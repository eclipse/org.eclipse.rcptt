/*******************************************************************************
 * Copyright (c) 2009, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.ecl.internal.debug.runtime;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.rcptt.ecl.core.BoxedValue;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.core.CommandStack;
import org.eclipse.rcptt.ecl.core.CorePackage;
import org.eclipse.rcptt.ecl.core.Declaration;
import org.eclipse.rcptt.ecl.core.Pipeline;
import org.eclipse.rcptt.ecl.core.Proc;
import org.eclipse.rcptt.ecl.core.ProcInstance;
import org.eclipse.rcptt.ecl.core.Sequence;
import org.eclipse.rcptt.ecl.core.Val;
import org.eclipse.rcptt.ecl.core.With;
import org.eclipse.rcptt.ecl.core.util.CommandToStringConverter;
import org.eclipse.rcptt.ecl.debug.commands.DebugCommand;
import org.eclipse.rcptt.ecl.debug.model.ModelFactory;
import org.eclipse.rcptt.ecl.debug.model.StackFrame;
import org.eclipse.rcptt.ecl.debug.model.Variable;
import org.eclipse.rcptt.ecl.debug.model.VariableKind;
import org.eclipse.rcptt.ecl.debug.runtime.IEclDebugExtension;
import org.eclipse.rcptt.ecl.gen.ast.AstExec;
import org.eclipse.rcptt.ecl.gen.ast.AstNode;
import org.eclipse.rcptt.ecl.internal.core.DeclarationContainer;
import org.eclipse.rcptt.ecl.runtime.BoxedValues;

public class EclStackSupport {
	private String id;
	private CommandToStringConverter converter = new CommandToStringConverter();
	private long varId = 0;

	public EclStackSupport(String id) {
		this.id = id;
	}

	private DebugCommand getRoot(CommandStack stack) {
		do {
			Command command = stack.getCommand();
			if (command instanceof DebugCommand) {
				return (DebugCommand) command;
			}
			stack = stack.getParent();
		} while (stack != null);
		return null;
	}

	public List<StackFrame> getFrames(CommandStack stack) {
		if (getSource(stack) == null) {
			// no source information for this command stack
			return null;
		}
		DebugCommand debug = getRoot(stack);
		if (debug == null || !id.equals(debug.getSession())) {
			// another session
			return null;
		}
		String path = debug.getPath();
		EMap<String, String> paths = debug.getPaths();
		List<StackFrame> frames = new ArrayList<StackFrame>();
		Command lastCommand = null;
		List<IEclDebugExtension> extensions = DebugExtensionManager.getInstance().getExtensions();
		int id = 0;
		do {
			Command command = stack.getCommand();
			if (command instanceof AstExec) {
				AstExec exec = (AstExec) command;
				String currentPath = getCurrentPath(path, paths, exec);
				StackFrame frame = ModelFactory.eINSTANCE.createStackFrame();
				frame.setFile(currentPath);
				frame.setCommand(exec.getName());
				frame.setLine(exec.getLine());
				frame.setColumn(exec.getColumn());
				frame.setLength(exec.getName().length());

				for (IEclDebugExtension ext : extensions) {
					ext.prepareFrame(stack, frame, this);
				}

				Set<String> variables = new HashSet<String>();

				Variable cmdVar = createCommandVariable(lastCommand);
				if (cmdVar != null) {
					cmdVar.setName(exec.getName());
					frame.getVariables().add(cmdVar);
					variables.add(cmdVar.getName());
				}

				// Add all variables
				CommandStack current = stack;
				boolean withSet = false;
				while (current != null) {
					DeclarationContainer declarations = current.getDeclarations();
					if (declarations != null) {
						for (Declaration d : declarations.declarations()) {
							if (d instanceof Val) {
								Val v = (Val) d;
								if (variables.add(v.getName())) {
									Variable var = createVariable(v.getValue());
									var.setKind(VariableKind.VARIABLE);
									var.setName(v.getName());
									processVariable(var, v.getValue());
									frame.getVariables().add(var);
								}
							}
						}
					}
					if (!withSet && current.getCommand() instanceof With) {
						EObject val = ((With) current.getCommand()).getObject();
						if (val != null) {
							Variable var = createVariable(val);
							var.setKind(VariableKind.REFERENCE);
							var.setName("with object");
							processVariable(var, val);
							frame.getVariables().add(var);
						}
						withSet = true;
					}
					if (current.getCommand() instanceof ProcInstance) {
						current = null;
					}
					else {
						current = current.getParent();
					}
				}
				for (IEclDebugExtension ext : extensions) {
					ext.updateFrame(stack, frame);
				}

				frame.setId(id);
				id++;
				frames.add(frame);
			} else {
				lastCommand = command;
			}
			stack = stack.getParent();
		} while (stack != null);
		return frames;
	}

	public void processVariable(Variable var, Object value) {
		if (value != null) {
			List<IEclDebugExtension> extensions = DebugExtensionManager.getInstance().getExtensions();
			for (IEclDebugExtension ext : extensions) {
				if (ext.supportVariableValue(value)) {
					ext.processVariable(var, value, true);
					return;
				}
			}
			if (value instanceof EObject) {
				var.setType(((EObject) value).eClass().getName());
			}
			else {
				var.setType(value.getClass().getName());
			}
			if (value instanceof BoxedValue) {
				var.setValue(EcoreUtil.copy((BoxedValue) value));
			}
			else if (!isComplexValue(value)) {
				var.setValue(BoxedValues.box(value.toString()));
			}
		}
	}

	private boolean isComplexValue(Object value) {
		if (value instanceof BoxedValue) {
			return false;
		}
		List<IEclDebugExtension> extensions = DebugExtensionManager.getInstance().getExtensions();
		for (IEclDebugExtension ext : extensions) {
			if (ext.supportVariableValue(value)) {
				return ext.isComplexVariableValue(value);
			}
		}
		return value instanceof EObject || value instanceof List;
	}

	public void processObjectValue(Variable var, Object value) {
		if (!isComplexValue(value)) {
			return;
		}

		List<IEclDebugExtension> extensions = DebugExtensionManager.getInstance().getExtensions();
		for (IEclDebugExtension ext : extensions) {
			if (ext.supportVariableValue(value)) {
				ext.processVariable(var, value, false);
				return;
			}
		}

		if (value instanceof EObject) {
			var.getChildren().clear();
			processEObject(var, value);
		}
		else if (value instanceof List) {
			var.getChildren().clear();
			List list = (List) value;
			int index = 0;
			var.setType(List.class.getName());
			for (Object object : list) {
				Variable childVar = createVariable(object);
				childVar.setKind(VariableKind.REFERENCE);
				childVar.setName("[" + Integer.toString(index) + "]");
				processVariable(childVar, object);
				var.getChildren().add(childVar);
				index++;
			}
		}
	}

	private void processEObject(Variable var, Object value) {
		EObject obj = (EObject) value;
		for (EStructuralFeature f : obj.eClass()
				.getEAllStructuralFeatures()) {
			if (!obj.eIsSet(f) || f == CorePackage.eINSTANCE.getCommand_Host()
					|| f == CorePackage.eINSTANCE.getCommand_Bindings()) {
				continue;
			}

			Object childValue = obj.eGet(f);

			if (isChildFiltered(childValue)) {
				continue;
			}

			Variable childVar = createVariable(childValue);
			childVar.setKind(VariableKind.FIELD);
			childVar.setType(f.getEType().toString());
			childVar.setName(f.getName());
			processVariable(childVar, childValue);

			var.getChildren().add(childVar);
		}
	}

	private boolean isChildFiltered(Object childValue) {
		if (childValue instanceof AstExec || childValue instanceof Pipeline || childValue instanceof Sequence
				|| childValue instanceof Proc) {
			return true;
		}
		List<IEclDebugExtension> extensions = DebugExtensionManager.getInstance().getExtensions();
		for (IEclDebugExtension ext : extensions) {
			if (ext.isVariableChildFiltered(childValue)) {
				return true;
			}
		}
		return false;
	}

	private String getCurrentPath(String path, EMap<String, String> paths, AstExec exec) {
		String currentPath = path;
		if (exec.getResourceID() != null && paths.containsKey(exec.getResourceID())) {
			currentPath = paths.get(exec.getResourceID());
		}
		return currentPath;
	}

	private Variable createCommandVariable(Command command) {
		Variable result = null;
		if (command == null) {
			return result;
		}
		Variable cmd = createVariable(command);
		cmd.setKind(VariableKind.COMMAND);
		cmd.setName(converter.convert(command));
		for (EStructuralFeature f : command.eClass()
				.getEAllStructuralFeatures()) {
			if (!command.eIsSet(f) || f == CorePackage.eINSTANCE.getCommand_Host()
					|| f == CorePackage.eINSTANCE.getCommand_Bindings()) {
				continue;
			}

			Object value = command.eGet(f);
			if (isChildFiltered(value)) {
				continue;
			}
			Variable var = createVariable(value);
			var.setKind(VariableKind.ARGUMENT);
			var.setType(f.getEType().toString());
			var.setName(f.getName());
			processVariable(var, value);

			cmd.getChildren().add(var);
		}
		return cmd;
	}

	public synchronized Variable createVariable(Object value) {
		Variable cmd = ModelFactory.eINSTANCE.createVariable();
		cmd.setId(this.id + varId);
		varId++;
		cmd.setComplex(isComplexValue(value));
		cmd.setObjectRef(value);
		return cmd;
	}

	private AstNode getSource(CommandStack stack) {
		stack = stack.getParent();
		if (stack != null) {
			Command command = stack.getCommand();
			if (command instanceof AstExec) {
				return (AstExec) command;
			}
		}
		return null;
	}

	public void resolveVariable(Variable var) {
		if (var.getObjectRef() != null) {
			processObjectValue(var, var.getObjectRef());
		}
	}

	public Variable createVar(String name, Object value, VariableKind kind) {
		Variable var = createVariable(value);
		var.setKind(kind);
		var.setName(name);
		processVariable(var, value);
		return var;
	}
}

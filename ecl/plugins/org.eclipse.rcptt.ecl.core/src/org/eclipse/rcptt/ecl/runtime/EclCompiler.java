/*******************************************************************************
 * Copyright (c) 2009, 2014 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.ecl.runtime;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.rcptt.ecl.core.Binding;
import org.eclipse.rcptt.ecl.core.Block;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.core.CoreFactory;
import org.eclipse.rcptt.ecl.core.CorePackage;
import org.eclipse.rcptt.ecl.core.Exec;
import org.eclipse.rcptt.ecl.core.ExecutableParameter;
import org.eclipse.rcptt.ecl.core.LiteralParameter;
import org.eclipse.rcptt.ecl.core.Parallel;
import org.eclipse.rcptt.ecl.core.Parameter;
import org.eclipse.rcptt.ecl.core.Pipeline;
import org.eclipse.rcptt.ecl.core.Sequence;
import org.eclipse.rcptt.ecl.core.util.EclCommandNameConvention;
import org.eclipse.rcptt.ecl.internal.core.CorePlugin;
import org.eclipse.rcptt.ecl.internal.core.ParamConverterManager;

public class EclCompiler {

	public static Command compile(Command command) throws CoreException {
		return compile(command, false);
	}

	public static Command compile(Command command, boolean hasInput)
			throws CoreException {
		if (command instanceof Exec) {
			Exec exec = (Exec) command;
			return compile(
					new FQName(null,
							EclCommandNameConvention.toScriptletName(exec
									.getName())), exec.getParameters(),
					hasInput, false);
		}
		if (command instanceof Block) {
			Block block = (Block) command;
			for (int i = 0; i < block.getCommands().size(); i++) {
				boolean innerHasInput = false;
				if (block instanceof Sequence)
					innerHasInput = hasInput;
				else if (block instanceof Pipeline)
					if (i == 0)
						innerHasInput = hasInput;
					else
						innerHasInput = true;
				else if (block instanceof Parallel)
					innerHasInput = hasInput;
				block.getCommands().set(i,
						compile(block.getCommands().get(i), innerHasInput));
			}
		}
		return command;
	}

	public static Command rawCompile(Exec exec, boolean hasInput)
			throws CoreException {
		return compile(
				new FQName(null, EclCommandNameConvention.toScriptletName(exec
						.getName())), exec.getParameters(), hasInput, true);
	}

	public static Command compile(FQName fqn, List<Parameter> params,
			boolean hasInput) throws CoreException {
		return compile(fqn, params, hasInput, false);
	}

	public static Command compile(FQName fqn, List<Parameter> params,
			boolean hasInput, boolean inDepth) throws CoreException {
		Command target = CoreUtils.createCommand(fqn.ns, fqn.name);
		EClass targetClass = target.eClass();

		List<EStructuralFeature> features = CoreUtils.getFeatures(targetClass);
		Map<String, EStructuralFeature> map = new HashMap<String, EStructuralFeature>();
		for (EStructuralFeature feature : features) {
			map.put(feature.getName(), feature);
			// FIXME handle name conflicts!!!!
		}

		int i = 0;
		boolean processUnnamed = canProcessUnnamed(targetClass);
		for (Parameter param : params) {
			if (param.eIsSet(CorePackage.eINSTANCE.getParameter_Name())) {
				processUnnamed = false;
			} else {
				if (!processUnnamed) {
					IStatus status = new Status(IStatus.ERROR,
							CorePlugin.PLUGIN_ID,
							"Unnamed parameters disallowed after named ones");
					throw new CoreException(status);
				}
			}
			EStructuralFeature feature = processUnnamed ? features.get(i++)
					: map.get(param.getName());

			if (feature == null) {
				IStatus status = new Status(IStatus.ERROR,
						CorePlugin.PLUGIN_ID, MessageFormat.format(
								"Invalid parameter name: {0}",
								new Object[] { param.getName() }));
				throw new CoreException(status);
			}
			if (processUnnamed
					&& feature.getEAnnotation(CoreUtils.INPUT_ANN) != null
					&& hasInput)
				feature = features.get(i++);
			if (feature.getEAnnotation(CoreUtils.INTERNAL_ANN) != null)
				feature = features.get(i++);

			evalFeatureValue(target, param, feature, hasInput, inDepth);
			// TODO support any upper bound
			if (feature.getUpperBound() == -1)
				i--;
		}
		return target;
	}

	private static boolean canProcessUnnamed(EClass targetClass)
			throws CoreException {
		boolean wasOptional = false;
		for (EStructuralFeature feature : targetClass.getEStructuralFeatures()) {
			int lower = feature.getLowerBound();
			int upper = feature.getUpperBound();
			checkBounds(lower, upper);
			if (lower == 0) {
				wasOptional = true;
			} else if (wasOptional) {
				return false;
			}
		}
		return true;
	}

	private static void checkBounds(int lower, int upper) throws CoreException {
		if (lower < 0) {
			IStatus status = new Status(IStatus.ERROR, CorePlugin.PLUGIN_ID,
					"Lower bounds is negative");
			throw new CoreException(status);
		}
		if (upper > 1) {
			// TODO correct message
			IStatus status = new Status(IStatus.ERROR, CorePlugin.PLUGIN_ID,
					"Upper bounds more than one is not supported yet");
			throw new CoreException(status);
		}
	}

	private static void evalFeatureValue(Command target, Parameter param,
			EStructuralFeature feature, boolean hasInput, boolean inDepth)
			throws CoreException {
		Object value = null;
		if (param instanceof LiteralParameter) {
			LiteralParameter literal = (LiteralParameter) param;
			Class<?> instanceClass = feature.getEType().getInstanceClass();
			List<String> allowedTypes = CoreUtils.getMetaTypeList(feature);
			try {
				if (feature.getEType() instanceof EEnum) {
					EEnum en = (EEnum) feature.getEType();
					EEnumLiteral eEnumLiteral = en.getEEnumLiteral(literal
							.getLiteral());
					if (eEnumLiteral == null) {
						IStatus status = new Status(IStatus.ERROR,
								CorePlugin.PLUGIN_ID, "Invalid constant: "
										+ literal.getLiteral());
						throw new CoreException(status);
					}
					value = eEnumLiteral.getInstance();
				}
				// Type to converter thought IParamConverter
				if (value == null) {
					IParamConverter<?> converter = ParamConverterManager
							.getInstance().getConverter(instanceClass);
					if (converter != null) {
						value = converter.convert(literal, allowedTypes);
						if (value instanceof Command && inDepth) {
							value = compile((Command) value, true);
						}
					}
				}
				// Type to converter thought EcoreUtil.createFromString
				if (value == null && feature.getEType() instanceof EDataType) {
					value = EcoreUtil.createFromString(
							(EDataType) feature.getEType(),
							literal.getLiteral());
				}
			} catch (Exception e) {
				// Exception while converting
				if (e instanceof CoreException) {
					throw (CoreException) e;
				}
				IStatus status = new Status(IStatus.ERROR,
						CorePlugin.PLUGIN_ID, "Parameter conversion failed: "
								+ e.getMessage(), e);
				throw new CoreException(status);
			}
			// If failed to convert emit error
			if (value == null) {
				IStatus status = new Status(IStatus.ERROR,
						CorePlugin.PLUGIN_ID, "Can't convert value "
								+ literal.getLiteral() + " to type "
								+ instanceClass.getSimpleName());
				throw new CoreException(status);
			}
			try {
				if (feature.getUpperBound() == 1) {
					target.eSet(feature, value);
				} else {
					@SuppressWarnings("unchecked")
					List<Object> list = (List<Object>) target.eGet(feature);
					list.add(value);
				}
			} catch (ClassCastException cce) {
				IStatus status = new Status(IStatus.ERROR,
						CorePlugin.PLUGIN_ID, "Can't assign value " + value
								+ " to attribute " + feature.getName(), cce);
				throw new CoreException(status);
			}
		} else if (param instanceof ExecutableParameter) {
			Binding binding = CoreFactory.eINSTANCE.createBinding();
			binding.setFeature(feature);
			ExecutableParameter execParam = (ExecutableParameter) param;
			binding.setCommand(compile(execParam.getCommand(), hasInput));
			target.getBindings().add(binding);
		} else {
			throw new RuntimeException("Invalid parameter");
		}
	}
}

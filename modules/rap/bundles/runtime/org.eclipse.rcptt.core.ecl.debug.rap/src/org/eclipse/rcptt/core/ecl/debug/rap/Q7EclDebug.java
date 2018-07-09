/*******************************************************************************
 * Copyright (c) 2009, 2016 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.core.ecl.debug.rap;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.rcptt.ecl.core.CommandStack;
import org.eclipse.rcptt.ecl.debug.model.StackFrame;
import org.eclipse.rcptt.ecl.debug.model.Variable;
import org.eclipse.rcptt.ecl.debug.model.VariableKind;
import org.eclipse.rcptt.ecl.debug.runtime.IEclDebugExtension;
import org.eclipse.rcptt.ecl.internal.debug.runtime.EclStackSupport;
import org.eclipse.ui.PlatformUI;

import org.eclipse.rcptt.tesla.core.protocol.raw.Element;
import org.eclipse.rcptt.tesla.core.ui.Widget;
import org.eclipse.rcptt.tesla.ecl.impl.rap.TeslaBridge;
import org.eclipse.rcptt.tesla.ecl.model.ControlHandler;
import org.eclipse.rcptt.tesla.internal.core.processing.ITeslaCommandProcessor;
import org.eclipse.rcptt.tesla.internal.ui.player.SWTUIElement;
import org.eclipse.rcptt.tesla.internal.ui.processors.IModelMapperHelper;
import org.eclipse.rcptt.tesla.internal.ui.processors.SWTUIProcessor;

public class Q7EclDebug implements IEclDebugExtension {

	private EclStackSupport eclStackSupport;

	public Q7EclDebug() {
	}

	@Override
	public void updateFrame(CommandStack stack, StackFrame frame) {
	}

	@Override
	public boolean supportVariableValue(Object value) {
		if (value instanceof ControlHandler) {
			return true;
		}
		return false;
	}

	@Override
	public void processVariable(final Variable var, Object value, boolean prepare) {
		if (value instanceof ControlHandler) {
			ControlHandler handler = (ControlHandler) value;
			var.setType("RCPTT Widget Reference");
			var.setObjectRef(value);
			if (!prepare) {
				// fill children
				var.getChildren().clear();
				var.getChildren().add(eclStackSupport.createVar("kind", handler.getKind().name(), VariableKind.FIELD));
				if (handler.getParent() != null) {
					var.getChildren()
							.add(eclStackSupport.createVar("parent", handler.getParent(), VariableKind.REFERENCE));
				}
				if (handler.getCustomKindId() != null) {
					var.getChildren().add(
							eclStackSupport.createVar("customKind", handler.getCustomKindId(), VariableKind.FIELD));
				}
				if (handler.getColumn() != null) {
					var.getChildren()
							.add(eclStackSupport.createVar("column", handler.getColumn(), VariableKind.FIELD));
				}
				if (handler.getResolved() != null) {
					var.getChildren().add(eclStackSupport.createVar("isResolved", true, VariableKind.FIELD));
					final Element element = handler.getResolved();
					final List<IModelMapperHelper> helpers = TeslaBridge.getClient().getProcessors(
							IModelMapperHelper.class);
					if (!helpers.isEmpty()) {
						PlatformUI.getWorkbench().getDisplay().syncExec(new Runnable() {
							@Override
							public void run() {
								for (IModelMapperHelper helper : helpers) {
									EObject value = helper.getElementModel(element);
									if (value != null) {
										var.getChildren().add(
												eclStackSupport.createVar("widget", value, VariableKind.REFERENCE));
									}
								}
							}
						});
					}
				}
				else {
					var.getChildren().add(eclStackSupport.createVar("isResolved", false, VariableKind.FIELD));
				}

			}
		}
	}

	@Override
	public boolean isComplexVariableValue(Object value) {
		if (value instanceof ControlHandler) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isVariableChildFiltered(Object childValue) {
		return false;
	}

	@Override
	public void prepareFrame(CommandStack stack, StackFrame frame, EclStackSupport eclStackSupport) {
		this.eclStackSupport = eclStackSupport;
	}
}

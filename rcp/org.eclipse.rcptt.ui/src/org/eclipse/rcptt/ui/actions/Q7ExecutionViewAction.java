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
package org.eclipse.rcptt.ui.actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ISelectionProvider;

import org.eclipse.rcptt.core.model.ModelException;
import org.eclipse.rcptt.internal.core.RcpttPlugin;
import org.eclipse.rcptt.internal.launching.PrepareExecutionWrapper;
import org.eclipse.rcptt.launching.IExecutable;
import org.eclipse.rcptt.launching.IExecutionSession;
import org.eclipse.rcptt.ui.utils.Executables;

public abstract class Q7ExecutionViewAction extends Action {

	protected ISelectionProvider selectionProvider;
	protected Executables executables;

	public Q7ExecutionViewAction() {
		super();
	}

	public Q7ExecutionViewAction(String text) {
		super(text);
	}

	public Q7ExecutionViewAction(String text, ImageDescriptor image) {
		super(text, image);
	}

	public Q7ExecutionViewAction(String text, int style) {
		super(text, style);
	}

	public void updateEnablement(IExecutionSession session) {
		setEnabled(session != null && !session.isRunning()
				&& !selectionProvider.getSelection().isEmpty());
	}

	public void inputChanged(Executables executables) {
		this.executables = executables;
	}

	protected void updateVariant(Map<String, List<List<String>>> variants,
			IExecutable executable) {
		if (executable instanceof PrepareExecutionWrapper) {
			List<String> varName = ((PrepareExecutionWrapper) executable)
					.getVariantName();
			if (varName != null) {
				try {
					String id = executable.getActualElement().getID();
					List<List<String>> list = variants.get(id);
					if (list == null) {
						list = new ArrayList<List<String>>();
						variants.put(id, list);
					}
					list.add(varName);
				} catch (ModelException e) {
					RcpttPlugin.log(e);
				}
			}
		}
	}

}
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
package org.eclipse.rcptt.ctx.workbench.ui.views;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.viewers.BaseLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.views.IViewRegistry;

import org.eclipse.rcptt.core.model.IQ7Element.HandleType;
import org.eclipse.rcptt.core.scenario.ScenarioPackage;
import org.eclipse.rcptt.core.scenario.WorkbenchContext;
import org.eclipse.rcptt.internal.ui.Q7UIPlugin;
import org.eclipse.rcptt.ui.commons.ArrayTransfer;
import org.eclipse.rcptt.ui.commons.EObjectTable;

public class ViewsTable extends EObjectTable {

	public ViewsTable(WorkbenchContext context) {
		super(context, ScenarioPackage.Literals.WORKBENCH_CONTEXT__VIEWS);
	}

	public String getName() {
		return "Views";
	}

	public Image getImage() {
		return null;
	}

	@Override
	protected ILabelProvider createLabelProvider() {
		return new ViewsLabelProvider();
	}

	private class ViewsLabelProvider extends BaseLabelProvider implements
			ILabelProvider {

		public Image getImage(Object element) {
			return null;
		}

		public String getText(Object element) {
			return element.toString();
		}
	}

	@Override
	protected Object[] handleAdd() {
		try {
			SelectViewDialog dialog = new SelectViewDialog(viewer.getControl()
					.getShell());
			if (dialog.open() == SelectEditorFileDialog.OK) {
				return new String[] { dialog.getView() };
			}
		} catch (CoreException e) {
			if (e.getStatus().getSeverity() != Status.CANCEL) {
				Q7UIPlugin.log(e);
			}
		}
		return null;
	}

	@Override
	protected boolean canAdd(Object[] objects) {
		if (!super.canAdd(objects)) {
			return false;
		}
		IViewRegistry viewRegistry = PlatformUI.getWorkbench()
				.getViewRegistry();
		for (Object obj : objects) {
			if (null == viewRegistry.find((String) obj)) {
				return false;
			}
		}
		return true;
	}

	private class ViewsTransfer extends ArrayTransfer {
		private final String TYPE_NAME = "String[]";
		private final int TYPE_ID = registerType(TYPE_NAME);

		@Override
		protected int[] getTypeIds() {
			return new int[] { TYPE_ID };
		}

		@Override
		protected String[] getTypeNames() {
			return new String[] { TYPE_NAME };
		}
	}

	private static ViewsTransfer TRANSFER = null;

	@Override
	protected Class<?> getContentsType() {
		return String.class;
	}

	@Override
	protected Transfer getContentTransfer() {
		if (null == TRANSFER) {
			TRANSFER = new ViewsTransfer();
		}
		return TRANSFER;
	}

	@Override
	protected HandleType getAppropriateHandleType() {
		return null;
	}
}

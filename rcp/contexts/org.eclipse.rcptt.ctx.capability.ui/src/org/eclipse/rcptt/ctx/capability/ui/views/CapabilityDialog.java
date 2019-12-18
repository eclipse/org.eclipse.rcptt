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
package org.eclipse.rcptt.ctx.capability.ui.views;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.rcptt.core.scenario.CapabilityContext;
import org.eclipse.rcptt.core.scenario.CapabilityContextItem;
import org.eclipse.rcptt.ctx.capability.CapabilityManager;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ListSelectionDialog;

public class CapabilityDialog extends ListSelectionDialog {

	private static final LabelProvider LABEL_PROVIDER = new LabelProvider();
	private final CapabilityContextItem current;

	public CapabilityDialog(Shell shell, CapabilityContext context, CapabilityContextItem current) {
		super(shell, context, new ContentProvider(context, current), LABEL_PROVIDER, Messages.CapabilityDialog_Message);
		this.current = current;
		this.setTitle(Messages.CapabilityDialog_Title);
	}

	public CapabilityDialog(Shell shell, CapabilityContext context) {
		this(shell, context, null);
	}

	@Override
	protected List<?> getInitialElementSelections() {
		return current != null ? current.getCapability() : Collections.emptyList();
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		final Control area = super.createDialogArea(parent);

		return area;
	}

	@Override
	protected Control createContents(Composite parent) {
		final Control control = super.createContents(parent);
		getViewer().addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				updatesButtonState();
			}
		});
		updatesButtonState();
		return control;
	}

	@Override
	public String[] getResult() {
		final Object[] result = super.getResult();
		return Arrays.copyOf(result, result.length, String[].class);
	}

	private void updatesButtonState() {
		getButton(IDialogConstants.OK_ID).setEnabled(getViewer().getCheckedElements().length > 0);
	}

	private static class ContentProvider implements IStructuredContentProvider {

		private final CapabilityContextItem current;
		private final CapabilityContext context;

		public ContentProvider(CapabilityContext context, CapabilityContextItem item) {
			this.context = context;
			this.current = item;
		}

		@Override
		public Object[] getElements(Object input) {
			return CapabilityManager.getManager().getAvaliableCapabiltiies(context, current);
		}
	}
}

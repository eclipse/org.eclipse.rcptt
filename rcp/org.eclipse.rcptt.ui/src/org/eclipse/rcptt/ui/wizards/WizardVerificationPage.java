/*******************************************************************************
 * Copyright (c) 2009, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.ui.wizards;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

import org.eclipse.rcptt.core.VerificationType;
import org.eclipse.rcptt.core.VerificationTypeManager;
import org.eclipse.rcptt.core.model.IContext;
import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.model.search.Q7SearchCore;
import org.eclipse.rcptt.core.workspace.RcpttCore;
import org.eclipse.rcptt.internal.core.model.ReferencedProjectScope;
import org.eclipse.rcptt.internal.ui.Messages;
import org.eclipse.rcptt.ui.utils.ImageManager;
import org.eclipse.rcptt.ui.verification.VerificationUIManager;

public class WizardVerificationPage extends WizardExecutablePage {

	private ImageManager imageManager = new ImageManager();

	private VerificationType type;
	private String name;
	private boolean takeSnapshot = false;

	private final VerificationType targetType;

	private final String widgetClass;

	public WizardVerificationPage(IStructuredSelection selection,
			VerificationType targetType, String widgetClass) {
		super("Verification", Messages.WizardVerificationPage_Title, selection); //$NON-NLS-1$
		this.targetType = targetType;
		this.widgetClass = widgetClass;
	}

	public boolean takeSnapshot() {
		return takeSnapshot;
	}

	public void setTakeSnapshot(boolean takeSnapshot) {
		this.takeSnapshot = takeSnapshot;
	}

	@Override
	protected void createContent(Composite parent) {
		Label label = new Label(parent, SWT.LEFT);
		label.setText(Messages.WizardVerificationPage_NameLabel);
		final Text text = new Text(parent, SWT.BORDER);
		text.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				name = text.getText();
				validate();
			}
		});
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.CENTER).grab(true, false)
				.span(2, 1).applyTo(text);

		final Table table = new Table(parent, SWT.BORDER);
		GridDataFactory.fillDefaults().grab(true, true).span(3, 2).applyTo(table);
		VerificationType[] types = VerificationTypeManager.getInstance().getTypes();
		for (VerificationType type : types) {
			if (takeSnapshot && !type.canCreate())
				continue;
			if (!type.canMake())
				continue;
			if (widgetClass != null && !type.supportsWidget(widgetClass))
				continue;

			TableItem item = new TableItem(table, SWT.NONE);
			item.setText(type.getName());
			item.setData(type);
			ImageDescriptor descriptor = VerificationUIManager.getInstance()
					.getIcon(type);
			if (descriptor != null) {
				item.setImage(imageManager.getImage(descriptor));
			}
		}

		for (TableItem i : table.getItems())
			if (i.getData() == targetType) {
				table.setSelection(i);
				type = targetType;
			}

		table.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				TableItem[] items = table.getSelection();
				if (items.length > 0) {
					type = (VerificationType) items[0].getData();
				} else {
					type = null;
				}
				validate();
			}
		});

		// --

		// Set initial selection on first context type
		if (targetType == null && table.getItemCount() > 0) {
			table.select(0);
			type = (VerificationType) table.getItem(0).getData();
		}

		// Set initial focus on text field
		text.setFocus();
	}

	@Override
	protected boolean doValidate() {
		if (super.doValidate()) {
			if (type == null) {
				setErrorMessage(Messages.WizardVerificationPage_NoTypeSelectedMsg);
				return false;
			}
			if (name == null || !Path.EMPTY.isValidSegment(name)) {
				setErrorMessage(Messages.WizardVerificationPage_EmptyNameMsg);
				return false;
			}
			IQ7NamedElement[] elements = Q7SearchCore.findByName(name,
					new ReferencedProjectScope(RcpttCore.create(getProject())),
					new NullProgressMonitor());
			for (IQ7NamedElement iq7NamedElement : elements) {
				if (iq7NamedElement instanceof IContext) {
					setErrorMessage(Messages.WizardVerificationPage_DuplicateMsg);
					return false;
				}
			}
			return true;
		}
		return false;
	}

	public String getVerificationName() {
		return name;
	}

	@Override
	protected String getDefaultMessage() {
		return type.getDescription();
	}

	public VerificationType getVerificationType() {
		return type;
	}

	@Override
	public void dispose() {
		super.dispose();
		if (imageManager != null) {
			imageManager.dispose();
			imageManager = null;
		}
	}

}

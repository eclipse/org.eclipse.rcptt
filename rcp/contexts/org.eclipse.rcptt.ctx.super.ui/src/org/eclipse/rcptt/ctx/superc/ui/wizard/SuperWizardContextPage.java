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
package org.eclipse.rcptt.ctx.superc.ui.wizard;

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

import org.eclipse.rcptt.core.ContextType;
import org.eclipse.rcptt.core.ContextTypeManager;
import org.eclipse.rcptt.core.model.IContext;
import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.model.search.Q7SearchCore;
import org.eclipse.rcptt.core.workspace.RcpttCore;
import org.eclipse.rcptt.internal.core.model.ReferencedProjectScope;
import org.eclipse.rcptt.internal.ui.Messages;
import org.eclipse.rcptt.ui.context.ContextUIManager;
import org.eclipse.rcptt.ui.utils.ImageManager;
import org.eclipse.rcptt.ui.wizards.WizardExecutablePage;

public class SuperWizardContextPage extends WizardExecutablePage {

	private ImageManager imageManager = new ImageManager();

	private ContextType type;
	private String name;

	public SuperWizardContextPage(IStructuredSelection selection) {
		super("Context", Messages.WizardContextPage_Title, selection); //$NON-NLS-1$
	}

	@Override
	protected void createContent(Composite parent) {
		Label label = new Label(parent, SWT.LEFT);
		label.setText(Messages.WizardContextPage_NameLabel);
		final Text text = new Text(parent, SWT.BORDER);
		text.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				name = text.getText();
				validate();
			}
		});
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.CENTER)
				.grab(true, false).span(2, 1).applyTo(text);

		// Label typeLabel = new Label(parent, SWT.LEFT);
		// typeLabel.setText("Type:");

		final Table table = new Table(parent, SWT.BORDER);
		GridDataFactory.fillDefaults().grab(true, true).span(3, 2)
				.applyTo(table);
		ContextType[] types = ContextTypeManager.getInstance().getTypes();
		for (ContextType type : types) {
			if (!type.canMake()) {
				continue;
			}
			TableItem item = new TableItem(table, SWT.NONE);
			item.setText(type.getName());
			item.setData(type);
			ImageDescriptor descriptor = ContextUIManager.getInstance()
					.getIcon(type);
			if (descriptor != null) {
				item.setImage(imageManager.getImage(descriptor));
			}
		}
		table.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				TableItem[] items = table.getSelection();
				if (items.length > 0) {
					type = (ContextType) items[0].getData();
				} else {
					type = null;
				}
				validate();
			}
		});

		// Set initial selection on first context type
		if (table.getItemCount() > 0) {
			table.select(0);
			type = (ContextType) table.getItem(0).getData();
		}

		// Set initial focus on text field
		text.setFocus();
	}

	@Override
	protected boolean doValidate() {
		if (super.doValidate()) {
			if (type == null) {
				setErrorMessage(Messages.WizardContextPage_NoTypeSelectedMsg);
				return false;
			}
			if (name == null || !Path.EMPTY.isValidSegment(name)) {
				setErrorMessage(Messages.WizardContextPage_EmptyNameMsg);
				return false;
			}
			IQ7NamedElement[] elements = Q7SearchCore.findByName(name,
					new ReferencedProjectScope(RcpttCore.create(getProject())),
					new NullProgressMonitor());
			for (IQ7NamedElement iq7NamedElement : elements) {
				if (iq7NamedElement instanceof IContext) {
					setErrorMessage(Messages.WizardContextPage_DuplicateContextMsg);
					return false;
				}
			}
			return true;
		}
		return false;
	}

	public String getContextName() {
		return name;
	}

	@Override
	protected String getDefaultMessage() {
		return type.getDescription();
	}

	public ContextType getContextType() {
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

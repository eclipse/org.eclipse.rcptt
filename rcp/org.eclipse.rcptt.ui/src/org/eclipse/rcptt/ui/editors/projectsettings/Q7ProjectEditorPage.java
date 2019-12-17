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
package org.eclipse.rcptt.ui.editors.projectsettings;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.rcptt.core.model.IQ7ProjectMetadata;
import org.eclipse.rcptt.core.model.ModelException;
import org.eclipse.rcptt.core.scenario.ProjectMetadata;
import org.eclipse.rcptt.internal.ui.HookUtils;
import org.eclipse.rcptt.internal.ui.Images;
import org.eclipse.rcptt.internal.ui.Q7UIPlugin;
import org.eclipse.rcptt.ui.controls.ContextsTable;
import org.eclipse.rcptt.ui.controls.DescriptionComposite;
import org.eclipse.rcptt.ui.controls.SectionWithToolbar;
import org.eclipse.rcptt.ui.controls.VerificationsTable;
import org.eclipse.rcptt.ui.editors.IQ7NamedElementEditorPage;
import org.eclipse.rcptt.ui.editors.NamedElementEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;

public class Q7ProjectEditorPage extends FormPage implements
		IQ7NamedElementEditorPage {

	private ContextsTable contextTable;
	private Section contextSection;
	private DescriptionComposite descriptionComposite;
	private Section descriptionSection;
	private VerificationsTable verificationsTable;
	private Section verificationSection;

	public Q7ProjectEditorPage(NamedElementEditor editor) {
		super(editor, "metadata", "RCPTT Project Description"); //$NON-NLS-1$
	}

	public ContextsTable getContextTable() {
		return contextTable;
	}

	public VerificationsTable getVerificationsTable() {
		return verificationsTable;
	}

	public DescriptionComposite getDescriptionComposite() {
		return descriptionComposite;
	}

	@Override
	protected void createFormContent(IManagedForm managedForm) {
		ScrolledForm form = managedForm.getForm();
		form.setText("Project Settings");
		form.setImage(Images.getImage(Images.Q7_META));

		FormToolkit toolkit = managedForm.getToolkit();

		Composite parent = form.getBody();
		GridLayoutFactory.swtDefaults().equalWidth(true).applyTo(parent);

		descriptionComposite = new DescriptionComposite(getElement()) {
			@Override
			public void createControl(Composite parent) {
				super.createControl(parent);
			}
		};
		descriptionSection = new SectionWithToolbar(descriptionComposite,
				Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED).create(
				parent, toolkit);

		try {
			contextTable = new ContextsTable(getModel()) {
				@Override
				public String getName() {
					return "Default Contexts";
				}
			};
		} catch (ModelException e) {
			Q7UIPlugin.log(e);
		}
		contextSection = new SectionWithToolbar(contextTable, Section.TITLE_BAR
				| Section.TWISTIE | Section.EXPANDED).create(parent, toolkit);

		GridDataFactory.fillDefaults().hint(SWT.DEFAULT, 300).grab(true, true)
				.applyTo(contextSection);
		GridDataFactory.fillDefaults().hint(SWT.DEFAULT, 300).grab(true, true)
				.applyTo(descriptionSection);

		try {
			verificationsTable = new VerificationsTable(getModel()) {
				@Override
				public String getName() {
					return "Default Verifications";
				}
			};
		} catch (ModelException e) {
			Q7UIPlugin.log(e);
		}
		verificationSection = new SectionWithToolbar(verificationsTable,
				Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED).
				create(parent, toolkit);

		GridDataFactory.fillDefaults().hint(SWT.DEFAULT, 300).grab(true, true)
				.applyTo(verificationSection);
		GridDataFactory.fillDefaults().hint(SWT.DEFAULT, 300).grab(true, true)
				.applyTo(contextSection);
		GridDataFactory.fillDefaults().hint(SWT.DEFAULT, 300).grab(true, true)
				.applyTo(descriptionSection);
		
		getEditor().createActions();

	}

	@Override
	public NamedElementEditor getEditor() {
		return (NamedElementEditor) super.getEditor();
	}

	public IQ7ProjectMetadata getModel() {
		return (IQ7ProjectMetadata) getEditor().getModel();
	}

	public ProjectMetadata getElement() {
		return (ProjectMetadata) getEditor().getElement();
	}

	public void elementChangedEvent() {
	}

	public void updateContent() {
	}

	public void refreshPage() {
	}

	@Override
	public void createPartControl(Composite parent) {
		super.createPartControl(parent);
		Runnable r = new Runnable() {
			public void run() {
				((Q7ProjectEditor) getEditor()).updateEnablement();
				((NamedElementEditor) getEditor()).activateActions();
			}
		};
		HookUtils.textHook(parent, r, new FocusListener() {
			public void focusGained(FocusEvent e) {
				((NamedElementEditor) getEditor()).updateEnablement();
				((NamedElementEditor) getEditor()).activateActions();
			}

			public void focusLost(FocusEvent e) {
				((NamedElementEditor) getEditor()).deactivateActions();
			}
		});
		((Q7ProjectEditor) getEditor()).updateEnablement();
	}
}

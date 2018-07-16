/*******************************************************************************
 * Copyright (c) 2009, 2014, 2018 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.ui.controls;

import org.eclipse.core.databinding.Binding;
import org.eclipse.core.databinding.observable.ChangeEvent;
import org.eclipse.core.databinding.observable.IChangeListener;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocumentListener;
import org.eclipse.jface.text.TextViewer;
import org.eclipse.jface.text.TextViewerUndoManager;
import org.eclipse.rcptt.core.scenario.NamedElement;
import org.eclipse.rcptt.core.scenario.ScenarioPackage;
import org.eclipse.rcptt.internal.ui.Images;
import org.eclipse.rcptt.internal.ui.Messages;
import org.eclipse.rcptt.ui.editors.NamedElementEditorActions.INamedElementActions;
import org.eclipse.rcptt.ui.editors.TextViewerActions;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

public class DescriptionComposite extends AbstractEmbeddedComposite {

	private NamedElement element;
	private Composite control;
	private TextViewer descriptionControl;
	private Binding descriptionBinding;
	private INamedElementActions actions;

	@Override
	protected void fillActions(IToolBarManager manager) {
		IAction clearAction = new Action() {
			@Override
			public void run() {
				descriptionControl.getDocument().set(""); //$NON-NLS-1$
				descriptionControl.getControl().setFocus();
			}
		};
		clearAction.setImageDescriptor(Images.getImageDescriptor(Images.PANEL_CLEAR));
		clearAction.setToolTipText(Messages.DescriptionComposite_ClearToolTip);
		manager.add(clearAction);
	}

	public DescriptionComposite(NamedElement element) {
		this.element = element;
	}

	public String getName() {
		return Messages.DescriptionComposite_Name;
	}

	public Image getImage() {
		return Images.getImage(Images.FILE);
	}

	public void createControl(Composite parent) {
		super.createControl(parent);

		control = new Composite(parent, SWT.NONE);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(control);
		GridLayoutFactory.fillDefaults().numColumns(1).equalWidth(true).applyTo(control);

		descriptionControl = new TextViewer(control, SWT.MULTI | SWT.WRAP | SWT.V_SCROLL | SWT.H_SCROLL | SWT.BORDER);

		actions = new TextViewerActions(descriptionControl);
		// descriptionControl = new StyledText(control, SWT.MULTI | SWT.WRAP
		// | SWT.V_SCROLL | SWT.H_SCROLL | SWT.BORDER);
		GridDataFactory.fillDefaults().grab(true, true).hint(100, 50).applyTo(descriptionControl.getControl());
		update(element);
	}

	public Control getControl() {
		return control;
	}

	public void update(NamedElement element) {
		this.element = element;
		if (descriptionBinding != null) {
			descriptionBinding.dispose();
		}
		// descriptionBinding = dbc.bindValue(SWTObservables.observeText(
		// descriptionControl.getControl(), SWT.Modify), EMFProperties
		// .value(ScenarioPackage.Literals.NAMED_ELEMENT__DESCRIPTION)
		// .observe(element));

		descriptionControl.getDocument().addDocumentListener(new IDocumentListener() {
			public void documentChanged(DocumentEvent event) {
				String value = descriptionControl.getDocument().get();
				if (value != null && value.trim().length() == 0) {
					value = null;
				}
				String curDescr = DescriptionComposite.this.element.getDescription();
				if (value == null && curDescr != null) {
					DescriptionComposite.this.element.setDescription(value);
				} else {
					if (value != curDescr && !value.equals(curDescr)) {
						DescriptionComposite.this.element.setDescription(value);
					}
				}
			}

			public void documentAboutToBeChanged(DocumentEvent event) {
				// Do nothing
			}
		});

		IChangeListener scenarioContentListener = new IChangeListener() {
			public void handleChange(ChangeEvent event) {
				if (descriptionControl.getDocument() != null) {
					String doc = descriptionControl.getDocument().get();
					String descr = DescriptionComposite.this.element.getDescription();
					if (!doc.equals(descr)) {
						descriptionControl.getDocument().set(descr);
					}
				}
			}
		};
		IObservableValue scriptContent = EMFObservables.observeValue(element,
				ScenarioPackage.Literals.SCENARIO__CONTENT);
		scriptContent.addChangeListener(scenarioContentListener);

		// Set initial value
		if (descriptionControl.getDocument() != null) {
			String doc = descriptionControl.getDocument().get();
			String descr = DescriptionComposite.this.element.getDescription();
			if (!doc.equals(descr) && descr != null) {
				descriptionControl.getDocument().set(descr);
			}
		}

		descriptionControl.getUndoManager().reset();
	}

	public TextViewer getDescriptionViewer() {
		return descriptionControl;
	}

	public StyledText getDescriptionControl() {
		return getDescriptionViewer().getTextWidget();
	}

	public INamedElementActions getActions() {
		return actions;
	}
}

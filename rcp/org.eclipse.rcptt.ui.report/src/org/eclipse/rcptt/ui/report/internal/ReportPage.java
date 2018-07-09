/*******************************************************************************
 * Copyright (c) 2009, 2015 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.ui.report.internal;

import java.util.List;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Node;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Report;
import org.eclipse.rcptt.ui.controls.SectionWithToolbar;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.IFormColors;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.internal.forms.widgets.FormImages;

@SuppressWarnings("restriction")
public class ReportPage extends FormPage {
	DataBindingContext dbc = new DataBindingContext();
	private Label nameLabel;
	private Text nameText;
	private Report report;

	public ReportPage(FormEditor editor, String id, String title, Report report) {
		super(editor, id, title);
		this.report = report;

	}

	@Override
	protected void createFormContent(IManagedForm managedForm) {
		ScrolledForm form = managedForm.getForm();
		FormToolkit toolkit = managedForm.getToolkit();

		Composite parent = form.getBody();
		GridLayoutFactory.fillDefaults().margins(0, 0).spacing(0, 0)
				.equalWidth(true).applyTo(parent);

		createGeneralContent(parent, toolkit);

		Composite composite = toolkit.createComposite(parent);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(composite);
		GridLayoutFactory.fillDefaults().margins(5, 5).spacing(0, 0)
				.equalWidth(false).applyTo(composite);

		SashForm composite2 = new SashForm(composite, SWT.HORIZONTAL
				| SWT.SMOOTH);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(composite2);
		GridLayoutFactory.fillDefaults().numColumns(2).margins(5, 5)
				.spacing(0, 0).equalWidth(true).applyTo(composite2);

		final ReportDetailsComposite detailsComposite = new ReportDetailsComposite(
				report);
		new SectionWithToolbar(new TestCaseComposite(report) {
			@Override
			protected void doNodesSelection(List<Node> nodes) {
				detailsComposite.update(report, nodes);
			}
		}, Section.TITLE_BAR).create(composite2, toolkit);

		new SectionWithToolbar(detailsComposite, Section.TITLE_BAR).create(
				composite2, toolkit);
		composite2.setWeights(new int[] { 40, 60 });
	}

	protected Composite createGeneralContent(Composite parent,
			FormToolkit toolkit) {
		Composite composite = toolkit.createComposite(parent);

		GridLayoutFactory.swtDefaults().numColumns(4).applyTo(composite);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.TOP)
				.grab(true, false).applyTo(composite);

		createNameControl(composite, toolkit);
		// createSaveButton(composite, toolkit);
		// createTagControl(composite, toolkit);
		// createReplayButton(composite, toolkit);

		int height = composite.computeSize(SWT.DEFAULT, SWT.DEFAULT).y;

		Color top = toolkit.getColors().getColor(IFormColors.H_GRADIENT_END);
		Color bot = toolkit.getColors().getColor(IFormColors.H_GRADIENT_START);

		Image gradientImage = FormImages.getInstance().getGradient(
				new Color[] { top, bot }, new int[] { 100 }, height, true,
				toolkit.getColors().getColor(IFormColors.TB_BG),
				composite.getDisplay());
		// No need to dispose the gradient image cause it's created and stored
		// in resource manager
		composite.setBackgroundImage(gradientImage);

		Composite c1 = toolkit.createComposite(parent);
		GridDataFactory.fillDefaults().hint(SWT.DEFAULT, 1).span(4, 1)
				.grab(true, false).applyTo(c1);
		c1.setBackground(toolkit.getColors().getColor(
				IFormColors.H_BOTTOM_KEYLINE1));

		Composite c2 = toolkit.createComposite(parent);
		GridDataFactory.fillDefaults().hint(SWT.DEFAULT, 1).span(4, 1)
				.grab(true, false).applyTo(c2);
		c2.setBackground(toolkit.getColors().getColor(
				IFormColors.H_BOTTOM_KEYLINE2));

		if (!Platform.getOS().equals(Platform.OS_MACOSX)) {
			// We need to simulate transparent background for labels
			composite.layout();
			setBackgroundToHeaderLabel(nameLabel, gradientImage);
			// setBackgroundToHeaderLabel(tagsLabel, gradientImage);
		}

		return composite;
	}

	protected void setBackgroundToHeaderLabel(Label label, Image backgroundImage) {
		Rectangle bounds = label.getBounds();
		bounds.x = 0;
		bounds.width = 1;
		final Image image = new Image(label.getDisplay(), bounds);
		GC gc = new GC(image);
		gc.drawImage(backgroundImage, bounds.x, bounds.y, bounds.width,
				bounds.height, 0, 0, bounds.width, bounds.height);
		gc.dispose();
		label.setBackgroundImage(image);
		label.addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				image.dispose();
			}
		});
	}

	protected void createNameControl(Composite parent, FormToolkit toolkit) {
		nameLabel = createLabel(parent, toolkit, "Name:");
		nameText = createWrappedText(parent, toolkit, report.getRoot()
				.getName(), 2);
		nameText.setEditable(false);
		nameText.setBackground(null);
	}

	protected Label createLabel(Composite parent, FormToolkit toolkit,
			final String label) {
		Label labelControl = new Label(parent, SWT.NONE);
		labelControl.setText(label);
		labelControl.setForeground(toolkit.getColors().getColor(
				IFormColors.TITLE));
		GridDataFactory.swtDefaults().align(SWT.BEGINNING, SWT.CENTER)
				.applyTo(labelControl);
		labelControl.setBackground(null);
		return labelControl;
	}

	protected Text createWrappedText(Composite parent, FormToolkit toolkit,
			String text, int hSpan) {
		Composite composite = toolkit.createComposite(parent);
		GridLayoutFactory.fillDefaults().equalWidth(true).applyTo(composite);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.CENTER)
				.span(hSpan, 1).grab(true, false).applyTo(composite);
		Text textControl = toolkit.createText(composite, text, SWT.BORDER
				/* | SWT.WRAP | SWT.MULTI */);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL)
				.grab(true, true).hint(111, SWT.DEFAULT).applyTo(textControl);
		textControl.setBackground(null);
		return textControl;
	}

}

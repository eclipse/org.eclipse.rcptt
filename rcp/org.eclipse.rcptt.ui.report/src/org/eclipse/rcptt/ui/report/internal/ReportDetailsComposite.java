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
package org.eclipse.rcptt.ui.report.internal;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.rcptt.internal.ui.Images;
import org.eclipse.rcptt.reporting.core.ImageEntry;
import org.eclipse.rcptt.reporting.util.RcpttReportGenerator;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Node;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Report;
import org.eclipse.rcptt.ui.controls.AbstractEmbeddedComposite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;

public class ReportDetailsComposite extends AbstractEmbeddedComposite {

	private Composite control;
	private Text textBox;

	public ReportDetailsComposite(Report report) {
	}

	public String getName() {
		return "Details";
	}

	public Image getImage() {
		return Images.getImage(Images.FILE);
	}

	public void createControl(Composite parent) {
		super.createControl(parent);

		control = new Composite(parent, SWT.NONE);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(control);
		GridLayoutFactory.swtDefaults().numColumns(1).equalWidth(false)
				.applyTo(control);

		textBox = new Text(control, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		textBox.setEditable(false);
		GridDataFactory.fillDefaults().grab(true, true)
				.applyTo(textBox);
	}

	public Control getControl() {
		return control;
	}

	public void update(Report report, List<Node> nodes2) {
		StringWriter writer = new StringWriter();
		RcpttReportGenerator generator = new RcpttReportGenerator(new PrintWriter(writer), new ArrayList<ImageEntry>()) {
			@Override
			protected void printChildren(int tabs, Node infoNode) {
			}
		};
		for (Node node : nodes2)
			generator.printNode(node, 0);
		textBox.setText(writer.toString());
	}

}

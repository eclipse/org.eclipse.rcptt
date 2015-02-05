/*******************************************************************************
 * Copyright (c) 2009, 2014 Xored Software Inc and others.
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

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.rcptt.internal.ui.Images;
import org.eclipse.rcptt.reporting.core.RcpttReportGenerator;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Node;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Report;
import org.eclipse.rcptt.sherlock.core.reporting.SimpleReportGenerator;
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
		SimpleReportGenerator generator = new RcpttReportGenerator(report) {
			@Override
			protected void printChildren(StringBuilder stringBuilder, int tabs, Node infoNode,
					boolean includeWaitDetails) {
			}
		};
		StringBuilder b = new StringBuilder();
		for (Node node : nodes2) {
			generator.printNode(node, b, 0, false);
			b.append("RCPTT Widget details");
			generator.printNode(node, b, 0, true);
		}
		textBox.setText(b.toString());
	}

}

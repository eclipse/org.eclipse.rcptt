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

import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;

import org.eclipse.rcptt.internal.ui.Images;
import org.eclipse.rcptt.ui.controls.AbstractEmbeddedComposite;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Node;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Report;
import org.eclipse.rcptt.sherlock.core.reporting.SimpleReportGenerator;

public class ReportDetailsComposite extends AbstractEmbeddedComposite {

	private Composite control;
	private Report report;
//	private ReportTimelineComposite reportTimeline;
	private boolean includeTasks = true;
	private Text textBox;

	@Override
	protected void fillActions(IToolBarManager manager) {
//		IAction zoomInAction = new Action() {
//			@Override
//			public void run() {
//				reportTimeline.doZoomIn();
//			}
//		};
//		zoomInAction.setImageDescriptor(Images
//				.getImageDescriptor(Images.ZOOM_IN));
//		zoomInAction.setToolTipText("Zoom In");
//		manager.add(zoomInAction);
//
//		IAction zoomOutAction = new Action() {
//			@Override
//			public void run() {
//				reportTimeline.doZoomOut();
//			}
//		};
//		zoomOutAction.setImageDescriptor(Images
//				.getImageDescriptor(Images.ZOOM_OUT));
//		zoomOutAction.setToolTipText("Zoom Out");
//		manager.add(zoomOutAction);
//
//		IAction filter = new Action("Include tasks", Action.AS_CHECK_BOX) {
//			@Override
//			public void run() {
//				includeTasks = !includeTasks;
//				reportTimeline.setShowTasks(includeTasks);
//			}
//		};
//		filter.setChecked(includeTasks);
//		filter.setImageDescriptor(Images.getImageDescriptor(Images.ECL_COMMAND));
//		filter.setToolTipText("Include tasks");
//		manager.add(filter);

		// filter = new Action("Include Jobs", Action.AS_CHECK_BOX) {
		// @Override
		// public void run() {
		// includeJobs = !includeJobs;
		// internalUpdate(nodes);
		// }
		// };
		// filter.setChecked(includeJobs);
		// filter.setImageDescriptor(Images.getImageDescriptor(Images.SNAPSHOT));
		// filter.setToolTipText("Include Jobs");
		// manager.add(filter);
		//
		// filter = new Action("Include Asyncs", Action.AS_CHECK_BOX) {
		// @Override
		// public void run() {
		// includeAsync = !includeAsync;
		// internalUpdate(nodes);
		// }
		// };
		// filter.setChecked(includeAsync);
		// filter.setImageDescriptor(Images.getImageDescriptor(Images.SNAPSHOT));
		// filter.setToolTipText("Include Asyncs");
		// manager.add(filter);
		//
		// filter = new Action("Include Raw", Action.AS_CHECK_BOX) {
		// @Override
		// public void run() {
		// includeRaw = !includeRaw;
		// internalUpdate(nodes);
		// }
		// };
		// filter.setChecked(includeRaw);
		// filter.setImageDescriptor(Images.getImageDescriptor(Images.SNAPSHOT));
		// filter.setToolTipText("Include Raw");
		// manager.add(filter);
	}

	public ReportDetailsComposite(Report report) {
		this.report = report;
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

		textBox = new Text(control, SWT.BORDER| SWT.H_SCROLL | SWT.V_SCROLL);
		textBox.setEditable(false);
		GridDataFactory.fillDefaults().grab(true, true)
		.applyTo(textBox);
//		reportTimeline = new ReportTimelineComposite(report, control);
	}

	public Control getControl() {
		return control;
	}

	public void update(List<Node> nodes2) {
		SimpleReportGenerator generator = new SimpleReportGenerator();
		StringBuilder b = new StringBuilder();
		for (Node node : nodes2) {
			generator.printNode(node, b, 0, false);
			b.append("RCPTT Widget details");
			generator.printNode(node, b, 0, true);
		}
		textBox.setText(b.toString());
//		reportTimeline.update(nodes2);
		
	}

}

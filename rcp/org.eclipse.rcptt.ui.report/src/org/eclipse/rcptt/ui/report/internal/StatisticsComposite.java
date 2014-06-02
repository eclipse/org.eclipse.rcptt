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

import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

import org.eclipse.rcptt.internal.ui.Images;
import org.eclipse.rcptt.reporting.Q7Statistics;
import org.eclipse.rcptt.reporting.core.Q7ReportIterator;
import org.eclipse.rcptt.reporting.internal.ReportUtils;
import org.eclipse.rcptt.ui.controls.AbstractEmbeddedComposite;
import org.eclipse.rcptt.ui.launching.StatisticPanel;

public class StatisticsComposite extends AbstractEmbeddedComposite {

	private Composite control;
	private Q7Statistics statistics;

	@Override
	protected void fillActions(IToolBarManager manager) {
	}

	public StatisticsComposite(Q7ReportIterator iterator) {
		statistics = ReportUtils.calculateStatistics(iterator.iterator());
	}

	public String getName() {
		return "Execution statistics";
	}

	public Image getImage() {
		return Images.getImage(Images.FILE);
	}

	public void createControl(Composite parent) {
		super.createControl(parent);

		control = new Composite(parent, SWT.NONE);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(control);
		GridLayoutFactory.swtDefaults().numColumns(2).equalWidth(false)
				.applyTo(control);
		StatisticPanel panel = new StatisticPanel(control);
		if (statistics != null) {
			panel.update(statistics.getTotal(), statistics.getPassed()
					+ statistics.getFailed() + statistics.getSkipped(),
					statistics.getFailed(), statistics.getSkipped(),
					statistics.getTime());
		}
	}

	public Control getControl() {
		return control;
	}

}

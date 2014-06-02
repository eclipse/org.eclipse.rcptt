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
package org.eclipse.rcptt.ui.launching;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import org.eclipse.rcptt.internal.ui.Images;
import org.eclipse.rcptt.internal.ui.Messages;

public class StatisticPanel extends Composite {

	private final Label runsLabel;
	private final Label failuresLabel;
	private final Label stopsLabel;
	private final Label totalTimeLabel;

	public StatisticPanel(Composite parent) {
		super(parent, SWT.WRAP);
		RowLayout layout = new RowLayout();
		layout.wrap = true;
		layout.pack = true;
		layout.spacing = 10;
		setLayout(layout);

		runsLabel = createLabel(Messages.StatisticPanel_RunsLabel, null);
		failuresLabel = createLabel(Messages.StatisticPanel_FailuresLabel,
				Images.getImageDescriptor(Images.SCENARIO_FAIL_STATISTIC)
						.createImage());
		stopsLabel = createLabel(Messages.StatisticPanel_StopsLabel,
				Images.getImageDescriptor(Images.SCENARIO_STOP_STATISTIC)
						.createImage());
		totalTimeLabel = createLabel(Messages.StatisticPanel_TotalTimeLabel, null);

		reset();
	}

	private Label createLabel(String name, Image image) {
		Composite c = new Composite(this, SWT.NONE);
		GridLayoutFactory.fillDefaults().numColumns(3).applyTo(c);

		// Image
		Label label = new Label(c, SWT.NONE);
		if (image != null) {
			image.setBackground(label.getBackground());
			label.setImage(image);
			GridDataFactory.fillDefaults().align(SWT.BEGINNING, SWT.CENTER)
					.applyTo(label);
		} else {
			GridDataFactory.fillDefaults().exclude(true).applyTo(label);
		}

		// Name
		label = new Label(c, SWT.NONE);
		label.setText(name);
		GridDataFactory.fillDefaults().align(SWT.BEGINNING, SWT.CENTER)
				.applyTo(label);

		// Value
		label = new Label(c, SWT.NONE);
		GridDataFactory.fillDefaults().align(SWT.BEGINNING, SWT.CENTER)
				.applyTo(label);

		return label;
	}

	public synchronized void reset() {
		update(0, 0, 0, 0, 0);
	}

	public synchronized void update(int total, int finished, int failed,
			int stopped, long totalTime) {
		runsLabel.setText(finished + "/" + total); //$NON-NLS-1$
		failuresLabel.setText(String.valueOf(failed));
		stopsLabel.setText(String.valueOf(stopped));
		totalTimeLabel.setText(TimeFormatHelper.format(totalTime));
		layout();
		redraw();
	}
}

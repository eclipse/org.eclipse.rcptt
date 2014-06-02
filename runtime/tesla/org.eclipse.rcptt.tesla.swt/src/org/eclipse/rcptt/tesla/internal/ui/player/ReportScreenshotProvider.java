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
package org.eclipse.rcptt.tesla.internal.ui.player;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import org.eclipse.rcptt.reporting.core.ReportManager;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Node;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Report;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.ReportFactory;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Screenshot;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.ScreenshotKind;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Snaphot;
import org.eclipse.rcptt.sherlock.core.reporting.ReportBuilder;

public class ReportScreenshotProvider {
	private static SWTScreenCapturer screenCapturer;

	public static List<Snaphot> takeScreenshot(final Display display,
			final boolean onError, final String messagePrefix) {
		if (screenCapturer == null) {
			screenCapturer = new SWTScreenCapturer();
		}
		final List<Shell> toProceed = new ArrayList<Shell>();
		final List<Snaphot> shots = new ArrayList<Snaphot>();

		display.syncExec(new Runnable() {
			public void run() {
				Shell[] shells = display.getShells();
				for (Shell shell : shells) {
					if (shell.isDisposed() || !shell.isVisible()) {
						continue;
					}
					toProceed.add(shell);
				}
			}
		});

		for (final Shell s : toProceed) {
			display.syncExec(new Runnable() {
				public void run() {
					if (!s.isDisposed() && s.isVisible()) {
						if (s.getMinimized()) {
							s.setMinimized(false);
						}
						s.setActive();
						s.forceActive();
					}
				}
			});
			display.syncExec(new Runnable() {
				public void run() {
					if (!s.isDisposed() && s.isVisible()) {
						makeScreenshot(display, s, messagePrefix, onError,
								shots);
					}
				}
			});
		}

		return shots;
	}

	public static void makeScreenshot(Display display, Shell shell,
			String message, boolean onError, List<Snaphot> shots) {
		if (shell.isDisposed()) {
			return;
		}
		final Rectangle bounds = display.getBounds();
		String finalMessage = message;
		String postFix = PlayerTextUtils.replaceNonUnicode(shell.getText());
		if (postFix != null) {
			finalMessage = message + "(" + postFix + ")";
		}

		int minx = bounds.width, miny = bounds.height, maxx = 0, maxy = 0;

		Rectangle rectangle = shell.getBounds();
		rectangle.x -= 10;
		rectangle.y -= 10;
		rectangle.width += 20;
		rectangle.height += 20;
		Point displayPoint = new Point(rectangle.x, rectangle.y);
		if (minx > displayPoint.x) {
			minx = displayPoint.x;
		}
		if (miny > displayPoint.y) {
			miny = displayPoint.y;
		}

		if (maxx < displayPoint.x + rectangle.width) {
			maxx = displayPoint.x + rectangle.width;
		}
		if (maxy < displayPoint.y + rectangle.height) {
			maxy = displayPoint.y + rectangle.height;
		}
		// }
		byte[] shotData = screenCapturer.makeScreenShotData(display, minx,
				miny, maxx - minx, maxy - miny, null, !onError);
		if (shotData != null) {
			ReportBuilder builder = ReportManager.getBuilder();

			if (builder != null) {
				// Clean out previous screenshots with same name.
				Report report = builder.getReport();
				cleanScreenshots(report.getRoot(), finalMessage);

				Snaphot snaphot = builder.createSnapshot();
				Screenshot img = ReportFactory.eINSTANCE.createScreenshot();
				img.setKind(ScreenshotKind.PNG);
				img.setData(shotData);
				img.setMessage(finalMessage);
				snaphot.setData(img);
				shots.add(snaphot);
			}

		}
	}

	private static void cleanScreenshots(Node node, String message) {
		EList<Node> list = node.getChildren();
		for (Node child : list) {
			cleanScreenshots(child, message);
		}
		EList<Snaphot> snapshots = node.getSnapshots();
		List<Snaphot> toClean = new ArrayList<Snaphot>();
		for (Snaphot snapshot : snapshots) {
			EObject data = snapshot.getData();
			if (data instanceof Screenshot) {
				if (((Screenshot) data).getMessage().equals(message)) {
					toClean.add(snapshot);
				}
			}
		}
		snapshots.removeAll(toClean);
	}
}

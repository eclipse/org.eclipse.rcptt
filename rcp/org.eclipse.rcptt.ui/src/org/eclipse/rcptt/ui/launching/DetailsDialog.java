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

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.rcptt.internal.ui.Messages;
import org.eclipse.rcptt.reporting.Q7Info;
import org.eclipse.rcptt.reporting.core.ReportHelper;
import org.eclipse.rcptt.sherlock.core.model.sherlock.EclipseStatus;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Event;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.LoggingCategory;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Node;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Report;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Screenshot;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Snaphot;
import org.eclipse.rcptt.sherlock.core.reporting.ReportBuilder;
import org.eclipse.rcptt.sherlock.core.reporting.SimpleReportGenerator;
import org.eclipse.rcptt.tesla.core.info.AdvancedInformation;
import org.eclipse.rcptt.tesla.core.info.Q7WaitInfoRoot;
import org.eclipse.rcptt.tesla.core.utils.AdvancedInformationGenerator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

import com.google.common.base.Strings;

public final class DetailsDialog extends Dialog {
	@SuppressWarnings("unused")
	private AdvancedInformation info;
	private static final String LINE_SEPARATOR = System
			.getProperty("line.separator"); //$NON-NLS-1$
	private StyledText text;
	private Report report;

	public DetailsDialog(Shell parentShell, AdvancedInformation info,
			Report report) {
		super(parentShell);
		this.info = info;
		this.report = report;
		setShellStyle(getShellStyle() | SWT.SHEET);
	}

	@Override
	protected boolean isResizable() {
		return true;
	}

	private static class ImageEntry {
		byte[] data;
		String description;
	}

	private List<ImageEntry> images = new ArrayList<ImageEntry>();
	private int current = -1;
	private Composite bar;
	private Button nextButton;
	private Button prevButton;
	private Label imageIndex;
	private Label descriptionField;
	private Label imageControl;

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite content = (Composite) super.createDialogArea(parent);
		CTabFolder folder = new CTabFolder(content, SWT.NONE);
		folder.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		CTabItem screenshots = new CTabItem(folder, SWT.NONE);
		screenshots.setText("Screenshots");

		CTabItem item = new CTabItem(folder, SWT.NONE);
		text = new StyledText(folder, SWT.READ_ONLY | SWT.BORDER | SWT.H_SCROLL
				| SWT.V_SCROLL);
		item.setControl(text);
		item.setText("Description");
		final Composite ct = new Composite(folder, SWT.NONE);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(ct);
		GridLayoutFactory.swtDefaults().numColumns(1).applyTo(ct);

		generateContent();

		if (images.size() == 0) {
			screenshots.dispose();
		}

		final ScrolledComposite sc;
		if (images.size() > 0) {
			sc = new ScrolledComposite(ct, SWT.HORIZONTAL | SWT.VERTICAL
					| SWT.BORDER);
			GridDataFactory.swtDefaults().grab(true, true).applyTo(sc);
			sc.setExpandHorizontal(true);
			sc.setExpandVertical(true);
			GridDataFactory.fillDefaults().grab(true, true).applyTo(sc);
			imageControl = new Label(sc, SWT.BORDER);
			imageControl.setText(" ");
			GridDataFactory.fillDefaults().grab(true, true)
					.applyTo(imageControl);
			sc.setContent(imageControl);

			screenshots.setControl(ct);
		} else {
			sc = null;
		}
		Label info = new Label(ct, SWT.NONE);
		info.setText("Details:");
		GridDataFactory.fillDefaults().grab(true, false).applyTo(info);
		descriptionField = new Label(ct, SWT.NONE);
		GridDataFactory.fillDefaults().grab(true, false)
				.applyTo(descriptionField);

		if (sc != null) {
			bar = null;
			if (images.size() > 1) {
				bar = new Composite(ct, SWT.NONE);
				GridDataFactory.fillDefaults().grab(false, false)
						.align(SWT.RIGHT, SWT.CENTER).applyTo(bar);
				GridLayoutFactory.fillDefaults().numColumns(4).applyTo(bar);

				imageIndex = new Label(bar, SWT.NONE);

				prevButton = new Button(bar, SWT.PUSH);
				prevButton.setText("Previous");
				nextButton = new Button(bar, SWT.PUSH);
				nextButton.setText("Next");

				setButtonLayoutData(prevButton);
				setButtonLayoutData(nextButton);

				nextButton.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						updateImage(sc, 1);
					}
				});
				prevButton.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						updateImage(sc, -1);
					}
				});
			}
		}

		if (sc != null) {
			updateImage(sc, 1);
		}
		folder.setSelection(0);
		return content;
	}

	private void showImage(Label description, final Label imageControl,
			int selection) {
		if (current != selection) {
			if (images.size() > selection) {
				ImageEntry imgData = images.get(selection);
				description.setText(imgData.description);
				Image img = new Image(imageControl.getDisplay(),
						new ByteArrayInputStream(imgData.data));
				imageControl.setImage(img);
				current = selection;
			}
			// Update button enablement
			if (nextButton != null && prevButton != null && imageIndex != null) {
				prevButton.setEnabled(current != 0);
				nextButton.setEnabled(current != images.size() - 1);
				imageIndex.setText("Screenshot " + (current + 1) + " from "
						+ images.size());
				bar.layout();
			}
		}
	}

	private void generateContent() {
		String value = ""; //$NON-NLS-1$
		// if (info != null) {
		// value = new AdvancedInformationGenerator().generateContent(info);
		// }
		if (report != null) {
			value += "\n" + new RcpttReportGenerator(this.report, this.images).generateContent(report);
		}
		text.setText(value);
	}

	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText(Messages.DetailsDialog_Title);
		Rectangle bounds = newShell.getBounds();
		newShell.setBounds(bounds.x, bounds.y, 800, 600);
	}

	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL,
				true);
	}

	private void updateImage(final ScrolledComposite sc, int change) {
		int selection = current + change;
		if (selection < 0 || selection >= images.size()) {
			return;
		}
		showImage(descriptionField, imageControl, selection);
		Point size = imageControl.computeSize(SWT.DEFAULT, SWT.DEFAULT);
		sc.setMinSize(size);
	}

	private static class RcpttReportGenerator extends SimpleReportGenerator {
		private final List<ImageEntry> images;
		private final Report report;

		public RcpttReportGenerator(Report report, List<ImageEntry> images) {
			this.report = report;
			this.images = images;
		}

		@Override
		public StringBuilder toString(StringBuilder builder,
				int tabs, org.eclipse.emf.ecore.EObject obj,
				String... ignores) {
			if (obj instanceof AdvancedInformation) {
				String content = new AdvancedInformationGenerator()
						.generateContent((AdvancedInformation) obj);
				builder.append(content);
				return builder;
			}
			return super.toString(builder, tabs, obj, ignores);
		};

		@Override
		public void printNode(
				org.eclipse.rcptt.sherlock.core.model.sherlock.report.Node infoNode,
				StringBuilder stringBuilder, int tabs, boolean includeWaitDetails) {

			writeQ7Info(stringBuilder, tabs, infoNode);

			if (includeWaitDetails) {
				writeQ7WaitInfo(stringBuilder, tabs, infoNode);
			}

			writeLogsFromNode(stringBuilder, tabs, infoNode);

			printChildren(stringBuilder, tabs, infoNode, includeWaitDetails);

			if (!includeWaitDetails) {
				for (Event child : infoNode.getEvents()) {
					if (child.getData() instanceof EclipseStatus) {
						printStatus(
								(EclipseStatus) child.getData(),
								tabs + 6, stringBuilder);
					}
				}

				for (Snaphot child : infoNode.getSnapshots()) {
					if (child.getData() instanceof Screenshot) {
						Screenshot shot = (Screenshot) child
								.getData();
						ImageEntry e = new ImageEntry();
						e.data = shot.getData();
						e.description = shot.getMessage()
								+ ": "
								+ TimeFormatHelper.format(child
										.getTime()
										- report.getRoot()
												.getStartTime());
						images.add(e);
					} else {
						printSnapshot(child, stringBuilder, tabs + 4);
					}
				}
			}
		}

		private void printChildren(StringBuilder stringBuilder, int tabs, Node infoNode, boolean includeWaitDetails) {
			for (Node child : infoNode.getChildren()) {
				printNode(child, stringBuilder, tabs + 4, includeWaitDetails);
			}
		}

		private void writeQ7WaitInfo(StringBuilder stringBuilder, int tabs, Node infoNode) {
			Q7WaitInfoRoot waitInfo = ReportHelper.getWaitInfo(infoNode, false);
			if (waitInfo != null) {
				printWaitInfo(stringBuilder, tabs, "", waitInfo);
			}
		}

		private void writeQ7Info(StringBuilder stringBuilder, int tabs, Node infoNode) {
			Q7Info q7Info = ReportHelper.getInfo(infoNode);
			appendTabs(stringBuilder, tabs);
			if (q7Info != null) {
				switch (q7Info.getType()) {
				case TESTCASE:
					stringBuilder.append(Messages.bind(
							Messages.DetailsDialog_TestCase,
							infoNode.getName()));
					break;
				case SCRIPT:
					stringBuilder.append(Messages.bind(
							Messages.DetailsDialog_Script,
							infoNode.getName()));
					break;
				case CONTEXT:
					stringBuilder.append(Messages.bind(
							Messages.DetailsDialog_Context,
							infoNode.getName()));
					break;
				case VERIFICATION:
					stringBuilder.append(Messages.bind(
							Messages.DetailsDialog_Verifications,
							infoNode.getName(), q7Info.getPhase()));
					break;
				case ECL_COMMAND:
					stringBuilder.append(Messages.bind(
							Messages.DetailsDialog_EclCommand,
							infoNode.getName()));
					break;
				case TEST_SUITE:
					// TODO: Check it later.
					break;
				default:
					break;
				}
				stringBuilder.append(" ") //$NON-NLS-1$
						.append(Messages
								.bind(Messages.DetailsDialog_TimeFragment,
										TimeFormatHelper.format(infoNode
												.getEndTime()
												- infoNode
														.getStartTime())))
						.append(LINE_SEPARATOR);
			}
		}

		private void writeLogsFromNode(StringBuilder builder, int tabs, Node infoNode) {
			boolean haveEntries = false;
			for (LoggingCategory logCategory : LoggingCategory.VALUES) {
				String log = ReportBuilder.getLogs(infoNode, logCategory);
				if (!Strings.isNullOrEmpty(log)) {
					if (!haveEntries) {
						haveEntries = true;
						appendTabs(builder, tabs)
								.append("--------------Logs BEGIN-------------------")
								.append(LINE_SEPARATOR);
					}

					for (String logLine : log.split(LINE_SEPARATOR)) {
						appendTabs(builder, tabs)
								.append(logLine)
								.append(LINE_SEPARATOR);
					}
				}
			}

			if (haveEntries) {
				appendTabs(builder, tabs)
						.append("--------------Logs END-------------------")
						.append(LINE_SEPARATOR);
			}
		}
	}
}

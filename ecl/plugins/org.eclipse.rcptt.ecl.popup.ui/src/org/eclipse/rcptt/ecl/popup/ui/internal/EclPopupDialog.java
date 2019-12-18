/*******************************************************************************
 * Copyright (c) 2009, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.ecl.popup.ui.internal;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.dialogs.PopupDialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.rcptt.ecl.popup.EclPopupPlugin;
import org.eclipse.rcptt.ecl.popup.EclPopupSession;
import org.eclipse.rcptt.ecl.popup.EclPopupSession.EclResult;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.internal.WorkbenchPlugin;

@SuppressWarnings("restriction")
public class EclPopupDialog extends PopupDialog {
	private EclPopupSession session;

	public EclPopupDialog(IWorkbenchWindow window) {
		super(window.getShell(), SWT.RESIZE, true, true, // persist size
				false, // but not location
				true, true, null, "Start typing ECL command");

		this.session = EclPopupPlugin.getDefault().getSession();
		refresh("");
	}

	private StyledText filterText;
	private boolean afterExec = false;
	private boolean updateAfterExec = false;

	@Override
	protected Control createTitleControl(Composite parent) {
		filterText = new StyledText(parent, SWT.NONE);

		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.CENTER)
				.grab(true, false).applyTo(filterText);
		filterText.addKeyListener(new KeyListener() {

			public void keyReleased(KeyEvent e) {
				// do nothing
			}

			public void keyPressed(KeyEvent e) {
				switch (e.keyCode) {
				case SWT.TAB:
					String newText = filterText.getText().trim() + "tabbed";
					filterText.setText(newText);
					filterText.setCaretOffset(newText.length());
					break;
				case SWT.CR:
				case SWT.KEYPAD_CR:
					execCommand();
					break;
				case SWT.ARROW_UP:
					history.receiveBottomFocus();
					break;
				case SWT.ARROW_DOWN:
					if (!result.isHidden()) {
						result.receiveTopFocus();
					} else {
						proposals.receiveTopFocus();
					}
					break;
				}
			}
		});
		filterText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				String text = ((StyledText) e.widget).getText().toLowerCase();
				refresh(text);
			}
		});
		return filterText;

	}

	@Override
	protected Control createDialogArea(Composite parent) {
		final Composite area = (Composite) super.createDialogArea(parent);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL)
				.grab(true, true).applyTo(area);
		result = new ResultRow(area, "Result");
		result.hide();
		result.setFocusReceiver(new IFocusReceiver() {

			public void receiveTopFocus() {
				focusFilterText();
			}

			public void receiveBottomFocus() {
				history.receiveTopFocus();
			}
		});
		proposals = new ProposalRow(area);
		proposals.setFocusReceiver(new IFocusReceiver() {
			public void receiveTopFocus() {
				focusFilterText();
			}

			public void receiveBottomFocus() {
				history.receiveTopFocus();
			}

		});
		proposals.setCommandReceiver(new ICommandReceiver() {

			public void commandSelected(String command) {
				setFilterText(command);
			}
		});
		history = new ResultRow(area, "History");
		history.setResults(session.getHistory());
		history.setFocusReceiver(new IFocusReceiver() {

			public void receiveTopFocus() {
				if (result.isHidden()) {
					proposals.receiveBottomFocus();
				} else {
					result.receiveBottomFocus();
				}
			}

			public void receiveBottomFocus() {
				focusFilterText();
			}
		});
		history.setCommandReceiver(new ICommandReceiver() {

			public void commandSelected(String command) {
				setFilterText(command);
			}
		});
		getShell().addControlListener(new ControlAdapter() {
			@Override
			public void controlResized(ControlEvent e) {
				int height = area.getSize().y / 2;
				proposals.setHeightHint(height);
				history.setHeightHint(height);
				result.setHeightHint(height);
				area.layout();

			}
		});
		return area;
	}

	private ResultRow history;
	private ProposalRow proposals;
	private ResultRow result;

	private void execCommand() {
		final String command = filterText.getText().trim();
		filterText.setEnabled(false);
		Job job = new Job("command") {
			@Override
			protected IStatus run(IProgressMonitor monitor) {

				final EclResult result = session.exec(command);
				if (!closed) {
					getShell().getDisplay().asyncExec(new Runnable() {
						public void run() {
							executionDone(result);
						}
					});
				}
				return Status.OK_STATUS;
			}
		};
		job.setSystem(true);
		job.schedule();
	}

	private void executionDone(EclResult r) {
		if (closed) {
			return;
		}
		filterText.setEnabled(true);
		result.setResults(new EclResult[] { r });
		result.show();
		proposals.hide();
		updateLayout();
		afterExec = true;
		updateAfterExec = true;
		filterText.setText("");
		filterText.setFocus();
	}

	private void updateLayout() {
		result.getParent().layout();
	}

	@Override
	protected Control getFocusControl() {
		return filterText;
	}

	protected IDialogSettings getDialogSettings() {
		final IDialogSettings workbenchDialogSettings = WorkbenchPlugin
				.getDefault().getDialogSettings();
		IDialogSettings result = workbenchDialogSettings.getSection(getId());
		if (result == null) {
			result = workbenchDialogSettings.addNewSection(getId());
		}
		return result;
	}

	protected String getId() {
		return "org.eclipse.rcptt.ecl.popup.EclPopup"; //$NON-NLS-1$
	}

	protected void refresh(String text) {
		if (result == null) {
			return;
		}
		if (afterExec) {
			history.setResults(session.getHistory());
			afterExec = false;
			return;
		}

		if (updateAfterExec) {
			result.hide();
			proposals.show();
			updateLayout();
			updateAfterExec = false;
		}

		proposals.setCommand(text);

	}

	private void setFilterText(String text) {
		filterText.setText(text);
		focusFilterText();
	}

	private void focusFilterText() {
		filterText.setFocus();
		filterText.setCaretOffset(filterText.getText().length());
	}

	private boolean closed = false;

	@Override
	public boolean close() {
		closed = true;
		return super.close();
	}
}

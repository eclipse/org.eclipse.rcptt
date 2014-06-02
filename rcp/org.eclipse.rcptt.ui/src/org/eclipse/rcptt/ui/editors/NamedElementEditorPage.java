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
package org.eclipse.rcptt.ui.editors;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.IFormColors;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;

import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.scenario.NamedElement;
import org.eclipse.rcptt.internal.ui.HookUtils;
import org.eclipse.rcptt.internal.ui.Messages;
import org.eclipse.rcptt.launching.IExecutable;
import org.eclipse.rcptt.launching.IExecutionSession;
import org.eclipse.rcptt.launching.ILaunchListener;
import org.eclipse.rcptt.launching.Q7Launcher;
import org.eclipse.rcptt.ui.launching.LaunchUtils;

public abstract class NamedElementEditorPage extends FormPage implements
		IQ7NamedElementEditorPage {

	protected final DataBindingContext dbc = new DataBindingContext();
	protected EditorHeader header;
	protected EditorContent editorContent;

	public NamedElementEditorPage(NamedElementEditor editor, String id,
			String title) {
		super(editor, id, title);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.rcptt.ui.editors.IQ7NamedElementEditorPage#getEditor()
	 */
	@Override
	public NamedElementEditor getEditor() {
		return (NamedElementEditor) super.getEditor();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.rcptt.ui.editors.IQ7NamedElementEditorPage#getModel()
	 */
	public IQ7NamedElement getModel() {
		return getEditor().getModel();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.rcptt.ui.editors.IQ7NamedElementEditorPage#getElement()
	 */
	public NamedElement getElement() {
		return getEditor().getElement();
	}

	public EditorHeader getHeader() {
		return header;
	}

	@Override
	protected void createFormContent(IManagedForm managedForm) {
		ScrolledForm form = managedForm.getForm();
		FormToolkit toolkit = managedForm.getToolkit();

		Composite parent = form.getBody();
		GridLayoutFactory.fillDefaults().margins(0, 0).spacing(0, 0)
				.equalWidth(true).applyTo(parent);

		Composite composite = createGeneralContent(parent, toolkit);

		// Composite composite = toolkit.createComposite(parent);
		// GridDataFactory.fillDefaults().grab(true, true).applyTo(composite);
		// GridLayoutFactory.fillDefaults().margins(5, 5).spacing(0, 0)
		// .equalWidth(true).applyTo(composite);

		createSpecificContent(composite, toolkit, managedForm);
		getEditor().createActions();
	}
	

	protected void createSpecificContent(Composite parent, FormToolkit toolkit,
			IManagedForm managedForm) {
	}

	protected Composite createGeneralContent(Composite parent,
			FormToolkit toolkit) {
		Composite top2 = toolkit.createComposite(parent);
		top2.setLayoutData(new GridData(GridData.FILL_BOTH));

		header = createHeader();
		Composite composite = header.createContent(top2, toolkit);
		header.update(getModel(), getElement());

		editorContent = createEditorContent();

		editorContent.createSections(composite, toolkit);
		editorContent.setSelectionProvider(getSite());

		return composite;
	}

	protected EditorContent createEditorContent() {
		return new EditorContent(header, false, false);
	}

	protected EditorHeader createHeader() {
		return new EditorHeader(getModel(), getElement()) {
			@Override
			protected void record() {
			}
		};
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

	protected abstract void record();

	protected void replay() {
		IResource res = getModel().getResource();
		if (res == null)
			return;
		LaunchUtils.launchContext(new IResource[] { res }, "run"); //$NON-NLS-1$
	}

	protected void multiReplay() {
		final IResource res = getModel().getResource();
		if (res == null)
			return;
		InputDialog in = new InputDialog(null,
				Messages.NamedElementEditorPage_RunCounterDialogTitle,
				Messages.NamedElementEditorPage_RunCounterDialogLabel,
				Messages.NamedElementEditorPage_RunCounterDialogDefaultValue,
				new IInputValidator() {
					public String isValid(String newText) {
						try {
							int value = Integer.parseInt(newText);
							if (value <= 0) {
								return Messages.NamedElementEditorPage_RunCounterDialogNeagtiveIntErrorMsg;
							}
						} catch (Throwable e) {
							return Messages.NamedElementEditorPage_RunCounterDialogIncorrectIntErrorMsg;
						}
						return null;
					}
				});
		final int count[] = new int[] { 10 };
		if (in.open() == InputDialog.OK) {
			try {
				count[0] = Integer.parseInt(in.getValue());
			} catch (NumberFormatException ew) {
			}
			final Job j = new Job("Times execute") { //$NON-NLS-1$
				@Override
				protected IStatus run(IProgressMonitor monitor) {
					LaunchUtils.launchContext(new IResource[] { res }, "run"); //$NON-NLS-1$
					return Status.OK_STATUS;
				}
			};
			final ILaunchListener listener = new ILaunchListener() {
				public void started(IExecutionSession session) {
				}

				public void launchStatusChanged(IExecutable... executable) {
					for (IExecutable e : executable) {
						if (e.getStatus() == IExecutable.FAILED) {
							count[0] = 0;
						}
					}
				}

				public void finished() {
					count[0]--;
					if (count[0] > 0) {
						j.schedule(500);
					}
				}
			};
			Job cancelationJob = new Job("Times execution") { //$NON-NLS-1$
				@Override
				protected IStatus run(IProgressMonitor monitor) {
					monitor.beginTask("Times", count[0]); //$NON-NLS-1$
					while (!monitor.isCanceled() && count[0] > 0) {
						int count2 = count[0];
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							// Ignore
						}
						if (count2 != count[0]) {
							monitor.worked(count2 - count[0]);
						}
					}
					count[0] = 0;
					Q7Launcher.getInstance().removeListener(listener);
					return Status.OK_STATUS;
				}
			};
			cancelationJob.schedule();
			Q7Launcher.getInstance().addListener(listener);
			j.schedule();
		}
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

	@Override
	public void setFocus() {
		header.focus();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.rcptt.ui.editors.IQ7NamedElementEditorPage#elementChangedEvent()
	 */
	public void elementChangedEvent() {
	}

	public EditorContent getContent() {
		return editorContent;
	}

	@Override
	public void createPartControl(Composite parent) {
		super.createPartControl(parent);
		HookUtils.textHook(parent, new Runnable() {
			public void run() {
				((NamedElementEditor) getEditor()).updateEnablement();
			}
		}, new FocusListener() {
			public void focusGained(FocusEvent e) {
				((NamedElementEditor) getEditor()).updateEnablement();
				((NamedElementEditor) getEditor()).activateActions();
			}

			public void focusLost(FocusEvent e) {
				((NamedElementEditor) getEditor()).deactivateActions();
			}
		});
	}
}

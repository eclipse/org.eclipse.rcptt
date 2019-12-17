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
package org.eclipse.rcptt.ui.controls;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.AbstractOperation;
import org.eclipse.core.commands.operations.IOperationHistory;
import org.eclipse.core.commands.operations.IOperationHistoryListener;
import org.eclipse.core.commands.operations.IUndoContext;
import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.commands.operations.OperationHistoryEvent;
import org.eclipse.core.databinding.observable.ChangeEvent;
import org.eclipse.core.databinding.observable.IChangeListener;
import org.eclipse.core.databinding.observable.value.ComputedValue;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.ui.actions.ToggleBreakpointAction;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentListener;
import org.eclipse.jface.text.ITextViewerExtension6;
import org.eclipse.jface.text.IUndoManagerExtension;
import org.eclipse.jface.text.source.AnnotationModel;
import org.eclipse.jface.text.source.AnnotationRulerColumn;
import org.eclipse.jface.text.source.CompositeRuler;
import org.eclipse.jface.text.source.LineNumberRulerColumn;
import org.eclipse.jface.text.source.OverviewRuler;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.editors.text.EditorsUI;
import org.eclipse.ui.texteditor.AbstractTextEditor;
import org.eclipse.ui.texteditor.AnnotationPreference;
import org.eclipse.ui.texteditor.DefaultMarkerAnnotationAccess;
import org.eclipse.ui.texteditor.MarkerAnnotationPreferences;
import org.eclipse.ui.texteditor.ResourceMarkerAnnotationModel;
import org.eclipse.ui.texteditor.SourceViewerDecorationSupport;

import org.eclipse.rcptt.core.Scenarios;
import org.eclipse.rcptt.core.internal.builder.Q7Builder;
import org.eclipse.rcptt.core.scenario.Scenario;
import org.eclipse.rcptt.core.scenario.ScenarioPackage;
import org.eclipse.rcptt.internal.core.model.Q7InternalTestCase;
import org.eclipse.rcptt.internal.ui.Images;
import org.eclipse.rcptt.internal.ui.Messages;
import org.eclipse.rcptt.internal.ui.Q7UIPlugin;
import org.eclipse.rcptt.ui.debug.ToggleBreakpointEnablementAction;
import org.eclipse.rcptt.ui.editors.TextViewerActionsSupport;
import org.eclipse.rcptt.ui.editors.ecl.EclSourceViewer;
import org.eclipse.rcptt.ui.editors.ecl.EclSourceViewerConfiguration;
import org.eclipse.rcptt.ui.panels.Actions;
import org.eclipse.rcptt.ui.recording.RecordingSupport.RecordingMode;

public class ScriptComposite extends AbstractEmbeddedComposite {

	private static final String SCENARIO_ERROR = "Test case contains errors. Please see error log for details."; //$NON-NLS-1$
	private final Scenario scenario;
	private final IFile file;
	private final IWorkbenchPartSite site;
	private final Shell shell;
	private final int style;
	private final AtomicBoolean scrollLock = new AtomicBoolean(false);
	private Composite control;
	private EclSourceViewer viewer;
	private boolean ignoreChanges;
	private int lastDocumentOperation;

	private final IObservableValue editable = new ComputedValue() {
		@Override
		protected Object calculate() {
			return (Boolean) stopped.getValue();
		}
	};

	private final IObservableValue stopped = new ComputedValue() {
		@Override
		protected Object calculate() {
			return getRecordingMode().equals(RecordingMode.Stopped);
		}
	};

	public ScriptComposite(Q7InternalTestCase model, IFile file, Shell shell, int style) {
		this.scenario = model.getNamedElement();
		this.file = file;
		this.site = null;
		this.shell = shell;
		this.style = style;
	}

	public String getName() {
		return Messages.ScriptComposite_Name;
	}

	public Image getImage() {
		return Images.getImage(Images.PANEL_SCENARIO);
	}

	private RecordingMode getRecordingMode() {
		return (RecordingMode) recordingMode.getValue();
	}

	@SuppressWarnings("restriction")
	@Override
	public void createControl(Composite parent) {
		super.createControl(parent);
		final CompositeRuler ruler = new CompositeRuler();

		DefaultMarkerAnnotationAccess access = new DefaultMarkerAnnotationAccess();

		AnnotationRulerColumn annotations = new AnnotationRulerColumn(12,
				access);
		ruler.addDecorator(0, annotations);

		LineNumberRulerColumn column = new LineNumberRulerColumn() {
			@Override
			public int getWidth() {
				return super.getWidth() + 10;
			}
		};
		Font font = JFaceResources.getTextFont();
		column.setFont(font);
		column.setForeground(parent.getDisplay().getSystemColor(
				SWT.COLOR_DARK_GRAY));
		ruler.addDecorator(1, column);

		OverviewRuler overview = new OverviewRuler(access, 12,
				EditorsUI.getSharedTextColors());

		MarkerAnnotationPreferences preferences = org.eclipse.ui.internal.editors.text.EditorsPlugin.getDefault()
				.getMarkerAnnotationPreferences();

		AnnotationModel model = file != null ? new ResourceMarkerAnnotationModel(
				file) : new AnnotationModel();

		Iterator<?> e = preferences.getAnnotationPreferences().iterator();
		while (e.hasNext()) {
			AnnotationPreference preference = (AnnotationPreference) e.next();
			if (preference.contributesToHeader())
				overview.addHeaderAnnotationType(preference.getAnnotationType());
			// annotations.addAnnotationType(preference.getAnnotationType());
		}
		annotations.addAnnotationType(Q7Builder.MARKER_TYPE);

		viewer = new EclSourceViewer(parent, ruler, overview, true, SWT.MULTI
				| SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		final IDocument document = new Document(
				Scenarios.getScriptContent(scenario));
		viewer.setDocument(document, model);
		viewer.configure(new EclSourceViewerConfiguration());

		SourceViewerDecorationSupport support = new SourceViewerDecorationSupport(
				viewer, overview, access, EditorsUI.getSharedTextColors());

		Iterator<?> it = preferences.getAnnotationPreferences().iterator();
		while (it.hasNext())
			support.setAnnotationPreference((AnnotationPreference) it.next());

		support.install(EditorsUI.getPreferenceStore());

		Control rulerControl = ruler.getControl();
		rulerControl.addMouseListener(new MouseListener() {

			public void mouseUp(final MouseEvent e) {
			}

			public void mouseDoubleClick(MouseEvent e) {
				if (1 == e.button) {
					ToggleBreakpointAction action = new ToggleBreakpointAction(
							PlatformUI.getWorkbench()
									.getActiveWorkbenchWindow().getActivePage()
									.getActivePart(), document, ruler);
					action.update();
					action.run();
				}
			}

			public void mouseDown(MouseEvent e) {
			}
		});

		String id = AbstractTextEditor.DEFAULT_RULER_CONTEXT_MENU_ID;

		MenuManager manager = new MenuManager(id, id);
		manager.setRemoveAllWhenShown(true);
		manager.addMenuListener(new IMenuListener() {
			public void menuAboutToShow(IMenuManager menu) {
				if (viewer != null && viewer.getTextWidget() != null)
					viewer.getTextWidget().setFocus();

				ToggleBreakpointAction action1 = new ToggleBreakpointAction(
						PlatformUI.getWorkbench().getActiveWorkbenchWindow()
								.getActivePage().getActivePart(), document,
						ruler);
				action1.update();
				menu.add(action1);

				ToggleBreakpointEnablementAction action2 = new ToggleBreakpointEnablementAction(
						viewer, ruler);

				action2.update();
				if (action2.isEnabled()) {
					menu.add(action2);
				}
			}
		});

		Menu fRulerContextMenu = manager.createContextMenu(rulerControl);
		rulerControl.setMenu(fRulerContextMenu);

		viewer.setEditable((Boolean) editable.getValue());
		editable.addChangeListener(new IChangeListener() {
			public void handleChange(ChangeEvent event) {
				viewer.setEditable((Boolean) editable.getValue());
			}
		});

		GridDataFactory.fillDefaults().grab(true, true)
				.applyTo(viewer.getControl());

		getOperationHistory().addOperationHistoryListener(
				new IOperationHistoryListener() {

					public void historyNotification(OperationHistoryEvent event) {
						lastDocumentOperation = event.getEventType();
					}
				});

		viewer.getDocument().addDocumentListener(new IDocumentListener() {
			public void documentChanged(DocumentEvent event) {
				if (ignoreChanges) {
					return;
				}
				if (!getRecordingMode().equals(RecordingMode.Recording)) {
					String value = viewer.getDocument().get();
					if ((value == null || value.length() == 0)
							&& lastDocumentOperation != OperationHistoryEvent.ABOUT_TO_UNDO) {
						clear();
					} else {
						Scenarios.setEclContent(scenario, value);
					}
				}
			}

			public void documentAboutToBeChanged(DocumentEvent event) {
				// Do nothing
			}
		});

		IChangeListener scenarioContentListener = new IChangeListener() {
			public void handleChange(ChangeEvent event) {
				if (ignoreChanges) {
					return;
				}
				String script;
				try {
					script = Scenarios.getScriptContent(scenario);
				} catch (Exception e) {
					script = SCENARIO_ERROR;
					Q7UIPlugin.log(e);
				}
				// in some cases after hit upon here from document listener
				// viewer.getDocument() is null
				if (viewer.getDocument() != null) {
					String doc = viewer.getDocument().get();
					if (!doc.equals(script)) {
						viewer.getDocument().set(script);
						if ((!getRecordingMode().equals(RecordingMode.Stopped) && !getRecordingMode()
								.equals(RecordingMode.Replaying))
								&& !scrollLock.get()) {
							try {
								IDocument document = viewer.getDocument();
								int length = document.getLength();
								if (document.getLength() > 0) {
									int lineOfOffset = document
											.getLineOfOffset(length);
									int lineOffset = document
											.getLineOffset(lineOfOffset);
									viewer.revealRange(lineOffset, 0);
								}
							} catch (BadLocationException e) {
								Q7UIPlugin.log((e));
							}
						}
					}
				}
			}
		};
		IObservableValue scriptContent = EMFObservables.observeValue(scenario,
				ScenarioPackage.Literals.SCENARIO__CONTENT);
		scriptContent.addChangeListener(scenarioContentListener);

		IObservableValue teslaContent = EMFObservables.observeValue(scenario,
				ScenarioPackage.Literals.SCENARIO__TESLA_CONTENT);
		teslaContent.addChangeListener(scenarioContentListener);

		if (site != null) {
			new TextViewerActionsSupport(viewer, site, editable);
		} else if (shell != null) {
			new TextViewerActionsSupport(viewer, shell, editable);
		}

		control = viewer.getControl();
	}

	public Control getControl() {
		return control;
	}

	public EclSourceViewer getViewer() {
		return viewer;
	}

	@Override
	public void fillActions(IToolBarManager manager) {
		IAction clearAction = new Action() {
			@Override
			public void run() {
				clear();
			}
		};
		clearAction.setImageDescriptor(Images
				.getImageDescriptor(Images.PANEL_CLEAR));
		clearAction.setToolTipText(Messages.ScriptComposite_ClearActionToolTip);
		dbc.bindValue(Actions.observeEnabled(clearAction), new ComputedValue() {
			@Override
			protected Object calculate() {
				return getRecordingMode().equals(RecordingMode.Stopped);
			}
		});
		manager.add(clearAction);

		if ((style & SWT.SCROLL_LOCK) != 0) {
			IAction scrollLockAction = new Action("", IAction.AS_CHECK_BOX) { //$NON-NLS-1$
				@Override
				public void run() {
					scrollLock.set(isChecked());
				};
			};
			scrollLockAction.setImageDescriptor(Images
					.getImageDescriptor(Images.PANEL_SCROLL_LOCK));
			scrollLockAction
					.setToolTipText(Messages.ScriptComposite_ScrollLockActionToolTip);
			final IObservableValue scrollLockEnabled = new ComputedValue() {
				@Override
				protected Object calculate() {
					return (Boolean) (!getRecordingMode().equals(
							RecordingMode.Stopped) && !getRecordingMode()
							.equals(RecordingMode.Replaying));
				}
			};
			dbc.bindValue(Actions.observeEnabled(scrollLockAction),
					scrollLockEnabled);
			manager.add(scrollLockAction);
		}
	}

	public void clear() {
		// Must clean Tesla first to prevent viewer getting old content
		// from Tesla on Scenario content change
		final IUndoContext undoContext = (viewer instanceof ITextViewerExtension6 && viewer
				.getUndoManager() instanceof IUndoManagerExtension) ? ((IUndoManagerExtension) viewer
				.getUndoManager()).getUndoContext() : null;

		if (undoContext != null) {
			ClearScenarioOperation clearScenario = new ClearScenarioOperation(
					Messages.ScriptComposite_ClearActionOp, undoContext);
			try {
				getOperationHistory().execute(clearScenario, null, null);
			} catch (ExecutionException e) {
				Q7UIPlugin.log((e));
			}
		} else {
			scenario.setContent(null);
			scenario.setTeslaContent(null);
		}
	}

	private static IOperationHistory getOperationHistory() {
		return PlatformUI.getWorkbench().getOperationSupport()
				.getOperationHistory();
	}

	private class ClearScenarioOperation extends AbstractOperation {

		private EObject fPreservedTeslaContent;
		private EObject fPreservedECLContent;
		private final IUndoContext fUndoContext;

		public ClearScenarioOperation(String label, IUndoContext undoContext) {
			super(label);
			fUndoContext = undoContext;
			addContext(fUndoContext);
		}

		@Override
		public IStatus execute(IProgressMonitor monitor, IAdaptable info)
				throws ExecutionException {
			ignoreChanges = true;
			fPreservedECLContent = scenario.getContent();
			fPreservedTeslaContent = scenario.getTeslaContent();
			scenario.setContent(null);
			scenario.setTeslaContent(null);
			viewer.getTextWidget().setText(""); //$NON-NLS-1$
			getOperationHistory().replaceOperation(
					getOperationHistory().getUndoOperation(fUndoContext),
					new IUndoableOperation[0]);
			ignoreChanges = false;
			return Status.OK_STATUS;
		}

		@Override
		public IStatus redo(IProgressMonitor monitor, IAdaptable info)
				throws ExecutionException {
			return execute(monitor, info);
		}

		@Override
		public IStatus undo(IProgressMonitor monitor, IAdaptable info)
				throws ExecutionException {
			ignoreChanges = true;
			scenario.setTeslaContent(fPreservedTeslaContent);
			fPreservedTeslaContent = null;
			scenario.setContent(fPreservedECLContent);
			fPreservedECLContent = null;

			String script;
			try {
				script = Scenarios.getScriptContent(scenario);
			} catch (Exception e) {
				script = SCENARIO_ERROR;
				Q7UIPlugin.log(e);
			}
			viewer.getTextWidget().setText(script);
			getOperationHistory().replaceOperation(
					getOperationHistory().getUndoOperation(fUndoContext),
					new IUndoableOperation[0]);
			ignoreChanges = false;

			return Status.OK_STATUS;
		}
	}

}

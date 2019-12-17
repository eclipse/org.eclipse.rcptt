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
package org.eclipse.rcptt.ui.editors;

import java.util.ResourceBundle;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.IOperationHistory;
import org.eclipse.core.commands.operations.IOperationHistoryListener;
import org.eclipse.core.commands.operations.IUndoContext;
import org.eclipse.core.commands.operations.OperationHistoryEvent;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.ChangeEvent;
import org.eclipse.core.databinding.observable.IChangeListener;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.bindings.keys.KeyStroke;
import org.eclipse.jface.bindings.keys.ParseException;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.text.ITextOperationTarget;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.text.ITextViewerExtension6;
import org.eclipse.jface.text.IUndoManagerExtension;
import org.eclipse.jface.text.TextViewer;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.IWorkbenchCommandConstants;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.operations.RedoActionHandler;
import org.eclipse.ui.operations.UndoActionHandler;
import org.eclipse.ui.texteditor.FindReplaceAction;
import org.eclipse.ui.texteditor.ITextEditorActionConstants;
import org.eclipse.ui.texteditor.ITextEditorActionDefinitionIds;
import org.eclipse.ui.texteditor.ResourceAction;

import org.eclipse.rcptt.internal.ui.Messages;
import org.eclipse.rcptt.internal.ui.Q7UIPlugin;
import org.eclipse.rcptt.ui.actions.GotoScriptLineAction;

public class TextViewerActionsSupport implements FocusListener, DisposeListener {

	private final TextViewer textViewer;
	private final IWorkbenchPartSite partSite;
	private final Shell shell;
	private final IObservableValue editable;
	@SuppressWarnings("unused")
	private final DataBindingContext dbc = new DataBindingContext();

	private final static String CutLabel = Messages.TextViewerActionsSupport_CutLabel;
	private final static String CopyLabel = Messages.TextViewerActionsSupport_CopyLabel;
	private final static String PasteLabel = Messages.TextViewerActionsSupport_PasteLabel;
	private final static String DeleteLabel = Messages.TextViewerActionsSupport_DeleteLabel;
	private final static String SelectAllLabel = Messages.TextViewerActionsSupport_SelectAllLabel;

	final static String BUNDLE_FOR_CONSTRUCTED_KEYS = "org.eclipse.ui.texteditor.ConstructedEditorMessages";//$NON-NLS-1$

	private Action undoAction;
	private Action redoAction;

	private Action cutAction;
	private Action copyAction;
	private Action pasteAction;
	private Action deleteAction;
	private Action selectAllAction;

	private ResourceAction findAction;

	private Action contentAssistAction;
	private Action gotoLineAction;

	public TextViewerActionsSupport(TextViewer textViewer,
			IWorkbenchPartSite partSite, IObservableValue editable) {
		this.textViewer = textViewer;
		this.partSite = partSite;
		this.shell = partSite.getShell();
		this.editable = editable;
		init();
	}

	public TextViewerActionsSupport(TextViewer textViewer, Shell shell,
			IObservableValue editable) {
		this.textViewer = textViewer;
		this.partSite = null;
		this.shell = shell;
		this.editable = editable;
		init();
	}

	private void init() {
		addListeners();
		createActions();
		if (partSite == null) {
			setAcceleratorLabel();
		} else if (getTextWidget() != null && getTextWidget().isFocusControl()) {
			activateActions();
		}
		updateEditActionsEnablement();
		editable.addChangeListener(new IChangeListener() {
			public void handleChange(ChangeEvent event) {
				updateEditActionsEnablement();
			}
		});
		createPopupMenu();
	}

	public Action getUndoAction() {
		return undoAction;
	}

	public Action getRedoAction() {
		return redoAction;
	}

	public Action getCutAction() {
		return cutAction;
	}

	public Action getCopyAction() {
		return copyAction;
	}

	public Action getPasteAction() {
		return pasteAction;
	}

	public Action getDeleteAction() {
		return deleteAction;
	}

	public Action getSelectAllAction() {
		return selectAllAction;
	}

	public ResourceAction getFindAction() {
		return findAction;
	}

	public Action getContentAssistAction() {
		return contentAssistAction;
	}

	public Action getGotoLineAction() {
		return gotoLineAction;
	}

	private void addListeners() {
		if (getTextWidget() != null) {
			if (partSite != null) {
				getTextWidget().addFocusListener(this);
				getTextWidget().addDisposeListener(this);
			} else {
				getTextWidget().addKeyListener(new KeyAdapter() {
					public void keyPressed(KeyEvent event) {
						try {
							processKeyDown(event);
						} catch (ParseException e) {
							Q7UIPlugin.log(e);
						}
					}
				});
			}
		}
		this.textViewer
				.addSelectionChangedListener(new ISelectionChangedListener() {
					public void selectionChanged(SelectionChangedEvent event) {
						updateEditActionsEnablement();
					}
				});
	}

	private void processKeyDown(KeyEvent e) throws ParseException {
		KeyStroke pressed = KeyStroke.getInstance(e.stateMask,
				Character.toUpperCase(e.keyCode));

		if (pressed.equals(KeyStroke.getInstance("M1+Z"))) { //$NON-NLS-1$
			undoAction.run();
		} else if (pressed.equals(KeyStroke.getInstance("M1+Y"))) { //$NON-NLS-1$
			redoAction.run();
		} else if (pressed.equals(KeyStroke.getInstance("M1+A"))) { //$NON-NLS-1$
			selectAllAction.run();
		} else if (pressed.equals(KeyStroke.getInstance("M1+F"))) { //$NON-NLS-1$
			findAction.run();
		} else if (pressed.equals(KeyStroke.getInstance("Ctrl+Space"))) { //$NON-NLS-1$
			contentAssistAction.run();
		} else if (gotoLineAction != null
				&& pressed.equals(KeyStroke.getInstance("M1+L"))) { //$NON-NLS-1$
			gotoLineAction.run();
		}

	}

	private void createPopupMenu() {
		if (getTextWidget() != null) {
			MenuManager popupMenuManager = new MenuManager();
			IMenuListener listener = new IMenuListener() {
				public void menuAboutToShow(IMenuManager mng) {
					fillContextMenu(mng);
				}
			};
			popupMenuManager.addMenuListener(listener);
			popupMenuManager.setRemoveAllWhenShown(true);
			Menu menu = popupMenuManager.createContextMenu(textViewer
					.getControl());
			getTextWidget().setMenu(menu);
		}
	}

	private void fillContextMenu(IMenuManager menuManager) {
		if (undoAction != null)
			menuManager.add(undoAction);
		if (redoAction != null)
			menuManager.add(redoAction);
		if (undoAction != null || redoAction != null)
			menuManager.add(new Separator());
		menuManager.add(cutAction);
		menuManager.add(copyAction);
		menuManager.add(pasteAction);
		menuManager.add(new Separator());
		menuManager.add(deleteAction);
		menuManager.add(selectAllAction);
	}

	private void updateEditActionsEnablement() {
		ITextSelection selection = (ITextSelection) textViewer.getSelection();
		boolean hasSelectedText = !selection.isEmpty()
				&& selection.getLength() > 0;
		boolean isEditable = (Boolean) editable.getValue();
		cutAction.setEnabled(isEditable && hasSelectedText);
		copyAction.setEnabled(hasSelectedText);
		pasteAction.setEnabled(isEditable);
		deleteAction.setEnabled(isEditable && hasSelectedText);
		if (findAction != null) {
			findAction.setEnabled(true);
		}
	}

	private void createActions() {
		createUndoRedoActions();
		createCommonTextAction();
		createAdditionalAction();
	}

	private void createUndoRedoActions() {
		if (textViewer instanceof ITextViewerExtension6
				&& textViewer.getUndoManager() instanceof IUndoManagerExtension) {

			final IUndoContext undoContext = ((IUndoManagerExtension) textViewer
					.getUndoManager()).getUndoContext();
			if (undoContext != null) {

				if (partSite != null) {
					undoAction = new UndoActionHandler(partSite, undoContext);
					redoAction = new RedoActionHandler(partSite, undoContext);
				} else {
					undoAction = new CustomUndoAction(undoContext);
					redoAction = new CustomRedoAction(undoContext);
				}
				undoAction
						.setActionDefinitionId(IWorkbenchCommandConstants.EDIT_UNDO);
				redoAction
						.setActionDefinitionId(IWorkbenchCommandConstants.EDIT_REDO);

				textViewer.getUndoManager().reset();
			}
		}
	}

	private void createCommonTextAction() {
		cutAction = new Action(CutLabel) {
			public void run() {
				if (textViewer.canDoOperation(ITextOperationTarget.CUT))
					textViewer.doOperation(ITextOperationTarget.CUT);
			};
		};
		cutAction.setActionDefinitionId(IWorkbenchCommandConstants.EDIT_CUT);
		cutAction
				.setImageDescriptor(getImageDescriptor(ISharedImages.IMG_TOOL_CUT));
		cutAction
				.setDisabledImageDescriptor(getImageDescriptor(ISharedImages.IMG_TOOL_CUT_DISABLED));

		copyAction = new Action(CopyLabel) {
			public void run() {
				if (textViewer.canDoOperation(ITextOperationTarget.COPY))
					textViewer.doOperation(ITextOperationTarget.COPY);
			};
		};
		copyAction.setActionDefinitionId(IWorkbenchCommandConstants.EDIT_COPY);
		copyAction
				.setImageDescriptor(getImageDescriptor(ISharedImages.IMG_TOOL_COPY));
		copyAction
				.setDisabledImageDescriptor(getImageDescriptor(ISharedImages.IMG_TOOL_COPY_DISABLED));

		pasteAction = new Action(PasteLabel) {
			public void run() {
				if (textViewer.canDoOperation(ITextOperationTarget.PASTE))
					textViewer.doOperation(ITextOperationTarget.PASTE);
			};
		};
		pasteAction
				.setActionDefinitionId(IWorkbenchCommandConstants.EDIT_PASTE);
		pasteAction
				.setImageDescriptor(getImageDescriptor(ISharedImages.IMG_TOOL_PASTE));
		pasteAction
				.setDisabledImageDescriptor(getImageDescriptor(ISharedImages.IMG_TOOL_PASTE_DISABLED));

		deleteAction = new Action(DeleteLabel) {
			public void run() {
				if (textViewer.canDoOperation(ITextOperationTarget.DELETE))
					textViewer.doOperation(ITextOperationTarget.DELETE);
			};
		};
		deleteAction
				.setActionDefinitionId(IWorkbenchCommandConstants.EDIT_DELETE);
		deleteAction
				.setImageDescriptor(getImageDescriptor(ISharedImages.IMG_TOOL_DELETE));
		deleteAction
				.setDisabledImageDescriptor(getImageDescriptor(ISharedImages.IMG_TOOL_DELETE_DISABLED));

		selectAllAction = new Action(SelectAllLabel) {
			public void run() {
				if (textViewer.canDoOperation(ITextOperationTarget.SELECT_ALL))
					textViewer.doOperation(ITextOperationTarget.SELECT_ALL);
			};
		};
		selectAllAction
				.setActionDefinitionId(IWorkbenchCommandConstants.EDIT_SELECT_ALL);

	}

	private void createAdditionalAction() {
		if (shell != null) {
			ResourceBundle fgBundleForConstructedKeys = ResourceBundle
					.getBundle(BUNDLE_FOR_CONSTRUCTED_KEYS);

			findAction = new FindReplaceAction(
					fgBundleForConstructedKeys, "Editor.FindReplace.", shell, textViewer.getFindReplaceTarget()); //$NON-NLS-1$
			findAction
					.setActionDefinitionId(IWorkbenchCommandConstants.EDIT_FIND_AND_REPLACE);
		}

		contentAssistAction = new Action() {
			@Override
			public void run() {
				if (textViewer.isEditable()
						&& textViewer.getTextWidget().isFocusControl()) {
					Display display = Display.getCurrent();

					BusyIndicator.showWhile(display, new Runnable() {
						public void run() {
							textViewer
									.doOperation(ISourceViewer.CONTENTASSIST_PROPOSALS);
						}
					});
				}
			}
		};
		contentAssistAction
				.setActionDefinitionId(IWorkbenchCommandConstants.EDIT_CONTENT_ASSIST);

		// create gotoLine action only if textViewer not in editPart
		if (partSite == null && textViewer.getDocument() != null) {
			gotoLineAction = new GotoScriptLineAction(textViewer);
			gotoLineAction
					.setActionDefinitionId(ITextEditorActionDefinitionIds.LINE_GOTO);
		}
	}

	private void setAcceleratorLabel() {
		if (undoAction != null) {
			undoAction.setAccelerator(KeyCodeAcceleratorFormat("M1+Z")); //$NON-NLS-1$
		}
		if (redoAction != null) {
			redoAction.setAccelerator(KeyCodeAcceleratorFormat("M1+Y")); //$NON-NLS-1$
		}
		cutAction.setAccelerator(KeyCodeAcceleratorFormat("M1+X")); //$NON-NLS-1$
		copyAction.setAccelerator(KeyCodeAcceleratorFormat("M1+C")); //$NON-NLS-1$
		pasteAction.setAccelerator(KeyCodeAcceleratorFormat("M1+V")); //$NON-NLS-1$
		deleteAction.setAccelerator(KeyCodeAcceleratorFormat("DELETE")); //$NON-NLS-1$
		selectAllAction.setAccelerator(KeyCodeAcceleratorFormat("M1+A")); //$NON-NLS-1$
		if (gotoLineAction != null) {
			gotoLineAction.setAccelerator(KeyCodeAcceleratorFormat("M1+L")); //$NON-NLS-1$
		}
	}

	private int KeyCodeAcceleratorFormat(String shortcut) {
		try {
			return KeyStroke.getInstance(shortcut).getModifierKeys()
					| KeyStroke.getInstance(shortcut).getNaturalKey();
		} catch (ParseException e) {
			return 0;
		}
	}

	private void activateActions() {
		IActionBars actionBars = getActionBars();
		if (actionBars != null) {
			actionBars.setGlobalActionHandler(ITextEditorActionConstants.UNDO,
					undoAction);
			actionBars.setGlobalActionHandler(ITextEditorActionConstants.REDO,
					redoAction);
			actionBars.setGlobalActionHandler(ITextEditorActionConstants.CUT,
					cutAction);
			actionBars.setGlobalActionHandler(ITextEditorActionConstants.COPY,
					copyAction);
			actionBars.setGlobalActionHandler(ITextEditorActionConstants.PASTE,
					pasteAction);
			actionBars.setGlobalActionHandler(
					ITextEditorActionConstants.DELETE, deleteAction);
			actionBars.setGlobalActionHandler(
					ITextEditorActionConstants.SELECT_ALL, selectAllAction);
			actionBars.setGlobalActionHandler(ITextEditorActionConstants.FIND,
					findAction);
			actionBars.setGlobalActionHandler(
					ITextEditorActionConstants.CONTENT_ASSIST,
					contentAssistAction);
			actionBars.updateActionBars();
		}
	}

	private void deactivateActions() {
		IActionBars actionBars = getActionBars();
		if (actionBars != null) {
			actionBars.setGlobalActionHandler(ITextEditorActionConstants.UNDO,
					null);
			actionBars.setGlobalActionHandler(ITextEditorActionConstants.REDO,
					null);
			actionBars.setGlobalActionHandler(ITextEditorActionConstants.CUT,
					null);
			actionBars.setGlobalActionHandler(ITextEditorActionConstants.COPY,
					null);
			actionBars.setGlobalActionHandler(ITextEditorActionConstants.PASTE,
					null);
			actionBars.setGlobalActionHandler(
					ITextEditorActionConstants.DELETE, null);
			actionBars.setGlobalActionHandler(
					ITextEditorActionConstants.SELECT_ALL, null);
			actionBars.setGlobalActionHandler(ITextEditorActionConstants.FIND,
					null);
			actionBars.setGlobalActionHandler(
					ITextEditorActionConstants.CONTENT_ASSIST, null);
			actionBars.updateActionBars();
		}
	}

	public void widgetDisposed(DisposeEvent e) {
		deactivateActions();
	}

	public void focusGained(FocusEvent e) {
		activateActions();
	}

	public void focusLost(FocusEvent e) {
		deactivateActions();
	}

	private ImageDescriptor getImageDescriptor(String imageId) {
		return PlatformUI.getWorkbench().getSharedImages()
				.getImageDescriptor(imageId);
	}

	private StyledText getTextWidget() {
		return textViewer.getTextWidget();
	}

	private IActionBars getActionBars() {
		if (partSite instanceof IEditorSite)
			return ((IEditorSite) partSite).getActionBars();

		if (partSite instanceof IViewSite)
			return ((IViewSite) partSite).getActionBars();

		return null;
	}

	private abstract class CustomOperationAction extends Action {

		private IUndoContext undoContext = null;

		CustomOperationAction(IUndoContext context) {
			super(""); //$NON-NLS-1$
			undoContext = context;
			AddHistoryListener();
			updateEnablement();
		}

		private void AddHistoryListener() {
			getHistory().addOperationHistoryListener(
					new IOperationHistoryListener() {
						public void historyNotification(
								OperationHistoryEvent event) {
							if (event.getOperation().hasContext(undoContext)) {
								updateEnablement();
							}
						}
					});
		}

		protected abstract void updateEnablement();

		IOperationHistory getHistory() {
			return PlatformUI.getWorkbench().getOperationSupport()
					.getOperationHistory();
		}

		final IUndoContext getUndoContext() {
			return undoContext;
		}
	}

	private class CustomUndoAction extends CustomOperationAction {

		CustomUndoAction(IUndoContext context) {
			super(context);

			setText(Messages.TextViewerActionsSupport_UndoLabel);
			setImageDescriptor(PlatformUI.getWorkbench().getSharedImages()
					.getImageDescriptor(ISharedImages.IMG_TOOL_UNDO));
			setDisabledImageDescriptor(PlatformUI.getWorkbench()
					.getSharedImages()
					.getImageDescriptor(ISharedImages.IMG_TOOL_UNDO_DISABLED));
		}

		public final void run() {
			if (isEnabled()) {
				try {
					getHistory().undo(getUndoContext(), null, null);
				} catch (ExecutionException e) {
					Q7UIPlugin.log(e);
				}
			}
		}

		protected void updateEnablement() {
			setEnabled(getHistory().canUndo(getUndoContext()));
		}
	}

	private class CustomRedoAction extends CustomOperationAction {

		CustomRedoAction(IUndoContext context) {
			super(context);

			setText(Messages.TextViewerActionsSupport_RedoLabel);
			setImageDescriptor(PlatformUI.getWorkbench().getSharedImages()
					.getImageDescriptor(ISharedImages.IMG_TOOL_REDO));
			setDisabledImageDescriptor(PlatformUI.getWorkbench()
					.getSharedImages()
					.getImageDescriptor(ISharedImages.IMG_TOOL_REDO_DISABLED));
		}

		public final void run() {
			if (isEnabled()) {
				try {
					getHistory().redo(getUndoContext(), null, null);
				} catch (ExecutionException e) {
					e.printStackTrace();
				}
			}
		}

		protected void updateEnablement() {
			setEnabled(getHistory().canRedo(getUndoContext()));
		}
	}
}

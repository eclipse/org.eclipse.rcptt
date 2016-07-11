package org.eclipse.rcptt.tesla.recording.aspects.workbench.rap;

import org.aspectj.lang.annotation.SuppressAjWarnings;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.IHandler;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.statushandlers.StatusAdapter;
import org.eclipse.ui.statushandlers.WorkbenchStatusDialogManager;
import org.eclipse.rcptt.tesla.core.am.rap.AspectManager;
import org.eclipse.rcptt.tesla.core.context.ContextManagement;
import org.eclipse.rcptt.tesla.core.context.ContextManagement.Context;
import org.eclipse.ui.internal.statushandlers.InternalDialog;
import org.eclipse.ui.internal.WorkbenchPage;
import org.eclipse.ui.internal.OpenPreferencesAction;

public aspect WorkbenchRecordingAspect {

	public WorkbenchRecordingAspect() {
		AspectManager.activateAspect(RecordingWorkbenchActivator.PLUGIN_ID, this.getClass().getName());
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	before(IEditorReference[] refArray, boolean save):
		execution(boolean org.eclipse.ui.internal.WorkbenchPage.closeEditors (IEditorReference[], boolean)) &&
		args(refArray, save) {
		try {
			Context context = ContextManagement.currentContext();
			// System.out.println("Close EDITORS:");
			if (context.contains(
					"org.eclipse.rap.ui.internal.presentations.PaneFolder",
					"notifyCloseListeners")) {
				// This is mostly mouse close event
				WorkbenchEventManager.closeEditors(refArray);
			}
		} catch (Throwable e) {
			RecordingWorkbenchActivator.log(e);
		}
	}

	// Object around(): execution(boolean
	// org.eclipse.rap.ui.internal.Workbench.restart()) {
	// Object result = proceed();
	// try {
	// if (result instanceof Boolean && ((Boolean) result).booleanValue()) {
	// WorkbenchEventManager.restartEclipse();
	// }
	// } catch (Throwable e) {
	// RecordingWorkbenchActivator.log(e);
	// }
	// return result;
	// }

	@SuppressAjWarnings("adviceDidNotMatch")
	Object around(IHandler handler, ExecutionEvent event):
		execution(Object org.eclipse.core.commands.IHandler.execute(ExecutionEvent))
		&& target(handler) && args(event) {
		try {
			if (WorkbenchEventManager.getFreeze()) {
				return 0;
			}
			ActionType type = matchHandler(handler);
			if (type != null) {
				WorkbenchEventManager.recordAction(type);
			}
		} catch (Throwable e) {
			RecordingWorkbenchActivator.log(e);
		}
		return proceed(handler, event);
	}


	private ActionType matchHandler(IHandler handler) {
		String name = handler.getClass().getName();
		if ("org.eclipse.rap.ui.internal.about.AboutHandler".equals(name)) {
			return ActionType.ABOUT_DIALOG;
		}
		if ("org.eclipse.rap.ui.internal.handlers.ShowPreferencePageHandler"
				.equals(name)) {
			return ActionType.PREFERENCE_DIALOG;
		}
		return null;
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	before(): execution(void org.eclipse.ui.internal.OpenPreferencesAction.run()) {
		WorkbenchEventManager.recordAction(ActionType.PREFERENCE_DIALOG);
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	Object around(WorkbenchStatusDialogManager mgr, StatusAdapter adapter,
			boolean modal):
		execution(void org.eclipse.ui.statushandlers.WorkbenchStatusDialogManager.addStatusAdapter(StatusAdapter, boolean))
		&& target(mgr) && args(adapter, modal) {
		try {
			WorkbenchEventManager.recordAddStatus(adapter, modal);
		} catch (Throwable e) {
			RecordingWorkbenchActivator.log(e);
		}
		return proceed(mgr, adapter, modal);
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	after(): execution(boolean org.eclipse.ui.internal.statushandlers.InternalDialog.close()) {
		try {
			WorkbenchEventManager.recordStatusCleanup();
		} catch (Throwable e) {
			RecordingWorkbenchActivator.log(e);
		}
	}
}

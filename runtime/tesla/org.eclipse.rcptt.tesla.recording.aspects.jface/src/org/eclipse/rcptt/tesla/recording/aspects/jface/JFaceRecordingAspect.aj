package org.eclipse.rcptt.tesla.recording.aspects.jface;

import org.aspectj.lang.annotation.SuppressAjWarnings;
import org.eclipse.jface.util.OpenStrategy;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnViewerEditor;
import org.eclipse.jface.viewers.ColumnViewerEditorActivationEvent;
import org.eclipse.swt.events.SelectionEvent;

import org.eclipse.rcptt.tesla.core.am.AspectManager;

public aspect JFaceRecordingAspect {

	public JFaceRecordingAspect() {
		AspectManager.activateAspect(RecordingJFaceActivator.PLUGIN_ID, this
				.getClass().getName());
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	after(CellEditor cellEditor): 
		execution(void org.eclipse.jface.viewers.CellEditor.activate ()) && target(cellEditor) {
		try {
			if (!skipActive) {
				JFaceEventManager.activateCellEditor(cellEditor);
			}
		} catch (Throwable e) {
			RecordingJFaceActivator.log(e);
		}
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	before(SelectionEvent e, OpenStrategy str):
		execution(void org.eclipse.jface.util.OpenStrategy.fireOpenEvent(SelectionEvent)) && args(e) && target(str) {
		try {
			JFaceEventManager.recordOpenStrategyEvent(str, e);
		} catch (Throwable eee) {
			RecordingJFaceActivator.log(eee);
		}
	}

	private boolean skipActive = false;

	@SuppressAjWarnings("adviceDidNotMatch")
	before(CellEditor cellEditor,
			ColumnViewerEditorActivationEvent activationEvent): 
		execution(void org.eclipse.jface.viewers.CellEditor.activate (ColumnViewerEditorActivationEvent)) && target(cellEditor) && args(activationEvent) {
		skipActive = true;
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	after(CellEditor cellEditor,
			ColumnViewerEditorActivationEvent activationEvent): 
		execution(void org.eclipse.jface.viewers.CellEditor.activate (ColumnViewerEditorActivationEvent)) && target(cellEditor) && args(activationEvent) {
		try {
			JFaceEventManager.activateCellEditor(cellEditor, activationEvent);
			skipActive = false;
		} catch (Throwable e) {
			RecordingJFaceActivator.log(e);
		}
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	before(CellEditor cellEditor): 
		execution(void org.eclipse.jface.viewers.CellEditor.fireApplyEditorValue ()) && target(cellEditor) {
		try {
			JFaceEventManager.applyCellEditor(cellEditor);
		} catch (Throwable e) {
			RecordingJFaceActivator.log(e);
		}
	}
	@SuppressAjWarnings("adviceDidNotMatch")
	before(CellEditor cellEditor): 
		execution(void org.eclipse.jface.viewers.CellEditor.deactivate ()) && target(cellEditor) {
		try {
			JFaceEventManager.deactivateCellEditor(cellEditor);
		} catch (Throwable e) {
			RecordingJFaceActivator.log(e);
		}
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	before(ColumnViewerEditor editor): execution( void org.eclipse.jface.viewers.ColumnViewerEditor.applyEditorValue()) && target(editor) {
		try {
			JFaceEventManager.applyCellEditor(editor);
		} catch (Throwable e) {
			RecordingJFaceActivator.log(e);
		}
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	before(ColumnViewerEditor editor): execution( void org.eclipse.jface.viewers.ColumnViewerEditor.cancelEditing()) && target(editor) {
		try {
			JFaceEventManager.cancelCellEditor(editor);
		} catch (Throwable e) {
			RecordingJFaceActivator.log(e);
		}
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	before(CellEditor cellEditor): 
		execution(void org.eclipse.jface.viewers.CellEditor.fireCancelEditor ()) && target(cellEditor) {
		try {
			JFaceEventManager.cancelCellEditor(cellEditor);
		} catch (Throwable e) {
			RecordingJFaceActivator.log(e);
		}
	}
}

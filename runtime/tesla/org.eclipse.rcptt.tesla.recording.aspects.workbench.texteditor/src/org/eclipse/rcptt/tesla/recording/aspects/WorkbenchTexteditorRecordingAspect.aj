package org.eclipse.rcptt.tesla.recording.aspects;

import org.aspectj.lang.annotation.SuppressAjWarnings;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.IVerticalRuler;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.texteditor.AbstractTextEditor;

import org.eclipse.rcptt.tesla.core.am.AspectManager;

public aspect WorkbenchTexteditorRecordingAspect {

	public WorkbenchTexteditorRecordingAspect() {
		AspectManager.activateAspect(
				RecordingWorkbenchTexteditorActivator.PLUGIN_ID, this
						.getClass().getName());
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	ISourceViewer around(AbstractTextEditor editor): 
		execution(ISourceViewer org.eclipse.ui.texteditor.AbstractTextEditor.createSourceViewer(Composite, IVerticalRuler, int))
		&& target(editor) {
		ISourceViewer result = proceed(editor);
		try {
			WorkbenchTexteditorEventManager.mapEditor(result, editor);
		} catch (Throwable e) {
			RecordingWorkbenchTexteditorActivator.log(e);
		}
		return result;
	}
}

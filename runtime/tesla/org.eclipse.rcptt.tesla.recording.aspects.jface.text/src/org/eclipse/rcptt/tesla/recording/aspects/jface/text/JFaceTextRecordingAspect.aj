package org.eclipse.rcptt.tesla.recording.aspects.jface.text;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.aspectj.lang.annotation.SuppressAjWarnings;
import org.eclipse.jface.text.AbstractInformationControlManager;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.TextViewer;
import org.eclipse.jface.text.source.CompositeRuler;
import org.eclipse.jface.text.source.OverviewRuler;
import org.eclipse.jface.text.source.VerticalRuler;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Widget;

import org.eclipse.rcptt.tesla.core.am.AspectManager;
import org.eclipse.rcptt.tesla.swt.events.TeslaEventManager;

public aspect JFaceTextRecordingAspect {

	public JFaceTextRecordingAspect() {
		AspectManager.activateAspect(RecordingJFaceTextActivator.PLUGIN_ID,
				this.getClass().getName());
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	before(boolean autoActivation): 
		execution(String org.eclipse.jface.text.contentassist.CompletionProposalPopup.showProposals(boolean)) && args(autoActivation) {
		try {
			Object target = thisJoinPoint.getTarget();
			JFaceTextEventManager.showContentAssist(target, autoActivation);
		} catch (Throwable e) {
			RecordingJFaceTextActivator.log(e);
		}
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	Object around(boolean autoActivation): 
		execution(String org.eclipse.jface.text.contentassist.CompletionProposalPopup.showProposals(boolean)) && args(autoActivation) {
		if (TeslaEventManager.getManager().isFiltering() && autoActivation) {
			return null;
		}
		return proceed(autoActivation);
	}
	
	@SuppressAjWarnings("adviceDidNotMatch")
	before(AbstractInformationControlManager infControlManager, Rectangle subjectArea, Object information): 
		execution(void org.eclipse.jface.text.AbstractInformationControlManager.internalShowInformationControl(Rectangle, Object)) && target(infControlManager) && args(subjectArea, information) {
		try {		
			Object obj = getOriginalControl(infControlManager);
			if (obj instanceof Widget) {
				Widget widget = (Widget)obj;
				JFaceTextEventManager.activateInfomationWindow(widget, subjectArea);
			}
		} catch (Throwable e) {
			RecordingJFaceTextActivator.log(e);
		}				
	}
	
	private Object getOriginalControl(AbstractInformationControlManager infControlManager) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		Method method = AbstractInformationControlManager.class.getDeclaredMethod("getSubjectControl");
		method.setAccessible(true);
		return method.invoke(infControlManager);
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	StyledText around(TextViewer viewer):
		execution(StyledText org.eclipse.jface.text.TextViewer.createTextWidget(org.eclipse.swt.widgets.Composite, int)) 
		&& target(viewer) {
		StyledText result = proceed(viewer);
		JFaceTextEventManager.mapViewer(result, viewer);
		return result;
	}
	
	@SuppressAjWarnings("adviceDidNotMatch")
	Control around(VerticalRuler ruler, Composite parent, ITextViewer viewer):
		execution(Control org.eclipse.jface.text.source.VerticalRuler.createControl(Composite, ITextViewer)) 
		&& target(ruler) && args(parent, viewer) {
		Control result = proceed(ruler, parent, viewer);
		try {
			JFaceTextEventManager.mapRuler(ruler, result, viewer);
		} catch (Throwable e) {
			RecordingJFaceTextActivator.log(e);
		}
		return result;
	}
	
	@SuppressAjWarnings("adviceDidNotMatch")
	Control around(CompositeRuler ruler, Composite parent, ITextViewer viewer):
		execution(Control org.eclipse.jface.text.source.CompositeRuler.createControl(Composite, ITextViewer)) 
		&& target(ruler) && args(parent, viewer) {
		Control result = proceed(ruler, parent, viewer);
		try {
			JFaceTextEventManager.mapRuler(ruler, result, viewer);
		} catch (Throwable e) {
			RecordingJFaceTextActivator.log(e);
		}
		return result;
	}
	
	@SuppressAjWarnings("adviceDidNotMatch")
	Control around(OverviewRuler ruler, Composite parent, ITextViewer viewer):
		execution(Control org.eclipse.jface.text.source.OverviewRuler.createControl(Composite, ITextViewer)) 
		&& target(ruler) && args(parent, viewer) {
		Control result = proceed(ruler, parent, viewer);
		try {
			JFaceTextEventManager.mapRuler(ruler, result, viewer);
		} catch (Throwable e) {
			RecordingJFaceTextActivator.log(e);
		}
		return result;
	}
}

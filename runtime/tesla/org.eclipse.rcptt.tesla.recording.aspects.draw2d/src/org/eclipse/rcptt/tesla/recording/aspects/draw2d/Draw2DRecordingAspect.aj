package org.eclipse.rcptt.tesla.recording.aspects.draw2d;

import org.aspectj.lang.annotation.SuppressAjWarnings;
import org.eclipse.draw2d.SWTEventDispatcher;

import org.eclipse.rcptt.tesla.core.am.AspectManager;

public aspect Draw2DRecordingAspect {

	public Draw2DRecordingAspect() {
		AspectManager.activateAspect(RecordingDraw2DActivator.PLUGIN_ID, this
				.getClass().getName());
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	after(SWTEventDispatcher dispatcher, org.eclipse.swt.events.MouseEvent me):
		execution(public void org.eclipse.draw2d.SWTEventDispatcher.dispatchMousePressed(org.eclipse.swt.events.MouseEvent)) && target(dispatcher) && args(me) {
		try {
			Draw2DEventManager.mousePressed(dispatcher, me);
		} catch (Throwable e) {
			RecordingDraw2DActivator.log(e);
		}
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	after(SWTEventDispatcher dispatcher, org.eclipse.swt.events.MouseEvent me):
		execution(public void org.eclipse.draw2d.SWTEventDispatcher.dispatchMouseMoved(org.eclipse.swt.events.MouseEvent)) && target(dispatcher) && args(me) {
		try {
			Draw2DEventManager.mouseMoved(dispatcher, me);
		} catch (Throwable e) {
			RecordingDraw2DActivator.log(e);
		}
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	before(SWTEventDispatcher dispatcher, org.eclipse.swt.events.MouseEvent me):
		execution(public void org.eclipse.draw2d.SWTEventDispatcher.dispatchMouseReleased(org.eclipse.swt.events.MouseEvent)) && target(dispatcher) && args(me) {
		try {
			Draw2DEventManager.mouseReleased(dispatcher, me);
		} catch (Throwable e) {
			RecordingDraw2DActivator.log(e);
		}
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	after(SWTEventDispatcher dispatcher, org.eclipse.swt.events.MouseEvent me):
		execution(public void org.eclipse.draw2d.SWTEventDispatcher.dispatchMouseHover(org.eclipse.swt.events.MouseEvent)) && target(dispatcher) && args(me) {
		try {
			Draw2DEventManager.mouseHover(dispatcher, me);
		} catch (Throwable e) {
			RecordingDraw2DActivator.log(e);
		}
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	after(SWTEventDispatcher dispatcher, org.eclipse.swt.events.MouseEvent me):
		execution(public void org.eclipse.draw2d.SWTEventDispatcher.dispatchMouseEntered(org.eclipse.swt.events.MouseEvent)) && target(dispatcher) && args(me) {
		try {
			Draw2DEventManager.mouseEntered(dispatcher, me);
		} catch (Throwable e) {
			RecordingDraw2DActivator.log(e);
		}
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	after(SWTEventDispatcher dispatcher, org.eclipse.swt.events.MouseEvent me):
		execution(public void org.eclipse.draw2d.SWTEventDispatcher.dispatchMouseExited(org.eclipse.swt.events.MouseEvent)) && target(dispatcher) && args(me) {
		try {
			Draw2DEventManager.mouseExited(dispatcher, me);
		} catch (Throwable e) {
			RecordingDraw2DActivator.log(e);
		}
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	after(SWTEventDispatcher dispatcher, org.eclipse.swt.events.MouseEvent me):
		execution(public void org.eclipse.draw2d.SWTEventDispatcher.dispatchMouseDoubleClicked(org.eclipse.swt.events.MouseEvent)) && target(dispatcher) && args(me) {
		try {
			Draw2DEventManager.mouseDoubleClick(dispatcher, me);
		} catch (Throwable e) {
			RecordingDraw2DActivator.log(e);
		}
	}
}

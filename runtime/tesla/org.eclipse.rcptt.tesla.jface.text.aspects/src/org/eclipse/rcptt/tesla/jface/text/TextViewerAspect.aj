package org.eclipse.rcptt.tesla.jface.text;

import org.aspectj.lang.annotation.SuppressAjWarnings;
import org.eclipse.jface.text.AbstractHoverInformationControlManager;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.TextViewer;
import org.eclipse.jface.text.source.CompositeRuler;
import org.eclipse.jface.text.source.OverviewRuler;
import org.eclipse.jface.text.source.VerticalRuler;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

import org.eclipse.rcptt.tesla.core.am.AspectManager;
import org.eclipse.rcptt.tesla.swt.events.TeslaEventManager;

privileged public aspect TextViewerAspect {

	public TextViewerAspect() {
		AspectManager.activateAspect(JFaceTextAspectsActivator.PLUGIN_ID, this
				.getClass().getName());
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	StyledText around(TextViewer viewer):
		execution(StyledText org.eclipse.jface.text.TextViewer.createTextWidget(org.eclipse.swt.widgets.Composite, int)) 
		&& target(viewer) {
		StyledText result = proceed(viewer);
		try {
			JFaceTextManager.mapViewer(result, viewer);
		} catch (Throwable e) {
			JFaceTextAspectsActivator.log(e);
		}
		return result;
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	Control around(VerticalRuler ruler, Composite parent, ITextViewer viewer):
		execution(Control org.eclipse.jface.text.source.VerticalRuler.createControl(Composite, ITextViewer)) 
		&& target(ruler) && args(parent, viewer) {
		Control result = proceed(ruler, parent, viewer);
		try {
			JFaceTextManager.mapRuler(ruler, result, viewer);
		} catch (Throwable e) {
			JFaceTextAspectsActivator.log(e);
		}
		return result;
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	Control around(CompositeRuler ruler, Composite parent, ITextViewer viewer):
		execution(Control org.eclipse.jface.text.source.CompositeRuler.createControl(Composite, ITextViewer)) 
		&& target(ruler) && args(parent, viewer) {
		Control result = proceed(ruler, parent, viewer);
		try {
			JFaceTextManager.mapRuler(ruler, result, viewer);
		} catch (Throwable e) {
			JFaceTextAspectsActivator.log(e);
		}
		return result;
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	Control around(OverviewRuler ruler, Composite parent, ITextViewer viewer):
		execution(Control org.eclipse.jface.text.source.OverviewRuler.createControl(Composite, ITextViewer)) 
		&& target(ruler) && args(parent, viewer) {
		Control result = proceed(ruler, parent, viewer);
		try {
			JFaceTextManager.mapRuler(ruler, result, viewer);
		} catch (Throwable e) {
			JFaceTextAspectsActivator.log(e);
		}
		return result;
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	before(AbstractHoverInformationControlManager manager): execution(org.eclipse.jface.text.AbstractHoverInformationControlManager.new(..)) && target(manager) {
		JFaceTextManager.registerHoverManager(manager);
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	void around(int showStyle): 
		execution(void org.eclipse.jface.text.contentassist.ContentAssistant.AutoAssistListener.start(int)) 
		&& args(showStyle) {
		if (TeslaEventManager.getManager().hasListeners()) {
			return; // Ignore auto showing of proposals
		} else {
			proceed(showStyle);
		}
	}
}

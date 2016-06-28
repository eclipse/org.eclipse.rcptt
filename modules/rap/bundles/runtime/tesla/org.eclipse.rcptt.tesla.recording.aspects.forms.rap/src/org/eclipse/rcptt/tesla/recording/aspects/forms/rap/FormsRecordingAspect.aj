package org.eclipse.rcptt.tesla.recording.aspects.forms.rap;

import org.aspectj.lang.annotation.SuppressAjWarnings;
import org.eclipse.rcptt.tesla.core.am.rap.AspectManager;
import org.eclipse.ui.forms.widgets.ExpandableComposite;

public aspect FormsRecordingAspect {

	public FormsRecordingAspect() {
		AspectManager.activateAspect(RecordingFormsActivator.PLUGIN_ID, this
				.getClass().getName());
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	before(ExpandableComposite composite): execution(void org.eclipse.ui.forms.widgets.ExpandableComposite.toggleState()) && target(composite)  {
		try {
			FormsEventManager.clickOnExpandable(composite);
		} catch (Throwable e) {
			RecordingFormsActivator.log(e);
		}
	}

}

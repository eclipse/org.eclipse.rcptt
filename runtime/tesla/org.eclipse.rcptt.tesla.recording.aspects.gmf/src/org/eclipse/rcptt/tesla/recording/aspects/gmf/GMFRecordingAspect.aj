package org.eclipse.rcptt.tesla.recording.aspects.gmf;

import org.eclipse.rcptt.tesla.core.am.AspectManager;

public aspect GMFRecordingAspect {

	public GMFRecordingAspect() {
		AspectManager.activateAspect(RecordingGMFActivator.PLUGIN_ID, this
				.getClass().getName());
	}
}

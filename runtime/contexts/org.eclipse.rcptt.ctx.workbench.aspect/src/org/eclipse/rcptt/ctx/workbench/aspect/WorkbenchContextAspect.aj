package org.eclipse.rcptt.ctx.workbench.aspect;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import org.aspectj.lang.annotation.SuppressAjWarnings;


public aspect WorkbenchContextAspect {
	
	
	@SuppressWarnings("all")
	@SuppressAjWarnings("adviceDidNotMatch")
	before(org.eclipse.ui.internal.views.log.LogView logView)
		: execution(void org.eclipse.ui.internal.views.log.LogView.dispose()) && target(logView) {
		// clear Error Log entries to release allocated memory
		try {
			Field field = org.eclipse.ui.internal.views.log.LogView.class.getDeclaredField("elements");
			field.setAccessible(true);
			Object object = field.get(logView);
			if (object instanceof List) {
				((List<?>) object).clear();
			}
			
			field = org.eclipse.ui.internal.views.log.LogView.class.getDeclaredField("groups");
			field.setAccessible(true);
			object = field.get(logView);
			if (object instanceof Map) {
				((Map<?, ?>) object).clear();
			}
			
			field = org.eclipse.ui.internal.views.log.LogView.class.getDeclaredField("batchedEntries");
			field.setAccessible(true);
			object = field.get(logView);
			if (object instanceof List) {
				((List<?>) object).clear();
			}
		} catch (Throwable e) {
			Activator.log(e);
		}	
	}	
	
}

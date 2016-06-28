package org.eclipse.rcptt.tesla.swt.aspects.rap;

import org.aspectj.lang.annotation.SuppressAjWarnings;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Resource;
//import org.eclipse.swt.internal.ImageList;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.rcptt.tesla.core.am.rap.AspectManager;
import org.eclipse.rcptt.tesla.core.context.ContextManagement;
import org.eclipse.rcptt.tesla.core.context.ContextManagement.Context;
import org.eclipse.rcptt.tesla.swt.handles.HandleStore;

public aspect Handles {
	public Handles() {
		AspectManager.activateAspect(SWTAspectActivator.PLUGIN_ID, this
				.getClass().getName());
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	after(Widget widget): 
		execution(org.eclipse.swt.widgets.Widget.new(..)) && target(widget)  {
		Context context = ContextManagement.currentContext();
		HandleStore.getStore().registerWidget(widget, context);
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	before(Widget widget): 
		execution(void org.eclipse.swt.widgets.Widget.dispose()) && target(widget)  {
		HandleStore.getStore().releaseWidget(widget);
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	before(Widget widget):
		execution(void org.eclipse.swt.widgets.Widget.destroyWidget()) && target(widget) {
		HandleStore.getStore().releaseWidget(widget);
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	before(Widget widget):
		execution(void org.eclipse.swt.widgets.Widget.releaseWidget()) && target(widget) {
		HandleStore.getStore().releaseWidget(widget);
	}
	
	@SuppressAjWarnings("adviceDidNotMatch")
	before(Widget widget):
		execution(void org.eclipse.swt.widgets.Widget.releaseHandle()) && target(widget) {
		HandleStore.getStore().releaseWidget(widget);
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	after(Resource res): 
		execution(org.eclipse.swt.graphics.Resource.new(..)) && target(res)  {
		Context context = ContextManagement.currentContext();
		HandleStore.getStore().registerResource(res, context);
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	before(Resource res): 
		execution(void org.eclipse.swt.graphics.Resource.dispose()) && target(res)  {
		HandleStore.getStore().releaseResource(res);
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	before(Font res): 
		execution(void org.eclipse.swt.graphics.Font.destroy()) && target(res)  {
		HandleStore.getStore().releaseResource(res);
	}

//	after(org.eclipse.swt.internal.ImageList list, Image img):
//		execution(void org.eclipse.swt.internal.ImageList.add(Image)) && target(list) && args(img) {
//		HandleStore.getStore().releaseResource(img);
//	}

}

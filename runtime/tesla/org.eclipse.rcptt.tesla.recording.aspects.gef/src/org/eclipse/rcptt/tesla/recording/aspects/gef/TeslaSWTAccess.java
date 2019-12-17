/*******************************************************************************
 * Copyright (c) 2009, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.tesla.recording.aspects.gef;

import java.lang.reflect.Field;

import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.TypedListener;
import org.eclipse.swt.widgets.Widget;

public class TeslaSWTAccess {
	public static <T> T getThis(Class<T> clazz, Widget widget, int event) {
		Listener[] listeners = widget.getListeners(event);
		for (Listener listener : listeners) {
			Object lookFor = listener;
			if (listener instanceof TypedListener) {
				lookFor = ((TypedListener) listener).getEventListener();
			}
			try {
				Field this$0 = lookFor.getClass().getDeclaredField("this$0");
				this$0.setAccessible(true);
				Object viewer = this$0.get(lookFor);
				if (clazz.isInstance(viewer)) {
					return clazz.cast(viewer);
				}
			} catch (Throwable e) {
				// ignore exceptions
			}
		}
		return null;
	}
}

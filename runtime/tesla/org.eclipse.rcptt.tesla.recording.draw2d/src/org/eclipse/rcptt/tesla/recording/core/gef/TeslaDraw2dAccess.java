/*******************************************************************************
 * Copyright (c) 2009, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.tesla.recording.core.gef;

import java.lang.reflect.Field;

public class TeslaDraw2dAccess {

	static org.eclipse.draw2d.MouseEvent getCurrentEvent(Object widget) {
		Field this$0;
		try {
			Class<? extends Object> cl = widget.getClass();
			this$0 = cl.getDeclaredField("currentEvent");
			this$0.setAccessible(true);
			return (org.eclipse.draw2d.MouseEvent) this$0.get(widget);
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}
		// Search for Figure canvas and try to restore viewer
		catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}
		return null;
	}

}

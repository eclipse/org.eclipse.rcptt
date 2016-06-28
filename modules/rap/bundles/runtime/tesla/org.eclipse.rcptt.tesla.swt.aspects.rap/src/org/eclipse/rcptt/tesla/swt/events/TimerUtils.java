/*******************************************************************************
 * Copyright (c) 2009, 2016 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.tesla.swt.events;

import java.lang.reflect.Field;
import java.util.ArrayList;

import org.eclipse.swt.widgets.Display;

public class TimerUtils {
	public static Runnable[] getTimers(Display display) throws Exception {
		Field timerList = display.getClass().getDeclaredField("timerList");
		timerList.setAccessible(true);
		java.util.List<Runnable> result = new ArrayList<Runnable>();
		Runnable runnables[] = (Runnable[]) timerList.get(display);
		if (runnables != null) {
			for (Runnable runnable : runnables) {
				if (runnable != null) {
					result.add(runnable);
				}
			}
		}
		return result.toArray(new Runnable[result.size()]);
	}
}

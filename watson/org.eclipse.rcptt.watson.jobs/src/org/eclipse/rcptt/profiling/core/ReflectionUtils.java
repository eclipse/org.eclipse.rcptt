/*******************************************************************************
 * Copyright (c) 2009, 2014 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.profiling.core;

import java.lang.reflect.Field;

public class ReflectionUtils {
	public static Object getThis(Object lookFor) {
		try {
			Field this$0 = lookFor.getClass().getDeclaredField("this$0");
			this$0.setAccessible(true);
			return this$0.get(lookFor);
		} catch (Throwable e) {
			// ignore exceptions
		}
		return null;
	}
}

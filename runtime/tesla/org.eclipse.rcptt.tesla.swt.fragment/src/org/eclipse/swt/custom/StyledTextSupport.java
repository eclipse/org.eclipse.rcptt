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
package org.eclipse.swt.custom;

import java.lang.reflect.Field;

public class StyledTextSupport {
	public static boolean isCaretEvent(Object object, int type) {
		try {
			Class<? extends Object> classzz = object.getClass();
			Field field = classzz.getDeclaredField("CaretMoved");
			field.setAccessible(true);
			Integer value = (Integer) field.get(object);
			if (type == value.intValue()) {
				return true;
			}
		} catch (SecurityException e) {
			// e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}
		return false;
	}
}

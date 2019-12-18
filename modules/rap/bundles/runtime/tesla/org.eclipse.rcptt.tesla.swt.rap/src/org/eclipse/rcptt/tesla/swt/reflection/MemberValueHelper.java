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
package org.eclipse.rcptt.tesla.swt.reflection;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Widget;

import org.eclipse.rcptt.tesla.core.ui.PropertyNodeType;
import org.eclipse.rcptt.tesla.internal.ui.player.PlayerTextUtils;

public class MemberValueHelper {

	static PropertyNodeType detectType(Class<?> nativeType) {
		if (nativeType.isPrimitive()
				|| nativeType.equals(java.lang.Boolean.class)
				|| nativeType.equals(java.lang.Character.class)
				|| nativeType.equals(java.lang.Byte.class)
				|| nativeType.equals(java.lang.Short.class)
				|| nativeType.equals(java.lang.Integer.class)
				|| nativeType.equals(java.lang.Long.class)
				|| nativeType.equals(java.lang.Float.class)
				|| nativeType.equals(java.lang.Double.class)

				|| nativeType.equals(java.lang.String.class)
				|| nativeType.equals(java.lang.StringBuilder.class)
				|| nativeType.equals(java.lang.StringBuffer.class)

				|| nativeType.equals(org.eclipse.swt.graphics.Color.class)) {
			return PropertyNodeType.PROPERTY;
		}
		return PropertyNodeType.REFERENCE;
	}

	static String getFormattedValue(Object value, String memberName,
			Class<?> nativeType, Object container) {
		if (value == null) {
			if (PropertyNodeType.PROPERTY.equals(detectType(nativeType))) {
				return "";
			}
			return JavaMembersHelper.NULL_CONST;
		}
		if (nativeType.equals(org.eclipse.swt.graphics.Color.class)) {
			Color color = (Color) value;
			return String.format("#%02X%02X%02X", color.getRed(),
					color.getGreen(), color.getBlue());
		}
		if (memberName.equals("getStyle")
				&& container instanceof Widget
				&& (nativeType.equals(int.class) || nativeType
						.equals(Integer.class))) {
			int style = (Integer) value;
			int processedStyle = 0;
			String strStyle = "";
			for (SWTStyleConstantsData.StyleConstant styleConst : SWTStyleConstantsData.styleConstants) {
				for (Class<?> clazz : styleConst.getApplyedTo()) {
					if (clazz.isAssignableFrom(container.getClass())
							&& (style & styleConst.getValue()) != 0) {
						strStyle += strStyle.equals("") ? styleConst.getName()
								: ", " + styleConst.getName();
						processedStyle = processedStyle | styleConst.getValue();
						break;
					}
				}
				if (style == processedStyle) {
					break;
				}
			}
			if (style == processedStyle) {
				return "[" + strStyle + "]";
			}
		}
		String result = PlayerTextUtils.replaceMultilines(value.toString());
		// Escape control characters
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < result.length(); i++) {
			char charAt = result.charAt(i);
			if (Character.isISOControl(charAt) && charAt != '\n') {
				builder.append("\\").append(Integer.valueOf(charAt));
			} else {
				builder.append(charAt);
			}
		}
		return builder.toString();
	}

	static String getClassName(Object object) {
		if (object.getClass().isArray()) {
			return object.getClass().getComponentType().getName() + "[]";
		}
		return object.getClass().getName();
	}
}

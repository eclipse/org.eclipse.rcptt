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
package org.eclipse.rcptt.tesla.ecl.internal.impl;

import java.util.List;
import java.util.regex.Pattern;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.rcptt.util.TableTreeItemPathUtil;
import org.eclipse.rcptt.tesla.core.protocol.ElementKind;
import org.eclipse.rcptt.tesla.ecl.impl.rap.TeslaBridge;
import org.eclipse.rcptt.tesla.ecl.model.ControlHandler;
import org.eclipse.rcptt.tesla.ecl.model.TeslaFactory;
import org.eclipse.rcptt.tesla.ecl.model.Wrapper;

public class ServiceUtil {
	public static EObject wrap(Object o) {
		Wrapper wrapper = TeslaFactory.eINSTANCE.createWrapper();
		wrapper.setObject(o);
		return wrapper;
	}

	public static final Pattern IndexedSegmentPattern = Pattern
			.compile("(.*)%(\\d+)%");

	public static List<String> processSelectItems(Object item, String selectColumn)
			throws CoreException {

		List<String> result = null;

		if (item instanceof ControlHandler) {
			ControlHandler handler = (ControlHandler) item;
			if (handler.getKind() == ElementKind.Item) {
				result = TeslaBridge.parsePath(handler.getPath());
			}
		} else {
			result = TableTreeItemPathUtil.appendSegmentsColumnName(
					TeslaBridge.parsePath(item.toString()), selectColumn);
		}

		if (result == null) {
			throw TeslaImplPlugin.makeCoreException("Expected string or item.");
		}
		return result;
	}
}

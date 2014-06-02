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
package org.eclipse.rcptt.tesla.recording.core;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.rcptt.tesla.core.protocol.raw.Element;
import org.eclipse.rcptt.tesla.core.ui.PropertyNodeList;

public interface IRecordingHelper<T> {

	PropertyNodeList getNodeProperties(Element element, String nodePath)
			throws IllegalArgumentException, IllegalAccessException,
			InvocationTargetException;

	String getWidgetDetails(Element element);
}

/*******************************************************************************
 * Copyright (c) 2009, 2015 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.tesla.recording.core;

public interface IRecordingProcessorExtension {
	boolean isNotCanvas(Object widget, int type, Object event);

	boolean isIgnored(Object widget, int type, Object event);

	boolean isNotDraw2d(Object widget);

	/**
	 * Return true if widget is a part of parent widget
	 * 
	 * @param widget
	 * @param parent
	 * @return
	 */
	boolean isPartOfParent(Object widget, Object parent);
}

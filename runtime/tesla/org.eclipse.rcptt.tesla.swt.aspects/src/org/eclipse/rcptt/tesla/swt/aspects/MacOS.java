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
package org.eclipse.rcptt.tesla.swt.aspects;

import java.lang.reflect.Field;
import java.lang.Class;

public class MacOS {

	private static Class<?> fClassOS;
	
	private static Class<?> getClassOS() {
		if (fClassOS == null)
			try {
				fClassOS = Class.forName("org.eclipse.swt.internal.cocoa.OS");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} 
		return fClassOS;
	}
	
	private static final long getMacOSXEventCode(String eventId)
	{
		long eventCode = 0;
		try {
			Field field = getClassOS().getField(eventId);
			eventCode = field.getLong(getClassOS());
		} catch (Throwable e) {			
			e.printStackTrace();
		}
		return eventCode;
	}
	
	public static final long sel_mouseDown_ = getMacOSXEventCode("sel_mouseDown_");
	public static final long sel_mouseUp_ = getMacOSXEventCode("sel_mouseUp_");
	public static final long sel_keyDown_ = getMacOSXEventCode("sel_keyDown_");
	public static final long sel_keyUp_ = getMacOSXEventCode("sel_keyUp_");	
	public static final long sel_rightMouseDown_ = getMacOSXEventCode("sel_rightMouseDown_");
	public static final long sel_rightMouseUp_ = getMacOSXEventCode("sel_rightMouseUp_");
	public static final long sel_keyCode = getMacOSXEventCode("sel_keyCode");
	public static final long sel_mouseDragged_ = getMacOSXEventCode("sel_mouseDragged_");
	public static final long sel_mouseEntered_ = getMacOSXEventCode("sel_mouseEntered_");
	public static final long sel_mouseExited_ = getMacOSXEventCode("sel_mouseExited_");
	public static final long sel_mouseMoved_ = getMacOSXEventCode("sel_mouseMoved_");
	public static final long sel_rightMouseDragged_ = getMacOSXEventCode("sel_rightMouseDragged_");
	public static final long sel_otherMouseDown_ = getMacOSXEventCode("sel_otherMouseDown_");
	public static final long sel_otherMouseUp_ = getMacOSXEventCode("sel_otherMouseUp_");
	public static final long sel_otherMouseDragged_ = getMacOSXEventCode("sel_otherMouseDragged_");
	public static final long sel_hitPart = getMacOSXEventCode("sel_hitPart");
	public static final long sel_hitTest_ = getMacOSXEventCode("sel_hitTest_");
	public static final long sel_hitTestForEvent_inRect_ofView_ = getMacOSXEventCode("sel_hitTestForEvent_inRect_ofView_");
	public static final long sel_cut_ = getMacOSXEventCode("sel_cut_");
	public static final long sel_copy_ = getMacOSXEventCode("sel_copy_");
	public static final long sel_paste_ = getMacOSXEventCode("sel_paste_");
	public static final long sel_insertText_ = getMacOSXEventCode("sel_insertText_");
	public static final long sel_pageDown_ = getMacOSXEventCode("sel_pageDown_");
	public static final long sel_pageUp_ = getMacOSXEventCode("sel_pageUp_");
	public static final long sel_scrollWheel_ = getMacOSXEventCode("sel_scrollWheel_");
	public static final long sel_wheelDelta = getMacOSXEventCode("sel_wheelDelta");
	public static final long sel_windowWillClose_ = getMacOSXEventCode("sel_windowWillClose_");
	public static final long sel_windowShouldClose_ = getMacOSXEventCode("sel_windowShouldClose_");
	
}

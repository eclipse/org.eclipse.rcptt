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
package org.eclipse.rcptt.tesla.recording.aspects.draw2d;

import org.eclipse.draw2d.SWTEventDispatcher;
import org.eclipse.swt.events.MouseEvent;

public interface IDraw2DEventListener {
	public void mousePressed(SWTEventDispatcher disp, MouseEvent event);
	public void mouseReleased(SWTEventDispatcher disp, MouseEvent event);
	public void mouseMoved(SWTEventDispatcher disp, MouseEvent event);
	public void mouseEntered(SWTEventDispatcher disp, MouseEvent event);
	public void mouseExited(SWTEventDispatcher disp, MouseEvent event);
	public void mouseHover(SWTEventDispatcher disp, MouseEvent event);
	public void mouseDoubleClick(SWTEventDispatcher disp, MouseEvent event);
}

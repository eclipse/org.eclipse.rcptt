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
package org.eclipse.rcptt.tesla.ui.describers;

import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Widget;

public interface IWidgetDescriber {

	Display getDisplay();

	Widget getWidget();

	void redraw();

	// This is for asserts
	Rectangle getBounds();

	Point getPoint();

	Point getRealPoint();

	IWidgetDescriber getControl();

	Widget getItemWidget();

	Image captureImage();

	boolean supportsDND();
}

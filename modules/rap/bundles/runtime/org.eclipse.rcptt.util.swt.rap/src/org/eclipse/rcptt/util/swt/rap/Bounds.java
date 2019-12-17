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
package org.eclipse.rcptt.util.swt.rap;

import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;

public class Bounds {
	public static Point centerRel(Rectangle rect) {
		return new Point(rect.width / 2, rect.height / 2);
	}

	public static Point centerAbs(Rectangle rect) {
		return new Point(rect.x + rect.width / 2, rect.y + rect.height / 2);
	}
}

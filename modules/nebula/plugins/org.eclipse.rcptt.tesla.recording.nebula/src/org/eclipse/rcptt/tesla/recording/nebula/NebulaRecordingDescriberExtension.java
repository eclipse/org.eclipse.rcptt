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
package org.eclipse.rcptt.tesla.recording.nebula;

import org.eclipse.nebula.widgets.grid.Grid;
import org.eclipse.nebula.widgets.grid.GridItem;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Widget;

import org.eclipse.rcptt.tesla.recording.core.swt.IRecorderDescriberExtension;
import org.eclipse.rcptt.tesla.recording.core.swt.IRecordingDescriber;

public class NebulaRecordingDescriberExtension implements
		IRecorderDescriberExtension {

	public IRecordingDescriber getDescriber(Widget widget,
			IRecordingDescriber previous, int x, int y, boolean fromAssert) {
		if (!(widget instanceof Grid || widget instanceof GridItem))
			return previous;
		return getItemAt(new NebulaRecordingDescriber(widget), x, y, fromAssert);
	}

	private IRecordingDescriber getItemAt(IRecordingDescriber descr, int x,
			int y, boolean fromAssert) {
		Widget base = descr.getWidget();

		if (base instanceof GridItem) {
			return getItemAt(
					new NebulaRecordingDescriber(((GridItem) base).getParent()),
					x, y, fromAssert);
		}

		if (base instanceof Grid) {
			Grid grid = (Grid) base;
			GridItem item = grid.getItem(new Point(x, y));
			if (item != null)
				return new NebulaRecordingDescriber(item);
			else
				return new NebulaRecordingDescriber(grid);
		}

		return descr;
	}

}

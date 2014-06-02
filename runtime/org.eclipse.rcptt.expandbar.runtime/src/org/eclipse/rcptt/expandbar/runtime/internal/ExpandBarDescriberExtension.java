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
package org.eclipse.rcptt.expandbar.runtime.internal;

import static org.eclipse.rcptt.expandbar.runtime.internal.ExpandBarUtil.getItemHeaderBounds;
import static org.eclipse.rcptt.expandbar.runtime.internal.ExpandBarUtil.isRelatedWidget;

import org.eclipse.swt.widgets.ExpandBar;
import org.eclipse.swt.widgets.ExpandItem;
import org.eclipse.swt.widgets.Widget;

import org.eclipse.rcptt.tesla.recording.core.swt.IRecorderDescriberExtension;
import org.eclipse.rcptt.tesla.recording.core.swt.IRecordingDescriber;

public class ExpandBarDescriberExtension implements IRecorderDescriberExtension {

	@Override
	public IRecordingDescriber getDescriber(Widget widget, IRecordingDescriber previous, int x, int y,
			boolean fromAssert) {
		if (!isRelatedWidget(widget)) {
			return previous;
		}

		if (widget instanceof ExpandItem) {
			return getItemDescriber((ExpandItem) widget);
		}

		ExpandBar bar = (ExpandBar) widget;

		for (ExpandItem item : bar.getItems()) {
			if (getItemHeaderBounds(item).contains(x, y)) {
				return getItemDescriber(item);
			}
		}
		return getBarDescriber(bar);
	}

	private IRecordingDescriber getItemDescriber(ExpandItem item) {
		return new ExpandItemRecordingDescriber(item);
	}

	private IRecordingDescriber getBarDescriber(ExpandBar bar) {
		return new ExpandBarRecordingDescriber(bar);
	}

}

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
package org.eclipse.rcptt.tesla.recording.core.swt;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.Widget;

/**
 * This class can be extended by implementation of IWidgetClassifierExtension interface in the case when you need some
 * widget to be handled (while recording) like a standard widget.
 * <p>
 * See <code>NebulaWidgetClassifierExtension</code> class for an example.
 */
public class WidgetClassifier {

	public static boolean isAColumn(Widget widget) {
		for (IWidgetClassifierExtension ext : getExtensions())
			if (ext.canClassify(widget))
				return ext.isAColumn(widget);

		return (widget instanceof TreeColumn) || (widget instanceof TableColumn);
	}

	// More classification methods are to be added here...
	// In the case of large number of classifications, the methods should be replaced by comparable type values.


	//

	private static List<IWidgetClassifierExtension> getExtensions() {
		List<IWidgetClassifierExtension> result = new ArrayList<IWidgetClassifierExtension>();
		for (IWidgetLocatorExtension wle : SWTRecordingHelper.getHelper().getLocator().extensions) {
			IWidgetClassifierExtension ext = wle.getWidgetClassifierExtension();
			if (ext != null)
				result.add(ext);
		}
		return result;
	}

}

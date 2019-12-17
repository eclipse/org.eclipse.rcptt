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
package org.eclipse.rcptt.tesla.recording.nebula;

import org.eclipse.nebula.widgets.grid.GridColumn;
import org.eclipse.swt.widgets.Widget;

import org.eclipse.rcptt.tesla.recording.core.swt.IWidgetClassifierExtension;

public class NebulaWidgetClassifierExtension implements IWidgetClassifierExtension {

	@Override
	public boolean canClassify(Widget widget) {
		return (widget instanceof GridColumn);
	}

	@Override
	public boolean isAColumn(Widget widget) {
		return (widget instanceof GridColumn);
	}

}

/*******************************************************************************
 * Copyright (c) 2009, 2016 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.tesla.recording.core.swt.rap;

import org.eclipse.swt.widgets.Widget;

import org.eclipse.rcptt.tesla.internal.ui.player.FindResult;
import org.eclipse.rcptt.tesla.internal.ui.player.SWTUIElement;

public interface IWidgetLocatorExtension {

	/**
	 * Extends widget locator findElement functionality.
	 * <p>
	 * CAUTION: Now (1 Aug 2013) the extensions are used only from the
	 * findMenuItem method.
	 * 
	 * @see SWTWidgetLocator#findElement(SWTUIElement, boolean, boolean,
	 *      boolean)
	 * @see SWTWidgetLocator#findElement(Widget, boolean, boolean, boolean)
	 */
	FindResult findElement(SWTUIElement widget, boolean unknownAllowed,
			boolean alwaysFindLeaf, boolean supportEclipseWorkbench);

	/**
	 * In case when some custom widget should be handled as some default widget, this method can be used.
	 * <p>
	 * See {@link WidgetClassifier} class for details.
	 */
	IWidgetClassifierExtension getWidgetClassifierExtension();

}

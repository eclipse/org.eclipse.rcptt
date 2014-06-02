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
package org.eclipse.rcptt.tesla.swt.events;

import org.eclipse.rcptt.tesla.core.context.ContextManagement.Context;
import org.eclipse.rcptt.tesla.swt.events.TeslaEventManager.HasEventKind;

public interface ITeslaEventListener {
	/**
	 * Called then sleep are going to be performed.
	 * 
	 * @param currentContext
	 * @param isContextChanged
	 */
	boolean doProcessing(Context currentContext);

	void hasEvent(HasEventKind hasEventKind, String name);
}

/*******************************************************************************
 * /*******************************************************************************
 *  * Copyright (c) 2009, 2019 Xored Software Inc and others.
 *  * All rights reserved. This program and the accompanying materials
 *  * are made available under the terms of the Eclipse Public License v1.0
 *  * which accompanies this distribution, and is available at
 *  * https://www.eclipse.org/legal/epl-v20.html
 *  *
 *  * Contributors:
 *  *     Xored Software Inc - initial API and implementation and/or initial documentation
 *  *******************************************************************************/
package org.eclipse.rcptt.tesla.swt.js;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 *
 * @author Artem Kovalev
 */
public class JavaScriptExecutionManager {

	private static JavaScriptExecutionManager manager;

	public static JavaScriptExecutionManager getManager()
	{
		if(manager == null){
			manager = new JavaScriptExecutionManager();
		}
		return manager;
	}

	private final AtomicBoolean stoped = new AtomicBoolean(false);

	public  void stop()
	{
		stoped.set(true);
	}

	public  void start()
	{
		stoped.set(false);
	}

	public  boolean isActive()
	{
		return !stoped.get();
	}

}

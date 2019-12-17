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
package org.eclipse.rcptt.tesla.core.protocol;

public interface IWindowProvider {
	static final String FROM_PATH_MARK = "-from";
	static final String CLASS_PATH_MARK = "-class";
	//

	WindowUIElement window();

	WindowUIElement window(String pattern);

	WindowUIElement window(String pattern, int index);

	WindowUIElement fromedWindow(String from);

	WindowUIElement fromedWindow(String from, int index);

	WindowUIElement classedWindow(String klass);

	WindowUIElement classedWindow(String klass, int index);
}

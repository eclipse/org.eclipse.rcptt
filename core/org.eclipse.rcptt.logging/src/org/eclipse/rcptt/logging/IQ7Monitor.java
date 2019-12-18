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
package org.eclipse.rcptt.logging;

import java.io.File;

public interface IQ7Monitor extends StatusListener {
	void log(String message, Throwable e);

	void log(String message);

	String getId();

	String getPrefix();

	void close();

	void putChild(IQ7Monitor result);

	String getFile();

	File getRootFolder();

	public static interface IQ7LogListener {
		void added(String message);
	}

	public void addListener(IQ7LogListener listener);

	public void removeListener(IQ7LogListener listener);
}

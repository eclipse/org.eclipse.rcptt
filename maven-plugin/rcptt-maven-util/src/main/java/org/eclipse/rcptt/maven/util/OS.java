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
package org.eclipse.rcptt.maven.util;

public enum OS {
	WIN("win32", "win32"),
	LINUX("linux", "gtk"),
	MACOSX("macosx", "cocoa");
	
	public final String os;
	public final String ws;
	public final String classifier;
	private OS(String os, String ws) {
		this.os = os;
		this.ws = ws;
		this.classifier = String.format("%s.%s", os, ws);
	}
}

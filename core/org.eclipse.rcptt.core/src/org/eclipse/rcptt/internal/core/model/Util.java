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
package org.eclipse.rcptt.internal.core.model;

import java.io.File;

import org.eclipse.core.internal.resources.OS;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;

public class Util {
	public static int combineHashCodes(int hashCode1, int hashCode2) {
		return hashCode1 * 17 + hashCode2;
	}

	public static String convert(String label) {
		char[] newLabel = new char[label.length()];
		for (int i = 0; i < label.length(); i++) {
			char ch = label.charAt(i);
			newLabel[i] = replaceChar(ch);
		}
		return new String(newLabel);
	}

	public static boolean isValidName(IContainer container, String name) {
		IFile file = container.getFile(new Path(name));
		if (file.exists())
			return false;
		try {
			IPath path = file.getLocation();
			if (path != null) {
				File fFile = path.toFile();
				if (fFile.exists())
					return false;
			}
		} catch (Exception e) {
			// ignore any problem
		}
		return true;
	}

	public static char replaceChar(char ch) {
		char[] chars = OS.INVALID_RESOURCE_CHARACTERS;
		if (ch == '.')
			return '_';
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == ch) {
				return '_';
			}
		}
		return ch;
	}
}

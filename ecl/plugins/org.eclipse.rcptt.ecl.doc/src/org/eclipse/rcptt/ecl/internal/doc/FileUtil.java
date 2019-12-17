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
package org.eclipse.rcptt.ecl.internal.doc;

import java.io.IOException;
import java.io.InputStreamReader;

import org.eclipse.rcptt.ecl.doc.EclDocPlugin;

public class FileUtil {

	public static String readFileAsString(String file) throws IOException {
		InputStreamReader reader = null;
		try {
			reader = new InputStreamReader(EclDocPlugin.getDefault()
					.getBundle().getResource(file).openStream(), "UTF-8");
			char[] buf = new char[8192];
			int read = 0;
			StringBuilder sb = new StringBuilder();
			while ((read = reader.read(buf)) != -1) {
				sb.append(buf, 0, read);
			}
			return sb.toString();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
				}
			}

		}
	}

}

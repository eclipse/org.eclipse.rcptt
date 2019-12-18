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
package org.eclipse.rcptt.core.persistence;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.eclipse.rcptt.util.FileUtil;

public class FileUtils {

	@Deprecated
	public static byte[] getStreamContent(InputStream stream)
			throws IOException {
		return FileUtil.getStreamContent(stream);
	}

	@Deprecated
	public static void deleteFiles(File[] listFiles) {
		FileUtil.deleteFiles(listFiles);
	}

	public static void copy(InputStream content, OutputStream outputStream)
			throws IOException {
		FileUtil.copy(content, outputStream);
	}

	public static String limitSize(String id) {
		return FileUtil.limitSize(id);
	}

}

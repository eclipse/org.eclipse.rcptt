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
import java.io.IOException;
import java.util.logging.FileHandler;

public class FileQ7Monitor extends BaseFileQ7Monitor implements IQ7Monitor {
	private File file;

	public FileQ7Monitor(File file) {
		this.file = file;
		reinit();
	}

	@Override
	protected FileHandler getFileHandle() throws IOException {
		return new FileHandler(file.getAbsolutePath() + "_%g.log",
				getLogFileSize(), getLogFileCount(), true);
	}

	@Override
	protected String getFailMessage() {
		return "Failed to write to log:" + this.file.getAbsolutePath();
	}

	public File getRootFolder() {
		return file;
	}

	public String getId() {
		return file.getName();
	}

	public String getPrefix() {
		return null;
	}

	public void putChild(IQ7Monitor result) {
	}

	public String getFile() {
		return file.getAbsolutePath();
	}
}

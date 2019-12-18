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
import java.util.HashSet;
import java.util.Set;
import java.util.logging.FileHandler;

public class ConfigurableFileQ7Monitor extends BaseFileQ7Monitor implements
		IQ7Monitor {
	private String id;
	private String prefix;
	private File file;
	private String fileID;
	private Set<IQ7Monitor> childs = new HashSet<IQ7Monitor>();

	public ConfigurableFileQ7Monitor(String id, String prefix, File file,
			String name) {
		this.fileID = Q7LoggingManager.getID(name);
		this.id = id;
		this.prefix = prefix;
		this.file = file;
		reinit();
	}

	@Override
	protected FileHandler getFileHandle() throws IOException {
		File logFile = new File(file, fileID);
		return new FileHandler(logFile.getAbsolutePath() + "_%g.log",
				getLogFileSize(), getLogFileCount(), true);
	}

	public String getId() {
		return id;
	}

	public String getPrefix() {
		return prefix;
	}

	@Override
	protected String getFailMessage() {
		return "Failed to write to log:" + this.file.getAbsolutePath() + ":"
				+ fileID;
	}

	public void close() {
		super.close();
		for (IQ7Monitor child : childs) {
			child.close();
		}
		childs.clear();
		Q7LoggingManager.getManager().remove(this);
	}

	public void putChild(IQ7Monitor result) {
		childs.add(result);
	}

	public String getFile() {
		return new File(file, fileID).getAbsolutePath();
	}

	public File getRootFolder() {
		return file;
	}
}

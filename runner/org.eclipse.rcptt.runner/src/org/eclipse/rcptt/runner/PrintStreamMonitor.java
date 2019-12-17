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
package org.eclipse.rcptt.runner;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.rcptt.core.persistence.plain.IPlainConstants;

public class PrintStreamMonitor implements IProgressMonitor {

	private boolean isCanceled;
	private String prefix;
	private OutputStreamWriter out;
	private boolean stdoutDulicate = false;
	private String previousOutLine = "";

	public PrintStreamMonitor(boolean stdoutDuplicate) {
		this.prefix = "";
		this.stdoutDulicate = stdoutDuplicate;
	}

	public PrintStreamMonitor() {
		this.prefix = "";
		this.stdoutDulicate = false;
	}

	public PrintStreamMonitor(String prefix, File file) {
		this.prefix = prefix;
		if (file != null) {
			try {
				out = new OutputStreamWriter(new BufferedOutputStream(new FileOutputStream(file)),
						IPlainConstants.ENCODING);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void beginTask(String name, int totalWork) {
		if (name != null) {
			try {
				if (out != null) {
					out.write("Begin task: " + prefix + name + "\n"); //$NON-NLS-1$ //$NON-NLS-2$
					out.flush();
				}
				if (stdoutDulicate && filter(name)) {
					System.out.println("Begin task: " + prefix + name); //$NON-NLS-1$
					previousOutLine = name;
				}
			} catch (Throwable e) {

			}
		}
	}

	/**
	 * Perform a filtering and return true if line is accepted.
	 */
	private boolean filter(String name) {
		String nameVal = name.trim();
		if (nameVal.equals(previousOutLine)) {
			return false;
		}
		if (nameVal.length() == 0) {
			return false;
		}
		if (nameVal.contains("1 operation remaining.")) { //$NON-NLS-1$
			return false;
		}
		if (nameVal.contains("from platform:///plugin/org.eclipse.rcptt.updates.")) { //$NON-NLS-1$
			return false;
		}
		if (nameVal.contains("Fetching org.eclipse.rcptt") || nameVal.contains("Downloading org.eclipse.rcptt")) {
			return false;
		}
		return true;
	}

	private void print(String name) {
		if (name != null) {
			try {
				if (out != null) {
					out.write("progress: " + prefix + name + "\n"); //$NON-NLS-1$ //$NON-NLS-2$
					out.flush();
				}
				if (stdoutDulicate && filter(name)) {
					System.out.println("progress: " + prefix + name); //$NON-NLS-1$
					previousOutLine = name;
				}
			} catch (Throwable e) {

			}
		}
	}

	public void done() {
	}

	public void internalWorked(double work) {
	}

	public boolean isCanceled() {
		return isCanceled;
	}

	public void setCanceled(boolean value) {
		isCanceled = value;
	}

	public void setTaskName(String name) {
		print(name);
	}

	public void subTask(String name) {
		print(name);
	}

	public void worked(int work) {
	}
}

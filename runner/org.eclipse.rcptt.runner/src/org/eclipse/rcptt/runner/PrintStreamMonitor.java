/*******************************************************************************
 * Copyright (c) 2009, 2015 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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

	public PrintStreamMonitor() {
		this.prefix = "";
	}

	public PrintStreamMonitor(String prefix, File file) {
		this.prefix = prefix;
		if (file != null) {
			try {
				out = new OutputStreamWriter(new BufferedOutputStream(
						new FileOutputStream(file)), IPlainConstants.ENCODING);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void beginTask(String name, int totalWork) {
		if (name != null && out != null) {
			try {
				out.write("Begin task: " + prefix + name + "\n");
				out.flush();
			} catch (Throwable e) {

			}
		}
	}

	private void print(String name) {
		if (name != null && out != null) {
			try {
				out.write("progress: " + prefix + name + "\n");
				out.flush();
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

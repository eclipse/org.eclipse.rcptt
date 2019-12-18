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
package org.eclipse.rcptt.sherlock.core.streams;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.eclipse.rcptt.sherlock.core.SherlockCore;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Report;

public class SherlockReportSession {
	int index = 0;
	private File root;

	public SherlockReportSession(File root) {
		this.root = root;
		this.root.mkdirs();
	}

	/**
	 * Return access identifier
	 * 
	 * @param report
	 * @return
	 */
	public String write(Report report) {
		String postfix = "";
		if (report.getRoot().getName() != null) {
			postfix = SherlockCore.rlimitSize(
					SherlockCore.getID(report.getRoot().getName()), 10);
		}
		String id = "" + String.format("%04d", index) + "_" + postfix
				+ ".report";
		index++;
		try {
			SherlockReportFormat.storeReport(report, new BufferedOutputStream(
					new FileOutputStream(new File(root, id))), true);
		} catch (IOException e) {
			SherlockCore.log(e);
			return null;
		}
		return id;
	}

	public Report getReport(String id) {
		File file = new File(root, id);
		if (!file.exists()) {
			return null;
		}
		try {
			return SherlockReportFormat.loadReport(new BufferedInputStream(
					new FileInputStream(file)), true, true);
		} catch (IOException e) {
			SherlockCore.log(e);
		}
		return null;
	}

	public void dispose() {
		File[] listFiles = root.listFiles();
		dispose(listFiles);
		root.delete();
	}

	private void dispose(File[] listFiles) {
		if (listFiles == null) {
			return;
		}
		for (File file : listFiles) {
			if (file.isDirectory()) {
				dispose(file.listFiles());
			}
			file.delete();
		}
	}

	public void reinit() {
		dispose();
		root.mkdirs();
	}
}
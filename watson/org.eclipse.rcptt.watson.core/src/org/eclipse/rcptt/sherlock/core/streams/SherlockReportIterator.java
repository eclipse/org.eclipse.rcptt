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
package org.eclipse.rcptt.sherlock.core.streams;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.eclipse.rcptt.sherlock.core.SherlockCore;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Report;

/**
 * This class is designed to be used as reader of Q7 test execution reports,
 * accumulated in one Q7.report file.
 * 
 * Usage:
 * 
 * <code>
 * SherlockReportIterator reports = new SherlockReportIterator(new
 * File("q7.report"));
 * reports.reset();
 * while(reports.hasNext()) {
 * 	Report report = reports.next();
 * 	// Dome some actions against report object.
 * }
 * reports.close(); // Close file input stream at the end.
 * </code>
 * 
 */
public class SherlockReportIterator {
	private ZipInputStream zin;
	ZipEntry currentEntry;
	private File reportFile;

	/**
	 * Construct report iterator based on existing file object.
	 * 
	 * To load reports from some custom input, please use
	 * <code>SherlockReportFormat</code>
	 * 
	 * @param file
	 *            - q7.report file.
	 */
	public SherlockReportIterator(File file) {
		this.reportFile = file;
		reset();
	}

	/**
	 * Reset current iterator and start from begining.
	 */
	public void reset() {
		if (zin != null) {
			try {
				zin.close();
			} catch (IOException e) {
				SherlockCore.log(e);
			}
		}
		try {
			this.zin = new ZipInputStream(new BufferedInputStream(
					new FileInputStream(reportFile)));
			currentEntry = zin.getNextEntry();
		} catch (IOException e) {
			SherlockCore.log(e);
		}
	}

	/**
	 * Check for next report are exists.
	 * 
	 * @return true if report exists, false otherwise.
	 */
	public boolean hasNext() {
		return currentEntry != null;
	}

	/**
	 * Read and load next execution report.
	 * 
	 * @return Report object if report build be loaded.
	 */
	public Report next() {
		try {
			if( currentEntry.getName().equals("ResourceContents")) {
				// This is one report report file.
				Report report = SherlockReportFormat.loadReport(zin, false, false);
				currentEntry = null;
				return report;
			}
			Report report = SherlockReportFormat.loadReport(zin, false, true);
			currentEntry = zin.getNextEntry();
			return report;
		} catch (Throwable e) {
			SherlockCore.log(e);
			currentEntry = null;
		}
		return null;
	}

	/**
	 * Close previously opened iteration.
	 */
	public void close() {
		currentEntry = null;
		try {
			if (zin != null) {
				zin.close();
			}
		} catch (Throwable e) {
			SherlockCore.log(e);
		}
	}

	/**
	 * Return report file specified in constructor.
	 * 
	 * @return report file.
	 */
	public File getReportFile() {
		return reportFile;
	}
};

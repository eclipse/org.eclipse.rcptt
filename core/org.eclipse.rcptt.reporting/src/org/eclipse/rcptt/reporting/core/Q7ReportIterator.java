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
package org.eclipse.rcptt.reporting.core;

import java.io.File;
import java.util.Iterator;
import java.util.NoSuchElementException;

import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Report;
import org.eclipse.rcptt.sherlock.core.streams.SherlockReportIterator;

public class Q7ReportIterator extends SherlockReportIterator implements
		Iterable<Report> {

	public Q7ReportIterator(File file) {
		super(file);
	}

	public Iterator<Report> iterator() {
		reset();

		return new Iterator<Report>() {

			
			public boolean hasNext() {
				return Q7ReportIterator.this.hasNext();
			}

			
			public Report next() {
				if (!hasNext()) {
					throw new NoSuchElementException();
				}
				return Q7ReportIterator.this.next();
			};

			
			public void remove() {
				throw new UnsupportedOperationException();
			}
		};

	}

}

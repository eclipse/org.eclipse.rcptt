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
package org.eclipse.rcptt.sherlock.core.reporting;

/**
 * Interface to provide events to Report
 */
public interface IEventProvider {
	/**
	 * Register builder as event listener.
	 */
	void addListener(IReportBuilder builder);

	/**
	 * Remove builder from listeners
	 */
	void removeListener(IReportBuilder builder);

	/**
	 * Store specified information snapshot (static data) into report
	 */
	void storeSnapshot(IReportBuilder builder, String type);
}

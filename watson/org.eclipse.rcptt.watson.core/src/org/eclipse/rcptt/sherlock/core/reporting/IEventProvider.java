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
package org.eclipse.rcptt.sherlock.core.reporting;

import org.eclipse.rcptt.sherlock.core.INodeBuilder;

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
	void storeSnapshot(INodeBuilder builder);
}

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
package org.eclipse.rcptt.sherlock.core;

public interface IEventProviders {
	public static final String LOG_EVENT_PROVIDER = "org.eclipse.rcptt.sherlock.core.log.provider";
	public static final String JOBS_INFO_PROVIDER = "org.eclipse.rcptt.sherlock.jobs.info.provider";
	public static final String TESLA_INFO_PROVIDER = "org.eclipse.rcptt.tesla.ecl.iml.info.provider";
	public static final String ECL_COMMAND_EVENT_PROVIDER = "org.eclipse.rcptt.core.ecl.core.ecl.provider";
	public static final String JFACE_LOG_EVENT_PROVIDER = "org.eclipse.rcptt.sherlock.core.jface.log.provider";
}

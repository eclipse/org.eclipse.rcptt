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
package org.eclipse.rcptt.launching;

import java.util.List;
import java.util.Map;

import org.eclipse.rcptt.internal.core.model.Q7TestCase;
import org.eclipse.rcptt.internal.launching.ExecutionSession;
import org.eclipse.rcptt.internal.launching.ecl.EclScenarioExecutable;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Report;

public interface ITestEngine {

	/**
	 * @deprecated Use {@link #executionStarted}
	 */
	@Deprecated
	public void testRunStarted(Map<String, String> config, List<Q7TestCase> tests);

	/** To be extracted into a separate interface */
	public void setConfiguration(Map<String, String> config);

	/** To be extracted into a separate interface */
	public Map<String, String> getConfiguration();
	
	public void testRunCompleted();

	public void sessionStarted(ExecutionSession session);

	public void sessionCompleted(ExecutionSession session);

	public void executionStarted(EclScenarioExecutable scenario, Map<String, String> config);

	public void executionCompleted(EclScenarioExecutable scenario, Report report);

	public String validateParameter(String paramName, String paramValue);

}

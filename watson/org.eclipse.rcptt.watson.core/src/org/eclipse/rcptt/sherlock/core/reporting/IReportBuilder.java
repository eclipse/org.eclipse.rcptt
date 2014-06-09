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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.rcptt.sherlock.core.INodeBuilder;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.EventSource;

public interface IReportBuilder {

	/**
	 * Register new event source
	 */
	public EventSource registerEventSource(String name);


//	/**
//	 * Return current report. Direct operations are not thread safe.
//	 */
//	public Report getReport();

	
//	/**
//	 * Works with current node. Proper synchronizations are applied.
//	 * @param procedure
//	 */
//	public void withCurrentNode(Procedure1<Node> procedure);


	/**
	 * Store snapshot using following event provider. 'id' used for prefix
	 * match.
	 * 
	 * So if we have providers: 'a.b.c', 'a.b', 'a.d'
	 * 
	 * and pass id as 'a.b' then 'a.b.c' and 'a.b' will be selected.
	 * 
	 * 
	 */
	public void takeSnapshot(String type, String... id);

	public EventSource findSource(String attr, EObject info);


	/**
	 * Works with current node. Proper synchronizations are applied.
	 */
	INodeBuilder getCurrent();
}
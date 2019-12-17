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
package org.eclipse.rcptt.sherlock.core.reporting;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.rcptt.sherlock.core.INodeBuilder;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.EventSource;

public interface IReportBuilder {

	/**
	 * Register new event source
	 */
	public EventSource registerEventSource(String name);

	public EventSource findSource(String attr, EObject info);


	/**
	 * Works with current node. Proper synchronizations are applied.
	 */
	INodeBuilder getCurrent();
}
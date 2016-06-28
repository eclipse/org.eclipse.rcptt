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
package org.eclipse.rcptt.sherlock.core;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Event;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.LoggingCategory;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Node;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Snaphot;
import org.eclipse.rcptt.sherlock.core.reporting.Procedure1;

public interface INodeBuilder {
	/**
	 * Add subnode to current one and make it active.
	 */
	public INodeBuilder beginTask(String name);

	/**
	 * End current task and go level up
	 */
	public void endTask();
	
	/**
	 * Create new event in current structure model
	 */
	public void createEvent(Event event);

	/**
	 * Create snapshot instance and add it to current node.
	 * 
	 * @return
	 */
	//public void createSnapshot(EObject data, Map<String, EObject> properties);

	/*
	 * Add or append existing log entry into current node.
	 */
	void appendLog(LoggingCategory category, String text);

	void setProperty(String key, EObject value);

	EObject getProperty(String key);

	/**
	 * Returns the parent node, or {@code null} if this is a root node.
	 */
	INodeBuilder getParent();

	void addSnapshot(Snaphot snapshot);
	
	/** Direct node access
	 * Provides synchronized node access
	 * Should not be used (might cause reference leaks to unsynchronized contexts). 
	 * */
	@Deprecated
	void update(Procedure1<Node> runnable);
	
}

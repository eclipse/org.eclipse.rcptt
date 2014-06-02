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
package org.eclipse.rcptt.core;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.rcptt.core.scenario.Context;

/**
 * Context processor
 */
public interface IContextProcessor {

	public boolean isApplied(Context context);

	/**
	 * Apply context
	 * 
	 * @param context
	 * @return
	 * @throws CoreException
	 */
	public void apply(Context context) throws CoreException;

	/**
	 * Create context from the current environment
	 * 
	 * @return
	 * @throws CoreException
	 */
	public Context create(EObject param) throws CoreException;

}

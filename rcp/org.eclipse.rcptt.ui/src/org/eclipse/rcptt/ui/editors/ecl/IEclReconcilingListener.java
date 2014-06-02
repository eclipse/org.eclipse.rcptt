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
package org.eclipse.rcptt.ui.editors.ecl;

import org.eclipse.core.runtime.IProgressMonitor;

import org.eclipse.rcptt.core.model.IQ7NamedElement;

public interface IEclReconcilingListener {

	/**
	 * Called before reconciling is started.
	 */
	void aboutToBeReconciled();

	void reconciled(IQ7NamedElement ast, boolean forced,
			IProgressMonitor progressMonitor);
}

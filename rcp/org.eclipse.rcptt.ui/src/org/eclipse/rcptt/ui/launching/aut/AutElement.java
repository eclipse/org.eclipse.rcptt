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
package org.eclipse.rcptt.ui.launching.aut;

import org.eclipse.core.runtime.CoreException;

import org.eclipse.rcptt.internal.launching.aut.Q7LaunchValidatorManager;
import org.eclipse.rcptt.launching.Aut;

public class AutElement {

	private final Aut aut;

	public AutElement(Aut aut) {
		this.aut = aut;
	}

	public Aut getAut() {
		return aut;
	}

	public String getName() {
		return aut.getName();
	}

	/**
	 * Check if element is launched.
	 */
	boolean isLaunched() {
		return false;
	}

	/**
	 * Check if element could be launched.
	 */
	boolean couldBeLaunched() {
		// TODO: Some configuration could not be launched.
		return true;
	}

	/**
	 * Return true if element could be stopped.
	 */
	boolean couldBeStopped() {
		return false;
	}

	public boolean isValid() {
		return Q7LaunchValidatorManager.isValid(aut.getConfig());
	}

	public void remove() throws CoreException {
		aut.getConfig().delete();
	}

	public void stop() {
	}

}

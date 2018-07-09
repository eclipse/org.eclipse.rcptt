/*******************************************************************************
 * Copyright (c) 2009, 2016 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 * 	Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.launching.multiaut;

import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.model.search.Q7SearchCore;
import org.eclipse.rcptt.launching.Aut;
import org.eclipse.rcptt.launching.AutManager;


public class ResolvedEntry {
	private ResolvedEntry(IQ7NamedElement element, Aut aut, boolean restart) {
		this.element = element;
		this.aut = aut;
		this.restart = restart;
	}

	public final IQ7NamedElement element;
	public final Aut aut;
	public final boolean restart;

	public boolean isOK() {
		return element != null && aut != null;
	}

	public static ResolvedEntry resolve(LaunchStoreEntry entry) {
		return new ResolvedEntry(entry.testId == null ? null : Q7SearchCore.findById(entry.testId),
				AutManager.INSTANCE.getByName(entry.autName), entry.restart);
	}
}
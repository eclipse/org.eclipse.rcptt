/*******************************************************************************
 * Copyright (c) 2009, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *  
 * Contributors:
 * 	Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.launching.multiaut.ui;

import java.util.List;

import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.model.ModelException;
import org.eclipse.rcptt.core.model.search.Q7SearchCore;
import org.eclipse.rcptt.launching.Aut;
import org.eclipse.rcptt.launching.AutManager;
import org.eclipse.rcptt.launching.multiaut.LaunchStoreEntry;

public class LaunchUIEntry {
	private LaunchUIEntry(IQ7NamedElement element, Aut aut, boolean restart, LaunchStoreEntry sourceEntry) {
		this.element = element;
		this.aut = aut;
		this.restart = restart;
		this.sourceEntry = sourceEntry;
	}

	public final IQ7NamedElement element;
	public Aut aut;
	public boolean restart;

	/**
	 * May be null, used only for better error displaying
	 */
	protected LaunchStoreEntry sourceEntry;

	public static LaunchUIEntry fromStoreEntry(LaunchStoreEntry entry) {
		if (entry.testId == null) {
			MultiAutUIPlugin.logWarn("Entry with null id stored in multi aut launch config, ignoring");
			return null;
		}
		IQ7NamedElement element = Q7SearchCore.findById(entry.testId);
		Aut aut = AutManager.INSTANCE.getByName(entry.autName);

		if (element == null) {
			return new LaunchUIEntry(null, aut, entry.restart, entry);
		}
		return new LaunchUIEntry(element, aut, entry.restart, entry);
	}

	public static LaunchUIEntry fromNamedElement(IQ7NamedElement element) {
		return new LaunchUIEntry(element, defaultAut(), false, null);
	}

	private static Aut defaultAut() {
		List<Aut> auts = AutManager.INSTANCE.getAuts();
		return auts.size() == 0 ? null : auts.get(0);
	}

	public LaunchStoreEntry toStoreEntry() {
		try {
			return new LaunchStoreEntry(element.getID(), aut.getName(), restart);
		} catch (ModelException e) {
			MultiAutUIPlugin.logErr(e, "Model exception while getting id from element '%s'", element.getName());
			return null;
		}

	}

	public String getTestName() {
		return element == null ? "Unresolved" : element.getName();
	}

	public String getAutName() {
		if (aut != null) {
			return aut.getName();
		}
		if (sourceEntry.autName == null) {
			return "";
		}
		return sourceEntry.autName;
	}
}

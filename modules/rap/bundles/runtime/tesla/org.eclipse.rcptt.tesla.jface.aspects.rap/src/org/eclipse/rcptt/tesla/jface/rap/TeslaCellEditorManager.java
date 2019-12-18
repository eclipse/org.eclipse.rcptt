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
package org.eclipse.rcptt.tesla.jface.rap;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.jface.viewers.CellEditor;

public class TeslaCellEditorManager {
	private static TeslaCellEditorManager manager = null;
	private Set<CellEditor> directEditManagers = new HashSet<CellEditor>();
	private boolean markNewAsForced = false;
	private CellEditor lastActivated = null;

	private CellEditor lastActivatedByAnyMethod = null;

	public CellEditor getLastActivatedByAnyMethod() {
		return lastActivatedByAnyMethod;
	}

	public synchronized static TeslaCellEditorManager getInstance() {
		if (manager == null) {
			manager = new TeslaCellEditorManager();
		}
		return manager;
	}

	public synchronized void addManager(CellEditor mgr) {
		directEditManagers.add(mgr);
		lastActivatedByAnyMethod = mgr;
		if (markNewAsForced) {
			lastActivated = mgr;
		}
	}

	public synchronized boolean removeManager(CellEditor mgr) {
		directEditManagers.remove(mgr);
		return true;
	}

	public synchronized CellEditor[] getEditors() {
		List<CellEditor> toRemove = new ArrayList<CellEditor>();
		for (CellEditor cellEditor : directEditManagers) {
			if (cellEditor.getControl() != null
					&& cellEditor.getControl().isDisposed()) {
				toRemove.add(cellEditor);
			}
		}
		directEditManagers.removeAll(toRemove);
		return directEditManagers.toArray(new CellEditor[directEditManagers
				.size()]);
	}

	public void forceRemove(CellEditor manager2) {
		directEditManagers.remove(manager2);
	}

	public synchronized void makeNewAsForced(boolean b) {
		this.markNewAsForced = b;
		lastActivated = null;
	}

	public CellEditor getLastActivated() {
		return lastActivated;
	}

	public synchronized void clean() {
		this.directEditManagers.clear();
		lastActivated = null;
	}

	public boolean isInActivation() {
		return this.markNewAsForced;
	}
}

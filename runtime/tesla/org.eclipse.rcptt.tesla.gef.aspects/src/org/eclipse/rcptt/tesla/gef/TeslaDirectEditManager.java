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
package org.eclipse.rcptt.tesla.gef;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.gef.tools.DirectEditManager;

public class TeslaDirectEditManager {
	private static TeslaDirectEditManager manager = null;
	private List<DirectEditManager> directEditManagers = new ArrayList<DirectEditManager>();
	private Set<DirectEditManager> teslaActivated = new HashSet<DirectEditManager>();

	public synchronized static TeslaDirectEditManager getInstance() {
		if (manager == null) {
			manager = new TeslaDirectEditManager();
		}
		return manager;
	}

	public synchronized void addManager(DirectEditManager mgr) {
		directEditManagers.add(mgr);
	}

	public synchronized boolean removeManager(DirectEditManager mgr) {
		if (!teslaActivated.contains(mgr)) {
			directEditManagers.remove(mgr);
			return true;
		}
		return false;
	}

	public synchronized DirectEditorContainer[] getEditors() {
		DirectEditorContainer[] containers = new DirectEditorContainer[directEditManagers
				.size()];
		for (int i = 0; i < containers.length; i++) {
			containers[i] = new DirectEditorContainer(directEditManagers.get(i));
		}
		return containers;
	}
	public void clean() {
		teslaActivated.clear();

	}

	public synchronized void forceRemove(DirectEditManager manager2) {
		teslaActivated.remove(manager2);
		directEditManagers.remove(manager2);
	}

	public synchronized void forceEdit(DirectEditManager manager2) {
		teslaActivated.add(manager2);
		DirectEditorContainer ctr = new DirectEditorContainer(manager2);
		ctr.removeListeners();
	}

	public boolean contains(DirectEditManager manager) {
		return false;
	}
}

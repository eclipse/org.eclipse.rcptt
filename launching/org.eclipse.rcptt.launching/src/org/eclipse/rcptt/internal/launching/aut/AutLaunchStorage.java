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
package org.eclipse.rcptt.internal.launching.aut;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.debug.core.ILaunch;
import org.eclipse.rcptt.launching.AutLaunch;
import org.eclipse.rcptt.launching.AutLaunchState;
import org.eclipse.rcptt.launching.IQ7Launch;

/**
 * Thread-safe AUT launch storage with quick access by id and ILaunch
 */
public class AutLaunchStorage {

	public synchronized List<AutLaunch> getAll() {
		filterTerminated();
		return new ArrayList<AutLaunch>(launches);
	}

	public synchronized void add(BaseAutLaunch launch) {
		launches.add(launch);
		byId.put(launch.getId(), launch);
		byLaunch.put(launch.getLaunch(), launch);
		List<BaseAutLaunch> list = byAut.get(launch.getAut());
		if (list == null) {
			list = new ArrayList<BaseAutLaunch>();
			byAut.put(launch.getAut(), list);
		}
		list.add(launch);
	}

	public synchronized boolean remove(BaseAutLaunch launch) {
		byId.remove(launch.getId());
		byLaunch.remove(launch.getLaunch());
		List<BaseAutLaunch> list = byAut.get(launch.getAut());
		if (list != null) {
			list.remove(launch);
			if (list.isEmpty()) {
				byAut.remove(launch.getAut());
			}
		}
		return launches.remove(launch);
	}

	public synchronized void replaceLaunch(BaseAutLaunch aut,
			ILaunch newLaunch, ILaunch oldLaunch) {
		byLaunch.remove(oldLaunch);
		byLaunch.put(newLaunch, aut);
	}

	public synchronized BaseAutLaunch removeByLaunch(ILaunch config) {
		BaseAutLaunch aut = getByLaunch(config);
		if (aut != null) {
			remove(aut);
		}
		return aut;
	}

	public synchronized List<AutLaunch> getByAut(BaseAut aut) {
		filterTerminated();
		List<BaseAutLaunch> list = byAut.get(aut);
		if (list == null) {
			return Collections.emptyList();
		}
		return new ArrayList<AutLaunch>(list);
	}

	public synchronized BaseAutLaunch getCurrent(BaseAut aut) {
		filterTerminated();
		List<BaseAutLaunch> list = byAut.get(aut);
		if (list != null && list.size() > 0) {
			return list.get(list.size() - 1);
		}
		return null;
	}

	public synchronized BaseAutLaunch getById(String id) {
		return byId.get(id);
	}

	public synchronized BaseAutLaunch getByLaunch(ILaunch launch) {
		BaseAutLaunch baseAutLaunch = byLaunch.get(launch);
		if (baseAutLaunch != null) {
			return baseAutLaunch;
		}
		String id = launch.getAttribute(IQ7Launch.ATTR_AUT_ID);
		if (id != null) {
			return byId.get(id);
		}
		return null;
	}

	private void filterTerminated() {
		List<BaseAutLaunch> terminated = new ArrayList<BaseAutLaunch>();
		for (BaseAutLaunch launch : launches) {
			if (launch.getState() == AutLaunchState.TERMINATE) {
				terminated.add(launch);
			}
		}
		for (BaseAutLaunch launch : terminated) {
			remove(launch);
		}
	}

	private List<BaseAutLaunch> launches = new ArrayList<BaseAutLaunch>();
	private Map<String, BaseAutLaunch> byId = new HashMap<String, BaseAutLaunch>();
	private Map<ILaunch, BaseAutLaunch> byLaunch = new HashMap<ILaunch, BaseAutLaunch>();
	private Map<BaseAut, List<BaseAutLaunch>> byAut = new HashMap<BaseAut, List<BaseAutLaunch>>();

}

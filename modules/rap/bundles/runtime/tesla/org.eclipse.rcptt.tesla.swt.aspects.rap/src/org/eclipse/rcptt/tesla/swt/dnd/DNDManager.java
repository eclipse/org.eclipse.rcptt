/*******************************************************************************
 * Copyright (c) 2009, 2016 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.tesla.swt.dnd;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.dnd.DragSource;
import org.eclipse.swt.dnd.DropTarget;

import org.eclipse.rcptt.util.ListUtil;
import org.eclipse.rcptt.util.Predicate;

public class DNDManager {
	private static DNDManager manager;
	private List<WeakReference<DropTarget>> targets = new ArrayList<WeakReference<DropTarget>>();
	private List<WeakReference<DragSource>> sources = new ArrayList<WeakReference<DragSource>>();

	public synchronized static DNDManager getInstance() {
		if (manager == null) {
			manager = new DNDManager();
		}
		return manager;
	}

	public void addTarget(final DropTarget target) {
		synchronized (targets) {
			targets.add(new WeakReference<DropTarget>(target));
		}
	}

	public List<DropTarget> getTargets() {
		synchronized (targets) {
			final List<DropTarget> result = new ArrayList<DropTarget>();
			ListUtil.excludeInPlace(targets,
					new Predicate<WeakReference<DropTarget>>() {
						public boolean apply(WeakReference<DropTarget> input) {
							DropTarget dropTarget = input.get();
							if (dropTarget != null
									&& dropTarget.getControl() != null) {
								result.add(dropTarget);
								return false;
							}
							return true;
						}
					});
			return result;
		}
	}

	public List<DragSource> getSources() {
		final List<DragSource> result = new ArrayList<DragSource>();
		ListUtil.excludeInPlace(sources,
				new Predicate<WeakReference<DragSource>>() {
					public boolean apply(WeakReference<DragSource> input) {
						DragSource dragSource = input.get();
						if (dragSource != null
								&& dragSource.getControl() != null) {
							result.add(dragSource);
							return false;
						}
						return true;
					}
				});
		return result;
	}

	public void addSource(final DragSource source) {
		synchronized (sources) {
			sources.add(new WeakReference<DragSource>(source));
		}
	}
}

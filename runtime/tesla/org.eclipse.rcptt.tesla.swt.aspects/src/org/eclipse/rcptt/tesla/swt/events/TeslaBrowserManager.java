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
package org.eclipse.rcptt.tesla.swt.events;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.swt.browser.Browser;

import org.eclipse.rcptt.util.ListUtil;
import org.eclipse.rcptt.util.Predicate;
import org.eclipse.rcptt.tesla.swt.aspects.SWTAspectActivator;

public class TeslaBrowserManager {
	private static TeslaBrowserManager manager = new TeslaBrowserManager();
	private Set<ITeslaBrowserListener> listeners = new HashSet<ITeslaBrowserListener>();
	private Set<WeakReference<Browser>> browsers = new HashSet<WeakReference<Browser>>();

	private TeslaBrowserManager() {
	}

	public static TeslaBrowserManager getManager() {
		return manager;
	}

	public void addEventListener(ITeslaBrowserListener listener) {
		synchronized (listeners) {
			this.listeners.add(listener);
		}
	}

	public void removeEventListener(ITeslaBrowserListener listener) {
		synchronized (listeners) {
			this.listeners.remove(listener);
		}
	}

	public void clearListeners() {
		synchronized (listeners) {
			this.listeners.clear();
		}
	}

	public void notifyAdded(Browser br) {
		List<ITeslaBrowserListener> copy = getListeners();
		for (ITeslaBrowserListener listener : copy) {
			listener.browserAdded(br);
		}
	}

	private List<ITeslaBrowserListener> getListeners() {
		List<ITeslaBrowserListener> copy = null;
		synchronized (listeners) {
			copy = new ArrayList<ITeslaBrowserListener>(listeners);
		}
		return copy;
	}

	public boolean hasListeners() {
		synchronized (listeners) {
			return !listeners.isEmpty();
		}
	}

	public void addBrowser(final Browser browser) {
		try {
			if (browser != null && !browser.isDisposed()) {
				synchronized (browsers) {
					browsers.add(new WeakReference<Browser>(browser));
				}
				notifyAdded(browser);
			}
		} catch (Throwable e) {
			SWTAspectActivator.log(e);
		}
	}

	public Browser[] getBrowsers() {
		synchronized (browsers) {
			final List<Browser> result = new ArrayList<Browser>();
			ListUtil.excludeInPlace(browsers,
					new Predicate<WeakReference<Browser>>() {
						public boolean apply(WeakReference<Browser> input) {
							Browser browser = input.get();
							if (browser != null && !browser.isDisposed()) {
								result.add(browser);
								return false;
							}
							return true;
						}
					});
			return (Browser[]) result.toArray(new Browser[result.size()]);
		}
	}

	public synchronized void browserSetText(Browser browser) {
		List<ITeslaBrowserListener> copy = getListeners();
		for (ITeslaBrowserListener listener : copy) {
			listener.browserSetText(browser);
		}
	}

	public void beginChanging(Browser browser) {
		List<ITeslaBrowserListener> copy = getListeners();
		for (ITeslaBrowserListener listener : copy) {
			listener.browserChanged(browser);
		}
	}
}

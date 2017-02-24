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
package org.eclipse.rcptt.tesla.core.am;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.CopyOnWriteArrayList;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleException;

public class AspectManager {

	/**
	 * Contain bundle to list of activated Aspects map
	 */
	private static Map<String, List<String>> aspectBundleActivationState = new HashMap<String, List<String>>();
	private static CopyOnWriteArrayList<AspectListener> listeners = new CopyOnWriteArrayList<AspectListener>();

	public static synchronized void activateBundle(String bundle) {
		if (!aspectBundleActivationState.containsKey(bundle)) {
			aspectBundleActivationState.put(bundle, new ArrayList<String>());
		}
	}

	public static void activateAspect(String bundle, String aspect) {
		addAspect(bundle, aspect);
		if (Activator.getDefault() != null && Activator.getDefault().LOGGING) {
			System.out.println("Tesla: Activate aspect in bundle:" + bundle
					+ " aspect:" + aspect);
		}
		for (AspectListener listener : listeners) {
			listener.activated(bundle, aspect);
		}
	}

	public static synchronized Collection<BundleAspects> getAspects() {
		List<BundleAspects> result = new ArrayList<BundleAspects>();
		for (Entry<String, List<String>> e : aspectBundleActivationState
				.entrySet()) {
			result.add(new BundleAspects(e.getKey(), new ArrayList<String>(e
					.getValue())));
		}
		return result;
	}

	public static void addListener(AspectListener listener) {
		listeners.add(listener);
	}

	public static void removeListener(AspectListener listener) {
		listeners.remove(listener);
	}

	public static void printInfo() {
		if (Activator.getDefault() != null && Activator.getDefault().LOGGING) {
			// System.out.println("Tesla aspects information...");
			for (BundleAspects ba : getAspects()) {
				if (ba.getAspects().isEmpty()) {
					System.out.print("Bundle: " + ba.getBundle());
					if (ba.getAspects().isEmpty()) {
						System.out.println();
						System.out.println("\t No Aspects are activated...");
					} else {
						System.out.println();
						for (String aspect : ba.getAspects()) {
							System.out.println("\t" + aspect);
						}
					}
				}
			}
		}
	}

	public static IStatus initialize() {
		Bundle bundle = Platform.getBundle("org.eclipse.rcptt.tesla.swt.aspects");
		if (bundle != null && bundle.getState() != Bundle.ACTIVE) {
			try {
				bundle.start(0);
			} catch (BundleException e) {
				Activator.log(e);
			}
		}
		long stTime = System.currentTimeMillis();
		if (bundle != null && bundle.getState() != Bundle.ACTIVE) {
			while (stTime + 50 * 1000 > System.currentTimeMillis()) {
				if (bundle.getState() != Bundle.ACTIVE) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						continue;
					}
				} else {
					// Wait 2 seconds to be sure activation are completed.
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
					}
					break;
				}
			}
		}
		if (bundle != null && bundle.getState() != Bundle.ACTIVE) {
			Status st = new Status(
					Status.ERROR,
					Activator.PLUGIN_ID,
					700,
					"RCPTT aspects plugin \"org.eclipse.rcptt.tesla.swt.aspects\" could not be activated. Could not continue...",
					null);
			Activator.getDefault().getLog().log(st);
			return st;
		}

		// Check aspectj weaving are initialized correctly
		if (!isAspectsInitialized()) {
			Status st = new Status(
					Status.ERROR,
					Activator.PLUGIN_ID,
					700,
					"RCPTT aspects plugin \"org.eclipse.rcptt.tesla.swt.aspects\" is not initialized. Could not continue...",
					null);
			Activator.getDefault().getLog().log(st);
			return st;
		}
		return Status.OK_STATUS;
	}

	private static synchronized void addAspect(String bundle, String aspect) {
		activateBundle(bundle);
		aspectBundleActivationState.get(bundle).add(aspect);
	}

	private static synchronized boolean isAspectsInitialized() {
		List<String> swtAspectBundle = aspectBundleActivationState
				.get("org.eclipse.rcptt.tesla.swt.aspects");
		return swtAspectBundle != null && !swtAspectBundle.isEmpty();
	}
}

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
package org.eclipse.rcptt.tesla.jface;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.text.reconciler.AbstractReconciler;

public class TextReconcilerManager {

	private static TextReconcilerManager instance;
	private List<WeakReference<AbstractReconciler>> reconcilers = new ArrayList<WeakReference<AbstractReconciler>>();

	public synchronized static TextReconcilerManager getInstance() {
		if (instance == null) {
			instance = new TextReconcilerManager();
		}
		return instance;
	}

	public synchronized void newReconciler(AbstractReconciler reconciler) {
		reconcilers.add(new WeakReference<AbstractReconciler>(reconciler));
	}

	public synchronized List<AbstractReconciler> getReconcilers() {
		ArrayList<AbstractReconciler> result = new ArrayList<AbstractReconciler>();
		for (WeakReference<AbstractReconciler> reconciler : reconcilers) {
			if (reconciler.get() != null) {
				result.add(reconciler.get());
			}
		}
		return result;
	}
}

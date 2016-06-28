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
package org.eclipse.rcptt.tesla.jface.databinding.observable.aspects.rap;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.observable.Realm;

public class DatabindingObservableManager {

	private static DatabindingObservableManager instance;
	private List<WeakReference<Realm>> realms = new ArrayList<WeakReference<Realm>>();

	public synchronized static DatabindingObservableManager getInstance() {
		if (instance == null) {
			instance = new DatabindingObservableManager();
		}
		return instance;
	}

	public synchronized void newRealm(Realm realm) {
		realms.add(new WeakReference<Realm>(realm));
	}

	public synchronized List<Realm> getRealms() {
		ArrayList<Realm> result = new ArrayList<Realm>();
		for (WeakReference<Realm> realm : realms) {
			if (realm.get() != null) {
				result.add(realm.get());
			}
		}
		return result;
	}
}

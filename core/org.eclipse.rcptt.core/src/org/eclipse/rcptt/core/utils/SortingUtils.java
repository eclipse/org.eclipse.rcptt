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
package org.eclipse.rcptt.core.utils;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.model.ModelException;
import org.eclipse.rcptt.core.model.search.Q7SearchCore;
import org.eclipse.rcptt.internal.core.RcpttPlugin;

public class SortingUtils {

	public static void sortNamedElements(List<? extends IQ7NamedElement> elements) {
		Collections.sort(elements, new Comparator<IQ7NamedElement>() {
			public int compare(IQ7NamedElement o1, IQ7NamedElement o2) {
				int diff = o1.getName().compareTo(o2.getName());
				if (diff != 0)
					return diff;
				try {
					String id1 = Q7SearchCore.findIDByDocument(o1);
					if (id1 == null)
						id1 = o1.getID();
					String id2 = Q7SearchCore.findIDByDocument(o2);
					if (id2 == null)
						id2 = o2.getID();
					return id1.compareTo(id2);
				} catch (ModelException e) {
					RcpttPlugin.log(e);
				}
				return -1;
			}
		});
	}
}

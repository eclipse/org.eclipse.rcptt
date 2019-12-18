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
package org.eclipse.rcptt.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListUtil {

	public static <T> List<T> filter(Iterable<? extends T> input,
			Predicate<T> predicate) {
		List<T> result = new ArrayList<T>();
		for (T element : input) {
			if (predicate.apply(element)) {
				result.add(element);
			}
		}
		return result;
	}

	public static <T> void excludeInPlace(Iterable<T> input,
			Predicate<T> predicate) {
		Iterator<T> iterator = input.iterator();
		while (iterator.hasNext()) {
			if (predicate.apply(iterator.next())) {
				iterator.remove();
			}
		}
	}

	//

	public static <T> Iterable<T> reverse(final List<T> input) {
		return new Iterable<T>() {
			@Override
			public Iterator<T> iterator() {
				return new Iterator<T>() {

					int i = input.size() - 1;

					@Override
					public boolean hasNext() {
						return i >= 0;
					}

					@Override
					public T next() {
						return input.get(i--);
					}

					@Override
					public void remove() {
						throw new UnsupportedOperationException();
					}

				};
			}
		};
	}

}

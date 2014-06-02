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
package org.eclipse.rcptt.util;

public class Predicates {
	public static <T> Predicate<T> not(final Predicate<T> predicate) {
		return new Predicate<T>() {
			public boolean apply(T input) {
				return !predicate.apply(input);
			}
		};
	}

	public static <T> Predicate<T> and(final Predicate<T>... predicates) {
		return new Predicate<T>() {
			public boolean apply(T input) {
				for (Predicate<T> predicate : predicates) {
					if (!predicate.apply(input)) {
						return false;
					}
				}
				return true;
			}
		};
	}

	public static <T> Predicate<T> or(final Predicate<T>... predicates) {
		return new Predicate<T>() {
			public boolean apply(T input) {
				for (Predicate<T> predicate : predicates) {
					if (predicate.apply(input)) {
						return true;
					}
				}
				return false;
			}
		};
	}

	public static <T> Predicate<T> ife(final Predicate<T> cond, final Predicate<T> t, final Predicate<T> f) {
		return new Predicate<T>() {
			public boolean apply(T input) {
				return cond.apply(input) ? t.apply(input) : f.apply(input);
			}
		};
	}

}

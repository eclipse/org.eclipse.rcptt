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
package org.eclipse.rcptt.tesla.recording.core.swt.peg;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.rcptt.util.ObjectUtil;
import org.eclipse.rcptt.util.Predicate;
import org.eclipse.rcptt.tesla.core.protocol.raw.Command;

public class FeaturePredicate implements Predicate<Command> {
	private final Object expected;
	private final EStructuralFeature[] features;

	public FeaturePredicate(Object expected, EStructuralFeature[] features) {
		this.expected = expected;
		this.features = features;
	}

	public boolean apply(Command input) {
		Object[] value = getFeature(input, features);
		if (value.length == 0) {
			return false;
		}

		return equal(expected, value[0]);
	}

	public static boolean equal(Object o1, Object o2) {
		if (o1 instanceof EObject && o2 instanceof EObject) {
			return EcoreUtil.equals((EObject) o1, (EObject) o2);
		}
		return ObjectUtil.equal(o1, o2);
	}

	public static Object[] getFeature(Object input, EStructuralFeature[] chain) {
		Object value = input;
		for (EStructuralFeature feature : chain) {
			if (!(value instanceof EObject)) {
				return new Object[0];
			}
			value = ((EObject) value).eGet(feature);
		}
		return new Object[] { value };
	}
}
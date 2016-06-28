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

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.rcptt.tesla.core.protocol.raw.Command;

public class FeaturesEqPredicate extends TwoCommandsPredicate {
	private final EStructuralFeature[] features;

	public FeaturesEqPredicate(EStructuralFeature[] features) {
		this.features = features;
	}

	@Override
	protected boolean apply(Command c1, Command c2) {
		Object[] value1 = FeaturePredicate.getFeature(c1, features);
		Object[] value2 = FeaturePredicate.getFeature(c2, features);
		if (value1.length == 0 || value2.length == 0) {
			return false;
		}
		return FeaturePredicate.equal(value1[0], value2[0]);
	}

}

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
package org.eclipse.rcptt.launching.ext.tests;

import org.junit.Assert;
import org.junit.Test;

import org.eclipse.rcptt.launching.ext.BundleStart;

public class BundleStartTest {
	@Test
	public void testQS2313() {
		verifyBundleStart("default:true", ":start");
		verifyBundleStart("default:true", "start");
	}

	@Test
	public void testPositive() {
		verifyBundleStart("1:true", "1:start");
		verifyBundleStart("1:default", "1");
		verifyBundleStart("default:default", "");
	}

	private static void verifyBundleStart(String expectedModel, String inputOsgi) {
		Assert.assertEquals(expectedModel, BundleStart
				.fromOsgiString(inputOsgi).toModelString());
	}
}

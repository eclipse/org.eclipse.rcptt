/*******************************************************************************
 * Copyright (c) 2009, 2016 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 * 	Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.tesla.jface.aspects.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.eclipse.rcptt.tesla.jface.DescriptorInfo;
import org.junit.Test;

public class DescriptorInfoTest {

	@Test
	public void testInvalid() {
		String str = "<invalid>";
		assertNull(DescriptorInfo.BUNDLE_URL.extract(str));
		assertNull(DescriptorInfo.ABSOLUTE_URL.extract(str));
		assertNull(DescriptorInfo.FILE_CLASS.extract(str));
	}

	@Test
	public void testBundleResource() {
		String str = "URLImageDescriptor(bundleresource://5724.fwk1864311781:1/icons/icon.png)";
		assertEquals("unknownBundle/icons/icon.png", DescriptorInfo.BUNDLE_URL.extract(str));
	}

	@Test
	public void testBundleEntry() {
		String str = "URLImageDescriptor(bundleentry://562.fwk1873444284/icons/full/eview16/filenav_nav.gif)";
		assertEquals("org.eclipse.rcptt.verifications.tree/icons/full/eview16/filenav_nav.gif",
				DescriptorInfo.BUNDLE_URL.extract(str));
	}

	@Test
	public void testAbsolutePath() {
		String str = "URLImageDescriptor(file:/C:/rcptt/icons/icon.png)";
		assertEquals("C:/rcptt/icons/icon.png", DescriptorInfo.ABSOLUTE_URL.extract(str));
	}

	@Test
	public void testPlatformPlugin() {
		String str = "URLImageDescriptor(platform:/plugin/org.eclipse.rcptt/icons/scroll_lock.png)";
		assertEquals("org.eclipse.rcptt/icons/scroll_lock.png", DescriptorInfo.ABSOLUTE_URL.extract(str));
	}

	@Test
	public void testFileClass() {
		String str = "FileImageDescriptor(location=class org.eclipse.jface.action.StatusLine, name=images/stop.gif)";
		assertEquals("org.eclipse.jface.action.StatusLineimages/stop.gif", DescriptorInfo.FILE_CLASS.extract(str));
	}

}

package org.eclipse.rcptt.tesla.jface.aspects.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.eclipse.rcptt.tesla.jface.DescriptorInfo;
import org.junit.Test;

public class DescriptorInfoTest {

	@Test
	public void testFail() {
		String str = "UndefinedDescriptor()";
		assertFalse(DescriptorInfo.isValid(str));
		assertEquals("UndefinedDescriptor()", DescriptorInfo.getInfo(str));
	}

	@Test
	public void testBundleResource() {
		String str = "URLImageDescriptor(bundleresource://5724.fwk1864311781:1/icons/icon.png)";
		assertTrue(DescriptorInfo.isValid(str));
		assertEquals("unknownBundle/icons/icon.png", DescriptorInfo.getInfo(str));
	}

	@Test
	public void testBundleEntry() {
		String str = "URLImageDescriptor(bundleentry://562.fwk1873444284/icons/full/eview16/filenav_nav.gif)";
		assertTrue(DescriptorInfo.isValid(str));
		assertEquals("org.eclipse.rcptt.verifications.tree/icons/full/eview16/filenav_nav.gif",
				DescriptorInfo.getInfo(str));
	}

	@Test
	public void testAbsolutePath() {
		String str = "URLImageDescriptor(file:/C:/rcptt/icons/icon.png)";
		assertTrue(DescriptorInfo.isValid(str));
		assertEquals("C:/rcptt/icons/icon.png", DescriptorInfo.getInfo(str));
	}

	@Test
	public void testPlatformPlugin() {
		String str = "URLImageDescriptor(platform:/plugin/org.eclipse.rcptt/icons/scroll_lock.png)";
		assertTrue(DescriptorInfo.isValid(str));
		assertEquals("org.eclipse.rcptt/icons/scroll_lock.png", DescriptorInfo.getInfo(str));
	}

	@Test
	public void testFileClass() {
		String str = "FileImageDescriptor(location=class org.eclipse.jface.action.StatusLine, name=images/stop.gif)";
		assertTrue(DescriptorInfo.isValid(str));
		assertEquals("org.eclipse.jface.action.StatusLineimages/stop.gif", DescriptorInfo.getInfo(str));
	}

}

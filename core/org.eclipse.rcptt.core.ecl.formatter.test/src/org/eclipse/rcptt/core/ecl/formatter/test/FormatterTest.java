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
package org.eclipse.rcptt.core.ecl.formatter.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import org.eclipse.rcptt.core.ecl.formatter.EclFormatter;
import org.eclipse.rcptt.core.ecl.formatter.EclFormatterOptions;

public class FormatterTest {

	@Test(expected = IllegalArgumentException.class)
	public void testNull() {
		new EclFormatter().format(null);
	}

	@Test()
	public void testEmpty() {
		assertEquals("", new EclFormatter().format(""));
	}

	@Test()
	public void testNoArgs() {
		EclFormatter f = new EclFormatter(
				new EclFormatterOptions().wrapAt(8));
		assertEquals("cmd-a |\n\t\tcmd-b", f.format("cmd-a | cmd-b"));
		assertEquals("a | b", f.format("a | b"));
		assertEquals("a\nb", f.format("a\nb"));
	}

	@Test()
	public void testSmallWrap() {
		EclFormatter f = new EclFormatter(
				new EclFormatterOptions().wrapAt(2));
		assertEquals("cmd-a |\n\t\tcmd-b", f.format("cmd-a | cmd-b"));
	}

	@Test()
	public void testBoolArgs() {
		EclFormatter f = new EclFormatter(
				new EclFormatterOptions().wrapAt(8));
		assertEquals("cmd -arg", f.format("cmd -arg"));
		assertEquals("cmd\n\t\t-arg1\n\t\t-arg2", f.format("cmd -arg1 -arg2"));
	}

	@Test()
	public void testArgs() {
		EclFormatter f = new EclFormatter(
				new EclFormatterOptions().wrapAt(8));
		assertEquals("cmd -a 1", f.format("cmd -a 1"));
		assertEquals("cmd -a 1\n\t\t-b 2", f.format("cmd -a 1 -b 2"));

		assertEquals("cmd -a", f.format("cmd\n-a"));
		assertEquals("cmd -a 1", f.format("cmd\n-a 1"));
		assertEquals("cmd 1", f.format("cmd\n1"));
	}

	@Test
	public void testPipeline() {
		EclFormatter f = new EclFormatter(
				new EclFormatterOptions().wrapAt(8));
		assertEquals("a | a", f.format("a|\na"));
	}
}

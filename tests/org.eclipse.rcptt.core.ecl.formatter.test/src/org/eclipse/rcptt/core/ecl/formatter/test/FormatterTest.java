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
package org.eclipse.rcptt.core.ecl.formatter.test;

import static org.junit.Assert.assertEquals;

import org.eclipse.rcptt.core.ecl.formatter.EclFormatter;
import org.eclipse.rcptt.core.ecl.formatter.EclFormatterOptions;
import org.junit.Test;

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
		assertEquals("cmd-a\n\t\t| cmd-b", f.format("cmd-a | cmd-b"));
		assertEquals("a | b", f.format("a | b"));
		assertEquals("a\nb", f.format("a\nb"));
	}

	@Test()
	public void testSmallWrap() {
		EclFormatter f = new EclFormatter(
				new EclFormatterOptions().wrapAt(2));
		assertEquals("cmd-a\n\t\t| cmd-b", f.format("cmd-a | cmd-b"));
	}

	@Test()
	public void testBigWrap() {
		EclFormatter f = new EclFormatter(
				new EclFormatterOptions().wrapAt(80));
		assertEquals("cmd-a | cmd-b", f.format("cmd-a | cmd-b"));
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

	@Test()
	public void testSmallIndent() {
		EclFormatter f2 = new EclFormatter(new EclFormatterOptions().wrapAt(8).indent(2).wrapIndent(2));
		EclFormatter f4 = new EclFormatter(new EclFormatterOptions().wrapAt(8).indent(4).wrapIndent(4));
		assertEquals("cmd-a\n  | cmd-b", f2.format("cmd-a | cmd-b"));
		assertEquals("cmd-a\n\t| cmd-b", f4.format("cmd-a | cmd-b"));
	}

	@Test()
	public void testBigIndent() {
		EclFormatter f = new EclFormatter(new EclFormatterOptions().wrapAt(8).indent(16).wrapIndent(16));
		assertEquals("cmd-a\n\t\t\t\t| cmd-b\n\t\t\t\t| cmd-c", f.format("cmd-a | cmd-b | cmd-c"));
	}

}

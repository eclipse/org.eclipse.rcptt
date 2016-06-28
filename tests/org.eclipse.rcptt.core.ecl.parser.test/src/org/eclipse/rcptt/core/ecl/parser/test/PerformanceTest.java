/*******************************************************************************
 * Copyright (c) 2009, 2015 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.core.ecl.parser.test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import org.junit.Assert;
import org.junit.Test;

import org.eclipse.rcptt.core.ecl.parser.EclScannerParser;
import org.eclipse.rcptt.core.ecl.parser.ast.Parser;
import org.eclipse.rcptt.core.ecl.parser.ast.Script;
import org.eclipse.rcptt.core.ecl.scanner.EclScanner;
import org.eclipse.rcptt.core.ecl.scanner.EclToken;

public class PerformanceTest {
	private static String sampleScript;
	static {

		try {
			InputStream is = PerformanceTest.class.getResourceAsStream("big-script.ecl");
			InputStreamReader reader = new InputStreamReader(is, "UTF-8");
			StringBuilder result = new StringBuilder();
			char[] chars = new char[16384];
			int read = 0;
			while ((read = reader.read(chars)) != -1) {
				result.append(chars, 0, read);
			}
			sampleScript = result.toString();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Test
	public void test1() {

		Assert.assertNotNull(sampleScript);
		final AtomicReference<Script> oldScript = new AtomicReference<Script>();
		long oldResult = measure(10, new Runnable() {
			@Override
			public void run() {
				oldScript.set(Parser.parse(sampleScript));
			}
		});
		final AtomicReference<Script> newScript = new AtomicReference<Script>();

		long newResult = measure(10, new Runnable() {
			@Override
			public void run() {
				newScript.set(EclScannerParser.parse(sampleScript));
			}
		});

		Assert.assertEquals(oldScript.get().pipelines.size(), newScript.get().pipelines.size());
		System.out.println(String.format("Old Time - %dms", oldResult));
		System.out.println(String.format("New Time - %dms", newResult));
	}

	@Test
	public void testScanner() {
		long result = measure(10, new Runnable() {
			@Override
			public void run() {
				EclScanner scanner = new EclScanner(sampleScript);
				List<EclToken> result = new ArrayList<EclToken>();
				EclToken next = null;
				while ((next = scanner.next()).type != EclToken.Type.Eof)
					result.add(next);
				// System.out.println(result.size());
			}
		});
		System.out.println(String.format("Scan Time - %dms", result));
	}

	public static long measure(int times, Runnable runnable) {
		long start = System.currentTimeMillis();
		for (int i = 0; i < times; i++) {
			runnable.run();
		}
		return (System.currentTimeMillis() - start) / times;
	}
}

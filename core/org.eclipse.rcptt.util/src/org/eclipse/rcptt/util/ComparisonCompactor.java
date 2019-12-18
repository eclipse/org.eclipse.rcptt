/*******************************************************************************
 * Copyright (c) 2004, 2014 JUnit Team and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Kent Beck - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.util;

/**
 * 
 * This class is copied with minimal changes from JUnit source code which is
 * distributed under common public license 1.0
 * 
 */
class ComparisonCompactor {
	private static final String ELLIPSIS = "...";

	/**
	 * The maximum length for <code>expected</code> and <code>actual</code>.
	 * When <code>contextLength</code> is exceeded, the Strings are
	 * shortened
	 */
	private int fContextLength;
	private String fExpected;
	private String fActual;
	private int fPrefix;
	private int fSuffix;

	/**
	 * @param contextLength
	 *            the maximum length for <code>expected</code> and
	 *            <code>actual</code>. When contextLength is exceeded, the
	 *            Strings are shortened
	 * @param expected
	 *            the expected string value
	 * @param actual
	 *            the actual string value
	 */
	public ComparisonCompactor(int contextLength, String expected,
			String actual) {
		fContextLength = contextLength;
		fExpected = expected;
		fActual = actual;
	}

	String compact() {
		if (fExpected == null || fActual == null || areStringsEqual())
			return format(fExpected, fActual);

		findCommonPrefix();
		findCommonSuffix();
		String expected = compactString(fExpected);
		String actual = compactString(fActual);
		return format(expected, actual);
	}

	private static final String format(String expected, String actual) {
		return String
				.format("expected:<%s> but was:<%s>", expected, actual);
	}

	private String compactString(String source) {
		String result = source.substring(fPrefix, source.length() - fSuffix
				+ 1);
		if (fPrefix > 0)
			result = computeCommonPrefix() + result;
		if (fSuffix > 0)
			result = result + computeCommonSuffix();
		return result;
	}

	private void findCommonPrefix() {
		fPrefix = 0;
		int end = Math.min(fExpected.length(), fActual.length());
		for (; fPrefix < end; fPrefix++) {
			if (fExpected.charAt(fPrefix) != fActual.charAt(fPrefix))
				break;
		}
	}

	private void findCommonSuffix() {
		int expectedSuffix = fExpected.length() - 1;
		int actualSuffix = fActual.length() - 1;
		for (; actualSuffix >= fPrefix && expectedSuffix >= fPrefix; actualSuffix--, expectedSuffix--) {
			if (fExpected.charAt(expectedSuffix) != fActual
					.charAt(actualSuffix))
				break;
		}
		fSuffix = fExpected.length() - expectedSuffix;
	}

	private String computeCommonPrefix() {
		return (fPrefix > fContextLength ? ELLIPSIS : "")
				+ fExpected.substring(
						Math.max(0, fPrefix - fContextLength), fPrefix);
	}

	private String computeCommonSuffix() {
		int end = Math.min(fExpected.length() - fSuffix + 1
				+ fContextLength, fExpected.length());
		return fExpected.substring(fExpected.length() - fSuffix + 1, end)
				+ (fExpected.length() - fSuffix + 1 < fExpected.length()
						- fContextLength ? ELLIPSIS : "");
	}

	private boolean areStringsEqual() {
		return fExpected.equals(fActual);
	}
}
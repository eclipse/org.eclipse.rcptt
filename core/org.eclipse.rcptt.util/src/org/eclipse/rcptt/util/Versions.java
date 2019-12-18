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
package org.eclipse.rcptt.util;

import org.osgi.framework.Version;

/**
 * Reason for this class is that {@link Version#compareTo(Version)} method was
 * added only in in eclipse 3.6, but we support 3.5 as well
 * 
 * @author ivaninozemtsev
 * 
 */
public class Versions {
	public static boolean isGreater(Version a, Version b) {
		return compareTo(a, b) > 0;
	}

	/**
	 * Copied from {@link Version#compareTo(Version)}
	 * 
	 * @param other
	 * @return
	 */
	public static int compareTo(Version left, Version right) {
		if (left == right) { // quicktest
			return 0;
		}

		int result = left.getMajor() - right.getMajor();
		if (result != 0) {
			return result;
		}

		result = left.getMinor() - right.getMinor();
		if (result != 0) {
			return result;
		}

		result = left.getMicro() - right.getMicro();
		if (result != 0) {
			return result;
		}

		return left.getQualifier().compareTo(right.getQualifier());
	}
}

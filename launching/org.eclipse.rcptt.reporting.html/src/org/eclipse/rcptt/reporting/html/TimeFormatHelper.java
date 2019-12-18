/*******************************************************************************
 * Copyright (c) 2009, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *  
 * Contributors:
 * 	Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.reporting.html;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public final class TimeFormatHelper {

	private static DecimalFormat secondsFormat;

	static {
		DecimalFormatSymbols symbols = new DecimalFormatSymbols();
		symbols.setDecimalSeparator('.');
		secondsFormat = new DecimalFormat("#0.000", symbols); //$NON-NLS-1$
	}

	private TimeFormatHelper() {
	}

	public static String format(long millis) {
		int mins = 0;
		double secs = 0;
		if (millis != 0) {
			double time = (double) millis / 1000;
			mins = (int) (time / 60);
			secs = time - mins * 60;
		}

		StringBuilder result = new StringBuilder();
		if (mins != 0) {
			result.append(mins);
			result.append(" m "); //$NON-NLS-1$
			result.append((int) secs);
		} else {
			result.append(secondsFormat.format(secs));
		}

		return result.toString();
	}
}

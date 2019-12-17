/*******************************************************************************
 * Copyright (c) 2009, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.ecl.internal.dispatch;

import org.eclipse.osgi.util.NLS;

public final class Messages extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.rcptt.ecl.internal.dispatch.messages"; //$NON-NLS-1$

	private Messages() {
		// Do not instantiate
	}

	public static String NotUniqueExtension;

	static {
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}
}
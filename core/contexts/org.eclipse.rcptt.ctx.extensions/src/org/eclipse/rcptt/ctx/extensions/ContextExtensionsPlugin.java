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
package org.eclipse.rcptt.ctx.extensions;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;
import org.osgi.framework.BundleContext;

public class ContextExtensionsPlugin extends Plugin {

	public static final String PLUGIN_ID = "org.eclipse.rcptt.contextsupportex"; //$NON-NLS-1$

	private static ContextExtensionsPlugin plugin;

	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	public static ContextExtensionsPlugin getDefault() {
		return plugin;
	}

	public static void logErr(Throwable cause, String format, Object... args) {
		if (getDefault() == null) {
			return;
		}
		getDefault().getLog().log(new Status(IStatus.ERROR, PLUGIN_ID, String.format(format, args), cause));
	}

}

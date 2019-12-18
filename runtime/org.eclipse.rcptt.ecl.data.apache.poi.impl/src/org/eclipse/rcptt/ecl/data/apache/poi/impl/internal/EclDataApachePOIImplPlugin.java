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
package org.eclipse.rcptt.ecl.data.apache.poi.impl.internal;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;
import org.osgi.framework.BundleContext;

public class EclDataApachePOIImplPlugin extends Plugin {

	public static final String PLUGIN_ID = "org.eclipse.rcptt.ecl.data.apache.poi.impl";
	private static EclDataApachePOIImplPlugin plugin;

	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	public static EclDataApachePOIImplPlugin getDefault() {
		return plugin;
	}

	public static IStatus createErr(String format, Object... args) {
		return createErr(null, format, args);
	}

	public static IStatus createErr(Throwable e, String format, Object... args) {
		return new Status(IStatus.ERROR, PLUGIN_ID,
				String.format(format, args), e);
	}

}

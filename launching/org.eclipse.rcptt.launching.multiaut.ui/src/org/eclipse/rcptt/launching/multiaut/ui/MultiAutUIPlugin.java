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
package org.eclipse.rcptt.launching.multiaut.ui;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

public class MultiAutUIPlugin extends AbstractUIPlugin {
	public static final String PLUGIN_ID = "org.eclipse.rcptt.launching.multiaut.ui";
	private static MultiAutUIPlugin plugin;

	public static MultiAutUIPlugin getDefault() {
		return plugin;
	}

	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	};

	public static void log(int severity, Throwable cause, String format, Object... args) {
		getDefault().getLog().log(new Status(severity, PLUGIN_ID, String.format(format, args), cause));
	}

	public static void logWarn(Throwable cause, String format, Object... args) {
		log(IStatus.WARNING, cause, format, args);
	}

	public static void logWarn(String format, Object... args) {
		logWarn(null, format, args);
	}

	public static void logErr(Throwable cause, String format, Object... args) {
		log(IStatus.ERROR, cause, format, args);
	}

	public static void logErr(String format, Object... args) {
		logErr(null, format, args);
	}

	@Override
	protected void initializeImageRegistry(ImageRegistry reg) {
		super.initializeImageRegistry(reg);
		reg.put(IMAGE_CHECKED_KEY, imageDescriptorFromPlugin(PLUGIN_ID, "icons/checked.gif"));
		reg.put(IMAGE_UNCHECKED_KEY, imageDescriptorFromPlugin(PLUGIN_ID, "icons/unchecked.gif"));
	}

	public static Image getCheckedImage() {
		return getDefault().getImageRegistry().get(IMAGE_CHECKED_KEY);
	}

	public static Image getUncheckedImage() {
		return getDefault().getImageRegistry().get(IMAGE_UNCHECKED_KEY);
	}

	private static final String IMAGE_CHECKED_KEY = "checked";
	private static final String IMAGE_UNCHECKED_KEY = "unchecked";
}
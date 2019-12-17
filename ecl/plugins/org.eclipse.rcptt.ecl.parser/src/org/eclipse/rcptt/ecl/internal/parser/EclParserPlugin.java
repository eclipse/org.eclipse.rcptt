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

package org.eclipse.rcptt.ecl.internal.parser;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class EclParserPlugin extends Plugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.eclipse.rcptt.ecl.parser";

	// The shared instance
	private static EclParserPlugin plugin;

	/**
	 * The constructor
	 */
	public EclParserPlugin() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.core.runtime.Plugins#start(org.osgi.framework.BundleContext)
	 */
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.core.runtime.Plugin#stop(org.osgi.framework.BundleContext)
	 */
	@Override
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 * 
	 * @return the shared instance
	 */
	public static EclParserPlugin getDefault() {
		return plugin;
	}

	public static void log(IStatus status) {
		getDefault().getLog().log(status);
	}

	public static void log(CoreException e) {
		log(e.getStatus());
	}

	public static void logErr(String message, Throwable e) {
		log(new Status(IStatus.ERROR, PLUGIN_ID, message, e));
	}

	public static String readFile(String file) throws Exception {
		InputStream openStream = getInputStream(file);
		byte[] content = getContent(openStream);
		return new String(content).replace("\r\n", "\n");
	}

	public static InputStream getInputStream(String file) throws IOException {
		URL entry = getDefault().getBundle().getEntry(file);
		InputStream openStream = entry.openStream();
		return openStream;
	}

	public static byte[] getContent(InputStream input) throws IOException {
		final BufferedInputStream buffer = new BufferedInputStream(input);
		final ByteArrayOutputStream output = new ByteArrayOutputStream(100000);
		try {
			final byte[] bytes = new byte[8192];
			int length = 0;
			while ((length = buffer.read(bytes)) > 0) {
				output.write(bytes, 0, length);
			}
		} finally {
			buffer.close();
		}
		return output.toByteArray();
	}

	public static IStatus createStatus(Throwable t) {
		if (t instanceof CoreException)
			return ((CoreException) t).getStatus();
		return new Status(Status.ERROR, PLUGIN_ID, t.getMessage(), t);
	}

}

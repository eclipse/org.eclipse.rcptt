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
package org.eclipse.rcptt.core.internal.ecl.parser;

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

public class Q7EclParserPlugin extends Plugin {

	public static final String PLUGIN_ID = "org.eclipse.rcptt.core.ecl.parser";

	private static Q7EclParserPlugin plugin;

	public static Q7EclParserPlugin getDefault() {
		return plugin;
	}

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

	public static void log(IStatus status) {
		getDefault().getLog().log(status);
	}

	public static void log(CoreException e) {
		log(e.getStatus());
	}

	public static void logErr(String message, Throwable e) {
		log(new Status(IStatus.ERROR, PLUGIN_ID, message, e));
	}

	public static void logErr(Throwable cause, String format, Object... args) {
		log(new Status(IStatus.ERROR, PLUGIN_ID, String.format(format, args)));
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
}

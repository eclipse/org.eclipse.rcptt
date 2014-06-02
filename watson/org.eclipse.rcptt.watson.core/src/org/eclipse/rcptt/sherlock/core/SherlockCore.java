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
package org.eclipse.rcptt.sherlock.core;

import org.eclipse.core.runtime.ILogListener;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;
import org.osgi.framework.BundleContext;

import org.eclipse.core.runtime.IBundleGroup;
import org.osgi.framework.Bundle;

import java.util.List;

import org.eclipse.rcptt.sherlock.core.internal.SherlockLogListener;
import org.eclipse.rcptt.sherlock.core.model.sherlock.EclipseStatus;
import org.eclipse.rcptt.sherlock.core.model.sherlock.JavaException;
import org.eclipse.rcptt.sherlock.core.model.sherlock.JavaStackTraceEntry;
import org.eclipse.rcptt.sherlock.core.model.sherlock.SherlockFactory;

public class SherlockCore extends Plugin {
	public static final String PLUGIN_ID = "org.eclipse.rcptt.watson.core";

	private static SherlockCore plugin;

	public SherlockCore() {
	}

	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		Platform.addLogListener(logListener);
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		Platform.removeLogListener(logListener);
		plugin = null;
		super.stop(context);
	}

	public static SherlockCore getDefault() {
		return plugin;
	}

	// ILogListener
	private final SherlockLogListener logListener = new SherlockLogListener();

	public static void addLogListener(ILogListener listener,
			IStatusFilter statusFilter, IPluginFilter pluginFilter) {
		getDefault().logListener.addLogListener(listener, statusFilter,
				pluginFilter);
	}

	public static void removeLogListener(ILogListener listener) {
		getDefault().logListener.removeLogListener(listener);
	}

	// Converters
	public static EclipseStatus convert(IStatus status) {
		return convert(status, null);
	}

	public static EclipseStatus convert(IStatus status,
			List<IBundleGroup> features) {
		final EclipseStatus eclipseStatus = SherlockFactory.eINSTANCE
				.createEclipseStatus();
		eclipseStatus.setCode(status.getCode());
		eclipseStatus.setMessage(status.getMessage());

		String plugin = status.getPlugin();
		eclipseStatus.setPlugin(plugin);

		if (features != null) {
			for (IBundleGroup feature : features) {

				for (Bundle bundle : feature.getBundles()) {
					if (bundle.getSymbolicName().equals(plugin)) {
						eclipseStatus.getFeatureGuess().add(
								feature.getIdentifier());
						break;
					}
				}

			}
		}

		eclipseStatus.setSeverity(status.getSeverity());

		final Throwable exception = status.getException();
		if (exception != null) {
			eclipseStatus.setException(convert(exception));
		}

		for (IStatus child : status.getChildren()) {
			eclipseStatus.getChildren().add(convert(child));
		}

		return eclipseStatus;
	}

	public static JavaException convert(Throwable th) {
		final JavaException javaException = SherlockFactory.eINSTANCE
				.createJavaException();

		javaException.setClassName(th.getClass().getName());
		javaException.setMessage(th.getMessage());

		final Throwable cause = th.getCause();
		if (cause != null) {
			javaException.setCause(convert(cause));
		}

		for (StackTraceElement element : th.getStackTrace()) {
			javaException.getStackTrace().add(convert(element));
		}

		return javaException;
	}

	public static JavaStackTraceEntry convert(StackTraceElement element) {
		final JavaStackTraceEntry entry = SherlockFactory.eINSTANCE
				.createJavaStackTraceEntry();
		entry.setClassName(element.getClassName());
		entry.setFileName(element.getFileName());
		entry.setLineNumber(element.getLineNumber());
		entry.setMethodName(element.getMethodName());
		entry.setNativeMethod(element.isNativeMethod());
		return entry;
	}

	public static void log(String msg) {
		getDefault().getLog().log(
				new Status(IStatus.ERROR, PLUGIN_ID, msg, null));
	}

	public static void log(Throwable e) {
		getDefault().getLog().log(
				new Status(IStatus.ERROR, PLUGIN_ID, e.getMessage(), e));
	}

	public static void log(String msg, Throwable e) {
		getDefault().getLog().log(new Status(IStatus.ERROR, PLUGIN_ID, msg, e));
	}

	public static String rlimitSize(String id, int len) {
		if (id.length() > len) {
			return id.substring(0, len);
		}
		return id;
	}

	public static String getID(String value) {
		if (value == null) {
			return null;
		}
		String textResult = "";
		for (char c : value.toCharArray()) {
			if (!Character.isLetterOrDigit(c)) {
				textResult += '_';
			} else {
				textResult += c;
			}
		}
		return textResult;
	}
}

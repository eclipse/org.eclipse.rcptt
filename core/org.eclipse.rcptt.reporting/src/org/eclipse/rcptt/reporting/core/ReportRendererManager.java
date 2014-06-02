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
package org.eclipse.rcptt.reporting.core;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;

import org.eclipse.rcptt.reporting.internal.Q7ReportingPlugin;

public class ReportRendererManager {
	public static class ReportRenderer {
		private String name;
		private String description;
		private IReportRenderer renderer;
		private String extension;
		private String id;

		public ReportRenderer(String name, String extension,
				String description, IReportRenderer renderer, String id) {
			super();
			this.name = name;
			this.extension = extension;
			this.description = description;
			this.renderer = renderer;
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public String getDescription() {
			return description;
		}

		public IReportRenderer getRenderer() {
			return renderer;
		}

		public String getExtension() {
			return extension;
		}

		public String getId() {
			return id;
		}
	}

	private List<ReportRenderer> managers = null;
	private static ReportRendererManager instance = null;

	private ReportRendererManager() {
	}

	private synchronized void initialize() {
		if (managers != null) {
			return;
		}
		managers = new ArrayList<ReportRenderer>();

		IConfigurationElement[] elements = Platform.getExtensionRegistry()
				.getConfigurationElementsFor(
						Q7ReportingPlugin.PLUGIN_ID + ".reportRenderer");
		for (IConfigurationElement cfg : elements) {
			IReportRenderer provider;
			try {
				String name = cfg.getAttribute("name");
				String extension = cfg.getAttribute("extension");
				String description = cfg.getAttribute("description");
				String id = cfg.getAttribute("id");
				provider = (IReportRenderer) cfg
						.createExecutableExtension("class");
				managers.add(new ReportRenderer(name, extension, description,
						provider, id));
			} catch (CoreException e) {
				Q7ReportingPlugin.getDefault().getLog().log(e.getStatus());
			}
		}
	}

	public ReportRenderer[] getExtensions() {
		initialize();
		return managers.toArray(new ReportRenderer[managers.size()]);
	}

	public synchronized static ReportRendererManager getInstance() {
		if (instance == null) {
			instance = new ReportRendererManager();
		}
		return instance;
	}
}

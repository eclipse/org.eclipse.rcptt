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
package org.eclipse.rcptt.sherlock.core;

public class PluginFilters {
	private static enum AllPluginFilter implements IPluginFilter {
		INSTANCE;

		public boolean matches(String plugin) {
			return true;
		}
	}

	public static IPluginFilter all() {
		return AllPluginFilter.INSTANCE;
	}

	private static class ExactPluginFilter implements IPluginFilter {
		private final String plugin;

		public ExactPluginFilter(String plugin) {
			this.plugin = plugin;
		}

		public boolean matches(String plugin) {
			return this.plugin.equals(plugin);
		}
	}

	public static IPluginFilter exact(String plugin) {
		return new ExactPluginFilter(plugin);
	}

	public static IPluginFilter regex(String regex) {
		throw new AssertionError();
	}
}

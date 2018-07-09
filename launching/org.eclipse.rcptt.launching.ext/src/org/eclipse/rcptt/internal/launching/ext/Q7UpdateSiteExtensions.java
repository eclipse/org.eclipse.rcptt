/*******************************************************************************
 * Copyright (c) 2009, 2016 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.internal.launching.ext;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Strings.isNullOrEmpty;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Collection;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IContributor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.equinox.p2.metadata.VersionRange;
import org.osgi.framework.Bundle;

import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;

public enum Q7UpdateSiteExtensions {
	instance;

	public static class Q7RuntimeInfo {
		public static final String SWT_PLATFORM = "swt"; //$NON-NLS-1$
		public static final String RAP_PLATFORM = "rap"; //$NON-NLS-1$

		public final String kind;
		public final URI path;
		public final Bundle bundle;
		public final VersionRange version;
		public final String platform;

		public Q7RuntimeInfo(String kind, URI path, Bundle bundle, VersionRange version) {
			this(kind, path, bundle, version, SWT_PLATFORM);
		}

		public Q7RuntimeInfo(String kind, URI path, Bundle bundle, VersionRange version, String platform) {
			checkArgument(bundle != null);
			checkArgument(version != null);
			checkArgument(!isNullOrEmpty(kind));
			checkArgument(path != null);
			this.kind = kind;
			this.path = path;
			this.bundle = bundle;
			this.version = version;
			this.platform = Strings.isNullOrEmpty(platform) ? SWT_PLATFORM : platform;
		}

		@Override
		public String toString() {
			return bundle.toString();
		}
	}

	private final Collection<Q7RuntimeInfo> bundles;

	Q7UpdateSiteExtensions() {
		bundles = inializeProcessors();
	}

	private static URI pathToUri(String path, Bundle bundle) {
		checkArgument(!isNullOrEmpty(path));
		checkArgument(!path.trim().isEmpty());
		checkArgument(bundle != null);
		URL url = bundle.getEntry(new Path(path).toString());
		try {
			if (url != null)
				return url.toURI();
			// Try to resolve as URI entry.
			return new URI(path);
		} catch (URISyntaxException e) {
			throw new IllegalArgumentException(e);
		}
	}

	private static Collection<Q7RuntimeInfo> inializeProcessors() {
		IConfigurationElement[] configurationElements = Platform
				.getExtensionRegistry().getConfigurationElementsFor(
						Q7ExtLaunchingPlugin.PLUGIN_ID + ".q7runtime");
		Builder<Q7RuntimeInfo> builder = ImmutableList.builder();
		for (IConfigurationElement config : configurationElements) {
			IContributor contributor = config.getContributor();
			final Q7RuntimeInfo info;
			try {
				final VersionRange version = new VersionRange(config.getAttribute("version"));
				Bundle bundle = Platform.getBundle(contributor.getName());
				URI path = pathToUri(config.getAttribute("path"), bundle);
				info = new Q7RuntimeInfo(
						config.getAttribute("kind"),
						path,
						bundle,
						version,
						config.getAttribute("platform"));
			} catch (IllegalArgumentException e) {
				Q7ExtLaunchingPlugin
						.getDefault()
						.log("Plugin "
								+ contributor.getName()
								+ " provides incorrect q7runtime extension point",
								e);
				continue;
			}
			builder.add(info);
		}
		return builder.build();
	}

	public static Q7UpdateSiteExtensions getDefault() {
		return instance;
	}

	public Collection<Q7RuntimeInfo> getRuntimes() {
		if (bundles.isEmpty())
			throw new RuntimeException(
					"No injection providers found. Make sure org.eclipse.rcptt.updates.* plugins are loaded");
		return bundles;
		// List<Q7RuntimeInfo> result = new ArrayList<Q7UpdateSiteExtensions.Q7RuntimeInfo>();
		// Set<String> keySet = versionToBundles.keySet();
		// Version versionValue = Version.create(version);
		// for (String key : keySet) {
		// if (key.equals(version)) {
		// result.addAll(versionToBundles.get(key));
		// } else {
		// try {
		// VersionRange range = new VersionRange(key);
		// if (range.isIncluded(versionValue)) {
		// result.addAll(versionToBundles.get(key));
		// }
		// } catch (IllegalArgumentException e) {
		// RcpttPlugin.log(e);
		// }
		// }
		// }
		// return result;
	}
}

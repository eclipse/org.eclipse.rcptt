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
package org.eclipse.rcptt.internal.launching.ext;

import java.net.URI;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.pde.internal.core.target.IUBundleContainer;
import org.eclipse.pde.internal.core.target.ProfileBundleContainer;
import org.eclipse.pde.internal.core.target.provisional.IBundleContainer;

import org.eclipse.rcptt.internal.launching.ext.Q7TargetPlatformInitializer.Q7Info;
import org.eclipse.rcptt.launching.internal.target.TargetPlatformHelper;
import org.eclipse.rcptt.launching.target.ITargetPlatformHelper;

@SuppressWarnings("restriction")
public class Q7TargetPlatformValidator {
	public static boolean validateUpdates(String location,
			ITargetPlatformHelper platform) {
		if (!platform.isValid()) {
			return false;
		}
		String path = platform.getTargetPlatformProfilePath();
		if (!location.equals(path)) {
			return false;
		}
		Q7Info info = Q7TargetPlatformInitializer.getInfo(platform);
		if (info == null) {
			return false;
		}
		Set<URI> infoURIs = new HashSet<URI>();
		infoURIs.add(info.q7);
		infoURIs.add(info.deps);
		infoURIs.addAll(info.extra);

		Set<URI> curURIs = new HashSet<URI>();
		// Collect current uris
		IBundleContainer[] containers = ((TargetPlatformHelper) platform)
				.getBundleContainers();
		for (IBundleContainer iBundleContainer : containers) {
			if (iBundleContainer instanceof ProfileBundleContainer) {
				continue; // Skip profile container.
			}
			if (iBundleContainer instanceof IUBundleContainer) {
				curURIs.addAll(Arrays
						.asList(((IUBundleContainer) iBundleContainer)
								.getRepositories()));
			}
		}

		return infoURIs.equals(curURIs);
	}
}

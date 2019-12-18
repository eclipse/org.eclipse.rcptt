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
package org.eclipse.rcptt.internal.launching.ext;

import java.io.File;

import org.eclipse.debug.core.ILaunchConfiguration;

import org.eclipse.rcptt.internal.launching.Q7LaunchingPlugin;
import org.eclipse.rcptt.launching.ILaunchValidator;
import org.eclipse.rcptt.launching.IQ7Launch;
import org.eclipse.rcptt.launching.ext.Q7LaunchingUtil;

public class Q7ExternalLaunchValidator implements ILaunchValidator {

	public Q7ExternalLaunchValidator() {
	}

	public boolean isLaunchValid(ILaunchConfiguration config) {
		try {
			if (config.getType().getIdentifier()
					.equals(Q7LaunchingUtil.EXTERNAL_LAUNCH_TYPE)) {
				String location = config.getAttribute(IQ7Launch.AUT_LOCATION,
						"");
				File loc = new File(location);
				if (!loc.exists()) {
					return false;
				}
				return true;
//				ITargetPlatformHelper helper = Q7TargetPlatformManager
//						.getTarget(config, new NullProgressMonitor());
//				if (helper != null) {
//					return helper.isValid();
//				}
//				return false;
			}
		} catch (Throwable e) {
			Q7LaunchingPlugin.log(e);
		}
		return true;
	}
}

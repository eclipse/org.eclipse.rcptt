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
package org.eclipse.rcptt.ctx.resources;

import org.eclipse.core.runtime.IPath;

public class FileBuffersUtils {
	private static IFileBufferUtils utils;
	private static boolean init = false;

	public static IFileBufferUtils getFileBuffers() {
		if (!init) {
			init = true;
			try {
				Class<?> forName = Class
						.forName("org.eclipse.rcptt.ctx.resources.FileBuffersUtilsImpl");
				utils = (IFileBufferUtils) forName.newInstance();
			} catch (Exception e) {
				// e.printStackTrace();
			}
			if (utils == null) {
				utils = new IFileBufferUtils() {
					public void clearAll() {
					}

					public void syncLocation(IPath location) {
					}
				};
			}
		}
		return utils;
	}
}

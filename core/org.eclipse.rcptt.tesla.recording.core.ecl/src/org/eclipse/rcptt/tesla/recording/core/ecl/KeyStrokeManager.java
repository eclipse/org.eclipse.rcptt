/*******************************************************************************
 * Copyright (c) 2009, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *  
 * Contributors:
 * 	Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.tesla.recording.core.ecl;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;

public class KeyStrokeManager {

	private static String POINT_ID = TeslaRecordingPlugin.PLUGIN_ID + ".keyStrokeExtension"; //$NON-NLS-1$

	private static IKeyStrokeManagerExtension extension;


	public static IKeyStrokeManagerExtension getUtils() {
		if(extension == null)
		{
			IConfigurationElement[] elements = Platform.getExtensionRegistry().getConfigurationElementsFor(POINT_ID);
			if (elements.length != 1) {
				TeslaRecordingPlugin.log("IKeyStrokeManagerExtension is not exists."); //$NON-NLS-1$
				return null;
			}

			try {
				extension = (IKeyStrokeManagerExtension)elements[0].createExecutableExtension("class");//$NON-NLS-1$

			} catch (CoreException e) {
				TeslaRecordingPlugin.log("Error while get key stroke extension.", e); //$NON-NLS-1$
			}
		}

		return extension;
	}

}

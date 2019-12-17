/*******************************************************************************
 * Copyright (c) 2009, 2009, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.tesla.swt.util;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.osgi.util.NLS;
import org.eclipse.rcptt.tesla.core.TeslaFeatures;
import org.eclipse.rcptt.tesla.swt.TeslaSWTMessages;
import org.eclipse.rcptt.tesla.swt.reflection.JavaMembersHelper;
import org.eclipse.rcptt.tesla.ui.SWTTeslaActivator;
import org.eclipse.rcptt.util.StringUtils;

public class IdentifyObjectUtil {

	/**
	 * Tries to identify object by java methods specified in options
	 * 
	 * @param object
	 * @return null or non-empty id
	 */
	@SuppressWarnings("rawtypes")
	public static String getObjectIdByClassMethods(Object object) throws CoreException {
		String methods = TeslaFeatures.getInstance().getValue(TeslaFeatures.IDENTIFY_BY_CLASS_METHODS);
		if (StringUtils.isBlank(methods)) {
			return null;
		}
		for (String method : methods.split(",")) {
			String[] methodInfo = method.split(":");
			if (methodInfo.length != 2) {
				continue;
			}
			String className = methodInfo[0].trim();
			String idPath = methodInfo[1].trim();

			Class clazz = object.getClass();
			if (className.equals(clazz.getSimpleName()) || className.equals(clazz.getName())) {
				try {
					String id = JavaMembersHelper.getPropertyValue(object, idPath);
					if (!StringUtils.isBlank(id)) {
						return id;
					}
				} catch (Exception e) {
					String errorMessage = NLS.bind(TeslaSWTMessages.IdentifyObjectUtil_FailedToInvokeMethod,
							idPath, className);
					throw new CoreException(SWTTeslaActivator.createStatus(errorMessage, e));
				}
			}
		}
		return null;
	}

}

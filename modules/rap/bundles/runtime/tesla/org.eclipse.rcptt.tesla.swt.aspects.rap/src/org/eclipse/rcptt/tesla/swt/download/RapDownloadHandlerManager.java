/*******************************************************************************
 * /*******************************************************************************
 *  * Copyright (c) 2009, 2016 Xored Software Inc and others.
 *  * All rights reserved. This program and the accompanying materials
 *  * are made available under the terms of the Eclipse Public License v1.0
 *  * which accompanies this distribution, and is available at
 *  * http://www.eclipse.org/legal/epl-v10.html
 *  *
 *  * Contributors:
 *  *     Xored Software Inc - initial API and implementation and/or initial documentation
 *  *******************************************************************************/
package org.eclipse.rcptt.tesla.swt.download;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;

import org.eclipse.rap.rwt.RWT;
import org.eclipse.rap.rwt.internal.service.ServiceManagerImpl;
import org.eclipse.rap.rwt.service.ServiceHandler;
import org.eclipse.rcptt.tesla.swt.aspects.rap.SWTAspectActivator;

public class RapDownloadHandlerManager {

	private final static Set<String> handlers = new HashSet<String>();
	private static String content;


	public static void addHandler(String name)
	{
		handlers.add(name);
	}

	public static void clear()
	{
		//handlers.clear();
		content = null;
	}

	public static boolean contains(String name)
	{
		return handlers.contains(name);
	}


	public static void addFile(String file)
	{
		content = file;
	}


	public static byte[] emulateDownload(String url, String handler)
	{
		 @SuppressWarnings("restriction")
		ServiceHandler serviceHandler = ((ServiceManagerImpl)RWT.getServiceManager()).getServiceHandler(handler);

		 MockHttpServletRequest request = new MockHttpServletRequest(url);
		 MockHttpServletResponse response = new MockHttpServletResponse();

		 try {
			serviceHandler.service(request, response);
			return response.getDuplicateOutput().toByteArray();
		} catch (IOException e) {
			SWTAspectActivator.log(e);
		} catch (ServletException e) {
			SWTAspectActivator.log(e);
		}

		return null;
	}
}

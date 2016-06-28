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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.Base64;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.servlet.AsyncContext;
import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpUpgradeHandler;
import javax.servlet.http.Part;

import org.eclipse.rap.rwt.RWT;
import org.eclipse.rap.rwt.internal.service.ServiceManagerImpl;
import org.eclipse.rap.rwt.service.ServiceHandler;
import org.eclipse.rcptt.util.MockHttpServletRequest;
import org.eclipse.rcptt.util.MockHttpServletResponse;

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

	public static boolean checkContent(String content) {
		return content.equals(RapDownloadHandlerManager.content);
	}

	public static void addFile(String file)
	{
		content = file;
	}


	public static String emulateDownload(String url, String handler)
	{
		 @SuppressWarnings("restriction")
		ServiceHandler serviceHandler = ((ServiceManagerImpl)RWT.getServiceManager()).getServiceHandler(handler);

		 MockHttpServletRequest request = new MockHttpServletRequest(url);
		 MockHttpServletResponse response = new MockHttpServletResponse();

		 try {
			serviceHandler.service(request, response);

			return org.eclipse.rcptt.util.Base64.encode(response.getDuplicateOutput().toByteArray());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return null;
	}
}

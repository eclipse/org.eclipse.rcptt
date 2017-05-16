/*******************************************************************************
 * Copyright (c) 2009, 2016 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 * 	Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/

package org.eclipse.rcptt.tesla.swt.download;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.Principal;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
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

public class MockHttpServletRequest implements HttpServletRequest {

	public static final String DEFAULT_PROTOCOL = "http";

	public static final String DEFAULT_SERVER_ADDR = "127.0.0.1";

	public static final String DEFAULT_SERVER_NAME = "localhost";

	public static final int DEFAULT_SERVER_PORT = 80;

	public static final String DEFAULT_REMOTE_ADDR = "127.0.0.1";

	public static final String DEFAULT_REMOTE_HOST = "localhost";

	private static final String CONTENT_TYPE_HEADER = "Content-Type";

	private static final String CHARSET_PREFIX = "charset=";

	private boolean active = true;

	// ---------------------------------------------------------------------
	// ServletRequest properties
	// ---------------------------------------------------------------------

	private final Map<String, Object> attributes = new LinkedHashMap<String, Object>();

	private String characterEncoding;

	private byte[] content;

	private String contentType;

	private final Map<String, String[]> parameters = new LinkedHashMap<String, String[]>(16);

	private String protocol = DEFAULT_PROTOCOL;

	private String scheme = DEFAULT_PROTOCOL;

	private String serverName = DEFAULT_SERVER_NAME;

	private int serverPort = DEFAULT_SERVER_PORT;

	private String remoteAddr = DEFAULT_REMOTE_ADDR;

	private String remoteHost = DEFAULT_REMOTE_HOST;

	private final List<Locale> locales = new LinkedList<Locale>();

	private boolean secure = false;

	private int remotePort = DEFAULT_SERVER_PORT;

	private String localName = DEFAULT_SERVER_NAME;

	private String localAddr = DEFAULT_SERVER_ADDR;

	private int localPort = DEFAULT_SERVER_PORT;

	private boolean asyncStarted = false;

	private boolean asyncSupported = false;

	private DispatcherType dispatcherType = DispatcherType.REQUEST;

	// ---------------------------------------------------------------------
	// HttpServletRequest properties
	// ---------------------------------------------------------------------

	private String authType;

	private Cookie[] cookies;

	private final Map<String, Object> headers = new HashMap<String, Object>();

	private String method;

	private String pathInfo;

	private String contextPath = "";

	private String queryString;

	private String remoteUser;

	private final Set<String> userRoles = new HashSet<String>();

	private Principal userPrincipal;

	private String requestedSessionId;

	private String requestURI;

	private String servletPath = "";

	private HttpSession session;

	private boolean requestedSessionIdValid = true;

	private boolean requestedSessionIdFromCookie = true;

	private boolean requestedSessionIdFromURL = false;

	private final Map<String, Part> parts = new LinkedHashMap<String, Part>();

	private URI url;

	public MockHttpServletRequest(String requestURI) {
		this.method = "GET";
		this.requestURI = requestURI;
		this.url = URI.create(requestURI);
		this.locales.add(Locale.ENGLISH);
	}

	// ---------------------------------------------------------------------
	// Lifecycle methods
	// ---------------------------------------------------------------------

	@Override
	public ServletContext getServletContext() {
		return null;
	}

	public boolean isActive() {
		return this.active;
	}

	public void close() {
		this.active = false;
	}

	public void invalidate() {
		close();
		clearAttributes();
	}

	// ---------------------------------------------------------------------
	// ServletRequest interface
	// ---------------------------------------------------------------------

	@Override
	public Object getAttribute(String name) {
		return this.attributes.get(name);
	}

	@Override
	public Enumeration<String> getAttributeNames() {
		return Collections.enumeration(new LinkedHashSet<String>(this.attributes.keySet()));
	}

	@Override
	public String getCharacterEncoding() {
		return this.characterEncoding;
	}

	@Override
	public void setCharacterEncoding(String characterEncoding) {
		this.characterEncoding = characterEncoding;
		updateContentTypeHeader();
	}

	private void updateContentTypeHeader() {
		if (this.contentType != null) {
			StringBuilder sb = new StringBuilder(this.contentType);
			if (!this.contentType.toLowerCase().contains(CHARSET_PREFIX) && this.characterEncoding != null) {
				sb.append(";").append(CHARSET_PREFIX).append(this.characterEncoding);
			}
			doAddHeaderValue(CONTENT_TYPE_HEADER, sb.toString(), true);
		}
	}

	public void setContent(byte[] content) {
		this.content = content;
	}

	@Override
	public int getContentLength() {
		return (this.content != null ? this.content.length : -1);
	}

	public long getContentLengthLong() {
		return getContentLength();
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
		if (contentType != null) {
			int charsetIndex = contentType.toLowerCase().indexOf(CHARSET_PREFIX);
			if (charsetIndex != -1) {
				String encoding = contentType.substring(charsetIndex + CHARSET_PREFIX.length());
				this.characterEncoding = encoding;
			}
			updateContentTypeHeader();
		}
	}

	@Override
	public String getContentType() {
		return this.contentType;
	}

	@Override
	public ServletInputStream getInputStream() {
		return null;
	}

	public void setParameter(String name, String value) {
		setParameter(name, new String[] { value });
	}

	public void setParameter(String name, String[] values) {
		this.parameters.put(name, values);
	}

	@SuppressWarnings("rawtypes")
	public void setParameters(Map params) {
		for (Object key : params.keySet()) {
			Object value = params.get(key);
			if (value instanceof String) {
				this.setParameter((String) key, (String) value);
			} else if (value instanceof String[]) {
				this.setParameter((String) key, (String[]) value);
			} else {
				throw new IllegalArgumentException(
						"Parameter map value must be single value " + " or array of type [" + String.class.getName()
								+ "]");
			}
		}
	}

	public void addParameter(String name, String value) {
		addParameter(name, new String[] { value });
	}

	public void addParameter(String name, String[] values) {
		String[] oldArr = this.parameters.get(name);
		if (oldArr != null) {
			String[] newArr = new String[oldArr.length + values.length];
			System.arraycopy(oldArr, 0, newArr, 0, oldArr.length);
			System.arraycopy(values, 0, newArr, oldArr.length, values.length);
			this.parameters.put(name, newArr);
		} else {
			this.parameters.put(name, values);
		}
	}

	@SuppressWarnings("rawtypes")
	public void addParameters(Map params) {
		for (Object key : params.keySet()) {
			Object value = params.get(key);
			if (value instanceof String) {
				this.addParameter((String) key, (String) value);
			} else if (value instanceof String[]) {
				this.addParameter((String) key, (String[]) value);
			} else {
				throw new IllegalArgumentException("Parameter map value must be single value " +
						" or array of type [" + String.class.getName() + "]");
			}
		}
	}

	public void removeParameter(String name) {
		this.parameters.remove(name);
	}

	public void removeAllParameters() {
		this.parameters.clear();
	}

	private boolean isInitialize = false;

	@Override
	public String getParameter(String name) {

		if (!isInitialize) {
			String[] split = url.getQuery().split("&");
			for (String sp : split) {
				String[] param = sp.split("=");
				parameters.put(param[0], new String[] { param[1] });
			}
			isInitialize = true;
		}
		String[] arr = (name != null ? this.parameters.get(name) : null);
		return (arr != null && arr.length > 0 ? arr[0] : null);
	}

	@Override
	public Enumeration<String> getParameterNames() {
		return Collections.enumeration(this.parameters.keySet());
	}

	@Override
	public String[] getParameterValues(String name) {
		return (name != null ? this.parameters.get(name) : null);
	}

	@Override
	public Map<String, String[]> getParameterMap() {
		return Collections.unmodifiableMap(this.parameters);
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	@Override
	public String getProtocol() {
		return this.protocol;
	}

	public void setScheme(String scheme) {
		this.scheme = scheme;
	}

	@Override
	public String getScheme() {
		return this.scheme;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	@Override
	public String getServerName() {
		return this.serverName;
	}

	public void setServerPort(int serverPort) {
		this.serverPort = serverPort;
	}

	@Override
	public int getServerPort() {
		return this.serverPort;
	}

	@Override
	public BufferedReader getReader() throws UnsupportedEncodingException {
		if (this.content != null) {
			InputStream sourceStream = new ByteArrayInputStream(this.content);
			Reader sourceReader = (this.characterEncoding != null)
					? new InputStreamReader(sourceStream, this.characterEncoding) : new InputStreamReader(sourceStream);
			return new BufferedReader(sourceReader);
		} else {
			return null;
		}
	}

	public void setRemoteAddr(String remoteAddr) {
		this.remoteAddr = remoteAddr;
	}

	@Override
	public String getRemoteAddr() {
		return this.remoteAddr;
	}

	public void setRemoteHost(String remoteHost) {
		this.remoteHost = remoteHost;
	}

	@Override
	public String getRemoteHost() {
		return this.remoteHost;
	}

	@Override
	public void setAttribute(String name, Object value) {
		if (value != null) {
			this.attributes.put(name, value);
		} else {
			this.attributes.remove(name);
		}
	}

	@Override
	public void removeAttribute(String name) {
		this.attributes.remove(name);
	}

	public void clearAttributes() {
		this.attributes.clear();
	}

	public void addPreferredLocale(Locale locale) {
		this.locales.add(0, locale);
	}

	public void setPreferredLocales(List<Locale> locales) {
		this.locales.clear();
		this.locales.addAll(locales);
	}

	@Override
	public Locale getLocale() {
		return this.locales.get(0);
	}

	@Override
	public Enumeration<Locale> getLocales() {
		return Collections.enumeration(this.locales);
	}

	public void setSecure(boolean secure) {
		this.secure = secure;
	}

	@Override
	public boolean isSecure() {
		return this.secure;
	}

	@Override
	public RequestDispatcher getRequestDispatcher(String path) {
		return null;
	}

	@Override
	@Deprecated
	public String getRealPath(String path) {
		return "";
	}

	public void setRemotePort(int remotePort) {
		this.remotePort = remotePort;
	}

	@Override
	public int getRemotePort() {
		return this.remotePort;
	}

	public void setLocalName(String localName) {
		this.localName = localName;
	}

	@Override
	public String getLocalName() {
		return this.localName;
	}

	public void setLocalAddr(String localAddr) {
		this.localAddr = localAddr;
	}

	@Override
	public String getLocalAddr() {
		return this.localAddr;
	}

	public void setLocalPort(int localPort) {
		this.localPort = localPort;
	}

	@Override
	public int getLocalPort() {
		return this.localPort;
	}

	@Override
	public AsyncContext startAsync() {
		return startAsync(this, null);
	}

	@Override
	public AsyncContext startAsync(ServletRequest request, ServletResponse response) {
		if (!this.asyncSupported) {
			throw new IllegalStateException("Async not supported");
		}
		this.asyncStarted = true;
		return null;
	}

	public void setAsyncStarted(boolean asyncStarted) {
		this.asyncStarted = asyncStarted;
	}

	@Override
	public boolean isAsyncStarted() {
		return this.asyncStarted;
	}

	public void setAsyncSupported(boolean asyncSupported) {
		this.asyncSupported = asyncSupported;
	}

	@Override
	public boolean isAsyncSupported() {
		return this.asyncSupported;
	}

	@Override
	public AsyncContext getAsyncContext() {
		return null;
	}

	public void setDispatcherType(DispatcherType dispatcherType) {
		this.dispatcherType = dispatcherType;
	}

	@Override
	public DispatcherType getDispatcherType() {
		return this.dispatcherType;
	}

	// ---------------------------------------------------------------------
	// HttpServletRequest interface
	// ---------------------------------------------------------------------

	public void setAuthType(String authType) {
		this.authType = authType;
	}

	@Override
	public String getAuthType() {
		return this.authType;
	}

	public void setCookies(Cookie... cookies) {
		this.cookies = cookies;
	}

	@Override
	public Cookie[] getCookies() {
		return this.cookies;
	}

	public void addHeader(String name, Object value) {
		if (CONTENT_TYPE_HEADER.equalsIgnoreCase(name)) {
			setContentType((String) value);
			return;
		}
		doAddHeaderValue(name, value, false);
	}

	@SuppressWarnings("rawtypes")
	private void doAddHeaderValue(String name, Object value, boolean replace) {
		this.headers.put(name, value);
	}

	@Override
	public long getDateHeader(String name) {
		return -1;
	}

	@Override
	public String getHeader(String name) {
		return headers.get(name).toString();
	}

	@Override
	public Enumeration<String> getHeaders(String name) {
		return null;
	}

	@Override
	public Enumeration<String> getHeaderNames() {
		return Collections.enumeration(this.headers.keySet());
	}

	@Override
	public int getIntHeader(String name) {
		return -1;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	@Override
	public String getMethod() {
		return this.method;
	}

	public void setPathInfo(String pathInfo) {
		this.pathInfo = pathInfo;
	}

	@Override
	public String getPathInfo() {
		return this.pathInfo;
	}

	@Override
	public String getPathTranslated() {
		return (this.pathInfo != null ? getRealPath(this.pathInfo) : null);
	}

	public void setContextPath(String contextPath) {
		this.contextPath = contextPath;
	}

	@Override
	public String getContextPath() {
		return this.contextPath;
	}

	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}

	@Override
	public String getQueryString() {
		return this.queryString;
	}

	public void setRemoteUser(String remoteUser) {
		this.remoteUser = remoteUser;
	}

	@Override
	public String getRemoteUser() {
		return this.remoteUser;
	}

	public void addUserRole(String role) {
		this.userRoles.add(role);
	}

	@Override
	public boolean isUserInRole(String role) {
		return true;
	}

	public void setUserPrincipal(Principal userPrincipal) {
		this.userPrincipal = userPrincipal;
	}

	@Override
	public Principal getUserPrincipal() {
		return this.userPrincipal;
	}

	public void setRequestedSessionId(String requestedSessionId) {
		this.requestedSessionId = requestedSessionId;
	}

	@Override
	public String getRequestedSessionId() {
		return this.requestedSessionId;
	}

	public void setRequestURI(String requestURI) {
		this.requestURI = requestURI;
	}

	@Override
	public String getRequestURI() {
		return this.requestURI;
	}

	@Override
	public StringBuffer getRequestURL() {
		StringBuffer url = new StringBuffer(this.scheme).append("://").append(this.serverName);

		if (this.serverPort > 0
				&& (("http".equalsIgnoreCase(scheme) && this.serverPort != 80)
						|| ("https".equalsIgnoreCase(scheme) && this.serverPort != 443))) {
			url.append(':').append(this.serverPort);
		}

		url.append(getRequestURI());

		return url;
	}

	public void setServletPath(String servletPath) {
		this.servletPath = servletPath;
	}

	@Override
	public String getServletPath() {
		return this.servletPath;
	}

	public void setSession(HttpSession session) {
		this.session = session;

	}

	@Override
	public HttpSession getSession(boolean create) {
		return this.session;
	}

	@Override
	public HttpSession getSession() {
		return getSession(true);
	}

	public String changeSessionId() {

		return "";
	}

	public void setRequestedSessionIdValid(boolean requestedSessionIdValid) {
		this.requestedSessionIdValid = requestedSessionIdValid;
	}

	@Override
	public boolean isRequestedSessionIdValid() {
		return this.requestedSessionIdValid;
	}

	public void setRequestedSessionIdFromCookie(boolean requestedSessionIdFromCookie) {
		this.requestedSessionIdFromCookie = requestedSessionIdFromCookie;
	}

	@Override
	public boolean isRequestedSessionIdFromCookie() {
		return this.requestedSessionIdFromCookie;
	}

	public void setRequestedSessionIdFromURL(boolean requestedSessionIdFromURL) {
		this.requestedSessionIdFromURL = requestedSessionIdFromURL;
	}

	@Override
	public boolean isRequestedSessionIdFromURL() {
		return this.requestedSessionIdFromURL;
	}

	@Override
	@Deprecated
	public boolean isRequestedSessionIdFromUrl() {
		return isRequestedSessionIdFromURL();
	}

	@Override
	public boolean authenticate(HttpServletResponse response) throws IOException, ServletException {
		throw new UnsupportedOperationException();
	}

	@Override
	public void login(String username, String password) throws ServletException {
		throw new UnsupportedOperationException();
	}

	@Override
	public void logout() throws ServletException {
		this.userPrincipal = null;
		this.remoteUser = null;
		this.authType = null;
	}

	public void addPart(Part part) {
		this.parts.put(part.getName(), part);
	}

	@Override
	public Part getPart(String name) throws IOException, IllegalStateException, ServletException {
		return this.parts.get(name);
	}

	@Override
	public Collection<Part> getParts() throws IOException, IllegalStateException, ServletException {
		return this.parts.values();
	}

	@Override
	public <T extends HttpUpgradeHandler> T upgrade(Class<T> handlerClass) throws IOException, ServletException {
		// TODO Auto-generated method stub
		return null;
	}

}
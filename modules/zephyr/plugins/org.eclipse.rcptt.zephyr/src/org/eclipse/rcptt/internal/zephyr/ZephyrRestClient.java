/*******************************************************************************
 * Copyright (c) 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.internal.zephyr;

import java.io.IOException;
import java.lang.IllegalStateException;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.AuthCache;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.BasicAuthCache;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public final class ZephyrRestClient {

	private static final String URL_GET_PROJECTS = "%s/rest/api/2/project?expand";
	private static final String URL_GET_USERS = "%s/rest/api/2/user?username=%s";
	private static final String URL_GET_ISSUETYPES = "%s/rest/api/2/issuetype";
	private static final String TEST_ISSSUETYPE_NAME = "Test";
	private static final long ISSUE_TYPE_ID = 10100L;

	private CloseableHttpClient httpclient;
	private HttpClientContext context;
	private final String url;
	private final String userName;
	private final String password;

	public ZephyrRestClient(String url, String userName, String password) {
		super();
		this.url = StringUtils.removeEnd(url, "/");
		this.userName = userName;
		this.password = password;
		createClientContext(this.url, this.userName, this.password);
		createHttpClient();
	}

	public void destroy() {
		if (httpclient != null) {
			try {
				httpclient.close();
			} catch (IOException e) {
				ZephyrPlugin.log(e);
			}
		}
	}

	public boolean validateConnection() {
		boolean status = false;

		final String constructedURL = String.format(URL_GET_PROJECTS, getUrl());
		try (final CloseableHttpResponse response = get(constructedURL)) {
			int statusCode = response.getStatusLine().getStatusCode();

			if (statusCode >= 200 && statusCode < 300) {
				final HttpEntity entity = response.getEntity();
				String string = null;
				try {
					string = EntityUtils.toString(entity);
					if (string.startsWith("[") && string.endsWith("]"))
						return true;
				} catch (IOException e) {
					ZephyrPlugin.log(e);
				}

			} else if (statusCode == 401) {
				return true;
			} else if (statusCode == 404) {
				return false;
			} else {
				ZephyrPlugin.log(String.format("Unexpected response status <%s> upon validate connection <%s>",
						statusCode, constructedURL));
			}
		} catch (IOException e) {
			ZephyrPlugin.log(e);
			return false;
		}
		return status;
	}

	public boolean validateCredentials() {
		boolean status = true;

		final String constructedURL = String.format(URL_GET_USERS, getUrl(), getUserName());
		try (final CloseableHttpResponse response = get(constructedURL)) {
			final int statusCode = response.getStatusLine().getStatusCode();

			if (statusCode == 401) {
				status = false;
			}
		} catch (IOException e) {
			throw new IllegalStateException("Failed to get " + constructedURL, e);
		}
		return status;
	}

	public long findZephyrTypeId() {
		long status = ISSUE_TYPE_ID;

		final String url = String.format(URL_GET_ISSUETYPES, getUrl());

		final Header[] headers = new Header[2];
		headers[0] = new BasicHeader("Content-Type", "application/json");
		headers[1] = new BasicHeader("Accept-Encoding", "gzip, deflate, sdch");

		try (final CloseableHttpResponse response = get(url, headers)) {

			int statusCode = response.getStatusLine().getStatusCode();

			if (statusCode >= 200 && statusCode < 300) {
				HttpEntity entity = response.getEntity();
				String string = null;
				try {
					string = EntityUtils.toString(entity, "utf-8");

					final JsonArray jArr = new JsonParser().parse(string).getAsJsonArray();
					jArr.add(string);

					for (int i = 0; i < jArr.size(); i++) {
						final JsonObject jObj = jArr.get(i).getAsJsonObject();
						if (jObj.get("name").getAsString().trim().equals(TEST_ISSSUETYPE_NAME)) {
							return jObj.get("id").getAsLong();
						}
					}
				} catch (IOException e) {
					ZephyrPlugin.log(String.format("Bad response entity upon receipt of zephyr type id <%s>", url), e);
				}

			} else if (statusCode == 401 || statusCode == 404) {
				return status;
			} else {
				ZephyrPlugin.log(String.format("Unexpected response status <%s> upon receipt of zephyr type id <%s>",
						statusCode, url));
			}
		} catch (IOException e) {
			throw new IllegalStateException("Failed to get " + url, e);
		}
		return status;
	}

	private HttpClientContext createClientContext(String hostAddressWithProtocol, String userName, String password) {
		URL url;
		try {
			url = new URL(hostAddressWithProtocol);
			final HttpHost targetHost = new HttpHost(url.getHost(), url.getPort(), url.getProtocol());
			final CredentialsProvider credsProvider = new BasicCredentialsProvider();
			credsProvider.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials(userName, password));

			final AuthCache authCache = new BasicAuthCache();
			authCache.put(targetHost, new BasicScheme());

			context = HttpClientContext.create();
			context.setCredentialsProvider(credsProvider);
			context.setAuthCache(authCache);
		} catch (MalformedURLException e) {
			throw new IllegalArgumentException(e);
		}

		return context;
	}

	private void createHttpClient() {
		try {
			final SSLContextBuilder builder = new SSLContextBuilder();
			builder.loadTrustMaterial(null, new TrustSelfSignedStrategy());
			final SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(builder.build(),
					SSLConnectionSocketFactory.getDefaultHostnameVerifier());
			httpclient = HttpClients.custom().setSSLSocketFactory(sslsf)/* .setDefaultRequestConfig(config) */.build();
		} catch (KeyManagementException | NoSuchAlgorithmException | KeyStoreException e) {
			throw new IllegalArgumentException(e);
		}
	}

	public CloseableHttpResponse get(final String url) {
		return get(new HttpGet(url));
	}

	public CloseableHttpResponse get(final String url, final Header[] headers) {
		final HttpGet httpGet = new HttpGet(url);
		for (final Header header : headers) {
			httpGet.addHeader(header);
		}
		return get(httpGet);
	}

	private CloseableHttpResponse get(final HttpGet httpGet) {
		try {
			return this.httpclient.execute(httpGet, this.context);
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}
	}

	public CloseableHttpResponse put(final String url, final Header[] headers, final HttpEntity entity) {
		final HttpPut httpPut = new HttpPut(url);
		for (final Header header : headers) {
			httpPut.addHeader(header);
		}
		httpPut.setEntity(entity);
		return put(httpPut);
	}

	private CloseableHttpResponse put(final HttpPut httpPut) {
		try {
			return this.httpclient.execute(httpPut, this.context);
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}
	}

	public String getUrl() {
		return url;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}
}

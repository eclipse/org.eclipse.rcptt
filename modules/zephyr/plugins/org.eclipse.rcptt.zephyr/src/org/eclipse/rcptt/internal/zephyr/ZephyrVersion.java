/*******************************************************************************
 * Copyright (c) 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.internal.zephyr;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;

import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

public final class ZephyrVersion {

	private static final String URL_GET_VERSIONS = "%s/rest/api/2/project/%s/versions?expand";

	public static Map<String, Long> getAllVersions(final ZephyrRestClient restClient, final Long projectID) {

		final Map<String, Long> versions = new HashMap<>();

		final String url = String.format(URL_GET_VERSIONS, restClient.getUrl(), projectID);
		try (final CloseableHttpResponse response = restClient.get(url)) {

			final int statusCode = response.getStatusLine().getStatusCode();

			if (statusCode >= 200 && statusCode < 300) {
				final HttpEntity entity = response.getEntity();
				String string = null;
				try {
					string = EntityUtils.toString(entity);
				} catch (ParseException | IOException e) {
					throw new IllegalArgumentException(
							String.format("Bad response entity upon receipt of versions <%s>", url), e);
				}

				final JsonArray projArray = new JsonParser().parse(string).getAsJsonArray();
				for (int i = 0; i < projArray.size(); i++) {
					final Long id = projArray.get(i).getAsJsonObject().get("id").getAsLong();
					final String projName = projArray.get(i).getAsJsonObject().get("name").getAsString();
					versions.put(projName, id);
				}
			} else {
				throw new IllegalArgumentException(String
						.format("Unexpected response status <%s> upon receipt of versions <%s>", statusCode, url));
			}
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}
		return versions;
	}

	public static Long getVersionIdByName(final ZephyrRestClient restClient, final Long projectId,
			final String versionName) {
		final Map<String, Long> versions = getAllVersions(restClient, projectId);
		final Long versionId = versions.get(versionName);
		if (versionId == null) {
			throw new IllegalArgumentException(String.format("Version <%s> not found among <%s>", versionName,
					String.join(", ", versions.keySet())));
		}
		return versionId;
	}
}

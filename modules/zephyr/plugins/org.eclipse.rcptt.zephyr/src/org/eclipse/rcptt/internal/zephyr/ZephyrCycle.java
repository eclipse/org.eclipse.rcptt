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
import java.util.Set;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public final class ZephyrCycle {

	private static final String URL_GET_CYCLES = "%s/rest/zapi/latest/cycle?projectId=%s&versionId=%s";

	public static Map<String, Long> getAllCycles(final ZephyrRestClient restClient, final long projectId,
			final long versionId) {

		final Map<String, Long> cycles = new HashMap<String, Long>();

		final String url = String.format(URL_GET_CYCLES, restClient.getUrl(), projectId, versionId);
		try (final CloseableHttpResponse response = restClient.get(url)) {
			final int statusCode = response.getStatusLine().getStatusCode();

			if (statusCode >= 200 && statusCode < 300) {
				final HttpEntity entity = response.getEntity();
				String string = null;
				try {
					string = EntityUtils.toString(entity);
				} catch (ParseException | IOException e) {
					throw new IllegalArgumentException(
							String.format("Bad response entity upon receipt of cycles <%s>", url), e);
				}

				final JsonObject projObj = new JsonParser().parse(string).getAsJsonObject();
				for (int i = 0; i < projObj.size(); i++) {
					final Set<String> keys = projObj.keySet();

					for (final String key : keys) {
						if (!key.trim().equals("recordsCount")) {
							final JsonObject cycleObject = projObj.get(key).getAsJsonObject();
							final String cycleName = cycleObject.get("name").getAsString();
							final long id = Long.parseLong(key);
							cycles.put(cycleName, id);
						}
					}
				}
			} else {
				throw new IllegalArgumentException(
						String.format("Unexpected response status <%s> upon receipt of cycles <%s>", statusCode, url));
			}
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}
		return cycles;
	}

	public static Long getCycleIdByName(final ZephyrRestClient restClient, final long projectId, final long versionId,
			final String cycleName) {
		final Map<String, Long> cycles = getAllCycles(restClient, projectId, versionId);
		final Long cycleId = cycles.get(cycleName);
		if (cycleId == null) {
			throw new IllegalArgumentException(
					String.format("Cycle <%s> not found among <%s>", cycleName, String.join(", ", cycles.keySet())));
		}
		return cycleId;
	}
}

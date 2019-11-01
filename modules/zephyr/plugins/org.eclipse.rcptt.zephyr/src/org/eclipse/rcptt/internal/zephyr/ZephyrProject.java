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
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public final class ZephyrProject {

	private static final String URL_GET_PROJECTS = "%s/rest/api/2/issue/createmeta";
	private static final String TEST_ISSSUETYPE_NAME = "Test";

	public static Map<String, Long> getAllProjects(ZephyrRestClient restClient) {

		final Map<String, Long> projects = new HashMap<>();

		final String url = String.format(URL_GET_PROJECTS, restClient.getUrl());
		try (final CloseableHttpResponse response = restClient.get(url)) {

			final int statusCode = response.getStatusLine().getStatusCode();

			if (statusCode >= 200 && statusCode < 300) {
				final HttpEntity entity = response.getEntity();
				String string = null;
				try {
					string = EntityUtils.toString(entity);
				} catch (ParseException | IOException e) {
					throw new IllegalArgumentException(
							String.format("Bad response entity upon receipt of projects <%s>", url), e);
				}

				final JsonObject projObject = new JsonParser().parse(string).getAsJsonObject();
				final JsonArray projArray = projObject.get("projects").getAsJsonArray();
				for (int i = 0; i < projArray.size(); i++) {
					final JsonObject project = projArray.get(i).getAsJsonObject();
					final Long id = project.get("id").getAsLong();
					final String projName = project.get("name").getAsString();
					final JsonArray issueTypes = project.get("issuetypes").getAsJsonArray();

					boolean issueTypeTesstExists = false;
					for (int j = 0; j < issueTypes.size(); j++) {
						final JsonObject issueType = issueTypes.get(j).getAsJsonObject();
						final String issueTypeName = issueType.get("name").getAsString();

						if (issueTypeName.trim().equalsIgnoreCase(TEST_ISSSUETYPE_NAME)) {
							issueTypeTesstExists = true;
							break;
						}
					}

					if (!issueTypeTesstExists) {
						continue;
					}
					projects.put(projName, id);
				}

			} else {
				throw new IllegalArgumentException(String
						.format("Unexpected response status <%s> upon receipt of projects <%s>", statusCode, url));
			}
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}
		return projects;
	}

	public static Long getProjectIdByName(final String projectName, final ZephyrRestClient restClient) {
		final Map<String, Long> projects = getAllProjects(restClient);
		final Long projectId = projects.get(projectName);
		if (projectId == null) {
			throw new IllegalArgumentException(String.format("Project <%s> not found among <%s>", projectName,
					String.join(", ", projects.keySet())));
		}
		return projectId;
	}
}

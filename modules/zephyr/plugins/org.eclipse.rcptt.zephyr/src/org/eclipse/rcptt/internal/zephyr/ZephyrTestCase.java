/*******************************************************************************
 * Copyright (c) 2019, 2020 Xored Software Inc and others.
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
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public final class ZephyrTestCase {

	public static final int PASS = 1;
	public static final int FAIL = 2;

	private static final String URL_GET_TEST_BY_NAME = "%s/rest/api/2/issue/%s";
	private static final String URL_CREATE_EXECUTIONS_URL = "%s/rest/zapi/latest/execution?projectId=%s&versionId=%s&cycleId=%s";
	private static final String URL_EXECUTE_TEST = "%s/rest/zapi/latest/execution/%s/execute";

	private static Map<Long, Long> fetchExecutionIds(ZephyrConfigModel zephyrData) {
		final Map<Long, Long> issueKeyExecutionIdMap = new HashMap<Long, Long>();
		final String url = String.format(URL_CREATE_EXECUTIONS_URL, zephyrData.getRestClient().getUrl(),
				zephyrData.getProjectId(), zephyrData.getVersionId(), zephyrData.getCycleId());

		try (final CloseableHttpResponse response = zephyrData.getRestClient().get(url)) {

			final int statusCode = response.getStatusLine().getStatusCode();

			if (statusCode >= 200 && statusCode < 300) {
				final HttpEntity entity = response.getEntity();
				String string = null;
				try {
					string = EntityUtils.toString(entity);
				} catch (IOException e) {
					throw new IllegalArgumentException(
							String.format("Bad response entity upon receipt of execution ids <%s>", url), e);
				}

				final JsonObject executionObject = new JsonParser().parse(string).getAsJsonObject();
				final JsonArray executions = executionObject.get("executions").getAsJsonArray();

				for (int i = 0; i < executions.size(); i++) {
					final JsonObject execution = executions.get(i).getAsJsonObject();
					final long issueKey = execution.get("issueId").getAsLong();
					final long executionId = execution.get("id").getAsLong();

					issueKeyExecutionIdMap.put(issueKey, executionId);
				}

			} else {
				throw new IllegalArgumentException(String
						.format("Unexpected response status <%s> upon receipt of execution ids <%s>", statusCode, url));
			}

		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}

		return issueKeyExecutionIdMap;
	}

	public static void processTestCaseDetails(ZephyrConfigModel zephyrData) {
		final Long testCaseId = searchTestCaseId(zephyrData);

		if (testCaseId == null) {
			ZephyrPlugin.log("Invalid Issue: " + zephyrData.getIssueName());
			return;
		}

		final Long testid = fetchExecutionIds(zephyrData).get(testCaseId);
		executeTest(zephyrData, testid);
	}

	public static void executeTest(ZephyrConfigModel zephyrData, Long testId) {
		final String url = String.format(URL_EXECUTE_TEST, zephyrData.getRestClient().getUrl(), testId);

		final Header[] headers = new Header[1];
		headers[0] = new BasicHeader("Content-Type", "application/json");

		final TestCaseResultModel testCase = zephyrData.getTestcase();
		final JsonObject obj = new JsonObject();
		obj.addProperty("status", testCase.getIsPassed() ? PASS : FAIL);
		obj.addProperty("comment", testCase.getComment());
		StringEntity entity = null;
		try {
			entity = new StringEntity(obj.toString());
		} catch (UnsupportedEncodingException e) {
			throw new IllegalArgumentException(String.format("Bad response entity upon execute test <%s>", url), e);
		}

		try (final CloseableHttpResponse response = zephyrData.getRestClient().put(url, headers, entity)) {

			final int statusCode = response.getStatusLine().getStatusCode();

			if (statusCode < 200 && statusCode >= 300) {
				throw new IllegalArgumentException(
						String.format("Unexpected response status <%s> upon execute test <%s>", statusCode, url));
			}

		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}
	}

	private static Long searchTestCaseId(ZephyrConfigModel zephyrData) {
		final String issueName = zephyrData.getIssueName();
		if (issueName == null) {
			return null;
		}
		
		final String url = String.format(URL_GET_TEST_BY_NAME, zephyrData.getRestClient().getUrl(),
				zephyrData.getIssueName());

		try (final CloseableHttpResponse response = zephyrData.getRestClient().get(url)) {

			final int statusCode = response.getStatusLine().getStatusCode();

			if (statusCode >= 200 && statusCode < 300) {
				final HttpEntity entity = response.getEntity();
				String string = null;
				try {
					string = EntityUtils.toString(entity);
				} catch (IOException e) {
					throw new IllegalArgumentException(
							String.format("Bad response entity upon receipt of issues <%s>", url), e);
				}

				final JsonObject testCaseIssue = new JsonParser().parse(string).getAsJsonObject();
				final long testId = testCaseIssue.get("id").getAsLong();
				return testId;
			} else {
				throw new IllegalArgumentException(
						String.format("Unexpected response status <%s> upon receipt of issues <%s>", statusCode, url));
			}

		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}
	}
}
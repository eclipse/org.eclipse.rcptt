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
	private static final int MAX_ISSUE_SEARCH_COUNT = 250;

	private static final String URL_GET_ALL_TESTS = "%s/rest/api/2/search?%sjql=project=%s&issuetype=%s&maxResults="
			+ MAX_ISSUE_SEARCH_COUNT + "&startAt=%s";
	private static final String URL_CREATE_EXECUTIONS_URL = "%s/rest/zapi/latest/execution?projectId=%s&versionId=%s&cycleId=%s";
	private static final String URL_EXECUTE_TEST = "%s/rest/zapi/latest/execution/%s/execute";

	public static Long getTestCaseId(ZephyrConfigModel zephyrData) {
		final String issueName = zephyrData.getIssueName();
		if (issueName == null) {
			return null;
		}

		final Map<String, Long> searchedTests = searchIssues(zephyrData);
		return searchedTests.get(issueName);
	}

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
		final Long testCaseId = getTestCaseId(zephyrData);

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

	private static Map<String, Long> searchIssues(ZephyrConfigModel zephyrData) {

		long searchIssueStartcount = -1L;
		long totalIssueCount = 0L;
		long searchedIsssuesCount = 0L;

		final Map<String, Long> searchedTests = new HashMap<String, Long>();

		do {
			final String url = String.format(URL_GET_ALL_TESTS, zephyrData.getRestClient().getUrl(),
					zephyrData.getProjectId(), zephyrData.getTestIssueTypeId(), searchIssueStartcount,
					searchIssueStartcount);
			JsonArray searchedIssues = null;

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

					final JsonObject testCaseIssues = new JsonParser().parse(string).getAsJsonObject();
					totalIssueCount = testCaseIssues.get("total").getAsLong();
					searchedIssues = testCaseIssues.get("issues").getAsJsonArray();

					searchedIsssuesCount += searchedIssues.size();
				} else {
					throw new IllegalArgumentException(String
							.format("Unexpected response status <%s> upon receipt of issues <%s>", statusCode, url));
				}

				if (searchedIssues != null && searchedIssues.size() > 0) {
					for (int i = 0; i < searchedIssues.size(); i++) {
						final JsonObject jsonObject = searchedIssues.get(i).getAsJsonObject();
						final long testId = jsonObject.get("id").getAsLong();
						final String testKey = jsonObject.get("key").getAsString().trim();

						searchedTests.put(testKey, testId);
					}
				}
			} catch (IOException e) {
				throw new IllegalArgumentException(e);
			}
		} while (searchedIsssuesCount < totalIssueCount);

		return searchedTests;
	}
}
/*******************************************************************************
 * Copyright (c) 2009, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.internal.testrail;

import java.text.MessageFormat;
import java.util.List;

import org.eclipse.rcptt.testrail.domain.TestRailTestCase;
import org.eclipse.rcptt.testrail.domain.TestRailTestResult;
import org.eclipse.rcptt.testrail.domain.TestRailTestRun;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

public class TestRailAPIClient {
	private static final String ENDPOINT = "index.php?/api/v2";
	private APIClient client;
	private String projectId;

	public TestRailAPIClient(String address, String username, String password, String projectId) {
		final String url = address + ENDPOINT;
		this.client = new APIClient(url, username, password);
		this.projectId = projectId.substring(1); // remove "P"
	}

	public void setUseUnicode(boolean useUnicode) {
		client.setUseUnicode(useUnicode);
	}

	public boolean isAvailable() {
		String method = MessageFormat.format("/get_cases/{0}", projectId);
		String response = client.sendGetRequest(method);
		return response != null;
	}

	public String getTestCasesString() {
		String method = MessageFormat.format("/get_cases/{0}", projectId);
		String response = client.sendGetRequest(method);
		if (response == null) {
			TestRailPlugin.log(Messages.TestRailAPIClient_FailedToGetTestCases);
			return null;
		}
		return response;
	}

	public static JsonArray getTestCasesJsonArray(String response) {
		JsonArray testCases = (JsonArray) new JsonParser().parse(response);
		return testCases;
	}

	public static List<TestRailTestCase> getTestCasesList(String response) {
		TypeToken<List<TestRailTestCase>> token = new TypeToken<List<TestRailTestCase>>() {
		};
		List<TestRailTestCase> testCases = new Gson().fromJson(response, token.getType());
		return testCases;
	}

	public TestRailTestRun addRun(TestRailTestRun testRunDraft) {
		String method = MessageFormat.format("/add_run/{0}", projectId);
		Gson gson = new GsonBuilder()
				.excludeFieldsWithoutExposeAnnotation()
				.disableHtmlEscaping()
				.create();
		String params = gson.toJson(testRunDraft).toString();
		String response = client.sendPostRequest(method, params);
		if (response == null) {
			TestRailPlugin.log(Messages.TestRailAPIClient_FailedToAddTestRun);
			return null;
		}

		TypeToken<TestRailTestRun> token = new TypeToken<TestRailTestRun>() {
		};
		TestRailTestRun testRun = new Gson().fromJson(response, token.getType());
		return testRun;
	}

	public void addResultForTestCase(TestRailTestResult testCaseResult) {
		String method = MessageFormat.format("/add_result_for_case/{0}/{1}",
				testCaseResult.getRunId(), testCaseResult.getCaseId());
		Gson gson = new GsonBuilder()
				.excludeFieldsWithoutExposeAnnotation()
				.disableHtmlEscaping()
				.create();
		String params = gson.toJson(testCaseResult).toString();
		String response = client.sendPostRequest(method, params);
		if (response == null) {
			TestRailPlugin.log(Messages.TestRailAPIClient_FailedToAddTestResult);
		}
	}
}

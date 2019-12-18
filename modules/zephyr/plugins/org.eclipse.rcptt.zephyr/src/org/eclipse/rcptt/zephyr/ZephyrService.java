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
package org.eclipse.rcptt.zephyr;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.net.ssl.SSLException;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.rcptt.internal.core.model.Q7TestCase;
import org.eclipse.rcptt.internal.launching.ExecutionSession;
import org.eclipse.rcptt.internal.launching.ecl.EclScenarioExecutable;
import org.eclipse.rcptt.internal.zephyr.ZephyrCycle;
import org.eclipse.rcptt.internal.zephyr.Messages;
import org.eclipse.rcptt.internal.zephyr.ZephyrProject;
import org.eclipse.rcptt.internal.zephyr.ZephyrRestClient;
import org.eclipse.rcptt.internal.zephyr.TestCaseResultModel;
import org.eclipse.rcptt.internal.zephyr.ZephyrTestCase;
import org.eclipse.rcptt.internal.zephyr.ZephyrVersion;
import org.eclipse.rcptt.internal.zephyr.ZephyrConfigModel;
import org.eclipse.rcptt.internal.zephyr.ZephyrPlugin;
import org.eclipse.rcptt.launching.ITestEngine;
import org.eclipse.rcptt.reporting.util.ReportUtils;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Node;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Report;

public final class ZephyrService implements ITestEngine {
	public static final String ZEPHYR_ISSUE = "zephyr-issue";

	private static final String TEST_ENGINE_ENABLED = "enabled";
	private static final String ZEPHYR_CONFIG_ADDRESS_PARAM = "baseUrl";
	private static final String ZEPHYR_CONFIG_USERNAME_PARAM = "username";
	private static final String ZEPHYR_CONFIG_PASSWORD_PARAM = "password";

	private boolean zephyrEnabled;
	private ZephyrConfigModel config;

	@Override
	public void testRunStarted(Map<String, String> config, List<Q7TestCase> tests) {
	}

	@Override
	public void testRunCompleted() {
		this.config.getRestClient().destroy();
	}

	@Override
	public void sessionStarted(ExecutionSession session) {
	}

	@Override
	public void sessionCompleted(ExecutionSession session) {

	}

	@Override
	public void executionStarted(EclScenarioExecutable scenario, Map<String, String> config) {
		applyConfig(scenario, config);

		if (!zephyrEnabled) {
			return;
		}
		final String issueName = this.getIssue((Q7TestCase) scenario.getActualElement());
		this.config.setIssueName(issueName);
	}

	@Override
	public void executionCompleted(EclScenarioExecutable scenario, Report report) {
		if (!zephyrEnabled) {
			return;
		}

		final Boolean passed = getZephyrStatus(scenario);
		if (passed == null)
			return;

		final TestCaseResultModel testcase = new TestCaseResultModel(passed, getZephyrComment(scenario, report));

		this.config.setTestcase(testcase);
		ZephyrTestCase.processTestCaseDetails(this.config);

	}

	private void applyConfig(final EclScenarioExecutable scenario, final Map<String, String> config) {
		final String address = config.get(ZEPHYR_CONFIG_ADDRESS_PARAM);
		final String username = config.get(ZEPHYR_CONFIG_USERNAME_PARAM);
		final String password = config.get(ZEPHYR_CONFIG_PASSWORD_PARAM);

		final IProject rcpttProject = getIProject(scenario);
		final String projectKey = ZephyrPlugin.getZephyrProject(rcpttProject);
		final String versionKey = ZephyrPlugin.getZephyrVersion(rcpttProject);
		final String cycleKey = ZephyrPlugin.getZephyrCycle(rcpttProject);

		this.zephyrEnabled = true;
		this.config = initializeZephyrData(address, username, password, projectKey, versionKey, cycleKey);
		ZephyrPlugin.logInfo(Messages.ZephyrService_SuccessfullyCreatedClient);
	}

	private Boolean getZephyrStatus(final EclScenarioExecutable scenario) {
		final int severity = scenario.getResultStatus().getSeverity();

		switch (severity) {
		case IStatus.OK:
		case IStatus.INFO:
			return true;
		case IStatus.WARNING:
		case IStatus.ERROR:
			return false;
		case IStatus.CANCEL:
			return null;
		}
		return null;
	}

	private static final String TESTRESULT_CONTEXT_PREFIX = "__Contexts:__ ";
	private static final String TESTRESULT_FAILMSG_PREFIX = "__Fail message:__\n";

	private String getZephyrComment(EclScenarioExecutable scenario, Report report) {
		String testCaseComment = "";

		final List<String> variantName = scenario.getVariantName();
		if (variantName != null && !variantName.isEmpty()) {
			String contextNames = variantName.stream().collect(Collectors.joining(", ")).toString();
			testCaseComment = TESTRESULT_CONTEXT_PREFIX + contextNames;
		}

		final int testCaseSeveriry = scenario.getResultStatus().getSeverity();
		if (testCaseSeveriry == IStatus.ERROR) {
			if (!testCaseComment.equals("")) {
				testCaseComment += "\n\n";
			}

			final Node reportRoot = report.getRoot();
			testCaseComment += TESTRESULT_FAILMSG_PREFIX + ReportUtils.getFailMessage(reportRoot);
		}

		return testCaseComment;
	}

	@Override
	public String validateParameter(String name, String value) {
		return null;
	}

	public Map<String, Long> getAllProjects() {
		return ZephyrProject.getAllProjects(getRestClient());
	}

	public Map<String, Long> getAllVersions(final Long zephyrProject) {
		return ZephyrVersion.getAllVersions(getRestClient(), zephyrProject);
	}

	public Map<String, Long> getAllCycles(final Long zephyrProject, final Long zephyrVersion) {
		return ZephyrCycle.getAllCycles(getRestClient(), zephyrProject, zephyrVersion);
	}

	private ZephyrRestClient getRestClient() {
		final String host = ZephyrPlugin.getZephyrAddress();
		final String username = ZephyrPlugin.getZephyrUsername();
		final String password = ZephyrPlugin.getZephyrPassword();
		return new ZephyrRestClient(host, username, password);
	}

	private String getIssue(final Q7TestCase testCase) {
		try {
			final String testCaseId = testCase.getProperties().get(ZEPHYR_ISSUE);
			if (testCaseId == null) {
				ZephyrPlugin.logInfo(
						MessageFormat.format(Messages.ZephyrService_TestCasePropertyIsNotSpecified, ZEPHYR_ISSUE));
				return null;
			}
			return testCaseId;
		} catch (Exception e) {
			ZephyrPlugin.log(
					MessageFormat.format(Messages.ZephyrService_ErrorWhileGettingTestCaseProperty, ZEPHYR_ISSUE), e);
			return null;
		}
	}

	public IStatus doTestConnection(final String host, final String username, final String password) {

		final String serverAddress = StringUtils.removeEnd(host, "/");

		if (StringUtils.isBlank(serverAddress)) {
			return ZephyrPlugin.createStatus(IStatus.ERROR, "Please enter the server name");
		}

		if (StringUtils.isBlank(username)) {
			return ZephyrPlugin.createStatus(IStatus.ERROR, "Please enter the username");
		}

		if (StringUtils.isBlank(password)) {
			return ZephyrPlugin.createStatus(IStatus.ERROR, "Please enter the password");
		}

		if (!(serverAddress.trim().startsWith("https://") || serverAddress.trim().startsWith("http://"))) {
			return ZephyrPlugin.createStatus(IStatus.ERROR, "Incorrect server address format");
		}

		final String jiraURL = validateURL(serverAddress);

		if (!jiraURL.startsWith("http")) {
			return ZephyrPlugin.createStatus(IStatus.ERROR, jiraURL);
		}
		final ZephyrRestClient restClient = new ZephyrRestClient(serverAddress, username, password);

		if (!restClient.validateConnection()) {
			return ZephyrPlugin.createStatus(IStatus.ERROR, "This is not a valid Jira Server");
		}

		if (!restClient.validateCredentials()) {
			return ZephyrPlugin.createStatus(IStatus.ERROR, "Invalid user credentials");
		}
		restClient.destroy();
		return ZephyrPlugin.createStatus(IStatus.OK, "Connection to JIRA has been validated");
	}

	public static String validateURL(String string) {
		StringBuilder builder = new StringBuilder();
		try {
			final URL url = new URL(string);
			final URLConnection conn = url.openConnection();
			conn.connect();
			conn.getInputStream().close();

			builder.append(url.getProtocol());
			builder.append("://");
			builder.append(url.getHost());

			final int port = url.getPort();
			if (port > 0) {
				builder.append(":");
				builder.append(port);

			}
		} catch (MalformedURLException e) {
			return Messages.ZephyrService_UrlInvalid;
		} catch (SSLException e) {
			return Messages.ZephyrService_UrlSslError;
		} catch (IOException e) {
			return Messages.ZephyrService_UrlConnectionError;
		}
		return builder.toString();
	}

	private ZephyrConfigModel initializeZephyrData(final String host, final String username, final String password,
			final String projectKey, final String versionKey, final String cycleKey) {
		final ZephyrConfigModel zephyrConfig = new ZephyrConfigModel();

		zephyrConfig.setRestClient(new ZephyrRestClient(host, username, password));
		zephyrConfig.setTestIssueTypeId(zephyrConfig.getRestClient().findZephyrTypeId());

		zephyrConfig.setZephyrProjectId(ZephyrProject.getProjectIdByName(projectKey, zephyrConfig.getRestClient()));
		zephyrConfig.setVersionId(ZephyrVersion.getVersionIdByName(zephyrConfig.getRestClient(),
				zephyrConfig.getProjectId(), versionKey));
		zephyrConfig.setCycleId(ZephyrCycle.getCycleIdByName(zephyrConfig.getRestClient(), zephyrConfig.getProjectId(),
				zephyrConfig.getVersionId(), cycleKey));

		return zephyrConfig;
	}

	private IProject getIProject(final EclScenarioExecutable scenario) {
		return scenario.getActualElement().getParent().getParent().getQ7Project().getProject();
	}

	@Override
	public void setConfiguration(Map<String, String> config) {
		final String isEnabled = config.get(TEST_ENGINE_ENABLED);
		final boolean state = isEnabled == null ? true : Boolean.getBoolean(isEnabled);
		ZephyrPlugin.setZephyrEnabled(state);

		final String address = config.get(ZEPHYR_CONFIG_ADDRESS_PARAM);
		ZephyrPlugin.setZephyrAddress(address);

		final String username = config.get(ZEPHYR_CONFIG_USERNAME_PARAM);
		ZephyrPlugin.setZephyrUsername(username);

		final String password = config.get(ZEPHYR_CONFIG_PASSWORD_PARAM);
		ZephyrPlugin.setZephyrPassword(password);
	}

	@Override
	public Map<String, String> getConfiguration() {
		final Map<String, String> config = new HashMap<String, String>();

		final boolean isEnabled = ZephyrPlugin.getZephyrEnabled();
		config.put(TEST_ENGINE_ENABLED, Boolean.toString(isEnabled));

		final String address = ZephyrPlugin.getZephyrAddress();
		config.put(ZEPHYR_CONFIG_ADDRESS_PARAM, address);

		final String username = ZephyrPlugin.getZephyrUsername();
		config.put(ZEPHYR_CONFIG_USERNAME_PARAM, username);

		final String password = ZephyrPlugin.getZephyrPassword();
		config.put(ZEPHYR_CONFIG_PASSWORD_PARAM, password);

		return config;
	}
}

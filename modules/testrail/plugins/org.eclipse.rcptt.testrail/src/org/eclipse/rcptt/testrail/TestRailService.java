/*******************************************************************************
 * Copyright (c) 2009, 2016 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.testrail;

import java.net.URL;
import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.Launch;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.rcptt.internal.core.model.Q7TestCase;
import org.eclipse.rcptt.internal.launching.Executable;
import org.eclipse.rcptt.internal.launching.ExecutionSession;
import org.eclipse.rcptt.internal.launching.GroupExecutable;
import org.eclipse.rcptt.internal.launching.PrepareExecutionWrapper;
import org.eclipse.rcptt.internal.launching.ecl.EclScenarioExecutable;
import org.eclipse.rcptt.internal.testrail.Messages;
import org.eclipse.rcptt.internal.testrail.TestRailAPIClient;
import org.eclipse.rcptt.internal.testrail.TestRailPlugin;
import org.eclipse.rcptt.launching.IExecutable;
import org.eclipse.rcptt.launching.ITestEngine;
import org.eclipse.rcptt.reporting.util.ReportUtils;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Node;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Report;
import org.eclipse.rcptt.testrail.domain.TestRailStepResult;
import org.eclipse.rcptt.testrail.domain.TestRailTestResult;
import org.eclipse.rcptt.testrail.domain.TestRailTestRun;

public class TestRailService implements ITestEngine {
	private static final String TESTRAIL_ID_PARAM = "testrail-id";
	private static final String TESTRAILCONFIG_ADDRESS_PARAM = "host";
	private static final String TESTRAILCONFIG_USERNAME_PARAM = "username";
	private static final String TESTRAILCONFIG_PASSWORD_PARAM = "password";
	private static final String TESTRAILCONFIG_PROJECTID_PARAM = "projectId";
	private static final String TESTRAILCONFIG_TESTRUNID_PARAM = "testRunId";
	private static final String TESTRAILCONFIG_USEUNICODE_PARAM = "useUnicode";
	private static final String TESTRESULT_CONTEXT_PREFIX = "__Contexts:__ ";
	private static final String TESTRESULT_FAILMSG_PREFIX = "__Fail message:__\n";
	private static final String TESTRUN_DEFAULT_NAME = "Tests";
	private static final String TESTRAILSTEP_PROPERTYNAME = "test-rail-step:{0}";
	private static final String TESTRAIL_PROJECTID_PREFIX = "P";
	private static final String TESTRAIL_TESTRUNID_PREFIX = "R";
	private static final String TESTRAIL_TESTCASEID_PREFIX = "C";

	private TestRailAPIClient testRailAPI;
	private boolean testRailEnabled;
	private String testRunId;
	private Map<String, String> config;

	public TestRailService() {
	}

	@Override
	public void testRunStarted(Map<String, String> config, List<Q7TestCase> tests) {
		applyConfig(config);
		if (testRunId != null) {
			return;
		}

		TestRailTestRun testRunDraft = createTestRunDraft(tests);
		if (testRunDraft == null) {
			return;
		}

		TestRailTestRun testRun = testRailAPI.addRun(testRunDraft);
		if (testRun != null) {
			this.testRunId = testRun.getId();
		}
	}

	@Override
	public void testRunCompleted() {
		cleanConfig();
	}

	@Override
	public void sessionStarted(ExecutionSession session) {
		if (config == null || config.isEmpty()) {
			applyDefaultConfig();
		} else {
			return;
		}
		if (!testRailEnabled) {
			return;
		}
		if (testRailAPI == null) {
			return;
		}

		String runId = getLaunchTestRunId(session);
		if (runId != null && !runId.equals("")) {
			this.testRunId = runId;
			return;
		}

		TestRailTestRun testRunDraft = createTestRunDraft(session);
		if (testRunDraft == null) {
			return;
		}

		TestRailTestRun testRun = testRailAPI.addRun(testRunDraft);
		if (testRun != null) {
			this.testRunId = testRun.getId();
		}
	}

	@Override
	public void sessionCompleted(ExecutionSession session) {
	}

	@Override
	public void executionStarted(EclScenarioExecutable scenario) {
	}

	@Override
	public void executionCompleted(EclScenarioExecutable scenario, Report report) {
		if (!testRailEnabled) {
			return;
		}
		if (testRailAPI == null) {
			return;
		}
		if (testRunId == null) {
			return;
		}

		TestRailTestResult testResultDraft = createTestResultDraft(scenario, report);
		if (testResultDraft == null) {
			return;
		}

		testRailAPI.addResultForTestCase(testResultDraft);
	}

	@Override
	public String validateParameter(String name, String value) {
		if (name.equals(TESTRAILCONFIG_ADDRESS_PARAM)) {
			return validateUrl(value);
		}
		if (name.equals(TESTRAILCONFIG_PROJECTID_PARAM)) {
			return validateTestRailId(TESTRAIL_PROJECTID_PREFIX, value);
		}
		if (name.equals(TESTRAILCONFIG_TESTRUNID_PARAM)) {
			return validateTestRailId(TESTRAIL_TESTRUNID_PREFIX, value);
		}
		if (name.equals(TESTRAILCONFIG_USEUNICODE_PARAM)) {
			return validateBoolean(value);
		}
		return null;
	}

	private void applyDefaultConfig() {
		this.testRunId = null;
		this.testRailEnabled = TestRailPlugin.getTestRailState();
		if (!testRailEnabled) {
			TestRailPlugin.logInfo(Messages.TestRailService_TestRailIsNotEnabled);
			this.testRailAPI = null;
			return;
		}
		String address = TestRailPlugin.getTestRailAddress();
		String username = TestRailPlugin.getTestRailUsername();
		String password = TestRailPlugin.getTestRailPassword();
		if (password == null) {
			TestRailPlugin.log(Messages.TestRailService_FailedToSetUpConnection);
			this.testRailAPI = null;
			return;
		}
		String projectId = TestRailPlugin.getTestRailProjectId();
		boolean useUnicode = TestRailPlugin.getTestRailUseUnicode();

		this.testRailAPI = new TestRailAPIClient(address, username, password, projectId);
		testRailAPI.setUseUnicode(useUnicode);
		TestRailPlugin.logInfo(Messages.TestRailService_SuccessfullyCreatedClient);
	}

	private void applyConfig(Map<String, String> config) {
		String address = config.get(TESTRAILCONFIG_ADDRESS_PARAM);
		String username = config.get(TESTRAILCONFIG_USERNAME_PARAM);
		String password = config.get(TESTRAILCONFIG_PASSWORD_PARAM);
		String projectId = config.get(TESTRAILCONFIG_PROJECTID_PARAM);
		String runId = config.get(TESTRAILCONFIG_TESTRUNID_PARAM);
		String useUnicode = config.get(TESTRAILCONFIG_USEUNICODE_PARAM);

		if (runId != null && !runId.equals("")) {
			this.testRunId = runId.substring(1); // remove "R"
		} else {
			this.testRunId = null;
		}
		this.testRailEnabled = true;
		this.testRailAPI = new TestRailAPIClient(address, username, password, projectId);
		if (useUnicode != null && !useUnicode.equals("")) {
			testRailAPI.setUseUnicode("true".equalsIgnoreCase(useUnicode));
		}
		this.config = config;
		TestRailPlugin.logInfo(Messages.TestRailService_SuccessfullyCreatedClient);
	}

	private void cleanConfig() {
		this.testRunId = null;
		this.testRailEnabled = false;
		this.testRailAPI = null;
		this.config = Collections.emptyMap();
	}

	private String getLaunchTestRunId(ExecutionSession session) {
		ILaunchConfiguration configuration = ((Launch) session.getLaunch()).getLaunchConfiguration();
		String runId = "";
		try {
			runId = configuration.getAttribute(TestRailPlugin.LAUNCH_TESTRUNID, "");
			if (!runId.equals("")) {
				return runId.substring(1); // remove "R"
			}
		} catch (CoreException e) {
			TestRailPlugin.log(MessageFormat.format(Messages.TestRailService_ErrorWhileGettingLaunchProperty,
					TestRailPlugin.LAUNCH_TESTRUNID), e);
		}
		return null;
	}

	private TestRailTestRun createTestRunDraft(ExecutionSession session) {
		String name = getTestRunName(session.getName());
		Set<String> caseIds = getTestRunCaseIds(session);
		if (caseIds.isEmpty()) {
			return null;
		}

		TestRailTestRun testRunDraft = new TestRailTestRun();
		testRunDraft.setName(name);
		testRunDraft.setIncludeAll(false);
		testRunDraft.setCaseIds(caseIds);
		return testRunDraft;
	}

	private TestRailTestRun createTestRunDraft(List<Q7TestCase> tests) {
		String name = getTestRunName(TESTRUN_DEFAULT_NAME);
		Set<String> caseIds = tests.stream()
				.map(test -> getTestRailId(test))
				.filter(testRailId -> testRailId != null && !testRailId.equals(""))
				.collect(Collectors.toSet());
		if (caseIds.isEmpty()) {
			return null;
		}

		TestRailTestRun testRunDraft = new TestRailTestRun();
		testRunDraft.setName(name);
		testRunDraft.setIncludeAll(false);
		testRunDraft.setCaseIds(caseIds);
		return testRunDraft;
	}

	private TestRailTestResult createTestResultDraft(EclScenarioExecutable scenario, Report report) {
		Q7TestCase testCase = (Q7TestCase) scenario.getActualElement();
		String testCaseId = getTestRailId(testCase);
		if (testCaseId == null) {
			return null;
		}

		String testCaseStatus = getTestRailStatus(scenario);
		if (testCaseStatus == null) {
			TestRailPlugin.logInfo(Messages.TestRailService_TestCaseCanceled);
			return null;
		}

		String testCaseDuration = getTestRailDuration(report);
		String testCaseComment = getTestRailComment(scenario, report);
		List<TestRailStepResult> stepResults = getTestRailStepResults(report);

		TestRailTestResult testResultDraft = new TestRailTestResult();
		testResultDraft.setRunId(testRunId);
		testResultDraft.setCaseId(testCaseId);
		testResultDraft.setStatus(testCaseStatus);
		testResultDraft.setElapsed(testCaseDuration);
		testResultDraft.setComment(testCaseComment);
		testResultDraft.setStepResults(stepResults);
		return testResultDraft;
	}

	private EclScenarioExecutable getScenario(Executable wrapper) {
		if (wrapper instanceof PrepareExecutionWrapper) {
			IExecutable executable = ((PrepareExecutionWrapper) wrapper).getExecutable();
			if (executable instanceof GroupExecutable) {
				IExecutable scenario = ((GroupExecutable) executable).getRoot();
				if (scenario instanceof EclScenarioExecutable)
					return (EclScenarioExecutable) scenario;
			}
		}
		return null;
	}

	private String getTestRailId(Q7TestCase testCase) {
		try {
			String testCaseId = testCase.getProperties().get(TESTRAIL_ID_PARAM);
			if (testCaseId == null) {
				TestRailPlugin.logInfo(
						MessageFormat.format(Messages.TestRailService_TestCasePropertyIsNotSpecified,
								TESTRAIL_ID_PARAM));
				return null;
			}
			String message = validateTestRailId(TESTRAIL_TESTCASEID_PREFIX, testCaseId);
			if (message != null) {
				TestRailPlugin.log(
						MessageFormat.format(Messages.TestRailService_InvalidParameterValue,
								TESTRAIL_ID_PARAM, message));
				return null;
			}
			return testCaseId.substring(1); // remove "C"
		} catch (Exception e) {
			TestRailPlugin.log(
					MessageFormat.format(Messages.TestRailService_ErrorWhileGettingTestCaseProperty,
							TESTRAIL_ID_PARAM),
					e);
			return null;
		}
	}

	private String getTestRunName(String name) {
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm");
		LocalDateTime localDate = LocalDateTime.now();
		return MessageFormat.format("{0} {1}", name, dateFormatter.format(localDate));
	}

	private Set<String> getTestRunCaseIds(ExecutionSession session) {
		final Executable[] executables = session.getExecutables();
		final List<Q7TestCase> testCases = Arrays.stream(executables)
				.map(wrapper -> (Q7TestCase) getScenario(wrapper).getActualElement())
				.filter(testCase -> testCase != null)
				.collect(Collectors.toList());

		final Set<String> caseIds = testCases.stream()
				.map(scenario -> getTestRailId(scenario))
				.filter(testRailId -> testRailId != null && !testRailId.equals(""))
				.collect(Collectors.toSet());

		return caseIds;
	}

	private String getTestRailDuration(Report report) {
		Node reportRoot = report.getRoot();
		long duration = (reportRoot.getEndTime() - reportRoot.getStartTime()) / 1000;

		if (duration != 0) {
			return MessageFormat.format("{0}s", String.format("%d", duration));
		}
		return null;
	}

	private String getTestRailStatus(EclScenarioExecutable scenario) {
		int severity = scenario.getResultStatus().getSeverity();

		switch (severity) {
		case IStatus.OK:
		case IStatus.INFO:
			return "1";
		case IStatus.WARNING:
		case IStatus.ERROR:
			return "5";
		case IStatus.CANCEL:
			return null;
		}
		return null;
	}

	private String getTestRailComment(EclScenarioExecutable scenario, Report report) {
		String testCaseComment = "";

		List<String> variantName = scenario.getVariantName();
		if (variantName != null && !variantName.isEmpty()) {
			String contextNames = variantName.stream()
					.collect(Collectors.joining(", "))
					.toString();
			testCaseComment = TESTRESULT_CONTEXT_PREFIX + contextNames;
		}

		int testCaseSeveriry = scenario.getResultStatus().getSeverity();
		if (testCaseSeveriry == IStatus.ERROR) {
			if (!testCaseComment.equals("")) {
				testCaseComment += "\n\n";
			}

			Node reportRoot = report.getRoot();
			testCaseComment += TESTRESULT_FAILMSG_PREFIX + ReportUtils.getFailMessage(reportRoot);
		}

		return testCaseComment;
	}

	private List<TestRailStepResult> getTestRailStepResults(Report report) {
		Node reportRoot = report.getRoot();
		List<TestRailStepResult> results = new ArrayList<TestRailStepResult>();
		EMap<String, EObject> props = reportRoot.getProperties();
		int id = 1;
		String prop = generateStepName(id);
		while (props.get(prop) != null) {
			EObject obj = props.get(prop);
			if (obj instanceof TestRailStep) {
				TestRailStep step = (TestRailStep) obj;
				TestRailStepResult result = new TestRailStepResult();
				result.setContent(step.getContent());
				result.setExpected(step.getExpected());
				result.setActual(step.getActual());
				int status = step.getStatus().getValue();
				if (status != TestRailStepStatus.UNTESTED_VALUE) {
					result.setStatus(String.valueOf(status));
				}
				results.add(result);
			}
			id++;
			prop = generateStepName(id);
		}
		return results;
	}

	private String generateStepName(int id) {
		return MessageFormat.format(TESTRAILSTEP_PROPERTYNAME, String.valueOf(id));
	}

	private String validateTestRailId(String prefix, String value) {
		String message = MessageFormat.format(Messages.TestRailService_InvalidTestRailId, prefix);
		if (!value.startsWith(prefix)) {
			return message;
		}
		try {
			String idString = value.substring(1); // remove prefix
			int parsedValue = Integer.parseInt(idString);
			if (parsedValue <= 0) {
				return message;
			}
		} catch (Exception e) {
			return message;
		}
		return null;
	}

	private String validateUrl(String value) {
		try {
			URL url = new URL(value);
			if (url.getHost().equals("")) {
				return Messages.TestRailService_InvalidURL;
			}
		} catch (Exception e) {
			return Messages.TestRailService_InvalidURL;
		}
		if (!value.endsWith("/")) {
			return Messages.TestRailService_URLShouldEndsWithSlash;
		}
		return null;
	}

	private String validateBoolean(String value) {
		if (!"true".equalsIgnoreCase(value) && !"false".equalsIgnoreCase(value)) {
			return Messages.TestRailService_InvalidBoolean;
		}
		return null;
	}
}

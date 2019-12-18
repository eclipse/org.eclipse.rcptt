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

public final class ZephyrConfigModel {

	private TestCaseResultModel testcase;
	private Long projectId;
	private Long versionId;
	private Long cycleId;
	private String IssueName;
	private long zephyrTypeId;
	private ZephyrRestClient restClient;

	public String getIssueName() {
		return IssueName;
	}

	public void setIssueName(String testIssueId) {
		this.IssueName = testIssueId;
	}

	public long getTestIssueTypeId() {
		return zephyrTypeId;
	}

	public void setTestIssueTypeId(long testIssueTypeId) {
		this.zephyrTypeId = testIssueTypeId;
	}

	public TestCaseResultModel getTestcase() {
		return testcase;
	}

	public void setTestcase(TestCaseResultModel testcase) {
		this.testcase = testcase;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setZephyrProjectId(Long zephyrProjectId) {
		this.projectId = zephyrProjectId;
	}

	public Long getCycleId() {
		return cycleId;
	}

	public void setCycleId(Long cycleId) {
		this.cycleId = cycleId;
	}

	public ZephyrRestClient getRestClient() {
		return restClient;
	}

	public void setRestClient(ZephyrRestClient restClient) {
		this.restClient = restClient;
	}

	public Long getVersionId() {
		return versionId;
	}

	public void setVersionId(Long versionId) {
		this.versionId = versionId;
	}
}
package org.eclipse.rcptt.testrail.domain;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TestRailTestResult {
	@Expose(serialize = false)
	private String runId;
	@Expose(serialize = false)
	private String caseId;
	@SerializedName("status_id")
	private String status;
	private String elapsed;
	private String comment;
	@SerializedName("custom_step_results")
	private List<TestRailStepResult> stepResults;

	public TestRailTestResult() {
	}

	public String getRunId() {
		return runId;
	}

	public void setRunId(String runId) {
		this.runId = runId;
	}

	public String getCaseId() {
		return caseId;
	}

	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setElapsed(String elapsed) {
		this.elapsed = elapsed;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public void setStepResults(List<TestRailStepResult> stepResults) {
		this.stepResults = stepResults;
	}
}

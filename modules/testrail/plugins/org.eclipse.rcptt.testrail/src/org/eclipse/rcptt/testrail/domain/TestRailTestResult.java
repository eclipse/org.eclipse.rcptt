package org.eclipse.rcptt.testrail.domain;

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
}

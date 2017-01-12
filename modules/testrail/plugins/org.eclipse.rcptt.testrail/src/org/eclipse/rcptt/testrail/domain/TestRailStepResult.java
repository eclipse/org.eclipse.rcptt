package org.eclipse.rcptt.testrail.domain;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TestRailStepResult {
	@Expose
	private String content;
	@Expose
	private String expected;
	@Expose
	private String actual;
	@Expose
	@SerializedName("status_id")
	private String status;

	public TestRailStepResult() {
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setExpected(String expected) {
		this.expected = expected;
	}

	public void setActual(String actual) {
		this.actual = actual;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}

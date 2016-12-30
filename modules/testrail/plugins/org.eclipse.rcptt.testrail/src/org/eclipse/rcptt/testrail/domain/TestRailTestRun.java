package org.eclipse.rcptt.testrail.domain;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TestRailTestRun {
	@Expose(serialize = false)
	private String id;
	private String name;
	@SerializedName("include_all")
	private boolean includeAll;
	@SerializedName("case_ids")
	private List<String> caseIds;

	public TestRailTestRun() {
		this.includeAll = false;
	}

	public String getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setIncludeAll(boolean includeAll) {
		this.includeAll = includeAll;
	}

	public void setCaseIds(List<String> caseIds) {
		this.caseIds = caseIds;
	}
}

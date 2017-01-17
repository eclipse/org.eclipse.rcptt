package org.eclipse.rcptt.testrail.domain;

import java.util.Set;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TestRailTestRun {
	@Expose(serialize = false)
	private String id;
	@Expose
	private String name;
	@Expose
	@SerializedName("include_all")
	private boolean includeAll;
	@Expose
	@SerializedName("case_ids")
	private Set<String> caseIds;

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

	public void setCaseIds(Set<String> caseIds) {
		this.caseIds = caseIds;
	}
}

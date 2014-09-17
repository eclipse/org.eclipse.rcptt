package org.eclipse.rcptt.ui.report.internal;

import org.eclipse.rcptt.reporting.ResultStatus;

class ReportEntry {
	public String name;
	public String id;
	public int time;
	public ResultStatus status;
	public String message = "";
	public boolean warning = false;
}
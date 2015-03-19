package org.eclipse.rcptt.reporting.html;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Node;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Report;
import org.eclipse.rcptt.util.FileUtil;

import com.google.common.base.Charsets;

public class HtmlReporter extends HtmlReportRenderer {
	private int nameIndex = 0;

	private String getNewFileName(Node node, IContentFactory factory) {
		String prefix = "_" + getNodeName(node);
		String fname = prefix + ".html";
		fname = prefix + "_" + (nameIndex++) + ".html";
		return fname;
	}

	@Override
	protected void renderFailed(PrintWriter writer, IContentFactory content, Iterable<Report> failedReports)
			throws CoreException {
		writer.println("<table class=\"failed\">");
		for (Report report: failedReports) {
			renderNameAndDuration(writer, report, content);
		}
		writer.println("</table>");
	}

	
	@Override
	protected void renderNameAndDuration(PrintWriter writer, Report report, IContentFactory content)
			throws CoreException {
		Node root = report.getRoot();
		long millseconds = root.getEndTime() - root.getStartTime();
		String duration = durationFormat.format((float) (millseconds) / 1000f);
		writer.println("<tr><td>");
		String fileName = getNewFileName(root, content);
		PrintWriter childWriter = null;
		try {
			OutputStream os = content.createFileStream(fileName);
			childWriter = new PrintWriter(new OutputStreamWriter(os, Charsets.UTF_8));
			childWriter.println("<html>");
			// TODO:add style
			childWriter.println("<head><title>"+root.getName()+"</title></head>");
			childWriter.println("<body>");
			renderFailed(writer, report, content);
			childWriter.println("</body></html>");
		} finally {
			FileUtil.safeClose(childWriter);
		}
		writer.println(String.format("<a href=\"%s\">%s</a>", fileName, root.getName()));
		writer.println("</td><td>" + duration + " s</td></tr>");
	}
}

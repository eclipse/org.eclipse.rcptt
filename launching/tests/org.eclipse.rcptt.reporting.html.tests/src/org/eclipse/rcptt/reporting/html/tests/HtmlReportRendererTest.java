package org.eclipse.rcptt.reporting.html.tests;

import static java.util.Arrays.asList;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.rcptt.internal.core.RcpttPlugin;
import org.eclipse.rcptt.reporting.core.FileContentFactory;
import org.eclipse.rcptt.reporting.core.Q7ReportIterator;
import org.eclipse.rcptt.reporting.core.ReportHelper;
import org.eclipse.rcptt.reporting.html.HtmlReportRenderer;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Node;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Report;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.ReportFactory;
import org.eclipse.rcptt.util.FileUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HtmlReportRendererTest {
	private VolatileContentFactory contentFactory;
	private HtmlReportRenderer renderer;

	@Before
	public void before() {
		contentFactory = new VolatileContentFactory();
		renderer = new HtmlReportRenderer();
	}

	@Test
	public void testNoPlaceholders() {
		String result = generate(Collections.<Report> emptyList());
		Assert.assertTrue("Even empty report should have summary", result.length() > 300);
		Assert.assertFalse("All placeholders should be replaced with numbers", result.contains("$"));
	}

	@Test
	public void testNoRoot() {
		Report report = ReportFactory.eINSTANCE.createReport();
		String result = generate(report);
		Assert.assertFalse("Broken report should be represented as nice as possible", result.contains("NullPointer"));
	}


	private Report createReport(String name, int severity) {
		Report report = ReportFactory.eINSTANCE.createReport();
		report.setRoot(createNode(name, severity));
		return report;
	}

	private Node createNode(String name, int severity) {
		Node node = ReportFactory.eINSTANCE.createNode();
		node.setName(name);
		ReportHelper.getInfo(node).setResult(RcpttPlugin.createProcessStatus(severity, "No message"));
		return node;
	}

	@Test
	public void testStylingOfDifferentResults() {
		String result = generate(Arrays.asList(createReport("1", IStatus.ERROR), createReport("2", IStatus.OK),
				createReport("3", IStatus.CANCEL)));
		Assert.assertTrue("Failed tests has red titles", result.contains("<h1 class=\"failure\">Failed Tests (1)</h1>"));
		Assert.assertTrue("Failed tests has red titles", result.contains("<h2 class=\"failure\">1</h2>"));
		Assert.assertTrue("Failed tests has red titles",
				result.contains("<h1 class=\"skipped\">Skipped Tests (1)</h1>"));
		Assert.assertTrue("Test 3 should be in a table", result.contains("<td>3</td>"));
		Assert.assertTrue("Failed tests has red titles", result.contains("<h1 class=\"passed\">Passed Tests (1)</h1>"));
		Assert.assertTrue("Test 2 should be in a table", result.contains("<td>2</td>"));
	}

	private String generate(Iterable<Report> reports) {
		renderer.generateReport(contentFactory, "1", reports);
		String result = contentFactory.read("1.html");
		Assert.assertTrue("Whole report should be generated", result.contains("Passed Tests ("));
		return result;
	}

	private String generate(Report report) {
		return generate(asList(report));
	}


	@Test
	public void testStyle() {
		String result = generate(Collections.<Report> emptyList());
		String style = contentFactory.read("rcptt.css");
		Assert.assertTrue("Style file should be written", style.length() > 0);
		Assert.assertTrue("Style file should be referenced", result.contains("<link href=\"rcptt.css\""));
	}

	@Test
	public void testScript() {
		String result = generate(Collections.<Report> emptyList());
		String style = contentFactory.read("rcptt.js");
		Assert.assertTrue("Script file should be written", style.length() > 0);
		Assert.assertTrue("Script file should be referenced",
				result.contains("<script type=\"text/javascript\" src =\"rcptt.js\">"));
	}

	@Test
	public void renderZip() {
		Q7ReportIterator iterator = new Q7ReportIterator(new File("C:\\Users\\vasili\\Downloads\\tests.report"));
		try {
			renderer.generateReport(new FileContentFactory(new File("C:\\temp\\reportHtmlTest")), "Name", iterator);
		} finally {
			FileUtil.safeClose(iterator);
		}
	}



}

package org.eclipse.rcptt.reporting.core;

import java.io.IOException;
import java.util.List;

import org.eclipse.rcptt.ecl.core.EclException;
import org.eclipse.rcptt.ecl.core.ProcessStatus;
import org.eclipse.rcptt.ecl.internal.core.ProcessStatusConverter;
import org.eclipse.rcptt.reporting.ItemKind;
import org.eclipse.rcptt.reporting.Q7Info;
import org.eclipse.rcptt.sherlock.core.model.sherlock.EclipseStatus;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Event;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.LoggingCategory;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Node;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Report;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Screenshot;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Snaphot;
import org.eclipse.rcptt.sherlock.core.reporting.ReportBuilder;
import org.eclipse.rcptt.sherlock.core.reporting.SimpleReportGenerator;
import org.eclipse.rcptt.tesla.core.info.AdvancedInformation;
import org.eclipse.rcptt.tesla.core.info.Q7WaitInfoRoot;
import org.eclipse.rcptt.tesla.core.utils.AdvancedInformationGenerator;

import com.google.common.base.Strings;
import com.google.common.io.CharStreams;

public class RcpttReportGenerator extends SimpleReportGenerator {
	private final List<ImageEntry> images;
	private final Report report;
	private final String lineSeparator;

	public RcpttReportGenerator(Report report, String lineSeparator, List<ImageEntry> images) {
		this.report = report;
		this.lineSeparator = lineSeparator;
		this.images = images;
	}

	@Override
	public StringBuilder toString(StringBuilder builder,
			int tabs, org.eclipse.emf.ecore.EObject obj,
			String... ignores) {
		if (obj instanceof AdvancedInformation) {
			String content = new AdvancedInformationGenerator()
					.generateContent((AdvancedInformation) obj);
			builder.append(content);
			return builder;
		}
		return super.toString(builder, tabs, obj, ignores);
	};

	@Override
	public void printNode(
			org.eclipse.rcptt.sherlock.core.model.sherlock.report.Node infoNode,
			StringBuilder stringBuilder, int tabs, boolean includeWaitDetails) {

		writeQ7Info(stringBuilder, tabs, infoNode);

		if (includeWaitDetails) {
			writeQ7WaitInfo(stringBuilder, tabs, infoNode);
		}

		writeLogsFromNode(stringBuilder, tabs, infoNode);

		printChildren(stringBuilder, tabs, infoNode, includeWaitDetails);

		if (!includeWaitDetails) {
			for (Event child : infoNode.getEvents()) {
				if (child.getData() instanceof EclipseStatus) {
					printStatus(
							(EclipseStatus) child.getData(),
							tabs + 6, stringBuilder);
				}
			}

			for (Snaphot child : infoNode.getSnapshots()) {
				if (child.getData() instanceof Screenshot) {
					Screenshot shot = (Screenshot) child
							.getData();
					String description = shot.getMessage()
							+ ": " //$NON-NLS-1$
							+ TimeFormatHelper.format(child
									.getTime()
									- report.getRoot()
											.getStartTime());
					images.add(new ImageEntry(shot.getData(), description));
				} else {
					printSnapshot(child, stringBuilder, tabs + 4);
				}
			}
		}
	}

	private void printChildren(StringBuilder stringBuilder, int tabs, Node infoNode, boolean includeWaitDetails) {
		for (Node child : infoNode.getChildren()) {
			printNode(child, stringBuilder, tabs + 4, includeWaitDetails);
		}
	}

	private void writeQ7WaitInfo(StringBuilder stringBuilder, int tabs, Node infoNode) {
		Q7WaitInfoRoot waitInfo = ReportHelper.getWaitInfo(infoNode, false);
		if (waitInfo != null) {
			printWaitInfo(stringBuilder, tabs, "", waitInfo); //$NON-NLS-1$
		}
	}

	String kindToString(ItemKind kind, String name) {
		switch (kind) {
		case CONTEXT:
			return "Context " + name;
		case ECL_COMMAND:
			return name;
		case SCRIPT:
			return "Script " + name;
		case TESTCASE:
			return "Test case " + name;
		case TEST_SUITE:
			return "Test suite " + name;
		case VERIFICATION:
			return "Verification " + name;
		}
		return name;
	}

	private void writeQ7Info(StringBuilder stringBuilder, int tabs, Node infoNode) {
		Q7Info q7Info = ReportHelper.getInfo(infoNode);
		appendTabs(stringBuilder, tabs);
		if (q7Info != null) {
			stringBuilder.append(kindToString(q7Info.getType(), infoNode.getName()));
			stringBuilder
					.append(" ")
					.append("time: " +
							TimeFormatHelper.format(infoNode.getEndTime() - infoNode.getStartTime()))
					.append(lineSeparator);
			writeResult(stringBuilder, tabs + 1, q7Info.getResult());
		}
	}

	private void writeResult(Appendable stream, int tabs, ProcessStatus result) {
		if (SimpleSeverity.create(result) == SimpleSeverity.OK)
			return;
		appendTabs(stream, tabs);
		try {
			stream.append("Result: ").append(SimpleSeverity.create(result).name()).append(", message:")
					.append(result.getMessage());
			stream.append(lineSeparator);
			writeException(stream, tabs + 1, result.getException());
			for (ProcessStatus child : result.getChildren()) {
				writeResult(stream, tabs + 1, child);
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private void writeException(Appendable stream, final int tabs, EclException exception) {
		if (exception == null)
			return;
		IndentedWriter writer = new IndentedWriter(CharStreams.asWriter(stream)) {
			@Override
			public void writeIndent() {
				appendTabs(this, tabs);
			}
		};
		ProcessStatusConverter.getThrowable(exception).printStackTrace(writer);
		writer.println();
		writer.close();
	}

	private void writeLogsFromNode(StringBuilder builder, int tabs, Node infoNode) {
		boolean haveEntries = false;
		for (LoggingCategory logCategory : LoggingCategory.VALUES) {
			String log = ReportBuilder.getLogs(infoNode, logCategory);
			if (!Strings.isNullOrEmpty(log)) {
				if (!haveEntries) {
					haveEntries = true;
					appendTabs(builder, tabs)
							.append("--------------Logs BEGIN-------------------") //$NON-NLS-1$
							.append(lineSeparator);
				}

				for (String logLine : log.split(lineSeparator)) {
					appendTabs(builder, tabs)
							.append(logLine)
							.append(lineSeparator);
				}
			}
		}

		if (haveEntries) {
			appendTabs(builder, tabs)
					.append("--------------Logs END-------------------") //$NON-NLS-1$
					.append(lineSeparator);
		}
	}
}
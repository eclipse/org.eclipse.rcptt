package org.eclipse.rcptt.reporting.core;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.rcptt.ecl.core.EclException;
import org.eclipse.rcptt.ecl.core.ProcessStatus;
import org.eclipse.rcptt.ecl.internal.core.ProcessStatusConverter;
import org.eclipse.rcptt.internal.core.RcpttPlugin;
import org.eclipse.rcptt.reporting.ItemKind;
import org.eclipse.rcptt.reporting.Q7Info;
import org.eclipse.rcptt.sherlock.core.model.sherlock.EclipseStatus;
import org.eclipse.rcptt.sherlock.core.model.sherlock.JavaException;
import org.eclipse.rcptt.sherlock.core.model.sherlock.JavaStackTraceEntry;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Event;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.LoggingCategory;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Node;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Report;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Screenshot;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Snaphot;
import org.eclipse.rcptt.sherlock.core.reporting.ReportBuilder;
import org.eclipse.rcptt.sherlock.core.reporting.SimpleReportGenerator;
import org.eclipse.rcptt.tesla.core.TeslaFeatures;
import org.eclipse.rcptt.tesla.core.info.AdvancedInformation;
import org.eclipse.rcptt.tesla.core.info.Q7WaitInfo;
import org.eclipse.rcptt.tesla.core.info.Q7WaitInfoRoot;
import org.eclipse.rcptt.tesla.core.utils.AdvancedInformationGenerator;
import org.eclipse.rcptt.util.StringUtils;

public class RcpttReportGenerator {
	private final SimpleReportGenerator simpleReportGenerator = new SimpleReportGenerator();
	private final List<ImageEntry> images;
	private final PrintWriter writer;
	private long startTime = 0;

	public RcpttReportGenerator(PrintWriter writer, List<ImageEntry> images) {
		this.writer = writer;
		this.images = images;
	}

	protected PrintWriter writeTabs(int tabs) {
		return writeTabs(writer, tabs);
	}

	public void writeReport(Report report, int tabs) {
		startTime = report.getRoot().getStartTime();
		printNode(report.getRoot(), tabs);
	}

	protected static <T extends Appendable> T writeTabs(T writer, int tabs) {
		for (int i = 0; i < tabs; ++i) {
			try {
				writer.append("  ");
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		return writer;
	}

	// @Override
	// public StringBuilder toString(StringBuilder builder,
	// int tabs, org.eclipse.emf.ecore.EObject obj,
	// String... ignores) {
	// if (obj instanceof AdvancedInformation) {
	// String content = new AdvancedInformationGenerator()
	// .generateContent((AdvancedInformation) obj);
	// builder.append(content);
	// return builder;
	// }
	// return super.toString(builder, tabs, obj, ignores);
	// };
	//
	public void printNode(Node infoNode, int tabs) {
		writeQ7Info(tabs, infoNode);

		writeQ7WaitInfo(tabs, infoNode);

		writeLogsFromNode(tabs, infoNode);

		try {
			for (Event child : infoNode.getEvents()) {
				writeEvent(child, tabs + 1);
			}

			for (Snaphot child : infoNode.getSnapshots()) {
				writeSnapshot(child, tabs + 1);
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		printChildren(tabs, infoNode);
	}

	private void writeEvent(Event event, int tabs) throws IOException {
		writeTabs(tabs + 1).println("Event " + TimeFormatHelper.format(event.getTime() - startTime));
		printObject(event.getData(), tabs + 2);
	}

	public void printObject(EObject object, int tabs) throws IOException {
		if (object instanceof EclipseStatus) {
			printStatus((EclipseStatus) object, tabs);
		} else if (object instanceof Snaphot) {
			writeSnapshot((Snaphot) object, tabs);
		} else {
			simpleReportGenerator.toString(writer, tabs, object);
		}

	}

	private void writeSnapshot(Snaphot snapshot, int tabs) throws IOException {
		if (snapshot.getData() instanceof Screenshot) {
			Screenshot shot = (Screenshot) snapshot
					.getData();
			String description = shot.getMessage()
					+ ": " //$NON-NLS-1$
					+ TimeFormatHelper.format(snapshot
							.getTime()
							- startTime);
			images.add(new ImageEntry(shot.getData(), description));
			return;
		} else if (snapshot.getData() instanceof AdvancedInformation) {
			printAdvanced((AdvancedInformation) snapshot.getData(), tabs);
			return;
		}
		writeTabs(tabs).println("Snapshot " + TimeFormatHelper.format(snapshot.getTime() - startTime));
		printObject(snapshot.getData(), tabs + 1);
	}

	private void printAdvanced(AdvancedInformation data, int tabs) {
		new AdvancedInformationGenerator(writer).writeAdvanced(data, tabs);
	}

	private PrintWriter w(int tabs) {
		return writeTabs(tabs);
	}

	private void printStatus(EclipseStatus status, int tabs) throws IOException {
		SimpleSeverity severity = SimpleSeverity.create(status.getSeverity());
		w(tabs).append(severity.name());
		writer.append(" in plugin: ").println(status.getPlugin());
		w(tabs).append("message: ").println(status.getMessage());
		if (status.getException() != null) {
			w(tabs).println("exception: ");
			printJavaException(status.getException(), tabs + 2);
		}
		for (EclipseStatus child : status.getChildren()) {
			printStatus(child, tabs + 1);
		}
	}

	private void printJavaException(JavaException e, int tabs) {
		w(tabs).append(e.getClassName());
		if (!StringUtils.isEmpty(e.getMessage())) {
			writer.print(":" + e.getMessage());
		}
		writer.println();
		for (JavaStackTraceEntry st : e.getStackTrace()) {
			w(tabs + 2).append("at ")
					.append(st.getClassName()).append(".")
					.append(st.getMethodName()).append("(")
					.append(st.getFileName()).append(":")
					.append("" + st.getLineNumber()).append(")")
					.println();
		}
		JavaException cause = e.getCause();
		if (cause != null) {
			w(tabs + 2).println("Caused by:");
			printJavaException(cause, tabs + 1);
		}
	}

	protected void printChildren(int tabs, Node infoNode) {
		for (Node child : infoNode.getChildren()) {
			printNode(child, tabs + 4);
		}
	}

	private void writeQ7WaitInfo(int tabs, Node infoNode) {
		Q7WaitInfoRoot waitInfo = ReportHelper.getWaitInfo(infoNode, false);
		if (waitInfo != null) {
			writeQ7WaitInfo(tabs, waitInfo); //$NON-NLS-1$
		}
	}

	public static String getType(Q7WaitInfoRoot info, Q7WaitInfo q7WaitInfo) {
		String type = info.getTypesNames().get(q7WaitInfo.getTypeId());
		if (!TeslaFeatures.isIncludeIgnoredWaitDetails() && type.contains("(ignored)")) {
			return null;
		}
		return type;
	}

	public void writeQ7WaitInfo(int tabs, Q7WaitInfoRoot info) {
		List<Q7WaitInfo> infos = new ArrayList<Q7WaitInfo>(info.getInfos());
		Collections.sort(infos, new Comparator<Q7WaitInfo>() {
			@Override
			public int compare(Q7WaitInfo o1, Q7WaitInfo o2) {
				return Long.valueOf(o1.getLastTick()).compareTo(Long.valueOf(o2.getLastTick()));
			}
		});
		if (infos.size() == 0) {
			return;
		}
		long endTime = info.getStartTime();
		int total = 0;
		for (Q7WaitInfo q7WaitInfo : infos) {
			if (getType(info, q7WaitInfo) == null) {
				continue;
			}
			if (endTime < q7WaitInfo.getEndTime()) {
				endTime = q7WaitInfo.getEndTime();
			}
			total++;
		}
		if (total == 0) {
			return;
		}
		writeTabs(tabs + 4).append("--> q7 wait details <-- total wait time: ")
				.append(Long.toString(endTime - info.getStartTime()))
				.println();
		for (Q7WaitInfo i : infos) {
			long totalTime = i.getEndTime() - i.getStartTime();
			String className = SimpleReportGenerator.getClassName(info, i);
			String type = getType(info, i);
			if (type == null) {
				continue;
			}
			writeTabs(tabs + 8).append(type).append(": ")
					.append(className);
			// writer.append(" time: ").append(Long.toString(i.getStartTime())).append(" - ").append(i.getEndTime());
			if (totalTime != 0)
				writer.append(", total time: ").append(Long.toString(totalTime));
			if (i.getLastTick() > 0) {
				// writer.append(", total ticks: ").append(Long.toString(i.getTicks()));
				writer.append(", ticks: ").append(Long.toString(i.getLastTick() - i.getTicks() + 1));
				writer.append(" to ").append(Long.toString(i.getLastTick()));
			}
			// if( i.getLastTick() != 0) {
			// }
			writer.println();
		}
	}

	String kindToString(ItemKind kind, String name) {
		switch (kind) {
		case CONTEXT:
			return "Context *" + name + "*";
		case ECL_COMMAND:
			return name;
		case SCRIPT:
			return "Script *" + name + "*";
		case TESTCASE:
			return "Test case *" + name + "*";
		case TEST_SUITE:
			return "Test suite *" + name + "*";
		case VERIFICATION:
			return "Verification *" + name + "*";
		}
		return name;
	}

	private void writeQ7Info(int tabs, Node infoNode) {
		Q7Info q7Info = ReportHelper.getInfo(infoNode);
		writeTabs(tabs);
		if (q7Info != null) {
			writer.append(kindToString(q7Info.getType(), infoNode.getName()));
			writer.
					append(" ")
					.append("time: " +
							TimeFormatHelper.format(infoNode.getEndTime() - infoNode.getStartTime()))
					.println();
			writeResult(tabs + 1, q7Info.getResult());
		}
	}

	public void writeResult(int tabs, ProcessStatus result) {
		if (result == null)
			result = RcpttPlugin.createProcessStatus(IStatus.ERROR, "Null result");
		if (SimpleSeverity.create(result) == SimpleSeverity.OK)
			return;
		w(tabs).append("Result: " + SimpleSeverity.create(result).name() + ", message: ")
				.println(result.getMessage());
		writeException(writer, tabs + 1, result.getException());
		for (ProcessStatus child : result.getChildren()) {
			writeResult(tabs + 1, child);
		}
	}

	private static void writeException(Writer writer, final int tabs, EclException exception) {
		if (exception == null)
			return;
		IndentedWriter iwriter = new IndentedWriter(writer) {
			@Override
			public void writeIndent() {
				writeTabs(this, tabs);
			}
		};
		ProcessStatusConverter.getThrowable(exception).printStackTrace(iwriter);
		iwriter.println();
		iwriter.flush();
	}

	public void writeLogsFromNode(int tabs, Node infoNode) {
		boolean haveEntries = false;
		for (LoggingCategory logCategory : LoggingCategory.VALUES) {
			String log = ReportBuilder.getLogs(infoNode, logCategory);
			if (!StringUtils.isEmpty(log)) {
				if (!haveEntries) {
					haveEntries = true;
					writeTabs(tabs)
							.println("--------------Logs BEGIN-------------------"); //$NON-NLS-1$
				}

				for (String logLine : log.split("[\r\n]+")) {
					writeTabs(tabs)
							.append(logLine)
							.println();
				}
			}
		}

		if (haveEntries) {
			writeTabs(tabs)
					.append("--------------Logs END-------------------") //$NON-NLS-1$
					.println();
		}
	}
}
package org.eclipse.rcptt.core.internal.ecl.core;

import static org.eclipse.rcptt.reporting.core.ReportHelper.setResult;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.rcptt.ecl.core.ProcessStatus;
import org.eclipse.rcptt.internal.core.RcpttPlugin;
import org.eclipse.rcptt.reporting.Q7Info;
import org.eclipse.rcptt.reporting.core.ReportHelper;
import org.eclipse.rcptt.reporting.core.RunnableWithStatus;
import org.eclipse.rcptt.sherlock.core.INodeBuilder;

public class Utils {

	public static void reportExecution(INodeBuilder parentNode, RunnableWithStatus runnable, String title,
			Q7Info infoPrototype) throws CoreException, InterruptedException {
		INodeBuilder nde = parentNode.beginTask(title);
		Q7Info info = EcoreUtil.copy(infoPrototype);
		ReportHelper.setInfo(nde, info);
		try {
			runnable.run();
			ReportHelper.setResult(nde, createStatus(IStatus.OK, " "));
		} catch (Throwable e) {
			IStatus status = RcpttPlugin.createStatus(e);
			setResult(nde, status);
			ReportHelper.takeSnapshot(nde);
			throw new CoreException(status);
		} finally {
			nde.endTask();
		}
	}

	public static ProcessStatus createStatus(int severity, String message) {
		return RcpttPlugin.createProcessStatus(severity, message);
	}

}

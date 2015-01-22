package org.eclipse.rcptt.core.internal.ecl.core;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.rcptt.ecl.parser.ScriptErrorStatus;
import org.eclipse.rcptt.internal.core.RcpttPlugin;
import org.eclipse.rcptt.reporting.Q7Info;
import org.eclipse.rcptt.reporting.ResultStatus;
import org.eclipse.rcptt.reporting.core.ReportHelper;
import org.eclipse.rcptt.reporting.core.RunnableWithStatus;
import org.eclipse.rcptt.sherlock.core.INodeBuilder;
import org.eclipse.rcptt.util.Exceptions;
import org.eclipse.rcptt.verifications.runtime.VerificationReporter;
import org.eclipse.rcptt.verifications.runtime.VerificationStatus;

public class Utils {
	public static void reportExecution(INodeBuilder parentNode, RunnableWithStatus runnable, String title,
			Q7Info infoPrototype) throws CoreException, InterruptedException {
		INodeBuilder nde = parentNode.beginTask(title);
		Q7Info info = EcoreUtil.copy(infoPrototype);
		info.setResult(ResultStatus.FAIL);
		info.setMessage(title + " failed to set failure reason");
		try {
			runnable.run();
			info.setResult(ResultStatus.PASS);
			info.setMessage("");
		} catch (Throwable e) {
			info.setMessage(Exceptions.toString(e));
			if (e instanceof CoreException) {
				IStatus status = ((CoreException) e).getStatus();
				if (status.matches(IStatus.CANCEL)) {
					info.setResult(ResultStatus.SKIPPED);
					info.setMessage("Execution cancelled: " + Exceptions.toString(e));
				}
				if (status instanceof VerificationStatus) {
					VerificationStatus st = (VerificationStatus) ((CoreException) e).getStatus();
					info.setMessage(VerificationReporter.getStyledMessage(st).getMessage());
				}
				if (status instanceof ScriptErrorStatus) {
					info.setMessage(status.getMessage());
				}
			}
			ReportHelper.takeSnapshot(nde);
			throw new CoreException(RcpttPlugin.createStatus(e));
		} finally {
			ReportHelper.setInfo(nde, info);
			nde.endTask();
		}
	}

}

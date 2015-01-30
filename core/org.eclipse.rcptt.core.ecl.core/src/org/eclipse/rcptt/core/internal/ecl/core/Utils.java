package org.eclipse.rcptt.core.internal.ecl.core;

import static org.eclipse.rcptt.core.internal.ecl.core.Activator.PLUGIN_ID;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.rcptt.ecl.core.CoreFactory;
import org.eclipse.rcptt.ecl.core.ProcessStatus;
import org.eclipse.rcptt.ecl.internal.core.ProcessStatusConverter;
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
		try {
			runnable.run();
			info.setResult(createStatus(IStatus.OK, " "));
		} catch (Throwable e) {
			IStatus status = RcpttPlugin.createStatus(e);
			info.setResult(ProcessStatusConverter.toProcessStatus(status));
			ReportHelper.takeSnapshot(nde);
			throw new CoreException(status);
		} finally {
			ReportHelper.setInfo(nde, info);
			nde.endTask();
		}
	}

	public static ProcessStatus createStatus(int severity, String message) {
		ProcessStatus status = CoreFactory.eINSTANCE.createProcessStatus();
		status.setSeverity(severity);
		status.setPluginId(PLUGIN_ID);
		status.setMessage(message);
		return status;
	}

}

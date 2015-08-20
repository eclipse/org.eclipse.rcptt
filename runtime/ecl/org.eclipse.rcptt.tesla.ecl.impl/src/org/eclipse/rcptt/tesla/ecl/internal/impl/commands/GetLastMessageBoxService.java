package org.eclipse.rcptt.tesla.ecl.internal.impl.commands;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.IProcess;
import org.eclipse.rcptt.tesla.ecl.internal.impl.TeslaImplPlugin;
import org.eclipse.rcptt.tesla.ecl.model.GetLastMessageBox;
import org.eclipse.rcptt.tesla.ecl.model.MessageBoxInfo;
import org.eclipse.rcptt.tesla.swt.dialogs.SWTDialogManager;

public class GetLastMessageBoxService implements ICommandService {
	public IStatus service(Command command, IProcess context) throws CoreException {
		if (!(command instanceof GetLastMessageBox)) {
			return Status.CANCEL_STATUS;
		}
		final MessageBoxInfo info = SWTDialogManager.getMessageBoxInfo();
		if (info == null) {
			return TeslaImplPlugin.err("Message box info is absent.");
		}
		context.getOutput().write(info);
		return Status.OK_STATUS;
	}
}

package org.eclipse.rcptt.ecl.client.tcp.tests;


import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.IProcess;

import com.google.common.base.Function;

public class EclInjectedCommandService implements ICommandService {
	public static Function<Command, IStatus> delegate = new Function<Command, IStatus>() {
		@Override
		public IStatus apply(Command ignored) {
			return Status.OK_STATUS;
		}
	};

	public EclInjectedCommandService() {
	}

	@Override
	public IStatus service(Command command, IProcess context) throws InterruptedException, CoreException {
		return delegate.apply(command);
	}

}

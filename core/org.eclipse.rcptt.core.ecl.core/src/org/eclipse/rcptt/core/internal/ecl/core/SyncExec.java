package org.eclipse.rcptt.core.internal.ecl.core;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Status;
import org.eclipse.rcptt.internal.core.RcpttPlugin;

public class SyncExec<T> implements Runnable {
	private final Function0<T> runnable;
	boolean started = false;
	boolean finished = false;
	T result = null;
	Throwable error = null;

	public SyncExec(Function0<T> runnable) {
		this.runnable = runnable;
	}

	@Override
	public final void run() {
		synchronized (this) {
			if (finished)
				return;
			if (started)
				throw new RuntimeException("Repeated execution");
			started = true;
			notifyAll();
		}
		try {
			result = runnable.apply();
		} catch (Throwable e) {
			error = e;
		} finally {
			synchronized (this) {
				finished = true;
				notifyAll();
			}
		}
	}

	public T wait(int milliseconds) throws CoreException {
		long finishTime = System.currentTimeMillis() + milliseconds;
		synchronized (this) {
			try {
				while (true) {
					if (finished) {
						if (error != null)
							throw new CoreException(RcpttPlugin.createStatus(error));
						return result;
					}
					long timeLeft = finishTime - System.currentTimeMillis();
					if (timeLeft <= 0) {
						final String message = started ? "Execution timed out" : "Execution failed to start";
						throw new CoreException(RcpttPlugin.createStatus(message));
					}
					try {
						wait(timeLeft);
					} catch (InterruptedException e) {
						throw new CoreException(Status.CANCEL_STATUS);
					}
				}
			} finally {
				finished = true;
			}
		}
	}

}

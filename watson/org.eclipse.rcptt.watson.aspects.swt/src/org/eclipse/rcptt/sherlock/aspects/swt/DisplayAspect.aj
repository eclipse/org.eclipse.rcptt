package org.eclipse.rcptt.sherlock.aspects.swt;

import java.lang.reflect.Field;

import org.aspectj.lang.annotation.SuppressAjWarnings;
import org.eclipse.swt.widgets.Display;

import org.eclipse.rcptt.sherlock.aspects.asyncs.AsyncEventManager;
import org.eclipse.rcptt.sherlock.aspects.asyncs.IAsyncEventListener;

public aspect DisplayAspect {
	public DisplayAspect() {
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	Object around(Display display, Runnable async): execution(void Display.syncExec(Runnable)) && target( display ) && args(async) {
		IAsyncEventListener[] listeners = null;
		try {
			listeners = AsyncEventManager.getDefault().getListeners();
			for (IAsyncEventListener l : listeners) {
				l.asyncAdded(async, true);
			}
		} catch (Throwable e) {
			SWTAspectActivator.log(e);
		}
		// Runnable called
		try {
			return proceed(display, async);
		} finally {
			try {
				for (IAsyncEventListener l : listeners) {
					l.asyncDone(async);
				}
			} catch (Throwable e) {
				SWTAspectActivator.log(e);
			}
		}
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	Object around(): execution(void org.eclipse.swt.widgets.RunnableLock.run()) {
		IAsyncEventListener[] listeners = null;
		Runnable value = null;
		try {
			listeners = AsyncEventManager.getDefault().getListeners();
			if (listeners.length > 0) {
				try {
					Object target = thisJoinPoint.getTarget();
					Field runable = target.getClass().getDeclaredField(
							"runnable");
					runable.setAccessible(true);
					value = (Runnable) runable.get(target);
					for (IAsyncEventListener l : listeners) {
						l.asyncRunning(value);
					}
				} catch (Throwable e) {
					SWTAspectActivator.log(e);
				}
			}
		} catch (Throwable e) {
			SWTAspectActivator.log(e);
		}
		Object result = proceed();
		try {
			if (listeners.length > 0) {
				if (value != null) {
					for (IAsyncEventListener l : listeners) {
						l.asyncDone(value);
					}
				}
			}
		} catch (Throwable e) {
			SWTAspectActivator.log(e);
		}
		return result;
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	before(Display display, Runnable async): execution(void Display.asyncExec(Runnable)) && target( display ) && args(async) {
		// Runnable called
		try {
			if (AsyncEventManager.getDefault().getListeners().length > 0) {
				if (async != null) {
					IAsyncEventListener[] listeners = AsyncEventManager
							.getDefault().getListeners();
					for (IAsyncEventListener l : listeners) {
						l.asyncAdded(async, false);
					}
				}
			}
		} catch (Throwable e) {
			SWTAspectActivator.log(e);
		}
	}

	// timer Exec
	@SuppressAjWarnings("adviceDidNotMatch")
	Object around(int time, Runnable run):execution(void org.eclipse.swt.widgets.Display.timerExec(int, Runnable)) && args(time,run) {
		Runnable newRunnable = run;
		try {
			if (AsyncEventManager.getDefault().getListeners().length > 0) {
				IAsyncEventListener[] listeners = AsyncEventManager.getDefault()
						.getListeners();
				for (IAsyncEventListener l : listeners) {
					l.timerAdded(newRunnable);
				}
				for (IAsyncEventListener l : listeners) {
					newRunnable = l.processTimerProc(newRunnable);
				}
			}
		} catch (Throwable e) {
			SWTAspectActivator.log(e);
		}

		return proceed(time, newRunnable);
	}
}

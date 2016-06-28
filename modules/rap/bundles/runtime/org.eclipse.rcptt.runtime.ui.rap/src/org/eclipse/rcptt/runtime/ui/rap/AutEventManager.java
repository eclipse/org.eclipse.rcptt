/*******************************************************************************
 * Copyright (c) 2009, 2016 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.runtime.ui.rap;

import java.net.InetAddress;
import java.util.Locale;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IBundleGroup;
import org.eclipse.core.runtime.IBundleGroupProvider;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.rcptt.core.launching.events.AutBundleState;
import org.eclipse.rcptt.core.launching.events.AutEvent;
import org.eclipse.rcptt.core.launching.events.AutEventInit;
import org.eclipse.rcptt.core.launching.events.AutEventStart;
import org.eclipse.rcptt.core.launching.events.AutSendEvent;
import org.eclipse.rcptt.core.launching.events.AutStartState;
import org.eclipse.rcptt.core.launching.events.Capability;
import org.eclipse.rcptt.core.launching.events.EventsFactory;
import org.eclipse.rcptt.ecl.client.tcp.EclTcpClientManager;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.runtime.IPipe;
import org.eclipse.rcptt.ecl.runtime.IProcess;
import org.eclipse.rcptt.ecl.runtime.ISession;
import org.eclipse.rcptt.internal.runtime.ui.rap.Activator;
import org.eclipse.rcptt.tesla.core.TeslaLimits;
import org.osgi.framework.Bundle;

public class AutEventManager {
	private static AutEventManager eventManager = null;
	private static String q7Id = null;
	private static int q7EclPort = -1;

	private static String getAutIdentity() {
		if (q7Id == null) {
			return System.getProperty("q7id");
		}
		return q7Id;
	}

	public static int getQ7EclPort() {
		if (q7EclPort == -1) {
			String q7EclPort = System.getProperty("q7EclPort");
			if (q7EclPort == null || q7EclPort.trim().length() == 0) {
				return -1;
			}
			return Integer.parseInt(q7EclPort);
		}
		return q7EclPort;
	}

	private ISession createEclSession() throws CoreException {
		try {
			int port = getQ7EclPort();
			if (port == -1) {
				return null;
			}
			return EclTcpClientManager.Instance.startClientSession(
					InetAddress.getByName("localhost"), port);
		} catch (Exception e) {
			throw new CoreException(new Status(Status.ERROR, Activator.PLUGIN_ID,
					"Couldn't open ECL session", e));
		}
	}

	public synchronized static AutEventManager getInstance() {
		if (eventManager == null) {
			eventManager = new AutEventManager();
		}
		return eventManager;
	}

	public Object execute(Command command, long timeout, IProgressMonitor monitor) throws CoreException,
			InterruptedException {
		ISession session = createEclSession();
		if (session == null) {
			Activator
					.log("Failed to send Aut Event: " + command, new Exception("Failed to send Aut Event: " + command));
			return null;
		}
		try {
			IPipe out = session.createPipe();
			IProcess rc = session.execute(command, null, out);
			IStatus status = rc.waitFor(timeout, monitor);
			if (!status.isOK()) {
				throw new CoreException(status);
			}
			return out.take(timeout);
		} finally {
			safeClose(session);
		}
	}

	private void safeClose(ISession session) {
		try {
			session.close();
		} catch (Exception e) {
			Activator.log(e);
		}
	}

	public Object sendEvent(AutEvent event) throws CoreException, InterruptedException {
		AutSendEvent cmd = EventsFactory.eINSTANCE.createAutSendEvent();
		cmd.setId(getAutIdentity());
		cmd.setEvent(event);
		return execute(cmd, TeslaLimits.getAUTStartupTimeout(), new NullProgressMonitor());
	}

	public void sendStartup() {
		AutEventStart startEvent = EventsFactory.eINSTANCE.createAutEventStart();
		int eclPort = Q7ServerStarter.INSTANCE.getEclPort();
		int teslaPort = Q7ServerStarter.INSTANCE.getTeslaPort();
		startEvent.setEclPort(eclPort);
		startEvent.setTeslaPort(teslaPort);
		startEvent.setPlatform(getPlatform());
		startEvent.setCapability(getCapability());

		if (eclPort != -1 && teslaPort != -1) {
			startEvent.setState(AutStartState.OK);
		} else {
			if (eclPort == -1) {
				startEvent.setMessage("Failed to start ECL server");
			} else if (teslaPort == -1) {
				startEvent.setMessage("Failed to start Q7 Runtime server");
			}
			startEvent.setState(AutStartState.FAIL);
		}
		try {
			AutEventManager.getInstance().sendEvent(startEvent);
		} catch (CoreException e) {
			Activator.log(e.getMessage(), e);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	public void sendInitialStartupFail(String msg) {
		AutEventStart startEvent = EventsFactory.eINSTANCE.createAutEventStart();
		startEvent.setState(AutStartState.FAIL);
		startEvent.setMessage(msg);
		try {
			AutEventManager.getInstance().sendEvent(startEvent);
		} catch (CoreException e) {
			Activator.log(e.getMessage(), e);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	public static void reconnect(String id, int port) {
		q7Id = id;
		q7EclPort = port;
	}

	public void sendInit() {
		AutEventInit initObj = EventsFactory.eINSTANCE
				.createAutEventInit();
		IBundleGroupProvider[] providers = Platform.getBundleGroupProviders();
		for (IBundleGroupProvider provider : providers) {
			IBundleGroup[] groups = provider.getBundleGroups();
			for (IBundleGroup group : groups) {
				Bundle[] bundles = group.getBundles();
				for (Bundle bundle : bundles) {
					AutBundleState state = EventsFactory.eINSTANCE.createAutBundleState();
					state.setId(bundle.getSymbolicName());
					state.setLocation(bundle.getLocation());
					switch (bundle.getState()) {
					case Bundle.ACTIVE:
						state.setState("active");
						break;
					case Bundle.INSTALLED:
						state.setState("installed");
						break;
					case Bundle.RESOLVED:
						state.setState("resolved");
						break;
					case Bundle.STARTING:
						state.setState("starting");
						break;
					case Bundle.STOPPING:
						state.setState("stopping");
						break;
					case Bundle.UNINSTALLED:
						state.setState("uninstalled");
						break;
					}
					initObj.getBundleState().add(state);
				}
			}
		}
		try {
			sendEvent(initObj);
		} catch (CoreException e) {
			Activator.log(e.getMessage(), e);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	private static org.eclipse.rcptt.core.launching.events.Platform getPlatform() {
		final String os = System.getProperty("os.name", "generic").toLowerCase(Locale.ENGLISH); //$NON-NLS-1$ //$NON-NLS-2$
		if (os.indexOf("mac") >= 0) //$NON-NLS-1$
			return org.eclipse.rcptt.core.launching.events.Platform.MAC_OS;
		if (os.indexOf("win") >= 0) //$NON-NLS-1$
			return org.eclipse.rcptt.core.launching.events.Platform.WINDOWS;
		if (os.indexOf("nux") >= 0) ////$NON-NLS-1$
			return org.eclipse.rcptt.core.launching.events.Platform.LINUX;

		return org.eclipse.rcptt.core.launching.events.Platform.OTHER;

	}

	private static Capability getCapability() {
		return Capability.RAP;
	}
}

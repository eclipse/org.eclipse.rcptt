/*******************************************************************************
 * Copyright (c) 2009, 2014 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.ecl.internal.client.tcp.tests;

import java.io.IOException;
import java.net.InetAddress;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.rcptt.ecl.client.tcp.EclTcpClientManager;
import org.eclipse.rcptt.ecl.core.tests.AbstractCoreTest;
import org.eclipse.rcptt.ecl.platform.commands.CommandsFactory;
import org.eclipse.rcptt.ecl.platform.commands.ListPlugins;
import org.eclipse.rcptt.ecl.runtime.IPipe;
import org.eclipse.rcptt.ecl.runtime.IProcess;
import org.eclipse.rcptt.ecl.runtime.ISession;
import org.eclipse.rcptt.ecl.server.tcp.EclTcpServerManager;

import junit.framework.TestCase;

public class TestTcpSession extends AbstractCoreTest {

	private static final String LOCALHOST = "127.0.0.1";

	// @Override
	protected ISession createSession() throws Exception {
		return EclTcpClientManager.Instance.startClientSession(
				// InetAddress.getLocalHost(),
				InetAddress.getByName(LOCALHOST),
				EclTcpClientManager.DEFAULT_PORT + 1);
	}

	static {
		try {
			EclTcpServerManager.Instance
					.startServer(EclTcpClientManager.DEFAULT_PORT + 1);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void testCommandExecution001() throws Throwable {
		ListPlugins listPlugins = CommandsFactory.eINSTANCE.createListPlugins();
		IProcess process = session.execute(listPlugins);
		IPipe input = process.getOutput();
		int count1 = 0;
		int count2 = 0;
		while (true) {
			Object object = input.take(Long.MAX_VALUE);
			if (object == null || object instanceof IStatus) {
				break;
			}
			count1++;
		}
		IProcess process2 = session.execute(listPlugins);
		IPipe input2 = process2.getOutput();
		while (true) {
			Object object = input2.take(Long.MAX_VALUE);
			if (object == null || object instanceof IStatus) {
				break;
			}
			count2++;
		}
		TestCase.assertEquals(count1, count2);
	}
}

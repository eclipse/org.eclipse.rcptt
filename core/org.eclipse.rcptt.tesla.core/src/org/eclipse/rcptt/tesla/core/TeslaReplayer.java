/*******************************************************************************
 * Copyright (c) 2009, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.tesla.core;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.rcptt.tesla.core.protocol.UIPlayer;
import org.eclipse.rcptt.tesla.core.protocol.raw.Command;
import org.eclipse.rcptt.tesla.core.protocol.raw.Element;
import org.eclipse.rcptt.tesla.core.protocol.raw.Response;
import org.eclipse.rcptt.tesla.core.protocol.raw.ResponseStatus;
import org.eclipse.rcptt.tesla.internal.core.ModelUtils;
import org.eclipse.rcptt.tesla.internal.core.SimpleCommandPrinter;
import org.eclipse.rcptt.tesla.internal.core.network.IProgressInformer;

public class TeslaReplayer {
	public interface IReplayPreExecute {
		/**
		 * If return true, then command will be skipped
		 * 
		 * @param cmd
		 * @return
		 */
		boolean preExecute(Command cmd);
	}

	public int replayCommands(UIPlayer player,
			TeslaScenarioContainer container, IProgressInformer informer,
			IProgressMonitor monitor, IReplayPreExecute preExecutor)
			throws IOException {
		StringBuilder builder = new StringBuilder();
		boolean success = true;
		int index = 0;
		Command workCmd = null;
		try {
			if (!container.isEmpty()) {
				Map<String, Element> elementToRealElementMap = new HashMap<String, Element>();
				List<Command> commands = container.getCommands();
				// int index = 0;
				for (Command cmd : commands) {
					if (preExecutor != null && preExecutor.preExecute(cmd)) {
						continue;
					}
					// long startTime = System.currentTimeMillis();
					// eclipse 3.4 compatibility:
					// EcoreUtil.copy raise exception if argument is null
					workCmd = (cmd != null) ? (Command) EcoreUtil.copy(cmd)
							: null;
					try {
						ModelUtils
								.updateElementsAccordingTo(workCmd,
										elementToRealElementMap,
										new HashSet<EObject>());
					} catch (Exception e) {
						String msgErr = "Failed to replay at:"
								+ SimpleCommandPrinter.toString(workCmd)
								+ " index:" + index
								+ " msg=Test case is broken...";
						builder.append(msgErr);

						// System.err.println(msgErr);
						if (informer != null) {
							informer.handleError(container, workCmd, index,
									msgErr, null);
						}
						success = false;
						return index;
					}
					String msg = "Replaying command:"
							+ SimpleCommandPrinter.toString(workCmd);
					// System.out.println(msg);
					builder.append(msg).append('\n');
					if (monitor != null) {
						monitor.subTask(msg);
					}
					if (monitor != null && monitor.isCanceled()) {
						return index;
					}

					List<Element> list = container.getElements(cmd);
					Response response = null;
					response = player.safeExecuteCommand(workCmd);
					if (response == null) {
						return index;
					}
					if (!response.getStatus().equals(ResponseStatus.OK)) {
						String msgErr = "Failed to replay at:"
								+ SimpleCommandPrinter.toString(workCmd)
								+ " index:" + index + " msg="
								+ response.getMessage();
						builder.append(msgErr);

						// System.err.println(msgErr);
						if (informer != null) {
							informer.handleError(container, workCmd, index,
									response.getMessage(),
									response.getAdvancedInformation());
						}
						success = false;
						return index;
					}
					if (list != null && list.size() > 0) {
						// We need to receive some element output
						Set<Element> realElements = ModelUtils
								.extractElements(response);
						if (realElements.size() == list.size()
								&& list.size() == 1) {
							elementToRealElementMap.put(makeKey(list.get(0)),
									realElements.iterator().next());
						}
					}
					index++;
					if (informer != null) {
						// Output already executed commands into informer
						informer.appendText(builder.toString());
					}
					// long delta = System.currentTimeMillis() - startTime;
					// System.err.println("Command execution time:" +
					// Long.toString(delta) + " " + msg);
				}
			}
			return index;
		} catch (Throwable e) {
			String msgErr = "Failed to replay at:"
					+ SimpleCommandPrinter.toString(workCmd) + " index:"
					+ index + " msg=" + e.getMessage();
			builder.append(msgErr);

			// System.err.println(msgErr);
			if (informer != null) {
				informer.handleError(container, workCmd, index, e.getMessage(),
						null);
			}
			success = false;
			return index;
		} finally {
			if (success) {
				if (informer != null) {
					builder.append("Replay sucessfully completed...");
					informer.appendText(builder.toString());
				}
				if (monitor != null) {
					monitor.subTask("Replay sucessfully completed...");
				}
			}
		}
	}

	private String makeKey(Element element) {
		return ModelUtils.makeKey(element);
	}
}

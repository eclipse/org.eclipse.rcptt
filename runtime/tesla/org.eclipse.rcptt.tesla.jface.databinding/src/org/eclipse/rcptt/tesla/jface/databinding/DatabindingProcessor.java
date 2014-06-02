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
package org.eclipse.rcptt.tesla.jface.databinding;

import java.lang.Thread.State;
import java.lang.reflect.Field;
import java.util.List;

import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.internal.databinding.observable.Queue;

import org.eclipse.rcptt.tesla.core.Q7WaitUtils;
import org.eclipse.rcptt.tesla.core.context.ContextManagement.Context;
import org.eclipse.rcptt.tesla.core.info.AdvancedInformation;
import org.eclipse.rcptt.tesla.core.info.Q7WaitInfoRoot;
import org.eclipse.rcptt.tesla.core.protocol.IElementProcessorMapper;
import org.eclipse.rcptt.tesla.core.protocol.SelectCommand;
import org.eclipse.rcptt.tesla.core.protocol.SelectResponse;
import org.eclipse.rcptt.tesla.core.protocol.raw.Command;
import org.eclipse.rcptt.tesla.core.protocol.raw.Element;
import org.eclipse.rcptt.tesla.core.protocol.raw.Response;
import org.eclipse.rcptt.tesla.internal.core.AbstractTeslaClient;
import org.eclipse.rcptt.tesla.internal.core.TeslaCore;
import org.eclipse.rcptt.tesla.internal.core.processing.ElementGenerator;
import org.eclipse.rcptt.tesla.internal.core.processing.ITeslaCommandProcessor;
import org.eclipse.rcptt.tesla.internal.ui.processors.ISWTWaitPolicy;
import org.eclipse.rcptt.tesla.jface.DatabindingObservableManager;

public class DatabindingProcessor implements ITeslaCommandProcessor,
		ISWTWaitPolicy {

	// private AbstractTeslaClient client;
	// private String id;

	public DatabindingProcessor() {
	}

	public String getFeatureID() {
		return "databinding";
	}

	public boolean isSelectorSupported(String kind) {
		return false;
	}

	public SelectResponse select(SelectCommand cmd, ElementGenerator generator,
			IElementProcessorMapper mapper) {
		return null;
	}

	public boolean isCommandSupported(Command cmd) {
		return false;
	}

	public Response executeCommand(Command command,
			IElementProcessorMapper mapper) {
		return null;
	}

	public PreExecuteStatus preExecute(Command command,
			PreExecuteStatus previousStatus, Q7WaitInfoRoot info) {
		return null;
	}

	public void initialize(AbstractTeslaClient client, String id) {
		// this.client = client;
		// this.id = id;
	}

	public void postSelect(Element element, IElementProcessorMapper mapper) {

	}

	public boolean isInactivityRequired() {
		return false;
	}

	public boolean isReadyToProceed(Context context, Q7WaitInfoRoot info) {
		return canProceed(context, info);
	}

	@SuppressWarnings("restriction")
	public boolean canProceed(Context context, Q7WaitInfoRoot info) {
		List<Realm> realms = DatabindingObservableManager.getInstance()
				.getRealms();
		for (Realm realm : realms) {
			try {
				Field declaredField = Realm.class.getDeclaredField("workQueue");
				declaredField.setAccessible(true);
				Object object = declaredField.get(realm);
				if (object != null
						&& object instanceof org.eclipse.core.internal.databinding.observable.Queue) {
					synchronized (object) {
						Queue queue = (org.eclipse.core.internal.databinding.observable.Queue) object;
						if (!queue
								.isEmpty()) {
							Q7WaitUtils.updateInfo("databinding", realm.getClass().getName(), info);
							return false;
						}
					}
				}

				// also check for thread are in one of waiting states
				Field threadField = Realm.class
						.getDeclaredField("workerThread");
				threadField.setAccessible(true);
				Thread threadObject = (Thread) threadField.get(realm);
				if (threadObject != null) {
					State state = threadObject.getState();
					if (!(state.equals(State.BLOCKED)
							|| state.equals(State.WAITING)
							|| state.equals(State.TIMED_WAITING) || state
								.equals(State.TERMINATED))) {
						Q7WaitUtils.updateInfo("databinding", realm.getClass().getName(), info);
						// Realm are in execution of some action phase
						return false;
					}
				}
			} catch (Throwable e) {
				TeslaCore.log(e);
			}
		}
		return true;
	}

	public void clean() {
	}

	public void terminate() {
	}

	public void checkHang() {
	}

	public void collectInformation(AdvancedInformation information,
			Command lastCommand) {
	}

	public void notifyUI() {
	}
}

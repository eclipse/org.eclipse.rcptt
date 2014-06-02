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
package org.eclipse.rcptt.tesla.internal.jdt;

import java.util.HashSet;
import java.util.Set;

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
import org.eclipse.rcptt.tesla.internal.core.processing.ElementGenerator;
import org.eclipse.rcptt.tesla.internal.core.processing.ITeslaCommandProcessor;

public class JDTSupportProcessor implements ITeslaCommandProcessor {

	@SuppressWarnings("unused")
	private AbstractTeslaClient client;
	// private String id;
	private Set<String> elements = new HashSet<String>();

	public JDTSupportProcessor() {
	}

	public boolean callMasterProcess(Context currentContext) {
		return false;
	}

	public boolean canProceed(Context context, Q7WaitInfoRoot info) {
		// return JavaModelManager.getIndexManager().awaitingJobsCount() == 0;
		return true;
	}

	public void clean() {
		elements.clear();
	}

	public Response executeCommand(Command command,
			IElementProcessorMapper mapper) {
		return null;
	}

	public String getFeatureID() {
		return null;
	}

	public void initialize(AbstractTeslaClient client, String id) {
		this.client = client;
		// this.id = id;
	}

	public boolean isCommandSupported(Command cmd) {
		return false;
	}

	public boolean isInactivityRequired() {
		return false;
	}

	public boolean isSelectorSupported(String kind) {
		return false;
	}

	public void postSelect(Element element, IElementProcessorMapper mapper) {
	}

	public PreExecuteStatus preExecute(Command command,
			PreExecuteStatus previousStatus, Q7WaitInfoRoot info) {
		return null;
	}

	public SelectResponse select(SelectCommand cmd, ElementGenerator generator,
			IElementProcessorMapper mapper) {
		return null;
	}

	public void terminate() {
		clean();
		client = null;
	}

	public void checkHang() {
	}

	public void collectInformation(AdvancedInformation information,
			Command lastCommand) {
	}

	public void notifyUI() {
	}
}

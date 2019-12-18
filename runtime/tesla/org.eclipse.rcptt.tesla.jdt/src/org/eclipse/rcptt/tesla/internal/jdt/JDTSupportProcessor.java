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

	@Override
	public int getPriority() {
		return 200;
	}

	public boolean callMasterProcess(Context currentContext) {
		return false;
	}

	@Override
	public boolean canProceed(Context context, Q7WaitInfoRoot info) {
		// return JavaModelManager.getIndexManager().awaitingJobsCount() == 0;
		return true;
	}

	@Override
	public void clean() {
		elements.clear();
	}

	@Override
	public Response executeCommand(Command command,
			IElementProcessorMapper mapper) {
		return null;
	}

	@Override
	public String getFeatureID() {
		return null;
	}

	@Override
	public void initialize(AbstractTeslaClient client, String id) {
		this.client = client;
		// this.id = id;
	}

	@Override
	public boolean isCommandSupported(Command cmd) {
		return false;
	}

	@Override
	public boolean isInactivityRequired() {
		return false;
	}

	@Override
	public boolean isSelectorSupported(String kind) {
		return false;
	}

	@Override
	public void postSelect(Element element, IElementProcessorMapper mapper) {
	}

	@Override
	public PreExecuteStatus preExecute(Command command,
			PreExecuteStatus previousStatus, Q7WaitInfoRoot info) {
		return null;
	}

	@Override
	public SelectResponse select(SelectCommand cmd, ElementGenerator generator,
			IElementProcessorMapper mapper) {
		return null;
	}

	@Override
	public void terminate() {
		clean();
		client = null;
	}

	@Override
	public void checkHang() {
	}

	@Override
	public void collectInformation(AdvancedInformation information,
			Command lastCommand) {
	}

	@Override
	public void notifyUI() {
	}
}

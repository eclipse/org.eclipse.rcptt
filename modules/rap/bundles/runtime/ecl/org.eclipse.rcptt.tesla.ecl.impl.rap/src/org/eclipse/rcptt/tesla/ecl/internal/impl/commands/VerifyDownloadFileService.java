/*******************************************************************************
 * /*******************************************************************************
 *  * Copyright (c) 2009, 2016 Xored Software Inc and others.
 *  * All rights reserved. This program and the accompanying materials
 *  * are made available under the terms of the Eclipse Public License v1.0
 *  * which accompanies this distribution, and is available at
 *  * http://www.eclipse.org/legal/epl-v10.html
 *  *
 *  * Contributors:
 *  *     Xored Software Inc - initial API and implementation and/or initial documentation
 *  *******************************************************************************/
package org.eclipse.rcptt.tesla.ecl.internal.impl.commands;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.tesla.core.protocol.ObjectResponse;
import org.eclipse.rcptt.tesla.core.protocol.ProtocolFactory;
import org.eclipse.rcptt.tesla.core.protocol.RapDownloadFile;
import org.eclipse.rcptt.tesla.core.protocol.raw.Response;
import org.eclipse.rcptt.tesla.ecl.impl.rap.AbstractActionService;
import org.eclipse.rcptt.tesla.ecl.impl.rap.TeslaBridge;
import org.eclipse.rcptt.tesla.ecl.internal.impl.TeslaImplPlugin;
import org.eclipse.rcptt.tesla.ecl.rap.model.VerifyDownloadFile;
import org.eclipse.rcptt.tesla.swt.download.RapDownloadHandlerManager;

public class VerifyDownloadFileService extends AbstractActionService {

	@Override
	protected Object exec(Command command) throws CoreException {

		final VerifyDownloadFile verify = (VerifyDownloadFile) command;

		final RapDownloadFile download = ProtocolFactory.eINSTANCE.createRapDownloadFile();
		download.setHandler(verify.getHandler());
		download.setUrl(verify.getUrl());

		final Response response = TeslaBridge.getPlayer().safeExecuteCommand(download);
		if (!(response instanceof ObjectResponse)) {
			return new CoreException(TeslaImplPlugin.err("Fail response")); //$NON-NLS-1$
		}

		final String content = (String) ((ObjectResponse) response).getResult();

		if (!RapDownloadHandlerManager.checkContent(content)) {
			return new CoreException(TeslaImplPlugin.err("File is not same")); //$NON-NLS-1$
		}

		TeslaBridge.waitExecution();
		return null;
	}

}

/*******************************************************************************
 * Copyright (c) 2009, 2016 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.tesla.recording.core.ecl.rap.parser;

import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.core.Pipeline;
import org.eclipse.rcptt.ecl.core.util.ScriptletFactory;
import org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage;
import org.eclipse.rcptt.tesla.core.protocol.RapDownloadFile;
import org.eclipse.rcptt.tesla.core.protocol.RapUploadFile;
import org.eclipse.rcptt.tesla.ecl.TeslaScriptletFactory;
import org.eclipse.rcptt.tesla.ecl.model.VerifyTrue;
import org.eclipse.rcptt.tesla.ecl.rap.model.DownloadFile;
import org.eclipse.rcptt.tesla.ecl.rap.model.ExecWithoutJs;
import org.eclipse.rcptt.tesla.ecl.rap.model.MatchBinary;
import org.eclipse.rcptt.tesla.ecl.rap.model.RapTeslaFactory;
import org.eclipse.rcptt.tesla.ecl.rap.model.UploadFile;
import org.eclipse.rcptt.tesla.recording.core.ecl.TeslaCommand;
import org.eclipse.rcptt.tesla.recording.core.ecl.parser.TeslaParser;
import org.eclipse.rcptt.util.StringUtils;

public class RapTeslaParser {

	@TeslaCommand(packageUri = ProtocolPackage.eNS_URI, classifier = "RapDownloadFile")
	public static Command downloadFile(TeslaParser parser, RapDownloadFile file) {
		final ExecWithoutJs command = RapTeslaFactory.eINSTANCE.createExecWithoutJs();

		final DownloadFile download = RapTeslaFactory.eINSTANCE.createDownloadFile();

		download.setHandlerId(file.getHandler());
		download.setUrl(file.getUrl());

		final MatchBinary matching = RapTeslaFactory.eINSTANCE.createMatchBinary();
		matching.setBase64(file.getContent());

		final VerifyTrue verify = TeslaScriptletFactory.makeVerifyTrue();

		final Pipeline pipe = ScriptletFactory.makePipe(download, matching, verify);
		command.setCommand(pipe);

		return command;
	}

	@TeslaCommand(packageUri = ProtocolPackage.eNS_URI, classifier = "RapUploadFile")
	public static Command rapUploadFile(TeslaParser parser, RapUploadFile file) {
		final UploadFile upload = RapTeslaFactory.eINSTANCE.createUploadFile();
		if (!StringUtils.isEmpty(file.getBase64file())) {
			upload.setBase64(file.getBase64file());
		}

		return upload;
	}
}

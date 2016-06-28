package org.eclipse.rcptt.tesla.recording.core.ecl.rap.parser;

import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.core.Sequence;
import org.eclipse.rcptt.ecl.core.util.ScriptletFactory;
import org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage;
import org.eclipse.rcptt.tesla.core.protocol.RapDownloadFile;
import org.eclipse.rcptt.tesla.ecl.rap.model.ExecWithoutJs;
import org.eclipse.rcptt.tesla.ecl.rap.model.RapTeslaFactory;
import org.eclipse.rcptt.tesla.ecl.rap.model.SetDownloadResultFile;
import org.eclipse.rcptt.tesla.ecl.rap.model.VerifyDownloadFile;
import org.eclipse.rcptt.tesla.recording.core.ecl.TeslaCommand;

public class RapTeslaParser {

	@TeslaCommand(packageUri = ProtocolPackage.eNS_URI, classifier = "RapDownloadFile")
	public Command downloadFile(RapDownloadFile file)
	{
			final ExecWithoutJs command = RapTeslaFactory.eINSTANCE.createExecWithoutJs();

			final SetDownloadResultFile downloadResult = RapTeslaFactory.eINSTANCE.createSetDownloadResultFile();
			downloadResult.setFile(file.getContent());

			final VerifyDownloadFile verify = RapTeslaFactory.eINSTANCE.createVerifyDownloadFile();
			verify.setUrl(file.getUrl());
			verify.setHandler(file.getHandler());

			final Sequence sequence = ScriptletFactory.makeSeq(downloadResult, verify);

			command.setCommand(sequence);

			return command;
	}
}

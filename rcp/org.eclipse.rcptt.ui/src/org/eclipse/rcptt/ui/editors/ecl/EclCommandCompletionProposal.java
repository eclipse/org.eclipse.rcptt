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
package org.eclipse.rcptt.ui.editors.ecl;

import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.rcptt.ecl.doc.EclDocCommand;
import org.eclipse.rcptt.ecl.doc.EclDocWriter;
import org.eclipse.swt.graphics.Image;

public class EclCommandCompletionProposal extends EclCompletionProposal {

	private EclDocCommand command;

	public EclCommandCompletionProposal(String replacementString,
			int replacementOffset, int replacementLength, int cursorPosition,
			Image image, String displayString,
			IContextInformation contextInformation,
			String additionalProposalInfo) {		
		super(replacementString, replacementOffset, replacementLength,
				cursorPosition, image, displayString, contextInformation, additionalProposalInfo);
		
		this.command = null;
	}
	
	public EclCommandCompletionProposal(String replacementString,
			int replacementOffset, int replacementLength, int cursorPosition,
			Image image, IContextInformation contextInformation,
			EclDocCommand command) {
		super(replacementString, replacementOffset, replacementLength,
				cursorPosition, image, null, contextInformation, null);
		this.command = command;
	}

	@Override
	public String getDisplayString() {
		if(command != null){
			return command.getName();
		}else{
			return super.getDisplayString();
		}
	}

	@Override
	public String getAdditionalProposalInfo() {
		if(command != null)
			return EclDocWriter.writeToString(command, "Error while formating documentation.");
		else
			return "";
	}
}

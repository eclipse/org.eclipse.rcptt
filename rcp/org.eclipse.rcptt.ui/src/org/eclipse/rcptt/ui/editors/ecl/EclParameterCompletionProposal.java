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
package org.eclipse.rcptt.ui.editors.ecl;

import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.rcptt.ecl.doc.EclDocParameter;
import org.eclipse.rcptt.ecl.doc.EclDocWriter;
import org.eclipse.swt.graphics.Image;

public class EclParameterCompletionProposal extends EclCompletionProposal {

	private EclDocParameter param;

	public EclParameterCompletionProposal(String replacementString,
			int replacementOffset, int replacementLength, int cursorPosition,
			Image image, String displayString,
			IContextInformation contextInformation,
			String additionalProposalInfo) {		
		super(replacementString, replacementOffset, replacementLength,
				cursorPosition, image, displayString, contextInformation, additionalProposalInfo);
		
		this.param = null;
	}
	
	public EclParameterCompletionProposal(String replacementString,
			int replacementOffset, int replacementLength, int cursorPosition,
			Image image, IContextInformation contextInformation,
			EclDocParameter param) {
		super(replacementString, replacementOffset, replacementLength,
				cursorPosition, image, null, contextInformation, null);
		this.param = param;
	}

	@Override
	public String getDisplayString() {
		if(param != null)
			return param.getName();
		else
			return super.getDisplayString();
	}

	@Override
	public String getAdditionalProposalInfo() {
		if(param != null)
			return EclDocWriter.writeToString(param, "Error while formating documentation.");
		else
			return "";
	}
}

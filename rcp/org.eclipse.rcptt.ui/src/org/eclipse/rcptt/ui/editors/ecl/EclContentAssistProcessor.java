/*******************************************************************************
 * Copyright (c) 2009, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.ui.editors.ecl;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.text.contentassist.IContextInformationValidator;
import org.eclipse.swt.graphics.Image;

import org.eclipse.rcptt.core.ecl.model.ArgDecl;
import org.eclipse.rcptt.core.ecl.model.BuiltinProcDecl;
import org.eclipse.rcptt.core.ecl.model.Q7ElementContainer;
import org.eclipse.rcptt.core.ecl.model.VarDecl;
import org.eclipse.rcptt.core.ecl.parser.model.Completer;
import org.eclipse.rcptt.core.ecl.parser.model.Proposal;
import org.eclipse.rcptt.internal.ui.Images;

public class EclContentAssistProcessor implements IContentAssistProcessor {
	public IContextInformation[] computeContextInformation(ITextViewer viewer,
			int offset) {
		return null;
	}

	public ICompletionProposal[] computeCompletionProposals(ITextViewer viewer,
			int offset) {
		Q7ElementContainer container = ((EclSourceViewer) viewer).getElementContainer();
		container.includeBuildins(true);
		container.setOffset(offset);
		List<Proposal> result = Completer.proposals(container.script, offset, container);

		List<ICompletionProposal> toReturn = new ArrayList<ICompletionProposal>();
		for (Proposal proposal : result) {
			String fullText = proposal.fullText();
			toReturn.add(new EclCompletionProposal(fullText, offset - proposal.prefixLength, proposal.prefixLength,
					fullText.length(),
					getImage(proposal), fullText, null, proposal.decl.doc()));
		}

		return toReturn.toArray(new ICompletionProposal[toReturn.size()]);
	}

	public char[] getCompletionProposalAutoActivationCharacters() {
		return ECLEditorPlugin.getECLScriptContentAssistTriggers().toCharArray();
	}

	public char[] getContextInformationAutoActivationCharacters() {
		return null;
	}

	public String getErrorMessage() {
		return null;
	}

	public IContextInformationValidator getContextInformationValidator() {
		return null;
	}

	private Image commandImage;
	private Image parameterImage;
	private Image inputParameterImage;
	private Image procImage;
	private Image localImage;
	private Image globalImage;

	private Image getImage(Proposal proposal) {
		if (proposal instanceof Proposal.ArgNameProposal) {
			return ((ArgDecl) proposal.decl).isInput ? getInputArgImage() : getArgImage();
		}
		if (proposal instanceof Proposal.ProcNameProposal) {
			return proposal.decl instanceof BuiltinProcDecl ? getCommandImage() : getProcImage();
		}

		if (proposal instanceof Proposal.VarValueProposal) {
			return ((VarDecl) proposal.decl).isGlobal ? getGlobalImage() : getLocalImage();
		}
		return null;
	}

	private Image getProcImage() {
		if (procImage == null) {
			procImage = Images.getImage(Images.ECL_PROC);
		}
		return procImage;
	}

	private Image getLocalImage() {
		if (localImage == null) {
			localImage = Images.getImage(Images.ECL_LOCAL);
		}
		return localImage;
	}

	private Image getGlobalImage() {
		if (globalImage == null) {
			globalImage = Images.getImage(Images.ECL_GLOBAL);
		}
		return globalImage;
	}

	private Image getCommandImage() {
		if (commandImage == null) {
			commandImage = Images.getImage(Images.ECL_COMMAND);
		}
		return commandImage;
	}

	private Image getArgImage() {
		if (parameterImage == null)
			parameterImage = Images.getImage(Images.ECL_ATTRIBUTE);
		return parameterImage;
	}

	private Image getInputArgImage() {
		if (inputParameterImage == null)
			inputParameterImage = Images
					.getImage(Images.ECL_INPUT_ATTRIBUTE);
		return inputParameterImage;
	}

}

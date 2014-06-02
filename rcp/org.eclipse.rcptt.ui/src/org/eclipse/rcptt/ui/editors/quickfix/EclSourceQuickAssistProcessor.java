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
package org.eclipse.rcptt.ui.editors.quickfix;

import java.util.Iterator;

import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.quickassist.IQuickAssistInvocationContext;
import org.eclipse.jface.text.quickassist.IQuickAssistProcessor;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.IAnnotationModel;

import org.eclipse.rcptt.core.builder.Q7ProblemSources;
import org.eclipse.rcptt.ui.editors.ecl.EclProblemAnnotation;

public class EclSourceQuickAssistProcessor implements IQuickAssistProcessor {

	private final ICompletionProposal emptyProposal = new EmptyProporsal();

	@Override
	public String getErrorMessage() {
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ICompletionProposal[] computeQuickAssistProposals(IQuickAssistInvocationContext invocationContext) {
		IAnnotationModel model = invocationContext.getSourceViewer().getAnnotationModel();
		Iterator<Annotation> iterator = model.getAnnotationIterator();

		while (iterator.hasNext()) {
			Annotation annotation = (Annotation) iterator.next();
			Position pos = model.getPosition(annotation);
			if (annotation instanceof EclProblemAnnotation
					&& pos.overlapsWith(invocationContext.getOffset(), 1)) {
				EclProblemAnnotation eclAnnotation = (EclProblemAnnotation) annotation;
				if (eclAnnotation.getProblem().getSourceId()
				== Q7ProblemSources.WARN_OBSOLETE_GETPARAM_CMD.getSourceId()) {
					return new ICompletionProposal[] {
							new GetParamCmdQuickFixer(pos.offset, pos.offset + pos.length)
					};
				}
			}
		}

		return new ICompletionProposal[] { emptyProposal };
	}

	@Override
	public boolean canFix(Annotation annotation) {
		return (annotation instanceof EclProblemAnnotation
		&& ((EclProblemAnnotation) annotation).isQuickFixable());
	}

	@Override
	public boolean canAssist(IQuickAssistInvocationContext invocationContext) {
		return false;
	}
}
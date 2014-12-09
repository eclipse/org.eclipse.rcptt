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
package org.eclipse.rcptt.ui.launching;

import java.util.Arrays;
import java.util.List;

import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.swt.graphics.Image;

import com.google.common.base.Joiner;
import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.model.IQ7Project;
import org.eclipse.rcptt.core.model.IQ7ProjectMetadata;
import org.eclipse.rcptt.core.model.ModelException;
import org.eclipse.rcptt.core.ecl.core.model.ExecutionPhase;
import org.eclipse.rcptt.internal.core.RcpttPlugin;
import org.eclipse.rcptt.internal.launching.PrepareExecutionWrapper;
import org.eclipse.rcptt.internal.ui.Images;
import org.eclipse.rcptt.launching.IExecutable;

public class ExecutionLabelProvider extends LabelProvider implements
		IStyledLabelProvider {

	@Override
	public Image getImage(Object element) {
		IExecutable executable = cast(element);
		if (executable.getType() == IExecutable.TYPE_SCENARIO) {
			if (executable.isTerminated()) {
				return Images.getImage(Images.SCENARIO_STOP);
			}
			switch (executable.getStatus()) {
			case WAITING:
				return Images.getImage(Images.SCENARIO_WAIT);
			case LAUNCHING:
				return Images.getImage(Images.SCENARIO_RUN);
			case PASSED:
				return Images.getImage(Images.SCENARIO_PASS);
			case FAILED:
				return Images.getImage(Images.SCENARIO_FAIL);
			}
		} else if (executable.getType() == IExecutable.TYPE_CONTEXT) {
			if (executable.isTerminated()) {
				return Images.getImage(Images.CONTEXT_STOP);
			}
			switch (executable.getStatus()) {
			case WAITING:
				return Images.getImage(Images.CONTEXT_WAIT);
			case LAUNCHING:
				return Images.getImage(Images.CONTEXT_RUN);
			case PASSED:
				return Images.getImage(Images.CONTEXT_PASS);
			case FAILED:
				return Images.getImage(Images.CONTEXT_FAIL);
			}
		} else if (executable.getType() == IExecutable.TYPE_VERIFICATION) {
			if (executable.isTerminated()) {
				return Images.getImage(Images.VERIFICATION_STOP);
			}
			switch (executable.getStatus()) {
			case WAITING:
				return Images.getImage(Images.VERIFICATION_WAIT);
			case LAUNCHING:
				return Images.getImage(Images.VERIFICATION_RUN);
			case PASSED:
				return Images.getImage(Images.VERIFICATION_PASS);
			case FAILED:
				return Images.getImage(Images.VERIFICATION_FAIL);
			}
		} else if (executable.getType() == IExecutable.TYPE_TESTSUITE) {
			if (executable.isTerminated()) {
				return Images.getImage(Images.EXECUTION_SESSION_STOP);
			}
			switch (executable.getStatus()) {
			case WAITING:
				return Images.getImage(Images.EXECUTION_SESSION);
			case LAUNCHING:
				return Images.getImage(Images.EXECUTION_SESSION_RUN);
			case PASSED:
				return Images.getImage(Images.EXECUTION_SESSION_OK);
			case FAILED:
				return Images.getImage(Images.EXECUTION_SESSION_FAIL);
			}
		}
		return null;
	}

	public StyledString getStyledText(Object element) {
		IExecutable executable = cast(element);
		StyledString styledString = new StyledString(executable.getName());

		if (executable instanceof PrepareExecutionWrapper) {
			List<String> variantName = ((PrepareExecutionWrapper) executable)
					.getVariantName();
			if (variantName != null && !variantName.isEmpty()) {
				styledString
						.append(" (" + Joiner.on(',').join(variantName) + ")", StyledString.DECORATIONS_STYLER); //$NON-NLS-1$
			}
		}

		if (executable.getPhase() != ExecutionPhase.AUTO) {
			styledString.append(" ", StyledString.DECORATIONS_STYLER).
					append(executable.getPhase().toString(), StyledString.DECORATIONS_STYLER);
		}

		if (executable.getStatus() == IExecutable.State.PASSED
				|| executable.getStatus() == IExecutable.State.FAILED) {
			styledString.append(" (", StyledString.COUNTER_STYLER); //$NON-NLS-1$
			long time = executable.getTime();
			styledString.append(TimeFormatHelper.format(time),
					StyledString.COUNTER_STYLER);
			styledString.append(")", StyledString.COUNTER_STYLER); //$NON-NLS-1$
		}
		try {
			IQ7NamedElement actualElement = executable.getActualElement();
			if (!actualElement.getResource().getProject().isOpen()) {
				return styledString;
			}
			if (actualElement != null && actualElement.exists()) {
				String id = executable.getActualElement().getID();
				if (id != null) {
					IQ7Project project = executable.getActualElement()
							.getQ7Project();
					IQ7ProjectMetadata metadata = project.getMetadata();
					if (metadata != null && metadata.exists()) {
						String[] contexts = metadata.getContexts();
						if (contexts != null
								&& Arrays.asList(contexts).contains(id)) {
							styledString.append(" (default context)",
									StyledString.DECORATIONS_STYLER);
						}
					}
				}
			}
		} catch (ModelException e) {
			RcpttPlugin.log(e);
		}
		return styledString;
	}

	@Override
	public String getText(Object element) {
		return getStyledText(element).toString();
	}

	private IExecutable cast(Object element) {
		return (IExecutable) element;
	}

}
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
package org.eclipse.rcptt.ui.launching;

import java.util.Arrays;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.rcptt.core.ecl.core.model.ExecutionPhase;
import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.model.IQ7Project;
import org.eclipse.rcptt.core.model.IQ7ProjectMetadata;
import org.eclipse.rcptt.core.model.ModelException;
import org.eclipse.rcptt.internal.core.RcpttPlugin;
import org.eclipse.rcptt.internal.launching.PrepareExecutionWrapper;
import org.eclipse.rcptt.internal.ui.StateImageProvider;
import org.eclipse.rcptt.launching.IExecutable;
import org.eclipse.rcptt.reporting.core.TimeFormatHelper;
import org.eclipse.swt.graphics.Image;

import com.google.common.base.Joiner;

public class ExecutionLabelProvider extends LabelProvider implements
		IStyledLabelProvider {

	@Override
	public Image getImage(Object element) {
		IExecutable executable = cast(element);

		try {
			if (executable.getType() == IExecutable.TYPE_SCENARIO) {
				return StateImageProvider.TEST.getStateImage(executable.getStatus(), executable.getResultStatus());
			} else if (executable.getType() == IExecutable.TYPE_CONTEXT) {
				return StateImageProvider.CONTEXT.getStateImage(executable.getStatus(), executable.getResultStatus());
			} else if (executable.getType() == IExecutable.TYPE_VERIFICATION) {
				return StateImageProvider.VERIFICATION.getStateImage(executable.getStatus(),
						executable.getResultStatus());
			} else if (executable.getType() == IExecutable.TYPE_TESTSUITE) {
				return StateImageProvider.SUITE.getStateImage(executable.getStatus(), executable.getResultStatus());
			}
		} catch (CoreException e) {
			RcpttPlugin.getDefault().getLog().log(e.getStatus());
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

		if (executable.getStatus() == IExecutable.State.COMPLETED
				&& !executable.getResultStatus().matches(IStatus.CANCEL)) {
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
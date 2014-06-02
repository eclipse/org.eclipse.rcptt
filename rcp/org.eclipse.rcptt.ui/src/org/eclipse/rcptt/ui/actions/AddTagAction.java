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
package org.eclipse.rcptt.ui.actions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.handlers.HandlerUtil;

import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.model.ModelException;
import org.eclipse.rcptt.core.scenario.NamedElement;
import org.eclipse.rcptt.core.tags.Tag;
import org.eclipse.rcptt.core.utils.TagsUtil;
import org.eclipse.rcptt.internal.core.RcpttPlugin;
import org.eclipse.rcptt.internal.ui.Messages;
import org.eclipse.rcptt.internal.ui.Q7UIPlugin;
import org.eclipse.rcptt.launching.utils.TestSuiteUtils;
import org.eclipse.rcptt.ui.editors.INamedElementEditor;
import org.eclipse.rcptt.ui.launching.LaunchUtils;
import org.eclipse.rcptt.ui.tags.SelectTagDialog;
import org.eclipse.rcptt.ui.utils.ModelUtils;

public class AddTagAction extends AbstractHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {
		IResource[] resources = LaunchUtils.getContext(HandlerUtil
				.getCurrentSelection(event));
		final IQ7NamedElement[] elements = TestSuiteUtils.getElements(resources,
				false, false);

		List<String> disabledTags = null;
		if (elements.length == 1) {
			try {
				disabledTags = TagsUtil.extractTags(elements[0].getTags());
			} catch (ModelException e) {
				e.printStackTrace();
			}
		}
		if (disabledTags == null) {
			disabledTags = new ArrayList<String>();
		}

		final SelectTagDialog dialog = new SelectTagDialog(
				HandlerUtil.getActiveShell(event), disabledTags);

		if (dialog.open() == SelectTagDialog.OK) {
			Job job = new Job(Messages.AddTagAction_Job) {
				@Override
				protected IStatus run(final IProgressMonitor monitor) {
					monitor.beginTask(Messages.AddTagAction_Task,
							elements.length);
					for (IQ7NamedElement element : elements) {
						if (monitor.isCanceled())
							break;
						try {
							doAddTag(element, dialog.getResult(),
									dialog.getTagName(), monitor);
						} catch (ModelException e) {
							RcpttPlugin.log(e);
						}
						monitor.worked(1);
					}
					monitor.done();
					return Status.OK_STATUS;
				}
			};
			job.setUser(true);
			job.schedule();
		}
		return null;
	}

	protected void doAddTag(IQ7NamedElement element, List<Tag> selected,
			String newTag, final IProgressMonitor monitor)
			throws ModelException {
		String tags = element.getTags();
		NamedElement namedElement = element.getModifiedNamedElement();
		if( namedElement != null ) {
			tags = namedElement.getTags();
		}
		final List<String> existingTags = TagsUtil.extractTags(tags);
		final StringBuilder sb = new StringBuilder(tags);
		boolean first = existingTags.isEmpty();
		if (!selected.isEmpty()) {
			for (final Tag tag : selected) {
				if (existingTags.contains(tag.getPath())) {
					continue;
				}
				if (!first) {
					sb.append(", "); //$NON-NLS-1$
				} else {
					first = false;
				}
				sb.append(tag.getPath());
			}
		} else if (newTag != null) {
			if (existingTags.contains(newTag.trim())) {
				return;
			}
			if (sb.toString().length() != 0) {
				sb.append(", "); //$NON-NLS-1$
			}
			sb.append(newTag.trim());
		}
		if (sb.length() > 0) {
			try {
				final INamedElementEditor editor = ModelUtils
						.findEditor(element);
				if (editor != null) {
					boolean wasDirty = editor.isDirty();
					editor.setTags(sb.toString());
					if (!wasDirty) {
						Display.getDefault().asyncExec(new Runnable() {
							public void run() {
								editor.doSave(monitor);
							}
						});
					}

				} else {
					IQ7NamedElement copy = element
							.getWorkingCopy(new NullProgressMonitor());
					try {
						copy.setTags(sb.toString());
						copy.commitWorkingCopy(true, new NullProgressMonitor());
					} finally {
						copy.discardWorkingCopy();
					}
					// Q7Core.getInstance().save(element);
				}
			} catch (Throwable e) {
				Q7UIPlugin.log(e);
			}
		}
	}

}

/*******************************************************************************
 * Copyright (c) 2009, 2015 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.ui.actions;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.model.ModelException;
import org.eclipse.rcptt.core.persistence.IPersistenceModel;
import org.eclipse.rcptt.core.persistence.PersistenceManager;
import org.eclipse.rcptt.core.persistence.plain.PlainTextPersistenceModel;
import org.eclipse.rcptt.internal.core.model.ModelManager;
import org.eclipse.rcptt.internal.core.model.Q7NamedElement;
import org.eclipse.rcptt.internal.ui.Q7UIPlugin;
import org.eclipse.rcptt.launching.utils.TestSuiteUtils;
import org.eclipse.rcptt.ui.launching.LaunchUtils;
import org.eclipse.rcptt.ui.utils.WriteAccessChecker;
import org.eclipse.ui.handlers.HandlerUtil;

public class ConvertOldElemenetsAction extends AbstractHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {
		IResource[] resources = LaunchUtils.getContext(HandlerUtil
				.getCurrentSelection(event));
		final IQ7NamedElement[] elements = TestSuiteUtils.getElements(resources,
				false, false);

		Job job = new Job("Convert RCPTT elements") {
			@Override
			protected IStatus run(final IProgressMonitor monitor) {
				ModelManager.getModelManager().getIndexManager().disable();
				try {
					monitor.beginTask("Convert RCPTT elements", elements.length);
					for (IQ7NamedElement element : elements) {
						if (monitor.isCanceled())
							break;
						try {
							monitor.subTask("Processing " + element.getName());
							IQ7NamedElement copy = element
									.getWorkingCopy(new NullProgressMonitor());
							try {
								IPersistenceModel persistenceModel = copy
										.getPersistenceModel();
								if (!(persistenceModel instanceof PlainTextPersistenceModel)) {
									IPersistenceModel newModel = PersistenceManager
											.getInstance()
											.replaceModelWith(
													persistenceModel
															.getResource(),
													persistenceModel);
									((Q7NamedElement) copy)
											.updatePersistenceModel(newModel);
									WriteAccessChecker writeAccessChecker = new WriteAccessChecker();
									if (writeAccessChecker.makeResourceWritable(copy)) {
										copy.commitWorkingCopy(true,
												new NullProgressMonitor());
									}
								}
							} catch (ModelException e) {
								Q7UIPlugin.log(e);
							} finally {
								copy.discardWorkingCopy();
								element.close();
							}
						} catch (Throwable e) {
							Q7UIPlugin.log(e);
						}
						monitor.worked(1);
					}
				} finally {
					ModelManager.getModelManager().getIndexManager().enable();
				}
				monitor.done();
				return Status.OK_STATUS;
			}
		};
		job.setUser(true);
		job.setRule(ResourcesPlugin.getWorkspace().getRoot());
		job.schedule();

		return null;
	}
}

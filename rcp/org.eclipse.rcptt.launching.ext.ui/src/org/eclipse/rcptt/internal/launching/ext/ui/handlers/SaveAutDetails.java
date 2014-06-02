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
package org.eclipse.rcptt.internal.launching.ext.ui.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.rcptt.launching.autdetails.AutDetailsCollector;
import org.eclipse.rcptt.launching.autdetails.ZipAutDetailsProcessor;
import org.eclipse.rcptt.ui.launching.aut.AutElement;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;

public class SaveAutDetails extends AbstractHandler {
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection sel = HandlerUtil.getCurrentSelection(event);
		if (sel instanceof IStructuredSelection) {
			AutElement aut = (AutElement) ((IStructuredSelection) sel)
					.getFirstElement();
			Shell shell = HandlerUtil.getActiveWorkbenchWindow(event)
					.getShell();
			FileDialog dialog = new FileDialog(shell, SWT.SAVE);
			dialog.setFileName(aut.getName().toLowerCase() + "_aut_details");
			dialog.setOverwrite(true);
			dialog.setFilterExtensions(new String[] { "*.zip" });
			String pathToZip = dialog.open();

			if (pathToZip != null) {
			new AutDetailsCollector().collectInformation(aut.getAut(),
					new ZipAutDetailsProcessor(pathToZip));
			}
		}
		return null;
	}
}

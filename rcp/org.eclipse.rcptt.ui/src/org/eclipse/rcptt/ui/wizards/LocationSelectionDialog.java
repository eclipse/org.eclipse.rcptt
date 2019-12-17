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
package org.eclipse.rcptt.ui.wizards;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

import org.eclipse.rcptt.internal.ui.Images;
import org.eclipse.rcptt.internal.ui.Messages;
import org.eclipse.rcptt.ui.commons.Q7ContainerSelectionGroup;

public class LocationSelectionDialog extends Dialog {
	Q7ContainerSelectionGroup containerSelectionGroup;
	private String initialSelection;
	protected IPath location;

	public LocationSelectionDialog(Shell parentShell) {
		super(parentShell);
	}

	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText(Messages.LocationSelectionDialog_Title);
		newShell.setImage(Images.getImageDescriptor(Images.AUT).createImage());
	}

	@Override
	protected int getShellStyle() {
		return super.getShellStyle() | SWT.RESIZE;
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite content = (Composite) super.createDialogArea(parent);
		GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
		data.widthHint = 400;
		data.heightHint = 300;
		content.setLayoutData(data);
		// GridLayoutFactory.swtDefaults().numColumns(1).applyTo(content);

		Listener listener = new Listener() {
			public void handleEvent(Event event) {
				location = containerSelectionGroup.getContainerFullPath();
			}
		};
		containerSelectionGroup = new Q7ContainerSelectionGroup(content,
				listener,
				Messages.LocationSelectionDialog_Q7ContainerSelectionGroupMsg, 400,
				300);
		containerSelectionGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL,
				true, true));
		setLocation(initialSelection);
		updateEnablement(false);
		return content;
	}

	private void updateEnablement(boolean state) {
		if (buttonBar != null) {
			Button button = getButton(OK);
			button.setEnabled(state);
		}
	}

	public void setLocation(String location) {
		if (containerSelectionGroup == null) {
			initialSelection = location;
			return;
		}
		if (location != null) {
			IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
			IPath path = new Path(location);
			if (!path.isEmpty()) {
				IPath folderPath = path.removeFirstSegments(1);
				String projectSegment = path.segment(0);
				if (projectSegment != null) {
					IContainer container = root.getProject(projectSegment);
					if (!folderPath.isEmpty()) {
						container = container.getFolder(folderPath);
					}
					if (container != null && container.exists()) {
						containerSelectionGroup.setSelectedContainer(container);
					}
				}
			}
		}
	}

	public String getLocation() {
		if (location != null) {
			return location.toString();
		}
		return null;
	}

}

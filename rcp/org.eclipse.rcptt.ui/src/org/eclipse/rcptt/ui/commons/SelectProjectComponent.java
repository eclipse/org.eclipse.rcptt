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
package org.eclipse.rcptt.ui.commons;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import org.eclipse.rcptt.core.nature.RcpttNature;
import org.eclipse.rcptt.internal.ui.Messages;

public abstract class SelectProjectComponent {

	private Label label;
	private Combo projectCombo;
	private IProject[] projects;
	private IProject project;
	private IStructuredSelection selection;

	public SelectProjectComponent(IStructuredSelection selection) {
		this.selection = selection;
		if (selection == null) {
			this.selection = new StructuredSelection();
		}
	}

	public void setEnabled(boolean enabled) {
		label.setEnabled(enabled);
		projectCombo.setEnabled(enabled);
	}

	public void create(Composite parent) {
		label = new Label(parent, SWT.LEFT);
		label.setText(Messages.SelectProjectComponent_ProjectLabel);
		label.setLayoutData(getLabelData());
		projectCombo = new Combo(parent, SWT.READ_ONLY);
		projectCombo.setLayoutData(getComboData());
		IProject[] allProjects = ResourcesPlugin.getWorkspace().getRoot()
				.getProjects();
		List<IProject> list = new ArrayList<IProject>();
		for (IProject project : allProjects) {
			try {
				if (RcpttNature.isRcpttProject(project)) {
					list.add(project);
				}
			} catch (Exception e) {
				// ignore any exceptions
			}
		}
		projects = list.toArray(new IProject[list.size()]);
		int index = getInitalProject();
		for (int i = 0; i < projects.length; i++) {
			IProject prj = projects[i];
			projectCombo.add(prj.getName());
		}
		projectCombo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int index = projectCombo.getSelectionIndex();
				IProject newProject = null;
				if (index >= 0 && index < projects.length) {
					newProject = projects[index];
				}
				if (newProject != project) {
					project = newProject;
					projectChanged();
				}
			}
		});
		if (index >= 0) {
			projectCombo.select(index);
			project = projects[index];
		} else if (projects.length > 0) {
			projectCombo.select(0);
			project = projects[0];
		} else {
			projectCombo.setText(Messages.SelectProjectComponent_NoQ7ProjectsComboText);
		}
	}

	public void setProject(String name) {
		for (int i = 0; i < projects.length; i++) {
			if (projects[i].getName().equals(name)) {
				projectCombo.select(i);
				project = projects[i];
				return;
			}
		}
	}

	protected GridData getLabelData() {
		return null;
	}

	protected GridData getComboData() {
		return new GridData(GridData.FILL_HORIZONTAL);
	}

	/**
	 * @return project index
	 */
	private int getInitalProject() {
		Iterator<?> it = selection.iterator();
		if (it.hasNext()) {
			Object object = it.next();
			IResource selectedResource = null;
			if (object instanceof IResource) {
				selectedResource = (IResource) object;
			} else if (object instanceof IAdaptable) {
				selectedResource = (IResource) ((IAdaptable) object)
						.getAdapter(IResource.class);
			}
			if (selectedResource != null) {
				IProject project = selectedResource.getProject();
				for (int i = 0; i < projects.length; i++) {
					IProject prj = projects[i];
					if (project.equals(prj)) {
						return i;
					}
				}
			}
		}
		return -1;
	}

	protected abstract void projectChanged();

	public String validate() {
		if (projects.length == 0) {
			return Messages.SelectProjectComponent_NoQ7ProjectsExistMsg;
		} else if (project == null) {
			return Messages.SelectProjectComponent_NoQ7ProjectSelectedMsg;
		}
		return null;
	}

	public IProject getProject() {
		return project;
	}

}

/*******************************************************************************
 * Copyright (c) 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.zephyr.ui.properties;

import java.util.Map;
import org.eclipse.rcptt.zephyr.internal.ui.Messages;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkbenchPropertyPage;
import org.eclipse.ui.dialogs.PropertyPage;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.rcptt.internal.zephyr.ZephyrPlugin;
import org.eclipse.rcptt.zephyr.ZephyrService;

public final class ZephyrPropertiesPage extends PropertyPage implements IWorkbenchPropertyPage {

	private ZephyrService service;

	private Combo zephyrProject;
	private Combo zephyrVersion;
	private Combo zephyrCycle;

	private Map<String, Long> zephyrProjects;
	private Map<String, Long> zephyrVersions;
	private Map<String, Long> zephyrCycles;

	@Override
	protected Control createContents(final Composite parent) {
		final Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(2, false));
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));

		this.service = new ZephyrService();
		this.zephyrProject = createCombo(composite, Messages.ZephyrPreferencePage_Project, () -> updateVersionList());
		this.zephyrVersion = createCombo(composite, Messages.ZephyrPreferencePage_Version, () -> updateCycleList());
		this.zephyrCycle = createCombo(composite, Messages.ZephyrPreferencePage_Cycle, () -> checkCycle());

		updateProjectList();
		final int projectIndex = this.zephyrProject.indexOf(ZephyrPlugin.getZephyrProject(getRcpttProject()));
		if (projectIndex > -1) {
			this.zephyrProject.select(projectIndex);
			updateVersionList();
			final int versionIndex = this.zephyrVersion.indexOf(ZephyrPlugin.getZephyrVersion(getRcpttProject()));
			if (versionIndex > -1) {
				this.zephyrVersion.select(versionIndex);
				updateCycleList();
				final int cycleIndex = this.zephyrCycle.indexOf(ZephyrPlugin.getZephyrCycle(getRcpttProject()));
				if (cycleIndex > -1) {
					this.zephyrCycle.select(cycleIndex);

				}
			}
		}
		return composite;
	}

	@Override
	public boolean performOk() {
		System.out.print("Perform");
		ZephyrPlugin.setZephyrProject(getItemName(this.zephyrProject), getRcpttProject());
		ZephyrPlugin.setZephyrVersion(getItemName(this.zephyrVersion), getRcpttProject());
		ZephyrPlugin.setZephyrCycle(getItemName(this.zephyrCycle), getRcpttProject());
		return super.performOk();
	}

	@Override
	protected void performDefaults() {
		System.out.print("Default");
		ZephyrPlugin.setZephyrProject("", getRcpttProject());
		ZephyrPlugin.setZephyrVersion("", getRcpttProject());
		ZephyrPlugin.setZephyrCycle("", getRcpttProject());
		this.zephyrProject.clearSelection();
		this.zephyrVersion.clearSelection();
		this.zephyrCycle.clearSelection();
		super.performDefaults();
	}

	private Combo createCombo(final Composite parent, final String labelText, final Runnable runnable) {
		final Label label = new Label(parent, SWT.LEFT);
		label.setText(labelText);

		final Combo combo = new Combo(parent, SWT.DROP_DOWN);
		combo.addModifyListener(new ModifyListener() {
			public void modifyText(final ModifyEvent e) {
				runnable.run();
			}
		});

		combo.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		return combo;
	}

	private void updateProjectList() {
		this.zephyrProjects = service.getAllProjects();
		this.zephyrProject.setItems(getKeyArray(this.zephyrProjects));
		this.zephyrVersion.clearSelection();
	}

	private void updateVersionList() {
		final Long projectId = getProjectId();
		this.zephyrVersions = projectId == null ? null : service.getAllVersions(getProjectId());
		this.zephyrVersion.setItems(getKeyArray(this.zephyrVersions));
		this.zephyrCycle.clearSelection();
	}

	private void updateCycleList() {
		final Long versionId = getVersionId();
		this.zephyrCycles = versionId == null ? null : service.getAllCycles(getProjectId(), versionId);
		this.zephyrCycle.setItems(getKeyArray(this.zephyrCycles));
	}

	private void checkCycle() {
		final Long cycleId = getCycleId();
		if (cycleId == null) {
			setMessage(null);
			setErrorMessage(Messages.ZephyrPropertiesPage_CycleInvalid);
		} else {
			setMessage(Messages.ZephyrPropertiesPage_AllPropertiesValid);
			setErrorMessage(null);
		}
	}

	private String[] getKeyArray(Map<String, Long> items) {
		if (items == null)
			return new String[0];
		return items.keySet().toArray(new String[items.size()]);
	}

	private Long getProjectId() {
		return getItemId(this.zephyrProject, this.zephyrProjects);
	}

	private Long getVersionId() {
		return getItemId(this.zephyrVersion, this.zephyrVersions);
	}

	private Long getCycleId() {
		return getItemId(this.zephyrCycle, this.zephyrCycles);
	}

	private Long getItemId(final Combo item, final Map<String, Long> items) {
		final int index = item.getSelectionIndex();
		return index > -1 && items != null ? items.get(item.getItem(index)) : null;
	}

	private String getItemName(final Combo item) {
		final int index = item.getSelectionIndex();
		return index > -1 ? item.getItem(index) : "";
	}

	private IProject getRcpttProject() {
		return (IProject) this.getElement().getAdapter(IResource.class);
	}

}

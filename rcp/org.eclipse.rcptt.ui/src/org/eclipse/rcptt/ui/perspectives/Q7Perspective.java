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
package org.eclipse.rcptt.ui.perspectives;

import org.eclipse.debug.ui.IDebugUIConstants;
import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;
import org.eclipse.ui.console.IConsoleConstants;

import org.eclipse.rcptt.ui.launching.ExecutionView;
import org.eclipse.rcptt.ui.navigator.Q7Explorer;

/**
 * This class is meant to serve as an example for how various contributions are
 * made to a perspective. Note that some of the extension point id's are
 * referred to as API constants while others are hardcoded and may be subject to
 * change.
 */
public class Q7Perspective implements IPerspectiveFactory {

	private static final String BOTTOM_RIGHT = "bottomRight"; // NON-NLS-1 //$NON-NLS-1$
	private static final String BOTTOM_LEFT = "bottomLeft"; // NON-NLS-1 //$NON-NLS-1$
	private static final String TOP_LEFT = "topLeft"; // NON-NLS-1 //$NON-NLS-1$

	private IPageLayout factory;

	public Q7Perspective() {
		super();
	}

	public void createInitialLayout(IPageLayout factory) {
		this.factory = factory;
		addViews();
		addActions();
		addNewWizardShortcuts();
	}

	private void addViews() {
		IFolderLayout topLeft = factory.createFolder(TOP_LEFT,
				IPageLayout.LEFT, 0.25f, factory.getEditorArea());
		topLeft.addView(Q7Explorer.ID);

		IFolderLayout bottomLeft = factory.createFolder(BOTTOM_LEFT,
				IPageLayout.BOTTOM, 0.5f, TOP_LEFT);
		bottomLeft.addView(ExecutionView.ID);

		IFolderLayout bottomRight = factory.createFolder(BOTTOM_RIGHT,
				IPageLayout.BOTTOM, 0.75f, factory.getEditorArea());
		bottomRight.addView("org.eclipse.rcptt.ui.aut.manager"); //$NON-NLS-1$
		bottomRight.addView("org.eclipse.rcptt.ui.tags"); //$NON-NLS-1$
		bottomRight.addView(IPageLayout.ID_PROBLEM_VIEW);
		bottomRight.addPlaceholder(IConsoleConstants.ID_CONSOLE_VIEW);
	}

	private void addActions() {
		factory.addActionSet(IDebugUIConstants.LAUNCH_ACTION_SET);
	}

	private void addNewWizardShortcuts() {
		factory.addNewWizardShortcut("org.eclipse.rcptt.ui.wizards.newProject"); //$NON-NLS-1$
		factory.addNewWizardShortcut("org.eclipse.ui.wizards.new.folder"); //$NON-NLS-1$
		factory.addNewWizardShortcut("org.eclipse.rcptt.ui.wizards.newContext"); //$NON-NLS-1$
		factory.addNewWizardShortcut("org.eclipse.rcptt.ui.wizards.newVerification"); //$NON-NLS-1$
		factory.addNewWizardShortcut("org.eclipse.rcptt.ui.wizards.newSuperContext"); //$NON-NLS-1$
		factory.addNewWizardShortcut("org.eclipse.rcptt.ui.wizards.newScenario"); //$NON-NLS-1$
		factory.addNewWizardShortcut("org.eclipse.rcptt.ui.wizards.newTestSuite"); //$NON-NLS-1$
	}
}

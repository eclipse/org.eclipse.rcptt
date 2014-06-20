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
package org.eclipse.rcptt.ui.launching.aut;

import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.jface.wizard.WizardDialog;

public interface IAUTConfigWizard {

	void setLaunchConfiguration(ILaunchConfiguration configuration);

	void setWizardDialog(WizardDialog dialog);
}
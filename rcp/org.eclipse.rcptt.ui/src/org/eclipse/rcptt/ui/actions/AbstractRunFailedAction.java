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
package org.eclipse.rcptt.ui.actions;

import org.eclipse.rcptt.internal.ui.Images;
import org.eclipse.rcptt.internal.ui.Messages;
import org.eclipse.ui.actions.BaseSelectionListenerAction;

public class AbstractRunFailedAction extends BaseSelectionListenerAction {

	protected AbstractRunFailedAction() {
		super("Run Failed");
		setToolTipText(Messages.RunFailedAction_ToolTip);
		setImageDescriptor(Images.getImageDescriptor(Images.RUN_FAILED));
		setDisabledImageDescriptor(Images
				.getImageDescriptor(Images.RUN_FAILED_D));
	}

}

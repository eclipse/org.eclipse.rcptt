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

import org.eclipse.rcptt.internal.ui.Images;
import org.eclipse.rcptt.internal.ui.Messages;
import org.eclipse.ui.actions.BaseSelectionListenerAction;

public class AbstractRunAction extends BaseSelectionListenerAction {
	protected AbstractRunAction() {
		super("&Run");
		setToolTipText(Messages.RunSelectedAction_ToolTip);
		setText("&Run");
		setImageDescriptor(Images.getImageDescriptor(Images.PLAY));
		setDisabledImageDescriptor(Images.getImageDescriptor(Images.PLAY_D));
	}
}

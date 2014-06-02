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

import org.eclipse.jface.action.Action;

import org.eclipse.rcptt.internal.ui.Images;
import org.eclipse.rcptt.internal.ui.Messages;
import org.eclipse.rcptt.launching.IExecutionSession;
import org.eclipse.rcptt.launching.Q7Launcher;

public class StopAction extends Action {

    public StopAction() {
        setToolTipText(Messages.StopAction_ToolTip);
        setImageDescriptor(Images.getImageDescriptor(Images.STOP));
        setDisabledImageDescriptor(Images.getImageDescriptor(Images.STOP_D));
        setText("&Stop");
    }

    public void updateEnablement(IExecutionSession session) {
        if (session != null) {
            setEnabled(session.isRunning());
        } else {
            setEnabled(false);
        }
    }

    @Override
    public void run() {
        getLauncher().stop();
        updateEnablement(null);
    }

    private Q7Launcher getLauncher() {
        return Q7Launcher.getInstance();
    }

}

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

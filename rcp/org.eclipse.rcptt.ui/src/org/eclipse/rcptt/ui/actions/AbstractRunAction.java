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

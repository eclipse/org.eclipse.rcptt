package org.eclipse.rcptt.ctx.filesystem.ui.actions;

import org.eclipse.rcptt.internal.ui.Images;

public class Rename extends FSAction {

	public Rename() {
		super("Rename", Images.getImageDescriptor(Images.SCENARIO_EMPTY));
	}

	@Override
	protected void init() {
		setEnabled(selection != null && selection.length == 1);
	}

	@Override
	public void run() {
		viewer.editElement(selection[0], 0);
	}

}

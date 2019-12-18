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
package org.eclipse.rcptt.ui.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionFactory;

import org.eclipse.rcptt.internal.ui.Messages;
import org.eclipse.rcptt.ui.commons.ISelectionActionsHandler;

public abstract class SelectionAction extends Action {

	private final ISelectionActionsHandler handler;

	public SelectionAction(ISelectionActionsHandler handler, String text,
			String actionID, ImageDescriptor image,
			ImageDescriptor imageDisabled) {
		super(text, image);
		setDisabledImageDescriptor(imageDisabled);
		setActionDefinitionId(actionID);

		this.handler = handler;
	}

	public ISelectionActionsHandler getSelectionHandler() {
		return handler;
	}

	public void update() {
		setEnabled(isEnabled());
	}

	public static class RemoveAction extends SelectionAction {

		public RemoveAction(ISelectionActionsHandler handler) {
			super(handler, Messages.SelectionAction_Remove, ActionFactory.DELETE.getCommandId(),
					PlatformUI.getWorkbench().getSharedImages()
							.getImageDescriptor(ISharedImages.IMG_TOOL_DELETE),
					PlatformUI.getWorkbench().getSharedImages()
							.getImageDescriptor(
									ISharedImages.IMG_TOOL_DELETE_DISABLED));
		}

		@Override
		public boolean isEnabled() {
			return getSelectionHandler().canRemove();
		}

		@Override
		public void run() {
			if (isEnabled()) {
				getSelectionHandler().handleRemove();
			}
		}
	}

	public static class CutAction extends SelectionAction {

		public CutAction(ISelectionActionsHandler handler) {
			super(handler, Messages.SelectionAction_Cut, ActionFactory.CUT.getCommandId(), PlatformUI
					.getWorkbench().getSharedImages().getImageDescriptor(
							ISharedImages.IMG_TOOL_CUT), PlatformUI
					.getWorkbench().getSharedImages().getImageDescriptor(
							ISharedImages.IMG_TOOL_CUT_DISABLED));
		}

		@Override
		public boolean isEnabled() {
			return getSelectionHandler().canCut();
		}

		@Override
		public void run() {
			if (isEnabled()) {
				getSelectionHandler().cut();
			}
		}
	}

	public static class CopyAction extends SelectionAction {

		public CopyAction(ISelectionActionsHandler handler) {
			super(handler, Messages.SelectionAction_Copy, ActionFactory.COPY.getCommandId(),
					PlatformUI.getWorkbench().getSharedImages()
							.getImageDescriptor(ISharedImages.IMG_TOOL_COPY),
					PlatformUI.getWorkbench().getSharedImages()
							.getImageDescriptor(
									ISharedImages.IMG_TOOL_COPY_DISABLED));
		}

		@Override
		public boolean isEnabled() {
			return getSelectionHandler().canCopy();
		}

		@Override
		public void run() {
			if (isEnabled()) {
				getSelectionHandler().copy();
			}
		}
	}

	public static class PasteAction extends SelectionAction {

		public PasteAction(ISelectionActionsHandler handler) {
			super(handler, Messages.SelectionAction_Paste, ActionFactory.PASTE.getCommandId(),
					PlatformUI.getWorkbench().getSharedImages()
							.getImageDescriptor(ISharedImages.IMG_TOOL_PASTE),
					PlatformUI.getWorkbench().getSharedImages()
							.getImageDescriptor(
									ISharedImages.IMG_TOOL_PASTE_DISABLED));
		}

		@Override
		public boolean isEnabled() {
			return getSelectionHandler().canPaste();
		}

		@Override
		public void run() {
			if (isEnabled()) {
				getSelectionHandler().paste();
			}
		}
	}
}

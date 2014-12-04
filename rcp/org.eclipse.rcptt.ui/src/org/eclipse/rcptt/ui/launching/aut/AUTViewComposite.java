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

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.rcptt.internal.ui.Images;
import org.eclipse.rcptt.internal.ui.Messages;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.menus.IMenuService;

public class AUTViewComposite extends BasicAUTComposite {
	private IAction runAction;
	private IAction stopAction;
	private Action configureAction;
	private Action newAction;
	private Action deleteAction;
	private Menu menu;
	private IViewSite site;

	public AUTViewComposite(IViewSite site) {
		IActionBars bars = site.getActionBars();
		IToolBarManager manager = bars.getToolBarManager();
		fillActions(manager);
		this.site = site;
	}

	private void fillActions(IToolBarManager manager) {
		runAction = new Action() {
			public void run() {
				launch();
			}
		};
		runAction.setImageDescriptor(Images.getImageDescriptor(Images.APP_RUN));
		runAction.setToolTipText(Messages.AUTViewComposite_RunActionToolTip);
		runAction.setText(Messages.AUTViewComposite_RunActionText);
		manager.add(runAction);

		stopAction = new Action() {
			@Override
			public void run() {
				stop();
			}
		};
		stopAction.setImageDescriptor(Images
				.getImageDescriptor(Images.APP_STOP));
		stopAction.setToolTipText(Messages.AUTViewComposite_StopActionToolTip);
		stopAction.setText(Messages.AUTViewComposite_StopActionText);
		manager.add(stopAction);

		manager.add(new Separator());

		if (getInitWizard("new") != null) {
			newAction = new Action() {
				@Override
				public void run() {
					addAut();
				}
			};
			newAction.setImageDescriptor(getNewImage());
			newAction
					.setToolTipText(Messages.AUTViewComposite_NewActionToolTip);
			newAction.setText(Messages.AUTViewComposite_NewActionText);
			manager.add(newAction);
		}

		configureAction = new Action() {
			@Override
			public void run() {
				configure();
			}
		};
		configureAction.setImageDescriptor(PlatformUI.getWorkbench()
				.getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_DEF_VIEW));
		configureAction
				.setToolTipText(Messages.AUTViewComposite_ConfigureActionToolTip);
		configureAction.setText(Messages.AUTViewComposite_ConfigureActionText);
		manager.add(configureAction);

		deleteAction = new Action() {
			@Override
			public void run() {
				removeAUT();
			}
		};
		deleteAction.setImageDescriptor(getDeleteImage());
		deleteAction
				.setToolTipText(Messages.AUTViewComposite_RemoveActionToolTip);
		deleteAction.setText(Messages.AUTViewComposite_RemoveActionText);
		manager.add(deleteAction);
	}

	@Override
	public void create(Composite parent, boolean border) {
		super.create(parent, border);
		MenuManager mgr = new MenuManager();
		mgr.add(runAction);
		mgr.add(stopAction);
		mgr.add(new Separator());
		if (newAction != null) {
			mgr.add(newAction);
		}
		mgr.add(configureAction);
		mgr.add(deleteAction);
		menu = mgr.createContextMenu(viewer.getControl());
		viewer.getControl().setMenu(menu);
		
		populateMenu(mgr);
	}

	private void populateMenu(MenuManager mgr) {
		IMenuService service = (IMenuService) site.getService(IMenuService.class);
		service.populateContributionManager(mgr, "popup:AUT_context_menu_id");
	}

	@Override
	protected void updateButtonsEnablement() {
		if (runAction != null) {
			AutElement element = getElement();
			int selectionCount = ((IStructuredSelection) (viewer.getSelection()))
					.size();
			if (element == null) {
				runAction.setEnabled(false);
				stopAction.setEnabled(false);
				configureAction.setEnabled(false);
				deleteAction.setEnabled(false);
				return;
			} else {
				runAction.setEnabled(selectionCount == 1
						&& element.couldBeLaunched());
				stopAction.setEnabled(element.couldBeStopped());
				configureAction.setEnabled(selectionCount == 1 && true);
				deleteAction.setEnabled(true);
			}
		}
	}

	protected String getMessageTitle() {
		return Messages.AUTViewComposite_Title;
	}
}

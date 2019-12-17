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
package org.eclipse.rcptt.ctx.capability.ui.views;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.window.Window;
import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.scenario.CapabilityContext;
import org.eclipse.rcptt.core.scenario.CapabilityContextItem;
import org.eclipse.rcptt.core.scenario.ScenarioPackage;
import org.eclipse.rcptt.ctx.capability.CapabilityManager;
import org.eclipse.rcptt.internal.ui.Images;
import org.eclipse.rcptt.ui.controls.AbstractEmbeddedComposite;
import org.eclipse.rcptt.ui.controls.SectionWithToolbar;
import org.eclipse.rcptt.ui.editors.NamedElementEditorActions.INamedElementActions;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;

public class CapabilityContextTables extends AbstractEmbeddedComposite implements INamedElementActions {

	private static final int SECTION_STYLE = Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED;

	private final Map<CapabiltyContextTable, Section> contextToSection = new HashMap<CapabiltyContextTable, Section>();
	private final Adapter adapter = new Adapter();

	private final FormToolkit toolkit;
	private final CapabilityContext context;
	private final IQ7NamedElement namedElement;

	private Composite composite;
	private Action addTool;
	private CapabiltyContextTable activeTable;

	public CapabilityContextTables(IQ7NamedElement namedElement, CapabilityContext context, FormToolkit toolkit) {
		this.namedElement = namedElement;
		this.context = context;
		this.toolkit = toolkit;
	}

	@Override
	public String getName() {
		return Messages.CapabilityContextTables_SectionName;
	}

	@Override
	public Image getImage() {
		return Images.getImage(Images.CONTEXT);
	}

	@Override
	public Control getControl() {
		return composite;
	}

	@Override
	public void dispose() {
		context.eAdapters().remove(adapter);
		super.dispose();
	}

	@Override
	public void createControl(Composite parent) {
		super.createControl(parent);

		composite = new Composite(parent, SWT.NONE);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(composite);
		GridLayoutFactory.fillDefaults().margins(5, 5).spacing(0, 0)
				.equalWidth(true).applyTo(composite);

		context.eAdapters().add(adapter);

		updateTables();
	}

	@Override
	protected void fillActions(IToolBarManager manager) {
		addTool = new Action() {
			@Override
			public void run() {
				handleAddCapability();
			}
		};
		addTool.setText(Messages.CapabilityContextTables_AddActionText);
		addTool.setImageDescriptor(
				PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_OBJ_ADD));

		manager.add(addTool);

		updateActionState();
	}

	protected void handleAddCapability() {
		final CapabilityDialog dialog = new CapabilityDialog(getControl().getShell(), context);
		if (dialog.open() == Window.OK) {
			CapabilityManager.getManager().addCapability(context, dialog.getResult());
		}
	}

	// Start--- INamedElementActions Implementations
	@Override
	public void undo() {
		if (activeTable != null) {
			activeTable.undo();
		}
	}

	@Override
	public void redo() {
		if (activeTable != null) {
			activeTable.redo();
		}

	}

	@Override
	public boolean canUndo() {
		return activeTable != null && activeTable.canUndo();
	}

	@Override
	public boolean canRedo() {
		return activeTable != null && activeTable.canRedo();
	}

	@Override
	public void copy() {
		if (activeTable != null) {
			activeTable.copy();
		}

	}

	@Override
	public void paste() {
		if (activeTable != null) {
			activeTable.paste();
		}

	}

	@Override
	public void cut() {
		if (activeTable != null) {
			activeTable.cut();
		}
	}

	@Override
	public boolean canCopy() {
		return activeTable != null && activeTable.canCopy();
	}

	@Override
	public boolean canPaste() {
		return activeTable != null && activeTable.canPaste();
	}

	@Override
	public boolean canCut() {
		return activeTable != null && activeTable.canCut();
	}
	// End--- INamedElementActions Implementations

	private class Adapter extends EContentAdapter {
		@Override
		public void notifyChanged(Notification notification) {
			super.notifyChanged(notification);

			final Object feature = notification.getFeature();
			if (feature == ScenarioPackage.Literals.CAPABILITY_CONTEXT__ITEMS) {
				updateTables();
				updateActionState();
			} else if (feature == ScenarioPackage.Literals.CAPABILITY_CONTEXT_ITEM__CAPABILITY) {
				updateSectionName();
				updateActionState();
			}
		}
	}

	private void fillUIContextItems() {
		contextToSection.clear();
		for (CapabilityContextItem item : context.getItems()) {
			final CapabiltyContextTable table = new CapabiltyContextTable(namedElement, item);
			final SectionWithToolbar section = new SectionWithToolbar(table, SECTION_STYLE);
			final Section control = section.create(composite, toolkit);
			contextToSection.put(table, control);

			table.getControl().addFocusListener(new FocusListener() {

				@Override
				public void focusLost(FocusEvent e) {
				}

				@Override
				public void focusGained(FocusEvent e) {
					activeTable = table;
				}
			});
		}
	}

	private void updateSectionName() {
		for (Entry<CapabiltyContextTable, Section> entry : contextToSection.entrySet()) {
			entry.getValue().setText(entry.getKey().getName());
		}
	}

	private void updateActionState() {
		addTool.setEnabled(CapabilityManager.getManager().getAvaliableCapabiltiies(context).length != 0);
	}

	private void updateTables() {
		try {
			composite.setRedraw(false);

			final Control[] children = composite.getChildren();
			for (int i = children.length - 1; i >= 0; i--) {
				children[i].dispose();
			}
			fillUIContextItems();

		} finally {
			composite.setRedraw(true);
			composite.layout();
		}
	}

}

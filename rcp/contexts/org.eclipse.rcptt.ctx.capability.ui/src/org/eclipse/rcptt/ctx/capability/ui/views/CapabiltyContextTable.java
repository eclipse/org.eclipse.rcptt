/*******************************************************************************
 * Copyright (c) 2009, 2016 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.ctx.capability.ui.views;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.IValueChangeListener;
import org.eclipse.core.databinding.observable.value.ValueChangeEvent;
import org.eclipse.core.resources.IResource;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.ViewerDropAdapter;
import org.eclipse.jface.window.Window;
import org.eclipse.rcptt.core.model.IContext;
import org.eclipse.rcptt.core.model.IQ7Element.HandleType;
import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.model.ModelException;
import org.eclipse.rcptt.core.model.search.Q7SearchCore;
import org.eclipse.rcptt.core.scenario.CapabilityContext;
import org.eclipse.rcptt.core.scenario.CapabilityContextItem;
import org.eclipse.rcptt.core.scenario.ScenarioPackage;
import org.eclipse.rcptt.core.workspace.RcpttCore;
import org.eclipse.rcptt.ctx.capability.CapabilityManager;
import org.eclipse.rcptt.internal.ui.Images;
import org.eclipse.rcptt.internal.ui.Q7UIPlugin;
import org.eclipse.rcptt.ui.commons.EObjectTable;
import org.eclipse.rcptt.ui.commons.NamedElementTransfer;
import org.eclipse.rcptt.ui.dialogs.ContextSelectionDialog;
import org.eclipse.rcptt.ui.editors.NamedElementLabelProvider;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.dnd.TransferData;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ResourceTransfer;

public class CapabiltyContextTable extends EObjectTable {

	private static NamedElementTransfer TRANSFER = null;

	private final OpenContextEditorHelper openHelper = new OpenContextEditorHelper();
	private final ContextFilter filter = new ContextFilter();
	private final WorkspaceChangeListener workspaceMonitorListener;
	private IQ7NamedElement namedElement;
	private Action editCapability;
	private Action removeCapability;
	private IObservableValue<?> capabilityObservables;

	public CapabiltyContextTable(IQ7NamedElement namedElement, CapabilityContextItem content) {
		super(content, ScenarioPackage.Literals.CAPABILITY_CONTEXT_ITEM__CONTEXT_REFERENCES);
		this.setNamedElement(namedElement);

		workspaceMonitorListener = new WorkspaceChangeListener(this);
		RcpttCore.addElementChangedListener(workspaceMonitorListener);
	}

	@Override
	public String getName() {
		final StringBuilder builder = new StringBuilder();
		final EList<String> capability = getContent().getCapability();
		final int last = capability.size() - 1;

		if (last < 0)
			return ""; //$NON-NLS-1$

		for (int i = 0; i < last; i++) {
			builder.append(capability.get(i)).append(", "); //$NON-NLS-1$
		}
		builder.append(capability.get(last));

		return builder.toString().toUpperCase();
	}

	@Override
	public Image getImage() {
		return Images.getImage(Images.CONTEXT);
	}

	@Override
	public void update(EObject content) {
		super.update(content);

		capabilityObservables = EMFObservables.observeValue(getContent(),
				ScenarioPackage.Literals.CAPABILITY_CONTEXT_ITEM__CAPABILITY);
		capabilityObservables.addValueChangeListener(new IValueChangeListener<Object>() {
			@Override
			public void handleValueChange(ValueChangeEvent<? extends Object> event) {
				updateActionTooltip();
			}
		});
	}

	@Override
	public void createControl(Composite parent) {
		super.createControl(parent);

		viewer.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				IStructuredSelection selection = (IStructuredSelection) event.getSelection();
				openHelper.open(selection, namedElement.getQ7Project());
			}
		});
	}

	@Override
	public void dispose() {
		if (capabilityObservables != null) {
			capabilityObservables.dispose();
		}

		RcpttCore.removeElementChangedListener(workspaceMonitorListener);
		super.dispose();
	}

	@Override
	protected ILabelProvider createLabelProvider() {
		return new NamedElementLabelProvider(getNamedElement().getQ7Project());
	}

	@Override
	protected Object[] handleAdd() {
		ContextSelectionDialog dialog = new ContextSelectionDialog(getControl().getShell(), getNamedElement(), null) {
			@Override
			protected boolean isValidToAdd(IContext context) {
				return filter.isValidToAdd(context, getNamedElement());
			}
		};
		if (dialog.open() == Window.OK) {
			Object[] selected = dialog.getResult();
			List<String> list = new ArrayList<String>();
			if (selected != null) {
				for (int i = 0; i < selected.length; i++) {
					IContext context = (IContext) selected[i];
					try {
						String id = Q7SearchCore.findIDByDocument(context);
						if (id == null) {
							id = context.getID();
						}
						list.add(id);
					} catch (ModelException e) {
						Q7UIPlugin.log(e);
					}
				}
			}
			setVisible(true);
			return list.toArray(new String[list.size()]);
		}
		return null;
	}

	@Override
	protected Class<?> getContentsType() {
		return String.class;
	}

	@Override
	protected Transfer getContentTransfer() {
		if (null == TRANSFER) {
			TRANSFER = new NamedElementTransfer();
		}
		return TRANSFER;
	}

	@Override
	protected HandleType getAppropriateHandleType() {
		return HandleType.Context;
	}

	protected CapabilityContextItem getContent() {
		return (CapabilityContextItem) content;
	}

	@Override
	protected void fillActions(IToolBarManager toolBarManager) {
		super.fillActions(toolBarManager);

		// start section of initialize action
		editCapability = new Action() {
			@Override
			public void run() {
				handleEditItem();
			}
		};

		editCapability.setImageDescriptor(Images.getImageDescriptor(Images.PANEL_MENU));

		removeCapability = new Action() {
			@Override
			public void run() {
				handleRemoveItem();
			}
		};
		removeCapability.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_ETOOL_CLEAR));

		updateActionTooltip();
		// end section of initialize action

		toolBarManager.add(new Separator());
		toolBarManager.add(editCapability);
		toolBarManager.add(removeCapability);
	}

	@Override
	protected boolean allowDrag(IStructuredSelection selection) {
		if (!super.allowDrag(selection)) {
			return false;
		}
		Object element = selection.getFirstElement();
		if (element == null || !(element instanceof String)) {
			return false;
		}
		return true;
	}

	@Override
	protected boolean doPerformDrop(Object data, Object currentTarget, int currentLocation) {
		if (data instanceof IResource[]) {
			IResource[] resources = (IResource[]) data;
			EList<Object> content = getContents();
			int targetPosition = content.size() - 1;
			if (currentTarget != null) {
				targetPosition = content.indexOf(currentTarget);
			}
			if (currentLocation == ViewerDropAdapter.LOCATION_AFTER
					|| currentLocation == ViewerDropAdapter.LOCATION_NONE) {
				targetPosition++;
			}
			EList<Object> contents = getContents();
			List<String> newContents = new ArrayList<String>();
			for (IResource resource : resources) {
				IQ7NamedElement element = ResourceUtils.getNamedElementByResource(resource);
				if (filter.isValidToAdd(element, getNamedElement())) {
					try {
						newContents.add(element.getID());
					} catch (ModelException e) {
						Q7UIPlugin.log(e);
					}
				}
			}
			if (targetPosition != -1) {
				contents.addAll(targetPosition, newContents);
			} else {
				contents.addAll(newContents);
			}
			refresh();

			return true;
		} else {
			return super.doPerformDrop(data, currentTarget, currentLocation);
		}
	}

	@Override
	protected boolean doValidateDrop(Object target, int operation, TransferData transferType, int currentLocation) {
		if (ResourceTransfer.getInstance().isSupportedType(transferType)) {
			IResource[] resources = ResourceUtils.getSelectedResources();
			for (IResource resource : resources) {
				IQ7NamedElement element = ResourceUtils.getNamedElementByResource(resource);
				if (filter.isValidToAdd(element, getNamedElement())) {
					return true;
				}
			}
			return false;
		}
		return super.doValidateDrop(target, operation, transferType, currentLocation);
	}

	@Override
	protected Transfer[] getDropTransferTypes() {
		Transfer[] base = super.getDropTransferTypes();
		Transfer[] result = new Transfer[base.length + 1];
		for (int i = 0; i < base.length; i++) {
			result[i] = base[i];
		}
		result[base.length] = ResourceTransfer.getInstance();
		return result;
	}

	protected void handleRemoveItem() {
		getContext().getItems().remove(getContent());
	}

	protected void handleEditItem() {
		final CapabilityDialog dialog = new CapabilityDialog(getControl().getShell(), getContext(), getContent());
		if (dialog.open() == Window.OK) {
			CapabilityManager.getManager().updateCapabilityItem(getContent(), dialog.getResult());
		}
	}

	protected CapabilityContext getContext() {
		return (CapabilityContext) (getContent().eContainer());
	}

	private void updateActionTooltip() {
		String name = getName();
		editCapability.setText(Messages.CapabiltyContextTable_EditActionTooltip + name);
		removeCapability.setText(Messages.CapabiltyContextTable_DeleteActionTooltip + name);
	}

	/* package */ IQ7NamedElement getNamedElement() {
		return namedElement;
	}

	/* package */ void setNamedElement(IQ7NamedElement namedElement) {
		this.namedElement = namedElement;
	}

	/* package */ TableViewer getTableViewer() {
		return viewer;
	}
}

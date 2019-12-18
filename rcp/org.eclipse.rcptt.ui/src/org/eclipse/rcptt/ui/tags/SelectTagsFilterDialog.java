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
package org.eclipse.rcptt.ui.tags;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.dialogs.TrayDialog;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.tags.Tag;
import org.eclipse.rcptt.core.tags.TagsPackage;
import org.eclipse.rcptt.core.tags.TagsRegistry;
import org.eclipse.rcptt.internal.ui.IQ7HelpContextIds;
import org.eclipse.rcptt.internal.ui.Images;
import org.eclipse.rcptt.internal.ui.Messages;
import org.eclipse.rcptt.internal.ui.Q7UIPlugin;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

public class SelectTagsFilterDialog extends TrayDialog {
	
	private static final String SETTINGS_KEY = "SelectTagDialog"; //$NON-NLS-1$
	private TagsFilterComposite tagsComposite;
	private TreeViewer tagsViewer;
	private TableViewer listViewer;
	private final List<Tag> selectedTags = new ArrayList<Tag>();
	private final List<IQ7NamedElement> selectedItems = new ArrayList<IQ7NamedElement>();

	public SelectTagsFilterDialog(final Shell parentShell) {
		super(parentShell);

		Assert.isNotNull(parentShell, "parentShell"); //$NON-NLS-1$

		setShellStyle(SWT.CLOSE | SWT.MIN | SWT.MAX | SWT.RESIZE | SWT.APPLICATION_MODAL);
	}

	@Override
	protected Control createDialogArea(final Composite parent) {
		final Composite panel = (Composite) super.createDialogArea(parent);
		
		tagsComposite = new TagsFilterComposite(panel, false);
		tagsViewer = tagsComposite.getTagsViewer();
		listViewer = tagsComposite.getListViewer();
		
		tagsViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(final SelectionChangedEvent event) {
				final IStructuredSelection iss = (IStructuredSelection) event.getSelection();
				clearResult();
				for (final Object o : iss.toList()) {
					selectedTags.add((Tag) o);
				}

				validate();
			}
		});
		tagsViewer.addDoubleClickListener(new IDoubleClickListener() {
			@Override
			public void doubleClick(final DoubleClickEvent event) {
				setReturnCode(OK);
				selectedTags.clear();
				selectedTags.add((Tag) ((IStructuredSelection) event.getSelection()).getFirstElement());
				close();
			}
		});
		
		listViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				final IStructuredSelection iss = (IStructuredSelection) event.getSelection();
				clearResult();
				for (final Object o : iss.toList()) {
					selectedItems.add((IQ7NamedElement) o);
				}

				validate();
			}
		});
		listViewer.addDoubleClickListener(new IDoubleClickListener() {
			@Override
			public void doubleClick(final DoubleClickEvent event) {
				setReturnCode(OK);
				selectedItems.clear();
				selectedItems.add((IQ7NamedElement) ((IStructuredSelection) event.getSelection()).getFirstElement());
				close();
			}
		});
		
		
		TagsRegistry tagsRegistry = Q7UIPlugin.getDefault().getTags();
		tagsComposite.tags = EMFObservables.observeList(tagsRegistry, TagsPackage.Literals.TAGS_REGISTRY__TAGS);
		tagsViewer.setInput(tagsComposite.tags);
		
		PlatformUI.getWorkbench().getHelpSystem().setHelp(panel, IQ7HelpContextIds.TAGS);
		return panel;
	}
	
	protected void validate() {
		Button button = getButton(OK);
		if (button != null) {
			if (!selectedTags.isEmpty() || !selectedItems.isEmpty()) {
				button.setEnabled(true);
			} else {
				button.setEnabled(false);
			}
		}
	}
	
	public List<Tag> getSelectedTags() {
		return selectedTags;
	}

	public List<IQ7NamedElement> getSelectedItems() {
		return selectedItems;
	}
	
	private void clearResult() {
		selectedTags.clear();
		selectedItems.clear();
	}

	@Override
	protected void cancelPressed() {
		setReturnCode(CANCEL);
		clearResult();
		close();
	}
	
	@Override
	protected void configureShell(final Shell newShell) {
		super.configureShell(newShell);
		newShell.setText(Messages.SelectTagDialog_Title);
		newShell.setImage(Images.getImageDescriptor(Images.TAG).createImage());
		newShell.layout(true);
	}

	@Override
	public int open() {
		clearResult();
		return super.open();
	}

	@Override
	protected IDialogSettings getDialogBoundsSettings() {
		final IDialogSettings root = Q7UIPlugin.getDefault().getDialogSettings();
		IDialogSettings section = root.getSection(SETTINGS_KEY);
		if (section == null) {
			section = root.addNewSection(SETTINGS_KEY);
		}
		return section;
	}

}

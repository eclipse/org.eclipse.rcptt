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
package org.eclipse.rcptt.ui.tags;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.core.databinding.observable.list.ObservableList;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.core.databinding.observable.masterdetail.IObservableFactory;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.databinding.viewers.ObservableListTreeContentProvider;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.dialogs.TrayDialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.StyledString.Styler;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.TextStyle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

import org.eclipse.rcptt.internal.ui.IQ7HelpContextIds;
import org.eclipse.rcptt.internal.ui.Images;
import org.eclipse.rcptt.internal.ui.Messages;
import org.eclipse.rcptt.internal.ui.Q7UIPlugin;
import org.eclipse.rcptt.ui.commons.SearchControl;
import org.eclipse.rcptt.core.tags.Tag;
import org.eclipse.rcptt.core.tags.TagsRegistry;
import org.eclipse.rcptt.core.utils.TagsUtil;
import org.eclipse.rcptt.ui.utils.TreeViewerWildcardFilter;

public class SelectTagDialog extends TrayDialog {
	private final List<Tag> result = new ArrayList<Tag>();
	private final List<String> disabledTags;
	protected String tagName;

	private class TagLabels extends LabelProvider implements IColorProvider,
			IStyledLabelProvider, IBaseLabelProvider {
		@Override
		public Image getImage(final Object element) {
			return null;
		}

		public String getText(final Object element) {
			final Tag tag = (Tag) element;
			int size = TagsUtil.getDistinctTagRefsCount(tag);
			if (size == 1)
				return Messages.bind(
						Messages.SelectTagDialog_TagWithOneOccurrenceFormat,
						tag.getValue());
			else
				return Messages.bind(
						Messages.SelectTagDialog_TagWithManyOccurrencesFormat,
						tag.getValue(), size);
		}

		public Color getForeground(Object element) {
			// final Tag tag = (Tag) element;
			// return disabledTags.contains(tag.getPath()) ? getShell()
			// .getDisplay().getSystemColor(SWT.COLOR_GRAY) : null;
			return null;
		}

		public Color getBackground(Object element) {
			return null;
		}

		public StyledString getStyledText(Object element) {
			StyledString ss = new StyledString();
			final Tag tag = (Tag) element;
			int size = TagsUtil.getDistinctTagRefsCount(tag);
			if (size == 1)
				ss.append(Messages.bind(
						Messages.SelectTagDialog_TagWithOneOccurrenceFormat,
						tag.getValue()));
			else
				ss.append(Messages.bind(
						Messages.SelectTagDialog_TagWithManyOccurrencesFormat,
						tag.getValue(), size));
			int pos = tag.getValue().length();
			ss.setStyle(pos, ss.length() - pos, new Styler() {
				@Override
				public void applyStyles(TextStyle textStyle) {
					textStyle.foreground = getShell().getDisplay()
							.getSystemColor(SWT.COLOR_GRAY);
				}
			});
			return ss;
		}
	}

	public SelectTagDialog(final Shell parentShell,
			final List<String> disabledTags) {
		super(parentShell);

		Assert.isNotNull(parentShell, "parentShell"); //$NON-NLS-1$
		Assert.isNotNull(disabledTags, "disabledTags"); //$NON-NLS-1$

		this.disabledTags = disabledTags;

		setShellStyle(SWT.CLOSE | SWT.MIN | SWT.MAX | SWT.RESIZE
				| SWT.APPLICATION_MODAL);
	}

	@Override
	protected Control createDialogArea(final Composite parent) {
		final Composite panel = (Composite) super.createDialogArea(parent);

		final SearchControl searchControl = new SearchControl(panel);
		searchControl.setInitialText(Messages.SelectTagDialog_InitialTagName);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(searchControl);
		final TreeViewer tagsViewer = new TreeViewer(panel, SWT.BORDER
				| SWT.MULTI);
		tagsViewer.getControl().setLayoutData(
				new GridData(SWT.FILL, SWT.FILL, true, true));
		searchControl.setSearchResultControl(tagsViewer.getControl());
		searchControl.getFilterControl().addModifyListener(
				new ModifyListener() {
					public void modifyText(ModifyEvent e) {
						String value = searchControl.getFilterString();
						if (!searchControl.getInitialText().equals(value)) {
							tagName = value;
						} else {
							tagName = null;
						}
						tagsViewer.refresh();
						validate();
					}
				});

		tagsViewer
				.setFilters(new ViewerFilter[] { new TreeViewerWildcardFilter(
						tagsViewer) {
					protected boolean isIgnoredElement(Object parentElement,
							Object element) {
						return false;
					}

					@Override
					protected String getFilterText() {
						String value = searchControl.getFilterString();
						if (!searchControl.getInitialText().equals(value)) {
							return value;
						}
						return ""; //$NON-NLS-1$
					}

					@Override
					protected String getElementText(Object parentElement,
							Object element) {
						return ((Tag) element).getValue();
					}

				} });

		final ObservableListTreeContentProvider contentProvider = new ObservableListTreeContentProvider(
				new IObservableFactory() {

					public IObservable createObservable(final Object target) {
						if (target instanceof IObservable) {
							return (IObservable) target;
						} else if (target instanceof Tag) {
							final Tag tag = (Tag) target;
							ObservableList list = new WritableList();
							synchronized (tag) {
								EList<Tag> tags = tag.getTags();
								for (Tag childTag : tags) {
									synchronized (childTag) {
										if (childTag.getTags().size() > 0
												|| !disabledTags.contains(childTag
														.getPath())) {
											list.add(childTag);
										}
									}
								}
							}
							return list;
						} else {
							return null;
						}
					}
				}, null);

		tagsViewer.setContentProvider(contentProvider);

		allTags = new WritableList();
		TagsRegistry tagRegistry = Q7UIPlugin.getDefault().getTags();
		synchronized (tagRegistry) {
			EList<Tag> tags = tagRegistry.getTags();
			for (Tag childTag : tags) {
				synchronized (childTag) {
					if (childTag.getTags().size() > 0
							|| !disabledTags.contains(childTag.getPath())) {
						allTags.add(childTag);
					}
				}
			}
		}
		tagsViewer.setInput(allTags);
		tagsViewer.setLabelProvider(new DelegatingStyledCellLabelProvider(
				new TagLabels()));
		tagsViewer.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(final SelectionChangedEvent event) {
				final IStructuredSelection iss = (IStructuredSelection) event
						.getSelection();
				result.clear();

				boolean changed = false;
				for (final Object o : iss.toList()) {
					final Tag tag = (Tag) o;
					if (!disabledTags.contains(tag.getPath())) {
						result.add(tag);
					} else {
						changed = true;
					}
				}

				if (changed) {
					tagsViewer.setSelection(new StructuredSelection(result));
				}
				validate();
			}
		});
		tagsViewer.addDoubleClickListener(new IDoubleClickListener() {

			public void doubleClick(final DoubleClickEvent event) {
				setReturnCode(OK);
				result.clear();
				result.add((Tag) ((IStructuredSelection) event.getSelection())
						.getFirstElement());
				close();
			}
		});
		validate();

		PlatformUI.getWorkbench().getHelpSystem()
				.setHelp(panel, IQ7HelpContextIds.TAGS);
		return panel;
	}

	protected void validate() {
		Button button = getButton(OK);
		if (button != null) {
			if (!result.isEmpty()
					|| (tagName != null && tagName.trim().length() > 0)) {
				if (!disabledTags.contains(tagName)) {
					button.setEnabled(true);
				}
			} else {
				button.setEnabled(false);
			}
		}
	}

	@Override
	protected void cancelPressed() {
		setReturnCode(CANCEL);
		result.clear();
		close();
	}

	public List<Tag> getResult() {
		return result;
	}

	public String getTagName() {
		return tagName;
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
		result.clear();
		return super.open();
	}

	private static final String SETTINGS_KEY = "SelectTagDialog"; //$NON-NLS-1$
	private ObservableList allTags;

	@Override
	protected IDialogSettings getDialogBoundsSettings() {
		final IDialogSettings root = Q7UIPlugin.getDefault()
				.getDialogSettings();
		IDialogSettings section = root.getSection(SETTINGS_KEY);
		if (section == null) {
			section = root.addNewSection(SETTINGS_KEY);
		}
		return section;
	}

	@Override
	protected Point getInitialSize() {
		final Point calculatedSize = super.getInitialSize();
		if (calculatedSize.x < 500) {
			calculatedSize.x = 500;
		}
		if (calculatedSize.y < 400) {
			calculatedSize.y = 400;
		}
		return calculatedSize;
	}

}

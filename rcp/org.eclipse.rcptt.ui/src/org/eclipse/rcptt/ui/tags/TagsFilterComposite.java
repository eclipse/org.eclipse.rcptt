/*******************************************************************************
 * Copyright (c) 2009, 2016 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 * 	Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.ui.tags;

import static org.eclipse.rcptt.core.search.tags.TagsContentAssist.OPERATOR_OR;
import static org.eclipse.rcptt.core.search.tags.TagsContentAssist.REGEX_SPEC_CHARS;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.masterdetail.IObservableFactory;
import org.eclipse.emf.databinding.EObjectObservableList;
import org.eclipse.jface.bindings.keys.KeyStroke;
import org.eclipse.jface.databinding.viewers.ObservableListTreeContentProvider;
import org.eclipse.jface.fieldassist.ContentProposal;
import org.eclipse.jface.fieldassist.ContentProposalAdapter;
import org.eclipse.jface.fieldassist.IContentProposal;
import org.eclipse.jface.fieldassist.IContentProposalListener;
import org.eclipse.jface.fieldassist.IContentProposalProvider;
import org.eclipse.jface.fieldassist.IControlContentAdapter;
import org.eclipse.jface.fieldassist.TextContentAdapter;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.search.tags.TagsContentAssist;
import org.eclipse.rcptt.core.search.tags.TagsSearch;
import org.eclipse.rcptt.core.tags.Tag;
import org.eclipse.rcptt.core.tags.TagsPackage;
import org.eclipse.rcptt.core.utils.TagsUtil;
import org.eclipse.rcptt.internal.ui.Images;
import org.eclipse.rcptt.internal.ui.Messages;
import org.eclipse.rcptt.ui.commons.SearchControl;
import org.eclipse.rcptt.ui.utils.ModelUtils;
import org.eclipse.rcptt.util.StringUtils;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Tree;

/**
 * Creates a control with filtering RCPTT items by their tags.
 * 
 * Contains tags tree view + item list view + filter control + autocomplete.
 * Filter works with and/AND/&/or/OR/|/NOT/! operators and parentheses. E.g.: tag1 OR ("tag with space" AND !tag2)
 */
public class TagsFilterComposite {
	
	private static final String TOOLTIP_FILTER = "E.g. tag1 OR (tag2 AND !tag3)";
	
	public IObservableList tags;
	
	private SearchControl searchControl;
	private TreeViewer tagsViewer;
	private TableViewer listViewer;
	private AutocompleteContentProposalAdapter proposalAdapter;
	
	private boolean isHorizontal;

	public TagsFilterComposite(Composite parent, boolean isHorizontal) {
		this.isHorizontal = isHorizontal;
		
		Composite panel;
		if (isHorizontal) {
			panel = new Composite(parent, SWT.NONE);
			GridLayoutFactory.fillDefaults().numColumns(3).equalWidth(true).margins(0, 0).applyTo(panel);
			GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).applyTo(panel);
		} else {
			panel = new Composite(parent, SWT.NONE);
			GridLayoutFactory.fillDefaults().margins(0, 0).applyTo(panel);
			GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).applyTo(panel);
		}
		
		createFilterControl(panel);
		createTreeControl(panel);
		createListControl(panel);
	}

	public TreeViewer getTagsViewer() {
		return tagsViewer;
	}
	
	public TableViewer getListViewer() {
		return listViewer;
	}
	
 	/**
	 * Updates RCPTT item list depending on current filter value.
	 */
	public void updateList() {
		String string = searchControl.getFilterString();
		if (string == null)
			string = "";
		string = string.trim();
		
		if (string.isEmpty()) {
			listViewer.setInput(null);
		} else {
			listViewer.setInput(TagsSearch.findAllByExpression(string));
		}
	}
	
	/**
	 * Autocomplete proposal provider class.
	 */
	public class AutocompleteContentProposalProvider implements IContentProposalProvider {

		@SuppressWarnings("unchecked")
		@Override
		public IContentProposal[] getProposals(String contents, int position) {
			ArrayList<String> proposals = TagsContentAssist.getOffers(searchControl.getFilterString(), tags);
			IContentProposal[] contentProposals = new IContentProposal[proposals.size()];
			for (int i = 0; i < proposals.size(); i++) {
				contentProposals[i] = new ContentProposal(proposals.get(i));
			}

			return contentProposals;
		}

	}

	/**
	 * Autocomplete proposal adapter class.
	 */
	public class AutocompleteContentProposalAdapter extends ContentProposalAdapter {

		public AutocompleteContentProposalAdapter(Control control, IControlContentAdapter controlContentAdapter,
				IContentProposalProvider proposalProvider, KeyStroke keyStroke, char[] autoActivationCharacters) {
			super(control, controlContentAdapter, proposalProvider, keyStroke, autoActivationCharacters);
		}

		public void showProposals() {
			openProposalPopup();
		}

	}
	
	private void createFilterControl(Composite panel) {
		// Filter control
		searchControl = new SearchControl(panel);
		if (isHorizontal) {
			GridDataFactory.fillDefaults().grab(true, false).span(3, 1).applyTo(searchControl);
		} else {
			GridDataFactory.fillDefaults().grab(true, false).applyTo(searchControl);
		}
		
		searchControl.setInitialText("Tag name");
		searchControl.getFilterControl().setToolTipText(TOOLTIP_FILTER);

		proposalAdapter = new AutocompleteContentProposalAdapter(searchControl.getFilterControl(),
				new TextContentAdapter(), new AutocompleteContentProposalProvider(), null, null);
		proposalAdapter.setPropagateKeys(true);
		proposalAdapter.setProposalAcceptanceStyle(ContentProposalAdapter.PROPOSAL_REPLACE);
		proposalAdapter.addContentProposalListener(new IContentProposalListener() {

			@Override
			public void proposalAccepted(IContentProposal proposal) {
				selectAutocompleteOffer();
			}

		});

		searchControl.getFilterControl().addListener(SWT.KeyDown, new Listener() {
			@Override
			public void handleEvent(Event event) {
				switch (event.keyCode) {
				// ContentProposalAdapter can't be activated by any character and CTRL+SPACE at the same time,
				// so by default it's activated by any alphanumeric character and here it's activated by CTRL+SPACE
				case SWT.SPACE:
					if ((event.stateMask & SWT.CTRL) == SWT.CTRL) {
						proposalAdapter.showProposals();
						event.doit = false;
					}
					break;
				// Uses Enter to refresh listViewer if User typed filter query instead of using autocompletion
				case SWT.CR:
					selectAutocompleteOffer();
					break;
				}
			}
		});
	}
	
	private void selectAutocompleteOffer() {
		updateList();
		tagsViewer.setSelection(null);
		
		// Selects all RCPTT items
		int index = listViewer.getTable().getItemCount();
		List<Object> toSelect = new ArrayList<Object>();
		while (--index >= 0) {
			toSelect.add(listViewer.getElementAt(index));
		}
		listViewer.setSelection(new StructuredSelection(toSelect), true);
	}
	
	private void createTreeControl(Composite panel) {
		Tree tree = new Tree(panel, SWT.BORDER | SWT.MULTI);
		if (isHorizontal) {
			GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).applyTo(tree);
		} else {
			GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).hint(SWT.DEFAULT, 220).applyTo(tree);
		}
		
		ObservableListTreeContentProvider treeContentProvider = new ObservableListTreeContentProvider(
				new IObservableFactory() {
					@Override
					public IObservable createObservable(Object target) {
						if (target instanceof IObservable) {
							return (IObservable) target;
						} else if (target instanceof Tag) {
							final Tag tag = (Tag) target;
							return new EObjectObservableList(tag, TagsPackage.Literals.TAG__TAGS);
						} else {
							return null;
						}
					}
				}, null);
		
		LabelProvider treeLabelProvider = new LabelProvider() {
			@Override
			public Image getImage(Object element) {
				return Images.getImage(Images.TAG);
			}

			@Override
			public String getText(Object element) {
				final Tag tag = (Tag) element;
				final String value = tag.getValue().trim();
				if (value.length() == 0) {
					return Messages.bind(
							Messages.TagsView_UntaggedLabelFormat,
							TagsUtil.getDistinctTagRefsCount(tag));
				} else {
					return Messages.bind(Messages.TagsView_TagLabelFormat,
							value, TagsUtil.getDistinctTagRefsCount(tag));
				}
			}
		};
		
		tagsViewer = new TreeViewer(tree);
		tagsViewer.setContentProvider(treeContentProvider);
		tagsViewer.setLabelProvider(treeLabelProvider);
		tagsViewer.setSorter(new ViewerSorter());
		tagsViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				updateFilterControl((IStructuredSelection) event.getSelection());
			}
		});
		tagsViewer.getControl().addDisposeListener(new DisposeListener() {
			@Override
			public void widgetDisposed(DisposeEvent e) {
				if (tags != null)
					tags.dispose();
			}
		});
	}
	
	private void createListControl(Composite panel) {
		listViewer = new TableViewer(panel, SWT.BORDER | SWT.MULTI);
		if (isHorizontal) {
			GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).span(2, 1).applyTo(listViewer.getTable());
		} else {
			GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).applyTo(listViewer.getTable());
		}
		IStructuredContentProvider listContentProvider = new IStructuredContentProvider() {
			@Override
			public void dispose() {
			}

			@Override
			public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			}

			@Override
			public Object[] getElements(Object inputElement) {
				if (inputElement instanceof Tag) {
					List<IQ7NamedElement> refs = ((Tag) inputElement).getRefs();
					return refs.toArray(new Object[refs.size()]);
				}
				
				if (inputElement instanceof IQ7NamedElement[]) {
					IQ7NamedElement[] list = (IQ7NamedElement[]) inputElement;
					return list;
				}
				
				return new Object[0];
			}
			
		};

		LabelProvider listLabelProvider = new LabelProvider() {
			@Override
			public Image getImage(Object element) {
				if (element instanceof IQ7NamedElement) {
					return ModelUtils.getImage((IQ7NamedElement) element);
				}
				return Images.getImage(Images.UNKNOWN);
			}

			@Override
			public String getText(Object element) {
				if (element instanceof IQ7NamedElement) {
					return ModelUtils.getText((IQ7NamedElement) element);
				} else {
					return element != null ? element.toString() : "null"; //$NON-NLS-1$
				}
			}
		};
		
		listViewer.setContentProvider(listContentProvider);
		listViewer.setLabelProvider(listLabelProvider);
		listViewer.setSorter(new ViewerSorter());
	}
	
	private void updateFilterControl(IStructuredSelection selection) {
		if (selection.size() >= 1) {
			ArrayList<String> tags = new ArrayList<String>();
			for (Object o : selection.toArray()) {
				if (o instanceof Tag) {
					String tagName = ((Tag) o).getPath();
					if (tagName.matches(REGEX_SPEC_CHARS)) {
						tags.add("\"" + tagName + "\"");
					} else {
						tags.add(tagName);
					}
				}
			}
			
			proposalAdapter.setEnabled(false);
			searchControl.getFilterControl().setText(StringUtils.join(" " + OPERATOR_OR + " ", tags));
			proposalAdapter.setEnabled(true);
			if (selection.size() == 1) {
				listViewer.setInput(selection.getFirstElement()); // Don't run searching if only one tag is selected
			} else {
				updateList();
			}
		}
	}
	
}

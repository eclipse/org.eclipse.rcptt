package org.eclipse.rcptt.ui.tags;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.masterdetail.IObservableFactory;
import org.eclipse.emf.databinding.EObjectObservableList;
import org.eclipse.jface.databinding.viewers.ObservableListTreeContentProvider;
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
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Tree;

/**
 * Creates a control with filtering RCPTT items by their tags.
 * 
 * Contains tags tree view + item list view + filter control + autocomplete.
 * Filter works with and/AND/&, or/OR/| and parentheses. E.g.: tag1 AND ("tag with space" OR tag2)
 */
public class TagsFilterComposite {
	
	private static final String OPERATOR_OR = "OR";
	private static final String OPERATOR_AND = "AND";
	private static final String REGEX_LAST_SEGMENT = "^.*(\\(| or | OR | \\| | and | AND | & | not | NOT |!)(.*)$";
	private static final String REGEX_SPEC_CHARS = ".*[ ()!].*";
	private static final String TOOLTIP_FILTER = "Feel free to use AND, OR and parentheses";
	
	public IObservableList tags;
	
	private SearchControl searchControl;
	private TreeViewer tagsViewer;
	private TableViewer listViewer;
	private Shell popupShell;
	private Table popupTable;
	
	private boolean autocompleteOff = false;
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
	
	public void hidePopup() {
		if (!popupShell.isDisposed())
			popupShell.setVisible(false);
	}
	
	private void createFilterControl(Composite panel) {
		final Display display = panel.getDisplay();
		final Shell shell = panel.getShell();
		
		// Autocomplete popup
		popupShell = new Shell(shell, SWT.ON_TOP);
		popupShell.setLayout(new FillLayout());
		popupTable = new Table(popupShell, SWT.SINGLE);
		popupTable.addListener(SWT.KeyDown, new Listener() {
			@Override
			public void handleEvent(Event event) {
				switch (event.keyCode) {
				case SWT.ESC:
					popupShell.setVisible(false);
					break;
				case SWT.CR:
					selectAutocompleteOffer();
					break;
				}
			}
		});
		popupTable.addMouseListener(new MouseListener() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				selectAutocompleteOffer();
			}

			@Override
			public void mouseDown(MouseEvent e) {
			}

			@Override
			public void mouseUp(MouseEvent e) {
			}
		});
		
		// Filter control
		searchControl = new SearchControl(panel);
		if (isHorizontal) {
			GridDataFactory.fillDefaults().grab(true, false).span(3, 1).applyTo(searchControl);
		} else {
			GridDataFactory.fillDefaults().grab(true, false).applyTo(searchControl);
		}
		
		searchControl.setInitialText("Tag name");
		searchControl.getFilterControl().setToolTipText(TOOLTIP_FILTER);
		searchControl.getFilterControl().addListener(SWT.KeyDown, new Listener() {
			@Override
			public void handleEvent(Event event) {
				switch (event.keyCode) {
				case SWT.ARROW_DOWN:
					int index = (popupTable.getSelectionIndex() + 1) % popupTable.getItemCount();
					popupTable.setSelection(index);
					event.doit = false;
					break;
				case SWT.ARROW_UP:
					index = popupTable.getSelectionIndex() - 1;
					if (index < 0)
						index = popupTable.getItemCount() - 1;
					popupTable.setSelection(index);
					event.doit = false;
					break;
				case SWT.ESC:
					popupShell.setVisible(false);
					break;
				case SWT.SPACE:
					if ((event.stateMask & SWT.CTRL) == SWT.CTRL) {
						showAutocomplete();
						event.doit = false;
					}
					break;
				case SWT.CR:
					selectAutocompleteOffer();
					break;
				}
			}
		});
		searchControl.getFilterControl().addListener(SWT.Modify, new Listener() {
			@Override
			public void handleEvent(Event event) {
				showAutocomplete();
			}
		});

		// Close popup staff
		Listener focusOutListener = new Listener() {
			@Override
			public void handleEvent(Event event) {
				// Async is needed to wait until focus reaches its new Control
				display.asyncExec(new Runnable() {
					@Override
					public void run() {
						if (display.isDisposed())
							return;
						Control control = display.getFocusControl();
						if (control == null || (control != searchControl.getFilterControl() && control != popupTable)) {
							popupShell.setVisible(false);
						}
					}
				});
			}
		};
		popupTable.addListener(SWT.FocusOut, focusOutListener);
		searchControl.getFilterControl().addListener(SWT.FocusOut, focusOutListener);

		shell.addListener(SWT.Move, new Listener() {
			@Override
			public void handleEvent(Event event) {
				popupShell.setVisible(false);
			}
		});
		shell.addListener(SWT.Resize, new Listener() {
			@Override
			public void handleEvent(Event event) {
				popupShell.setVisible(false);
			}
		});
	}
	
	private void showAutocomplete() {
		if (autocompleteOff) return;
		
		String search = searchControl.getFilterString();
		if (search.trim().length() == 0) {
			popupShell.setVisible(false);
		} else {
			ArrayList<String> results = getAutocompleteOffers(search);
			if (results.size() > 0) {
				TableItem[] items = popupTable.getItems();
				if (results.size() > items.length) {
					for (int i = items.length; i < results.size(); i++) {
						new TableItem(popupTable, SWT.NONE);
					}
				} else if (results.size() < items.length) {
					for (int i = items.length - 1; i >= results.size(); i--) {
						items[i].dispose();
					}
				}

				for (int i = 0; i < results.size(); i++) {
					popupTable.getItem(i).setText(results.get(i));
				}
				popupTable.deselectAll();

				Rectangle bounds = searchControl.getBounds();
				Point p = searchControl.toDisplay(0, bounds.height);
				popupShell.setBounds(p.x, p.y, bounds.width - 50, 100);
				popupShell.setVisible(true);
			} else {
				popupShell.setVisible(false);
			}
		}
	}
	
	private void selectAutocompleteOffer() {
		if (popupShell.isVisible() && popupTable.getSelectionIndex() != -1) {
			String selected = popupTable.getSelection()[0].getText();
			searchControl.getFilterControl().setText(selected);
			searchControl.getFilterControl().setSelection(selected.length(), selected.length());
		}
		popupShell.setVisible(false);
		
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
	
	@SuppressWarnings("unchecked")
	private ArrayList<String> getAutocompleteOffers(String search) {
		ArrayList<String> results = new ArrayList<String>(0);
		
		Map<String, String> last = getLastSegment(search);
		if (search.endsWith(" ")) {
			if (last.get("operator") == null) { // tagName<space>
				findAllTags(search, "", results, tags);
				results.add(search + OPERATOR_OR);
				results.add(search + OPERATOR_AND);
			} else if (!last.get("segment").trim().isEmpty()) { // ..<or|and|(> tagName<space>
				String prefix = search.substring(0, search.length() - last.get("segment").length());
				findAllTags(last.get("segment"), prefix, results, tags);
				results.add(search + OPERATOR_OR);
				results.add(search + OPERATOR_AND);
			} else { // ..<or|and><space>
				getAllRootTags(search, results, tags);
			}
		} else if (search.endsWith("(") || search.endsWith("!")) { // ..( or ..!
			getAllRootTags(search, results, tags);
		} else {
			if (last.get("operator") == null) { // tagNa..
				findAllTags(search.replaceAll("^\\s+",""), "", results, tags);
			} else if (!last.get("segment").trim().isEmpty()) { // ..<or|and|(> tagNa..
				String prefix = search.substring(0, search.length() - last.get("segment").length());
				findAllTags(last.get("segment").replaceAll("^\\s+",""), prefix, results, tags);
			}
		}
		
		return results;
	}
	
	private static Map<String, String> getLastSegment(String text) {
		Pattern pattern = Pattern.compile(REGEX_LAST_SEGMENT);
		Matcher matcher = pattern.matcher(text);
		Map<String, String> result = new HashMap<String, String>();
		if (matcher.find()) {
			result.put("operator", matcher.group(1));
			result.put("segment", matcher.group(2) == null ? "" : matcher.group(2));
		} else {
			result.put("operator", null);
			result.put("segment", null);
		}
		
		return result;
	}
	
	private void getAllRootTags(String prefix, ArrayList<String> results, List<Tag> tags) {
		if (tags != null) {
			for (Tag tag : tags) {
				if (tag.getPath().matches(REGEX_SPEC_CHARS)) {
					results.add(prefix + "\"" + tag.getPath() + "\"");
				} else {
					results.add(prefix + tag.getPath());
				}
			}
		}
	}
	
	private void findAllTags(String search, String prefix, ArrayList<String> results, List<Tag> tags) {
		if (tags != null) {
			for (Tag tag : tags) {
				if (tag.getPath().toLowerCase().startsWith(search.toLowerCase())) {
					if (tag.getPath().matches(REGEX_SPEC_CHARS)) {
						results.add(prefix + "\"" + tag.getPath() + "\"");
					} else {
						results.add(prefix + tag.getPath());
					}
				}
				findAllTags(search, prefix, results, tag.getTags());
			}
		}
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
			
			autocompleteOff = true;
			searchControl.getFilterControl().setText(StringUtils.join(" " + OPERATOR_OR + " ", tags));
			autocompleteOff = false;
			if (selection.size() == 1) {
				listViewer.setInput(selection.getFirstElement()); // Don't run searching if only one tag is selected
			} else {
				updateList();
			}
		}
	}
	
}

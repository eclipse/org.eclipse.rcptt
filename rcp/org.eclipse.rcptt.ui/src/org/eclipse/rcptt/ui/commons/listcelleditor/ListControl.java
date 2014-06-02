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
package org.eclipse.rcptt.ui.commons.listcelleditor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TreeEditor;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.TraverseEvent;
import org.eclipse.swt.events.TraverseListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

import org.eclipse.rcptt.internal.ui.Messages;

public class ListControl extends Composite {

	private final class AddAdapter extends SelectionAdapter {
		private final FilterEditor filterEditor;

		private AddAdapter(FilterEditor filterEditor) {
			this.filterEditor = filterEditor;
		}

		@Override
		public void widgetSelected(SelectionEvent e) {
			viewer.cancelEditing();
			doAddFilter(filterEditor);
		}
	}

	private final class ChangeAdapter extends SelectionAdapter {
		private final FilterEditor filterEditor;

		private ChangeAdapter(FilterEditor filterEditor) {
			this.filterEditor = filterEditor;
		}

		@Override
		public void widgetSelected(SelectionEvent e) {
			doChange(filterEditor);
		}
	}

	private final class ClearAdapter extends SelectionAdapter {
		@Override
		public void widgetSelected(SelectionEvent e) {
			filterEditor.closeEditor();
			values.clear();
			viewer.refresh();
		}
	}

	private final class DeleteAdapter extends SelectionAdapter {

		@Override
		public void widgetSelected(SelectionEvent e) {
			delete(true);
		}

		public void delete(boolean closeEditor) {
			IStructuredSelection selection = (IStructuredSelection) viewer
					.getSelection();
			Iterator<?> it = selection.iterator();
			while (it.hasNext()) {
				Object elem = it.next();
				values.remove(elem);
			}
			if (closeEditor)
				filterEditor.closeEditor();
			viewer.refresh();
		}
	}

	private final class FilterEditor extends TreeEditor {

		private StringWrapper text;
		private Text valueEditor;

		private FilterEditor(Tree tree) {
			super(tree);
		}

		public void startEditing() {
			Control oldEditor = this.getEditor();
			if (oldEditor != null)
				oldEditor.dispose();

			TreeItem[] selection = tree.getSelection();
			if (selection == null || selection.length < 1)
				return;

			text = (StringWrapper) ((IStructuredSelection) viewer
					.getSelection()).getFirstElement();
			TreeItem item = selection[0];
			if (item == null)
				return;

			valueEditor = new Text(tree, SWT.NONE);
			valueEditor.setText(item.getText());

			valueEditor.addTraverseListener(new TraverseListener() {
				public void keyTraversed(TraverseEvent event) {
					switch (event.detail) {
					case SWT.TRAVERSE_RETURN:
						applyChanges();
						/* fall-through */
					case SWT.TRAVERSE_ESCAPE:
						closeEditor();
						event.doit = true;
						event.detail = SWT.TRAVERSE_NONE;
					}
				}
			});

			valueEditor.addFocusListener(new FocusAdapter() {
				@Override
				public void focusLost(FocusEvent e) {
					applyChanges();
				}
			});

			valueEditor.selectAll();
			valueEditor.setFocus();

			this.setEditor(valueEditor, item);
		}

		private void applyChanges() {
			text.setString(valueEditor.getText());
			viewer.refresh(text);
			viewer.setSelection(new StructuredSelection(text));
		}

		private void closeEditor(boolean changeSelection) {
			this.setEditor(null, null);
			if (valueEditor != null)
				valueEditor.dispose();
			if (text != null && text.getString() != null) {
				if (text.getString().trim().length() == 0) {
					new DeleteAdapter().delete(false);
				} else if (changeSelection)
					viewer.setSelection(new StructuredSelection(text));
				text = null;
			}
		}

		private void closeEditor() {
			closeEditor(true);
		}
	}

	private final Tree tree;

	private final TreeViewer viewer;

	private final List<StringWrapper> values;

	private final boolean readOnly;

	private FilterEditor filterEditor;

	private Composite buttonsComposite;

	/**
	 * Creates a new instance of BCI filters control on a given parent.
	 * 
	 * @param parent
	 * @param style
	 */

	public ListControl(Composite parent, int style) {
		this(parent, style, false, new ArrayList<StringWrapper>());
	}

	public ListControl(Composite parent, int style, boolean createButtons,
			List<StringWrapper> values) {
		super(parent, SWT.NONE);

		readOnly = (style & SWT.READ_ONLY) != 0;

		GridLayout layout = new GridLayout(createButtons ? 2 : 1, false);
		layout.marginWidth = layout.marginHeight = 1;
		this.setLayout(layout);

		tree = new Tree(this, style | SWT.V_SCROLL | SWT.MULTI);
		viewer = new TreeViewer(tree);
		this.values = values;

		viewer.setLabelProvider(new LabelProvider() {

			@Override
			public String getText(Object element) {
				return element.toString();
			}

			@Override
			public Image getImage(Object element) {
				return null;
			}

		});

		viewer.setContentProvider(new ITreeContentProvider() {

			public void inputChanged(Viewer viewer, Object oldInput,
					Object newInput) {
			}

			public void dispose() {
			}

			public Object[] getElements(Object inputElement) {
				if (inputElement instanceof List) {
					List<?> list = (List<?>) inputElement;
					return list.toArray();
				}
				return null;
			}

			public boolean hasChildren(Object element) {
				return element instanceof List;
			}

			public Object getParent(Object element) {
				return null;
			}

			public Object[] getChildren(Object parentElement) {
				return null;
			}

		});
		viewer.setInput(values);
		GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
		gridData.minimumWidth = 150;
		tree.setLayoutData(gridData);
		if (readOnly)
			return;

		Menu menu = new Menu(tree);

		filterEditor = new FilterEditor(tree);
		filterEditor.grabHorizontal = true;

		viewer.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				filterEditor.closeEditor(false);
			}

		});

		viewer.addDoubleClickListener(new IDoubleClickListener() {

			public void doubleClick(DoubleClickEvent event) {
				doChange(filterEditor);
			}

		});

		MenuItem addItem = new MenuItem(menu, SWT.PUSH);
		addItem.setText(Messages.ListControl_Add);
		addItem.addSelectionListener(new AddAdapter(filterEditor));

		final MenuItem changeFilterItem = new MenuItem(menu, SWT.PUSH);
		changeFilterItem.setText(Messages.ListControl_Change);
		changeFilterItem.addSelectionListener(new ChangeAdapter(filterEditor));

		final MenuItem deleteItem = new MenuItem(menu, SWT.PUSH);
		deleteItem.setText(Messages.ListControl_Delete);
		deleteItem.addSelectionListener(new DeleteAdapter());

		deleteItem.setEnabled(false);
		changeFilterItem.setEnabled(false);

		viewer.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {

				IStructuredSelection sel = (IStructuredSelection) event
						.getSelection();
				if (sel.isEmpty()) {
					changeFilterItem.setEnabled(false);
					deleteItem.setEnabled(false);
				} else if (sel.size() > 1) {
					changeFilterItem.setEnabled(false);
					deleteItem.setEnabled(true);
				} else {
					changeFilterItem.setEnabled(true);
					deleteItem.setEnabled(true);
				}

			}

		});
		if (createButtons) {
			buttonsComposite = new Composite(this, SWT.NONE);
			buttonsComposite.setLayoutData(new GridData(SWT.LEFT, SWT.TOP,
					false, true));
			FillLayout fl = new FillLayout(SWT.VERTICAL);
			fl.spacing = 5;
			buttonsComposite.setLayout(fl);
			Button addItemb = new Button(buttonsComposite, SWT.PUSH);
			addItemb.setText(Messages.ListControl_Add);
			addItemb.addSelectionListener(new AddAdapter(filterEditor));

			final Button changeFilterItemb = new Button(buttonsComposite,
					SWT.PUSH);
			changeFilterItemb.setText(Messages.ListControl_Change);
			changeFilterItemb.addSelectionListener(new ChangeAdapter(
					filterEditor));

			final Button deleteItemb = new Button(buttonsComposite, SWT.PUSH);
			deleteItemb.setText(Messages.ListControl_Delete);
			deleteItemb.addSelectionListener(new DeleteAdapter());

			deleteItemb.setEnabled(false);
			changeFilterItemb.setEnabled(false);

			final Button clear = new Button(buttonsComposite, SWT.PUSH);
			clear.setText(Messages.ListControl_Clear);
			clear.addSelectionListener(new ClearAdapter());
			clear.setEnabled(true);

			viewer.addSelectionChangedListener(new ISelectionChangedListener() {

				public void selectionChanged(SelectionChangedEvent event) {

					IStructuredSelection sel = (IStructuredSelection) event
							.getSelection();
					if (sel.isEmpty()) {
						changeFilterItemb.setEnabled(false);
						deleteItemb.setEnabled(false);
					} else if (sel.size() > 1) {
						changeFilterItemb.setEnabled(false);
						deleteItemb.setEnabled(true);
					} else {
						changeFilterItemb.setEnabled(true);
						deleteItemb.setEnabled(true);
					}

				}

			});
		}
		tree.setMenu(menu);
	}

	public List<StringWrapper> getValues() {
		return values;
	}

	@Override
	public void update() {
		viewer.setSelection(new StructuredSelection(Collections.EMPTY_LIST));
		viewer.refresh(true);
	}

	private void doAddFilter(final FilterEditor filterEditor) {
		StringWrapper value = new StringWrapper();
		values.add(value);
		viewer.refresh();

		viewer.setSelection(new StructuredSelection(value));
		filterEditor.startEditing();
	}

	private void doChange(final FilterEditor filterEditor) {
		filterEditor.startEditing();
	}

	@Override
	public void setEnabled(boolean enabled) {
		super.setEnabled(enabled);
		Control[] childs = buttonsComposite.getChildren();
		for (int i = 0; i < childs.length; i++) {
			childs[i].setEnabled(enabled);
		}
		// buttonsComposite.setEnabled(enabled);

	}
}

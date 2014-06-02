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
package org.eclipse.rcptt.ecl.popup.ui.internal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.rcptt.ecl.popup.EclPopupSession.EclResult;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

class ResultRow extends DialogRow {

	public ResultRow(Composite parent, String title) {
		super(parent, title);
	}

	private TreeViewer viewer;
	private Tree control;

	public void setResults(EclResult[] results) {
		viewer.setInput(results);
		if (results.length == 1) {
			viewer.expandToLevel(2);
		}
	}

	@Override
	protected Control createContent() {
		viewer = new TreeViewer(this, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		control = viewer.getTree();
		viewer.setContentProvider(new ResultContentProvider());
		control.addKeyListener(new KeyListener() {

			public void keyReleased(KeyEvent e) {
			}

			public void keyPressed(KeyEvent e) {
				switch (e.keyCode) {
				case SWT.ARROW_DOWN:
					if (control.getSelectionCount() != 1) {
						return;
					}

					if (isLast(control.getSelection()[0])) {
						focusReceiver.receiveBottomFocus();
						return;
					}
					break;
				case SWT.ARROW_UP:
					if (control.getSelectionCount() != 1) {
						return;
					}
					if (isFirst(control.getSelection()[0])) {
						focusReceiver.receiveTopFocus();
					}
					break;
				case SWT.CR:
				case SWT.KEYPAD_CR:
					if (control.getSelectionCount() == 0) {
						return;
					}
					if (control.getSelection()[0].getParentItem() != null) {
						return;
					}
					ResultEntry entry = (ResultEntry) control.getSelection()[0]
							.getData();
					commandReceiver.commandSelected(entry.value.command);
					break;
				}
			}
		});
		return control;
	}

	/**
	 * True when this is a root tree item and it is the first
	 * 
	 * @param item
	 * @return
	 */
	private static boolean isFirst(TreeItem item) {
		if (item.getParentItem() != null) {
			return false;
		}

		return getSiblings(item)[0] == item;
	}

	private static boolean isLast(TreeItem item) {
		return isLast(item, true);
	}

	/**
	 * Returns true when there's no tree item below this one
	 * 
	 * @param item
	 * @return
	 */
	private static boolean isLast(TreeItem item, boolean checkExpansion) {
		TreeItem[] siblings = getSiblings(item);
		if (siblings[siblings.length - 1] != item) {
			return false;
		}

		if (checkExpansion && item.getExpanded() && item.getItemCount() > 0) {
			return false;
		}
		TreeItem parent = item.getParentItem();
		if (parent == null) {
			return true;
		}

		return isLast(parent, false);

	}

	private static TreeItem getLast(TreeItem item) {
		if (!item.getExpanded()) {
			return item;
		}

		TreeItem[] children = item.getItems();
		return getLast(children[children.length - 1]);
	}

	private static TreeItem[] getSiblings(TreeItem item) {
		return item.getParentItem() == null ? item.getParent().getItems()
				: item.getParentItem().getItems();
	}

	public void receiveTopFocus() {
		if (control.getItemCount() == 0) {
			focusReceiver.receiveBottomFocus();
			return;
		}

		control.setSelection(control.getItem(0));
		control.forceFocus();
	}

	@Override
	public void receiveBottomFocus() {
		if (control.getItemCount() == 0) {
			focusReceiver.receiveTopFocus();
			return;
		}

		control.setSelection(getLast(control.getItem(control.getItemCount() - 1)));
		control.forceFocus();
	}

	private static class ResultContentProvider implements ITreeContentProvider {

		public void dispose() {
			// do nothing
		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			// do nothing
		}

		public Object[] getElements(Object inputElement) {
			if (inputElement instanceof EclResult[]) {
				EclResult[] results = (EclResult[]) inputElement;
				Object[] elements = new Object[results.length];
				for (int i = 0; i < results.length; i++) {
					elements[i] = new ResultEntry(results[i]);
				}
				return elements;
			}
			return null;
		}

		public Object[] getChildren(Object parent) {
			if (parent instanceof Entry) {
				return ((Entry) parent).getChildren();
			}

			return new Object[0];
		}

		public Object getParent(Object element) {
			if (element instanceof Entry) {
				return ((Entry) element).parent;
			}
			return null;
		}

		public boolean hasChildren(Object element) {
			if (element instanceof Entry) {
				return ((Entry) element).getChildren().length > 0;
			}
			return false;
		}

	}

	private static final Map<Integer, String> severities = new HashMap<Integer, String>();
	static {
		severities.put(IStatus.CANCEL, "CANCEL");
		severities.put(IStatus.ERROR, "ERROR");
		severities.put(IStatus.INFO, "INFO");
		severities.put(IStatus.OK, "OK");
		severities.put(IStatus.WARNING, "WARNING");
	}

	private static abstract class Entry {
		public Entry(Object parent, String name) {
			this.parent = parent;
			this.name = name;
		}

		public final Object parent;
		public final String name;

		public abstract Object[] getChildren();
	}

	private static class ResultEntry extends Entry {
		public final EclResult value;

		public ResultEntry(EclResult result) {
			super(null, result.command);
			this.value = result;
		}

		@Override
		public Object[] getChildren() {
			return new Object[] {
					new StatusEntry(this, "status", value.status),
					new ArrayEntry(this, "pipe", value.pipe) };
		}

		@Override
		public String toString() {
			return String.format("%s %s", name,
					severities.get(value.status.getSeverity()));
		}
	}

	private static class StatusEntry extends Entry {
		public StatusEntry(Object parent, String name, IStatus status) {
			super(parent, name);
			this.status = status;
		}

		public final IStatus status;

		@Override
		public Object[] getChildren() {
			List<Object> result = new ArrayList<Object>();
			result.add(new SimpleEntry(this, "severity", severities.get(status
					.getSeverity())));
			result.add(new SimpleEntry(this, "message", status.getMessage()));
			result.add(new SimpleEntry(this, "pluginId", status.getPlugin()));
			result.add(new SimpleEntry(this, "code", Integer.toString(status
					.getCode())));
			if (status.getException() != null) {
				result.add(new ExceptionEntry(this, "exception", status
						.getException()));
			}
			if (status.getChildren() != null && status.getChildren().length > 0) {
				result.add(new ArrayEntry(this, name, status.getChildren()));
			}
			return result.toArray();
		}

		@Override
		public String toString() {
			return String.format("%s %s", name,
					severities.get(status.getSeverity()));
		}
	}

	private static class ArrayEntry extends Entry {
		public ArrayEntry(Object parent, String name, Object[] children) {
			super(parent, name);
			this.children = children;
		}

		public final Object[] children;

		@Override
		public Object[] getChildren() {
			List<Object> result = new ArrayList<Object>();
			for (int i = 0; i < children.length; i++) {
				Object child = children[i];
				String name = String.format("[%d]", i);
				if (child instanceof Throwable) {
					result.add(new ExceptionEntry(this, name, (Throwable) child));
				} else if (child instanceof IStatus) {
					result.add(new StatusEntry(this, name, (IStatus) child));
				} else if (child instanceof EObject) {
					result.add(new EObjectEntry(this, name, (EObject) child));
				} else {
					result.add(new SimpleEntry(this, name, child));
				}

			}
			return result.toArray();
		}

		@Override
		public String toString() {
			return name;
		}
	}

	private static class EObjectEntry extends Entry {
		public EObjectEntry(Object parent, String name, EObject value) {
			super(parent, name);
			this.value = value;
		}

		public final EObject value;

		@Override
		public Object[] getChildren() {
			List<Object> result = new ArrayList<Object>();
			for (EStructuralFeature feature : value.eClass()
					.getEAllStructuralFeatures()) {
				if (feature.isTransient()) {
					continue;
				}

				Object val = value.eGet(feature);
				if (val == null) {
					result.add(new SimpleEntry(this, feature.getName(), "null"));
					continue;
				}
				if (feature.isMany()) {
					List<?> list = (List<?>) value;
					result.add(new ArrayEntry(this, feature.getName(), list
							.toArray()));
				} else {
					if (feature instanceof EAttribute) {
						result.add(new SimpleEntry(this, feature.getName(), val));
					} else if (feature instanceof EReference
							&& val instanceof EObject) {
						result.add(new EObjectEntry(this, feature.getName(),
								(EObject) val));
					}
				}
			}
			return result.toArray();
		}

		@Override
		public String toString() {
			return String.format("%s %s", name, value.eClass().getName());
		}
	}

	private static class ExceptionEntry extends Entry {
		public ExceptionEntry(Object parent, String name, Throwable value) {
			super(parent, name);
			this.value = value;
		}

		public final Throwable value;

		@Override
		public Object[] getChildren() {
			List<Object> result = new ArrayList<Object>();
			result.add(new SimpleEntry(this, "class", value.getClass()
					.getName()));
			result.add(new SimpleEntry(this, "message", value.getMessage()));
			if (value.getCause() != null) {
				result.add(new ExceptionEntry(this, "cause", value.getCause()));
			}
			return result.toArray();
		}

	}

	private static class SimpleEntry extends Entry {
		public SimpleEntry(Object parent, String name, Object value) {
			super(parent, name);
			this.value = value;
		}

		public final Object value;

		@Override
		public Object[] getChildren() {
			return new Object[0];
		}

		@Override
		public String toString() {
			return String.format("%s = %s", name, value);
		}
	}
}
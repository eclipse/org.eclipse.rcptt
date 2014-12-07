package org.eclipse.rcptt.ui.controls;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.ToolBar;

public class EmbeddedTabFolder extends CTabFolder {

	public static class TabItem extends CTabItem {
		public TabItem(EmbeddedTabFolder parent, int style, IEmbeddedComposite part) {
			super(parent, style);
			boolean first = parent.getItemCount() == 1;
			setData(part);
			setText(part.getName());
			setImage(part.getImage());
			part.createControl(parent);
			setControl(part.getControl());
			part.createToolBar(parent);
			ToolBar toolBar = part.getToolBar();
			if (toolBar != null) {
				toolBar.setVisible(false);
			}
			if (first)
				parent.handleTabSelection(this);
		}

		@Override
		public IEmbeddedComposite getData() {
			return (IEmbeddedComposite) super.getData();
		}
	}

	public EmbeddedTabFolder(Composite parent, int style) {
		super(parent, style);
	}

	@Override
	public TabItem getItem(int index) {
		return (TabItem) super.getItem(index);
	}

	public TabItem addTab(IEmbeddedComposite part) {
		TabItem item = new TabItem(this, SWT.NONE, part);
		return item;
	}

	private void handleTabSelection(TabItem tab) {
		IEmbeddedComposite part = (IEmbeddedComposite) tab.getData();
		Control last = getTopRight();
		if (last != null)
			last.setVisible(false);
		ToolBar toolBar = part.getToolBar();
		setTopRight(null);
		if (toolBar != null) {
			toolBar.setVisible(true);
			setTopRight(toolBar);
		}
	}

	{
		addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				handleTabSelection((TabItem) e.item);
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				handleTabSelection((TabItem) e.item);
			}
		});

	}

}

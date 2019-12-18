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
package org.eclipse.rcptt.tesla.internal.ui.player;

import java.util.ArrayList;

import org.eclipse.jface.fieldassist.ControlDecoration;
import org.eclipse.osgi.util.NLS;
import org.eclipse.rcptt.logging.IQ7ActivityLogs;
import org.eclipse.rcptt.logging.Q7LoggingManager;
import org.eclipse.rcptt.tesla.core.TeslaFeatures;
import org.eclipse.rcptt.tesla.core.protocol.ElementKind;
import org.eclipse.rcptt.tesla.core.protocol.GenericElementKind;
import org.eclipse.rcptt.tesla.core.protocol.UIColor;
import org.eclipse.rcptt.tesla.internal.ui.IBasicMappingNode;
import org.eclipse.rcptt.tesla.internal.ui.player.viewers.Viewers;
import org.eclipse.rcptt.tesla.jface.rap.ControlDecoratorRecordingHolder;
import org.eclipse.rcptt.tesla.swt.rap.TeslaSWTMessages;
import org.eclipse.rcptt.tesla.ui.RWTUtils;
import org.eclipse.rcptt.util.swt.rap.TableTreeUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.IWorkbench;

/**
 * Instances of this class are used mainly as convenience wraps for SWT widgets
 * (and not only widgets, but UI elements of other kinds as well) to do some
 * actions on them by SWTUIPlayer.
 * <p>
 * The wrapping layer also serves as an unification of various kinds of UI
 * elements.
 *
 * @see SWTUIPlayer#wrap(Object)
 */
public class SWTUIElement implements IBasicMappingNode {
	public final Widget widget;
	protected final SWTUIPlayer swtPlayer;

	private GenericElementKind kindOverride = null;

	/**
	 * This method can be used when we want to treat the UI element like an
	 * element of more general kind (like a Nebula Grid as a Canvas) and perform
	 * actions of that kind on it.
	 */
	public void overrideKind(GenericElementKind kind) {
		kindOverride = kind;
	}

	public SWTUIElement(Widget w, SWTUIPlayer p) {
		widget = w;
		this.swtPlayer = p;
	}

	public String getGenerationKind() {
		return getKind().name();
	}

	public GenericElementKind getKind() {
		if (kindOverride != null)
			return kindOverride;
		else
			return SWTUIPlayer.getKind(widget);
	}

	public boolean isSuitableForKind(GenericElementKind kind) {

		if (getKind().is(ElementKind.PropertyTab) && kind.is(ElementKind.Canvas))
			return true;

		return getKind().is(kind);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((widget == null) ? 0 : widget.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SWTUIElement other = (SWTUIElement) obj;
		if (widget == null) {
			if (other.widget != null)
				return false;
		} else if (!widget.equals(other.widget))
			return false;
		return true;
	}

	public boolean match(Object c) {
		return widget != null && widget.equals(c);
	}

	@Override
	public String toString() {
		if (widget != null && widget.isDisposed()) {
			return NLS.bind(TeslaSWTMessages.SWTUIElement_ControlDisposed,
					widget.getClass().getSimpleName());
		}
		return widget == null ? TeslaSWTMessages.SWTUIElement_ControlNull
				: widget.getClass().getSimpleName() + ":" + getText();
	}

	public String getClassName() {
		return widget == null ? "null" : widget.getClass().getName();
	}

	public void setText(String text) {
		swtPlayer.setText(this, text);
	}

	public int countItems(String[] selection) {
		return swtPlayer.countItems(this, selection);
	}

	public String getText() {
		return PlayerTextUtils.getText(this);
	}

	public String getModificationText() {
		return PlayerTextUtils.replaceMultilinesNoTrim(PlayerTextUtils.getRawText(this));
	}

	public void setBackgroundColor(UIColor color) {
		swtPlayer.setBackgroundColor(this, color);
	}

	public void setBackgroundColor(int color) {
		swtPlayer.setBackgroundColor(this, color);
	}

	public UIColor getBackgroundColor() {
		return swtPlayer.getBackgroundColor(this);
	}

	public boolean isWindow() {
		return getKind().is(ElementKind.Window);
	}

	public boolean isView() {
		return getKind().is(ElementKind.View);
	}

	public boolean isTree() {
		return getKind().is(ElementKind.Tree);
	}

	public boolean isTable() {
		return getKind().is(ElementKind.Table);
	}

	public boolean isList() {
		return getKind().is(ElementKind.List);
	}

	public boolean isButton() {
		return getKind().is(ElementKind.Button);
	}

	public boolean isText() {
		return getKind().is(ElementKind.Text);
	}

	public void click() {
		swtPlayer.click(this);
	}

	// Click and wait for context to be same if it is changed.
	public void clickAndWait() {
		swtPlayer.clickAndWait(this);
	}

	public boolean isDisposed() {
		return swtPlayer.isDisposed(this);
	}

	public void show() {
		swtPlayer.show(this, -1, -1);
	}

	/**
	 * Such selection kind are valid mostly for trees
	 */
	public boolean setSelection(java.util.List<String[]> selection,
			boolean selectAll) {
		return Viewers.setSelection(this, selection, selectAll);
	}

	public boolean setSelection(String[] selection, String pattern,
			Integer index, boolean selectAll) {
		return Viewers.setSelection(this, selection, pattern, index, selectAll);
	}

	public int expandSelection(String[] selection, String pattern, Integer index) {
		return Viewers.expandSelection(this, selection, pattern, index);
	}

	public void close() {
		swtPlayer.close(this);
	}

	public boolean isDisabled() {
		return PlayerWidgetUtils.isDisabled(this);
	}

	public String[] getPathSelection() {
		return Viewers.getPathSelection(this);
	}

	public SWTUIPlayer getPlayer() {
		return swtPlayer;
	}

	public String getSelectedTab() {
		return swtPlayer.getSelectedTabItem(this);
	}

	public boolean isSupportMultipleSelections() {
		if (widget instanceof Tree || widget instanceof Table
				|| widget instanceof List) {
			int style = widget.getStyle();
			return (style & SWT.MULTI) != 0;
		}
		return false;
	}

	public String[][] getMultiPathSelection() {
		return Viewers.getMultiPathSelection(this);
	}

	public org.eclipse.rcptt.tesla.core.ui.Widget getModel() {
		if (TeslaFeatures.isActivityLogging()) {
			Q7LoggingManager.logMessage(IQ7ActivityLogs.PROPERTIES,
					"begin property mapping for: " + getClassName());
		}
		return SWTModelMapper.map(this);
	}

	public Widget unwrap() {
		return PlayerWrapUtils.unwrapWidget(this);
	}

	public boolean isWorkbenchWindow() {
		IWorkbench workbench = RWTUtils.getWorkbench();
		if (getKind().is(ElementKind.Window) && workbench != null) {
			return workbench.getActiveWorkbenchWindow()
					.getShell().equals(widget);
		}
		return false;
	}

	public Rectangle getBounds() {
		if (widget.isDisposed()) {
			return new Rectangle(0, 0, 0, 0);
		}

		if (widget instanceof Control) {
			Rectangle bounds = ((Control) widget).getBounds();
			if (((Control) widget).getParent() != null) {
				Point point = ((Control) widget).toDisplay(bounds.x, bounds.y);
				bounds.x = point.x;
				bounds.y = point.y;
			}
			return bounds;
		}

		if ((widget instanceof TreeItem) || (widget instanceof TableItem)) {
			return TableTreeUtil.getItemBounds(widget);
		}
		return new Rectangle(0, 0, 0, 0);
	}

	public java.util.List<ControlDecoration> getDecorators() {
		java.util.List<ControlDecoration> result = new ArrayList<ControlDecoration>();

		if (widget instanceof Control) {
			result = ControlDecoratorRecordingHolder.getDecorators((Control) widget);
		}

		return result;
	}

}

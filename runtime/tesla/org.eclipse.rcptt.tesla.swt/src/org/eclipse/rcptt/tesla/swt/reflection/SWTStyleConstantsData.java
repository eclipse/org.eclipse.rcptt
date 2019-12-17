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
package org.eclipse.rcptt.tesla.swt.reflection;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.CoolBar;
import org.eclipse.swt.widgets.CoolItem;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Decorations;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.Sash;
import org.eclipse.swt.widgets.Scale;
import org.eclipse.swt.widgets.ScrollBar;
import org.eclipse.swt.widgets.Scrollable;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Slider;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.ToolTip;
import org.eclipse.swt.widgets.Tracker;
import org.eclipse.swt.widgets.Tree;

public class SWTStyleConstantsData {

	public static class StyleConstant {
		private final String name;
		private final int value;
		private final List<Class<?>> applyedTo = new ArrayList<Class<?>>();

		StyleConstant(String name, int value) {
			this.name = name;
			this.value = value;
		}

		public String getName() {
			return name;
		}

		public int getValue() {
			return value;
		}

		public List<Class<?>> getApplyedTo() {
			return applyedTo;
		}
	}

	public static List<StyleConstant> styleConstants = new ArrayList<StyleConstant>();

	static {
		StyleConstant styleConst = new StyleConstant("BAR", 1 << 1);
		styleConst.getApplyedTo().add(Menu.class);
		styleConstants.add(styleConst);

		styleConst = new StyleConstant("DROP_DOWN", 1 << 2);
		styleConst.getApplyedTo().add(Menu.class);
		styleConst.getApplyedTo().add(ToolItem.class);
		styleConst.getApplyedTo().add(CoolItem.class);
		styleConst.getApplyedTo().add(Combo.class);
		styleConst.getApplyedTo().add(DateTime.class);
		styleConstants.add(styleConst);

		styleConst = new StyleConstant("POP_UP", 1 << 3);
		styleConst.getApplyedTo().add(Menu.class);
		styleConstants.add(styleConst);

		styleConst = new StyleConstant("SEPARATOR", 1 << 1);
		styleConst.getApplyedTo().add(Label.class);
		styleConst.getApplyedTo().add(MenuItem.class);
		styleConst.getApplyedTo().add(ToolItem.class);
		styleConstants.add(styleConst);

		styleConst = new StyleConstant("TOGGLE", 1 << 1);
		styleConst.getApplyedTo().add(Button.class);
		styleConstants.add(styleConst);

		styleConst = new StyleConstant("ARROW", 1 << 2);
		styleConst.getApplyedTo().add(Button.class);
		styleConstants.add(styleConst);

		styleConst = new StyleConstant("PUSH", 1 << 3);
		styleConst.getApplyedTo().add(Button.class);
		styleConst.getApplyedTo().add(MenuItem.class);
		styleConst.getApplyedTo().add(ToolItem.class);
		styleConstants.add(styleConst);

		styleConst = new StyleConstant("RADIO", 1 << 4);
		styleConst.getApplyedTo().add(Button.class);
		styleConst.getApplyedTo().add(MenuItem.class);
		styleConst.getApplyedTo().add(ToolItem.class);
		styleConstants.add(styleConst);

		styleConst = new StyleConstant("CHECK", 1 << 5);
		styleConst.getApplyedTo().add(Button.class);
		styleConst.getApplyedTo().add(MenuItem.class);
		styleConst.getApplyedTo().add(ToolItem.class);
		styleConst.getApplyedTo().add(Table.class);
		styleConst.getApplyedTo().add(Tree.class);
		styleConstants.add(styleConst);

		styleConst = new StyleConstant("CASCADE", 1 << 6);
		styleConst.getApplyedTo().add(MenuItem.class);
		styleConstants.add(styleConst);

		styleConst = new StyleConstant("MULTI", 1 << 1);
		styleConst.getApplyedTo().add(Text.class);
		styleConst.getApplyedTo().add(org.eclipse.swt.widgets.List.class);
		styleConst.getApplyedTo().add(Table.class);
		styleConst.getApplyedTo().add(Tree.class);
		styleConst.getApplyedTo().add(FileDialog.class);
		styleConst.getApplyedTo().add(StyledText.class); // Not described in SWT
		styleConstants.add(styleConst);

		styleConst = new StyleConstant("SINGLE", 1 << 2);
		styleConst.getApplyedTo().add(Text.class);
		styleConst.getApplyedTo().add(org.eclipse.swt.widgets.List.class);
		styleConst.getApplyedTo().add(Table.class);
		styleConst.getApplyedTo().add(Tree.class);
		styleConst.getApplyedTo().add(StyledText.class); // Not described in SWT
		styleConstants.add(styleConst);

		styleConst = new StyleConstant("READ_ONLY", 1 << 3);
		styleConst.getApplyedTo().add(StyledText.class);
		styleConst.getApplyedTo().add(Combo.class);
		styleConst.getApplyedTo().add(Text.class);
		styleConstants.add(styleConst);

		styleConst = new StyleConstant("WRAP", 1 << 6);
		styleConst.getApplyedTo().add(StyledText.class);
		styleConst.getApplyedTo().add(Button.class);
		styleConst.getApplyedTo().add(Label.class);
		styleConst.getApplyedTo().add(Text.class);
		styleConst.getApplyedTo().add(ToolBar.class);
		styleConst.getApplyedTo().add(Spinner.class);
		styleConstants.add(styleConst);

		styleConst = new StyleConstant("SEARCH", 1 << 7);
		styleConst.getApplyedTo().add(Text.class);
		styleConstants.add(styleConst);

		styleConst = new StyleConstant("SIMPLE", 1 << 6);
		styleConst.getApplyedTo().add(Combo.class);
		styleConstants.add(styleConst);

		styleConst = new StyleConstant("PASSWORD", 1 << 22);
		styleConst.getApplyedTo().add(Text.class);
		styleConstants.add(styleConst);

		styleConst = new StyleConstant("SHADOW_IN", 1 << 2);
		styleConst.getApplyedTo().add(Label.class);
		styleConst.getApplyedTo().add(Group.class);
		styleConstants.add(styleConst);

		styleConst = new StyleConstant("SHADOW_OUT", 1 << 3);
		styleConst.getApplyedTo().add(Label.class);
		styleConst.getApplyedTo().add(Group.class);
		styleConst.getApplyedTo().add(ToolBar.class);
		styleConstants.add(styleConst);

		styleConst = new StyleConstant("SHADOW_ETCHED_IN", 1 << 4);
		styleConst.getApplyedTo().add(Group.class);
		styleConstants.add(styleConst);

		styleConst = new StyleConstant("SHADOW_ETCHED_OUT", 1 << 6);
		styleConst.getApplyedTo().add(Group.class);
		styleConstants.add(styleConst);

		styleConst = new StyleConstant("SHADOW_NONE", 1 << 5);
		styleConst.getApplyedTo().add(Label.class);
		styleConst.getApplyedTo().add(Group.class);
		styleConstants.add(styleConst);

		styleConst = new StyleConstant("INDETERMINATE", 1 << 1);
		styleConst.getApplyedTo().add(ProgressBar.class);
		styleConstants.add(styleConst);

		styleConst = new StyleConstant("TOOL", 1 << 2);
		styleConst.getApplyedTo().add(Decorations.class);
		styleConstants.add(styleConst);

		styleConst = new StyleConstant("NO_TRIM", 1 << 3);
		styleConst.getApplyedTo().add(Decorations.class);
		styleConstants.add(styleConst);

		styleConst = new StyleConstant("RESIZE", 1 << 4);
		styleConst.getApplyedTo().add(Decorations.class);
		styleConst.getApplyedTo().add(Tracker.class);
		styleConstants.add(styleConst);

		styleConst = new StyleConstant("TITLE", 1 << 5);
		styleConst.getApplyedTo().add(Decorations.class);
		styleConstants.add(styleConst);

		styleConst = new StyleConstant("CLOSE", 1 << 6);
		styleConst.getApplyedTo().add(Decorations.class);
		styleConstants.add(styleConst);

		styleConst = new StyleConstant("MIN", 1 << 7);
		styleConst.getApplyedTo().add(Decorations.class);
		styleConstants.add(styleConst);

		styleConst = new StyleConstant("MAX", 1 << 10);
		styleConst.getApplyedTo().add(Decorations.class);
		styleConstants.add(styleConst);

		styleConst = new StyleConstant("H_SCROLL", 1 << 8);
		styleConst.getApplyedTo().add(Scrollable.class);
		styleConstants.add(styleConst);

		styleConst = new StyleConstant("V_SCROLL", 1 << 9);
		styleConst.getApplyedTo().add(Scrollable.class);
		styleConstants.add(styleConst);

		styleConst = new StyleConstant("NO_SCROLL", 1 << 4);
		styleConst.getApplyedTo().add(Tree.class);
		styleConst.getApplyedTo().add(Table.class);
		styleConstants.add(styleConst);

		styleConst = new StyleConstant("BORDER", 1 << 11);
		styleConst.getApplyedTo().add(Control.class);
		styleConstants.add(styleConst);

		styleConst = new StyleConstant("CLIP_CHILDREN", 1 << 12);
		styleConst.getApplyedTo().add(Control.class);
		styleConstants.add(styleConst);

		styleConst = new StyleConstant("CLIP_SIBLINGS", 1 << 13);
		styleConst.getApplyedTo().add(Control.class);
		styleConstants.add(styleConst);

		styleConst = new StyleConstant("ON_TOP", 1 << 14);
		styleConst.getApplyedTo().add(Shell.class);
		styleConstants.add(styleConst);

		styleConst = new StyleConstant("SHEET", 1 << 28);
		styleConst.getApplyedTo().add(Dialog.class);
		styleConst.getApplyedTo().add(Shell.class);
		styleConstants.add(styleConst);

		styleConst = new StyleConstant("MODELESS", 0);
		styleConst.getApplyedTo().add(Dialog.class);
		styleConst.getApplyedTo().add(Shell.class);
		styleConstants.add(styleConst);

		styleConst = new StyleConstant("PRIMARY_MODAL", 1 << 15);
		styleConst.getApplyedTo().add(Dialog.class);
		styleConst.getApplyedTo().add(Shell.class);
		styleConstants.add(styleConst);

		styleConst = new StyleConstant("APPLICATION_MODAL", 1 << 16);
		styleConst.getApplyedTo().add(Dialog.class);
		styleConst.getApplyedTo().add(Shell.class);
		styleConstants.add(styleConst);

		styleConst = new StyleConstant("SYSTEM_MODAL", 1 << 17);
		styleConst.getApplyedTo().add(Dialog.class);
		styleConst.getApplyedTo().add(Shell.class);
		styleConstants.add(styleConst);

		styleConst = new StyleConstant("HIDE_SELECTION", 1 << 15);
		styleConst.getApplyedTo().add(Table.class);
		styleConstants.add(styleConst);

		styleConst = new StyleConstant("FULL_SELECTION", 1 << 16);
		styleConst.getApplyedTo().add(Table.class);
		styleConst.getApplyedTo().add(Tree.class);
		styleConst.getApplyedTo().add(StyledText.class);
		styleConstants.add(styleConst);

		styleConst = new StyleConstant("FLAT", 1 << 23);
		styleConst.getApplyedTo().add(Button.class);
		styleConst.getApplyedTo().add(ToolBar.class);
		styleConstants.add(styleConst);

		styleConst = new StyleConstant("SMOOTH", 1 << 16);
		styleConst.getApplyedTo().add(ProgressBar.class);
		styleConst.getApplyedTo().add(Sash.class);
		styleConstants.add(styleConst);

		styleConst = new StyleConstant("NO_BACKGROUND", 1 << 18);
		styleConst.getApplyedTo().add(Composite.class);
		styleConstants.add(styleConst);

		styleConst = new StyleConstant("NO_FOCUS", 1 << 19);
		styleConst.getApplyedTo().add(Composite.class);
		styleConst.getApplyedTo().add(Label.class); // not described in SWT
		styleConstants.add(styleConst);

		styleConst = new StyleConstant("NO_REDRAW_RESIZE", 1 << 20);
		styleConst.getApplyedTo().add(Composite.class);
		styleConstants.add(styleConst);

		styleConst = new StyleConstant("NO_MERGE_PAINTS", 1 << 21);
		styleConst.getApplyedTo().add(Composite.class);
		styleConstants.add(styleConst);

		styleConst = new StyleConstant("NO_RADIO_GROUP", 1 << 22);
		styleConst.getApplyedTo().add(Composite.class);
		styleConst.getApplyedTo().add(Menu.class);
		styleConstants.add(styleConst);

		styleConst = new StyleConstant("LEFT_TO_RIGHT", 1 << 25);
		styleConst.getApplyedTo().add(Control.class);
		styleConst.getApplyedTo().add(Menu.class);
		styleConstants.add(styleConst);

		styleConst = new StyleConstant("RIGHT_TO_LEFT", 1 << 26);
		styleConst.getApplyedTo().add(Control.class);
		styleConst.getApplyedTo().add(Menu.class);
		styleConstants.add(styleConst);

		styleConst = new StyleConstant("MIRRORED", 1 << 27);
		styleConst.getApplyedTo().add(Control.class);
		styleConst.getApplyedTo().add(Menu.class);
		styleConstants.add(styleConst);

		styleConst = new StyleConstant("EMBEDDED", 1 << 24);
		styleConst.getApplyedTo().add(Composite.class);
		styleConstants.add(styleConst);

		styleConst = new StyleConstant("VIRTUAL", 1 << 28);
		styleConst.getApplyedTo().add(Table.class);
		styleConst.getApplyedTo().add(Tree.class);
		styleConstants.add(styleConst);

		styleConst = new StyleConstant("DOUBLE_BUFFERED", 1 << 29);
		styleConst.getApplyedTo().add(Control.class);
		styleConstants.add(styleConst);

		styleConst = new StyleConstant("TRANSPARENT", 1 << 30);
		styleConst.getApplyedTo().add(Composite.class);
		styleConstants.add(styleConst);

		styleConst = new StyleConstant("UP", 1 << 7);
		styleConst.getApplyedTo().add(Button.class);
		styleConst.getApplyedTo().add(Tracker.class);
		styleConst.getApplyedTo().add(Table.class);
		styleConst.getApplyedTo().add(Tree.class);
		styleConstants.add(styleConst);

		styleConst = new StyleConstant("TOP", 1 << 7);
		styleConst.getApplyedTo().add(Label.class); // Not described in SWT
		styleConstants.add(styleConst);

		styleConst = new StyleConstant("DOWN", 1 << 10);
		styleConst.getApplyedTo().add(Button.class);
		styleConst.getApplyedTo().add(Tracker.class);
		styleConst.getApplyedTo().add(Table.class);
		styleConst.getApplyedTo().add(Tree.class);
		styleConstants.add(styleConst);

		styleConst = new StyleConstant("BOTTOM", 1 << 10);
		styleConst.getApplyedTo().add(TabFolder.class);
		styleConst.getApplyedTo().add(Label.class); // Not described in SWT
		styleConstants.add(styleConst);

		styleConst = new StyleConstant("LEAD", 1 << 14);
		styleConst.getApplyedTo().add(Button.class);
		styleConst.getApplyedTo().add(Label.class);
		styleConst.getApplyedTo().add(TableColumn.class);
		styleConst.getApplyedTo().add(Tracker.class);
		styleConstants.add(styleConst);

		styleConst = new StyleConstant("TRAIL", 1 << 17);
		styleConst.getApplyedTo().add(Button.class);
		styleConst.getApplyedTo().add(Label.class);
		styleConst.getApplyedTo().add(TableColumn.class);
		styleConst.getApplyedTo().add(Tracker.class);
		styleConstants.add(styleConst);

		styleConst = new StyleConstant("LEFT", 1 << 14);
		styleConst.getApplyedTo().add(Text.class);
		styleConstants.add(styleConst);
		
		styleConst = new StyleConstant("RIGHT", 1 << 17);
		styleConst.getApplyedTo().add(ToolBar.class); // Not described in SWT
		styleConst.getApplyedTo().add(Text.class);
		styleConstants.add(styleConst);

		styleConst = new StyleConstant("CENTER", 1 << 24);
		styleConst.getApplyedTo().add(Text.class);
		styleConst.getApplyedTo().add(Button.class);
		styleConst.getApplyedTo().add(Label.class);
		styleConst.getApplyedTo().add(TableColumn.class);
		styleConstants.add(styleConst);

		styleConst = new StyleConstant("HORIZONTAL", 1 << 8);
		styleConst.getApplyedTo().add(Label.class);
		styleConst.getApplyedTo().add(ProgressBar.class);
		styleConst.getApplyedTo().add(Sash.class);
		styleConst.getApplyedTo().add(Scale.class);
		styleConst.getApplyedTo().add(ScrollBar.class);
		styleConst.getApplyedTo().add(Slider.class);
		styleConst.getApplyedTo().add(ToolBar.class);
		styleConst.getApplyedTo().add(CoolBar.class);
		styleConstants.add(styleConst);

		styleConst = new StyleConstant("VERTICAL", 1 << 9);
		styleConst.getApplyedTo().add(Label.class);
		styleConst.getApplyedTo().add(ProgressBar.class);
		styleConst.getApplyedTo().add(Sash.class);
		styleConst.getApplyedTo().add(Scale.class);
		styleConst.getApplyedTo().add(ScrollBar.class);
		styleConst.getApplyedTo().add(Slider.class);
		styleConst.getApplyedTo().add(ToolBar.class);
		styleConst.getApplyedTo().add(CoolBar.class);
		styleConstants.add(styleConst);

		styleConst = new StyleConstant("DATE", 1 << 5);
		styleConst.getApplyedTo().add(DateTime.class);
		styleConstants.add(styleConst);

		styleConst = new StyleConstant("TIME", 1 << 7);
		styleConst.getApplyedTo().add(DateTime.class);
		styleConstants.add(styleConst);

		styleConst = new StyleConstant("CALENDAR", 1 << 10);
		styleConst.getApplyedTo().add(DateTime.class);
		styleConstants.add(styleConst);

		styleConst = new StyleConstant("SHORT", 1 << 15);
		styleConst.getApplyedTo().add(DateTime.class);
		styleConstants.add(styleConst);

		styleConst = new StyleConstant("MEDIUM", 1 << 16);
		styleConst.getApplyedTo().add(DateTime.class);
		styleConstants.add(styleConst);

		styleConst = new StyleConstant("LONG", 1 << 28);
		styleConst.getApplyedTo().add(DateTime.class);
		styleConstants.add(styleConst);

		styleConst = new StyleConstant("MOZILLA", 1 << 15);
		styleConst.getApplyedTo().add(Browser.class);
		styleConstants.add(styleConst);

		styleConst = new StyleConstant("BALLOON", 1 << 12);
		styleConst.getApplyedTo().add(ToolTip.class);
		styleConstants.add(styleConst);
	}
}

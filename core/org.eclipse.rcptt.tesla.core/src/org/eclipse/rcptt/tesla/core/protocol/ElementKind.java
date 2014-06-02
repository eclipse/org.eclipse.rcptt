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
package org.eclipse.rcptt.tesla.core.protocol;

public enum ElementKind {
	Unknown,
	// Only for search purposes, then asked UnknownKind will be returned
	Any,
	//
	Window, EclipseWindow, Menu, Button, Text, Tree, List, Label, Table, TabFolder, TabItem,
	//
	Link, FormText, Combo, Group, Expandable,
	//
	CoolBar, CBanner, Toolbar,

	// workbench kinds
	View, Editor,

	// Text editor
	TextViewer, VerticalRuler, LeftRuler, VerticalColumn, RightRuler,

	// Diagraming
	DiagramViewer, DiagramFigure,
	// Diagraming palette support
	PaletteViewer, PaletteEntry,

	// State kind
	State,

	Item,
	// This is for tree,list,table items
	Canvas,
	// Web browser control support
	Browser,
	// Region addressable using image
	Region,

	// Menus
	AboutMenu, PreferencesMenu,

	// Data time
	DateTime,

	// Slider
	Slider,

	Perspective,

	// E4 Quick Access
	QuickAccess,

	// Column headers for tables and trees
	ColumnHeader,

	// Tabbed property view tab
	PropertyTab,

	// for custom controls
	Custom;
	
	public static ElementKind kindOf(String s) {
		try {
			return valueOf(s);
		} catch (IllegalArgumentException e) {
			return Custom;
		}
	}
}
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
package org.eclipse.rcptt.tesla.core.ui;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage
 * @generated
 */
public interface UiFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	UiFactory eINSTANCE = org.eclipse.rcptt.tesla.core.ui.impl.UiFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Widget</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Widget</em>'.
	 * @generated
	 */
	Widget createWidget();

	/**
	 * Returns a new object of class '<em>Control</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Control</em>'.
	 * @generated
	 */
	Control createControl();

	/**
	 * Returns a new object of class '<em>Control Decorator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Control Decorator</em>'.
	 * @generated
	 */
	ControlDecorator createControlDecorator();

	/**
	 * Returns a new object of class '<em>Button</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Button</em>'.
	 * @generated
	 */
	Button createButton();

	/**
	 * Returns a new object of class '<em>Tool Item</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tool Item</em>'.
	 * @generated
	 */
	ToolItem createToolItem();

	/**
	 * Returns a new object of class '<em>Label</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Label</em>'.
	 * @generated
	 */
	Label createLabel();

	/**
	 * Returns a new object of class '<em>Link</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Link</em>'.
	 * @generated
	 */
	Link createLink();

	/**
	 * Returns a new object of class '<em>Item</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Item</em>'.
	 * @generated
	 */
	Item createItem();

	/**
	 * Returns a new object of class '<em>Menu Item</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Menu Item</em>'.
	 * @generated
	 */
	MenuItem createMenuItem();

	/**
	 * Returns a new object of class '<em>Tree Item</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tree Item</em>'.
	 * @generated
	 */
	TreeItem createTreeItem();

	/**
	 * Returns a new object of class '<em>Table Item</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Table Item</em>'.
	 * @generated
	 */
	TableItem createTableItem();

	/**
	 * Returns a new object of class '<em>Text</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Text</em>'.
	 * @generated
	 */
	Text createText();

	/**
	 * Returns a new object of class '<em>Text Position</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Text Position</em>'.
	 * @generated
	 */
	TextPosition createTextPosition();

	/**
	 * Returns a new object of class '<em>Color</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Color</em>'.
	 * @generated
	 */
	Color createColor();

	/**
	 * Returns a new object of class '<em>Point</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Point</em>'.
	 * @generated
	 */
	Point createPoint();

	/**
	 * Returns a new object of class '<em>Rectangle</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Rectangle</em>'.
	 * @generated
	 */
	Rectangle createRectangle();

	/**
	 * Returns a new object of class '<em>Combo</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Combo</em>'.
	 * @generated
	 */
	Combo createCombo();

	/**
	 * Returns a new object of class '<em>Tab Folder</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tab Folder</em>'.
	 * @generated
	 */
	TabFolder createTabFolder();

	/**
	 * Returns a new object of class '<em>Composite</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Composite</em>'.
	 * @generated
	 */
	Composite createComposite();

	/**
	 * Returns a new object of class '<em>Group</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Group</em>'.
	 * @generated
	 */
	Group createGroup();

	/**
	 * Returns a new object of class '<em>Expandable Composite</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Expandable Composite</em>'.
	 * @generated
	 */
	ExpandableComposite createExpandableComposite();

	/**
	 * Returns a new object of class '<em>Tree</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tree</em>'.
	 * @generated
	 */
	Tree createTree();

	/**
	 * Returns a new object of class '<em>Table</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Table</em>'.
	 * @generated
	 */
	Table createTable();

	/**
	 * Returns a new object of class '<em>Viewer Column</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Viewer Column</em>'.
	 * @generated
	 */
	ViewerColumn createViewerColumn();

	/**
	 * Returns a new object of class '<em>Selection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Selection</em>'.
	 * @generated
	 */
	Selection createSelection();

	/**
	 * Returns a new object of class '<em>Diagram Item</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Diagram Item</em>'.
	 * @generated
	 */
	DiagramItem createDiagramItem();

	/**
	 * Returns a new object of class '<em>Diagram Connection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Diagram Connection</em>'.
	 * @generated
	 */
	DiagramConnection createDiagramConnection();

	/**
	 * Returns a new object of class '<em>Property Entry</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Property Entry</em>'.
	 * @generated
	 */
	PropertyEntry createPropertyEntry();

	/**
	 * Returns a new object of class '<em>Property Map</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Property Map</em>'.
	 * @generated
	 */
	PropertyMap createPropertyMap();

	/**
	 * Returns a new object of class '<em>Property Widget</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Property Widget</em>'.
	 * @generated
	 */
	PropertyWidget createPropertyWidget();

	/**
	 * Returns a new object of class '<em>Browser</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Browser</em>'.
	 * @generated
	 */
	Browser createBrowser();

	/**
	 * Returns a new object of class '<em>View</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>View</em>'.
	 * @generated
	 */
	View createView();

	/**
	 * Returns a new object of class '<em>Editor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Editor</em>'.
	 * @generated
	 */
	Editor createEditor();

	/**
	 * Returns a new object of class '<em>Window</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Window</em>'.
	 * @generated
	 */
	Window createWindow();

	/**
	 * Returns a new object of class '<em>Date Time</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Date Time</em>'.
	 * @generated
	 */
	DateTime createDateTime();

	/**
	 * Returns a new object of class '<em>Slider</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Slider</em>'.
	 * @generated
	 */
	Slider createSlider();

	/**
	 * Returns a new object of class '<em>Property Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Property Node</em>'.
	 * @generated
	 */
	PropertyNode createPropertyNode();

	/**
	 * Returns a new object of class '<em>Property Node List</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Property Node List</em>'.
	 * @generated
	 */
	PropertyNodeList createPropertyNodeList();

	/**
	 * Returns a new object of class '<em>Form Text</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Form Text</em>'.
	 * @generated
	 */
	FormText createFormText();

	/**
	 * Returns a new object of class '<em>Image</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Image</em>'.
	 * @generated
	 */
	Image createImage();

	/**
	 * Returns a new object of class '<em>With Image</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>With Image</em>'.
	 * @generated
	 */
	WithImage createWithImage();

	/**
	 * Returns a new object of class '<em>Marker</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Marker</em>'.
	 * @generated
	 */
	Marker createMarker();

	/**
	 * Returns a new object of class '<em>Cell</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Cell</em>'.
	 * @generated
	 */
	Cell createCell();

	/**
	 * Returns a new object of class '<em>Style Range Entry</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Style Range Entry</em>'.
	 * @generated
	 */
	StyleRangeEntry createStyleRangeEntry();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	UiPackage getUiPackage();

} //UiFactory

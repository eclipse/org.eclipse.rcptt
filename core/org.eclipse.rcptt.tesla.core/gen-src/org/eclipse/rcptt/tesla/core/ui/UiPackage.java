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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.rcptt.tesla.core.ui.UiFactory
 * @model kind="package"
 * @generated
 */
public interface UiPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "ui";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://eclipse.org/rcptt/tesla/widgets";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.eclipse.rcptt.tesla.widgets";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	UiPackage eINSTANCE = org.eclipse.rcptt.tesla.core.ui.impl.UiPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.ui.impl.WidgetImpl <em>Widget</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.ui.impl.WidgetImpl
	 * @see org.eclipse.rcptt.tesla.core.ui.impl.UiPackageImpl#getWidget()
	 * @generated
	 */
	int WIDGET = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.ui.impl.ControlImpl <em>Control</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.ui.impl.ControlImpl
	 * @see org.eclipse.rcptt.tesla.core.ui.impl.UiPackageImpl#getControl()
	 * @generated
	 */
	int CONTROL = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.ui.impl.ButtonImpl <em>Button</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.ui.impl.ButtonImpl
	 * @see org.eclipse.rcptt.tesla.core.ui.impl.UiPackageImpl#getButton()
	 * @generated
	 */
	int BUTTON = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.ui.impl.ToolItemImpl <em>Tool Item</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.ui.impl.ToolItemImpl
	 * @see org.eclipse.rcptt.tesla.core.ui.impl.UiPackageImpl#getToolItem()
	 * @generated
	 */
	int TOOL_ITEM = 4;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.ui.impl.LabelImpl <em>Label</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.ui.impl.LabelImpl
	 * @see org.eclipse.rcptt.tesla.core.ui.impl.UiPackageImpl#getLabel()
	 * @generated
	 */
	int LABEL = 5;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.ui.impl.LinkImpl <em>Link</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.ui.impl.LinkImpl
	 * @see org.eclipse.rcptt.tesla.core.ui.impl.UiPackageImpl#getLink()
	 * @generated
	 */
	int LINK = 6;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.ui.impl.ItemImpl <em>Item</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.ui.impl.ItemImpl
	 * @see org.eclipse.rcptt.tesla.core.ui.impl.UiPackageImpl#getItem()
	 * @generated
	 */
	int ITEM = 7;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.ui.impl.MenuItemImpl <em>Menu Item</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.ui.impl.MenuItemImpl
	 * @see org.eclipse.rcptt.tesla.core.ui.impl.UiPackageImpl#getMenuItem()
	 * @generated
	 */
	int MENU_ITEM = 8;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.ui.impl.TreeItemImpl <em>Tree Item</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.ui.impl.TreeItemImpl
	 * @see org.eclipse.rcptt.tesla.core.ui.impl.UiPackageImpl#getTreeItem()
	 * @generated
	 */
	int TREE_ITEM = 10;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.ui.impl.TableItemImpl <em>Table Item</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.ui.impl.TableItemImpl
	 * @see org.eclipse.rcptt.tesla.core.ui.impl.UiPackageImpl#getTableItem()
	 * @generated
	 */
	int TABLE_ITEM = 11;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.ui.impl.TextImpl <em>Text</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.ui.impl.TextImpl
	 * @see org.eclipse.rcptt.tesla.core.ui.impl.UiPackageImpl#getText()
	 * @generated
	 */
	int TEXT = 12;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.ui.impl.ColorImpl <em>Color</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.ui.impl.ColorImpl
	 * @see org.eclipse.rcptt.tesla.core.ui.impl.UiPackageImpl#getColor()
	 * @generated
	 */
	int COLOR = 14;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.ui.impl.PointImpl <em>Point</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.ui.impl.PointImpl
	 * @see org.eclipse.rcptt.tesla.core.ui.impl.UiPackageImpl#getPoint()
	 * @generated
	 */
	int POINT = 15;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.ui.impl.RectangleImpl <em>Rectangle</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.ui.impl.RectangleImpl
	 * @see org.eclipse.rcptt.tesla.core.ui.impl.UiPackageImpl#getRectangle()
	 * @generated
	 */
	int RECTANGLE = 16;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.ui.impl.ComboImpl <em>Combo</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.ui.impl.ComboImpl
	 * @see org.eclipse.rcptt.tesla.core.ui.impl.UiPackageImpl#getCombo()
	 * @generated
	 */
	int COMBO = 17;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.ui.impl.TabFolderImpl <em>Tab Folder</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.ui.impl.TabFolderImpl
	 * @see org.eclipse.rcptt.tesla.core.ui.impl.UiPackageImpl#getTabFolder()
	 * @generated
	 */
	int TAB_FOLDER = 18;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.ui.impl.CompositeImpl <em>Composite</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.ui.impl.CompositeImpl
	 * @see org.eclipse.rcptt.tesla.core.ui.impl.UiPackageImpl#getComposite()
	 * @generated
	 */
	int COMPOSITE = 19;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.ui.impl.GroupImpl <em>Group</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.ui.impl.GroupImpl
	 * @see org.eclipse.rcptt.tesla.core.ui.impl.UiPackageImpl#getGroup()
	 * @generated
	 */
	int GROUP = 20;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.ui.impl.ExpandableCompositeImpl <em>Expandable Composite</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.ui.impl.ExpandableCompositeImpl
	 * @see org.eclipse.rcptt.tesla.core.ui.impl.UiPackageImpl#getExpandableComposite()
	 * @generated
	 */
	int EXPANDABLE_COMPOSITE = 21;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.ui.impl.TreeImpl <em>Tree</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.ui.impl.TreeImpl
	 * @see org.eclipse.rcptt.tesla.core.ui.impl.UiPackageImpl#getTree()
	 * @generated
	 */
	int TREE = 22;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.ui.impl.TableImpl <em>Table</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.ui.impl.TableImpl
	 * @see org.eclipse.rcptt.tesla.core.ui.impl.UiPackageImpl#getTable()
	 * @generated
	 */
	int TABLE = 23;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.ui.impl.ViewerColumnImpl <em>Viewer Column</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.ui.impl.ViewerColumnImpl
	 * @see org.eclipse.rcptt.tesla.core.ui.impl.UiPackageImpl#getViewerColumn()
	 * @generated
	 */
	int VIEWER_COLUMN = 24;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.ui.impl.SelectionImpl <em>Selection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.ui.impl.SelectionImpl
	 * @see org.eclipse.rcptt.tesla.core.ui.impl.UiPackageImpl#getSelection()
	 * @generated
	 */
	int SELECTION = 25;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.ui.impl.DiagramItemImpl <em>Diagram Item</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.ui.impl.DiagramItemImpl
	 * @see org.eclipse.rcptt.tesla.core.ui.impl.UiPackageImpl#getDiagramItem()
	 * @generated
	 */
	int DIAGRAM_ITEM = 26;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.ui.impl.DiagramConnectionImpl <em>Diagram Connection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.ui.impl.DiagramConnectionImpl
	 * @see org.eclipse.rcptt.tesla.core.ui.impl.UiPackageImpl#getDiagramConnection()
	 * @generated
	 */
	int DIAGRAM_CONNECTION = 27;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.ui.impl.PropertyEntryImpl <em>Property Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.ui.impl.PropertyEntryImpl
	 * @see org.eclipse.rcptt.tesla.core.ui.impl.UiPackageImpl#getPropertyEntry()
	 * @generated
	 */
	int PROPERTY_ENTRY = 28;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.ui.impl.PropertyMapImpl <em>Property Map</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.ui.impl.PropertyMapImpl
	 * @see org.eclipse.rcptt.tesla.core.ui.impl.UiPackageImpl#getPropertyMap()
	 * @generated
	 */
	int PROPERTY_MAP = 29;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.ui.impl.PropertyWidgetImpl <em>Property Widget</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.ui.impl.PropertyWidgetImpl
	 * @see org.eclipse.rcptt.tesla.core.ui.impl.UiPackageImpl#getPropertyWidget()
	 * @generated
	 */
	int PROPERTY_WIDGET = 30;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.ui.impl.BrowserImpl <em>Browser</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.ui.impl.BrowserImpl
	 * @see org.eclipse.rcptt.tesla.core.ui.impl.UiPackageImpl#getBrowser()
	 * @generated
	 */
	int BROWSER = 31;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.ui.impl.ViewImpl <em>View</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.ui.impl.ViewImpl
	 * @see org.eclipse.rcptt.tesla.core.ui.impl.UiPackageImpl#getView()
	 * @generated
	 */
	int VIEW = 32;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.ui.impl.EditorImpl <em>Editor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.ui.impl.EditorImpl
	 * @see org.eclipse.rcptt.tesla.core.ui.impl.UiPackageImpl#getEditor()
	 * @generated
	 */
	int EDITOR = 33;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.ui.impl.WindowImpl <em>Window</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.ui.impl.WindowImpl
	 * @see org.eclipse.rcptt.tesla.core.ui.impl.UiPackageImpl#getWindow()
	 * @generated
	 */
	int WINDOW = 34;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.ui.impl.DateTimeImpl <em>Date Time</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.ui.impl.DateTimeImpl
	 * @see org.eclipse.rcptt.tesla.core.ui.impl.UiPackageImpl#getDateTime()
	 * @generated
	 */
	int DATE_TIME = 35;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.ui.impl.SliderImpl <em>Slider</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.ui.impl.SliderImpl
	 * @see org.eclipse.rcptt.tesla.core.ui.impl.UiPackageImpl#getSlider()
	 * @generated
	 */
	int SLIDER = 36;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.ui.impl.PropertyNodeImpl <em>Property Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.ui.impl.PropertyNodeImpl
	 * @see org.eclipse.rcptt.tesla.core.ui.impl.UiPackageImpl#getPropertyNode()
	 * @generated
	 */
	int PROPERTY_NODE = 37;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.ui.impl.PropertyNodeListImpl <em>Property Node List</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.ui.impl.PropertyNodeListImpl
	 * @see org.eclipse.rcptt.tesla.core.ui.impl.UiPackageImpl#getPropertyNodeList()
	 * @generated
	 */
	int PROPERTY_NODE_LIST = 38;

	/**
	 * The feature id for the '<em><b>Property Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_NODE_LIST__PROPERTY_NODES = 0;

	/**
	 * The number of structural features of the '<em>Property Node List</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_NODE_LIST_FEATURE_COUNT = 1;

	/**
	 * The feature id for the '<em><b>Property Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIDGET__PROPERTY_NODES = PROPERTY_NODE_LIST__PROPERTY_NODES;

	/**
	 * The number of structural features of the '<em>Widget</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIDGET_FEATURE_COUNT = PROPERTY_NODE_LIST_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Property Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL__PROPERTY_NODES = WIDGET__PROPERTY_NODES;

	/**
	 * The feature id for the '<em><b>Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL__CLASS_NAME = WIDGET_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Enablement</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL__ENABLEMENT = WIDGET_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Background Color</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL__BACKGROUND_COLOR = WIDGET_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Foreground Color</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL__FOREGROUND_COLOR = WIDGET_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Contain Menu</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL__CONTAIN_MENU = WIDGET_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Bounds</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL__BOUNDS = WIDGET_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Border With</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL__BORDER_WITH = WIDGET_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Decorators</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL__DECORATORS = WIDGET_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>Control</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_FEATURE_COUNT = WIDGET_FEATURE_COUNT + 8;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.ui.impl.ControlDecoratorImpl <em>Control Decorator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.ui.impl.ControlDecoratorImpl
	 * @see org.eclipse.rcptt.tesla.core.ui.impl.UiPackageImpl#getControlDecorator()
	 * @generated
	 */
	int CONTROL_DECORATOR = 2;

	/**
	 * The feature id for the '<em><b>Visible</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_DECORATOR__VISIBLE = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_DECORATOR__DESCRIPTION = 1;

	/**
	 * The number of structural features of the '<em>Control Decorator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_DECORATOR_FEATURE_COUNT = 2;

	/**
	 * The feature id for the '<em><b>Property Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUTTON__PROPERTY_NODES = CONTROL__PROPERTY_NODES;

	/**
	 * The feature id for the '<em><b>Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUTTON__CLASS_NAME = CONTROL__CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Enablement</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUTTON__ENABLEMENT = CONTROL__ENABLEMENT;

	/**
	 * The feature id for the '<em><b>Background Color</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUTTON__BACKGROUND_COLOR = CONTROL__BACKGROUND_COLOR;

	/**
	 * The feature id for the '<em><b>Foreground Color</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUTTON__FOREGROUND_COLOR = CONTROL__FOREGROUND_COLOR;

	/**
	 * The feature id for the '<em><b>Contain Menu</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUTTON__CONTAIN_MENU = CONTROL__CONTAIN_MENU;

	/**
	 * The feature id for the '<em><b>Bounds</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUTTON__BOUNDS = CONTROL__BOUNDS;

	/**
	 * The feature id for the '<em><b>Border With</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUTTON__BORDER_WITH = CONTROL__BORDER_WITH;

	/**
	 * The feature id for the '<em><b>Decorators</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUTTON__DECORATORS = CONTROL__DECORATORS;

	/**
	 * The feature id for the '<em><b>Image</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUTTON__IMAGE = CONTROL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Caption</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUTTON__CAPTION = CONTROL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Tooltip</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUTTON__TOOLTIP = CONTROL_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Selected</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUTTON__SELECTED = CONTROL_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Grayed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUTTON__GRAYED = CONTROL_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUTTON__KIND = CONTROL_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Button</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUTTON_FEATURE_COUNT = CONTROL_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Property Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ITEM__PROPERTY_NODES = BUTTON__PROPERTY_NODES;

	/**
	 * The feature id for the '<em><b>Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ITEM__CLASS_NAME = BUTTON__CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Enablement</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ITEM__ENABLEMENT = BUTTON__ENABLEMENT;

	/**
	 * The feature id for the '<em><b>Background Color</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ITEM__BACKGROUND_COLOR = BUTTON__BACKGROUND_COLOR;

	/**
	 * The feature id for the '<em><b>Foreground Color</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ITEM__FOREGROUND_COLOR = BUTTON__FOREGROUND_COLOR;

	/**
	 * The feature id for the '<em><b>Contain Menu</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ITEM__CONTAIN_MENU = BUTTON__CONTAIN_MENU;

	/**
	 * The feature id for the '<em><b>Bounds</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ITEM__BOUNDS = BUTTON__BOUNDS;

	/**
	 * The feature id for the '<em><b>Border With</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ITEM__BORDER_WITH = BUTTON__BORDER_WITH;

	/**
	 * The feature id for the '<em><b>Decorators</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ITEM__DECORATORS = BUTTON__DECORATORS;

	/**
	 * The feature id for the '<em><b>Image</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ITEM__IMAGE = BUTTON__IMAGE;

	/**
	 * The feature id for the '<em><b>Caption</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ITEM__CAPTION = BUTTON__CAPTION;

	/**
	 * The feature id for the '<em><b>Tooltip</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ITEM__TOOLTIP = BUTTON__TOOLTIP;

	/**
	 * The feature id for the '<em><b>Selected</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ITEM__SELECTED = BUTTON__SELECTED;

	/**
	 * The feature id for the '<em><b>Grayed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ITEM__GRAYED = BUTTON__GRAYED;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ITEM__KIND = BUTTON__KIND;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ITEM__INDEX = BUTTON_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Tool Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_ITEM_FEATURE_COUNT = BUTTON_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Property Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL__PROPERTY_NODES = CONTROL__PROPERTY_NODES;

	/**
	 * The feature id for the '<em><b>Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL__CLASS_NAME = CONTROL__CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Enablement</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL__ENABLEMENT = CONTROL__ENABLEMENT;

	/**
	 * The feature id for the '<em><b>Background Color</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL__BACKGROUND_COLOR = CONTROL__BACKGROUND_COLOR;

	/**
	 * The feature id for the '<em><b>Foreground Color</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL__FOREGROUND_COLOR = CONTROL__FOREGROUND_COLOR;

	/**
	 * The feature id for the '<em><b>Contain Menu</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL__CONTAIN_MENU = CONTROL__CONTAIN_MENU;

	/**
	 * The feature id for the '<em><b>Bounds</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL__BOUNDS = CONTROL__BOUNDS;

	/**
	 * The feature id for the '<em><b>Border With</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL__BORDER_WITH = CONTROL__BORDER_WITH;

	/**
	 * The feature id for the '<em><b>Decorators</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL__DECORATORS = CONTROL__DECORATORS;

	/**
	 * The feature id for the '<em><b>Image</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL__IMAGE = CONTROL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Caption</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL__CAPTION = CONTROL_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Label</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL_FEATURE_COUNT = CONTROL_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Property Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK__PROPERTY_NODES = CONTROL__PROPERTY_NODES;

	/**
	 * The feature id for the '<em><b>Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK__CLASS_NAME = CONTROL__CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Enablement</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK__ENABLEMENT = CONTROL__ENABLEMENT;

	/**
	 * The feature id for the '<em><b>Background Color</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK__BACKGROUND_COLOR = CONTROL__BACKGROUND_COLOR;

	/**
	 * The feature id for the '<em><b>Foreground Color</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK__FOREGROUND_COLOR = CONTROL__FOREGROUND_COLOR;

	/**
	 * The feature id for the '<em><b>Contain Menu</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK__CONTAIN_MENU = CONTROL__CONTAIN_MENU;

	/**
	 * The feature id for the '<em><b>Bounds</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK__BOUNDS = CONTROL__BOUNDS;

	/**
	 * The feature id for the '<em><b>Border With</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK__BORDER_WITH = CONTROL__BORDER_WITH;

	/**
	 * The feature id for the '<em><b>Decorators</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK__DECORATORS = CONTROL__DECORATORS;

	/**
	 * The feature id for the '<em><b>Caption</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK__CAPTION = CONTROL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Toltip</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK__TOLTIP = CONTROL_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_FEATURE_COUNT = CONTROL_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Property Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITEM__PROPERTY_NODES = WIDGET__PROPERTY_NODES;

	/**
	 * The feature id for the '<em><b>Caption</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITEM__CAPTION = WIDGET_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Selection</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITEM__SELECTION = WIDGET_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Enablement</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITEM__ENABLEMENT = WIDGET_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITEM__INDEX = WIDGET_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITEM_FEATURE_COUNT = WIDGET_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Property Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU_ITEM__PROPERTY_NODES = ITEM__PROPERTY_NODES;

	/**
	 * The feature id for the '<em><b>Caption</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU_ITEM__CAPTION = ITEM__CAPTION;

	/**
	 * The feature id for the '<em><b>Selection</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU_ITEM__SELECTION = ITEM__SELECTION;

	/**
	 * The feature id for the '<em><b>Enablement</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU_ITEM__ENABLEMENT = ITEM__ENABLEMENT;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU_ITEM__INDEX = ITEM__INDEX;

	/**
	 * The feature id for the '<em><b>Accelerator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU_ITEM__ACCELERATOR = ITEM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Cascade</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU_ITEM__CASCADE = ITEM_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Menu Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MENU_ITEM_FEATURE_COUNT = ITEM_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.ui.impl.StyleRangeEntryImpl <em>Style Range Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.ui.impl.StyleRangeEntryImpl
	 * @see org.eclipse.rcptt.tesla.core.ui.impl.UiPackageImpl#getStyleRangeEntry()
	 * @generated
	 */
	int STYLE_RANGE_ENTRY = 9;

	/**
	 * The feature id for the '<em><b>Property Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STYLE_RANGE_ENTRY__PROPERTY_NODES = WIDGET__PROPERTY_NODES;

	/**
	 * The feature id for the '<em><b>Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STYLE_RANGE_ENTRY__START = WIDGET_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STYLE_RANGE_ENTRY__LENGTH = WIDGET_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STYLE_RANGE_ENTRY__TEXT = WIDGET_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Font Style</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STYLE_RANGE_ENTRY__FONT_STYLE = WIDGET_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Font</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STYLE_RANGE_ENTRY__FONT = WIDGET_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Foreground Color</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STYLE_RANGE_ENTRY__FOREGROUND_COLOR = WIDGET_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Background Color</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STYLE_RANGE_ENTRY__BACKGROUND_COLOR = WIDGET_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Underline</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STYLE_RANGE_ENTRY__UNDERLINE = WIDGET_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Underline Color</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STYLE_RANGE_ENTRY__UNDERLINE_COLOR = WIDGET_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Strikeout</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STYLE_RANGE_ENTRY__STRIKEOUT = WIDGET_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Strikeout Color</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STYLE_RANGE_ENTRY__STRIKEOUT_COLOR = WIDGET_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Border Style</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STYLE_RANGE_ENTRY__BORDER_STYLE = WIDGET_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Border Color</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STYLE_RANGE_ENTRY__BORDER_COLOR = WIDGET_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Rise</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STYLE_RANGE_ENTRY__RISE = WIDGET_FEATURE_COUNT + 13;

	/**
	 * The feature id for the '<em><b>Metrics</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STYLE_RANGE_ENTRY__METRICS = WIDGET_FEATURE_COUNT + 14;

	/**
	 * The feature id for the '<em><b>Start Pos</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STYLE_RANGE_ENTRY__START_POS = WIDGET_FEATURE_COUNT + 15;

	/**
	 * The feature id for the '<em><b>End Pos</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STYLE_RANGE_ENTRY__END_POS = WIDGET_FEATURE_COUNT + 16;

	/**
	 * The number of structural features of the '<em>Style Range Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STYLE_RANGE_ENTRY_FEATURE_COUNT = WIDGET_FEATURE_COUNT + 17;

	/**
	 * The feature id for the '<em><b>Property Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_ITEM__PROPERTY_NODES = ITEM__PROPERTY_NODES;

	/**
	 * The feature id for the '<em><b>Caption</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_ITEM__CAPTION = ITEM__CAPTION;

	/**
	 * The feature id for the '<em><b>Selection</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_ITEM__SELECTION = ITEM__SELECTION;

	/**
	 * The feature id for the '<em><b>Enablement</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_ITEM__ENABLEMENT = ITEM__ENABLEMENT;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_ITEM__INDEX = ITEM__INDEX;

	/**
	 * The feature id for the '<em><b>Image</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_ITEM__IMAGE = ITEM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Selected</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_ITEM__SELECTED = ITEM_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Checked</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_ITEM__CHECKED = ITEM_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Background Color</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_ITEM__BACKGROUND_COLOR = ITEM_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Foreground Color</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_ITEM__FOREGROUND_COLOR = ITEM_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Bounds</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_ITEM__BOUNDS = ITEM_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Child Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_ITEM__CHILD_COUNT = ITEM_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Columns</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_ITEM__COLUMNS = ITEM_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Columns Background Color</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_ITEM__COLUMNS_BACKGROUND_COLOR = ITEM_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Columns Foreground Color</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_ITEM__COLUMNS_FOREGROUND_COLOR = ITEM_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Style Ranges</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_ITEM__STYLE_RANGES = ITEM_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Styles</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_ITEM__STYLES = ITEM_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Values</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_ITEM__VALUES = ITEM_FEATURE_COUNT + 12;

	/**
	 * The number of structural features of the '<em>Tree Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_ITEM_FEATURE_COUNT = ITEM_FEATURE_COUNT + 13;

	/**
	 * The feature id for the '<em><b>Property Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_ITEM__PROPERTY_NODES = ITEM__PROPERTY_NODES;

	/**
	 * The feature id for the '<em><b>Caption</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_ITEM__CAPTION = ITEM__CAPTION;

	/**
	 * The feature id for the '<em><b>Selection</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_ITEM__SELECTION = ITEM__SELECTION;

	/**
	 * The feature id for the '<em><b>Enablement</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_ITEM__ENABLEMENT = ITEM__ENABLEMENT;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_ITEM__INDEX = ITEM__INDEX;

	/**
	 * The feature id for the '<em><b>Image</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_ITEM__IMAGE = ITEM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Selected</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_ITEM__SELECTED = ITEM_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Checked</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_ITEM__CHECKED = ITEM_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Background Color</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_ITEM__BACKGROUND_COLOR = ITEM_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Foreground Color</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_ITEM__FOREGROUND_COLOR = ITEM_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Bounds</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_ITEM__BOUNDS = ITEM_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Columns</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_ITEM__COLUMNS = ITEM_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Columns Background Color</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_ITEM__COLUMNS_BACKGROUND_COLOR = ITEM_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Columns Foreground Color</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_ITEM__COLUMNS_FOREGROUND_COLOR = ITEM_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Style Ranges</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_ITEM__STYLE_RANGES = ITEM_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Styles</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_ITEM__STYLES = ITEM_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Values</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_ITEM__VALUES = ITEM_FEATURE_COUNT + 11;

	/**
	 * The number of structural features of the '<em>Table Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_ITEM_FEATURE_COUNT = ITEM_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Property Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT__PROPERTY_NODES = CONTROL__PROPERTY_NODES;

	/**
	 * The feature id for the '<em><b>Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT__CLASS_NAME = CONTROL__CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Enablement</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT__ENABLEMENT = CONTROL__ENABLEMENT;

	/**
	 * The feature id for the '<em><b>Background Color</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT__BACKGROUND_COLOR = CONTROL__BACKGROUND_COLOR;

	/**
	 * The feature id for the '<em><b>Foreground Color</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT__FOREGROUND_COLOR = CONTROL__FOREGROUND_COLOR;

	/**
	 * The feature id for the '<em><b>Contain Menu</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT__CONTAIN_MENU = CONTROL__CONTAIN_MENU;

	/**
	 * The feature id for the '<em><b>Bounds</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT__BOUNDS = CONTROL__BOUNDS;

	/**
	 * The feature id for the '<em><b>Border With</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT__BORDER_WITH = CONTROL__BORDER_WITH;

	/**
	 * The feature id for the '<em><b>Decorators</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT__DECORATORS = CONTROL__DECORATORS;

	/**
	 * The feature id for the '<em><b>Tooltip</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT__TOOLTIP = CONTROL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT__VALUE = CONTROL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Read Only</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT__READ_ONLY = CONTROL_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Raw Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT__RAW_VALUE = CONTROL_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Style Ranges</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT__STYLE_RANGES = CONTROL_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT__TEXT = CONTROL_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Styles</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT__STYLES = CONTROL_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Caret Position</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT__CARET_POSITION = CONTROL_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Style At Caret</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT__STYLE_AT_CARET = CONTROL_FEATURE_COUNT + 8;

	/**
	 * The number of structural features of the '<em>Text</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_FEATURE_COUNT = CONTROL_FEATURE_COUNT + 9;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.ui.impl.TextPositionImpl <em>Text Position</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.ui.impl.TextPositionImpl
	 * @see org.eclipse.rcptt.tesla.core.ui.impl.UiPackageImpl#getTextPosition()
	 * @generated
	 */
	int TEXT_POSITION = 13;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_POSITION__LINE = 0;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_POSITION__COLUMN = 1;

	/**
	 * The number of structural features of the '<em>Text Position</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_POSITION_FEATURE_COUNT = 2;

	/**
	 * The feature id for the '<em><b>Red</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR__RED = 0;

	/**
	 * The feature id for the '<em><b>Green</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR__GREEN = 1;

	/**
	 * The feature id for the '<em><b>Blue</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR__BLUE = 2;

	/**
	 * The feature id for the '<em><b>Alfa</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR__ALFA = 3;

	/**
	 * The number of structural features of the '<em>Color</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_FEATURE_COUNT = 4;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINT__X = 0;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINT__Y = 1;

	/**
	 * The number of structural features of the '<em>Point</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINT_FEATURE_COUNT = 2;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECTANGLE__X = 0;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECTANGLE__Y = 1;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECTANGLE__WIDTH = 2;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECTANGLE__HEIGHT = 3;

	/**
	 * The number of structural features of the '<em>Rectangle</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECTANGLE_FEATURE_COUNT = 4;

	/**
	 * The feature id for the '<em><b>Property Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMBO__PROPERTY_NODES = CONTROL__PROPERTY_NODES;

	/**
	 * The feature id for the '<em><b>Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMBO__CLASS_NAME = CONTROL__CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Enablement</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMBO__ENABLEMENT = CONTROL__ENABLEMENT;

	/**
	 * The feature id for the '<em><b>Background Color</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMBO__BACKGROUND_COLOR = CONTROL__BACKGROUND_COLOR;

	/**
	 * The feature id for the '<em><b>Foreground Color</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMBO__FOREGROUND_COLOR = CONTROL__FOREGROUND_COLOR;

	/**
	 * The feature id for the '<em><b>Contain Menu</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMBO__CONTAIN_MENU = CONTROL__CONTAIN_MENU;

	/**
	 * The feature id for the '<em><b>Bounds</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMBO__BOUNDS = CONTROL__BOUNDS;

	/**
	 * The feature id for the '<em><b>Border With</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMBO__BORDER_WITH = CONTROL__BORDER_WITH;

	/**
	 * The feature id for the '<em><b>Decorators</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMBO__DECORATORS = CONTROL__DECORATORS;

	/**
	 * The feature id for the '<em><b>Tooltip</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMBO__TOOLTIP = CONTROL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Selection</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMBO__SELECTION = CONTROL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Read Only</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMBO__READ_ONLY = CONTROL_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Values</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMBO__VALUES = CONTROL_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Combo</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMBO_FEATURE_COUNT = CONTROL_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Property Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAB_FOLDER__PROPERTY_NODES = CONTROL__PROPERTY_NODES;

	/**
	 * The feature id for the '<em><b>Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAB_FOLDER__CLASS_NAME = CONTROL__CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Enablement</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAB_FOLDER__ENABLEMENT = CONTROL__ENABLEMENT;

	/**
	 * The feature id for the '<em><b>Background Color</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAB_FOLDER__BACKGROUND_COLOR = CONTROL__BACKGROUND_COLOR;

	/**
	 * The feature id for the '<em><b>Foreground Color</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAB_FOLDER__FOREGROUND_COLOR = CONTROL__FOREGROUND_COLOR;

	/**
	 * The feature id for the '<em><b>Contain Menu</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAB_FOLDER__CONTAIN_MENU = CONTROL__CONTAIN_MENU;

	/**
	 * The feature id for the '<em><b>Bounds</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAB_FOLDER__BOUNDS = CONTROL__BOUNDS;

	/**
	 * The feature id for the '<em><b>Border With</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAB_FOLDER__BORDER_WITH = CONTROL__BORDER_WITH;

	/**
	 * The feature id for the '<em><b>Decorators</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAB_FOLDER__DECORATORS = CONTROL__DECORATORS;

	/**
	 * The feature id for the '<em><b>Selection</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAB_FOLDER__SELECTION = CONTROL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Pages</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAB_FOLDER__PAGES = CONTROL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Active Page</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAB_FOLDER__ACTIVE_PAGE = CONTROL_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Tab Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAB_FOLDER__TAB_COUNT = CONTROL_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Tab Folder</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAB_FOLDER_FEATURE_COUNT = CONTROL_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Property Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE__PROPERTY_NODES = CONTROL__PROPERTY_NODES;

	/**
	 * The feature id for the '<em><b>Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE__CLASS_NAME = CONTROL__CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Enablement</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE__ENABLEMENT = CONTROL__ENABLEMENT;

	/**
	 * The feature id for the '<em><b>Background Color</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE__BACKGROUND_COLOR = CONTROL__BACKGROUND_COLOR;

	/**
	 * The feature id for the '<em><b>Foreground Color</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE__FOREGROUND_COLOR = CONTROL__FOREGROUND_COLOR;

	/**
	 * The feature id for the '<em><b>Contain Menu</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE__CONTAIN_MENU = CONTROL__CONTAIN_MENU;

	/**
	 * The feature id for the '<em><b>Bounds</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE__BOUNDS = CONTROL__BOUNDS;

	/**
	 * The feature id for the '<em><b>Border With</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE__BORDER_WITH = CONTROL__BORDER_WITH;

	/**
	 * The feature id for the '<em><b>Decorators</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE__DECORATORS = CONTROL__DECORATORS;

	/**
	 * The feature id for the '<em><b>Child Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE__CHILD_COUNT = CONTROL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Composite</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_FEATURE_COUNT = CONTROL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Property Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP__PROPERTY_NODES = COMPOSITE__PROPERTY_NODES;

	/**
	 * The feature id for the '<em><b>Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP__CLASS_NAME = COMPOSITE__CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Enablement</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP__ENABLEMENT = COMPOSITE__ENABLEMENT;

	/**
	 * The feature id for the '<em><b>Background Color</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP__BACKGROUND_COLOR = COMPOSITE__BACKGROUND_COLOR;

	/**
	 * The feature id for the '<em><b>Foreground Color</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP__FOREGROUND_COLOR = COMPOSITE__FOREGROUND_COLOR;

	/**
	 * The feature id for the '<em><b>Contain Menu</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP__CONTAIN_MENU = COMPOSITE__CONTAIN_MENU;

	/**
	 * The feature id for the '<em><b>Bounds</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP__BOUNDS = COMPOSITE__BOUNDS;

	/**
	 * The feature id for the '<em><b>Border With</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP__BORDER_WITH = COMPOSITE__BORDER_WITH;

	/**
	 * The feature id for the '<em><b>Decorators</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP__DECORATORS = COMPOSITE__DECORATORS;

	/**
	 * The feature id for the '<em><b>Child Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP__CHILD_COUNT = COMPOSITE__CHILD_COUNT;

	/**
	 * The feature id for the '<em><b>Caption</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP__CAPTION = COMPOSITE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP_FEATURE_COUNT = COMPOSITE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Property Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPANDABLE_COMPOSITE__PROPERTY_NODES = COMPOSITE__PROPERTY_NODES;

	/**
	 * The feature id for the '<em><b>Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPANDABLE_COMPOSITE__CLASS_NAME = COMPOSITE__CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Enablement</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPANDABLE_COMPOSITE__ENABLEMENT = COMPOSITE__ENABLEMENT;

	/**
	 * The feature id for the '<em><b>Background Color</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPANDABLE_COMPOSITE__BACKGROUND_COLOR = COMPOSITE__BACKGROUND_COLOR;

	/**
	 * The feature id for the '<em><b>Foreground Color</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPANDABLE_COMPOSITE__FOREGROUND_COLOR = COMPOSITE__FOREGROUND_COLOR;

	/**
	 * The feature id for the '<em><b>Contain Menu</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPANDABLE_COMPOSITE__CONTAIN_MENU = COMPOSITE__CONTAIN_MENU;

	/**
	 * The feature id for the '<em><b>Bounds</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPANDABLE_COMPOSITE__BOUNDS = COMPOSITE__BOUNDS;

	/**
	 * The feature id for the '<em><b>Border With</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPANDABLE_COMPOSITE__BORDER_WITH = COMPOSITE__BORDER_WITH;

	/**
	 * The feature id for the '<em><b>Decorators</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPANDABLE_COMPOSITE__DECORATORS = COMPOSITE__DECORATORS;

	/**
	 * The feature id for the '<em><b>Child Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPANDABLE_COMPOSITE__CHILD_COUNT = COMPOSITE__CHILD_COUNT;

	/**
	 * The feature id for the '<em><b>Caption</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPANDABLE_COMPOSITE__CAPTION = COMPOSITE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Expanded</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPANDABLE_COMPOSITE__EXPANDED = COMPOSITE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Expandable Composite</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPANDABLE_COMPOSITE_FEATURE_COUNT = COMPOSITE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Property Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE__PROPERTY_NODES = CONTROL__PROPERTY_NODES;

	/**
	 * The feature id for the '<em><b>Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE__CLASS_NAME = CONTROL__CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Enablement</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE__ENABLEMENT = CONTROL__ENABLEMENT;

	/**
	 * The feature id for the '<em><b>Background Color</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE__BACKGROUND_COLOR = CONTROL__BACKGROUND_COLOR;

	/**
	 * The feature id for the '<em><b>Foreground Color</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE__FOREGROUND_COLOR = CONTROL__FOREGROUND_COLOR;

	/**
	 * The feature id for the '<em><b>Contain Menu</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE__CONTAIN_MENU = CONTROL__CONTAIN_MENU;

	/**
	 * The feature id for the '<em><b>Bounds</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE__BOUNDS = CONTROL__BOUNDS;

	/**
	 * The feature id for the '<em><b>Border With</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE__BORDER_WITH = CONTROL__BORDER_WITH;

	/**
	 * The feature id for the '<em><b>Decorators</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE__DECORATORS = CONTROL__DECORATORS;

	/**
	 * The feature id for the '<em><b>Columns</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE__COLUMNS = CONTROL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Lines Visible</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE__LINES_VISIBLE = CONTROL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Selection</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE__SELECTION = CONTROL_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Multi Selection</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE__MULTI_SELECTION = CONTROL_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Header Visible</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE__HEADER_VISIBLE = CONTROL_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Item Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE__ITEM_COUNT = CONTROL_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Tree</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_FEATURE_COUNT = CONTROL_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Property Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE__PROPERTY_NODES = CONTROL__PROPERTY_NODES;

	/**
	 * The feature id for the '<em><b>Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE__CLASS_NAME = CONTROL__CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Enablement</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE__ENABLEMENT = CONTROL__ENABLEMENT;

	/**
	 * The feature id for the '<em><b>Background Color</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE__BACKGROUND_COLOR = CONTROL__BACKGROUND_COLOR;

	/**
	 * The feature id for the '<em><b>Foreground Color</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE__FOREGROUND_COLOR = CONTROL__FOREGROUND_COLOR;

	/**
	 * The feature id for the '<em><b>Contain Menu</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE__CONTAIN_MENU = CONTROL__CONTAIN_MENU;

	/**
	 * The feature id for the '<em><b>Bounds</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE__BOUNDS = CONTROL__BOUNDS;

	/**
	 * The feature id for the '<em><b>Border With</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE__BORDER_WITH = CONTROL__BORDER_WITH;

	/**
	 * The feature id for the '<em><b>Decorators</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE__DECORATORS = CONTROL__DECORATORS;

	/**
	 * The feature id for the '<em><b>Columns</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE__COLUMNS = CONTROL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Lines Visible</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE__LINES_VISIBLE = CONTROL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Selection</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE__SELECTION = CONTROL_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Multi Selection</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE__MULTI_SELECTION = CONTROL_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Header Visible</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE__HEADER_VISIBLE = CONTROL_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Item Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE__ITEM_COUNT = CONTROL_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Table</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_FEATURE_COUNT = CONTROL_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Property Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEWER_COLUMN__PROPERTY_NODES = ITEM__PROPERTY_NODES;

	/**
	 * The feature id for the '<em><b>Caption</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEWER_COLUMN__CAPTION = ITEM__CAPTION;

	/**
	 * The feature id for the '<em><b>Selection</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEWER_COLUMN__SELECTION = ITEM__SELECTION;

	/**
	 * The feature id for the '<em><b>Enablement</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEWER_COLUMN__ENABLEMENT = ITEM__ENABLEMENT;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEWER_COLUMN__INDEX = ITEM__INDEX;

	/**
	 * The feature id for the '<em><b>Resizable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEWER_COLUMN__RESIZABLE = ITEM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Movable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEWER_COLUMN__MOVABLE = ITEM_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEWER_COLUMN__WIDTH = ITEM_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Tooltip</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEWER_COLUMN__TOOLTIP = ITEM_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Viewer Column</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEWER_COLUMN_FEATURE_COUNT = ITEM_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECTION__PATH = 0;

	/**
	 * The number of structural features of the '<em>Selection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECTION_FEATURE_COUNT = 1;

	/**
	 * The feature id for the '<em><b>Property Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_ITEM__PROPERTY_NODES = WIDGET__PROPERTY_NODES;

	/**
	 * The feature id for the '<em><b>properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_ITEM__PROPERTIES = WIDGET_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_ITEM__TEXT = WIDGET_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Tooltip</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_ITEM__TOOLTIP = WIDGET_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_ITEM__CLASS_NAME = WIDGET_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Item Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_ITEM__ITEM_ADDRESS = WIDGET_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Selected</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_ITEM__SELECTED = WIDGET_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_ITEM__X = WIDGET_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_ITEM__Y = WIDGET_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_ITEM__WIDTH = WIDGET_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_ITEM__HEIGHT = WIDGET_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Children Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_ITEM__CHILDREN_COUNT = WIDGET_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Background Color</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_ITEM__BACKGROUND_COLOR = WIDGET_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Foreground Color</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_ITEM__FOREGROUND_COLOR = WIDGET_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Model Property Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_ITEM__MODEL_PROPERTY_NODES = WIDGET_FEATURE_COUNT + 13;

	/**
	 * The number of structural features of the '<em>Diagram Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_ITEM_FEATURE_COUNT = WIDGET_FEATURE_COUNT + 14;

	/**
	 * The feature id for the '<em><b>Property Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_CONNECTION__PROPERTY_NODES = DIAGRAM_ITEM__PROPERTY_NODES;

	/**
	 * The feature id for the '<em><b>properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_CONNECTION__PROPERTIES = DIAGRAM_ITEM__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_CONNECTION__TEXT = DIAGRAM_ITEM__TEXT;

	/**
	 * The feature id for the '<em><b>Tooltip</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_CONNECTION__TOOLTIP = DIAGRAM_ITEM__TOOLTIP;

	/**
	 * The feature id for the '<em><b>Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_CONNECTION__CLASS_NAME = DIAGRAM_ITEM__CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Item Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_CONNECTION__ITEM_ADDRESS = DIAGRAM_ITEM__ITEM_ADDRESS;

	/**
	 * The feature id for the '<em><b>Selected</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_CONNECTION__SELECTED = DIAGRAM_ITEM__SELECTED;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_CONNECTION__X = DIAGRAM_ITEM__X;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_CONNECTION__Y = DIAGRAM_ITEM__Y;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_CONNECTION__WIDTH = DIAGRAM_ITEM__WIDTH;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_CONNECTION__HEIGHT = DIAGRAM_ITEM__HEIGHT;

	/**
	 * The feature id for the '<em><b>Children Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_CONNECTION__CHILDREN_COUNT = DIAGRAM_ITEM__CHILDREN_COUNT;

	/**
	 * The feature id for the '<em><b>Background Color</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_CONNECTION__BACKGROUND_COLOR = DIAGRAM_ITEM__BACKGROUND_COLOR;

	/**
	 * The feature id for the '<em><b>Foreground Color</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_CONNECTION__FOREGROUND_COLOR = DIAGRAM_ITEM__FOREGROUND_COLOR;

	/**
	 * The feature id for the '<em><b>Model Property Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_CONNECTION__MODEL_PROPERTY_NODES = DIAGRAM_ITEM__MODEL_PROPERTY_NODES;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_CONNECTION__SOURCE = DIAGRAM_ITEM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_CONNECTION__TARGET = DIAGRAM_ITEM_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Diagram Connection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_CONNECTION_FEATURE_COUNT = DIAGRAM_ITEM_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_ENTRY__NAME = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_ENTRY__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Property Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_ENTRY_FEATURE_COUNT = 2;

	/**
	 * The feature id for the '<em><b>properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_MAP__PROPERTIES = 0;

	/**
	 * The number of structural features of the '<em>Property Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_MAP_FEATURE_COUNT = 1;

	/**
	 * The feature id for the '<em><b>Property Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_WIDGET__PROPERTY_NODES = WIDGET__PROPERTY_NODES;

	/**
	 * The feature id for the '<em><b>properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_WIDGET__PROPERTIES = WIDGET_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Property Widget</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_WIDGET_FEATURE_COUNT = WIDGET_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Property Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BROWSER__PROPERTY_NODES = CONTROL__PROPERTY_NODES;

	/**
	 * The feature id for the '<em><b>Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BROWSER__CLASS_NAME = CONTROL__CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Enablement</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BROWSER__ENABLEMENT = CONTROL__ENABLEMENT;

	/**
	 * The feature id for the '<em><b>Background Color</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BROWSER__BACKGROUND_COLOR = CONTROL__BACKGROUND_COLOR;

	/**
	 * The feature id for the '<em><b>Foreground Color</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BROWSER__FOREGROUND_COLOR = CONTROL__FOREGROUND_COLOR;

	/**
	 * The feature id for the '<em><b>Contain Menu</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BROWSER__CONTAIN_MENU = CONTROL__CONTAIN_MENU;

	/**
	 * The feature id for the '<em><b>Bounds</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BROWSER__BOUNDS = CONTROL__BOUNDS;

	/**
	 * The feature id for the '<em><b>Border With</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BROWSER__BORDER_WITH = CONTROL__BORDER_WITH;

	/**
	 * The feature id for the '<em><b>Decorators</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BROWSER__DECORATORS = CONTROL__DECORATORS;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BROWSER__TEXT = CONTROL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BROWSER__URI = CONTROL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Plain Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BROWSER__PLAIN_TEXT = CONTROL_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Browser</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BROWSER_FEATURE_COUNT = CONTROL_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Property Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW__PROPERTY_NODES = CONTROL__PROPERTY_NODES;

	/**
	 * The feature id for the '<em><b>Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW__CLASS_NAME = CONTROL__CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Enablement</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW__ENABLEMENT = CONTROL__ENABLEMENT;

	/**
	 * The feature id for the '<em><b>Background Color</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW__BACKGROUND_COLOR = CONTROL__BACKGROUND_COLOR;

	/**
	 * The feature id for the '<em><b>Foreground Color</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW__FOREGROUND_COLOR = CONTROL__FOREGROUND_COLOR;

	/**
	 * The feature id for the '<em><b>Contain Menu</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW__CONTAIN_MENU = CONTROL__CONTAIN_MENU;

	/**
	 * The feature id for the '<em><b>Bounds</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW__BOUNDS = CONTROL__BOUNDS;

	/**
	 * The feature id for the '<em><b>Border With</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW__BORDER_WITH = CONTROL__BORDER_WITH;

	/**
	 * The feature id for the '<em><b>Decorators</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW__DECORATORS = CONTROL__DECORATORS;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW__TITLE = CONTROL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>View</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_FEATURE_COUNT = CONTROL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Property Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDITOR__PROPERTY_NODES = CONTROL__PROPERTY_NODES;

	/**
	 * The feature id for the '<em><b>Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDITOR__CLASS_NAME = CONTROL__CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Enablement</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDITOR__ENABLEMENT = CONTROL__ENABLEMENT;

	/**
	 * The feature id for the '<em><b>Background Color</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDITOR__BACKGROUND_COLOR = CONTROL__BACKGROUND_COLOR;

	/**
	 * The feature id for the '<em><b>Foreground Color</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDITOR__FOREGROUND_COLOR = CONTROL__FOREGROUND_COLOR;

	/**
	 * The feature id for the '<em><b>Contain Menu</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDITOR__CONTAIN_MENU = CONTROL__CONTAIN_MENU;

	/**
	 * The feature id for the '<em><b>Bounds</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDITOR__BOUNDS = CONTROL__BOUNDS;

	/**
	 * The feature id for the '<em><b>Border With</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDITOR__BORDER_WITH = CONTROL__BORDER_WITH;

	/**
	 * The feature id for the '<em><b>Decorators</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDITOR__DECORATORS = CONTROL__DECORATORS;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDITOR__TITLE = CONTROL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Input</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDITOR__INPUT = CONTROL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Dirty</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDITOR__DIRTY = CONTROL_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDITOR__ACTIVE = CONTROL_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Editor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDITOR_FEATURE_COUNT = CONTROL_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Property Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOW__PROPERTY_NODES = CONTROL__PROPERTY_NODES;

	/**
	 * The feature id for the '<em><b>Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOW__CLASS_NAME = CONTROL__CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Enablement</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOW__ENABLEMENT = CONTROL__ENABLEMENT;

	/**
	 * The feature id for the '<em><b>Background Color</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOW__BACKGROUND_COLOR = CONTROL__BACKGROUND_COLOR;

	/**
	 * The feature id for the '<em><b>Foreground Color</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOW__FOREGROUND_COLOR = CONTROL__FOREGROUND_COLOR;

	/**
	 * The feature id for the '<em><b>Contain Menu</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOW__CONTAIN_MENU = CONTROL__CONTAIN_MENU;

	/**
	 * The feature id for the '<em><b>Bounds</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOW__BOUNDS = CONTROL__BOUNDS;

	/**
	 * The feature id for the '<em><b>Border With</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOW__BORDER_WITH = CONTROL__BORDER_WITH;

	/**
	 * The feature id for the '<em><b>Decorators</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOW__DECORATORS = CONTROL__DECORATORS;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOW__TITLE = CONTROL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Sizeable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOW__SIZEABLE = CONTROL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Has Border</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOW__HAS_BORDER = CONTROL_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Has Minimize Button</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOW__HAS_MINIMIZE_BUTTON = CONTROL_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Has Maximize Button</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOW__HAS_MAXIMIZE_BUTTON = CONTROL_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Has Close Button</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOW__HAS_CLOSE_BUTTON = CONTROL_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Is Primary Modal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOW__IS_PRIMARY_MODAL = CONTROL_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Is Application Modal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOW__IS_APPLICATION_MODAL = CONTROL_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Is System Modal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOW__IS_SYSTEM_MODAL = CONTROL_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Is Tool</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOW__IS_TOOL = CONTROL_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Is Sheet</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOW__IS_SHEET = CONTROL_FEATURE_COUNT + 10;

	/**
	 * The number of structural features of the '<em>Window</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOW_FEATURE_COUNT = CONTROL_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Property Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATE_TIME__PROPERTY_NODES = CONTROL__PROPERTY_NODES;

	/**
	 * The feature id for the '<em><b>Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATE_TIME__CLASS_NAME = CONTROL__CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Enablement</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATE_TIME__ENABLEMENT = CONTROL__ENABLEMENT;

	/**
	 * The feature id for the '<em><b>Background Color</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATE_TIME__BACKGROUND_COLOR = CONTROL__BACKGROUND_COLOR;

	/**
	 * The feature id for the '<em><b>Foreground Color</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATE_TIME__FOREGROUND_COLOR = CONTROL__FOREGROUND_COLOR;

	/**
	 * The feature id for the '<em><b>Contain Menu</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATE_TIME__CONTAIN_MENU = CONTROL__CONTAIN_MENU;

	/**
	 * The feature id for the '<em><b>Bounds</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATE_TIME__BOUNDS = CONTROL__BOUNDS;

	/**
	 * The feature id for the '<em><b>Border With</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATE_TIME__BORDER_WITH = CONTROL__BORDER_WITH;

	/**
	 * The feature id for the '<em><b>Decorators</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATE_TIME__DECORATORS = CONTROL__DECORATORS;

	/**
	 * The feature id for the '<em><b>Tooltip</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATE_TIME__TOOLTIP = CONTROL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATE_TIME__DATE = CONTROL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Read Only</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATE_TIME__READ_ONLY = CONTROL_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATE_TIME__TIME = CONTROL_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Date Time</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATE_TIME_FEATURE_COUNT = CONTROL_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Property Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLIDER__PROPERTY_NODES = CONTROL__PROPERTY_NODES;

	/**
	 * The feature id for the '<em><b>Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLIDER__CLASS_NAME = CONTROL__CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Enablement</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLIDER__ENABLEMENT = CONTROL__ENABLEMENT;

	/**
	 * The feature id for the '<em><b>Background Color</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLIDER__BACKGROUND_COLOR = CONTROL__BACKGROUND_COLOR;

	/**
	 * The feature id for the '<em><b>Foreground Color</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLIDER__FOREGROUND_COLOR = CONTROL__FOREGROUND_COLOR;

	/**
	 * The feature id for the '<em><b>Contain Menu</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLIDER__CONTAIN_MENU = CONTROL__CONTAIN_MENU;

	/**
	 * The feature id for the '<em><b>Bounds</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLIDER__BOUNDS = CONTROL__BOUNDS;

	/**
	 * The feature id for the '<em><b>Border With</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLIDER__BORDER_WITH = CONTROL__BORDER_WITH;

	/**
	 * The feature id for the '<em><b>Decorators</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLIDER__DECORATORS = CONTROL__DECORATORS;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLIDER__VALUE = CONTROL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Slider</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLIDER_FEATURE_COUNT = CONTROL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_NODE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_NODE__TYPE = 1;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_NODE__VALUE = 2;

	/**
	 * The number of structural features of the '<em>Property Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_NODE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.ui.impl.FormTextImpl <em>Form Text</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.ui.impl.FormTextImpl
	 * @see org.eclipse.rcptt.tesla.core.ui.impl.UiPackageImpl#getFormText()
	 * @generated
	 */
	int FORM_TEXT = 39;

	/**
	 * The feature id for the '<em><b>Property Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORM_TEXT__PROPERTY_NODES = CONTROL__PROPERTY_NODES;

	/**
	 * The feature id for the '<em><b>Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORM_TEXT__CLASS_NAME = CONTROL__CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Enablement</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORM_TEXT__ENABLEMENT = CONTROL__ENABLEMENT;

	/**
	 * The feature id for the '<em><b>Background Color</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORM_TEXT__BACKGROUND_COLOR = CONTROL__BACKGROUND_COLOR;

	/**
	 * The feature id for the '<em><b>Foreground Color</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORM_TEXT__FOREGROUND_COLOR = CONTROL__FOREGROUND_COLOR;

	/**
	 * The feature id for the '<em><b>Contain Menu</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORM_TEXT__CONTAIN_MENU = CONTROL__CONTAIN_MENU;

	/**
	 * The feature id for the '<em><b>Bounds</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORM_TEXT__BOUNDS = CONTROL__BOUNDS;

	/**
	 * The feature id for the '<em><b>Border With</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORM_TEXT__BORDER_WITH = CONTROL__BORDER_WITH;

	/**
	 * The feature id for the '<em><b>Decorators</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORM_TEXT__DECORATORS = CONTROL__DECORATORS;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORM_TEXT__TEXT = CONTROL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Form Text</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORM_TEXT_FEATURE_COUNT = CONTROL_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.ui.impl.ImageImpl <em>Image</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.ui.impl.ImageImpl
	 * @see org.eclipse.rcptt.tesla.core.ui.impl.UiPackageImpl#getImage()
	 * @generated
	 */
	int IMAGE = 40;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE__PATH = 0;

	/**
	 * The feature id for the '<em><b>Decorations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE__DECORATIONS = 1;

	/**
	 * The number of structural features of the '<em>Image</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.ui.impl.WithImageImpl <em>With Image</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.ui.impl.WithImageImpl
	 * @see org.eclipse.rcptt.tesla.core.ui.impl.UiPackageImpl#getWithImage()
	 * @generated
	 */
	int WITH_IMAGE = 41;

	/**
	 * The feature id for the '<em><b>Image</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WITH_IMAGE__IMAGE = 0;

	/**
	 * The number of structural features of the '<em>With Image</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WITH_IMAGE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.ui.impl.ValuesMapImpl <em>Values Map</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.ui.impl.ValuesMapImpl
	 * @see org.eclipse.rcptt.tesla.core.ui.impl.UiPackageImpl#getValuesMap()
	 * @generated
	 */
	int VALUES_MAP = 42;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUES_MAP__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUES_MAP__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Values Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUES_MAP_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.ui.ButtonKind <em>Button Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.ui.ButtonKind
	 * @see org.eclipse.rcptt.tesla.core.ui.impl.UiPackageImpl#getButtonKind()
	 * @generated
	 */
	int BUTTON_KIND = 43;


	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.core.ui.PropertyNodeType <em>Property Node Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.core.ui.PropertyNodeType
	 * @see org.eclipse.rcptt.tesla.core.ui.impl.UiPackageImpl#getPropertyNodeType()
	 * @generated
	 */
	int PROPERTY_NODE_TYPE = 44;


	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.ui.Widget <em>Widget</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Widget</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.Widget
	 * @generated
	 */
	EClass getWidget();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.ui.Control <em>Control</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Control</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.Control
	 * @generated
	 */
	EClass getControl();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.ui.Control#getClassName <em>Class Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Class Name</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.Control#getClassName()
	 * @see #getControl()
	 * @generated
	 */
	EAttribute getControl_ClassName();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.ui.Control#isEnablement <em>Enablement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enablement</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.Control#isEnablement()
	 * @see #getControl()
	 * @generated
	 */
	EAttribute getControl_Enablement();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.rcptt.tesla.core.ui.Control#getBackgroundColor <em>Background Color</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Background Color</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.Control#getBackgroundColor()
	 * @see #getControl()
	 * @generated
	 */
	EReference getControl_BackgroundColor();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.rcptt.tesla.core.ui.Control#getForegroundColor <em>Foreground Color</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Foreground Color</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.Control#getForegroundColor()
	 * @see #getControl()
	 * @generated
	 */
	EReference getControl_ForegroundColor();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.ui.Control#isContainMenu <em>Contain Menu</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Contain Menu</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.Control#isContainMenu()
	 * @see #getControl()
	 * @generated
	 */
	EAttribute getControl_ContainMenu();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.rcptt.tesla.core.ui.Control#getBounds <em>Bounds</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Bounds</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.Control#getBounds()
	 * @see #getControl()
	 * @generated
	 */
	EReference getControl_Bounds();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.ui.Control#getBorderWith <em>Border With</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Border With</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.Control#getBorderWith()
	 * @see #getControl()
	 * @generated
	 */
	EAttribute getControl_BorderWith();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.rcptt.tesla.core.ui.Control#getDecorators <em>Decorators</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Decorators</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.Control#getDecorators()
	 * @see #getControl()
	 * @generated
	 */
	EReference getControl_Decorators();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.ui.ControlDecorator <em>Control Decorator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Control Decorator</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.ControlDecorator
	 * @generated
	 */
	EClass getControlDecorator();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.ui.ControlDecorator#isVisible <em>Visible</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Visible</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.ControlDecorator#isVisible()
	 * @see #getControlDecorator()
	 * @generated
	 */
	EAttribute getControlDecorator_Visible();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.ui.ControlDecorator#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.ControlDecorator#getDescription()
	 * @see #getControlDecorator()
	 * @generated
	 */
	EAttribute getControlDecorator_Description();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.ui.Button <em>Button</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Button</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.Button
	 * @generated
	 */
	EClass getButton();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.ui.Button#getCaption <em>Caption</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Caption</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.Button#getCaption()
	 * @see #getButton()
	 * @generated
	 */
	EAttribute getButton_Caption();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.ui.Button#getTooltip <em>Tooltip</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tooltip</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.Button#getTooltip()
	 * @see #getButton()
	 * @generated
	 */
	EAttribute getButton_Tooltip();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.ui.Button#isSelected <em>Selected</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Selected</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.Button#isSelected()
	 * @see #getButton()
	 * @generated
	 */
	EAttribute getButton_Selected();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.ui.Button#isGrayed <em>Grayed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Grayed</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.Button#isGrayed()
	 * @see #getButton()
	 * @generated
	 */
	EAttribute getButton_Grayed();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.ui.Button#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.Button#getKind()
	 * @see #getButton()
	 * @generated
	 */
	EAttribute getButton_Kind();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.ui.ToolItem <em>Tool Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tool Item</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.ToolItem
	 * @generated
	 */
	EClass getToolItem();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.ui.ToolItem#getIndex <em>Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Index</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.ToolItem#getIndex()
	 * @see #getToolItem()
	 * @generated
	 */
	EAttribute getToolItem_Index();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.ui.Label <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Label</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.Label
	 * @generated
	 */
	EClass getLabel();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.ui.Label#getCaption <em>Caption</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Caption</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.Label#getCaption()
	 * @see #getLabel()
	 * @generated
	 */
	EAttribute getLabel_Caption();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.ui.Link <em>Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Link</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.Link
	 * @generated
	 */
	EClass getLink();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.ui.Link#getCaption <em>Caption</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Caption</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.Link#getCaption()
	 * @see #getLink()
	 * @generated
	 */
	EAttribute getLink_Caption();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.ui.Link#getToltip <em>Toltip</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Toltip</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.Link#getToltip()
	 * @see #getLink()
	 * @generated
	 */
	EAttribute getLink_Toltip();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.ui.Item <em>Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Item</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.Item
	 * @generated
	 */
	EClass getItem();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.ui.Item#getCaption <em>Caption</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Caption</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.Item#getCaption()
	 * @see #getItem()
	 * @generated
	 */
	EAttribute getItem_Caption();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.ui.Item#isSelection <em>Selection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Selection</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.Item#isSelection()
	 * @see #getItem()
	 * @generated
	 */
	EAttribute getItem_Selection();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.ui.Item#isEnablement <em>Enablement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enablement</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.Item#isEnablement()
	 * @see #getItem()
	 * @generated
	 */
	EAttribute getItem_Enablement();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.ui.Item#getIndex <em>Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Index</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.Item#getIndex()
	 * @see #getItem()
	 * @generated
	 */
	EAttribute getItem_Index();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.ui.MenuItem <em>Menu Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Menu Item</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.MenuItem
	 * @generated
	 */
	EClass getMenuItem();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.ui.MenuItem#getAccelerator <em>Accelerator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Accelerator</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.MenuItem#getAccelerator()
	 * @see #getMenuItem()
	 * @generated
	 */
	EAttribute getMenuItem_Accelerator();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.ui.MenuItem#isCascade <em>Cascade</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cascade</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.MenuItem#isCascade()
	 * @see #getMenuItem()
	 * @generated
	 */
	EAttribute getMenuItem_Cascade();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.ui.TreeItem <em>Tree Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tree Item</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.TreeItem
	 * @generated
	 */
	EClass getTreeItem();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.ui.TreeItem#isSelected <em>Selected</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Selected</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.TreeItem#isSelected()
	 * @see #getTreeItem()
	 * @generated
	 */
	EAttribute getTreeItem_Selected();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.ui.TreeItem#isChecked <em>Checked</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Checked</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.TreeItem#isChecked()
	 * @see #getTreeItem()
	 * @generated
	 */
	EAttribute getTreeItem_Checked();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.rcptt.tesla.core.ui.TreeItem#getBackgroundColor <em>Background Color</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Background Color</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.TreeItem#getBackgroundColor()
	 * @see #getTreeItem()
	 * @generated
	 */
	EReference getTreeItem_BackgroundColor();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.rcptt.tesla.core.ui.TreeItem#getForegroundColor <em>Foreground Color</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Foreground Color</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.TreeItem#getForegroundColor()
	 * @see #getTreeItem()
	 * @generated
	 */
	EReference getTreeItem_ForegroundColor();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.rcptt.tesla.core.ui.TreeItem#getBounds <em>Bounds</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Bounds</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.TreeItem#getBounds()
	 * @see #getTreeItem()
	 * @generated
	 */
	EReference getTreeItem_Bounds();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.ui.TreeItem#getChildCount <em>Child Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Child Count</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.TreeItem#getChildCount()
	 * @see #getTreeItem()
	 * @generated
	 */
	EAttribute getTreeItem_ChildCount();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.rcptt.tesla.core.ui.TreeItem#getColumns <em>Columns</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Columns</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.TreeItem#getColumns()
	 * @see #getTreeItem()
	 * @generated
	 */
	EAttribute getTreeItem_Columns();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.rcptt.tesla.core.ui.TreeItem#getColumnsBackgroundColor <em>Columns Background Color</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Columns Background Color</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.TreeItem#getColumnsBackgroundColor()
	 * @see #getTreeItem()
	 * @generated
	 */
	EReference getTreeItem_ColumnsBackgroundColor();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.rcptt.tesla.core.ui.TreeItem#getColumnsForegroundColor <em>Columns Foreground Color</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Columns Foreground Color</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.TreeItem#getColumnsForegroundColor()
	 * @see #getTreeItem()
	 * @generated
	 */
	EReference getTreeItem_ColumnsForegroundColor();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.rcptt.tesla.core.ui.TreeItem#getStyleRanges <em>Style Ranges</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Style Ranges</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.TreeItem#getStyleRanges()
	 * @see #getTreeItem()
	 * @generated
	 */
	EAttribute getTreeItem_StyleRanges();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.rcptt.tesla.core.ui.TreeItem#getStyles <em>Styles</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Styles</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.TreeItem#getStyles()
	 * @see #getTreeItem()
	 * @generated
	 */
	EReference getTreeItem_Styles();

	/**
	 * Returns the meta object for the map '{@link org.eclipse.rcptt.tesla.core.ui.TreeItem#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Values</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.TreeItem#getValues()
	 * @see #getTreeItem()
	 * @generated
	 */
	EReference getTreeItem_Values();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.ui.TableItem <em>Table Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Table Item</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.TableItem
	 * @generated
	 */
	EClass getTableItem();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.ui.TableItem#isSelected <em>Selected</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Selected</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.TableItem#isSelected()
	 * @see #getTableItem()
	 * @generated
	 */
	EAttribute getTableItem_Selected();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.ui.TableItem#isChecked <em>Checked</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Checked</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.TableItem#isChecked()
	 * @see #getTableItem()
	 * @generated
	 */
	EAttribute getTableItem_Checked();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.rcptt.tesla.core.ui.TableItem#getBackgroundColor <em>Background Color</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Background Color</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.TableItem#getBackgroundColor()
	 * @see #getTableItem()
	 * @generated
	 */
	EReference getTableItem_BackgroundColor();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.rcptt.tesla.core.ui.TableItem#getForegroundColor <em>Foreground Color</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Foreground Color</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.TableItem#getForegroundColor()
	 * @see #getTableItem()
	 * @generated
	 */
	EReference getTableItem_ForegroundColor();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.rcptt.tesla.core.ui.TableItem#getBounds <em>Bounds</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Bounds</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.TableItem#getBounds()
	 * @see #getTableItem()
	 * @generated
	 */
	EReference getTableItem_Bounds();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.rcptt.tesla.core.ui.TableItem#getColumns <em>Columns</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Columns</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.TableItem#getColumns()
	 * @see #getTableItem()
	 * @generated
	 */
	EAttribute getTableItem_Columns();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.rcptt.tesla.core.ui.TableItem#getColumnsBackgroundColor <em>Columns Background Color</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Columns Background Color</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.TableItem#getColumnsBackgroundColor()
	 * @see #getTableItem()
	 * @generated
	 */
	EReference getTableItem_ColumnsBackgroundColor();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.rcptt.tesla.core.ui.TableItem#getColumnsForegroundColor <em>Columns Foreground Color</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Columns Foreground Color</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.TableItem#getColumnsForegroundColor()
	 * @see #getTableItem()
	 * @generated
	 */
	EReference getTableItem_ColumnsForegroundColor();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.rcptt.tesla.core.ui.TableItem#getStyleRanges <em>Style Ranges</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Style Ranges</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.TableItem#getStyleRanges()
	 * @see #getTableItem()
	 * @generated
	 */
	EAttribute getTableItem_StyleRanges();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.rcptt.tesla.core.ui.TableItem#getStyles <em>Styles</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Styles</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.TableItem#getStyles()
	 * @see #getTableItem()
	 * @generated
	 */
	EReference getTableItem_Styles();

	/**
	 * Returns the meta object for the map '{@link org.eclipse.rcptt.tesla.core.ui.TableItem#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Values</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.TableItem#getValues()
	 * @see #getTableItem()
	 * @generated
	 */
	EReference getTableItem_Values();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.ui.Text <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Text</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.Text
	 * @generated
	 */
	EClass getText();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.ui.Text#getTooltip <em>Tooltip</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tooltip</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.Text#getTooltip()
	 * @see #getText()
	 * @generated
	 */
	EAttribute getText_Tooltip();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.ui.Text#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.Text#getValue()
	 * @see #getText()
	 * @generated
	 */
	EAttribute getText_Value();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.ui.Text#isReadOnly <em>Read Only</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Read Only</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.Text#isReadOnly()
	 * @see #getText()
	 * @generated
	 */
	EAttribute getText_ReadOnly();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.ui.Text#getRawValue <em>Raw Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Raw Value</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.Text#getRawValue()
	 * @see #getText()
	 * @generated
	 */
	EAttribute getText_RawValue();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.rcptt.tesla.core.ui.Text#getStyleRanges <em>Style Ranges</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Style Ranges</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.Text#getStyleRanges()
	 * @see #getText()
	 * @generated
	 */
	EAttribute getText_StyleRanges();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.ui.Text#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.Text#getText()
	 * @see #getText()
	 * @generated
	 */
	EAttribute getText_Text();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.rcptt.tesla.core.ui.Text#getStyles <em>Styles</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Styles</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.Text#getStyles()
	 * @see #getText()
	 * @generated
	 */
	EReference getText_Styles();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.rcptt.tesla.core.ui.Text#getCaretPosition <em>Caret Position</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Caret Position</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.Text#getCaretPosition()
	 * @see #getText()
	 * @generated
	 */
	EReference getText_CaretPosition();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.rcptt.tesla.core.ui.Text#getStyleAtCaret <em>Style At Caret</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Style At Caret</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.Text#getStyleAtCaret()
	 * @see #getText()
	 * @generated
	 */
	EReference getText_StyleAtCaret();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.ui.TextPosition <em>Text Position</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Text Position</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.TextPosition
	 * @generated
	 */
	EClass getTextPosition();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.ui.TextPosition#getLine <em>Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Line</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.TextPosition#getLine()
	 * @see #getTextPosition()
	 * @generated
	 */
	EAttribute getTextPosition_Line();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.ui.TextPosition#getColumn <em>Column</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Column</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.TextPosition#getColumn()
	 * @see #getTextPosition()
	 * @generated
	 */
	EAttribute getTextPosition_Column();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.ui.Color <em>Color</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Color</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.Color
	 * @generated
	 */
	EClass getColor();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.ui.Color#getRed <em>Red</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Red</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.Color#getRed()
	 * @see #getColor()
	 * @generated
	 */
	EAttribute getColor_Red();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.ui.Color#getGreen <em>Green</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Green</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.Color#getGreen()
	 * @see #getColor()
	 * @generated
	 */
	EAttribute getColor_Green();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.ui.Color#getBlue <em>Blue</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Blue</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.Color#getBlue()
	 * @see #getColor()
	 * @generated
	 */
	EAttribute getColor_Blue();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.ui.Color#getAlfa <em>Alfa</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Alfa</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.Color#getAlfa()
	 * @see #getColor()
	 * @generated
	 */
	EAttribute getColor_Alfa();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.ui.Point <em>Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Point</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.Point
	 * @generated
	 */
	EClass getPoint();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.ui.Point#getX <em>X</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>X</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.Point#getX()
	 * @see #getPoint()
	 * @generated
	 */
	EAttribute getPoint_X();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.ui.Point#getY <em>Y</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Y</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.Point#getY()
	 * @see #getPoint()
	 * @generated
	 */
	EAttribute getPoint_Y();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.ui.Rectangle <em>Rectangle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rectangle</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.Rectangle
	 * @generated
	 */
	EClass getRectangle();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.ui.Rectangle#getX <em>X</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>X</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.Rectangle#getX()
	 * @see #getRectangle()
	 * @generated
	 */
	EAttribute getRectangle_X();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.ui.Rectangle#getY <em>Y</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Y</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.Rectangle#getY()
	 * @see #getRectangle()
	 * @generated
	 */
	EAttribute getRectangle_Y();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.ui.Rectangle#getWidth <em>Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Width</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.Rectangle#getWidth()
	 * @see #getRectangle()
	 * @generated
	 */
	EAttribute getRectangle_Width();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.ui.Rectangle#getHeight <em>Height</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Height</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.Rectangle#getHeight()
	 * @see #getRectangle()
	 * @generated
	 */
	EAttribute getRectangle_Height();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.ui.Combo <em>Combo</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Combo</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.Combo
	 * @generated
	 */
	EClass getCombo();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.ui.Combo#getTooltip <em>Tooltip</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tooltip</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.Combo#getTooltip()
	 * @see #getCombo()
	 * @generated
	 */
	EAttribute getCombo_Tooltip();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.ui.Combo#getSelection <em>Selection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Selection</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.Combo#getSelection()
	 * @see #getCombo()
	 * @generated
	 */
	EAttribute getCombo_Selection();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.ui.Combo#isReadOnly <em>Read Only</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Read Only</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.Combo#isReadOnly()
	 * @see #getCombo()
	 * @generated
	 */
	EAttribute getCombo_ReadOnly();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.rcptt.tesla.core.ui.Combo#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Values</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.Combo#getValues()
	 * @see #getCombo()
	 * @generated
	 */
	EAttribute getCombo_Values();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.ui.TabFolder <em>Tab Folder</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tab Folder</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.TabFolder
	 * @generated
	 */
	EClass getTabFolder();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.ui.TabFolder#getSelection <em>Selection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Selection</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.TabFolder#getSelection()
	 * @see #getTabFolder()
	 * @generated
	 */
	EAttribute getTabFolder_Selection();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.rcptt.tesla.core.ui.TabFolder#getPages <em>Pages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Pages</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.TabFolder#getPages()
	 * @see #getTabFolder()
	 * @generated
	 */
	EAttribute getTabFolder_Pages();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.ui.TabFolder#getActivePage <em>Active Page</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Active Page</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.TabFolder#getActivePage()
	 * @see #getTabFolder()
	 * @generated
	 */
	EAttribute getTabFolder_ActivePage();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.ui.TabFolder#getTabCount <em>Tab Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tab Count</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.TabFolder#getTabCount()
	 * @see #getTabFolder()
	 * @generated
	 */
	EAttribute getTabFolder_TabCount();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.ui.Composite <em>Composite</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composite</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.Composite
	 * @generated
	 */
	EClass getComposite();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.ui.Composite#getChildCount <em>Child Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Child Count</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.Composite#getChildCount()
	 * @see #getComposite()
	 * @generated
	 */
	EAttribute getComposite_ChildCount();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.ui.Group <em>Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Group</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.Group
	 * @generated
	 */
	EClass getGroup();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.ui.Group#getCaption <em>Caption</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Caption</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.Group#getCaption()
	 * @see #getGroup()
	 * @generated
	 */
	EAttribute getGroup_Caption();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.ui.ExpandableComposite <em>Expandable Composite</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expandable Composite</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.ExpandableComposite
	 * @generated
	 */
	EClass getExpandableComposite();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.ui.ExpandableComposite#getCaption <em>Caption</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Caption</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.ExpandableComposite#getCaption()
	 * @see #getExpandableComposite()
	 * @generated
	 */
	EAttribute getExpandableComposite_Caption();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.ui.ExpandableComposite#isExpanded <em>Expanded</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Expanded</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.ExpandableComposite#isExpanded()
	 * @see #getExpandableComposite()
	 * @generated
	 */
	EAttribute getExpandableComposite_Expanded();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.ui.Tree <em>Tree</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tree</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.Tree
	 * @generated
	 */
	EClass getTree();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.rcptt.tesla.core.ui.Tree#getColumns <em>Columns</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Columns</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.Tree#getColumns()
	 * @see #getTree()
	 * @generated
	 */
	EReference getTree_Columns();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.ui.Tree#isLinesVisible <em>Lines Visible</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lines Visible</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.Tree#isLinesVisible()
	 * @see #getTree()
	 * @generated
	 */
	EAttribute getTree_LinesVisible();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.rcptt.tesla.core.ui.Tree#getSelection <em>Selection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Selection</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.Tree#getSelection()
	 * @see #getTree()
	 * @generated
	 */
	EReference getTree_Selection();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.ui.Tree#isMultiSelection <em>Multi Selection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Multi Selection</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.Tree#isMultiSelection()
	 * @see #getTree()
	 * @generated
	 */
	EAttribute getTree_MultiSelection();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.ui.Tree#isHeaderVisible <em>Header Visible</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Header Visible</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.Tree#isHeaderVisible()
	 * @see #getTree()
	 * @generated
	 */
	EAttribute getTree_HeaderVisible();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.ui.Tree#getItemCount <em>Item Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Item Count</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.Tree#getItemCount()
	 * @see #getTree()
	 * @generated
	 */
	EAttribute getTree_ItemCount();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.ui.Table <em>Table</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Table</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.Table
	 * @generated
	 */
	EClass getTable();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.rcptt.tesla.core.ui.Table#getColumns <em>Columns</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Columns</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.Table#getColumns()
	 * @see #getTable()
	 * @generated
	 */
	EReference getTable_Columns();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.ui.Table#isLinesVisible <em>Lines Visible</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lines Visible</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.Table#isLinesVisible()
	 * @see #getTable()
	 * @generated
	 */
	EAttribute getTable_LinesVisible();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.rcptt.tesla.core.ui.Table#getSelection <em>Selection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Selection</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.Table#getSelection()
	 * @see #getTable()
	 * @generated
	 */
	EReference getTable_Selection();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.ui.Table#isMultiSelection <em>Multi Selection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Multi Selection</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.Table#isMultiSelection()
	 * @see #getTable()
	 * @generated
	 */
	EAttribute getTable_MultiSelection();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.ui.Table#isHeaderVisible <em>Header Visible</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Header Visible</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.Table#isHeaderVisible()
	 * @see #getTable()
	 * @generated
	 */
	EAttribute getTable_HeaderVisible();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.ui.Table#getItemCount <em>Item Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Item Count</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.Table#getItemCount()
	 * @see #getTable()
	 * @generated
	 */
	EAttribute getTable_ItemCount();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.ui.ViewerColumn <em>Viewer Column</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Viewer Column</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.ViewerColumn
	 * @generated
	 */
	EClass getViewerColumn();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.ui.ViewerColumn#isResizable <em>Resizable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Resizable</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.ViewerColumn#isResizable()
	 * @see #getViewerColumn()
	 * @generated
	 */
	EAttribute getViewerColumn_Resizable();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.ui.ViewerColumn#isMovable <em>Movable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Movable</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.ViewerColumn#isMovable()
	 * @see #getViewerColumn()
	 * @generated
	 */
	EAttribute getViewerColumn_Movable();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.ui.ViewerColumn#getWidth <em>Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Width</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.ViewerColumn#getWidth()
	 * @see #getViewerColumn()
	 * @generated
	 */
	EAttribute getViewerColumn_Width();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.ui.ViewerColumn#getTooltip <em>Tooltip</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tooltip</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.ViewerColumn#getTooltip()
	 * @see #getViewerColumn()
	 * @generated
	 */
	EAttribute getViewerColumn_Tooltip();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.ui.Selection <em>Selection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Selection</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.Selection
	 * @generated
	 */
	EClass getSelection();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.rcptt.tesla.core.ui.Selection#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Path</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.Selection#getPath()
	 * @see #getSelection()
	 * @generated
	 */
	EAttribute getSelection_Path();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.ui.DiagramItem <em>Diagram Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Diagram Item</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.DiagramItem
	 * @generated
	 */
	EClass getDiagramItem();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.ui.DiagramItem#getX <em>X</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>X</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.DiagramItem#getX()
	 * @see #getDiagramItem()
	 * @generated
	 */
	EAttribute getDiagramItem_X();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.ui.DiagramItem#getY <em>Y</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Y</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.DiagramItem#getY()
	 * @see #getDiagramItem()
	 * @generated
	 */
	EAttribute getDiagramItem_Y();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.ui.DiagramItem#getWidth <em>Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Width</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.DiagramItem#getWidth()
	 * @see #getDiagramItem()
	 * @generated
	 */
	EAttribute getDiagramItem_Width();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.ui.DiagramItem#getHeight <em>Height</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Height</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.DiagramItem#getHeight()
	 * @see #getDiagramItem()
	 * @generated
	 */
	EAttribute getDiagramItem_Height();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.ui.DiagramItem#getTooltip <em>Tooltip</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tooltip</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.DiagramItem#getTooltip()
	 * @see #getDiagramItem()
	 * @generated
	 */
	EAttribute getDiagramItem_Tooltip();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.ui.DiagramItem#getChildrenCount <em>Children Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Children Count</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.DiagramItem#getChildrenCount()
	 * @see #getDiagramItem()
	 * @generated
	 */
	EAttribute getDiagramItem_ChildrenCount();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.ui.DiagramItem#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.DiagramItem#getText()
	 * @see #getDiagramItem()
	 * @generated
	 */
	EAttribute getDiagramItem_Text();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.rcptt.tesla.core.ui.DiagramItem#getBackgroundColor <em>Background Color</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Background Color</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.DiagramItem#getBackgroundColor()
	 * @see #getDiagramItem()
	 * @generated
	 */
	EReference getDiagramItem_BackgroundColor();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.rcptt.tesla.core.ui.DiagramItem#getForegroundColor <em>Foreground Color</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Foreground Color</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.DiagramItem#getForegroundColor()
	 * @see #getDiagramItem()
	 * @generated
	 */
	EReference getDiagramItem_ForegroundColor();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.rcptt.tesla.core.ui.DiagramItem#getModelPropertyNodes <em>Model Property Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Model Property Nodes</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.DiagramItem#getModelPropertyNodes()
	 * @see #getDiagramItem()
	 * @generated
	 */
	EReference getDiagramItem_ModelPropertyNodes();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.ui.DiagramItem#getItemAddress <em>Item Address</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Item Address</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.DiagramItem#getItemAddress()
	 * @see #getDiagramItem()
	 * @generated
	 */
	EAttribute getDiagramItem_ItemAddress();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.ui.DiagramItem#isSelected <em>Selected</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Selected</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.DiagramItem#isSelected()
	 * @see #getDiagramItem()
	 * @generated
	 */
	EAttribute getDiagramItem_Selected();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.ui.DiagramItem#getClassName <em>Class Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Class Name</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.DiagramItem#getClassName()
	 * @see #getDiagramItem()
	 * @generated
	 */
	EAttribute getDiagramItem_ClassName();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.ui.DiagramConnection <em>Diagram Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Diagram Connection</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.DiagramConnection
	 * @generated
	 */
	EClass getDiagramConnection();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.rcptt.tesla.core.ui.DiagramConnection#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Source</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.DiagramConnection#getSource()
	 * @see #getDiagramConnection()
	 * @generated
	 */
	EReference getDiagramConnection_Source();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.rcptt.tesla.core.ui.DiagramConnection#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Target</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.DiagramConnection#getTarget()
	 * @see #getDiagramConnection()
	 * @generated
	 */
	EReference getDiagramConnection_Target();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.ui.PropertyEntry <em>Property Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property Entry</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.PropertyEntry
	 * @generated
	 */
	EClass getPropertyEntry();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.ui.PropertyEntry#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.PropertyEntry#getName()
	 * @see #getPropertyEntry()
	 * @generated
	 */
	EAttribute getPropertyEntry_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.ui.PropertyEntry#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.PropertyEntry#getValue()
	 * @see #getPropertyEntry()
	 * @generated
	 */
	EAttribute getPropertyEntry_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.ui.PropertyMap <em>Property Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property Map</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.PropertyMap
	 * @generated
	 */
	EClass getPropertyMap();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.rcptt.tesla.core.ui.PropertyMap#get__properties <em>properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>properties</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.PropertyMap#get__properties()
	 * @see #getPropertyMap()
	 * @generated
	 */
	EReference getPropertyMap___properties();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.ui.PropertyWidget <em>Property Widget</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property Widget</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.PropertyWidget
	 * @generated
	 */
	EClass getPropertyWidget();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.ui.Browser <em>Browser</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Browser</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.Browser
	 * @generated
	 */
	EClass getBrowser();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.ui.Browser#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.Browser#getText()
	 * @see #getBrowser()
	 * @generated
	 */
	EAttribute getBrowser_Text();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.ui.Browser#getUri <em>Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Uri</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.Browser#getUri()
	 * @see #getBrowser()
	 * @generated
	 */
	EAttribute getBrowser_Uri();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.ui.Browser#getPlainText <em>Plain Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Plain Text</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.Browser#getPlainText()
	 * @see #getBrowser()
	 * @generated
	 */
	EAttribute getBrowser_PlainText();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.ui.View <em>View</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>View</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.View
	 * @generated
	 */
	EClass getView();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.ui.View#getTitle <em>Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Title</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.View#getTitle()
	 * @see #getView()
	 * @generated
	 */
	EAttribute getView_Title();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.ui.Editor <em>Editor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Editor</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.Editor
	 * @generated
	 */
	EClass getEditor();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.ui.Editor#getTitle <em>Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Title</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.Editor#getTitle()
	 * @see #getEditor()
	 * @generated
	 */
	EAttribute getEditor_Title();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.ui.Editor#getInput <em>Input</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Input</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.Editor#getInput()
	 * @see #getEditor()
	 * @generated
	 */
	EAttribute getEditor_Input();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.ui.Editor#isDirty <em>Dirty</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dirty</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.Editor#isDirty()
	 * @see #getEditor()
	 * @generated
	 */
	EAttribute getEditor_Dirty();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.ui.Editor#isActive <em>Active</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Active</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.Editor#isActive()
	 * @see #getEditor()
	 * @generated
	 */
	EAttribute getEditor_Active();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.ui.Window <em>Window</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Window</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.Window
	 * @generated
	 */
	EClass getWindow();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.ui.Window#getTitle <em>Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Title</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.Window#getTitle()
	 * @see #getWindow()
	 * @generated
	 */
	EAttribute getWindow_Title();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.ui.Window#isSizeable <em>Sizeable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sizeable</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.Window#isSizeable()
	 * @see #getWindow()
	 * @generated
	 */
	EAttribute getWindow_Sizeable();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.ui.Window#isIsPrimaryModal <em>Is Primary Modal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Primary Modal</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.Window#isIsPrimaryModal()
	 * @see #getWindow()
	 * @generated
	 */
	EAttribute getWindow_IsPrimaryModal();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.ui.Window#isIsApplicationModal <em>Is Application Modal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Application Modal</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.Window#isIsApplicationModal()
	 * @see #getWindow()
	 * @generated
	 */
	EAttribute getWindow_IsApplicationModal();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.ui.Window#isIsSystemModal <em>Is System Modal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is System Modal</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.Window#isIsSystemModal()
	 * @see #getWindow()
	 * @generated
	 */
	EAttribute getWindow_IsSystemModal();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.ui.Window#isIsTool <em>Is Tool</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Tool</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.Window#isIsTool()
	 * @see #getWindow()
	 * @generated
	 */
	EAttribute getWindow_IsTool();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.ui.Window#isIsSheet <em>Is Sheet</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Sheet</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.Window#isIsSheet()
	 * @see #getWindow()
	 * @generated
	 */
	EAttribute getWindow_IsSheet();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.ui.Window#isHasCloseButton <em>Has Close Button</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Has Close Button</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.Window#isHasCloseButton()
	 * @see #getWindow()
	 * @generated
	 */
	EAttribute getWindow_HasCloseButton();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.ui.Window#isHasMinimizeButton <em>Has Minimize Button</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Has Minimize Button</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.Window#isHasMinimizeButton()
	 * @see #getWindow()
	 * @generated
	 */
	EAttribute getWindow_HasMinimizeButton();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.ui.Window#isHasMaximizeButton <em>Has Maximize Button</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Has Maximize Button</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.Window#isHasMaximizeButton()
	 * @see #getWindow()
	 * @generated
	 */
	EAttribute getWindow_HasMaximizeButton();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.ui.Window#isHasBorder <em>Has Border</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Has Border</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.Window#isHasBorder()
	 * @see #getWindow()
	 * @generated
	 */
	EAttribute getWindow_HasBorder();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.ui.DateTime <em>Date Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Date Time</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.DateTime
	 * @generated
	 */
	EClass getDateTime();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.ui.DateTime#getTooltip <em>Tooltip</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tooltip</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.DateTime#getTooltip()
	 * @see #getDateTime()
	 * @generated
	 */
	EAttribute getDateTime_Tooltip();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.ui.DateTime#getDate <em>Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Date</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.DateTime#getDate()
	 * @see #getDateTime()
	 * @generated
	 */
	EAttribute getDateTime_Date();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.ui.DateTime#isReadOnly <em>Read Only</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Read Only</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.DateTime#isReadOnly()
	 * @see #getDateTime()
	 * @generated
	 */
	EAttribute getDateTime_ReadOnly();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.ui.DateTime#getTime <em>Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Time</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.DateTime#getTime()
	 * @see #getDateTime()
	 * @generated
	 */
	EAttribute getDateTime_Time();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.ui.Slider <em>Slider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Slider</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.Slider
	 * @generated
	 */
	EClass getSlider();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.ui.Slider#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.Slider#getValue()
	 * @see #getSlider()
	 * @generated
	 */
	EAttribute getSlider_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.ui.PropertyNode <em>Property Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property Node</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.PropertyNode
	 * @generated
	 */
	EClass getPropertyNode();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.ui.PropertyNode#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.PropertyNode#getName()
	 * @see #getPropertyNode()
	 * @generated
	 */
	EAttribute getPropertyNode_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.ui.PropertyNode#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.PropertyNode#getType()
	 * @see #getPropertyNode()
	 * @generated
	 */
	EAttribute getPropertyNode_Type();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.ui.PropertyNode#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.PropertyNode#getValue()
	 * @see #getPropertyNode()
	 * @generated
	 */
	EAttribute getPropertyNode_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.ui.PropertyNodeList <em>Property Node List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property Node List</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.PropertyNodeList
	 * @generated
	 */
	EClass getPropertyNodeList();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.rcptt.tesla.core.ui.PropertyNodeList#getPropertyNodes <em>Property Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Property Nodes</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.PropertyNodeList#getPropertyNodes()
	 * @see #getPropertyNodeList()
	 * @generated
	 */
	EReference getPropertyNodeList_PropertyNodes();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.ui.FormText <em>Form Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Form Text</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.FormText
	 * @generated
	 */
	EClass getFormText();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.ui.FormText#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.FormText#getText()
	 * @see #getFormText()
	 * @generated
	 */
	EAttribute getFormText_Text();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.ui.Image <em>Image</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Image</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.Image
	 * @generated
	 */
	EClass getImage();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.ui.Image#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Path</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.Image#getPath()
	 * @see #getImage()
	 * @generated
	 */
	EAttribute getImage_Path();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.rcptt.tesla.core.ui.Image#getDecorations <em>Decorations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Decorations</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.Image#getDecorations()
	 * @see #getImage()
	 * @generated
	 */
	EReference getImage_Decorations();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.ui.WithImage <em>With Image</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>With Image</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.WithImage
	 * @generated
	 */
	EClass getWithImage();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.rcptt.tesla.core.ui.WithImage#getImage <em>Image</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Image</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.WithImage#getImage()
	 * @see #getWithImage()
	 * @generated
	 */
	EReference getWithImage_Image();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>Values Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Values Map</em>'.
	 * @see java.util.Map.Entry
	 * @model keyDataType="org.eclipse.emf.ecore.EString"
	 *        valueDataType="org.eclipse.emf.ecore.EString"
	 * @generated
	 */
	EClass getValuesMap();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getValuesMap()
	 * @generated
	 */
	EAttribute getValuesMap_Key();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getValuesMap()
	 * @generated
	 */
	EAttribute getValuesMap_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.core.ui.StyleRangeEntry <em>Style Range Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Style Range Entry</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.StyleRangeEntry
	 * @generated
	 */
	EClass getStyleRangeEntry();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.ui.StyleRangeEntry#getStart <em>Start</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.StyleRangeEntry#getStart()
	 * @see #getStyleRangeEntry()
	 * @generated
	 */
	EAttribute getStyleRangeEntry_Start();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.ui.StyleRangeEntry#getLength <em>Length</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Length</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.StyleRangeEntry#getLength()
	 * @see #getStyleRangeEntry()
	 * @generated
	 */
	EAttribute getStyleRangeEntry_Length();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.ui.StyleRangeEntry#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.StyleRangeEntry#getText()
	 * @see #getStyleRangeEntry()
	 * @generated
	 */
	EAttribute getStyleRangeEntry_Text();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.ui.StyleRangeEntry#getFontStyle <em>Font Style</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Font Style</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.StyleRangeEntry#getFontStyle()
	 * @see #getStyleRangeEntry()
	 * @generated
	 */
	EAttribute getStyleRangeEntry_FontStyle();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.ui.StyleRangeEntry#getFont <em>Font</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Font</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.StyleRangeEntry#getFont()
	 * @see #getStyleRangeEntry()
	 * @generated
	 */
	EAttribute getStyleRangeEntry_Font();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.rcptt.tesla.core.ui.StyleRangeEntry#getForegroundColor <em>Foreground Color</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Foreground Color</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.StyleRangeEntry#getForegroundColor()
	 * @see #getStyleRangeEntry()
	 * @generated
	 */
	EReference getStyleRangeEntry_ForegroundColor();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.rcptt.tesla.core.ui.StyleRangeEntry#getBackgroundColor <em>Background Color</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Background Color</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.StyleRangeEntry#getBackgroundColor()
	 * @see #getStyleRangeEntry()
	 * @generated
	 */
	EReference getStyleRangeEntry_BackgroundColor();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.ui.StyleRangeEntry#getUnderline <em>Underline</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Underline</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.StyleRangeEntry#getUnderline()
	 * @see #getStyleRangeEntry()
	 * @generated
	 */
	EAttribute getStyleRangeEntry_Underline();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.rcptt.tesla.core.ui.StyleRangeEntry#getUnderlineColor <em>Underline Color</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Underline Color</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.StyleRangeEntry#getUnderlineColor()
	 * @see #getStyleRangeEntry()
	 * @generated
	 */
	EReference getStyleRangeEntry_UnderlineColor();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.ui.StyleRangeEntry#getStrikeout <em>Strikeout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Strikeout</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.StyleRangeEntry#getStrikeout()
	 * @see #getStyleRangeEntry()
	 * @generated
	 */
	EAttribute getStyleRangeEntry_Strikeout();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.rcptt.tesla.core.ui.StyleRangeEntry#getStrikeoutColor <em>Strikeout Color</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Strikeout Color</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.StyleRangeEntry#getStrikeoutColor()
	 * @see #getStyleRangeEntry()
	 * @generated
	 */
	EReference getStyleRangeEntry_StrikeoutColor();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.ui.StyleRangeEntry#getBorderStyle <em>Border Style</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Border Style</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.StyleRangeEntry#getBorderStyle()
	 * @see #getStyleRangeEntry()
	 * @generated
	 */
	EAttribute getStyleRangeEntry_BorderStyle();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.rcptt.tesla.core.ui.StyleRangeEntry#getBorderColor <em>Border Color</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Border Color</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.StyleRangeEntry#getBorderColor()
	 * @see #getStyleRangeEntry()
	 * @generated
	 */
	EReference getStyleRangeEntry_BorderColor();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.ui.StyleRangeEntry#getRise <em>Rise</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rise</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.StyleRangeEntry#getRise()
	 * @see #getStyleRangeEntry()
	 * @generated
	 */
	EAttribute getStyleRangeEntry_Rise();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.tesla.core.ui.StyleRangeEntry#getMetrics <em>Metrics</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Metrics</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.StyleRangeEntry#getMetrics()
	 * @see #getStyleRangeEntry()
	 * @generated
	 */
	EAttribute getStyleRangeEntry_Metrics();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.rcptt.tesla.core.ui.StyleRangeEntry#getStartPos <em>Start Pos</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Start Pos</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.StyleRangeEntry#getStartPos()
	 * @see #getStyleRangeEntry()
	 * @generated
	 */
	EReference getStyleRangeEntry_StartPos();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.rcptt.tesla.core.ui.StyleRangeEntry#getEndPos <em>End Pos</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>End Pos</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.StyleRangeEntry#getEndPos()
	 * @see #getStyleRangeEntry()
	 * @generated
	 */
	EReference getStyleRangeEntry_EndPos();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.rcptt.tesla.core.ui.ButtonKind <em>Button Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Button Kind</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.ButtonKind
	 * @generated
	 */
	EEnum getButtonKind();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.rcptt.tesla.core.ui.PropertyNodeType <em>Property Node Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Property Node Type</em>'.
	 * @see org.eclipse.rcptt.tesla.core.ui.PropertyNodeType
	 * @generated
	 */
	EEnum getPropertyNodeType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	UiFactory getUiFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.ui.impl.WidgetImpl <em>Widget</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.ui.impl.WidgetImpl
		 * @see org.eclipse.rcptt.tesla.core.ui.impl.UiPackageImpl#getWidget()
		 * @generated
		 */
		EClass WIDGET = eINSTANCE.getWidget();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.ui.impl.ControlImpl <em>Control</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.ui.impl.ControlImpl
		 * @see org.eclipse.rcptt.tesla.core.ui.impl.UiPackageImpl#getControl()
		 * @generated
		 */
		EClass CONTROL = eINSTANCE.getControl();

		/**
		 * The meta object literal for the '<em><b>Class Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTROL__CLASS_NAME = eINSTANCE.getControl_ClassName();

		/**
		 * The meta object literal for the '<em><b>Enablement</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTROL__ENABLEMENT = eINSTANCE.getControl_Enablement();

		/**
		 * The meta object literal for the '<em><b>Background Color</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTROL__BACKGROUND_COLOR = eINSTANCE.getControl_BackgroundColor();

		/**
		 * The meta object literal for the '<em><b>Foreground Color</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTROL__FOREGROUND_COLOR = eINSTANCE.getControl_ForegroundColor();

		/**
		 * The meta object literal for the '<em><b>Contain Menu</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTROL__CONTAIN_MENU = eINSTANCE.getControl_ContainMenu();

		/**
		 * The meta object literal for the '<em><b>Bounds</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTROL__BOUNDS = eINSTANCE.getControl_Bounds();

		/**
		 * The meta object literal for the '<em><b>Border With</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTROL__BORDER_WITH = eINSTANCE.getControl_BorderWith();

		/**
		 * The meta object literal for the '<em><b>Decorators</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTROL__DECORATORS = eINSTANCE.getControl_Decorators();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.ui.impl.ControlDecoratorImpl <em>Control Decorator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.ui.impl.ControlDecoratorImpl
		 * @see org.eclipse.rcptt.tesla.core.ui.impl.UiPackageImpl#getControlDecorator()
		 * @generated
		 */
		EClass CONTROL_DECORATOR = eINSTANCE.getControlDecorator();

		/**
		 * The meta object literal for the '<em><b>Visible</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTROL_DECORATOR__VISIBLE = eINSTANCE.getControlDecorator_Visible();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTROL_DECORATOR__DESCRIPTION = eINSTANCE.getControlDecorator_Description();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.ui.impl.ButtonImpl <em>Button</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.ui.impl.ButtonImpl
		 * @see org.eclipse.rcptt.tesla.core.ui.impl.UiPackageImpl#getButton()
		 * @generated
		 */
		EClass BUTTON = eINSTANCE.getButton();

		/**
		 * The meta object literal for the '<em><b>Caption</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUTTON__CAPTION = eINSTANCE.getButton_Caption();

		/**
		 * The meta object literal for the '<em><b>Tooltip</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUTTON__TOOLTIP = eINSTANCE.getButton_Tooltip();

		/**
		 * The meta object literal for the '<em><b>Selected</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUTTON__SELECTED = eINSTANCE.getButton_Selected();

		/**
		 * The meta object literal for the '<em><b>Grayed</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUTTON__GRAYED = eINSTANCE.getButton_Grayed();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUTTON__KIND = eINSTANCE.getButton_Kind();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.ui.impl.ToolItemImpl <em>Tool Item</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.ui.impl.ToolItemImpl
		 * @see org.eclipse.rcptt.tesla.core.ui.impl.UiPackageImpl#getToolItem()
		 * @generated
		 */
		EClass TOOL_ITEM = eINSTANCE.getToolItem();

		/**
		 * The meta object literal for the '<em><b>Index</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TOOL_ITEM__INDEX = eINSTANCE.getToolItem_Index();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.ui.impl.LabelImpl <em>Label</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.ui.impl.LabelImpl
		 * @see org.eclipse.rcptt.tesla.core.ui.impl.UiPackageImpl#getLabel()
		 * @generated
		 */
		EClass LABEL = eINSTANCE.getLabel();

		/**
		 * The meta object literal for the '<em><b>Caption</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LABEL__CAPTION = eINSTANCE.getLabel_Caption();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.ui.impl.LinkImpl <em>Link</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.ui.impl.LinkImpl
		 * @see org.eclipse.rcptt.tesla.core.ui.impl.UiPackageImpl#getLink()
		 * @generated
		 */
		EClass LINK = eINSTANCE.getLink();

		/**
		 * The meta object literal for the '<em><b>Caption</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LINK__CAPTION = eINSTANCE.getLink_Caption();

		/**
		 * The meta object literal for the '<em><b>Toltip</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LINK__TOLTIP = eINSTANCE.getLink_Toltip();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.ui.impl.ItemImpl <em>Item</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.ui.impl.ItemImpl
		 * @see org.eclipse.rcptt.tesla.core.ui.impl.UiPackageImpl#getItem()
		 * @generated
		 */
		EClass ITEM = eINSTANCE.getItem();

		/**
		 * The meta object literal for the '<em><b>Caption</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ITEM__CAPTION = eINSTANCE.getItem_Caption();

		/**
		 * The meta object literal for the '<em><b>Selection</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ITEM__SELECTION = eINSTANCE.getItem_Selection();

		/**
		 * The meta object literal for the '<em><b>Enablement</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ITEM__ENABLEMENT = eINSTANCE.getItem_Enablement();

		/**
		 * The meta object literal for the '<em><b>Index</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ITEM__INDEX = eINSTANCE.getItem_Index();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.ui.impl.MenuItemImpl <em>Menu Item</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.ui.impl.MenuItemImpl
		 * @see org.eclipse.rcptt.tesla.core.ui.impl.UiPackageImpl#getMenuItem()
		 * @generated
		 */
		EClass MENU_ITEM = eINSTANCE.getMenuItem();

		/**
		 * The meta object literal for the '<em><b>Accelerator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MENU_ITEM__ACCELERATOR = eINSTANCE.getMenuItem_Accelerator();

		/**
		 * The meta object literal for the '<em><b>Cascade</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MENU_ITEM__CASCADE = eINSTANCE.getMenuItem_Cascade();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.ui.impl.TreeItemImpl <em>Tree Item</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.ui.impl.TreeItemImpl
		 * @see org.eclipse.rcptt.tesla.core.ui.impl.UiPackageImpl#getTreeItem()
		 * @generated
		 */
		EClass TREE_ITEM = eINSTANCE.getTreeItem();

		/**
		 * The meta object literal for the '<em><b>Selected</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TREE_ITEM__SELECTED = eINSTANCE.getTreeItem_Selected();

		/**
		 * The meta object literal for the '<em><b>Checked</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TREE_ITEM__CHECKED = eINSTANCE.getTreeItem_Checked();

		/**
		 * The meta object literal for the '<em><b>Background Color</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TREE_ITEM__BACKGROUND_COLOR = eINSTANCE.getTreeItem_BackgroundColor();

		/**
		 * The meta object literal for the '<em><b>Foreground Color</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TREE_ITEM__FOREGROUND_COLOR = eINSTANCE.getTreeItem_ForegroundColor();

		/**
		 * The meta object literal for the '<em><b>Bounds</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TREE_ITEM__BOUNDS = eINSTANCE.getTreeItem_Bounds();

		/**
		 * The meta object literal for the '<em><b>Child Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TREE_ITEM__CHILD_COUNT = eINSTANCE.getTreeItem_ChildCount();

		/**
		 * The meta object literal for the '<em><b>Columns</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TREE_ITEM__COLUMNS = eINSTANCE.getTreeItem_Columns();

		/**
		 * The meta object literal for the '<em><b>Columns Background Color</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TREE_ITEM__COLUMNS_BACKGROUND_COLOR = eINSTANCE.getTreeItem_ColumnsBackgroundColor();

		/**
		 * The meta object literal for the '<em><b>Columns Foreground Color</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TREE_ITEM__COLUMNS_FOREGROUND_COLOR = eINSTANCE.getTreeItem_ColumnsForegroundColor();

		/**
		 * The meta object literal for the '<em><b>Style Ranges</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TREE_ITEM__STYLE_RANGES = eINSTANCE.getTreeItem_StyleRanges();

		/**
		 * The meta object literal for the '<em><b>Styles</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TREE_ITEM__STYLES = eINSTANCE.getTreeItem_Styles();

		/**
		 * The meta object literal for the '<em><b>Values</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TREE_ITEM__VALUES = eINSTANCE.getTreeItem_Values();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.ui.impl.TableItemImpl <em>Table Item</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.ui.impl.TableItemImpl
		 * @see org.eclipse.rcptt.tesla.core.ui.impl.UiPackageImpl#getTableItem()
		 * @generated
		 */
		EClass TABLE_ITEM = eINSTANCE.getTableItem();

		/**
		 * The meta object literal for the '<em><b>Selected</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TABLE_ITEM__SELECTED = eINSTANCE.getTableItem_Selected();

		/**
		 * The meta object literal for the '<em><b>Checked</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TABLE_ITEM__CHECKED = eINSTANCE.getTableItem_Checked();

		/**
		 * The meta object literal for the '<em><b>Background Color</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TABLE_ITEM__BACKGROUND_COLOR = eINSTANCE.getTableItem_BackgroundColor();

		/**
		 * The meta object literal for the '<em><b>Foreground Color</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TABLE_ITEM__FOREGROUND_COLOR = eINSTANCE.getTableItem_ForegroundColor();

		/**
		 * The meta object literal for the '<em><b>Bounds</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TABLE_ITEM__BOUNDS = eINSTANCE.getTableItem_Bounds();

		/**
		 * The meta object literal for the '<em><b>Columns</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TABLE_ITEM__COLUMNS = eINSTANCE.getTableItem_Columns();

		/**
		 * The meta object literal for the '<em><b>Columns Background Color</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TABLE_ITEM__COLUMNS_BACKGROUND_COLOR = eINSTANCE.getTableItem_ColumnsBackgroundColor();

		/**
		 * The meta object literal for the '<em><b>Columns Foreground Color</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TABLE_ITEM__COLUMNS_FOREGROUND_COLOR = eINSTANCE.getTableItem_ColumnsForegroundColor();

		/**
		 * The meta object literal for the '<em><b>Style Ranges</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TABLE_ITEM__STYLE_RANGES = eINSTANCE.getTableItem_StyleRanges();

		/**
		 * The meta object literal for the '<em><b>Styles</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TABLE_ITEM__STYLES = eINSTANCE.getTableItem_Styles();

		/**
		 * The meta object literal for the '<em><b>Values</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TABLE_ITEM__VALUES = eINSTANCE.getTableItem_Values();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.ui.impl.TextImpl <em>Text</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.ui.impl.TextImpl
		 * @see org.eclipse.rcptt.tesla.core.ui.impl.UiPackageImpl#getText()
		 * @generated
		 */
		EClass TEXT = eINSTANCE.getText();

		/**
		 * The meta object literal for the '<em><b>Tooltip</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEXT__TOOLTIP = eINSTANCE.getText_Tooltip();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEXT__VALUE = eINSTANCE.getText_Value();

		/**
		 * The meta object literal for the '<em><b>Read Only</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEXT__READ_ONLY = eINSTANCE.getText_ReadOnly();

		/**
		 * The meta object literal for the '<em><b>Raw Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEXT__RAW_VALUE = eINSTANCE.getText_RawValue();

		/**
		 * The meta object literal for the '<em><b>Style Ranges</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEXT__STYLE_RANGES = eINSTANCE.getText_StyleRanges();

		/**
		 * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEXT__TEXT = eINSTANCE.getText_Text();

		/**
		 * The meta object literal for the '<em><b>Styles</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEXT__STYLES = eINSTANCE.getText_Styles();

		/**
		 * The meta object literal for the '<em><b>Caret Position</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEXT__CARET_POSITION = eINSTANCE.getText_CaretPosition();

		/**
		 * The meta object literal for the '<em><b>Style At Caret</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEXT__STYLE_AT_CARET = eINSTANCE.getText_StyleAtCaret();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.ui.impl.TextPositionImpl <em>Text Position</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.ui.impl.TextPositionImpl
		 * @see org.eclipse.rcptt.tesla.core.ui.impl.UiPackageImpl#getTextPosition()
		 * @generated
		 */
		EClass TEXT_POSITION = eINSTANCE.getTextPosition();

		/**
		 * The meta object literal for the '<em><b>Line</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEXT_POSITION__LINE = eINSTANCE.getTextPosition_Line();

		/**
		 * The meta object literal for the '<em><b>Column</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEXT_POSITION__COLUMN = eINSTANCE.getTextPosition_Column();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.ui.impl.ColorImpl <em>Color</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.ui.impl.ColorImpl
		 * @see org.eclipse.rcptt.tesla.core.ui.impl.UiPackageImpl#getColor()
		 * @generated
		 */
		EClass COLOR = eINSTANCE.getColor();

		/**
		 * The meta object literal for the '<em><b>Red</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLOR__RED = eINSTANCE.getColor_Red();

		/**
		 * The meta object literal for the '<em><b>Green</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLOR__GREEN = eINSTANCE.getColor_Green();

		/**
		 * The meta object literal for the '<em><b>Blue</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLOR__BLUE = eINSTANCE.getColor_Blue();

		/**
		 * The meta object literal for the '<em><b>Alfa</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLOR__ALFA = eINSTANCE.getColor_Alfa();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.ui.impl.PointImpl <em>Point</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.ui.impl.PointImpl
		 * @see org.eclipse.rcptt.tesla.core.ui.impl.UiPackageImpl#getPoint()
		 * @generated
		 */
		EClass POINT = eINSTANCE.getPoint();

		/**
		 * The meta object literal for the '<em><b>X</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POINT__X = eINSTANCE.getPoint_X();

		/**
		 * The meta object literal for the '<em><b>Y</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POINT__Y = eINSTANCE.getPoint_Y();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.ui.impl.RectangleImpl <em>Rectangle</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.ui.impl.RectangleImpl
		 * @see org.eclipse.rcptt.tesla.core.ui.impl.UiPackageImpl#getRectangle()
		 * @generated
		 */
		EClass RECTANGLE = eINSTANCE.getRectangle();

		/**
		 * The meta object literal for the '<em><b>X</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RECTANGLE__X = eINSTANCE.getRectangle_X();

		/**
		 * The meta object literal for the '<em><b>Y</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RECTANGLE__Y = eINSTANCE.getRectangle_Y();

		/**
		 * The meta object literal for the '<em><b>Width</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RECTANGLE__WIDTH = eINSTANCE.getRectangle_Width();

		/**
		 * The meta object literal for the '<em><b>Height</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RECTANGLE__HEIGHT = eINSTANCE.getRectangle_Height();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.ui.impl.ComboImpl <em>Combo</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.ui.impl.ComboImpl
		 * @see org.eclipse.rcptt.tesla.core.ui.impl.UiPackageImpl#getCombo()
		 * @generated
		 */
		EClass COMBO = eINSTANCE.getCombo();

		/**
		 * The meta object literal for the '<em><b>Tooltip</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMBO__TOOLTIP = eINSTANCE.getCombo_Tooltip();

		/**
		 * The meta object literal for the '<em><b>Selection</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMBO__SELECTION = eINSTANCE.getCombo_Selection();

		/**
		 * The meta object literal for the '<em><b>Read Only</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMBO__READ_ONLY = eINSTANCE.getCombo_ReadOnly();

		/**
		 * The meta object literal for the '<em><b>Values</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMBO__VALUES = eINSTANCE.getCombo_Values();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.ui.impl.TabFolderImpl <em>Tab Folder</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.ui.impl.TabFolderImpl
		 * @see org.eclipse.rcptt.tesla.core.ui.impl.UiPackageImpl#getTabFolder()
		 * @generated
		 */
		EClass TAB_FOLDER = eINSTANCE.getTabFolder();

		/**
		 * The meta object literal for the '<em><b>Selection</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TAB_FOLDER__SELECTION = eINSTANCE.getTabFolder_Selection();

		/**
		 * The meta object literal for the '<em><b>Pages</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TAB_FOLDER__PAGES = eINSTANCE.getTabFolder_Pages();

		/**
		 * The meta object literal for the '<em><b>Active Page</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TAB_FOLDER__ACTIVE_PAGE = eINSTANCE.getTabFolder_ActivePage();

		/**
		 * The meta object literal for the '<em><b>Tab Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TAB_FOLDER__TAB_COUNT = eINSTANCE.getTabFolder_TabCount();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.ui.impl.CompositeImpl <em>Composite</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.ui.impl.CompositeImpl
		 * @see org.eclipse.rcptt.tesla.core.ui.impl.UiPackageImpl#getComposite()
		 * @generated
		 */
		EClass COMPOSITE = eINSTANCE.getComposite();

		/**
		 * The meta object literal for the '<em><b>Child Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPOSITE__CHILD_COUNT = eINSTANCE.getComposite_ChildCount();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.ui.impl.GroupImpl <em>Group</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.ui.impl.GroupImpl
		 * @see org.eclipse.rcptt.tesla.core.ui.impl.UiPackageImpl#getGroup()
		 * @generated
		 */
		EClass GROUP = eINSTANCE.getGroup();

		/**
		 * The meta object literal for the '<em><b>Caption</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GROUP__CAPTION = eINSTANCE.getGroup_Caption();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.ui.impl.ExpandableCompositeImpl <em>Expandable Composite</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.ui.impl.ExpandableCompositeImpl
		 * @see org.eclipse.rcptt.tesla.core.ui.impl.UiPackageImpl#getExpandableComposite()
		 * @generated
		 */
		EClass EXPANDABLE_COMPOSITE = eINSTANCE.getExpandableComposite();

		/**
		 * The meta object literal for the '<em><b>Caption</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXPANDABLE_COMPOSITE__CAPTION = eINSTANCE.getExpandableComposite_Caption();

		/**
		 * The meta object literal for the '<em><b>Expanded</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXPANDABLE_COMPOSITE__EXPANDED = eINSTANCE.getExpandableComposite_Expanded();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.ui.impl.TreeImpl <em>Tree</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.ui.impl.TreeImpl
		 * @see org.eclipse.rcptt.tesla.core.ui.impl.UiPackageImpl#getTree()
		 * @generated
		 */
		EClass TREE = eINSTANCE.getTree();

		/**
		 * The meta object literal for the '<em><b>Columns</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TREE__COLUMNS = eINSTANCE.getTree_Columns();

		/**
		 * The meta object literal for the '<em><b>Lines Visible</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TREE__LINES_VISIBLE = eINSTANCE.getTree_LinesVisible();

		/**
		 * The meta object literal for the '<em><b>Selection</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TREE__SELECTION = eINSTANCE.getTree_Selection();

		/**
		 * The meta object literal for the '<em><b>Multi Selection</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TREE__MULTI_SELECTION = eINSTANCE.getTree_MultiSelection();

		/**
		 * The meta object literal for the '<em><b>Header Visible</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TREE__HEADER_VISIBLE = eINSTANCE.getTree_HeaderVisible();

		/**
		 * The meta object literal for the '<em><b>Item Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TREE__ITEM_COUNT = eINSTANCE.getTree_ItemCount();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.ui.impl.TableImpl <em>Table</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.ui.impl.TableImpl
		 * @see org.eclipse.rcptt.tesla.core.ui.impl.UiPackageImpl#getTable()
		 * @generated
		 */
		EClass TABLE = eINSTANCE.getTable();

		/**
		 * The meta object literal for the '<em><b>Columns</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TABLE__COLUMNS = eINSTANCE.getTable_Columns();

		/**
		 * The meta object literal for the '<em><b>Lines Visible</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TABLE__LINES_VISIBLE = eINSTANCE.getTable_LinesVisible();

		/**
		 * The meta object literal for the '<em><b>Selection</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TABLE__SELECTION = eINSTANCE.getTable_Selection();

		/**
		 * The meta object literal for the '<em><b>Multi Selection</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TABLE__MULTI_SELECTION = eINSTANCE.getTable_MultiSelection();

		/**
		 * The meta object literal for the '<em><b>Header Visible</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TABLE__HEADER_VISIBLE = eINSTANCE.getTable_HeaderVisible();

		/**
		 * The meta object literal for the '<em><b>Item Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TABLE__ITEM_COUNT = eINSTANCE.getTable_ItemCount();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.ui.impl.ViewerColumnImpl <em>Viewer Column</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.ui.impl.ViewerColumnImpl
		 * @see org.eclipse.rcptt.tesla.core.ui.impl.UiPackageImpl#getViewerColumn()
		 * @generated
		 */
		EClass VIEWER_COLUMN = eINSTANCE.getViewerColumn();

		/**
		 * The meta object literal for the '<em><b>Resizable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VIEWER_COLUMN__RESIZABLE = eINSTANCE.getViewerColumn_Resizable();

		/**
		 * The meta object literal for the '<em><b>Movable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VIEWER_COLUMN__MOVABLE = eINSTANCE.getViewerColumn_Movable();

		/**
		 * The meta object literal for the '<em><b>Width</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VIEWER_COLUMN__WIDTH = eINSTANCE.getViewerColumn_Width();

		/**
		 * The meta object literal for the '<em><b>Tooltip</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VIEWER_COLUMN__TOOLTIP = eINSTANCE.getViewerColumn_Tooltip();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.ui.impl.SelectionImpl <em>Selection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.ui.impl.SelectionImpl
		 * @see org.eclipse.rcptt.tesla.core.ui.impl.UiPackageImpl#getSelection()
		 * @generated
		 */
		EClass SELECTION = eINSTANCE.getSelection();

		/**
		 * The meta object literal for the '<em><b>Path</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SELECTION__PATH = eINSTANCE.getSelection_Path();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.ui.impl.DiagramItemImpl <em>Diagram Item</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.ui.impl.DiagramItemImpl
		 * @see org.eclipse.rcptt.tesla.core.ui.impl.UiPackageImpl#getDiagramItem()
		 * @generated
		 */
		EClass DIAGRAM_ITEM = eINSTANCE.getDiagramItem();

		/**
		 * The meta object literal for the '<em><b>X</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIAGRAM_ITEM__X = eINSTANCE.getDiagramItem_X();

		/**
		 * The meta object literal for the '<em><b>Y</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIAGRAM_ITEM__Y = eINSTANCE.getDiagramItem_Y();

		/**
		 * The meta object literal for the '<em><b>Width</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIAGRAM_ITEM__WIDTH = eINSTANCE.getDiagramItem_Width();

		/**
		 * The meta object literal for the '<em><b>Height</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIAGRAM_ITEM__HEIGHT = eINSTANCE.getDiagramItem_Height();

		/**
		 * The meta object literal for the '<em><b>Tooltip</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIAGRAM_ITEM__TOOLTIP = eINSTANCE.getDiagramItem_Tooltip();

		/**
		 * The meta object literal for the '<em><b>Children Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIAGRAM_ITEM__CHILDREN_COUNT = eINSTANCE.getDiagramItem_ChildrenCount();

		/**
		 * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIAGRAM_ITEM__TEXT = eINSTANCE.getDiagramItem_Text();

		/**
		 * The meta object literal for the '<em><b>Background Color</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DIAGRAM_ITEM__BACKGROUND_COLOR = eINSTANCE.getDiagramItem_BackgroundColor();

		/**
		 * The meta object literal for the '<em><b>Foreground Color</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DIAGRAM_ITEM__FOREGROUND_COLOR = eINSTANCE.getDiagramItem_ForegroundColor();

		/**
		 * The meta object literal for the '<em><b>Model Property Nodes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DIAGRAM_ITEM__MODEL_PROPERTY_NODES = eINSTANCE.getDiagramItem_ModelPropertyNodes();

		/**
		 * The meta object literal for the '<em><b>Item Address</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIAGRAM_ITEM__ITEM_ADDRESS = eINSTANCE.getDiagramItem_ItemAddress();

		/**
		 * The meta object literal for the '<em><b>Selected</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIAGRAM_ITEM__SELECTED = eINSTANCE.getDiagramItem_Selected();

		/**
		 * The meta object literal for the '<em><b>Class Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIAGRAM_ITEM__CLASS_NAME = eINSTANCE.getDiagramItem_ClassName();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.ui.impl.DiagramConnectionImpl <em>Diagram Connection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.ui.impl.DiagramConnectionImpl
		 * @see org.eclipse.rcptt.tesla.core.ui.impl.UiPackageImpl#getDiagramConnection()
		 * @generated
		 */
		EClass DIAGRAM_CONNECTION = eINSTANCE.getDiagramConnection();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DIAGRAM_CONNECTION__SOURCE = eINSTANCE.getDiagramConnection_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DIAGRAM_CONNECTION__TARGET = eINSTANCE.getDiagramConnection_Target();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.ui.impl.PropertyEntryImpl <em>Property Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.ui.impl.PropertyEntryImpl
		 * @see org.eclipse.rcptt.tesla.core.ui.impl.UiPackageImpl#getPropertyEntry()
		 * @generated
		 */
		EClass PROPERTY_ENTRY = eINSTANCE.getPropertyEntry();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY_ENTRY__NAME = eINSTANCE.getPropertyEntry_Name();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY_ENTRY__VALUE = eINSTANCE.getPropertyEntry_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.ui.impl.PropertyMapImpl <em>Property Map</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.ui.impl.PropertyMapImpl
		 * @see org.eclipse.rcptt.tesla.core.ui.impl.UiPackageImpl#getPropertyMap()
		 * @generated
		 */
		EClass PROPERTY_MAP = eINSTANCE.getPropertyMap();

		/**
		 * The meta object literal for the '<em><b>properties</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_MAP__PROPERTIES = eINSTANCE.getPropertyMap___properties();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.ui.impl.PropertyWidgetImpl <em>Property Widget</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.ui.impl.PropertyWidgetImpl
		 * @see org.eclipse.rcptt.tesla.core.ui.impl.UiPackageImpl#getPropertyWidget()
		 * @generated
		 */
		EClass PROPERTY_WIDGET = eINSTANCE.getPropertyWidget();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.ui.impl.BrowserImpl <em>Browser</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.ui.impl.BrowserImpl
		 * @see org.eclipse.rcptt.tesla.core.ui.impl.UiPackageImpl#getBrowser()
		 * @generated
		 */
		EClass BROWSER = eINSTANCE.getBrowser();

		/**
		 * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BROWSER__TEXT = eINSTANCE.getBrowser_Text();

		/**
		 * The meta object literal for the '<em><b>Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BROWSER__URI = eINSTANCE.getBrowser_Uri();

		/**
		 * The meta object literal for the '<em><b>Plain Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BROWSER__PLAIN_TEXT = eINSTANCE.getBrowser_PlainText();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.ui.impl.ViewImpl <em>View</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.ui.impl.ViewImpl
		 * @see org.eclipse.rcptt.tesla.core.ui.impl.UiPackageImpl#getView()
		 * @generated
		 */
		EClass VIEW = eINSTANCE.getView();

		/**
		 * The meta object literal for the '<em><b>Title</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VIEW__TITLE = eINSTANCE.getView_Title();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.ui.impl.EditorImpl <em>Editor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.ui.impl.EditorImpl
		 * @see org.eclipse.rcptt.tesla.core.ui.impl.UiPackageImpl#getEditor()
		 * @generated
		 */
		EClass EDITOR = eINSTANCE.getEditor();

		/**
		 * The meta object literal for the '<em><b>Title</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EDITOR__TITLE = eINSTANCE.getEditor_Title();

		/**
		 * The meta object literal for the '<em><b>Input</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EDITOR__INPUT = eINSTANCE.getEditor_Input();

		/**
		 * The meta object literal for the '<em><b>Dirty</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EDITOR__DIRTY = eINSTANCE.getEditor_Dirty();

		/**
		 * The meta object literal for the '<em><b>Active</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EDITOR__ACTIVE = eINSTANCE.getEditor_Active();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.ui.impl.WindowImpl <em>Window</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.ui.impl.WindowImpl
		 * @see org.eclipse.rcptt.tesla.core.ui.impl.UiPackageImpl#getWindow()
		 * @generated
		 */
		EClass WINDOW = eINSTANCE.getWindow();

		/**
		 * The meta object literal for the '<em><b>Title</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WINDOW__TITLE = eINSTANCE.getWindow_Title();

		/**
		 * The meta object literal for the '<em><b>Sizeable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WINDOW__SIZEABLE = eINSTANCE.getWindow_Sizeable();

		/**
		 * The meta object literal for the '<em><b>Is Primary Modal</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WINDOW__IS_PRIMARY_MODAL = eINSTANCE.getWindow_IsPrimaryModal();

		/**
		 * The meta object literal for the '<em><b>Is Application Modal</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WINDOW__IS_APPLICATION_MODAL = eINSTANCE.getWindow_IsApplicationModal();

		/**
		 * The meta object literal for the '<em><b>Is System Modal</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WINDOW__IS_SYSTEM_MODAL = eINSTANCE.getWindow_IsSystemModal();

		/**
		 * The meta object literal for the '<em><b>Is Tool</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WINDOW__IS_TOOL = eINSTANCE.getWindow_IsTool();

		/**
		 * The meta object literal for the '<em><b>Is Sheet</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WINDOW__IS_SHEET = eINSTANCE.getWindow_IsSheet();

		/**
		 * The meta object literal for the '<em><b>Has Close Button</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WINDOW__HAS_CLOSE_BUTTON = eINSTANCE.getWindow_HasCloseButton();

		/**
		 * The meta object literal for the '<em><b>Has Minimize Button</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WINDOW__HAS_MINIMIZE_BUTTON = eINSTANCE.getWindow_HasMinimizeButton();

		/**
		 * The meta object literal for the '<em><b>Has Maximize Button</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WINDOW__HAS_MAXIMIZE_BUTTON = eINSTANCE.getWindow_HasMaximizeButton();

		/**
		 * The meta object literal for the '<em><b>Has Border</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WINDOW__HAS_BORDER = eINSTANCE.getWindow_HasBorder();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.ui.impl.DateTimeImpl <em>Date Time</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.ui.impl.DateTimeImpl
		 * @see org.eclipse.rcptt.tesla.core.ui.impl.UiPackageImpl#getDateTime()
		 * @generated
		 */
		EClass DATE_TIME = eINSTANCE.getDateTime();

		/**
		 * The meta object literal for the '<em><b>Tooltip</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATE_TIME__TOOLTIP = eINSTANCE.getDateTime_Tooltip();

		/**
		 * The meta object literal for the '<em><b>Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATE_TIME__DATE = eINSTANCE.getDateTime_Date();

		/**
		 * The meta object literal for the '<em><b>Read Only</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATE_TIME__READ_ONLY = eINSTANCE.getDateTime_ReadOnly();

		/**
		 * The meta object literal for the '<em><b>Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATE_TIME__TIME = eINSTANCE.getDateTime_Time();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.ui.impl.SliderImpl <em>Slider</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.ui.impl.SliderImpl
		 * @see org.eclipse.rcptt.tesla.core.ui.impl.UiPackageImpl#getSlider()
		 * @generated
		 */
		EClass SLIDER = eINSTANCE.getSlider();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SLIDER__VALUE = eINSTANCE.getSlider_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.ui.impl.PropertyNodeImpl <em>Property Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.ui.impl.PropertyNodeImpl
		 * @see org.eclipse.rcptt.tesla.core.ui.impl.UiPackageImpl#getPropertyNode()
		 * @generated
		 */
		EClass PROPERTY_NODE = eINSTANCE.getPropertyNode();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY_NODE__NAME = eINSTANCE.getPropertyNode_Name();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY_NODE__TYPE = eINSTANCE.getPropertyNode_Type();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY_NODE__VALUE = eINSTANCE.getPropertyNode_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.ui.impl.PropertyNodeListImpl <em>Property Node List</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.ui.impl.PropertyNodeListImpl
		 * @see org.eclipse.rcptt.tesla.core.ui.impl.UiPackageImpl#getPropertyNodeList()
		 * @generated
		 */
		EClass PROPERTY_NODE_LIST = eINSTANCE.getPropertyNodeList();

		/**
		 * The meta object literal for the '<em><b>Property Nodes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_NODE_LIST__PROPERTY_NODES = eINSTANCE.getPropertyNodeList_PropertyNodes();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.ui.impl.FormTextImpl <em>Form Text</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.ui.impl.FormTextImpl
		 * @see org.eclipse.rcptt.tesla.core.ui.impl.UiPackageImpl#getFormText()
		 * @generated
		 */
		EClass FORM_TEXT = eINSTANCE.getFormText();

		/**
		 * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FORM_TEXT__TEXT = eINSTANCE.getFormText_Text();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.ui.impl.ImageImpl <em>Image</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.ui.impl.ImageImpl
		 * @see org.eclipse.rcptt.tesla.core.ui.impl.UiPackageImpl#getImage()
		 * @generated
		 */
		EClass IMAGE = eINSTANCE.getImage();

		/**
		 * The meta object literal for the '<em><b>Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMAGE__PATH = eINSTANCE.getImage_Path();

		/**
		 * The meta object literal for the '<em><b>Decorations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMAGE__DECORATIONS = eINSTANCE.getImage_Decorations();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.ui.impl.WithImageImpl <em>With Image</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.ui.impl.WithImageImpl
		 * @see org.eclipse.rcptt.tesla.core.ui.impl.UiPackageImpl#getWithImage()
		 * @generated
		 */
		EClass WITH_IMAGE = eINSTANCE.getWithImage();

		/**
		 * The meta object literal for the '<em><b>Image</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WITH_IMAGE__IMAGE = eINSTANCE.getWithImage_Image();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.ui.impl.ValuesMapImpl <em>Values Map</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.ui.impl.ValuesMapImpl
		 * @see org.eclipse.rcptt.tesla.core.ui.impl.UiPackageImpl#getValuesMap()
		 * @generated
		 */
		EClass VALUES_MAP = eINSTANCE.getValuesMap();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VALUES_MAP__KEY = eINSTANCE.getValuesMap_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VALUES_MAP__VALUE = eINSTANCE.getValuesMap_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.ui.impl.StyleRangeEntryImpl <em>Style Range Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.ui.impl.StyleRangeEntryImpl
		 * @see org.eclipse.rcptt.tesla.core.ui.impl.UiPackageImpl#getStyleRangeEntry()
		 * @generated
		 */
		EClass STYLE_RANGE_ENTRY = eINSTANCE.getStyleRangeEntry();

		/**
		 * The meta object literal for the '<em><b>Start</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STYLE_RANGE_ENTRY__START = eINSTANCE.getStyleRangeEntry_Start();

		/**
		 * The meta object literal for the '<em><b>Length</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STYLE_RANGE_ENTRY__LENGTH = eINSTANCE.getStyleRangeEntry_Length();

		/**
		 * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STYLE_RANGE_ENTRY__TEXT = eINSTANCE.getStyleRangeEntry_Text();

		/**
		 * The meta object literal for the '<em><b>Font Style</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STYLE_RANGE_ENTRY__FONT_STYLE = eINSTANCE.getStyleRangeEntry_FontStyle();

		/**
		 * The meta object literal for the '<em><b>Font</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STYLE_RANGE_ENTRY__FONT = eINSTANCE.getStyleRangeEntry_Font();

		/**
		 * The meta object literal for the '<em><b>Foreground Color</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STYLE_RANGE_ENTRY__FOREGROUND_COLOR = eINSTANCE.getStyleRangeEntry_ForegroundColor();

		/**
		 * The meta object literal for the '<em><b>Background Color</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STYLE_RANGE_ENTRY__BACKGROUND_COLOR = eINSTANCE.getStyleRangeEntry_BackgroundColor();

		/**
		 * The meta object literal for the '<em><b>Underline</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STYLE_RANGE_ENTRY__UNDERLINE = eINSTANCE.getStyleRangeEntry_Underline();

		/**
		 * The meta object literal for the '<em><b>Underline Color</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STYLE_RANGE_ENTRY__UNDERLINE_COLOR = eINSTANCE.getStyleRangeEntry_UnderlineColor();

		/**
		 * The meta object literal for the '<em><b>Strikeout</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STYLE_RANGE_ENTRY__STRIKEOUT = eINSTANCE.getStyleRangeEntry_Strikeout();

		/**
		 * The meta object literal for the '<em><b>Strikeout Color</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STYLE_RANGE_ENTRY__STRIKEOUT_COLOR = eINSTANCE.getStyleRangeEntry_StrikeoutColor();

		/**
		 * The meta object literal for the '<em><b>Border Style</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STYLE_RANGE_ENTRY__BORDER_STYLE = eINSTANCE.getStyleRangeEntry_BorderStyle();

		/**
		 * The meta object literal for the '<em><b>Border Color</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STYLE_RANGE_ENTRY__BORDER_COLOR = eINSTANCE.getStyleRangeEntry_BorderColor();

		/**
		 * The meta object literal for the '<em><b>Rise</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STYLE_RANGE_ENTRY__RISE = eINSTANCE.getStyleRangeEntry_Rise();

		/**
		 * The meta object literal for the '<em><b>Metrics</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STYLE_RANGE_ENTRY__METRICS = eINSTANCE.getStyleRangeEntry_Metrics();

		/**
		 * The meta object literal for the '<em><b>Start Pos</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STYLE_RANGE_ENTRY__START_POS = eINSTANCE.getStyleRangeEntry_StartPos();

		/**
		 * The meta object literal for the '<em><b>End Pos</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STYLE_RANGE_ENTRY__END_POS = eINSTANCE.getStyleRangeEntry_EndPos();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.ui.ButtonKind <em>Button Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.ui.ButtonKind
		 * @see org.eclipse.rcptt.tesla.core.ui.impl.UiPackageImpl#getButtonKind()
		 * @generated
		 */
		EEnum BUTTON_KIND = eINSTANCE.getButtonKind();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.core.ui.PropertyNodeType <em>Property Node Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.core.ui.PropertyNodeType
		 * @see org.eclipse.rcptt.tesla.core.ui.impl.UiPackageImpl#getPropertyNodeType()
		 * @generated
		 */
		EEnum PROPERTY_NODE_TYPE = eINSTANCE.getPropertyNodeType();

	}

} //UiPackage

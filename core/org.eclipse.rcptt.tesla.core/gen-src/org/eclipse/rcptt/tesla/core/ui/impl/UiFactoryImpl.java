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
package org.eclipse.rcptt.tesla.core.ui.impl;

import org.eclipse.rcptt.tesla.core.ui.*;

import java.util.Map;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class UiFactoryImpl extends EFactoryImpl implements UiFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static UiFactory init() {
		try {
			UiFactory theUiFactory = (UiFactory)EPackage.Registry.INSTANCE.getEFactory(UiPackage.eNS_URI);
			if (theUiFactory != null) {
				return theUiFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new UiFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UiFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case UiPackage.WIDGET: return createWidget();
			case UiPackage.CONTROL: return createControl();
			case UiPackage.CONTROL_DECORATOR: return createControlDecorator();
			case UiPackage.BUTTON: return createButton();
			case UiPackage.TOOL_ITEM: return createToolItem();
			case UiPackage.LABEL: return createLabel();
			case UiPackage.LINK: return createLink();
			case UiPackage.ITEM: return createItem();
			case UiPackage.MENU_ITEM: return createMenuItem();
			case UiPackage.STYLE_RANGE_ENTRY: return createStyleRangeEntry();
			case UiPackage.TREE_ITEM: return createTreeItem();
			case UiPackage.TABLE_ITEM: return createTableItem();
			case UiPackage.TEXT: return createText();
			case UiPackage.TEXT_POSITION: return createTextPosition();
			case UiPackage.COLOR: return createColor();
			case UiPackage.POINT: return createPoint();
			case UiPackage.RECTANGLE: return createRectangle();
			case UiPackage.COMBO: return createCombo();
			case UiPackage.TAB_FOLDER: return createTabFolder();
			case UiPackage.COMPOSITE: return createComposite();
			case UiPackage.GROUP: return createGroup();
			case UiPackage.EXPANDABLE_COMPOSITE: return createExpandableComposite();
			case UiPackage.TREE: return createTree();
			case UiPackage.TABLE: return createTable();
			case UiPackage.VIEWER_COLUMN: return createViewerColumn();
			case UiPackage.SELECTION: return createSelection();
			case UiPackage.DIAGRAM_ITEM: return createDiagramItem();
			case UiPackage.DIAGRAM_CONNECTION: return createDiagramConnection();
			case UiPackage.PROPERTY_ENTRY: return createPropertyEntry();
			case UiPackage.PROPERTY_MAP: return createPropertyMap();
			case UiPackage.PROPERTY_WIDGET: return createPropertyWidget();
			case UiPackage.BROWSER: return createBrowser();
			case UiPackage.VIEW: return createView();
			case UiPackage.EDITOR: return createEditor();
			case UiPackage.WINDOW: return createWindow();
			case UiPackage.DATE_TIME: return createDateTime();
			case UiPackage.SLIDER: return createSlider();
			case UiPackage.PROPERTY_NODE: return createPropertyNode();
			case UiPackage.PROPERTY_NODE_LIST: return createPropertyNodeList();
			case UiPackage.FORM_TEXT: return createFormText();
			case UiPackage.IMAGE: return createImage();
			case UiPackage.WITH_IMAGE: return createWithImage();
			case UiPackage.VALUES_MAP: return (EObject)createValuesMap();
			case UiPackage.MARKER: return createMarker();
			case UiPackage.LINE_MARKERS_VALUE: return (EObject)createLineMarkersValue();
			case UiPackage.CELL: return createCell();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case UiPackage.BUTTON_KIND:
				return createButtonKindFromString(eDataType, initialValue);
			case UiPackage.PROPERTY_NODE_TYPE:
				return createPropertyNodeTypeFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case UiPackage.BUTTON_KIND:
				return convertButtonKindToString(eDataType, instanceValue);
			case UiPackage.PROPERTY_NODE_TYPE:
				return convertPropertyNodeTypeToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Widget createWidget() {
		WidgetImpl widget = new WidgetImpl();
		return widget;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Control createControl() {
		ControlImpl control = new ControlImpl();
		return control;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ControlDecorator createControlDecorator() {
		ControlDecoratorImpl controlDecorator = new ControlDecoratorImpl();
		return controlDecorator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Button createButton() {
		ButtonImpl button = new ButtonImpl();
		return button;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ToolItem createToolItem() {
		ToolItemImpl toolItem = new ToolItemImpl();
		return toolItem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Label createLabel() {
		LabelImpl label = new LabelImpl();
		return label;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Link createLink() {
		LinkImpl link = new LinkImpl();
		return link;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Item createItem() {
		ItemImpl item = new ItemImpl();
		return item;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MenuItem createMenuItem() {
		MenuItemImpl menuItem = new MenuItemImpl();
		return menuItem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TreeItem createTreeItem() {
		TreeItemImpl treeItem = new TreeItemImpl();
		return treeItem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TableItem createTableItem() {
		TableItemImpl tableItem = new TableItemImpl();
		return tableItem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Text createText() {
		TextImpl text = new TextImpl();
		return text;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TextPosition createTextPosition() {
		TextPositionImpl textPosition = new TextPositionImpl();
		return textPosition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Color createColor() {
		ColorImpl color = new ColorImpl();
		return color;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Point createPoint() {
		PointImpl point = new PointImpl();
		return point;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Rectangle createRectangle() {
		RectangleImpl rectangle = new RectangleImpl();
		return rectangle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Combo createCombo() {
		ComboImpl combo = new ComboImpl();
		return combo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TabFolder createTabFolder() {
		TabFolderImpl tabFolder = new TabFolderImpl();
		return tabFolder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Composite createComposite() {
		CompositeImpl composite = new CompositeImpl();
		return composite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Group createGroup() {
		GroupImpl group = new GroupImpl();
		return group;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpandableComposite createExpandableComposite() {
		ExpandableCompositeImpl expandableComposite = new ExpandableCompositeImpl();
		return expandableComposite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Tree createTree() {
		TreeImpl tree = new TreeImpl();
		return tree;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Table createTable() {
		TableImpl table = new TableImpl();
		return table;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ViewerColumn createViewerColumn() {
		ViewerColumnImpl viewerColumn = new ViewerColumnImpl();
		return viewerColumn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Selection createSelection() {
		SelectionImpl selection = new SelectionImpl();
		return selection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DiagramItem createDiagramItem() {
		DiagramItemImpl diagramItem = new DiagramItemImpl();
		return diagramItem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DiagramConnection createDiagramConnection() {
		DiagramConnectionImpl diagramConnection = new DiagramConnectionImpl();
		return diagramConnection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyEntry createPropertyEntry() {
		PropertyEntryImpl propertyEntry = new PropertyEntryImpl();
		return propertyEntry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyMap createPropertyMap() {
		PropertyMapImpl propertyMap = new PropertyMapImpl();
		return propertyMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyWidget createPropertyWidget() {
		PropertyWidgetImpl propertyWidget = new PropertyWidgetImpl();
		return propertyWidget;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Browser createBrowser() {
		BrowserImpl browser = new BrowserImpl();
		return browser;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public View createView() {
		ViewImpl view = new ViewImpl();
		return view;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Editor createEditor() {
		EditorImpl editor = new EditorImpl();
		return editor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Window createWindow() {
		WindowImpl window = new WindowImpl();
		return window;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DateTime createDateTime() {
		DateTimeImpl dateTime = new DateTimeImpl();
		return dateTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Slider createSlider() {
		SliderImpl slider = new SliderImpl();
		return slider;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyNode createPropertyNode() {
		PropertyNodeImpl propertyNode = new PropertyNodeImpl();
		return propertyNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyNodeList createPropertyNodeList() {
		PropertyNodeListImpl propertyNodeList = new PropertyNodeListImpl();
		return propertyNodeList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FormText createFormText() {
		FormTextImpl formText = new FormTextImpl();
		return formText;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Image createImage() {
		ImageImpl image = new ImageImpl();
		return image;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WithImage createWithImage() {
		WithImageImpl withImage = new WithImageImpl();
		return withImage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<String, String> createValuesMap() {
		ValuesMapImpl valuesMap = new ValuesMapImpl();
		return valuesMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<String, EList<Marker>> createLineMarkersValue() {
		LineMarkersValueImpl lineMarkersValue = new LineMarkersValueImpl();
		return lineMarkersValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Cell createCell() {
		CellImpl cell = new CellImpl();
		return cell;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Marker createMarker() {
		MarkerImpl marker = new MarkerImpl();
		return marker;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StyleRangeEntry createStyleRangeEntry() {
		StyleRangeEntryImpl styleRangeEntry = new StyleRangeEntryImpl();
		return styleRangeEntry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ButtonKind createButtonKindFromString(EDataType eDataType, String initialValue) {
		ButtonKind result = ButtonKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertButtonKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyNodeType createPropertyNodeTypeFromString(EDataType eDataType, String initialValue) {
		PropertyNodeType result = PropertyNodeType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPropertyNodeTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UiPackage getUiPackage() {
		return (UiPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static UiPackage getPackage() {
		return UiPackage.eINSTANCE;
	}

} //UiFactoryImpl

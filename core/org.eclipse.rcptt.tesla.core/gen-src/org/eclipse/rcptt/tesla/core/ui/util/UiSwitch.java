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
package org.eclipse.rcptt.tesla.core.ui.util;

import org.eclipse.rcptt.tesla.core.ui.*;

import java.util.List;

import java.util.Map;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.rcptt.tesla.core.ui.UiPackage
 * @generated
 */
public class UiSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static UiPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UiSwitch() {
		if (modelPackage == null) {
			modelPackage = UiPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case UiPackage.WIDGET: {
				Widget widget = (Widget)theEObject;
				T result = caseWidget(widget);
				if (result == null) result = casePropertyNodeList(widget);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UiPackage.CONTROL: {
				Control control = (Control)theEObject;
				T result = caseControl(control);
				if (result == null) result = caseWidget(control);
				if (result == null) result = casePropertyNodeList(control);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UiPackage.CONTROL_DECORATOR: {
				ControlDecorator controlDecorator = (ControlDecorator)theEObject;
				T result = caseControlDecorator(controlDecorator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UiPackage.BUTTON: {
				Button button = (Button)theEObject;
				T result = caseButton(button);
				if (result == null) result = caseControl(button);
				if (result == null) result = caseWithImage(button);
				if (result == null) result = caseWidget(button);
				if (result == null) result = casePropertyNodeList(button);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UiPackage.TOOL_ITEM: {
				ToolItem toolItem = (ToolItem)theEObject;
				T result = caseToolItem(toolItem);
				if (result == null) result = caseButton(toolItem);
				if (result == null) result = caseControl(toolItem);
				if (result == null) result = caseWithImage(toolItem);
				if (result == null) result = caseWidget(toolItem);
				if (result == null) result = casePropertyNodeList(toolItem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UiPackage.LABEL: {
				Label label = (Label)theEObject;
				T result = caseLabel(label);
				if (result == null) result = caseControl(label);
				if (result == null) result = caseWithImage(label);
				if (result == null) result = caseWidget(label);
				if (result == null) result = casePropertyNodeList(label);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UiPackage.LINK: {
				Link link = (Link)theEObject;
				T result = caseLink(link);
				if (result == null) result = caseControl(link);
				if (result == null) result = caseWidget(link);
				if (result == null) result = casePropertyNodeList(link);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UiPackage.ITEM: {
				Item item = (Item)theEObject;
				T result = caseItem(item);
				if (result == null) result = caseWidget(item);
				if (result == null) result = casePropertyNodeList(item);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UiPackage.MENU_ITEM: {
				MenuItem menuItem = (MenuItem)theEObject;
				T result = caseMenuItem(menuItem);
				if (result == null) result = caseItem(menuItem);
				if (result == null) result = caseWidget(menuItem);
				if (result == null) result = casePropertyNodeList(menuItem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UiPackage.STYLE_RANGE_ENTRY: {
				StyleRangeEntry styleRangeEntry = (StyleRangeEntry)theEObject;
				T result = caseStyleRangeEntry(styleRangeEntry);
				if (result == null) result = caseWidget(styleRangeEntry);
				if (result == null) result = casePropertyNodeList(styleRangeEntry);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UiPackage.TREE_ITEM: {
				TreeItem treeItem = (TreeItem)theEObject;
				T result = caseTreeItem(treeItem);
				if (result == null) result = caseItem(treeItem);
				if (result == null) result = caseWithImage(treeItem);
				if (result == null) result = caseWidget(treeItem);
				if (result == null) result = casePropertyNodeList(treeItem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UiPackage.TABLE_ITEM: {
				TableItem tableItem = (TableItem)theEObject;
				T result = caseTableItem(tableItem);
				if (result == null) result = caseItem(tableItem);
				if (result == null) result = caseWithImage(tableItem);
				if (result == null) result = caseWidget(tableItem);
				if (result == null) result = casePropertyNodeList(tableItem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UiPackage.TEXT: {
				Text text = (Text)theEObject;
				T result = caseText(text);
				if (result == null) result = caseControl(text);
				if (result == null) result = caseWidget(text);
				if (result == null) result = casePropertyNodeList(text);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UiPackage.TEXT_POSITION: {
				TextPosition textPosition = (TextPosition)theEObject;
				T result = caseTextPosition(textPosition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UiPackage.COLOR: {
				Color color = (Color)theEObject;
				T result = caseColor(color);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UiPackage.POINT: {
				Point point = (Point)theEObject;
				T result = casePoint(point);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UiPackage.RECTANGLE: {
				Rectangle rectangle = (Rectangle)theEObject;
				T result = caseRectangle(rectangle);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UiPackage.COMBO: {
				Combo combo = (Combo)theEObject;
				T result = caseCombo(combo);
				if (result == null) result = caseControl(combo);
				if (result == null) result = caseWidget(combo);
				if (result == null) result = casePropertyNodeList(combo);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UiPackage.TAB_FOLDER: {
				TabFolder tabFolder = (TabFolder)theEObject;
				T result = caseTabFolder(tabFolder);
				if (result == null) result = caseControl(tabFolder);
				if (result == null) result = caseWidget(tabFolder);
				if (result == null) result = casePropertyNodeList(tabFolder);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UiPackage.COMPOSITE: {
				Composite composite = (Composite)theEObject;
				T result = caseComposite(composite);
				if (result == null) result = caseControl(composite);
				if (result == null) result = caseWidget(composite);
				if (result == null) result = casePropertyNodeList(composite);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UiPackage.GROUP: {
				Group group = (Group)theEObject;
				T result = caseGroup(group);
				if (result == null) result = caseComposite(group);
				if (result == null) result = caseControl(group);
				if (result == null) result = caseWidget(group);
				if (result == null) result = casePropertyNodeList(group);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UiPackage.EXPANDABLE_COMPOSITE: {
				ExpandableComposite expandableComposite = (ExpandableComposite)theEObject;
				T result = caseExpandableComposite(expandableComposite);
				if (result == null) result = caseComposite(expandableComposite);
				if (result == null) result = caseControl(expandableComposite);
				if (result == null) result = caseWidget(expandableComposite);
				if (result == null) result = casePropertyNodeList(expandableComposite);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UiPackage.TREE: {
				Tree tree = (Tree)theEObject;
				T result = caseTree(tree);
				if (result == null) result = caseControl(tree);
				if (result == null) result = caseWidget(tree);
				if (result == null) result = casePropertyNodeList(tree);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UiPackage.TABLE: {
				Table table = (Table)theEObject;
				T result = caseTable(table);
				if (result == null) result = caseControl(table);
				if (result == null) result = caseWidget(table);
				if (result == null) result = casePropertyNodeList(table);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UiPackage.VIEWER_COLUMN: {
				ViewerColumn viewerColumn = (ViewerColumn)theEObject;
				T result = caseViewerColumn(viewerColumn);
				if (result == null) result = caseItem(viewerColumn);
				if (result == null) result = caseWidget(viewerColumn);
				if (result == null) result = casePropertyNodeList(viewerColumn);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UiPackage.SELECTION: {
				Selection selection = (Selection)theEObject;
				T result = caseSelection(selection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UiPackage.DIAGRAM_ITEM: {
				DiagramItem diagramItem = (DiagramItem)theEObject;
				T result = caseDiagramItem(diagramItem);
				if (result == null) result = caseWidget(diagramItem);
				if (result == null) result = casePropertyMap(diagramItem);
				if (result == null) result = casePropertyNodeList(diagramItem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UiPackage.DIAGRAM_CONNECTION: {
				DiagramConnection diagramConnection = (DiagramConnection)theEObject;
				T result = caseDiagramConnection(diagramConnection);
				if (result == null) result = caseDiagramItem(diagramConnection);
				if (result == null) result = caseWidget(diagramConnection);
				if (result == null) result = casePropertyMap(diagramConnection);
				if (result == null) result = casePropertyNodeList(diagramConnection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UiPackage.PROPERTY_ENTRY: {
				PropertyEntry propertyEntry = (PropertyEntry)theEObject;
				T result = casePropertyEntry(propertyEntry);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UiPackage.PROPERTY_MAP: {
				PropertyMap propertyMap = (PropertyMap)theEObject;
				T result = casePropertyMap(propertyMap);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UiPackage.PROPERTY_WIDGET: {
				PropertyWidget propertyWidget = (PropertyWidget)theEObject;
				T result = casePropertyWidget(propertyWidget);
				if (result == null) result = caseWidget(propertyWidget);
				if (result == null) result = casePropertyMap(propertyWidget);
				if (result == null) result = casePropertyNodeList(propertyWidget);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UiPackage.BROWSER: {
				Browser browser = (Browser)theEObject;
				T result = caseBrowser(browser);
				if (result == null) result = caseControl(browser);
				if (result == null) result = caseWidget(browser);
				if (result == null) result = casePropertyNodeList(browser);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UiPackage.VIEW: {
				View view = (View)theEObject;
				T result = caseView(view);
				if (result == null) result = caseControl(view);
				if (result == null) result = caseWidget(view);
				if (result == null) result = casePropertyNodeList(view);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UiPackage.EDITOR: {
				Editor editor = (Editor)theEObject;
				T result = caseEditor(editor);
				if (result == null) result = caseControl(editor);
				if (result == null) result = caseWidget(editor);
				if (result == null) result = casePropertyNodeList(editor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UiPackage.WINDOW: {
				Window window = (Window)theEObject;
				T result = caseWindow(window);
				if (result == null) result = caseControl(window);
				if (result == null) result = caseWidget(window);
				if (result == null) result = casePropertyNodeList(window);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UiPackage.DATE_TIME: {
				DateTime dateTime = (DateTime)theEObject;
				T result = caseDateTime(dateTime);
				if (result == null) result = caseControl(dateTime);
				if (result == null) result = caseWidget(dateTime);
				if (result == null) result = casePropertyNodeList(dateTime);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UiPackage.SLIDER: {
				Slider slider = (Slider)theEObject;
				T result = caseSlider(slider);
				if (result == null) result = caseControl(slider);
				if (result == null) result = caseWidget(slider);
				if (result == null) result = casePropertyNodeList(slider);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UiPackage.PROPERTY_NODE: {
				PropertyNode propertyNode = (PropertyNode)theEObject;
				T result = casePropertyNode(propertyNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UiPackage.PROPERTY_NODE_LIST: {
				PropertyNodeList propertyNodeList = (PropertyNodeList)theEObject;
				T result = casePropertyNodeList(propertyNodeList);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UiPackage.FORM_TEXT: {
				FormText formText = (FormText)theEObject;
				T result = caseFormText(formText);
				if (result == null) result = caseControl(formText);
				if (result == null) result = caseWidget(formText);
				if (result == null) result = casePropertyNodeList(formText);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UiPackage.IMAGE: {
				Image image = (Image)theEObject;
				T result = caseImage(image);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UiPackage.WITH_IMAGE: {
				WithImage withImage = (WithImage)theEObject;
				T result = caseWithImage(withImage);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UiPackage.VALUES_MAP: {
				@SuppressWarnings("unchecked") Map.Entry<String, String> valuesMap = (Map.Entry<String, String>)theEObject;
				T result = caseValuesMap(valuesMap);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Widget</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Widget</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWidget(Widget object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Control</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Control</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseControl(Control object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Control Decorator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Control Decorator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseControlDecorator(ControlDecorator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Button</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Button</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseButton(Button object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tool Item</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tool Item</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseToolItem(ToolItem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Label</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Label</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLabel(Label object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Link</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Link</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLink(Link object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Item</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Item</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseItem(Item object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Menu Item</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Menu Item</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMenuItem(MenuItem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tree Item</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tree Item</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTreeItem(TreeItem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Table Item</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Table Item</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTableItem(TableItem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Text</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Text</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseText(Text object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Text Position</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Text Position</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTextPosition(TextPosition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Color</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Color</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseColor(Color object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Point</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Point</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePoint(Point object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Rectangle</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Rectangle</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRectangle(Rectangle object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Combo</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Combo</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCombo(Combo object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tab Folder</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tab Folder</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTabFolder(TabFolder object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Composite</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Composite</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComposite(Composite object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Group</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Group</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGroup(Group object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Expandable Composite</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Expandable Composite</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExpandableComposite(ExpandableComposite object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tree</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tree</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTree(Tree object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Table</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Table</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTable(Table object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Viewer Column</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Viewer Column</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseViewerColumn(ViewerColumn object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Selection</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Selection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSelection(Selection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Diagram Item</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Diagram Item</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDiagramItem(DiagramItem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Diagram Connection</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Diagram Connection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDiagramConnection(DiagramConnection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Property Entry</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property Entry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePropertyEntry(PropertyEntry object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Property Map</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property Map</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePropertyMap(PropertyMap object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Property Widget</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property Widget</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePropertyWidget(PropertyWidget object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Browser</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Browser</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBrowser(Browser object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>View</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>View</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseView(View object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Editor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Editor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEditor(Editor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Window</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Window</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWindow(Window object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Date Time</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Date Time</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDateTime(DateTime object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Slider</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Slider</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSlider(Slider object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Property Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePropertyNode(PropertyNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Property Node List</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property Node List</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePropertyNodeList(PropertyNodeList object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Form Text</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Form Text</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFormText(FormText object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Image</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Image</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseImage(Image object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>With Image</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>With Image</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWithImage(WithImage object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Values Map</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Values Map</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseValuesMap(Map.Entry<String, String> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Style Range Entry</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Style Range Entry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStyleRangeEntry(StyleRangeEntry object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public T defaultCase(EObject object) {
		return null;
	}

} //UiSwitch

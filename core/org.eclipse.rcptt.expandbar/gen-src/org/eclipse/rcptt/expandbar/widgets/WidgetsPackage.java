/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.rcptt.expandbar.widgets;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.rcptt.tesla.core.ui.UiPackage;

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
 * @see org.eclipse.rcptt.expandbar.widgets.WidgetsFactory
 * @model kind="package"
 * @generated
 */
public interface WidgetsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "widgets";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://eclipse.org/rcptt/widgets/expandbar/model";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.eclipse.rcptt.widgets.expandbar.model";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	WidgetsPackage eINSTANCE = org.eclipse.rcptt.expandbar.widgets.impl.WidgetsPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.expandbar.widgets.impl.ExpandBarImpl <em>Expand Bar</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.expandbar.widgets.impl.ExpandBarImpl
	 * @see org.eclipse.rcptt.expandbar.widgets.impl.WidgetsPackageImpl#getExpandBar()
	 * @generated
	 */
	int EXPAND_BAR = 0;

	/**
	 * The feature id for the '<em><b>Property Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPAND_BAR__PROPERTY_NODES = UiPackage.CONTROL__PROPERTY_NODES;

	/**
	 * The feature id for the '<em><b>Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPAND_BAR__CLASS_NAME = UiPackage.CONTROL__CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Enablement</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPAND_BAR__ENABLEMENT = UiPackage.CONTROL__ENABLEMENT;

	/**
	 * The feature id for the '<em><b>Background Color</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPAND_BAR__BACKGROUND_COLOR = UiPackage.CONTROL__BACKGROUND_COLOR;

	/**
	 * The feature id for the '<em><b>Foreground Color</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPAND_BAR__FOREGROUND_COLOR = UiPackage.CONTROL__FOREGROUND_COLOR;

	/**
	 * The feature id for the '<em><b>Contain Menu</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPAND_BAR__CONTAIN_MENU = UiPackage.CONTROL__CONTAIN_MENU;

	/**
	 * The feature id for the '<em><b>Bounds</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPAND_BAR__BOUNDS = UiPackage.CONTROL__BOUNDS;

	/**
	 * The feature id for the '<em><b>Border With</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPAND_BAR__BORDER_WITH = UiPackage.CONTROL__BORDER_WITH;

	/**
	 * The feature id for the '<em><b>Decorators</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPAND_BAR__DECORATORS = UiPackage.CONTROL__DECORATORS;

	/**
	 * The feature id for the '<em><b>Items</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPAND_BAR__ITEMS = UiPackage.CONTROL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Expand Bar</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPAND_BAR_FEATURE_COUNT = UiPackage.CONTROL_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.expandbar.widgets.impl.ExpandItemImpl <em>Expand Item</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.expandbar.widgets.impl.ExpandItemImpl
	 * @see org.eclipse.rcptt.expandbar.widgets.impl.WidgetsPackageImpl#getExpandItem()
	 * @generated
	 */
	int EXPAND_ITEM = 1;

	/**
	 * The feature id for the '<em><b>Property Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPAND_ITEM__PROPERTY_NODES = UiPackage.WIDGET__PROPERTY_NODES;

	/**
	 * The feature id for the '<em><b>Image</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPAND_ITEM__IMAGE = UiPackage.WIDGET_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Caption</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPAND_ITEM__CAPTION = UiPackage.WIDGET_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Expanded</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPAND_ITEM__EXPANDED = UiPackage.WIDGET_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPAND_ITEM__INDEX = UiPackage.WIDGET_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Expand Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPAND_ITEM_FEATURE_COUNT = UiPackage.WIDGET_FEATURE_COUNT + 4;


	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.expandbar.widgets.ExpandBar <em>Expand Bar</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expand Bar</em>'.
	 * @see org.eclipse.rcptt.expandbar.widgets.ExpandBar
	 * @generated
	 */
	EClass getExpandBar();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.rcptt.expandbar.widgets.ExpandBar#getItems <em>Items</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Items</em>'.
	 * @see org.eclipse.rcptt.expandbar.widgets.ExpandBar#getItems()
	 * @see #getExpandBar()
	 * @generated
	 */
	EReference getExpandBar_Items();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.expandbar.widgets.ExpandItem <em>Expand Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expand Item</em>'.
	 * @see org.eclipse.rcptt.expandbar.widgets.ExpandItem
	 * @generated
	 */
	EClass getExpandItem();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.expandbar.widgets.ExpandItem#getCaption <em>Caption</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Caption</em>'.
	 * @see org.eclipse.rcptt.expandbar.widgets.ExpandItem#getCaption()
	 * @see #getExpandItem()
	 * @generated
	 */
	EAttribute getExpandItem_Caption();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.expandbar.widgets.ExpandItem#isExpanded <em>Expanded</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Expanded</em>'.
	 * @see org.eclipse.rcptt.expandbar.widgets.ExpandItem#isExpanded()
	 * @see #getExpandItem()
	 * @generated
	 */
	EAttribute getExpandItem_Expanded();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.expandbar.widgets.ExpandItem#getIndex <em>Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Index</em>'.
	 * @see org.eclipse.rcptt.expandbar.widgets.ExpandItem#getIndex()
	 * @see #getExpandItem()
	 * @generated
	 */
	EAttribute getExpandItem_Index();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	WidgetsFactory getWidgetsFactory();

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
		 * The meta object literal for the '{@link org.eclipse.rcptt.expandbar.widgets.impl.ExpandBarImpl <em>Expand Bar</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.expandbar.widgets.impl.ExpandBarImpl
		 * @see org.eclipse.rcptt.expandbar.widgets.impl.WidgetsPackageImpl#getExpandBar()
		 * @generated
		 */
		EClass EXPAND_BAR = eINSTANCE.getExpandBar();

		/**
		 * The meta object literal for the '<em><b>Items</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPAND_BAR__ITEMS = eINSTANCE.getExpandBar_Items();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.expandbar.widgets.impl.ExpandItemImpl <em>Expand Item</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.expandbar.widgets.impl.ExpandItemImpl
		 * @see org.eclipse.rcptt.expandbar.widgets.impl.WidgetsPackageImpl#getExpandItem()
		 * @generated
		 */
		EClass EXPAND_ITEM = eINSTANCE.getExpandItem();

		/**
		 * The meta object literal for the '<em><b>Caption</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXPAND_ITEM__CAPTION = eINSTANCE.getExpandItem_Caption();

		/**
		 * The meta object literal for the '<em><b>Expanded</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXPAND_ITEM__EXPANDED = eINSTANCE.getExpandItem_Expanded();

		/**
		 * The meta object literal for the '<em><b>Index</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXPAND_ITEM__INDEX = eINSTANCE.getExpandItem_Index();

	}

} //WidgetsPackage

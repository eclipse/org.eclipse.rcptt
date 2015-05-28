/**
 */
package org.eclipse.rcptt.tesla.nebula.nattable.ecl.nattable;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.rcptt.tesla.core.ui.UiPackage;
import org.eclipse.rcptt.tesla.ecl.model.TeslaPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.rcptt.tesla.nebula.nattable.ecl.nattable.NattableFactory
 * @model kind="package"
 * @generated
 */
public interface NattablePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "nattable";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://eclipse.org/rcptt/tesla/nebula/nattable/ecl";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.eclipse.rcptt.tesla.nebula.nattable.ecl";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	NattablePackage eINSTANCE = org.eclipse.rcptt.tesla.nebula.nattable.ecl.nattable.impl.NattablePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.tesla.nebula.nattable.ecl.nattable.impl.NebulaNatTableImpl <em>Nebula Nat Table</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.tesla.nebula.nattable.ecl.nattable.impl.NebulaNatTableImpl
	 * @see org.eclipse.rcptt.tesla.nebula.nattable.ecl.nattable.impl.NattablePackageImpl#getNebulaNatTable()
	 * @generated
	 */
	int NEBULA_NAT_TABLE = 0;

	/**
	 * The feature id for the '<em><b>Property Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEBULA_NAT_TABLE__PROPERTY_NODES = UiPackage.CONTROL__PROPERTY_NODES;

	/**
	 * The feature id for the '<em><b>Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEBULA_NAT_TABLE__CLASS_NAME = UiPackage.CONTROL__CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Enablement</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEBULA_NAT_TABLE__ENABLEMENT = UiPackage.CONTROL__ENABLEMENT;

	/**
	 * The feature id for the '<em><b>Background Color</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEBULA_NAT_TABLE__BACKGROUND_COLOR = UiPackage.CONTROL__BACKGROUND_COLOR;

	/**
	 * The feature id for the '<em><b>Foreground Color</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEBULA_NAT_TABLE__FOREGROUND_COLOR = UiPackage.CONTROL__FOREGROUND_COLOR;

	/**
	 * The feature id for the '<em><b>Contain Menu</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEBULA_NAT_TABLE__CONTAIN_MENU = UiPackage.CONTROL__CONTAIN_MENU;

	/**
	 * The feature id for the '<em><b>Bounds</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEBULA_NAT_TABLE__BOUNDS = UiPackage.CONTROL__BOUNDS;

	/**
	 * The feature id for the '<em><b>Border With</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEBULA_NAT_TABLE__BORDER_WITH = UiPackage.CONTROL__BORDER_WITH;

	/**
	 * The feature id for the '<em><b>Decorators</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEBULA_NAT_TABLE__DECORATORS = UiPackage.CONTROL__DECORATORS;

	/**
	 * The number of structural features of the '<em>Nebula Nat Table</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEBULA_NAT_TABLE_FEATURE_COUNT = UiPackage.CONTROL_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '
	 * {@link org.eclipse.rcptt.tesla.nebula.nattable.ecl.nattable.impl.GetNebulaNatTableImpl
	 * <em>Get Nebula Nat Table</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.rcptt.tesla.nebula.nattable.ecl.nattable.impl.GetNebulaNatTableImpl
	 * @see org.eclipse.rcptt.tesla.nebula.nattable.ecl.nattable.impl.NattablePackageImpl#getGetNebulaNatTable()
	 * @generated
	 */
	int GET_NEBULA_NAT_TABLE = 1;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_NEBULA_NAT_TABLE__HOST = TeslaPackage.SELECTOR__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_NEBULA_NAT_TABLE__BINDINGS = TeslaPackage.SELECTOR__BINDINGS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_NEBULA_NAT_TABLE__ID = TeslaPackage.SELECTOR__ID;

	/**
	 * The feature id for the '<em><b>After</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_NEBULA_NAT_TABLE__AFTER = TeslaPackage.SELECTOR__AFTER;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_NEBULA_NAT_TABLE__TYPE = TeslaPackage.SELECTOR__TYPE;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_NEBULA_NAT_TABLE__INDEX = TeslaPackage.SELECTOR__INDEX;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_NEBULA_NAT_TABLE__PARENT = TeslaPackage.SELECTOR__PARENT;

	/**
	 * The number of structural features of the '<em>Get Nebula Nat Table</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_NEBULA_NAT_TABLE_FEATURE_COUNT = TeslaPackage.SELECTOR_FEATURE_COUNT + 0;

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.nebula.nattable.ecl.nattable.NebulaNatTable <em>Nebula Nat Table</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Nebula Nat Table</em>'.
	 * @see org.eclipse.rcptt.tesla.nebula.nattable.ecl.nattable.NebulaNatTable
	 * @generated
	 */
	EClass getNebulaNatTable();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.tesla.nebula.nattable.ecl.nattable.GetNebulaNatTable <em>Get Nebula Nat Table</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get Nebula Nat Table</em>'.
	 * @see org.eclipse.rcptt.tesla.nebula.nattable.ecl.nattable.GetNebulaNatTable
	 * @generated
	 */
	EClass getGetNebulaNatTable();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	NattableFactory getNattableFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.nebula.nattable.ecl.nattable.impl.NebulaNatTableImpl <em>Nebula Nat Table</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.nebula.nattable.ecl.nattable.impl.NebulaNatTableImpl
		 * @see org.eclipse.rcptt.tesla.nebula.nattable.ecl.nattable.impl.NattablePackageImpl#getNebulaNatTable()
		 * @generated
		 */
		EClass NEBULA_NAT_TABLE = eINSTANCE.getNebulaNatTable();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.tesla.nebula.nattable.ecl.nattable.impl.GetNebulaNatTableImpl <em>Get Nebula Nat Table</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.tesla.nebula.nattable.ecl.nattable.impl.GetNebulaNatTableImpl
		 * @see org.eclipse.rcptt.tesla.nebula.nattable.ecl.nattable.impl.NattablePackageImpl#getGetNebulaNatTable()
		 * @generated
		 */
		EClass GET_NEBULA_NAT_TABLE = eINSTANCE.getGetNebulaNatTable();

	}

} //NattablePackage

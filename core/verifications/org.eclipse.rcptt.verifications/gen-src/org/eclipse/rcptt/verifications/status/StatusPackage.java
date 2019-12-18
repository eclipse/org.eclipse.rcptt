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
package org.eclipse.rcptt.verifications.status;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.rcptt.ecl.core.CorePackage;

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
 * @see org.eclipse.rcptt.verifications.status.StatusFactory
 * @model kind="package"
 * @generated
 */
public interface StatusPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "status";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://eclipse.org/rcptt/verifications/status";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.eclipse.rcptt.verifications.status";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	StatusPackage eINSTANCE = org.eclipse.rcptt.verifications.status.impl.StatusPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.verifications.status.impl.EVerificationStatusImpl <em>EVerification Status</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.verifications.status.impl.EVerificationStatusImpl
	 * @see org.eclipse.rcptt.verifications.status.impl.StatusPackageImpl#getEVerificationStatus()
	 * @generated
	 */
	int EVERIFICATION_STATUS = 0;

	/**
	 * The feature id for the '<em><b>Plugin Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVERIFICATION_STATUS__PLUGIN_ID = CorePackage.PROCESS_STATUS__PLUGIN_ID;

	/**
	 * The feature id for the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVERIFICATION_STATUS__CODE = CorePackage.PROCESS_STATUS__CODE;

	/**
	 * The feature id for the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVERIFICATION_STATUS__MESSAGE = CorePackage.PROCESS_STATUS__MESSAGE;

	/**
	 * The feature id for the '<em><b>Severity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVERIFICATION_STATUS__SEVERITY = CorePackage.PROCESS_STATUS__SEVERITY;

	/**
	 * The feature id for the '<em><b>Exception</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVERIFICATION_STATUS__EXCEPTION = CorePackage.PROCESS_STATUS__EXCEPTION;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVERIFICATION_STATUS__CHILDREN = CorePackage.PROCESS_STATUS__CHILDREN;

	/**
	 * The feature id for the '<em><b>Resource</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVERIFICATION_STATUS__RESOURCE = CorePackage.PROCESS_STATUS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVERIFICATION_STATUS__DATA = CorePackage.PROCESS_STATUS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>EVerification Status</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVERIFICATION_STATUS_FEATURE_COUNT = CorePackage.PROCESS_STATUS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.verifications.status.impl.VerificationStatusDataImpl <em>Verification Status Data</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.verifications.status.impl.VerificationStatusDataImpl
	 * @see org.eclipse.rcptt.verifications.status.impl.StatusPackageImpl#getVerificationStatusData()
	 * @generated
	 */
	int VERIFICATION_STATUS_DATA = 1;

	/**
	 * The feature id for the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERIFICATION_STATUS_DATA__MESSAGE = 0;

	/**
	 * The feature id for the '<em><b>Resource Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERIFICATION_STATUS_DATA__RESOURCE_ID = 1;

	/**
	 * The number of structural features of the '<em>Verification Status Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERIFICATION_STATUS_DATA_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.verifications.status.impl.TreeItemVerificationErrorImpl <em>Tree Item Verification Error</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.verifications.status.impl.TreeItemVerificationErrorImpl
	 * @see org.eclipse.rcptt.verifications.status.impl.StatusPackageImpl#getTreeItemVerificationError()
	 * @generated
	 */
	int TREE_ITEM_VERIFICATION_ERROR = 2;

	/**
	 * The feature id for the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_ITEM_VERIFICATION_ERROR__MESSAGE = VERIFICATION_STATUS_DATA__MESSAGE;

	/**
	 * The feature id for the '<em><b>Resource Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_ITEM_VERIFICATION_ERROR__RESOURCE_ID = VERIFICATION_STATUS_DATA__RESOURCE_ID;

	/**
	 * The feature id for the '<em><b>Item Index Path</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_ITEM_VERIFICATION_ERROR__ITEM_INDEX_PATH = VERIFICATION_STATUS_DATA_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Item Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_ITEM_VERIFICATION_ERROR__ITEM_PATH = VERIFICATION_STATUS_DATA_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_ITEM_VERIFICATION_ERROR__COLUMN = VERIFICATION_STATUS_DATA_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Tree Item Verification Error</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_ITEM_VERIFICATION_ERROR_FEATURE_COUNT = VERIFICATION_STATUS_DATA_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.verifications.status.impl.TreeItemStyleVerificationErrorImpl <em>Tree Item Style Verification Error</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.verifications.status.impl.TreeItemStyleVerificationErrorImpl
	 * @see org.eclipse.rcptt.verifications.status.impl.StatusPackageImpl#getTreeItemStyleVerificationError()
	 * @generated
	 */
	int TREE_ITEM_STYLE_VERIFICATION_ERROR = 3;

	/**
	 * The feature id for the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_ITEM_STYLE_VERIFICATION_ERROR__MESSAGE = TREE_ITEM_VERIFICATION_ERROR__MESSAGE;

	/**
	 * The feature id for the '<em><b>Resource Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_ITEM_STYLE_VERIFICATION_ERROR__RESOURCE_ID = TREE_ITEM_VERIFICATION_ERROR__RESOURCE_ID;

	/**
	 * The feature id for the '<em><b>Item Index Path</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_ITEM_STYLE_VERIFICATION_ERROR__ITEM_INDEX_PATH = TREE_ITEM_VERIFICATION_ERROR__ITEM_INDEX_PATH;

	/**
	 * The feature id for the '<em><b>Item Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_ITEM_STYLE_VERIFICATION_ERROR__ITEM_PATH = TREE_ITEM_VERIFICATION_ERROR__ITEM_PATH;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_ITEM_STYLE_VERIFICATION_ERROR__COLUMN = TREE_ITEM_VERIFICATION_ERROR__COLUMN;

	/**
	 * The feature id for the '<em><b>Expected Style</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_ITEM_STYLE_VERIFICATION_ERROR__EXPECTED_STYLE = TREE_ITEM_VERIFICATION_ERROR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Actual Style</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_ITEM_STYLE_VERIFICATION_ERROR__ACTUAL_STYLE = TREE_ITEM_VERIFICATION_ERROR_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Tree Item Style Verification Error</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_ITEM_STYLE_VERIFICATION_ERROR_FEATURE_COUNT = TREE_ITEM_VERIFICATION_ERROR_FEATURE_COUNT + 2;

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.verifications.status.EVerificationStatus <em>EVerification Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EVerification Status</em>'.
	 * @see org.eclipse.rcptt.verifications.status.EVerificationStatus
	 * @generated
	 */
	EClass getEVerificationStatus();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.verifications.status.EVerificationStatus#getResource <em>Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Resource</em>'.
	 * @see org.eclipse.rcptt.verifications.status.EVerificationStatus#getResource()
	 * @see #getEVerificationStatus()
	 * @generated
	 */
	EAttribute getEVerificationStatus_Resource();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.rcptt.verifications.status.EVerificationStatus#getData <em>Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Data</em>'.
	 * @see org.eclipse.rcptt.verifications.status.EVerificationStatus#getData()
	 * @see #getEVerificationStatus()
	 * @generated
	 */
	EReference getEVerificationStatus_Data();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.verifications.status.VerificationStatusData <em>Verification Status Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Verification Status Data</em>'.
	 * @see org.eclipse.rcptt.verifications.status.VerificationStatusData
	 * @generated
	 */
	EClass getVerificationStatusData();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.verifications.status.VerificationStatusData#getMessage <em>Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Message</em>'.
	 * @see org.eclipse.rcptt.verifications.status.VerificationStatusData#getMessage()
	 * @see #getVerificationStatusData()
	 * @generated
	 */
	EAttribute getVerificationStatusData_Message();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.verifications.status.VerificationStatusData#getResourceId <em>Resource Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Resource Id</em>'.
	 * @see org.eclipse.rcptt.verifications.status.VerificationStatusData#getResourceId()
	 * @see #getVerificationStatusData()
	 * @generated
	 */
	EAttribute getVerificationStatusData_ResourceId();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.verifications.status.TreeItemVerificationError <em>Tree Item Verification Error</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tree Item Verification Error</em>'.
	 * @see org.eclipse.rcptt.verifications.status.TreeItemVerificationError
	 * @generated
	 */
	EClass getTreeItemVerificationError();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.rcptt.verifications.status.TreeItemVerificationError#getItemIndexPath <em>Item Index Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Item Index Path</em>'.
	 * @see org.eclipse.rcptt.verifications.status.TreeItemVerificationError#getItemIndexPath()
	 * @see #getTreeItemVerificationError()
	 * @generated
	 */
	EAttribute getTreeItemVerificationError_ItemIndexPath();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.verifications.status.TreeItemVerificationError#getItemPath <em>Item Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Item Path</em>'.
	 * @see org.eclipse.rcptt.verifications.status.TreeItemVerificationError#getItemPath()
	 * @see #getTreeItemVerificationError()
	 * @generated
	 */
	EAttribute getTreeItemVerificationError_ItemPath();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.verifications.status.TreeItemVerificationError#getColumn <em>Column</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Column</em>'.
	 * @see org.eclipse.rcptt.verifications.status.TreeItemVerificationError#getColumn()
	 * @see #getTreeItemVerificationError()
	 * @generated
	 */
	EAttribute getTreeItemVerificationError_Column();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.verifications.status.TreeItemStyleVerificationError <em>Tree Item Style Verification Error</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tree Item Style Verification Error</em>'.
	 * @see org.eclipse.rcptt.verifications.status.TreeItemStyleVerificationError
	 * @generated
	 */
	EClass getTreeItemStyleVerificationError();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.rcptt.verifications.status.TreeItemStyleVerificationError#getExpectedStyle <em>Expected Style</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expected Style</em>'.
	 * @see org.eclipse.rcptt.verifications.status.TreeItemStyleVerificationError#getExpectedStyle()
	 * @see #getTreeItemStyleVerificationError()
	 * @generated
	 */
	EReference getTreeItemStyleVerificationError_ExpectedStyle();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.rcptt.verifications.status.TreeItemStyleVerificationError#getActualStyle <em>Actual Style</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Actual Style</em>'.
	 * @see org.eclipse.rcptt.verifications.status.TreeItemStyleVerificationError#getActualStyle()
	 * @see #getTreeItemStyleVerificationError()
	 * @generated
	 */
	EReference getTreeItemStyleVerificationError_ActualStyle();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	StatusFactory getStatusFactory();

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
		 * The meta object literal for the '{@link org.eclipse.rcptt.verifications.status.impl.EVerificationStatusImpl <em>EVerification Status</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.verifications.status.impl.EVerificationStatusImpl
		 * @see org.eclipse.rcptt.verifications.status.impl.StatusPackageImpl#getEVerificationStatus()
		 * @generated
		 */
		EClass EVERIFICATION_STATUS = eINSTANCE.getEVerificationStatus();

		/**
		 * The meta object literal for the '<em><b>Resource</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVERIFICATION_STATUS__RESOURCE = eINSTANCE.getEVerificationStatus_Resource();

		/**
		 * The meta object literal for the '<em><b>Data</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVERIFICATION_STATUS__DATA = eINSTANCE.getEVerificationStatus_Data();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.verifications.status.impl.VerificationStatusDataImpl <em>Verification Status Data</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.verifications.status.impl.VerificationStatusDataImpl
		 * @see org.eclipse.rcptt.verifications.status.impl.StatusPackageImpl#getVerificationStatusData()
		 * @generated
		 */
		EClass VERIFICATION_STATUS_DATA = eINSTANCE.getVerificationStatusData();

		/**
		 * The meta object literal for the '<em><b>Message</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VERIFICATION_STATUS_DATA__MESSAGE = eINSTANCE.getVerificationStatusData_Message();

		/**
		 * The meta object literal for the '<em><b>Resource Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VERIFICATION_STATUS_DATA__RESOURCE_ID = eINSTANCE.getVerificationStatusData_ResourceId();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.verifications.status.impl.TreeItemVerificationErrorImpl <em>Tree Item Verification Error</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.verifications.status.impl.TreeItemVerificationErrorImpl
		 * @see org.eclipse.rcptt.verifications.status.impl.StatusPackageImpl#getTreeItemVerificationError()
		 * @generated
		 */
		EClass TREE_ITEM_VERIFICATION_ERROR = eINSTANCE.getTreeItemVerificationError();

		/**
		 * The meta object literal for the '<em><b>Item Index Path</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TREE_ITEM_VERIFICATION_ERROR__ITEM_INDEX_PATH = eINSTANCE.getTreeItemVerificationError_ItemIndexPath();

		/**
		 * The meta object literal for the '<em><b>Item Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TREE_ITEM_VERIFICATION_ERROR__ITEM_PATH = eINSTANCE.getTreeItemVerificationError_ItemPath();

		/**
		 * The meta object literal for the '<em><b>Column</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TREE_ITEM_VERIFICATION_ERROR__COLUMN = eINSTANCE.getTreeItemVerificationError_Column();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.verifications.status.impl.TreeItemStyleVerificationErrorImpl <em>Tree Item Style Verification Error</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.verifications.status.impl.TreeItemStyleVerificationErrorImpl
		 * @see org.eclipse.rcptt.verifications.status.impl.StatusPackageImpl#getTreeItemStyleVerificationError()
		 * @generated
		 */
		EClass TREE_ITEM_STYLE_VERIFICATION_ERROR = eINSTANCE.getTreeItemStyleVerificationError();

		/**
		 * The meta object literal for the '<em><b>Expected Style</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TREE_ITEM_STYLE_VERIFICATION_ERROR__EXPECTED_STYLE = eINSTANCE.getTreeItemStyleVerificationError_ExpectedStyle();

		/**
		 * The meta object literal for the '<em><b>Actual Style</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TREE_ITEM_STYLE_VERIFICATION_ERROR__ACTUAL_STYLE = eINSTANCE.getTreeItemStyleVerificationError_ActualStyle();

	}

} //StatusPackage

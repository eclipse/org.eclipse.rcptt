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
package org.eclipse.rcptt.sherlock.core.model.sherlock.report;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Builder Store</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.sherlock.core.model.sherlock.report.ReportBuilderStore#getReport <em>Report</em>}</li>
 *   <li>{@link org.eclipse.rcptt.sherlock.core.model.sherlock.report.ReportBuilderStore#getCurrentNode <em>Current Node</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.report.ReportPackage#getReportBuilderStore()
 * @model
 * @generated
 */
public interface ReportBuilderStore extends EObject {
	/**
	 * Returns the value of the '<em><b>Report</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Report</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Report</em>' containment reference.
	 * @see #setReport(Report)
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.report.ReportPackage#getReportBuilderStore_Report()
	 * @model containment="true"
	 * @generated
	 */
	Report getReport();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.report.ReportBuilderStore#getReport <em>Report</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Report</em>' containment reference.
	 * @see #getReport()
	 * @generated
	 */
	void setReport(Report value);

	/**
	 * Returns the value of the '<em><b>Current Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Current Node</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Current Node</em>' reference.
	 * @see #setCurrentNode(Node)
	 * @see org.eclipse.rcptt.sherlock.core.model.sherlock.report.ReportPackage#getReportBuilderStore_CurrentNode()
	 * @model
	 * @generated
	 */
	Node getCurrentNode();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.sherlock.core.model.sherlock.report.ReportBuilderStore#getCurrentNode <em>Current Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Current Node</em>' reference.
	 * @see #getCurrentNode()
	 * @generated
	 */
	void setCurrentNode(Node value);

} // ReportBuilderStore

/*******************************************************************************
 * Copyright (c) 2009, 2015 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.tesla.ecl.model;


import org.eclipse.emf.ecore.EObject;

import org.eclipse.rcptt.tesla.core.protocol.ElementKind;
import org.eclipse.rcptt.tesla.core.protocol.SelectCommand;
import org.eclipse.rcptt.tesla.core.protocol.raw.Element;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Control Handler</b></em>'.
 * Represents a control on the AUT window.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.model.ControlHandler#getKind <em>Kind</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.model.ControlHandler#getCustomKindId <em>Custom Kind Id</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.model.ControlHandler#getText <em>Text</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.model.ControlHandler#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.model.ControlHandler#getIndex <em>Index</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.model.ControlHandler#getPath <em>Path</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.model.ControlHandler#getIndexes <em>Indexes</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.model.ControlHandler#getAfter <em>After</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.model.ControlHandler#getParent <em>Parent</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.model.ControlHandler#getResolved <em>Resolved</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.model.ControlHandler#getRow <em>Row</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.model.ControlHandler#getColumn <em>Column</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.model.ControlHandler#getX <em>X</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.model.ControlHandler#getY <em>Y</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.model.ControlHandler#getRawImage <em>Raw Image</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getControlHandler()
 * @model
 * @generated
 */
public interface ControlHandler extends EObject {
	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see #setKind(ElementKind)
	 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getControlHandler_Kind()
	 * @model dataType="org.eclipse.rcptt.tesla.ecl.model.ElementKind"
	 * @generated
	 */
	ElementKind getKind();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.model.ControlHandler#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see #getKind()
	 * @generated
	 */
	void setKind(ElementKind value);

	/**
	 * Returns the value of the '<em><b>Custom Kind Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Custom Kind Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Custom Kind Id</em>' attribute.
	 * @see #setCustomKindId(String)
	 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getControlHandler_CustomKindId()
	 * @model
	 * @generated
	 */
	String getCustomKindId();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.model.ControlHandler#getCustomKindId <em>Custom Kind Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Custom Kind Id</em>' attribute.
	 * @see #getCustomKindId()
	 * @generated
	 */
	void setCustomKindId(String value);

	/**
	 * Returns the value of the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Text</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Text</em>' attribute.
	 * @see #setText(String)
	 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getControlHandler_Text()
	 * @model
	 * @generated
	 */
	String getText();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.model.ControlHandler#getText <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Text</em>' attribute.
	 * @see #getText()
	 * @generated
	 */
	void setText(String value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(String)
	 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getControlHandler_Type()
	 * @model annotation="http://www.eclipse.org/ecl/docs description='Indicates the type of a control, if there are any types.'"
	 * @generated
	 */
	String getType();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.model.ControlHandler#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);

	/**
	 * Returns the value of the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Index</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Index</em>' attribute.
	 * @see #setIndex(Integer)
	 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getControlHandler_Index()
	 * @model
	 * @generated
	 */
	Integer getIndex();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.model.ControlHandler#getIndex <em>Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Index</em>' attribute.
	 * @see #getIndex()
	 * @generated
	 */
	void setIndex(Integer value);

	/**
	 * Returns the value of the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Path</em>' attribute.
	 * @see #setPath(String)
	 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getControlHandler_Path()
	 * @model
	 * @generated
	 */
	String getPath();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.model.ControlHandler#getPath <em>Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Path</em>' attribute.
	 * @see #getPath()
	 * @generated
	 */
	void setPath(String value);

	/**
	 * Returns the value of the '<em><b>Indexes</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Indexes</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Indexes</em>' attribute.
	 * @see #setIndexes(String)
	 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getControlHandler_Indexes()
	 * @model
	 * @generated
	 */
	String getIndexes();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.model.ControlHandler#getIndexes <em>Indexes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Indexes</em>' attribute.
	 * @see #getIndexes()
	 * @generated
	 */
	void setIndexes(String value);

	/**
	 * Returns the value of the '<em><b>After</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>After</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>After</em>' reference.
	 * @see #setAfter(ControlHandler)
	 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getControlHandler_After()
	 * @model
	 * @generated
	 */
	ControlHandler getAfter();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.model.ControlHandler#getAfter <em>After</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>After</em>' reference.
	 * @see #getAfter()
	 * @generated
	 */
	void setAfter(ControlHandler value);

	/**
	 * Returns the value of the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' reference.
	 * @see #setParent(ControlHandler)
	 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getControlHandler_Parent()
	 * @model
	 * @generated
	 */
	ControlHandler getParent();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.model.ControlHandler#getParent <em>Parent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(ControlHandler value);

	/**
	 * Returns the value of the '<em><b>Resolved</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>
	 * Some {@link ControlHandler} can be resolved into an Element identifier by calling TeslaBridge.find method, which does it by indirectly running a {@link SelectCommand} on the player.
	 * <p>
	 * See {@link Element} class documentation for the information on how to get an UIElement wrap (like SWTUIElement) from an Element identifier.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Resolved</em>' reference.
	 * @see #setResolved(Element)
	 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getControlHandler_Resolved()
	 * @model
	 * @generated
	 */
	Element getResolved();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.model.ControlHandler#getResolved <em>Resolved</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resolved</em>' reference.
	 * @see #getResolved()
	 * @generated
	 */
	void setResolved(Element value);

	/**
	 * Returns the value of the '<em><b>Row</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Row</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Row</em>' attribute.
	 * @see #setRow(Integer)
	 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getControlHandler_Row()
	 * @model
	 * @generated
	 */
	Integer getRow();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.model.ControlHandler#getRow <em>Row</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Row</em>' attribute.
	 * @see #getRow()
	 * @generated
	 */
	void setRow(Integer value);

	/**
	 * Returns the value of the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Column</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Column</em>' attribute.
	 * @see #setColumn(Integer)
	 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getControlHandler_Column()
	 * @model
	 * @generated
	 */
	Integer getColumn();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.model.ControlHandler#getColumn <em>Column</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Column</em>' attribute.
	 * @see #getColumn()
	 * @generated
	 */
	void setColumn(Integer value);

	/**
	 * Returns the value of the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>X</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>X</em>' attribute.
	 * @see #setX(int)
	 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getControlHandler_X()
	 * @model
	 * @generated
	 */
	int getX();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.model.ControlHandler#getX <em>X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>X</em>' attribute.
	 * @see #getX()
	 * @generated
	 */
	void setX(int value);

	/**
	 * Returns the value of the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Y</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Y</em>' attribute.
	 * @see #setY(int)
	 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getControlHandler_Y()
	 * @model
	 * @generated
	 */
	int getY();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.model.ControlHandler#getY <em>Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Y</em>' attribute.
	 * @see #getY()
	 * @generated
	 */
	void setY(int value);

	/**
	 * Returns the value of the '<em><b>Raw Image</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Raw Image</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Raw Image</em>' attribute.
	 * @see #setRawImage(String)
	 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage#getControlHandler_RawImage()
	 * @model
	 * @generated
	 */
	String getRawImage();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.tesla.ecl.model.ControlHandler#getRawImage <em>Raw Image</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Raw Image</em>' attribute.
	 * @see #getRawImage()
	 * @generated
	 */
	void setRawImage(String value);

} // ControlHandler
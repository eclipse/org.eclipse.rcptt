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
package org.eclipse.rcptt.ecl.operations;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.rcptt.ecl.operations.OperationsPackage
 * @generated
 */
public interface OperationsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	OperationsFactory eINSTANCE = org.eclipse.rcptt.ecl.operations.impl.OperationsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Eq</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Eq</em>'.
	 * @generated
	 */
	Eq createEq();

	/**
	 * Returns a new object of class '<em>Int</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Int</em>'.
	 * @generated
	 */
	Int createInt();

	/**
	 * Returns a new object of class '<em>Long</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Long</em>'.
	 * @generated
	 */
	Long createLong();

	/**
	 * Returns a new object of class '<em>Float</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Float</em>'.
	 * @generated
	 */
	Float createFloat();

	/**
	 * Returns a new object of class '<em>Bool</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Bool</em>'.
	 * @generated
	 */
	Bool createBool();

	/**
	 * Returns a new object of class '<em>Str</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Str</em>'.
	 * @generated
	 */
	Str createStr();

	/**
	 * Returns a new object of class '<em>Assert True</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Assert True</em>'.
	 * @generated
	 */
	AssertTrue createAssertTrue();

	/**
	 * Returns a new object of class '<em>Length</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Length</em>'.
	 * @generated
	 */
	Length createLength();

	/**
	 * Returns a new object of class '<em>Not Eq</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Not Eq</em>'.
	 * @generated
	 */
	NotEq createNotEq();

	/**
	 * Returns a new object of class '<em>Gt</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Gt</em>'.
	 * @generated
	 */
	Gt createGt();

	/**
	 * Returns a new object of class '<em>Lt</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Lt</em>'.
	 * @generated
	 */
	Lt createLt();

	/**
	 * Returns a new object of class '<em>Not</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Not</em>'.
	 * @generated
	 */
	Not createNot();

	/**
	 * Returns a new object of class '<em>Try</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Try</em>'.
	 * @generated
	 */
	Try createTry();

	/**
	 * Returns a new object of class '<em>Format</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Format</em>'.
	 * @generated
	 */
	Format createFormat();

	/**
	 * Returns a new object of class '<em>Emit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Emit</em>'.
	 * @generated
	 */
	Emit createEmit();

	/**
	 * Returns a new object of class '<em>Repeat With</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Repeat With</em>'.
	 * @generated
	 */
	RepeatWith createRepeatWith();

	/**
	 * Returns a new object of class '<em>Repeat</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Repeat</em>'.
	 * @generated
	 */
	Repeat createRepeat();

	/**
	 * Returns a new object of class '<em>Assert Empty</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Assert Empty</em>'.
	 * @generated
	 */
	AssertEmpty createAssertEmpty();

	/**
	 * Returns a new object of class '<em>Assert Non Empty</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Assert Non Empty</em>'.
	 * @generated
	 */
	AssertNonEmpty createAssertNonEmpty();

	/**
	 * Returns a new object of class '<em>Concat</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Concat</em>'.
	 * @generated
	 */
	Concat createConcat();

	/**
	 * Returns a new object of class '<em>Or</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Or</em>'.
	 * @generated
	 */
	Or createOr();

	/**
	 * Returns a new object of class '<em>And</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>And</em>'.
	 * @generated
	 */
	And createAnd();

	/**
	 * Returns a new object of class '<em>Get Time</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Get Time</em>'.
	 * @generated
	 */
	GetTime createGetTime();

	/**
	 * Returns a new object of class '<em>Format Time</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Format Time</em>'.
	 * @generated
	 */
	FormatTime createFormatTime();

	/**
	 * Returns a new object of class '<em>Plus</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Plus</em>'.
	 * @generated
	 */
	Plus createPlus();

	/**
	 * Returns a new object of class '<em>Minus</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Minus</em>'.
	 * @generated
	 */
	Minus createMinus();

	/**
	 * Returns a new object of class '<em>Div</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Div</em>'.
	 * @generated
	 */
	Div createDiv();

	/**
	 * Returns a new object of class '<em>Mult</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mult</em>'.
	 * @generated
	 */
	Mult createMult();

	/**
	 * Returns a new object of class '<em>Abs</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Abs</em>'.
	 * @generated
	 */
	Abs createAbs();

	/**
	 * Returns a new object of class '<em>Mod</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mod</em>'.
	 * @generated
	 */
	Mod createMod();

	/**
	 * Returns a new object of class '<em>Between</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Between</em>'.
	 * @generated
	 */
	Between createBetween();

	/**
	 * Returns a new object of class '<em>Entry</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Entry</em>'.
	 * @generated
	 */
	Entry createEntry();

	/**
	 * Returns a new object of class '<em>Map</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Map</em>'.
	 * @generated
	 */
	Map createMap();

	/**
	 * Returns a new object of class '<em>List</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>List</em>'.
	 * @generated
	 */
	List createList();

	/**
	 * Returns a new object of class '<em>Loop</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Loop</em>'.
	 * @generated
	 */
	Loop createLoop();

	/**
	 * Returns a new object of class '<em>Recur</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Recur</em>'.
	 * @generated
	 */
	Recur createRecur();

	/**
	 * Returns a new object of class '<em>To List</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>To List</em>'.
	 * @generated
	 */
	ToList createToList();

	/**
	 * Returns a new object of class '<em>Each</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Each</em>'.
	 * @generated
	 */
	Each createEach();

	/**
	 * Returns a new object of class '<em>Split</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Split</em>'.
	 * @generated
	 */
	Split createSplit();

	/**
	 * Returns a new object of class '<em>Binary Op</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Binary Op</em>'.
	 * @generated
	 */
	BinaryOp createBinaryOp();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	OperationsPackage getOperationsPackage();

} //OperationsFactory

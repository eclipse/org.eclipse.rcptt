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
package org.eclipse.rcptt.ecl.core;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.rcptt.ecl.core.CorePackage
 * @generated
 */
public interface CoreFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CoreFactory eINSTANCE = org.eclipse.rcptt.ecl.core.impl.CoreFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Command</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Command</em>'.
	 * @generated
	 */
	Command createCommand();

	/**
	 * Returns a new object of class '<em>Binding</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Binding</em>'.
	 * @generated
	 */
	Binding createBinding();

	/**
	 * Returns a new object of class '<em>Pipeline</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Pipeline</em>'.
	 * @generated
	 */
	Pipeline createPipeline();

	/**
	 * Returns a new object of class '<em>Sequence</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sequence</em>'.
	 * @generated
	 */
	Sequence createSequence();

	/**
	 * Returns a new object of class '<em>Parallel</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Parallel</em>'.
	 * @generated
	 */
	Parallel createParallel();

	/**
	 * Returns a new object of class '<em>With</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>With</em>'.
	 * @generated
	 */
	With createWith();

	/**
	 * Returns a new object of class '<em>Exec</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Exec</em>'.
	 * @generated
	 */
	Exec createExec();

	/**
	 * Returns a new object of class '<em>Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Parameter</em>'.
	 * @generated
	 */
	Parameter createParameter();

	/**
	 * Returns a new object of class '<em>Executable Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Executable Parameter</em>'.
	 * @generated
	 */
	ExecutableParameter createExecutableParameter();

	/**
	 * Returns a new object of class '<em>Literal Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Literal Parameter</em>'.
	 * @generated
	 */
	LiteralParameter createLiteralParameter();

	/**
	 * Returns a new object of class '<em>Foreach</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Foreach</em>'.
	 * @generated
	 */
	Foreach createForeach();

	/**
	 * Returns a new object of class '<em>Process Status</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Process Status</em>'.
	 * @generated
	 */
	ProcessStatus createProcessStatus();

	/**
	 * Returns a new object of class '<em>Converted To EMF Pipe</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Converted To EMF Pipe</em>'.
	 * @generated
	 */
	ConvertedToEMFPipe createConvertedToEMFPipe();

	/**
	 * Returns a new object of class '<em>Serialized</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Serialized</em>'.
	 * @generated
	 */
	Serialized createSerialized();

	/**
	 * Returns a new object of class '<em>Nullable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Nullable</em>'.
	 * @generated
	 */
	Nullable createNullable();

	/**
	 * Returns a new object of class '<em>If</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>If</em>'.
	 * @generated
	 */
	If createIf();

	/**
	 * Returns a new object of class '<em>Ecl Byte</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ecl Byte</em>'.
	 * @generated
	 */
	EclByte createEclByte();

	/**
	 * Returns a new object of class '<em>Ecl Short</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ecl Short</em>'.
	 * @generated
	 */
	EclShort createEclShort();

	/**
	 * Returns a new object of class '<em>Ecl String</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ecl String</em>'.
	 * @generated
	 */
	EclString createEclString();

	/**
	 * Returns a new object of class '<em>Ecl Exception</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ecl Exception</em>'.
	 * @generated
	 */
	EclException createEclException();

	/**
	 * Returns a new object of class '<em>Ecl Stack Trace Entry</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ecl Stack Trace Entry</em>'.
	 * @generated
	 */
	EclStackTraceEntry createEclStackTraceEntry();

	/**
	 * Returns a new object of class '<em>Listen</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Listen</em>'.
	 * @generated
	 */
	Listen createListen();

	/**
	 * Returns a new object of class '<em>Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Declaration</em>'.
	 * @generated
	 */
	Declaration createDeclaration();

	/**
	 * Returns a new object of class '<em>Val</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Val</em>'.
	 * @generated
	 */
	Val createVal();

	/**
	 * Returns a new object of class '<em>Get Val</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Get Val</em>'.
	 * @generated
	 */
	GetVal createGetVal();

	/**
	 * Returns a new object of class '<em>Let</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Let</em>'.
	 * @generated
	 */
	Let createLet();

	/**
	 * Returns a new object of class '<em>Proc</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Proc</em>'.
	 * @generated
	 */
	Proc createProc();

	/**
	 * Returns a new object of class '<em>Proc Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Proc Instance</em>'.
	 * @generated
	 */
	ProcInstance createProcInstance();

	/**
	 * Returns a new object of class '<em>Global</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Global</em>'.
	 * @generated
	 */
	Global createGlobal();

	/**
	 * Returns a new object of class '<em>Session State</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Session State</em>'.
	 * @generated
	 */
	SessionState createSessionState();

	/**
	 * Returns a new object of class '<em>Save State</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Save State</em>'.
	 * @generated
	 */
	SaveState createSaveState();

	/**
	 * Returns a new object of class '<em>Restore State</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Restore State</em>'.
	 * @generated
	 */
	RestoreState createRestoreState();

	/**
	 * Returns a new object of class '<em>Get</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Get</em>'.
	 * @generated
	 */
	Get createGet();

	/**
	 * Returns a new object of class '<em>Ecl List</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ecl List</em>'.
	 * @generated
	 */
	EclList createEclList();

	/**
	 * Returns a new object of class '<em>Ecl Map</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ecl Map</em>'.
	 * @generated
	 */
	EclMap createEclMap();

	/**
	 * Returns a new object of class '<em>Ecl Map Entry</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ecl Map Entry</em>'.
	 * @generated
	 */
	EclMapEntry createEclMapEntry();

	/**
	 * Returns a new object of class '<em>Ecl Boolean</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ecl Boolean</em>'.
	 * @generated
	 */
	EclBoolean createEclBoolean();

	/**
	 * Returns a new object of class '<em>Ecl Char</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ecl Char</em>'.
	 * @generated
	 */
	EclChar createEclChar();

	/**
	 * Returns a new object of class '<em>Ecl Integer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ecl Integer</em>'.
	 * @generated
	 */
	EclInteger createEclInteger();

	/**
	 * Returns a new object of class '<em>Ecl Float</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ecl Float</em>'.
	 * @generated
	 */
	EclFloat createEclFloat();

	/**
	 * Returns a new object of class '<em>Ecl Long</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ecl Long</em>'.
	 * @generated
	 */
	EclLong createEclLong();

	/**
	 * Returns a new object of class '<em>Ecl Double</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ecl Double</em>'.
	 * @generated
	 */
	EclDouble createEclDouble();

	/**
	 * Returns a new object of class '<em>Script</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Script</em>'.
	 * @generated
	 */
	Script createScript();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	CorePackage getCorePackage();

} //CoreFactory

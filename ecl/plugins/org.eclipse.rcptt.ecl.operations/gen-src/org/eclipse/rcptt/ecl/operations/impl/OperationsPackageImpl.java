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
package org.eclipse.rcptt.ecl.operations.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.rcptt.ecl.core.CorePackage;
import org.eclipse.rcptt.ecl.operations.Abs;
import org.eclipse.rcptt.ecl.operations.And;
import org.eclipse.rcptt.ecl.operations.AssertEmpty;
import org.eclipse.rcptt.ecl.operations.AssertNonEmpty;
import org.eclipse.rcptt.ecl.operations.AssertTrue;
import org.eclipse.rcptt.ecl.operations.Between;
import org.eclipse.rcptt.ecl.operations.BinaryOp;
import org.eclipse.rcptt.ecl.operations.Bool;
import org.eclipse.rcptt.ecl.operations.Concat;
import org.eclipse.rcptt.ecl.operations.Convert;
import org.eclipse.rcptt.ecl.operations.Div;
import org.eclipse.rcptt.ecl.operations.Each;
import org.eclipse.rcptt.ecl.operations.Emit;
import org.eclipse.rcptt.ecl.operations.Entry;
import org.eclipse.rcptt.ecl.operations.Eq;
import org.eclipse.rcptt.ecl.operations.Format;
import org.eclipse.rcptt.ecl.operations.FormatTime;
import org.eclipse.rcptt.ecl.operations.GetTime;
import org.eclipse.rcptt.ecl.operations.Gt;
import org.eclipse.rcptt.ecl.operations.Int;
import org.eclipse.rcptt.ecl.operations.Length;
import org.eclipse.rcptt.ecl.operations.List;
import org.eclipse.rcptt.ecl.operations.Loop;
import org.eclipse.rcptt.ecl.operations.Lt;
import org.eclipse.rcptt.ecl.operations.Map;
import org.eclipse.rcptt.ecl.operations.Minus;
import org.eclipse.rcptt.ecl.operations.Mod;
import org.eclipse.rcptt.ecl.operations.Mult;
import org.eclipse.rcptt.ecl.operations.Not;
import org.eclipse.rcptt.ecl.operations.NotEq;
import org.eclipse.rcptt.ecl.operations.OperationsFactory;
import org.eclipse.rcptt.ecl.operations.OperationsPackage;
import org.eclipse.rcptt.ecl.operations.Or;
import org.eclipse.rcptt.ecl.operations.ParseTime;
import org.eclipse.rcptt.ecl.operations.Plus;
import org.eclipse.rcptt.ecl.operations.Recur;
import org.eclipse.rcptt.ecl.operations.Repeat;
import org.eclipse.rcptt.ecl.operations.RepeatWith;
import org.eclipse.rcptt.ecl.operations.Split;
import org.eclipse.rcptt.ecl.operations.Str;
import org.eclipse.rcptt.ecl.operations.ToList;
import org.eclipse.rcptt.ecl.operations.Try;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!--
 * end-user-doc -->
 * @generated
 */
public class OperationsPackageImpl extends EPackageImpl implements
		OperationsPackage {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eqEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass intEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass longEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass floatEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass boolEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass strEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass convertEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass assertTrueEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass lengthEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass notEqEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass gtEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ltEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass notEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tryEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass formatEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass emitEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass repeatWithEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass repeatEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass assertEmptyEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass assertNonEmptyEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass concatEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass orEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass andEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass getTimeEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass formatTimeEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass plusEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass minusEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass divEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass multEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass absEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass betweenEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass entryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mapEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass listEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass loopEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass recurEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass toListEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eachEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass splitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parseTimeEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass binaryOpEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with {@link org.eclipse.emf.ecore.EPackage.Registry
	 * EPackage.Registry} by the
	 * package package URI value.
	 * <p>
	 * Note: the correct way to create the package is via the static factory method {@link #init init()}, which also
	 * performs initialization of the package, or returns the registered package, if one already exists. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.rcptt.ecl.operations.OperationsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private OperationsPackageImpl() {
		super(eNS_URI, OperationsFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link OperationsPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static OperationsPackage init() {
		if (isInited) return (OperationsPackage)EPackage.Registry.INSTANCE.getEPackage(OperationsPackage.eNS_URI);

		// Obtain or create and register package
		OperationsPackageImpl theOperationsPackage = (OperationsPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof OperationsPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new OperationsPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		CorePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theOperationsPackage.createPackageContents();

		// Initialize created meta-data
		theOperationsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theOperationsPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(OperationsPackage.eNS_URI, theOperationsPackage);
		return theOperationsPackage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEq() {
		return eqEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEq_Left() {
		return (EReference)eqEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEq_Right() {
		return (EReference)eqEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInt() {
		return intEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLong() {
		return longEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFloat() {
		return floatEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBool() {
		return boolEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStr() {
		return strEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConvert() {
		return convertEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConvert_Input() {
		return (EReference)convertEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAssertTrue() {
		return assertTrueEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAssertTrue_Input() {
		return (EAttribute)assertTrueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAssertTrue_Message() {
		return (EAttribute)assertTrueEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLength() {
		return lengthEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLength_Input() {
		return (EReference)lengthEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNotEq() {
		return notEqEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNotEq_Left() {
		return (EReference)notEqEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNotEq_Right() {
		return (EReference)notEqEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGt() {
		return gtEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLt() {
		return ltEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNot() {
		return notEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNot_Left() {
		return (EReference)notEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTry() {
		return tryEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTry_Command() {
		return (EReference)tryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTry_Catch() {
		return (EReference)tryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTry_Finally() {
		return (EReference)tryEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTry_Times() {
		return (EAttribute)tryEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTry_Delay() {
		return (EAttribute)tryEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFormat() {
		return formatEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFormat_Format() {
		return (EAttribute)formatEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFormat_Args() {
		return (EReference)formatEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEmit() {
		return emitEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEmit_Values() {
		return (EReference)emitEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRepeatWith() {
		return repeatWithEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRepeatWith_Commands() {
		return (EReference)repeatWithEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRepeatWith_Command() {
		return (EReference)repeatWithEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRepeat() {
		return repeatEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRepeat_Index() {
		return (EReference)repeatEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRepeat_Times() {
		return (EAttribute)repeatEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRepeat_Command() {
		return (EReference)repeatEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRepeat_Delay() {
		return (EAttribute)repeatEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAssertEmpty() {
		return assertEmptyEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAssertEmpty_Message() {
		return (EAttribute)assertEmptyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAssertNonEmpty() {
		return assertNonEmptyEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAssertNonEmpty_Message() {
		return (EAttribute)assertNonEmptyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConcat() {
		return concatEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConcat_Strs() {
		return (EAttribute)concatEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOr() {
		return orEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOr_Args() {
		return (EReference)orEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAnd() {
		return andEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAnd_Args() {
		return (EReference)andEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGetTime() {
		return getTimeEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFormatTime() {
		return formatTimeEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFormatTime_Format() {
		return (EAttribute)formatTimeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPlus() {
		return plusEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMinus() {
		return minusEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDiv() {
		return divEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMult() {
		return multEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbs() {
		return absEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbs_Arg() {
		return (EReference)absEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMod() {
		return modEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBetween() {
		return betweenEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBetween_Input() {
		return (EReference)betweenEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBetween_Left() {
		return (EReference)betweenEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBetween_Right() {
		return (EReference)betweenEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEntry() {
		return entryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEntry_Key() {
		return (EReference)entryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEntry_Value() {
		return (EReference)entryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMap() {
		return mapEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMap_Entries() {
		return (EReference)mapEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getList() {
		return listEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getList_Items() {
		return (EReference)listEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLoop() {
		return loopEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLoop_Vals() {
		return (EReference)loopEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLoop_Body() {
		return (EReference)loopEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRecur() {
		return recurEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRecur_Values() {
		return (EReference)recurEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getToList() {
		return toListEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEach() {
		return eachEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEach_Input() {
		return (EReference)eachEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEach_Val() {
		return (EReference)eachEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEach_Key() {
		return (EReference)eachEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEach_Do() {
		return (EReference)eachEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSplit() {
		return splitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSplit_Str() {
		return (EAttribute)splitEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSplit_Sep() {
		return (EAttribute)splitEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSplit_TrimResults() {
		return (EAttribute)splitEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSplit_OmitEmptyStrings() {
		return (EAttribute)splitEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParseTime() {
		return parseTimeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParseTime_Format() {
		return (EAttribute)parseTimeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParseTime_Input() {
		return (EAttribute)parseTimeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBinaryOp() {
		return binaryOpEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBinaryOp_Left() {
		return (EReference)binaryOpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBinaryOp_Right() {
		return (EReference)binaryOpEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public OperationsFactory getOperationsFactory() {
		return (OperationsFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		eqEClass = createEClass(EQ);
		createEReference(eqEClass, EQ__LEFT);
		createEReference(eqEClass, EQ__RIGHT);

		intEClass = createEClass(INT);

		longEClass = createEClass(LONG);

		floatEClass = createEClass(FLOAT);

		boolEClass = createEClass(BOOL);

		strEClass = createEClass(STR);

		convertEClass = createEClass(CONVERT);
		createEReference(convertEClass, CONVERT__INPUT);

		assertTrueEClass = createEClass(ASSERT_TRUE);
		createEAttribute(assertTrueEClass, ASSERT_TRUE__INPUT);
		createEAttribute(assertTrueEClass, ASSERT_TRUE__MESSAGE);

		lengthEClass = createEClass(LENGTH);
		createEReference(lengthEClass, LENGTH__INPUT);

		notEqEClass = createEClass(NOT_EQ);
		createEReference(notEqEClass, NOT_EQ__LEFT);
		createEReference(notEqEClass, NOT_EQ__RIGHT);

		gtEClass = createEClass(GT);

		ltEClass = createEClass(LT);

		notEClass = createEClass(NOT);
		createEReference(notEClass, NOT__LEFT);

		tryEClass = createEClass(TRY);
		createEReference(tryEClass, TRY__COMMAND);
		createEReference(tryEClass, TRY__CATCH);
		createEReference(tryEClass, TRY__FINALLY);
		createEAttribute(tryEClass, TRY__TIMES);
		createEAttribute(tryEClass, TRY__DELAY);

		formatEClass = createEClass(FORMAT);
		createEAttribute(formatEClass, FORMAT__FORMAT);
		createEReference(formatEClass, FORMAT__ARGS);

		emitEClass = createEClass(EMIT);
		createEReference(emitEClass, EMIT__VALUES);

		repeatWithEClass = createEClass(REPEAT_WITH);
		createEReference(repeatWithEClass, REPEAT_WITH__COMMANDS);
		createEReference(repeatWithEClass, REPEAT_WITH__COMMAND);

		repeatEClass = createEClass(REPEAT);
		createEReference(repeatEClass, REPEAT__INDEX);
		createEAttribute(repeatEClass, REPEAT__TIMES);
		createEReference(repeatEClass, REPEAT__COMMAND);
		createEAttribute(repeatEClass, REPEAT__DELAY);

		assertEmptyEClass = createEClass(ASSERT_EMPTY);
		createEAttribute(assertEmptyEClass, ASSERT_EMPTY__MESSAGE);

		assertNonEmptyEClass = createEClass(ASSERT_NON_EMPTY);
		createEAttribute(assertNonEmptyEClass, ASSERT_NON_EMPTY__MESSAGE);

		concatEClass = createEClass(CONCAT);
		createEAttribute(concatEClass, CONCAT__STRS);

		orEClass = createEClass(OR);
		createEReference(orEClass, OR__ARGS);

		andEClass = createEClass(AND);
		createEReference(andEClass, AND__ARGS);

		getTimeEClass = createEClass(GET_TIME);

		formatTimeEClass = createEClass(FORMAT_TIME);
		createEAttribute(formatTimeEClass, FORMAT_TIME__FORMAT);

		binaryOpEClass = createEClass(BINARY_OP);
		createEReference(binaryOpEClass, BINARY_OP__LEFT);
		createEReference(binaryOpEClass, BINARY_OP__RIGHT);

		plusEClass = createEClass(PLUS);

		minusEClass = createEClass(MINUS);

		divEClass = createEClass(DIV);

		multEClass = createEClass(MULT);

		absEClass = createEClass(ABS);
		createEReference(absEClass, ABS__ARG);

		modEClass = createEClass(MOD);

		betweenEClass = createEClass(BETWEEN);
		createEReference(betweenEClass, BETWEEN__INPUT);
		createEReference(betweenEClass, BETWEEN__LEFT);
		createEReference(betweenEClass, BETWEEN__RIGHT);

		entryEClass = createEClass(ENTRY);
		createEReference(entryEClass, ENTRY__KEY);
		createEReference(entryEClass, ENTRY__VALUE);

		mapEClass = createEClass(MAP);
		createEReference(mapEClass, MAP__ENTRIES);

		listEClass = createEClass(LIST);
		createEReference(listEClass, LIST__ITEMS);

		loopEClass = createEClass(LOOP);
		createEReference(loopEClass, LOOP__VALS);
		createEReference(loopEClass, LOOP__BODY);

		recurEClass = createEClass(RECUR);
		createEReference(recurEClass, RECUR__VALUES);

		toListEClass = createEClass(TO_LIST);

		eachEClass = createEClass(EACH);
		createEReference(eachEClass, EACH__INPUT);
		createEReference(eachEClass, EACH__VAL);
		createEReference(eachEClass, EACH__KEY);
		createEReference(eachEClass, EACH__DO);

		splitEClass = createEClass(SPLIT);
		createEAttribute(splitEClass, SPLIT__STR);
		createEAttribute(splitEClass, SPLIT__SEP);
		createEAttribute(splitEClass, SPLIT__TRIM_RESULTS);
		createEAttribute(splitEClass, SPLIT__OMIT_EMPTY_STRINGS);

		parseTimeEClass = createEClass(PARSE_TIME);
		createEAttribute(parseTimeEClass, PARSE_TIME__INPUT);
		createEAttribute(parseTimeEClass, PARSE_TIME__FORMAT);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model. This
	 * method is guarded to have no affect on any invocation but its first. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		CorePackage theCorePackage = (CorePackage)EPackage.Registry.INSTANCE.getEPackage(CorePackage.eNS_URI);
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		eqEClass.getESuperTypes().add(theCorePackage.getCommand());
		intEClass.getESuperTypes().add(this.getConvert());
		longEClass.getESuperTypes().add(this.getConvert());
		floatEClass.getESuperTypes().add(this.getConvert());
		boolEClass.getESuperTypes().add(this.getConvert());
		strEClass.getESuperTypes().add(this.getConvert());
		convertEClass.getESuperTypes().add(theCorePackage.getCommand());
		assertTrueEClass.getESuperTypes().add(theCorePackage.getCommand());
		lengthEClass.getESuperTypes().add(theCorePackage.getCommand());
		notEqEClass.getESuperTypes().add(theCorePackage.getCommand());
		gtEClass.getESuperTypes().add(this.getBinaryOp());
		ltEClass.getESuperTypes().add(this.getBinaryOp());
		notEClass.getESuperTypes().add(theCorePackage.getCommand());
		tryEClass.getESuperTypes().add(theCorePackage.getCommand());
		formatEClass.getESuperTypes().add(theCorePackage.getCommand());
		emitEClass.getESuperTypes().add(theCorePackage.getCommand());
		repeatWithEClass.getESuperTypes().add(theCorePackage.getCommand());
		repeatEClass.getESuperTypes().add(theCorePackage.getCommand());
		assertEmptyEClass.getESuperTypes().add(theCorePackage.getCommand());
		assertNonEmptyEClass.getESuperTypes().add(theCorePackage.getCommand());
		concatEClass.getESuperTypes().add(theCorePackage.getCommand());
		orEClass.getESuperTypes().add(theCorePackage.getCommand());
		andEClass.getESuperTypes().add(theCorePackage.getCommand());
		getTimeEClass.getESuperTypes().add(theCorePackage.getCommand());
		formatTimeEClass.getESuperTypes().add(theCorePackage.getCommand());
		binaryOpEClass.getESuperTypes().add(theCorePackage.getCommand());
		plusEClass.getESuperTypes().add(this.getBinaryOp());
		minusEClass.getESuperTypes().add(this.getBinaryOp());
		divEClass.getESuperTypes().add(this.getBinaryOp());
		multEClass.getESuperTypes().add(this.getBinaryOp());
		absEClass.getESuperTypes().add(theCorePackage.getCommand());
		modEClass.getESuperTypes().add(this.getBinaryOp());
		betweenEClass.getESuperTypes().add(theCorePackage.getCommand());
		entryEClass.getESuperTypes().add(theCorePackage.getCommand());
		mapEClass.getESuperTypes().add(theCorePackage.getCommand());
		listEClass.getESuperTypes().add(theCorePackage.getCommand());
		loopEClass.getESuperTypes().add(theCorePackage.getCommand());
		recurEClass.getESuperTypes().add(theCorePackage.getCommand());
		toListEClass.getESuperTypes().add(theCorePackage.getCommand());
		eachEClass.getESuperTypes().add(theCorePackage.getCommand());
		splitEClass.getESuperTypes().add(theCorePackage.getCommand());
		parseTimeEClass.getESuperTypes().add(theCorePackage.getCommand());

		// Initialize classes and features; add operations and parameters
		initEClass(eqEClass, Eq.class, "Eq", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEq_Left(), theEcorePackage.getEObject(), null, "left", null, 0, 1, Eq.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEq_Right(), theEcorePackage.getEObject(), null, "right", null, 0, 1, Eq.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(intEClass, Int.class, "Int", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(longEClass, org.eclipse.rcptt.ecl.operations.Long.class, "Long", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(floatEClass, org.eclipse.rcptt.ecl.operations.Float.class, "Float", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(boolEClass, Bool.class, "Bool", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(strEClass, Str.class, "Str", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(convertEClass, Convert.class, "Convert", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConvert_Input(), theEcorePackage.getEObject(), null, "input", null, 0, 1, Convert.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(assertTrueEClass, AssertTrue.class, "AssertTrue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAssertTrue_Input(), theEcorePackage.getEBoolean(), "input", null, 0, 1, AssertTrue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAssertTrue_Message(), theEcorePackage.getEString(), "message", null, 0, 1, AssertTrue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(lengthEClass, Length.class, "Length", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLength_Input(), theEcorePackage.getEObject(), null, "input", null, 0, -1, Length.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(notEqEClass, NotEq.class, "NotEq", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNotEq_Left(), theEcorePackage.getEObject(), null, "left", null, 0, 1, NotEq.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNotEq_Right(), theEcorePackage.getEObject(), null, "right", null, 0, 1, NotEq.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(gtEClass, Gt.class, "Gt", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(ltEClass, Lt.class, "Lt", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(notEClass, Not.class, "Not", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNot_Left(), theEcorePackage.getEObject(), null, "left", null, 0, 1, Not.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tryEClass, Try.class, "Try", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTry_Command(), theCorePackage.getCommand(), null, "command", null, 0, 1, Try.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTry_Catch(), theCorePackage.getCommand(), null, "catch", null, 0, 1, Try.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTry_Finally(), theCorePackage.getCommand(), null, "finally", null, 0, 1, Try.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTry_Times(), theEcorePackage.getEIntegerObject(), "times", "1", 0, 1, Try.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTry_Delay(), theEcorePackage.getEIntegerObject(), "delay", "0", 0, 1, Try.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(formatEClass, Format.class, "Format", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFormat_Format(), theEcorePackage.getEString(), "format", null, 0, 1, Format.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFormat_Args(), theEcorePackage.getEObject(), null, "args", null, 0, -1, Format.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(emitEClass, Emit.class, "Emit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEmit_Values(), theEcorePackage.getEObject(), null, "values", null, 0, -1, Emit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(repeatWithEClass, RepeatWith.class, "RepeatWith", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRepeatWith_Commands(), theEcorePackage.getEObject(), null, "commands", null, 0, -1, RepeatWith.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRepeatWith_Command(), theCorePackage.getCommand(), null, "command", null, 0, 1, RepeatWith.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(repeatEClass, Repeat.class, "Repeat", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRepeat_Index(), theCorePackage.getVal(), null, "index", null, 0, 1, Repeat.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRepeat_Times(), theEcorePackage.getEInt(), "times", "1", 0, 1, Repeat.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRepeat_Command(), theCorePackage.getCommand(), null, "command", null, 0, 1, Repeat.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRepeat_Delay(), theEcorePackage.getEInt(), "delay", "0", 0, 1, Repeat.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(assertEmptyEClass, AssertEmpty.class, "AssertEmpty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAssertEmpty_Message(), theEcorePackage.getEString(), "message", null, 0, 1, AssertEmpty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(assertNonEmptyEClass, AssertNonEmpty.class, "AssertNonEmpty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAssertNonEmpty_Message(), theEcorePackage.getEString(), "message", null, 0, 1, AssertNonEmpty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(concatEClass, Concat.class, "Concat", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getConcat_Strs(), theEcorePackage.getEString(), "strs", null, 0, -1, Concat.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(orEClass, Or.class, "Or", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOr_Args(), theEcorePackage.getEObject(), null, "args", null, 2, -1, Or.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(andEClass, And.class, "And", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAnd_Args(), theEcorePackage.getEObject(), null, "args", null, 2, -1, And.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(getTimeEClass, GetTime.class, "GetTime", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(formatTimeEClass, FormatTime.class, "FormatTime", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFormatTime_Format(), theEcorePackage.getEString(), "format", null, 0, 1, FormatTime.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(binaryOpEClass, BinaryOp.class, "BinaryOp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBinaryOp_Left(), theEcorePackage.getEObject(), null, "left", null, 0, 1, BinaryOp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBinaryOp_Right(), theEcorePackage.getEObject(), null, "right", null, 0, 1, BinaryOp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(plusEClass, Plus.class, "Plus", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(minusEClass, Minus.class, "Minus", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(divEClass, Div.class, "Div", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(multEClass, Mult.class, "Mult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(absEClass, Abs.class, "Abs", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAbs_Arg(), theEcorePackage.getEObject(), null, "arg", null, 0, 1, Abs.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(modEClass, Mod.class, "Mod", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(betweenEClass, Between.class, "Between", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBetween_Input(), theEcorePackage.getEObject(), null, "input", null, 0, 1, Between.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBetween_Left(), theEcorePackage.getEObject(), null, "left", null, 0, 1, Between.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBetween_Right(), theEcorePackage.getEObject(), null, "right", null, 0, 1, Between.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(entryEClass, Entry.class, "Entry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEntry_Key(), theEcorePackage.getEObject(), null, "key", null, 0, 1, Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEntry_Value(), theEcorePackage.getEObject(), null, "value", null, 0, 1, Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mapEClass, Map.class, "Map", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMap_Entries(), this.getEntry(), null, "entries", null, 0, -1, Map.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(listEClass, List.class, "List", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getList_Items(), theEcorePackage.getEObject(), null, "items", null, 0, -1, List.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(loopEClass, Loop.class, "Loop", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLoop_Vals(), theCorePackage.getVal(), null, "vals", null, 0, -1, Loop.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLoop_Body(), theCorePackage.getCommand(), null, "body", null, 0, 1, Loop.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(recurEClass, Recur.class, "Recur", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRecur_Values(), theEcorePackage.getEObject(), null, "values", null, 0, -1, Recur.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(toListEClass, ToList.class, "ToList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(eachEClass, Each.class, "Each", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEach_Input(), theEcorePackage.getEObject(), null, "input", null, 1, 1, Each.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEach_Val(), theCorePackage.getVal(), null, "val", null, 1, 1, Each.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEach_Key(), theCorePackage.getVal(), null, "key", null, 0, 1, Each.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEach_Do(), theCorePackage.getCommand(), null, "do", null, 0, 1, Each.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(splitEClass, Split.class, "Split", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSplit_Str(), theEcorePackage.getEString(), "str", null, 0, 1, Split.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSplit_Sep(), theEcorePackage.getEString(), "sep", null, 0, 1, Split.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSplit_TrimResults(), theEcorePackage.getEBoolean(), "trimResults", "false", 0, 1, Split.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSplit_OmitEmptyStrings(), theEcorePackage.getEBoolean(), "omitEmptyStrings", "false", 0, 1, Split.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(parseTimeEClass, ParseTime.class, "ParseTime", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getParseTime_Input(), theEcorePackage.getEString(), "input", null, 1, 1, ParseTime.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getParseTime_Format(), theEcorePackage.getEString(), "format", null, 0, 1, ParseTime.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/ecl/docs
		createDocsAnnotations();
		// http://www.eclipse.org/ecl/input
		createInputAnnotations();
		// http://www.eclipse.org/ecl/internal
		createInternalAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/ecl/docs</b>.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void createDocsAnnotations() {
		String source = "http://www.eclipse.org/ecl/docs";		
		addAnnotation
		  (eqEClass, 
		   source, 
		   new String[] {
			 "description", "Compares arguments on equality",
			 "returns", "<code>true</code> when args are equal, <code>false</code> otherwise."
		   });			
		addAnnotation
		  (getEq_Left(), 
		   source, 
		   new String[] {
			 "description", "Left argument"
		   });		
		addAnnotation
		  (getEq_Right(), 
		   source, 
		   new String[] {
			 "description", "Right argument"
		   });		
		addAnnotation
		  (intEClass, 
		   source, 
		   new String[] {
			 "description", "Converts its argument to int.",
			 "returns", "Returns integer value or fails if value cannot be converted. <code>true</code> is converted to <code>1</code> and <code>false</code> is converted to <code>0</code>.",
			 "example", "//verifies that the number of Stops it less then 3\nget-view \"Execution View\" | get-label -after [get-label \"Stops:\"] | get-text | int | lt 3 | verify-true"
		   });		
		addAnnotation
		  (longEClass, 
		   source, 
		   new String[] {
			 "description", "Converts its argument to long.",
			 "returns", "Returns long value or fails if value cannot be converted. <code>true</code> is converted to <code>1L</code> and <code>false</code> is converted to <code>0L</code>."
		   });		
		addAnnotation
		  (floatEClass, 
		   source, 
		   new String[] {
			 "description", "Converts its argument to float.",
			 "returns", "<p>Returns float value or fails if value cannot be converted. <code>true</code> is converted to <code>1.0</code> and <code>false</code> is converted to <code>0</code>. This command uses <code>java.lang.Float.parseFloat</code> method, but also supports a few additional text values for infinity:</p>\n<ul>\n  <li><b>+inf</b> &ndash; returns <code>Float.POSITIVE_INFINITY</code></li>\n  <li><b>inf</b> &ndash; returns <code>Float.POSITIVE_INFINITY</code></li>\n  <li><b>-inf</b> &ndash; returns <code>Float.NEGATIVE_INFINITY</code></li>\n</ul>"
		   });		
		addAnnotation
		  (boolEClass, 
		   source, 
		   new String[] {
			 "description", "Converts its argument to boolean.",
			 "returns", "Returns boolean value or fails if value cannot be converted. ",
			 "example", "bool true | assert-true\nbool 1 | assert-true"
		   });		
		addAnnotation
		  (strEClass, 
		   source, 
		   new String[] {
			 "description", "Converts its argument to string.",
			 "returns", "Returns string value or fails if value cannot be converted. ",
			 "example", "//Types \"2\" into log\ndiv 10 5 | str | log"
		   });			
		addAnnotation
		  (getConvert_Input(), 
		   source, 
		   new String[] {
			 "description", "Argument to be converted."
		   });			
		addAnnotation
		  (assertTrueEClass, 
		   source, 
		   new String[] {
			 "description", "If input is not true, fails",
			 "returns", "Nothing",
			 "example", "...get-tree | get-item Project | get-property childCount -raw | gt 3 | assert-true -message \"Child count is not greater then 3!\" "
		   });		
		addAnnotation
		  (getAssertTrue_Input(), 
		   source, 
		   new String[] {
			 "description", "Input value. Must be true."
		   });			
		addAnnotation
		  (getAssertTrue_Message(), 
		   source, 
		   new String[] {
			 "description", "Message to fail with when input is not true"
		   });		
		addAnnotation
		  (lengthEClass, 
		   source, 
		   new String[] {
			 "description", "Returns count of objects got from input pipe",
			 "returns", "Object count",
			 "example", "emit 1 2 3 | length | equals 3 | verify-true\n\n// verifies that Project item has 10 children\nget-view \"Q7 Explorer\" | get-tree | get-item Project | get-items | length | equals 10 | verify-true"
		   });		
		addAnnotation
		  (getLength_Input(), 
		   source, 
		   new String[] {
			 "description", "List of objects to get the length for"
		   });			
		addAnnotation
		  (notEqEClass, 
		   source, 
		   new String[] {
			 "description", "Compares arguments are different",
			 "returns", "<code>false</code> when args are equal, <code>true</code> otherwise.",
			 "example", " int 9 | not-eq 10 | verify-true"
		   });			
		addAnnotation
		  (getNotEq_Left(), 
		   source, 
		   new String[] {
			 "description", "Left argument"
		   });		
		addAnnotation
		  (getNotEq_Right(), 
		   source, 
		   new String[] {
			 "description", "Right argument"
		   });		
		addAnnotation
		  (gtEClass, 
		   source, 
		   new String[] {
			 "description", "Compares arguments on to one be greater then another",
			 "returns", "<code>true</code> when left are greater then right, <code>false</code> otherwise.",
			 "example", "plus 6 4 | gt 8 | verify-true"
		   });		
		addAnnotation
		  (ltEClass, 
		   source, 
		   new String[] {
			 "description", "Compares arguments one are less then another",
			 "returns", "<code>true</code> when left is less then right, <code>false</code> otherwise.",
			 "example", "plus 6 4 | lt 12 | verify-true"
		   });		
		addAnnotation
		  (notEClass, 
		   source, 
		   new String[] {
			 "description", "Return !value",
			 "returns", "<code>true</code> when value is false, <code>false</code> otherwise.",
			 "example", "minus 10 7 | equals 2 | not | verify-true"
		   });			
		addAnnotation
		  (getNot_Left(), 
		   source, 
		   new String[] {
			 "description", "Left argument"
		   });		
		addAnnotation
		  (tryEClass, 
		   source, 
		   new String[] {
			 "description", "Try to execute command, retry times with delay if command are failed.\nExecute catch if all operations is not succesfull. Execute finally in anyway.",
			 "returns", "return\'s -command output if command is successed.",
			 "example", "try -times 10 -delay 100 -command {\r\n\t// some ECL scripts\r\n}"
		   });		
		addAnnotation
		  (formatEClass, 
		   source, 
		   new String[] {
			 "description", "Writes a formatted string to output pipe",
			 "returns", "Formatted string",
			 "example", "format \"string: %s, int: %d\" \"foo\" 5 | log"
		   });		
		addAnnotation
		  (getFormat_Format(), 
		   source, 
		   new String[] {
			 "description", "Format string as in Java\'s <a href=\"http://docs.oracle.com/javase/6/docs/api/java/util/Formatter.html\">String.format</a>"
		   });		
		addAnnotation
		  (getFormat_Args(), 
		   source, 
		   new String[] {
			 "description", "Arguments for format string"
		   });		
		addAnnotation
		  (emitEClass, 
		   source, 
		   new String[] {
			 "description", "Writes its arguments into output pipe. ",
			 "returns", "List of arguments",
			 "example", "emit \"hello\" \"world\" | foreach { log }"
		   });		
		addAnnotation
		  (repeatWithEClass, 
		   source, 
		   new String[] {
			 "description", "Takes list of commands from input pipe and single command as argument and executes them in following order: \n<pre>\ncommand-from-input-1 | command-from-arg\ncommand-from-input-2 | command-from-arg\n...\n</pre>",
			 "returns", "Aggregated output of command from argument",
			 "example", "// executes commands:\r\n// echo 1 | gt 2\r\n// echo 2 | gt 2\r\n// echo 3 | gt 2\r\n// output: false, false, true\r\nemit { echo 1} { echo 2} { echo 3} | repeat-with { gt 2 } "
		   });			
		addAnnotation
		  (repeatEClass, 
		   source, 
		   new String[] {
			 "description", "Execute specified command multiple times.",
			 "returns", "Aggregated command output",
			 "example", "//creates file0, file1, file2, file3, file4 \n\nrepeat [val index] -times 5 -command {\n\n\tget-view \"Q7 Explorer\" | get-tree | select \"Project/Folder\" | get-menu \"New/Other...\" | click\n\twith [get-window New] {\n    \t\tget-tree | select \"General/File\"\n    \t\tget-button \"Next >\" | click\n\t}\n\twith [get-window \"New File\"] {\n    \t\tget-editbox -after [get-label \"File name:\"] | set-text [concat \"file\" [$index | str]]\n    \t\tget-button Finish | click\n\t}\n}"
		   });		
		addAnnotation
		  (getRepeat_Index(), 
		   source, 
		   new String[] {
			 "description", "Optional value declaration to hold a current index"
		   });		
		addAnnotation
		  (assertEmptyEClass, 
		   source, 
		   new String[] {
			 "description", "Asserts that input pipe doesn\'t contain anything",
			 "returns", "Nothing",
			 "example", "find-in-workspace -path \"Project/nonexisting.file\" | assert-empty"
		   });		
		addAnnotation
		  (getAssertEmpty_Message(), 
		   source, 
		   new String[] {
			 "description", "Message to fail with when input is not empty"
		   });		
		addAnnotation
		  (assertNonEmptyEClass, 
		   source, 
		   new String[] {
			 "description", "Asserts that input pipe contain something",
			 "returns", "Nothing",
			 "example", "find-in-workspace -path \"Project/.*\" | assert-non-empty"
		   });		
		addAnnotation
		  (getAssertNonEmpty_Message(), 
		   source, 
		   new String[] {
			 "description", "Message to fail with when input is empty"
		   });		
		addAnnotation
		  (concatEClass, 
		   source, 
		   new String[] {
			 "description", "Concatenates strings passed as arguments",
			 "returns", "Concatenated string value",
			 "example", "concat \"Mess\" \"age\" | equals \"Message\" | assert-true"
		   });		
		addAnnotation
		  (orEClass, 
		   source, 
		   new String[] {
			 "description", "Computes the result of logical Or operation for passed arguments.",
			 "returns", "<code>true</code> or <code>false</code>.",
			 "example", "with [get-view \"Q7 Explorer\" | get-tree] {\n  if [or[get-item Project | get-property caption -raw | eq Project][get-property itemCount -raw | eq 1]] {\n    log -message \"One of two verifications passed\"\n  }\n}"
		   });		
		addAnnotation
		  (getOr_Args(), 
		   source, 
		   new String[] {
			 "description", "Arguments to compute on."
		   });		
		addAnnotation
		  (andEClass, 
		   source, 
		   new String[] {
			 "description", "Computes the result of logical And operation for passed arguments.",
			 "returns", "<code>true</code> or <code>false</code>.",
			 "example", "with [get-view \"Q7 Explorer\" | get-tree] {\n  if [and[get-item Project | get-property caption -raw | eq Project][get-property itemCount -raw | eq 1]] {\n    log -message \"Both verifications passed\"\n  }\n}"
		   });		
		addAnnotation
		  (getAnd_Args(), 
		   source, 
		   new String[] {
			 "description", "Arguments to compute on."
		   });		
		addAnnotation
		  (getTimeEClass, 
		   source, 
		   new String[] {
			 "description", "Returns current time as a number of milliseconds since January, 1, 1970.",
			 "returns", "Current time as long integer",
			 "example", "get-time | format-time -format \"hh:mm:ss\" | log"
		   });		
		addAnnotation
		  (formatTimeEClass, 
		   source, 
		   new String[] {
			 "description", "Reads timestamp value (as a number of milliseconds since January, 1, 1970) from input pipe and formats according to given format string. Format string is the same as used in <code>java.text.SimpleDateFormat</code>.",
			 "returns", "String representation of given time",
			 "example", "get-time | format-time -format \"dd.MM.yyyy\" | log\n// writes current date, month and year into log"
		   });			
		addAnnotation
		  (getBinaryOp_Left(), 
		   source, 
		   new String[] {
			 "description", "Left argument"
		   });		
		addAnnotation
		  (getBinaryOp_Right(), 
		   source, 
		   new String[] {
			 "description", "Right argument"
		   });		
		addAnnotation
		  (plusEClass, 
		   source, 
		   new String[] {
			 "description", "<p>returns <code>left + right</code></p>\n<p>Before performing an operation, arguments are converted to the widest type according to the following rules:</p>\n<ol>\n  <li><code>string</code> arguments converted to <code>long</code></li>\n  <li><code>boolean</code> arguments converted to <code>long</code> (1 for <code>true</code> and 0 for <code>false</code>)</li>\n  <li>If one of arguments is <code>double</code>, converts the other one to <code>double</code></li>\n  <li>If one of arguments is <code>float</code>, converts the other one to <code>float</code></li>\n  <li>If one of arguments is <code>long</code>, converts the other one to <code>long</code></li>\n  <li>Otherwise (in case of <code>byte</code>, <code>char</code>, or <code>short</code>) converts both arguments to <code>int</code></li>\n</ol>\n",
			 "example", "plus 10 3 | equals 13 | verify-true\nint 8 | plus 2 | equals 10 | assert-true \"8 + 2 not equals 10!\""
		   });		
		addAnnotation
		  (minusEClass, 
		   source, 
		   new String[] {
			 "description", "<p>returns <code>left - right</code></p>\n<p>Before performing an operation, arguments are converted to the widest type according to the following rules:</p>\n<ol>\n  <li><code>string</code> arguments converted to <code>long</code></li>\n  <li><code>boolean</code> arguments converted to <code>long</code> (1 for <code>true</code> and 0 for <code>false</code>)</li>\n  <li>If one of arguments is <code>double</code>, converts the other one to <code>double</code></li>\n  <li>If one of arguments is <code>float</code>, converts the other one to <code>float</code></li>\n  <li>If one of arguments is <code>long</code>, converts the other one to <code>long</code></li>\n  <li>Otherwise (in case of <code>byte</code>, <code>char</code>, or <code>short</code>) converts both arguments to <code>int</code></li>\n</ol>\n",
			 "example", "minus 8 5 | equals 3 | verify-true"
		   });		
		addAnnotation
		  (divEClass, 
		   source, 
		   new String[] {
			 "description", "<p>returns <code>left / right</code></p>\n<p>Before performing an operation, arguments are converted to the widest type according to the following rules:</p>\n<ol>\n  <li><code>string</code> arguments converted to <code>long</code></li>\n  <li><code>boolean</code> arguments converted to <code>long</code> (1 for <code>true</code> and 0 for <code>false</code>)</li>\n  <li>If one of arguments is <code>double</code>, converts the other one to <code>double</code></li>\n  <li>If one of arguments is <code>float</code>, converts the other one to <code>float</code></li>\n  <li>If one of arguments is <code>long</code>, converts the other one to <code>long</code></li>\n  <li>Otherwise (in case of <code>byte</code>, <code>char</code>, or <code>short</code>) converts both arguments to <code>int</code></li>\n</ol>\n",
			 "example", "div 10 5 | equals 2 | assert-true -message \"10/5 not equals 2!\""
		   });		
		addAnnotation
		  (multEClass, 
		   source, 
		   new String[] {
			 "description", "<p>returns <code>left * right</code></p>\n<p>Before performing an operation, arguments are converted to the widest type according to the following rules:</p>\n<ol>\n  <li><code>string</code> arguments converted to <code>long</code></li>\n  <li><code>boolean</code> arguments converted to <code>long</code> (1 for <code>true</code> and 0 for <code>false</code>)</li>\n  <li>If one of arguments is <code>double</code>, converts the other one to <code>double</code></li>\n  <li>If one of arguments is <code>float</code>, converts the other one to <code>float</code></li>\n  <li>If one of arguments is <code>long</code>, converts the other one to <code>long</code></li>\n  <li>Otherwise (in case of <code>byte</code>, <code>char</code>, or <code>short</code>) converts both arguments to <code>int</code></li>\n</ol>\n",
			 "example", "mult 5 7 | equals 35 | verify-true"
		   });		
		addAnnotation
		  (absEClass, 
		   source, 
		   new String[] {
			 "description", "<p>returns <code>java.lang.Math.abs(arg)</code></p>\n<p>The return type of an operation is determined by the following rules:</p>\n<ol>\n  <li><code>string</code> arg is converted to <code>long</code></li>\n  <li><code>boolean</code> arg is converted to <code>long</code> (1 for <code>true</code> and 0 for <code>false</code>)</li>\n  <li><code>double</code>, <code>float</code>, <code>long</code> args retain its original type</li>\n  <li>Otherwise (in case of <code>byte</code>, <code>char</code>, or <code>short</code>) the returned value has type <code>int</code></li>\n</ol>\n",
			 "example", " emit \"-10.6\" | int | abs | str | log (writes 10 to  log)"
		   });			
		addAnnotation
		  (modEClass, 
		   source, 
		   new String[] {
			 "description", "<p>returns <code>left % right</code></p>\n<p>Before performing an operation, arguments are converted to the widest type according to the following rules:</p>\n<ol>\n  <li><code>string</code> arguments converted to <code>long</code></li>\n  <li><code>boolean</code> arguments converted to <code>long</code> (1 for <code>true</code> and 0 for <code>false</code>)</li>\n  <li>If one of arguments is <code>double</code>, converts the other one to <code>double</code></li>\n  <li>If one of arguments is <code>float</code>, converts the other one to <code>float</code></li>\n  <li>If one of arguments is <code>long</code>, converts the other one to <code>long</code></li>\n  <li>Otherwise (in case of <code>byte</code>, <code>char</code>, or <code>short</code>) converts both arguments to <code>int</code></li>\n</ol>\n",
			 "example", "mod 11 3 | equals 2 | verify-true"
		   });		
		addAnnotation
		  (betweenEClass, 
		   source, 
		   new String[] {
			 "description", "<p>returns <code>true</code> if <code>input</code> is greater than or equal to <code>left</code> and less than or equal to <code>right</code></p>\n\n<p>Before performing an operation, arguments are converted according to the following rules:</p>\n<ol>\n  <li><code>string</code> arguments converted to <code>long</code></li>\n  <li><code>boolean</code> arguments converted to <code>long</code> (1 for <code>true</code> and 0 for <code>false</code>)</li>\n  <li>If one of arguments is <code>double</code>, converts the other one to <code>double</code></li>\n  <li>If one of arguments is <code>float</code>, converts the other one to <code>float</code></li>\n  <li>If one of arguments is <code>long</code>, converts the other one to <code>long</code></li>\n  <li>Otherwise (in case of <code>byte</code>, <code>char</code>, or <code>short</code>) converts both arguments to <code>int</code></li>\n</ol>\n",
			 "example", "int 10 | between 7 12 | verify-true"
		   });			
		addAnnotation
		  (entryEClass, 
		   source, 
		   new String[] {
			 "description", "Creates a new map entry. Can only be used as an argument for <a href=\"#map\">map</a> command."
		   });		
		addAnnotation
		  (mapEClass, 
		   source, 
		   new String[] {
			 "description", "Creates a new map. Also see <a href=\"#get\">get</a> command to find a value by key.",
			 "example", "let [val myMap [map \n   [entry firstName \"Ivan\"]\n   [entry lastName \"Inozemtsev\"]]] {\n   log [format \"%s %s\" [$myMap | get firstName] [$myMap | get lastName]]\n}"
		   });		
		addAnnotation
		  (getMap_Entries(), 
		   source, 
		   new String[] {
			 "description", "An arbitrary number of <a href=\"#entry\">entries</a>."
		   });		
		addAnnotation
		  (listEClass, 
		   source, 
		   new String[] {
			 "description", "Creates a new list. Also see <a href=\"#get\">get</a> command to find an element by index.",
			 "example", "list January Febuary March | get 1 | equals \"Febuary\" | verify-true"
		   });		
		addAnnotation
		  (loopEClass, 
		   source, 
		   new String[] {
			 "description", "Executes recursive looping of a body. Allows to emulate \'while\' and \'for\' loops while preserving variable immutability. The idea is taken from Clojure\'s <a href=\"http://clojure.org/functional_programming#Functional%20Programming--Recursive%20Looping\">loop/recur</a> approach. Also see <a href=\"#recur\">recur</a> command.",
			 "example", "// Example 1. returns how many times a 81 is divisible by 3\nloop [val count 0] [val n 81] {\n    if [mod $n 3 | eq 0] {\n        recur [$count | plus 1] [$n | div 3]\n    } -else {\n        log [format \"The answer is %d\" $count] //prints \'The answer is 4\'\n    }\n}\n\n\n// Example 2. deletes all elements from a tree\nproc \"get-my-tree\" { get-view \"My View\" | get-tree }\n\nproc \"has-elements\" {\n    get-my-tree | get-property itemCount -raw | int | gt 0\n}\n\nloop {\n    if [has-elements] {\n        // Selects a first top-level item and invokes \"Delete\" from context menu\n        get-my-tree | select \".*\" | get-menu \"Delete\" | click\n        // Confirms a removal in popup dialog\n        get-window \"Confirm Delete\" | get-button OK | click\n        // Continues execution from the beginning of loop body\n        recur\n    }\n}"
		   });		
		addAnnotation
		  (getLoop_Vals(), 
		   source, 
		   new String[] {
			 "description", "Valus which are going to be modified during iterations. All initial values must be set."
		   });		
		addAnnotation
		  (getLoop_Body(), 
		   source, 
		   new String[] {
			 "description", "A script to execute. Whenever script invokes <a href=\"#recur\">recur</a> command, an execution jumps to the beginning of loop body script."
		   });		
		addAnnotation
		  (recurEClass, 
		   source, 
		   new String[] {
			 "description", "Returns an execution to the beginning of <a href=\"#loop\">loop</a> command. Cannot be used outside of a loop.",
			 "example", "// calc and show a sum of ints from 3 to 10\n\nloop [val result 0] [val i 3] {\n    if [$i | eq 10] {\n        show-alert [str [$result | plus $i]]\n    } -else {\n        recur [$result | plus $i] [$i | plus 1]\n    }\n}"
		   });		
		addAnnotation
		  (getRecur_Values(), 
		   source, 
		   new String[] {
			 "description", "A list of new values for variables, declared in <code>loop</code> command. Value count must exactly match to corresponding val count of a <code>loop</code> command."
		   });		
		addAnnotation
		  (toListEClass, 
		   source, 
		   new String[] {
			 "description", "Loads whole input pipe and returns a single EclList object, containing it.",
			 "example", "emit 1 2 3 | to-list // same as list 1 2 3\nemit 1 2 3 | to-list | to-list // same as list [list 1 2 3]"
		   });		
		addAnnotation
		  (eachEClass, 
		   source, 
		   new String[] {
			 "description", "Iterates over <a href=\"#list\">list</a> or <a href=\"#map\">map</a>. Accepts one or two variable declarations, when only one variable given, it will be hold list elements or map values. A second variable, if provided, used for map keys or list element indices.",
			 "example", "// Iterate over elements.\nlist 1 2 3 | each [val element] {\n    log [format \"%d\" $element]\n}\n\n// Iterate over elements with indices\nlist 1 2 3 | each [val element] [val index] {\n    log [format \"list[%d] = %d\" $index $element]\n}\n\n// Iterate over map values\nmap [entry \"one\" 1] [entry \"two\" 2] | each [val value] { log [str $value] }\n\n// Iterate over map values with keys\nmap [entry \"one\" 1] [entry \"two\" 2] | each [val v] [val k] { log [concat $k \" = \" [str $v]] }"
		   });			
		addAnnotation
		  (getEach_Input(), 
		   source, 
		   new String[] {
			 "description", "Map or List"
		   });		
		addAnnotation
		  (splitEClass, 
		   source, 
		   new String[] {
			 "description", "",
			 "example", "str \"1, 2, 3, 4, 5\" | split -sep \",\" -trimResults | foreach [val item]{\n\t$item | log\n}\n"
		   });			
		addAnnotation
		  (parseTimeEClass, 
		   source, 
		   new String[] {
			 "description", "Reads a string from input pipe and parses it accoridng to a given format string.",
			 "returns", "Timestamp value (as a number of milliseconds since January, 1, 1970)"
		   });			
		addAnnotation
		  (getParseTime_Input(), 
		   source, 
		   new String[] {
			 "description", "String representation of date."
		   });
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/ecl/input</b>.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void createInputAnnotations() {
		String source = "http://www.eclipse.org/ecl/input";			
		addAnnotation
		  (getEq_Left(), 
		   source, 
		   new String[] {
		   });											
		addAnnotation
		  (getConvert_Input(), 
		   source, 
		   new String[] {
		   });				
		addAnnotation
		  (getAssertTrue_Input(), 
		   source, 
		   new String[] {
		   });					
		addAnnotation
		  (getLength_Input(), 
		   source, 
		   new String[] {
		   });			
		addAnnotation
		  (getNotEq_Left(), 
		   source, 
		   new String[] {
		   });							
		addAnnotation
		  (getNot_Left(), 
		   source, 
		   new String[] {
		   });									
		addAnnotation
		  (getRepeatWith_Commands(), 
		   source, 
		   new String[] {
		   });															
		addAnnotation
		  (getBinaryOp_Left(), 
		   source, 
		   new String[] {
		   });									
		addAnnotation
		  (getAbs_Arg(), 
		   source, 
		   new String[] {
		   });				
		addAnnotation
		  (getBetween_Input(), 
		   source, 
		   new String[] {
		   });													
		addAnnotation
		  (getEach_Input(), 
		   source, 
		   new String[] {
		   });				
		addAnnotation
		  (getSplit_Str(), 
		   source, 
		   new String[] {
		   });			
		addAnnotation
		  (getParseTime_Input(), 
		   source, 
		   new String[] {
		   });	
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/ecl/internal</b>.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	protected void createInternalAnnotations() {
		String source = "http://www.eclipse.org/ecl/internal";											
		addAnnotation
		  (convertEClass, 
		   source, 
		   new String[] {
		   });																																																																				
	}

} // OperationsPackageImpl

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
package org.eclipse.rcptt.ecl.operations.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.rcptt.ecl.core.Command;
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
import org.eclipse.rcptt.ecl.operations.Loop;
import org.eclipse.rcptt.ecl.operations.Lt;
import org.eclipse.rcptt.ecl.operations.Map;
import org.eclipse.rcptt.ecl.operations.Minus;
import org.eclipse.rcptt.ecl.operations.Mod;
import org.eclipse.rcptt.ecl.operations.Mult;
import org.eclipse.rcptt.ecl.operations.Not;
import org.eclipse.rcptt.ecl.operations.NotEq;
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
 * <!-- begin-user-doc --> The <b>Switch</b> for the model's inheritance
 * hierarchy. It supports the call {@link #doSwitch(EObject) doSwitch(object)} to invoke the <code>caseXXX</code> method
 * for each class of the model,
 * starting with the actual class of the object and proceeding up the
 * inheritance hierarchy until a non-null result is returned, which is the
 * result of the switch. <!-- end-user-doc -->
 * @see org.eclipse.rcptt.ecl.operations.OperationsPackage
 * @generated
 */
public class OperationsSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected static OperationsPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	public OperationsSwitch() {
		if (modelPackage == null) {
			modelPackage = OperationsPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
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
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case OperationsPackage.EQ: {
				Eq eq = (Eq)theEObject;
				T result = caseEq(eq);
				if (result == null) result = caseCommand(eq);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OperationsPackage.INT: {
				Int int_ = (Int)theEObject;
				T result = caseInt(int_);
				if (result == null) result = caseConvert(int_);
				if (result == null) result = caseCommand(int_);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OperationsPackage.LONG: {
				org.eclipse.rcptt.ecl.operations.Long long_ = (org.eclipse.rcptt.ecl.operations.Long)theEObject;
				T result = caseLong(long_);
				if (result == null) result = caseConvert(long_);
				if (result == null) result = caseCommand(long_);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OperationsPackage.FLOAT: {
				org.eclipse.rcptt.ecl.operations.Float float_ = (org.eclipse.rcptt.ecl.operations.Float)theEObject;
				T result = caseFloat(float_);
				if (result == null) result = caseConvert(float_);
				if (result == null) result = caseCommand(float_);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OperationsPackage.BOOL: {
				Bool bool = (Bool)theEObject;
				T result = caseBool(bool);
				if (result == null) result = caseConvert(bool);
				if (result == null) result = caseCommand(bool);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OperationsPackage.STR: {
				Str str = (Str)theEObject;
				T result = caseStr(str);
				if (result == null) result = caseConvert(str);
				if (result == null) result = caseCommand(str);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OperationsPackage.CONVERT: {
				Convert convert = (Convert)theEObject;
				T result = caseConvert(convert);
				if (result == null) result = caseCommand(convert);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OperationsPackage.ASSERT_TRUE: {
				AssertTrue assertTrue = (AssertTrue)theEObject;
				T result = caseAssertTrue(assertTrue);
				if (result == null) result = caseCommand(assertTrue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OperationsPackage.LENGTH: {
				Length length = (Length)theEObject;
				T result = caseLength(length);
				if (result == null) result = caseCommand(length);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OperationsPackage.NOT_EQ: {
				NotEq notEq = (NotEq)theEObject;
				T result = caseNotEq(notEq);
				if (result == null) result = caseCommand(notEq);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OperationsPackage.GT: {
				Gt gt = (Gt)theEObject;
				T result = caseGt(gt);
				if (result == null) result = caseBinaryOp(gt);
				if (result == null) result = caseCommand(gt);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OperationsPackage.LT: {
				Lt lt = (Lt)theEObject;
				T result = caseLt(lt);
				if (result == null) result = caseBinaryOp(lt);
				if (result == null) result = caseCommand(lt);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OperationsPackage.NOT: {
				Not not = (Not)theEObject;
				T result = caseNot(not);
				if (result == null) result = caseCommand(not);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OperationsPackage.TRY: {
				Try try_ = (Try)theEObject;
				T result = caseTry(try_);
				if (result == null) result = caseCommand(try_);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OperationsPackage.FORMAT: {
				Format format = (Format)theEObject;
				T result = caseFormat(format);
				if (result == null) result = caseCommand(format);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OperationsPackage.EMIT: {
				Emit emit = (Emit)theEObject;
				T result = caseEmit(emit);
				if (result == null) result = caseCommand(emit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OperationsPackage.REPEAT_WITH: {
				RepeatWith repeatWith = (RepeatWith)theEObject;
				T result = caseRepeatWith(repeatWith);
				if (result == null) result = caseCommand(repeatWith);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OperationsPackage.REPEAT: {
				Repeat repeat = (Repeat)theEObject;
				T result = caseRepeat(repeat);
				if (result == null) result = caseCommand(repeat);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OperationsPackage.ASSERT_EMPTY: {
				AssertEmpty assertEmpty = (AssertEmpty)theEObject;
				T result = caseAssertEmpty(assertEmpty);
				if (result == null) result = caseCommand(assertEmpty);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OperationsPackage.ASSERT_NON_EMPTY: {
				AssertNonEmpty assertNonEmpty = (AssertNonEmpty)theEObject;
				T result = caseAssertNonEmpty(assertNonEmpty);
				if (result == null) result = caseCommand(assertNonEmpty);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OperationsPackage.CONCAT: {
				Concat concat = (Concat)theEObject;
				T result = caseConcat(concat);
				if (result == null) result = caseCommand(concat);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OperationsPackage.OR: {
				Or or = (Or)theEObject;
				T result = caseOr(or);
				if (result == null) result = caseCommand(or);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OperationsPackage.AND: {
				And and = (And)theEObject;
				T result = caseAnd(and);
				if (result == null) result = caseCommand(and);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OperationsPackage.GET_TIME: {
				GetTime getTime = (GetTime)theEObject;
				T result = caseGetTime(getTime);
				if (result == null) result = caseCommand(getTime);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OperationsPackage.FORMAT_TIME: {
				FormatTime formatTime = (FormatTime)theEObject;
				T result = caseFormatTime(formatTime);
				if (result == null) result = caseCommand(formatTime);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OperationsPackage.BINARY_OP: {
				BinaryOp binaryOp = (BinaryOp)theEObject;
				T result = caseBinaryOp(binaryOp);
				if (result == null) result = caseCommand(binaryOp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OperationsPackage.PLUS: {
				Plus plus = (Plus)theEObject;
				T result = casePlus(plus);
				if (result == null) result = caseBinaryOp(plus);
				if (result == null) result = caseCommand(plus);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OperationsPackage.MINUS: {
				Minus minus = (Minus)theEObject;
				T result = caseMinus(minus);
				if (result == null) result = caseBinaryOp(minus);
				if (result == null) result = caseCommand(minus);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OperationsPackage.DIV: {
				Div div = (Div)theEObject;
				T result = caseDiv(div);
				if (result == null) result = caseBinaryOp(div);
				if (result == null) result = caseCommand(div);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OperationsPackage.MULT: {
				Mult mult = (Mult)theEObject;
				T result = caseMult(mult);
				if (result == null) result = caseBinaryOp(mult);
				if (result == null) result = caseCommand(mult);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OperationsPackage.ABS: {
				Abs abs = (Abs)theEObject;
				T result = caseAbs(abs);
				if (result == null) result = caseCommand(abs);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OperationsPackage.MOD: {
				Mod mod = (Mod)theEObject;
				T result = caseMod(mod);
				if (result == null) result = caseBinaryOp(mod);
				if (result == null) result = caseCommand(mod);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OperationsPackage.BETWEEN: {
				Between between = (Between)theEObject;
				T result = caseBetween(between);
				if (result == null) result = caseCommand(between);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OperationsPackage.ENTRY: {
				Entry entry = (Entry)theEObject;
				T result = caseEntry(entry);
				if (result == null) result = caseCommand(entry);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OperationsPackage.MAP: {
				Map map = (Map)theEObject;
				T result = caseMap(map);
				if (result == null) result = caseCommand(map);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OperationsPackage.LIST: {
				org.eclipse.rcptt.ecl.operations.List list = (org.eclipse.rcptt.ecl.operations.List)theEObject;
				T result = caseList(list);
				if (result == null) result = caseCommand(list);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OperationsPackage.LOOP: {
				Loop loop = (Loop)theEObject;
				T result = caseLoop(loop);
				if (result == null) result = caseCommand(loop);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OperationsPackage.RECUR: {
				Recur recur = (Recur)theEObject;
				T result = caseRecur(recur);
				if (result == null) result = caseCommand(recur);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OperationsPackage.TO_LIST: {
				ToList toList = (ToList)theEObject;
				T result = caseToList(toList);
				if (result == null) result = caseCommand(toList);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OperationsPackage.EACH: {
				Each each = (Each)theEObject;
				T result = caseEach(each);
				if (result == null) result = caseCommand(each);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OperationsPackage.SPLIT: {
				Split split = (Split)theEObject;
				T result = caseSplit(split);
				if (result == null) result = caseCommand(split);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OperationsPackage.PARSE_TIME: {
				ParseTime parseTime = (ParseTime)theEObject;
				T result = caseParseTime(parseTime);
				if (result == null) result = caseCommand(parseTime);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of ' <em>Eq</em>'. <!-- begin-user-doc --> This
	 * implementation returns null;
	 * returning a non-null result will terminate the switch. <!-- end-user-doc
	 * -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of ' <em>Eq</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEq(Eq object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of ' <em>Int</em>'. <!-- begin-user-doc --> This
	 * implementation returns null;
	 * returning a non-null result will terminate the switch. <!-- end-user-doc
	 * -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of ' <em>Int</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInt(Int object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of ' <em>Long</em>'. <!-- begin-user-doc --> This
	 * implementation returns null;
	 * returning a non-null result will terminate the switch. <!-- end-user-doc
	 * -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of ' <em>Long</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLong(org.eclipse.rcptt.ecl.operations.Long object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Float</em>'.
	 * <!-- begin-user-doc --> This implementation returns
	 * null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Float</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFloat(org.eclipse.rcptt.ecl.operations.Float object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of ' <em>Bool</em>'. <!-- begin-user-doc --> This
	 * implementation returns null;
	 * returning a non-null result will terminate the switch. <!-- end-user-doc
	 * -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of ' <em>Bool</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBool(Bool object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of ' <em>Str</em>'. <!-- begin-user-doc --> This
	 * implementation returns null;
	 * returning a non-null result will terminate the switch. <!-- end-user-doc
	 * -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of ' <em>Str</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStr(Str object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Convert</em>'.
	 * <!-- begin-user-doc --> This implementation returns
	 * null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Convert</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConvert(Convert object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Assert True</em>'.
	 * <!-- begin-user-doc --> This implementation
	 * returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Assert True</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAssertTrue(AssertTrue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Length</em>'.
	 * <!-- begin-user-doc --> This implementation returns
	 * null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Length</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLength(Length object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Not Eq</em>'.
	 * <!-- begin-user-doc --> This implementation returns
	 * null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Not Eq</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNotEq(NotEq object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of ' <em>Gt</em>'. <!-- begin-user-doc --> This
	 * implementation returns null;
	 * returning a non-null result will terminate the switch. <!-- end-user-doc
	 * -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of ' <em>Gt</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGt(Gt object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of ' <em>Lt</em>'. <!-- begin-user-doc --> This
	 * implementation returns null;
	 * returning a non-null result will terminate the switch. <!-- end-user-doc
	 * -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of ' <em>Lt</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLt(Lt object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of ' <em>Not</em>'. <!-- begin-user-doc --> This
	 * implementation returns null;
	 * returning a non-null result will terminate the switch. <!-- end-user-doc
	 * -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of ' <em>Not</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNot(Not object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of ' <em>Try</em>'. <!-- begin-user-doc --> This
	 * implementation returns null;
	 * returning a non-null result will terminate the switch. <!-- end-user-doc
	 * -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of ' <em>Try</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTry(Try object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Format</em>'.
	 * <!-- begin-user-doc --> This implementation returns
	 * null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Format</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFormat(Format object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of ' <em>Emit</em>'. <!-- begin-user-doc --> This
	 * implementation returns null;
	 * returning a non-null result will terminate the switch. <!-- end-user-doc
	 * -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of ' <em>Emit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEmit(Emit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Repeat With</em>'.
	 * <!-- begin-user-doc --> This implementation
	 * returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Repeat With</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRepeatWith(RepeatWith object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Repeat</em>'.
	 * <!-- begin-user-doc --> This implementation returns
	 * null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Repeat</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRepeat(Repeat object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Assert Empty</em>'.
	 * <!-- begin-user-doc --> This implementation
	 * returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Assert Empty</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAssertEmpty(AssertEmpty object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Assert Non Empty</em>'.
	 * <!-- begin-user-doc --> This implementation
	 * returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Assert Non Empty</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAssertNonEmpty(AssertNonEmpty object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Concat</em>'.
	 * <!-- begin-user-doc --> This implementation returns
	 * null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Concat</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConcat(Concat object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of ' <em>Or</em>'. <!-- begin-user-doc --> This
	 * implementation returns null;
	 * returning a non-null result will terminate the switch. <!-- end-user-doc
	 * -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of ' <em>Or</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOr(Or object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of ' <em>And</em>'. <!-- begin-user-doc --> This
	 * implementation returns null;
	 * returning a non-null result will terminate the switch. <!-- end-user-doc
	 * -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of ' <em>And</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAnd(And object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Get Time</em>'.
	 * <!-- begin-user-doc --> This implementation returns
	 * null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Get Time</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGetTime(GetTime object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Format Time</em>'.
	 * <!-- begin-user-doc --> This implementation
	 * returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Format Time</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFormatTime(FormatTime object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of ' <em>Plus</em>'. <!-- begin-user-doc --> This
	 * implementation returns null;
	 * returning a non-null result will terminate the switch. <!-- end-user-doc
	 * -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of ' <em>Plus</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePlus(Plus object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Minus</em>'.
	 * <!-- begin-user-doc --> This implementation returns
	 * null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Minus</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMinus(Minus object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of ' <em>Div</em>'. <!-- begin-user-doc --> This
	 * implementation returns null;
	 * returning a non-null result will terminate the switch. <!-- end-user-doc
	 * -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of ' <em>Div</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDiv(Div object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of ' <em>Mult</em>'. <!-- begin-user-doc --> This
	 * implementation returns null;
	 * returning a non-null result will terminate the switch. <!-- end-user-doc
	 * -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of ' <em>Mult</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMult(Mult object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of ' <em>Abs</em>'. <!-- begin-user-doc --> This
	 * implementation returns null;
	 * returning a non-null result will terminate the switch. <!-- end-user-doc
	 * -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of ' <em>Abs</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbs(Abs object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mod</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mod</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMod(Mod object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Between</em>'.
	 * <!-- begin-user-doc --> This implementation returns
	 * null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Between</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBetween(Between object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Entry</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Entry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEntry(Entry object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Map</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Map</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMap(Map object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>List</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>List</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseList(org.eclipse.rcptt.ecl.operations.List object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Loop</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Loop</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLoop(Loop object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Recur</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Recur</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRecur(Recur object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>To List</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>To List</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseToList(ToList object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Each</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Each</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEach(Each object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Split</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Split</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSplit(Split object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parse Time</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parse Time</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParseTime(ParseTime object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Binary Op</em>'.
	 * <!-- begin-user-doc --> This implementation returns
	 * null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Binary Op</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBinaryOp(BinaryOp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Command</em>'.
	 * <!-- begin-user-doc --> This implementation returns
	 * null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Command</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCommand(Command object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc --> This implementation returns
	 * null; returning a non-null result will terminate the switch, but this is
	 * the last case anyway. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public T defaultCase(EObject object) {
		return null;
	}

} // OperationsSwitch

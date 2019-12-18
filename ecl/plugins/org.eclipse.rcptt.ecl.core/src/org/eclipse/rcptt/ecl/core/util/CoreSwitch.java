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
package org.eclipse.rcptt.ecl.core.util;

import java.util.List;

import java.util.Map;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.rcptt.ecl.core.*;

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
 * @see org.eclipse.rcptt.ecl.core.CorePackage
 * @generated
 */
public class CoreSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static CorePackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoreSwitch() {
		if (modelPackage == null) {
			modelPackage = CorePackage.eINSTANCE;
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
			case CorePackage.COMMAND: {
				Command command = (Command)theEObject;
				T result = caseCommand(command);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.BINDING: {
				Binding binding = (Binding)theEObject;
				T result = caseBinding(binding);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.BLOCK: {
				Block block = (Block)theEObject;
				T result = caseBlock(block);
				if (result == null) result = caseCommand(block);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.PIPELINE: {
				Pipeline pipeline = (Pipeline)theEObject;
				T result = casePipeline(pipeline);
				if (result == null) result = caseBlock(pipeline);
				if (result == null) result = caseCommand(pipeline);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.SEQUENCE: {
				Sequence sequence = (Sequence)theEObject;
				T result = caseSequence(sequence);
				if (result == null) result = caseBlock(sequence);
				if (result == null) result = caseCommand(sequence);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.PARALLEL: {
				Parallel parallel = (Parallel)theEObject;
				T result = caseParallel(parallel);
				if (result == null) result = caseBlock(parallel);
				if (result == null) result = caseCommand(parallel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.WITH: {
				With with = (With)theEObject;
				T result = caseWith(with);
				if (result == null) result = caseCommand(with);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.EXEC: {
				Exec exec = (Exec)theEObject;
				T result = caseExec(exec);
				if (result == null) result = caseCommand(exec);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.PARAMETER: {
				Parameter parameter = (Parameter)theEObject;
				T result = caseParameter(parameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.EXECUTABLE_PARAMETER: {
				ExecutableParameter executableParameter = (ExecutableParameter)theEObject;
				T result = caseExecutableParameter(executableParameter);
				if (result == null) result = caseParameter(executableParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.LITERAL_PARAMETER: {
				LiteralParameter literalParameter = (LiteralParameter)theEObject;
				T result = caseLiteralParameter(literalParameter);
				if (result == null) result = caseParameter(literalParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.FOREACH: {
				Foreach foreach = (Foreach)theEObject;
				T result = caseForeach(foreach);
				if (result == null) result = caseCommand(foreach);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.SCRIPT: {
				Script script = (Script)theEObject;
				T result = caseScript(script);
				if (result == null) result = caseCommand(script);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.PROCESS_STATUS: {
				ProcessStatus processStatus = (ProcessStatus)theEObject;
				T result = caseProcessStatus(processStatus);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.CONVERTED_TO_EMF_PIPE: {
				ConvertedToEMFPipe convertedToEMFPipe = (ConvertedToEMFPipe)theEObject;
				T result = caseConvertedToEMFPipe(convertedToEMFPipe);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.SERIALIZED: {
				Serialized serialized = (Serialized)theEObject;
				T result = caseSerialized(serialized);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.NULLABLE: {
				Nullable nullable = (Nullable)theEObject;
				T result = caseNullable(nullable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.IF: {
				If if_ = (If)theEObject;
				T result = caseIf(if_);
				if (result == null) result = caseCommand(if_);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.BOXED_VALUE: {
				BoxedValue boxedValue = (BoxedValue)theEObject;
				T result = caseBoxedValue(boxedValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.ECL_BYTE: {
				EclByte eclByte = (EclByte)theEObject;
				T result = caseEclByte(eclByte);
				if (result == null) result = caseBoxedValue(eclByte);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.ECL_SHORT: {
				EclShort eclShort = (EclShort)theEObject;
				T result = caseEclShort(eclShort);
				if (result == null) result = caseBoxedValue(eclShort);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.ECL_INTEGER: {
				EclInteger eclInteger = (EclInteger)theEObject;
				T result = caseEclInteger(eclInteger);
				if (result == null) result = caseBoxedValue(eclInteger);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.ECL_LONG: {
				EclLong eclLong = (EclLong)theEObject;
				T result = caseEclLong(eclLong);
				if (result == null) result = caseBoxedValue(eclLong);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.ECL_DOUBLE: {
				EclDouble eclDouble = (EclDouble)theEObject;
				T result = caseEclDouble(eclDouble);
				if (result == null) result = caseBoxedValue(eclDouble);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.ECL_FLOAT: {
				EclFloat eclFloat = (EclFloat)theEObject;
				T result = caseEclFloat(eclFloat);
				if (result == null) result = caseBoxedValue(eclFloat);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.ECL_BOOLEAN: {
				EclBoolean eclBoolean = (EclBoolean)theEObject;
				T result = caseEclBoolean(eclBoolean);
				if (result == null) result = caseBoxedValue(eclBoolean);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.ECL_CHAR: {
				EclChar eclChar = (EclChar)theEObject;
				T result = caseEclChar(eclChar);
				if (result == null) result = caseBoxedValue(eclChar);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.ECL_STRING: {
				EclString eclString = (EclString)theEObject;
				T result = caseEclString(eclString);
				if (result == null) result = caseBoxedValue(eclString);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.ECL_EXCEPTION: {
				EclException eclException = (EclException)theEObject;
				T result = caseEclException(eclException);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.ECL_STACK_TRACE_ENTRY: {
				EclStackTraceEntry eclStackTraceEntry = (EclStackTraceEntry)theEObject;
				T result = caseEclStackTraceEntry(eclStackTraceEntry);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.LISTEN: {
				Listen listen = (Listen)theEObject;
				T result = caseListen(listen);
				if (result == null) result = caseCommand(listen);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.DECLARATION: {
				Declaration declaration = (Declaration)theEObject;
				T result = caseDeclaration(declaration);
				if (result == null) result = caseCommand(declaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.VAL: {
				Val val = (Val)theEObject;
				T result = caseVal(val);
				if (result == null) result = caseDeclaration(val);
				if (result == null) result = caseCommand(val);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.GET_VAL: {
				GetVal getVal = (GetVal)theEObject;
				T result = caseGetVal(getVal);
				if (result == null) result = caseCommand(getVal);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.LET: {
				Let let = (Let)theEObject;
				T result = caseLet(let);
				if (result == null) result = caseCommand(let);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.PROC: {
				Proc proc = (Proc)theEObject;
				T result = caseProc(proc);
				if (result == null) result = caseCommand(proc);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.PROC_INSTANCE: {
				ProcInstance procInstance = (ProcInstance)theEObject;
				T result = caseProcInstance(procInstance);
				if (result == null) result = caseCommand(procInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.GLOBAL: {
				Global global = (Global)theEObject;
				T result = caseGlobal(global);
				if (result == null) result = caseCommand(global);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.SESSION_STATE: {
				SessionState sessionState = (SessionState)theEObject;
				T result = caseSessionState(sessionState);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.SAVE_STATE: {
				SaveState saveState = (SaveState)theEObject;
				T result = caseSaveState(saveState);
				if (result == null) result = caseCommand(saveState);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.RESTORE_STATE: {
				RestoreState restoreState = (RestoreState)theEObject;
				T result = caseRestoreState(restoreState);
				if (result == null) result = caseCommand(restoreState);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.GET: {
				Get get = (Get)theEObject;
				T result = caseGet(get);
				if (result == null) result = caseCommand(get);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.ECL_LIST: {
				EclList eclList = (EclList)theEObject;
				T result = caseEclList(eclList);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.ECL_MAP: {
				EclMap eclMap = (EclMap)theEObject;
				T result = caseEclMap(eclMap);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.ECL_MAP_ENTRY: {
				EclMapEntry eclMapEntry = (EclMapEntry)theEObject;
				T result = caseEclMapEntry(eclMapEntry);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.CASE: {
				Case case_ = (Case)theEObject;
				T result = caseCase(case_);
				if (result == null) result = caseCommand(case_);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorePackage.SWITCH: {
				Switch switch_ = (Switch)theEObject;
				T result = caseSwitch(switch_);
				if (result == null) result = caseCommand(switch_);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Command</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Command</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCommand(Command object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Binding</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Binding</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBinding(Binding object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Block</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Block</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBlock(Block object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Pipeline</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pipeline</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePipeline(Pipeline object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sequence</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sequence</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSequence(Sequence object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parallel</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parallel</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParallel(Parallel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>With</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>With</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWith(With object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Exec</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Exec</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExec(Exec object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParameter(Parameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Executable Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Executable Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExecutableParameter(ExecutableParameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Literal Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Literal Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLiteralParameter(LiteralParameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Foreach</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Foreach</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseForeach(Foreach object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Script</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Script</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseScript(Script object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Process Status</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Process Status</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProcessStatus(ProcessStatus object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Converted To EMF Pipe</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Converted To EMF Pipe</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConvertedToEMFPipe(ConvertedToEMFPipe object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Serialized</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Serialized</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSerialized(Serialized object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Nullable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Nullable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNullable(Nullable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>If</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>If</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIf(If object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Boxed Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Boxed Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBoxedValue(BoxedValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ecl Byte</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ecl Byte</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEclByte(EclByte object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ecl Short</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ecl Short</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEclShort(EclShort object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ecl Integer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ecl Integer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEclInteger(EclInteger object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ecl Long</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ecl Long</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEclLong(EclLong object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ecl Double</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ecl Double</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEclDouble(EclDouble object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ecl Float</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ecl Float</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEclFloat(EclFloat object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ecl Boolean</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ecl Boolean</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEclBoolean(EclBoolean object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ecl Char</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ecl Char</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEclChar(EclChar object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ecl String</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ecl String</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEclString(EclString object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ecl Exception</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ecl Exception</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEclException(EclException object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ecl Stack Trace Entry</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ecl Stack Trace Entry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEclStackTraceEntry(EclStackTraceEntry object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Listen</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Listen</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseListen(Listen object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDeclaration(Declaration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Val</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Val</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVal(Val object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Get Val</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Get Val</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGetVal(GetVal object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Let</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Let</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLet(Let object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Proc</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Proc</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProc(Proc object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Proc Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Proc Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProcInstance(ProcInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Global</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Global</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGlobal(Global object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Session State</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Session State</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSessionState(SessionState object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Save State</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Save State</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSaveState(SaveState object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Restore State</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Restore State</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRestoreState(RestoreState object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Get</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Get</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGet(Get object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ecl List</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ecl List</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEclList(EclList object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ecl Map</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ecl Map</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEclMap(EclMap object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ecl Map Entry</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ecl Map Entry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEclMapEntry(EclMapEntry object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Case</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Case</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCase(Case object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Switch</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Switch</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSwitch(Switch object) {
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

} //CoreSwitch

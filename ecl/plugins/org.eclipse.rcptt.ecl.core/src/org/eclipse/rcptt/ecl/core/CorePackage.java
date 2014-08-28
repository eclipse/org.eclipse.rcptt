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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see org.eclipse.rcptt.ecl.core.CoreFactory
 * @model kind="package"
 * @generated
 */
public interface CorePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "core";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/ecl/core.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.eclipse.rcptt.ecl.core";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CorePackage eINSTANCE = org.eclipse.rcptt.ecl.core.impl.CorePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.core.impl.CommandImpl <em>Command</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.core.impl.CommandImpl
	 * @see org.eclipse.rcptt.ecl.core.impl.CorePackageImpl#getCommand()
	 * @generated
	 */
	int COMMAND = 0;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND__HOST = 0;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND__BINDINGS = 1;

	/**
	 * The number of structural features of the '<em>Command</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.core.impl.BindingImpl <em>Binding</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.core.impl.BindingImpl
	 * @see org.eclipse.rcptt.ecl.core.impl.CorePackageImpl#getBinding()
	 * @generated
	 */
	int BINDING = 1;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING__FEATURE = 0;

	/**
	 * The feature id for the '<em><b>Command</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING__COMMAND = 1;

	/**
	 * The number of structural features of the '<em>Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.core.impl.BlockImpl <em>Block</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.core.impl.BlockImpl
	 * @see org.eclipse.rcptt.ecl.core.impl.CorePackageImpl#getBlock()
	 * @generated
	 */
	int BLOCK = 2;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK__HOST = COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK__BINDINGS = COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Commands</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK__COMMANDS = COMMAND_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Block</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_FEATURE_COUNT = COMMAND_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.core.impl.PipelineImpl <em>Pipeline</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.core.impl.PipelineImpl
	 * @see org.eclipse.rcptt.ecl.core.impl.CorePackageImpl#getPipeline()
	 * @generated
	 */
	int PIPELINE = 3;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPELINE__HOST = BLOCK__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPELINE__BINDINGS = BLOCK__BINDINGS;

	/**
	 * The feature id for the '<em><b>Commands</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPELINE__COMMANDS = BLOCK__COMMANDS;

	/**
	 * The number of structural features of the '<em>Pipeline</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PIPELINE_FEATURE_COUNT = BLOCK_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.core.impl.SequenceImpl <em>Sequence</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.core.impl.SequenceImpl
	 * @see org.eclipse.rcptt.ecl.core.impl.CorePackageImpl#getSequence()
	 * @generated
	 */
	int SEQUENCE = 4;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE__HOST = BLOCK__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE__BINDINGS = BLOCK__BINDINGS;

	/**
	 * The feature id for the '<em><b>Commands</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE__COMMANDS = BLOCK__COMMANDS;

	/**
	 * The number of structural features of the '<em>Sequence</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_FEATURE_COUNT = BLOCK_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.core.impl.ParallelImpl <em>Parallel</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.core.impl.ParallelImpl
	 * @see org.eclipse.rcptt.ecl.core.impl.CorePackageImpl#getParallel()
	 * @generated
	 */
	int PARALLEL = 5;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARALLEL__HOST = BLOCK__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARALLEL__BINDINGS = BLOCK__BINDINGS;

	/**
	 * The feature id for the '<em><b>Commands</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARALLEL__COMMANDS = BLOCK__COMMANDS;

	/**
	 * The number of structural features of the '<em>Parallel</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARALLEL_FEATURE_COUNT = BLOCK_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.core.impl.WithImpl <em>With</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.core.impl.WithImpl
	 * @see org.eclipse.rcptt.ecl.core.impl.CorePackageImpl#getWith()
	 * @generated
	 */
	int WITH = 6;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WITH__HOST = COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WITH__BINDINGS = COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Object</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WITH__OBJECT = COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Do</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WITH__DO = COMMAND_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>With</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WITH_FEATURE_COUNT = COMMAND_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.core.impl.ExecImpl <em>Exec</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.core.impl.ExecImpl
	 * @see org.eclipse.rcptt.ecl.core.impl.CorePackageImpl#getExec()
	 * @generated
	 */
	int EXEC = 7;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXEC__HOST = COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXEC__BINDINGS = COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXEC__NAMESPACE = COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXEC__NAME = COMMAND_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXEC__PARAMETERS = COMMAND_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Exec</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXEC_FEATURE_COUNT = COMMAND_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.core.impl.ParameterImpl <em>Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.core.impl.ParameterImpl
	 * @see org.eclipse.rcptt.ecl.core.impl.CorePackageImpl#getParameter()
	 * @generated
	 */
	int PARAMETER = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__NAME = 0;

	/**
	 * The number of structural features of the '<em>Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.core.impl.ExecutableParameterImpl <em>Executable Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.core.impl.ExecutableParameterImpl
	 * @see org.eclipse.rcptt.ecl.core.impl.CorePackageImpl#getExecutableParameter()
	 * @generated
	 */
	int EXECUTABLE_PARAMETER = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTABLE_PARAMETER__NAME = PARAMETER__NAME;

	/**
	 * The feature id for the '<em><b>Command</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTABLE_PARAMETER__COMMAND = PARAMETER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Executable Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTABLE_PARAMETER_FEATURE_COUNT = PARAMETER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.core.impl.LiteralParameterImpl <em>Literal Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.core.impl.LiteralParameterImpl
	 * @see org.eclipse.rcptt.ecl.core.impl.CorePackageImpl#getLiteralParameter()
	 * @generated
	 */
	int LITERAL_PARAMETER = 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_PARAMETER__NAME = PARAMETER__NAME;

	/**
	 * The feature id for the '<em><b>Literal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_PARAMETER__LITERAL = PARAMETER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_PARAMETER__FORMAT = PARAMETER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Literal Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_PARAMETER_FEATURE_COUNT = PARAMETER_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.core.impl.ForeachImpl <em>Foreach</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.core.impl.ForeachImpl
	 * @see org.eclipse.rcptt.ecl.core.impl.CorePackageImpl#getForeach()
	 * @generated
	 */
	int FOREACH = 11;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOREACH__HOST = COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOREACH__BINDINGS = COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Item</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOREACH__ITEM = COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Do</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOREACH__DO = COMMAND_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Input</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOREACH__INPUT = COMMAND_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Foreach</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOREACH_FEATURE_COUNT = COMMAND_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.core.impl.ProcessStatusImpl <em>Process Status</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.core.impl.ProcessStatusImpl
	 * @see org.eclipse.rcptt.ecl.core.impl.CorePackageImpl#getProcessStatus()
	 * @generated
	 */
	int PROCESS_STATUS = 13;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.core.impl.ScriptImpl <em>Script</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.core.impl.ScriptImpl
	 * @see org.eclipse.rcptt.ecl.core.impl.CorePackageImpl#getScript()
	 * @generated
	 */
	int SCRIPT = 12;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT__HOST = COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT__BINDINGS = COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT__CONTENT = COMMAND_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Script</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_FEATURE_COUNT = COMMAND_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Plugin Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_STATUS__PLUGIN_ID = 0;

	/**
	 * The feature id for the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_STATUS__CODE = 1;

	/**
	 * The feature id for the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_STATUS__MESSAGE = 2;

	/**
	 * The feature id for the '<em><b>Severity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_STATUS__SEVERITY = 3;

	/**
	 * The feature id for the '<em><b>Exception</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_STATUS__EXCEPTION = 4;

	/**
	 * The number of structural features of the '<em>Process Status</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_STATUS_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.core.impl.ConvertedToEMFPipeImpl <em>Converted To EMF Pipe</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.core.impl.ConvertedToEMFPipeImpl
	 * @see org.eclipse.rcptt.ecl.core.impl.CorePackageImpl#getConvertedToEMFPipe()
	 * @generated
	 */
	int CONVERTED_TO_EMF_PIPE = 14;

	/**
	 * The feature id for the '<em><b>Object</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONVERTED_TO_EMF_PIPE__OBJECT = 0;

	/**
	 * The number of structural features of the '<em>Converted To EMF Pipe</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONVERTED_TO_EMF_PIPE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.core.impl.SerializedImpl <em>Serialized</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.core.impl.SerializedImpl
	 * @see org.eclipse.rcptt.ecl.core.impl.CorePackageImpl#getSerialized()
	 * @generated
	 */
	int SERIALIZED = 15;

	/**
	 * The feature id for the '<em><b>Bytes</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERIALIZED__BYTES = 0;

	/**
	 * The number of structural features of the '<em>Serialized</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERIALIZED_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.core.impl.NullableImpl <em>Nullable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.core.impl.NullableImpl
	 * @see org.eclipse.rcptt.ecl.core.impl.CorePackageImpl#getNullable()
	 * @generated
	 */
	int NULLABLE = 16;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULLABLE__VALUE = 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULLABLE__TYPE = 1;

	/**
	 * The number of structural features of the '<em>Nullable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULLABLE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.core.impl.IfImpl <em>If</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.core.impl.IfImpl
	 * @see org.eclipse.rcptt.ecl.core.impl.CorePackageImpl#getIf()
	 * @generated
	 */
	int IF = 17;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF__HOST = COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF__BINDINGS = COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF__CONDITION = COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Then</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF__THEN = COMMAND_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Else</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF__ELSE = COMMAND_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>If</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_FEATURE_COUNT = COMMAND_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.core.impl.BoxedValueImpl <em>Boxed Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.core.impl.BoxedValueImpl
	 * @see org.eclipse.rcptt.ecl.core.impl.CorePackageImpl#getBoxedValue()
	 * @generated
	 */
	int BOXED_VALUE = 18;

	/**
	 * The number of structural features of the '<em>Boxed Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOXED_VALUE_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.core.impl.EclByteImpl <em>Ecl Byte</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.core.impl.EclByteImpl
	 * @see org.eclipse.rcptt.ecl.core.impl.CorePackageImpl#getEclByte()
	 * @generated
	 */
	int ECL_BYTE = 19;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECL_BYTE__VALUE = BOXED_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Ecl Byte</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECL_BYTE_FEATURE_COUNT = BOXED_VALUE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.core.impl.EclShortImpl <em>Ecl Short</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.core.impl.EclShortImpl
	 * @see org.eclipse.rcptt.ecl.core.impl.CorePackageImpl#getEclShort()
	 * @generated
	 */
	int ECL_SHORT = 20;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECL_SHORT__VALUE = BOXED_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Ecl Short</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECL_SHORT_FEATURE_COUNT = BOXED_VALUE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.core.impl.EclStringImpl <em>Ecl String</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.core.impl.EclStringImpl
	 * @see org.eclipse.rcptt.ecl.core.impl.CorePackageImpl#getEclString()
	 * @generated
	 */
	int ECL_STRING = 27;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.core.impl.EclBooleanImpl <em>Ecl Boolean</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.core.impl.EclBooleanImpl
	 * @see org.eclipse.rcptt.ecl.core.impl.CorePackageImpl#getEclBoolean()
	 * @generated
	 */
	int ECL_BOOLEAN = 25;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.core.impl.EclCharImpl <em>Ecl Char</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.core.impl.EclCharImpl
	 * @see org.eclipse.rcptt.ecl.core.impl.CorePackageImpl#getEclChar()
	 * @generated
	 */
	int ECL_CHAR = 26;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.core.impl.EclIntegerImpl <em>Ecl Integer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.core.impl.EclIntegerImpl
	 * @see org.eclipse.rcptt.ecl.core.impl.CorePackageImpl#getEclInteger()
	 * @generated
	 */
	int ECL_INTEGER = 21;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECL_INTEGER__VALUE = BOXED_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Ecl Integer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECL_INTEGER_FEATURE_COUNT = BOXED_VALUE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.core.impl.EclFloatImpl <em>Ecl Float</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.core.impl.EclFloatImpl
	 * @see org.eclipse.rcptt.ecl.core.impl.CorePackageImpl#getEclFloat()
	 * @generated
	 */
	int ECL_FLOAT = 24;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.core.impl.EclLongImpl <em>Ecl Long</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.core.impl.EclLongImpl
	 * @see org.eclipse.rcptt.ecl.core.impl.CorePackageImpl#getEclLong()
	 * @generated
	 */
	int ECL_LONG = 22;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECL_LONG__VALUE = BOXED_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Ecl Long</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECL_LONG_FEATURE_COUNT = BOXED_VALUE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.core.impl.EclDoubleImpl <em>Ecl Double</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.core.impl.EclDoubleImpl
	 * @see org.eclipse.rcptt.ecl.core.impl.CorePackageImpl#getEclDouble()
	 * @generated
	 */
	int ECL_DOUBLE = 23;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECL_DOUBLE__VALUE = BOXED_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Ecl Double</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECL_DOUBLE_FEATURE_COUNT = BOXED_VALUE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECL_FLOAT__VALUE = BOXED_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Ecl Float</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECL_FLOAT_FEATURE_COUNT = BOXED_VALUE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECL_BOOLEAN__VALUE = BOXED_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Ecl Boolean</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECL_BOOLEAN_FEATURE_COUNT = BOXED_VALUE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECL_CHAR__VALUE = BOXED_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Ecl Char</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECL_CHAR_FEATURE_COUNT = BOXED_VALUE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECL_STRING__VALUE = BOXED_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Ecl String</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECL_STRING_FEATURE_COUNT = BOXED_VALUE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.core.impl.EclExceptionImpl <em>Ecl Exception</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.core.impl.EclExceptionImpl
	 * @see org.eclipse.rcptt.ecl.core.impl.CorePackageImpl#getEclException()
	 * @generated
	 */
	int ECL_EXCEPTION = 28;

	/**
	 * The feature id for the '<em><b>Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECL_EXCEPTION__CLASS_NAME = 0;

	/**
	 * The feature id for the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECL_EXCEPTION__MESSAGE = 1;

	/**
	 * The feature id for the '<em><b>Stack Trace</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECL_EXCEPTION__STACK_TRACE = 2;

	/**
	 * The feature id for the '<em><b>Throwable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECL_EXCEPTION__THROWABLE = 3;

	/**
	 * The feature id for the '<em><b>Cause</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECL_EXCEPTION__CAUSE = 4;

	/**
	 * The number of structural features of the '<em>Ecl Exception</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECL_EXCEPTION_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.core.impl.EclStackTraceEntryImpl <em>Ecl Stack Trace Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.core.impl.EclStackTraceEntryImpl
	 * @see org.eclipse.rcptt.ecl.core.impl.CorePackageImpl#getEclStackTraceEntry()
	 * @generated
	 */
	int ECL_STACK_TRACE_ENTRY = 29;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECL_STACK_TRACE_ENTRY__INDEX = 0;

	/**
	 * The feature id for the '<em><b>Declaring Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECL_STACK_TRACE_ENTRY__DECLARING_CLASS = 1;

	/**
	 * The feature id for the '<em><b>Method Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECL_STACK_TRACE_ENTRY__METHOD_NAME = 2;

	/**
	 * The feature id for the '<em><b>File Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECL_STACK_TRACE_ENTRY__FILE_NAME = 3;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECL_STACK_TRACE_ENTRY__LINE_NUMBER = 4;

	/**
	 * The feature id for the '<em><b>Native Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECL_STACK_TRACE_ENTRY__NATIVE_METHOD = 5;

	/**
	 * The number of structural features of the '<em>Ecl Stack Trace Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECL_STACK_TRACE_ENTRY_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.core.impl.ListenImpl <em>Listen</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.core.impl.ListenImpl
	 * @see org.eclipse.rcptt.ecl.core.impl.CorePackageImpl#getListen()
	 * @generated
	 */
	int LISTEN = 30;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LISTEN__HOST = COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LISTEN__BINDINGS = COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LISTEN__SOURCE = COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>While</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LISTEN__WHILE = COMMAND_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Listen</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LISTEN_FEATURE_COUNT = COMMAND_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.core.impl.DeclarationImpl <em>Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.core.impl.DeclarationImpl
	 * @see org.eclipse.rcptt.ecl.core.impl.CorePackageImpl#getDeclaration()
	 * @generated
	 */
	int DECLARATION = 31;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECLARATION__HOST = COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECLARATION__BINDINGS = COMMAND__BINDINGS;

	/**
	 * The number of structural features of the '<em>Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECLARATION_FEATURE_COUNT = COMMAND_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.core.impl.ValImpl <em>Val</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.core.impl.ValImpl
	 * @see org.eclipse.rcptt.ecl.core.impl.CorePackageImpl#getVal()
	 * @generated
	 */
	int VAL = 32;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAL__HOST = DECLARATION__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAL__BINDINGS = DECLARATION__BINDINGS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAL__NAME = DECLARATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAL__VALUE = DECLARATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Input</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAL__INPUT = DECLARATION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Val</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAL_FEATURE_COUNT = DECLARATION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.core.impl.GetValImpl <em>Get Val</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.core.impl.GetValImpl
	 * @see org.eclipse.rcptt.ecl.core.impl.CorePackageImpl#getGetVal()
	 * @generated
	 */
	int GET_VAL = 33;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_VAL__HOST = COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_VAL__BINDINGS = COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_VAL__NAME = COMMAND_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Get Val</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_VAL_FEATURE_COUNT = COMMAND_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.core.impl.LetImpl <em>Let</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.core.impl.LetImpl
	 * @see org.eclipse.rcptt.ecl.core.impl.CorePackageImpl#getLet()
	 * @generated
	 */
	int LET = 34;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET__HOST = COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET__BINDINGS = COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Vals</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET__VALS = COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET__BODY = COMMAND_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Let</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET_FEATURE_COUNT = COMMAND_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.core.impl.ProcImpl <em>Proc</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.core.impl.ProcImpl
	 * @see org.eclipse.rcptt.ecl.core.impl.CorePackageImpl#getProc()
	 * @generated
	 */
	int PROC = 35;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROC__HOST = COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROC__BINDINGS = COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROC__NAME = COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Vals</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROC__VALS = COMMAND_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROC__BODY = COMMAND_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Proc</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROC_FEATURE_COUNT = COMMAND_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.core.impl.ProcInstanceImpl <em>Proc Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.core.impl.ProcInstanceImpl
	 * @see org.eclipse.rcptt.ecl.core.impl.CorePackageImpl#getProcInstance()
	 * @generated
	 */
	int PROC_INSTANCE = 36;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROC_INSTANCE__HOST = COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROC_INSTANCE__BINDINGS = COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROC_INSTANCE__DEFINITION = COMMAND_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Proc Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROC_INSTANCE_FEATURE_COUNT = COMMAND_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.core.impl.GlobalImpl <em>Global</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.core.impl.GlobalImpl
	 * @see org.eclipse.rcptt.ecl.core.impl.CorePackageImpl#getGlobal()
	 * @generated
	 */
	int GLOBAL = 37;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL__HOST = COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL__BINDINGS = COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Vals</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL__VALS = COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Override</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL__OVERRIDE = COMMAND_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Global</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_FEATURE_COUNT = COMMAND_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.core.impl.SessionStateImpl <em>Session State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.core.impl.SessionStateImpl
	 * @see org.eclipse.rcptt.ecl.core.impl.CorePackageImpl#getSessionState()
	 * @generated
	 */
	int SESSION_STATE = 38;

	/**
	 * The feature id for the '<em><b>Procs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SESSION_STATE__PROCS = 0;

	/**
	 * The feature id for the '<em><b>Decls</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SESSION_STATE__DECLS = 1;

	/**
	 * The number of structural features of the '<em>Session State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SESSION_STATE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.core.impl.SaveStateImpl <em>Save State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.core.impl.SaveStateImpl
	 * @see org.eclipse.rcptt.ecl.core.impl.CorePackageImpl#getSaveState()
	 * @generated
	 */
	int SAVE_STATE = 39;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAVE_STATE__HOST = COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAVE_STATE__BINDINGS = COMMAND__BINDINGS;

	/**
	 * The number of structural features of the '<em>Save State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAVE_STATE_FEATURE_COUNT = COMMAND_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.core.impl.RestoreStateImpl <em>Restore State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.core.impl.RestoreStateImpl
	 * @see org.eclipse.rcptt.ecl.core.impl.CorePackageImpl#getRestoreState()
	 * @generated
	 */
	int RESTORE_STATE = 40;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESTORE_STATE__HOST = COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESTORE_STATE__BINDINGS = COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>State</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESTORE_STATE__STATE = COMMAND_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Restore State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESTORE_STATE_FEATURE_COUNT = COMMAND_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.core.impl.GetImpl <em>Get</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.core.impl.GetImpl
	 * @see org.eclipse.rcptt.ecl.core.impl.CorePackageImpl#getGet()
	 * @generated
	 */
	int GET = 41;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET__HOST = COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET__BINDINGS = COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Input</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET__INPUT = COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Key</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET__KEY = COMMAND_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Default</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET__DEFAULT = COMMAND_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Get</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GET_FEATURE_COUNT = COMMAND_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.core.impl.EclListImpl <em>Ecl List</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.core.impl.EclListImpl
	 * @see org.eclipse.rcptt.ecl.core.impl.CorePackageImpl#getEclList()
	 * @generated
	 */
	int ECL_LIST = 42;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECL_LIST__ELEMENTS = 0;

	/**
	 * The number of structural features of the '<em>Ecl List</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECL_LIST_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.core.impl.EclMapImpl <em>Ecl Map</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.core.impl.EclMapImpl
	 * @see org.eclipse.rcptt.ecl.core.impl.CorePackageImpl#getEclMap()
	 * @generated
	 */
	int ECL_MAP = 43;

	/**
	 * The feature id for the '<em><b>Entries</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECL_MAP__ENTRIES = 0;

	/**
	 * The number of structural features of the '<em>Ecl Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECL_MAP_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.core.impl.EclMapEntryImpl <em>Ecl Map Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.core.impl.EclMapEntryImpl
	 * @see org.eclipse.rcptt.ecl.core.impl.CorePackageImpl#getEclMapEntry()
	 * @generated
	 */
	int ECL_MAP_ENTRY = 44;

	/**
	 * The feature id for the '<em><b>Key</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECL_MAP_ENTRY__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECL_MAP_ENTRY__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Ecl Map Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECL_MAP_ENTRY_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.core.impl.CaseImpl <em>Case</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.core.impl.CaseImpl
	 * @see org.eclipse.rcptt.ecl.core.impl.CorePackageImpl#getCase()
	 * @generated
	 */
	int CASE = 45;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE__HOST = COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE__BINDINGS = COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE__CONDITION = COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Then</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE__THEN = COMMAND_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Case</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE_FEATURE_COUNT = COMMAND_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.rcptt.ecl.core.impl.SwitchImpl <em>Switch</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.rcptt.ecl.core.impl.SwitchImpl
	 * @see org.eclipse.rcptt.ecl.core.impl.CorePackageImpl#getSwitch()
	 * @generated
	 */
	int SWITCH = 46;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH__HOST = COMMAND__HOST;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH__BINDINGS = COMMAND__BINDINGS;

	/**
	 * The feature id for the '<em><b>Input</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH__INPUT = COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Items</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH__ITEMS = COMMAND_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Default</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH__DEFAULT = COMMAND_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Switch</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_FEATURE_COUNT = COMMAND_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '<em>Throwable</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.Throwable
	 * @see org.eclipse.rcptt.ecl.core.impl.CorePackageImpl#getThrowable()
	 * @generated
	 */
	int THROWABLE = 47;

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.core.Command <em>Command</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Command</em>'.
	 * @see org.eclipse.rcptt.ecl.core.Command
	 * @generated
	 */
	EClass getCommand();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.core.Command#getHost <em>Host</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Host</em>'.
	 * @see org.eclipse.rcptt.ecl.core.Command#getHost()
	 * @see #getCommand()
	 * @generated
	 */
	EAttribute getCommand_Host();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.rcptt.ecl.core.Command#getBindings <em>Bindings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Bindings</em>'.
	 * @see org.eclipse.rcptt.ecl.core.Command#getBindings()
	 * @see #getCommand()
	 * @generated
	 */
	EReference getCommand_Bindings();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.core.Binding <em>Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Binding</em>'.
	 * @see org.eclipse.rcptt.ecl.core.Binding
	 * @generated
	 */
	EClass getBinding();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.rcptt.ecl.core.Binding#getFeature <em>Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Feature</em>'.
	 * @see org.eclipse.rcptt.ecl.core.Binding#getFeature()
	 * @see #getBinding()
	 * @generated
	 */
	EReference getBinding_Feature();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.rcptt.ecl.core.Binding#getCommand <em>Command</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Command</em>'.
	 * @see org.eclipse.rcptt.ecl.core.Binding#getCommand()
	 * @see #getBinding()
	 * @generated
	 */
	EReference getBinding_Command();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.core.Block <em>Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Block</em>'.
	 * @see org.eclipse.rcptt.ecl.core.Block
	 * @generated
	 */
	EClass getBlock();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.rcptt.ecl.core.Block#getCommands <em>Commands</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Commands</em>'.
	 * @see org.eclipse.rcptt.ecl.core.Block#getCommands()
	 * @see #getBlock()
	 * @generated
	 */
	EReference getBlock_Commands();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.core.Pipeline <em>Pipeline</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pipeline</em>'.
	 * @see org.eclipse.rcptt.ecl.core.Pipeline
	 * @generated
	 */
	EClass getPipeline();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.core.Sequence <em>Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sequence</em>'.
	 * @see org.eclipse.rcptt.ecl.core.Sequence
	 * @generated
	 */
	EClass getSequence();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.core.Parallel <em>Parallel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parallel</em>'.
	 * @see org.eclipse.rcptt.ecl.core.Parallel
	 * @generated
	 */
	EClass getParallel();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.core.With <em>With</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>With</em>'.
	 * @see org.eclipse.rcptt.ecl.core.With
	 * @generated
	 */
	EClass getWith();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.rcptt.ecl.core.With#getObject <em>Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Object</em>'.
	 * @see org.eclipse.rcptt.ecl.core.With#getObject()
	 * @see #getWith()
	 * @generated
	 */
	EReference getWith_Object();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.rcptt.ecl.core.With#getDo <em>Do</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Do</em>'.
	 * @see org.eclipse.rcptt.ecl.core.With#getDo()
	 * @see #getWith()
	 * @generated
	 */
	EReference getWith_Do();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.core.Exec <em>Exec</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Exec</em>'.
	 * @see org.eclipse.rcptt.ecl.core.Exec
	 * @generated
	 */
	EClass getExec();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.core.Exec#getNamespace <em>Namespace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Namespace</em>'.
	 * @see org.eclipse.rcptt.ecl.core.Exec#getNamespace()
	 * @see #getExec()
	 * @generated
	 */
	EAttribute getExec_Namespace();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.core.Exec#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.rcptt.ecl.core.Exec#getName()
	 * @see #getExec()
	 * @generated
	 */
	EAttribute getExec_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.rcptt.ecl.core.Exec#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see org.eclipse.rcptt.ecl.core.Exec#getParameters()
	 * @see #getExec()
	 * @generated
	 */
	EReference getExec_Parameters();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.core.Parameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter</em>'.
	 * @see org.eclipse.rcptt.ecl.core.Parameter
	 * @generated
	 */
	EClass getParameter();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.core.Parameter#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.rcptt.ecl.core.Parameter#getName()
	 * @see #getParameter()
	 * @generated
	 */
	EAttribute getParameter_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.core.ExecutableParameter <em>Executable Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Executable Parameter</em>'.
	 * @see org.eclipse.rcptt.ecl.core.ExecutableParameter
	 * @generated
	 */
	EClass getExecutableParameter();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.rcptt.ecl.core.ExecutableParameter#getCommand <em>Command</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Command</em>'.
	 * @see org.eclipse.rcptt.ecl.core.ExecutableParameter#getCommand()
	 * @see #getExecutableParameter()
	 * @generated
	 */
	EReference getExecutableParameter_Command();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.core.LiteralParameter <em>Literal Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Literal Parameter</em>'.
	 * @see org.eclipse.rcptt.ecl.core.LiteralParameter
	 * @generated
	 */
	EClass getLiteralParameter();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.core.LiteralParameter#getLiteral <em>Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Literal</em>'.
	 * @see org.eclipse.rcptt.ecl.core.LiteralParameter#getLiteral()
	 * @see #getLiteralParameter()
	 * @generated
	 */
	EAttribute getLiteralParameter_Literal();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.core.LiteralParameter#getFormat <em>Format</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Format</em>'.
	 * @see org.eclipse.rcptt.ecl.core.LiteralParameter#getFormat()
	 * @see #getLiteralParameter()
	 * @generated
	 */
	EAttribute getLiteralParameter_Format();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.core.Foreach <em>Foreach</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Foreach</em>'.
	 * @see org.eclipse.rcptt.ecl.core.Foreach
	 * @generated
	 */
	EClass getForeach();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.rcptt.ecl.core.Foreach#getItem <em>Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Item</em>'.
	 * @see org.eclipse.rcptt.ecl.core.Foreach#getItem()
	 * @see #getForeach()
	 * @generated
	 */
	EReference getForeach_Item();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.rcptt.ecl.core.Foreach#getDo <em>Do</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Do</em>'.
	 * @see org.eclipse.rcptt.ecl.core.Foreach#getDo()
	 * @see #getForeach()
	 * @generated
	 */
	EReference getForeach_Do();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.rcptt.ecl.core.Foreach#getInput <em>Input</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Input</em>'.
	 * @see org.eclipse.rcptt.ecl.core.Foreach#getInput()
	 * @see #getForeach()
	 * @generated
	 */
	EReference getForeach_Input();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.core.ProcessStatus <em>Process Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Process Status</em>'.
	 * @see org.eclipse.rcptt.ecl.core.ProcessStatus
	 * @generated
	 */
	EClass getProcessStatus();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.core.ProcessStatus#getPluginId <em>Plugin Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Plugin Id</em>'.
	 * @see org.eclipse.rcptt.ecl.core.ProcessStatus#getPluginId()
	 * @see #getProcessStatus()
	 * @generated
	 */
	EAttribute getProcessStatus_PluginId();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.core.ProcessStatus#getCode <em>Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Code</em>'.
	 * @see org.eclipse.rcptt.ecl.core.ProcessStatus#getCode()
	 * @see #getProcessStatus()
	 * @generated
	 */
	EAttribute getProcessStatus_Code();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.core.ProcessStatus#getMessage <em>Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Message</em>'.
	 * @see org.eclipse.rcptt.ecl.core.ProcessStatus#getMessage()
	 * @see #getProcessStatus()
	 * @generated
	 */
	EAttribute getProcessStatus_Message();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.core.ProcessStatus#getSeverity <em>Severity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Severity</em>'.
	 * @see org.eclipse.rcptt.ecl.core.ProcessStatus#getSeverity()
	 * @see #getProcessStatus()
	 * @generated
	 */
	EAttribute getProcessStatus_Severity();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.rcptt.ecl.core.ProcessStatus#getException <em>Exception</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Exception</em>'.
	 * @see org.eclipse.rcptt.ecl.core.ProcessStatus#getException()
	 * @see #getProcessStatus()
	 * @generated
	 */
	EReference getProcessStatus_Exception();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.core.ConvertedToEMFPipe <em>Converted To EMF Pipe</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Converted To EMF Pipe</em>'.
	 * @see org.eclipse.rcptt.ecl.core.ConvertedToEMFPipe
	 * @generated
	 */
	EClass getConvertedToEMFPipe();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.rcptt.ecl.core.ConvertedToEMFPipe#getObject <em>Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Object</em>'.
	 * @see org.eclipse.rcptt.ecl.core.ConvertedToEMFPipe#getObject()
	 * @see #getConvertedToEMFPipe()
	 * @generated
	 */
	EReference getConvertedToEMFPipe_Object();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.core.Serialized <em>Serialized</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Serialized</em>'.
	 * @see org.eclipse.rcptt.ecl.core.Serialized
	 * @generated
	 */
	EClass getSerialized();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.core.Serialized#getBytes <em>Bytes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Bytes</em>'.
	 * @see org.eclipse.rcptt.ecl.core.Serialized#getBytes()
	 * @see #getSerialized()
	 * @generated
	 */
	EAttribute getSerialized_Bytes();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.core.Nullable <em>Nullable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Nullable</em>'.
	 * @see org.eclipse.rcptt.ecl.core.Nullable
	 * @generated
	 */
	EClass getNullable();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.rcptt.ecl.core.Nullable#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see org.eclipse.rcptt.ecl.core.Nullable#getValue()
	 * @see #getNullable()
	 * @generated
	 */
	EReference getNullable_Value();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.core.Nullable#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.eclipse.rcptt.ecl.core.Nullable#getType()
	 * @see #getNullable()
	 * @generated
	 */
	EAttribute getNullable_Type();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.core.If <em>If</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>If</em>'.
	 * @see org.eclipse.rcptt.ecl.core.If
	 * @generated
	 */
	EClass getIf();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.rcptt.ecl.core.If#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Condition</em>'.
	 * @see org.eclipse.rcptt.ecl.core.If#getCondition()
	 * @see #getIf()
	 * @generated
	 */
	EReference getIf_Condition();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.rcptt.ecl.core.If#getThen <em>Then</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Then</em>'.
	 * @see org.eclipse.rcptt.ecl.core.If#getThen()
	 * @see #getIf()
	 * @generated
	 */
	EReference getIf_Then();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.rcptt.ecl.core.If#getElse <em>Else</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Else</em>'.
	 * @see org.eclipse.rcptt.ecl.core.If#getElse()
	 * @see #getIf()
	 * @generated
	 */
	EReference getIf_Else();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.core.EclString <em>Ecl String</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ecl String</em>'.
	 * @see org.eclipse.rcptt.ecl.core.EclString
	 * @generated
	 */
	EClass getEclString();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.core.EclString#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.rcptt.ecl.core.EclString#getValue()
	 * @see #getEclString()
	 * @generated
	 */
	EAttribute getEclString_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.core.EclException <em>Ecl Exception</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ecl Exception</em>'.
	 * @see org.eclipse.rcptt.ecl.core.EclException
	 * @generated
	 */
	EClass getEclException();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.core.EclException#getClassName <em>Class Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Class Name</em>'.
	 * @see org.eclipse.rcptt.ecl.core.EclException#getClassName()
	 * @see #getEclException()
	 * @generated
	 */
	EAttribute getEclException_ClassName();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.core.EclException#getMessage <em>Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Message</em>'.
	 * @see org.eclipse.rcptt.ecl.core.EclException#getMessage()
	 * @see #getEclException()
	 * @generated
	 */
	EAttribute getEclException_Message();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.rcptt.ecl.core.EclException#getStackTrace <em>Stack Trace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Stack Trace</em>'.
	 * @see org.eclipse.rcptt.ecl.core.EclException#getStackTrace()
	 * @see #getEclException()
	 * @generated
	 */
	EReference getEclException_StackTrace();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.core.EclException#getThrowable <em>Throwable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Throwable</em>'.
	 * @see org.eclipse.rcptt.ecl.core.EclException#getThrowable()
	 * @see #getEclException()
	 * @generated
	 */
	EAttribute getEclException_Throwable();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.rcptt.ecl.core.EclException#getCause <em>Cause</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Cause</em>'.
	 * @see org.eclipse.rcptt.ecl.core.EclException#getCause()
	 * @see #getEclException()
	 * @generated
	 */
	EReference getEclException_Cause();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.core.EclStackTraceEntry <em>Ecl Stack Trace Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ecl Stack Trace Entry</em>'.
	 * @see org.eclipse.rcptt.ecl.core.EclStackTraceEntry
	 * @generated
	 */
	EClass getEclStackTraceEntry();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.core.EclStackTraceEntry#getIndex <em>Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Index</em>'.
	 * @see org.eclipse.rcptt.ecl.core.EclStackTraceEntry#getIndex()
	 * @see #getEclStackTraceEntry()
	 * @generated
	 */
	EAttribute getEclStackTraceEntry_Index();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.core.EclStackTraceEntry#getDeclaringClass <em>Declaring Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Declaring Class</em>'.
	 * @see org.eclipse.rcptt.ecl.core.EclStackTraceEntry#getDeclaringClass()
	 * @see #getEclStackTraceEntry()
	 * @generated
	 */
	EAttribute getEclStackTraceEntry_DeclaringClass();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.core.EclStackTraceEntry#getMethodName <em>Method Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Method Name</em>'.
	 * @see org.eclipse.rcptt.ecl.core.EclStackTraceEntry#getMethodName()
	 * @see #getEclStackTraceEntry()
	 * @generated
	 */
	EAttribute getEclStackTraceEntry_MethodName();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.core.EclStackTraceEntry#getFileName <em>File Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>File Name</em>'.
	 * @see org.eclipse.rcptt.ecl.core.EclStackTraceEntry#getFileName()
	 * @see #getEclStackTraceEntry()
	 * @generated
	 */
	EAttribute getEclStackTraceEntry_FileName();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.core.EclStackTraceEntry#getLineNumber <em>Line Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Line Number</em>'.
	 * @see org.eclipse.rcptt.ecl.core.EclStackTraceEntry#getLineNumber()
	 * @see #getEclStackTraceEntry()
	 * @generated
	 */
	EAttribute getEclStackTraceEntry_LineNumber();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.core.EclStackTraceEntry#isNativeMethod <em>Native Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Native Method</em>'.
	 * @see org.eclipse.rcptt.ecl.core.EclStackTraceEntry#isNativeMethod()
	 * @see #getEclStackTraceEntry()
	 * @generated
	 */
	EAttribute getEclStackTraceEntry_NativeMethod();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.core.Listen <em>Listen</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Listen</em>'.
	 * @see org.eclipse.rcptt.ecl.core.Listen
	 * @generated
	 */
	EClass getListen();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.core.Listen#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Source</em>'.
	 * @see org.eclipse.rcptt.ecl.core.Listen#getSource()
	 * @see #getListen()
	 * @generated
	 */
	EAttribute getListen_Source();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.rcptt.ecl.core.Listen#getWhile <em>While</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>While</em>'.
	 * @see org.eclipse.rcptt.ecl.core.Listen#getWhile()
	 * @see #getListen()
	 * @generated
	 */
	EReference getListen_While();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.core.Declaration <em>Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Declaration</em>'.
	 * @see org.eclipse.rcptt.ecl.core.Declaration
	 * @generated
	 */
	EClass getDeclaration();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.core.Val <em>Val</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Val</em>'.
	 * @see org.eclipse.rcptt.ecl.core.Val
	 * @generated
	 */
	EClass getVal();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.core.Val#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.rcptt.ecl.core.Val#getName()
	 * @see #getVal()
	 * @generated
	 */
	EAttribute getVal_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.core.Val#isInput <em>Input</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Input</em>'.
	 * @see org.eclipse.rcptt.ecl.core.Val#isInput()
	 * @see #getVal()
	 * @generated
	 */
	EAttribute getVal_Input();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.rcptt.ecl.core.Val#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Value</em>'.
	 * @see org.eclipse.rcptt.ecl.core.Val#getValue()
	 * @see #getVal()
	 * @generated
	 */
	EReference getVal_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.core.GetVal <em>Get Val</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get Val</em>'.
	 * @see org.eclipse.rcptt.ecl.core.GetVal
	 * @generated
	 */
	EClass getGetVal();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.core.GetVal#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.rcptt.ecl.core.GetVal#getName()
	 * @see #getGetVal()
	 * @generated
	 */
	EAttribute getGetVal_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.core.Let <em>Let</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Let</em>'.
	 * @see org.eclipse.rcptt.ecl.core.Let
	 * @generated
	 */
	EClass getLet();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.rcptt.ecl.core.Let#getVals <em>Vals</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Vals</em>'.
	 * @see org.eclipse.rcptt.ecl.core.Let#getVals()
	 * @see #getLet()
	 * @generated
	 */
	EReference getLet_Vals();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.rcptt.ecl.core.Let#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Body</em>'.
	 * @see org.eclipse.rcptt.ecl.core.Let#getBody()
	 * @see #getLet()
	 * @generated
	 */
	EReference getLet_Body();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.core.Proc <em>Proc</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Proc</em>'.
	 * @see org.eclipse.rcptt.ecl.core.Proc
	 * @generated
	 */
	EClass getProc();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.core.Proc#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.rcptt.ecl.core.Proc#getName()
	 * @see #getProc()
	 * @generated
	 */
	EAttribute getProc_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.rcptt.ecl.core.Proc#getVals <em>Vals</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Vals</em>'.
	 * @see org.eclipse.rcptt.ecl.core.Proc#getVals()
	 * @see #getProc()
	 * @generated
	 */
	EReference getProc_Vals();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.rcptt.ecl.core.Proc#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Body</em>'.
	 * @see org.eclipse.rcptt.ecl.core.Proc#getBody()
	 * @see #getProc()
	 * @generated
	 */
	EReference getProc_Body();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.core.ProcInstance <em>Proc Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Proc Instance</em>'.
	 * @see org.eclipse.rcptt.ecl.core.ProcInstance
	 * @generated
	 */
	EClass getProcInstance();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.rcptt.ecl.core.ProcInstance#getDefinition <em>Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Definition</em>'.
	 * @see org.eclipse.rcptt.ecl.core.ProcInstance#getDefinition()
	 * @see #getProcInstance()
	 * @generated
	 */
	EReference getProcInstance_Definition();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.core.Global <em>Global</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Global</em>'.
	 * @see org.eclipse.rcptt.ecl.core.Global
	 * @generated
	 */
	EClass getGlobal();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.rcptt.ecl.core.Global#getVals <em>Vals</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Vals</em>'.
	 * @see org.eclipse.rcptt.ecl.core.Global#getVals()
	 * @see #getGlobal()
	 * @generated
	 */
	EReference getGlobal_Vals();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.core.Global#isOverride <em>Override</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Override</em>'.
	 * @see org.eclipse.rcptt.ecl.core.Global#isOverride()
	 * @see #getGlobal()
	 * @generated
	 */
	EAttribute getGlobal_Override();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.core.SessionState <em>Session State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Session State</em>'.
	 * @see org.eclipse.rcptt.ecl.core.SessionState
	 * @generated
	 */
	EClass getSessionState();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.rcptt.ecl.core.SessionState#getProcs <em>Procs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Procs</em>'.
	 * @see org.eclipse.rcptt.ecl.core.SessionState#getProcs()
	 * @see #getSessionState()
	 * @generated
	 */
	EReference getSessionState_Procs();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.rcptt.ecl.core.SessionState#getDecls <em>Decls</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Decls</em>'.
	 * @see org.eclipse.rcptt.ecl.core.SessionState#getDecls()
	 * @see #getSessionState()
	 * @generated
	 */
	EReference getSessionState_Decls();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.core.SaveState <em>Save State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Save State</em>'.
	 * @see org.eclipse.rcptt.ecl.core.SaveState
	 * @generated
	 */
	EClass getSaveState();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.core.RestoreState <em>Restore State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Restore State</em>'.
	 * @see org.eclipse.rcptt.ecl.core.RestoreState
	 * @generated
	 */
	EClass getRestoreState();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.rcptt.ecl.core.RestoreState#getState <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>State</em>'.
	 * @see org.eclipse.rcptt.ecl.core.RestoreState#getState()
	 * @see #getRestoreState()
	 * @generated
	 */
	EReference getRestoreState_State();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.core.Get <em>Get</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Get</em>'.
	 * @see org.eclipse.rcptt.ecl.core.Get
	 * @generated
	 */
	EClass getGet();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.rcptt.ecl.core.Get#getInput <em>Input</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Input</em>'.
	 * @see org.eclipse.rcptt.ecl.core.Get#getInput()
	 * @see #getGet()
	 * @generated
	 */
	EReference getGet_Input();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.rcptt.ecl.core.Get#getKey <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Key</em>'.
	 * @see org.eclipse.rcptt.ecl.core.Get#getKey()
	 * @see #getGet()
	 * @generated
	 */
	EReference getGet_Key();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.rcptt.ecl.core.Get#getDefault <em>Default</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Default</em>'.
	 * @see org.eclipse.rcptt.ecl.core.Get#getDefault()
	 * @see #getGet()
	 * @generated
	 */
	EReference getGet_Default();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.core.EclList <em>Ecl List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ecl List</em>'.
	 * @see org.eclipse.rcptt.ecl.core.EclList
	 * @generated
	 */
	EClass getEclList();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.rcptt.ecl.core.EclList#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Elements</em>'.
	 * @see org.eclipse.rcptt.ecl.core.EclList#getElements()
	 * @see #getEclList()
	 * @generated
	 */
	EReference getEclList_Elements();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.core.EclMap <em>Ecl Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ecl Map</em>'.
	 * @see org.eclipse.rcptt.ecl.core.EclMap
	 * @generated
	 */
	EClass getEclMap();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.rcptt.ecl.core.EclMap#getEntries <em>Entries</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Entries</em>'.
	 * @see org.eclipse.rcptt.ecl.core.EclMap#getEntries()
	 * @see #getEclMap()
	 * @generated
	 */
	EReference getEclMap_Entries();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.core.EclMapEntry <em>Ecl Map Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ecl Map Entry</em>'.
	 * @see org.eclipse.rcptt.ecl.core.EclMapEntry
	 * @generated
	 */
	EClass getEclMapEntry();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.rcptt.ecl.core.EclMapEntry#getKey <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Key</em>'.
	 * @see org.eclipse.rcptt.ecl.core.EclMapEntry#getKey()
	 * @see #getEclMapEntry()
	 * @generated
	 */
	EReference getEclMapEntry_Key();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.rcptt.ecl.core.EclMapEntry#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see org.eclipse.rcptt.ecl.core.EclMapEntry#getValue()
	 * @see #getEclMapEntry()
	 * @generated
	 */
	EReference getEclMapEntry_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.core.Case <em>Case</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Case</em>'.
	 * @see org.eclipse.rcptt.ecl.core.Case
	 * @generated
	 */
	EClass getCase();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.rcptt.ecl.core.Case#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Condition</em>'.
	 * @see org.eclipse.rcptt.ecl.core.Case#getCondition()
	 * @see #getCase()
	 * @generated
	 */
	EReference getCase_Condition();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.rcptt.ecl.core.Case#getThen <em>Then</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Then</em>'.
	 * @see org.eclipse.rcptt.ecl.core.Case#getThen()
	 * @see #getCase()
	 * @generated
	 */
	EReference getCase_Then();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.core.Switch <em>Switch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Switch</em>'.
	 * @see org.eclipse.rcptt.ecl.core.Switch
	 * @generated
	 */
	EClass getSwitch();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.rcptt.ecl.core.Switch#getItems <em>Items</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Items</em>'.
	 * @see org.eclipse.rcptt.ecl.core.Switch#getItems()
	 * @see #getSwitch()
	 * @generated
	 */
	EReference getSwitch_Items();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.rcptt.ecl.core.Switch#getDefault <em>Default</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Default</em>'.
	 * @see org.eclipse.rcptt.ecl.core.Switch#getDefault()
	 * @see #getSwitch()
	 * @generated
	 */
	EReference getSwitch_Default();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.rcptt.ecl.core.Switch#getInput <em>Input</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Input</em>'.
	 * @see org.eclipse.rcptt.ecl.core.Switch#getInput()
	 * @see #getSwitch()
	 * @generated
	 */
	EReference getSwitch_Input();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.core.EclBoolean <em>Ecl Boolean</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ecl Boolean</em>'.
	 * @see org.eclipse.rcptt.ecl.core.EclBoolean
	 * @generated
	 */
	EClass getEclBoolean();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.core.EclBoolean#isValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.rcptt.ecl.core.EclBoolean#isValue()
	 * @see #getEclBoolean()
	 * @generated
	 */
	EAttribute getEclBoolean_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.core.EclChar <em>Ecl Char</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ecl Char</em>'.
	 * @see org.eclipse.rcptt.ecl.core.EclChar
	 * @generated
	 */
	EClass getEclChar();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.core.EclChar#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.rcptt.ecl.core.EclChar#getValue()
	 * @see #getEclChar()
	 * @generated
	 */
	EAttribute getEclChar_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.core.EclInteger <em>Ecl Integer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ecl Integer</em>'.
	 * @see org.eclipse.rcptt.ecl.core.EclInteger
	 * @generated
	 */
	EClass getEclInteger();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.core.EclInteger#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.rcptt.ecl.core.EclInteger#getValue()
	 * @see #getEclInteger()
	 * @generated
	 */
	EAttribute getEclInteger_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.core.EclFloat <em>Ecl Float</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ecl Float</em>'.
	 * @see org.eclipse.rcptt.ecl.core.EclFloat
	 * @generated
	 */
	EClass getEclFloat();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.core.EclFloat#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.rcptt.ecl.core.EclFloat#getValue()
	 * @see #getEclFloat()
	 * @generated
	 */
	EAttribute getEclFloat_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.core.EclLong <em>Ecl Long</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ecl Long</em>'.
	 * @see org.eclipse.rcptt.ecl.core.EclLong
	 * @generated
	 */
	EClass getEclLong();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.core.EclLong#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.rcptt.ecl.core.EclLong#getValue()
	 * @see #getEclLong()
	 * @generated
	 */
	EAttribute getEclLong_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.core.EclDouble <em>Ecl Double</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ecl Double</em>'.
	 * @see org.eclipse.rcptt.ecl.core.EclDouble
	 * @generated
	 */
	EClass getEclDouble();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.core.EclDouble#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.rcptt.ecl.core.EclDouble#getValue()
	 * @see #getEclDouble()
	 * @generated
	 */
	EAttribute getEclDouble_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.core.BoxedValue <em>Boxed Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boxed Value</em>'.
	 * @see org.eclipse.rcptt.ecl.core.BoxedValue
	 * @generated
	 */
	EClass getBoxedValue();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.core.EclByte <em>Ecl Byte</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ecl Byte</em>'.
	 * @see org.eclipse.rcptt.ecl.core.EclByte
	 * @generated
	 */
	EClass getEclByte();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.core.EclByte#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.rcptt.ecl.core.EclByte#getValue()
	 * @see #getEclByte()
	 * @generated
	 */
	EAttribute getEclByte_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.core.EclShort <em>Ecl Short</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ecl Short</em>'.
	 * @see org.eclipse.rcptt.ecl.core.EclShort
	 * @generated
	 */
	EClass getEclShort();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.core.EclShort#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.rcptt.ecl.core.EclShort#getValue()
	 * @see #getEclShort()
	 * @generated
	 */
	EAttribute getEclShort_Value();

	/**
	 * Returns the meta object for data type '{@link java.lang.Throwable <em>Throwable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Throwable</em>'.
	 * @see java.lang.Throwable
	 * @model instanceClass="java.lang.Throwable"
	 * @generated
	 */
	EDataType getThrowable();

	/**
	 * Returns the meta object for class '{@link org.eclipse.rcptt.ecl.core.Script <em>Script</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Script</em>'.
	 * @see org.eclipse.rcptt.ecl.core.Script
	 * @generated
	 */
	EClass getScript();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.rcptt.ecl.core.Script#getContent <em>Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Content</em>'.
	 * @see org.eclipse.rcptt.ecl.core.Script#getContent()
	 * @see #getScript()
	 * @generated
	 */
	EAttribute getScript_Content();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CoreFactory getCoreFactory();

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
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.core.impl.CommandImpl <em>Command</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.core.impl.CommandImpl
		 * @see org.eclipse.rcptt.ecl.core.impl.CorePackageImpl#getCommand()
		 * @generated
		 */
		EClass COMMAND = eINSTANCE.getCommand();

		/**
		 * The meta object literal for the '<em><b>Host</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMMAND__HOST = eINSTANCE.getCommand_Host();

		/**
		 * The meta object literal for the '<em><b>Bindings</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMMAND__BINDINGS = eINSTANCE.getCommand_Bindings();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.core.impl.BindingImpl <em>Binding</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.core.impl.BindingImpl
		 * @see org.eclipse.rcptt.ecl.core.impl.CorePackageImpl#getBinding()
		 * @generated
		 */
		EClass BINDING = eINSTANCE.getBinding();

		/**
		 * The meta object literal for the '<em><b>Feature</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BINDING__FEATURE = eINSTANCE.getBinding_Feature();

		/**
		 * The meta object literal for the '<em><b>Command</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BINDING__COMMAND = eINSTANCE.getBinding_Command();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.core.impl.BlockImpl <em>Block</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.core.impl.BlockImpl
		 * @see org.eclipse.rcptt.ecl.core.impl.CorePackageImpl#getBlock()
		 * @generated
		 */
		EClass BLOCK = eINSTANCE.getBlock();

		/**
		 * The meta object literal for the '<em><b>Commands</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BLOCK__COMMANDS = eINSTANCE.getBlock_Commands();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.core.impl.PipelineImpl <em>Pipeline</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.core.impl.PipelineImpl
		 * @see org.eclipse.rcptt.ecl.core.impl.CorePackageImpl#getPipeline()
		 * @generated
		 */
		EClass PIPELINE = eINSTANCE.getPipeline();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.core.impl.SequenceImpl <em>Sequence</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.core.impl.SequenceImpl
		 * @see org.eclipse.rcptt.ecl.core.impl.CorePackageImpl#getSequence()
		 * @generated
		 */
		EClass SEQUENCE = eINSTANCE.getSequence();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.core.impl.ParallelImpl <em>Parallel</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.core.impl.ParallelImpl
		 * @see org.eclipse.rcptt.ecl.core.impl.CorePackageImpl#getParallel()
		 * @generated
		 */
		EClass PARALLEL = eINSTANCE.getParallel();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.core.impl.WithImpl <em>With</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.core.impl.WithImpl
		 * @see org.eclipse.rcptt.ecl.core.impl.CorePackageImpl#getWith()
		 * @generated
		 */
		EClass WITH = eINSTANCE.getWith();

		/**
		 * The meta object literal for the '<em><b>Object</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WITH__OBJECT = eINSTANCE.getWith_Object();

		/**
		 * The meta object literal for the '<em><b>Do</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WITH__DO = eINSTANCE.getWith_Do();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.core.impl.ExecImpl <em>Exec</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.core.impl.ExecImpl
		 * @see org.eclipse.rcptt.ecl.core.impl.CorePackageImpl#getExec()
		 * @generated
		 */
		EClass EXEC = eINSTANCE.getExec();

		/**
		 * The meta object literal for the '<em><b>Namespace</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXEC__NAMESPACE = eINSTANCE.getExec_Namespace();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXEC__NAME = eINSTANCE.getExec_Name();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXEC__PARAMETERS = eINSTANCE.getExec_Parameters();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.core.impl.ParameterImpl <em>Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.core.impl.ParameterImpl
		 * @see org.eclipse.rcptt.ecl.core.impl.CorePackageImpl#getParameter()
		 * @generated
		 */
		EClass PARAMETER = eINSTANCE.getParameter();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER__NAME = eINSTANCE.getParameter_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.core.impl.ExecutableParameterImpl <em>Executable Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.core.impl.ExecutableParameterImpl
		 * @see org.eclipse.rcptt.ecl.core.impl.CorePackageImpl#getExecutableParameter()
		 * @generated
		 */
		EClass EXECUTABLE_PARAMETER = eINSTANCE.getExecutableParameter();

		/**
		 * The meta object literal for the '<em><b>Command</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXECUTABLE_PARAMETER__COMMAND = eINSTANCE.getExecutableParameter_Command();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.core.impl.LiteralParameterImpl <em>Literal Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.core.impl.LiteralParameterImpl
		 * @see org.eclipse.rcptt.ecl.core.impl.CorePackageImpl#getLiteralParameter()
		 * @generated
		 */
		EClass LITERAL_PARAMETER = eINSTANCE.getLiteralParameter();

		/**
		 * The meta object literal for the '<em><b>Literal</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LITERAL_PARAMETER__LITERAL = eINSTANCE.getLiteralParameter_Literal();

		/**
		 * The meta object literal for the '<em><b>Format</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LITERAL_PARAMETER__FORMAT = eINSTANCE.getLiteralParameter_Format();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.core.impl.ForeachImpl <em>Foreach</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.core.impl.ForeachImpl
		 * @see org.eclipse.rcptt.ecl.core.impl.CorePackageImpl#getForeach()
		 * @generated
		 */
		EClass FOREACH = eINSTANCE.getForeach();

		/**
		 * The meta object literal for the '<em><b>Item</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FOREACH__ITEM = eINSTANCE.getForeach_Item();

		/**
		 * The meta object literal for the '<em><b>Do</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FOREACH__DO = eINSTANCE.getForeach_Do();

		/**
		 * The meta object literal for the '<em><b>Input</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FOREACH__INPUT = eINSTANCE.getForeach_Input();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.core.impl.ProcessStatusImpl <em>Process Status</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.core.impl.ProcessStatusImpl
		 * @see org.eclipse.rcptt.ecl.core.impl.CorePackageImpl#getProcessStatus()
		 * @generated
		 */
		EClass PROCESS_STATUS = eINSTANCE.getProcessStatus();

		/**
		 * The meta object literal for the '<em><b>Plugin Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROCESS_STATUS__PLUGIN_ID = eINSTANCE.getProcessStatus_PluginId();

		/**
		 * The meta object literal for the '<em><b>Code</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROCESS_STATUS__CODE = eINSTANCE.getProcessStatus_Code();

		/**
		 * The meta object literal for the '<em><b>Message</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROCESS_STATUS__MESSAGE = eINSTANCE.getProcessStatus_Message();

		/**
		 * The meta object literal for the '<em><b>Severity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROCESS_STATUS__SEVERITY = eINSTANCE.getProcessStatus_Severity();

		/**
		 * The meta object literal for the '<em><b>Exception</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROCESS_STATUS__EXCEPTION = eINSTANCE.getProcessStatus_Exception();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.core.impl.ConvertedToEMFPipeImpl <em>Converted To EMF Pipe</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.core.impl.ConvertedToEMFPipeImpl
		 * @see org.eclipse.rcptt.ecl.core.impl.CorePackageImpl#getConvertedToEMFPipe()
		 * @generated
		 */
		EClass CONVERTED_TO_EMF_PIPE = eINSTANCE.getConvertedToEMFPipe();

		/**
		 * The meta object literal for the '<em><b>Object</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONVERTED_TO_EMF_PIPE__OBJECT = eINSTANCE.getConvertedToEMFPipe_Object();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.core.impl.SerializedImpl <em>Serialized</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.core.impl.SerializedImpl
		 * @see org.eclipse.rcptt.ecl.core.impl.CorePackageImpl#getSerialized()
		 * @generated
		 */
		EClass SERIALIZED = eINSTANCE.getSerialized();

		/**
		 * The meta object literal for the '<em><b>Bytes</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERIALIZED__BYTES = eINSTANCE.getSerialized_Bytes();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.core.impl.NullableImpl <em>Nullable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.core.impl.NullableImpl
		 * @see org.eclipse.rcptt.ecl.core.impl.CorePackageImpl#getNullable()
		 * @generated
		 */
		EClass NULLABLE = eINSTANCE.getNullable();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NULLABLE__VALUE = eINSTANCE.getNullable_Value();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NULLABLE__TYPE = eINSTANCE.getNullable_Type();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.core.impl.IfImpl <em>If</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.core.impl.IfImpl
		 * @see org.eclipse.rcptt.ecl.core.impl.CorePackageImpl#getIf()
		 * @generated
		 */
		EClass IF = eINSTANCE.getIf();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IF__CONDITION = eINSTANCE.getIf_Condition();

		/**
		 * The meta object literal for the '<em><b>Then</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IF__THEN = eINSTANCE.getIf_Then();

		/**
		 * The meta object literal for the '<em><b>Else</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IF__ELSE = eINSTANCE.getIf_Else();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.core.impl.EclStringImpl <em>Ecl String</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.core.impl.EclStringImpl
		 * @see org.eclipse.rcptt.ecl.core.impl.CorePackageImpl#getEclString()
		 * @generated
		 */
		EClass ECL_STRING = eINSTANCE.getEclString();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ECL_STRING__VALUE = eINSTANCE.getEclString_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.core.impl.EclExceptionImpl <em>Ecl Exception</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.core.impl.EclExceptionImpl
		 * @see org.eclipse.rcptt.ecl.core.impl.CorePackageImpl#getEclException()
		 * @generated
		 */
		EClass ECL_EXCEPTION = eINSTANCE.getEclException();

		/**
		 * The meta object literal for the '<em><b>Class Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ECL_EXCEPTION__CLASS_NAME = eINSTANCE.getEclException_ClassName();

		/**
		 * The meta object literal for the '<em><b>Message</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ECL_EXCEPTION__MESSAGE = eINSTANCE.getEclException_Message();

		/**
		 * The meta object literal for the '<em><b>Stack Trace</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ECL_EXCEPTION__STACK_TRACE = eINSTANCE.getEclException_StackTrace();

		/**
		 * The meta object literal for the '<em><b>Throwable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ECL_EXCEPTION__THROWABLE = eINSTANCE.getEclException_Throwable();

		/**
		 * The meta object literal for the '<em><b>Cause</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ECL_EXCEPTION__CAUSE = eINSTANCE.getEclException_Cause();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.core.impl.EclStackTraceEntryImpl <em>Ecl Stack Trace Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.core.impl.EclStackTraceEntryImpl
		 * @see org.eclipse.rcptt.ecl.core.impl.CorePackageImpl#getEclStackTraceEntry()
		 * @generated
		 */
		EClass ECL_STACK_TRACE_ENTRY = eINSTANCE.getEclStackTraceEntry();

		/**
		 * The meta object literal for the '<em><b>Index</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ECL_STACK_TRACE_ENTRY__INDEX = eINSTANCE.getEclStackTraceEntry_Index();

		/**
		 * The meta object literal for the '<em><b>Declaring Class</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ECL_STACK_TRACE_ENTRY__DECLARING_CLASS = eINSTANCE.getEclStackTraceEntry_DeclaringClass();

		/**
		 * The meta object literal for the '<em><b>Method Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ECL_STACK_TRACE_ENTRY__METHOD_NAME = eINSTANCE.getEclStackTraceEntry_MethodName();

		/**
		 * The meta object literal for the '<em><b>File Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ECL_STACK_TRACE_ENTRY__FILE_NAME = eINSTANCE.getEclStackTraceEntry_FileName();

		/**
		 * The meta object literal for the '<em><b>Line Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ECL_STACK_TRACE_ENTRY__LINE_NUMBER = eINSTANCE.getEclStackTraceEntry_LineNumber();

		/**
		 * The meta object literal for the '<em><b>Native Method</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ECL_STACK_TRACE_ENTRY__NATIVE_METHOD = eINSTANCE.getEclStackTraceEntry_NativeMethod();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.core.impl.ListenImpl <em>Listen</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.core.impl.ListenImpl
		 * @see org.eclipse.rcptt.ecl.core.impl.CorePackageImpl#getListen()
		 * @generated
		 */
		EClass LISTEN = eINSTANCE.getListen();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LISTEN__SOURCE = eINSTANCE.getListen_Source();

		/**
		 * The meta object literal for the '<em><b>While</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LISTEN__WHILE = eINSTANCE.getListen_While();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.core.impl.DeclarationImpl <em>Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.core.impl.DeclarationImpl
		 * @see org.eclipse.rcptt.ecl.core.impl.CorePackageImpl#getDeclaration()
		 * @generated
		 */
		EClass DECLARATION = eINSTANCE.getDeclaration();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.core.impl.ValImpl <em>Val</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.core.impl.ValImpl
		 * @see org.eclipse.rcptt.ecl.core.impl.CorePackageImpl#getVal()
		 * @generated
		 */
		EClass VAL = eINSTANCE.getVal();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VAL__NAME = eINSTANCE.getVal_Name();

		/**
		 * The meta object literal for the '<em><b>Input</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VAL__INPUT = eINSTANCE.getVal_Input();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VAL__VALUE = eINSTANCE.getVal_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.core.impl.GetValImpl <em>Get Val</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.core.impl.GetValImpl
		 * @see org.eclipse.rcptt.ecl.core.impl.CorePackageImpl#getGetVal()
		 * @generated
		 */
		EClass GET_VAL = eINSTANCE.getGetVal();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GET_VAL__NAME = eINSTANCE.getGetVal_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.core.impl.LetImpl <em>Let</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.core.impl.LetImpl
		 * @see org.eclipse.rcptt.ecl.core.impl.CorePackageImpl#getLet()
		 * @generated
		 */
		EClass LET = eINSTANCE.getLet();

		/**
		 * The meta object literal for the '<em><b>Vals</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LET__VALS = eINSTANCE.getLet_Vals();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LET__BODY = eINSTANCE.getLet_Body();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.core.impl.ProcImpl <em>Proc</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.core.impl.ProcImpl
		 * @see org.eclipse.rcptt.ecl.core.impl.CorePackageImpl#getProc()
		 * @generated
		 */
		EClass PROC = eINSTANCE.getProc();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROC__NAME = eINSTANCE.getProc_Name();

		/**
		 * The meta object literal for the '<em><b>Vals</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROC__VALS = eINSTANCE.getProc_Vals();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROC__BODY = eINSTANCE.getProc_Body();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.core.impl.ProcInstanceImpl <em>Proc Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.core.impl.ProcInstanceImpl
		 * @see org.eclipse.rcptt.ecl.core.impl.CorePackageImpl#getProcInstance()
		 * @generated
		 */
		EClass PROC_INSTANCE = eINSTANCE.getProcInstance();

		/**
		 * The meta object literal for the '<em><b>Definition</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROC_INSTANCE__DEFINITION = eINSTANCE.getProcInstance_Definition();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.core.impl.GlobalImpl <em>Global</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.core.impl.GlobalImpl
		 * @see org.eclipse.rcptt.ecl.core.impl.CorePackageImpl#getGlobal()
		 * @generated
		 */
		EClass GLOBAL = eINSTANCE.getGlobal();

		/**
		 * The meta object literal for the '<em><b>Vals</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GLOBAL__VALS = eINSTANCE.getGlobal_Vals();

		/**
		 * The meta object literal for the '<em><b>Override</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GLOBAL__OVERRIDE = eINSTANCE.getGlobal_Override();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.core.impl.SessionStateImpl <em>Session State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.core.impl.SessionStateImpl
		 * @see org.eclipse.rcptt.ecl.core.impl.CorePackageImpl#getSessionState()
		 * @generated
		 */
		EClass SESSION_STATE = eINSTANCE.getSessionState();

		/**
		 * The meta object literal for the '<em><b>Procs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SESSION_STATE__PROCS = eINSTANCE.getSessionState_Procs();

		/**
		 * The meta object literal for the '<em><b>Decls</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SESSION_STATE__DECLS = eINSTANCE.getSessionState_Decls();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.core.impl.SaveStateImpl <em>Save State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.core.impl.SaveStateImpl
		 * @see org.eclipse.rcptt.ecl.core.impl.CorePackageImpl#getSaveState()
		 * @generated
		 */
		EClass SAVE_STATE = eINSTANCE.getSaveState();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.core.impl.RestoreStateImpl <em>Restore State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.core.impl.RestoreStateImpl
		 * @see org.eclipse.rcptt.ecl.core.impl.CorePackageImpl#getRestoreState()
		 * @generated
		 */
		EClass RESTORE_STATE = eINSTANCE.getRestoreState();

		/**
		 * The meta object literal for the '<em><b>State</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESTORE_STATE__STATE = eINSTANCE.getRestoreState_State();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.core.impl.GetImpl <em>Get</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.core.impl.GetImpl
		 * @see org.eclipse.rcptt.ecl.core.impl.CorePackageImpl#getGet()
		 * @generated
		 */
		EClass GET = eINSTANCE.getGet();

		/**
		 * The meta object literal for the '<em><b>Input</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GET__INPUT = eINSTANCE.getGet_Input();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GET__KEY = eINSTANCE.getGet_Key();

		/**
		 * The meta object literal for the '<em><b>Default</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GET__DEFAULT = eINSTANCE.getGet_Default();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.core.impl.EclListImpl <em>Ecl List</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.core.impl.EclListImpl
		 * @see org.eclipse.rcptt.ecl.core.impl.CorePackageImpl#getEclList()
		 * @generated
		 */
		EClass ECL_LIST = eINSTANCE.getEclList();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ECL_LIST__ELEMENTS = eINSTANCE.getEclList_Elements();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.core.impl.EclMapImpl <em>Ecl Map</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.core.impl.EclMapImpl
		 * @see org.eclipse.rcptt.ecl.core.impl.CorePackageImpl#getEclMap()
		 * @generated
		 */
		EClass ECL_MAP = eINSTANCE.getEclMap();

		/**
		 * The meta object literal for the '<em><b>Entries</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ECL_MAP__ENTRIES = eINSTANCE.getEclMap_Entries();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.core.impl.EclMapEntryImpl <em>Ecl Map Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.core.impl.EclMapEntryImpl
		 * @see org.eclipse.rcptt.ecl.core.impl.CorePackageImpl#getEclMapEntry()
		 * @generated
		 */
		EClass ECL_MAP_ENTRY = eINSTANCE.getEclMapEntry();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ECL_MAP_ENTRY__KEY = eINSTANCE.getEclMapEntry_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ECL_MAP_ENTRY__VALUE = eINSTANCE.getEclMapEntry_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.core.impl.CaseImpl <em>Case</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.core.impl.CaseImpl
		 * @see org.eclipse.rcptt.ecl.core.impl.CorePackageImpl#getCase()
		 * @generated
		 */
		EClass CASE = eINSTANCE.getCase();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CASE__CONDITION = eINSTANCE.getCase_Condition();

		/**
		 * The meta object literal for the '<em><b>Then</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CASE__THEN = eINSTANCE.getCase_Then();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.core.impl.SwitchImpl <em>Switch</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.core.impl.SwitchImpl
		 * @see org.eclipse.rcptt.ecl.core.impl.CorePackageImpl#getSwitch()
		 * @generated
		 */
		EClass SWITCH = eINSTANCE.getSwitch();

		/**
		 * The meta object literal for the '<em><b>Items</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SWITCH__ITEMS = eINSTANCE.getSwitch_Items();

		/**
		 * The meta object literal for the '<em><b>Default</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SWITCH__DEFAULT = eINSTANCE.getSwitch_Default();

		/**
		 * The meta object literal for the '<em><b>Input</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SWITCH__INPUT = eINSTANCE.getSwitch_Input();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.core.impl.EclBooleanImpl <em>Ecl Boolean</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.core.impl.EclBooleanImpl
		 * @see org.eclipse.rcptt.ecl.core.impl.CorePackageImpl#getEclBoolean()
		 * @generated
		 */
		EClass ECL_BOOLEAN = eINSTANCE.getEclBoolean();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ECL_BOOLEAN__VALUE = eINSTANCE.getEclBoolean_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.core.impl.EclCharImpl <em>Ecl Char</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.core.impl.EclCharImpl
		 * @see org.eclipse.rcptt.ecl.core.impl.CorePackageImpl#getEclChar()
		 * @generated
		 */
		EClass ECL_CHAR = eINSTANCE.getEclChar();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ECL_CHAR__VALUE = eINSTANCE.getEclChar_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.core.impl.EclIntegerImpl <em>Ecl Integer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.core.impl.EclIntegerImpl
		 * @see org.eclipse.rcptt.ecl.core.impl.CorePackageImpl#getEclInteger()
		 * @generated
		 */
		EClass ECL_INTEGER = eINSTANCE.getEclInteger();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ECL_INTEGER__VALUE = eINSTANCE.getEclInteger_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.core.impl.EclFloatImpl <em>Ecl Float</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.core.impl.EclFloatImpl
		 * @see org.eclipse.rcptt.ecl.core.impl.CorePackageImpl#getEclFloat()
		 * @generated
		 */
		EClass ECL_FLOAT = eINSTANCE.getEclFloat();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ECL_FLOAT__VALUE = eINSTANCE.getEclFloat_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.core.impl.EclLongImpl <em>Ecl Long</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.core.impl.EclLongImpl
		 * @see org.eclipse.rcptt.ecl.core.impl.CorePackageImpl#getEclLong()
		 * @generated
		 */
		EClass ECL_LONG = eINSTANCE.getEclLong();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ECL_LONG__VALUE = eINSTANCE.getEclLong_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.core.impl.EclDoubleImpl <em>Ecl Double</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.core.impl.EclDoubleImpl
		 * @see org.eclipse.rcptt.ecl.core.impl.CorePackageImpl#getEclDouble()
		 * @generated
		 */
		EClass ECL_DOUBLE = eINSTANCE.getEclDouble();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ECL_DOUBLE__VALUE = eINSTANCE.getEclDouble_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.core.impl.BoxedValueImpl <em>Boxed Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.core.impl.BoxedValueImpl
		 * @see org.eclipse.rcptt.ecl.core.impl.CorePackageImpl#getBoxedValue()
		 * @generated
		 */
		EClass BOXED_VALUE = eINSTANCE.getBoxedValue();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.core.impl.EclByteImpl <em>Ecl Byte</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.core.impl.EclByteImpl
		 * @see org.eclipse.rcptt.ecl.core.impl.CorePackageImpl#getEclByte()
		 * @generated
		 */
		EClass ECL_BYTE = eINSTANCE.getEclByte();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ECL_BYTE__VALUE = eINSTANCE.getEclByte_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.core.impl.EclShortImpl <em>Ecl Short</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.core.impl.EclShortImpl
		 * @see org.eclipse.rcptt.ecl.core.impl.CorePackageImpl#getEclShort()
		 * @generated
		 */
		EClass ECL_SHORT = eINSTANCE.getEclShort();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ECL_SHORT__VALUE = eINSTANCE.getEclShort_Value();

		/**
		 * The meta object literal for the '<em>Throwable</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.Throwable
		 * @see org.eclipse.rcptt.ecl.core.impl.CorePackageImpl#getThrowable()
		 * @generated
		 */
		EDataType THROWABLE = eINSTANCE.getThrowable();

		/**
		 * The meta object literal for the '{@link org.eclipse.rcptt.ecl.core.impl.ScriptImpl <em>Script</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.rcptt.ecl.core.impl.ScriptImpl
		 * @see org.eclipse.rcptt.ecl.core.impl.CorePackageImpl#getScript()
		 * @generated
		 */
		EClass SCRIPT = eINSTANCE.getScript();

		/**
		 * The meta object literal for the '<em><b>Content</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCRIPT__CONTENT = eINSTANCE.getScript_Content();

	}

} //CorePackage

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
package org.eclipse.rcptt.core.internal.ecl.parser;

public enum EclPartition {
	script, sequence, expr, parallel, pipeline,
	// primary,
	command, commandNamespace, commandName,
	//
	param, paramName, paramValue, curly, subCommand, literal, number, string,
	//
	colon, and, or, lparen, rparen, lcurly, rcurly, lbrack, rbrack, spacing, ws, nl,
	//
	unknown
}

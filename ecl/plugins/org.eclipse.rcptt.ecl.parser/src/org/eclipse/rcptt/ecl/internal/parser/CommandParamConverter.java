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
package org.eclipse.rcptt.ecl.internal.parser;

import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.core.LiteralParameter;
import org.eclipse.rcptt.ecl.gen.ast.AstLiteral;
import org.eclipse.rcptt.ecl.parser.EclCoreParser;
import org.eclipse.rcptt.ecl.runtime.IParamConverter;

public class CommandParamConverter implements IParamConverter<Command> {

	public Command convert(LiteralParameter parameter, List<String> allowedTypes)
			throws CoreException {
		if (parameter instanceof AstLiteral) {
			AstLiteral astLiteral = (AstLiteral) parameter;
			return EclCoreParser.newCommand(parameter.getLiteral(), astLiteral.getResourceID(),
					astLiteral.getLine(), astLiteral.getColumn());
		} else
			return EclCoreParser.newCommand(parameter.getLiteral());
	}

	public Class<Command> forType() {
		return Command.class;
	}

	public String convertToCode(Object value) {
		throw new UnsupportedOperationException(
				"Command should be converted using other mechanism");
	}

}

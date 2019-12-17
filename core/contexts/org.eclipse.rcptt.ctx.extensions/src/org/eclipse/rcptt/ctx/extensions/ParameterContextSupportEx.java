/*******************************************************************************
 * Copyright (c) 2009, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.ctx.extensions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.rcptt.core.model.IContext;
import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.model.IQ7Project;
import org.eclipse.rcptt.core.model.ModelException;
import org.eclipse.rcptt.core.model.search.AllProjectScope;
import org.eclipse.rcptt.core.model.search.Q7SearchCore;
import org.eclipse.rcptt.internal.core.model.OneProjectScope;
import org.eclipse.rcptt.parameters.Parameter;
import org.eclipse.rcptt.parameters.ParametersContext;

public class ParameterContextSupportEx {
	public static Map<String, List<String>> getAllParametersNames(IQ7NamedElement excludedContext, IQ7Project project) {
		IContext[] contexts = Q7SearchCore.findAllContexts((project==null)?new AllProjectScope(): new OneProjectScope(project));
		Map<String, List<String>> mapIdToParameters = new HashMap<String, List<String>>();
		
		try {
			for (IContext context : contexts) {
				//skip current context				
				if((excludedContext != null) && (excludedContext instanceof IContext) && (context.equals(excludedContext)))
					continue;
				
				if (context.getNamedElement() instanceof ParametersContext) {
					ParametersContext pc = (ParametersContext) context.getNamedElement();
					List<Parameter> listOfParameters = pc.getParameters();
					List<String> listParametersName = new ArrayList<String>();
					for (Parameter param : listOfParameters) {
						listParametersName.add(param.getName());
					}
					mapIdToParameters.put(context.getID(), listParametersName);
				}
			}
		} catch (ModelException e) {			
		}
		
		return mapIdToParameters;
	}
}

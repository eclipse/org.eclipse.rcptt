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
package org.eclipse.rcptt.core.ecl.context.impl;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.rcptt.ecl.core.CoreFactory;
import org.eclipse.rcptt.ecl.core.Script;

import org.eclipse.rcptt.core.ContextType;
import org.eclipse.rcptt.core.DefaultContextMaker;
import org.eclipse.rcptt.core.scenario.Context;
import org.eclipse.rcptt.core.ecl.context.ContextFactory;
import org.eclipse.rcptt.core.ecl.context.EclContext;

public class EclContextMaker extends DefaultContextMaker {
	public Context create(Resource resource, ContextType type, String name) {
		EclContext eclContext = ContextFactory.eINSTANCE.createEclContext();
		eclContext.setName(name);
		Script script = CoreFactory.eINSTANCE.createScript();
		script.setContent("");
		eclContext.setScript(script);
		resource.getContents().add(eclContext);
		return eclContext;
	}
}

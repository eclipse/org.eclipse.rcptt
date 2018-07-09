/*******************************************************************************
 * Copyright (c) 2009, 2016 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.tesla.ecl.rap;

import org.eclipse.rcptt.ecl.core.util.ScriptletFactory;
import org.eclipse.rcptt.tesla.ecl.rap.model.ExecWithoutJs;
import org.eclipse.rcptt.tesla.ecl.rap.model.RapTeslaFactory;
import org.eclipse.rcptt.tesla.ecl.rap.model.RunJs;

/**
 *
 * @author Artem Kovalev
 *
 */
public class RapTeslaScriptletFactory extends ScriptletFactory {

	public static ExecWithoutJs createExecWithoutJs()
	{
		return RapTeslaFactory.eINSTANCE.createExecWithoutJs();
	}


	public static RunJs createRunJs(String jsCode)
	{
		final RunJs result = RapTeslaFactory.eINSTANCE.createRunJs();
		result.setJsCode(jsCode);
		return result;
	}

}

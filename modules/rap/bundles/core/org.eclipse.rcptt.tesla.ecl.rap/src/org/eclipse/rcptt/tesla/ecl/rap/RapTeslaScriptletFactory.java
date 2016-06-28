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
import org.eclipse.rcptt.tesla.ecl.rap.model.SetDownloadResultFile;
import org.eclipse.rcptt.tesla.ecl.rap.model.VerifyDownloadFile;

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

	public static SetDownloadResultFile createSetDownloadResultFile(String base64FileContent)
	{
		final SetDownloadResultFile result = RapTeslaFactory.eINSTANCE.createSetDownloadResultFile();
		result.setFile(base64FileContent);
		return result;
	}

	public static RunJs createRunJs(String jsCode)
	{
		final RunJs result = RapTeslaFactory.eINSTANCE.createRunJs();
		result.setJsCode(jsCode);
		return result;
	}

	public static VerifyDownloadFile createVerifyDownloadFile(String url)
	{
		final VerifyDownloadFile verify = RapTeslaFactory.eINSTANCE.createVerifyDownloadFile();
		verify.setUrl(url);
		return verify;
	}
}

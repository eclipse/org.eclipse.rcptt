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
package org.eclipse.rcptt.ecl.data.tests;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.rcptt.ecl.data.commands.CommandsFactory;
import org.eclipse.rcptt.ecl.data.commands.ReadCsvFile;
import org.eclipse.rcptt.ecl.data.internal.commands.ReadCsvFileService;
import org.junit.Test;

public class ReadCsvFileTests {
	@Test
	public void testSimple() throws InterruptedException, CoreException {
		ReadCsvFile cmd = CommandsFactory.eINSTANCE.createReadCsvFile();
		cmd.setUri("workspace:foo/bar");
		ReadCsvFileService service = new ReadCsvFileService();
		service.service(cmd, null);
	}
}

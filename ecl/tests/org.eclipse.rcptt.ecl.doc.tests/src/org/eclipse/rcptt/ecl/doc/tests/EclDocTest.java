/*******************************************************************************
 * Copyright (c) 2009, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.ecl.doc.tests;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

import org.eclipse.rcptt.ecl.doc.EclDocAllCommandsWriter;
import org.eclipse.rcptt.ecl.doc.EclDocWriter;

import junit.framework.TestCase;

public class EclDocTest extends TestCase {

	public void test01() throws Exception {
		EclDocWriter w = new EclDocWriter(getOutput());
		new EclDocAllCommandsWriter().write(w);
		w.finish();
	}

	private Writer getOutput() throws IOException {
		final ByteArrayOutputStream byteArrayOutput = new ByteArrayOutputStream();
		return new OutputStreamWriter(byteArrayOutput);
	}
}

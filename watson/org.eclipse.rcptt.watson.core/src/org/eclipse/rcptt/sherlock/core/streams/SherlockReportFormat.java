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
package org.eclipse.rcptt.sherlock.core.streams;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Report;

/**
 * Use this class to load and store Q7 execution reports.
 */
public class SherlockReportFormat {
	/**
	 * Store Q7 execution report into output stream.
	 * 
	 * @param report
	 *            - report object to store.
	 * @param stream
	 *            - output stream.
	 * @param close
	 *            - if true, will close output stream.
	 * @throws IOException
	 *             - throws exception if something going wrong.
	 */
	public static void storeReport(Report report, OutputStream stream,
			boolean close) throws IOException {
		SherlockBinaryResourceImpl res = new SherlockBinaryResourceImpl();
		res.getContents().add(EcoreUtil.copy(report));
		Map<String, Object> opts = new HashMap<String, Object>();
		opts.put(Resource.OPTION_ZIP, Boolean.TRUE);
		res.save(stream, opts);
		if (close) {
			stream.close();
		}
	}

	/**
	 * Load Q7 execution report from InputStream.
	 * 
	 * @param stream
	 *            - input stream.
	 * @param close
	 *            - auto close input stream afrer loading.
	 * @return Report file if it is loaded correctly.
	 * @throws IOException
	 *             - throws exception if something going wrong.
	 */
	public static Report loadReport(InputStream stream, boolean close, boolean compressed)
			throws IOException {
		SherlockBinaryResourceImpl res = new SherlockBinaryResourceImpl();
		Map<String, Object> opts = new HashMap<String, Object>();
		if( compressed) {
			opts.put(Resource.OPTION_ZIP, Boolean.TRUE);
		}
		res.load(stream, opts);
		if (close) {
			stream.close();
		}
		if (res.getContents().size() == 1) {
			EObject eObject = res.getContents().get(0);
			if (eObject instanceof Report) {
				return (Report) eObject;
			}
		}
		return null;
	}
}

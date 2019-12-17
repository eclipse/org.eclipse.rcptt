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
package org.eclipse.rcptt.ctx.script;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.rcptt.ecl.core.CoreFactory;
import org.eclipse.rcptt.ecl.core.Script;

import org.eclipse.rcptt.core.persistence.plain.IPlainConstants;
import org.eclipse.rcptt.core.persistence.plain.IPlainTextPersistenceExtension;
import org.eclipse.rcptt.core.persistence.plain.PlainTextPersistenceModel;
import org.eclipse.rcptt.core.ecl.context.EclContext;
import org.eclipse.rcptt.internal.core.RcpttPlugin;
import org.eclipse.rcptt.util.FileUtil;

public class EclContextPlainExtension implements IPlainTextPersistenceExtension {

	private static final String ECL_CONTEXT = ".ecl.context";

	public EclContextPlainExtension() {
	}

	public boolean isContentEntryOptional(EList<EObject> contents) {
		if (contents.get(0) instanceof EclContext) {
			return true;
		}
		return false;
	}

	public void updateAttributes(
			PlainTextPersistenceModel plainTextPersistenceModel,
			Map<String, String> masterAttributes, EObject eObject) {
		if (eObject instanceof EclContext) {
			EclContext ctx = (EclContext) eObject;
			Script script = ctx.getScript();
			if (script != null) {
				String content = script.getContent();
				OutputStream store = plainTextPersistenceModel
						.store(ECL_CONTEXT);
				try {
					store.write(content.getBytes(IPlainConstants.ENCODING));
				} catch (IOException e) {
					RcpttPlugin.log(e);
				} finally {
					FileUtil.safeClose(store);
				}
			}
		}
	}

	public void updateMetadata(
			PlainTextPersistenceModel plainTextPersistenceModel,
			Map<String, String> header, EObject eObject) {
		if (eObject instanceof EclContext) {
			InputStream stream = plainTextPersistenceModel.read(ECL_CONTEXT);
			if (stream != null) {
				try {
					byte[] content = FileUtil.getStreamContent(stream);
					Script sc = CoreFactory.eINSTANCE.createScript();
					sc.setContent(new String(content, IPlainConstants.ENCODING));
					((EclContext) eObject).setScript(sc);
				} catch (IOException e) {
					RcpttPlugin.log(e);
				} finally {
					FileUtil.safeClose(stream);
				}
			}
		}
	}

	public void performObjectPreSaveUpdate(EObject eObject) {
		if (eObject instanceof EclContext) {
			((EclContext) eObject).setScript(null);
		}
	}

	public String getTextContentType(String fName) {
		if (ECL_CONTEXT.equals(fName)) {
			return "text/ecl";
		}
		return null;
	}
}

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
package org.eclipse.rcptt.ctx.parameters;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.rcptt.core.persistence.plain.IPlainTextPersistenceExtension;
import org.eclipse.rcptt.core.persistence.plain.PlainTextPersistenceModel;
import org.eclipse.rcptt.internal.core.RcpttPlugin;
import org.eclipse.rcptt.parameters.Parameter;
import org.eclipse.rcptt.parameters.ParametersContext;
import org.eclipse.rcptt.parameters.ParametersFactory;
import org.eclipse.rcptt.util.FileUtil;

public class ParametersContextPlainExtension implements
		IPlainTextPersistenceExtension {

	private static final String PARAMETERS_CONTEXT = ".parameters.context";
	
	public ParametersContextPlainExtension() {
	}

	public boolean isContentEntryOptional(EList<EObject> contents) {
		if (contents.get(0) instanceof ParametersContext) {
			return true;
		}
		return false;
	}

	public void updateAttributes(
			PlainTextPersistenceModel plainTextPersistenceModel,
			Map<String, String> masterAttributes, EObject eObject) {
		
		if (eObject instanceof ParametersContext) {
			ParametersContext ctx = (ParametersContext) eObject;
			
			Properties props = convertToProperties(ctx);
			
			OutputStream stream = plainTextPersistenceModel.store(PARAMETERS_CONTEXT);
			try {
				props.store(stream, null);
			} catch (IOException e) {
				RcpttPlugin.log(e);
			} finally {
				FileUtil.safeClose(stream);
			}
		}
	}

	public static Properties convertToProperties(ParametersContext ctx) {
		Properties props = new Properties();
		for (Parameter param : ctx.getParameters()) {
			props.put(param.getName(), param.getValue());
		}
		return props;
	}

	public void updateMetadata(
			PlainTextPersistenceModel plainTextPersistenceModel,
			Map<String, String> header, EObject eObject) {
		
		if (eObject instanceof ParametersContext) {
			InputStream stream = plainTextPersistenceModel.read(PARAMETERS_CONTEXT);
			if (stream != null) {
				try {
					Properties props = new Properties();
					props.load(stream);
					
					EList<Parameter> params = ((ParametersContext) eObject).getParameters();
					params.clear();
					for (Entry<Object, Object> prop : props.entrySet()) {
						Parameter param = ParametersFactory.eINSTANCE.createParameter();
						param.setName((String) prop.getKey());
						param.setValue((String) prop.getValue());
						params.add(param);
					}
					
				} catch (IOException e) {
					RcpttPlugin.log(e);
				} finally {
					FileUtil.safeClose(stream);
				}
			}
		}
	}

	public void performObjectPreSaveUpdate(EObject eObject) {
		if (eObject instanceof ParametersContext) {
			((ParametersContext) eObject).getParameters().clear();
		}
	}

	public String getTextContentType(String fName) {
		if (PARAMETERS_CONTEXT.equals(fName)) {
			return "text/properties";
		}
		return null;
	}

}

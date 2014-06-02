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
package org.eclipse.rcptt.core;

import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.rcptt.core.model.IContext;
import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.model.ModelException;
import org.eclipse.rcptt.core.scenario.Context;
import org.eclipse.rcptt.core.scenario.ScenarioPackage;

public class DefaultContextMaker implements IContextMaker {

	public Context create(Resource resource, ContextType type, String name) {
		EClass eClass = type.getEClass();
		Context context = (Context) eClass.getEPackage().getEFactoryInstance()
				.create(eClass);
		context.setName(name);
		resource.getContents().add(context);
		return context;
	}

	public IStatus validate(Context context) {
		return Status.OK_STATUS;
	}
	
	public boolean canMake() {
		return true;
	}

	public void makeExecutable(Context context, IQ7NamedElement source)
			throws ModelException {
	}

	public void captureContents(IContext context, Context data,
			IProgressMonitor monitor) throws CoreException {
		Context thisData = (Context) context.getNamedElement();
		for (final EStructuralFeature feature : data.eClass()
				.getEAllStructuralFeatures()) {
			if (feature.getEContainingClass() != ScenarioPackage.eINSTANCE
					.getNamedElement()) {
				if (feature instanceof EAttribute) {
					thisData.eSet(feature, data.eGet(feature));
				} else {
					if (feature.isMany()) {
						final List<?> list = (List<?>) data.eGet(feature);
						@SuppressWarnings("unchecked")
						final List<Object> newList = (List<Object>) thisData
								.eGet(feature);
						newList.clear();
						for (final Object object : list) {
							final EObject eObject = (EObject) object;
							newList.add(EcoreUtil.copy(eObject));
						}
					} else {
						final EObject eObject = (EObject) data.eGet(feature);
						thisData.eSet(feature, EcoreUtil.copy(eObject));
					}
				}
			}
		}
	}

}

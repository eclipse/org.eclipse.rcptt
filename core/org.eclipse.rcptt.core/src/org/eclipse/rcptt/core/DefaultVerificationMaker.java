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
package org.eclipse.rcptt.core;

import java.util.ArrayList;
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

import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.model.IVerification;
import org.eclipse.rcptt.core.model.ModelException;
import org.eclipse.rcptt.core.scenario.ScenarioPackage;
import org.eclipse.rcptt.core.scenario.Verification;

public class DefaultVerificationMaker implements IVerificationMaker {

	public Verification create(Resource resource, VerificationType type, String name) {
		EClass eClass = type.getEClass();
		Verification verification = (Verification) eClass.getEPackage()
				.getEFactoryInstance().create(eClass);
		verification.setName(name);
		resource.getContents().add(verification);
		return verification;
	}

	public IStatus validate(Verification verification) {
		return Status.OK_STATUS;
	}

	public boolean canMake() {
		return true;
	}

	public void makeExecutable(Verification verification, IQ7NamedElement source)
			throws ModelException {
	}

	public void captureContents(IVerification verification, Verification data,
			IProgressMonitor monitor) throws CoreException {
		Verification thisData = (Verification) verification.getNamedElement();

		for (final EStructuralFeature feature : data.eClass().getEAllStructuralFeatures()) {
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
						// tempList is used to force sending of single
						// change notification
						List<EObject> tempList = new ArrayList<EObject>();
						for (final Object object : list) {
							final EObject eObject = (EObject) object;
							tempList.add(EcoreUtil.copy(eObject));
						}
						if (tempList.size() > 0)
							thisData.eSetDeliver(false);
						newList.clear();
						if (tempList.size() > 0)
							thisData.eSetDeliver(true);
						newList.addAll(tempList);
					} else {
						final EObject eObject = (EObject) data.eGet(feature);
						thisData.eSet(feature, EcoreUtil.copy(eObject));
					}
				}
			}
		}
	}

}

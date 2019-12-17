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
package org.eclipse.rcptt.ecl.internal.core;

import static org.eclipse.rcptt.ecl.core.util.EclCommandNameConvention.toScriptletName;
import static org.eclipse.rcptt.ecl.internal.core.CorePlugin.err;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.rcptt.ecl.core.CorePackage;
import org.eclipse.rcptt.ecl.core.Declaration;
import org.eclipse.rcptt.ecl.core.Proc;
import org.eclipse.rcptt.ecl.core.ProcInstance;
import org.eclipse.rcptt.ecl.core.Val;
import org.eclipse.rcptt.ecl.runtime.CoreUtils;

public class LocalProcManager {
	private EPackage epackage;
	private Map<String, Proc> declarations = new LinkedHashMap<String, Proc>();

	protected EPackage getPackage() {
		if (epackage == null) {
			epackage = EcoreFactory.eINSTANCE.createEPackage();
			String randomName = UUID.randomUUID().toString();
			epackage.setName(randomName);
			epackage.setNsPrefix(randomName);
			epackage.setNsURI(randomName);
		}
		return epackage;
	}

	public synchronized Iterable<Proc> declarations() {
		return declarations.values();
	}

	public synchronized void declare(Proc proc) throws CoreException {
		verifyInputParamsCount(proc);

		EPackage pkg = getPackage();
		verifyNoSuchProc(proc, pkg);

		EClass eclass = EcoreFactory.eINSTANCE.createEClass();
		eclass.getESuperTypes().add(CorePackage.Literals.PROC_INSTANCE);
		String scriptletName = toScriptletName(proc.getName());
		eclass.setName(scriptletName);

		for (Declaration decl : proc.getVals()) {
			if (!(decl instanceof Val)) {
				continue; // TODO: pipe support
			}

			Val val = (Val) decl;
			EReference reference = EcoreFactory.eINSTANCE.createEReference();
			reference.setName(val.getName());
			reference.setEType(EcorePackage.Literals.EOBJECT);
			reference.setContainment(true);
			if (val.isInput()) {
				EAnnotation inputAnn = EcoreFactory.eINSTANCE
						.createEAnnotation();
				inputAnn.setSource(CoreUtils.INPUT_ANN);
				reference.getEAnnotations().add(inputAnn);
			}

			eclass.getEStructuralFeatures().add(reference);
		}

		pkg.getEClassifiers().add(eclass);

		declarations.put(scriptletName, proc);
	}

	public ProcInstance createCommand(String className) {
		Proc proc = declarations.get(className);
		if (proc == null) {
			return null;
		}

		EPackage pkg = getPackage();
		EClass commandClass = (EClass) pkg.getEClassifier(className);
		ProcInstance command = (ProcInstance) pkg.getEFactoryInstance().create(
				commandClass);

		command.eSet(CorePackage.Literals.PROC_INSTANCE__DEFINITION, proc);

		for (Declaration decl : proc.getVals()) {
			if (!(decl instanceof Val)) {
				continue; // TODO: pipe support
			}

			Val val = (Val) decl;
			if (val.getValue() != null) {
				command.eSet(commandClass.getEStructuralFeature(val.getName()),
						EcoreUtil.copy(val.getValue()));
			}
		}

		return command;
	}

	private static void verifyNoSuchProc(Proc proc, EPackage pkg)
			throws CoreException {
		if (pkg.getEClassifier(toScriptletName(proc.getName())) != null) {
			throw new CoreException(err(String.format(
					"proc '%s' already declared", proc.getName())));
		}
	}

	private static void verifyInputParamsCount(Proc proc) throws CoreException {
		int inputValCount = 0;
		for (Declaration declaration : proc.getVals()) {
			if (declaration instanceof Val && ((Val) declaration).isInput()) {
				inputValCount++;
			}
		}
		if (inputValCount > 1) {
			throw new CoreException(
					err("Only one parameter can be initialized from input"));
		}
	}

}

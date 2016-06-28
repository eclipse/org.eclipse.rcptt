/*******************************************************************************
 * Copyright (c) 2009, 2015 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.rcptt.core.scenario.Verification;

class ResolvedVerificationType implements VerificationType {

	private static final String ATTR_ID = "id";
	private static final String ATTR_NAME = "name";
	private static final String ATTR_DESCRIPTION = "description";
	private static final String ATTR_ECLASS = "eclass";
	private static final String ATTR_PACKAGE = "epackage-uri";
	private static final String ATTR_CAN_CREATE = "canCreate";
	private static final String ATTR_PRIORITY = "priority";
	private static final String ATTR_PHASES = "phases";
	private static final String ATTR_WIDGET = "widget";
	private static final String ATTR_CLASS = "class";
	private static final String ATTR_PROMPT = "prompt";

	private final String id;
	private final String name;
	private final String description;
	private final EClass eClass;
	private final String contributorId;
	private boolean canCreate;
	private final int priority;
	private final String[] phases;
	private final String[] widgets;
	private final String prompt;

	public ResolvedVerificationType(IConfigurationElement element) throws CoreException {
		id = getVal(element, ATTR_ID);
		name = getVal(element, ATTR_NAME);
		description = getVal(element, ATTR_DESCRIPTION);
		contributorId = element.getContributor().getName();
		canCreate = Boolean.TRUE.toString().equals(getVal(element, ATTR_CAN_CREATE));
		phases = parsePhases(getVal(element, ATTR_PHASES));
		widgets = readWidgets(element);
		prompt = getVal(element, ATTR_PROMPT, null);

		int parsed;
		try {
			parsed = Integer.parseInt(getVal(element, ATTR_PRIORITY));
		} catch (NumberFormatException e) {
			parsed = 10;
		}
		priority = parsed;
		String packageUri = getVal(element, ATTR_PACKAGE);
		EPackage ePackage = EPackage.Registry.INSTANCE.getEPackage(packageUri);
		if (ePackage == null)
			throw new IllegalArgumentException("Invalid package uri for '" + id
					+ "' verification type: " + packageUri);
		String className = getVal(element, ATTR_ECLASS);
		EClassifier classifier = ePackage.getEClassifier(className);
		if (classifier instanceof EClass) {
			eClass = (EClass) classifier;
		} else {
			throw new IllegalArgumentException("Invalid class name for '" + id
					+ "' verification type: " + className);
		}
	}

	private String[] readWidgets(IConfigurationElement element) {
		List<String> result = new ArrayList<String>();

		for (IConfigurationElement w : element.getChildren(ATTR_WIDGET))
			result.add(getVal(w, ATTR_CLASS));

		return result.toArray(new String[result.size()]);
	}

	private static String[] parsePhases(String text) {
		String[] result = text.split("[\\s,]");
		Set<String> members = new HashSet<String>();

		if (result.length == 0)
			throw new IllegalArgumentException("No phases specified for verification.");

		for (String p : result) {
			if (!p.equals(PHASE_START) &&
					!p.equals(PHASE_RUN) &&
					!p.equals(PHASE_FINISH))
				throw new IllegalArgumentException("Invalid phase name '" + p
						+ "'.");

			if (members.contains(p))
				throw new IllegalArgumentException("Duplicate phase detected '" + p
						+ "'.");

			members.add(p);
		}

		return result;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.rcptt.core.IVerificationType#getPhases()
	 */
	@Override
	public String[] getPhases() {
		return phases;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.rcptt.core.IVerificationType#supportsPhase(java.lang.String)
	 */
	@Override
	public boolean supportsPhase(String name) {
		return Arrays.asList(phases).contains(name);
	}

	public String getContributorId() {
		return contributorId;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.rcptt.core.IVerificationType#getId()
	 */
	@Override
	public String getId() {
		return id;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.rcptt.core.IVerificationType#getName()
	 */
	@Override
	public String getName() {
		return name;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.rcptt.core.IVerificationType#getDescription()
	 */
	@Override
	public String getDescription() {
		return description;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.rcptt.core.IVerificationType#getEClass()
	 */
	@Override
	public EClass getEClass() {
		return eClass;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.rcptt.core.IVerificationType#canCreate()
	 */
	@Override
	public boolean canCreate() {
		return canCreate;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.rcptt.core.IVerificationType#getPriority()
	 */
	@Override
	public int getPriority() {
		return priority;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.rcptt.core.IVerificationType#getWidgets()
	 */
	@Override
	public String[] getWidgets() {
		return widgets;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.rcptt.core.IVerificationType#getPrompt()
	 */
	@Override
	public String getPrompt() {
		return prompt;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.rcptt.core.IVerificationType#supportsWidget(java.lang.String)
	 */
	@Override
	public boolean supportsWidget(String class_) {
		return Arrays.asList(getWidgets()).contains(class_);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.rcptt.core.IVerificationType#create(org.eclipse.emf.ecore.resource.Resource, java.lang.String)
	 */
	@Override
	public Verification create(Resource resource, String name) {
		return getMaker().create(resource, this, name);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.rcptt.core.IVerificationType#validate(org.eclipse.rcptt.core.scenario.Verification)
	 */
	@Override
	public IStatus validate(Verification verification) {
		return getMaker().validate(verification);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.rcptt.core.IVerificationType#getMaker()
	 */
	@Override
	public IVerificationMaker getMaker() {
		return VerificationTypeManager.getInstance().getMaker(getId());
	}

	private String getVal(IConfigurationElement element, String attr) {
		String val = element.getAttribute(attr);
		if (val == null || val.length() == 0)
			throw new IllegalArgumentException("Verification attribute '" + attr
					+ "' can't be empty");

		return val;
	}

	private String getVal(IConfigurationElement element, String attr, String defaultValue) {
		String val = element.getAttribute(attr);
		if (val == null || val.length() == 0)
			val = defaultValue;
		return val;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.rcptt.core.IVerificationType#canMake()
	 */
	@Override
	public boolean canMake() {
		return getMaker().canMake();
	}

}

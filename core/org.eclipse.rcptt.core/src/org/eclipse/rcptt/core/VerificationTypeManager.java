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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.rcptt.core.scenario.UnresolvedVerification;
import org.eclipse.rcptt.core.scenario.Verification;
import org.eclipse.rcptt.internal.core.RcpttPlugin;

public class VerificationTypeManager {

	private static VerificationTypeManager instance;

	public static VerificationTypeManager getInstance() {
		if (instance == null) {
			instance = new VerificationTypeManager();
		}
		return instance;
	}

	private static final String EXPT_ID = RcpttPlugin.PLUGIN_ID + ".verificationTypes";

	private static final String PROCESSOR_EXPT_ID = RcpttPlugin.PLUGIN_ID
			+ ".verificationProcessors";

	private static final String MAKER_EXPT_ID = RcpttPlugin.PLUGIN_ID + ".verificationMaker";

	private static final String ATTR_TYPE = "type";
	private static final String ATTR_CLASS = "class";

	public VerificationType getTypeByVerification(Verification verification) {
		init();
		if (verification instanceof UnresolvedVerification) {
			return UnresolvedType.INSTANCE;
		}
		VerificationType rv = classToType.get(verification.eClass());
		if (rv == null)
			throw new IllegalArgumentException("Unknown verification type " + verification.eClass().getName());
		return rv;
	}

	private static Map<String, String> legacyTypes = new HashMap<String, String>();
	static {
		legacyTypes.put("com.xored.q7.log.verification", "org.eclipse.rcptt.verifications.log");
		legacyTypes.put("com.xored.q7.text.verification", "org.eclipse.rcptt.verifications.text");
		legacyTypes.put("com.xored.q7.time.verification", "org.eclipse.rcptt.verifications.time");
		legacyTypes.put("com.xored.q7.tree.verification", "org.eclipse.rcptt.verifications.tree");
	}
	public VerificationType getTypeById(String id) {
		init();
		if (legacyTypes.containsKey(id)) {
			id = legacyTypes.get(id);
		}
		return idToType.get(id);
	}

	public VerificationType[] getTypes() {
		init();
		return types;
	}

	public synchronized IVerificationMaker getMaker(String verificationTypeId) {
		if (idToMaker == null) {
			idToMaker = new HashMap<String, IVerificationMaker>();
			IConfigurationElement[] elements = Platform.getExtensionRegistry()
					.getConfigurationElementsFor(MAKER_EXPT_ID);
			for (IConfigurationElement element : elements) {
				try {
					String id = element.getAttribute(ATTR_TYPE);
					IVerificationMaker processor = (IVerificationMaker) element
							.createExecutableExtension(ATTR_CLASS);
					idToMaker.put(id, processor);
				} catch (CoreException e) {
					RcpttPlugin.log(e);
				}
			}
		}
		IVerificationMaker maker = idToMaker.get(verificationTypeId);
		if (maker == null)
			return new DefaultVerificationMaker();

		return maker;
	}

	public synchronized IVerificationProcessor getProcessor(String verificationTypeId) {
		if (idToProcessor == null) {
			idToProcessor = new HashMap<String, IVerificationProcessor>();
			IConfigurationElement[] elements = Platform.getExtensionRegistry()
					.getConfigurationElementsFor(PROCESSOR_EXPT_ID);
			for (IConfigurationElement element : elements) {
				try {
					String id = element.getAttribute(ATTR_TYPE);
					IVerificationProcessor processor = (IVerificationProcessor) element
							.createExecutableExtension(ATTR_CLASS);
					idToProcessor.put(id, processor);
				} catch (CoreException e) {
					RcpttPlugin.log(e);
				}
			}
		}
		return idToProcessor.get(verificationTypeId);
	}

	private synchronized void init() {
		if (classToType != null) {
			return;
		}
		List<VerificationType> list = new ArrayList<VerificationType>();
		classToType = new HashMap<EClass, VerificationType>();
		idToType = new HashMap<String, VerificationType>();

		IConfigurationElement[] elements = Platform.getExtensionRegistry()
				.getConfigurationElementsFor(EXPT_ID);
		for (IConfigurationElement element : elements) {
			try {
				VerificationType type = new ResolvedVerificationType(element);
				list.add(type);
				classToType.put(type.getEClass(), type);
				idToType.put(type.getId(), type);
			} catch (CoreException e) {
				RcpttPlugin.log(e);
			}
		}
		types = list.toArray(new VerificationType[list.size()]);
		Arrays.sort(types, new Comparator<VerificationType>() {
			public int compare(VerificationType t1, VerificationType t2) {
				return -((Integer) t1.getPriority()).compareTo(t2.getPriority());
			}
		});
	}

	public Set<VerificationType> getTypesForWidgetClass(String class_) {
		Set<VerificationType> result = new HashSet<VerificationType>();
		for (VerificationType t : getTypes())
			if (t.supportsWidget(class_))
				result.add(t);
		return result;
	}

	private VerificationType[] types;
	private Map<EClass, VerificationType> classToType;
	private Map<String, VerificationType> idToType;
	private Map<String, IVerificationProcessor> idToProcessor;
	private Map<String, IVerificationMaker> idToMaker;
}

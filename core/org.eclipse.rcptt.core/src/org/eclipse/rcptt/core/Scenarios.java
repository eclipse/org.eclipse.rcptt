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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.rcptt.ecl.core.CoreFactory;
import org.eclipse.rcptt.ecl.core.Script;

import org.eclipse.rcptt.core.model.ITestCase;
import org.eclipse.rcptt.core.model.ModelException;
import org.eclipse.rcptt.core.model.search.Q7SearchCore;
import org.eclipse.rcptt.core.scenario.Scenario;
import org.eclipse.rcptt.core.scenario.ScenarioPackage;
import org.eclipse.rcptt.tesla.core.protocol.raw.TeslaScenario;
import org.eclipse.rcptt.tesla.recording.core.ecl.EclRecorder;

public class Scenarios {

	public static final String ECL_SCENARIO_TYPE = "ecl";

	public static final String TESLA_SCENARIO_TYPE = "tesla";

	public static class ScenarioTypeWatcher extends EContentAdapter {
		static final ScenarioTypeWatcher INSTANCE = new ScenarioTypeWatcher();
		private static final EAttribute feature = ScenarioPackage.eINSTANCE.getScenario_Type();

		private ScenarioTypeWatcher() {
		}

		@Override
		public void notifyChanged(Notification notification) {
			super.notifyChanged(notification);
			if (notification.getEventType() == Notification.REMOVING_ADAPTER)
				return;
			if (feature.equals(notification.getFeature())) {
				Scenario scenario = (Scenario) notification.getNotifier();
				String value = notification.getNewStringValue();
				if (ECL_SCENARIO_TYPE.equals(value))
					setTypeToEcl(scenario);
				else if (TESLA_SCENARIO_TYPE.equals(value))
					setTypeToEcl(scenario);
			}
		}
	}

	public static boolean isEclMode(Scenario scenario) {
		return ECL_SCENARIO_TYPE.equals(getScenarioType(scenario, ECL_SCENARIO_TYPE));
	}

	public static boolean isTeslaMode(Scenario scenario) {
		return TESLA_SCENARIO_TYPE.equals(getScenarioType(scenario, ECL_SCENARIO_TYPE));
	}

	public static String getScenarioType(Scenario scenario, String def) {
		String type = scenario.getType();
		if (type != null)
			return type;
		EObject content = scenario.getContent();
		if (content != null) {
			return content instanceof Script ? ECL_SCENARIO_TYPE : TESLA_SCENARIO_TYPE;
		}
		return def;
	}

	public static class ObsoleteEclFormatException extends RuntimeException {
		private static final long serialVersionUID = 6956202972837349383L;
	}

	public static class UserModificationException extends RuntimeException {
		private static final long serialVersionUID = 825351484816358064L;
	}

	/**
	 * Set scenario type to ECL. Returns true if scenario was changed during
	 * this operation and false otherwise. Scenario won't be changed if it
	 * already has ECL type.
	 * 
	 * @param scenario
	 * @return true if scenario was changed and false otherwise.
	 */
	public static boolean setTypeToEcl(Scenario scenario) {
		switch (getScenarioMode(scenario)) {
		case strictTesla:
			scenario.setTeslaContent(scenario.getContent());
		case tesla:
			scenario.setType(ECL_SCENARIO_TYPE);
			scenario.setContent(null);
			return true;
		}
		return false;
	}

	/**
	 * Set scenario type to Tesla. Returns true if scenario was changed during
	 * this operation and false otherwise. Scenario won't be changed if it
	 * already has Tesla type or if it has ECL type but wasn't edited by user
	 * yet.
	 * 
	 * @param scenario
	 * @param discardUserChanges
	 * @return true if scenario was changed and false otherwise.
	 * @throws ObsoleteEclFormatException
	 *             if scenario format is not support such conversion.
	 * @throws UserModificationException
	 *             discardUserChanges is false and user changes cannot be saved.
	 */
	public static boolean setTypeToTesla(Scenario scenario, boolean discardUserChanges) {
		ScenarioMode mode = getScenarioMode(scenario);
		switch (mode) {
		case strictEcl:
			throw new ObsoleteEclFormatException();
		case ecl:
			if (scenario.getContent() != null && !discardUserChanges)
				throw new UserModificationException();
			scenario.setType(TESLA_SCENARIO_TYPE);
			scenario.setContent(null);
			return true;
		}
		return false;
	}

	public static boolean hasUserModifications(Scenario scenario) {
		ScenarioMode mode = getScenarioMode(scenario);
		switch (mode) {
		case strictEcl:
			return true;
		case ecl:
			return scenario.getContent() != null;
			// TODO Script eclScript = (Script) scenario.getContent();
			// if (eclScript == null)
			// return false;
			//
			// String teslaScript = new EclRecorder()
			// .generateCode(getTesla(scenario));
			// Command teslaContent;
			// Command eclContent;
			// try {
			// teslaContent = EclCoreParser.newCommand(teslaScript);
			// eclContent = EclCoreParser.newCommand(eclScript.getContent());
			// } catch (CoreException e) {
			// Q7Plugin.log(e);
			// return true;
			// }
			// return !EcoreUtil.equals(eclContent, teslaContent);
		}
		return false;
	}

	public static boolean hasObsoleteEclFormat(Scenario scenario) {
		return getScenarioMode(scenario) == ScenarioMode.strictEcl;
	}

	public static boolean hasObsoleteTeslaFormat(Scenario scenario) {
		return getScenarioMode(scenario) == ScenarioMode.strictTesla;
	}

	public static boolean hasTesla(Scenario scenario) {
		if (scenario.getContent() instanceof TeslaScenario) {
			return true;
		} else if (scenario.getTeslaContent() instanceof TeslaScenario) {
			return true;
		}
		return false;
	}

	public static TeslaScenario getTesla(Scenario scenario) {
		if (scenario.getContent() instanceof TeslaScenario) {
			return (TeslaScenario) scenario.getContent();
		} else if (scenario.getTeslaContent() instanceof TeslaScenario) {
			return (TeslaScenario) scenario.getTeslaContent();
		}
		return null;
	}
	public static TeslaScenario getTesla(ITestCase scenario) throws ModelException {
		if (scenario.getContent() instanceof TeslaScenario) {
			return (TeslaScenario) scenario.getContent();
		} else if (scenario.getTesla() instanceof TeslaScenario) {
			return (TeslaScenario) scenario.getTesla();
		}
		return null;
	}

	public static void setTesla(Scenario scenario, TeslaScenario tesla) {
		if (hasObsoleteTeslaFormat(scenario)) {
			scenario.setContent(tesla);
		} else {
			scenario.setTeslaContent(tesla);
		}
	}

	public static boolean hasEcl(Scenario scenario) {
		return scenario.getContent() instanceof Script;
	}

	public static boolean isEmpty(ITestCase test) {
		try {
			Boolean value = Q7SearchCore.findIsEmptyByDocument(test);
			if( value != null) {
				return value.booleanValue();
			}
			
			if (test.getNamedElement() instanceof Scenario) {
				Scenario scenario = (Scenario)test.getNamedElement();
				return isEmpty(scenario);
			}
		} catch (Exception e) {
			// ignore exception
		}
		return false;
	}

	public static boolean isEmpty(Scenario scenario) {
		Script script = getEcl(scenario);
		if (script != null) {
			String content = script.getContent();
			if (content != null && content.length() > 0)
				return false;
		}
		return true;
	}

	public static Script getEcl(Scenario scenario) {
		if (scenario.getContent() instanceof Script) {
			return (Script) scenario.getContent();
		}
		TeslaScenario tesla = getTesla(scenario);
		if (tesla == null) {
			return null;
		} else {
			Script script = CoreFactory.eINSTANCE.createScript();
			script.setContent(new EclRecorder().generateCode(tesla));
			return script;
		}
	}
	public static Script getEcl(ITestCase scenario) throws ModelException {
		if (scenario.getContent() instanceof Script) {
			return (Script) scenario.getContent();
		}
		TeslaScenario tesla = getTesla(scenario);
		if (tesla == null) {
			return null;
		} else {
			Script script = CoreFactory.eINSTANCE.createScript();
			script.setContent(new EclRecorder().generateCode(tesla));
			return script;
		}
	}

	public static void setEcl(Scenario scenario, Script script) {
		if (isEclMode(scenario)) {
			if (!EcoreUtil.equals(script, scenario.getContent()))
				scenario.setContent(script);
		} else {
			throw new IllegalArgumentException();
		}
	}

	public static void setEclContent(Scenario scenario, String content) {
		if (isEclMode(scenario)) {
			String previous = getScriptContent(scenario);
			if (previous != null && previous.equals(content)) {
				return;
			}
		} else {
			setTypeToEcl(scenario);
		}
		if (content == null /*|| content.length() == 0*/) {
			scenario.setContent(null);
			return;
		}
		Script script = CoreFactory.eINSTANCE.createScript();
		script.setContent(content);
		scenario.setContent(script);
	}

	public static void setEclContent(ITestCase scenario, String content) throws ModelException {
		if (content == null || content.length() == 0) {
			scenario.setContent(null);
			return;
		}
		Script script = CoreFactory.eINSTANCE.createScript();
		script.setContent(content);
		scenario.setContent(script);
	}

	private static enum ScenarioMode {
		ecl, tesla, strictEcl, strictTesla
	}

	private static ScenarioMode getScenarioMode(Scenario scenario) {
		String type = getScenarioType(scenario, ECL_SCENARIO_TYPE);
		if (ECL_SCENARIO_TYPE.equals(type)) {
			if (scenario.getTeslaContent() == null) {
				Script script = (Script) scenario.getContent();
				if (script == null || script.getContent() == null || script.getContent().trim().length() == 0)
					return ScenarioMode.ecl;
			} else if (scenario.getTeslaContent() == null || scenario.getTeslaContent() instanceof TeslaScenario)
				return ScenarioMode.ecl;
			return ScenarioMode.strictEcl;
		} else {
			return scenario.getContent() instanceof TeslaScenario ? ScenarioMode.strictTesla : ScenarioMode.tesla;
		}
	}

	public static String getScriptContent(Scenario scenario) {
		if (isEclMode(scenario)) {
			if (hasObsoleteEclFormat(scenario) || hasUserModifications(scenario)) {
				Script script = getEcl(scenario);
				if (script == null)
					return "";
				return script.getContent();
			}
		}

		TeslaScenario tesla = getTesla(scenario);
		if (tesla == null)
			return "";
		return new EclRecorder().generateCode(tesla);
	}

	// Suppresses default constructor, ensuring non-instantiability.
	private Scenarios() {
	}
}

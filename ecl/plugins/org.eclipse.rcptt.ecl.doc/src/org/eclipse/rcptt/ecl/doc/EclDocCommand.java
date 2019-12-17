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
package org.eclipse.rcptt.ecl.doc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.rcptt.ecl.core.util.EclCommandNameConvention;
import org.eclipse.rcptt.ecl.internal.core.CorePlugin;
import org.eclipse.rcptt.ecl.runtime.CoreUtils;

public class EclDocCommand implements IEclDocProvider {

	private EClass eclass;
	private String name;
	private EclDocCommandDocumentation docs;
	private List<EclDocParameter> params;

	public EclDocCommand(EClass eclass) {
		this.eclass = eclass;
		this.name = EclCommandNameConvention.toCommandName(eclass.getName());
	}

	public boolean isExcluded() {
		return excludedCommands.contains(name);
	}

	public String getName() {
		return name;
	}

	public boolean isInternal() {
		return eclass.getEAnnotation(EclDocConstants.INTERNAL_ANN) != null;
	}

	public EClass getEClass() {
		return eclass;
	}

	public EclDocCommandDocumentation getDocumentation() {
		if (docs == null)
			docs = new EclDocCommandDocumentation(this);
		return docs;
	}

	public List<EclDocParameter> getParameters() {
		if (params != null)
			return params;

		params = new ArrayList<EclDocParameter>();
		EList<EStructuralFeature> features = getEClass()
				.getEAllStructuralFeatures();
		for (EStructuralFeature f : features)
			params.add(new EclDocParameter(f));

		return params;
	}

	public EclDocParameter findParameter(String name) {
		if (name.length() > 1 && name.charAt(0) == '-')
			name = name.substring(1);

		for (EclDocParameter p : getParameters())
			if (p.getName().equals(name))
				return p;
		return null;
	}

	// --

	private static ArrayList<EclDocCommand> commands = null;
	private static HashMap<String, EclDocCommand> commandsByName = null;

	private static List<String> excludedCommands = Arrays.asList("recognize",
			"contains-image", "sequence", "parallel", "get-advanced-info",
			"control-not-found", "pipeline", "setup-player", "shutdown-player",
			"get-global", "set-global", "script", "get-region",
			"get-region-text", "alert", "get-memory-usage", "get-val",
			"proc-instance", "save-session", "restore-session", "declaration", "unzip-file",
			"shoutdown-player", "path-utils", "list-executed-suites",
			"kill-all-executed", "binary-op");

	private static EClass COMMAND = (EClass) EPackage.Registry.INSTANCE
			.getEPackage("http://www.eclipse.org/ecl/core.ecore")
			.getEClassifier("Command");

	public static synchronized List<EclDocCommand> getAllPublicCommands() {
		CorePlugin.getScriptletManager().getAllCommandNames(); // prevents deadlock
		if (commands != null)
			return commands;

		commands = new ArrayList<EclDocCommand>();
		commandsByName = new HashMap<String, EclDocCommand>();

		for (Object o : EPackage.Registry.INSTANCE.values().toArray()) {
			try {
				if (o instanceof EPackage.Descriptor)
					o = ((EPackage.Descriptor) o).getEPackage();

				if (!(o instanceof EPackage))
					continue;

				EPackage p = (EPackage) o;
				for (EClassifier classifier : p.getEClassifiers()) {
					if (!(classifier instanceof EClass))
						continue;

					EClass class_ = (EClass) classifier;
					if (class_.isAbstract()
							|| !class_.getEAllSuperTypes().contains(COMMAND))
						continue;

					EclDocCommand command = new EclDocCommand(class_);
					if (command.isInternal() || command.isExcluded())
						continue;

					if (commandsByName.containsKey(command.getName()))
						continue;

					commands.add(command);
					commandsByName.put(command.getName(), command);
				}
			} catch (Exception e) {
				EclDocPlugin.err("Failed to load documentation from: " + o, e);
			}
		}

		Collections.sort(commands, new Comparator<EclDocCommand>() {
			public int compare(EclDocCommand a, EclDocCommand b) {
				return a.getName().compareTo(b.getName());
			}
		});

		return commands;
	}

	public static synchronized EclDocCommand get(String name) {
		if (commandsByName == null)
			getAllPublicCommands();
		return commandsByName.get(name);
	}

	// --

	private static void writeParam(EclDocParameter param, EclDocWriter w)
			throws IOException {
		w.dd();
		{
			w.b(param.getName());

			int lower = param.getLowerBound();
			int upper = param.getUpperBound();

			if (upper != lower) {
				if (lower == 0 && upper == 1) {
					w.raw(" optional");
				} else {
					w.raw(" (");
					if (upper >= lower) {
						w.raw(lower);
						w.raw(", ");
						w.raw(upper);
					} else {
						w.raw(lower);
						w.raw(", ");
						w.raw("&infin;");
					}
					w.raw(")");
				}
			} else if (lower != 1) {
				w.raw(" ");
				w.raw(lower);
			}

			w.raw(" ");
			w.raw(param.getFriendlyTypeName());

			if (param.isOptional()) {
				String literal = param.getFriendlyDefaultLiteral();
				if (!CoreUtils.isBlank(literal)) {
					w.raw(" = ");
					w.raw(literal);
				}
			}

			String paramDesc = param.getDocumentation().getDescription();
			if (!CoreUtils.isBlank(paramDesc)) {
				w.raw(": ");
				w.raw(paramDesc);
			}
		}
		w.close();
	}

	public void writeEclDoc(EclDocWriter w) throws IOException {
		String desc = getDocumentation().getDescription();
		desc = CoreUtils.isBlank(desc) ? getName() : desc;
		w.text(desc);

		// --

		EclDocParameter inputParam = null;
		ArrayList<EclDocParameter> params = new ArrayList<EclDocParameter>();
		for (EclDocParameter p : getParameters()) {
			if (p.isInput()) {
				inputParam = p;
				continue;
			}
			if (p.isInternal())
				continue;

			params.add(p);
		}

		if (inputParam != null) {
			w.dl();
			{
				w.dt("Input:");
				writeParam(inputParam, w);
			}
			w.close();
		}

		if (params.size() > 0) {
			w.dl();
			{
				w.dt("Parameters:");
				for (EclDocParameter p : params)
					writeParam(p, w);
			}
			w.close();
		}

		// --

		String returns = getDocumentation().getReturns();
		if (!CoreUtils.isBlank(returns)) {
			w.dl();
			{
				w.dt("Output:");
				w.dd(returns);
			}
			w.close();
		}

		String example = getDocumentation().getExample();
		if (!CoreUtils.isBlank(example)) {
			w.dl();
			{
				w.dt("Example:");
				w.dd();
				{
					w.pre(example);
				}
				w.close();
			}
			w.close();
		}
	}
}

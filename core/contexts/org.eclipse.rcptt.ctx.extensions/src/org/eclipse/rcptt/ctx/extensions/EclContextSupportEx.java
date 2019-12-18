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
package org.eclipse.rcptt.ctx.extensions;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.rcptt.core.model.IContext;
import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.model.IQ7Project;
import org.eclipse.rcptt.core.model.ModelException;
import org.eclipse.rcptt.core.model.search.AllProjectScope;
import org.eclipse.rcptt.core.model.search.Q7SearchCore;
import org.eclipse.rcptt.core.ecl.context.EclContext;
import org.eclipse.rcptt.internal.core.model.OneProjectScope;

public class EclContextSupportEx {
	public static Map<String, String> getAllScripts(IQ7NamedElement excludedContext, IQ7Project project) {
		IContext[] contexts = Q7SearchCore.findAllContexts((project==null)?new AllProjectScope(): new OneProjectScope(project));
		Map<String, String> mapIdToScript = new HashMap<String, String>();

		try {
			for (IContext context : contexts) {
				// skip current context
				if ((excludedContext != null) && (excludedContext instanceof IContext)
						&& (context.equals(excludedContext)))
					continue;

				if (context.getNamedElement() instanceof EclContext) {
					EclContext ecl = (EclContext) context.getNamedElement();
					mapIdToScript.put(context.getID(), ecl.getScript().getContent());
				}
			}
		} catch (ModelException e) {
		}

		return mapIdToScript;
	}

	public static Map<String, String> getAllScripts(String excludedScript, IQ7Project project) {
		IContext[] contexts = Q7SearchCore.findAllContexts((project==null)?new AllProjectScope(): new OneProjectScope(project));
		Map<String, String> mapIdToScript = new HashMap<String, String>();

		try {
			for (IContext context : contexts) {
				if (context.getNamedElement() instanceof EclContext) {
					EclContext ecl = (EclContext) context.getNamedElement();
					String eclScript = ecl.getScript().getContent().trim();
					excludedScript = excludedScript.trim();

					if (!isPartOf(eclScript, excludedScript)) {
						mapIdToScript.put(context.getID(), eclScript);
					}

					/*
					 * if(!excludedScript.equalsIgnoreCase(eclScript)) {
					 * mapIdToScript.put(context.getID(), eclScript); }
					 */
				}
			}
		} catch (ModelException e) {
		}

		return mapIdToScript;
	}

	private static boolean isPartOf(String s1, String s2) {
		if (s1.equalsIgnoreCase(s2))
			return true;

		/*
		 * String patternString = "\\b(" + s1 + ")\\b"; Pattern pattern =
		 * Pattern.compile(patternString); Matcher matcher =
		 * pattern.matcher(s2);
		 * 
		 * if(matcher.find()) return true;
		 */

		return false;
	}
}

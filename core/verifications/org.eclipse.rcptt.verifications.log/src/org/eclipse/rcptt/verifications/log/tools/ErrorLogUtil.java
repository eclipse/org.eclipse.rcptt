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
package org.eclipse.rcptt.verifications.log.tools;

import static org.eclipse.rcptt.util.StringUtils.nullToEmpty;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.rcptt.verifications.log.ErrorLogVerification;
import org.eclipse.rcptt.verifications.log.LogEntryPredicate;
import org.eclipse.rcptt.verifications.log.LogFactory;
import org.eclipse.rcptt.verifications.log.LogPackage;
import org.eclipse.rcptt.verifications.log.LogPackage.Literals;




public class ErrorLogUtil {
	public static boolean match(LogEntryPredicate predicate, IStatus status) {
		if (!LogPackage.Literals.LOG_ENTRY_PREDICATE__CODE.getDefaultValue()
				.equals(predicate.getCode())) {
			if (predicate.getCode() != status.getCode())
				return false;
		}

		if (!status.matches(predicate.getSeverityMask()))
			return false;

		if (!status.getMessage().matches(predicate.getMessagePattern()))
			return false;

		if (!status.getPlugin().matches(predicate.getPluginPattern()))
			return false;

		return true;
	}

	public static LogEntryPredicate find(Iterable<LogEntryPredicate> predicates, IStatus status) {
		for (LogEntryPredicate predicate : predicates) {
			if (match(predicate, status))
				return predicate;
		}
		return null;
	}

	public static boolean includes(LogEntryPredicate wide,
			LogEntryPredicate specific) {
		if ((specific.getSeverityMask() & ~wide.getSeverityMask()) != 0)
			return false;
		if (!Literals.LOG_ENTRY_PREDICATE__CODE.getDefaultValue().equals(
				wide.getCode()))
			if (wide.getCode() == specific.getCode())
				return false;
		if (!nullToEmpty(specific.getMessagePattern()).matches(
				nullToEmpty(wide.getMessagePattern())))
			return false;
		if (!nullToEmpty(specific.getPluginPattern()).matches(
				nullToEmpty(wide.getPluginPattern())))
			return false;
		return true;
	}

	public static LogEntryPredicate createMatchingPredicate(IStatus status) {
		LogEntryPredicate rv = LogFactory.eINSTANCE.createLogEntryPredicate();
		rv.setCode(status.getCode());
		rv.setSeverityMask(status.getSeverity());
		rv.setMessagePattern(status.getMessage());
		rv.setPluginPattern(status.getPlugin());
		assert match(rv, status);
		return rv;
	}

	public static int getIndex(LogEntryPredicate predicate) {
		ErrorLogVerification parent = (ErrorLogVerification) predicate
				.eContainer();
		if (parent == null)
			throw new NullPointerException(
					"Predicate should be stored in a verification");

		List<LogEntryPredicate> content = getPredicates(parent);

		int rv = content.indexOf(predicate);

		assert rv >= 0;
		return rv;
	}

	protected static List<LogEntryPredicate> getPredicates(
			ErrorLogVerification parent) {
		List<LogEntryPredicate> content = new ArrayList<LogEntryPredicate>();
		content.addAll(parent.getRequired());
		content.addAll(parent.getAllowed());
		content.addAll(parent.getDenied());
		return content;
	}

	public static LogEntryPredicate getPredicateByIndex(
			ErrorLogVerification parent, int index) {
		assert index >= 0;
		List<LogEntryPredicate> content = getPredicates(parent);
		if (index >= content.size())
			return null;
		LogEntryPredicate rv = content.get(index);
		assert rv != null;
		assert getIndex(rv) == index;
		return rv;
	}

	
	private static final int[] MASKS = {
		IStatus.ERROR,
		IStatus.WARNING,
		IStatus.INFO
	};

	private static final String[] NAMES = {
		"ERROR",
		"WARNING",
		"INFO"
	};

	private static String severityToString(int severity) {
		StringBuilder sb = new StringBuilder();
		boolean first = true;
		for (int i = 0; i < MASKS.length; i++) {
			if ((MASKS[i] & severity) == 0)
				continue;
			if (!first)
				sb.append(", ");
			sb.append(NAMES[i]);
			first = false;
		}
		if (first) {
			sb.append("NO SEVERITY");
		}
		return sb.toString();
	}
		
	public static String describe(LogEntryPredicate predicate) {
		StringBuilder sb = new StringBuilder();
		sb.append(severityToString(predicate.getSeverityMask()));
		if (!LogPackage.Literals.LOG_ENTRY_PREDICATE__CODE.getDefaultValue().equals(predicate.getCode())) {
			sb.append("code: " + predicate.getCode());
		}
		
		if (!".*".equals(predicate.getPluginPattern()))
			sb.append(", plugin: " + nullToEmpty(predicate.getPluginPattern()));
		if (!".*".equals(predicate.getMessagePattern()))
			sb.append(", message: " + nullToEmpty(predicate.getMessagePattern()));
		
		return sb.toString();
	}
	
	
	public static String describe(IStatus status) {
		return status.toString();
	}

}

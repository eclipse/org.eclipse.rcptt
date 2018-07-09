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
package org.eclipse.rcptt.tesla.recording.core.ecl.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.core.CoreFactory;
import org.eclipse.rcptt.ecl.core.Exec;
import org.eclipse.rcptt.ecl.core.ExecutableParameter;
import org.eclipse.rcptt.ecl.core.LiteralParameter;
import org.eclipse.rcptt.ecl.core.Parameter;
import org.eclipse.rcptt.ecl.core.Pipeline;
import org.eclipse.rcptt.ecl.core.util.EclCommandNameConvention;
import org.eclipse.rcptt.tesla.ecl.TeslaScriptletFactory;
import org.eclipse.rcptt.tesla.ecl.model.GetItem;
import org.eclipse.rcptt.tesla.ecl.model.Select;
import org.eclipse.rcptt.tesla.ecl.model.TeslaFactory;
import org.eclipse.rcptt.tesla.ecl.model.TeslaPackage;
import org.eclipse.rcptt.util.TableTreeItemPathUtil;

public class TeslaParserUtil {

	// makePathFromList method has been moved into TeslaPathUtils class


	public static Command cut(Command target, Command start) {
		if (target instanceof Pipeline)
			return cut((Pipeline) target, start);
		return null;
	}

	public static Command cut(Pipeline target, Command start) {
		if (start instanceof Pipeline)
			return cut(target, (Pipeline) start);
		else {
			if (target.getCommands().size() <= 1)
				return null;
			Command first = target.getCommands().get(0);
			if (EcoreUtil.equals(first, start)) {
				// eclipse 3.4 compatibility:
				// EcoreUtil.copy raise exception if argument is null
				target = (target != null) ? (Pipeline) EcoreUtil.copy(target)
						: null;
				target.getCommands().remove(0);
				if (target.getCommands().size() == 1)
					return target.getCommands().get(0);
				return target;
			} else {
				return null;
			}
		}
	}

	public static Command cut(Pipeline target, Pipeline start) {
		int targetSize = target.getCommands().size();
		int size = start.getCommands().size();
		if (targetSize < size)
			return null;
		for (int i = 0; i < size; i++) {
			if (!EcoreUtil.equals(target.getCommands().get(i), start
					.getCommands().get(i))) {
				return null;
			}
		}
		// eclipse 3.4 compatibility:
		// EcoreUtil.copy raise exception if argument is null
		target = (target != null) ? (Pipeline) EcoreUtil.copy(target) : null;
		List<Command> subList = new ArrayList<Command>(target.getCommands()
				.subList(size, targetSize));
		target.getCommands().clear();
		target.getCommands().addAll(subList);
		if (target.getCommands().size() == 1)
			return target.getCommands().get(0);
		return target;
	}

	public static Command makeSelect(List<Command> items) {
		List<Parameter> parameters = new ArrayList<Parameter>();
		boolean sameColumn = true;
		boolean firstVal = true;
		String columnName = null;

		for (Command i : items) {
			if (i instanceof GetItem) {
				GetItem item = (GetItem) i;
				if (item.getIndex() != null) {
					sameColumn = false;
					break;
				}
				if ((item.getColumn() == null)
						|| !item.getColumn().equals(columnName)) {
					if (!firstVal) {
						sameColumn = false;
						break;
					} else {
						columnName = item.getColumn();
					}
				}
			}
			firstVal = false;
		}
		for (Command i : items) {
			if (i instanceof GetItem && ((GetItem) i).getIndex() == null
					&& (((GetItem) i).getColumn() == null || sameColumn)) {
				// select "..." syntax case
				LiteralParameter literal = CoreFactory.eINSTANCE
						.createLiteralParameter();
				literal.setName(TeslaPackage.Literals.SELECT__ITEMS.getName());
				literal.setLiteral(((GetItem) i).getPath());
				parameters.add(literal);
			} else {
				// select [get-item ...] syntax case
				ExecutableParameter executable = CoreFactory.eINSTANCE
						.createExecutableParameter();
				executable.setCommand(i);
				executable.setName(TeslaPackage.Literals.SELECT__ITEMS
						.getName());
				parameters.add(executable);
			}
		}
		if (sameColumn && columnName != null) {
			LiteralParameter columnLiteral = CoreFactory.eINSTANCE
					.createLiteralParameter();
			columnLiteral.setName(TeslaPackage.Literals.SELECT__COLUMN.getName());
			columnLiteral.setLiteral(columnName);
			parameters.add(columnLiteral);
		}

		Exec exec = CoreFactory.eINSTANCE.createExec();
		exec.setName(EclCommandNameConvention
				.toCommandName(TeslaPackage.Literals.SELECT.getName()));
		exec.getParameters().addAll(parameters);
		return exec;
	}

	// for combos
	public static Command makeSelect(String text) {
		Select cmd = TeslaFactory.eINSTANCE.createSelect();
		cmd.getItems().add(text);
		return cmd;
	}

	private static final Pattern IndexedSegmentPattern = Pattern
			.compile("(.*)%(\\d+)%");

	public static Command makeItem(List<String> path) {
		if (path.size() == 0)
			throw new IllegalArgumentException("Empty path");
		List<Command> items = new ArrayList<Command>();
		StringBuilder item = new StringBuilder();
		String columnName = null;
		boolean empty = true;
		boolean firstSegment = true;
		for (String segment : path) {
			columnName = TableTreeItemPathUtil.findColumnName(segment);
			String trimSegment = TableTreeItemPathUtil.excludeColumnName(segment);
			Matcher matcher = IndexedSegmentPattern.matcher(trimSegment);
			if (matcher.matches()) {
				if (!empty) {
					items.add(TeslaScriptletFactory.makeItem(item.toString(),
							null, columnName));
					item.setLength(0);
					empty = true;
				}
				String p = matcher.group(1);
				p = p.replace("/", "\\/");
				int i = Integer.parseInt(matcher.group(2));
				items.add(TeslaScriptletFactory.makeItem(p, i, columnName));
				firstSegment = true;
			} else {
				if (!firstSegment)
					item.append('/');
				trimSegment = trimSegment.replace("/", "\\/");
				item.append(trimSegment);
				empty = false;
				firstSegment = false;
			}
		}
		if (!empty) {
			items.add(TeslaScriptletFactory.makeItem(item.toString(), null, columnName));
		}
		if (items.size() == 1) {
			return items.get(0);
		}
		return TeslaScriptletFactory.makePipe((List<Command>) items);
	}

	public static Command makeMenu(List<String> path, Integer index) {
		if (path.size() == 0)
			throw new IllegalArgumentException("Empty path");
		List<Command> items = new ArrayList<Command>();
		StringBuilder item = new StringBuilder();
		for (String segment : path) {
			Matcher matcher = IndexedSegmentPattern.matcher(segment);
			if (matcher.matches()) {
				if (item.length() > 0) {
					items.add(TeslaScriptletFactory.makeItem(item.toString(),
							null));
					item.setLength(0);
				}
				String p = matcher.group(1);
				int i = Integer.parseInt(matcher.group(2));
				items.add(TeslaScriptletFactory.makeMenu(p, i));
			} else {
				if (item.length() > 0)
					item.append('/');
				segment = segment.replace("/", "\\/");
				item.append(segment);
			}
		}
		if (item.length() > 0) {
			items.add(TeslaScriptletFactory.makeMenu(item.toString(), index));
		}
		if (items.size() == 1) {
			return items.get(0);
		}
		return TeslaScriptletFactory.makePipe((List<Command>) items);
	}
}

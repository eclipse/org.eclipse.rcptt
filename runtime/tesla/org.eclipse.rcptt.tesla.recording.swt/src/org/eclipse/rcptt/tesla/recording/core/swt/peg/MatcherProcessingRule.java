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
package org.eclipse.rcptt.tesla.recording.core.swt.peg;

import static org.eclipse.rcptt.util.Predicates.and;
import static org.eclipse.rcptt.util.Predicates.or;
import static org.eclipse.rcptt.tesla.core.protocol.DragKind.START;
import static org.eclipse.rcptt.tesla.core.protocol.MouseEventKind.DOWN;
import static org.eclipse.rcptt.tesla.core.protocol.MouseEventKind.UP;
import static org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage.Literals.CLICK_TEXT;
import static org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage.Literals.DRAG_COMMAND;
import static org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage.Literals.DRAG_COMMAND__KIND;
import static org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage.Literals.ELEMENT_COMMAND__ELEMENT;
import static org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage.Literals.MOUSE_EVENT;
import static org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage.Literals.MOUSE_EVENT__BUTTON;
import static org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage.Literals.MOUSE_EVENT__KIND;
import static org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage.Literals.MOUSE_EVENT__STATE_MASK;
import static org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage.Literals.SELECT_COMMAND;
import static org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage.Literals.SELECT_COMMAND__DATA;
import static org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage.Literals.SELECT_DATA__KIND;
import static org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage.Literals.SELECT_DATA__PARENT;
import static org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage.Literals.SET_FOCUS;
import static org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage.Literals.SET_SELECTION;
import static org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage.Literals.SET_TEXT;
import static org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage.Literals.SET_TEXT_OFFSET;
import static org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage.Literals.SET_TEXT_OFFSET__LINE;
import static org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage.Literals.SET_TEXT_OFFSET__OFFSET;
import static org.eclipse.rcptt.tesla.core.protocol.diagram.DiagramPackage.Literals.FIGURE_MOUSE_COMMAND;
import static org.eclipse.rcptt.tesla.core.protocol.diagram.DiagramPackage.Literals.FIGURE_MOUSE_COMMAND__BUTTON;
import static org.eclipse.rcptt.tesla.core.protocol.diagram.DiagramPackage.Literals.FIGURE_MOUSE_COMMAND__KIND;
import static org.eclipse.rcptt.tesla.core.protocol.raw.RawPackage.Literals.ELEMENT__ID;
import static org.eclipse.rcptt.tesla.core.protocol.raw.RawPackage.Literals.ELEMENT__KIND;

import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.rcptt.util.Predicate;
import org.eclipse.rcptt.tesla.core.protocol.ElementKind;
import org.eclipse.rcptt.tesla.core.protocol.SelectCommand;
import org.eclipse.rcptt.tesla.core.protocol.SelectData;
import org.eclipse.rcptt.tesla.core.protocol.diagram.MouseCommandKind;
import org.eclipse.rcptt.tesla.core.protocol.raw.Command;

@SuppressWarnings("unchecked")
public abstract class MatcherProcessingRule extends ProcessingRule {
	private final Predicate<List<Command>> matcher;

	public MatcherProcessingRule(Predicate<List<Command>> matcher) {
		this.matcher = matcher;
	}

	public boolean matches(List<Command> commands) {
		return matcher.apply(commands);
	}

	protected static CommandPredicate command(int index,
			Predicate<Command>... predicates) {
		return new CommandPredicate(index, and(predicates));
	}

	protected static CommandsPredicate commands(int index1, int index2,
			Predicate<List<Command>>... predicates) {
		return new CommandsPredicate(new int[] { index1, index2 },
				and(predicates));
	}

	protected static FeaturesEqPredicate eq(EStructuralFeature... features) {
		return new FeaturesEqPredicate(features);
	}

	protected static CommandTypePredicate type(EClass type) {
		return new CommandTypePredicate(type);
	}

	protected static FeaturePredicate field(Object expected,
			EStructuralFeature... features) {
		return new FeaturePredicate(expected, features);
	}

	protected static FeaturesEqPredicate sameSelectData = eq(SELECT_COMMAND__DATA);
	protected static FeaturesEqPredicate isSameCellInGetItem = eq(SELECT_COMMAND__DATA);
	protected static FeaturesEqPredicate sameParentInGetItem = eq(
			SELECT_COMMAND__DATA, SELECT_DATA__PARENT);
	protected static Predicate<Command> isGetItem = and(type(SELECT_COMMAND),
			field("Item", SELECT_COMMAND__DATA, SELECT_DATA__KIND));
	protected static Predicate<Command> isMouseDown = and(type(MOUSE_EVENT),
			field(DOWN, MOUSE_EVENT__KIND));
	protected static Predicate<Command> isMouseUp = and(type(MOUSE_EVENT),
			field(UP, MOUSE_EVENT__KIND));
	protected static Predicate<Command> isDragStart = and(type(DRAG_COMMAND),
			field(START, DRAG_COMMAND__KIND));
	protected static Predicate<Command> isSetFocus = type(SET_FOCUS);
	protected static Predicate<Command> isDefaultButton = and(
			type(MOUSE_EVENT), field(1, MOUSE_EVENT__BUTTON));
	protected static Predicate<Command> isEmptyStateMask = field(0,
			MOUSE_EVENT__STATE_MASK);
	protected static Predicate<Command> isSetTreeOrTableSelection = and(
			type(SET_SELECTION),
			or(field("Tree", ELEMENT_COMMAND__ELEMENT, ELEMENT__KIND),
					field("Table", ELEMENT_COMMAND__ELEMENT, ELEMENT__KIND)));
	protected static Predicate<Command> isSetText = type(SET_TEXT);
	protected static Predicate<List<Command>> isSameElement = and(
			eq(ELEMENT_COMMAND__ELEMENT, ELEMENT__ID),
			eq(ELEMENT_COMMAND__ELEMENT, ELEMENT__KIND));
	protected static Predicate<Command> isClickText = type(CLICK_TEXT);

	protected static Predicate<Command> isSetTextOffset = type(SET_TEXT_OFFSET);
	protected static FeaturesEqPredicate isSameOffsetOffset = eq(SET_TEXT_OFFSET__OFFSET);
	protected static FeaturesEqPredicate isSameOffsetLine = eq(SET_TEXT_OFFSET__LINE);

	@SuppressWarnings("unchecked")
	protected static Predicate<Command> isFigureMouseMoveNoButtons = and(
			type(FIGURE_MOUSE_COMMAND),
			field(MouseCommandKind.MOVE, FIGURE_MOUSE_COMMAND__KIND),
			field(0, FIGURE_MOUSE_COMMAND__BUTTON));

	private static List<String> editPartPathFirst = Arrays.asList("editpart",
			"editpart.feature");
	protected static Predicate<Command> isSelectEditPart = new Predicate<Command>() {
		public boolean apply(Command input) {
			if (!(input instanceof SelectCommand)) {
				return false;
			}
			SelectData data = ((SelectCommand) input).getData();
			return ElementKind.DiagramFigure.name().equals(data.getKind())
					&& data.getPath().size() > 0
					&& editPartPathFirst.contains(data.getPath().get(0));
		}
	};

}
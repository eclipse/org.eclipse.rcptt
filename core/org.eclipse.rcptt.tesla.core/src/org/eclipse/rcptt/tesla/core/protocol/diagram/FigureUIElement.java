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
package org.eclipse.rcptt.tesla.core.protocol.diagram;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.rcptt.tesla.core.protocol.BasicUIElement;
import org.eclipse.rcptt.tesla.core.protocol.Children;
import org.eclipse.rcptt.tesla.core.protocol.ChildrenResponse;
import org.eclipse.rcptt.tesla.core.protocol.ElementKind;
import org.eclipse.rcptt.tesla.core.protocol.GetText;
import org.eclipse.rcptt.tesla.core.protocol.GetTextResponse;
import org.eclipse.rcptt.tesla.core.protocol.Parent;
import org.eclipse.rcptt.tesla.core.protocol.ParentResponse;
import org.eclipse.rcptt.tesla.core.protocol.ProtocolFactory;
import org.eclipse.rcptt.tesla.core.protocol.SelectResponse;
import org.eclipse.rcptt.tesla.core.protocol.UIPlayer;
import org.eclipse.rcptt.tesla.core.protocol.UISelector;
import org.eclipse.rcptt.tesla.core.protocol.raw.Element;
import org.eclipse.rcptt.tesla.core.protocol.raw.Response;
import org.eclipse.rcptt.tesla.core.protocol.raw.ResponseStatus;

public class FigureUIElement extends BasicUIElement {
	private static class Selectors {
		public UISelector<FigureUIElement> childFigure;
		public UISelector<FigureUIElement> paletteEntry;
	}

	private final Selectors selector = new Selectors();

	public FigureUIElement(Element e, UIPlayer player) {
		super(e, player);
		selector.childFigure = new UISelector<FigureUIElement>(
				ElementKind.DiagramFigure, player, FigureUIElement.class)
				.parent(getElement());
		selector.paletteEntry = new UISelector<FigureUIElement>(
				ElementKind.PaletteEntry, player, FigureUIElement.class)
				.parent(getElement());
	}

	/**
	 * Return null if parent are diagram.
	 * 
	 * @return
	 */
	public FigureUIElement getParent() {
		Parent command = factory.createParent();
		command.setElement(getElement());
		Response response = player.safeExecuteCommand(command);
		player.clearFailures();
		if (response == null) {
			return null;
		}
		ParentResponse parentResponse = (ParentResponse) response;
		Element parent = parentResponse.getParent();
		if (parent.getKind().equals(ElementKind.DiagramFigure.name())) {
			return new FigureUIElement(parent, player);
		}
		return null;
	}

	public DiagramViewerUIElement getDiagram() {
		Parent command = factory.createParent();
		command.setElement(getElement());
		Response response = player.safeExecuteCommand(command);
		player.clearFailures();
		if (response == null) {
			return null;
		}
		ParentResponse parentResponse = (ParentResponse) response;
		Element parent = parentResponse.getParent();
		if (parent.getKind().equals(ElementKind.DiagramViewer.name())) {
			return new DiagramViewerUIElement(parent, player);
		}
		return null;
	}

	public FigureUIElement createFigure(String pattern, int x, int y) {
		CreateFigure figure = DiagramFactory.eINSTANCE.createCreateFigure();
		figure.setPattern(pattern);
		figure.setElement(getElement());
		figure.setX(x);
		figure.setY(y);
		Response response = player.safeExecuteCommand(figure);
		player.clearFailures();
		if (response != null && response.getStatus().equals(ResponseStatus.OK)) {
			CreateFigureResponse figureResponse = (CreateFigureResponse) response;
			EList<Element> list = figureResponse.getFigure();
			if (list.size() != 1) {
				// throw new RuntimeException("Wrong count of created figures"
				// + list.size());
				return null;
			}
			return new FigureUIElement(figureResponse.getFigure().get(0),
					player);
		}
		return null;
	}

	public FigureUIElement createConnection(String pattern,
			FigureUIElement from, FigureUIElement to) {
		CreateConnection figure = DiagramFactory.eINSTANCE
				.createCreateConnection();
		figure.setPattern(pattern);
		figure.setElement(getElement());
		figure.setFrom(from.getElement());
		figure.setTo(to.getElement());
		Response response = player.safeExecuteCommand(figure);
		player.clearFailures();
		if (response != null && response.getStatus().equals(ResponseStatus.OK)) {
			CreateConnectionResponse figureResponse = (CreateConnectionResponse) response;
			EList<Element> list = figureResponse.getFigure();
			if (list.size() != 1) {
				// throw new RuntimeException("Wrong count of created figures"
				// + list.size());
				return null;
			}
			return new FigureUIElement(figureResponse.getFigure().get(0),
					player);
		}
		return null;
	}

	public FigureUIElement[] getChildren() {
		Children command = ProtocolFactory.eINSTANCE.createChildren();
		command.setElement(getElement());
		Response response = player.safeExecuteCommand(command);
		player.clearFailures();
		if (response == null) {
			return null;
		}
		ChildrenResponse childrenResponse = (ChildrenResponse) response;
		EList<Element> children = childrenResponse.getChildren();
		List<FigureUIElement> figures = new ArrayList<FigureUIElement>();
		for (Element element : children) {
			figures.add(new FigureUIElement(element, player));
		}
		return figures.toArray(new FigureUIElement[figures.size()]);
	}

	public FigureUIElement child(String pattern) {
		return selector.childFigure.find(pattern);
	}

	public FigureUIElement paletteEntry(String pattern) {
		return selector.paletteEntry.find(pattern);
	}
	public FigureUIElement paletteEntry(String pattern, int index) {
		return selector.paletteEntry.find(pattern, index);
	}

	public FigureUIElement childClass(String pattern) {
		return selector.childFigure.classPattern(pattern).find();
	}

	// Editing support
	public DirectEditUIElement directEdit() {
		ActivateDirectEdit cmd = DiagramFactory.eINSTANCE
				.createActivateDirectEdit();
		cmd.setElement(getElement());
		SelectResponse response = (SelectResponse) player
				.safeExecuteCommand(cmd);
		EList<Element> elements = response.getElements();
		if (elements.size() != 1) {
			return null;
		} else {
			return new DirectEditUIElement(elements.get(0), player);
		}
	}

	public void forceDirectEdit(List<Integer> address) {
		ActivateDirectEdit cmd = DiagramFactory.eINSTANCE
				.createActivateDirectEdit();
		cmd.setElement(getElement());
		if (address != null) {
			cmd.getPartPath().addAll(address);
		}
		player.safeExecuteCommand(cmd);
	}

	public void deselectAll() {

	}

	public void move(int x, int y) {
		MoveFigure command = DiagramFactory.eINSTANCE.createMoveFigure();
		command.setX(x);
		command.setY(y);
		command.setElement(getElement());
		player.safeExecuteCommand(command);
	}

	public void resize(int width, int height) {
		ResizeFigure command = DiagramFactory.eINSTANCE.createResizeFigure();
		command.setX(width);
		command.setY(height);
		command.setElement(getElement());
		player.safeExecuteCommand(command);
	}

	public String getText() {
		GetText cmd = factory.createGetText();
		cmd.setElement(getElement());
		GetTextResponse response = (GetTextResponse) player
				.safeExecuteCommand(cmd);
		player.clearFailures();
		if (response == null) { // In case we are in recording
			return null;
		}
		if (response.getStatus().equals(ResponseStatus.OK)) {
			return response.getText();
		}
		return null;
	}

	public void executeFigureMouseCommand(int x, int y, int button,
			MouseCommandKind kind, List<Integer> partPath,
			List<Integer> figurePath, int width, int height, int figureWidth,
			int figureHeight, int stateMask) {
		FigureMouseCommand command = DiagramFactory.eINSTANCE
				.createFigureMouseCommand();
		command.setKind(kind);
		command.setButton(button);
		command.setElement(getElement());
		command.setX(x);
		command.setY(y);
		command.setBoundsWidth(width);
		command.setBoundsHeight(height);
		command.setFigureHeight(figureHeight);
		command.setFigureWidth(figureWidth);
		command.setStateMask(stateMask);
		if (figurePath != null) {
			command.getFigurePath().addAll(figurePath);
		}
		if (partPath != null) {
			command.getPartPath().addAll(partPath);
		}
		player.safeExecuteCommand(command);
	}

	public void cancelDirectEdit() {
		CancelDirectEdit cmd = DiagramFactory.eINSTANCE
				.createCancelDirectEdit();
		cmd.setElement(getElement());
		player.safeExecuteCommand(cmd);
	}

	public void commitDirectEdit() {
		CommitDirectEdit cmd = DiagramFactory.eINSTANCE
				.createCommitDirectEdit();
		cmd.setElement(getElement());
		player.safeExecuteCommand(cmd);
	}

	public void activateDirectEdit(List<Integer> partPaths) {
		ActivateDirectEdit cmd = DiagramFactory.eINSTANCE
				.createActivateDirectEdit();
		cmd.setElement(getElement());
		if (partPaths != null) {
			cmd.getPartPath().addAll(partPaths);
		}
		player.safeExecuteCommand(cmd);
	}

	public FigureUIElement figure(List<Integer> address) {
		return selector.childFigure.path("editpart", "address")
				.indexes(address.toArray(new Integer[address.size()])).find();
	}

	public FigureUIElement figure(Integer... address) {
		return selector.childFigure.path("editpart", "address")
				.indexes(address).find();
	}

	public FigureUIElement figureSourceConnection(int connection) {
		return selector.childFigure
				.path("editpart.source.connection", "address")
				.indexes(connection).find();
	}

	public FigureUIElement figureTargetConnection(int connection) {
		return selector.childFigure
				.path("editpart.target.connection", "address")
				.indexes(connection).find();
	}

	public FigureUIElement rawFigure(List<Integer> path) {
		return selector.childFigure.path("rawFigure", "address")
				.indexes(path.toArray(new Integer[path.size()])).find();
	}

	public FigureUIElement rawFigureAt(int x, int y) {
		return selector.childFigure.path("figure", "position",
				Integer.toString(x), Integer.toString(y)).find();
	}

	public FigureUIElement figureByFeature(String name, String value,
			Integer index) {
		return selector.childFigure.path("editpart.feature", name).find(value,
				index);
	}

	public FigureUIElement figureByName(String value, Integer index) {
		return selector.childFigure.path("editpart", "name").find(value, index);
	}

	public FigureUIElement handleByClass(String value, Integer index) {
		return selector.childFigure.path("handle", "class").find(value, index);
	}

	public FigureUIElement figureByText(String value, Integer index) {
		return selector.childFigure.path("editpart", "text").find(value, index);
	}

	public FigureUIElement figureByCustomId(String value) {
		return selector.childFigure.path("editpart", "customId").find(value);
	}

	public FigureUIElement figureByClassName(String value, Integer index) {
		return selector.childFigure.path("editpart", "classname").find(value,
				index);
	}

}

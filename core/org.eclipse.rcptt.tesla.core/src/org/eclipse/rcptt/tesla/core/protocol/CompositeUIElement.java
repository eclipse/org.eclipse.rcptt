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
package org.eclipse.rcptt.tesla.core.protocol;

import org.eclipse.core.runtime.Assert;

import org.eclipse.rcptt.tesla.core.protocol.diagram.DiagramViewerUIElement;
import org.eclipse.rcptt.tesla.core.protocol.raw.Element;

public class CompositeUIElement extends ControlUIElement {
	private static class Selectors {
		public UISelector<ControlUIElement> button;
		public UISelector<ControlUIElement> label;
		public UISelector<CompositeUIElement> group;
		public UISelector<CompositeUIElement> expandable;
		public UISelector<TextUIElement> text;
		public UISelector<TextUIElement> combo;

		public UISelector<ViewerUIElement> tree;
		public UISelector<ViewerUIElement> list;
		public UISelector<ViewerUIElement> table;
		public UISelector<CompositeUIElement> tabItem;
		public UISelector<PartUIElement> tabFolder;
		public UISelector<PartUIElement> view;
		public UISelector<EditorUIElement> editor;

		public UISelector<FormTextUIElement> formText;
		public UISelector<ControlUIElement> link;

		public UISelector<DiagramViewerUIElement> diagramViewer;
		public UISelector<DiagramViewerUIElement> paletteViewer;

		public UISelector<CompositeUIElement> cbanner;
		public UISelector<CompositeUIElement> coolbar;
		public UISelector<CompositeUIElement> toolbar;
		public UISelector<ControlUIElement> any;

		public UISelector<CanvasUIElement> canvas;
	}

	private final Selectors selector = new Selectors();

	@Override
	protected void updateAfter(Element e) {
		super.updateAfter(e);
		selector.button.after = e;
		selector.label.after = e;
		selector.text.after = e;
		selector.combo.after = e;
		selector.link.after = e;
		selector.diagramViewer.after = e;
		selector.paletteViewer.after = e;
		selector.formText.after = e;
		selector.view.after = e;
		selector.editor.after = e;
		selector.group.after = e;
		selector.expandable.after = e;

		selector.cbanner.after = e;
		selector.coolbar.after = e;
		selector.toolbar.after = e;
		selector.any.after = e;
		selector.canvas.after = e;

		selector.tree.after = e;
		selector.list.after = e;
		selector.table.after = e;
		selector.tabItem.after = e;
		selector.tabFolder.after = e;
	}

	public CompositeUIElement(Element e, UIPlayer player) {
		super(e, player);
		selector.button = new UISelector<ControlUIElement>(ElementKind.Button,
				player, ControlUIElement.class).parent(element);
		selector.text = new UISelector<TextUIElement>(ElementKind.Text, player,
				TextUIElement.class).parent(element);
		selector.combo = new UISelector<TextUIElement>(ElementKind.Combo,
				player, TextUIElement.class).parent(element);
		selector.formText = new UISelector<FormTextUIElement>(
				ElementKind.FormText, player, FormTextUIElement.class)
				.parent(element);
		selector.label = new UISelector<ControlUIElement>(ElementKind.Label,
				player, ControlUIElement.class).parent(element);

		selector.tree = new UISelector<ViewerUIElement>(ElementKind.Tree,
				player, ViewerUIElement.class).parent(element);
		selector.table = new UISelector<ViewerUIElement>(ElementKind.Table,
				player, ViewerUIElement.class).parent(element);
		selector.list = new UISelector<ViewerUIElement>(ElementKind.List,
				player, ViewerUIElement.class).parent(element);

		selector.tabItem = new UISelector<CompositeUIElement>(
				ElementKind.TabItem, player, CompositeUIElement.class)
				.parent(element);
		selector.tabFolder = new UISelector<PartUIElement>(
				ElementKind.TabFolder, player, PartUIElement.class)
				.parent(element);

		selector.view = new UISelector<PartUIElement>(ElementKind.View, player,
				PartUIElement.class).parent(element);

		selector.editor = new UISelector<EditorUIElement>(ElementKind.Editor,
				player, EditorUIElement.class).parent(element);

		selector.link = new UISelector<ControlUIElement>(ElementKind.Link,
				player, ControlUIElement.class).parent(element);

		selector.diagramViewer = new UISelector<DiagramViewerUIElement>(
				ElementKind.DiagramViewer, player, DiagramViewerUIElement.class)
				.parent(element);

		selector.paletteViewer = new UISelector<DiagramViewerUIElement>(
				ElementKind.PaletteViewer, player, DiagramViewerUIElement.class)
				.parent(element);

		selector.expandable = new UISelector<CompositeUIElement>(
				ElementKind.Expandable, player, CompositeUIElement.class)
				.parent(element);

		selector.group = new UISelector<CompositeUIElement>(ElementKind.Group,
				player, CompositeUIElement.class).parent(element);

		selector.cbanner = new UISelector<CompositeUIElement>(
				ElementKind.CBanner, player, CompositeUIElement.class)
				.parent(element);

		selector.coolbar = new UISelector<CompositeUIElement>(
				ElementKind.CoolBar, player, CompositeUIElement.class)
				.parent(element);
		selector.toolbar = new UISelector<CompositeUIElement>(
				ElementKind.Toolbar, player, CompositeUIElement.class)
				.parent(element);
		selector.any = new UISelector<ControlUIElement>(ElementKind.Any,
				player, ControlUIElement.class).parent(element);
		selector.canvas = new UISelector<CanvasUIElement>(ElementKind.Canvas,
				player, CanvasUIElement.class).parent(element);
	}

	public ControlUIElement button() {
		return selector.button.find();
	}

	public ControlUIElement any(int index) {
		return selector.any.find(index);
	}

	public CanvasUIElement canvas() {
		return selector.canvas.find();
	}

	public CanvasUIElement canvas(int index) {
		return selector.canvas.find(index);
	}

	public ControlUIElement button(String text) {
		return selector.button.find(text);
	}

	public ControlUIElement button(int index) {
		return selector.button.find(index);
	}

	public ControlUIElement button(String text, int index) {
		return selector.button.find(text, index);
	}

	public CompositeUIElement group() {
		return selector.group.find();
	}

	public CompositeUIElement group(String text) {
		return selector.group.find(text);
	}

	public CompositeUIElement group(int index) {
		return selector.group.find(index);
	}

	public CompositeUIElement expandable() {
		return selector.expandable.find();
	}

	public CompositeUIElement expandable(String text) {
		return selector.expandable.find(text);
	}

	public CompositeUIElement expandable(int index) {
		return selector.expandable.find(index);
	}

	public CompositeUIElement expandable(String text, int index) {
		return selector.expandable.find(text, index);
	}

	public ControlUIElement link() {
		return selector.link.find();
	}

	public ControlUIElement link(String text) {
		return selector.link.find(text);
	}

	public ControlUIElement link(int index) {
		return selector.link.find(index);
	}

	public ControlUIElement label() {
		return selector.label.find();
	}

	public ControlUIElement label(String text) {
		return selector.label.find(text);
	}

	public ControlUIElement label(int index) {
		return selector.label.find(index);
	}

	public TextUIElement text() {
		return selector.text.find();
	}

	public TextUIElement text(int index) {
		return selector.text.find(index);
	}

	public TextUIElement combo() {
		return selector.combo.find();
	}

	public TextUIElement combo(int index) {
		return selector.combo.find(index);
	}

	public FormTextUIElement formText() {
		return selector.formText.find();
	}

	public FormTextUIElement formText(String pattern) {
		return selector.formText.find(pattern);
	}

	public FormTextUIElement formText(int index) {
		return selector.formText.find(index);
	}

	public ViewerUIElement tree() {
		return selector.tree.find();
	}

	public ViewerUIElement tree(int index) {
		return selector.tree.find(index);
	}

	public ViewerUIElement list() {
		return selector.list.find();
	}

	public ViewerUIElement list(int index) {
		return selector.list.find(index);
	}

	public ViewerUIElement table() {
		return selector.table.find();
	}

	public ViewerUIElement table(int index) {
		return selector.table.find(index);
	}

	public CompositeUIElement tabItem(String pattern) {
		return selector.tabItem.find(pattern);
	}

	public PartUIElement tabFolder() {
		return selector.tabFolder.find();
	}

	public PartUIElement tabFolder(int index) {
		return selector.tabFolder.find(index);
	}

	public PartUIElement view(String pattern) {
		return selector.view.find(pattern);
	}

	public PartUIElement view(String pattern, int index) {
		return selector.view.find(pattern, index);
	}

	public EditorUIElement editor(String pattern) {
		return selector.editor.find(pattern);
	}

	public EditorUIElement editor(String pattern, String classPattern,
			Integer index) {
		return selector.editor.classPattern(classPattern).find(pattern, index);
	}

	public DiagramViewerUIElement diagramViewer() {
		return diagramViewer(null);
	}

	public DiagramViewerUIElement diagramViewer(Integer index) {
		return selector.diagramViewer.find(index);
	}

	public DiagramViewerUIElement paletteViewer() {
		return selector.paletteViewer.find();
	}

	public CompositeUIElement coolbar() {
		return selector.coolbar.find();
	}

	public CompositeUIElement coolbar(int index) {
		return selector.coolbar.find(index);
	}

	public CompositeUIElement cbanner() {
		return selector.cbanner.find();
	}

	public ControlUIElement cbanner(int index) {
		return selector.cbanner.find(index);
	}

	public CompositeUIElement toolbar() {
		return selector.toolbar.find();
	}

	public CompositeUIElement toolbar(int index) {
		return selector.toolbar.find(index);
	}

	public CompositeUIElement after(Element e) {
		CompositeUIElement ee = new CompositeUIElement(element, player);
		ee.updateAfter(e);
		return ee;
	}

	public CompositeUIElement after(BasicUIElement e) {
		CompositeUIElement ee = new CompositeUIElement(element, player);
		Assert.isNotNull(e);
		Assert.isNotNull(e.getElement());
		ee.updateAfter(e.getElement());
		return ee;
	}

	public CompositeUIElement after(UISelector<BasicUIElement> selector) {
		CompositeUIElement ee = new CompositeUIElement(element, player);
		BasicUIElement select = selector.find();
		Assert.isNotNull(select);
		Assert.isNotNull(select.getElement());
		ee.updateAfter(select.getElement());
		return ee;
	}
}

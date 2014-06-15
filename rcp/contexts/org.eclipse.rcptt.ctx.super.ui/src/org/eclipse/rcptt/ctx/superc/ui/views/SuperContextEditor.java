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
package org.eclipse.rcptt.ctx.superc.ui.views;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IWorkbenchSite;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;

import org.eclipse.rcptt.core.ContextType;
import org.eclipse.rcptt.core.ContextTypeManager;
import org.eclipse.rcptt.core.model.ModelException;
import org.eclipse.rcptt.core.scenario.ScenarioPackage;
import org.eclipse.rcptt.core.scenario.SuperContext;
import org.eclipse.rcptt.internal.ui.Q7UIPlugin;
import org.eclipse.rcptt.ui.context.BaseContextEditor;
import org.eclipse.rcptt.ui.controls.ContextsTable;
import org.eclipse.rcptt.ui.controls.SectionWithToolbar;
import org.eclipse.rcptt.ui.editors.EditorHeader;
import org.eclipse.rcptt.ui.editors.IQ7EditorActionsProvider;
import org.eclipse.rcptt.ui.editors.NamedElementEditorActions.INamedElementActions;

public class SuperContextEditor extends BaseContextEditor implements IQ7EditorActionsProvider {

	private ContextsTable contexts;

	public SuperContext getContextElement() {
		try {
			return (SuperContext) super.getElement().getNamedElement();
		} catch (ModelException e) {
			Q7UIPlugin.log(e);
		}
		return null;
	}

	public Control create(Composite parent, FormToolkit toolkit, IWorkbenchSite site,
			EditorHeader header) {
		try {
			ContextType type = ContextTypeManager.getInstance().getTypeById(
					getContextElement().getChildType());
			getForm().getForm().setText(type.getName() + " Super Context");
			contexts = new ContextsTable(getElement(),
					ScenarioPackage.Literals.SUPER_CONTEXT__CONTEXT_REFERENCES, false);
			contexts.setContextFilter(type.getId());
			return new SectionWithToolbar(contexts, Section.TITLE_BAR | Section.TWISTIE
					| Section.EXPANDED).create(parent, toolkit);
		} catch (ModelException e) {
			Q7UIPlugin.log(e);
		}
		return null;
	}
	@Override
	public INamedElementActions createActions() {
		return contexts;
	}
}

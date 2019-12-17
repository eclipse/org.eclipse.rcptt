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
package org.eclipse.rcptt.forms.impl.rap;


import org.eclipse.rcptt.tesla.core.context.ContextManagement.Context;
import org.eclipse.rcptt.tesla.core.info.AdvancedInformation;
import org.eclipse.rcptt.tesla.core.info.Q7WaitInfoRoot;
import org.eclipse.rcptt.tesla.core.protocol.IElementProcessorMapper;
import org.eclipse.rcptt.tesla.core.protocol.SelectCommand;
import org.eclipse.rcptt.tesla.core.protocol.SelectResponse;
import org.eclipse.rcptt.tesla.core.protocol.raw.Command;
import org.eclipse.rcptt.tesla.core.protocol.raw.Element;
import org.eclipse.rcptt.tesla.core.protocol.raw.Response;
import org.eclipse.rcptt.tesla.core.ui.UiFactory;
import org.eclipse.rcptt.tesla.core.ui.Widget;
import org.eclipse.rcptt.tesla.internal.core.AbstractTeslaClient;
import org.eclipse.rcptt.tesla.internal.core.processing.ElementGenerator;
import org.eclipse.rcptt.tesla.internal.core.processing.ITeslaCommandProcessor;
import org.eclipse.rcptt.tesla.internal.ui.player.ISWTModelMapperExtension;
import org.eclipse.rcptt.tesla.internal.ui.player.ISWTUIPlayerExtension;
import org.eclipse.rcptt.tesla.internal.ui.player.PlayerTextUtils;
import org.eclipse.rcptt.tesla.internal.ui.player.SWTModelMapper;
import org.eclipse.rcptt.tesla.internal.ui.player.SWTUIElement;
import org.eclipse.rcptt.tesla.internal.ui.player.SWTUIPlayer;
import org.eclipse.rcptt.tesla.internal.ui.player.TeslaSWTAccess;
import org.eclipse.swt.widgets.Link;
import org.eclipse.ui.forms.widgets.AbstractHyperlink;
import org.eclipse.ui.forms.widgets.FormText;
import org.eclipse.ui.internal.forms.widgets.FormTextModel;

@SuppressWarnings("restriction")
public class EclipseFormsProcessor implements ITeslaCommandProcessor, ISWTModelMapperExtension {

	private final ISWTUIPlayerExtension extension = new EclipseFormsPlayerExtension();

	@Override
	public void initialize(AbstractTeslaClient client, String id) {
		SWTUIPlayer.addExtension(extension);
	}

	@Override
	public void terminate() {
		SWTUIPlayer.removeExtension(extension);
	}

	@Override
	public String getFeatureID() {
		return "org.eclipse.rcptt.forms.impl";
	}

	@Override
	public boolean isSelectorSupported(String kind) {
		return false;
	}

	@Override
	public SelectResponse select(SelectCommand cmd, ElementGenerator generator, IElementProcessorMapper mapper) {
		return null;
	}

	@Override
	public boolean isCommandSupported(Command cmd) {
		return false;
	}

	@Override
	public Response executeCommand(Command command, IElementProcessorMapper mapper) {
		return null;
	}

	@Override
	public PreExecuteStatus preExecute(Command command, PreExecuteStatus previousStatus, Q7WaitInfoRoot info) {
		return null;
	}

	@Override
	public void postSelect(Element element, IElementProcessorMapper mapper) {

	}

	@Override
	public boolean isInactivityRequired() {
		return false;
	}

	@Override
	public boolean canProceed(Context context, Q7WaitInfoRoot info) {
		return true;
	}

	@Override
	public void clean() {

	}

	@Override
	public void checkHang() {

	}

	@Override
	public void collectInformation(AdvancedInformation information, Command lastCommand) {
	}

	@Override
	public void notifyUI() {
	}

	@Override
	public Widget mapExtraValues(SWTUIElement element, Widget result) {
		return mapWidget(element, result);
	}

	public static Widget mapWidget(SWTUIElement element, Widget result) {
		org.eclipse.swt.widgets.Widget widget = element.widget;
		if (widget instanceof Link) {
			Widget link = fillLink((org.eclipse.swt.widgets.Link) widget);
			if (link != null) {
				result = link;
			}
		} else if (widget instanceof AbstractHyperlink) {
			Widget hyperLink = fillHyperLink((AbstractHyperlink) widget);
			if (hyperLink != null) {
				result = hyperLink;
			}
		} else if (widget instanceof FormText) {
			Widget formText = fillFormText((FormText) widget);
			if (formText != null) {
				result = formText;
			}
		}
		return result;
	}

	private static Widget fillFormText(FormText widget) {
		org.eclipse.rcptt.tesla.core.ui.FormText formText = UiFactory.eINSTANCE
				.createFormText();
		SWTModelMapper.fillControl(formText, widget);

		String text = "";
		FormTextModel model = TeslaSWTAccess.getField(FormTextModel.class,
				widget, "model");
		if (model != null)
			text = model.getAccessibleText();

		formText.setText(text);
		return formText;
	}

	private static Widget fillHyperLink(AbstractHyperlink widget) {
		org.eclipse.rcptt.tesla.core.ui.Link label = UiFactory.eINSTANCE.createLink();
		label.setCaption(unify(widget.getText()));
		label.setToltip(unify(widget.getToolTipText()));
		SWTModelMapper.fillControl(label, widget);
		return label;
	}

	private static Widget fillLink(org.eclipse.swt.widgets.Link widget) {
		org.eclipse.rcptt.tesla.core.ui.Link label = UiFactory.eINSTANCE.createLink();
		label.setCaption(unify(widget.getText()));
		label.setToltip(unify(widget.getToolTipText()));
		SWTModelMapper.fillControl(label, widget);
		return label;
	}

	private static String unify(String value) {
		return PlayerTextUtils.unifyMultilines(value);
	}

	@Override
	public int getPriority() {
		return 300;
	}

}

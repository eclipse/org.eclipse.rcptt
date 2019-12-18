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
package org.eclipse.rcptt.tesla.core.protocol;

import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.rcptt.tesla.core.protocol.raw.Element;
import org.eclipse.rcptt.tesla.core.protocol.raw.Response;

public class BasicUIElement {

	protected final Element element;
	protected UIPlayer player;
	protected ProtocolFactory factory = ProtocolFactory.eINSTANCE;

	public BasicUIElement(Element e, UIPlayer player) {
		// eclipse 3.4 compatibility:
		// EcoreUtil.copy raise exception if argument is null
		this.element = (e != null) ? (Element) EcoreUtil.copy(e) : null;
		this.player = player;
	}

	public Element getElement() {
		return (element != null) ? (Element) EcoreUtil.copy(element) : null;
	}

	public boolean isWindow() {
		return element.getKind().equals(ElementKind.Window.name());
	}

	public void doAssert(AssertKind kind, String attribute, String expected)
			throws AssertionFailedError {
		doAssert(kind, attribute, null, expected, null);
	}

	public void doAssert(AssertKind kind, String attribute, Integer index,
			String expected) throws AssertionFailedError {
		doAssert(kind, attribute, index, expected, null);
	}

	public void doAssert(AssertKind kind, String attribute, String expected,
			String category) throws AssertionFailedError {
		doAssert(kind, attribute, null, expected, category);
	}

	public void doAssert(AssertKind kind, String attribute, Integer index,
			String expected, String category) throws AssertionFailedError {
		Assert assertCmd = factory.createAssert();
		assertCmd.setElement(getElement());
		assertCmd.setKind(kind);
		assertCmd.setIndex(index);
		assertCmd.setAttribute(attribute);
		assertCmd.setValue(expected);
		assertCmd.setCategory(category);
		Response response = player.safeExecuteCommand(assertCmd);
		if (response == null) {
			return;
		}
	}

	public void doContainsImageAssert(byte[] image) throws AssertionFailedError {
		Assert assertCmd = factory.createAssert();
		assertCmd.setElement(getElement());
		assertCmd.setKind(AssertKind.CONTAINS_IMAGE);
		AssertImageData imageData = factory.createAssertImageData();
		imageData.setImage(image);
		assertCmd.setImageData(imageData);
		Response response = player.safeExecuteCommand(assertCmd);
		if (response == null) {
			return;
		}
	}

	public String getRegionText(int x, int y, int sx, int sy, int width,
			int height) throws AssertionFailedError {
		GetRegionText cmd = factory.createGetRegionText();
		cmd.setElement(getElement());
		cmd.setX(x);
		cmd.setY(y);
		cmd.setSx(sx);
		cmd.setSy(sy);
		cmd.setWidth(width);
		cmd.setHeight(height);

		Response response = player.safeExecuteCommand(cmd);
		if (response instanceof GetTextResponse) {
			return ((GetTextResponse) response).getText();
		}
		return null;
	}
}

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
package org.eclipse.rcptt.tesla.gmf;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.draw2d.text.TextFlow;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Rectangle;

import org.eclipse.rcptt.tesla.core.ui.DiagramItem;
import org.eclipse.rcptt.tesla.core.ui.PropertyNodeList;
import org.eclipse.rcptt.tesla.core.ui.UiFactory;
import org.eclipse.rcptt.tesla.core.ui.Widget;
import org.eclipse.rcptt.tesla.gef.GefModelMapper;
import org.eclipse.rcptt.tesla.internal.ui.player.SWTUIPlayer;
import org.eclipse.rcptt.tesla.swt.reflection.EMFMembersHelper;

public class GMFModelMapper {

	public static Widget map(EditPart part, SWTUIPlayer player) {
		DiagramItem item = GefModelMapper.basicMap(part);
		if (item != null) {
			String partText = GefModelMapper.getText(part, TextFlow.class,
					org.eclipse.draw2d.Label.class, WrappingLabel.class);
			item.setText(partText);
		}

		Object model = getModel(part);
		if (model != null) {
			EMFMembersHelper
					.fillProperties(model, item.getModelPropertyNodes());
		}
		return item;
	}

	public static PropertyNodeList getPropertyNodes(EditPart part,
			String nodePath) throws IllegalArgumentException,
			IllegalAccessException, InvocationTargetException {
		Object model = getModel(part);
		if (model != null) {
			PropertyNodeList propertyNodeList = UiFactory.eINSTANCE
					.createPropertyNodeList();
			if (EMFMembersHelper.fillProperties(model, nodePath,
					propertyNodeList.getPropertyNodes())) {
				return propertyNodeList;
			}
		}
		return GefModelMapper.getAdvancedPropertyNodes(part, nodePath);
	}

	public static String getPropertyValue(EditPart part, String nodePath)
			throws IllegalArgumentException, IllegalAccessException,
			InvocationTargetException {
		Object model = getModel(part);
		if (model != null) {
			String properyValue = EMFMembersHelper.getPropertyValue(model,
					nodePath);
			if (properyValue != null) {
				return properyValue;
			}
			// Backward compatibility, from old versions property can be
			// recorded with "element" as root
			if (model instanceof View) {
				EObject eObject = ((View) model).getElement();
				if (eObject != null) {
					properyValue = EMFMembersHelper.getPropertyValue(eObject,
							nodePath);
					if (properyValue != null) {
						return properyValue;
					}
				}
			}
			// Backward compatibility, from old versions property can be
			// recorded with "view" prefix
			if (nodePath.startsWith("view.")) {
				properyValue = EMFMembersHelper.getPropertyValue(model,
						nodePath.replaceFirst("view\\.", ""));
				if (properyValue != null) {
					return properyValue;
				}
			}
		}
		return GefModelMapper.getAdvancedPropertyValue(part, nodePath);
	}

	public static boolean isGMFMapped(EditPart part) {
		return getModel(part) != null;
	}

	private static Object getModel(EditPart part) {
		if (part instanceof GraphicalEditPart) {
			GraphicalEditPart gpart = (GraphicalEditPart) part;
			Object model = gpart.getModel();
			if (model instanceof EObject) {
				return model;
			}
		}
		return null;
	}

	public static Rectangle getBounds(EditPart part) {
		if (part instanceof GraphicalEditPart) {
			org.eclipse.draw2d.geometry.Rectangle bounds = ((GraphicalEditPart) part)
					.getFigure().getBounds();
			return new Rectangle(bounds.x, bounds.y, bounds.width,
					bounds.height);
		}
		return null;
	}
}

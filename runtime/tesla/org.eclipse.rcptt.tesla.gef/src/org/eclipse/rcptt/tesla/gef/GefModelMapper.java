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
package org.eclipse.rcptt.tesla.gef;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.text.TextFlow;
import org.eclipse.emf.databinding.EObjectObservableValue;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.editparts.AbstractConnectionEditPart;
import org.eclipse.rcptt.tesla.core.ui.DiagramConnection;
import org.eclipse.rcptt.tesla.core.ui.DiagramItem;
import org.eclipse.rcptt.tesla.core.ui.PropertyNodeList;
import org.eclipse.rcptt.tesla.core.ui.UiFactory;
import org.eclipse.rcptt.tesla.core.ui.Widget;
import org.eclipse.rcptt.tesla.internal.core.TeslaCore;
import org.eclipse.rcptt.tesla.internal.ui.player.SWTModelMapper;
import org.eclipse.rcptt.tesla.internal.ui.player.SWTUIPlayer;
import org.eclipse.rcptt.tesla.swt.reflection.EMFMembersHelper;
import org.eclipse.rcptt.tesla.swt.reflection.JavaMembersHelper;
import org.eclipse.swt.graphics.Rectangle;

public class GefModelMapper {

	public static Widget map(EditPart part, SWTUIPlayer player) {
		DiagramItem item = basicMap(part);
		if (part instanceof AbstractConnectionEditPart) {
			fillConnectionProperies((AbstractConnectionEditPart) part,
					(DiagramConnection) item, player);
		}
		Object model = getModel(part);
		if (model != null) {
			EMFMembersHelper
					.fillProperties(model, item.getModelPropertyNodes());
		}
		return item;
	}

	public static DiagramItem basicMap(EditPart part) {
		DiagramItem item;
		if (part instanceof AbstractConnectionEditPart) {
			item = UiFactory.eINSTANCE.createDiagramConnection();
		} else {
			item = UiFactory.eINSTANCE.createDiagramItem();
		}
		if (part.getViewer().getSelectedEditParts().contains(part)) {
			item.setSelected(true);
		} else {
			item.setSelected(false);
		}
		Rectangle bounds = getBounds(part);
		if (bounds != null) {
			item.setX(bounds.x);
			item.setY(bounds.y);
			item.setWidth(bounds.width);
			item.setHeight(bounds.height);
			if (part instanceof GraphicalEditPart) {
				item.setBackgroundColor(SWTModelMapper
						.makeColor(((GraphicalEditPart) part).getFigure()
								.getBackgroundColor()));
				item.setForegroundColor(SWTModelMapper
						.makeColor(((GraphicalEditPart) part).getFigure()
								.getForegroundColor()));

			}
			item.setClassName(part.getClass().getName());
			item.setItemAddress(GefUtils.getAddress(part).toString());
		}
		List<?> children = part.getChildren();
		int count = 0;
		for (Object object : children) {
			if (object instanceof GraphicalEditPart) {
				IFigure figure = ((GraphicalEditPart) object).getFigure();
				if (figure.isShowing()) {
					count++;
				}
			}
		}
		String partText = getText(part, TextFlow.class,
				org.eclipse.draw2d.Label.class);
		item.setText(partText);
		item.setChildrenCount(count);
		addAdvancedProperies(part, item);
		return item;
	}

	public static DiagramItem figureMap(IFigure figure) {
		DiagramItem item = UiFactory.eINSTANCE.createDiagramItem();

		if (figure instanceof Label) {
			SWTModelMapper.fillImage(item, ((Label) figure).getIcon());
		}

		item.setText(getText(figure));
		item.setTooltip(getText(figure.getToolTip()));
		item.setClassName(figure.getClass().getName());
		item.setChildrenCount(figure.getChildren().size());
		org.eclipse.draw2d.geometry.Rectangle bounds = figure.getBounds();
		item.setX(bounds.x);
		item.setY(bounds.y);
		item.setWidth(bounds.width);
		item.setHeight(bounds.height);
		item.setBackgroundColor(SWTModelMapper.makeColor(figure
				.getBackgroundColor()));
		item.setForegroundColor(SWTModelMapper.makeColor(figure
				.getForegroundColor()));

		addAdvancedProperies(figure, item);

		return item;
	}

	private static Object getModel(EditPart part) {
		if (part instanceof GraphicalEditPart) {
			GraphicalEditPart gpart = (GraphicalEditPart) part;

			Object model = gpart.getModel();
			if (model instanceof EObject) {
				return model;
			} else if (model instanceof EObjectObservableValue) {
				return ((EObjectObservableValue) model).getObserved();
			}
		}
		return null;
	}

	private static void addAdvancedProperies(Object object, Widget widget) {
		try {
			JavaMembersHelper.fillProperties(object, widget.getPropertyNodes());
		} catch (Exception e) {
			TeslaCore.log(e);
		}
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
		PropertyNodeList propertyNodeList = UiFactory.eINSTANCE
				.createPropertyNodeList();
		if (JavaMembersHelper.fillProperties(part, nodePath,
				propertyNodeList.getPropertyNodes())) {
			return propertyNodeList;
		}
		return getAdvancedPropertyNodes(part, nodePath);
	}

	public static PropertyNodeList getPropertyNodes(IFigure figure,
			String nodePath) throws IllegalArgumentException,
			IllegalAccessException, InvocationTargetException {
		PropertyNodeList propertyNodeList = UiFactory.eINSTANCE
				.createPropertyNodeList();
		if (JavaMembersHelper.fillProperties(figure, nodePath,
				propertyNodeList.getPropertyNodes())) {
			return propertyNodeList;
		}
		return getAdvancedPropertyNodes(figure, nodePath);
	}

	public static PropertyNodeList getAdvancedPropertyNodes(Object object,
			String nodePath) throws IllegalArgumentException,
			IllegalAccessException, InvocationTargetException {
		PropertyNodeList propertyNodeList = UiFactory.eINSTANCE
				.createPropertyNodeList();
		if (JavaMembersHelper.fillProperties(object, nodePath,
				propertyNodeList.getPropertyNodes())) {
			return propertyNodeList;
		}
		return null;
	}

	public static String getPropertyValue(EditPart part, String nodePath)
			throws IllegalArgumentException, IllegalAccessException,
			InvocationTargetException {
		Object model = getModel(part);
		String value = null;
		if (model != null) {
			value = EMFMembersHelper.getPropertyValue(model, nodePath);
		}
		if (value == null) {
			return getAdvancedPropertyValue(part, nodePath);
		}
		return value;
	}

	public static String getPropertyValue(IFigure figure, String nodePath)
			throws IllegalArgumentException, IllegalAccessException,
			InvocationTargetException {
		return JavaMembersHelper.getPropertyValue(figure, nodePath);
	}

	public static String getAdvancedPropertyValue(Object object, String nodePath)
			throws IllegalArgumentException, IllegalAccessException,
			InvocationTargetException {
		return JavaMembersHelper.getPropertyValue(object, nodePath);
	}

	private static void fillConnectionProperies(
			AbstractConnectionEditPart connectionPart,
			DiagramConnection connectionItem, SWTUIPlayer player) {
		DiagramItem source = basicMap(connectionPart.getSource());
		connectionItem.setSource(source);
		DiagramItem target = basicMap(connectionPart.getTarget());
		connectionItem.setTarget(target);
	}

	public static String getText(EditPart part, Class<?>... classes) {
		StringBuilder builder = new StringBuilder();
		if (part instanceof GraphicalEditPart) {
			List<?> list = part.getChildren();
			List<IFigure> skips = new ArrayList<IFigure>();
			for (Object cPart : list) {
				if (cPart instanceof GraphicalEditPart) {
					skips.add(((GraphicalEditPart) cPart).getFigure());
				}
			}
			fillFigureText(((GraphicalEditPart) part).getFigure(), builder,
					skips);
			for (Object cPart : list) {
				if (cPart instanceof GraphicalEditPart) {
					IFigure figure = ((GraphicalEditPart) cPart).getFigure();
					if (figure.isVisible()) {
						for (Class<?> cl : classes) {
							if (cl.isInstance(figure)) {
								fillFigureText(figure, builder, null);
								break;
							}
						}
					}
				}
			}
		}
		return SWTModelMapper.unify(builder.toString().trim());
	}

	public static String getText(IFigure figure) {
		if (figure == null) {
			return "";
		}
		StringBuilder builder = new StringBuilder();
		fillFigureText(figure, builder, new ArrayList<IFigure>());
		return SWTModelMapper.unify(builder.toString().trim());
	}

	private static void fillFigureText(IFigure figure, StringBuilder builder,
			List<IFigure> skips) {
		if (figure.isVisible() && (skips == null || !skips.contains(figure))) {
			if (figure instanceof TextFlow) {
				builder.append(((TextFlow) figure).getText());
			}
			if (figure instanceof org.eclipse.draw2d.Label) {
				String labelText = ((org.eclipse.draw2d.Label) figure)
						.getText();

				builder.append(labelText);
			}
			List<?> list = figure.getChildren();
			boolean labelUsed = false;
			for (Object object : list) {
				int cur = builder.length();
				fillFigureText((IFigure) object, builder, skips);
				if (object instanceof Label) {
					if (cur != builder.length() && !labelUsed) {
						// Empty
						labelUsed = true;
					} else {
						builder.setLength(cur);
					}
				}
			}
		}
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

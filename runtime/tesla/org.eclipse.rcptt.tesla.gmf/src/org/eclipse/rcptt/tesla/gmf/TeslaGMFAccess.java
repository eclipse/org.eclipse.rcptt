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
package org.eclipse.rcptt.tesla.gmf;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.handles.AbstractHandle;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ConnectionHandleEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DiagramAssistantEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.PopupBarEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.tools.AbstractPopupBarTool;
import org.eclipse.gmf.runtime.diagram.ui.tools.PopupBarTool;

import org.eclipse.rcptt.tesla.internal.core.TeslaCore;

@SuppressWarnings("rawtypes")
public class TeslaGMFAccess {
	public static Object getField(Object t, Class<?> cl, String name) {
		try {
			Field field = cl.getDeclaredField(name);
			field.setAccessible(true);
			return field.get(t);
		} catch (Throwable e) {
			TeslaCore.log(e);
		}
		return null;
	}

	public static Object getHandlesField(DiagramAssistantEditPolicy editPolicy) {
		return getField(editPolicy, ConnectionHandleEditPolicy.class, "handles");
	}

	public static IFigure getBallonField(DiagramAssistantEditPolicy editPolicy) {
		return (IFigure) getField(editPolicy, PopupBarEditPolicy.class,
				"myBalloon");
	}

	public static EditPart getHost(PopupBarTool t) {
		return (EditPart) getField(t, AbstractPopupBarTool.class,
				"myHostEditPart");
	}

	public static List getHandles(EditPolicy editPolicy) {
		return (List) getField(editPolicy, ConnectionHandleEditPolicy.class,
				"handles");
	}

	@SuppressWarnings("restriction")
	public static Object getDelegatingDragPart(
			org.eclipse.gmf.runtime.gef.ui.internal.tools.DelegatingDragEditPartsTracker dragTracker) {
		return getField(dragTracker,
				org.eclipse.gmf.runtime.gef.ui.internal.tools.DelegatingDragEditPartsTracker.class,
				"delegateEditPart");
	}

	@SuppressWarnings("unchecked")
	static void showDiagramAssistanceOn(Point p, Object connectionPolicy,
			Class clazz) {
		try {
			Method method = clazz.getDeclaredMethod("showDiagramAssistant",
					Point.class);
			method.setAccessible(true);
			method.invoke(connectionPolicy, p);
		} catch (Throwable e) {
			TeslaCore.log(e);
		}
	}

	@SuppressWarnings({ "unchecked", "unused" })
	private static void hideDiagramAssistanceOn(Object connectionPolicy,
			Class clazz) {
		try {
			Method method = clazz.getDeclaredMethod("hideDiagramAssistant");
			method.setAccessible(true);
			method.invoke(connectionPolicy);
		} catch (Throwable e) {
			TeslaCore.log(e);
		}
	}

	public static EditPart getEditPart(AbstractHandle figure) {
		return (EditPart) getField(figure, AbstractHandle.class, "editpart");
	}
}

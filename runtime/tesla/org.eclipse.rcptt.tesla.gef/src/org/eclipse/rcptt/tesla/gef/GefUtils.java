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
package org.eclipse.rcptt.tesla.gef;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;

@SuppressWarnings("rawtypes")
public class GefUtils {
	public static List<Integer> getAddress(EditPart part) {
		return getAddressRaw(part);
	}

	public static List<Integer> getAddressRaw(EditPart part) {
		// Check for source/target edit part connections.
		if (part instanceof ConnectionEditPart) {
			ConnectionEditPart connection = (ConnectionEditPart) part;
			EditPart source = connection.getSource();
			if (source != null && source instanceof GraphicalEditPart) {
				List<Integer> sourceAddress = getAddressRaw(source);
				GraphicalEditPart sourcePart = (GraphicalEditPart) source;
				List list = sourcePart.getSourceConnections();
				int sourceIndex = list.indexOf(part);
				sourceAddress.add(0, sourceIndex);
				sourceAddress.add(0, -2);
				return sourceAddress;
			}
			EditPart target = connection.getTarget();
			if (target != null && target instanceof GraphicalEditPart) {
				List<Integer> targetAddress = getAddressRaw(target);
				GraphicalEditPart targetPart = (GraphicalEditPart) target;
				List list = targetPart.getTargetConnections();
				int targetIndex = list.indexOf(part);
				targetAddress.add(0, targetIndex);
				targetAddress.add(0, -3);
				return targetAddress;
			}
		}

		EditPart current = part;
		EditPart parent = current.getParent();
		List<Integer> address = new ArrayList<Integer>();
		while (parent != null) {
			List children = parent.getChildren();

			// Remove all invisible parts
			List realChildren = filterChildren(children);
			int indexOf = realChildren.indexOf(current);
			if (indexOf == -1) {
				// Check if current are connection part.
				if (current instanceof ConnectionEditPart) {
					List<Integer> connectionAddress = getAddressRaw(current);
					connectionAddress.add(-1);
					connectionAddress.addAll(address);
					return connectionAddress;
				}
				return null;
			}
			address.add(0, indexOf);
			current = parent;
			parent = parent.getParent();
		}
		return address;
	}

	private static List filterChildren(List children) {
		// TODO: Bug: QS-54
		return children;
		// List realChildren = new ArrayList();
		// for (Object object : children) {
		// if (object instanceof GraphicalEditPart) {
		// IFigure figure = ((GraphicalEditPart) object).getFigure();
		// if (!figure.isVisible()) {
		// continue;
		// }
		// }
		// realChildren.add(object);
		// }
		// return realChildren;
	}

	public static class FigureAddress {
		public List<Integer> path;
		public IFigure lastFigure;
	}

	public static List<Integer> getAddress(IFigure figure, IFigure stopAt) {
		List<Integer> address = new ArrayList<Integer>();
		if (figure == null) {
			return address;
		}
		while (figure.getParent() != null && !figure.equals(stopAt)) {
			IFigure parent = figure.getParent();
			List children = filterFigures(parent.getChildren());
			address.add(0, children.indexOf(figure));
			figure = parent;
		}
		return address;
	}

	public static FigureAddress getAddress(IFigure handle) {
		IFigure current = handle;
		IFigure parent = current.getParent();
		List<Integer> address = new ArrayList<Integer>();
		while (parent != null) {
			List children = parent.getChildren();
			children = filterFigures(children);
			int indexOf = children.indexOf(current);
			if (indexOf == -1) {
				return null;
			}
			address.add(0, indexOf);
			current = parent;
			parent = parent.getParent();
		}
		address.add(0, -1); // From Figure root
		FigureAddress fa = new FigureAddress();
		fa.path = address;
		fa.lastFigure = handle;
		return fa;

	}

	private static List filterFigures(List children) {
		// TODO: Bug: QS-54
		return children;
		// List result = new ArrayList();
		// for (Object object : children) {
		// if (object instanceof IFigure) {
		// if (!((IFigure) object).isVisible()) {
		// continue;
		// }
		// }
		// result.add(object);
		// }
		// return result;
	}
}

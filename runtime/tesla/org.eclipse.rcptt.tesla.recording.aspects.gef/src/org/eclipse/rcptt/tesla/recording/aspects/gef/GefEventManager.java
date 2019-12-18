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
package org.eclipse.rcptt.tesla.recording.aspects.gef;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.gef.EditDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.Request;
import org.eclipse.gef.Tool;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editparts.AbstractEditPart;
import org.eclipse.gef.tools.DirectEditManager;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.events.MouseEvent;

import org.eclipse.rcptt.tesla.gef.DirectEditorContainer;

public final class GefEventManager {
	private GefEventManager() {
	}

	private static Set<IGefEventListener> listeners = new HashSet<IGefEventListener>();

	public static void addListener(IGefEventListener listener) {
		listeners.add(listener);
	}

	public static void removeListener(IGefEventListener listener) {
		listeners.remove(listener);
	}

	public static void performRequst(EditPart part, Request request) {
		for (IGefEventListener listener : listeners) {
			listener.performRequest(part, request);
		}
	}

	public static void toolActivate(Tool tool) {
		for (IGefEventListener listener : listeners) {
			listener.toolActivate(tool);
		}
	}

	public static void setActiveTool(EditDomain domain, Tool tool) {
		for (IGefEventListener listener : listeners) {
			listener.setActiveTool(domain, tool);
		}

	}

	public static void notifyAddChild(AbstractEditPart part, EditPart child,
			int index) {
		for (IGefEventListener listener : listeners) {
			listener.notifyAddChild(part, child, index);
		}
	}
	public static void notifyRemoveChild(AbstractEditPart part, EditPart child,
			int index) {
		for (IGefEventListener listener : listeners) {
			listener.notifyRemoveChild(part, child, index);
		}
	}

	public static void mouseDown(EditDomain domain, MouseEvent mouseEvent,
			EditPartViewer viewer) {
		for (IGefEventListener listener : listeners) {
			listener.mouseDown(domain, mouseEvent, viewer);
		}

	}

	public static void afterMouseDown(EditDomain domain, MouseEvent mouseEvent,
			EditPartViewer viewer) {
		for (IGefEventListener listener : listeners) {
			listener.afterMouseDown(domain, mouseEvent, viewer);
		}
	}

	public static void mouseUp(EditDomain domain, MouseEvent mouseEvent,
			EditPartViewer viewer) {
		for (IGefEventListener listener : listeners) {
			listener.mouseUp(domain, mouseEvent, viewer);
		}
	}

	public static void afterMouseUp(EditDomain domain, MouseEvent mouseEvent,
			EditPartViewer viewer) {
		for (IGefEventListener listener : listeners) {
			listener.afterMouseUp(domain, mouseEvent, viewer);
		}

	}

	public static void mouseHover(EditDomain domain, MouseEvent mouseEvent,
			EditPartViewer viewer) {
		for (IGefEventListener listener : listeners) {
			listener.mouseHover(domain, mouseEvent, viewer);
		}
	}

	public static void mouseMove(EditDomain domain, MouseEvent mouseEvent,
			EditPartViewer viewer) {
		for (IGefEventListener listener : listeners) {
			listener.mouseMove(domain, mouseEvent, viewer);
		}
	}

	public static void mouseDrag(EditDomain domain, MouseEvent mouseEvent,
			EditPartViewer viewer) {
		for (IGefEventListener listener : listeners) {
			listener.mouseDrag(domain, mouseEvent, viewer);
		}

	}

	public static void mouseDoubleClick(EditDomain domain,
			MouseEvent mouseEvent, EditPartViewer viewer) {
		for (IGefEventListener listener : listeners) {
			listener.mouseDoubleClick(domain, mouseEvent, viewer);
		}

	}

	public static void mouseWheelScrolled(EditDomain domain,
			MouseEvent mouseEvent, EditPartViewer viewer) {
		for (IGefEventListener listener : listeners) {
			listener.mouseWheelScrolled(domain, mouseEvent, viewer);
		}
	}

	public static void executeCommand(Command command) {
		for (IGefEventListener listener : listeners) {
			listener.executeCommand(command);
		}
	}

	public static void nativeDragStarted(EditDomain domain,
			DragSourceEvent event, EditPartViewer viewer) {
		for (IGefEventListener listener : listeners) {
			listener.nativeDragStarted(domain, event, viewer);
		}
	}

	public static void nativeDragFinished(EditDomain domain,
			DragSourceEvent event, EditPartViewer viewer) {
		for (IGefEventListener listener : listeners) {
			listener.nativeDragFinished(domain, event, viewer);
		}
	}

	public static void recordCommitDirectEdit(DirectEditorContainer container) {
		for (IGefEventListener listener : listeners) {
			listener.commitDirectEdit(container);
		}
	}

	public static void recordCancelDirectEdit(DirectEditorContainer container) {
		for (IGefEventListener listener : listeners) {
			listener.cancelDirectEdit(container);
		}
	}

	public static void forceDirectEdit(DirectEditManager manager) {
		for(IGefEventListener listener: listeners) {
			listener.forceDirectEdit(manager);
		}
		
	}

	public static void handleDelayedDirectEdit(Object helper) {
		for(IGefEventListener listener: listeners) {
			listener.handleDelayedDirectEdit(helper);
		}
	}
}

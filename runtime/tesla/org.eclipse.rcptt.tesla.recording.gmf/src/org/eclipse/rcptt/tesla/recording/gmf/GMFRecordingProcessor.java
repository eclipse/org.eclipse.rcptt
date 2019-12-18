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
package org.eclipse.rcptt.tesla.recording.gmf;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.DragTracker;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Handle;
import org.eclipse.gef.handles.AbstractHandle;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.PopupBarEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.handles.CompartmentCollapseHandle;
import org.eclipse.gmf.runtime.diagram.ui.handles.ConnectionHandle;
import org.eclipse.gmf.runtime.diagram.ui.internal.handles.CompartmentResizeHandle;
import org.eclipse.gmf.runtime.diagram.ui.tools.PopupBarTool;
import org.eclipse.gmf.runtime.gef.ui.internal.tools.DelegatingDragEditPartsTracker;

import org.eclipse.rcptt.tesla.core.protocol.raw.SetMode;
import org.eclipse.rcptt.tesla.core.ui.PropertyNodeList;
import org.eclipse.rcptt.tesla.core.ui.Widget;
import org.eclipse.rcptt.tesla.gef.GefUtils;
import org.eclipse.rcptt.tesla.gef.GefUtils.FigureAddress;
import org.eclipse.rcptt.tesla.gmf.GMFModelMapper;
import org.eclipse.rcptt.tesla.gmf.GMFProcessor;
import org.eclipse.rcptt.tesla.gmf.TeslaGMFAccess;
import org.eclipse.rcptt.tesla.recording.aspects.gmf.GMFEventManager;
import org.eclipse.rcptt.tesla.recording.aspects.gmf.IGMFEventListener;
import org.eclipse.rcptt.tesla.recording.core.IRecordingHelper;
import org.eclipse.rcptt.tesla.recording.core.IRecordingProcessor;
import org.eclipse.rcptt.tesla.recording.core.TeslaRecorder;
import org.eclipse.rcptt.tesla.recording.core.gef.IGMFRecordingProcessor;
import org.eclipse.rcptt.tesla.recording.core.swt.SWTEventRecorder;

@SuppressWarnings("restriction")
public class GMFRecordingProcessor implements IRecordingProcessor,
		IGMFEventListener, IGMFRecordingProcessor {

	private TeslaRecorder recorder;

	public GMFRecordingProcessor() {
		GMFEventManager.addListener(this);
	}

	public void clear() {
	}

	public void initialize(TeslaRecorder teslaRecorder) {
		this.recorder = teslaRecorder;
	}

	public int getInitLevel() {
		return 2000;
	};

	public void setFreeze(boolean value, SetMode command) {
	}

	public List<Integer> getFigureAddress(IFigure resultFigure) {
		if (resultFigure instanceof Handle) {
			Handle h = (Handle) resultFigure;
			if (h.getDragTracker() instanceof PopupBarTool) {
				PopupBarTool t = (PopupBarTool) h.getDragTracker();
				EditPart editPart = getHost(t);
				PopupBarEditPolicy editPolicy = (PopupBarEditPolicy) editPart
						.getEditPolicy(EditPolicyRoles.POPUPBAR_ROLE);
				IFigure figure = getBalloon(editPolicy);
				List<Integer> address = GefUtils.getAddress(resultFigure,
						figure);
				address.add(0, -3);
				return address;
			}
		}
		return null;
	}

	private EditPart getHost(PopupBarTool t) {
		return TeslaGMFAccess.getHost(t);
	}

	private IFigure getBalloon(PopupBarEditPolicy t) {
		return TeslaGMFAccess.getBallonField(t);
	}

	@SuppressWarnings("rawtypes")
	public FigureAddress getHandleAddress(AbstractHandle handle) {
		if (handle instanceof ConnectionHandle) {
			ConnectionHandle ch = (ConnectionHandle) handle;
			GraphicalEditPart owner = ch.getOwner();
			EditPolicy editPolicy = owner
					.getEditPolicy(EditPolicyRoles.CONNECTION_HANDLES_ROLE);
			List list = getHandles(editPolicy);
			int index = list.indexOf(handle);
			if (index >= 0) {
				FigureAddress fa = new FigureAddress();
				fa.path = new ArrayList<Integer>();
				fa.lastFigure = handle;
				fa.path.add(-2);
				fa.path.add(index);
				return fa;
			}
		}
		// if (handle instanceof CompartmentResizeHandle) {
		// FigureAddress fa = new FigureAddress();
		// fa.path = new ArrayList<Integer>();
		// fa.path.add(-6);
		// fa.lastFigure = handle;
		// return fa;
		// }
		if (handle instanceof CompartmentCollapseHandle) {
			FigureAddress fa = new FigureAddress();
			fa.path = new ArrayList<Integer>();
			fa.path.add(-7);
			fa.lastFigure = handle;
			return fa;
		}
		return null;
	}

	@SuppressWarnings("rawtypes")
	private List getHandles(EditPolicy editPolicy) {
		return TeslaGMFAccess.getHandles(editPolicy);
	}

	public EditPart getEditPart(IFigure figure) {
		if (figure instanceof Handle) {
			Handle h = (Handle) figure;
			if (h.getDragTracker() instanceof PopupBarTool) {
				PopupBarTool t = (PopupBarTool) h.getDragTracker();
				EditPart editPart = getHost(t);
				return editPart;
			}
		}
		// if (figure instanceof CompartmentResizeHandle) {
		// return TeslaGMFAccess.getEditPart((AbstractHandle) figure);
		// }
		if (figure instanceof CompartmentCollapseHandle) {
			return TeslaGMFAccess.getEditPart((AbstractHandle) figure);
		}
		if (figure instanceof ConnectionHandle) {
			ConnectionHandle ch = (ConnectionHandle) figure;
			return ch.getOwner();
		}
		return null;
	}

	public void updateDragParts(Set<EditPart> dragPart, DragTracker dragTracker) {
		if (dragTracker instanceof DelegatingDragEditPartsTracker) {
			Object part = TeslaGMFAccess
					.getDelegatingDragPart((DelegatingDragEditPartsTracker) dragTracker);
			if (part != null) {
				dragPart.add((EditPart) part);
			}
		}
	}

	public Widget getModel(EditPart part) {
		return GMFModelMapper.map(part,
				recorder.getProcessor(SWTEventRecorder.class).getPlayer());
	}

	public boolean isGMFMapped(EditPart part) {
		return GMFModelMapper.isGMFMapped(part);
	}

	public PropertyNodeList getNodeProperties(EditPart part, String nodePath)
			throws IllegalArgumentException, IllegalAccessException,
			InvocationTargetException {
		return GMFModelMapper.getPropertyNodes(part, nodePath);
	}

	public boolean isIgnored(IFigure resultFigure) {
		// if (resultFigure instanceof CompartmentCollapseHandle) {
		// return true;
		// }
		if (resultFigure instanceof CompartmentResizeHandle) {
			return true;
		}
		return false;
	}

	public EObject getEMFMode(EditPart part) {
		return GMFProcessor.getGMFEMFModel(part);
	}

	public void resetAssertSelection() {
	}

	public IRecordingHelper<?> getHelper() {
		return null;
	}
}

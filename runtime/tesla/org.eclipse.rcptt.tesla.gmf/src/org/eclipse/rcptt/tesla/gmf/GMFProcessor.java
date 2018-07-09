/*******************************************************************************
 * Copyright (c) 2009, 2016 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.tesla.gmf;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.gef.DragTracker;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.handles.AbstractHandle;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ConnectionHandleEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DiagramAssistantEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.PopupBarEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.handles.CompartmentCollapseHandle;
import org.eclipse.gmf.runtime.diagram.ui.internal.handles.CompartmentResizeHandle;
import org.eclipse.gmf.runtime.gef.ui.internal.tools.DelegatingDragEditPartsTracker;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.rcptt.tesla.core.context.ContextManagement.Context;
import org.eclipse.rcptt.tesla.core.info.AdvancedInformation;
import org.eclipse.rcptt.tesla.core.info.Q7WaitInfoRoot;
import org.eclipse.rcptt.tesla.core.protocol.ElementKind;
import org.eclipse.rcptt.tesla.core.protocol.GetText;
import org.eclipse.rcptt.tesla.core.protocol.GetTextResponse;
import org.eclipse.rcptt.tesla.core.protocol.IElementProcessorMapper;
import org.eclipse.rcptt.tesla.core.protocol.ProtocolFactory;
import org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage;
import org.eclipse.rcptt.tesla.core.protocol.SelectCommand;
import org.eclipse.rcptt.tesla.core.protocol.SelectResponse;
import org.eclipse.rcptt.tesla.core.protocol.raw.Command;
import org.eclipse.rcptt.tesla.core.protocol.raw.Element;
import org.eclipse.rcptt.tesla.core.protocol.raw.Response;
import org.eclipse.rcptt.tesla.gef.FigureUIElement;
import org.eclipse.rcptt.tesla.gef.GefProcessor;
import org.eclipse.rcptt.tesla.gef.IGefReplayHelper;
import org.eclipse.rcptt.tesla.internal.core.AbstractTeslaClient;
import org.eclipse.rcptt.tesla.internal.core.processing.ElementGenerator;
import org.eclipse.rcptt.tesla.internal.core.processing.ITeslaCommandProcessor;
import org.eclipse.rcptt.tesla.internal.ui.processors.SWTUIProcessor;

@SuppressWarnings("restriction")
public class GMFProcessor implements ITeslaCommandProcessor, IGefReplayHelper {
	private final EClass[] commandsSupported = {
			// Protocol commands
			ProtocolPackage.Literals.GET_TEXT };
	private AbstractTeslaClient client;

	// private String id;

	public GMFProcessor() {
	}

	@Override
	public int getPriority() {
		return 225;
	}

	@Override
	public Response executeCommand(Command command,
			IElementProcessorMapper mapper) {
		EClass eClass = command.eClass();
		EPackage pkg = eClass.getEPackage();
		Response response = null;
		if (pkg.equals(ProtocolPackage.eINSTANCE)) {
			switch (eClass.getClassifierID()) {
			case ProtocolPackage.GET_TEXT:
				response = handleGetTextCommand((GetText) command);
				break;
			}
		}
		return response;
	}

	private Response handleGetTextCommand(GetText command) {
		GetTextResponse response = ProtocolFactory.eINSTANCE
				.createGetTextResponse();
		GefProcessor processor = client.getProcessor(GefProcessor.class);
		Element element = command.getElement();
		FigureUIElement figureUIElement = processor.getMapper().get(element);
		if (figureUIElement != null) {
			EditPart part = figureUIElement.getPart();
			if (part instanceof ITextAwareEditPart) {
				response.setText(((ITextAwareEditPart) part).getEditText());
				return response;
			}
		}
		return null;
	}

	@Override
	public String getFeatureID() {
		return "org.eclipse.rcptt.tesla.gmf";
	}

	@Override
	public void initialize(AbstractTeslaClient client, String id) {
		this.client = client;
		// this.id = id;
	}

	@Override
	public boolean isCommandSupported(Command cmd) {
		EClass ecl = cmd.eClass();
		for (EClass cl : commandsSupported) {
			if (cl.equals(ecl)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean isSelectorSupported(String kind) {
		return false;
	}

	@Override
	public PreExecuteStatus preExecute(Command command,
			PreExecuteStatus previousStatus, Q7WaitInfoRoot info) {
		return null;
	}

	@Override
	public SelectResponse select(SelectCommand cmd, ElementGenerator generator,
			IElementProcessorMapper mapper) {
		return null;
	}

	@Override
	public void postSelect(Element element, IElementProcessorMapper mapper) {
		if (element.getKind().equals(ElementKind.DiagramViewer.name())
				|| element.getKind().equals(ElementKind.PaletteViewer.name())) {
			// Map viewers to this issue. to support doDiagramAssist
			mapper.map(element, this);
		}
		GefProcessor processor = client.getProcessor(GefProcessor.class);
		if (element.getKind().equals(ElementKind.DiagramFigure.name())) {
			FigureUIElement figureUIElement = processor.getMapper()
					.get(element);
			if (figureUIElement != null
					&& figureUIElement.getPart() instanceof GraphicalEditPart) {
				GraphicalEditPart gep = (GraphicalEditPart) figureUIElement
						.getPart();
				String descr = element.getDescription();
				boolean modify = false;
				if (descr == null) {
					descr = "";
				}
				if (descr.indexOf("GMF(") == -1) {
					modify = true;
					descr += "GMF(model" + gep.resolveSemanticElement() + ")";
				}
				if (modify) {
					element.setDescription(descr);
				}
			}
			mapper.map(element, this);
		}
	}

	@Override
	public boolean isInactivityRequired() {
		return true;
	}

	@Override
	public boolean canProceed(Context context, Q7WaitInfoRoot info) {
		return true;
	}

	@Override
	public void clean() {
	}

	@Override
	public void terminate() {
		client = null;
	}

	@Override
	@SuppressWarnings("rawtypes")
	public IFigure getFigure(List<Integer> path,
			org.eclipse.gef.GraphicalEditPart part) {
		int kind = path.get(0).intValue();
		Rectangle bounds = part.getFigure().getBounds();
		Point p = new Point(bounds.x, bounds.y);
		switch (kind) {
		case -2: { // This is connection
			Job.getJobManager().wakeUp(
					ConnectionHandleEditPolicy.class.getName());
			DiagramAssistantEditPolicy editPolicy = (DiagramAssistantEditPolicy) part
					.getEditPolicy(EditPolicyRoles.CONNECTION_HANDLES_ROLE);
			List handles = (List) getHandlesField(editPolicy);
			if (handles == null) {
				TeslaGMFAccess.showDiagramAssistanceOn(p, editPolicy,
						ConnectionHandleEditPolicy.class);
				handles = (List) getHandlesField(editPolicy);
			}
			editPolicy.mouseExited(null);
			return (IFigure) handles.get(path.get(1));
		}
		case -3: {// This is popup
			Job.getJobManager().wakeUp(PopupBarEditPolicy.class.getName());
			DiagramAssistantEditPolicy editPolicy = (DiagramAssistantEditPolicy) part
					.getEditPolicy(EditPolicyRoles.POPUPBAR_ROLE);
			TeslaGMFAccess.showDiagramAssistanceOn(p, editPolicy,
					PopupBarEditPolicy.class);
			IFigure balloon = getBaloonField(editPolicy);
			List<Integer> list = path.subList(1, path.size());
			editPolicy.mouseExited(null);
			return getFigure(balloon, list);
		}
		case -6: {// This is resize
			AbstractHandle[] handles = findHandles(part);
			for (AbstractHandle abstractHandle : handles) {
				EditPart partHandle = TeslaGMFAccess
						.getEditPart(abstractHandle);
				if (part.equals(partHandle)
						&& abstractHandle instanceof CompartmentResizeHandle) {
					return abstractHandle;
				}
			}
			break;
		}
		case -7: // This is collapse
			AbstractHandle[] handles = findHandles(part);
			for (AbstractHandle abstractHandle : handles) {
				EditPart partHandle = TeslaGMFAccess
						.getEditPart(abstractHandle);
				if (part.equals(partHandle)
						&& abstractHandle instanceof CompartmentCollapseHandle) {
					return abstractHandle;
				}
			}
			break;
		}
		return null;
	}

	@SuppressWarnings("rawtypes")
	private AbstractHandle[] findHandles(org.eclipse.gef.GraphicalEditPart part) {
		IFigure rootFigure = ((FigureCanvas) part.getViewer().getControl())
				.getContents();
		List<AbstractHandle> handles = new ArrayList<AbstractHandle>();
		List children = rootFigure.getChildren();
		findHandlesLoop(handles, children);
		return handles.toArray(new AbstractHandle[handles
				.size()]);
	}

	@SuppressWarnings("rawtypes")
	private void findHandlesLoop(List<AbstractHandle> handles, List children) {
		for (Object object : children) {
			if (object instanceof IFigure) {
				List children2 = ((IFigure) object).getChildren();
				findHandlesLoop(handles, children2);
			}
			if (object instanceof AbstractHandle) {
				handles.add((AbstractHandle) object);
			}
		}
	}

	private IFigure getBaloonField(DiagramAssistantEditPolicy editPolicy) {
		return TeslaGMFAccess.getBallonField(editPolicy);
	}

	private Object getHandlesField(DiagramAssistantEditPolicy editPolicy) {
		return TeslaGMFAccess.getHandlesField(editPolicy);
	}

	@SuppressWarnings("rawtypes")
	private IFigure getFigure(IFigure parent, List<Integer> path) {
		IFigure te = parent;
		for (Integer integer : path) {
			List children = te.getChildren();
			if (children.size() <= integer.intValue()) {
				return null;
			}
			te = (IFigure) children.get(integer.intValue());
		}
		return te;
	}

	@Override
	public org.eclipse.rcptt.tesla.core.ui.Widget getModel(EditPart part) {
		return GMFModelMapper.map(part,
				client.getProcessor(SWTUIProcessor.class).getPlayer());
	}

	@Override
	public boolean isGMFMapped(EditPart part) {
		return GMFModelMapper.isGMFMapped(part);
	}

	@Override
	public String getPropertyValue(EditPart part, String nodePath)
			throws IllegalArgumentException, IllegalAccessException,
			InvocationTargetException {
		return GMFModelMapper.getPropertyValue(part, nodePath);
	}

	public boolean callMasterProcess(Context currentContext) {
		return false;
	}

	@Override
	public void checkHang() {
		// TODO Auto-generated method stub

	}

	@Override
	public void collectInformation(AdvancedInformation information,
			Command lastCommand) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateDragParts(Set<EditPart> dragParts, DragTracker dragTracker) {
		if (dragTracker instanceof DelegatingDragEditPartsTracker) {
			Object part = TeslaGMFAccess
					.getDelegatingDragPart((DelegatingDragEditPartsTracker) dragTracker);
			if (part != null) {
				dragParts.add((EditPart) part);
			}
		}
	}

	@Override
	public EObject getEMFMode(EditPart part) {
		return getGMFEMFModel(part);
	}

	public static EObject getGMFEMFModel(EditPart part) {
		if (part instanceof GraphicalEditPart) {
			GraphicalEditPart gpart = (GraphicalEditPart) part;
			Object model = gpart.getModel();
			if (model instanceof EObject) {
				EObject obj = (EObject) model;
				if (obj instanceof View) {
					EObject eObject = ((View) obj).getElement();
					if (eObject != null) {
						return eObject;
					}
				}
			}
		}
		return null;
	}

	@Override
	public void notifyUI() {
		// TODO Auto-generated method stub

	}
}

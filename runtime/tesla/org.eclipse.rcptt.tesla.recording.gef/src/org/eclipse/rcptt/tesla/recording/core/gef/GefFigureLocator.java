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
package org.eclipse.rcptt.tesla.recording.core.gef;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteEntry;
import org.eclipse.gef.ui.palette.PaletteViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Control;

import org.eclipse.rcptt.tesla.core.TeslaFeatures;
import org.eclipse.rcptt.tesla.core.protocol.CompositeUIElement;
import org.eclipse.rcptt.tesla.core.protocol.diagram.DiagramFeatures;
import org.eclipse.rcptt.tesla.core.protocol.diagram.DiagramViewerUIElement;
import org.eclipse.rcptt.tesla.core.protocol.diagram.FigureUIElement;
import org.eclipse.rcptt.tesla.core.ui.DiagramItem;
import org.eclipse.rcptt.tesla.core.ui.PropertyNodeList;
import org.eclipse.rcptt.tesla.core.ui.Widget;
import org.eclipse.rcptt.tesla.gef.GefModelMapper;
import org.eclipse.rcptt.tesla.gef.GefProcessor;
import org.eclipse.rcptt.tesla.gef.PropertySourceBasedModelMapper;
import org.eclipse.rcptt.tesla.gef.TeslaGefAccess;
import org.eclipse.rcptt.tesla.internal.ui.player.FindResult;
import org.eclipse.rcptt.tesla.internal.ui.player.PlayerWrapUtils;
import org.eclipse.rcptt.tesla.internal.ui.player.SWTModelMapper;
import org.eclipse.rcptt.tesla.internal.ui.player.SWTUIElement;
import org.eclipse.rcptt.tesla.internal.ui.player.SWTUIPlayer;
import org.eclipse.rcptt.tesla.internal.ui.player.TeslaSWTAccess;
import org.eclipse.rcptt.tesla.internal.ui.player.WorkbenchUIElement;
import org.eclipse.rcptt.tesla.recording.core.TeslaRecorder;
import org.eclipse.rcptt.tesla.recording.core.gef.GefRecordingHelper.GraphicalViewerEntry;
import org.eclipse.rcptt.tesla.recording.core.swt.BasicRecordingHelper.ElementEntry;
import org.eclipse.rcptt.tesla.recording.core.swt.SWTEventRecorder;

/**
 * Class for locating edit part.
 */
@SuppressWarnings("rawtypes")
public class GefFigureLocator {

	private final GefEventRecorder gefEventRecorder;

	public GefFigureLocator(GefEventRecorder gefRecorder) {
		this.gefEventRecorder = gefRecorder;
	}

	public GraphicalViewerEntry getDiagramUIElement(EditPartViewer viewer) {
		GraphicalViewerEntry entry = GefRecordingHelper
				.getGraphicalViewerEntries().get(viewer);
		SWTEventRecorder eventRecorder = gefEventRecorder.getEventRecorder();
		SWTUIPlayer player = eventRecorder.getPlayer();
		if (entry != null) {
			boolean change = gefEventRecorder.getEventRecorder().getLocator()
					.checkParentsTextFieldChange(entry.lowerParent, true);
			if (change) {
				GefRecordingHelper.getGraphicalViewerEntries().remove(viewer);
				entry = null;
			}
		}
		if (entry == null) {
			entry = new GraphicalViewerEntry();

			Control control = viewer.getControl();
			// if (!(control instanceof FigureCanvas)) {
			// // Ignore non figure canvas viewers
			// return null;
			// }
			SWTUIElement semanticParent = player.getParentElement(player
					.wrap(control));

			FindResult semanticParentElement = eventRecorder.getLocator()
					.findElement(semanticParent, false, false, true);

			if (semanticParent != null && semanticParentElement != null
					&& semanticParentElement.element != null) {
				CompositeUIElement parentElement = new CompositeUIElement(
						semanticParentElement.element,
						gefEventRecorder.getRecorder());
				DiagramViewerUIElement diagramViewer = null;
				ElementEntry element = GefRecordingHelper.getHelper().get(
						viewer);
				if (element != null) {
					diagramViewer = new DiagramViewerUIElement(
							element.getElement(),
							gefEventRecorder.getRecorder());
				} else {
					gefEventRecorder.getRecorder().setControls(
							SWTModelMapper
									.map(semanticParentElement.realElement));
					if (viewer instanceof PaletteViewer) {
						diagramViewer = parentElement.paletteViewer();
					} else {
						Integer index = null;
						SWTUIElement[] allCanvases = player.children.collectFor(
								semanticParent, null, true, FigureCanvas.class, Canvas.class);
						if (allCanvases != null) {
							int ind = 0;
							for (int i = 0; i < allCanvases.length; ++i) {
								org.eclipse.swt.widgets.Widget widget = (org.eclipse.swt.widgets.Widget) PlayerWrapUtils
										.unwrap(allCanvases[i]);
								if (!(widget instanceof FigureCanvas)) {
									GraphicalViewer vv = TeslaSWTAccess.getThis(GraphicalViewer.class, widget,
											SWT.Dispose);
									if (vv == null) {
										continue; // Skip this one
									}
								}
								if (widget == viewer
										.getControl()) {
									index = ind;
									break;
								}
								ind++;
							}
						}

						if (index == 0)
							index = null;
						diagramViewer = parentElement.diagramViewer(index);
					}
					if (diagramViewer != null) {
						GefRecordingHelper.getHelper().put(viewer,
								new ElementEntry(diagramViewer.getElement()));
					}
				}
				entry.diagramViewer = diagramViewer;
				entry.lowerParent = semanticParent;
				if (diagramViewer != null) {
					GefRecordingHelper.getGraphicalViewerEntries().put(viewer,
							entry);
				}
			}
		}
		if (entry.diagramViewer != null) {
			return entry;
		}
		return null;
	}

	public FigureUIElement find(EditPart part, EditPartViewer viewer,
			DiagramViewerUIElement diagramViewer, boolean fromAssert) {
		if (part == null) {
			return null;
		}
		if (viewer.getRootEditPart().equals(part)) {
			return diagramViewer;
		}
		EditPart parent = part.getParent();
		FigureUIElement parentPart = find(parent, viewer, diagramViewer,
				fromAssert);
		List<?> children = parent.getChildren();
		int index = children.indexOf(part);

		ElementEntry el = GefRecordingHelper.getHelper().get(part);
		TeslaRecorder recorder = gefEventRecorder.getRecorder();
		if (el != null) {
			// TODO: Add check for figure changes.
			ElementEntry newElement = findElement((GraphicalEditPart) part,
					children, parentPart, index, false, viewer, diagramViewer,
					fromAssert);
			if (newElement != null && !newElement.matchAttributes(el)) {
				// Attributes are same
				el = null;
				// Remove all possible children
				GefRecordingHelper.getHelper().remove(part);
				GefRecordingHelper.getHelper().clearAllWithParent(part);

			} else if (!fromAssert) {
				return new FigureUIElement(el.getElement(), recorder);
			}
		}
		mapModel(part, viewer, recorder, true);
		ElementEntry elementEntry = findElement((GraphicalEditPart) part,
				children, parentPart, index, true, viewer, diagramViewer,
				fromAssert);

		GefRecordingHelper.getHelper().put(part, elementEntry);
		return new FigureUIElement(elementEntry.getElement(),
				gefEventRecorder.getRecorder());
	}

	private ElementEntry findElement(GraphicalEditPart part, List<?> children,
			FigureUIElement parentPart, int index, boolean needCreateElement,
			EditPartViewer viewer, DiagramViewerUIElement diagramViewer,
			boolean fromAssert) {
		FigureUIElement element = null;
		ElementEntry result = null;

		if (TeslaFeatures.getInstance().isTrue(
				DiagramFeatures.STORE_PALETTE_AS_NAME)) {
			// eclipse 3.4 support: PaletteEditPart in different packages
			if (TeslaGefAccess.isPalleteEditPart(part)) {
				Object model = part.getModel();
				if (model != null && model instanceof PaletteEntry) {
					PaletteEntry entry = (PaletteEntry) model;
					String label = entry.getLabel();
					Integer indexPos = label == null ? null
							: calculatePaletteEntryIndex(label, entry);
					if (needCreateElement) {
						if (indexPos == null) {
							element = diagramViewer.paletteEntry(label);
						} else {
							element = diagramViewer.paletteEntry(label,
									indexPos.intValue());
						}
					} else {
						element = new FigureUIElement(null, null);
					}
					result = new ElementEntry(element.getElement());
					result.set("name", label);
				}
			}
		}
		if (element == null) {
			if (part instanceof ConnectionEditPart) {
				ConnectionEditPart connection = (ConnectionEditPart) part;
				EditPart source = connection.getSource();
				if (source != null && source instanceof GraphicalEditPart) {
					GraphicalEditPart sourcePart = (GraphicalEditPart) source;
					FigureUIElement sourceElement = find(sourcePart, viewer,
							diagramViewer, fromAssert);
					List list = sourcePart.getSourceConnections();
					int sourceIndex = list.indexOf(part);
					if (needCreateElement) {
						mapModel(part, viewer, gefEventRecorder.getRecorder(),
								true);
						element = sourceElement
								.figureSourceConnection(sourceIndex);
					} else {
						element = new FigureUIElement(null, null);
					}
					result = new ElementEntry(element.getElement());
					result.set("index", sourceIndex);
				}
				EditPart target = connection.getTarget();
				if (target != null && target instanceof GraphicalEditPart) {
					GraphicalEditPart targetPart = (GraphicalEditPart) target;
					FigureUIElement targetElement = find(targetPart, viewer,
							diagramViewer, fromAssert);

					List list = targetPart.getTargetConnections();
					int targetIndex = list.indexOf(part);
					if (needCreateElement) {
						mapModel(part, viewer, gefEventRecorder.getRecorder(),
								true);
						element = targetElement
								.figureTargetConnection(targetIndex);
					} else {
						element = new FigureUIElement(null, null);
					}
					result = new ElementEntry(element.getElement());
					result.set("index", targetIndex);
				}
			}
		}
		if (element == null) {
			if (TeslaFeatures.getInstance().isTrue(
					DiagramFeatures.PART_LOCATOR_USE_FEATURE_NAME_IDENTITY)
					|| TeslaFeatures.getInstance().isTrue(
							DiagramFeatures.PART_LOCATOR_USE_FEATURE_IDENTITY)) {
				List<String> ids = new ArrayList<String>();
				String[] identity = TeslaFeatures
						.getInstance()
						.getValue(
								DiagramFeatures.PART_LOCATOR_USE_FEATURE_IDENTITY_NAMES)
						.split(",");
				for (String s : identity) {
					if (!ids.contains(s)) {
						ids.add(s);
					}
				}
				EObject modelObject = getModelObject(part);
				if (modelObject != null) {
					// Check for other children not contain same model object
					if (checkChildrenNotContain(children, part, modelObject)) {
						EClass eClass = modelObject.eClass();
						EList<EAttribute> attributes = eClass
								.getEAllAttributes();
						for (EAttribute eAttribute : attributes) {
							if (TeslaFeatures
									.getInstance()
									.isTrue(DiagramFeatures.PART_LOCATOR_USE_FEATURE_NAME_IDENTITY)) {
								if (eAttribute.getName().equalsIgnoreCase(
										"name")) {
									Object value = modelObject.eGet(eAttribute);
									if (value != null
											&& value instanceof String) {
										Integer indexValue = getEMFFeatureIndex(
												part, children, (String) value,
												eAttribute.getName());
										if (needCreateElement) {
											element = parentPart.figureByName(
													(String) value, indexValue);
										} else {
											element = new FigureUIElement(null,
													null);
										}
										result = new ElementEntry(
												element.getElement());
										result.set("emf.name", value);
										break;
									}
								}
							}
							if (TeslaFeatures
									.getInstance()
									.isTrue(DiagramFeatures.PART_LOCATOR_USE_FEATURE_IDENTITY)) {
								if (ids.contains(eAttribute.getName())) {
									Object value = modelObject.eGet(eAttribute);
									if (value != null
											&& value instanceof String) {
										Integer indexValue = getEMFFeatureIndex(
												part, children, (String) value,
												eAttribute.getName());
										if (needCreateElement) {
											element = parentPart
													.figureByFeature(eAttribute
															.getName(),
															(String) value,
															indexValue);
										} else {
											element = new FigureUIElement(null,
													null);
										}
										result = new ElementEntry(
												element.getElement());
										result.set("feature.name",
												eAttribute.getName());
										result.set("feature.value", value);
										break;
									}
								}
							}
						}
					}
				}
			}
		}
		if (element == null
				&& TeslaFeatures.getInstance().isTrue(
						DiagramFeatures.PART_LOCATOR_USE_TEXT_IDENTITY)) {
			if (!viewer.getRootEditPart().equals(part)
					&& !viewer.getContents().equals(part)) {
				Widget first = mapModel(part, viewer,
						gefEventRecorder.getRecorder(), false);
				String text = GefProcessor.getPartText(first);
				if (text != null) {
					Integer partIndex = calcPartTextIndex(part, text);
					if (needCreateElement) {
						element = parentPart.figureByText(text, partIndex);
					} else {
						element = new FigureUIElement(null, null);
					}
					result = new ElementEntry(element.getElement());
					result.set("text", text);
				}
			}
		}
		if (element == null) {
			String method = TeslaFeatures.getInstance().getValue(
					DiagramFeatures.PART_LOCATOR_USE_IDENTITY);
			switch (DiagramFeatures.PartIdentity.valueOf(method)) {
			case Address:
				break;// Will be used by default
			case ClassName: {
				String className = getPartClassName(part);
				Integer partIndex = calcPartClassNameIndex(part, className);
				if (needCreateElement) {
					element = parentPart
							.figureByClassName(className, partIndex);
				} else {
					element = new FigureUIElement(null, null);
				}
				result = new ElementEntry(element.getElement());
				result.set("classname", className);
				break;
			}
			}
		}
		if (element == null) {
			if (needCreateElement) {
				element = parentPart.figure(index);
			} else {
				element = new FigureUIElement(null, null);
			}
			result = new ElementEntry(element.getElement());
			result.set("index", Integer.toString(index));
		}
		return result;
	}

	private Integer calculatePaletteEntryIndex(String label, PaletteEntry entry) {
		PaletteEntry parent = entry;
		PaletteEntry pp = parent.getParent();
		while (pp != null) {
			parent = pp;
			pp = pp.getParent();
		}
		if (!(parent instanceof PaletteContainer)) {
			return null;
		}
		List<PaletteEntry> entries = new ArrayList<PaletteEntry>();
		GefProcessor.fillPaletteEntries(entries, (PaletteContainer) parent);
		int index = 0;
		String entryLabel = entry.getLabel();
		for (PaletteEntry paletteEntry : entries) {
			if (paletteEntry.equals(entry)) {
				return index == 0 ? null : Integer.valueOf(index);
			}
			String eLabel = paletteEntry.getLabel();
			if (eLabel.equals(entryLabel)) {
				index++;
			}
		}
		return null;
	}

	private Integer getEMFFeatureIndex(EditPart part, List<?> children,
			String recordedName, String name) {
		int index = 0;
		for (Object object : children) {
			if (part.equals(object)) {
				break;
			}
			if (object instanceof EditPart) {
				EObject modelObject = getModelObject((EditPart) object);
				if (modelObject != null) {
					String oName = GefProcessor.getPartEMFName(modelObject,
							name, false);
					if (recordedName.equals(oName)) {
						index++;
					}
				}
			}
		}
		return index == 0 ? null : index;
	}

	private Integer calcPartClassNameIndex(EditPart part, String className) {
		EditPart parent = part.getParent();
		List children = parent.getChildren();
		int index = 0;
		for (Object object : children) {
			if (part.equals(object)) {
				break;
			}
			if (object instanceof EditPart) {
				String partName = getPartClassName((EditPart) object);
				if (partName.equals(className)) {
					index++;
				}
			}
		}
		return index == 0 ? null : Integer.valueOf(index);
	}

	private Integer calcPartTextIndex(EditPart part, String textValue) {
		EditPart parent = part.getParent();
		List children = parent.getChildren();
		int index = 0;
		for (Object object : children) {
			if (part.equals(object)) {
				// While search, we use mapModel, that set current iterated
				// control for recorder.
				// Now need to call mapModel to restore correct control in
				// recorder
				mapModel((EditPart) object, part.getViewer(),
						gefEventRecorder.getRecorder(), false);
				break;
			}
			if (object instanceof EditPart) {
				Widget objectModel = mapModel((EditPart) object,
						part.getViewer(), gefEventRecorder.getRecorder(), false);
				String partName = GefProcessor.getPartText(objectModel);
				if (partName != null && partName.equals(textValue)) {
					index++;
				}
			}
		}
		return index == 0 ? null : Integer.valueOf(index);
	}

	private String getPartClassName(EditPart part) {
		return GefProcessor.getPartClassName(part);
	}

	private boolean checkChildrenNotContain(List children, EditPart part,
			EObject modelObject) {
		for (Object o : children) {
			if (o instanceof EditPart && !part.equals(o)) {
				EObject eObject = getModelObject((EditPart) o);
				if (modelObject.equals(eObject)) {
					return false;
				}
			}
		}
		return true;
	}

	private EObject getModelObject(EditPart part) {
		IGMFRecordingProcessor[] helpers = gefEventRecorder.getHelpers();
		Object model = part.getModel();
		EObject modelObject = null;
		if (model != null && model instanceof EObject) {
			modelObject = (EObject) model;
		}
		for (IGMFRecordingProcessor helper : helpers) {
			EObject emfModel = helper.getEMFMode(part);
			if (emfModel != null) {
				modelObject = emfModel;
			}
		}
		return modelObject;
	}

	@SuppressWarnings("unused")
	private FigureUIElement findConnectionPart(ConnectionEditPart part,
			EditPartViewer viewer, DiagramViewerUIElement diagramViewer,
			TeslaRecorder recorder) {
		ConnectionEditPart connection = part;
		EditPart source = connection.getSource();
		if (source != null && source instanceof GraphicalEditPart) {
			GraphicalEditPart sourcePart = (GraphicalEditPart) source;
			FigureUIElement sourceElement = find(sourcePart, viewer,
					diagramViewer, false);
			List list = sourcePart.getSourceConnections();
			int sourceIndex = list.indexOf(part);
			mapModel(part, viewer, recorder, true);
			FigureUIElement figureSourceConnection = sourceElement
					.figureSourceConnection(sourceIndex);
			ElementEntry elementEntry = new ElementEntry(
					figureSourceConnection.getElement());
			GefRecordingHelper.getHelper().put(part, elementEntry);
			return figureSourceConnection;
		}
		EditPart target = connection.getTarget();
		if (target != null && target instanceof GraphicalEditPart) {
			GraphicalEditPart targetPart = (GraphicalEditPart) target;
			FigureUIElement targetElement = find(targetPart, viewer,
					diagramViewer, false);

			List list = targetPart.getTargetConnections();
			int targetIndex = list.indexOf(part);
			mapModel(part, viewer, recorder, true);
			FigureUIElement figureTargetConnection = targetElement
					.figureTargetConnection(targetIndex);
			ElementEntry elementEntry = new ElementEntry(
					figureTargetConnection.getElement());
			GefRecordingHelper.getHelper().put(part, elementEntry);
			return figureTargetConnection;
		}
		return null;
	}

	private org.eclipse.rcptt.tesla.core.ui.Widget mapModel(EditPart part,
			EditPartViewer viewer, TeslaRecorder recorder,
			boolean updateRecorder) {
		org.eclipse.rcptt.tesla.core.ui.Widget model = null;
		List<IGMFRecordingProcessor> processors = recorder
				.getProcessors(IGMFRecordingProcessor.class);
		SWTUIPlayer player = gefEventRecorder.getEventRecorder().getPlayer();
		SWTUIElement semanticParent = player.getParentElement(player
				.wrap(viewer.getControl()));

		if (semanticParent instanceof WorkbenchUIElement) {
			DiagramItem map = GefModelMapper.basicMap(part);

			if (PropertySourceBasedModelMapper.map(
					((WorkbenchUIElement) semanticParent).reference
							.getPart(true), part, map)) {
				model = map;
			}
		}

		if (model == null) {
			for (IGMFRecordingProcessor helper : processors) {
				model = helper.getModel(part);
			}
		}
		if (model == null) {
			model = GefModelMapper.map(part,
					recorder.getProcessor(SWTEventRecorder.class).getPlayer());
		}
		recorder.setControls(model);
		return model;
	}

	public PropertyNodeList getNodeProperties(EditPart part, String nodePath)
			throws IllegalArgumentException, IllegalAccessException,
			InvocationTargetException {
		EditPartViewer viewer = part.getViewer();
		SWTUIPlayer player = gefEventRecorder.getEventRecorder().getPlayer();
		SWTUIElement semanticParent = player.getParentElement(player
				.wrap(viewer.getControl()));
		if (semanticParent instanceof WorkbenchUIElement) {
			if (PropertySourceBasedModelMapper.isPropertyBasedMapped(
					((WorkbenchUIElement) semanticParent).reference
							.getPart(true), part)) {
				PropertyNodeList nodeList = PropertySourceBasedModelMapper
						.getPropertyNodes(
								((WorkbenchUIElement) semanticParent).reference
										.getPart(true), part, nodePath);
				if (nodeList != null) {
					return nodeList;
				}
			}
		}

		List<IGMFRecordingProcessor> processors = TeslaRecorder.getInstance()
				.getProcessors(IGMFRecordingProcessor.class);
		for (IGMFRecordingProcessor helper : processors) {
			if (helper.isGMFMapped(part)) {
				return helper.getNodeProperties(part, nodePath);
			}
		}

		return GefModelMapper.getPropertyNodes(part, nodePath);
	}
}

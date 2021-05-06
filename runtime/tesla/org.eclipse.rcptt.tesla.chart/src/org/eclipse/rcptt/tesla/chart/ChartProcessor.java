/*******************************************************************************
 * Copyright (c) 2009, 2021 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.tesla.chart;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.rcptt.tesla.core.context.ContextManagement.Context;
import org.eclipse.rcptt.tesla.core.info.AdvancedInformation;
import org.eclipse.rcptt.tesla.core.info.Q7WaitInfoRoot;
import org.eclipse.rcptt.tesla.core.protocol.ElementKind;
import org.eclipse.rcptt.tesla.core.protocol.GenericElementKind;
import org.eclipse.rcptt.tesla.core.protocol.IElementProcessorMapper;
import org.eclipse.rcptt.tesla.core.protocol.ProtocolFactory;
import org.eclipse.rcptt.tesla.core.protocol.SelectCommand;
import org.eclipse.rcptt.tesla.core.protocol.SelectData;
import org.eclipse.rcptt.tesla.core.protocol.SelectResponse;
import org.eclipse.rcptt.tesla.core.protocol.raw.Command;
import org.eclipse.rcptt.tesla.core.protocol.raw.Element;
import org.eclipse.rcptt.tesla.core.protocol.raw.Response;
import org.eclipse.rcptt.tesla.internal.core.AbstractTeslaClient;
import org.eclipse.rcptt.tesla.internal.core.processing.ElementGenerator;
import org.eclipse.rcptt.tesla.internal.core.processing.ITeslaCommandProcessor;
import org.eclipse.rcptt.tesla.internal.ui.SWTElementMapper;
import org.eclipse.rcptt.tesla.internal.ui.player.AbstractSWTUIPlayerExtension;
import org.eclipse.rcptt.tesla.internal.ui.player.ISWTUIPlayerExtension;
import org.eclipse.rcptt.tesla.internal.ui.player.PlayerSelectionFilter;
import org.eclipse.rcptt.tesla.internal.ui.player.SWTUIElement;
import org.eclipse.rcptt.tesla.internal.ui.player.SWTUIPlayer;
import org.eclipse.rcptt.tesla.internal.ui.processors.IModelMapperHelper;
import org.eclipse.rcptt.tesla.internal.ui.processors.SWTUIProcessor;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swtchart.Chart;

public class ChartProcessor implements ITeslaCommandProcessor, IModelMapperHelper {
	private static final ElementKind[] allSelectors = {
			ElementKind.DiagramFigure, ElementKind.Menu
	};

	private SWTUIProcessor swtUIProcessor;

	private ISWTUIPlayerExtension extension = new AbstractSWTUIPlayerExtension() {
		@Override
		public GenericElementKind getKind(Object w) {
			return (w instanceof Chart) ? new GenericElementKind(ElementKind.DiagramFigure) : null;
		}

		@Override
		public SWTUIElement select(SWTUIPlayer swtuiPlayer, PlayerSelectionFilter f) {
			if (f.kind.is(ElementKind.DiagramFigure)) {
				return swtuiPlayer.selectWidget(f, Chart.class);
			}
			return null;
		}
	};

	public ChartProcessor() {
		SWTUIPlayer.addExtension(extension);
	}

	@Override
	public EObject getElementModel(Element element) {
		SWTUIElement swtuiElement = getMapper().get(element);
		if (swtuiElement != null) {
			return swtuiElement.getModel();
		}
		return null;
	}

	@Override
	public int getPriority() {
		return 30;
	}

	@Override
	public String getFeatureID() {
		return "org.eclipse.rcptt.tesla.swt.chart";
	}

	@Override
	public boolean isSelectorSupported(String kind) {
		for (final ElementKind e : allSelectors) {
			if (e.name().equals(kind)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public SelectResponse select(SelectCommand cmd, ElementGenerator generator, IElementProcessorMapper mapper) {
		final SelectData data = cmd.getData();
		SWTUIElement parent = getMapper().get(data.getParent());
		final SWTUIElement after = getMapper().get(data.getAfter());
		if (parent == null && after != null) {
			parent = getPlayer().getParentElement(after);
		}
		SWTUIElement result = null;
		if (data.getKind().equals(ElementKind.Menu.name())) {
			if (parent.widget != null && parent.getKind().name().equals(ElementKind.DiagramFigure.name())) {
				Chart chart = (Chart) parent.widget;
				if (chart.getMenu() != null) {
					SWTUIElement element = new SWTUIElement(chart, parent.getPlayer());
					result = selectElement(element, data);
				}
				if (result == null) {
					Control control = chart.getPlotArea().getControl();
					SWTUIElement element = new SWTUIElement(control, parent.getPlayer());
					result = selectElement(element, data);
				}
			} else {
				return null;
			}
		} else {
			result = selectElement(parent, data);
		}

		SelectResponse response = ProtocolFactory.eINSTANCE
				.createSelectResponse();

		if (result != null) {
			response.getElements().add(getMapper().get(result));
		}
		else {
			return null;
		}
		return response;
	}

	@Override
	public boolean isCommandSupported(Command cmd) {
		return false;
	}

	@Override
	public Response executeCommand(Command command, IElementProcessorMapper mapper) {
		return swtUIProcessor.executeCommand(command, mapper);
	}

	@Override
	public PreExecuteStatus preExecute(Command command, PreExecuteStatus previousStatus, Q7WaitInfoRoot info) {
		return null;
	}

	@Override
	public void initialize(AbstractTeslaClient client, String id) {
		swtUIProcessor = client.getProcessor(SWTUIProcessor.class);
	}

	@Override
	public void postSelect(Element element, IElementProcessorMapper mapper) {
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
		SWTUIPlayer.removeExtension(extension);
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

	private synchronized SWTUIPlayer getPlayer() {
		return swtUIProcessor.getPlayer();
	}

	private SWTElementMapper getMapper() {
		return swtUIProcessor.getMapper();
	}

	private SWTUIElement selectElement(SWTUIElement parent, SelectData data) {
		final SWTUIElement after = getMapper().get(data.getAfter());
		final EList<String> path = data.getPath();
		String[] pathArray = null;
		if (path.size() > 0) {
			pathArray = path.toArray(new String[path.size()]);
		}
		EList<Integer> indexes = data.getIndexes();
		PlayerSelectionFilter filter = new PlayerSelectionFilter(parent, GenericElementKind
				.fromString(data.getKind()), data.getPattern(),
				pathArray, data.getIndex(), after,
				indexes.toArray(new Integer[data.getIndexes().size()]),
				data.getClassPattern());
		return getPlayer().select(filter);
	}

}

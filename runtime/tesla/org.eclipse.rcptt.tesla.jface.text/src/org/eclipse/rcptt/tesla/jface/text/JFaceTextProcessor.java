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
package org.eclipse.rcptt.tesla.jface.text;

import java.lang.Thread.State;
import java.lang.reflect.Field;
import java.util.List;
import java.util.WeakHashMap;

import org.eclipse.jface.text.reconciler.AbstractReconciler;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Widget;

import org.eclipse.rcptt.tesla.core.Q7WaitUtils;
import org.eclipse.rcptt.tesla.core.TeslaLimits;
import org.eclipse.rcptt.tesla.core.TeslaMessages;
import org.eclipse.rcptt.tesla.core.context.ContextManagement.Context;
import org.eclipse.rcptt.tesla.core.info.AdvancedInformation;
import org.eclipse.rcptt.tesla.core.info.Q7WaitInfoRoot;
import org.eclipse.rcptt.tesla.core.protocol.BooleanResponse;
import org.eclipse.rcptt.tesla.core.protocol.ElementKind;
import org.eclipse.rcptt.tesla.core.protocol.IElementProcessorMapper;
import org.eclipse.rcptt.tesla.core.protocol.ProtocolFactory;
import org.eclipse.rcptt.tesla.core.protocol.SelectCommand;
import org.eclipse.rcptt.tesla.core.protocol.SelectResponse;
import org.eclipse.rcptt.tesla.core.protocol.ShowContentAssist;
import org.eclipse.rcptt.tesla.core.protocol.raw.Command;
import org.eclipse.rcptt.tesla.core.protocol.raw.Element;
import org.eclipse.rcptt.tesla.core.protocol.raw.Response;
import org.eclipse.rcptt.tesla.core.protocol.raw.ResponseStatus;
import org.eclipse.rcptt.tesla.internal.core.AbstractTeslaClient;
import org.eclipse.rcptt.tesla.internal.core.TeslaCore;
import org.eclipse.rcptt.tesla.internal.core.processing.ElementGenerator;
import org.eclipse.rcptt.tesla.internal.core.processing.ITeslaCommandProcessor;
import org.eclipse.rcptt.tesla.internal.ui.player.PlayerWrapUtils;
import org.eclipse.rcptt.tesla.internal.ui.player.SWTUIElement;
import org.eclipse.rcptt.tesla.internal.ui.player.TeslaSWTAccess;
import org.eclipse.rcptt.tesla.internal.ui.processors.SWTUIProcessor;
import org.eclipse.rcptt.tesla.jface.TextReconcilerManager;

public class JFaceTextProcessor implements ITeslaCommandProcessor {

	private AbstractTeslaClient client;

	private WeakHashMap<AbstractReconciler, Long> reconcilerTimeours = new WeakHashMap<AbstractReconciler, Long>();

	// private String id;

	public JFaceTextProcessor() {
	}

	public String getFeatureID() {
		return "jface.text";
	}

	public boolean isSelectorSupported(String kind) {
		return false;
	}

	public SelectResponse select(SelectCommand cmd, ElementGenerator generator,
			IElementProcessorMapper mapper) {
		return null;
	}

	public boolean isCommandSupported(Command cmd) {
		if (cmd instanceof ShowContentAssist) {
			return true;
		}
		return false;
	}

	public Response executeCommand(Command command,
			IElementProcessorMapper mapper) {
		if (command instanceof ShowContentAssist) {
			return handleShowContentAssist((ShowContentAssist) command);
		}
		return null;
	}

	private Response handleShowContentAssist(ShowContentAssist command) {
		SWTUIElement swtuiElement = getSWTProcessor().getMapper().get(
				command.getElement());
		BooleanResponse response = ProtocolFactory.eINSTANCE
				.createBooleanResponse();
		if (swtuiElement != null) {
			Widget widget = PlayerWrapUtils.unwrapWidget(swtuiElement);
			if (widget instanceof StyledText) {
				Viewer thisControl = TeslaSWTAccess
						.getViewer((StyledText) widget);
				if (thisControl != null && thisControl instanceof SourceViewer) {
					SourceViewer textViewer = (SourceViewer) thisControl;
					textViewer
							.doOperation(ISourceViewer.CONTENTASSIST_PROPOSALS);
				}
			}
		} else {
			response.setMessage(TeslaMessages.CommandProcessor_CannotFindWidget);
			response.setStatus(ResponseStatus.FAILED);
		}
		return response;
	}

	private SWTUIProcessor getSWTProcessor() {
		return client.getProcessor(SWTUIProcessor.class);
	}

	public PreExecuteStatus preExecute(Command command,
			PreExecuteStatus previousStatus, Q7WaitInfoRoot info) {
		return null;
	}

	public void initialize(AbstractTeslaClient client, String id) {
		this.client = client;
		// this.id = id;
	}

	public void postSelect(Element element, IElementProcessorMapper mapper) {
		// Map text elements to support this processor operations
		if (element.getKind().equals(ElementKind.Text.name())) {
			mapper.map(element, this);
		}
	}

	public boolean isInactivityRequired() {
		return false;
	}

	public boolean canProceed(Context context, Q7WaitInfoRoot info) {
		List<AbstractReconciler> reconcilers = TextReconcilerManager
				.getInstance().getReconcilers();
		for (AbstractReconciler reconciler : reconcilers) {
			try {
				boolean needWait = false;
				Field threadField = AbstractReconciler.class
						.getDeclaredField("fThread");
				threadField.setAccessible(true);
				Thread threadObject = (Thread) threadField.get(reconciler);
				if (threadObject != null) { 
					State state = threadObject.getState();
					if (!(state.equals(State.BLOCKED)
							|| state.equals(State.WAITING)
							|| state.equals(State.TIMED_WAITING) || state
								.equals(State.TERMINATED))) {
						// Reconciler are in execution of some action phase
						Q7WaitUtils.updateInfo("reconciler.thread", reconciler.getClass().getName(), info);
						needWait = true;
					} else {
						Field field = threadObject.getClass().getDeclaredField(
								"fIsDirty");
						field.setAccessible(true);
						boolean fDirty = field.getBoolean(threadObject);

						field = threadObject.getClass().getDeclaredField(
								"fCanceled");
						field.setAccessible(true);
						boolean fCanceled = field.getBoolean(threadObject);
						if (fDirty && !fCanceled) {
							Q7WaitUtils.updateInfo("reconciler.thread.dirty", reconciler.getClass().getName(), info);
							needWait = true;
						}
					}
				}
				if (needWait) {
					Long firstTime = reconcilerTimeours.get(reconciler);
					if (firstTime == null) {
						reconcilerTimeours.put(reconciler, Long.valueOf(System.currentTimeMillis()));
					}
					else if (System.currentTimeMillis() - firstTime.longValue() > TeslaLimits.getReconcilerTimeout()) {
						Q7WaitUtils.updateInfo("reconciler.thread.skip", reconciler.getClass().getName(), info);
						// Ignore if timeout
						return true;
					}
					return false;
				}
			} catch (Throwable e) {
				TeslaCore.log(e);
			}
		}

		return true;
	}

	public void clean() {
		this.reconcilerTimeours.clear();
	}

	public void terminate() {
		client = null;
	}

	public void checkHang() {
	}

	public void collectInformation(AdvancedInformation information,
			Command lastCommand) {
		// TODO Auto-generated method stub

	}

	public void notifyUI() {
		// TODO Auto-generated method stub

	}
}

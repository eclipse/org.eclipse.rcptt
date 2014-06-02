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
package org.eclipse.rcptt.tesla.internal.core;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.rcptt.tesla.core.Q7WaitUtils;
import org.eclipse.rcptt.tesla.core.context.ContextManagement.Context;
import org.eclipse.rcptt.tesla.core.info.AdvancedInformation;
import org.eclipse.rcptt.tesla.core.info.InfoFactory;
import org.eclipse.rcptt.tesla.core.info.Q7WaitInfoRoot;
import org.eclipse.rcptt.tesla.core.protocol.Assert;
import org.eclipse.rcptt.tesla.core.protocol.BooleanResponse;
import org.eclipse.rcptt.tesla.core.protocol.ElementCommand;
import org.eclipse.rcptt.tesla.core.protocol.GetStateResponse;
import org.eclipse.rcptt.tesla.core.protocol.IElementProcessorMapper;
import org.eclipse.rcptt.tesla.core.protocol.Nop;
import org.eclipse.rcptt.tesla.core.protocol.ProtocolFactory;
import org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage;
import org.eclipse.rcptt.tesla.core.protocol.SelectCommand;
import org.eclipse.rcptt.tesla.core.protocol.SelectResponse;
import org.eclipse.rcptt.tesla.core.protocol.TeslaStream;
import org.eclipse.rcptt.tesla.core.protocol.raw.Command;
import org.eclipse.rcptt.tesla.core.protocol.raw.Element;
import org.eclipse.rcptt.tesla.core.protocol.raw.RawFactory;
import org.eclipse.rcptt.tesla.core.protocol.raw.Response;
import org.eclipse.rcptt.tesla.core.protocol.raw.ResponseStatus;
import org.eclipse.rcptt.tesla.internal.core.info.GeneralInformationCollector;
import org.eclipse.rcptt.tesla.internal.core.processing.ElementGenerator;
import org.eclipse.rcptt.tesla.internal.core.processing.ITeslaCommandProcessor;
import org.eclipse.rcptt.tesla.internal.core.processing.ITeslaCommandProcessor.PreExecuteStatus;

public abstract class AbstractTeslaClient implements IElementProcessorMapper {
	private boolean processing = false;
	private final ElementGenerator generator = new ElementGenerator();
	protected final List<Command> localQueue = new ArrayList<Command>();
	private Map<String, Set<ITeslaCommandProcessor>> elementProcessors = new HashMap<String, Set<ITeslaCommandProcessor>>();
	private final Map<Command, ITeslaCommandProcessor.PreExecuteStatus> preStatuses = new HashMap<Command, ITeslaCommandProcessor.PreExecuteStatus>();
	private ITeslaCommandProcessor[] processors;
	private Context currentContext;

	private final String id;
	private final AtomicInteger hasEvents = new AtomicInteger(-1);
	private AdvancedInformation lastFailureInformation;

	public AbstractTeslaClient(String id) {
		super();
		this.id = id;
		processors = new TeslaProcessorManager().getProcessors();
		for (ITeslaCommandProcessor processor : processors) {
			processor.initialize(this, id);
		}
	}

	public ElementGenerator getGenerator() {
		return generator;
	}

	public String getID() {
		return id;
	}

	public void shutdown() {
		for (ITeslaCommandProcessor processor : processors) {
			processor.terminate();
		}
		processors = null;
		elementProcessors = null;
	}

	public abstract boolean isActive();

	public abstract Object getSyncObject();

	public abstract boolean isClosed();

	protected abstract TeslaStream stream();

	public void map(Element element, ITeslaCommandProcessor processor) {
		if (element != null && processor != null) {
			putProcessor(element, processor);
			for (ITeslaCommandProcessor proc : processors) {
				proc.postSelect(element, new IElementProcessorMapper() {
					public void map(Element element,
							ITeslaCommandProcessor processor) {
						putProcessor(element, processor);
					}
				});
			}
		}
	}

	private void putProcessor(Element element, ITeslaCommandProcessor processor) {
		final String key = makeKey(element);
		Set<ITeslaCommandProcessor> set = this.elementProcessors.get(key);
		if (set == null) {
			set = new LinkedHashSet<ITeslaCommandProcessor>();
		}
		Set<ITeslaCommandProcessor> newSet = new LinkedHashSet<ITeslaCommandProcessor>();
		newSet.add(processor);
		newSet.addAll(set);
		// II: So that processors are iterated in
		// reverse order, i.e. processor which has
		// been put last, is iterated at first
		this.elementProcessors.put(key, newSet);
	}

	protected void handleSelect(SelectCommand cmd) throws IOException {
		try {
			// Check for extensions first
			String kind = cmd.getData().getKind();
			ITeslaCommandProcessor lastProcessor = null;
			SelectResponse response = null;
			for (ITeslaCommandProcessor processor : processors) {
				if (processor.isSelectorSupported(kind)) {
					try {
						response = processor.select(cmd, generator, this);
						lastProcessor = processor;
					} catch (Throwable t) {
						TeslaCore.log(t);
						if (response == null) {
							response = ProtocolFactory.eINSTANCE
									.createSelectResponse();
						}
						response.setStatus(ResponseStatus.FAILED);
						response.setMessage(t.getMessage());
					}
					if (response != null && !response.getElements().isEmpty()) {
						for (Element uiElement : response.getElements()) {
							map(uiElement, processor);
						}
						break;
					}
				}
				if (response != null && !response.getElements().isEmpty()) {
					break;
				}
			}
			if (response == null) {
				response = ProtocolFactory.eINSTANCE.createSelectResponse();
				response.setStatus(ResponseStatus.FAILED);
				response.setMessage("No Element with kind:" + kind
						+ " is available for selection...");
			}
			if (response.getStatus().equals(ResponseStatus.FAILED)) {
				handleFailedResponse(cmd, response, lastProcessor);
			}
			stream().writeResponse(response);
		} catch (Throwable e) {
			if (!(e.getMessage() != null && e.getMessage().equals(
					"Software caused connection abort: socket write error"))) {
				sendErrorResponse(e);
				TeslaCore.log(e);
			}
		}
	}

	protected void handleAssert(Assert cmd) throws IOException {
		// Check for extensions first
		for (ITeslaCommandProcessor processor : processors) {
			Response response = processor.executeCommand(cmd, this);
			if (response != null) {
				stream().writeResponse(response);
				return;
			}

		}
		BooleanResponse response = ProtocolFactory.eINSTANCE
				.createBooleanResponse();
		response.setStatus(ResponseStatus.FAILED);
		stream().writeResponse(response);
	}

	private String makeKey(Element uiElement) {
		return uiElement.getKind() + ":" + uiElement.getId();
	}

	public boolean processNext(Context context, Q7WaitInfoRoot info) {
		if (isClosed()) {
			return false;
		}
		synchronized (this) {
			if (processing) { // Skip this event if we already processing one
				// other
				return false;
			}
		}

		if (isActive() && (hasCommand() || !localQueue.isEmpty())
				&& canProceed(context, info)) {
			return doOneCommand(context, info);
		}
		return false;
	}

	public void hasEvent(String kind, String name, Q7WaitInfoRoot info) {
		hasEvents.incrementAndGet();
		Q7WaitUtils.updateInfo(kind, name, info);
	}

	protected boolean canProceed(Context context, Q7WaitInfoRoot info) {
		hasEvents.set(0);
		boolean result = true;
		for (ITeslaCommandProcessor processor : processors) {
			boolean proceed = processor.canProceed(context, info);
			if (!proceed) {
				result = false;
			}
		}
		if (hasEvents.get() > 0) {
			return false;
		}
		return result;
	}

	public void clean() {
		lastFailureInformation = null;
		for (ITeslaCommandProcessor processor : processors) {
			processor.clean();
		}
		for (PreExecuteStatus status : preStatuses.values()) {
			status.clean();
		}
		preStatuses.clear();
		elementProcessors.clear();
	}

	protected boolean preExecute(Command command, Q7WaitInfoRoot info) {
		if (command instanceof ElementCommand) {
			ElementCommand cmd = (ElementCommand) command;
			Element element = cmd.getElement();
			if (element != null) {
				Set<ITeslaCommandProcessor> processors = elementProcessors
						.get(makeKey(element));
				if (processors != null) {
					PreExecuteStatus preStatus = preStatuses.get(command);
					for (ITeslaCommandProcessor processor : processors) {
						if (processor != null) {
							try {
								PreExecuteStatus status = processor.preExecute(
										command, preStatus, info);
								if (status != null) {
									preStatuses.put(command, status);
									if (!status.canExecute) {
										return false;
									}
								} else {
									preStatuses.remove(command);
								}
							} catch (Throwable e) {
								TeslaCore.log(e);
							}
						}
					}
				}
			}
		} else {
			for (ITeslaCommandProcessor processor : processors) {
				try {
					PreExecuteStatus status = processor.preExecute(command,
							preStatuses.get(command), info);
					if (status != null) {
						if (!status.canExecute) {
							preStatuses.put(command, status);
							return false;
						}
					}
				} catch (Throwable e) {
					TeslaCore.log(e);
				}
			}
		}
		return true;
	}

	public void addCommand(Command cmd) {
		localQueue.add(cmd);
		notifyUI();
	}

	public void notifyUI() {
		for (ITeslaCommandProcessor processor : processors) {
			processor.notifyUI();
		}
	}

	private boolean doOneCommand(Context context, Q7WaitInfoRoot info) {
		synchronized (this) {
			processing = true;
		}
		this.currentContext = context;
		Command command = null;
		try {
			final boolean isLocalQueue;
			if (!localQueue.isEmpty()) {
				command = localQueue.remove(0);
				isLocalQueue = true;
			} else {
				command = stream().readCommand();
				if (command == null) {
					return false;
				}
				isLocalQueue = false;
			}
			if (!preExecute(command, info)) {
				if (isLocalQueue) {
					localQueue.add(0, command);
				} else {
					localQueue.add(command);
				}
				return false;
			}
			preExecute(command);
			execute(command);
			postExecute(command);
		} finally {
			synchronized (this) {
				processing = false;
			}
			currentContext = null;
		}
		return true;
	}

	protected void postExecute(Command command) {
		if (processors == null) {
			return;
		}
		for (ITeslaCommandProcessor processor : processors) {
			if (processor instanceof IScreenshotFactory) {
				((IScreenshotFactory) processor).makeScreenshot(
						"post execute: " + command.getClass().getName(), true);
				break;
			}
		}
	}

	protected void preExecute(Command command) {
		if (command instanceof SelectCommand || command instanceof Nop
				|| command instanceof Assert) {
			return;
		}
		for (ITeslaCommandProcessor processor : processors) {
			if (processor instanceof IScreenshotFactory) {
				((IScreenshotFactory) processor).makeScreenshot(
						"pre execute: " + command.getClass().getName(), false);
				break;
			}
		}
	}

	protected void execute(final Command command) {
		// long startTime = System.currentTimeMillis();
		if (!(command instanceof Nop)) {
			lastFailureInformation = null;
		}
		try {
			if (command instanceof ElementCommand) {
				ElementCommand cmd = (ElementCommand) command;
				Element element = cmd.getElement();

				if (element != null) {
					Set<ITeslaCommandProcessor> processors = elementProcessors
							.get(makeKey(element));
					if (processors != null) {
						for (ITeslaCommandProcessor processor : processors) {
							if (processor != null) {
								try {
									Response response = processor
											.executeCommand(command, this);
									if (response != null) {
										if (response.getStatus().equals(
												ResponseStatus.FAILED)) {
											handleFailedResponse(command,
													response, processor);
										}
										stream().writeResponse(response);
										return;
									}
								} catch (Throwable e) {
									TeslaCore.log(e);
									// Write failed status to stream
									sendErrorResponse(e);
									return;
								}
							}
						}
					}
				}
			} else {
				for (ITeslaCommandProcessor processor : processors) {
					if (processor.isCommandSupported(command)) {
						try {
							Response response = processor.executeCommand(
									command, this);
							if (response != null) {
								if (response.getStatus().equals(
										ResponseStatus.FAILED)) {
									handleFailedResponse(command, response,
											processor);
								}
								stream().writeResponse(response);
								return;
							}
						} catch (Exception e) {
							TeslaCore.log(e);
							sendErrorResponse(e);
							return;
						}
					}
				}
			}
			if (command.eClass().getEPackage()
					.equals(ProtocolFactory.eINSTANCE.getEPackage())) {
				switch (command.eClass().getClassifierID()) {
				case ProtocolPackage.SELECT_COMMAND:
					handleSelect((SelectCommand) command);
					return;
				case ProtocolPackage.SHUTDOWN:
					stream().writeResponse(
							RawFactory.eINSTANCE.createResponse());
					shutdown();
					return;
				case ProtocolPackage.NOP:

					stream().writeResponse(
							RawFactory.eINSTANCE.createResponse());
					return;
				case ProtocolPackage.GET_STATE:
					GetStateResponse res = ProtocolFactory.eINSTANCE
							.createGetStateResponse();
					Element state = RawFactory.eINSTANCE.createElement();
					String returnedState = currentContext.getID();
					// System.out.println("RETURNED WAIT STATE:" +
					// returnedState);
					state.setId(returnedState);
					state.setKind("State");
					res.setState(state);
					stream().writeResponse(res);
					return;
				case ProtocolPackage.WAIT_FOR_STATE:
					stream().writeResponse(
							RawFactory.eINSTANCE.createResponse());
					return;
				case ProtocolPackage.ROLLBACK_TO_STATE:
					// TODO
					stream().writeResponse(
							RawFactory.eINSTANCE.createResponse());
					return;
				}
			}
			Response failed = RawFactory.eINSTANCE.createResponse();
			failed.setStatus(ResponseStatus.FAILED);
			failed.setMessage("Unsupported command");
			stream().writeResponse(failed);
			// shutdown();
			// throw new RuntimeException("Unknown command:"
			// + command.toString());
			return;
		} catch (Throwable t) {
			logException(t);
			handleFailedResponse(command, null, null);
		}
	}

	private void sendErrorResponse(Throwable e) {
		try {
			Response errorResponse = RawFactory.eINSTANCE.createResponse();
			errorResponse.setStatus(ResponseStatus.FAILED);
			errorResponse.setMessage("Exception happened: "
					+ e.toString()); // not only class name, but also its
										// message
			stream().writeResponse(errorResponse);
		} catch (Throwable e2) {
			TeslaCore.log(e2);
		}
	}

	public AdvancedInformation getLastFailureInformation() {
		return lastFailureInformation;
	}

	public void clearLastFailureInformation() {
		lastFailureInformation = null;
	}

	protected void handleFailedResponse(Command command, Response response,
			ITeslaCommandProcessor processor) {
		if (response != null) {
			// Collect advanced information for this error
			AdvancedInformation information = getAdvancedInformation(command);
			this.lastFailureInformation = information;
			response.setAdvancedInformation(EcoreUtil
					.copy(information));
		}
	}

	public AdvancedInformation getAdvancedInformation(Command command) {
		// Collect advanced information
		AdvancedInformation information = InfoFactory.eINSTANCE
				.createAdvancedInformation();
		if (processors != null) {
			for (ITeslaCommandProcessor commandProcessor : processors) {
				commandProcessor.collectInformation(information, command);
			}
		}
		GeneralInformationCollector.collectInformation(information);

		return information;
	}

	public void collectLastFailureInformation() {
		AdvancedInformation information = getAdvancedInformation(null);
		this.lastFailureInformation = information;
	}

	public abstract void logException(Throwable t);

	public abstract boolean hasCommand();

	public <T> T getProcessor(Class<T> clazz$) {
		for (ITeslaCommandProcessor processor : processors) {
			if (clazz$ == processor.getClass()) {
				return clazz$.cast(processor);
			}
		}
		return null;
	}

	public <T> List<T> getProcessors(Class<T> clazz$) {
		List<T> result = new ArrayList<T>();
		for (ITeslaCommandProcessor processor : processors) {
			if (clazz$.isInstance(processor)) {
				result.add(clazz$.cast(processor));
			}
		}
		return result;
	}

}
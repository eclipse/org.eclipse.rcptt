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
package org.eclipse.rcptt.tesla.recording.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;

import org.eclipse.rcptt.tesla.core.protocol.raw.Command;
import org.eclipse.rcptt.tesla.core.protocol.raw.CommandTransferKind;
import org.eclipse.rcptt.tesla.core.protocol.raw.Element;
import org.eclipse.rcptt.tesla.core.protocol.raw.RawEvent;
import org.eclipse.rcptt.tesla.core.protocol.raw.SetMode;
import org.eclipse.rcptt.tesla.core.ui.Widget;
import org.eclipse.rcptt.tesla.recording.core.internal.Activator;

public class TeslaRecorder extends BaseTeslaRecorder {
	private static TeslaRecorder instance;

	private List<ITeslaRecordingListener> listeners = new ArrayList<ITeslaRecordingListener>();
	private List<IRecordingModeListener> modeListeners = new ArrayList<IRecordingModeListener>();

	private List<IRecordingProcessor> processors = new ArrayList<IRecordingProcessor>();

	public TeslaRecorder() {
	}

	private void inializeProcessors() {
		IConfigurationElement[] configurationElements = Platform
				.getExtensionRegistry().getConfigurationElementsFor(
						Activator.PLUGIN_ID + ".recorder");
		for (IConfigurationElement config : configurationElements) {
			try {
				IRecordingProcessor processor = (IRecordingProcessor) config
						.createExecutableExtension("class");
				processors.add(processor);
				// processor.initialize(this); // will be initialized a bit later, after sorting
			} catch (CoreException e) {
				Activator
						.getDefault()
						.getLog()
						.log(new Status(Status.ERROR, Activator.PLUGIN_ID, e
								.getMessage(), e));
			}
		}
		Collections.sort(processors, new Comparator<IRecordingProcessor>() {
			public int compare(IRecordingProcessor o1, IRecordingProcessor o2) {
				return Integer.valueOf(o1.getInitLevel()).compareTo(
						o2.getInitLevel());
			}
		});
		for (IRecordingProcessor pr : processors) {
			try {
				pr.initialize(this);
			} catch (Exception e) {
				Activator
						.getDefault()
						.getLog()
						.log(new Status(Status.ERROR, Activator.PLUGIN_ID, e
								.getMessage(), e));
			}
		}
	}

	@Override
	protected void hookExecuteCommand(Command command, List<Element> elements,
			CommandTransferKind kind, List<Widget> controls, int index,
			List<RawEvent> rawEvents) {
		synchronized (listeners) {
			for (ITeslaRecordingListener listener : listeners) {
				listener.recordCommand(command, elements, kind, controls,
						index, rawEvents);
			}
		}
	}

	public void addListener(ITeslaRecordingListener listener) {
		synchronized (listeners) {
			if (!listeners.contains(listener)) {
				listeners.add(listener);
			}
		}
	}

	public void removeListener(ITeslaRecordingListener listener) {
		synchronized (listeners) {
			listeners.remove(listener);
		}
	}

	public void addListener(IRecordingModeListener listener) {
		synchronized (listeners) {
			if (!modeListeners.contains(listener)) {
				modeListeners.add(listener);
			}
		}
	}

	public void removeListener(IRecordingModeListener listener) {
		synchronized (listeners) {
			modeListeners.remove(listener);
		}
	}

	public synchronized static TeslaRecorder getInstance() {
		if (instance == null) {
			instance = new TeslaRecorder();
			instance.inializeProcessors();
		}
		return instance;
	}

	public boolean hasListeners() {
		synchronized (listeners) {
			return !listeners.isEmpty();
		}
	}

	public <T> T getProcessor(Class<T> clazz$) {
		for (IRecordingProcessor processor : processors) {
			if (clazz$.getName().equals(processor.getClass().getName())) {
				return clazz$.cast(processor);
			}
		}
		return null;
	}

	public void clear() {
		super.clear();
		for (IRecordingProcessor processor : processors) {
			processor.clear();
		}
	}

	public void setFreeze(boolean value, SetMode command) {
		for (IRecordingProcessor processor : processors) {
			processor.setFreeze(value, command);
		}
	}

	public <T> List<T> getProcessors(Class<T> clazz$) {
		List<T> result = new ArrayList<T>();
		for (IRecordingProcessor processor : processors) {
			if (clazz$.isInstance(processor)) {
				result.add(clazz$.cast(processor));
			}
		}
		return result;
	}

	public void notifySetRecordingMode(boolean b) {
		synchronized (listeners) {
			for (IRecordingModeListener listener : this.modeListeners) {
				listener.changeMode(b);
			}
		}
	}

	public void resetAssertSelection() {
		for (IRecordingProcessor processor : processors) {
			processor.resetAssertSelection();
		}
	}
}

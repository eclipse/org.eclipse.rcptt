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
package org.eclipse.rcptt.tesla.swt.logging;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.aspectj.lang.JoinPoint;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.events.TypedEvent;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Widget;

import org.eclipse.rcptt.tesla.recording.core.TeslaRecorder;
import org.eclipse.rcptt.tesla.swt.events.TeslaEventManager;
import org.eclipse.rcptt.tesla.swt.workbench.EclipseWorkbenchProvider;
import org.eclipse.rcptt.tesla.ui.SWTTeslaActivator;

public class SwtEventLog {

	private static SwtEventLog instance = null;

	public static SwtEventLog getInstance() {
		if (instance == null) {
			instance = new SwtEventLog();
			instance.setLogStackTraceOnSend(true);
			// instance.activate(); // TO ACTIVATE LOGGING UNCOMMENT THIS LINE

			instance.addFilter(new BlockAllFilter());

			// send/post filter
			// instance.addFilter(new IFilter() {
			// public boolean filter(Widget widget, int type, Event event,
			// boolean send) {
			// return !send;
			// }
			// });
			//
			// instance.addFilter(new TypeFilter(TypeFilter.DND_EVENTS));

			// specific view filter, if you wish
			// instance.addFilter(new ViewFilter(
			// "org.eclipse.ui.views.PropertySheet"));

			// or just tag it
			// instance.addTagger("propview", new ViewFilter(
			// "org.eclipse.ui.views.PropertySheet"));
		}
		return instance;
	}

	private boolean logStackTraceOnSend = false;
	private boolean active = false;
	private FileWriter writer = null;

	public void setLogStackTraceOnSend(boolean value) {
		logStackTraceOnSend = value;
	}

	public void activate() {
		try {
			Class.forName("org.eclipse.core.resources.ResourcesPlugin");
		} catch (ClassNotFoundException e) {
			SWTTeslaActivator.log("Unable to create q7-swt-event.log writter",
					e);
			return;
		}

		File workspaceRoot = org.eclipse.core.resources.ResourcesPlugin
				.getWorkspace().getRoot().getLocation().toFile();
		File logFile = new File(workspaceRoot, ".metadata/q7-swt-event.log");

		try {
			writer = new FileWriter(logFile, true);
		} catch (IOException e) {
			SWTTeslaActivator.log("Unable to create q7-swt-event.log writter",
					e);
			return;
		}

		active = true;
	}

	public interface IFilter {
		boolean filter(Widget widget, int type, Event event, boolean send);
	}

	private List<IFilter> filters = new ArrayList<IFilter>();

	public void addFilter(IFilter filter) {
		filters.add(filter);
	}

	private static class Tagger {
		public String name;

		public IFilter filter;

		public Tagger(String name, IFilter filter) {
			this.name = name;
			this.filter = filter;
		}
	}

	private List<Tagger> taggers = new ArrayList<Tagger>();

	@SuppressWarnings("unused")
	private void addTagger(String name, IFilter filter) {
		taggers.add(new Tagger(name, filter));
	}

	private void write(String line, Object... args) {
		try {
			writer.append(String.format(line, args));
			writer.append('\n');
			writer.flush();
		} catch (IOException e) {
			SWTTeslaActivator.log("Unable to write to q7-swt-event.log", e);
		}

		// SWTTeslaActivator.info(String.format(line, args));
		// System.out.println(String.format(line, args));
	}

	private void writeAnnouncement(String message, Object... args) {
		write("\n=== %s ===\n", String.format(message, args));
	}

	private Widget lastWidget = null;
	private Integer lastType = null;
	private Map<String, Object> lastSnapshot = null;

	private enum AutState {
		Normal, Recording, Replaying, Invalid
	}

	private AutState lastState = null;

	private synchronized void writeEvent(String message, Widget widget,
			int type, Event event, boolean send) {
		if (!active || writer == null)
			return;

		AutState state = detectAutState();
		if (lastState == null || lastState != state) {
			writeAnnouncement("%s is the current AUT mode", state);
			lastState = state;
		}

		for (IFilter f : filters)
			if (f.filter(widget, type, event, send))
				return;

		Map<String, Object> snapshot = makeSnapshot(event);
		if (widget == lastWidget && (lastType != null && type == lastType)
				&& areSnapshotsEqual(snapshot, lastSnapshot)) {
			write("%s...", message);
			return;
		}

		lastWidget = widget;
		lastType = type;
		lastSnapshot = snapshot;

		write("%s %s%s %s - %s\n  %s\n", message,
				formatTags(widget, type, event, send),
				formatEventName(type, event), formatObject(widget),
				new SimpleDateFormat("yyyy/MM/dd HH:mm:ss:SSS")
						.format(new Date()), formatEvent(widget, snapshot));
		if (logStackTraceOnSend || !send)
			writeStackTrace();
	}

	private String formatTags(Widget widget, int type, Event event, boolean send) {
		StringBuilder b = new StringBuilder();
		for (Tagger t : taggers) {
			if (!t.filter.filter(widget, type, event, send)) {
				if (b.length() > 0)
					b.append(", ");
				b.append(t.name);
			}
		}

		return b.length() > 0 ? String.format("[%s] ", b) : "";
	}

	public void logProceed(Widget widget, int type, Event event, boolean send) {
		writeEvent("+", widget, type, event, send);
	}

	public void logSkip(Widget widget, int type, Event event, boolean send) {
		writeEvent("-", widget, type, event, send);
	}

	public void logRecord(Widget widget, int type, Event event, boolean send) {
		if (lastState == null || lastState != AutState.Recording)
			return;
		writeEvent("*", widget, type, event, send);
	}

	private void writeMethodCall(String message, JoinPoint point) {
		if (!active || writer == null)
			return;

		AutState state = detectAutState();
		if (lastState == null || lastState != state) {
			writeAnnouncement("%s is the current AUT mode", state);
			lastState = state;
		}

		write("%s %s %s - %s\n  %s: %s\n", message, point.getSignature(),
				point.getSourceLocation(), new SimpleDateFormat(
						"yyyy/MM/dd HH:mm:ss:SSS").format(new Date()),
				formatObject(point.getThis()), formatArgs(point.getArgs()));
	}

	private void writeStackTrace() {
		if (!active || writer == null)
			return;

		StackTraceElement[] trace = Thread.currentThread().getStackTrace();
		for (StackTraceElement e : trace)
			write("  " + e.toString());
		write("\n");
	}

	public void logMethodCallTo(JoinPoint point) {
		writeMethodCall(">", point);
		writeStackTrace();
	}

	public void logMethodCallFrom(JoinPoint point) {
		writeMethodCall(" ", point);
	}

	public void logTypedEvent(TypedEvent event) {
		if (!active || writer == null)
			return;

		AutState state = detectAutState();
		if (lastState == null || lastState != state) {
			writeAnnouncement("%s is the current AUT mode", state);
			lastState = state;
		}

		Map<String, Object> snapshot = makeSnapshot(event);
		write("# %s %s - %s\n  %s\n", event.getClass().getName(),
				formatObject(event.widget), new SimpleDateFormat(
						"yyyy/MM/dd HH:mm:ss:SSS").format(new Date()),
				formatEvent(event.widget, snapshot));
		writeStackTrace();
	}

	private static boolean areSnapshotsEqual(Map<String, Object> a,
			Map<String, Object> b) {
		if (a == null || b == null)
			return false;

		if (a.get("meta:class") != b.get("meta:class"))
			return false;

		if (a.size() != b.size())
			return false;

		for (String name : a.keySet()) {
			if (!b.containsKey(name))
				return false;

			Object aValue = a.get(name);
			Object bValue = b.get(name);
			if (aValue == bValue)
				continue;
			if (aValue == null || bValue == null)
				return false;
			if (!aValue.equals(bValue))
				return false;
		}

		return true;
	}

	private static Map<String, Object> makeSnapshot(Object object) {
		LinkedHashMap<String, Object> result = new LinkedHashMap<String, Object>();
		if (object == null)
			return null;

		Class<? extends Object> class_ = object.getClass();
		result.put("meta:class", class_);

		while (class_ != null) {
			Field[] fields = class_.getDeclaredFields();
			for (Field f : fields) {
				try {
					if (Modifier.isStatic(f.getModifiers()))
						continue;

					f.setAccessible(true);
					result.put(f.getName(), f.get(object));
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}

			class_ = class_.getSuperclass();
		}

		return result;
	}

	private static Map<Integer, String> eventNames = null;

	private static Map<Integer, String> getEventNames() {
		if (eventNames == null) {
			eventNames = new HashMap<Integer, String>();
			eventNames.put(-1, "[unknown]");

			for (Class<?> c : new Class<?>[] { SWT.class, DND.class }) {
				Field[] fields = c.getDeclaredFields();
				for (Field f : fields) {
					if (!Modifier.isStatic(f.getModifiers()))
						continue;

					String name = f.getName();
					if (name.length() < 2
							|| !(Character.isUpperCase(name.charAt(0)) && Character
									.isLowerCase(name.charAt(1))))
						continue;

					try {
						eventNames.put(f.getInt(null), name);
					} catch (IllegalArgumentException e) {
					} catch (IllegalAccessException e) {
					}
				}
			}
		}
		return eventNames;
	}

	private static String formatEventName(int type, Event event) {
		String result = getEventNames().get(
				type == -1 && event != null ? event.type : type);
		if (result == null)
			result = Integer.toString(type);
		return result;
	}

	private static String formatEvent(Widget widget,
			Map<String, Object> snapshot) {
		if (snapshot == null)
			return "null";

		StringBuilder b = new StringBuilder();
		for (String name : snapshot.keySet()) {
			if (name.contains(":")) // skip meta stuff
				continue;

			Object value = snapshot.get(name);
			if (b.length() > 0)
				b.append(", ");
			b.append(name).append(": ")
					.append(value == widget ? "..." : formatObject(value));
		}

		return b.toString();
	}

	private static Set<Class<? extends Object>> justToStringClasses = new HashSet<Class<? extends Object>>();
	static {
		justToStringClasses.add(Integer.class);
		justToStringClasses.add(Double.class);
		justToStringClasses.add(Float.class);
		justToStringClasses.add(Boolean.class);
		justToStringClasses.add(String.class);
		justToStringClasses.add(Byte.class);
		justToStringClasses.add(Short.class);
		justToStringClasses.add(Long.class);
		justToStringClasses.add(Character.class);
	}

	private static interface IFormatter {
		public String format(Object value);
	}

	private static final Map<Class<?>, IFormatter> formatters = new HashMap<Class<?>, IFormatter>();
	static {
		formatters.put(Combo.class, new IFormatter() {
			public String format(Object value) {
				Combo combo = (Combo) value;
				return formatArray(combo.getItems());
			}
		});

		formatters.put(CCombo.class, new IFormatter() {
			public String format(Object value) {
				CCombo combo = (CCombo) value;
				return formatArray(combo.getItems());
			}
		});
	}

	private static String formatArray(Object[] items) {
		String result = "[";
		for (Object o : items)
			result += result.length() > 1 ? ", " + formatObject(o)
					: formatObject(o);
		return result + ']';
	}

	private static String genericFormatObject(Object value) {
		if (value == null)
			return null;
		if (value instanceof Character && (Character) value == 0)
			return "NUL";
		if (justToStringClasses.contains(value.getClass()))
			return value.toString();
		if (value instanceof Object[])
			return formatArray((Object[]) value);
		if (value instanceof Widget) {
			Widget widget = (Widget) value;
			return String
					.format("%s@%x [%s] %s",
							value.getClass().getName(),
							System.identityHashCode(value),
							widget.isDisposed() ? "disposed"
									: formatWidgetPath(widget),
							widget.isDisposed() ? "[disposed]" : value
									.toString());
		}
		return String.format("%s@%x %s", value.getClass().getName(),
				System.identityHashCode(value), value.toString());
	}

	private static String detailsFormatObject(Object value) {
		IFormatter formatter = formatters.get(value.getClass());
		return formatter == null ? null : formatter.format(value);
	}

	private static String formatObject(Object value) {
		String genericText = genericFormatObject(value);
		String details = value == null ? null : detailsFormatObject(value);

		return details == null ? genericText : genericText + "\n  " + details;
	}

	private static String formatWidgetPath(Widget widget) {
		StringBuilder b = new StringBuilder();
		while (widget != null) {
			if (b.length() > 0)
				b.append(" <- ");
			b.append(widget.getClass().getSimpleName());

			try {
				Method getText = widget.getClass().getMethod("getText");
				if (getText.getReturnType() == String.class) {
					String text = (String) getText.invoke(widget);
					if (text != null && text.length() > 0) {
						if (text.length() > 32)
							text = text.substring(0, 32) + " ...";
						b.append('(').append(text).append(')');
					}
				}
			} catch (SecurityException e) {
			} catch (NoSuchMethodException e) {
			} catch (IllegalArgumentException e) {
			} catch (IllegalAccessException e) {
			} catch (InvocationTargetException e) {
			}

			widget = widget instanceof Control ? ((Control) widget).getParent()
					: null;
		}
		return b.toString();
	}

	private static String formatArgs(Object[] args) {
		if (args.length == 0)
			return "[none]";

		StringBuilder b = new StringBuilder();
		for (Object o : args) {
			if (b.length() > 0)
				b.append(", ");
			b.append(o == null ? null : formatObject(o));
		}

		return b.toString();
	}

	private static AutState detectAutState() {
		boolean replaying = TeslaEventManager.getManager().hasListeners();
		boolean recording = TeslaRecorder.getInstance().hasListeners();

		if (replaying) {
			if (recording)
				return AutState.Invalid;
			else
				return AutState.Replaying;
		} else if (recording) {
			if (replaying)
				return AutState.Invalid;
			else
				return AutState.Recording;
		} else
			return AutState.Normal;
	}

	// --

	private static class BlockAllFilter implements IFilter {

		public boolean filter(Widget widget, int type, Event event, boolean send) {
			return true;
		}

	}

	@SuppressWarnings("unused")
	private static class OrFilter implements IFilter {

		private IFilter left, right;

		public OrFilter(IFilter left, IFilter right) {
			this.left = left;
			this.right = right;
		}

		public boolean filter(Widget widget, int type, Event event, boolean send) {
			return left.filter(widget, type, event, send)
					&& right.filter(widget, type, event, send);
		}
	}

	@SuppressWarnings("unused")
	private static class TypeFilter implements IFilter {
		private int[] types;

		public TypeFilter(int... types) {
			this.types = types;
		}

		public boolean filter(Widget widget, int type, Event event, boolean send) {
			type = type == -1 && event != null ? event.type : type;
			for (int t : types)
				if (t == type)
					return false;
			return true;
		}

		public static final int[] DND_EVENTS = new int[] { DND.DragEnd,
				DND.DragEnter, DND.DragLeave, DND.DragOperationChanged,
				DND.DragOver, DND.DragSetData, DND.DragStart, DND.Drop,
				DND.DropAccept };
	}

	@SuppressWarnings("unused")
	private static class ViewFilter implements IFilter {

		private final String viewId;

		public ViewFilter(String viewId) {
			this.viewId = viewId;
		}

		public boolean filter(Widget widget, int type, Event event, boolean send) {
			if (!send)
				return true;

			while (widget != null) {
				String id = EclipseWorkbenchProvider.getProvider().getViewId(
						widget);
				if (viewId.equalsIgnoreCase(id))
					return false;

				widget = widget instanceof Control ? ((Control) widget)
						.getParent() : null;
			}

			return true;
		}
	}
}

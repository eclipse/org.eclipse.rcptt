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
package org.eclipse.rcptt.tesla.core.context;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.UUID;

public class ContextManagement {
	private static Stack<Context> contexts = new Stack<Context>();
	private static Context lastLeavedContext = null;
	private final static Map<String, Context> contextUUID = new HashMap<String, Context>();
	private static final boolean DEBUG = false;

	public static class Context {
		private StackTraceElement[] stack;
		private Exception e;

		public Context() {
			e = new Exception();
		}

		public Context(StackTraceElement[] thread) {
			this.stack = thread;
			this.e = null;
		}

		private static int indexOf(StackTraceElement[] stack, String className) {
			return indexOf(stack, className, 0, stack.length);
		}

		private static int indexOf(StackTraceElement[] stack, String className,
				int beginIndex, int endIndex) {
			for (int i = beginIndex; i < endIndex; i++) {
				StackTraceElement element = stack[i];
				if (className.equals(element.getClassName())) {
					return i;
				}
			}
			return -1;
		}

		private static StackTraceElement[] skipElements(
				StackTraceElement[] stack) {
			int num = indexOf(stack, ContextManagement.class.getName());
			if (num < 0) {
				return new StackTraceElement[0];
			}
			StackTraceElement[] result = new StackTraceElement[stack.length
					- (num + 1)];
			System.arraycopy(stack, num + 1, result, 0, stack.length
					- (num + 1));
			return result;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + Arrays.hashCode(getStack());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Context other = (Context) obj;
			if (!Arrays.equals(getStack(), other.getStack()))
				return false;
			return true;
		}

		public String getID() {
			for (Map.Entry<String, Context> entry : contextUUID.entrySet()) {
				if (this.equals(entry.getValue())) {
					return entry.getKey();
				}
			}
			final String stateId = UUID.randomUUID().toString();
			contextUUID.put(stateId, this);
			return stateId;
		}

		public boolean isCurrent() {
			return currentContext().equals(this);
		}

		public boolean contains(String clName, String methodName) {
			for (StackTraceElement e : getStack()) {
				if (e.getClassName().equals(clName)
						&& e.getMethodName().equals(methodName)) {
					return true;
				}
			}
			return false;
		}

		public int indexOf(String clName, String methodName) {
			int index = 0;
			for (StackTraceElement e : getStack()) {
				if (e.getClassName().equals(clName)
						&& e.getMethodName().equals(methodName)) {
					return index;
				}
				index++;
			}
			return -1;
		}

		private StackTraceElement[] getStack() {
			if (stack == null && e != null) {
				this.stack = skipElements(e.getStackTrace());
			}
			return stack;
		}

		public boolean containsClass(String clName) {
			for (StackTraceElement e : getStack()) {
				if (e.getClassName().contains(clName)) {
					return true;
				}
			}
			return false;
		}

		public boolean hasCall(String className, String methodName, int index) {
			StackTraceElement item = getStack()[index];
			if (className.equals(item.getClassName())
					&& methodName.equals(item.getMethodName())) {
				return true;
			}
			return false;
		}

		public StackTraceElement[] getStackTrace() {
			return getStack();
		}
	}

	@SuppressWarnings("unused")
	public static void enterContext() {
		Context ctx = new Context();
		if (DEBUG
				&& !(lastLeavedContext != null && lastLeavedContext.equals(ctx))) {
			System.out.println("Enter context:" + ctx.getID());
		}
		contexts.push(ctx);
	}

	@SuppressWarnings("unused")
	public static void exitContext() {
		Context toLeave = contexts.pop();
		if (DEBUG
				&& !(lastLeavedContext != null && lastLeavedContext
						.equals(toLeave))) {
			System.out.println("Leave context:" + toLeave.getID());
		}
		lastLeavedContext = toLeave;
	}

	public static Context peekContext() {
		return contexts.peek();
	}

	public static Context currentContext() {
		return new Context();
	}

	public static Context makeContext(StackTraceElement[] thread) {
		return new Context(thread);
	}

	public static Context lastContext() {
		return lastLeavedContext;
	}

	public static boolean isContextChanged(Context context) {
		if (lastLeavedContext != null) {
			return !lastLeavedContext.equals(context);
		}
		return false;
	}

	public static Context getByID(String id) {
		return contextUUID.get(id);
	}
}

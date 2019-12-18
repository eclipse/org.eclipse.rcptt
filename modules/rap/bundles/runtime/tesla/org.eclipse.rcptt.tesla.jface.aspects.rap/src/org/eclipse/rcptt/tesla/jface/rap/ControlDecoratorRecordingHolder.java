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
package org.eclipse.rcptt.tesla.jface.rap;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;

import org.eclipse.jface.fieldassist.ControlDecoration;
import org.eclipse.swt.widgets.Control;

public class ControlDecoratorRecordingHolder {
	private static WeakHashMap<Control, List<WeakReference<ControlDecoration>>> decorations = new WeakHashMap<Control, List<WeakReference<ControlDecoration>>>();

	public synchronized static List<ControlDecoration> getDecorators(
			Control ctrl) {
		List<ControlDecoration> result = new ArrayList<ControlDecoration>();
		List<WeakReference<ControlDecoration>> toRemove = new ArrayList<WeakReference<ControlDecoration>>();
		List<WeakReference<ControlDecoration>> values = decorations.get(ctrl);
		if (values == null) {
			return result;
		}
		for (WeakReference<ControlDecoration> controlDecoration : values) {
			ControlDecoration decoration = controlDecoration.get();
			if (decoration != null) {
				if (decoration.getControl() == null
						|| decoration.getControl().isDisposed()) {
					toRemove.add(controlDecoration);
				} else {
					result.add(decoration);
				}
			} else {
				toRemove.add(controlDecoration);
			}
		}
		values.removeAll(toRemove);
		if (values.size() == 0) {
			decorations.remove(ctrl);
		}
		return result;
	}

	public synchronized static void add(Control ctrl, ControlDecoration decor) {
		List<WeakReference<ControlDecoration>> list = decorations.get(ctrl);
		if (list == null) {
			list = new ArrayList<WeakReference<ControlDecoration>>();
			decorations.put(ctrl, list);
		}
		list.add(new WeakReference<ControlDecoration>(decor));
	}
}

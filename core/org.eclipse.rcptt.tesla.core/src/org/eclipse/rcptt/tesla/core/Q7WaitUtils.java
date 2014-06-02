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
package org.eclipse.rcptt.tesla.core;

import java.util.List;

import org.eclipse.emf.common.util.EList;

import org.eclipse.rcptt.tesla.core.info.InfoFactory;
import org.eclipse.rcptt.tesla.core.info.Q7WaitInfo;
import org.eclipse.rcptt.tesla.core.info.Q7WaitInfoRoot;

public class Q7WaitUtils {

	public static void updateInfo(String kind, String className, Q7WaitInfoRoot info) {
		if (info == null || className == null) {
			return;
		}
		synchronized (info) {
			// Update class name if contains $ to contain method name instead
			int pos = className.indexOf("$");
			if (pos != -1) {
				String methodValue = info.getInnerClassMap().get(className);
				if (methodValue == null) {
					StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
					String clName = className.substring(0, pos);
					for (int i1 = 0; i1 < stackTrace.length; i1++) {

						if (stackTrace[i1].getClassName().startsWith(clName)) {
							methodValue = stackTrace[i1].getMethodName() + ":"
									+ stackTrace[i1].getLineNumber();
							break;
						}
						if (stackTrace[i1].getClassName().equals("org.eclipse.rcptt.tesla.internal.ui.player.SWTUIPlayer")
								&& stackTrace[i1].getMethodName().equals("exec")) {
							methodValue = stackTrace[i1 + 1].getMethodName() + ":"
									+ stackTrace[i1 + 1].getLineNumber();
							break;
						}
					}
					if (methodValue != null) {
						info.getInnerClassMap().put(className, /*className.substring(0, pos) + "." + */methodValue);
					}
				}
			}

			int classId = getID(className, info.getClassNames());
			int typeId = getID(kind, info.getTypesNames());

			long currentTime = System.currentTimeMillis();
			long currentTick = info.getTick();
			if (classId != -1 && typeId != -1) {
				EList<Q7WaitInfo> infos = info.getInfos();
				for (Q7WaitInfo i : infos) {
					if (i.getTypeId() == typeId && i.getClassId() == classId) {
						long lastTick = i.getLastTick();
						if (lastTick == currentTick || lastTick == currentTick - 1
								|| i.getEndTime() == currentTime) {
							// This is previous execution counter here
							i.setEndTime(currentTime);
							i.setLastTick(currentTick);
							if (lastTick != currentTick) {
								i.setTicks(i.getTicks() + 1);
							}
							return;
						}
					}
				}
			}
			if (classId == -1) {
				classId = info.getClassNames().size();
				info.getClassNames().add(className);
			}
			if (typeId == -1) {
				typeId = info.getTypesNames().size();
				info.getTypesNames().add(kind);
			}

			Q7WaitInfo i = InfoFactory.eINSTANCE.createQ7WaitInfo();
			info.getInfos().add(i);
			i.setTypeId(typeId);
			i.setClassId(classId);
			i.setStartTime(currentTime);
			i.setTicks(1);
			i.setLastTick(currentTick);// Set current counter
			i.setEndTime(i.getStartTime());
		}
	}

	private static int getID(String kind, List<String> values) {
		for (int i = 0; i < values.size(); i++) {
			String typeName = values.get(i);
			if (typeName.equals(kind)) {
				return i;
			}
		}
		return -1;
	}

}

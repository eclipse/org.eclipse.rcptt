/*******************************************************************************
 * Copyright (c) 2009, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
/**
* 
*/
package org.eclipse.rcptt.internal.launching.utils;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 
 * @author Artem Kovalev
 */
public class LogBuilder {

	private final int initialLogSize;
	private final int rotationLogSize;
	private final StringBuilder initialLog = new StringBuilder();
	private final StringBuilder rotationLog = new StringBuilder();
	private final ReadWriteLock lock = new ReentrantReadWriteLock();

	public LogBuilder(int initialLogSize, int rotationLogSize) {
		this.initialLogSize = initialLogSize;
		this.rotationLogSize = rotationLogSize;
	}

	public void append(String string) {
		try {
			lock.writeLock().lock();

			if (!isFilled(initialLog, initialLogSize)) {
				initialLog.append(string);
			} else if (!isFilled(rotationLog, rotationLogSize)) {
				rotationLog.append(string);
			} else {
				rotationLog.delete(0, string.length());
				rotationLog.append(string);
			}
		} finally {
			lock.writeLock().unlock();
		}

	}

	public void clear() {
		try {
			lock.writeLock().lock();

			initialLog.setLength(0);
			rotationLog.setLength(0);
		} finally {
			lock.writeLock().unlock();
		}
	}

	public String toString() {

		try {
			lock.readLock().lock();

			String result = "Initial log:";
			result += System.lineSeparator();
			result += initialLog.length() > 0 ? initialLog.toString() : "Empty.";
			result += System.lineSeparator();
			if (rotationLog.length() > 0) {
				result += "Rotation log:";
				result += System.lineSeparator();
				result += rotationLog.toString();
			}

			return result;
		} finally {
			lock.readLock().unlock();
		}
	}

	private boolean isFilled(StringBuilder builder, int maxSize) {
		return (builder.length() * 2) > maxSize;
	}
}

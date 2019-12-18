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
package org.eclipse.rcptt.ecl.core.util;

public interface ICommandFormatter {

	void newSequenceCommand();

	void newPipeCommand();

	void addCommandName(String name);

	void addAttrName(String name, boolean forced);

	void addAttrValue(String value);

	void addAttrValueWithLineBreak(String value);

	void openGroup(boolean singleLine);

	void closeGroup(boolean singleLine);

	void openExec();

	void closeExec();

	String toString();

}

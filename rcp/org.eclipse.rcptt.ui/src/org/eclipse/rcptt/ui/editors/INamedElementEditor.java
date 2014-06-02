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
package org.eclipse.rcptt.ui.editors;

import org.eclipse.core.runtime.IProgressMonitor;

public interface INamedElementEditor {

	boolean isDirty();

	void doSave(IProgressMonitor monitor);

	Object getAdapter(Class<?> class1);

	void renamed(boolean b);

	void setTags(String tags);

}

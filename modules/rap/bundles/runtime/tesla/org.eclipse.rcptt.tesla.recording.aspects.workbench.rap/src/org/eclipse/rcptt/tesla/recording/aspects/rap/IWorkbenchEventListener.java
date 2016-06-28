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
package org.eclipse.rcptt.tesla.recording.aspects.rap;

import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.statushandlers.StatusAdapter;

public interface IWorkbenchEventListener {
	void closeEditors(IEditorReference[] refArray);

	void restartEclipse();

	void recordAction(ActionType type);

	void recordAddStatus(StatusAdapter adapter, boolean modal);

	void recordStatusCleanup();
}

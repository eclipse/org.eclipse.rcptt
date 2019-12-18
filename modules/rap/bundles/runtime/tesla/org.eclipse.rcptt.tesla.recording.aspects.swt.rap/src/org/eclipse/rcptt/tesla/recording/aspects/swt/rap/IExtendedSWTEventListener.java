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
package org.eclipse.rcptt.tesla.recording.aspects.swt.rap;

import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Event;

public interface IExtendedSWTEventListener extends IBasicSWTEventListener {

	public void recordDragEvent(Event event);

	public void recordSWTDialog(Dialog dialog, Object result);

	public void recordTabFolderEvent(Control tabControl, int eventId);

	public void setCurrentEvent(Event event);

    public boolean needProceedEvent();

    public void recordRapDownloadHandler(String handler, String url, String fileOnBase64);
}

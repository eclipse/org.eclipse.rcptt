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
package org.eclipse.rcptt.ui.editors.quickfix;

import org.eclipse.core.resources.IMarker;
import org.eclipse.ui.IMarkerResolution;
import org.eclipse.ui.IMarkerResolutionGenerator;

import org.eclipse.rcptt.core.builder.Q7ProblemSources;

public class Q7ProblemResolutionGenerator implements IMarkerResolutionGenerator {

	@Override
	public IMarkerResolution[] getResolutions(IMarker marker) {
		int sourceId = marker.getAttribute(IMarker.SOURCE_ID, -1);
		int startOffset = marker.getAttribute(IMarker.CHAR_START, -1);
		int endOffset = marker.getAttribute(IMarker.CHAR_END, -1);

		if (Q7ProblemSources.WARN_OBSOLETE_GETPARAM_CMD.getSourceId() == sourceId) {
			return new IMarkerResolution[] {
					new GetParamCmdQuickFixer(startOffset, endOffset)
			};
		}
		return new IMarkerResolution[] {};
	}
}

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
package org.eclipse.rcptt.ctx.resources;

import org.eclipse.core.filebuffers.FileBuffers;
import org.eclipse.core.filebuffers.IFileBuffer;
import org.eclipse.core.filebuffers.ITextFileBufferManager;
import org.eclipse.core.filebuffers.LocationKind;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;

import org.eclipse.rcptt.ctx.impl.internal.resources.Activator;

public class FileBuffersUtilsImpl implements IFileBufferUtils {
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.rcptt.ctx.resources.IFileBuffersClear#perform()
	 */
	public void clearAll() {
		try {
			int counter = 10;
			while (true) {
				IFileBuffer[] fileBuffers = FileBuffers
						.getTextFileBufferManager().getFileBuffers();
				if (fileBuffers.length == 0) {
					return;
				}
				for (IFileBuffer iFileBuffer : fileBuffers) {
					try {
						FileBuffers.getTextFileBufferManager().disconnect(
								iFileBuffer.getLocation(), LocationKind.IFILE,
								new NullProgressMonitor());
					} catch (CoreException e) {
						Activator.log(e);
					}
				}
				counter--;
				if (counter == 0) {
					break;
				}
			}
		} catch (NoClassDefFoundError e) {
			// ignore
		}
	}

	public void syncLocation(IPath location) {
		try {
			ITextFileBufferManager mgr = FileBuffers.getTextFileBufferManager();
			IFileBuffer buffer = mgr
					.getFileBuffer(location, LocationKind.IFILE);
			if (buffer != null) {
				buffer.revert(new NullProgressMonitor());
			}
		} catch (NoClassDefFoundError e) {
			// ignore
		} catch (CoreException e) {
			Activator.log(e);
		}
	}
}

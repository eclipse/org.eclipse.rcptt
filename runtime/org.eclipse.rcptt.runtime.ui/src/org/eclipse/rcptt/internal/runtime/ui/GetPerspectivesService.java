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
package org.eclipse.rcptt.internal.runtime.ui;

import java.io.ByteArrayOutputStream;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.IPipe;
import org.eclipse.rcptt.ecl.runtime.IProcess;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.ImageLoader;
import org.eclipse.ui.IPerspectiveDescriptor;
import org.eclipse.ui.PlatformUI;

import org.eclipse.rcptt.core.ecl.core.model.PerspectiveInfo;
import org.eclipse.rcptt.core.ecl.core.model.PerspectivesList;
import org.eclipse.rcptt.core.ecl.core.model.Q7CoreFactory;

public class GetPerspectivesService implements ICommandService {

	public IStatus service(Command command, IProcess context)
			throws InterruptedException, CoreException {
		IPipe output = context.getOutput();
		PerspectivesList list = Q7CoreFactory.eINSTANCE
				.createPerspectivesList();

		IPerspectiveDescriptor[] perspectives = PlatformUI.getWorkbench()
				.getPerspectiveRegistry().getPerspectives();
		for (IPerspectiveDescriptor desc : perspectives) {
			try {
				if (desc.getLabel().contains("<")
						&& desc.getLabel().contains(">")) {
					continue;
				}
				PerspectiveInfo info = Q7CoreFactory.eINSTANCE
						.createPerspectiveInfo();
				info.setId(desc.getId());
				info.setLabel(desc.getLabel());
				info.setDescription(desc.getDescription());
				ImageDescriptor imgDesc = desc.getImageDescriptor();
				if (imgDesc != null) {
					Image image = imgDesc.createImage();
					if (image != null) {
						ImageLoader loader = new ImageLoader();
						loader.data = new ImageData[] { image.getImageData() };
						ByteArrayOutputStream stream = new ByteArrayOutputStream();
						loader.save(stream, SWT.IMAGE_PNG);
						image.dispose();
						info.setImage(stream.toByteArray());
					}
				}
				list.getPerspectives().add(info);
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
		output.write(list);
		return Status.OK_STATUS;
	}
}

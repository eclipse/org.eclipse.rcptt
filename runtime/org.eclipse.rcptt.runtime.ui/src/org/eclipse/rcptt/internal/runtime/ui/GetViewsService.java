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
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.runtime.ICommandService;
import org.eclipse.rcptt.ecl.runtime.IPipe;
import org.eclipse.rcptt.ecl.runtime.IProcess;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.ImageLoader;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.activities.WorkbenchActivityHelper;
import org.eclipse.ui.internal.intro.IIntroConstants;
import org.eclipse.ui.views.IViewCategory;
import org.eclipse.ui.views.IViewDescriptor;

import org.eclipse.rcptt.core.ecl.core.model.Q7CoreFactory;
import org.eclipse.rcptt.core.ecl.core.model.ViewInfo;
import org.eclipse.rcptt.core.ecl.core.model.ViewList;

@SuppressWarnings("restriction")
public class GetViewsService implements ICommandService {

	public IStatus service(Command command, IProcess context)
			throws InterruptedException, CoreException {
		IPipe output = context.getOutput();
		ViewList list = Q7CoreFactory.eINSTANCE.createViewList();

		IViewCategory[] categories = PlatformUI.getWorkbench()
				.getViewRegistry().getCategories();
		for (IViewCategory desc : categories) {
			ViewInfo info = Q7CoreFactory.eINSTANCE.createViewInfo();
			info.setId(desc.getId());
			info.setLabel(desc.getLabel());
			IViewDescriptor[] views = desc.getViews();
			for (IViewDescriptor descriptor : views) {
				if (WorkbenchActivityHelper.filterItem(descriptor)) {
					continue;
				}
				if (descriptor.getId().equals(IIntroConstants.INTRO_VIEW_ID)) {
					// Remove into view
					continue;
				}
				ViewInfo viewInfo = Q7CoreFactory.eINSTANCE.createViewInfo();
				viewInfo.setDescription(descriptor.getDescription());
				viewInfo.setId(descriptor.getId());
				viewInfo.setLabel(descriptor.getLabel());
				Image image = descriptor.getImageDescriptor().createImage();

				ImageLoader loader = new ImageLoader();
				loader.data = new ImageData[] { image.getImageData() };
				ByteArrayOutputStream stream = new ByteArrayOutputStream();
				loader.save(stream, SWT.IMAGE_PNG);
				image.dispose();
				viewInfo.setImage(stream.toByteArray());

				info.getItems().add(viewInfo);
			}
			if (!info.getItems().isEmpty()) {
				list.getItems().add(info);
			}
		}
		output.write(list);
		return Status.OK_STATUS;
	}
}

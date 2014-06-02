package org.eclipse.rcptt.tesla.jface;

import org.aspectj.lang.annotation.SuppressAjWarnings;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.CompositeImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;

import org.eclipse.rcptt.tesla.core.am.AspectManager;

public aspect ImageDescriptorAspect {
	public ImageDescriptorAspect() {
		AspectManager.activateAspect(JFaceAspectsActivator.PLUGIN_ID, this
				.getClass().getName());
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	after(ImageDescriptor descriptor) returning(Image result) : target(descriptor) && 
		execution(public Image ImageDescriptor.createImage(boolean, org.eclipse.swt.graphics.Device)) {
		ImageSources.INSTANCE.imageFromDescriptor(result, descriptor);
	}
	
	@SuppressAjWarnings("adviceDidNotMatch")
	after(ImageDescriptor descriptor) returning(ImageData result) : target(descriptor) &&
		execution(public ImageData ImageDescriptor+.getImageData()) {
		ImageSources.INSTANCE.imageDataFromDescriptor(result, descriptor);
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	after(ImageDescriptor descriptor, ImageData data) : target(descriptor) &&
		execution(protected void CompositeImageDescriptor.drawImage(ImageData,int,int)) &&
		args(data, int, int) {
		ImageSources.INSTANCE.imageDrawn(data, descriptor);
	}
}

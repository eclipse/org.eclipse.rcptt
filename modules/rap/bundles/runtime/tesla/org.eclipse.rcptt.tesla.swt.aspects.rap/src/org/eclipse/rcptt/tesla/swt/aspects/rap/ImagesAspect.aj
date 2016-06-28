package org.eclipse.rcptt.tesla.swt.aspects.rap;

import org.aspectj.lang.annotation.SuppressAjWarnings;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.rcptt.tesla.core.am.rap.AspectManager;
import org.eclipse.rcptt.tesla.swt.images.ImageDataMapping;

public aspect ImagesAspect {
	public ImagesAspect() {
		AspectManager.activateAspect(SWTAspectActivator.PLUGIN_ID, this
				.getClass().getName());
	}
	
	@SuppressAjWarnings("adviceDidNotMatch")
	after(Image image) returning(ImageData result): target(image) &&
		execution(public ImageData Image.getImageData()) {
		ImageDataMapping.INSTANCE.imageDataFromImage(result, image);
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	after(Image image, ImageData imageData) : execution(public Image.new(Device, ImageData)) 
		&& this(image) && args(Device, imageData) { 
		ImageDataMapping.INSTANCE.imageFromImageData(image, imageData);
	}
	
	@SuppressAjWarnings("adviceDidNotMatch")
	after(Image image, ImageData imageData) : execution(public Image.new(Device, ImageData, ImageData)) 
		&& this(image) && args(Device, imageData, ImageData) { 
		ImageDataMapping.INSTANCE.imageFromImageData(image, imageData);
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	after(Image source, Image result) : execution(public Image.new(Device, Image, int))
		&& this(result) && args(Device, source, int) {
		ImageDataMapping.INSTANCE.imageFromImage(result, source);
	}
	
	@SuppressAjWarnings("adviceDidNotMatch")
	after(ImageData source) returning(ImageData result) : target(source) 
		&& execution(public ImageData ImageData.clone()) {
		ImageDataMapping.INSTANCE.imageDataFromImageData(result, source);
	}

}

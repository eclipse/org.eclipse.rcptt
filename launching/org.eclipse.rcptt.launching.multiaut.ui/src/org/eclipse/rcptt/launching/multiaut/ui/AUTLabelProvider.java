package org.eclipse.rcptt.launching.multiaut.ui;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.rcptt.ui.launching.aut.AUTProvider;
import org.eclipse.rcptt.ui.launching.aut.AutElement;
import org.eclipse.swt.graphics.Image;

public class AUTLabelProvider extends LabelProvider {
	@Override
	public String getText(Object element) {
		if (element instanceof AutElement) {
			return AUTProvider.getText((AutElement) element);
		}
		return super.getText(element);
	}

	@Override
	public Image getImage(Object element) {
		if (element instanceof AutElement) {
			AutElement e = (AutElement) element;
			return AUTProvider.getImage(e);
		}
		return super.getImage(element);
	}
}
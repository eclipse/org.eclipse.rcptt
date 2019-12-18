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
package org.eclipse.rcptt.ui.actions;

import org.eclipse.core.resources.IResource;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.StyledCellLabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.swt.widgets.Widget;

import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.internal.ui.Images;
import org.eclipse.rcptt.internal.ui.Messages;
import org.eclipse.rcptt.ui.utils.ModelUtils;

public class Q7ElementLabelProvider extends StyledCellLabelProvider implements
		ILabelProvider {
	protected boolean fullPath = true;

	public Q7ElementLabelProvider() {
	}

	public Q7ElementLabelProvider(boolean fullPath) {
		this.fullPath = fullPath;
	}

	@Override
	public void update(ViewerCell cell) {
		Object element = cell.getElement();
		Control ctrl = cell.getControl();
		Widget item = cell.getViewerRow().getItem();
		int index = 0;
		if (ctrl instanceof Tree) {
			index = ((Tree) ctrl).indexOf((TreeItem) item);
		} else if (ctrl instanceof Table) {
			index = ((Table) ctrl).indexOf((TableItem) item);
		}

		StyledString styled = getStyledText(element, index);
		cell.setText(styled.getString());
		cell.setStyleRanges(styled.getStyleRanges());
		cell.setImage(getImage(element));
	}

	public Image getImage(Object element) {
		if (element instanceof IQ7NamedElement) {
			return ModelUtils.getImage((IQ7NamedElement) element);
		}
		return Images.getImage(Images.UNKNOWN);
	}

	public String getText(Object element) {
		if (element instanceof IQ7NamedElement) {
			IQ7NamedElement namedElement = (IQ7NamedElement) element;
			StringBuilder builder = new StringBuilder();
			builder.append(ModelUtils.getText(namedElement));
			IResource file = namedElement.getResource();
			if (file != null) {
				builder.append(" ("); //$NON-NLS-1$
				if (fullPath) {
					builder.append(file.getFullPath().toString().substring(1));
				} else {
					builder.append(file.getProject().getName());
				}
				builder.append(')');

				if (namedElement.isWorkingCopy())
					builder.append(" (working copy)");
			}
			return builder.toString();
		}
		return Messages.NamedElementLabelProvider_UnknownElementText;
	}

	public StyledString getStyledText(Object element, int rowIndex) {
		if (element instanceof IQ7NamedElement) {
			IQ7NamedElement namedElement = (IQ7NamedElement) element;
			StyledString styled = new StyledString();
			styled.append(ModelUtils.getText(namedElement));
			IResource file = namedElement.getResource();
			int index = styled.length();
			if (file != null) {
				styled.append(" ("); //$NON-NLS-1$
				if (fullPath) {
					styled.append(file.getFullPath().toString().substring(1));
				} else {
					styled.append(file.getProject().getName());
				}
				styled.setStyle(index, styled.length() - index,
						StyledString.QUALIFIER_STYLER);

				addExtraAnnotation(namedElement, styled, rowIndex);
				styled.append(')');

				styled.setStyle(styled.length() - 1, 1,
						StyledString.QUALIFIER_STYLER);
			}

			if (namedElement.isWorkingCopy())
				styled.append(" (working copy)", StyledString.QUALIFIER_STYLER);

			return styled;
		}
		return new StyledString(
				Messages.NamedElementLabelProvider_UnknownElementText);
	}

	protected void addExtraAnnotation(IQ7NamedElement namedElement,
			StyledString styled, int rowIndex) {
	}
}
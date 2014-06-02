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
package org.eclipse.rcptt.ui.refactoring.delete;

import java.util.List;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.layout.LayoutConstants;
import org.eclipse.ltk.core.refactoring.participants.DeleteRefactoring;
import org.eclipse.ltk.ui.refactoring.RefactoringWizard;
import org.eclipse.ltk.ui.refactoring.UserInputWizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;

import org.eclipse.rcptt.core.tags.Tag;
import org.eclipse.rcptt.internal.ui.Messages;

public class DeleteTagWizard extends RefactoringWizard {

	public DeleteTagWizard(List<Tag> tags) {
		super(new DeleteRefactoring(new DeleteTagProcessor(tags)),
				DIALOG_BASED_USER_INTERFACE);
		setDefaultPageTitle(Messages.DeleteTagWizard_PageTitle);
		setWindowTitle(Messages.DeleteTagWizard_WindowTitle);
	}

	@Override
	protected void addUserInputPages() {
		DeleteTagProcessor processor = (DeleteTagProcessor) getRefactoring()
				.getAdapter(DeleteTagProcessor.class);
		addPage(new DeleteTagPage(processor));
	}

	final private static class DeleteTagPage extends UserInputWizardPage {

		private final DeleteTagProcessor processor;

		public DeleteTagPage(DeleteTagProcessor processor) {
			super("RenameTagRefactoringInputPage"); //$NON-NLS-1$
			this.processor = processor;
		}

		public void createControl(Composite parent) {
			initializeDialogUnits(parent);
			Point defaultSpacing = LayoutConstants.getSpacing();
			Composite composite = new Composite(parent, SWT.NONE);
			GridLayoutFactory.swtDefaults().numColumns(2)
					.spacing(defaultSpacing.x * 2, defaultSpacing.y)
					.applyTo(composite);
			composite.setFont(parent.getFont());

			Display display = parent.getDisplay();
			Image image = new Image(display,
					display.getSystemImage(SWT.ICON_QUESTION), SWT.IMAGE_COPY);
			Label imageLabel = new Label(composite, SWT.NULL);
			imageLabel.setBackground(image.getBackground());
			imageLabel.setImage(image);
			GridDataFactory.swtDefaults().align(SWT.CENTER, SWT.BEGINNING)
					.span(1, 2).applyTo(imageLabel);

			List<Tag> tags = processor.getTags();
			String message;
			if (tags.size() == 1) {
				Tag tag = tags.get(0);
				message = Messages.bind(
						Messages.DeleteTagWizard_OneTagMsg,
						tag.getPath());
			} else {
				message = Messages.bind(
						Messages.DeleteTagWizard_ManyTagsMsg,
						tags.size());
			}

			Label label = new Label(composite, SWT.WRAP);
			label.setFont(parent.getFont());
			label.setText(message);
			GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, false);
			gridData.widthHint = convertHorizontalDLUsToPixels(IDialogConstants.MINIMUM_MESSAGE_AREA_WIDTH);
			label.setLayoutData(gridData);

			setControl(composite);
		}
	}

}

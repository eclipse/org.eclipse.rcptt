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
package org.eclipse.rcptt.ctx.workbench.ui.views;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.fieldassist.ControlDecoration;
import org.eclipse.jface.fieldassist.FieldDecoration;
import org.eclipse.jface.fieldassist.FieldDecorationRegistry;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.IOpenListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.OpenEvent;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StyledCellLabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.rcptt.core.model.IContext;
import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.model.IQ7Project;
import org.eclipse.rcptt.core.model.ModelException;
import org.eclipse.rcptt.core.model.search.Q7SearchCore;
import org.eclipse.rcptt.core.scenario.FileEditor;
import org.eclipse.rcptt.core.scenario.NamedElement;
import org.eclipse.rcptt.internal.core.model.ReferencedProjectScope;
import org.eclipse.rcptt.internal.ui.Images;
import org.eclipse.rcptt.internal.ui.Q7UIPlugin;
import org.eclipse.rcptt.resources.WSUtils;
import org.eclipse.rcptt.resources.ui.viewers.WorkspaceContentProvider;
import org.eclipse.rcptt.workspace.WSFile;
import org.eclipse.rcptt.workspace.WorkspaceContext;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.TextStyle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;

public class SelectEditorFileDialog extends Dialog {

	private Text text;
	private IQ7Project group;
	private String path = "";
	private static String DESCRIPTION_EMPTY_NAME = "Path must be non-blank string";
	private static String DESCRIPTION_DUPLICATE_NAME = "Current path is already added into context";
	protected ControlDecoration nameDecoration;
	private HashSet<String> disabledPaths = new HashSet<String>();

	public SelectEditorFileDialog(Shell parentShell,
			IQ7Project group,
			List<Object> disabledFiles) {
		super(parentShell);
		setShellStyle(getShellStyle() | SWT.RESIZE);
		this.group = group;
		for (Object file : disabledFiles) {
			if (file instanceof FileEditor) {
				disabledPaths.add(((FileEditor) file).getPath());
			}
		}
	}

	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("Select file path");
	}

	@Override
	protected Point getInitialSize() {
		return new Point(520, 500);
	}

	public String getPath() {
		return path;
	}

	@Override
	protected Control createContents(Composite parent) {
		Control control = super.createContents(parent);
		validate();
		return control;
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite composite = (Composite) super.createDialogArea(parent);
		((GridLayout) composite.getLayout()).numColumns = 2;
		composite.setLayoutData(new GridData(GridData.FILL_BOTH));
		Label descriptionLabel = new Label(composite, SWT.LEFT | SWT.WRAP);
		descriptionLabel
				.setText("Enter file path to open or select file from the one of the workspace contexts");		
		
		GridData data = new GridData(GridData.FILL_HORIZONTAL);		
		data.horizontalSpan = 2;
		descriptionLabel.setLayoutData(data);
		Label filePathLabel = new Label(composite, SWT.LEFT);
		filePathLabel.setText("File path: ");
		
		nameDecoration = new ControlDecoration(filePathLabel, SWT.TOP | SWT.RIGHT);
		FieldDecoration errorFieldIndicator = FieldDecorationRegistry
				.getDefault().getFieldDecoration(
						FieldDecorationRegistry.DEC_ERROR);
		nameDecoration.setImage(errorFieldIndicator.getImage());				
		nameDecoration.setShowHover(true);
		nameDecoration.hide();
		
		text = new Text(composite, SWT.BORDER);
		data = new GridData(GridData.FILL_HORIZONTAL);
		data.horizontalIndent = 5;
		text.setLayoutData(data);
		text.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				path = text.getText();
				validate();
			}
		});
		createWorkspaces(composite);
		applyDialogFont(composite);
		return composite;
	}

	private boolean validate() {
		boolean duplicate = disabledPaths.contains(path);
		boolean named = path.length() > 0; 
		boolean validated = !duplicate && named;
		
		getButton(OK).setEnabled(validated);
		if (validated) {
			nameDecoration.hide();
		}
		else {			
			if (!duplicate) 
				nameDecoration.setDescriptionText(DESCRIPTION_EMPTY_NAME);
			else
				nameDecoration.setDescriptionText(DESCRIPTION_DUPLICATE_NAME);
			nameDecoration.show();
		}
		return validated;
	}

	private void createWorkspaces(Composite parent) {
		Tree tree = new Tree(parent, SWT.BORDER);
		TreeViewer viewer = new TreeViewer(tree);
		viewer.setLabelProvider(new EditorLabelProvider(disabledPaths));
		viewer.setContentProvider(new ContentProvider());
		List<WorkspaceContext> contexts = new ArrayList<WorkspaceContext>();
		IQ7NamedElement[] elements = Q7SearchCore
				.findAllElements(new ReferencedProjectScope(group));
		for (IQ7NamedElement iq7NamedElement : elements) {
			if (iq7NamedElement instanceof IContext) {
				try {
					NamedElement element = iq7NamedElement.getNamedElement();
					if (element instanceof WorkspaceContext) {
						contexts.add((WorkspaceContext) element);
					}
				} catch (ModelException e) {
					Q7UIPlugin.log(e);
				}
			}
		}

		viewer.setInput(contexts.toArray());
		viewer.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				IStructuredSelection sel = (IStructuredSelection) event
						.getSelection();
				Object element = sel.getFirstElement();
				if (element instanceof WSFile) {
					text.setText(WSUtils.getPath((WSFile) element).toString());
				}
			}
		});
		viewer.addOpenListener(new IOpenListener() {
			public void open(OpenEvent event) {
				IStructuredSelection sel = (IStructuredSelection) event
						.getSelection();
				Object element = sel.getFirstElement();
				if (element instanceof WSFile) {
					text.setText(WSUtils.getPath((WSFile) element).toString());
					if (validate()) {
						okPressed();
					}
				}
			}
		});
		GridData data = new GridData(GridData.FILL_BOTH);
		data.horizontalSpan = 2;
		tree.setLayoutData(data);
	}

	private class EditorLabelProvider extends StyledCellLabelProvider implements
			ILabelProvider {

		private WorkspaceLabelProvider wlp;
		private ItalicStyler styler = new ItalicStyler();
		private Set<String> disabledItems;		
		
		public EditorLabelProvider(Set<String> disabledItems) {
			super(StyledCellLabelProvider.COLORS_ON_SELECTION);
			wlp = new WorkspaceLabelProvider();
			this.disabledItems = disabledItems;
		}

		@Override
		public void update(ViewerCell cell) {
			Object element = cell.getElement();
			StyledString styled = getStyledText(element);
			cell.setText(styled.getString());
			cell.setStyleRanges(styled.getStyleRanges());
			cell.setImage(getImage(element));
		}
		
		private class ItalicStyler extends StyledString.Styler {
									
			@Override
			public void applyStyles(TextStyle textStyle) {
				textStyle.foreground = Display.getCurrent().getSystemColor(SWT.COLOR_DARK_GRAY);								
				textStyle.font = JFaceResources.getFontRegistry().getItalic(JFaceResources.DEFAULT_FONT);
			}					
		}
		
		public StyledString getStyledText(Object element) {
			if (element instanceof WSFile) {
				String elemPath = WSUtils.getPath((WSFile) element).toString();
				if (disabledItems.contains(elemPath)) {
					StyledString styled = new StyledString(getText(element));
					int ind = styled.length() + 1;					
					styled.append(" (already in use)");						
					styled.setStyle(ind, styled.length() - ind, styler);					
					return styled;
				}
			}
			return new StyledString(getText(element));
		}					
		
		public Image getImage(Object element) {
			if (element instanceof WorkspaceContext) {
				return Images.getImage(Images.WORKSPACE);
			}
			return wlp.getImage(element);
		}

		public String getText(Object element) {
			if (element instanceof WorkspaceContext) {
				return ((WorkspaceContext) element).getName();
			}
			return wlp.getText(element);
		}

	}

	private class ContentProvider implements ITreeContentProvider {

		private WorkspaceContentProvider wcp;

		public ContentProvider() {
			wcp = new WorkspaceContentProvider();
		}

		public Object[] getChildren(Object parentElement) {
			if (parentElement instanceof WorkspaceContext) {
				return wcp.getElements(parentElement);
			}
			return wcp.getChildren(parentElement);
		}

		public Object getParent(Object element) {
			return null;
		}

		public boolean hasChildren(Object element) {
			if (element instanceof WorkspaceContext) {
				return wcp.getElements(element).length > 0;
			}
			return wcp.hasChildren(element);
		}

		public Object[] getElements(Object inputElement) {
			return (Object[]) inputElement;
		}

		public void dispose() {
		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}

	}

}

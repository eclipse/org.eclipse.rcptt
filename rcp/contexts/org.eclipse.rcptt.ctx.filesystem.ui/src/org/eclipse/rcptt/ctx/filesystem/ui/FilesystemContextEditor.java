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
package org.eclipse.rcptt.ctx.filesystem.ui;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.Binding;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.databinding.validation.ValidationStatus;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.variables.VariablesPlugin;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.databinding.fieldassist.ControlDecorationSupport;
import org.eclipse.jface.databinding.fieldassist.ControlDecorationUpdater;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.fieldassist.ControlDecoration;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.window.Window;
import org.eclipse.pde.launching.IPDELauncherConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.IWorkbenchSite;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.IFormColors;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;

import org.eclipse.rcptt.core.model.ModelException;
import org.eclipse.rcptt.ctx.filesystem.FileSystemResolver;
import org.eclipse.rcptt.ctx.filesystem.PrefixScheme;
import org.eclipse.rcptt.ctx.filesystem.ui.actions.AddFiles;
import org.eclipse.rcptt.ctx.filesystem.ui.actions.AddFolder;
import org.eclipse.rcptt.ctx.filesystem.ui.actions.FSAction;
import org.eclipse.rcptt.ctx.filesystem.ui.actions.Remove;
import org.eclipse.rcptt.filesystem.FSCaptureParam;
import org.eclipse.rcptt.filesystem.FSResource;
import org.eclipse.rcptt.filesystem.FilesystemContext;
import org.eclipse.rcptt.filesystem.FilesystemFactory;
import org.eclipse.rcptt.filesystem.FilesystemPackage;
import org.eclipse.rcptt.internal.ui.Q7UIPlugin;
import org.eclipse.rcptt.launching.AutLaunch;
import org.eclipse.rcptt.launching.IQ7Launch;
import org.eclipse.rcptt.ui.commons.OneSelectionListener;
import org.eclipse.rcptt.ui.context.BaseContextEditor;
import org.eclipse.rcptt.ui.controls.SectionWithComposite;
import org.eclipse.rcptt.ui.editors.EditorHeader;
import org.eclipse.rcptt.ui.launching.LaunchUtils;
import org.eclipse.rcptt.ui.utils.UIContentAdapter;

public class FilesystemContextEditor extends BaseContextEditor {

	public FilesystemContext getContextElement() {
		try {
			return (FilesystemContext) super.getElement().getNamedElement();
		} catch (ModelException e) {
			Q7UIPlugin.log(e);
		}
		return null;
	}

	@Override
	public EObject getCreateParam(AutLaunch launch) throws CoreException {
		String path = getContextElement().getPath();
		FileSystemResolver resolver = createResolver(launch);

		if (!resolver.isDirectory(path)) {
			FilesystemContentRootPathDialog dialog = new FilesystemContentRootPathDialog(
					PlatformUI.getWorkbench()
							.getActiveWorkbenchWindow().getShell(),
					path,
					resolver);
			if (dialog.open() == Window.OK) {
				getContextElement().setPath(dialog.getRootpath());
			} else {
				throw new CoreException(Status.CANCEL_STATUS);
			}
		}
		FSCaptureParam param = FilesystemFactory.eINSTANCE
				.createFSCaptureParam();
		param.setPath(getContextElement().getPath());
		param.setClear(getContextElement().isClear());
		return param;
	}

	private EditorHeader header;
	private TreeViewer viewer;

	public Control create(Composite parent, FormToolkit toolkit,
			IWorkbenchSite site, EditorHeader header) {
		this.header = header;

		if (getContextElement().getRoot() == null) {
			getContextElement().setRoot(
					FilesystemFactory.eINSTANCE.createFSFolder());
		}

		Section section = new SectionWithComposite("Folder", Section.TITLE_BAR
				| Section.TWISTIE | Section.EXPANDED).create(parent, toolkit);
		Composite client = (Composite) section.getClient();
		GridLayoutFactory.fillDefaults().numColumns(2).spacing(10, 10)
				.applyTo(client);

		createRootControls(toolkit, client);
		createOptionsControls(toolkit, client);
		createTree(toolkit, client);
		createButtons(toolkit, client);

		setSelection(null);

		return section;
	}

	private List<Button> buttons = new ArrayList<Button>();

	private void createButtons(FormToolkit toolkit, Composite client) {
		Composite panel = toolkit.createComposite(client);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.BEGINNING)
				.applyTo(panel);
		RowLayout layout = new RowLayout(SWT.VERTICAL);
		layout.pack = false;
		layout.marginBottom = 0;
		layout.marginLeft = 0;
		layout.marginTop = 0;
		layout.marginRight = 0;
		panel.setLayout(layout);

		createButton(panel, toolkit, new AddFiles());
		createButton(panel, toolkit, new AddFolder());
		createButton(panel, toolkit, removeAction = new Remove());

		setSelection(null);
	}

	private void createButton(Composite parent, FormToolkit toolkit,
			final FSAction action) {
		action.setViewer(viewer);
		Button button = toolkit
				.createButton(parent, action.getText(), SWT.PUSH);
		button.setData(action);
		Image image = action.getImageDescriptor().createImage();
		button.setImage(image);
		button.setToolTipText(action.getToolTipText());
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				action.run();
			}
		});
		buttons.add(button);
	}

	private void setSelection(FSResource[] selection) {
		for (Button button : buttons) {
			FSAction action = (FSAction) button.getData();
			action.setSelection(selection);
			button.setEnabled(action.isEnabled());
		}
	}

	private boolean expandOrCollapse = false;

	private void createTree(FormToolkit toolkit, Composite client) {
		final Tree tree = new Tree(client, SWT.BORDER | SWT.MULTI);
		GridDataFactory.fillDefaults().grab(true, true).span(1, 1)
				.hint(100, 50).applyTo(tree);
		viewer = new TreeViewer(tree);

		viewer.setLabelProvider(new FilesystemContextLabelProvider());
		viewer.setContentProvider(new FilesystemContextContentProvider());
		viewer.setInput(getContextElement());

		viewer.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				IStructuredSelection sel = (IStructuredSelection) viewer
						.getSelection();
				Object[] res = sel.toArray();
				FSResource[] resources = new FSResource[res.length];
				for (int i = 0; i < res.length; i++)
					resources[i] = (FSResource) res[i];
				setSelection(resources);
			}
		});

		tree.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				if (expandOrCollapse || e.button != 1) {
					expandOrCollapse = false;
					return;
				}

				TreeItem item = tree.getItem(new Point(e.x, e.y));
				if (item == null) {
					tree.deselectAll();
					setSelection(null);
				}
			}
		});

		tree.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				expandOrCollapse = false;
			}

			public void keyReleased(KeyEvent e) {
				expandOrCollapse = false;
			}
		});

		tree.addListener(SWT.Expand, new Listener() {
			public void handleEvent(Event event) {
				expandOrCollapse = true;
			}
		});

		tree.addListener(SWT.Collapse, new Listener() {
			public void handleEvent(Event event) {
				expandOrCollapse = true;
			}
		});

		tree.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				viewer.getControl().addKeyListener(new KeyListener() {

					public void keyReleased(KeyEvent e) {
					}

					public void keyPressed(KeyEvent e) {
						if (e.stateMask != 0)
							return;

						switch (e.keyCode) {
						case SWT.DEL:
							if (removeAction.isEnabled()) {
								removeAction.run();
								e.doit = false;
							}
							break;
						}
					}
				});
			}
		});

		UIContentAdapter adapter = new UIContentAdapter() {
			@Override
			protected void changed(Notification notification) {
				if (viewer.getControl().isDisposed()) {
					return;
				}
				viewer.refresh();
			}
		};
		getContextElement().eAdapters().add(adapter);
	}

	private void createOptionsControls(FormToolkit toolkit, Composite client) {
		final Button clearCheckbox = toolkit.createButton(client,
				"Clear root folder before context application", SWT.CHECK);
		GridDataFactory.fillDefaults().span(3, 1).applyTo(clearCheckbox);

		UpdateValueStrategy strategy = new UpdateValueStrategy(
				UpdateValueStrategy.POLICY_ON_REQUEST);
		final Binding binding = dbc.bindValue(SWTObservables
				.observeSelection(clearCheckbox), EMFObservables.observeValue(
				getContextElement(),
				FilesystemPackage.Literals.FILESYSTEM_CONTEXT__CLEAR),
				strategy, null);
		clearCheckbox.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (clearCheckbox.getSelection() && !isClearConfirmed()) {
					clearCheckbox.setSelection(false);
					return;

				}
				binding.updateTargetToModel();
			}
		});
	}

	private boolean isClearConfirmed() {
		String path = getContextElement().getPath();
		if (path == null || path.isEmpty()) {
			path = "selected root path";
		} else if (currentResolver != null) {
			String resolvedPath = currentResolver.resolve(path);
			if (resolvedPath != null) {
				path = resolvedPath;
			}
		}
		return MessageDialog
				.openQuestion(
						viewer.getControl().getShell(),
						"Confirm folder clear",
						String.format(
								"Enabling this option will cause a complete "
										+ "removal of %s during context apply. Do you want to enable it?",
								path));
	}

	private void createRootControls(final FormToolkit toolkit,
			final Composite client) {
		Composite panel = toolkit.createComposite(client);
		GridDataFactory.fillDefaults().span(2, 1).applyTo(panel);
		GridLayoutFactory.fillDefaults().numColumns(3).spacing(10, 10)
				.applyTo(panel);

		Label rootLabel = toolkit.createLabel(panel, "Root path:");
		rootLabel
				.setForeground(toolkit.getColors().getColor(IFormColors.TITLE));
		rootLabel.setBackground(null);

		Text rootText = toolkit.createText(panel, "", SWT.BORDER);
		GridDataFactory.fillDefaults().
				grab(true, false).
				hint(1, SWT.DEFAULT).
				applyTo(rootText);
		Binding rootBinding = dbc.bindValue(SWTObservables.observeText(
				rootText, SWT.Modify), EMFObservables.observeValue(
				getContextElement(),
				FilesystemPackage.Literals.FILESYSTEM_CONTEXT__PATH),
				rootStrategy, rootStrategy);
		ControlDecorationSupport.create(rootBinding, SWT.TOP | SWT.LEFT, panel,
				new ControlDecorationUpdater() {
					@Override
					protected void update(ControlDecoration decoration,
							IStatus status) {
						decoration.setMarginWidth(2);
						super.update(decoration, status);
					}
				});

		Button browseButton = toolkit
				.createButton(panel, "Browse...", SWT.PUSH);
		browseButton.addSelectionListener(new OneSelectionListener() {
			@Override
			public void selected(SelectionEvent e) {
				AutLaunch launch = LaunchUtils.selectAutLaunch(client
						.getShell());
				if (launch == null)
					return;

				DirectoryDialog dialog = new DirectoryDialog(client.getShell());
				String result = dialog.open();
				if (result != null) {
					getContextElement().setPath(makeRootPath(result, launch));
				}
			}
		});
	}

	private static String substituteAndCanonicalize(String value) {
		String result = value;
		try {
			result = VariablesPlugin.getDefault().getStringVariableManager()
					.performStringSubstitution(value, false);
		} catch (CoreException e) {
		}

		try {
			result = new File(result).getCanonicalPath();
		} catch (IOException e) {
		}

		return result;
	}

	private String makeRootPath(String path, AutLaunch launch) {
		String made = getResolvedPath(path, launch);
		if (made != null)
			path = made;

		return path;
	}

	private FileSystemResolver currentResolver = null;

	private FileSystemResolver createResolver(AutLaunch launch) {
		FileSystemResolver resolver = new FileSystemResolver();

		ILaunchConfiguration config = launch.getAut().getConfig();
		if (config != null) {
			{ // workspace
				try {
					String location = config.getAttribute(
							IPDELauncherConstants.LOCATION, (String) null);
					if (location != null && location.length() > 0)
						resolver.register(new PrefixScheme(
								PrefixScheme.WORKSPACE,
								substituteAndCanonicalize(location)));
				} catch (CoreException e) {
					Q7UIPlugin.log(e);
				}
			}

			{ // aut
				try {
					String location = config.getAttribute(
							IQ7Launch.AUT_LOCATION, (String) null);
					if (location != null && location.length() > 0)
						resolver.register(new PrefixScheme(PrefixScheme.AUT,
								substituteAndCanonicalize(location)));
				} catch (CoreException e) {
					Q7UIPlugin.log(e);
				}
			}
		}

		{ // file
			resolver.register(new PrefixScheme(PrefixScheme.FILE, null));
		}

		{ // home
			resolver.register(new PrefixScheme(PrefixScheme.HOME, new File(
					System.getProperty("user.home")).getAbsolutePath()));
		}
		return resolver;
	}

	private String getResolvedPath(String path, AutLaunch launch) {
		currentResolver = createResolver(launch);
		return currentResolver.make(path);
	}

	// --

	private UpdateValueStrategy rootStrategy = new UpdateValueStrategy() {
		{
			this.setBeforeSetValidator(new IValidator() {
				public IStatus validate(Object value) {
					String path = (String) value;

					// TODO: more sophisticated path validity checking
					if (path == null || path.length() == 0) {
						header.getRecordButton().setEnabled(false);
						header.getReplayButton().setEnabled(false);
						return ValidationStatus
								.warning("No root path provided.");
					}

					header.getRecordButton().setEnabled(true);
					header.getReplayButton().setEnabled(true);
					return ValidationStatus.ok();
				}
			});
		}
	};

	private Remove removeAction;
}

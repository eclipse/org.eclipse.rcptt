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
package org.eclipse.rcptt.ui.resources.wizards;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.FileSystemElement;
import org.eclipse.ui.dialogs.IOverwriteQuery;
import org.eclipse.ui.dialogs.TypeFilteringDialog;
import org.eclipse.ui.model.WorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.eclipse.ui.model.WorkbenchViewerComparator;
import org.eclipse.ui.wizards.datatransfer.IImportStructureProvider;

import org.eclipse.rcptt.core.persistence.IPersistenceModel;
import org.eclipse.rcptt.core.persistence.PersistenceManager;
import org.eclipse.rcptt.ctx.resources.ImportUtils;
import org.eclipse.rcptt.ctx.resources.WSUtils;
import org.eclipse.rcptt.ui.utils.MinimizedFileSystemElement;
import org.eclipse.rcptt.util.FileUtil;
import org.eclipse.rcptt.workspace.WSContainer;
import org.eclipse.rcptt.workspace.WSFile;
import org.eclipse.rcptt.workspace.WSFolder;

@SuppressWarnings({ "rawtypes", "restriction" })
public class WizardFileSystemResourceImportPage1 extends WizardPage implements
		Listener, IOverwriteQuery {
	// widgets
	protected Combo sourceNameField;

	protected Button overwriteExistingResourcesCheckbox;

	protected Button createContainerStructureButton;

	protected Button createOnlySelectedButton;

	protected Button sourceBrowseButton;

	protected Button selectTypesButton;

	protected Button selectAllButton;

	protected Button deselectAllButton;

	// widgets
	private Text containerNameField;

	protected java.util.List selectedTypes = new ArrayList();

	/**
	 * The <code>selectionGroup</code> field should have been created with a
	 * private modifier. Subclasses should not access this field directly.
	 */

	protected org.eclipse.ui.internal.ide.dialogs.ResourceTreeAndListGroup selectionGroup;

	// A boolean to indicate if the user has typed anything
	private boolean entryChanged = false;

	private org.eclipse.ui.internal.ide.filesystem.FileSystemStructureProvider fileSystemStructureProvider = new org.eclipse.ui.internal.ide.filesystem.FileSystemStructureProvider();

	protected static final int COMBO_HISTORY_LENGTH = 5;

	// dialog store id constants
	private final static String STORE_SOURCE_NAMES_ID = "WizardFileSystemResourceImportPage1.STORE_SOURCE_NAMES_ID";//$NON-NLS-1$

	private final static String STORE_OVERWRITE_EXISTING_RESOURCES_ID = "WizardFileSystemResourceImportPage1.STORE_OVERWRITE_EXISTING_RESOURCES_ID";//$NON-NLS-1$

	private final static String STORE_CREATE_CONTAINER_STRUCTURE_ID = "WizardFileSystemResourceImportPage1.STORE_CREATE_CONTAINER_STRUCTURE_ID";//$NON-NLS-1$

	private static final String SELECT_TYPES_TITLE = org.eclipse.ui.internal.wizards.datatransfer.DataTransferMessages.DataTransfer_selectTypes;

	private static final String SELECT_ALL_TITLE = org.eclipse.ui.internal.wizards.datatransfer.DataTransferMessages.DataTransfer_selectAll;

	private static final String DESELECT_ALL_TITLE = org.eclipse.ui.internal.wizards.datatransfer.DataTransferMessages.DataTransfer_deselectAll;

	private static final String SELECT_SOURCE_TITLE = org.eclipse.ui.internal.wizards.datatransfer.DataTransferMessages.FileImport_selectSourceTitle;

	private static final String SELECT_SOURCE_MESSAGE = org.eclipse.ui.internal.wizards.datatransfer.DataTransferMessages.FileImport_selectSource;

	protected static final String SOURCE_EMPTY_MESSAGE = org.eclipse.ui.internal.wizards.datatransfer.DataTransferMessages.FileImport_sourceEmpty;

	// constants
	protected static final int SIZING_TEXT_FIELD_WIDTH = 250;

	private WSContainer container;

	/**
	 * Creates an instance of this class
	 * 
	 * @param aWorkbench
	 *            IWorkbench
	 * @param selection
	 *            IStructuredSelection
	 */
	public WizardFileSystemResourceImportPage1(WSContainer container) {
		super("fileSystemImportPage1");
		setTitle("File system");
		setDescription("Import resources from the local file system.");
		this.container = container;
	}

	/**
	 * Creates a new button with the given id.
	 * <p>
	 * The <code>Dialog</code> implementation of this framework method creates a
	 * standard push button, registers for selection events including button
	 * presses and registers default buttons with its shell. The button id is
	 * stored as the buttons client data. Note that the parent's layout is
	 * assumed to be a GridLayout and the number of columns in this layout is
	 * incremented. Subclasses may override.
	 * </p>
	 * 
	 * @param parent
	 *            the parent composite
	 * @param id
	 *            the id of the button (see <code>IDialogConstants.*_ID</code>
	 *            constants for standard dialog button ids)
	 * @param label
	 *            the label from the button
	 * @param defaultButton
	 *            <code>true</code> if the button is to be the default button,
	 *            and <code>false</code> otherwise
	 */
	protected Button createButton(Composite parent, int id, String label,
			boolean defaultButton) {
		// increment the number of columns in the button bar
		((GridLayout) parent.getLayout()).numColumns++;

		Button button = new Button(parent, SWT.PUSH);
		button.setFont(parent.getFont());

		GridData buttonData = new GridData(GridData.FILL_HORIZONTAL);
		button.setLayoutData(buttonData);

		button.setData(new Integer(id));
		button.setText(label);

		if (defaultButton) {
			Shell shell = parent.getShell();
			if (shell != null) {
				shell.setDefaultButton(button);
			}
			button.setFocus();
		}
		return button;
	}

	/**
	 * Creates the buttons for selecting specific types or selecting all or none
	 * of the elements.
	 * 
	 * @param parent
	 *            the parent control
	 */
	protected final void createButtonsGroup(Composite parent) {
		// top level group
		Composite buttonComposite = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		layout.makeColumnsEqualWidth = true;
		buttonComposite.setLayout(layout);
		buttonComposite.setFont(parent.getFont());
		GridData buttonData = new GridData(GridData.VERTICAL_ALIGN_FILL
				| GridData.HORIZONTAL_ALIGN_FILL);
		buttonData.horizontalSpan = 2;
		buttonComposite.setLayoutData(buttonData);

		// types edit button
		selectTypesButton = createButton(buttonComposite,
				IDialogConstants.SELECT_TYPES_ID, SELECT_TYPES_TITLE, false);

		SelectionListener listener = new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				handleTypesEditButtonPressed();
			}
		};
		selectTypesButton.addSelectionListener(listener);
		setButtonLayoutData(selectTypesButton);

		selectAllButton = createButton(buttonComposite,
				IDialogConstants.SELECT_ALL_ID, SELECT_ALL_TITLE, false);

		listener = new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				setAllSelections(true);
				updateWidgetEnablements();
			}
		};
		selectAllButton.addSelectionListener(listener);
		setButtonLayoutData(selectAllButton);

		deselectAllButton = createButton(buttonComposite,
				IDialogConstants.DESELECT_ALL_ID, DESELECT_ALL_TITLE, false);

		listener = new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				setAllSelections(false);
				updateWidgetEnablements();
			}
		};
		deselectAllButton.addSelectionListener(listener);
		setButtonLayoutData(deselectAllButton);

	}

	/*
	 * (non-Javadoc) Method declared on IDialogPage.
	 */
	public void createControl(Composite parent) {

		initializeDialogUnits(parent);

		Composite composite = new Composite(parent, SWT.NULL);
		composite.setLayout(new GridLayout());
		composite.setLayoutData(new GridData(GridData.VERTICAL_ALIGN_FILL
				| GridData.HORIZONTAL_ALIGN_FILL));
		composite.setSize(composite.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		composite.setFont(parent.getFont());

		createSourceGroup(composite);

		createDestinationGroup(composite);

		createOptionsGroup(composite);

		restoreWidgetValues();
		updateWidgetEnablements();
		setPageComplete(determinePageCompletion());
		setErrorMessage(null); // should not initially have error message

		setControl(composite);
		validateSourceGroup();
		PlatformUI
				.getWorkbench()
				.getHelpSystem()
				.setHelp(
						getControl(),
						org.eclipse.ui.internal.wizards.datatransfer.IDataTransferHelpContextIds.FILE_SYSTEM_IMPORT_WIZARD_PAGE);
	}

	/**
	 * Create the options specification widgets.
	 * 
	 * @param parent
	 *            org.eclipse.swt.widgets.Composite
	 */
	protected void createOptionsGroup(Composite parent) {
		// options group
		Group optionsGroup = new Group(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		optionsGroup.setLayout(layout);
		optionsGroup.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL
				| GridData.GRAB_HORIZONTAL));
		optionsGroup.setText(org.eclipse.ui.internal.ide.IDEWorkbenchMessages.WizardExportPage_options);
		optionsGroup.setFont(parent.getFont());

		createOptionsGroupButtons(optionsGroup);

	}

	/*
	 * @see WizardDataTransferPage.determinePageCompletion.
	 */
	protected boolean determinePageCompletion() {
		// Check for valid projects before making the user do anything
		boolean complete = validateSourceGroup();

		// Avoid draw flicker by not clearing the error
		// message unless all is valid.
		if (complete) {
			setErrorMessage(null);
		}

		return complete;
	}

	/**
	 * Creates the import destination specification controls.
	 * 
	 * @param parent
	 *            the parent control
	 */
	protected final void createDestinationGroup(Composite parent) {
		// container specification group
		Composite containerGroup = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		containerGroup.setLayout(layout);
		containerGroup.setLayoutData(new GridData(
				GridData.HORIZONTAL_ALIGN_FILL | GridData.GRAB_HORIZONTAL));
		containerGroup.setFont(parent.getFont());

		// container label
		Label resourcesLabel = new Label(containerGroup, SWT.NONE);
		resourcesLabel.setText(org.eclipse.ui.internal.ide.IDEWorkbenchMessages.WizardImportPage_folder);
		resourcesLabel.setFont(parent.getFont());

		// container name entry field
		containerNameField = new Text(containerGroup, SWT.SINGLE | SWT.BORDER);
		containerNameField.addListener(SWT.Modify, this);
		GridData data = new GridData(GridData.HORIZONTAL_ALIGN_FILL
				| GridData.GRAB_HORIZONTAL);
		data.widthHint = SIZING_TEXT_FIELD_WIDTH;
		containerNameField.setLayoutData(data);
		containerNameField.setFont(parent.getFont());
		containerNameField.setEnabled(false);

		containerNameField.setText(WSUtils.getPath(container).toString());
	}

	/**
	 * The <code>WizardDataTransfer</code> implementation of this
	 * <code>IOverwriteQuery</code> method asks the user whether the existing
	 * resource at the given path should be overwritten.
	 * 
	 * @param pathString
	 * @return the user's reply: one of <code>"YES"</code>, <code>"NO"</code>,
	 *         <code>"ALL"</code>, or <code>"CANCEL"</code>
	 */
	public String queryOverwrite(String pathString) {

		Path path = new Path(pathString);

		String messageString;
		// Break the message up if there is a file name and a directory
		// and there are at least 2 segments.
		if (path.getFileExtension() == null || path.segmentCount() < 2) {
			messageString = NLS.bind(
					org.eclipse.ui.internal.ide.IDEWorkbenchMessages.WizardDataTransfer_existsQuestion,
					pathString);
		} else {
			messageString = NLS
					.bind(org.eclipse.ui.internal.ide.IDEWorkbenchMessages.WizardDataTransfer_overwriteNameAndPathQuestion,
							path.lastSegment(), path.removeLastSegments(1)
									.toOSString());
		}

		final MessageDialog dialog = new MessageDialog(getContainer()
				.getShell(), org.eclipse.ui.internal.ide.IDEWorkbenchMessages.Question, null,
				messageString, MessageDialog.QUESTION, new String[] {
						IDialogConstants.YES_LABEL,
						IDialogConstants.YES_TO_ALL_LABEL,
						IDialogConstants.NO_LABEL,
						IDialogConstants.NO_TO_ALL_LABEL,
						IDialogConstants.CANCEL_LABEL }, 0) {
			protected int getShellStyle() {
				return super.getShellStyle() | SWT.SHEET;
			}
		};
		String[] response = new String[] { YES, ALL, NO, NO_ALL, CANCEL };
		// run in syncExec because callback is from an operation,
		// which is probably not running in the UI thread.
		getControl().getDisplay().syncExec(new Runnable() {
			public void run() {
				dialog.open();
			}
		});
		return dialog.getReturnCode() < 0 ? CANCEL : response[dialog
				.getReturnCode()];
	}

	/**
	 * Create the import options specification widgets.
	 */
	protected void createOptionsGroupButtons(Group optionsGroup) {

		// overwrite... checkbox
		overwriteExistingResourcesCheckbox = new Button(optionsGroup, SWT.CHECK);
		overwriteExistingResourcesCheckbox.setFont(optionsGroup.getFont());
		overwriteExistingResourcesCheckbox
				.setText(org.eclipse.ui.internal.wizards.datatransfer.DataTransferMessages.FileImport_overwriteExisting);

		// create containers radio
		createContainerStructureButton = new Button(optionsGroup, SWT.RADIO);
		createContainerStructureButton.setFont(optionsGroup.getFont());
		createContainerStructureButton.setText("Complete folder structure");
		createContainerStructureButton.setSelection(false);

		// create selection only radio
		createOnlySelectedButton = new Button(optionsGroup, SWT.RADIO);
		createOnlySelectedButton.setFont(optionsGroup.getFont());
		createOnlySelectedButton.setText("Selected folders only");
		createOnlySelectedButton.setSelection(true);

	}

	/**
	 * Create the group for creating the root directory
	 */
	protected void createRootDirectoryGroup(Composite parent) {
		Composite sourceContainerGroup = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		sourceContainerGroup.setLayout(layout);
		sourceContainerGroup.setFont(parent.getFont());
		sourceContainerGroup.setLayoutData(new GridData(
				GridData.HORIZONTAL_ALIGN_FILL | GridData.GRAB_HORIZONTAL));

		Label groupLabel = new Label(sourceContainerGroup, SWT.NONE);
		groupLabel.setText(getSourceLabel());
		groupLabel.setFont(parent.getFont());

		// source name entry field
		sourceNameField = new Combo(sourceContainerGroup, SWT.BORDER);
		GridData data = new GridData(GridData.HORIZONTAL_ALIGN_FILL
				| GridData.GRAB_HORIZONTAL);
		data.widthHint = SIZING_TEXT_FIELD_WIDTH;
		sourceNameField.setLayoutData(data);
		sourceNameField.setFont(parent.getFont());

		sourceNameField.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				updateFromSourceField();
			}
		});

		sourceNameField.addKeyListener(new KeyListener() {
			/*
			 * @see KeyListener.keyPressed
			 */
			public void keyPressed(KeyEvent e) {
				// If there has been a key pressed then mark as dirty
				entryChanged = true;
			}

			/*
			 * @see KeyListener.keyReleased
			 */
			public void keyReleased(KeyEvent e) {
			}
		});

		sourceNameField.addFocusListener(new FocusListener() {
			/*
			 * @see FocusListener.focusGained(FocusEvent)
			 */
			public void focusGained(FocusEvent e) {
				// Do nothing when getting focus
			}

			/*
			 * @see FocusListener.focusLost(FocusEvent)
			 */
			public void focusLost(FocusEvent e) {
				// Clear the flag to prevent constant update
				if (entryChanged) {
					entryChanged = false;
					updateFromSourceField();
				}

			}
		});

		// source browse button
		sourceBrowseButton = new Button(sourceContainerGroup, SWT.PUSH);
		sourceBrowseButton
				.setText(org.eclipse.ui.internal.wizards.datatransfer.DataTransferMessages.DataTransfer_browse);
		sourceBrowseButton.addListener(SWT.Selection, this);
		sourceBrowseButton.setLayoutData(new GridData(
				GridData.HORIZONTAL_ALIGN_FILL));
		sourceBrowseButton.setFont(parent.getFont());
		setButtonLayoutData(sourceBrowseButton);
	}

	/**
	 * Update the receiver from the source name field.
	 */

	private void updateFromSourceField() {

		setSourceName(sourceNameField.getText());
		// Update enablements when this is selected
		updateWidgetEnablements();
	}

	/**
	 * Creates and returns a <code>FileSystemElement</code> if the specified
	 * file system object merits one. The criteria for this are: Also create the
	 * children.
	 */
	protected MinimizedFileSystemElement createRootElement(
			Object fileSystemObject, IImportStructureProvider provider) {
		boolean isContainer = provider.isFolder(fileSystemObject);
		String elementLabel = provider.getLabel(fileSystemObject);

		// Use an empty label so that display of the element's full name
		// doesn't include a confusing label
		MinimizedFileSystemElement dummyParent = new MinimizedFileSystemElement("", null, true);//$NON-NLS-1$
		dummyParent.setPopulated();
		MinimizedFileSystemElement result = new MinimizedFileSystemElement(
				elementLabel, dummyParent, isContainer);
		result.setFileSystemObject(fileSystemObject);

		// Get the files for the element so as to build the first level
		result.getFiles(provider);

		return dummyParent;
	}

	/**
	 * Create the import source specification widgets
	 */
	protected void createSourceGroup(Composite parent) {

		createRootDirectoryGroup(parent);
		createFileSelectionGroup(parent);
		createButtonsGroup(parent);
	}

	/**
	 * Create the import source selection widget
	 */
	protected void createFileSelectionGroup(Composite parent) {

		// Just create with a dummy root.
		this.selectionGroup = new org.eclipse.ui.internal.ide.dialogs.ResourceTreeAndListGroup(
				parent,
				new FileSystemElement("Dummy", null, true),//$NON-NLS-1$
				getFolderProvider(), new WorkbenchLabelProvider(),
				getFileProvider(), new WorkbenchLabelProvider(), SWT.NONE,
				org.eclipse.ui.internal.ide.DialogUtil.inRegularFontMode(parent));

		ICheckStateListener listener = new ICheckStateListener() {
			public void checkStateChanged(CheckStateChangedEvent event) {
				updateWidgetEnablements();
			}
		};

		WorkbenchViewerComparator comparator = new WorkbenchViewerComparator();
		this.selectionGroup.setTreeComparator(comparator);
		this.selectionGroup.setListComparator(comparator);
		this.selectionGroup.addCheckStateListener(listener);

	}

	/**
	 * Enable or disable the button group.
	 */
	protected void enableButtonGroup(boolean enable) {
		selectTypesButton.setEnabled(enable);
		selectAllButton.setEnabled(enable);
		deselectAllButton.setEnabled(enable);
	}

	/**
	 * Answer a boolean indicating whether the specified source currently exists
	 * and is valid
	 */
	protected boolean ensureSourceIsValid() {
		if (new File(getSourceDirectoryName()).isDirectory()) {
			return true;
		}

		setErrorMessage(org.eclipse.ui.internal.wizards.datatransfer.DataTransferMessages.FileImport_invalidSource);
		return false;
	}

	/**
	 * Display an error dialog with the specified message.
	 * 
	 * @param message
	 *            the error message
	 */
	protected void displayErrorDialog(String message) {
		MessageDialog.open(MessageDialog.ERROR, getContainer().getShell(),
				getErrorDialogTitle(), message, SWT.SHEET);
	}

	/**
	 * Display an error dislog with the information from the supplied exception.
	 * 
	 * @param exception
	 *            Throwable
	 */
	protected void displayErrorDialog(Throwable exception) {
		String message = exception.getMessage();
		// Some system exceptions have no message
		if (message == null) {
			message = NLS.bind(
					org.eclipse.ui.internal.ide.IDEWorkbenchMessages.WizardDataTransfer_exceptionMessage,
					exception);
		}
		displayErrorDialog(message);
	}

	/**
	 * Get the title for an error dialog. Subclasses should override.
	 */
	protected String getErrorDialogTitle() {
		return org.eclipse.ui.internal.ide.IDEWorkbenchMessages.WizardExportPage_internalErrorTitle;
	}

	/**
	 * Returns this page's list of currently-specified resources to be imported.
	 * This is the primary resource selection facility accessor for subclasses.
	 * 
	 * @return a list of resources currently selected for export (element type:
	 *         <code>IResource</code>)
	 */
	protected java.util.List getSelectedResources() {
		return this.selectionGroup.getAllCheckedListItems();
	}

	/**
	 * Returns this page's list of currently-specified resources to be imported
	 * filtered by the org.eclipse.ui.internal.ide.dialogs.IElementFilter.
	 * 
	 */
	protected void getSelectedResources(org.eclipse.ui.internal.ide.dialogs.IElementFilter filter,
			IProgressMonitor monitor) throws InterruptedException {
		this.selectionGroup.getAllCheckedListItems(filter, monitor);
	}

	/**
	 * The Finish button was pressed. Try to do the required work now and answer
	 * a boolean indicating success. If false is returned then the wizard will
	 * not close.
	 * 
	 * @return boolean
	 */
	@SuppressWarnings("unchecked")
	public boolean finish() {
		if (!ensureSourceIsValid()) {
			return false;
		}

		saveWidgetValues();

		Iterator resourcesEnum = getSelectedResources().iterator();
		List fileSystemObjects = new ArrayList();
		while (resourcesEnum.hasNext()) {
			fileSystemObjects.add(((FileSystemElement) resourcesEnum.next())
					.getFileSystemObject());
		}

		if (fileSystemObjects.size() > 0) {
			return importResources(fileSystemObjects);
		}

		MessageDialog.openInformation(getContainer().getShell(),
				org.eclipse.ui.internal.wizards.datatransfer.DataTransferMessages.DataTransfer_information,
				org.eclipse.ui.internal.wizards.datatransfer.DataTransferMessages.FileImport_noneSelected);

		return false;
	}

	/**
	 * Returns a content provider for <code>FileSystemElement</code>s that
	 * returns only files as children.
	 */
	protected ITreeContentProvider getFileProvider() {
		return new WorkbenchContentProvider() {
			public Object[] getChildren(Object o) {
				if (o instanceof MinimizedFileSystemElement) {
					MinimizedFileSystemElement element = (MinimizedFileSystemElement) o;
					return element.getFiles(fileSystemStructureProvider)
							.getChildren(element);
				}
				return new Object[0];
			}
		};
	}

	/**
	 * Answer the root FileSystemElement that represents the contents of the
	 * currently-specified source. If this FileSystemElement is not currently
	 * defined then create and return it.
	 */
	protected MinimizedFileSystemElement getFileSystemTree() {

		File sourceDirectory = getSourceDirectory();
		if (sourceDirectory == null) {
			return null;
		}

		return selectFiles(sourceDirectory, fileSystemStructureProvider);
	}

	/**
	 * Returns a content provider for <code>FileSystemElement</code>s that
	 * returns only folders as children.
	 */
	protected ITreeContentProvider getFolderProvider() {
		return new WorkbenchContentProvider() {
			public Object[] getChildren(Object o) {
				if (o instanceof MinimizedFileSystemElement) {
					MinimizedFileSystemElement element = (MinimizedFileSystemElement) o;
					return element.getFolders(fileSystemStructureProvider)
							.getChildren(element);
				}
				return new Object[0];
			}

			public boolean hasChildren(Object o) {
				if (o instanceof MinimizedFileSystemElement) {
					MinimizedFileSystemElement element = (MinimizedFileSystemElement) o;
					if (element.isPopulated()) {
						return getChildren(element).length > 0;
					}

					// If we have not populated then wait until asked
					return true;
				}
				return false;
			}
		};
	}

	/**
	 * Returns a File object representing the currently-named source directory
	 * iff it exists as a valid directory, or <code>null</code> otherwise.
	 */
	protected File getSourceDirectory() {
		return getSourceDirectory(this.sourceNameField.getText());
	}

	/**
	 * Returns a File object representing the currently-named source directory
	 * iff it exists as a valid directory, or <code>null</code> otherwise.
	 * 
	 * @param path
	 *            a String not yet formatted for java.io.File compatability
	 */
	private File getSourceDirectory(String path) {
		File sourceDirectory = new File(getSourceDirectoryName(path));
		if (!sourceDirectory.exists() || !sourceDirectory.isDirectory()) {
			return null;
		}

		return sourceDirectory;
	}

	/**
	 * Answer the directory name specified as being the import source. Note that
	 * if it ends with a separator then the separator is first removed so that
	 * java treats it as a proper directory
	 */
	private String getSourceDirectoryName() {
		return getSourceDirectoryName(this.sourceNameField.getText());
	}

	/**
	 * Answer the directory name specified as being the import source. Note that
	 * if it ends with a separator then the separator is first removed so that
	 * java treats it as a proper directory
	 */
	private String getSourceDirectoryName(String sourceName) {
		IPath result = new Path(sourceName.trim());

		if (result.getDevice() != null && result.segmentCount() == 0) {
			result = result.addTrailingSeparator();
		} else {
			result = result.removeTrailingSeparator();
		}

		return result.toOSString();
	}

	/**
	 * Answer the string to display as the label for the source specification
	 * field
	 */
	protected String getSourceLabel() {
		return org.eclipse.ui.internal.wizards.datatransfer.DataTransferMessages.FileImport_fromDirectory;
	}

	/**
	 * Handle all events and enablements for widgets in this dialog
	 * 
	 * @param event
	 *            Event
	 */
	@SuppressWarnings("unused")
	public void handleEvent(Event event) {
		if (event.widget == sourceBrowseButton) {
			handleSourceBrowseButtonPressed();
		}

		Widget source = event.widget;

		updateWidgetEnablements();
	}

	/**
	 * Open an appropriate source browser so that the user can specify a source
	 * to import from
	 */
	protected void handleSourceBrowseButtonPressed() {

		String currentSource = this.sourceNameField.getText();
		DirectoryDialog dialog = new DirectoryDialog(
				sourceNameField.getShell(), SWT.SAVE | SWT.SHEET);
		dialog.setText(SELECT_SOURCE_TITLE);
		dialog.setMessage(SELECT_SOURCE_MESSAGE);
		dialog.setFilterPath(getSourceDirectoryName(currentSource));

		String selectedDirectory = dialog.open();
		if (selectedDirectory != null) {
			// Just quit if the directory is not valid
			if ((getSourceDirectory(selectedDirectory) == null)
					|| selectedDirectory.equals(currentSource)) {
				return;
			}
			// If it is valid then proceed to populate
			setErrorMessage(null);
			setSourceName(selectedDirectory);
			selectionGroup.setFocus();
		}
	}

	/**
	 * Open a registered type selection dialog and note the selections in the
	 * receivers types-to-export field., Added here so that inner classes can
	 * have access
	 */
	@SuppressWarnings("unchecked")
	protected void handleTypesEditButtonPressed() {

		TypeFilteringDialog dialog = new TypeFilteringDialog(getContainer()
				.getShell(), getTypesToImport());

		dialog.open();

		Object[] newSelectedTypes = dialog.getResult();
		if (newSelectedTypes != null) { // ie.- did not press Cancel
			this.selectedTypes = new ArrayList(newSelectedTypes.length);
			for (int i = 0; i < newSelectedTypes.length; i++) {
				this.selectedTypes.add(newSelectedTypes[i]);
			}

			setupSelectionsBasedOnSelectedTypes();
		}
	}

	/**
	 * Returns a collection of the currently-specified resource types for use by
	 * the type selection dialog.
	 */
	protected java.util.List getTypesToImport() {

		return selectedTypes;
	}

	/**
	 * Import the resources with extensions as specified by the user
	 */
	protected boolean importResources(List fileSystemObjects) {
		IPath minimalRoot = null;
		IPersistenceModel model = PersistenceManager.getInstance().getModel(
				container.eResource());
		if (model == null) {
			return false;
		}
		for (Object object : fileSystemObjects) {
			String lpath = fileSystemStructureProvider.getFullPath(object);
			IPath path = new Path(lpath).removeLastSegments(1);
			if (minimalRoot == null) {
				minimalRoot = path;
				continue;
			}
			while (!minimalRoot.isPrefixOf(path)) {
				minimalRoot = minimalRoot.removeLastSegments(1);
			}
			if (path.segmentCount() < minimalRoot.segmentCount()) {
				minimalRoot = path;
			}
		}
		for (Object object : fileSystemObjects) {
			if (!fileSystemStructureProvider.isFolder(object)) {
				IPath fullPath = new Path(
						fileSystemStructureProvider.getFullPath(object))
						.removeFirstSegments(minimalRoot.segmentCount());
				WSContainer folder = getFolder(this.container,
						fullPath.removeLastSegments(1));
				if (folder instanceof WSFolder) {
					WSFile wsFile = WSUtils.getFile((WSFolder) folder,
							fullPath.lastSegment(), true);
					String fName = ImportUtils.getName(wsFile);
					OutputStream store = model.store(fName);
					InputStream inputStream = fileSystemStructureProvider
							.getContents(object);
					try {
						FileUtil.copy(inputStream, store);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}

		return true;
	}

	private WSContainer getFolder(WSContainer container, IPath segms) {
		WSContainer result = (WSFolder) container;
		for (String part : segms.segments()) {
			result = WSUtils.getContainer(result, part, true);
		}
		return result;
	}

	/**
	 * Returns whether the extension provided is an extension that has been
	 * specified for export by the user.
	 * 
	 * @param extension
	 *            the resource name
	 * @return <code>true</code> if the resource name is suitable for export
	 *         based upon its extension
	 */
	protected boolean isExportableExtension(String extension) {
		if (selectedTypes == null) {
			return true;
		}

		Iterator itr = selectedTypes.iterator();
		while (itr.hasNext()) {
			if (extension.equalsIgnoreCase((String) itr.next())) {
				return true;
			}
		}

		return false;
	}

	/**
	 * Repopulate the view based on the currently entered directory.
	 */
	protected void resetSelection() {

		MinimizedFileSystemElement currentRoot = getFileSystemTree();
		this.selectionGroup.setRoot(currentRoot);

	}

	/**
	 * Use the dialog store to restore widget values to the values that they
	 * held last time this wizard was used to completion
	 */
	protected void restoreWidgetValues() {
		IDialogSettings settings = getDialogSettings();
		if (settings != null) {
			String[] sourceNames = settings.getArray(STORE_SOURCE_NAMES_ID);
			if (sourceNames == null) {
				return; // ie.- no values stored, so stop
			}

			// set filenames history
			for (int i = 0; i < sourceNames.length; i++) {
				sourceNameField.add(sourceNames[i]);
			}

			// radio buttons and checkboxes
			overwriteExistingResourcesCheckbox.setSelection(settings
					.getBoolean(STORE_OVERWRITE_EXISTING_RESOURCES_ID));

			boolean createStructure = settings
					.getBoolean(STORE_CREATE_CONTAINER_STRUCTURE_ID);
			createContainerStructureButton.setSelection(createStructure);
			createOnlySelectedButton.setSelection(!createStructure);

		}
	}

	/**
	 * Since Finish was pressed, write widget values to the dialog store so that
	 * they will persist into the next invocation of this wizard page
	 */
	protected void saveWidgetValues() {
		IDialogSettings settings = getDialogSettings();
		if (settings != null) {
			// update source names history
			String[] sourceNames = settings.getArray(STORE_SOURCE_NAMES_ID);
			if (sourceNames == null) {
				sourceNames = new String[0];
			}

			sourceNames = addToHistory(sourceNames, getSourceDirectoryName());
			settings.put(STORE_SOURCE_NAMES_ID, sourceNames);

			// radio buttons and checkboxes
			settings.put(STORE_OVERWRITE_EXISTING_RESOURCES_ID,
					overwriteExistingResourcesCheckbox.getSelection());

			settings.put(STORE_CREATE_CONTAINER_STRUCTURE_ID,
					createContainerStructureButton.getSelection());

		}
	}

	/**
	 * Adds an entry to a history, while taking care of duplicate history items
	 * and excessively long histories. The assumption is made that all histories
	 * should be of length
	 * <code>WizardDataTransferPage.COMBO_HISTORY_LENGTH</code>.
	 * 
	 * @param history
	 *            the current history
	 * @param newEntry
	 *            the entry to add to the history
	 */
	@SuppressWarnings("unchecked")
	protected String[] addToHistory(String[] history, String newEntry) {
		java.util.ArrayList l = new java.util.ArrayList(Arrays.asList(history));
		addToHistory(l, newEntry);
		String[] r = new String[l.size()];
		l.toArray(r);
		return r;
	}

	/**
	 * Adds an entry to a history, while taking care of duplicate history items
	 * and excessively long histories. The assumption is made that all histories
	 * should be of length
	 * <code>WizardDataTransferPage.COMBO_HISTORY_LENGTH</code>.
	 * 
	 * @param history
	 *            the current history
	 * @param newEntry
	 *            the entry to add to the history
	 */
	@SuppressWarnings("unchecked")
	protected void addToHistory(List history, String newEntry) {
		history.remove(newEntry);
		history.add(0, newEntry);

		// since only one new item was added, we can be over the limit
		// by at most one item
		if (history.size() > COMBO_HISTORY_LENGTH) {
			history.remove(COMBO_HISTORY_LENGTH);
		}
	}

	/**
	 * Invokes a file selection operation using the specified file system and
	 * structure provider. If the user specifies files to be imported then this
	 * selection is cached for later retrieval and is returned.
	 */
	protected MinimizedFileSystemElement selectFiles(
			final Object rootFileSystemObject,
			final IImportStructureProvider structureProvider) {

		final MinimizedFileSystemElement[] results = new MinimizedFileSystemElement[1];

		BusyIndicator.showWhile(getShell().getDisplay(), new Runnable() {
			public void run() {
				// Create the root element from the supplied file system object
				results[0] = createRootElement(rootFileSystemObject,
						structureProvider);
			}
		});

		return results[0];
	}

	/**
	 * Set all of the selections in the selection group to value. Implemented
	 * here to provide access for inner classes.
	 * 
	 * @param value
	 *            boolean
	 */
	protected void setAllSelections(boolean value) {
		selectionGroup.setAllSelections(value);
	}

	/**
	 * Sets the source name of the import to be the supplied path. Adds the name
	 * of the path to the list of items in the source combo and selects it.
	 * 
	 * @param path
	 *            the path to be added
	 */
	protected void setSourceName(String path) {

		if (path.length() > 0) {

			String[] currentItems = this.sourceNameField.getItems();
			int selectionIndex = -1;
			for (int i = 0; i < currentItems.length; i++) {
				if (currentItems[i].equals(path)) {
					selectionIndex = i;
				}
			}
			if (selectionIndex < 0) {
				int oldLength = currentItems.length;
				String[] newItems = new String[oldLength + 1];
				System.arraycopy(currentItems, 0, newItems, 0, oldLength);
				newItems[oldLength] = path;
				this.sourceNameField.setItems(newItems);
				selectionIndex = oldLength;
			}
			this.sourceNameField.select(selectionIndex);

			resetSelection();
		}
	}

	/**
	 * Update the tree to only select those elements that match the selected
	 * types
	 */
	protected void setupSelectionsBasedOnSelectedTypes() {
		ProgressMonitorDialog dialog = new org.eclipse.ui.internal.progress.ProgressMonitorJobsDialog(
				getContainer().getShell());
		final Map selectionMap = new Hashtable();

		final org.eclipse.ui.internal.ide.dialogs.IElementFilter filter = new org.eclipse.ui.internal.ide.dialogs.IElementFilter() {

			public void filterElements(Collection files,
					IProgressMonitor monitor) throws InterruptedException {
				if (files == null) {
					throw new InterruptedException();
				}
				Iterator filesList = files.iterator();
				while (filesList.hasNext()) {
					if (monitor.isCanceled()) {
						throw new InterruptedException();
					}
					checkFile(filesList.next());
				}
			}

			public void filterElements(Object[] files, IProgressMonitor monitor)
					throws InterruptedException {
				if (files == null) {
					throw new InterruptedException();
				}
				for (int i = 0; i < files.length; i++) {
					if (monitor.isCanceled()) {
						throw new InterruptedException();
					}
					checkFile(files[i]);
				}
			}

			@SuppressWarnings("unchecked")
			private void checkFile(Object fileElement) {
				MinimizedFileSystemElement file = (MinimizedFileSystemElement) fileElement;
				if (isExportableExtension(file.getFileNameExtension())) {
					List elements = new ArrayList();
					FileSystemElement parent = file.getParent();
					if (selectionMap.containsKey(parent)) {
						elements = (List) selectionMap.get(parent);
					}
					elements.add(file);
					selectionMap.put(parent, elements);
				}
			}

		};

		IRunnableWithProgress runnable = new IRunnableWithProgress() {
			public void run(final IProgressMonitor monitor)
					throws InterruptedException {
				monitor.beginTask(
						org.eclipse.ui.internal.wizards.datatransfer.DataTransferMessages.ImportPage_filterSelections,
						IProgressMonitor.UNKNOWN);
				getSelectedResources(filter, monitor);
			}
		};

		try {
			dialog.run(true, true, runnable);
		} catch (InvocationTargetException exception) {
			// Couldn't start. Do nothing.
			return;
		} catch (InterruptedException exception) {
			// Got interrupted. Do nothing.
			return;
		}
		// make sure that all paint operations caused by closing the progress
		// dialog get flushed, otherwise extra pixels will remain on the screen
		// until
		// updateSelections is completed
		getShell().update();
		// The updateSelections method accesses SWT widgets so cannot be
		// executed
		// as part of the above progress dialog operation since the operation
		// forks
		// a new process.
		if (selectionMap != null) {
			updateSelections(selectionMap);
		}
	}

	/*
	 * (non-Javadoc) Method declared on IDialogPage. Set the selection up when
	 * it becomes visible.
	 */
	public void setVisible(boolean visible) {
		super.setVisible(visible);
		resetSelection();
		if (visible) {
			this.sourceNameField.setFocus();
		}
	}

	/**
	 * Update the selections with those in map . Implemented here to give inner
	 * class visibility
	 * 
	 * @param map
	 *            Map - key tree elements, values Lists of list elements
	 */
	protected void updateSelections(final Map map) {
		Runnable runnable = new Runnable() {
			public void run() {
				selectionGroup.updateSelections(map);
			}
		};

		BusyIndicator.showWhile(getShell().getDisplay(), runnable);
	}

	/**
	 * Check if widgets are enabled or disabled by a change in the dialog.
	 * Provided here to give access to inner classes.
	 */
	protected void updateWidgetEnablements() {
		boolean pageComplete = determinePageCompletion();
		setPageComplete(pageComplete);
		if (pageComplete) {
			setMessage(null);
		}
		enableButtonGroup(ensureSourceIsValid());
	}

	/**
	 * Answer a boolean indicating whether self's source specification widgets
	 * currently all contain valid values.
	 */
	protected boolean validateSourceGroup() {
		File sourceDirectory = getSourceDirectory();
		if (sourceDirectory == null) {
			setMessage(SOURCE_EMPTY_MESSAGE);
			enableButtonGroup(false);
			return false;
		}

		List resourcesToExport = selectionGroup.getAllWhiteCheckedItems();
		if (resourcesToExport.size() == 0) {
			setMessage(null);
			setErrorMessage(org.eclipse.ui.internal.wizards.datatransfer.DataTransferMessages.FileImport_noneSelected);
			return false;
		}

		enableButtonGroup(true);
		setErrorMessage(null);
		return true;
	}

	/**
	 * Returns the error message for when the source conflicts with the
	 * destination.
	 */
	protected final String getSourceConflictMessage() {
		return (org.eclipse.ui.internal.ide.IDEWorkbenchMessages.WizardImportPage_importOnReceiver);
	}

}

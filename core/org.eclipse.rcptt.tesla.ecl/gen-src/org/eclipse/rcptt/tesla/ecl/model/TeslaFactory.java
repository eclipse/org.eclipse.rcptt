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
package org.eclipse.rcptt.tesla.ecl.model;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.rcptt.tesla.ecl.model.TeslaPackage
 * @generated
 */
public interface TeslaFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TeslaFactory eINSTANCE = org.eclipse.rcptt.tesla.ecl.model.impl.TeslaFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Wait</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Wait</em>'.
	 * @generated
	 */
	Wait createWait();

	/**
	 * Returns a new object of class '<em>Setup Player</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Setup Player</em>'.
	 * @generated
	 */
	SetupPlayer createSetupPlayer();

	/**
	 * Returns a new object of class '<em>Shoutdown Player</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Shoutdown Player</em>'.
	 * @generated
	 */
	ShoutdownPlayer createShoutdownPlayer();

	/**
	 * Returns a new object of class '<em>Process Status</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Process Status</em>'.
	 * @generated
	 */
	TeslaProcessStatus createTeslaProcessStatus();

	/**
	 * Returns a new object of class '<em>Wrapper</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Wrapper</em>'.
	 * @generated
	 */
	Wrapper createWrapper();

	/**
	 * Returns a new object of class '<em>Get Property</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Get Property</em>'.
	 * @generated
	 */
	GetProperty createGetProperty();

	/**
	 * Returns a new object of class '<em>Verify True</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Verify True</em>'.
	 * @generated
	 */
	VerifyTrue createVerifyTrue();

	/**
	 * Returns a new object of class '<em>Verify False</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Verify False</em>'.
	 * @generated
	 */
	VerifyFalse createVerifyFalse();

	/**
	 * Returns a new object of class '<em>Verify Handler</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Verify Handler</em>'.
	 * @generated
	 */
	VerifyHandler createVerifyHandler();

	/**
	 * Returns a new object of class '<em>Verify Error</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Verify Error</em>'.
	 * @generated
	 */
	VerifyError createVerifyError();

	/**
	 * Returns a new object of class '<em>Equals</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Equals</em>'.
	 * @generated
	 */
	Equals createEquals();

	/**
	 * Returns a new object of class '<em>Contains</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Contains</em>'.
	 * @generated
	 */
	Contains createContains();

	/**
	 * Returns a new object of class '<em>Matches</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Matches</em>'.
	 * @generated
	 */
	Matches createMatches();

	/**
	 * Returns a new object of class '<em>Is Empty</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Is Empty</em>'.
	 * @generated
	 */
	IsEmpty createIsEmpty();

	/**
	 * Returns a new object of class '<em>Unsupported</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Unsupported</em>'.
	 * @generated
	 */
	Unsupported createUnsupported();

	/**
	 * Returns a new object of class '<em>Control Not Found</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Control Not Found</em>'.
	 * @generated
	 */
	ControlNotFound createControlNotFound();

	/**
	 * Returns a new object of class '<em>Control Handler</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Control Handler</em>'.
	 * @generated
	 */
	ControlHandler createControlHandler();

	/**
	 * Returns a new object of class '<em>Get Eclipse Window</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Get Eclipse Window</em>'.
	 * @generated
	 */
	GetEclipseWindow createGetEclipseWindow();

	/**
	 * Returns a new object of class '<em>Get Control</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Get Control</em>'.
	 * @generated
	 */
	GetControl createGetControl();

	/**
	 * Returns a new object of class '<em>Get Button</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Get Button</em>'.
	 * @generated
	 */
	GetButton createGetButton();

	/**
	 * Returns a new object of class '<em>Get Canvas</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Get Canvas</em>'.
	 * @generated
	 */
	GetCanvas createGetCanvas();

	/**
	 * Returns a new object of class '<em>Get Checkbox</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Get Checkbox</em>'.
	 * @generated
	 */
	GetCheckbox createGetCheckbox();

	/**
	 * Returns a new object of class '<em>Get Combo</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Get Combo</em>'.
	 * @generated
	 */
	GetCombo createGetCombo();

	/**
	 * Returns a new object of class '<em>Get Editbox</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Get Editbox</em>'.
	 * @generated
	 */
	GetEditbox createGetEditbox();

	/**
	 * Returns a new object of class '<em>Get Group</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Get Group</em>'.
	 * @generated
	 */
	GetGroup createGetGroup();

	/**
	 * Returns a new object of class '<em>Get Item</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Get Item</em>'.
	 * @generated
	 */
	GetItem createGetItem();

	/**
	 * Returns a new object of class '<em>Get Label</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Get Label</em>'.
	 * @generated
	 */
	GetLabel createGetLabel();

	/**
	 * Returns a new object of class '<em>Get Link</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Get Link</em>'.
	 * @generated
	 */
	GetLink createGetLink();

	/**
	 * Returns a new object of class '<em>Get List</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Get List</em>'.
	 * @generated
	 */
	GetList createGetList();

	/**
	 * Returns a new object of class '<em>Get Menu</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Get Menu</em>'.
	 * @generated
	 */
	GetMenu createGetMenu();

	/**
	 * Returns a new object of class '<em>Get Tab Folder</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Get Tab Folder</em>'.
	 * @generated
	 */
	GetTabFolder createGetTabFolder();

	/**
	 * Returns a new object of class '<em>Get Tab Item</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Get Tab Item</em>'.
	 * @generated
	 */
	GetTabItem createGetTabItem();

	/**
	 * Returns a new object of class '<em>Get Table</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Get Table</em>'.
	 * @generated
	 */
	GetTable createGetTable();

	/**
	 * Returns a new object of class '<em>Get Toolbar</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Get Toolbar</em>'.
	 * @generated
	 */
	GetToolbar createGetToolbar();

	/**
	 * Returns a new object of class '<em>Get Tree</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Get Tree</em>'.
	 * @generated
	 */
	GetTree createGetTree();

	/**
	 * Returns a new object of class '<em>Get Window</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Get Window</em>'.
	 * @generated
	 */
	GetWindow createGetWindow();

	/**
	 * Returns a new object of class '<em>Get View</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Get View</em>'.
	 * @generated
	 */
	GetView createGetView();

	/**
	 * Returns a new object of class '<em>Get Editor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Get Editor</em>'.
	 * @generated
	 */
	GetEditor createGetEditor();

	/**
	 * Returns a new object of class '<em>Get Section</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Get Section</em>'.
	 * @generated
	 */
	GetSection createGetSection();

	/**
	 * Returns a new object of class '<em>Get Banner</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Get Banner</em>'.
	 * @generated
	 */
	GetBanner createGetBanner();

	/**
	 * Returns a new object of class '<em>Get Coolbar</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Get Coolbar</em>'.
	 * @generated
	 */
	GetCoolbar createGetCoolbar();

	/**
	 * Returns a new object of class '<em>Get Color Selector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Get Color Selector</em>'.
	 * @generated
	 */
	GetColorSelector createGetColorSelector();

	/**
	 * Returns a new object of class '<em>Get Cell</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Get Cell</em>'.
	 * @generated
	 */
	GetCell createGetCell();

	/**
	 * Returns a new object of class '<em>Click</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Click</em>'.
	 * @generated
	 */
	Click createClick();

	/**
	 * Returns a new object of class '<em>Double Click</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Double Click</em>'.
	 * @generated
	 */
	DoubleClick createDoubleClick();

	/**
	 * Returns a new object of class '<em>Get Text</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Get Text</em>'.
	 * @generated
	 */
	GetText createGetText();

	/**
	 * Returns a new object of class '<em>Is Disabled</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Is Disabled</em>'.
	 * @generated
	 */
	IsDisabled createIsDisabled();

	/**
	 * Returns a new object of class '<em>Is Disposed</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Is Disposed</em>'.
	 * @generated
	 */
	IsDisposed createIsDisposed();

	/**
	 * Returns a new object of class '<em>Type Text</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Type Text</em>'.
	 * @generated
	 */
	TypeText createTypeText();

	/**
	 * Returns a new object of class '<em>Key Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Key Type</em>'.
	 * @generated
	 */
	KeyType createKeyType();

	/**
	 * Returns a new object of class '<em>Type Command Key</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Type Command Key</em>'.
	 * @generated
	 */
	TypeCommandKey createTypeCommandKey();

	/**
	 * Returns a new object of class '<em>Set Text</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Set Text</em>'.
	 * @generated
	 */
	SetText createSetText();

	/**
	 * Returns a new object of class '<em>Set Text Selection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Set Text Selection</em>'.
	 * @generated
	 */
	SetTextSelection createSetTextSelection();

	/**
	 * Returns a new object of class '<em>Set Text Offset</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Set Text Offset</em>'.
	 * @generated
	 */
	SetTextOffset createSetTextOffset();

	/**
	 * Returns a new object of class '<em>Check</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Check</em>'.
	 * @generated
	 */
	Check createCheck();

	/**
	 * Returns a new object of class '<em>Uncheck</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Uncheck</em>'.
	 * @generated
	 */
	Uncheck createUncheck();

	/**
	 * Returns a new object of class '<em>Select</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Select</em>'.
	 * @generated
	 */
	Select createSelect();

	/**
	 * Returns a new object of class '<em>Activate Cell Edit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Activate Cell Edit</em>'.
	 * @generated
	 */
	ActivateCellEdit createActivateCellEdit();

	/**
	 * Returns a new object of class '<em>Apply Cell Edit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Apply Cell Edit</em>'.
	 * @generated
	 */
	ApplyCellEdit createApplyCellEdit();

	/**
	 * Returns a new object of class '<em>Cancel Cell Edit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Cancel Cell Edit</em>'.
	 * @generated
	 */
	CancelCellEdit createCancelCellEdit();

	/**
	 * Returns a new object of class '<em>Deactivate Cell Edit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Deactivate Cell Edit</em>'.
	 * @generated
	 */
	DeactivateCellEdit createDeactivateCellEdit();

	/**
	 * Returns a new object of class '<em>Close</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Close</em>'.
	 * @generated
	 */
	Close createClose();

	/**
	 * Returns a new object of class '<em>Return From Os Dialog</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Return From Os Dialog</em>'.
	 * @generated
	 */
	ReturnFromOsDialog createReturnFromOsDialog();

	/**
	 * Returns a new object of class '<em>Wait Until Eclipse Is Ready</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Wait Until Eclipse Is Ready</em>'.
	 * @generated
	 */
	WaitUntilEclipseIsReady createWaitUntilEclipseIsReady();

	/**
	 * Returns a new object of class '<em>Show Content Assist</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Show Content Assist</em>'.
	 * @generated
	 */
	ShowContentAssist createShowContentAssist();

	/**
	 * Returns a new object of class '<em>Drag Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Drag Action</em>'.
	 * @generated
	 */
	DragAction createDragAction();

	/**
	 * Returns a new object of class '<em>Drag Start</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Drag Start</em>'.
	 * @generated
	 */
	DragStart createDragStart();

	/**
	 * Returns a new object of class '<em>Drag End</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Drag End</em>'.
	 * @generated
	 */
	DragEnd createDragEnd();

	/**
	 * Returns a new object of class '<em>Drag Enter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Drag Enter</em>'.
	 * @generated
	 */
	DragEnter createDragEnter();

	/**
	 * Returns a new object of class '<em>Drag Exit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Drag Exit</em>'.
	 * @generated
	 */
	DragExit createDragExit();

	/**
	 * Returns a new object of class '<em>Drag Set Data</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Drag Set Data</em>'.
	 * @generated
	 */
	DragSetData createDragSetData();

	/**
	 * Returns a new object of class '<em>Drag Accept</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Drag Accept</em>'.
	 * @generated
	 */
	DragAccept createDragAccept();

	/**
	 * Returns a new object of class '<em>Drag Detect</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Drag Detect</em>'.
	 * @generated
	 */
	DragDetect createDragDetect();

	/**
	 * Returns a new object of class '<em>Drag Over</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Drag Over</em>'.
	 * @generated
	 */
	DragOver createDragOver();

	/**
	 * Returns a new object of class '<em>Drop</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Drop</em>'.
	 * @generated
	 */
	Drop createDrop();

	/**
	 * Returns a new object of class '<em>Recognize</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Recognize</em>'.
	 * @generated
	 */
	Recognize createRecognize();

	/**
	 * Returns a new object of class '<em>Recognize Response</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Recognize Response</em>'.
	 * @generated
	 */
	RecognizeResponse createRecognizeResponse();

	/**
	 * Returns a new object of class '<em>Contains Image</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Contains Image</em>'.
	 * @generated
	 */
	ContainsImage createContainsImage();

	/**
	 * Returns a new object of class '<em>Get Region Text</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Get Region Text</em>'.
	 * @generated
	 */
	GetRegionText createGetRegionText();

	/**
	 * Returns a new object of class '<em>Get Region</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Get Region</em>'.
	 * @generated
	 */
	GetRegion createGetRegion();

	/**
	 * Returns a new object of class '<em>Get Advanced Info</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Get Advanced Info</em>'.
	 * @generated
	 */
	GetAdvancedInfo createGetAdvancedInfo();

	/**
	 * Returns a new object of class '<em>Get About Menu</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Get About Menu</em>'.
	 * @generated
	 */
	GetAboutMenu createGetAboutMenu();

	/**
	 * Returns a new object of class '<em>Get Preferences Menu</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Get Preferences Menu</em>'.
	 * @generated
	 */
	GetPreferencesMenu createGetPreferencesMenu();

	/**
	 * Returns a new object of class '<em>Get Date Time</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Get Date Time</em>'.
	 * @generated
	 */
	GetDateTime createGetDateTime();

	/**
	 * Returns a new object of class '<em>Get Slider</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Get Slider</em>'.
	 * @generated
	 */
	GetSlider createGetSlider();

	/**
	 * Returns a new object of class '<em>Set Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Set Value</em>'.
	 * @generated
	 */
	SetValue createSetValue();

	/**
	 * Returns a new object of class '<em>Minimize</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Minimize</em>'.
	 * @generated
	 */
	Minimize createMinimize();

	/**
	 * Returns a new object of class '<em>Maximize</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Maximize</em>'.
	 * @generated
	 */
	Maximize createMaximize();

	/**
	 * Returns a new object of class '<em>Restore</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Restore</em>'.
	 * @generated
	 */
	Restore createRestore();

	/**
	 * Returns a new object of class '<em>Show Tab List</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Show Tab List</em>'.
	 * @generated
	 */
	ShowTabList createShowTabList();

	/**
	 * Returns a new object of class '<em>Options</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Options</em>'.
	 * @generated
	 */
	Options createOptions();

	/**
	 * Returns a new object of class '<em>Exec With Options</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Exec With Options</em>'.
	 * @generated
	 */
	ExecWithOptions createExecWithOptions();

	/**
	 * Returns a new object of class '<em>Shutdown Aut</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Shutdown Aut</em>'.
	 * @generated
	 */
	ShutdownAut createShutdownAut();

	/**
	 * Returns a new object of class '<em>Set Dialog Result</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Set Dialog Result</em>'.
	 * @generated
	 */
	SetDialogResult createSetDialogResult();

	/**
	 * Returns a new object of class '<em>Get Property Nodes</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Get Property Nodes</em>'.
	 * @generated
	 */
	GetPropertyNodes createGetPropertyNodes();

	/**
	 * Returns a new object of class '<em>Get By Os</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Get By Os</em>'.
	 * @generated
	 */
	GetByOs createGetByOs();

	/**
	 * Returns a new object of class '<em>From Raw Key</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>From Raw Key</em>'.
	 * @generated
	 */
	FromRawKey createFromRawKey();

	/**
	 * Returns a new object of class '<em>Hover At Text Offset</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Hover At Text Offset</em>'.
	 * @generated
	 */
	HoverAtTextOffset createHoverAtTextOffset();

	/**
	 * Returns a new object of class '<em>Get Text Viewer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Get Text Viewer</em>'.
	 * @generated
	 */
	GetTextViewer createGetTextViewer();

	/**
	 * Returns a new object of class '<em>Select Range</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Select Range</em>'.
	 * @generated
	 */
	SelectRange createSelectRange();

	/**
	 * Returns a new object of class '<em>Set Caret Pos</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Set Caret Pos</em>'.
	 * @generated
	 */
	SetCaretPos createSetCaretPos();

	/**
	 * Returns a new object of class '<em>Hover Text</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Hover Text</em>'.
	 * @generated
	 */
	HoverText createHoverText();

	/**
	 * Returns a new object of class '<em>Open Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Open Declaration</em>'.
	 * @generated
	 */
	OpenDeclaration createOpenDeclaration();

	/**
	 * Returns a new object of class '<em>Get Vertical Ruler</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Get Vertical Ruler</em>'.
	 * @generated
	 */
	GetVerticalRuler createGetVerticalRuler();

	/**
	 * Returns a new object of class '<em>Get Left Ruler</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Get Left Ruler</em>'.
	 * @generated
	 */
	GetLeftRuler createGetLeftRuler();

	/**
	 * Returns a new object of class '<em>Get Ruler Column</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Get Ruler Column</em>'.
	 * @generated
	 */
	GetRulerColumn createGetRulerColumn();

	/**
	 * Returns a new object of class '<em>Get Right Ruler</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Get Right Ruler</em>'.
	 * @generated
	 */
	GetRightRuler createGetRightRuler();

	/**
	 * Returns a new object of class '<em>Click Ruler</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Click Ruler</em>'.
	 * @generated
	 */
	ClickRuler createClickRuler();

	/**
	 * Returns a new object of class '<em>Double Click Ruler</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Double Click Ruler</em>'.
	 * @generated
	 */
	DoubleClickRuler createDoubleClickRuler();

	/**
	 * Returns a new object of class '<em>Hover Ruler</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Hover Ruler</em>'.
	 * @generated
	 */
	HoverRuler createHoverRuler();

	/**
	 * Returns a new object of class '<em>Click Link</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Click Link</em>'.
	 * @generated
	 */
	ClickLink createClickLink();

	/**
	 * Returns a new object of class '<em>Expand</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Expand</em>'.
	 * @generated
	 */
	Expand createExpand();

	/**
	 * Returns a new object of class '<em>Collapse</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Collapse</em>'.
	 * @generated
	 */
	Collapse createCollapse();

	/**
	 * Returns a new object of class '<em>Set Focus</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Set Focus</em>'.
	 * @generated
	 */
	SetFocus createSetFocus();

	/**
	 * Returns a new object of class '<em>Get Table Data</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Get Table Data</em>'.
	 * @generated
	 */
	GetTableData createGetTableData();

	/**
	 * Returns a new object of class '<em>Click Column</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Click Column</em>'.
	 * @generated
	 */
	ClickColumn createClickColumn();

	/**
	 * Returns a new object of class '<em>Trace</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Trace</em>'.
	 * @generated
	 */
	Trace createTrace();

	/**
	 * Returns a new object of class '<em>Mouse</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mouse</em>'.
	 * @generated
	 */
	Mouse createMouse();

	/**
	 * Returns a new object of class '<em>Get Object</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Get Object</em>'.
	 * @generated
	 */
	GetObject createGetObject();

	/**
	 * Returns a new object of class '<em>Get Items</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Get Items</em>'.
	 * @generated
	 */
	GetItems createGetItems();

	/**
	 * Returns a new object of class '<em>Expand All</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Expand All</em>'.
	 * @generated
	 */
	ExpandAll createExpandAll();

	/**
	 * Returns a new object of class '<em>Collapse All</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Collapse All</em>'.
	 * @generated
	 */
	CollapseAll createCollapseAll();

	/**
	 * Returns a new object of class '<em>Take Screenshot</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Take Screenshot</em>'.
	 * @generated
	 */
	TakeScreenshot createTakeScreenshot();

	/**
	 * Returns a new object of class '<em>Select Item</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Select Item</em>'.
	 * @generated
	 */
	SelectItem createSelectItem();

	/**
	 * Returns a new object of class '<em>Get Widget Details</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Get Widget Details</em>'.
	 * @generated
	 */
	GetWidgetDetails createGetWidgetDetails();

	/**
	 * Returns a new object of class '<em>Click Text</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Click Text</em>'.
	 * @generated
	 */
	ClickText createClickText();

	/**
	 * Returns a new object of class '<em>Get Quick Access</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Get Quick Access</em>'.
	 * @generated
	 */
	GetQuickAccess createGetQuickAccess();

	/**
	 * Returns a new object of class '<em>Get Column Header</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Get Column Header</em>'.
	 * @generated
	 */
	GetColumnHeader createGetColumnHeader();

	/**
	 * Returns a new object of class '<em>Set Position</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Set Position</em>'.
	 * @generated
	 */
	SetPosition createSetPosition();

	/**
	 * Returns a new object of class '<em>Set Width</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Set Width</em>'.
	 * @generated
	 */
	SetWidth createSetWidth();

	/**
	 * Returns a new object of class '<em>Get Property Tab</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Get Property Tab</em>'.
	 * @generated
	 */
	GetPropertyTab createGetPropertyTab();

	/**
	 * Returns a new object of class '<em>Show Alert</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Show Alert</em>'.
	 * @generated
	 */
	ShowAlert createShowAlert();

	/**
	 * Returns a new object of class '<em>Double Click Text</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Double Click Text</em>'.
	 * @generated
	 */
	DoubleClickText createDoubleClickText();

	/**
	 * Returns a new object of class '<em>To Control Handle</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>To Control Handle</em>'.
	 * @generated
	 */
	ToControlHandle createToControlHandle();

	/**
	 * Returns a new object of class '<em>Bound Control Handle</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Bound Control Handle</em>'.
	 * @generated
	 */
	BoundControlHandle createBoundControlHandle();

	/**
	 * Returns a new object of class '<em>Unfocus</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Unfocus</em>'.
	 * @generated
	 */
	Unfocus createUnfocus();

	/**
	 * Returns a new object of class '<em>Decrypt</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Decrypt</em>'.
	 * @generated
	 */
	Decrypt createDecrypt();

	/**
	 * Returns a new object of class '<em>Decrypt Result</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Decrypt Result</em>'.
	 * @generated
	 */
	DecryptResult createDecryptResult();

	/**
	 * Returns a new object of class '<em>Restart Aut</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Restart Aut</em>'.
	 * @generated
	 */
	RestartAut createRestartAut();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	TeslaPackage getTeslaPackage();

} //TeslaFactory

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
package org.eclipse.rcptt.tesla.core.protocol.raw.impl;

import org.eclipse.rcptt.tesla.core.protocol.raw.RawEvent;
import org.eclipse.rcptt.tesla.core.protocol.raw.RawPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Event</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.raw.impl.RawEventImpl#getWidget <em>Widget</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.raw.impl.RawEventImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.raw.impl.RawEventImpl#getDetail <em>Detail</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.raw.impl.RawEventImpl#getItem <em>Item</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.raw.impl.RawEventImpl#getIndex <em>Index</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.raw.impl.RawEventImpl#getX <em>X</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.raw.impl.RawEventImpl#getY <em>Y</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.raw.impl.RawEventImpl#getWidth <em>Width</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.raw.impl.RawEventImpl#getHeight <em>Height</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.raw.impl.RawEventImpl#getCount <em>Count</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.raw.impl.RawEventImpl#getTime <em>Time</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.raw.impl.RawEventImpl#getButton <em>Button</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.raw.impl.RawEventImpl#getCharacter <em>Character</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.raw.impl.RawEventImpl#getKeyCode <em>Key Code</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.raw.impl.RawEventImpl#getStateMask <em>State Mask</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.raw.impl.RawEventImpl#getStart <em>Start</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.raw.impl.RawEventImpl#getEnd <em>End</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.raw.impl.RawEventImpl#getText <em>Text</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.raw.impl.RawEventImpl#getData <em>Data</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.raw.impl.RawEventImpl#isNativeEvent <em>Native Event</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RawEventImpl extends EObjectImpl implements RawEvent {
	/**
	 * The cached value of the '{@link #getWidget() <em>Widget</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWidget()
	 * @generated
	 * @ordered
	 */
	protected EList<String> widget;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final int TYPE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected int type = TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getDetail() <em>Detail</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDetail()
	 * @generated
	 * @ordered
	 */
	protected static final int DETAIL_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getDetail() <em>Detail</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDetail()
	 * @generated
	 * @ordered
	 */
	protected int detail = DETAIL_EDEFAULT;

	/**
	 * The cached value of the '{@link #getItem() <em>Item</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getItem()
	 * @generated
	 * @ordered
	 */
	protected EList<String> item;

	/**
	 * The default value of the '{@link #getIndex() <em>Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndex()
	 * @generated
	 * @ordered
	 */
	protected static final int INDEX_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getIndex() <em>Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndex()
	 * @generated
	 * @ordered
	 */
	protected int index = INDEX_EDEFAULT;

	/**
	 * The default value of the '{@link #getX() <em>X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getX()
	 * @generated
	 * @ordered
	 */
	protected static final int X_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getX() <em>X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getX()
	 * @generated
	 * @ordered
	 */
	protected int x = X_EDEFAULT;

	/**
	 * The default value of the '{@link #getY() <em>Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getY()
	 * @generated
	 * @ordered
	 */
	protected static final int Y_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getY() <em>Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getY()
	 * @generated
	 * @ordered
	 */
	protected int y = Y_EDEFAULT;

	/**
	 * The default value of the '{@link #getWidth() <em>Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWidth()
	 * @generated
	 * @ordered
	 */
	protected static final int WIDTH_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getWidth() <em>Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWidth()
	 * @generated
	 * @ordered
	 */
	protected int width = WIDTH_EDEFAULT;

	/**
	 * The default value of the '{@link #getHeight() <em>Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeight()
	 * @generated
	 * @ordered
	 */
	protected static final int HEIGHT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getHeight() <em>Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeight()
	 * @generated
	 * @ordered
	 */
	protected int height = HEIGHT_EDEFAULT;

	/**
	 * The default value of the '{@link #getCount() <em>Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCount()
	 * @generated
	 * @ordered
	 */
	protected static final int COUNT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getCount() <em>Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCount()
	 * @generated
	 * @ordered
	 */
	protected int count = COUNT_EDEFAULT;

	/**
	 * The default value of the '{@link #getTime() <em>Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTime()
	 * @generated
	 * @ordered
	 */
	protected static final int TIME_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getTime() <em>Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTime()
	 * @generated
	 * @ordered
	 */
	protected int time = TIME_EDEFAULT;

	/**
	 * The default value of the '{@link #getButton() <em>Button</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getButton()
	 * @generated
	 * @ordered
	 */
	protected static final int BUTTON_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getButton() <em>Button</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getButton()
	 * @generated
	 * @ordered
	 */
	protected int button = BUTTON_EDEFAULT;

	/**
	 * The default value of the '{@link #getCharacter() <em>Character</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCharacter()
	 * @generated
	 * @ordered
	 */
	protected static final char CHARACTER_EDEFAULT = '\u0000';

	/**
	 * The cached value of the '{@link #getCharacter() <em>Character</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCharacter()
	 * @generated
	 * @ordered
	 */
	protected char character = CHARACTER_EDEFAULT;

	/**
	 * The default value of the '{@link #getKeyCode() <em>Key Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKeyCode()
	 * @generated
	 * @ordered
	 */
	protected static final int KEY_CODE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getKeyCode() <em>Key Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKeyCode()
	 * @generated
	 * @ordered
	 */
	protected int keyCode = KEY_CODE_EDEFAULT;

	/**
	 * The default value of the '{@link #getStateMask() <em>State Mask</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStateMask()
	 * @generated
	 * @ordered
	 */
	protected static final int STATE_MASK_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getStateMask() <em>State Mask</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStateMask()
	 * @generated
	 * @ordered
	 */
	protected int stateMask = STATE_MASK_EDEFAULT;

	/**
	 * The default value of the '{@link #getStart() <em>Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStart()
	 * @generated
	 * @ordered
	 */
	protected static final int START_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getStart() <em>Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStart()
	 * @generated
	 * @ordered
	 */
	protected int start = START_EDEFAULT;

	/**
	 * The default value of the '{@link #getEnd() <em>End</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnd()
	 * @generated
	 * @ordered
	 */
	protected static final int END_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getEnd() <em>End</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnd()
	 * @generated
	 * @ordered
	 */
	protected int end = END_EDEFAULT;

	/**
	 * The default value of the '{@link #getText() <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getText()
	 * @generated
	 * @ordered
	 */
	protected static final String TEXT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getText() <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getText()
	 * @generated
	 * @ordered
	 */
	protected String text = TEXT_EDEFAULT;

	/**
	 * The default value of the '{@link #getData() <em>Data</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getData()
	 * @generated
	 * @ordered
	 */
	protected static final String DATA_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getData() <em>Data</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getData()
	 * @generated
	 * @ordered
	 */
	protected String data = DATA_EDEFAULT;

	/**
	 * The default value of the '{@link #isNativeEvent() <em>Native Event</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNativeEvent()
	 * @generated
	 * @ordered
	 */
	protected static final boolean NATIVE_EVENT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isNativeEvent() <em>Native Event</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNativeEvent()
	 * @generated
	 * @ordered
	 */
	protected boolean nativeEvent = NATIVE_EVENT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RawEventImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RawPackage.Literals.RAW_EVENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getWidget() {
		if (widget == null)
		{
			widget = new EDataTypeEList<String>(String.class, this, RawPackage.RAW_EVENT__WIDGET);
		}
		return widget;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(int newType) {
		int oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RawPackage.RAW_EVENT__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getDetail() {
		return detail;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDetail(int newDetail) {
		int oldDetail = detail;
		detail = newDetail;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RawPackage.RAW_EVENT__DETAIL, oldDetail, detail));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getItem() {
		if (item == null)
		{
			item = new EDataTypeEList<String>(String.class, this, RawPackage.RAW_EVENT__ITEM);
		}
		return item;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getIndex() {
		return index;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIndex(int newIndex) {
		int oldIndex = index;
		index = newIndex;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RawPackage.RAW_EVENT__INDEX, oldIndex, index));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getX() {
		return x;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setX(int newX) {
		int oldX = x;
		x = newX;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RawPackage.RAW_EVENT__X, oldX, x));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getY() {
		return y;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setY(int newY) {
		int oldY = y;
		y = newY;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RawPackage.RAW_EVENT__Y, oldY, y));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWidth(int newWidth) {
		int oldWidth = width;
		width = newWidth;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RawPackage.RAW_EVENT__WIDTH, oldWidth, width));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHeight(int newHeight) {
		int oldHeight = height;
		height = newHeight;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RawPackage.RAW_EVENT__HEIGHT, oldHeight, height));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getCount() {
		return count;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCount(int newCount) {
		int oldCount = count;
		count = newCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RawPackage.RAW_EVENT__COUNT, oldCount, count));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getTime() {
		return time;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTime(int newTime) {
		int oldTime = time;
		time = newTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RawPackage.RAW_EVENT__TIME, oldTime, time));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getButton() {
		return button;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setButton(int newButton) {
		int oldButton = button;
		button = newButton;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RawPackage.RAW_EVENT__BUTTON, oldButton, button));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public char getCharacter() {
		return character;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCharacter(char newCharacter) {
		char oldCharacter = character;
		character = newCharacter;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RawPackage.RAW_EVENT__CHARACTER, oldCharacter,
					character));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getKeyCode() {
		return keyCode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKeyCode(int newKeyCode) {
		int oldKeyCode = keyCode;
		keyCode = newKeyCode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RawPackage.RAW_EVENT__KEY_CODE, oldKeyCode, keyCode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getStateMask() {
		return stateMask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStateMask(int newStateMask) {
		int oldStateMask = stateMask;
		stateMask = newStateMask;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RawPackage.RAW_EVENT__STATE_MASK, oldStateMask,
					stateMask));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getStart() {
		return start;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStart(int newStart) {
		int oldStart = start;
		start = newStart;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RawPackage.RAW_EVENT__START, oldStart, start));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getEnd() {
		return end;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnd(int newEnd) {
		int oldEnd = end;
		end = newEnd;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RawPackage.RAW_EVENT__END, oldEnd, end));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getText() {
		return text;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setText(String newText) {
		String oldText = text;
		text = newText;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RawPackage.RAW_EVENT__TEXT, oldText, text));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getData() {
		return data;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setData(String newData) {
		String oldData = data;
		data = newData;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RawPackage.RAW_EVENT__DATA, oldData, data));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isNativeEvent() {
		return nativeEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNativeEvent(boolean newNativeEvent) {
		boolean oldNativeEvent = nativeEvent;
		nativeEvent = newNativeEvent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RawPackage.RAW_EVENT__NATIVE_EVENT, oldNativeEvent,
					nativeEvent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID)
		{
		case RawPackage.RAW_EVENT__WIDGET:
			return getWidget();
		case RawPackage.RAW_EVENT__TYPE:
			return getType();
		case RawPackage.RAW_EVENT__DETAIL:
			return getDetail();
		case RawPackage.RAW_EVENT__ITEM:
			return getItem();
		case RawPackage.RAW_EVENT__INDEX:
			return getIndex();
		case RawPackage.RAW_EVENT__X:
			return getX();
		case RawPackage.RAW_EVENT__Y:
			return getY();
		case RawPackage.RAW_EVENT__WIDTH:
			return getWidth();
		case RawPackage.RAW_EVENT__HEIGHT:
			return getHeight();
		case RawPackage.RAW_EVENT__COUNT:
			return getCount();
		case RawPackage.RAW_EVENT__TIME:
			return getTime();
		case RawPackage.RAW_EVENT__BUTTON:
			return getButton();
		case RawPackage.RAW_EVENT__CHARACTER:
			return getCharacter();
		case RawPackage.RAW_EVENT__KEY_CODE:
			return getKeyCode();
		case RawPackage.RAW_EVENT__STATE_MASK:
			return getStateMask();
		case RawPackage.RAW_EVENT__START:
			return getStart();
		case RawPackage.RAW_EVENT__END:
			return getEnd();
		case RawPackage.RAW_EVENT__TEXT:
			return getText();
		case RawPackage.RAW_EVENT__DATA:
			return getData();
		case RawPackage.RAW_EVENT__NATIVE_EVENT:
			return isNativeEvent();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID)
		{
		case RawPackage.RAW_EVENT__WIDGET:
			getWidget().clear();
			getWidget().addAll((Collection<? extends String>) newValue);
			return;
		case RawPackage.RAW_EVENT__TYPE:
			setType((Integer) newValue);
			return;
		case RawPackage.RAW_EVENT__DETAIL:
			setDetail((Integer) newValue);
			return;
		case RawPackage.RAW_EVENT__ITEM:
			getItem().clear();
			getItem().addAll((Collection<? extends String>) newValue);
			return;
		case RawPackage.RAW_EVENT__INDEX:
			setIndex((Integer) newValue);
			return;
		case RawPackage.RAW_EVENT__X:
			setX((Integer) newValue);
			return;
		case RawPackage.RAW_EVENT__Y:
			setY((Integer) newValue);
			return;
		case RawPackage.RAW_EVENT__WIDTH:
			setWidth((Integer) newValue);
			return;
		case RawPackage.RAW_EVENT__HEIGHT:
			setHeight((Integer) newValue);
			return;
		case RawPackage.RAW_EVENT__COUNT:
			setCount((Integer) newValue);
			return;
		case RawPackage.RAW_EVENT__TIME:
			setTime((Integer) newValue);
			return;
		case RawPackage.RAW_EVENT__BUTTON:
			setButton((Integer) newValue);
			return;
		case RawPackage.RAW_EVENT__CHARACTER:
			setCharacter((Character) newValue);
			return;
		case RawPackage.RAW_EVENT__KEY_CODE:
			setKeyCode((Integer) newValue);
			return;
		case RawPackage.RAW_EVENT__STATE_MASK:
			setStateMask((Integer) newValue);
			return;
		case RawPackage.RAW_EVENT__START:
			setStart((Integer) newValue);
			return;
		case RawPackage.RAW_EVENT__END:
			setEnd((Integer) newValue);
			return;
		case RawPackage.RAW_EVENT__TEXT:
			setText((String) newValue);
			return;
		case RawPackage.RAW_EVENT__DATA:
			setData((String) newValue);
			return;
		case RawPackage.RAW_EVENT__NATIVE_EVENT:
			setNativeEvent((Boolean) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID)
		{
		case RawPackage.RAW_EVENT__WIDGET:
			getWidget().clear();
			return;
		case RawPackage.RAW_EVENT__TYPE:
			setType(TYPE_EDEFAULT);
			return;
		case RawPackage.RAW_EVENT__DETAIL:
			setDetail(DETAIL_EDEFAULT);
			return;
		case RawPackage.RAW_EVENT__ITEM:
			getItem().clear();
			return;
		case RawPackage.RAW_EVENT__INDEX:
			setIndex(INDEX_EDEFAULT);
			return;
		case RawPackage.RAW_EVENT__X:
			setX(X_EDEFAULT);
			return;
		case RawPackage.RAW_EVENT__Y:
			setY(Y_EDEFAULT);
			return;
		case RawPackage.RAW_EVENT__WIDTH:
			setWidth(WIDTH_EDEFAULT);
			return;
		case RawPackage.RAW_EVENT__HEIGHT:
			setHeight(HEIGHT_EDEFAULT);
			return;
		case RawPackage.RAW_EVENT__COUNT:
			setCount(COUNT_EDEFAULT);
			return;
		case RawPackage.RAW_EVENT__TIME:
			setTime(TIME_EDEFAULT);
			return;
		case RawPackage.RAW_EVENT__BUTTON:
			setButton(BUTTON_EDEFAULT);
			return;
		case RawPackage.RAW_EVENT__CHARACTER:
			setCharacter(CHARACTER_EDEFAULT);
			return;
		case RawPackage.RAW_EVENT__KEY_CODE:
			setKeyCode(KEY_CODE_EDEFAULT);
			return;
		case RawPackage.RAW_EVENT__STATE_MASK:
			setStateMask(STATE_MASK_EDEFAULT);
			return;
		case RawPackage.RAW_EVENT__START:
			setStart(START_EDEFAULT);
			return;
		case RawPackage.RAW_EVENT__END:
			setEnd(END_EDEFAULT);
			return;
		case RawPackage.RAW_EVENT__TEXT:
			setText(TEXT_EDEFAULT);
			return;
		case RawPackage.RAW_EVENT__DATA:
			setData(DATA_EDEFAULT);
			return;
		case RawPackage.RAW_EVENT__NATIVE_EVENT:
			setNativeEvent(NATIVE_EVENT_EDEFAULT);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID)
		{
		case RawPackage.RAW_EVENT__WIDGET:
			return widget != null && !widget.isEmpty();
		case RawPackage.RAW_EVENT__TYPE:
			return type != TYPE_EDEFAULT;
		case RawPackage.RAW_EVENT__DETAIL:
			return detail != DETAIL_EDEFAULT;
		case RawPackage.RAW_EVENT__ITEM:
			return item != null && !item.isEmpty();
		case RawPackage.RAW_EVENT__INDEX:
			return index != INDEX_EDEFAULT;
		case RawPackage.RAW_EVENT__X:
			return x != X_EDEFAULT;
		case RawPackage.RAW_EVENT__Y:
			return y != Y_EDEFAULT;
		case RawPackage.RAW_EVENT__WIDTH:
			return width != WIDTH_EDEFAULT;
		case RawPackage.RAW_EVENT__HEIGHT:
			return height != HEIGHT_EDEFAULT;
		case RawPackage.RAW_EVENT__COUNT:
			return count != COUNT_EDEFAULT;
		case RawPackage.RAW_EVENT__TIME:
			return time != TIME_EDEFAULT;
		case RawPackage.RAW_EVENT__BUTTON:
			return button != BUTTON_EDEFAULT;
		case RawPackage.RAW_EVENT__CHARACTER:
			return character != CHARACTER_EDEFAULT;
		case RawPackage.RAW_EVENT__KEY_CODE:
			return keyCode != KEY_CODE_EDEFAULT;
		case RawPackage.RAW_EVENT__STATE_MASK:
			return stateMask != STATE_MASK_EDEFAULT;
		case RawPackage.RAW_EVENT__START:
			return start != START_EDEFAULT;
		case RawPackage.RAW_EVENT__END:
			return end != END_EDEFAULT;
		case RawPackage.RAW_EVENT__TEXT:
			return TEXT_EDEFAULT == null ? text != null : !TEXT_EDEFAULT.equals(text);
		case RawPackage.RAW_EVENT__DATA:
			return DATA_EDEFAULT == null ? data != null : !DATA_EDEFAULT.equals(data);
		case RawPackage.RAW_EVENT__NATIVE_EVENT:
			return nativeEvent != NATIVE_EVENT_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (widget: ");
		result.append(widget);
		result.append(", type: ");
		result.append(type);
		result.append(", detail: ");
		result.append(detail);
		result.append(", item: ");
		result.append(item);
		result.append(", index: ");
		result.append(index);
		result.append(", x: ");
		result.append(x);
		result.append(", y: ");
		result.append(y);
		result.append(", width: ");
		result.append(width);
		result.append(", height: ");
		result.append(height);
		result.append(", count: ");
		result.append(count);
		result.append(", time: ");
		result.append(time);
		result.append(", button: ");
		result.append(button);
		result.append(", character: ");
		result.append(character);
		result.append(", keyCode: ");
		result.append(keyCode);
		result.append(", stateMask: ");
		result.append(stateMask);
		result.append(", start: ");
		result.append(start);
		result.append(", end: ");
		result.append(end);
		result.append(", text: ");
		result.append(text);
		result.append(", data: ");
		result.append(data);
		result.append(", nativeEvent: ");
		result.append(nativeEvent);
		result.append(')');
		return result.toString();
	}

} //RawEventImpl

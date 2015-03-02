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
package org.eclipse.rcptt.tesla.core.ui.impl;

import org.eclipse.rcptt.tesla.core.ui.Color;
import org.eclipse.rcptt.tesla.core.ui.DiagramItem;
import org.eclipse.rcptt.tesla.core.ui.Image;
import org.eclipse.rcptt.tesla.core.ui.PropertyEntry;
import org.eclipse.rcptt.tesla.core.ui.PropertyMap;
import org.eclipse.rcptt.tesla.core.ui.PropertyNode;
import org.eclipse.rcptt.tesla.core.ui.UiPackage;

import org.eclipse.rcptt.tesla.core.ui.WithImage;
import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Diagram Item</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.impl.DiagramItemImpl#get__properties <em>properties</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.impl.DiagramItemImpl#getImage <em>Image</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.impl.DiagramItemImpl#getText <em>Text</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.impl.DiagramItemImpl#getTooltip <em>Tooltip</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.impl.DiagramItemImpl#getClassName <em>Class Name</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.impl.DiagramItemImpl#getItemAddress <em>Item Address</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.impl.DiagramItemImpl#isSelected <em>Selected</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.impl.DiagramItemImpl#getX <em>X</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.impl.DiagramItemImpl#getY <em>Y</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.impl.DiagramItemImpl#getWidth <em>Width</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.impl.DiagramItemImpl#getHeight <em>Height</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.impl.DiagramItemImpl#getChildrenCount <em>Children Count</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.impl.DiagramItemImpl#getBackgroundColor <em>Background Color</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.impl.DiagramItemImpl#getForegroundColor <em>Foreground Color</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.impl.DiagramItemImpl#getModelPropertyNodes <em>Model Property Nodes</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DiagramItemImpl extends WidgetImpl implements DiagramItem {
	/**
	 * The cached value of the '{@link #get__properties() <em>properties</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #get__properties()
	 * @generated
	 * @ordered
	 */
	protected EList<PropertyEntry> __properties;

	/**
	 * The cached value of the '{@link #getImage() <em>Image</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImage()
	 * @generated
	 * @ordered
	 */
	protected Image image;

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
	 * The default value of the '{@link #getTooltip() <em>Tooltip</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTooltip()
	 * @generated
	 * @ordered
	 */
	protected static final String TOOLTIP_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTooltip() <em>Tooltip</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTooltip()
	 * @generated
	 * @ordered
	 */
	protected String tooltip = TOOLTIP_EDEFAULT;

	/**
	 * The default value of the '{@link #getClassName() <em>Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassName()
	 * @generated
	 * @ordered
	 */
	protected static final String CLASS_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getClassName() <em>Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassName()
	 * @generated
	 * @ordered
	 */
	protected String className = CLASS_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getItemAddress() <em>Item Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getItemAddress()
	 * @generated
	 * @ordered
	 */
	protected static final String ITEM_ADDRESS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getItemAddress() <em>Item Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getItemAddress()
	 * @generated
	 * @ordered
	 */
	protected String itemAddress = ITEM_ADDRESS_EDEFAULT;

	/**
	 * The default value of the '{@link #isSelected() <em>Selected</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSelected()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SELECTED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isSelected() <em>Selected</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSelected()
	 * @generated
	 * @ordered
	 */
	protected boolean selected = SELECTED_EDEFAULT;

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
	 * The default value of the '{@link #getChildrenCount() <em>Children Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChildrenCount()
	 * @generated
	 * @ordered
	 */
	protected static final int CHILDREN_COUNT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getChildrenCount() <em>Children Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChildrenCount()
	 * @generated
	 * @ordered
	 */
	protected int childrenCount = CHILDREN_COUNT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getBackgroundColor() <em>Background Color</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBackgroundColor()
	 * @generated
	 * @ordered
	 */
	protected Color backgroundColor;

	/**
	 * The cached value of the '{@link #getForegroundColor() <em>Foreground Color</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getForegroundColor()
	 * @generated
	 * @ordered
	 */
	protected Color foregroundColor;

	/**
	 * The cached value of the '{@link #getModelPropertyNodes() <em>Model Property Nodes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelPropertyNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<PropertyNode> modelPropertyNodes;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DiagramItemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UiPackage.Literals.DIAGRAM_ITEM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PropertyEntry> get__properties() {
		if (__properties == null) {
			__properties = new EObjectContainmentEList<PropertyEntry>(PropertyEntry.class, this, UiPackage.DIAGRAM_ITEM__PROPERTIES);
		}
		return __properties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Image getImage() {
		return image;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetImage(Image newImage, NotificationChain msgs) {
		Image oldImage = image;
		image = newImage;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UiPackage.DIAGRAM_ITEM__IMAGE, oldImage, newImage);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImage(Image newImage) {
		if (newImage != image) {
			NotificationChain msgs = null;
			if (image != null)
				msgs = ((InternalEObject)image).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UiPackage.DIAGRAM_ITEM__IMAGE, null, msgs);
			if (newImage != null)
				msgs = ((InternalEObject)newImage).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UiPackage.DIAGRAM_ITEM__IMAGE, null, msgs);
			msgs = basicSetImage(newImage, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.DIAGRAM_ITEM__IMAGE, newImage, newImage));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.DIAGRAM_ITEM__X, oldX, x));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.DIAGRAM_ITEM__Y, oldY, y));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.DIAGRAM_ITEM__WIDTH, oldWidth, width));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.DIAGRAM_ITEM__HEIGHT, oldHeight, height));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTooltip() {
		return tooltip;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTooltip(String newTooltip) {
		String oldTooltip = tooltip;
		tooltip = newTooltip;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.DIAGRAM_ITEM__TOOLTIP, oldTooltip, tooltip));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getChildrenCount() {
		return childrenCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setChildrenCount(int newChildrenCount) {
		int oldChildrenCount = childrenCount;
		childrenCount = newChildrenCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.DIAGRAM_ITEM__CHILDREN_COUNT, oldChildrenCount, childrenCount));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.DIAGRAM_ITEM__TEXT, oldText, text));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Color getBackgroundColor() {
		return backgroundColor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBackgroundColor(Color newBackgroundColor, NotificationChain msgs) {
		Color oldBackgroundColor = backgroundColor;
		backgroundColor = newBackgroundColor;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UiPackage.DIAGRAM_ITEM__BACKGROUND_COLOR, oldBackgroundColor, newBackgroundColor);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBackgroundColor(Color newBackgroundColor) {
		if (newBackgroundColor != backgroundColor) {
			NotificationChain msgs = null;
			if (backgroundColor != null)
				msgs = ((InternalEObject)backgroundColor).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UiPackage.DIAGRAM_ITEM__BACKGROUND_COLOR, null, msgs);
			if (newBackgroundColor != null)
				msgs = ((InternalEObject)newBackgroundColor).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UiPackage.DIAGRAM_ITEM__BACKGROUND_COLOR, null, msgs);
			msgs = basicSetBackgroundColor(newBackgroundColor, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.DIAGRAM_ITEM__BACKGROUND_COLOR, newBackgroundColor, newBackgroundColor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Color getForegroundColor() {
		return foregroundColor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetForegroundColor(Color newForegroundColor, NotificationChain msgs) {
		Color oldForegroundColor = foregroundColor;
		foregroundColor = newForegroundColor;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UiPackage.DIAGRAM_ITEM__FOREGROUND_COLOR, oldForegroundColor, newForegroundColor);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setForegroundColor(Color newForegroundColor) {
		if (newForegroundColor != foregroundColor) {
			NotificationChain msgs = null;
			if (foregroundColor != null)
				msgs = ((InternalEObject)foregroundColor).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UiPackage.DIAGRAM_ITEM__FOREGROUND_COLOR, null, msgs);
			if (newForegroundColor != null)
				msgs = ((InternalEObject)newForegroundColor).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UiPackage.DIAGRAM_ITEM__FOREGROUND_COLOR, null, msgs);
			msgs = basicSetForegroundColor(newForegroundColor, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.DIAGRAM_ITEM__FOREGROUND_COLOR, newForegroundColor, newForegroundColor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PropertyNode> getModelPropertyNodes() {
		if (modelPropertyNodes == null) {
			modelPropertyNodes = new EObjectContainmentEList<PropertyNode>(PropertyNode.class, this, UiPackage.DIAGRAM_ITEM__MODEL_PROPERTY_NODES);
		}
		return modelPropertyNodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getItemAddress() {
		return itemAddress;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setItemAddress(String newItemAddress) {
		String oldItemAddress = itemAddress;
		itemAddress = newItemAddress;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.DIAGRAM_ITEM__ITEM_ADDRESS, oldItemAddress, itemAddress));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSelected() {
		return selected;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSelected(boolean newSelected) {
		boolean oldSelected = selected;
		selected = newSelected;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.DIAGRAM_ITEM__SELECTED, oldSelected, selected));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getClassName() {
		return className;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClassName(String newClassName) {
		String oldClassName = className;
		className = newClassName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.DIAGRAM_ITEM__CLASS_NAME, oldClassName, className));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UiPackage.DIAGRAM_ITEM__PROPERTIES:
				return ((InternalEList<?>)get__properties()).basicRemove(otherEnd, msgs);
			case UiPackage.DIAGRAM_ITEM__IMAGE:
				return basicSetImage(null, msgs);
			case UiPackage.DIAGRAM_ITEM__BACKGROUND_COLOR:
				return basicSetBackgroundColor(null, msgs);
			case UiPackage.DIAGRAM_ITEM__FOREGROUND_COLOR:
				return basicSetForegroundColor(null, msgs);
			case UiPackage.DIAGRAM_ITEM__MODEL_PROPERTY_NODES:
				return ((InternalEList<?>)getModelPropertyNodes()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case UiPackage.DIAGRAM_ITEM__PROPERTIES:
				return get__properties();
			case UiPackage.DIAGRAM_ITEM__IMAGE:
				return getImage();
			case UiPackage.DIAGRAM_ITEM__TEXT:
				return getText();
			case UiPackage.DIAGRAM_ITEM__TOOLTIP:
				return getTooltip();
			case UiPackage.DIAGRAM_ITEM__CLASS_NAME:
				return getClassName();
			case UiPackage.DIAGRAM_ITEM__ITEM_ADDRESS:
				return getItemAddress();
			case UiPackage.DIAGRAM_ITEM__SELECTED:
				return isSelected();
			case UiPackage.DIAGRAM_ITEM__X:
				return getX();
			case UiPackage.DIAGRAM_ITEM__Y:
				return getY();
			case UiPackage.DIAGRAM_ITEM__WIDTH:
				return getWidth();
			case UiPackage.DIAGRAM_ITEM__HEIGHT:
				return getHeight();
			case UiPackage.DIAGRAM_ITEM__CHILDREN_COUNT:
				return getChildrenCount();
			case UiPackage.DIAGRAM_ITEM__BACKGROUND_COLOR:
				return getBackgroundColor();
			case UiPackage.DIAGRAM_ITEM__FOREGROUND_COLOR:
				return getForegroundColor();
			case UiPackage.DIAGRAM_ITEM__MODEL_PROPERTY_NODES:
				return getModelPropertyNodes();
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
		switch (featureID) {
			case UiPackage.DIAGRAM_ITEM__PROPERTIES:
				get__properties().clear();
				get__properties().addAll((Collection<? extends PropertyEntry>)newValue);
				return;
			case UiPackage.DIAGRAM_ITEM__IMAGE:
				setImage((Image)newValue);
				return;
			case UiPackage.DIAGRAM_ITEM__TEXT:
				setText((String)newValue);
				return;
			case UiPackage.DIAGRAM_ITEM__TOOLTIP:
				setTooltip((String)newValue);
				return;
			case UiPackage.DIAGRAM_ITEM__CLASS_NAME:
				setClassName((String)newValue);
				return;
			case UiPackage.DIAGRAM_ITEM__ITEM_ADDRESS:
				setItemAddress((String)newValue);
				return;
			case UiPackage.DIAGRAM_ITEM__SELECTED:
				setSelected((Boolean)newValue);
				return;
			case UiPackage.DIAGRAM_ITEM__X:
				setX((Integer)newValue);
				return;
			case UiPackage.DIAGRAM_ITEM__Y:
				setY((Integer)newValue);
				return;
			case UiPackage.DIAGRAM_ITEM__WIDTH:
				setWidth((Integer)newValue);
				return;
			case UiPackage.DIAGRAM_ITEM__HEIGHT:
				setHeight((Integer)newValue);
				return;
			case UiPackage.DIAGRAM_ITEM__CHILDREN_COUNT:
				setChildrenCount((Integer)newValue);
				return;
			case UiPackage.DIAGRAM_ITEM__BACKGROUND_COLOR:
				setBackgroundColor((Color)newValue);
				return;
			case UiPackage.DIAGRAM_ITEM__FOREGROUND_COLOR:
				setForegroundColor((Color)newValue);
				return;
			case UiPackage.DIAGRAM_ITEM__MODEL_PROPERTY_NODES:
				getModelPropertyNodes().clear();
				getModelPropertyNodes().addAll((Collection<? extends PropertyNode>)newValue);
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
		switch (featureID) {
			case UiPackage.DIAGRAM_ITEM__PROPERTIES:
				get__properties().clear();
				return;
			case UiPackage.DIAGRAM_ITEM__IMAGE:
				setImage((Image)null);
				return;
			case UiPackage.DIAGRAM_ITEM__TEXT:
				setText(TEXT_EDEFAULT);
				return;
			case UiPackage.DIAGRAM_ITEM__TOOLTIP:
				setTooltip(TOOLTIP_EDEFAULT);
				return;
			case UiPackage.DIAGRAM_ITEM__CLASS_NAME:
				setClassName(CLASS_NAME_EDEFAULT);
				return;
			case UiPackage.DIAGRAM_ITEM__ITEM_ADDRESS:
				setItemAddress(ITEM_ADDRESS_EDEFAULT);
				return;
			case UiPackage.DIAGRAM_ITEM__SELECTED:
				setSelected(SELECTED_EDEFAULT);
				return;
			case UiPackage.DIAGRAM_ITEM__X:
				setX(X_EDEFAULT);
				return;
			case UiPackage.DIAGRAM_ITEM__Y:
				setY(Y_EDEFAULT);
				return;
			case UiPackage.DIAGRAM_ITEM__WIDTH:
				setWidth(WIDTH_EDEFAULT);
				return;
			case UiPackage.DIAGRAM_ITEM__HEIGHT:
				setHeight(HEIGHT_EDEFAULT);
				return;
			case UiPackage.DIAGRAM_ITEM__CHILDREN_COUNT:
				setChildrenCount(CHILDREN_COUNT_EDEFAULT);
				return;
			case UiPackage.DIAGRAM_ITEM__BACKGROUND_COLOR:
				setBackgroundColor((Color)null);
				return;
			case UiPackage.DIAGRAM_ITEM__FOREGROUND_COLOR:
				setForegroundColor((Color)null);
				return;
			case UiPackage.DIAGRAM_ITEM__MODEL_PROPERTY_NODES:
				getModelPropertyNodes().clear();
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
		switch (featureID) {
			case UiPackage.DIAGRAM_ITEM__PROPERTIES:
				return __properties != null && !__properties.isEmpty();
			case UiPackage.DIAGRAM_ITEM__IMAGE:
				return image != null;
			case UiPackage.DIAGRAM_ITEM__TEXT:
				return TEXT_EDEFAULT == null ? text != null : !TEXT_EDEFAULT.equals(text);
			case UiPackage.DIAGRAM_ITEM__TOOLTIP:
				return TOOLTIP_EDEFAULT == null ? tooltip != null : !TOOLTIP_EDEFAULT.equals(tooltip);
			case UiPackage.DIAGRAM_ITEM__CLASS_NAME:
				return CLASS_NAME_EDEFAULT == null ? className != null : !CLASS_NAME_EDEFAULT.equals(className);
			case UiPackage.DIAGRAM_ITEM__ITEM_ADDRESS:
				return ITEM_ADDRESS_EDEFAULT == null ? itemAddress != null : !ITEM_ADDRESS_EDEFAULT.equals(itemAddress);
			case UiPackage.DIAGRAM_ITEM__SELECTED:
				return selected != SELECTED_EDEFAULT;
			case UiPackage.DIAGRAM_ITEM__X:
				return x != X_EDEFAULT;
			case UiPackage.DIAGRAM_ITEM__Y:
				return y != Y_EDEFAULT;
			case UiPackage.DIAGRAM_ITEM__WIDTH:
				return width != WIDTH_EDEFAULT;
			case UiPackage.DIAGRAM_ITEM__HEIGHT:
				return height != HEIGHT_EDEFAULT;
			case UiPackage.DIAGRAM_ITEM__CHILDREN_COUNT:
				return childrenCount != CHILDREN_COUNT_EDEFAULT;
			case UiPackage.DIAGRAM_ITEM__BACKGROUND_COLOR:
				return backgroundColor != null;
			case UiPackage.DIAGRAM_ITEM__FOREGROUND_COLOR:
				return foregroundColor != null;
			case UiPackage.DIAGRAM_ITEM__MODEL_PROPERTY_NODES:
				return modelPropertyNodes != null && !modelPropertyNodes.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == PropertyMap.class) {
			switch (derivedFeatureID) {
				case UiPackage.DIAGRAM_ITEM__PROPERTIES: return UiPackage.PROPERTY_MAP__PROPERTIES;
				default: return -1;
			}
		}
		if (baseClass == WithImage.class) {
			switch (derivedFeatureID) {
				case UiPackage.DIAGRAM_ITEM__IMAGE: return UiPackage.WITH_IMAGE__IMAGE;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == PropertyMap.class) {
			switch (baseFeatureID) {
				case UiPackage.PROPERTY_MAP__PROPERTIES: return UiPackage.DIAGRAM_ITEM__PROPERTIES;
				default: return -1;
			}
		}
		if (baseClass == WithImage.class) {
			switch (baseFeatureID) {
				case UiPackage.WITH_IMAGE__IMAGE: return UiPackage.DIAGRAM_ITEM__IMAGE;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (text: ");
		result.append(text);
		result.append(", tooltip: ");
		result.append(tooltip);
		result.append(", className: ");
		result.append(className);
		result.append(", itemAddress: ");
		result.append(itemAddress);
		result.append(", selected: ");
		result.append(selected);
		result.append(", x: ");
		result.append(x);
		result.append(", y: ");
		result.append(y);
		result.append(", width: ");
		result.append(width);
		result.append(", height: ");
		result.append(height);
		result.append(", childrenCount: ");
		result.append(childrenCount);
		result.append(')');
		return result.toString();
	}

} //DiagramItemImpl

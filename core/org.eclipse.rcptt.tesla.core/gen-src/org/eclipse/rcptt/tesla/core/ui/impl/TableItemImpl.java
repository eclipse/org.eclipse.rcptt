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
import org.eclipse.rcptt.tesla.core.ui.Image;
import org.eclipse.rcptt.tesla.core.ui.Rectangle;
import org.eclipse.rcptt.tesla.core.ui.StyleRangeEntry;
import org.eclipse.rcptt.tesla.core.ui.TableItem;
import org.eclipse.rcptt.tesla.core.ui.UiPackage;

import org.eclipse.rcptt.tesla.core.ui.WithImage;
import java.util.Collection;

import java.util.Map;
import java.util.Map.Entry;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Table Item</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.impl.TableItemImpl#getImage <em>Image</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.impl.TableItemImpl#isSelected <em>Selected</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.impl.TableItemImpl#isChecked <em>Checked</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.impl.TableItemImpl#getBackgroundColor <em>Background Color</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.impl.TableItemImpl#getForegroundColor <em>Foreground Color</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.impl.TableItemImpl#getBounds <em>Bounds</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.impl.TableItemImpl#getColumns <em>Columns</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.impl.TableItemImpl#getColumnsBackgroundColor <em>Columns Background Color</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.impl.TableItemImpl#getColumnsForegroundColor <em>Columns Foreground Color</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.impl.TableItemImpl#getStyleRanges <em>Style Ranges</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.impl.TableItemImpl#getStyles <em>Styles</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.ui.impl.TableItemImpl#getValues <em>Values</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TableItemImpl extends ItemImpl implements TableItem {
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
	 * The default value of the '{@link #isChecked() <em>Checked</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isChecked()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CHECKED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isChecked() <em>Checked</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isChecked()
	 * @generated
	 * @ordered
	 */
	protected boolean checked = CHECKED_EDEFAULT;

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
	 * The cached value of the '{@link #getBounds() <em>Bounds</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBounds()
	 * @generated
	 * @ordered
	 */
	protected Rectangle bounds;

	/**
	 * The cached value of the '{@link #getColumns() <em>Columns</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColumns()
	 * @generated
	 * @ordered
	 */
	protected EList<String> columns;

	/**
	 * The cached value of the '{@link #getColumnsBackgroundColor() <em>Columns Background Color</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColumnsBackgroundColor()
	 * @generated
	 * @ordered
	 */
	protected EList<Color> columnsBackgroundColor;

	/**
	 * The cached value of the '{@link #getColumnsForegroundColor() <em>Columns Foreground Color</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColumnsForegroundColor()
	 * @generated
	 * @ordered
	 */
	protected EList<Color> columnsForegroundColor;

	/**
	 * The cached value of the '{@link #getStyleRanges() <em>Style Ranges</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStyleRanges()
	 * @generated
	 * @ordered
	 */
	protected EList<String> styleRanges;

	/**
	 * The cached value of the '{@link #getStyles() <em>Styles</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStyles()
	 * @generated
	 * @ordered
	 */
	protected EList<StyleRangeEntry> styles;

	/**
	 * The cached value of the '{@link #getValues() <em>Values</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValues()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, String> values;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TableItemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UiPackage.Literals.TABLE_ITEM;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UiPackage.TABLE_ITEM__IMAGE, oldImage, newImage);
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
				msgs = ((InternalEObject)image).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UiPackage.TABLE_ITEM__IMAGE, null, msgs);
			if (newImage != null)
				msgs = ((InternalEObject)newImage).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UiPackage.TABLE_ITEM__IMAGE, null, msgs);
			msgs = basicSetImage(newImage, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.TABLE_ITEM__IMAGE, newImage, newImage));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.TABLE_ITEM__SELECTED, oldSelected, selected));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isChecked() {
		return checked;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setChecked(boolean newChecked) {
		boolean oldChecked = checked;
		checked = newChecked;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.TABLE_ITEM__CHECKED, oldChecked, checked));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UiPackage.TABLE_ITEM__BACKGROUND_COLOR, oldBackgroundColor, newBackgroundColor);
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
				msgs = ((InternalEObject)backgroundColor).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UiPackage.TABLE_ITEM__BACKGROUND_COLOR, null, msgs);
			if (newBackgroundColor != null)
				msgs = ((InternalEObject)newBackgroundColor).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UiPackage.TABLE_ITEM__BACKGROUND_COLOR, null, msgs);
			msgs = basicSetBackgroundColor(newBackgroundColor, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.TABLE_ITEM__BACKGROUND_COLOR, newBackgroundColor, newBackgroundColor));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UiPackage.TABLE_ITEM__FOREGROUND_COLOR, oldForegroundColor, newForegroundColor);
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
				msgs = ((InternalEObject)foregroundColor).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UiPackage.TABLE_ITEM__FOREGROUND_COLOR, null, msgs);
			if (newForegroundColor != null)
				msgs = ((InternalEObject)newForegroundColor).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UiPackage.TABLE_ITEM__FOREGROUND_COLOR, null, msgs);
			msgs = basicSetForegroundColor(newForegroundColor, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.TABLE_ITEM__FOREGROUND_COLOR, newForegroundColor, newForegroundColor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Rectangle getBounds() {
		return bounds;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBounds(Rectangle newBounds, NotificationChain msgs) {
		Rectangle oldBounds = bounds;
		bounds = newBounds;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UiPackage.TABLE_ITEM__BOUNDS, oldBounds, newBounds);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBounds(Rectangle newBounds) {
		if (newBounds != bounds) {
			NotificationChain msgs = null;
			if (bounds != null)
				msgs = ((InternalEObject)bounds).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UiPackage.TABLE_ITEM__BOUNDS, null, msgs);
			if (newBounds != null)
				msgs = ((InternalEObject)newBounds).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UiPackage.TABLE_ITEM__BOUNDS, null, msgs);
			msgs = basicSetBounds(newBounds, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiPackage.TABLE_ITEM__BOUNDS, newBounds, newBounds));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getColumns() {
		if (columns == null) {
			columns = new EDataTypeEList<String>(String.class, this, UiPackage.TABLE_ITEM__COLUMNS);
		}
		return columns;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Color> getColumnsBackgroundColor() {
		if (columnsBackgroundColor == null) {
			columnsBackgroundColor = new EObjectContainmentEList<Color>(Color.class, this, UiPackage.TABLE_ITEM__COLUMNS_BACKGROUND_COLOR);
		}
		return columnsBackgroundColor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Color> getColumnsForegroundColor() {
		if (columnsForegroundColor == null) {
			columnsForegroundColor = new EObjectContainmentEList<Color>(Color.class, this, UiPackage.TABLE_ITEM__COLUMNS_FOREGROUND_COLOR);
		}
		return columnsForegroundColor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getStyleRanges() {
		if (styleRanges == null) {
			styleRanges = new EDataTypeUniqueEList<String>(String.class, this, UiPackage.TABLE_ITEM__STYLE_RANGES);
		}
		return styleRanges;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<StyleRangeEntry> getStyles() {
		if (styles == null) {
			styles = new EObjectContainmentEList<StyleRangeEntry>(StyleRangeEntry.class, this, UiPackage.TABLE_ITEM__STYLES);
		}
		return styles;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap<String, String> getValues() {
		if (values == null) {
			values = new EcoreEMap<String,String>(UiPackage.Literals.VALUES_MAP, ValuesMapImpl.class, this, UiPackage.TABLE_ITEM__VALUES);
		}
		return values;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UiPackage.TABLE_ITEM__IMAGE:
				return basicSetImage(null, msgs);
			case UiPackage.TABLE_ITEM__BACKGROUND_COLOR:
				return basicSetBackgroundColor(null, msgs);
			case UiPackage.TABLE_ITEM__FOREGROUND_COLOR:
				return basicSetForegroundColor(null, msgs);
			case UiPackage.TABLE_ITEM__BOUNDS:
				return basicSetBounds(null, msgs);
			case UiPackage.TABLE_ITEM__COLUMNS_BACKGROUND_COLOR:
				return ((InternalEList<?>)getColumnsBackgroundColor()).basicRemove(otherEnd, msgs);
			case UiPackage.TABLE_ITEM__COLUMNS_FOREGROUND_COLOR:
				return ((InternalEList<?>)getColumnsForegroundColor()).basicRemove(otherEnd, msgs);
			case UiPackage.TABLE_ITEM__STYLES:
				return ((InternalEList<?>)getStyles()).basicRemove(otherEnd, msgs);
			case UiPackage.TABLE_ITEM__VALUES:
				return ((InternalEList<?>)getValues()).basicRemove(otherEnd, msgs);
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
			case UiPackage.TABLE_ITEM__IMAGE:
				return getImage();
			case UiPackage.TABLE_ITEM__SELECTED:
				return isSelected();
			case UiPackage.TABLE_ITEM__CHECKED:
				return isChecked();
			case UiPackage.TABLE_ITEM__BACKGROUND_COLOR:
				return getBackgroundColor();
			case UiPackage.TABLE_ITEM__FOREGROUND_COLOR:
				return getForegroundColor();
			case UiPackage.TABLE_ITEM__BOUNDS:
				return getBounds();
			case UiPackage.TABLE_ITEM__COLUMNS:
				return getColumns();
			case UiPackage.TABLE_ITEM__COLUMNS_BACKGROUND_COLOR:
				return getColumnsBackgroundColor();
			case UiPackage.TABLE_ITEM__COLUMNS_FOREGROUND_COLOR:
				return getColumnsForegroundColor();
			case UiPackage.TABLE_ITEM__STYLE_RANGES:
				return getStyleRanges();
			case UiPackage.TABLE_ITEM__STYLES:
				return getStyles();
			case UiPackage.TABLE_ITEM__VALUES:
				if (coreType) return getValues();
				else return getValues().map();
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
			case UiPackage.TABLE_ITEM__IMAGE:
				setImage((Image)newValue);
				return;
			case UiPackage.TABLE_ITEM__SELECTED:
				setSelected((Boolean)newValue);
				return;
			case UiPackage.TABLE_ITEM__CHECKED:
				setChecked((Boolean)newValue);
				return;
			case UiPackage.TABLE_ITEM__BACKGROUND_COLOR:
				setBackgroundColor((Color)newValue);
				return;
			case UiPackage.TABLE_ITEM__FOREGROUND_COLOR:
				setForegroundColor((Color)newValue);
				return;
			case UiPackage.TABLE_ITEM__BOUNDS:
				setBounds((Rectangle)newValue);
				return;
			case UiPackage.TABLE_ITEM__COLUMNS:
				getColumns().clear();
				getColumns().addAll((Collection<? extends String>)newValue);
				return;
			case UiPackage.TABLE_ITEM__COLUMNS_BACKGROUND_COLOR:
				getColumnsBackgroundColor().clear();
				getColumnsBackgroundColor().addAll((Collection<? extends Color>)newValue);
				return;
			case UiPackage.TABLE_ITEM__COLUMNS_FOREGROUND_COLOR:
				getColumnsForegroundColor().clear();
				getColumnsForegroundColor().addAll((Collection<? extends Color>)newValue);
				return;
			case UiPackage.TABLE_ITEM__STYLE_RANGES:
				getStyleRanges().clear();
				getStyleRanges().addAll((Collection<? extends String>)newValue);
				return;
			case UiPackage.TABLE_ITEM__STYLES:
				getStyles().clear();
				getStyles().addAll((Collection<? extends StyleRangeEntry>)newValue);
				return;
			case UiPackage.TABLE_ITEM__VALUES:
				((EStructuralFeature.Setting)getValues()).set(newValue);
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
			case UiPackage.TABLE_ITEM__IMAGE:
				setImage((Image)null);
				return;
			case UiPackage.TABLE_ITEM__SELECTED:
				setSelected(SELECTED_EDEFAULT);
				return;
			case UiPackage.TABLE_ITEM__CHECKED:
				setChecked(CHECKED_EDEFAULT);
				return;
			case UiPackage.TABLE_ITEM__BACKGROUND_COLOR:
				setBackgroundColor((Color)null);
				return;
			case UiPackage.TABLE_ITEM__FOREGROUND_COLOR:
				setForegroundColor((Color)null);
				return;
			case UiPackage.TABLE_ITEM__BOUNDS:
				setBounds((Rectangle)null);
				return;
			case UiPackage.TABLE_ITEM__COLUMNS:
				getColumns().clear();
				return;
			case UiPackage.TABLE_ITEM__COLUMNS_BACKGROUND_COLOR:
				getColumnsBackgroundColor().clear();
				return;
			case UiPackage.TABLE_ITEM__COLUMNS_FOREGROUND_COLOR:
				getColumnsForegroundColor().clear();
				return;
			case UiPackage.TABLE_ITEM__STYLE_RANGES:
				getStyleRanges().clear();
				return;
			case UiPackage.TABLE_ITEM__STYLES:
				getStyles().clear();
				return;
			case UiPackage.TABLE_ITEM__VALUES:
				getValues().clear();
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
			case UiPackage.TABLE_ITEM__IMAGE:
				return image != null;
			case UiPackage.TABLE_ITEM__SELECTED:
				return selected != SELECTED_EDEFAULT;
			case UiPackage.TABLE_ITEM__CHECKED:
				return checked != CHECKED_EDEFAULT;
			case UiPackage.TABLE_ITEM__BACKGROUND_COLOR:
				return backgroundColor != null;
			case UiPackage.TABLE_ITEM__FOREGROUND_COLOR:
				return foregroundColor != null;
			case UiPackage.TABLE_ITEM__BOUNDS:
				return bounds != null;
			case UiPackage.TABLE_ITEM__COLUMNS:
				return columns != null && !columns.isEmpty();
			case UiPackage.TABLE_ITEM__COLUMNS_BACKGROUND_COLOR:
				return columnsBackgroundColor != null && !columnsBackgroundColor.isEmpty();
			case UiPackage.TABLE_ITEM__COLUMNS_FOREGROUND_COLOR:
				return columnsForegroundColor != null && !columnsForegroundColor.isEmpty();
			case UiPackage.TABLE_ITEM__STYLE_RANGES:
				return styleRanges != null && !styleRanges.isEmpty();
			case UiPackage.TABLE_ITEM__STYLES:
				return styles != null && !styles.isEmpty();
			case UiPackage.TABLE_ITEM__VALUES:
				return values != null && !values.isEmpty();
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
		if (baseClass == WithImage.class) {
			switch (derivedFeatureID) {
				case UiPackage.TABLE_ITEM__IMAGE: return UiPackage.WITH_IMAGE__IMAGE;
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
		if (baseClass == WithImage.class) {
			switch (baseFeatureID) {
				case UiPackage.WITH_IMAGE__IMAGE: return UiPackage.TABLE_ITEM__IMAGE;
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
		result.append(" (selected: ");
		result.append(selected);
		result.append(", checked: ");
		result.append(checked);
		result.append(", columns: ");
		result.append(columns);
		result.append(", styleRanges: ");
		result.append(styleRanges);
		result.append(')');
		return result.toString();
	}

} //TableItemImpl

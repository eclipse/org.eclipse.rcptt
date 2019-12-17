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
package org.eclipse.rcptt.tesla.core.protocol.impl;

import org.eclipse.rcptt.tesla.core.protocol.AssertImageData;
import org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Assert Image Data</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.impl.AssertImageDataImpl#getImage <em>Image</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.impl.AssertImageDataImpl#getX <em>X</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.impl.AssertImageDataImpl#getY <em>Y</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.impl.AssertImageDataImpl#getSx <em>Sx</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.impl.AssertImageDataImpl#getSy <em>Sy</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.impl.AssertImageDataImpl#getWidth <em>Width</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.impl.AssertImageDataImpl#getHeight <em>Height</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AssertImageDataImpl extends EObjectImpl implements AssertImageData {
	/**
	 * The default value of the '{@link #getImage() <em>Image</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImage()
	 * @generated
	 * @ordered
	 */
	protected static final byte[] IMAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getImage() <em>Image</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImage()
	 * @generated
	 * @ordered
	 */
	protected byte[] image = IMAGE_EDEFAULT;

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
	 * The default value of the '{@link #getSx() <em>Sx</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSx()
	 * @generated
	 * @ordered
	 */
	protected static final int SX_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getSx() <em>Sx</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSx()
	 * @generated
	 * @ordered
	 */
	protected int sx = SX_EDEFAULT;

	/**
	 * The default value of the '{@link #getSy() <em>Sy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSy()
	 * @generated
	 * @ordered
	 */
	protected static final int SY_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getSy() <em>Sy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSy()
	 * @generated
	 * @ordered
	 */
	protected int sy = SY_EDEFAULT;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AssertImageDataImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ProtocolPackage.Literals.ASSERT_IMAGE_DATA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public byte[] getImage() {
		return image;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImage(byte[] newImage) {
		byte[] oldImage = image;
		image = newImage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProtocolPackage.ASSERT_IMAGE_DATA__IMAGE, oldImage, image));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ProtocolPackage.ASSERT_IMAGE_DATA__X, oldX, x));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ProtocolPackage.ASSERT_IMAGE_DATA__Y, oldY, y));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getSx() {
		return sx;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSx(int newSx) {
		int oldSx = sx;
		sx = newSx;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProtocolPackage.ASSERT_IMAGE_DATA__SX, oldSx, sx));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getSy() {
		return sy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSy(int newSy) {
		int oldSy = sy;
		sy = newSy;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProtocolPackage.ASSERT_IMAGE_DATA__SY, oldSy, sy));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ProtocolPackage.ASSERT_IMAGE_DATA__WIDTH, oldWidth, width));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ProtocolPackage.ASSERT_IMAGE_DATA__HEIGHT, oldHeight, height));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ProtocolPackage.ASSERT_IMAGE_DATA__IMAGE:
				return getImage();
			case ProtocolPackage.ASSERT_IMAGE_DATA__X:
				return getX();
			case ProtocolPackage.ASSERT_IMAGE_DATA__Y:
				return getY();
			case ProtocolPackage.ASSERT_IMAGE_DATA__SX:
				return getSx();
			case ProtocolPackage.ASSERT_IMAGE_DATA__SY:
				return getSy();
			case ProtocolPackage.ASSERT_IMAGE_DATA__WIDTH:
				return getWidth();
			case ProtocolPackage.ASSERT_IMAGE_DATA__HEIGHT:
				return getHeight();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ProtocolPackage.ASSERT_IMAGE_DATA__IMAGE:
				setImage((byte[])newValue);
				return;
			case ProtocolPackage.ASSERT_IMAGE_DATA__X:
				setX((Integer)newValue);
				return;
			case ProtocolPackage.ASSERT_IMAGE_DATA__Y:
				setY((Integer)newValue);
				return;
			case ProtocolPackage.ASSERT_IMAGE_DATA__SX:
				setSx((Integer)newValue);
				return;
			case ProtocolPackage.ASSERT_IMAGE_DATA__SY:
				setSy((Integer)newValue);
				return;
			case ProtocolPackage.ASSERT_IMAGE_DATA__WIDTH:
				setWidth((Integer)newValue);
				return;
			case ProtocolPackage.ASSERT_IMAGE_DATA__HEIGHT:
				setHeight((Integer)newValue);
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
			case ProtocolPackage.ASSERT_IMAGE_DATA__IMAGE:
				setImage(IMAGE_EDEFAULT);
				return;
			case ProtocolPackage.ASSERT_IMAGE_DATA__X:
				setX(X_EDEFAULT);
				return;
			case ProtocolPackage.ASSERT_IMAGE_DATA__Y:
				setY(Y_EDEFAULT);
				return;
			case ProtocolPackage.ASSERT_IMAGE_DATA__SX:
				setSx(SX_EDEFAULT);
				return;
			case ProtocolPackage.ASSERT_IMAGE_DATA__SY:
				setSy(SY_EDEFAULT);
				return;
			case ProtocolPackage.ASSERT_IMAGE_DATA__WIDTH:
				setWidth(WIDTH_EDEFAULT);
				return;
			case ProtocolPackage.ASSERT_IMAGE_DATA__HEIGHT:
				setHeight(HEIGHT_EDEFAULT);
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
			case ProtocolPackage.ASSERT_IMAGE_DATA__IMAGE:
				return IMAGE_EDEFAULT == null ? image != null : !IMAGE_EDEFAULT.equals(image);
			case ProtocolPackage.ASSERT_IMAGE_DATA__X:
				return x != X_EDEFAULT;
			case ProtocolPackage.ASSERT_IMAGE_DATA__Y:
				return y != Y_EDEFAULT;
			case ProtocolPackage.ASSERT_IMAGE_DATA__SX:
				return sx != SX_EDEFAULT;
			case ProtocolPackage.ASSERT_IMAGE_DATA__SY:
				return sy != SY_EDEFAULT;
			case ProtocolPackage.ASSERT_IMAGE_DATA__WIDTH:
				return width != WIDTH_EDEFAULT;
			case ProtocolPackage.ASSERT_IMAGE_DATA__HEIGHT:
				return height != HEIGHT_EDEFAULT;
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
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (image: ");
		result.append(image);
		result.append(", x: ");
		result.append(x);
		result.append(", y: ");
		result.append(y);
		result.append(", sx: ");
		result.append(sx);
		result.append(", sy: ");
		result.append(sy);
		result.append(", width: ");
		result.append(width);
		result.append(", height: ");
		result.append(height);
		result.append(')');
		return result.toString();
	}

} //AssertImageDataImpl

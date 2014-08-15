/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.rcptt.tesla.core.protocol.diagram.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.rcptt.tesla.core.protocol.diagram.DiagramPackage;
import org.eclipse.rcptt.tesla.core.protocol.diagram.MouseCommand;
import org.eclipse.rcptt.tesla.core.protocol.diagram.MouseCommandKind;

import org.eclipse.rcptt.tesla.core.protocol.raw.Element;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mouse Command</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.diagram.impl.MouseCommandImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.diagram.impl.MouseCommandImpl#getElement <em>Element</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.diagram.impl.MouseCommandImpl#getX <em>X</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.diagram.impl.MouseCommandImpl#getY <em>Y</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.diagram.impl.MouseCommandImpl#getButton <em>Button</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.diagram.impl.MouseCommandImpl#getKind <em>Kind</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.diagram.impl.MouseCommandImpl#getBoundsWidth <em>Bounds Width</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.diagram.impl.MouseCommandImpl#getBoundsHeight <em>Bounds Height</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.diagram.impl.MouseCommandImpl#getStateMask <em>State Mask</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MouseCommandImpl extends EObjectImpl implements MouseCommand {
	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final int ID_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected int id = ID_EDEFAULT;

	/**
	 * The cached value of the '{@link #getElement() <em>Element</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElement()
	 * @generated
	 * @ordered
	 */
	protected Element element;

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
	 * The default value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected static final MouseCommandKind KIND_EDEFAULT = MouseCommandKind.DOWN;

	/**
	 * The cached value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected MouseCommandKind kind = KIND_EDEFAULT;

	/**
	 * The default value of the '{@link #getBoundsWidth() <em>Bounds Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBoundsWidth()
	 * @generated
	 * @ordered
	 */
	protected static final int BOUNDS_WIDTH_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getBoundsWidth() <em>Bounds Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBoundsWidth()
	 * @generated
	 * @ordered
	 */
	protected int boundsWidth = BOUNDS_WIDTH_EDEFAULT;

	/**
	 * The default value of the '{@link #getBoundsHeight() <em>Bounds Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBoundsHeight()
	 * @generated
	 * @ordered
	 */
	protected static final int BOUNDS_HEIGHT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getBoundsHeight() <em>Bounds Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBoundsHeight()
	 * @generated
	 * @ordered
	 */
	protected int boundsHeight = BOUNDS_HEIGHT_EDEFAULT;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MouseCommandImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DiagramPackage.Literals.MOUSE_COMMAND;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(int newId) {
		int oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramPackage.MOUSE_COMMAND__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Element getElement() {
		return element;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetElement(Element newElement, NotificationChain msgs) {
		Element oldElement = element;
		element = newElement;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DiagramPackage.MOUSE_COMMAND__ELEMENT, oldElement, newElement);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setElement(Element newElement) {
		if (newElement != element) {
			NotificationChain msgs = null;
			if (element != null)
				msgs = ((InternalEObject)element).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DiagramPackage.MOUSE_COMMAND__ELEMENT, null, msgs);
			if (newElement != null)
				msgs = ((InternalEObject)newElement).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DiagramPackage.MOUSE_COMMAND__ELEMENT, null, msgs);
			msgs = basicSetElement(newElement, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramPackage.MOUSE_COMMAND__ELEMENT, newElement, newElement));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramPackage.MOUSE_COMMAND__X, oldX, x));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramPackage.MOUSE_COMMAND__Y, oldY, y));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramPackage.MOUSE_COMMAND__BUTTON, oldButton, button));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MouseCommandKind getKind() {
		return kind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKind(MouseCommandKind newKind) {
		MouseCommandKind oldKind = kind;
		kind = newKind == null ? KIND_EDEFAULT : newKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramPackage.MOUSE_COMMAND__KIND, oldKind, kind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getBoundsWidth() {
		return boundsWidth;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBoundsWidth(int newBoundsWidth) {
		int oldBoundsWidth = boundsWidth;
		boundsWidth = newBoundsWidth;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramPackage.MOUSE_COMMAND__BOUNDS_WIDTH, oldBoundsWidth, boundsWidth));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getBoundsHeight() {
		return boundsHeight;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBoundsHeight(int newBoundsHeight) {
		int oldBoundsHeight = boundsHeight;
		boundsHeight = newBoundsHeight;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramPackage.MOUSE_COMMAND__BOUNDS_HEIGHT, oldBoundsHeight, boundsHeight));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramPackage.MOUSE_COMMAND__STATE_MASK, oldStateMask, stateMask));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DiagramPackage.MOUSE_COMMAND__ELEMENT:
				return basicSetElement(null, msgs);
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
			case DiagramPackage.MOUSE_COMMAND__ID:
				return getId();
			case DiagramPackage.MOUSE_COMMAND__ELEMENT:
				return getElement();
			case DiagramPackage.MOUSE_COMMAND__X:
				return getX();
			case DiagramPackage.MOUSE_COMMAND__Y:
				return getY();
			case DiagramPackage.MOUSE_COMMAND__BUTTON:
				return getButton();
			case DiagramPackage.MOUSE_COMMAND__KIND:
				return getKind();
			case DiagramPackage.MOUSE_COMMAND__BOUNDS_WIDTH:
				return getBoundsWidth();
			case DiagramPackage.MOUSE_COMMAND__BOUNDS_HEIGHT:
				return getBoundsHeight();
			case DiagramPackage.MOUSE_COMMAND__STATE_MASK:
				return getStateMask();
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
			case DiagramPackage.MOUSE_COMMAND__ID:
				setId((Integer)newValue);
				return;
			case DiagramPackage.MOUSE_COMMAND__ELEMENT:
				setElement((Element)newValue);
				return;
			case DiagramPackage.MOUSE_COMMAND__X:
				setX((Integer)newValue);
				return;
			case DiagramPackage.MOUSE_COMMAND__Y:
				setY((Integer)newValue);
				return;
			case DiagramPackage.MOUSE_COMMAND__BUTTON:
				setButton((Integer)newValue);
				return;
			case DiagramPackage.MOUSE_COMMAND__KIND:
				setKind((MouseCommandKind)newValue);
				return;
			case DiagramPackage.MOUSE_COMMAND__BOUNDS_WIDTH:
				setBoundsWidth((Integer)newValue);
				return;
			case DiagramPackage.MOUSE_COMMAND__BOUNDS_HEIGHT:
				setBoundsHeight((Integer)newValue);
				return;
			case DiagramPackage.MOUSE_COMMAND__STATE_MASK:
				setStateMask((Integer)newValue);
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
			case DiagramPackage.MOUSE_COMMAND__ID:
				setId(ID_EDEFAULT);
				return;
			case DiagramPackage.MOUSE_COMMAND__ELEMENT:
				setElement((Element)null);
				return;
			case DiagramPackage.MOUSE_COMMAND__X:
				setX(X_EDEFAULT);
				return;
			case DiagramPackage.MOUSE_COMMAND__Y:
				setY(Y_EDEFAULT);
				return;
			case DiagramPackage.MOUSE_COMMAND__BUTTON:
				setButton(BUTTON_EDEFAULT);
				return;
			case DiagramPackage.MOUSE_COMMAND__KIND:
				setKind(KIND_EDEFAULT);
				return;
			case DiagramPackage.MOUSE_COMMAND__BOUNDS_WIDTH:
				setBoundsWidth(BOUNDS_WIDTH_EDEFAULT);
				return;
			case DiagramPackage.MOUSE_COMMAND__BOUNDS_HEIGHT:
				setBoundsHeight(BOUNDS_HEIGHT_EDEFAULT);
				return;
			case DiagramPackage.MOUSE_COMMAND__STATE_MASK:
				setStateMask(STATE_MASK_EDEFAULT);
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
			case DiagramPackage.MOUSE_COMMAND__ID:
				return id != ID_EDEFAULT;
			case DiagramPackage.MOUSE_COMMAND__ELEMENT:
				return element != null;
			case DiagramPackage.MOUSE_COMMAND__X:
				return x != X_EDEFAULT;
			case DiagramPackage.MOUSE_COMMAND__Y:
				return y != Y_EDEFAULT;
			case DiagramPackage.MOUSE_COMMAND__BUTTON:
				return button != BUTTON_EDEFAULT;
			case DiagramPackage.MOUSE_COMMAND__KIND:
				return kind != KIND_EDEFAULT;
			case DiagramPackage.MOUSE_COMMAND__BOUNDS_WIDTH:
				return boundsWidth != BOUNDS_WIDTH_EDEFAULT;
			case DiagramPackage.MOUSE_COMMAND__BOUNDS_HEIGHT:
				return boundsHeight != BOUNDS_HEIGHT_EDEFAULT;
			case DiagramPackage.MOUSE_COMMAND__STATE_MASK:
				return stateMask != STATE_MASK_EDEFAULT;
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

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (id: ");
		result.append(id);
		result.append(", x: ");
		result.append(x);
		result.append(", y: ");
		result.append(y);
		result.append(", button: ");
		result.append(button);
		result.append(", kind: ");
		result.append(kind);
		result.append(", boundsWidth: ");
		result.append(boundsWidth);
		result.append(", boundsHeight: ");
		result.append(boundsHeight);
		result.append(", stateMask: ");
		result.append(stateMask);
		result.append(')');
		return result.toString();
	}

} //MouseCommandImpl

/**
 */
package org.eclipse.rcptt.tesla.ecl.rap.model.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.rcptt.ecl.core.impl.CommandImpl;

import org.eclipse.rcptt.tesla.ecl.rap.model.DownloadFile;
import org.eclipse.rcptt.tesla.ecl.rap.model.RapTeslaPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Download File</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.rap.model.impl.DownloadFileImpl#getHandlerId <em>Handler Id</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.ecl.rap.model.impl.DownloadFileImpl#getUrl <em>Url</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DownloadFileImpl extends CommandImpl implements DownloadFile {
	/**
	 * The default value of the '{@link #getHandlerId() <em>Handler Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHandlerId()
	 * @generated
	 * @ordered
	 */
	protected static final String HANDLER_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getHandlerId() <em>Handler Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHandlerId()
	 * @generated
	 * @ordered
	 */
	protected String handlerId = HANDLER_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getUrl() <em>Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUrl()
	 * @generated
	 * @ordered
	 */
	protected static final String URL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUrl() <em>Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUrl()
	 * @generated
	 * @ordered
	 */
	protected String url = URL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DownloadFileImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RapTeslaPackage.Literals.DOWNLOAD_FILE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getHandlerId() {
		return handlerId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHandlerId(String newHandlerId) {
		String oldHandlerId = handlerId;
		handlerId = newHandlerId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RapTeslaPackage.DOWNLOAD_FILE__HANDLER_ID, oldHandlerId, handlerId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUrl(String newUrl) {
		String oldUrl = url;
		url = newUrl;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RapTeslaPackage.DOWNLOAD_FILE__URL, oldUrl, url));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RapTeslaPackage.DOWNLOAD_FILE__HANDLER_ID:
				return getHandlerId();
			case RapTeslaPackage.DOWNLOAD_FILE__URL:
				return getUrl();
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
			case RapTeslaPackage.DOWNLOAD_FILE__HANDLER_ID:
				setHandlerId((String)newValue);
				return;
			case RapTeslaPackage.DOWNLOAD_FILE__URL:
				setUrl((String)newValue);
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
			case RapTeslaPackage.DOWNLOAD_FILE__HANDLER_ID:
				setHandlerId(HANDLER_ID_EDEFAULT);
				return;
			case RapTeslaPackage.DOWNLOAD_FILE__URL:
				setUrl(URL_EDEFAULT);
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
			case RapTeslaPackage.DOWNLOAD_FILE__HANDLER_ID:
				return HANDLER_ID_EDEFAULT == null ? handlerId != null : !HANDLER_ID_EDEFAULT.equals(handlerId);
			case RapTeslaPackage.DOWNLOAD_FILE__URL:
				return URL_EDEFAULT == null ? url != null : !URL_EDEFAULT.equals(url);
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
		result.append(" (handlerId: ");
		result.append(handlerId);
		result.append(", url: ");
		result.append(url);
		result.append(')');
		return result.toString();
	}

} //DownloadFileImpl

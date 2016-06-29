/**
 */
package org.eclipse.rcptt.tesla.core.protocol.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage;
import org.eclipse.rcptt.tesla.core.protocol.RapUploadFile;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rap Upload File</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.impl.RapUploadFileImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.impl.RapUploadFileImpl#getBase64file <em>Base64file</em>}</li>
 *   <li>{@link org.eclipse.rcptt.tesla.core.protocol.impl.RapUploadFileImpl#getPath <em>Path</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RapUploadFileImpl extends EObjectImpl implements RapUploadFile {
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
	 * The default value of the '{@link #getBase64file() <em>Base64file</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase64file()
	 * @generated
	 * @ordered
	 */
	protected static final String BASE64FILE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBase64file() <em>Base64file</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase64file()
	 * @generated
	 * @ordered
	 */
	protected String base64file = BASE64FILE_EDEFAULT;

	/**
	 * The default value of the '{@link #getPath() <em>Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPath()
	 * @generated
	 * @ordered
	 */
	protected static final String PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPath() <em>Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPath()
	 * @generated
	 * @ordered
	 */
	protected String path = PATH_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RapUploadFileImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ProtocolPackage.Literals.RAP_UPLOAD_FILE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ProtocolPackage.RAP_UPLOAD_FILE__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBase64file() {
		return base64file;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase64file(String newBase64file) {
		String oldBase64file = base64file;
		base64file = newBase64file;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProtocolPackage.RAP_UPLOAD_FILE__BASE64FILE, oldBase64file, base64file));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPath() {
		return path;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPath(String newPath) {
		String oldPath = path;
		path = newPath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProtocolPackage.RAP_UPLOAD_FILE__PATH, oldPath, path));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ProtocolPackage.RAP_UPLOAD_FILE__ID:
				return getId();
			case ProtocolPackage.RAP_UPLOAD_FILE__BASE64FILE:
				return getBase64file();
			case ProtocolPackage.RAP_UPLOAD_FILE__PATH:
				return getPath();
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
			case ProtocolPackage.RAP_UPLOAD_FILE__ID:
				setId((Integer)newValue);
				return;
			case ProtocolPackage.RAP_UPLOAD_FILE__BASE64FILE:
				setBase64file((String)newValue);
				return;
			case ProtocolPackage.RAP_UPLOAD_FILE__PATH:
				setPath((String)newValue);
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
			case ProtocolPackage.RAP_UPLOAD_FILE__ID:
				setId(ID_EDEFAULT);
				return;
			case ProtocolPackage.RAP_UPLOAD_FILE__BASE64FILE:
				setBase64file(BASE64FILE_EDEFAULT);
				return;
			case ProtocolPackage.RAP_UPLOAD_FILE__PATH:
				setPath(PATH_EDEFAULT);
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
			case ProtocolPackage.RAP_UPLOAD_FILE__ID:
				return id != ID_EDEFAULT;
			case ProtocolPackage.RAP_UPLOAD_FILE__BASE64FILE:
				return BASE64FILE_EDEFAULT == null ? base64file != null : !BASE64FILE_EDEFAULT.equals(base64file);
			case ProtocolPackage.RAP_UPLOAD_FILE__PATH:
				return PATH_EDEFAULT == null ? path != null : !PATH_EDEFAULT.equals(path);
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
		result.append(", base64file: ");
		result.append(base64file);
		result.append(", path: ");
		result.append(path);
		result.append(')');
		return result.toString();
	}

} //RapUploadFileImpl

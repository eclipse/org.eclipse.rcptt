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

package org.eclipse.rcptt.ecl.internal.core;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.rcptt.ecl.core.CoreFactory;
import org.eclipse.rcptt.ecl.core.Serialized;
import org.eclipse.rcptt.ecl.runtime.IEMFConverter;

@SuppressWarnings("unchecked")
public enum EMFConverterManager implements IEMFConverter<Object, EObject> {
	INSTANCE;

	private final static String EXTPT = "org.eclipse.rcptt.ecl.core.emfConverters";
	private final static String CLASS_ATTR = "class";

	private Map<Class<?>, IEMFConverter<?, ?>> byJavaClass;
	private Map<EClass, IEMFConverter<?, ?>> byEClass;

	private EMFConverterManager() {
		byJavaClass = new HashMap<Class<?>, IEMFConverter<?, ?>>();
		byEClass = new HashMap<EClass, IEMFConverter<?, ?>>();
		IConfigurationElement[] configs = Platform.getExtensionRegistry()
				.getConfigurationElementsFor(EXTPT);
		for (IConfigurationElement config : configs) {
			try {
				Object object = config.createExecutableExtension(CLASS_ATTR);
				if (object instanceof IEMFConverter) {
					IEMFConverter<?, ?> converter = (IEMFConverter<?, ?>) object;

					Class<?> javaClass = converter.getJavaClass();
					byJavaClass.put(javaClass, converter);
					EClass eClass = converter.getEClass();
					byEClass.put(eClass, converter);
				}
			} catch (CoreException e) {
				CorePlugin.getDefault().getLog().log(e.getStatus());
			}
		}
	}

	public EObject toEObject(Object object) throws CoreException {
		@SuppressWarnings("rawtypes")
		IEMFConverter serializer = byJavaClass.get(object.getClass());
		if (serializer == null) {
			serializer = guessConverter(object.getClass());
		}
		if (serializer == null) {
			if (object instanceof Serializable) {
				return serializeObject(object);
			}
			throw new CoreException(new Status(IStatus.ERROR,
					CorePlugin.PLUGIN_ID,
					"Serialization is not supported for instances of: "
							+ object.getClass().getName()));
		}
		return serializer.toEObject(object);
	}
	
	private IEMFConverter<?, ?> guessConverter(Class<?> clazz) {
		IEMFConverter<?, ?> result = null;
		int score = Integer.MAX_VALUE;
		for(Entry<Class<?>, IEMFConverter<?, ?>> entry : byJavaClass.entrySet()) {
			int tmp = getDistance(clazz, entry.getKey());
			if(tmp < score) {
				score = tmp;
				result = entry.getValue();
			}
		}
		return result;
	}
	
	public static int getDistance(Class<?> from, Class<?> to) {
		return getDistance(from, to, 0);
	}

	private static int getDistance(Class<?> from, Class<?> to, int level) {
		if (from.equals(to)) {
			return level;
		}
		if (!to.isAssignableFrom(from)) {
			return Integer.MAX_VALUE;
		}

		int result = from.getSuperclass() == null ? Integer.MAX_VALUE
				: getDistance(from.getSuperclass(), to, level + 1);

		for (Class<?> iface : from.getInterfaces()) {
			int tmp = getDistance(iface, to, level + 1);
			if (tmp < result) {
				result = tmp;
			}
		}

		return result;
	}

	private EObject serializeObject(Object object) throws CoreException {
		try {
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			new ObjectOutputStream(out).writeObject(object);
			out.flush();
			out.close();
			Serialized serialized = CoreFactory.eINSTANCE.createSerialized();
			serialized.setBytes(out.toByteArray());
			return serialized;
		} catch (Exception e) {
			throw new CoreException(new Status(IStatus.ERROR,
					CorePlugin.PLUGIN_ID, "Failed to serialize object"));
		}
	}

	public Object fromEObject(EObject eObject) throws CoreException {
		@SuppressWarnings("rawtypes")
		IEMFConverter deserializer = byEClass.get(eObject.eClass());
		if (deserializer == null) {
			if (eObject instanceof Serialized) {
				return deserializeObject((Serialized) eObject);
			}
			throw new CoreException(new Status(IStatus.ERROR,
					CorePlugin.PLUGIN_ID,
					"Deserialization is not supported for instances of: "
							+ eObject.eClass().getName()));
		}
		return deserializer.fromEObject(eObject);
	}

	private Object deserializeObject(Serialized serialized)
			throws CoreException {
		try {
			ByteArrayInputStream in = new ByteArrayInputStream(
					serialized.getBytes());
			return new ObjectInputStream(in).readObject();
		} catch (Exception e) {
			throw new CoreException(new Status(IStatus.ERROR,
					CorePlugin.PLUGIN_ID, "Failed to deserialize object"));
		}
	}

	public Class<Object> getJavaClass() {
		return Object.class;
	}

	public EClass getEClass() {
		return EcorePackage.Literals.EOBJECT;
	}
}

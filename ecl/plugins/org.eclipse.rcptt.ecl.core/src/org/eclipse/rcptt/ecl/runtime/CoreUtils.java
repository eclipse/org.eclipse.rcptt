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
package org.eclipse.rcptt.ecl.runtime;

import java.io.InputStream;
import java.io.OutputStream;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.core.EclList;
import org.eclipse.rcptt.ecl.core.EclMap;
import org.eclipse.rcptt.ecl.core.EclMapEntry;
import org.eclipse.rcptt.ecl.internal.core.CorePlugin;
import org.eclipse.rcptt.ecl.internal.core.EMFStreamPipe;
import org.eclipse.rcptt.ecl.internal.core.IMarkeredPipe;

public class CoreUtils {

	public static final String INPUT_ANN = "http://www.eclipse.org/ecl/input";
	public static final String INTERNAL_ANN = "http://www.eclipse.org/ecl/internal";
	public static final String META_ANN = "http://www.eclipse.org/ecl/meta";

	public static final String TYPE_DET = "type";

	public static List<String> getMetaTypeList(EStructuralFeature feature) {
		EAnnotation annotation = feature.getEAnnotation(CoreUtils.META_ANN);
		if (annotation == null)
			return null;

		EMap<String, String> details = annotation.getDetails();
		if (details == null || !details.containsKey(CoreUtils.TYPE_DET))
			return null;

		String type = details.get(CoreUtils.TYPE_DET);
		if (type == null || type.length() == 0)
			return null;

		String[] types = type.split("\\s*\\|\\s*");
		List<String> result = new ArrayList<String>(types.length);
		for (String t : types) {
			if (t.length() == 0)
				continue;
			String trimmed = t.trim();
			if (trimmed.length() == 0)
				continue;
			result.add(trimmed);
		}

		return result;
	}

	/**
	 * Creates command parameters class using namespace and name specified
	 * 
	 * @param namespace
	 *            EMF package namespace
	 * @param name
	 *            class name from EMF package
	 * @return
	 * @throws CoreException
	 */
	public static Command createCommand(String namespace, String name)
			throws CoreException {
		return CorePlugin.getScriptletManager().createCommand(namespace, name);
	}

	public static Set<String> getFriendlyNames(String ns, String name)
			throws CoreException {
		return CorePlugin.getScriptletManager().getFriendlyNames(ns, name);
	}

	public static IMarkeredPipe createEMFPipe(InputStream in, OutputStream out) {
		return new EMFStreamPipe(in, out);
	}

	/**
	 * It tries to cast <code>value</code> into {@link Integer}, then into
	 * {@link Double} and finally into {@link Boolean}. If it is failed, return
	 * <code>value</code> itself as {@link String}
	 * 
	 * @param value
	 * @return casted object
	 */
	public static Object createPrimitiveFromString(String value) {
		try {
			return Integer.decode(value);
		} catch (NumberFormatException e0) {
			try {
				return Double.valueOf(value);
			} catch (NumberFormatException e1) {
				if (value.equalsIgnoreCase("true")
						|| value.equalsIgnoreCase("false")) {
					return Boolean.valueOf(value);
				}
				return value;
			}
		}
	}

	/**
	 * It returns suitable primitive type if possible or throw
	 * {@link ClassNotFoundException} otherwise
	 * 
	 * @param o
	 * @return suitable primitive type for <code>o</code>
	 * @throws ClassNotFoundException
	 */
	public static Class<?> getPrimitiveType(Object o)
			throws ClassNotFoundException {
		if (o instanceof Integer) {
			return int.class;
		} else if (o instanceof Double) {
			return double.class;
		} else if (o instanceof Boolean) {
			return boolean.class;
		}
		throw new ClassNotFoundException();
	}

	public static List<EStructuralFeature> getFeatures(EClass targetClass) {
		List<EStructuralFeature> features = new ArrayList<EStructuralFeature>();
		final List<EClass> classes = new ArrayList<EClass>(
				targetClass.getEAllSuperTypes());
		classes.add(targetClass);
		features.addAll(targetClass.getEAllStructuralFeatures());
		Collections.sort(features, new Comparator<EStructuralFeature>() {
			public int compare(EStructuralFeature o1, EStructuralFeature o2) {
				try {
					EClass eClass1 = o1.getEContainingClass();
					EClass eClass2 = o2.getEContainingClass();
					int i1 = classes.indexOf(eClass1);
					int i2 = classes.indexOf(eClass2);
					return i2 - i1;
				} catch (Exception e) {
					CorePlugin.err(e.getMessage(), e);
				}
				return 0;
			}
		});
		return features;
	}

	public static String getScriptletNameByClass(EClass eClass) {

		String className = eClass.getName();

		int startPos = className.lastIndexOf('.');
		if (startPos != -1) {
			className = className.substring(startPos);
		}
		if (className.endsWith("Impl")) {
			className = className.substring(0, className.length() - 4);
		}

		if (className.endsWith("Command")) {
			className = className.substring(0, className.length() - 7);
		}
		StringBuffer result = new StringBuffer();
		for (int index = 0; index < className.length(); index++) {
			char symbol = className.charAt(index);
			if (Character.isUpperCase(symbol)) {
				if (index != 0)
					result.append('-');
				symbol = Character.toLowerCase(symbol);
			}
			result.append(symbol);
		}

		return result.toString();

	}

	public static List<Object> readPipeContent(IPipe pipe) throws CoreException {
		List<Object> pipeContent = new ArrayList<Object>();
		Object o = null;
		while (true) {
			o = pipe.take(Long.MAX_VALUE); // wait forever to take
											// content
			if (o instanceof IStatus)
				break;
			pipeContent.add(o);
		}
		// Now pipe is empty for sure
		IStatus status = (IStatus) o;
		if (status.getSeverity() != IStatus.OK) {
			throw new CoreException(status);
		}
		return pipeContent;
	}

	@SuppressWarnings("unchecked")
	public static void featureSafeSet(EObject object,
			EStructuralFeature feature, List<?> value) throws CoreException {
		checkBounds(feature, value);
		if (value.size() > 0) {
			value = convert((List<Object>) value, feature);
			if (feature.getUpperBound() == 1)
				object.eSet(feature, value.get(0));
			else
				object.eSet(feature, value);
		}
	}

	/**
	 * Performs {@link #box(Object)} or {@link #unbox(Object)} operations on
	 * every object in given list of values based on feature type. Thus, if
	 * feature is {@link EReference}, values are boxed, if feature is
	 * {@link EAttribute}, values are unboxed.
	 * 
	 * @param values
	 * @param feature
	 * @return
	 */
	public static List<Object> convert(List<Object> values,
			EStructuralFeature feature) {
		boolean box = feature instanceof EReference;
		List<Object> result = new ArrayList<Object>();
		Class<?> clazz = feature.getEType().getInstanceClass();
		for (Object value : values) {
			result.add(adaptSingleObject(clazz, value, box));
		}
		return result;
	}

	private static Object adaptSingleObject(Class<?> instanceClass,
			final Object item, boolean box) {
		Object rv = Platform.getAdapterManager()
				.getAdapter(item, instanceClass);
		if (rv == null && item != null) {
			if (instanceClass.isAssignableFrom(String.class)) {
				
				rv = BoxedValues.unbox(item);
				if( rv instanceof EclList ) {
					StringBuilder sb = new StringBuilder();
					for( Object o: ((EclList) rv).getElements()) {
						if( sb.length() > 0) {
							sb.append(", ");
						}
						sb.append( adaptSingleObject(instanceClass, o, false));
					}
					rv = sb.toString();
				}
				else if( rv instanceof EclMap ) {
					StringBuilder sb = new StringBuilder();
					for( EclMapEntry o: ((EclMap) rv).getEntries()) {
						if( sb.length() > 0) {
							sb.append(", ");
						}
						sb.append( adaptSingleObject(instanceClass, o.getKey(), false));
						sb.append("=");
						sb.append(adaptSingleObject(instanceClass, o.getValue(), false));
					}
					rv = sb.toString();
				}
				else {
					rv = rv.toString();
				}
			}
		}
		if (rv == null)
			rv = item;
		return box ? BoxedValues.box(rv) : BoxedValues.unbox(rv);
	}

	public static void checkBounds(EStructuralFeature feature, Object value)
			throws CoreException {
		int actual = 0;
		if (value instanceof List<?>) {
			actual = ((List<?>) value).size();
		} else if (value != null) {
			actual = 1;
		}
		int lower = feature.getLowerBound();
		int upper = feature.getUpperBound();
		if (upper != -1 && actual > upper && upper != 1) {
			throw new CoreException(CorePlugin.err(MessageFormat.format(
					"Parameter {2} is already assigned", actual, upper,
					feature.getName())));
		}
		if (actual < lower) {
			throw new CoreException(CorePlugin.err(MessageFormat.format(
					"Parameter {2} is not assigned", actual, lower,
					feature.getName())));
		}
	}

	private CoreUtils() {
		throw new AssertionError();
	}

	public static boolean isBlank(String string) {
		// TODO: there is no reason to create new string on trimming just to
		// check it is empty, but who cares
		return string == null || string.length() == 0
				|| string.trim().length() == 0;
	}

}

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

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.rcptt.ecl.core.BoxedValue;
import org.eclipse.rcptt.ecl.core.CoreFactory;
import org.eclipse.rcptt.ecl.core.CorePackage;
import org.eclipse.rcptt.ecl.core.EclBoolean;
import org.eclipse.rcptt.ecl.core.EclByte;
import org.eclipse.rcptt.ecl.core.EclChar;
import org.eclipse.rcptt.ecl.core.EclDouble;
import org.eclipse.rcptt.ecl.core.EclFloat;
import org.eclipse.rcptt.ecl.core.EclInteger;
import org.eclipse.rcptt.ecl.core.EclLong;
import org.eclipse.rcptt.ecl.core.EclShort;
import org.eclipse.rcptt.ecl.core.EclString;
import org.eclipse.rcptt.ecl.internal.core.CorePlugin;

public class BoxedValues {
	private BoxedValues() {
	}

	private static final String VALUE_FEATURE = "value";
	private static final Map<String, String> TO_BOXED_TYPE = new HashMap<String, String>();
	private static final Map<String, String> FROM_BOXED_TYPE = new HashMap<String, String>();
	static {
		TO_BOXED_TYPE.put(Byte.class.getName(), CorePackage.eINSTANCE
				.getEclByte().getName());
		TO_BOXED_TYPE.put(Short.class.getName(), CorePackage.eINSTANCE
				.getEclShort().getName());
		TO_BOXED_TYPE.put(Integer.class.getName(), CorePackage.eINSTANCE
				.getEclInteger().getName());
		TO_BOXED_TYPE.put(Long.class.getName(), CorePackage.eINSTANCE
				.getEclLong().getName());

		TO_BOXED_TYPE.put(Float.class.getName(), CorePackage.eINSTANCE
				.getEclFloat().getName());
		TO_BOXED_TYPE.put(Double.class.getName(), CorePackage.eINSTANCE
				.getEclDouble().getName());

		TO_BOXED_TYPE.put(Boolean.class.getName(), CorePackage.eINSTANCE
				.getEclBoolean().getName());

		TO_BOXED_TYPE.put(Character.class.getName(), CorePackage.eINSTANCE
				.getEclChar().getName());
		TO_BOXED_TYPE.put(String.class.getName(), CorePackage.eINSTANCE
				.getEclString().getName());

		for (Entry<String, String> entry : TO_BOXED_TYPE.entrySet()) {
			FROM_BOXED_TYPE.put(entry.getValue(), entry.getKey());
		}
	}

	public static class BoxedSwitch<T> {
		public T doSwitch(BoxedValue value) throws CoreException {
			switch (value.eClass().getClassifierID()) {
			case CorePackage.ECL_BOOLEAN:
				return caseBoolean((EclBoolean) value);
			case CorePackage.ECL_BYTE:
				return caseByte((EclByte) value);
			case CorePackage.ECL_CHAR:
				return caseChar((EclChar) value);
			case CorePackage.ECL_DOUBLE:
				return caseDouble((EclDouble) value);
			case CorePackage.ECL_FLOAT:
				return caseFloat((EclFloat) value);
			case CorePackage.ECL_INTEGER:
				return caseInteger((EclInteger) value);
			case CorePackage.ECL_LONG:
				return caseLong((EclLong) value);
			case CorePackage.ECL_SHORT:
				return caseShort((EclShort) value);
			case CorePackage.ECL_STRING:
				return caseString((EclString) value);
			default:
				return caseDefault(value, value.eClass().getName());
			}

		}

		protected T caseBoolean(EclBoolean value) throws CoreException {
			return caseDefault(value, "Boolean");
		}

		protected T caseByte(EclByte value) throws CoreException {
			return caseDefault(value, "Byte");
		}

		protected T caseChar(EclChar value) throws CoreException {
			return caseDefault(value, "Char");
		}

		protected T caseDouble(EclDouble value) throws CoreException {
			return caseDefault(value, "Double");
		}

		protected T caseFloat(EclFloat value) throws CoreException {
			return caseDefault(value, "Float");
		}

		protected T caseInteger(EclInteger value) throws CoreException {
			return caseDefault(value, "Integer");
		}

		protected T caseLong(EclLong value) throws CoreException {
			return caseDefault(value, "Long");
		}

		protected T caseShort(EclShort value) throws CoreException {
			return caseDefault(value, "Short");
		}

		protected T caseString(EclString value) throws CoreException {
			return caseDefault(value, "String");
		}

		protected T caseDefault(BoxedValue value, String friendlyName) throws CoreException {
			return null;
		}
	}

	/**
	 * Wraps any object into {@link EObject}. If object is already EObject, no
	 * conversions performed, therefore this method is idempotent, i.e.
	 * <code>box(box(box(box(foo))))</code> equals to <code>box(foo)</code>.
	 * 
	 * If object is not null and not EObject, performs conversion according to
	 * object type so that {@link String} is converted to {@link EclString},
	 * {@link Integer} to {@link EclInteger} and so on
	 * 
	 * @param object
	 * @return {@link EObject} or <code>null</code>, if input is null.
	 * @throws IllegalArgumentException
	 *             when appropriate boxing type could not be found
	 */
	public static EObject box(Object object) {
		if (object == null) {
			return null;
		}
		if (object instanceof EObject) {
			return (EObject) object;
		}

		String className = object.getClass().getName();
		if (!TO_BOXED_TYPE.containsKey(className)) {
			throw new IllegalArgumentException(String.format(
					"Do not know how to box value of type '%s'", object
							.getClass().getName()));
		}
		EClass boxedType = (EClass) CorePackage.eINSTANCE
				.getEClassifier(TO_BOXED_TYPE.get(object.getClass().getName()));
		EObject result = CoreFactory.eINSTANCE.create(boxedType);
		result.eSet(boxedType.getEStructuralFeature(VALUE_FEATURE), object);
		return result;
	}

	public static EclBoolean box(boolean b) {
		EclBoolean result = CoreFactory.eINSTANCE.createEclBoolean();
		result.setValue(b);
		return result;
	}

	public static EclByte box(byte b) {
		EclByte result = CoreFactory.eINSTANCE.createEclByte();
		result.setValue(b);
		return result;
	}

	public static EclChar box(char c) {
		EclChar result = CoreFactory.eINSTANCE.createEclChar();
		result.setValue(c);
		return result;
	}

	public static EclDouble box(double d) {
		EclDouble result = CoreFactory.eINSTANCE.createEclDouble();
		result.setValue(d);
		return result;
	}

	public static EclFloat box(float f) {
		EclFloat result = CoreFactory.eINSTANCE.createEclFloat();
		result.setValue(f);
		return result;
	}

	public static EclInteger box(int i) {
		EclInteger result = CoreFactory.eINSTANCE.createEclInteger();
		result.setValue(i);
		return result;
	}

	public static EclLong box(long l) {
		EclLong result = CoreFactory.eINSTANCE.createEclLong();
		result.setValue(l);
		return result;
	}

	public static EclShort box(short s) {
		EclShort result = CoreFactory.eINSTANCE.createEclShort();
		result.setValue(s);
		return result;
	}

	public static EclString box(String s) {
		EclString result = CoreFactory.eINSTANCE.createEclString();
		result.setValue(s);
		return result;
	}

	/**
	 * Unwraps an object if it has been boxed to {@link EObject}. This method is
	 * idempotent, i.e. <code>unbox(unbox(unbox(unbox(foo))))</code> equals to
	 * <code>unbox(foo)</code>.
	 * 
	 * @param object
	 * @return
	 */
	public static Object unbox(Object object) {
		if (object == null) {
			return null;
		}
		if (!(object instanceof EObject)) {
			return object;
		}

		EClass eClass = ((EObject) object).eClass();
		if (FROM_BOXED_TYPE.containsKey(eClass.getName())) {
			return ((EObject) object).eGet(eClass
					.getEStructuralFeature(VALUE_FEATURE));
		}
		return object;
	}

	private static BoxedSwitch<Boolean> toBoolean = new BoxedSwitch<Boolean>() {
		@Override
		protected Boolean caseBoolean(EclBoolean value) throws CoreException {
			return value.isValue();
		}

		protected Boolean caseByte(EclByte value) throws CoreException {
			return value.getValue() != 0;
		};

		protected Boolean caseChar(EclChar value) throws CoreException {
			return value.getValue() != 0;
		};

		protected Boolean caseDouble(EclDouble value) throws CoreException {
			return value.getValue() != 0;
		};

		protected Boolean caseFloat(EclFloat value) throws CoreException {
			return value.getValue() != 0;
		};

		protected Boolean caseInteger(EclInteger value) throws CoreException {
			return value.getValue() != 0;
		};

		protected Boolean caseLong(EclLong value) throws CoreException {
			return value.getValue() != 0;
		};

		protected Boolean caseShort(EclShort value) throws CoreException {
			return value.getValue() != 0;
		};

		protected Boolean caseString(EclString value) throws CoreException {
			return Boolean.parseBoolean(value.getValue());
		};

		protected Boolean caseDefault(BoxedValue value, String friendlyName) throws CoreException {
			throw new CoreException(createConversionError(BoxedValues.toString(value), friendlyName, "Boolean"));
		};
	};

	private static BoxedSwitch<Byte> toByte = new BoxedSwitch<Byte>() {
		protected Byte caseDefault(BoxedValue value, String friendlyName) throws CoreException {
			throw new CoreException(createConversionError(BoxedValues.toString(value), friendlyName, "Byte"));
		}

		protected Byte caseBoolean(EclBoolean value) throws CoreException {
			return (byte) (value.isValue() ? 1 : 0);
		}

		protected Byte caseByte(EclByte value) throws CoreException {
			return value.getValue();
		}

		protected Byte caseChar(EclChar value) throws CoreException {
			char val = value.getValue();
			return (val < MIN || val > MAX) ? super.caseChar(value) : (byte) val;
		}

		protected Byte caseDouble(EclDouble value) throws CoreException {
			double val = value.getValue();
			return (val < MIN || val > MAX) ? super.caseDouble(value) : (byte) val;
		}

		protected Byte caseFloat(EclFloat value) throws CoreException {
			float val = value.getValue();
			return (val < MIN || val > MAX) ? super.caseFloat(value) : (byte) val;
		}

		protected Byte caseInteger(EclInteger value) throws CoreException {
			int val = value.getValue();
			return (val < MIN || val > MAX) ? super.caseInteger(value) : (byte) val;
		}

		protected Byte caseLong(EclLong value) throws CoreException {
			float val = value.getValue();
			return (val < MIN || val > MAX) ? super.caseLong(value) : (byte) val;
		}

		protected Byte caseShort(EclShort value) throws CoreException {
			short val = value.getValue();
			return (val < MIN || val > MAX) ? super.caseShort(value) : (byte) val;
		}

		protected Byte caseString(EclString value) throws CoreException {
			String val = value.getValue();
			try {
				return Byte.parseByte(val);
			} catch (NumberFormatException e) {
				return super.caseString(value);
			}
		}

		private static final byte MIN = Byte.MIN_VALUE;
		private static final byte MAX = Byte.MAX_VALUE;
	};

	protected static BoxedSwitch<Character> toChar = new BoxedSwitch<Character>() {
		protected Character caseDefault(BoxedValue value, String friendlyName) throws CoreException {
			throw new CoreException(createConversionError(BoxedValues.toString(value), friendlyName, "Char"));
		}

		protected Character caseBoolean(EclBoolean value) throws CoreException {
			return (char) (value.isValue() ? 1 : 0);
		}

		protected Character caseByte(EclByte value) throws CoreException {
			return (char) value.getValue();
		}

		protected Character caseChar(EclChar value) throws CoreException {
			return value.getValue();
		}

		protected Character caseDouble(EclDouble value) throws CoreException {
			double val = value.getValue();
			return val < MIN || val > MAX ? super.caseDouble(value) : (char) val;
		}

		protected Character caseFloat(EclFloat value) throws CoreException {
			float val = value.getValue();
			return val < MIN || val > MAX ? super.caseFloat(value) : (char) val;
		}

		protected Character caseInteger(EclInteger value) throws CoreException {
			int val = value.getValue();
			return val < MIN || val > MAX ? super.caseInteger(value) : (char) val;
		}

		protected Character caseLong(EclLong value) throws CoreException {
			long val = value.getValue();
			return val < MIN || val > MAX ? super.caseLong(value) : (char) val;
		}

		protected Character caseShort(EclShort value) throws CoreException {
			short val = value.getValue();
			return val < MIN || val > MAX ? super.caseShort(value) : (char) val;
		}

		protected Character caseString(EclString value) throws CoreException {
			String val = value.getValue();
			return val.length() == 1 ? val.charAt(0) : super.caseString(value);
		}

		private static final char MIN = Character.MIN_VALUE;
		private static final char MAX = Character.MAX_VALUE;
	};

	protected static BoxedSwitch<Double> toDouble = new BoxedSwitch<Double>() {
		protected Double caseDefault(BoxedValue value, String friendlyName) throws CoreException {
			throw new CoreException(createConversionError(BoxedValues.toString(value), friendlyName, "Double"));
		}

		protected Double caseBoolean(EclBoolean value) throws CoreException {
			return value.isValue() ? 1.0 : 0.0;
		}

		protected Double caseByte(EclByte value) throws CoreException {
			return (double) value.getValue();
		}

		protected Double caseChar(EclChar value) throws CoreException {
			return (double) value.getValue();
		}

		protected Double caseDouble(EclDouble value) throws CoreException {
			return value.getValue();
		}

		protected Double caseFloat(EclFloat value) throws CoreException {
			return (double) value.getValue();
		}

		protected Double caseInteger(EclInteger value) throws CoreException {
			return (double) value.getValue();
		}

		protected Double caseLong(EclLong value) throws CoreException {
			return (double) value.getValue();
		}

		protected Double caseShort(EclShort value) throws CoreException {
			return (double) value.getValue();
		}

		protected Double caseString(EclString value) throws CoreException {
			try {
				return Double.parseDouble(value.getValue());
			} catch (NumberFormatException e) {
				return super.caseString(value);
			}
		};
	};

	protected static BoxedSwitch<Float> toFloat = new BoxedSwitch<Float>() {
		protected Float caseDefault(BoxedValue value, String friendlyName) throws CoreException {
			throw new CoreException(createConversionError(BoxedValues.toString(value), friendlyName, "Float"));
		}

		protected Float caseBoolean(EclBoolean value) throws CoreException {
			return value.isValue() ? 1.0f : 0.0f;
		}

		protected Float caseByte(EclByte value) throws CoreException {
			return (float) value.getValue();
		}

		protected Float caseChar(EclChar value) throws CoreException {
			return (float) value.getValue();
		}

		protected Float caseDouble(EclDouble value) throws CoreException {
			double val = value.getValue();
			return (val < MIN || val > MAX) ? super.caseDouble(value) : (float) val;
		}

		protected Float caseFloat(EclFloat value) throws CoreException {
			return value.getValue();
		}

		protected Float caseInteger(EclInteger value) throws CoreException {
			return (float) value.getValue();
		}

		protected Float caseLong(EclLong value) throws CoreException {
			return (float) value.getValue();
		}

		protected Float caseShort(EclShort value) throws CoreException {
			return (float) value.getValue();
		}

		protected Float caseString(EclString value) throws CoreException {
			try {
				return Float.parseFloat(value.getValue());
			} catch (NumberFormatException e) {
				return super.caseString(value);
			}
		};

		private static final float MIN = -Float.MAX_VALUE;
		private static final float MAX = Float.MAX_VALUE;
	};

	protected static BoxedSwitch<Integer> toInteger = new BoxedSwitch<Integer>() {
		protected Integer caseDefault(BoxedValue value, String friendlyName) throws CoreException {
			throw new CoreException(createConversionError(BoxedValues.toString(value), friendlyName, "Integer"));
		}

		protected Integer caseBoolean(EclBoolean value) throws CoreException {
			return value.isValue() ? 1 : 0;
		}

		protected Integer caseByte(EclByte value) throws CoreException {
			return (int) value.getValue();
		}

		protected Integer caseChar(EclChar value) throws CoreException {
			return (int) value.getValue();
		}

		protected Integer caseDouble(EclDouble value) throws CoreException {
			double val = value.getValue();
			return val < MIN || val > MAX ? super.caseDouble(value) : (int) val;
		}

		protected Integer caseFloat(EclFloat value) throws CoreException {
			float val = value.getValue();
			return val < MIN || val > MAX ? super.caseFloat(value) : (int) val;
		}

		protected Integer caseInteger(EclInteger value) throws CoreException {
			return value.getValue();
		}

		protected Integer caseLong(EclLong value) throws CoreException {
			long val = value.getValue();
			return val < MIN || val > MAX ? super.caseLong(value) : (int) val;
		}

		protected Integer caseShort(EclShort value) throws CoreException {
			return (int) value.getValue();
		}

		protected Integer caseString(EclString value) throws CoreException {
			try {
				return Integer.parseInt(value.getValue());
			} catch (NumberFormatException e) {
				return super.caseString(value);
			}
		};

		private static final int MIN = Integer.MIN_VALUE;
		private static final int MAX = Integer.MAX_VALUE;
	};

	protected static BoxedSwitch<Long> toLong = new BoxedSwitch<Long>() {
		protected Long caseDefault(BoxedValue value, String friendlyName) throws CoreException {
			throw new CoreException(createConversionError(BoxedValues.toString(value), friendlyName, "Long"));
		}

		protected Long caseBoolean(EclBoolean value) throws CoreException {
			return value.isValue() ? 1L : 0L;
		}

		protected Long caseByte(EclByte value) throws CoreException {
			return (long) value.getValue();
		}

		protected Long caseChar(EclChar value) throws CoreException {
			return (long) value.getValue();
		}

		protected Long caseDouble(EclDouble value) throws CoreException {
			double val = value.getValue();
			return val < MIN || val > MAX ? super.caseDouble(value) : (long) val;
		}

		protected Long caseFloat(EclFloat value) throws CoreException {
			float val = value.getValue();
			return val < MIN || val > MAX ? super.caseFloat(value) : (long) val;
		}

		protected Long caseInteger(EclInteger value) throws CoreException {
			return (long) value.getValue();
		}

		protected Long caseLong(EclLong value) throws CoreException {
			return value.getValue();
		}

		protected Long caseShort(EclShort value) throws CoreException {
			return (long) value.getValue();
		}

		protected Long caseString(EclString value) throws CoreException {
			try {
				return Long.parseLong(value.getValue());
			} catch (NumberFormatException e) {
				return super.caseString(value);
			}
		};

		private static final long MIN = Long.MIN_VALUE;
		private static final long MAX = Long.MAX_VALUE;
	};

	protected static BoxedSwitch<Short> toShort = new BoxedSwitch<Short>() {
		protected Short caseDefault(BoxedValue value, String friendlyName) throws CoreException {
			throw new CoreException(createConversionError(BoxedValues.toString(value), friendlyName, "Short"));
		}

		protected Short caseBoolean(EclBoolean value) throws CoreException {
			return (short) (value.isValue() ? 1 : 0);
		}

		protected Short caseByte(EclByte value) throws CoreException {
			return (short) value.getValue();
		}

		protected Short caseChar(EclChar value) throws CoreException {
			return (short) value.getValue();
		}

		protected Short caseDouble(EclDouble value) throws CoreException {
			double val = value.getValue();
			return val < MIN || val > MAX ? super.caseDouble(value) : (short) val;
		}

		protected Short caseFloat(EclFloat value) throws CoreException {
			float val = value.getValue();
			return val < MIN || val > MAX ? super.caseFloat(value) : (short) val;
		}

		protected Short caseInteger(EclInteger value) throws CoreException {
			int val = value.getValue();
			return val < MIN || val > MAX ? super.caseInteger(value) : (short) val;
		}

		protected Short caseLong(EclLong value) throws CoreException {
			long val = value.getValue();
			return val < MIN || val > MAX ? super.caseLong(value) : (short) val;
		}

		protected Short caseShort(EclShort value) throws CoreException {
			return value.getValue();
		}

		protected Short caseString(EclString value) throws CoreException {
			try {
				return Short.parseShort(value.getValue());
			} catch (NumberFormatException e) {
				return super.caseString(value);
			}
		};

		private static final short MIN = Short.MIN_VALUE;
		private static final short MAX = Short.MAX_VALUE;
	};

	protected static BoxedSwitch<String> toString = new BoxedSwitch<String>() {
		protected String caseDefault(BoxedValue value, String friendlyName) throws CoreException {
			return value.eGet(value.eClass().getEStructuralFeature(VALUE_FEATURE))
					.toString();
		}

	};

	@SuppressWarnings("serial")
	private static Map<EClass, BoxedSwitch<? extends Object>> converters = new HashMap<EClass, BoxedValues.BoxedSwitch<? extends Object>>() {
		{
			put(CorePackage.Literals.ECL_BOOLEAN, toBoolean);
			put(CorePackage.Literals.ECL_BYTE, toByte);
			put(CorePackage.Literals.ECL_CHAR, toChar);
			put(CorePackage.Literals.ECL_DOUBLE, toDouble);
			put(CorePackage.Literals.ECL_FLOAT, toFloat);
			put(CorePackage.Literals.ECL_INTEGER, toInteger);
			put(CorePackage.Literals.ECL_LONG, toLong);
			put(CorePackage.Literals.ECL_SHORT, toShort);
			put(CorePackage.Literals.ECL_STRING, toString);
		}
	};

	public static BoxedValue toType(BoxedValue value, EClass to) throws CoreException {
		if (!converters.containsKey(to)) {
			throw new CoreException(CorePlugin.err(String.format("Don't know how to convert to %s", to.getName())));
		}
		return (BoxedValue) BoxedValues.box(converters.get(to).doSwitch(value));
	}

	public static Boolean toBoolean(BoxedValue boxed) throws CoreException {
		return toBoolean.doSwitch(boxed);
	}

	public static Byte toByte(BoxedValue boxed) throws CoreException {
		return toByte.doSwitch(boxed);
	}

	public static Character toChar(BoxedValue boxed) throws CoreException {
		return toChar.doSwitch(boxed);
	}

	public static Double toDouble(BoxedValue boxed) throws CoreException {
		return toDouble.doSwitch(boxed);
	}

	public static Float toFloat(BoxedValue boxed) throws CoreException {
		return toFloat.doSwitch(boxed);
	}

	public static Integer toInteger(BoxedValue boxed) throws CoreException {
		return toInteger.doSwitch(boxed);
	}

	public static Long toLong(BoxedValue boxed) throws CoreException {
		return toLong.doSwitch(boxed);
	}

	public static Short toShort(BoxedValue boxed) throws CoreException {
		return toShort.doSwitch(boxed);
	}

	public static String toString(BoxedValue boxed) {
		try {
			return toString.doSwitch(boxed);
		} catch (CoreException e) {
			return boxed == null ? "null" : boxed.toString();
		}
	}

	private static IStatus createConversionError(String value, String from,
			String to) {
		return new Status(IStatus.ERROR, CorePlugin.PLUGIN_ID, String.format(
				"Cannot convert value '%s' from %s to %s", value, from, to));
	}
}

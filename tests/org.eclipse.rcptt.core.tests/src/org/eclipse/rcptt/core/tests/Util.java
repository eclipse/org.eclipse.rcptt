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
package org.eclipse.rcptt.core.tests;

import java.io.DataInput;
import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UTFDataFormatException;

@SuppressWarnings("unused")
public class Util {
	public interface Displayable {
		String displayString(Object o);
	}

	public interface Comparer {
		/**
		 * Returns 0 if a and b are equal, >0 if a is greater than b, or <0 if a
		 * is less than b.
		 */
		int compare(Object a, Object b);
	}

	private static final char NEW_FORMAT_MARK = '+';
	private static final char ARGUMENTS_DELIMITER = '#';
	private static final String ARGUMENTS_DELIMITER_STR = String
			.valueOf(ARGUMENTS_DELIMITER);
	private static final String EMPTY_ARGUMENT = "   "; //$NON-NLS-1$
	public final static String UTF_8 = "UTF-8"; //$NON-NLS-1$

	/**
	 * Sort the strings in the given collection.
	 */
	private static void quickSort(String[] sortedCollection, int left, int right) {
		int original_left = left;
		int original_right = right;
		String mid = sortedCollection[(left + right) / 2];
		do {
			while (sortedCollection[left].compareTo(mid) < 0) {
				left++;
			}
			while (mid.compareTo(sortedCollection[right]) < 0) {
				right--;
			}
			if (left <= right) {
				String tmp = sortedCollection[left];
				sortedCollection[left] = sortedCollection[right];
				sortedCollection[right] = tmp;
				left++;
				right--;
			}
		} while (left <= right);
		if (original_left < right) {
			quickSort(sortedCollection, original_left, right);
		}
		if (left < original_right) {
			quickSort(sortedCollection, left, original_right);
		}
	}

	private static void quickSort(char[][] list, int left, int right) {
		int original_left = left;
		int original_right = right;
		char[] mid = list[(left + right) / 2];
		do {
			while (compare(list[left], mid) < 0) {
				left++;
			}
			while (compare(mid, list[right]) < 0) {
				right--;
			}
			if (left <= right) {
				char[] tmp = list[left];
				list[left] = list[right];
				list[right] = tmp;
				left++;
				right--;
			}
		} while (left <= right);
		if (original_left < right) {
			quickSort(list, original_left, right);
		}
		if (left < original_right) {
			quickSort(list, left, original_right);
		}
	}

	/**
	 * Sort the comparable objects in the given collection.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static void quickSort(Comparable[] sortedCollection, int left,
			int right) {
		int original_left = left;
		int original_right = right;
		Comparable mid = sortedCollection[(left + right) / 2];
		do {
			while (sortedCollection[left].compareTo(mid) < 0) {
				left++;
			}
			while (mid.compareTo(sortedCollection[right]) < 0) {
				right--;
			}
			if (left <= right) {
				Comparable tmp = sortedCollection[left];
				sortedCollection[left] = sortedCollection[right];
				sortedCollection[right] = tmp;
				left++;
				right--;
			}
		} while (left <= right);
		if (original_left < right) {
			quickSort(sortedCollection, original_left, right);
		}
		if (left < original_right) {
			quickSort(sortedCollection, left, original_right);
		}
	}

	private static void quickSort(int[] list, int left, int right) {
		int original_left = left;
		int original_right = right;
		int mid = list[(left + right) / 2];
		do {
			while (list[left] < mid) {
				left++;
			}
			while (mid < list[right]) {
				right--;
			}
			if (left <= right) {
				int tmp = list[left];
				list[left] = list[right];
				list[right] = tmp;
				left++;
				right--;
			}
		} while (left <= right);
		if (original_left < right) {
			quickSort(list, original_left, right);
		}
		if (left < original_right) {
			quickSort(list, left, original_right);
		}
	}

	/**
	 * Sort the objects in the given collection using the given comparer.
	 */
	private static void quickSort(Object[] sortedCollection, int left,
			int right, Comparer comparer) {
		int original_left = left;
		int original_right = right;
		Object mid = sortedCollection[(left + right) / 2];
		do {
			while (comparer.compare(sortedCollection[left], mid) < 0) {
				left++;
			}
			while (comparer.compare(mid, sortedCollection[right]) < 0) {
				right--;
			}
			if (left <= right) {
				Object tmp = sortedCollection[left];
				sortedCollection[left] = sortedCollection[right];
				sortedCollection[right] = tmp;
				left++;
				right--;
			}
		} while (left <= right);
		if (original_left < right) {
			quickSort(sortedCollection, original_left, right, comparer);
		}
		if (left < original_right) {
			quickSort(sortedCollection, left, original_right, comparer);
		}
	}

	public static void sort(char[][] list) {
		if (list.length > 1)
			quickSort(list, 0, list.length - 1);
	}

	/**
	 * Sorts an array of Comparable objects in place.
	 */
	@SuppressWarnings("rawtypes")
	public static void sort(Comparable[] objects) {
		if (objects.length > 1)
			quickSort(objects, 0, objects.length - 1);
	}

	public static void sort(int[] list) {
		if (list.length > 1)
			quickSort(list, 0, list.length - 1);
	}

	/**
	 * Sorts an array of objects in place. The given comparer compares pairs of
	 * items.
	 */
	public static void sort(Object[] objects, Comparer comparer) {
		if (objects.length > 1)
			quickSort(objects, 0, objects.length - 1, comparer);
	}

	/**
	 * Sorts an array of strings in place using quicksort.
	 */
	public static void sort(String[] strings) {
		if (strings.length > 1)
			quickSort(strings, 0, strings.length - 1);
	}

	/**
	 * Sorts an array of Comparable objects, returning a new array with the
	 * sorted items. The original array is left untouched.
	 */
	@SuppressWarnings("rawtypes")
	public static Comparable[] sortCopy(Comparable[] objects) {
		int len = objects.length;
		Comparable[] copy = new Comparable[len];
		System.arraycopy(objects, 0, copy, 0, len);
		sort(copy);
		return copy;
	}

	/**
	 * Sorts an array of Strings, returning a new array with the sorted items.
	 * The original array is left untouched.
	 */
	public static Object[] sortCopy(Object[] objects, Comparer comparer) {
		int len = objects.length;
		Object[] copy = new Object[len];
		System.arraycopy(objects, 0, copy, 0, len);
		sort(copy, comparer);
		return copy;
	}

	/**
	 * Sorts an array of Strings, returning a new array with the sorted items.
	 * The original array is left untouched.
	 */
	public static String[] sortCopy(String[] objects) {
		int len = objects.length;
		String[] copy = new String[len];
		System.arraycopy(objects, 0, copy, 0, len);
		sort(copy);
		return copy;
	}

	/**
	 * Compares two byte arrays. Returns <0 if a byte in a is less than the
	 * corresponding byte in b, or if a is shorter, or if a is null. Returns >0
	 * if a byte in a is greater than the corresponding byte in b, or if a is
	 * longer, or if b is null. Returns 0 if they are equal or both null.
	 */
	public static int compare(byte[] a, byte[] b) {
		if (a == b)
			return 0;
		if (a == null)
			return -1;
		if (b == null)
			return 1;
		int len = Math.min(a.length, b.length);
		for (int i = 0; i < len; ++i) {
			int diff = a[i] - b[i];
			if (diff != 0)
				return diff;
		}
		if (a.length > len)
			return 1;
		if (b.length > len)
			return -1;
		return 0;
	}

	/**
	 * Compares two strings lexicographically. The comparison is based on the
	 * Unicode value of each character in the strings.
	 * 
	 * @return the value <code>0</code> if the str1 is equal to str2; a value
	 *         less than <code>0</code> if str1 is lexicographically less than
	 *         str2; and a value greater than <code>0</code> if str1 is
	 *         lexicographically greater than str2.
	 */
	public static int compare(char[] str1, char[] str2) {
		int len1 = str1.length;
		int len2 = str2.length;
		int n = Math.min(len1, len2);
		int i = 0;
		while (n-- != 0) {
			char c1 = str1[i];
			char c2 = str2[i++];
			if (c1 != c2) {
				return c1 - c2;
			}
		}
		return len1 - len2;
	}

	/**
	 * Reads in a string from the specified data input stream. The string has
	 * been encoded using a modified UTF-8 format.
	 * <p>
	 * The first two bytes are read as if by <code>readUnsignedShort</code>.
	 * This value gives the number of following bytes that are in the encoded
	 * string, not the length of the resulting string. The following bytes are
	 * then interpreted as bytes encoding characters in the UTF-8 format and are
	 * converted into characters.
	 * <p>
	 * This method blocks until all the bytes are read, the end of the stream is
	 * detected, or an exception is thrown.
	 * 
	 * @param in
	 *            a data input stream.
	 * @return a Unicode string.
	 * @exception EOFException
	 *                if the input stream reaches the end before all the bytes.
	 * @exception IOException
	 *                if an I/O error occurs.
	 * @exception UTFDataFormatException
	 *                if the bytes do not represent a valid UTF-8 encoding of a
	 *                Unicode string.
	 * @see java.io.DataInputStream#readUnsignedShort()
	 */
	public final static char[] readUTF(DataInput in) throws IOException {
		int utflen = in.readUnsignedShort();
		char str[] = new char[utflen];
		int count = 0;
		int strlen = 0;
		while (count < utflen) {
			int c = in.readUnsignedByte();
			int char2, char3;
			switch (c >> 4) {
			case 0:
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
			case 6:
			case 7:
				// xxxxxxx
				count++;
				str[strlen++] = (char) c;
				break;
			case 12:
			case 13:
				// 110x xxxx 10xx xxxx
				count += 2;
				if (count > utflen)
					throw new UTFDataFormatException();
				char2 = in.readUnsignedByte();
				if ((char2 & 0xC0) != 0x80)
					throw new UTFDataFormatException();
				str[strlen++] = (char) (((c & 0x1F) << 6) | (char2 & 0x3F));
				break;
			case 14:
				// 1110 xxxx 10xx xxxx 10xx xxxx
				count += 3;
				if (count > utflen)
					throw new UTFDataFormatException();
				char2 = in.readUnsignedByte();
				char3 = in.readUnsignedByte();
				if (((char2 & 0xC0) != 0x80) || ((char3 & 0xC0) != 0x80))
					throw new UTFDataFormatException();
				str[strlen++] = (char) (((c & 0x0F) << 12)
						| ((char2 & 0x3F) << 6) | ((char3 & 0x3F) << 0));
				break;
			default:
				// 10xx xxxx, 1111 xxxx
				throw new UTFDataFormatException();
			}
		}
		if (strlen < utflen) {
			System.arraycopy(str, 0, str = new char[strlen], 0, strlen);
		}
		return str;
	}

	/**
	 * Writes a string to the given output stream using UTF-8 encoding in a
	 * machine-independent manner.
	 * <p>
	 * First, two bytes are written to the output stream as if by the
	 * <code>writeShort</code> method giving the number of bytes to follow. This
	 * value is the number of bytes actually written out, not the length of the
	 * string. Following the length, each character of the string is output, in
	 * sequence, using the UTF-8 encoding for the character.
	 * 
	 * @param str
	 *            a string to be written.
	 * @return the number of bytes written to the stream.
	 * @exception IOException
	 *                if an I/O error occurs.
	 * 
	 */
	public static int writeUTF(OutputStream out, char[] str) throws IOException {
		int strlen = str.length;
		int utflen = 0;
		for (int i = 0; i < strlen; i++) {
			int c = str[i];
			if ((c >= 0x0001) && (c <= 0x007F)) {
				utflen++;
			} else if (c > 0x07FF) {
				utflen += 3;
			} else {
				utflen += 2;
			}
		}
		if (utflen > 65535)
			throw new UTFDataFormatException();
		out.write((utflen >>> 8) & 0xFF);
		out.write((utflen >>> 0) & 0xFF);
		if (strlen == utflen) {
			for (int i = 0; i < strlen; i++)
				out.write(str[i]);
		} else {
			for (int i = 0; i < strlen; i++) {
				int c = str[i];
				if ((c >= 0x0001) && (c <= 0x007F)) {
					out.write(c);
				} else if (c > 0x07FF) {
					out.write(0xE0 | ((c >> 12) & 0x0F));
					out.write(0x80 | ((c >> 6) & 0x3F));
					out.write(0x80 | ((c >> 0) & 0x3F));
				} else {
					out.write(0xC0 | ((c >> 6) & 0x1F));
					out.write(0x80 | ((c >> 0) & 0x3F));
				}
			}
		}
		return utflen + 2; // the number of bytes written to the stream
	}

}

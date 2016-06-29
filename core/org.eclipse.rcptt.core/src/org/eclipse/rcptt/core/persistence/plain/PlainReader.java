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
package org.eclipse.rcptt.core.persistence.plain;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipInputStream;

import org.eclipse.rcptt.internal.core.RcpttPlugin;
import org.eclipse.rcptt.util.Base64;
import org.eclipse.rcptt.util.FileUtil;

public class PlainReader implements IPlainConstants {
	private BufferedReader reader;
	private InputStream in;

	public static class Entry {
		public String name;
		private Object content;
		public Map<String, String> attributes;
		public String rawData;

		public Object getContent() {
			if (content == null && rawData != null) {
				try {
					byte[] decode = Base64.decode(rawData);
					if (decode == null) {
						RcpttPlugin.log(
								"Failed to decode Q7 file format, invalid content",
								null);
						return null;
					}
					ByteArrayInputStream bin = new ByteArrayInputStream(decode);
					ZipInputStream zin = new ZipInputStream(bin);
					zin.getNextEntry();
					content = FileUtil.getStreamContent(zin);
					rawData = null;
				} catch (Exception e) {
					RcpttPlugin.log(e);
				}
			}
			return content;
		}
	}

	public PlainReader(InputStream stream) throws IOException {
		this.in = stream;
		reader = new BufferedReader(new InputStreamReader(
				new BufferedInputStream(stream), ENCODING));
	}

	private static final List<String> VALID_HEADERS = Arrays.asList(PLAIN_HEADER, PLAIN_METADATA, PLAIN_VERIFICATION,
			LEGACY_PLAIN_HEADER, LEGACY_PLAIN_METADATA, LEGACY_PLAIN_VERIFICATION);
	public Map<String, String> readHeader() throws Exception {
		String header = reader.readLine();
		if (header == null) {
			return null;
		}
		header = header.trim();
		while( header.startsWith("#")) {
			header = reader.readLine();
			if( header == null) {
				return null;
			}
			header = header.trim();
		}
		boolean headerOK = false;
		for (String validHeader : VALID_HEADERS) {
			if (validHeader.equalsIgnoreCase(header)) {
				headerOK = true;
				break;
			}
		}
		if (!headerOK) {
			// Not a plain file
			return null;
		}
		Map<String, String> map = readAttributes();
		return map;
	}

	private Map<String, String> readAttributes() throws IOException, Exception {
		Map<String, String> map = new HashMap<String, String>();
		while (true) {
			String line = reader.readLine();
			if (line == null || line.trim().length() == 0) {
				break;
			}
			int pos = line.indexOf(": ");
			if (pos != -1) {
				String key = line.substring(0, pos);
				String value = FileUtil.unescape(line.substring(pos + 2));
				if (map.containsKey(key)) {
					throw new Exception(
							"Wrong q7 plain format, duplicate attribute entry.");
				}
				map.put(key, value);
			} else {
				if (line.trim().endsWith(":")) {
					// Null Value, skip it
				} else {
					throw new Exception("Wrong q7 plain format");
				}
			}
		}
		return map;
	}

	/**
	 * Return next entry and null if end of stream are detected
	 * 
	 * @return
	 * @throws IOException
	 */
	public Entry readEntry() throws Exception {
		String entryHeader = reader.readLine();
		if (entryHeader == null) {
			return null;
		}
		// Skip newlines.
		while (entryHeader != null && entryHeader.trim().length() == 0) {
			entryHeader = reader.readLine();
		}
		if (entryHeader == null) {
			return null;
		}
		if (entryHeader.startsWith(NODE_PREFIX)) {
			Entry entry = new Entry();
			entry.attributes = readAttributes();
			entry.name = entry.attributes.get(ATTR_ENTRY_NAME);
			String contentType = entry.attributes.get(ATTR_CONTENT_TYPE);
			List<String> lines = new ArrayList<String>();
			while (true) {
				String line = reader.readLine();
				if (line == null
						|| line.trim().equals(entryHeader + NODE_POSTFIX)) {
					break;
				}
				lines.add(line);
			}
			if (contentType != null && contentType.contains("text")) {
				// Text mode content
				StringBuilder builder = new StringBuilder();
				for (String s : lines) {
					builder.append(s).append("\n");
				}
				String resultStr = builder.toString();
				if (resultStr.endsWith("\n")) {
					resultStr = resultStr.substring(0, resultStr.length()
							- "\n".length());
				}
				entry.content = resultStr;
			} else if (contentType != null && contentType.contains("binary")) {
				// Base64 encoded content
				StringBuilder builder = new StringBuilder();
				for (String s : lines) {
					builder.append(s);
				}
				entry.rawData = builder.toString();
			}
			return entry;

		} else {
			throw new Exception("Wrong q7 plain format");
		}
	}

	public void close() {
		FileUtil.safeClose(reader);
		FileUtil.safeClose(in);
	}
}

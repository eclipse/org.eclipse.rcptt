/*******************************************************************************
 * Copyright (c) 2009, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.internal.core.model.index;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;

import org.eclipse.rcptt.core.model.index.IQ7IndexConstants;
import org.eclipse.rcptt.core.model.search.SearchPattern.IKeyQuery;
import org.eclipse.rcptt.internal.core.RcpttPlugin;
import org.eclipse.rcptt.util.FileUtil;

public class Index {
	private static final String CURRENT_VERSION = "INDEX_ID_1.0.3";
	// private static final int N_THREADS = 8;
	// private IPath path;
	public ReadWriteMonitor monitor;
	private File indexFile;
	private Map<String, Entry> docToEnties = new HashMap<String, Entry>();
	private Map<String, String> pathToIDCache = new HashMap<String, String>();
	private Map<String, List<String>> idToPathCache = new HashMap<String, List<String>>();

	private Map<String, String> pathToNameCache = new HashMap<String, String>();
	private int changes = 0;
	private IPath path;

	private static class Entry {
		Map<String, List<String>> keys = new HashMap<String, List<String>>();
		String path;
		long timestamp = -1;

		public void addKey(String key, String value) {
			List<String> list = keys.get(key);
			if (list == null) {
				list = new ArrayList<String>();
				keys.put(key, list);
			}
			if( !list.contains(value)) {
				list.add(value);
			}
		}
	}

	public Index(IPath fullPath) {
		this.path = fullPath;
		this.monitor = new ReadWriteMonitor();
		// this.path = fullPath;
		indexFile = RcpttPlugin.getDefault().getStateLocation().append("index")
				.append(FileUtil.getID(fullPath.toString()) + ".index")
				.toFile();
		indexFile.getParentFile().mkdirs();
	}

	public synchronized void load() {
		this.docToEnties.clear();
		if (indexFile.exists()) {
			DataInputStream din = null;
			try {
				din = new DataInputStream(new BufferedInputStream(
						new FileInputStream(indexFile)));
				String id = din.readUTF();
				if (id.equals(CURRENT_VERSION)) {
					readIndex_1_0(din);
				}
			} catch (IOException e) {
				RcpttPlugin.log(e);
			} finally {
				FileUtil.safeClose(din);
			}
		}
	}

	private void readIndex_1_0(DataInputStream din) throws IOException {
		int entriesCount = din.readInt();
		for (int i = 0; i < entriesCount; i++) {
			Entry entry = new Entry();
			entry.path = din.readUTF();
			entry.timestamp = din.readLong();
			int keysCount = din.readInt();
			for (int j = 0; j < keysCount; j++) {
				String key = din.readUTF();
				List<String> values = new ArrayList<String>();
				int valuesCount = din.readInt();
				for (int k = 0; k < valuesCount; k++) {
					values.add(din.readUTF());
				}
				entry.keys.put(key, values);
				if (IQ7IndexConstants.ID.equals(key) && values.size() == 1) {
					pathToIDCache.put(entry.path, values.get(0));
					updateIdToPath(entry.path, values.get(0));
				}
				if (IQ7IndexConstants.NAME.equals(key) && values.size() == 1) {
					pathToNameCache.put(entry.path, values.get(0));
				}
			}
			docToEnties.put(entry.path, entry);
		}
	}

	private void writeIndex_1_0(DataOutputStream dout) throws IOException {
		dout.writeUTF(CURRENT_VERSION);
		List<String> keySet = new ArrayList<String>(docToEnties.keySet());
		int entriesCount = docToEnties.size();
		dout.writeInt(entriesCount);
		for (int i = 0; i < entriesCount; i++) {
			Entry entry = docToEnties.get(keySet.get(i));
			dout.writeUTF(entry.path);
			dout.writeLong(entry.timestamp);
			int keysCount = entry.keys.size();
			dout.writeInt(keysCount);
			List<String> eKeys = new ArrayList<String>(entry.keys.keySet());
			for (int j = 0; j < keysCount; j++) {
				String key = eKeys.get(j);
				dout.writeUTF(key);
				List<String> values = entry.keys.get(key);
				int valuesCount = values.size();
				dout.writeInt(valuesCount);
				for (int k = 0; k < valuesCount; k++) {
					dout.writeUTF(values.get(k));
				}
			}
		}
	}

	public synchronized String[] queryDocumentNames() {
		Set<String> names = docToEnties.keySet();
		return names.toArray(new String[names.size()]);
	}

	public synchronized void remove(String path) {
		changes++;
		docToEnties.remove(path);
		String id = pathToIDCache.remove(path);
		pathToNameCache.remove(path);
		List<String> list = idToPathCache.get(id);
		if (list != null) {
			list.remove(path);
			if (list.isEmpty()) {
				idToPathCache.remove(id);
			}
		}

	}

	public synchronized void save() throws IOException {
		if (changes == 0 && indexFile.exists()) {
			return;
		}
		if (docToEnties.isEmpty()) {
			if (indexFile.exists()) {
				indexFile.delete();
			}
		}
		DataOutputStream dout = null;
		try {
			dout = new DataOutputStream(new BufferedOutputStream(
					new FileOutputStream(indexFile)));
			writeIndex_1_0(dout);
		} finally {
			FileUtil.safeClose(dout);
		}
		changes = 0;
	}

	public synchronized void dispose() {
		docToEnties.clear();
		if (indexFile.exists()) {
			indexFile.delete();
		}
	}

	public synchronized void addKey(String path, String key, String value) {
		if (changes >= 2500) {
			try {
				save();
			} catch (IOException e) {
				RcpttPlugin.log(e);
			}
		}
		changes++;
		getEntry(path).addKey(key, value);
		if (IQ7IndexConstants.ID.equals(key)) {
			pathToIDCache.put(path, value);
			updateIdToPath(path, value);
		}
		if (IQ7IndexConstants.NAME.equals(key)) {
			pathToNameCache.put(path, value);
		}
	}

	private void updateIdToPath(String path, String id) {
		List<String> list = idToPathCache.get(id);
		if (list == null) {
			list = new ArrayList<String>();
			idToPathCache.put(id, list);
		}
		if (!list.contains(path)) {
			list.add(path);
		}
	}

	private Entry getEntry(String path) {
		Entry entry = docToEnties.get(path);
		if (entry == null) {
			entry = new Entry();
			entry.path = path;
			docToEnties.put(path, entry);
		}
		return entry;
	}

	public synchronized void updateModificationstamp(String path, long stamp) {
		changes++;
		getEntry(path).timestamp = stamp;
	}

	public synchronized long getModificationStamp(String path) {
		return getEntry(path).timestamp;
	}

	public synchronized List<QueryResult> queryIDs(String id) {
		List<QueryResult> result = new ArrayList<QueryResult>();
		List<String> list = idToPathCache.get(id);
		if (list == null) {
			return result;
		}
		for (String path : list) {
			result.add(new QueryResult(path, IQ7IndexConstants.ID, id));
		}

		return result;
	}

	public synchronized String queryID(String path) {
		return pathToIDCache.get(path);
	}

	public synchronized String queryName(String path) {
		return pathToNameCache.get(path);
	}

	public synchronized List<QueryResult> query(final String[] keys,
			final IKeyQuery pattern, IProgressMonitor monitor) {
		// ExecutorService executor = Executors.newFixedThreadPool(N_THREADS);
		final List<QueryResult> results = new ArrayList<QueryResult>();
		for (final Map.Entry<String, Entry> entry : docToEnties.entrySet()) {
			if (monitor.isCanceled()) {
				throw new OperationCanceledException();
			}
			// executor.execute(new Runnable() {
			// public void run() {
			Entry value = entry.getValue();
			for (String k : keys) {
				List<String> list = value.keys.get(k);
				if (list != null) {
					for (String val : list) {
						if (pattern.accept(k, val)) {
							synchronized (results) {
								results.add(new QueryResult(entry.getKey(), k,
										val));
							}
						}
					}
				}
			}
			// }
			// });
		}
		// executor.shutdown();
		// while (!executor.isTerminated()) {
		// try {
		// Thread.sleep(50);
		// } catch (Throwable e) {
		// // ignore
		// }
		// }
		return results;
	}

	public IPath getPath() {
		return path;
	}

	public synchronized Map<String, List<String>> query(String documentName) {
		Entry entry = getEntry(documentName);
		Map<String, List<String>> copy = new HashMap<String, List<String>>();
		Set<Map.Entry<String, List<String>>> entrySet = entry.keys.entrySet();
		for (Map.Entry<String, List<String>> entryValue : entrySet) {
			copy.put(entryValue.getKey(),
					new ArrayList<String>(entryValue.getValue()));
		}
		return copy;
	}
}

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
package org.eclipse.rcptt.internal.core.model.cache;

import java.util.Enumeration;

public abstract class OverflowingLRUCache extends LRUCache {
	protected int fOverflow = 0;
	protected boolean fTimestampsOn = true;
	protected double fLoadFactor = 0.333;

	public OverflowingLRUCache(int size) {
		this(size, 0);
	}

	public OverflowingLRUCache(int size, int overflow) {
		super(size);
		fOverflow = overflow;
	}

	public Object clone() {

		OverflowingLRUCache newCache = (OverflowingLRUCache) newInstance(
				fSpaceLimit, fOverflow);
		LRUCacheEntry qEntry;

		/* Preserve order of entries by copying from oldest to newest */
		qEntry = this.fEntryQueueTail;
		while (qEntry != null) {
			newCache.privateAdd(qEntry._fKey, qEntry._fValue, qEntry._fSpace);
			qEntry = qEntry._fPrevious;
		}
		return newCache;
	}

	protected abstract boolean close(LRUCacheEntry entry);

	@SuppressWarnings("rawtypes")
	public Enumeration elements() {
		if (fEntryQueue == null)
			return new LRUCacheEnumerator(null);
		LRUCacheEnumerator.LRUEnumeratorElement head = new LRUCacheEnumerator.LRUEnumeratorElement(
				fEntryQueue._fValue);
		LRUCacheEntry currentEntry = fEntryQueue._fNext;
		LRUCacheEnumerator.LRUEnumeratorElement currentElement = head;
		while (currentEntry != null) {
			currentElement.fNext = new LRUCacheEnumerator.LRUEnumeratorElement(
					currentEntry._fValue);
			currentElement = currentElement.fNext;

			currentEntry = currentEntry._fNext;
		}
		return new LRUCacheEnumerator(head);
	}

	public double fillingRatio() {
		return (fCurrentSpace + fOverflow) * 100.0 / fSpaceLimit;
	}

	@SuppressWarnings("rawtypes")
	public java.util.Hashtable getEntryTable() {
		return fEntryTable;
	}

	public double getLoadFactor() {
		return fLoadFactor;
	}

	public int getOverflow() {
		return fOverflow;
	}

	protected boolean makeSpace(int space) {

		int limit = fSpaceLimit;
		if (fOverflow == 0 && fCurrentSpace + space <= limit) {
			/* if space is already available */
			return true;
		}

		/* Free up space by removing oldest entries */
		int spaceNeeded = (int) ((1 - fLoadFactor) * limit);
		spaceNeeded = (spaceNeeded > space) ? spaceNeeded : space;
		LRUCacheEntry entry = fEntryQueueTail;

		try {
			// disable timestamps update while making space so that the previous
			// and next links are not changed
			// (by a call to get(Object) for example)
			fTimestampsOn = false;

			while (fCurrentSpace + spaceNeeded > limit && entry != null) {
				this.privateRemoveEntry(entry, false, false);
				entry = entry._fPrevious;
			}
		} finally {
			fTimestampsOn = true;
		}

		/* check again, since we may have aquired enough space */
		if (fCurrentSpace + space <= limit) {
			fOverflow = 0;
			return true;
		}

		/* update fOverflow */
		fOverflow = fCurrentSpace + space - limit;
		return false;
	}

	protected abstract LRUCache newInstance(int size, int overflow);

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void printStats() {
		LRUCacheEntry entry = fEntryQueue;
		while (entry != null) {
			entry = entry._fNext;
		}

		entry = fEntryQueueTail;
		while (entry != null) {
			entry = entry._fPrevious;
		}

		Enumeration keys = fEntryTable.keys();
		class Temp {
			public Class fClass;
			public int fCount;

			public Temp(Class aClass) {
				fClass = aClass;
				fCount = 1;
			}

			public String toString() {
				return "Class: " + fClass + " has " + fCount + " entries."; //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-1$
			}
		}
		java.util.HashMap h = new java.util.HashMap();
		while (keys.hasMoreElements()) {
			entry = (LRUCacheEntry) fEntryTable.get(keys.nextElement());
			Class key = entry._fValue.getClass();
			Temp t = (Temp) h.get(key);
			if (t == null) {
				h.put(key, new Temp(key));
			} else {
				t.fCount++;
			}
		}
	}

	protected void privateRemoveEntry(LRUCacheEntry entry, boolean shuffle) {
		privateRemoveEntry(entry, shuffle, true);
	}

	protected void privateRemoveEntry(LRUCacheEntry entry, boolean shuffle,
			boolean external) {

		if (!shuffle) {
			if (external) {
				fEntryTable.remove(entry._fKey);
				fCurrentSpace -= entry._fSpace;
				privateNotifyDeletionFromCache(entry);
			} else {
				if (!close(entry))
					return;
				// buffer close will recursively call #privateRemoveEntry with
				// external==true
				// thus entry will already be removed if reaching this point.
				if (fEntryTable.get(entry._fKey) == null) {
					return;
				} else {
					// basic removal
					fEntryTable.remove(entry._fKey);
					fCurrentSpace -= entry._fSpace;
					privateNotifyDeletionFromCache(entry);
				}
			}
		}
		LRUCacheEntry previous = entry._fPrevious;
		LRUCacheEntry next = entry._fNext;

		/* if this was the first entry */
		if (previous == null) {
			fEntryQueue = next;
		} else {
			previous._fNext = next;
		}
		/* if this was the last entry */
		if (next == null) {
			fEntryQueueTail = previous;
		} else {
			next._fPrevious = previous;
		}
	}

	public Object put(Object key, Object value) {
		/* attempt to rid ourselves of the overflow, if there is any */
		if (fOverflow > 0)
			shrink();

		/* Check whether there's an entry in the cache */
		int newSpace = spaceFor(value);
		LRUCacheEntry entry = (LRUCacheEntry) fEntryTable.get(key);

		if (entry != null) {
			privateRemoveEntry(entry, false, false);
		}

		// attempt to make new space
		makeSpace(newSpace);

		// add without worring about space, it will
		// be handled later in a makeSpace call
		privateAdd(key, value, newSpace);

		return value;
	}

	public Object remove(Object key) {
		return removeKey(key);
	}

	public void setLoadFactor(double newLoadFactor)
			throws IllegalArgumentException {
		if (newLoadFactor <= 1.0 && newLoadFactor > 0.0)
			fLoadFactor = newLoadFactor;
		else
			throw new IllegalArgumentException("Invalid load factor");
	}

	public void setSpaceLimit(int limit) {
		if (limit < fSpaceLimit) {
			makeSpace(fSpaceLimit - limit);
		}
		fSpaceLimit = limit;
	}

	public boolean shrink() {
		if (fOverflow > 0)
			return makeSpace(0);
		return true;
	}

	public String toString() {
		return toStringFillingRation("OverflowingLRUCache ") + //$NON-NLS-1$
				toStringContents();
	}

	protected void updateTimestamp(LRUCacheEntry entry) {
		if (fTimestampsOn) {
			entry._fTimestamp = fTimestampCounter++;
			if (fEntryQueue != entry) {
				this.privateRemoveEntry(entry, true);
				this.privateAddEntry(entry, true);
			}
		}
	}
}

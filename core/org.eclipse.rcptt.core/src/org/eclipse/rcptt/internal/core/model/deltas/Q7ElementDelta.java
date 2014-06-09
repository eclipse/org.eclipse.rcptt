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
package org.eclipse.rcptt.internal.core.model.deltas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.rcptt.core.model.IQ7Element;
import org.eclipse.rcptt.core.model.IQ7Element.HandleType;
import org.eclipse.rcptt.core.model.IQ7ElementDelta;
import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.internal.core.model.Q7Element;

public class Q7ElementDelta extends SimpleDelta implements IQ7ElementDelta {

	/**
	 * Empty array of IModelElementDelta
	 */
	protected static final IQ7ElementDelta[] EMPTY_DELTA = new IQ7ElementDelta[] {};

	protected IQ7ElementDelta[] affectedChildren = EMPTY_DELTA;

	/*
	 * The element that this delta describes the change to.
	 */
	protected IQ7Element changedElement;

	protected IResourceDelta[] resourceDeltas = null;

	/**
	 * Counter of resource deltas
	 */
	protected int resourceDeltasCounter;
	/**
	 * @see #getMovedFromElement()
	 */
	protected IQ7Element movedFromHandle = null;
	/**
	 * @see #getMovedToElement()
	 */
	protected IQ7Element movedToHandle = null;

	public Q7ElementDelta(IQ7Element element) {
		this.changedElement = element;
	}

	/**
	 * Creates the nested deltas resulting from an add operation. Convenience
	 * method for creating add deltas. The constructor should be used to create
	 * the root delta and then an add operation should call this method.
	 */
	public void added(IQ7Element element) {
		added(element, 0);
	}

	public void added(IQ7Element element, int flags) {
		Q7ElementDelta addedDelta = new Q7ElementDelta(element);
		addedDelta.added();
		addedDelta.changeFlags |= flags;
		insertDeltaTree(element, addedDelta);
	}

	/**
	 * Creates the nested deltas resulting from an delete operation. Convenience
	 * method for creating removed deltas. The constructor should be used to
	 * create the root delta and then the delete operation should call this
	 * method.
	 */
	public void removed(IQ7Element element) {
		removed(element, 0);
	}

	public void removed(IQ7Element element, int flags) {
		Q7ElementDelta removedDelta = new Q7ElementDelta(element);
		insertDeltaTree(element, removedDelta);
		Q7ElementDelta actualDelta = getDeltaFor(element);
		if (actualDelta != null) {
			actualDelta.removed();
			actualDelta.changeFlags |= flags;
			actualDelta.affectedChildren = EMPTY_DELTA;
		}
	}

	/**
	 * Returns the delta for a given element. Only looks below this delta.
	 */
	protected Q7ElementDelta getDeltaFor(IQ7Element element) {
		if (this.equalsAndSameParent(getElement(), element)) // handle case of
																// two archives
																// that can be
																// equals but
																// not in the
																// same project
			return this;
		if (this.affectedChildren.length == 0)
			return null;
		int childrenCount = this.affectedChildren.length;
		for (int i = 0; i < childrenCount; i++) {
			Q7ElementDelta delta = (Q7ElementDelta) this.affectedChildren[i];
			if (this.equalsAndSameParent(delta.getElement(), element)) { // handle
																			// case
																			// of
																			// two
																			// archives
																			// that
																			// can
																			// be
																			// equals
																			// but
																			// not
																			// in
																			// the
																			// same
																			// project
				return delta;
			} else {
				delta = delta.getDeltaFor(element);
				if (delta != null)
					return delta;
			}
		}
		return null;
	}

	/**
	 * Adds the child delta to the collection of affected children. If the child
	 * is already in the collection, walk down the hierarchy.
	 */
	protected void addAffectedChild(Q7ElementDelta child) {
		switch (this.kind) {
		case ADDED:
		case REMOVED:
			// no need to add a child if this parent is added or removed
			return;
		case CHANGED:
			this.changeFlags |= F_CHILDREN;
			break;
		default:
			this.kind = CHANGED;
			this.changeFlags |= F_CHILDREN;
		}

		// if a child delta is added to a compilation unit delta or below,
		// it's a fine grained delta
		if (this.changedElement.getElementType().equals(HandleType.Context)
				|| this.changedElement.getElementType().equals(HandleType.Verification)
				|| this.changedElement.getElementType().equals(HandleType.TestCase)
				|| this.changedElement.getElementType().equals(HandleType.TestSuite)) {
			this.fineGrained();
		}

		if (this.affectedChildren == null || this.affectedChildren.length == 0) {
			this.affectedChildren = new IQ7ElementDelta[] { child };
			return;
		}
		Q7ElementDelta existingChild = null;
		int existingChildIndex = -1;
		if (this.affectedChildren != null) {
			for (int i = 0; i < this.affectedChildren.length; i++) {
				if (this.equalsAndSameParent(this.affectedChildren[i].getElement(),
						child.getElement())) { // handle case of two archives
												// that can be equals but not in
												// the same project
					existingChild = (Q7ElementDelta) this.affectedChildren[i];
					existingChildIndex = i;
					break;
				}
			}
		}
		if (existingChild == null) { // new affected child
			this.affectedChildren = growAndAddToArray(this.affectedChildren, child);
		} else {
			switch (existingChild.getKind()) {
			case ADDED:
				switch (child.getKind()) {
				case ADDED: // child was added then added -> it is added
				case CHANGED: // child was added then changed -> it is added
					return;
				case REMOVED: // child was added then removed -> noop
					this.affectedChildren = this.removeAndShrinkArray(
							this.affectedChildren, existingChildIndex);
					return;
				}
				break;
			case REMOVED:
				switch (child.getKind()) {
				case ADDED: // child was removed then added -> it is changed
					child.kind = CHANGED;
					this.affectedChildren[existingChildIndex] = child;
					return;
				case CHANGED: // child was removed then changed -> it is removed
				case REMOVED: // child was removed then removed -> it is removed
					return;
				}
				break;
			case CHANGED:
				switch (child.getKind()) {
				case ADDED: // child was changed then added -> it is added
				case REMOVED: // child was changed then removed -> it is removed
					this.affectedChildren[existingChildIndex] = child;
					return;
				case CHANGED: // child was changed then changed -> it is changed
					IQ7ElementDelta[] children = child.getAffectedChildren();
					for (int i = 0; i < children.length; i++) {
						Q7ElementDelta childsChild = (Q7ElementDelta) children[i];
						existingChild.addAffectedChild(childsChild);
					}

					// update flags
					boolean childHadContentFlag = (child.changeFlags & F_CONTENT) != 0;
					boolean existingChildHadChildrenFlag = (existingChild.changeFlags & F_CHILDREN) != 0;
					existingChild.changeFlags |= child.changeFlags;

					// remove F_CONTENT flag if existing child had F_CHILDREN
					// flag set
					// (case of fine grained delta (existing child) and delta
					// coming from
					// DeltaProcessor (child))
					if (childHadContentFlag && existingChildHadChildrenFlag) {
						existingChild.changeFlags &= ~F_CONTENT;
					}

					// add the non-java resource deltas if needed
					// note that the child delta always takes precedence over
					// this existing child delta
					// as non-java resource deltas are always created last (by
					// the DeltaProcessor)
					IResourceDelta[] resDeltas = child.getResourceDeltas();
					if (resDeltas != null) {
						existingChild.resourceDeltas = resDeltas;
						existingChild.resourceDeltasCounter = child.resourceDeltasCounter;
					}

					return;
				}
				break;
			default:
				// unknown -> existing child becomes the child with the existing
				// child's flags
				int flags = existingChild.getFlags();
				this.affectedChildren[existingChildIndex] = child;
				child.changeFlags |= flags;
			}
		}
	}

	public IQ7Element getElement() {
		return this.changedElement;
	}

	/**
	 * Creates the nested deltas resulting from a change operation. Convenience
	 * method for creating change deltas. The constructor should be used to
	 * create the root delta and then a change operation should call this
	 * method.
	 */
	public Q7ElementDelta changed(IQ7Element element, int changeFlag) {
		Q7ElementDelta changedDelta = new Q7ElementDelta(element);
		changedDelta.changed(changeFlag);
		insertDeltaTree(element, changedDelta);
		return changedDelta;
	}

	/**
	 * Creates the delta tree for the given element and delta, and then inserts
	 * the tree as an affected child of this node.
	 */
	public void insertDeltaTree(IQ7Element element, Q7ElementDelta delta) {
		Q7ElementDelta childDelta = createDeltaTree(element, delta);
		if (!this.equalsAndSameParent(element, getElement())) { // handle case
																// of two
																// archives that
																// can be equals
																// but not in
																// the same
																// project
			addAffectedChild(childDelta);
		}
	}

	/**
	 * Creates the nested delta deltas based on the affected element its delta,
	 * and the root of this delta tree. Returns the root of the created delta
	 * tree.
	 */
	@SuppressWarnings("rawtypes")
	protected Q7ElementDelta createDeltaTree(IQ7Element element, Q7ElementDelta delta) {
		Q7ElementDelta childDelta = delta;
		ArrayList ancestors = getAncestors(element);
		if (ancestors == null) {
			if (this.equalsAndSameParent(delta.getElement(), getElement())) { // handle
																				// case
																				// of
																				// two
																				// archives
																				// that
																				// can
																				// be
																				// equals
																				// but
																				// not
																				// in
																				// the
																				// same
																				// project
				// the element being changed is the root element
				this.kind = delta.kind;
				this.changeFlags = delta.changeFlags;
				this.movedToHandle = delta.movedToHandle;
				this.movedFromHandle = delta.movedFromHandle;
			}
		} else {
			for (int i = 0, size = ancestors.size(); i < size; i++) {
				IQ7Element ancestor = (IQ7Element) ancestors.get(i);
				Q7ElementDelta ancestorDelta = new Q7ElementDelta(ancestor);
				ancestorDelta.addAffectedChild(childDelta);
				childDelta = ancestorDelta;
			}
		}
		return childDelta;
	}

	protected boolean equalsAndSameParent(IQ7Element e1, IQ7Element e2) {
		IQ7Element parent1;
		return e1.equals(e2) && ((parent1 = e1.getParent()) != null)
				&& parent1.equals(e2.getParent());
	}

	public IQ7ElementDelta[] getAddedChildren() {
		return getChildrenOfType(ADDED);
	}

	public IQ7ElementDelta[] getAffectedChildren() {
		return this.affectedChildren;
	}

	/**
	 * Returns a collection of all the parents of this element up to (but not
	 * including) the root of this tree in bottom-up order. If the given element
	 * is not a descendant of the root of this tree, <code>null</code> is
	 * returned.
	 */
	private ArrayList<IQ7Element> getAncestors(IQ7Element element) {
		IQ7Element parent = element.getParent();
		if (parent == null) {
			return null;
		}
		ArrayList<IQ7Element> parents = new ArrayList<IQ7Element>();
		while (!parent.equals(this.changedElement)) {
			parents.add(parent);
			parent = parent.getParent();
			if (parent == null) {
				return null;
			}
		}
		parents.trimToSize();
		return parents;
	}

	/**
	 * Adds the new element to a new array that contains all of the elements of
	 * the old array. Returns the new array.
	 */
	protected IQ7ElementDelta[] growAndAddToArray(IQ7ElementDelta[] array,
			IQ7ElementDelta addition) {
		IQ7ElementDelta[] old = array;
		array = new IQ7ElementDelta[old.length + 1];
		System.arraycopy(old, 0, array, 0, old.length);
		array[old.length] = addition;
		return array;
	}

	/**
	 * Removes the element from the array. Returns the a new array which has
	 * shrunk.
	 */
	protected IQ7ElementDelta[] removeAndShrinkArray(IQ7ElementDelta[] old, int index) {
		IQ7ElementDelta[] array = new IQ7ElementDelta[old.length - 1];
		if (index > 0)
			System.arraycopy(old, 0, array, 0, index);
		int rest = old.length - index - 1;
		if (rest > 0)
			System.arraycopy(old, index + 1, array, index, rest);
		return array;
	}

	/**
	 * Mark this delta as a fine-grained delta.
	 */
	public void fineGrained() {
		changed(F_FINE_GRAINED);
	}

	/**
	 * Return the collection of resource deltas. Return null if none.
	 */
	public IResourceDelta[] getResourceDeltas() {
		if (resourceDeltas == null)
			return null;
		if (resourceDeltas.length != resourceDeltasCounter) {
			System.arraycopy(resourceDeltas, 0,
					resourceDeltas = new IResourceDelta[resourceDeltasCounter], 0,
					resourceDeltasCounter);
		}
		return resourceDeltas;
	}

	/**
	 * Removes the child delta from the collection of affected children.
	 */
	protected void removeAffectedChild(Q7ElementDelta child) {
		int index = -1;
		if (this.affectedChildren != null) {
			for (int i = 0; i < this.affectedChildren.length; i++) {
				if (this.equalsAndSameParent(this.affectedChildren[i].getElement(),
						child.getElement())) { // handle case of two archives
												// that can be equals but not in
												// the same project
					index = i;
					break;
				}
			}
		}
		if (index >= 0) {
			this.affectedChildren = removeAndShrinkArray(this.affectedChildren, index);
		}
	}

	/**
	 * Mark this delta as a content changed delta.
	 */
	public void contentChanged() {
		this.changeFlags |= F_CONTENT;
	}

	/**
	 * Creates the nested deltas resulting from an move operation. Convenience
	 * method for creating the "move from" delta. The constructor should be used
	 * to create the root delta and then the move operation should call this
	 * method.
	 */
	public void movedFrom(IQ7Element movedFromElement, IQ7Element movedToElement) {
		Q7ElementDelta removedDelta = new Q7ElementDelta(movedFromElement);
		removedDelta.kind = REMOVED;
		removedDelta.changeFlags |= F_MOVED_TO;
		removedDelta.movedToHandle = movedToElement;
		insertDeltaTree(movedFromElement, removedDelta);
	}

	/**
	 * Creates the nested deltas resulting from an move operation. Convenience
	 * method for creating the "move to" delta. The constructor should be used
	 * to create the root delta and then the move operation should call this
	 * method.
	 */
	public void movedTo(IQ7Element movedToElement, IQ7Element movedFromElement) {
		Q7ElementDelta addedDelta = new Q7ElementDelta(movedToElement);
		addedDelta.kind = ADDED;
		addedDelta.changeFlags |= F_MOVED_FROM;
		addedDelta.movedFromHandle = movedFromElement;
		insertDeltaTree(movedToElement, addedDelta);
	}

	protected void addResourceDelta(IResource resource) {
		addResourceDelta(new ResourceChangeToNonQ7Delta(resource));
	}

	/**
	 * Adds the child delta to the collection of affected children. If the child
	 * is already in the collection, walk down the hierarchy.
	 */
	protected void addResourceDelta(IResourceDelta child) {
		switch (this.kind) {
		case ADDED:
		case REMOVED:
			// no need to add a child if this parent is added or removed
			return;
		case CHANGED:
			this.changeFlags |= F_CONTENT;
			break;
		default:
			this.kind = CHANGED;
			this.changeFlags |= F_CONTENT;
		}
		if (resourceDeltas == null) {
			resourceDeltas = new IResourceDelta[5];
			resourceDeltas[resourceDeltasCounter++] = child;
			return;
		}
		if (resourceDeltas.length == resourceDeltasCounter) {
			// need a resize
			System.arraycopy(resourceDeltas, 0,
					(resourceDeltas = new IResourceDelta[resourceDeltasCounter * 2]), 0,
					resourceDeltasCounter);
		}
		resourceDeltas[resourceDeltasCounter++] = child;
	}

	/**
	 * Returns the <code>ModelElementDelta</code> for the given element in the
	 * delta tree, or null, if no delta for the given element is found.
	 */
	protected Q7ElementDelta find(IQ7Element e) {
		if (this.equalsAndSameParent(this.changedElement, e)) { // handle case
																// of two
																// archives that
																// can be equals
																// but not in
																// the same
																// project
			return this;
		} else {
			for (int i = 0; i < this.affectedChildren.length; i++) {
				Q7ElementDelta delta = ((Q7ElementDelta) this.affectedChildren[i])
						.find(e);
				if (delta != null) {
					return delta;
				}
			}
		}
		return null;
	}

	/**
	 * Creates the nested deltas for a closed element.
	 */
	public void closed(IQ7Element element) {
		Q7ElementDelta delta = new Q7ElementDelta(element);
		delta.changed(F_CLOSED);
		insertDeltaTree(element, delta);
	}

	/**
	 * Creates the nested deltas for an opened element.
	 */
	public void opened(IQ7Element element) {
		Q7ElementDelta delta = new Q7ElementDelta(element);
		delta.changed(F_OPENED);
		insertDeltaTree(element, delta);
	}

	/**
	 * @see IQ7ElementDelta
	 */
	protected IQ7ElementDelta[] getChildrenOfType(int type) {
		int length = affectedChildren.length;
		if (length == 0) {
			return new IQ7ElementDelta[] {};
		}
		ArrayList<IQ7ElementDelta> children = new ArrayList<IQ7ElementDelta>(length);
		for (int i = 0; i < length; i++) {
			if (affectedChildren[i].getKind() == type) {
				children.add(affectedChildren[i]);
			}
		}

		IQ7ElementDelta[] childrenOfType = new IQ7ElementDelta[children.size()];
		children.toArray(childrenOfType);

		return childrenOfType;
	}

	public IQ7Element getMovedFromElement() {
		return this.movedFromHandle;
	}

	public IQ7Element getMovedToElement() {
		return movedToHandle;
	}

	@Override
	public String toString() {
		return toDebugString(0);
	}

	public String toDebugString(int depth) {
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < depth; i++) {
			buffer.append('\t');
		}
		buffer.append(((Q7Element) getElement()).toDebugString());
		toDebugString(buffer);
		IQ7ElementDelta[] children = getAffectedChildren();
		if (children != null) {
			for (int i = 0; i < children.length; ++i) {
				buffer.append("\n"); //$NON-NLS-1$
				buffer.append(((Q7ElementDelta) children[i]).toDebugString(depth + 1));
			}
		}
		for (int i = 0; i < resourceDeltasCounter; i++) {
			buffer.append("\n");//$NON-NLS-1$
			for (int j = 0; j < depth + 1; j++) {
				buffer.append('\t');
			}
			IResourceDelta resourceDelta = resourceDeltas[i];
			buffer.append(resourceDelta.toString());
			buffer.append("["); //$NON-NLS-1$
			switch (resourceDelta.getKind()) {
			case IResourceDelta.ADDED:
				buffer.append('+');
				break;
			case IResourceDelta.REMOVED:
				buffer.append('-');
				break;
			case IResourceDelta.CHANGED:
				buffer.append('*');
				break;
			default:
				buffer.append('?');
				break;
			}
			buffer.append("]"); //$NON-NLS-1$
		}
		return buffer.toString();
	}

	@Override
	protected boolean toDebugString(StringBuffer buffer, int flags) {
		boolean prev = super.toDebugString(buffer, flags);

		if ((flags & IQ7ElementDelta.F_CHILDREN) != 0) {
			if (prev)
				buffer.append(" | "); //$NON-NLS-1$
			buffer.append("CHILDREN"); //$NON-NLS-1$
			prev = true;
		}
		if ((flags & IQ7ElementDelta.F_DESCRIPTION) != 0) {
			if (prev)
				buffer.append(" | "); //$NON-NLS-1$
			buffer.append("PROJECT DESCRIPTION"); //$NON-NLS-1$
			prev = true;
		}
		if ((flags & IQ7ElementDelta.F_CONTENT) != 0) {
			if (prev)
				buffer.append(" | "); //$NON-NLS-1$
			buffer.append("CONTENT"); //$NON-NLS-1$
			prev = true;
		}
		if ((flags & IQ7ElementDelta.F_MOVED_FROM) != 0) {
			if (prev)
				buffer.append(" | "); //$NON-NLS-1$
			buffer.append("MOVED_FROM(" + ((Q7Element) getMovedFromElement()).toStringWithAncestors() + ")"); //$NON-NLS-1$ //$NON-NLS-2$
			prev = true;
		}
		if ((flags & IQ7ElementDelta.F_MOVED_TO) != 0) {
			if (prev)
				buffer.append(" | "); //$NON-NLS-1$
			buffer.append("MOVED_TO(" + ((Q7Element) getMovedToElement()).toStringWithAncestors() + ")"); //$NON-NLS-1$ //$NON-NLS-2$
			prev = true;
		}

		if ((flags & IQ7ElementDelta.F_REORDER) != 0) {
			if (prev)
				buffer.append(" | "); //$NON-NLS-1$
			buffer.append("REORDERED"); //$NON-NLS-1$
			prev = true;
		}
		if ((flags & IQ7ElementDelta.F_FINE_GRAINED) != 0) {
			if (prev)
				buffer.append(" | "); //$NON-NLS-1$
			buffer.append("FINE GRAINED"); //$NON-NLS-1$
			prev = true;
		}
		if ((flags & IQ7ElementDelta.F_PRIMARY_RESOURCE) != 0) {
			if (prev)
				buffer.append(" | "); //$NON-NLS-1$
			buffer.append("PRIMARY RESOURCE"); //$NON-NLS-1$
			prev = true;
		}
		if ((flags & IQ7ElementDelta.F_OPENED) != 0) {
			if (prev)
				buffer.append(" | "); //$NON-NLS-1$
			buffer.append("OPENED"); //$NON-NLS-1$
			prev = true;
		}
		if ((flags & IQ7ElementDelta.F_CLOSED) != 0) {
			if (prev)
				buffer.append(" | "); //$NON-NLS-1$
			buffer.append("CLOSED"); //$NON-NLS-1$
			prev = true;
		}
		return prev;
	}

	public IQ7NamedElement[] getNamedElements() {
		Set<IQ7NamedElement> namedElements = new HashSet<IQ7NamedElement>();
		IQ7ElementDelta[] deltas = getAffectedChildren();
		for (IQ7ElementDelta delta : deltas) {
			if ((delta.getFlags() & IQ7ElementDelta.F_WORKING_COPY) != 0) {
				continue; // Skip become working copy operation
			}
			IQ7Element element = delta.getElement();
			if (element instanceof IQ7NamedElement) {
				namedElements.add((IQ7NamedElement) element);
			}
			IQ7NamedElement[] elements = delta.getNamedElements();
			if (elements.length > 0) {
				namedElements.addAll(Arrays.asList(elements));
			}
		}
		return namedElements.toArray(new IQ7NamedElement[namedElements.size()]);
	}

	public IQ7ElementDelta getChildBy(IQ7NamedElement e) {
		IQ7ElementDelta[] deltas = getAffectedChildren();
		for (IQ7ElementDelta delta : deltas) {
			IQ7Element element = delta.getElement();
			if (element.equals(e)) {
				return delta;
			}
			IQ7ElementDelta childBy = delta.getChildBy(e);
			if (childBy != null) {
				return childBy;
			}
		}
		return null;
	}
}

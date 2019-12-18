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
/**
 * 
 */
package org.eclipse.rcptt.tesla.gef;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartListener;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.NodeListener;

public class EditPartChangeCollector implements EditPartListener, NodeListener {
	private Set<EditPart> added = new HashSet<EditPart>();
	private Set<EditPart> removed = new HashSet<EditPart>();

	private Set<ConnectionEditPart> connectionAdded = new HashSet<ConnectionEditPart>();
	private Set<ConnectionEditPart> connectionRemoved = new HashSet<ConnectionEditPart>();

	private Set<EditPart> associatedWith = new HashSet<EditPart>();

	public void childAdded(EditPart child, int index) {
		// Only if some parent are not in added
		EditPart e = child;
		boolean needAdd = true;
		while (e != null) {
			if (added.contains(e)) {
				needAdd = false;
			}
			e = e.getParent();
		}
		if (needAdd) {
			added.add(child);
		}
		associate(child);
	}

	public void partActivated(EditPart editpart) {
	}

	public void partDeactivated(EditPart editpart) {
	}

	public void removingChild(EditPart child, int index) {
		removed.add(child);
		deAssociate(child);
	}

	public void selectedStateChanged(EditPart editpart) {
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<EditPart> getAddedParts() {
		return new ArrayList(added);
	}

	@SuppressWarnings("rawtypes")
	public void associate(EditPart p) {
		if (!associatedWith.contains(p)) {
			associatedWith.add(p);
			p.addEditPartListener(this);
		}
		List children = p.getChildren();
		for (Object object : children) {
			if (object instanceof EditPart) {
				associate((EditPart) object);
			}
		}
		if (p instanceof GraphicalEditPart) {
			GraphicalEditPart gp = (GraphicalEditPart) p;
			gp.addNodeListener(this);
		}
	}

	@SuppressWarnings("rawtypes")
	private void deAssociate(EditPart p) {
		if (associatedWith.contains(p)) {
			associatedWith.add(p);
			p.removeEditPartListener(this);
		}
		List children = p.getChildren();
		for (Object object : children) {
			if (object instanceof EditPart) {
				deAssociate((EditPart) object);
			}
		}
		if (p instanceof GraphicalEditPart) {
			GraphicalEditPart gp = (GraphicalEditPart) p;
			gp.removeNodeListener(this);
		}
	}

	public void deAssociate() {
		while (!associatedWith.isEmpty()) {
			EditPart next = associatedWith.iterator().next();
			associatedWith.remove(next);
			deAssociate(next);
		}
	}

	public void removingSourceConnection(ConnectionEditPart connection,
			int index) {
		connectionRemoved.add(connection);
	}

	public void removingTargetConnection(ConnectionEditPart connection,
			int index) {
		connectionRemoved.add(connection);
	}

	public void sourceConnectionAdded(ConnectionEditPart connection, int index) {
		connectionAdded.add(connection);
	}

	public void targetConnectionAdded(ConnectionEditPart connection, int index) {
		connectionAdded.add(connection);
	}

	public List<ConnectionEditPart> getAddedConnections() {
		return new ArrayList<ConnectionEditPart>(connectionAdded);
	}
}
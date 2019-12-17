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
/**
 * 
 */
package org.eclipse.rcptt.tesla.core.protocol;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.rcptt.tesla.core.protocol.raw.Element;
import org.eclipse.rcptt.tesla.core.protocol.raw.Response;
import org.eclipse.rcptt.tesla.core.protocol.raw.ResponseStatus;

public class UISetSelector {
	private IUIPlayer player;
	private Element parent;
	private List<String> path;
	private List<List<String>> additionalSelections;

	public UISetSelector(IUIPlayer player) {
		this.player = player;
	}

	protected UISetSelector(UISetSelector sel) {
		this(sel.player);
		this.parent = sel.parent;
		if (sel.path != null) {
			this.path = new ArrayList<String>(sel.path);
		}
		if (sel.additionalSelections != null) {
			this.additionalSelections = new ArrayList<List<String>>(
					sel.additionalSelections);
		}
	}

	public UISetSelector parent(Element parent) {
		if (parent == null && this.parent == null) {
			return this;
		}
		UISetSelector ns = createClone();
		ns.parent = parent;
		return ns;
	}

	public UISetSelector path(String... path) {
		UISetSelector ns = createClone();
		if (path != null) {
			ns.path = Arrays.asList(path);
		} else {
			ns.path = null;
		}
		return ns;
	}

	public UISetSelector pathList(List<String> path) {
		UISetSelector ns = createClone();
		ns.path = path;
		return ns;
	}

	public UISetSelector part(String path) {
		if (path == null) {
			return this;
		}
		UISetSelector ns = createClone();
		if (ns.path == null) {
			ns.path = new ArrayList<String>();
		}
		ns.path.add(path);
		return ns;
	}

	public UISetSelector additional(String... path) {
		if (path == null || path.length == 0) {
			return this;
		}
		UISetSelector ns = createClone();
		if (ns.additionalSelections == null) {
			ns.additionalSelections = new ArrayList<List<String>>();
		}
		ns.additionalSelections.add(Arrays.asList(path));
		return ns;
	}

	public UISetSelector additionalPathList(List<String> path) {
		if (path == null || path.isEmpty()) {
			return this;
		}
		UISetSelector ns = createClone();
		if (ns.additionalSelections == null) {
			ns.additionalSelections = new ArrayList<List<String>>();
		}
		ns.additionalSelections.add(path);
		return ns;
	}

	public boolean select() {
		return select(null, null, false);
	}

	public boolean select(boolean all) {
		return select(null, null, all);
	}

	public boolean select(Integer index) {
		return select(null, index, false);
	}

	public boolean select(String pattern) {
		return select(pattern, null, false);
	}

	public boolean select(String pattern, Integer index, boolean all) {
		SetSelection sel = createSetSelection();
		initSetSelection(sel, all);

		Response executeCommand = (Response) player.safeExecuteCommand(sel);
		if (executeCommand == null) {
			return true;
		}
		if (executeCommand.getStatus().equals(ResponseStatus.FAILED)) {
			return false;
		}
		return ((BooleanResponse) executeCommand).isResult();
	}

	// for extensibility

	protected UISetSelector createClone() {
		return new UISetSelector(this);
	}

	protected SetSelection createSetSelection() {
		return ProtocolFactory.eINSTANCE.createSetSelection();
	}

	protected void initSetSelection(SetSelection sel, boolean all) {
		if (path != null) {
			sel.getPath().addAll(path);
		}
		// eclipse 3.4 compatibility:
		// EcoreUtil.copy raise exception if argument is null
		sel.setElement((parent != null) ? (Element) EcoreUtil.copy(parent)
				: null);
		EList<MultiSelectionItem> list = sel.getAdditionalItems();
		if (additionalSelections != null) {
			for (List<String> item : additionalSelections) {
				MultiSelectionItem msItem = ProtocolFactory.eINSTANCE
						.createMultiSelectionItem();
				msItem.getPath().addAll(item);
				list.add(msItem);
			}
		}
		sel.setAll(all);
	}

}
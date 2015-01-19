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
/**
 * 
 */
package org.eclipse.rcptt.tesla.core.protocol;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.rcptt.tesla.core.protocol.raw.Element;
import org.eclipse.rcptt.tesla.core.protocol.raw.Response;
import org.eclipse.rcptt.tesla.core.protocol.raw.ResponseStatus;
import org.eclipse.rcptt.tesla.internal.core.TeslaCore;

public class UISelector<T extends BasicUIElement> {

	private GenericElementKind kind;
	private IUIPlayer player;
	Element parent;
	Element after;
	private List<String> path; // Path
	private List<Integer> indexes;
	private String classPattern;
	private Class<T> caster;
	private byte[] image;


	public UISelector(ElementKind kind, IUIPlayer player, Class<T> caster) {
		this(new GenericElementKind(kind), player, caster);
	}

	public UISelector(String customKindId, IUIPlayer player, Class<T> caster) {
		this(new GenericElementKind(customKindId), player, caster);
	}

	public UISelector(GenericElementKind kind, IUIPlayer player, Class<T> caster) {
		this.kind = kind;
		this.player = player;
		this.caster = caster;
	}
	
	public Element getParent() {
		return parent;
	}

	void setCopy(UISelector<T> sel) {
		this.kind = sel.kind;
		this.player = sel.player;
		this.parent = sel.parent;
		this.after = sel.after;
		if (sel.path != null) {
			this.path = new ArrayList<String>(sel.path);
		}
		if (sel.indexes != null) {
			this.indexes = new ArrayList<Integer>(sel.indexes);
		}
		this.classPattern = sel.classPattern;
		this.caster = sel.caster;
		this.image = sel.image;
	}

	public UISelector<T> parent(Element parent) {
		if (parent == null && this.parent == null) {
			return this;
		}

		UISelector<T> ns = copy();
		ns.parent = parent;
		return ns;
	}

	public UISelector<T> classPattern(String pattern) {
		if (pattern == null && this.classPattern == null) {
			return this;
		}

		UISelector<T> ns = copy();
		ns.classPattern = pattern;
		return ns;
	}

	public UISelector<T> image(byte[] image) {
		UISelector<T> ns = copy();
		ns.image = image;
		return ns;
	}

	public UISelector<T> after(Element after) {
		Assert.isNotNull(after);
		UISelector<T> ns = copy();
		Assert.isNotNull(after);
		ns.after = after;
		return ns;
	}

	public UISelector<T> after(BasicUIElement after) {
		Assert.isNotNull(after);
		UISelector<T> ns = copy();
		Assert.isNotNull(after);
		Assert.isNotNull(after.getElement());
		ns.after = after.getElement();
		return ns;
	}

	private UISelector<T> copy() {
		UISelector<T> ns = new UISelector<T>(kind, player, caster);
		ns.setCopy(this);
		return ns;
	}

	public UISelector<T> after(UISelector<?> after) {
		UISelector<T> ns = copy();
		BasicUIElement sel = after.find();
		if (sel != null) {
			ns.after = sel.element;
		}
		return ns;
	}

	public UISelector<T> path(String... path) {
		UISelector<T> ns = copy();
		if (path != null) {
			ns.path = Arrays.asList(path);
		} else {
			ns.path = null;
		}
		return ns;
	}

	public UISelector<T> pathList(List<String> path) {
		UISelector<T> ns = copy();
		ns.path = path;
		return ns;
	}

	public UISelector<T> indexes(Integer... path) {
		UISelector<T> ns = copy();
		if (path != null) {
			ns.indexes = Arrays.asList(path);
		} else {
			ns.indexes = null;
		}
		return ns;
	}

	public UISelector<T> indexesList(List<Integer> indexes) {
		UISelector<T> ns = copy();
		ns.indexes = indexes;
		return ns;
	}

	public T find() {
		return find(null, null);
	}

	public T find(Integer index) {
		return find(null, index);
	}

	public T find(String pattern) {
		return find(pattern, null);
	}

	public T find(String pattern, Integer index) {
		SelectCommand cmd = ProtocolFactory.eINSTANCE.createSelectCommand();
		SelectData data = null;
		if (image != null) {
			IMLSelectData imageData = ProtocolFactory.eINSTANCE
					.createIMLSelectData();
			data = imageData;
			imageData.setImage(image);
		} else {
			data = ProtocolFactory.eINSTANCE.createSelectData();
		}
		cmd.setData(data);
		data.setPattern(pattern);
		if (path != null) {
			data.getPath().addAll(path);
		}
		// eclipse 3.4 compatibility:
		// EcoreUtil.copy raise exception if argument is null
		data.setParent((parent != null) ? (Element) EcoreUtil.copy(parent)
				: null);
		data.setAfter((after != null) ? (Element) EcoreUtil.copy(after) : null);
		data.setKind(kind.name());
		data.setIndex(index);
		data.setMultiplicity(1);
		data.setClassPattern(classPattern);
		if (indexes != null) {
			data.getIndexes().addAll(indexes);
		}
		Response response = player.safeExecuteCommand(cmd);
		if (response == null) { // In case of recording
			return null;
		}
		if (response instanceof SelectResponse) {
			SelectResponse selectResponse = (SelectResponse) response;
			if (selectResponse.getStatus().equals(ResponseStatus.OK)) {
				try {
					if (selectResponse.getElements().isEmpty()) {
						// TODO: May be better to throw exception here
						return null;
					}
					Constructor<T> constructor = caster.getConstructor(
							Element.class, UIPlayer.class);
					T instance = constructor.newInstance(selectResponse
							.getElements().get(0), player);
					return instance;
				} catch (Throwable e) {
					TeslaCore.log(e);
				}
			}
		}
		return null;
	}
	
	public void update(Element element) {
		UpdateControlCommand cmd = ProtocolFactory.eINSTANCE.createUpdateControlCommand();
		cmd.setElements(element);
		player.safeExecuteCommand(cmd);
	}
}
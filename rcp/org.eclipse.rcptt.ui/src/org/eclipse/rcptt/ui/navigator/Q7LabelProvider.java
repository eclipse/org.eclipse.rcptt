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
package org.eclipse.rcptt.ui.navigator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.LabelProviderChangedEvent;
import org.eclipse.rcptt.core.model.IElementChangedListener;
import org.eclipse.rcptt.core.model.IQ7Element;
import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.model.Q7ElementChangedEvent;
import org.eclipse.rcptt.core.scenario.NamedElement;
import org.eclipse.rcptt.core.workspace.RcpttCore;
import org.eclipse.rcptt.core.workspace.WorkspaceSynchronizer;
import org.eclipse.rcptt.ui.utils.ModelUtils;
import org.eclipse.rcptt.ui.utils.WorkbenchUtils;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.model.WorkbenchLabelProvider;

public class Q7LabelProvider extends LabelProvider implements
		IElementChangedListener {

	private ILabelProvider provider;
	private ProblemsLabelDecorator decorator;

	public Q7LabelProvider() {
		provider = /*
					 * WorkbenchLabelProvider.getDecoratingWorkbenchLabelProvider
					 * ()
					 */new WorkbenchLabelProvider();
		RcpttCore.addElementChangedListener(this);
		decorator = new ProblemsLabelDecorator();
	}

	@Override
	public void dispose() {
		super.dispose();
		RcpttCore.removeElementChangedListener(this);
	}

	public void elementChanged(Q7ElementChangedEvent event) {
		IQ7NamedElement[] elements = event.getDelta().getNamedElements();
		if (elements != null) {
			refresh(elements);
		}
	}

	public void markerChanged(List<NamedElement> elements) {
		final Set<IResource> elementsToRefresh = new HashSet<IResource>();

		for (NamedElement e : elements) {
			IResource file = WorkspaceSynchronizer.getFile(e.eResource());
			if (file != null) {
				// Replace all non root
				while (file.getType() != IResource.ROOT) {
					elementsToRefresh.add(file);
					file = file.getParent();
				}
			}
		}

		WorkbenchUtils.uiRun(new Runnable() {
			public void run() {
				fireLabelProviderChanged(new LabelProviderChangedEvent(
						Q7LabelProvider.this, elementsToRefresh.toArray()));
			}
		});
	}

	private void refresh(final IQ7NamedElement[] elements) {
		WorkbenchUtils.uiRun(new Runnable() {
			public void run() {
				Set<IResource> toRefresh = new HashSet<IResource>();
				for (IQ7NamedElement iq7NamedElement : elements) {
					IResource file = iq7NamedElement.getResource();
					if (file != null) {
						toRefresh.add(file);
						IResource res = file.getParent();
						while (res != null) {
							toRefresh.add(res);
							res = res.getParent();
							if (res == null) {
								break;
							}
							if (res.getType() == IResource.PROJECT) {
								break;
							}
						}
					}
				}
				if (!toRefresh.isEmpty()) {
					fireLabelProviderChanged(new LabelProviderChangedEvent(
							Q7LabelProvider.this, toRefresh.toArray()));
				}
			}
		});
	}

	@Override
	public Image getImage(Object element) {
		IQ7Element namedElement = getNamedElement(element);
		Image result = null;
		if (namedElement != null) {
			result = ModelUtils.getImage(namedElement);
		}
		if (result == null) {
			result = provider.getImage(element);
		}
		// if (result != null) {
		// return PlatformUI.getWorkbench().getDecoratorManager()
		// .decorateImage(result, element);
		// }
		if (result != null) {
			Object el = element;
			if (element instanceof NamedElement) {
				el = WorkspaceSynchronizer.getFile(((NamedElement) element)
						.eResource());
			}

			return decorator.decorateImage(result, el);
		}
		return result;
	}

	@Override
	public String getText(Object element) {
		IQ7Element namedElement = getNamedElement(element);

		if (namedElement != null) {
			return ModelUtils.getText(namedElement);
		}
		return provider.getText(element);
	}

	private IQ7Element getNamedElement(Object element) {
		if (element instanceof IFile) {
			IFile file = (IFile) element;
			try {
				return RcpttCore.create(file);
			} catch (Exception e) {
			}
		}
		return null;
	}
}

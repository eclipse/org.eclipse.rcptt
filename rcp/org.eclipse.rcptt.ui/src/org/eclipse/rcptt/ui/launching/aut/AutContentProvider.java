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
package org.eclipse.rcptt.ui.launching.aut;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.Control;

import org.eclipse.rcptt.core.Q7Features;
import org.eclipse.rcptt.core.launching.events.AutBundleState;
import org.eclipse.rcptt.internal.launching.aut.BaseAut;
import org.eclipse.rcptt.internal.launching.aut.BaseAutLaunch;
import org.eclipse.rcptt.internal.launching.aut.BaseAutManager;
import org.eclipse.rcptt.launching.Aut;
import org.eclipse.rcptt.launching.AutLaunch;
import org.eclipse.rcptt.launching.AutLaunchListener;
import org.eclipse.rcptt.launching.AutLaunchState;
import org.eclipse.rcptt.launching.AutListener;
import org.eclipse.rcptt.launching.AutManager;

public class AutContentProvider implements ITreeContentProvider, AutListener,
		AutLaunchListener {
	public static class Bundles {
		BaseAutLaunch launch;
	}

	public AutContentProvider() {
		AutManager.INSTANCE.addListener(this);
		build();
	}

	public void dispose() {
		AutManager.INSTANCE.removeListener(this);
	}

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		this.viewer = viewer;
		if (elements.size() > 0) {
			viewer.getControl().getDisplay().asyncExec(new Runnable() {
				public void run() {
					AutContentProvider.this.viewer
							.setSelection(new StructuredSelection(elements
									.get(0)));
				}
			});
		}
	}

	private Viewer viewer;

	private List<AutElement> elements = new ArrayList<AutElement>();

	public void autAdded(Aut aut) {
		refresh();
	}

	public void autRemoved(Aut aut) {
		refresh();
	}

	public void autChanged(Aut aut) {
		refresh();
	};

	public void launchAdded(AutLaunch launch) {
		refresh();
	}

	public void launchRemoved(AutLaunch launch) {
		refresh();
	}

	public void stateChanged(AutLaunch launch, AutLaunchState state) {
		refresh();
	}

	private void refresh() {
		final Control control = viewer.getControl();
		if (!control.isDisposed()) {
			control.getDisplay().asyncExec(new Runnable() {
				public void run() {
					if (!control.isDisposed()) {
						AutElement prevElement = getElement();
						build();
						viewer.refresh();
						if (prevElement != null) {
							ILaunchConfiguration config = prevElement.getAut()
									.getConfig();
							for (AutElement element : elements) {
								if (config.equals(element.getAut().getConfig())) {
									viewer.setSelection(new StructuredSelection(
											element));
									break;
								}
							}
						}
					}
				}
			});
		}
	}

	private void build() {
		for (AutElement element : elements) {
			if (element instanceof AutLaunchElement) {
				((AutLaunchElement) element).getLaunch().removeListener(this);
			}
		}
		elements.clear();
		List<Aut> auts = AutManager.INSTANCE.getAuts();
		for (Aut aut : auts) {
			List<AutLaunch> launches = aut.getLaunches();
			boolean haveLaunches = false;
			for (AutLaunch launch : launches) {
				if (launch.getState() != AutLaunchState.TERMINATE) {
					elements.add(new AutLaunchElement(launch));
					launch.addListener(this);
					haveLaunches = true;
				}
			}
			if (!haveLaunches) {
				elements.add(new AutElement(aut));
			}
		}
	}

	public Object[] getElements(Object inputElement) {
		return elements.toArray();
	}

	public Object[] getChildren(Object parentElement) {
		if (Q7Features.supportBundlesInApplications) {
			if (parentElement instanceof AutElement) {
				AutElement ale = (AutElement) parentElement;
				Aut aut = ale.getAut();
				List<Object> result = new ArrayList<Object>();
				BaseAutLaunch launch = BaseAutManager.INSTANCE.getCurrentLaunch((BaseAut) aut);
				if (launch != null) {
					List<AutBundleState> bundles = launch.getBundles();
					if (bundles != null) {
						Bundles bb = new Bundles();
						bb.launch = launch;
						result.add(bb);
					}
				}
				if (result.size() > 0) {
					return result.toArray();
				}
			}
			if (parentElement instanceof Bundles) {
				List<AutBundleState> bndls = ((Bundles) parentElement).launch.getBundles();
				return bndls != null ? bndls.toArray() : null;
			}
		}
		return null;
	}

	public Object getParent(Object element) {
		return null;
	}

	public boolean hasChildren(Object element) {
		return getChildren(element) != null;
	}

	private AutElement getElement() {
		ISelection selection = viewer.getSelection();
		if (selection instanceof IStructuredSelection) {
			Object element = ((IStructuredSelection) selection)
					.getFirstElement();
			if (element instanceof AutElement) {
				return (AutElement) element;
			}
		}
		return null;
	}

	@Override
	public void autStarted(AutLaunch baseAutLaunch, int eclPort, int teslaPort) {
		refresh();
	}

	@Override
	public void autInit(AutLaunch baseAutLaunch, List<AutBundleState> bundleState) {

	}

	@Override
	public void autLocationChange(BaseAutLaunch baseAutLaunch, String location) {
	}
}

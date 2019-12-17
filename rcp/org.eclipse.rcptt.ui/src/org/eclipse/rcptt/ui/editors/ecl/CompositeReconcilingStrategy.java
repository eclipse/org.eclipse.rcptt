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
package org.eclipse.rcptt.ui.editors.ecl;

import org.eclipse.core.runtime.IProgressMonitor;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.reconciler.DirtyRegion;
import org.eclipse.jface.text.reconciler.IReconcilingStrategy;
import org.eclipse.jface.text.reconciler.IReconcilingStrategyExtension;

public class CompositeReconcilingStrategy implements IReconcilingStrategy,
		IReconcilingStrategyExtension {

	private IReconcilingStrategy[] fStrategies;

	public CompositeReconcilingStrategy() {
	}

	public void setReconcilingStrategies(IReconcilingStrategy[] strategies) {
		fStrategies = strategies;
	}

	public IReconcilingStrategy[] getReconcilingStrategies() {
		return fStrategies;
	}

	public void setDocument(IDocument document) {
		if (fStrategies == null)
			return;

		for (int i = 0; i < fStrategies.length; i++)
			fStrategies[i].setDocument(document);
	}

	public void reconcile(DirtyRegion dirtyRegion, IRegion subRegion) {
		if (fStrategies == null)
			return;

		for (int i = 0; i < fStrategies.length; i++)
			fStrategies[i].reconcile(dirtyRegion, subRegion);
	}

	public void reconcile(IRegion partition) {
		if (fStrategies == null)
			return;

		for (int i = 0; i < fStrategies.length; i++)
			fStrategies[i].reconcile(partition);
	}

	public void setProgressMonitor(IProgressMonitor monitor) {
		if (fStrategies == null)
			return;

		for (int i = 0; i < fStrategies.length; i++) {
			if (fStrategies[i] instanceof IReconcilingStrategyExtension) {
				IReconcilingStrategyExtension extension = (IReconcilingStrategyExtension) fStrategies[i];
				extension.setProgressMonitor(monitor);
			}
		}
	}

	public void initialReconcile() {
		if (fStrategies == null)
			return;

		for (int i = 0; i < fStrategies.length; i++) {
			if (fStrategies[i] instanceof IReconcilingStrategyExtension) {
				IReconcilingStrategyExtension extension = (IReconcilingStrategyExtension) fStrategies[i];
				extension.initialReconcile();
			}
		}
	}
}

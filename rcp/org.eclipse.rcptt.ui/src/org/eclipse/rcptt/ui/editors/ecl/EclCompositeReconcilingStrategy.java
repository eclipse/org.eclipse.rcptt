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
package org.eclipse.rcptt.ui.editors.ecl;

import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.reconciler.DirtyRegion;
import org.eclipse.jface.text.reconciler.IReconcilingStrategy;

/**
 * Reconciling strategy for Java code. This is a composite strategy containing
 * the regular java model reconciler and the comment spelling strategy.
 * 
 * @since 3.0
 */
public class EclCompositeReconcilingStrategy extends
		CompositeReconcilingStrategy {

	private EclReconcilingStrategy fEclStrategy;

	/**
	 * Creates a new Java reconciling strategy.
	 * 
	 * @param viewer
	 *            the source viewer
	 * @param editor
	 *            the editor of the strategy's reconciler
	 * @param documentPartitioning
	 *            the document partitioning this strategy uses for configuration
	 */
	public EclCompositeReconcilingStrategy(EclSourceViewer viewer,
			String documentPartitioning) {
		fEclStrategy = new EclReconcilingStrategy(viewer);
		// SpellingService spellingService = EditorsUI.getSpellingService();

		setReconcilingStrategies(new IReconcilingStrategy[] { fEclStrategy
		// ,new SpellingReconcileStrategy(viewer, spellingService)
		});
	}

	@Override
	public void reconcile(DirtyRegion dirtyRegion, IRegion subRegion) {
		try {
			super.reconcile(dirtyRegion, subRegion);
		} finally {
			reconciled();
		}
	}

	@Override
	public void reconcile(IRegion partition) {
		try {
			super.reconcile(partition);
		} finally {
			reconciled();
		}
	}

	public void notifyListeners(boolean notify) {
		fEclStrategy.notifyListeners(notify);
	}

	@Override
	public void initialReconcile() {
		try {
			super.initialReconcile();
		} finally {
			reconciled();
		}
	}

	public void aboutToBeReconciled() {
		fEclStrategy.aboutToBeReconciled();

	}

	private void reconciled() {
		fEclStrategy.reconciled();
	}
}

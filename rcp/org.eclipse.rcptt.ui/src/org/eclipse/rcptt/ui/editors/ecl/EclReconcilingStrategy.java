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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.ISafeRunnable;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.SafeRunner;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.reconciler.DirtyRegion;
import org.eclipse.jface.text.reconciler.IReconcilingStrategy;
import org.eclipse.jface.text.reconciler.IReconcilingStrategyExtension;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.ui.texteditor.MarkerAnnotation;

import org.eclipse.rcptt.core.builder.IQ7ProblemReporter;
import org.eclipse.rcptt.core.builder.IQ7Validator;
import org.eclipse.rcptt.core.internal.builder.Q7Builder;
import org.eclipse.rcptt.core.internal.builder.Q7Problem;
import org.eclipse.rcptt.core.internal.builder.Q7ValidatorManager;
import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.internal.ui.Q7UIPlugin;

public class EclReconcilingStrategy implements IReconcilingStrategy,
		IReconcilingStrategyExtension {

	private IProgressMonitor fProgressMonitor;
	private boolean fNotify = true;

	private IEclReconcilingListener eclReconcilingListener;

	private EclSourceViewer viewer;
	private IQ7Validator[] validators;

	private final String ERROR_ANNOTATION_TYPE = "org.eclipse.rcptt.editor.q7error";
	private final String WARNING_ANNOTATION_TYPE = "org.eclipse.rcptt.editor.q7warning";

	public EclReconcilingStrategy(EclSourceViewer viewer) {
		this.viewer = viewer;
		validators = new Q7ValidatorManager().getExtensions();
	}

	public void setEclReconcilingListener(
			IEclReconcilingListener eclReconcilingListener) {
		this.eclReconcilingListener = eclReconcilingListener;
	}

	private void reconcile(final boolean initialReconcile) {
		// final IQ7NamedElement model = fEditor.getModel();
		// if (model != null) {
		SafeRunner.run(new ISafeRunnable() {
			public void run() {
				reconcile(viewer.getElement(), initialReconcile);
			}

			public void handleException(Throwable ex) {
				IStatus status = new Status(IStatus.ERROR,
						Q7UIPlugin.PLUGIN_ID, IStatus.OK, "Error in RCPTT during reconcile", ex); //$NON-NLS-1$
				Q7UIPlugin.getDefault().getLog().log(status);
			}
		});
		// }
	}

	@SuppressWarnings("rawtypes")
	private void reconcile(IQ7NamedElement unit, boolean initialReconcile) {
		final List<Q7Problem> problems = new ArrayList<Q7Problem>();
		IQ7ProblemReporter reporter = new IQ7ProblemReporter() {
			public void reportProblem(IFile element, ProblemType type,
					String message, int line, int offset, int length, int sourceId) {
				problems.add(new Q7Problem(message, line, offset, type
						.getValue(), length, sourceId));
			}
		};
		for (IQ7Validator validator : validators) {
			validator.reconcile(unit, viewer.getDocument().get(), reporter,
					new NullProgressMonitor());
		}

		IAnnotationModel annotationModel = viewer.getAnnotationModel();
		List<Annotation> toRemove = new ArrayList<Annotation>();
		Iterator iterator = annotationModel.getAnnotationIterator();
		while (iterator.hasNext()) {
			Annotation annotation = (Annotation) iterator.next();
			if (annotation instanceof MarkerAnnotation) {
				try {
					String type = ((MarkerAnnotation) annotation).getMarker()
							.getType();
					if (Q7Builder.MARKER_TYPE.equals(type)) {
						toRemove.add(annotation);
					}
				} catch (CoreException e) {
					Q7UIPlugin.log(e);
				}
			}
			if (annotation instanceof EclProblemAnnotation) {
				toRemove.add(annotation);
			}
		}
		for (Annotation annotation : toRemove) {
			annotationModel.removeAnnotation(annotation);
		}

		for (Q7Problem q7Problem : problems) {
			String annotationType = null;
			switch (q7Problem.getSeverity()) {
			case IMarker.SEVERITY_ERROR:
				annotationType = ERROR_ANNOTATION_TYPE;
				break;
			case IMarker.SEVERITY_WARNING:
				annotationType = WARNING_ANNOTATION_TYPE;
				break;
			}

			EclProblemAnnotation pr = new EclProblemAnnotation(annotationType, q7Problem);
			annotationModel.addAnnotation(pr, new Position(q7Problem.getOffset(), q7Problem.getLength()));
		}

		viewer.clearElementContainer();

	}

	public void reconcile(IRegion partition) {
		reconcile(false);
	}

	public void reconcile(DirtyRegion dirtyRegion, IRegion subRegion) {
		reconcile(false);
	}

	public void setDocument(IDocument document) {
	}

	public void setProgressMonitor(IProgressMonitor monitor) {
		fProgressMonitor = monitor;
	}

	public void initialReconcile() {
		reconcile(true);
	}

	public void notifyListeners(boolean notify) {
		fNotify = notify;
	}

	public void aboutToBeReconciled() {
		eclReconcilingListener.aboutToBeReconciled();
	}

	public void reconciled() {
		try {
			IProgressMonitor pm = fProgressMonitor;
			if (pm == null)
				pm = new NullProgressMonitor();
			if (eclReconcilingListener != null) {
				eclReconcilingListener.reconciled(null, !fNotify, pm);
			}
		} finally {
			fNotify = true;
		}
	}
}

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
package org.eclipse.rcptt.ui.refactoring.delete;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.widgets.Display;

import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.scenario.NamedElement;
import org.eclipse.rcptt.core.tags.Tag;
import org.eclipse.rcptt.core.tags.TagsRegistry;
import org.eclipse.rcptt.internal.ui.Messages;
import org.eclipse.rcptt.internal.ui.Q7UIPlugin;
import org.eclipse.rcptt.ui.editors.INamedElementEditor;
import org.eclipse.rcptt.ui.refactoring.RefactoringUtils;
import org.eclipse.rcptt.ui.utils.ModelUtils;

final public class DeleteTagReferenceChange extends Change {

	private final IQ7NamedElement element;
	private final Tag tag;

	public DeleteTagReferenceChange(IQ7NamedElement element, Tag tag) {
		Assert.isNotNull(element);
		Assert.isNotNull(tag);
		this.element = element;
		this.tag = tag;
	}

	@Override
	public String getName() {
		if (tag.getPath().equals(tag.getValue())) {
			return NLS.bind(
					Messages.DeleteTagReferenceChange_Name,
					new Object[] { tag.getValue(),
							RefactoringUtils.elementToString(element) });
		}
		return NLS.bind(
				Messages.DeleteTagReferenceChange_Name_Sub,
				new Object[] { tag.getValue(),
						RefactoringUtils.elementToString(element) });
	}

	@Override
	public Change perform(IProgressMonitor pm) throws CoreException {
		try {
			pm.beginTask(getName(), 1);
			final INamedElementEditor editor = ModelUtils.findEditor(element);
			boolean isDirtyInEditor = false;
			if (editor != null && editor.isDirty()) {
				isDirtyInEditor = true;
			}
			String tags = element.getTags();
			NamedElement modifiedNamedElement = element
					.getModifiedNamedElement();
			if (modifiedNamedElement != null) {
				tags = modifiedNamedElement.getTags();
			}
			String path = tag.getPath();
			String replaceStr = ""; //$NON-NLS-1$
			String newTags;
			if (tag.getValue().equals(path)) {
				// Remove whole tag
				newTags = tags.replaceAll(",\\s*" + path, replaceStr); //$NON-NLS-1$
				newTags = newTags.replaceAll(path + "\\s*,\\s*", replaceStr); //$NON-NLS-1$
				newTags = newTags
						.replaceAll("\\s*" + path + "\\s*", replaceStr); //$NON-NLS-1$ //$NON-NLS-2$
			} else {
				// Remove segment of tag
				replaceStr = path.substring(0, path.length()
						- tag.getValue().length() - 1);
				newTags = tags.replaceAll(path, replaceStr);
			}
			IQ7NamedElement elementWc = element.getWorkingCopy(pm);
			try {
				if (editor != null) {
					editor.setTags(newTags);
					final IProgressMonitor monitor = pm;
					Display.getDefault().syncExec(new Runnable() {
						public void run() {
							editor.doSave(monitor);
						}
					});
				} else {
					elementWc.setTags(newTags);
				}
				if (!isDirtyInEditor) {
					if (editor != null) {
						final IProgressMonitor monitor = pm;
						Display.getDefault().syncExec(new Runnable() {
							public void run() {
								editor.doSave(monitor);
							}
						});
					} else {
						elementWc.commitWorkingCopy(true, pm);
					}
				}
			} catch (Exception e) {
				Q7UIPlugin.log(e);
			} finally {
				elementWc.discardWorkingCopy();
			}
			return new UndoDeleteTagReferenceChange(element, tag, tags);
		} finally {
			pm.done();
		}
	}

	@Override
	public RefactoringStatus isValid(IProgressMonitor pm) throws CoreException,
			OperationCanceledException {
		synchronized (tag) {
			if (!tag.getRefs().contains(element)) {
				return RefactoringStatus.createErrorStatus(NLS.bind(
						Messages.DeleteTagReferenceChange_NoTagMsg,
						RefactoringUtils.elementToString(element),
						tag.getPath()));
			}
		}
		return new RefactoringStatus();
	}

	@Override
	public Object getModifiedElement() {
		return element;
	}

	@Override
	public void initializeValidationData(IProgressMonitor pm) {
		// Nothing
	}

	final static private class UndoDeleteTagReferenceChange extends Change {

		private final IQ7NamedElement element;
		private final Tag tag;
		private final String elementTags;

		public UndoDeleteTagReferenceChange(IQ7NamedElement element, Tag tag,
				String elementTags) {
			Assert.isNotNull(element);
			Assert.isNotNull(tag);
			this.element = element;
			this.tag = tag;
			this.elementTags = elementTags;
		}

		@Override
		public String getName() {
			return NLS.bind(
					Messages.DeleteTagReferenceChange_UndoName,
					new Object[] { tag.getPath(),
							RefactoringUtils.elementToString(element) });
		}

		@Override
		public Change perform(IProgressMonitor pm) throws CoreException {
			try {
				pm.beginTask(getName(), 1);
				final INamedElementEditor editor = ModelUtils
						.findEditor(element);
				boolean isDirtyInEditor = false;
				if (editor != null && editor.isDirty()) {
					isDirtyInEditor = true;
				}
				IQ7NamedElement elementWc = element.getWorkingCopy(pm);
				try {
					elementWc.setTags(elementTags);
					if (!isDirtyInEditor) {
						if (editor != null) {
							final IProgressMonitor monitor = pm;
							Display.getDefault().syncExec(new Runnable() {
								public void run() {
									editor.doSave(monitor);
								}
							});
						} else {
							elementWc.commitWorkingCopy(true, pm);
						}
					}
				} catch (Exception e) {
					Q7UIPlugin.log(e);
				} finally {
					elementWc.discardWorkingCopy();
				}
				// Search restored tag
				Tag restoredTag = tag;
				TagsRegistry registry = Q7UIPlugin.getDefault().getTags();
				synchronized (registry) {
					for (Tag currentTag : registry.getTags()) {
						if (currentTag.getPath().equals(tag.getPath())) {
							restoredTag = currentTag;
							break;
						}
					}
				}
				return new DeleteTagReferenceChange(element, restoredTag);
			} finally {
				pm.done();
			}
		}

		@Override
		public RefactoringStatus isValid(IProgressMonitor pm)
				throws CoreException, OperationCanceledException {
			synchronized (tag) {
				if (tag.getRefs().contains(element)) {
					return RefactoringStatus.createErrorStatus(NLS.bind(
							Messages.DeleteTagReferenceChange_9,
							RefactoringUtils.elementToString(element),
							tag.getPath()));
				}
			}
			return new RefactoringStatus();
		}

		@Override
		public Object getModifiedElement() {
			return element;
		}

		@Override
		public void initializeValidationData(IProgressMonitor pm) {
			// Nothing
		}

	}
}

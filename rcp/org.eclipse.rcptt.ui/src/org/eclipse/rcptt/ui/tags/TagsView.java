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
package org.eclipse.rcptt.ui.tags;

import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.MultiList;
import org.eclipse.core.databinding.observable.masterdetail.IObservableFactory;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.databinding.EObjectObservableList;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.databinding.viewers.ObservableListTreeContentProvider;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.ui.progress.UIJob;

import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.tags.Tag;
import org.eclipse.rcptt.core.tags.TagsPackage;
import org.eclipse.rcptt.core.tags.TagsRegistry;
import org.eclipse.rcptt.core.utils.TagsUtil;
import org.eclipse.rcptt.internal.ui.Images;
import org.eclipse.rcptt.internal.ui.Messages;
import org.eclipse.rcptt.internal.ui.Q7UIPlugin;
import org.eclipse.rcptt.ui.actions.RenameAction;
import org.eclipse.rcptt.ui.actions.edit.DeleteAction;
import org.eclipse.rcptt.ui.launching.LaunchUtils;
import org.eclipse.rcptt.ui.utils.ModelUtils;

public class TagsView extends ViewPart {

	private IObservableList tags;
	private EContentAdapter tagsLabelListener;

	private TreeViewer tagsViewer;

	private RenameAction renameAction;
	private DeleteAction deleteAction;
	private IAction replayAction;
	private IAction refreshAction;

	@Override
	public void createPartControl(Composite parent) {
		final Composite panel = new Composite(parent, SWT.NONE);
		panel.setLayout(new FillLayout());

		tagsViewer = new TreeViewer(panel);
		tagsViewer.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				updateSelection((IStructuredSelection) event.getSelection());
			}
		});

		ObservableListTreeContentProvider contentProvider = new ObservableListTreeContentProvider(
				new IObservableFactory() {

					public IObservable createObservable(Object target) {
						if (target instanceof IObservable) {
							return (IObservable) target;
						} else if (target instanceof Tag) {
							final Tag tag = (Tag) target;
							final IObservableList tags = new EObjectObservableList(
									tag, TagsPackage.Literals.TAG__TAGS);
							final IObservableList refs = new EObjectObservableList(
									tag, TagsPackage.Literals.TAG__REFS);
							return new MultiList(new IObservableList[] { tags,
									refs });
						} else {
							return null;
						}
					}
				}, null);
		tagsViewer.setContentProvider(contentProvider);

		createActions();

		tagsViewer.setLabelProvider(new LabelProvider() {

			@Override
			public Image getImage(Object element) {
				if (element instanceof Tag) {
					return Images.getImage(Images.TAG);
				} else if (element instanceof IQ7NamedElement) {
					return ModelUtils.getImage((IQ7NamedElement) element);
				}
				return null;
			}

			@Override
			public String getText(Object element) {
				if (element instanceof Tag) {
					final Tag tag = (Tag) element;
					final String value = tag.getValue().trim();
					if (value.length() == 0) {
						return Messages.bind(
								Messages.TagsView_UntaggedLabelFormat,
								TagsUtil.getDistinctTagRefsCount(tag));
					} else {
						return Messages.bind(Messages.TagsView_TagLabelFormat,
								value, TagsUtil.getDistinctTagRefsCount(tag));
					}
				} else if (element instanceof IQ7NamedElement) {
					return ModelUtils.getText((IQ7NamedElement) element);
				} else {
					return element != null ? element.toString() : "null"; //$NON-NLS-1$
				}
			}
		});

		MenuManager menuManager = new MenuManager();
		fillMenu(menuManager);
		tagsViewer.getControl().setMenu(
				menuManager.createContextMenu(tagsViewer.getControl()));

		fillToolbar(getViewSite().getActionBars().getToolBarManager());

		tagsViewer.addDoubleClickListener(new IDoubleClickListener() {

			public void doubleClick(DoubleClickEvent event) {
				final IStructuredSelection iss = (IStructuredSelection) tagsViewer
						.getSelection();
				final Object element = iss.getFirstElement();
				if (element instanceof IQ7NamedElement) {
					IQ7NamedElement q7Element = (IQ7NamedElement) element;
					final IWorkbenchPage activePage = PlatformUI.getWorkbench()
							.getActiveWorkbenchWindow().getActivePage();
					if (activePage != null) {
						try {
							IDE.openEditor(activePage,
									(IFile) q7Element.getResource());
						} catch (PartInitException e) {
							Q7UIPlugin.log(e);
						}
					}
				}
			}
		});
		Job setInputJob = new UIJob(tagsViewer.getControl().getDisplay(),
				"Initialize tags view") {
			@Override
			public IStatus runInUIThread(IProgressMonitor monitor) {
				final TagsRegistry tagsRegistry = Q7UIPlugin.getDefault()
						.getTags();
				tagsLabelListener = new EContentAdapter() {
					@Override
					public void notifyChanged(final Notification notification) {
						super.notifyChanged(notification);
						if (notification.getFeature() == TagsPackage.Literals.TAG__REFS
								|| notification.getFeature() == TagsPackage.Literals.TAG__VALUE
								|| notification.getFeature() == TagsPackage.Literals.TAG__TAGS) {
							Q7UIPlugin.asyncExec(new Runnable() {
								public void run() {
									if (!tagsViewer.getControl().isDisposed()) {
										Object parent = notification
												.getNotifier();
										while (parent instanceof Tag) {
											tagsViewer.refresh(parent, true);
											parent = TagsUtil
													.getParentTag((Tag) parent);
										}
									}
								}
							});
						}
					}
				};
				synchronized (tagsRegistry) {
					tagsRegistry.eAdapters().add(tagsLabelListener);
				}

				tagsViewer.setSorter(new ViewerSorter());
				tags = EMFObservables.observeList(tagsRegistry,
						TagsPackage.Literals.TAGS_REGISTRY__TAGS);
				tagsViewer.setInput(tags);
				return Status.OK_STATUS;
			}
		};
		setInputJob.schedule();
	}

	private void updateSelection(IStructuredSelection selection) {
		if (renameAction != null)
			renameAction.selectionChanged(selection);
		if (deleteAction != null)
			deleteAction.selectionChanged(selection);
	}

	private void createActions() {
		replayAction = new Action(Messages.TagsView_ReplayActionName,
				Images.getImageDescriptor(Images.PLAY)) {
			@Override
			public void run() {
				LaunchUtils.launchContext(
						LaunchUtils.getContext(tagsViewer.getSelection()),
						"run"); //$NON-NLS-1$
			}
		};
		renameAction = new RenameAction(getSite(), tagsViewer.getTree());
		deleteAction = new DeleteAction(getSite());

		refreshAction = new Action(Messages.TagsView_RefreshActionName,
				Images.getImageDescriptor(Images.REFRESH)) {
			@Override
			public void run() {
				final Object element = ((IStructuredSelection) tagsViewer
						.getSelection()).getFirstElement();
				tagsViewer.refresh(element, true);
			}
		};
	}

	private void fillMenu(IMenuManager manager) {
		manager.add(replayAction);
		manager.add(new Separator());
		manager.add(renameAction);
		manager.add(deleteAction);
		manager.add(new Separator());
		manager.add(refreshAction);
	}

	private void fillToolbar(IToolBarManager manager) {
		manager.add(replayAction);
		manager.add(deleteAction);
		manager.add(refreshAction);
	}

	@Override
	public void setFocus() {
		tagsViewer.getControl().setFocus();
	}

	@Override
	public void dispose() {
		super.dispose();
		TagsRegistry registry = Q7UIPlugin.getDefault().getTags();
		synchronized (registry) {
			registry.eAdapters().remove(tagsLabelListener);
		}
		if (tags != null) {
			tags.dispose();
		}
	}
}

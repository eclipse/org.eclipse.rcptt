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
package org.eclipse.rcptt.ui.editors;

import org.eclipse.core.databinding.Binding;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.jface.text.TextViewer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.rcptt.core.model.IQ7NamedElement;
import org.eclipse.rcptt.core.model.ITestCase;
import org.eclipse.rcptt.core.model.ModelException;
import org.eclipse.rcptt.core.scenario.NamedElement;
import org.eclipse.rcptt.core.scenario.ScenarioPackage;
import org.eclipse.rcptt.internal.core.RcpttPlugin;
import org.eclipse.rcptt.internal.ui.Messages;
import org.eclipse.rcptt.internal.ui.Q7UIPlugin;
import org.eclipse.rcptt.ui.controls.ContextsTable;
import org.eclipse.rcptt.ui.controls.DescriptionComposite;
import org.eclipse.rcptt.ui.controls.SectionWithToolbar;
import org.eclipse.rcptt.ui.controls.VerificationsTable;
import org.eclipse.rcptt.ui.editors.NamedElementEditorActions.INamedElementActions;
import org.eclipse.rcptt.ui.editors.ecl.EclSourceViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.program.Program;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.events.IHyperlinkListener;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Hyperlink;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.views.properties.IPropertySource;

public class EditorContent implements INamedElementActions {

	private final EditorHeader header;
	private final IPropertySource scenarioPropertySource;

	private ScriptSection script;
	private EclSourceViewer viewer;

	private Section contextSection;
	private ContextsTable contextTable;

	private Section descriptionSection;

	private StyledText externalRefControl;
	private boolean scenarioEditor;
	private final boolean supportRefs;

	private VerificationsTable verificationsTable;
	private Section verificationsSection;

	// private StyledText descriptionControl;

	public EditorContent(EditorHeader header, boolean refs, boolean scenario) {
		this.header = header;
		this.scenarioPropertySource = createPropertySource();
		this.supportRefs = refs;
		this.scenarioEditor = scenario;
	}

	public ScriptSection getScriptSection() {
		return script;
	}

	public Section getVerificationsSection() {
		return verificationsSection;
	}

	public ITestCase getModel() {
		return (ITestCase) header.getModel();
	}

	public NamedElement getElement() {
		return header.getElement();
	}

	public void createSections(Composite parent, final FormToolkit toolkit) {
		descriptionComposite = new DescriptionComposite(getElement()) {
			@Override
			public void createControl(Composite parent) {
				super.createControl(parent);
				if (supportRefs) {
					createExternalReferenceControl((Composite) getControl(),
							toolkit);
				}
			}
		};
		descriptionSection = new SectionWithToolbar(descriptionComposite,
				Section.TITLE_BAR | Section.TWISTIE | getDescriptionFlags())
				.create(parent, toolkit);
		// descriptionControl = descriptionComposite.getDescriptionControl();
		// TextViewer descrViewer = descriptionComposite.getDescriptionViewer();
		if (supportRefs) {
			try {
				contextTable = new ContextsTable(getModel());
			} catch (ModelException e) {
				Q7UIPlugin.log(e);
			}
			contextSection = new SectionWithToolbar(contextTable,
					Section.TITLE_BAR | Section.TWISTIE)
					.create(parent, toolkit);
		}

		if (scenarioEditor) {
			script = new ScriptSection();
			script.create(parent, toolkit);
		}

		if (supportRefs) {
			try {
				verificationsTable = new VerificationsTable(getModel());
			} catch (ModelException e) {
				Q7UIPlugin.log(e);
			}

			verificationsSection = new SectionWithToolbar(verificationsTable,
					Section.TITLE_BAR | Section.TWISTIE)
					.create(parent, toolkit);
		}
	}

	protected int getDescriptionFlags() {
		return 0;
	}

	public void setViewer(EclSourceViewer viewer) {
		this.viewer = viewer;
	}

	public void setSelectionProvider(IWorkbenchPartSite site) {
		site.setSelectionProvider(new ISelectionProvider() {
			public void setSelection(ISelection selection) {
			}

			public void removeSelectionChangedListener(
					ISelectionChangedListener listener) {
			}

			public ISelection getSelection() {
				if (scenarioPropertySource != null) {
					return new StructuredSelection(scenarioPropertySource);
				}
				return StructuredSelection.EMPTY;
			}

			public void addSelectionChangedListener(
					ISelectionChangedListener listener) {
			}
		});
	}

	public void showSearchMatch(int scenarioPart, int offset, int length) {
		final int SCRIPT = 0;
		final int DESCRIPTION = 1;
		final int TAGS = 2;
		final int CONTEXTS = 3;

		if (scenarioPart == SCRIPT) {
			if (!script.getSection().isExpanded()) {
				script.getSection().setExpanded(true);
			}
			if (viewer != null) {
				viewer.getTextWidget().setFocus();
				viewer.revealRange(offset, length);
				viewer.setSelectedRange(offset, length);
			}
		} else if (scenarioPart == DESCRIPTION) {
			if (!descriptionSection.isExpanded()) {
				descriptionSection.setExpanded(true);
			}
			descriptionComposite.getDescriptionControl().setFocus();
			descriptionComposite.getDescriptionControl().setSelection(offset,
					offset + length);
		} else if (scenarioPart == TAGS) {
			StyledText tagsControl = header.getTagsControl();
			tagsControl.setFocus();
			tagsControl.setSelection(offset, offset + length);
		} else if (scenarioPart == CONTEXTS) {
			if (contextSection != null) {
				if (!contextSection.isExpanded()) {
					contextSection.setExpanded(true);
				}
			}
		}
	}

	private void createExternalReferenceControl(Composite parent,
			FormToolkit toolkit) {
		Composite composite = toolkit.createComposite(parent);
		GridLayoutFactory.fillDefaults().numColumns(2).applyTo(composite);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.CENTER)
				.grab(true, false).span(2, 1).applyTo(composite);

		final Hyperlink externalRefLabel = toolkit.createHyperlink(composite,
				Messages.ScenarioEditorPage_ExternalReferenceLabel, SWT.NONE);
		GridDataFactory.fillDefaults().align(SWT.LEFT, SWT.CENTER)
				.applyTo(externalRefLabel);
		externalRefLabel.setToolTipText(EXT_REF_TOOLTIP);
		externalRefLabel.setUnderlined(true);
		externalRefControl = new StyledText(composite, SWT.BORDER | SWT.SINGLE
				| toolkit.getBorderStyle() | toolkit.getOrientation());
		toolkit.adapt(externalRefControl);
		externalRefControl.setToolTipText(EXT_REF_TOOLTIP);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.CENTER)
				.grab(true, false).applyTo(externalRefControl);

		externalRefControl.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent e) {
				externalRefLabel.setEnabled(!"".equals(externalRefControl //$NON-NLS-1$
						.getText().trim()));
			}
		});
		externalRefLabel.addHyperlinkListener(new IHyperlinkListener() {

			public void linkExited(HyperlinkEvent e) {
			}

			public void linkEntered(HyperlinkEvent e) {
			}

			public void linkActivated(HyperlinkEvent e) {
				if (!"".equals(externalRefControl.getText().trim())) { //$NON-NLS-1$
					Program.launch(externalRefControl.getText());
				}
			}
		});

		update(this.getModel(), getElement());

	}

	private IPropertySource createPropertySource() {
		IPropertySourceFactory factory = getPropertySourceFactory();
		if (factory != null) {
			return factory.createPropertySource(getElement());
		}
		return null;
	}

	private static final String EXT_REF_TOOLTIP = Messages.ScenarioEditorPage_ExternalReferenceToolTip;

	private static final String SCENARIO_EDITOR_PAGES_EXTENSION_POINT_ID = Q7UIPlugin.PLUGIN_ID
			+ ".scenarioPropertySource"; //$NON-NLS-1$

	private static IPropertySourceFactory[] PROPERTY_SOURCE_FACTORY;
	private DescriptionComposite descriptionComposite;
	private Binding externalRefBinding;

	private static IPropertySourceFactory getPropertySourceFactory() {
		if (PROPERTY_SOURCE_FACTORY == null) {
			PROPERTY_SOURCE_FACTORY = new IPropertySourceFactory[1];
			IExtensionPoint wizard = Platform
					.getExtensionRegistry()
					.getExtensionPoint(SCENARIO_EDITOR_PAGES_EXTENSION_POINT_ID);
			if (wizard != null) {
				IConfigurationElement[] elements = wizard
						.getConfigurationElements();
				for (IConfigurationElement element : elements) {
					try {
						PROPERTY_SOURCE_FACTORY[0] = (IPropertySourceFactory) element
								.createExecutableExtension("class"); //$NON-NLS-1$
						break;
					} catch (Throwable e) {
						RcpttPlugin.log(e);
					}
				}
			}
		}
		return PROPERTY_SOURCE_FACTORY[0];
	}

	public void gotoMarker(IMarker marker) {
		try {
			Object lineObj = marker.getAttribute(IMarker.LINE_NUMBER);
			if (lineObj instanceof Integer) {
				int line = (Integer) lineObj;
				if (!script.getSection().isExpanded()) {
					script.getSection().setExpanded(true);
				}
				if (viewer != null) {
					viewer.getTextWidget().setFocus();
					IRegion region = viewer.getDocument().getLineInformation(
							line - 1);
					viewer.setSelection(new TextSelection(region.getOffset(),
							region.getLength()), true);
				}
			}
		} catch (Exception e) {
			Q7UIPlugin.log(e);
		}
	}

	public boolean isInFocus() {
		return descriptionComposite.getDescriptionControl().isFocusControl()
				|| (externalRefControl != null && externalRefControl
						.isFocusControl())
				|| (contextTable != null && contextTable.getControl()
						.isFocusControl()) || header.isInFocus();
	}

	public void doSelectAll() {
		if (descriptionComposite.getDescriptionControl().isFocusControl()) {
			descriptionComposite.getDescriptionControl().selectAll();
		} else if (externalRefControl.isFocusControl()) {
			externalRefControl.selectAll();
		} else if (contextTable != null
				&& contextTable.getControl().isFocusControl()) {
			((Table) contextTable.getControl()).selectAll();
		}
	}

	public void copy() {
		if (descriptionComposite.getDescriptionControl().isFocusControl()) {
			TextUtils.copy(descriptionComposite.getDescriptionControl());
		} else if (externalRefControl != null
				&& externalRefControl.isFocusControl()) {
			TextUtils.copy(externalRefControl);
		} else if (contextTable != null
				&& contextTable.getControl().isFocusControl()) {
			if (contextTable.canCopy()) {
				contextTable.copy();
			}
		}
		else if (header.isInFocus()) {
			header.copy();
		}
	}

	public boolean canCopy() {
		if (descriptionComposite.getDescriptionControl().isFocusControl()) {
			return TextUtils.canCopy(descriptionComposite
					.getDescriptionControl());
		} else if (externalRefControl != null
				&& externalRefControl.isFocusControl()) {
			return TextUtils.canCopy(externalRefControl);
		} else if (contextTable != null
				&& contextTable.getControl().isFocusControl()) {
			return contextTable.canCopy();
		}
		else if (header.isInFocus()) {
			return header.canCopy();
		}
		return false;
	}

	public boolean canPaste() {
		if (descriptionComposite.getDescriptionControl().isFocusControl()) {
			return TextUtils.canPaste(descriptionComposite
					.getDescriptionControl());
		} else if (externalRefControl != null
				&& externalRefControl.isFocusControl()) {
			return TextUtils.canPaste(externalRefControl);
		} else if (contextTable != null
				&& contextTable.getControl().isFocusControl()) {
			return contextTable.canPaste();
		}
		else if (header.isInFocus()) {
			return header.canPaste();
		}
		return false;
	}

	public boolean canCut() {
		if (descriptionComposite.getDescriptionControl().isFocusControl()) {
			return TextUtils.canCut(descriptionComposite
					.getDescriptionControl());
		} else if (externalRefControl != null
				&& externalRefControl.isFocusControl()) {
			return TextUtils.canCut(externalRefControl);
		} else if (contextTable != null
				&& contextTable.getControl().isFocusControl()) {
			return contextTable.canCut();
		}
		else if (header.isInFocus()) {
			return header.canCut();
		}
		return false;
	}

	public void paste() {
		if (descriptionComposite.getDescriptionControl().isFocusControl()) {
			TextUtils.paste(descriptionComposite.getDescriptionControl());
		} else if (externalRefControl != null
				&& externalRefControl.isFocusControl()) {
			TextUtils.paste(externalRefControl);
		} else if (contextTable != null
				&& contextTable.getControl().isFocusControl()) {
			if (contextTable.canPaste()) {
				contextTable.paste();
			}
		}
		else if (header.isInFocus()) {
			header.paste();
		}
	}

	public void cut() {
		if (descriptionComposite.getDescriptionControl().isFocusControl()) {
			TextUtils.cut(descriptionComposite.getDescriptionControl());
		} else if (externalRefControl != null
				&& externalRefControl.isFocusControl()) {
			TextUtils.cut(externalRefControl);
		} else if (contextTable != null
				&& contextTable.getControl().isFocusControl()) {
			if (contextTable.canCut()) {
				contextTable.cut();
			}
		}
		else if (header.isInFocus()) {
			header.cut();
		}
	}

	public void update(IQ7NamedElement model, NamedElement element) {
		if (externalRefBinding != null) {
			externalRefBinding.dispose();
		}
		if (externalRefControl != null) {
			externalRefBinding = header
					.getDataBindingContext()
					.bindValue(
							SWTObservables.observeText(externalRefControl,
									SWT.Modify),
							EMFProperties
									.value(ScenarioPackage.Literals.SCENARIO__EXTERNAL_REFERENCE)
									.observe(getElement()));
		}
		descriptionComposite.update(element);
		if (contextTable != null) {
			contextTable.update(element);
		}
		if (verificationsTable != null) {
			verificationsTable.update(element);
		}
	}

	public void doTextCommand(int fAction) {
		if (descriptionComposite.getDescriptionControl().isFocusControl()) {
			descriptionComposite.getDescriptionControl().invokeAction(fAction);
		} else if (externalRefControl != null && externalRefControl.isFocusControl()) {
			externalRefControl.invokeAction(fAction);
		}
	}

	public TextViewer getTextViewer() {
		if (descriptionComposite.getDescriptionControl().isFocusControl()) {
			return descriptionComposite.getDescriptionViewer();
		}
		return null;
	}

	public boolean canUndo() {
		if (descriptionComposite.getDescriptionControl().isFocusControl()) {
			return descriptionComposite.canUndo();
		} else if (externalRefControl != null
				&& externalRefControl.isFocusControl()) {
		}
		return false;
	}

	public boolean canRedo() {
		if (descriptionComposite.getDescriptionControl().isFocusControl()) {
			return descriptionComposite.canRedo();
		} else if (externalRefControl != null
				&& externalRefControl.isFocusControl()) {
		}
		return false;
	}

	public void undo() {
		if (descriptionComposite.getDescriptionControl().isFocusControl()) {
			descriptionComposite.undo();
		} else if (externalRefControl != null
				&& externalRefControl.isFocusControl()) {
		}
	}

	public void redo() {
		if (descriptionComposite.getDescriptionControl().isFocusControl()) {
			descriptionComposite.redo();
		} else if (externalRefControl != null
				&& externalRefControl.isFocusControl()) {
		}
	}
}

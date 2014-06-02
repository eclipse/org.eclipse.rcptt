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
package org.eclipse.rcptt.ui.preferences;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.ControlListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.events.ExpansionEvent;
import org.eclipse.ui.forms.events.IExpansionListener;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;

import org.eclipse.rcptt.core.Q7Features;
import org.eclipse.rcptt.internal.core.RcpttPlugin;
import org.eclipse.rcptt.internal.ui.Messages;
import org.eclipse.rcptt.tesla.core.TeslaFeatures;
import org.eclipse.rcptt.tesla.core.utils.AbstractFeatureManager;
import org.eclipse.rcptt.tesla.core.utils.AbstractFeatureManager.Option;
import org.eclipse.rcptt.tesla.internal.core.TeslaCore;

public class FeaturesComposite {
	private Map<Option, Control> optionFields = new HashMap<Option, Control>();

	private Runnable optionChangeCallback;

	private boolean groupping = true;

	public void setOptionChangeCallback(Runnable optionChangeCallback) {
		this.optionChangeCallback = optionChangeCallback;
	}

	public void createOptions(final Composite content, String group,
			boolean autoApply, FormToolkit toolkit) {
		final ScrolledComposite sc = new ScrolledComposite(content,
				SWT.H_SCROLL | SWT.V_SCROLL);
		if (toolkit != null)
			toolkit.adapt(sc);
		GridLayoutFactory.swtDefaults().applyTo(sc);
		GridDataFactory.fillDefaults().grab(true, true).hint(500, 450)
				.applyTo(sc);

		final Composite ct = new Composite(sc, SWT.NONE);
		if (toolkit != null)
			toolkit.adapt(ct);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(ct);
		GridLayoutFactory.fillDefaults().applyTo(ct);
		createFeatures(ct, Messages.FeaturesComposite_CoreFeaturesGroup,
				Q7Features.getInstance(), group, autoApply, toolkit);
		createFeatures(ct, Messages.FeaturesComposite_RuntimeFeaturesGroup,
				TeslaFeatures.getInstance(), group, autoApply, toolkit);
		content.addControlListener(new ControlListener() {
			public void controlResized(ControlEvent e) {
				// ct.layout();
				Rectangle bounds = content.getBounds();
				Point min = ct.computeSize(SWT.DEFAULT, SWT.DEFAULT);
				ct.setSize(ct.computeSize(Math.max(min.x, bounds.width - 30),
						SWT.DEFAULT));
			}

			public void controlMoved(ControlEvent e) {
			}
		});
		Rectangle bounds = content.getBounds();
		ct.setSize(ct.computeSize(bounds.width - 30, SWT.DEFAULT));
		// sc.setMinSize(300, 200);
		// sc.setSize(300,200);
		sc.setContent(ct);
	}

	public void apply() {
		for (Map.Entry<Option, Control> opt : optionFields.entrySet()) {
			applyValue(opt.getKey(), opt.getValue());
		}

		Q7Features.getInstance().saveToPreferences(RcpttPlugin.getPreferences());
		TeslaFeatures.getInstance().saveToPreferences(
				TeslaCore.getPreferences());
	}

	private void applyValue(Option option, Control value) {
		if (value instanceof Button) {
			boolean selection = ((Button) value).getSelection();
			option.setValue(selection ? "true" : "false"); //$NON-NLS-1$ //$NON-NLS-2$
		} else if (value instanceof Spinner) {
			option.setValue(Integer.toString(((Spinner) value).getSelection()));
		} else if (value instanceof Combo) {
			int index = ((Combo) value).getSelectionIndex();
			option.setValue(option.getValues()[index]);
		} else if (value instanceof Text) {
			option.setValue(((Text) value).getText());
		}
		if (optionChangeCallback != null) {
			optionChangeCallback.run();
		}
	}

	public void createFeatures(final Composite content, String title,
			AbstractFeatureManager features, String cfgGroup,
			boolean autoApply, FormToolkit toolkit) {
		Option[] options = features.getOptions();
		Map<String, List<Option>> categories = new TreeMap<String, List<Option>>();
		Map<String, Boolean> expanded = new HashMap<String, Boolean>();
		for (final Option key : options) {
			if (key.isEditable() && key.isShowIn(cfgGroup)) {
				String category = key.getCategory();
				if (category == null) {
					category = ""; //$NON-NLS-1$
				}
				if (category.startsWith("$")) { //$NON-NLS-1$
					category = category.substring(1);
					expanded.put(category, Boolean.TRUE);
				}
				List<Option> optionsList = categories.get(category);
				if (optionsList == null) {
					optionsList = new ArrayList<AbstractFeatureManager.Option>();
				}
				categories.put(category, optionsList);
				optionsList.add(key);
			}
		}
		if (categories.isEmpty()) {
			return;
		}
		// sort each category content
		for (List<Option> optionsList : categories.values()) {
			Collections.sort(optionsList, new Comparator<Option>() {
				public int compare(Option o1, Option o2) {
					return Integer.valueOf(o1.getOrder()).compareTo(
							o2.getOrder());
				}
			});
		}
		Composite parent = content;
		if( groupping ) {
			Group mg = new Group(content, SWT.NONE);
			if (toolkit != null)
				toolkit.adapt(mg);
			mg.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
			mg.setText(title);
			mg.setLayout(new GridLayout(2, false));
			parent = mg;
		}
		for (Map.Entry<String, List<Option>> entry : categories.entrySet()) {
			if (entry.getValue().size() == 0) {
				continue;
			}
			Composite g = null;
			if (entry.getKey().length() > 0 && groupping) {
				// g = new Group(mg, SWT.NONE);
				// ((Group)g).setText(entry.getKey());
				boolean expValue = expanded.containsKey(entry.getKey());
				Section exp = new Section(parent, SWT.BORDER | Section.TWISTIE
						| (expValue ? Section.EXPANDED : 0));
				if (toolkit != null)
					toolkit.adapt(exp);
				if (!expValue) {
					exp.setExpanded(false);
				}
				exp.setText(entry.getKey());
				exp.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false,
						2, 1));
				g = new Composite(exp, SWT.NONE);
				if (toolkit != null)
					toolkit.adapt(g);
				g.setLayout(new GridLayout(2, false));
				exp.setClient(g);
				exp.addExpansionListener(new IExpansionListener() {
					public void expansionStateChanging(ExpansionEvent e) {
					}

					public void expansionStateChanged(ExpansionEvent e) {
						content.layout();
						Rectangle bounds = content.getParent().getBounds();
						Point min = content.computeSize(SWT.DEFAULT,
								SWT.DEFAULT);
						content.setSize(content.computeSize(
								Math.max(min.x, bounds.width - 30), SWT.DEFAULT));
					}
				});
			} else {
				g = parent;
			}
			for (final Option key : entry.getValue()) {
				if (key.isEditable() && key.isShowIn(cfgGroup)) {
					String[] values = key.getValues();
					if (values != null
							&& values.equals(AbstractFeatureManager.INT_VALUES)) {
						Label l = new Label(g, SWT.NONE);
						l.setText(key.getName());
						if (toolkit != null)
							toolkit.adapt(l, false, false);
						final Spinner b = new Spinner(g, SWT.CHECK | SWT.BORDER);
						if (toolkit != null)
							toolkit.adapt(b);
						b.setValues(0, 0, Integer.MAX_VALUE, 0, 1, 1000);
						b.setSelection(Integer.parseInt(key.getValue()));
						b.setToolTipText(key.getDescription());
						b.setLayoutData(new GridData(SWT.FILL, SWT.DEFAULT,
								true, false, 1, 1));
						optionFields.put(key, b);
						if (autoApply) {
							b.addSelectionListener(new SelectionAdapter() {
								@Override
								public void widgetSelected(SelectionEvent e) {
									applyValue(key, b);
								}
							});
						}
					} else if (values != null
							&& values
									.equals(AbstractFeatureManager.BOOLEAN_VALUES)) {
						final Button b = new Button(g, SWT.CHECK);
						b.setText(key.getName());
						if (toolkit != null)
							toolkit.adapt(b, true, true);
						b.setToolTipText(key.getDescription());
						b.setLayoutData(new GridData(SWT.FILL, SWT.DEFAULT,
								true, false, 2, 1));
						boolean value = "true".equals(key.getValue()); //$NON-NLS-1$
						b.setSelection(value);
						optionFields.put(key, b);
						if (autoApply) {
							b.addSelectionListener(new SelectionAdapter() {
								@Override
								public void widgetSelected(SelectionEvent e) {
									applyValue(key, b);
								}
							});
						}
					} else if (values != null) {
						Label l = new Label(g, SWT.NONE);
						l.setText(key.getName());
						if (toolkit != null)
							toolkit.adapt(l, false, false);
						final Combo b = new Combo(g, SWT.SIMPLE | SWT.DROP_DOWN
								| SWT.READ_ONLY);
						if (toolkit != null)
							toolkit.adapt(b);
						b.setItems(values);
						b.setText(key.getValue());
						if (key.getDescription() != null) {
							b.setToolTipText(key.getDescription());
							l.setToolTipText(key.getDescription());
						}
						b.setLayoutData(new GridData(SWT.FILL, SWT.DEFAULT,
								true, false, 1, 1));
						optionFields.put(key, b);
						if (autoApply) {
							b.addModifyListener(new ModifyListener() {
								public void modifyText(ModifyEvent e) {
									applyValue(key, b);
								}
							});
						}
					} else {
						Label l = new Label(g, SWT.NONE);
						l.setText(key.getName());
						if (toolkit != null)
							toolkit.adapt(l, false, false);
						final Text value = new Text(g, SWT.BORDER);
						if (toolkit != null)
							toolkit.adapt(value, true, true);
						if (key.getDescription() != null) {
							value.setToolTipText(key.getDescription());
							l.setToolTipText(key.getDescription());
						}
						value.setLayoutData(new GridData(SWT.FILL, SWT.DEFAULT,
								true, false));
						if (key.getValue() != null) {
							value.setText(key.getValue());
						}
						optionFields.put(key, value);
						if (autoApply) {
							value.addModifyListener(new ModifyListener() {
								public void modifyText(ModifyEvent e) {
									applyValue(key, value);
								}
							});
						}
					}
				}
			}
		}
	}

	public void setGroupping(boolean b) {
		this.groupping  = b;
	}
}

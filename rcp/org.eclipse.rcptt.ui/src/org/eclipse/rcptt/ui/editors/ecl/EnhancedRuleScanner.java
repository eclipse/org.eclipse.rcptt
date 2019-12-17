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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.jface.resource.StringConverter;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.BufferedRuleBasedScanner;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;

public abstract class EnhancedRuleScanner extends BufferedRuleBasedScanner {
	public static final String boldSuffix = "_bold"; //$NON-NLS-1$
	public static final String italicSuffix = "_italic"; //$NON-NLS-1$
	public static final String strikethroughSuffix = "_strikethrough"; //$NON-NLS-1$
	public static final String underlineSuffix = "_underline"; //$NON-NLS-1$

	protected final ColorManager colorManager;
	protected final IPreferenceStore preferenceStore;

	protected Map<String, Token> tokenMap = new HashMap<String, Token>();
	protected Map<String, Integer> properties = new HashMap<String, Integer>();
	protected String[] color;
	protected String[] bold;
	protected String[] italic;
	protected String[] strikethrough;
	protected String[] underline;
	protected boolean needsLazyColorLoading;

	abstract protected String[] getProperties();

	abstract protected List<IRule> createRules();

	public EnhancedRuleScanner(EditorToolkit toolkit) {
		preferenceStore = toolkit.getPreferenceStore();
		colorManager = toolkit.getColorManager();
	}

	public final void initialize() {
		color = getProperties();
		bold = new String[color.length];
		italic = new String[color.length];
		strikethrough = new String[color.length];
		underline = new String[color.length];

		for (int i = 0; i < color.length; i++) {
			bold[i] = getBoldKey(color[i]);
			italic[i] = getItalicKey(color[i]);
			strikethrough[i] = getStrikethroughKey(color[i]);
			underline[i] = getUnderlineKey(color[i]);

			properties.put(bold[i], i);
			properties.put(italic[i], i);
			properties.put(strikethrough[i], i);
			properties.put(underline[i], i);
		}

		needsLazyColorLoading = Display.getCurrent() == null;
		for (int i = 0; i < color.length; i++) {
			if (needsLazyColorLoading)
				addTokenWithProxyAttribute(color[i], bold[i], italic[i],
						strikethrough[i], underline[i]);
			else
				addToken(color[i], bold[i], italic[i], strikethrough[i],
						underline[i]);
		}

		initializeRules();
	}

	protected String getBoldKey(String colorKey) {
		return colorKey + boldSuffix;
	}

	protected String getItalicKey(String colorKey) {
		return colorKey + italicSuffix;
	}

	protected String getStrikethroughKey(String colorKey) {
		return colorKey + strikethroughSuffix;
	}

	protected String getUnderlineKey(String colorKey) {
		return colorKey + underlineSuffix;
	}

	@Override
	public IToken nextToken() {
		if (needsLazyColorLoading)
			resolveProxyAttributes();
		return super.nextToken();
	}

	private void resolveProxyAttributes() {
		if (needsLazyColorLoading && Display.getCurrent() != null) {
			for (int i = 0; i < color.length; i++) {
				addToken(color[i], bold[i], italic[i], strikethrough[i],
						underline[i]);
			}
			needsLazyColorLoading = false;
		}
	}

	private void addTokenWithProxyAttribute(String colorKey, String boldKey,
			String italicKey, String strikethroughKey, String underlineKey) {
		tokenMap.put(
				colorKey,
				new Token(createTextAttribute(null, boldKey, italicKey,
						strikethroughKey, underlineKey)));
	}

	private void addToken(String colorKey, String boldKey, String italicKey,
			String strikethroughKey, String underlineKey) {
		if (colorManager != null && colorKey != null
				&& colorManager.getColor(colorKey) == null) {
			RGB rgb = PreferenceConverter.getColor(preferenceStore, colorKey);

			colorManager.unbindColor(colorKey);
			colorManager.bindColor(colorKey, rgb);
		}

		if (!needsLazyColorLoading)
			tokenMap.put(
					colorKey,
					new Token(createTextAttribute(colorKey, boldKey, italicKey,
							strikethroughKey, underlineKey)));
		else {
			Token token = (tokenMap.get(colorKey));
			if (token != null)
				token.setData(createTextAttribute(colorKey, boldKey, italicKey,
						strikethroughKey, underlineKey));
		}
	}

	private TextAttribute createTextAttribute(String colorKey, String boldKey,
			String italicKey, String strikethroughKey, String underlineKey) {
		Color color = null;
		if (colorKey != null)
			color = colorManager.getColor(colorKey);

		int style = preferenceStore.getBoolean(boldKey) ? SWT.BOLD : SWT.NORMAL;
		if (preferenceStore.getBoolean(italicKey))
			style |= SWT.ITALIC;

		if (preferenceStore.getBoolean(strikethroughKey))
			style |= TextAttribute.STRIKETHROUGH;

		if (preferenceStore.getBoolean(underlineKey))
			style |= TextAttribute.UNDERLINE;

		return new TextAttribute(color, null, style);
	}

	protected Token getToken(String key) {
		if (needsLazyColorLoading)
			resolveProxyAttributes();
		return tokenMap.get(key);
	}

	private void initializeRules() {
		List<IRule> rules = createRules();
		if (rules != null) {
			IRule[] result = new IRule[rules.size()];
			rules.toArray(result);
			setRules(result);
		}
	}

	private int indexOf(String property) {
		if (property != null) {

			for (int i = 0; i < color.length; i++) {
				if (property.equals(color[i]) || property.equals(bold[i])
						|| property.equals(italic[i])
						|| property.equals(strikethrough[i])
						|| property.equals(underline[i]))
					return i;
			}
		}
		return -1;
	}

	public boolean affectsBehavior(PropertyChangeEvent event) {
		return indexOf(event.getProperty()) >= 0;
	}

	public void adaptToPreferenceChange(PropertyChangeEvent event) {
		String p = event.getProperty();
		int index = indexOf(p);
		Token token = getToken(color[index]);
		if (color[index].equals(p))
			adaptToColorChange(token, event);
		else if (bold[index].equals(p))
			adaptToStyleChange(token, event, SWT.BOLD);
		else if (italic[index].equals(p))
			adaptToStyleChange(token, event, SWT.ITALIC);
		else if (strikethrough[index].equals(p))
			adaptToStyleChange(token, event, TextAttribute.STRIKETHROUGH);
		else if (underline[index].equals(p))
			adaptToStyleChange(token, event, TextAttribute.UNDERLINE);
	}

	private void adaptToColorChange(Token token, PropertyChangeEvent event) {
		RGB rgb = null;

		Object value = event.getNewValue();
		if (value instanceof RGB)
			rgb = (RGB) value;
		else if (value instanceof String)
			rgb = StringConverter.asRGB((String) value);

		if (rgb != null) {
			String property = event.getProperty();
			Color color = colorManager.getColor(property);

			if ((color == null || !rgb.equals(color.getRGB()))) {
				colorManager.unbindColor(property);
				colorManager.bindColor(property, rgb);
				color = colorManager.getColor(property);
			}

			Object data = token.getData();
			if (data instanceof TextAttribute) {
				TextAttribute oldAttr = (TextAttribute) data;
				token.setData(new TextAttribute(color, oldAttr.getBackground(),
						oldAttr.getStyle()));
			}
		}
	}

	private void adaptToStyleChange(Token token, PropertyChangeEvent event,
			int styleAttribute) {
		boolean eventValue = false;
		Object value = event.getNewValue();
		if (value instanceof Boolean)
			eventValue = ((Boolean) value).booleanValue();
		else if (IPreferenceStore.TRUE.equals(value))
			eventValue = true;

		Object data = token.getData();
		if (data instanceof TextAttribute) {
			TextAttribute oldAttr = (TextAttribute) data;
			boolean activeValue = (oldAttr.getStyle() & styleAttribute) == styleAttribute;
			if (activeValue != eventValue)
				token.setData(new TextAttribute(oldAttr.getForeground(),
						oldAttr.getBackground(), eventValue ? oldAttr
								.getStyle() | styleAttribute : oldAttr
								.getStyle() & ~styleAttribute));
		}
	}

	// protected IPreferenceStore getPreferenceStore() {
	// return fPreferenceStore;
	// }
}

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
package org.eclipse.rcptt.tesla.internal.ui.player;

import org.eclipse.swt.widgets.ExpandBar;
import org.eclipse.swt.widgets.ExpandItem;
import org.eclipse.swt.widgets.Widget;

import org.eclipse.rcptt.tesla.core.protocol.GenericElementKind;
import org.eclipse.rcptt.tesla.internal.ui.processors.SWTUIProcessor;

public interface ISWTUIPlayerExtension {

	/**
	 * Extends the wrapping functionality of SWTUIPlayer.
	 * 
	 * @see SWTUIPlayer#wrap(Object)
	 * @see SWTUIElement
	 */
	SWTUIElement wrap(Object s, SWTUIPlayer p);

	/**
	 * For extending element kinds set with custom kinds. This method can also
	 * be used to associate built-in element kinds with custom UI elements.
	 * 
	 * @see SWTUIPlayer#getKind(Object)
	 * @see SWTUIElement#getKind()
	 */
	GenericElementKind getKind(Object w);

	/**
	 * Extends SWTUIPlayer's selecting functionality.
	 * 
	 * @see SWTUIPlayer#select(PlayerSelectionFilter)
	 */
	SWTUIElement select(SWTUIPlayer swtuiPlayer, PlayerSelectionFilter filter);

	/**
	 * Extends the {@link PlayerTextUtils#getRawText(SWTUIElement)} utility
	 * method.
	 */
	String getRawText(SWTUIElement element);

	/**
	 * This method can be used to extend SWTUIPlayer's children collecting
	 * functionality, which is used by player's selecting stuff. Children are
	 * collected, and then the selecting code picks the suitable element from
	 * the collection.
	 * <p>
	 * Find the references of {@link SWTUIPlayer#children} for more details.
	 * 
	 * @see ChildrenCollectingSession#collect()
	 */
	IChildrenCollectingExtension getChildrenCollectingExtension(ChildrenCollectingSession s);

	/**
	 * Extends SWTUIPlayer getShell method (to support custom element kinds),
	 * which is used to activate element's shell on preExecute stage.
	 * 
	 * @see SWTUIProcessor#activateViewEditor(SWTUIElement, boolean)
	 */
	SWTUIElement getShell(SWTUIElement element);

	/**
	 * Returns a logical parent of a given widget. Example -- controls in {@link ExpandItem} have {@link ExpandBar} as a
	 * parent, but should be accessed via item
	 * 
	 * @param current
	 * @return
	 */
	Widget getIndirectParent(Widget current);

}

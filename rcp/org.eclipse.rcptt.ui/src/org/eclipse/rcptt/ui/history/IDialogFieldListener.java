package org.eclipse.rcptt.ui.history;

/*******************************************************************************
 * Copyright (c) 2000, 2014 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
/**
 * Change listener used by <code>DialogField</code>
 */
public interface IDialogFieldListener {

  /**
   * The dialog field has changed.
   *
   * @param field the dialog field that changed
   */
  void dialogFieldChanged(DialogField field);

}


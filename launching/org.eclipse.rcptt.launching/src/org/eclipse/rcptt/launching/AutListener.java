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
package org.eclipse.rcptt.launching;

/**
 * Interface for listening to AUTs/launches life cycle events.
 * 
 * @author Yuri Strot
 * @see AutManager
 */
public interface AutListener {

	/**
	 * New AUT was registered
	 * 
	 * @param aut
	 */
	void autAdded(Aut aut);

	/**
	 * AUT was removed
	 * 
	 * @param aut
	 */
	void autRemoved(Aut aut);

	void autChanged(Aut aut);

	/**
	 * AUT was launched
	 * 
	 * @param launch
	 */
	void launchAdded(AutLaunch launch);

	/**
	 * AUT launch was removed
	 * 
	 * @param launch
	 */
	void launchRemoved(AutLaunch launch);

}

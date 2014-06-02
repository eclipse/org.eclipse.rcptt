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
package org.eclipse.rcptt.ecl.operations;


import org.eclipse.emf.common.util.EList;
import org.eclipse.rcptt.ecl.core.Command;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Map</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.rcptt.ecl.operations.Map#getEntries <em>Entries</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.rcptt.ecl.operations.OperationsPackage#getMap()
 * @model annotation="http://www.eclipse.org/ecl/docs description='Creates a new map. Also see <a href=\"#get\">get</a> command to find a value by key.' example='let [val myMap [map \n   [entry firstName \"Ivan\"]\n   [entry lastName \"Inozemtsev\"]]] {\n   log [format \"%s %s\" [$myMap | get firstName] [$myMap | get lastName]]\n}'"
 * @generated
 */
public interface Map extends Command {
	/**
	 * Returns the value of the '<em><b>Entries</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.rcptt.ecl.operations.Entry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Entries</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Entries</em>' containment reference list.
	 * @see org.eclipse.rcptt.ecl.operations.OperationsPackage#getMap_Entries()
	 * @model containment="true"
	 *        annotation="http://www.eclipse.org/ecl/docs description='An arbitrary number of <a href=\"#entry\">entries</a>.'"
	 * @generated
	 */
	EList<Entry> getEntries();

} // Map

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
package org.eclipse.rcptt.internal.core.model;

import org.eclipse.rcptt.core.model.IQ7Project;

public class BackReferencesProjectScope extends ReferencedProjectScope {

	public BackReferencesProjectScope(IQ7Project q7Project) {
		super(q7Project);

		try {
			IQ7Project[] projects = ModelManager.getModelManager().getModel()
					.getProjects();
			for (IQ7Project iq7Project : projects) {
				IQ7Project[] references = iq7Project.getReferences();
				for (IQ7Project iq7Project2 : references) {
					if (iq7Project2.equals(q7Project)) {
						calculatePaths(iq7Project);
					}
				}
			}

		} catch (Throwable e) {

		}
	}

}

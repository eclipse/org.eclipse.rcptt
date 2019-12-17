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
package org.eclipse.rcptt.sherlock.core.reporting.internal;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.rcptt.sherlock.core.INodeBuilder;
import org.eclipse.rcptt.sherlock.core.info.Info;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.ReportFactory;
import org.eclipse.rcptt.sherlock.core.model.sherlock.report.Snaphot;
import org.eclipse.rcptt.sherlock.core.reporting.AbstractEventProvider;
import org.eclipse.rcptt.sherlock.core.reporting.IReportBuilder;

public class CoreSnaphotsProvider extends AbstractEventProvider {

	public CoreSnaphotsProvider() {
	}
	
	private static void addSnapshotWithData(INodeBuilder node, EObject data) {
		Snaphot snapshot = ReportFactory.eINSTANCE.createSnaphot();
		snapshot.setData(data);
		node.addSnapshot(snapshot);
	}
	
	public void storeSnapshot(INodeBuilder node) {
		addSnapshotWithData(node, Info.getEclipse());
		addSnapshotWithData(node, Info.getJava());
		addSnapshotWithData(node, Info.getSystem());
	}

	@Override
	protected void initializeBuilder(IReportBuilder builder) {
	}

}

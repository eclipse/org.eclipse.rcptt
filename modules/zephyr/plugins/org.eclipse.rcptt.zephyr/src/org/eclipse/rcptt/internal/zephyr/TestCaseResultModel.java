/*******************************************************************************
 * Copyright (c) 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.internal.zephyr;

public final class TestCaseResultModel {

	private Boolean isPassed;
	private String comment;

	public TestCaseResultModel(Boolean isPassed, String comment){
		this.isPassed = isPassed;
		this.comment = comment;
	}

	public Boolean getIsPassed() {
		return isPassed;
	}

	public String getComment() {
		return comment;
	}
}

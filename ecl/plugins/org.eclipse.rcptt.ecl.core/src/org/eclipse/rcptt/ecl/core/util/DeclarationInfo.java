/*******************************************************************************
 * Copyright (c) 2009, 2019 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.ecl.core.util;

public class DeclarationInfo {
	public enum DeclarationInfoType {
		File, Parameter, NonExisting
	};

	private String q7NamedElementID;
	private int declarationOffset;
	private int lengthOfTheIdentifier;
	private DeclarationInfoType type;
	private String declarationString;

	public DeclarationInfo(String q7NamedElementID, int declarationOffset, int lengthOfTheIdentifier, DeclarationInfoType type) {
		super();
		this.q7NamedElementID = q7NamedElementID;
		this.declarationOffset = declarationOffset;
		this.lengthOfTheIdentifier = lengthOfTheIdentifier;
		this.type = type;
	}

	public void setDeclarationOffset(int declarationOffset) {
		this.declarationOffset = declarationOffset;
	}

	public String getQ7NamedElementID() {
		return q7NamedElementID;
	}

	public int getDeclarationOffset() {
		return declarationOffset;
	}

	public int getLengthOfTheIdentifier() {
		return lengthOfTheIdentifier;
	}

	public DeclarationInfoType getType() {
		return type;
	}

	public String getDeclarationString() {
		return declarationString;
	}

	public void setDeclarationString(String declarationString) {
		this.declarationString = declarationString;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + declarationOffset;
		result = prime * result + lengthOfTheIdentifier;
		result = prime * result + ((q7NamedElementID == null) ? 0 : q7NamedElementID.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DeclarationInfo other = (DeclarationInfo) obj;

		if ((type == DeclarationInfoType.NonExisting) && (other.type == DeclarationInfoType.NonExisting))
			return true;

		if (declarationOffset != other.declarationOffset)
			return false;
		if (lengthOfTheIdentifier != other.lengthOfTheIdentifier)
			return false;
		if (q7NamedElementID == null) {
			if (other.q7NamedElementID != null)
				return false;
		} else if (!q7NamedElementID.equals(other.q7NamedElementID))
			return false;
		if (type != other.type)
			return false;
		return true;
	}

}

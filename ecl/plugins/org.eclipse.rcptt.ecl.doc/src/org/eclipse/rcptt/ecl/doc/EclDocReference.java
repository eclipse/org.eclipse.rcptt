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
package org.eclipse.rcptt.ecl.doc;

import java.io.IOException;
import java.util.List;

import org.eclipse.rcptt.ecl.core.util.DeclarationInfo;

public class EclDocReference implements IEclDocProvider {
	List<DeclarationInfo> listOfDeclarations;
	String refName;

	public EclDocReference(String refName, List<DeclarationInfo> listOfDeclarations) {
		this.listOfDeclarations = listOfDeclarations;
		this.refName = refName;
	}

	public List<DeclarationInfo> getListOfDeclarations() {
		return listOfDeclarations;
	}

	public void writeEclDoc(EclDocWriter writer) throws IOException {
		if ((listOfDeclarations == null) || (listOfDeclarations.size() == 0)) {
			writer.text("");
			writer.b(refName);
			writer.text(" cannot be resolved as reference or procedure.");
		} else {
			writer.b(refName);
			if (listOfDeclarations.size() > 1) {
				writer.text(" Mutliple declarations have been found.");
			}

			for (DeclarationInfo declInfo : listOfDeclarations) {
				writer.dl();
				{
					switch (declInfo.getType()) {
					case Parameter: {
						writer.dt("Defined in: ");
						writer.dd("Parameters Context.");
					}
						break;
					case File: {
						writer.dt("Defined in: ");
						if (declInfo.getQ7NamedElementID().isEmpty()) {
							writer.dd(" current script </b> as \"<b>" + declInfo.getDeclarationString() + "</b>\"");
						} else {
							writer.dd(" another file </b> as \"<b>" + declInfo.getDeclarationString() + "<b>\"");
						}

					}
						break;
					case NonExisting: {
						writer.dd("Cannot be resolved as reference or procedure.");
					}
						break;
					}
				}
				writer.close();
			}
		}
		/*
		 * if ((listOfDeclarations == null) || (listOfDeclarations.size() == 0))
		 * { writer.text("Reference: "); writer.b(refName);
		 * writer.text(" is undefined."); } else { writer.text("Reference: ");
		 * writer.b(refName); writer.text(".");
		 * 
		 * if (listOfDeclarations.size() > 1) {
		 * writer.text(" Mutliple declarations have been found."); }
		 * 
		 * for (DeclarationInfo declInfo : listOfDeclarations) { writer.dl(); {
		 * writer.dt("Defined in: "); switch (declInfo.getType()) { case
		 * Parameter: { writer.dd("Parameters Context."); } break; case File: {
		 * if (declInfo.getQ7NamedElementID().isEmpty()) {
		 * writer.dd(" current script at <b>line " +
		 * declInfo.getDeclarationOffset() + "</b> as \"<b>" +
		 * declInfo.getDeclarationString() + "</b>\""); } else {
		 * writer.dd(" another file at <b>line " +
		 * declInfo.getDeclarationOffset() + "</b> as \"<b>" +
		 * declInfo.getDeclarationString() + "<b>\""); }
		 * 
		 * } break; case NonExisting: { writer.dd("<b>Undefined.</b>"); } break;
		 * } } writer.close(); } }
		 */
	}

}

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

import org.eclipse.rcptt.ecl.internal.doc.FileUtil;

public class EclDocAllCommandsWriter {

	public void write(EclDocWriter w) throws IOException {
		w.open("html").attr("lang", "en");
		{
			w.open("head");
			{
				w.tag("title", "ECL Documentation");
				w.open("style");
				{
					w.text(FileUtil.readFileAsString("css/all-commands.css"));
				}
				w.close();
			}
			w.close();

			w.open("body");
			{
				w.open("h2").attr("id", "top").text("Commands").close();
				w.open("ul");
				{
					for (EclDocCommand c : EclDocCommand.getAllPublicCommands()) {
						w.open("li");
						{
							w.open("a")
									.attr("href",
											String.format("#%s", c.getName()))
									.text(c.getName()).close();
						}
						w.close();
					}
				}
				w.close();

				for (EclDocCommand c : EclDocCommand.getAllPublicCommands()) {
					w.open("h3").attr("id", c.getName()).text(c.getName())
							.close();
					c.writeEclDoc(w);
					w.open("hr").close();
				}
			}
			w.close();
		}
		w.close();
	}
}

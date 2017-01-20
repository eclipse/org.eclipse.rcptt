/*******************************************************************************
 * Copyright (c) 2009, 2015 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.ecl.data.commands;

import org.eclipse.rcptt.ecl.core.Command;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Read Csv File</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.rcptt.ecl.data.commands.ReadCsvFile#getUri <em>Uri</em>}</li>
 * </ul>
 *
 * @see org.eclipse.rcptt.ecl.data.commands.CommandsPackage#getReadCsvFile()
 * @model annotation="http://www.eclipse.org/ecl/docs description='Parses given csv file. Fails if file is not found or format is invalid.\nLearn more about &lt;a href = \"http://xored.freshdesk.com/solution/articles/78219-assert-the-whole-table\"&gt;Asserting the whole table contents.&lt;/a&gt;' returns='&lt;code&gt;Table&lt;/code&gt; EMF Object. ' example='with [get-window Preferences] {\n\tget-tree | select \"Java/Installed JREs\"\n\tget-table | get-table-data | eq [read-csv-file \"workspace:/assertData/table.csv\"] | \n\t\tassert-true \"Data in table does not match input file\" \n\tget-button OK | click\n}\n\n//Let\'s say we need to write ErrorLog info to csv file \'table.csv\'.\n//ECL script should look like this:\n \nget-view \"Error Log\" | get-tree | expand-all\nget-view \"Error Log\" | get-tree | get-table-data | write-csv-file \"workspace:/MyProject/AssertData/table.csv\n \n//Note: \n//&lt;a href=\"#expand-all\"&gt;Expand-all&lt;/a&gt;command may be useful in case of hierarchical tree - otherwise non-expanded levels won\'t be written.  \n//You should have MyProject/AssertData on your workspace (you may do it easily with a workspace context) to let you csv file to be created there. \n \n//In case you want to specify which columns/rows should be written you may use \n//&lt;a href=\"#select-columns\"&gt;select-columns&lt;/a&gt;/&lt;a href=\"#exclude-columns\"&gt;exclude-columns&lt;/a&gt; and &lt;a href=\"#select-rows\"&gt;select-rows&lt;/a&gt;/&lt;a href=\"#exclude-rows\"&gt;exclude-rows&lt;/a&gt; commands:\n \nget-view \"Error Log\" | get-tree | get-table-data | select-columns \"Message\" | write-csv-file \"workspace:/MyProject/AssertData/table.csv\" \nget-view \"Error Log\" | get-tree | get-table-data | exclude-columns \"Message\" \"Plug-in\" | write-csv-file \"workspace:/MyProject/AssertData/table.csv\"\nget-view \"Error Log\" | get-tree | get-table-data | select-rows -column \"Message\"  -value \"Execution of early startup handlers completed.\" | write-csv-file \"workspace:/MyProject/AssertData/table.csv\"\n \n//To compare table data to already written csv file you may use &lt;a href=\"#read-csv-file\"&gt;read-csv-file&lt;/a&gt; command:\n \nget-view \"Error Log\" | get-tree | get-table-data | select-columns \"Plug-in\" | eq [read-csv-file \"workspace:/MyProject/AssertData/table.csv\"] | assert-true \"Data in table does not match input file\" '"
 * @generated
 */
public interface ReadCsvFile extends Command {
	/**
	 * Returns the value of the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uri</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Uri</em>' attribute.
	 * @see #setUri(String)
	 * @see org.eclipse.rcptt.ecl.data.commands.CommandsPackage#getReadCsvFile_Uri()
	 * @model annotation="http://www.eclipse.org/ecl/docs description='URI to a file to read. Currently supported schemes are workspace:/ for files in workspace and file:/ for files on local file system'"
	 * @generated
	 */
	String getUri();

	/**
	 * Sets the value of the '{@link org.eclipse.rcptt.ecl.data.commands.ReadCsvFile#getUri <em>Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Uri</em>' attribute.
	 * @see #getUri()
	 * @generated
	 */
	void setUri(String value);

} // ReadCsvFile

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
package org.eclipse.rcptt.maven.util;

import java.io.File;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.codehaus.plexus.archiver.Archiver;
import org.codehaus.plexus.archiver.ArchiverException;
import org.codehaus.plexus.archiver.UnArchiver;
import org.codehaus.plexus.archiver.manager.ArchiverManager;
import org.codehaus.plexus.archiver.manager.NoSuchArchiverException;
import org.codehaus.plexus.archiver.util.DefaultFileSet;

public class ArchiveUtil {
	public ArchiveUtil(ArchiverManager manager) {
		this.manager = manager;
	}
	private final ArchiverManager manager;
	
	public void compressDir(File srcDir, File destFile) throws MojoFailureException, MojoExecutionException {
		if(!srcDir.exists() || srcDir.isFile()) {
			throw new MojoFailureException(String.format("The source %s is not a directory", srcDir));
		}
		Archiver archiver = getArchiver(destFile);
		archiver.setDestFile(destFile);
		DefaultFileSet fs = new DefaultFileSet();
		fs.setDirectory(srcDir);
		try {
			archiver.addFileSet(fs);
			archiver.createArchive();
		} catch (Exception e) {
			throw new MojoExecutionException(String.format("Failed to create archive %s", destFile), e);
		}
		
	}
	public void extract(File archive, File destDir) throws MojoExecutionException, MojoFailureException {
		if(destDir.exists() && destDir.isFile()) {
			throw new MojoFailureException(String.format("The destination %s is not a directory", destDir));
		}
		if(!destDir.exists() && !destDir.mkdirs()) {
			throw new MojoFailureException(String.format("Can't create destionation directory %s", destDir));
		}
		UnArchiver unarchiver = getUnArchiver(archive);
		unarchiver.setSourceFile(archive);
		unarchiver.setDestDirectory(destDir);
		try {
			unarchiver.extract();
		} catch (ArchiverException e) {
			throw new MojoExecutionException(String.format("Failed to extract %s to %s", archive, destDir));
		}
	}
	
	/**
	 * Get unarchiver for file
	 * @param file
	 * @return
	 * @throws MojoExecutionException 
	 */
	protected UnArchiver getUnArchiver(File file) throws MojoExecutionException {
		try {
			return manager.getUnArchiver(file);
		} catch (NoSuchArchiverException e) {
			throw new MojoExecutionException(String.format("Can't find unarchiver for file %s, file", file.getName()), e);
		}
	}
	
	/**
	 * Get zip unarchiver
	 * @return
	 * @throws MojoExecutionException
	 */
	protected UnArchiver getUnArchiver() throws MojoExecutionException {
		try {
			return manager.getUnArchiver(DEFAULT_EXTENSION);
		} catch (NoSuchArchiverException e) {
			throw new MojoExecutionException(String.format("Can't find unarchiver for file %s, file"), e);		
		}
	}
	
	protected Archiver getArchiver(String hint) throws MojoExecutionException {
		try {
			return manager.getArchiver(hint);
		} catch (NoSuchArchiverException e) {
			throw new MojoExecutionException(String.format("Can't find archiver of type %s", hint), e);
		}
	}
	
	protected Archiver getArchiver(File file) throws MojoExecutionException {
		try {
			return manager.getArchiver(file);
		} catch (NoSuchArchiverException e) {
			throw new MojoExecutionException(String.format("Can't find archiver for destination %s", file), e);
		}
	}
	
	/**
	 * Get zip archiver
	 * @return
	 * @throws MojoExecutionException 
	 */
	public Archiver getArchiver() throws MojoExecutionException {
		return getArchiver(DEFAULT_EXTENSION);
	}
	
	public static final String DEFAULT_EXTENSION = "zip"; 
}

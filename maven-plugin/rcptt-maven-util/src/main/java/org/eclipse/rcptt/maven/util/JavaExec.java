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
package org.eclipse.rcptt.maven.util;

import java.io.File;
import java.util.Scanner;

import org.apache.maven.artifact.versioning.ComparableVersion;
import org.apache.maven.plugin.MojoFailureException;
import org.codehaus.plexus.util.cli.CommandLineException;
import org.codehaus.plexus.util.cli.Commandline;

public class JavaExec {
	private final File executable;
	private ComparableVersion version = null;

	public JavaExec(File executable) {
		this.executable = executable.getAbsoluteFile();
		if (!executable.exists())
			throw new IllegalArgumentException(executable + " doesn't exist");
	}

	private JavaExec(File executable, ComparableVersion version) {
		this.executable = executable;
		this.version = version;
	}

	public ComparableVersion getVersion() {
		if (version == null) {
			Commandline cmd = new Commandline();
			cmd.setExecutable(executable.getAbsolutePath());
			cmd.createArg().setValue("-version");
			try {
				Process process = cmd.execute();
				Scanner scanner = new Scanner(process.getErrorStream());
				try {
					scanner.useDelimiter("\"");
					scanner.next();
					version = new ComparableVersion(scanner.next());
				} finally {
					scanner.close();
				}

			} catch (CommandLineException e) {
				throw new RuntimeException("Failed to detect Java version", e);
			}
		}
		return version;
	}

	static String extension() {
		return PlatformUtil.getOS() == OS.WIN ? ".exe" : "";
	}

	private static File getExecutableFromInstallation(File installation) throws MojoFailureException {
		final String name = "java" + extension();
		File rv = new File(new File(installation, "bin"), name);
		if (!rv.exists()) {
			throw new MojoFailureException(
					String.format("Failed to resolve java execution location, %s does not exist", rv));
		}
		return rv;
	}

	public boolean hasPermGen() {
		return getVersion().compareTo(new ComparableVersion("1.8")) < 0;
	}

	public File getFile() {
		return executable;
	}

	private static File getDefaultInstallation() {
		String javaExec = System.getProperty("java.home");
		if (javaExec == null) {
			javaExec = System.getenv("JAVA_HOME");
			if (javaExec == null) {
				throw new IllegalStateException("Couldn't locate java, try setting JAVA_HOME environment variable.");
			}
		}
		return new File(javaExec);
	}

	public static JavaExec getDefault() throws MojoFailureException {
		return new JavaExec(getExecutableFromInstallation(getDefaultInstallation()),
				new ComparableVersion(System.getProperty("java.version")));
	}
}

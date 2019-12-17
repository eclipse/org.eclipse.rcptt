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
package org.eclipse.rcptt.maven.util;

public class Coords {

	private String artifactId;
	private String groupId;
	private String version;
	private String classifier;
	private String extension = "zip";
	private String explicit;
	private String[] vmArgs;

	public Coords() {
		super();
	}

	public String getArtifactId() {
		return artifactId;
	}

	public void setArtifactId(String artifactId) {
		this.artifactId = artifactId;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getClassifier() {
		return classifier;
	}
	
	public void setClassifier(String classifier) {
		this.classifier = classifier;
	}
	
	public String getExplicit() {
		return explicit;
	}
	
	public void setExplicit(String explicit) {
		this.explicit = explicit;
	}
	
	public String getExtension() {
		return extension;
	}
	
	public void setExtension(String extension) {
		this.extension = extension;
	}

	public String[] getVmArgs() {
		return vmArgs;
	}
	
	public void setVmArgs(String[] vmArgs) {
		this.vmArgs = vmArgs;
	}

	
	@Override
	public String toString() {
		return "Coords [artifactId=" + artifactId + ", groupId=" + groupId
				+ ", version=" + version + "]";
	}
}
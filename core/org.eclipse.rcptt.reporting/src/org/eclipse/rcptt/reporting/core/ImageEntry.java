package org.eclipse.rcptt.reporting.core;

public class ImageEntry {
	public final byte[] data;
	public final String description;

	public ImageEntry(byte[] data, String description) {
		super();
		this.data = data;
		this.description = description;
	}
}
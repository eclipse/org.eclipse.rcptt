package org.eclipse.rcptt.tesla.recording.core.ecl;

public interface IKeyStrokeManagerExtension {

	String getMask(int val);

	String formatKeyWithMeta(int mask, int keyCode, int meta);

	String getMeta(int meta);
}

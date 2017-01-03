package org.eclipse.rcptt.core.persistence.plain;

public class PlainFormatException extends Exception {
	private static final long serialVersionUID = 1L;
	private String fileName = "";

	public PlainFormatException(String msg) {
		super(msg);
	}

	public void setFileName(String fName) {
		this.fileName = fName;
	}

	@Override
	public String getMessage() {
		if (this.fileName != null) {
			return super.getMessage() + " on " + this.fileName;
		}
		return super.getMessage();
	}
}

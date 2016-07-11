package org.eclipse.rcptt.maven.util;

public class Rap {
	private int port = -1;
	private String servletPath;
	private String browserCmd;

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getServletPath() {
		return servletPath;
	}

	public void setServletPath(String servetPath) {
		this.servletPath = servetPath;
	}

	public String getBrowserCmd() {
		return browserCmd;
	}

	public void setBrowserCmd(String browserCmd) {
		this.browserCmd = browserCmd;
	}
}

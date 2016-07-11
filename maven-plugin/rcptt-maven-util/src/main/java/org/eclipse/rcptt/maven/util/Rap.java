package org.eclipse.rcptt.maven.util;

public class Rap {
	private int port = -1;
	private String servetPath;
	private String browserCmd;

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getServetPath() {
		return servetPath;
	}

	public void setServetPath(String servetPath) {
		this.servetPath = servetPath;
	}

	public String getBrowserCmd() {
		return browserCmd;
	}

	public void setBrowserCmd(String browserCmd) {
		this.browserCmd = browserCmd;
	}
}

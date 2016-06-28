package org.eclipse.rcptt.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Locale;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class MockHttpServletResponse implements HttpServletResponse {

	protected HttpServletResponse origResponse = null;
	private ByteArrayOutputStream duplicateOutput = null;
	protected ServletOutputStream stream = null;
	protected PrintWriter writer = null;

	@Override
	public String getCharacterEncoding() {
		return null;
	}

	@Override
	public String getContentType() {
		return null;
	}

	@Override
	public ServletOutputStream getOutputStream() throws IOException {
		if (writer != null) {
			throw new IllegalStateException("getOutputStream() has already been called!");
		}

		if (stream == null) {
			try {
				setDuplicateOutput(new ByteArrayOutputStream());
				stream = new ServletOutputStreamWrapper(null, getDuplicateOutput());
			} catch (Exception ex) {
				throw new IOException("Unable to construct servlet output stream: " + ex.getMessage(), ex);
			}
		}
		return stream;
	}

	@Override
	public PrintWriter getWriter() throws IOException {
		if (writer != null) {
			return (writer);
		}

		if (stream != null) {
			throw new IllegalStateException("getOutputStream() has already been called!");
		}

		writer = new PrintWriter(new OutputStreamWriter(getOutputStream(), "UTF-8"));
		return (writer);
	}

	@Override
	public void setCharacterEncoding(String charset) {

	}

	@Override
	public void setContentLength(int len) {

	}

	@Override
	public void setContentLengthLong(long len) {

	}

	@Override
	public void setContentType(String type) {

	}

	@Override
	public void setBufferSize(int size) {

	}

	@Override
	public int getBufferSize() {
		return 0;
	}

	@Override
	public void flushBuffer() throws IOException {
		stream.flush();
	}

	@Override
	public void resetBuffer() {

	}

	@Override
	public boolean isCommitted() {
		return false;
	}

	@Override
	public void reset() {

	}

	@Override
	public void setLocale(Locale loc) {

	}

	@Override
	public Locale getLocale() {
		return null;
	}

	@Override
	public void addCookie(Cookie cookie) {
	}

	@Override
	public boolean containsHeader(String name) {
		return false;
	}

	@Override
	public String encodeURL(String url) {
		return null;
	}

	@Override
	public String encodeRedirectURL(String url) {
		return null;
	}

	@Override
	public String encodeUrl(String url) {
		return null;
	}

	@Override
	public String encodeRedirectUrl(String url) {
		return null;
	}

	@Override
	public void sendError(int sc, String msg) throws IOException {

	}

	@Override
	public void sendError(int sc) throws IOException {


	}

	@Override
	public void sendRedirect(String location) throws IOException {


	}

	@Override
	public void setDateHeader(String name, long date) {


	}

	@Override
	public void addDateHeader(String name, long date) {


	}

	@Override
	public void setHeader(String name, String value) {


	}

	@Override
	public void addHeader(String name, String value) {


	}

	@Override
	public void setIntHeader(String name, int value) {


	}

	@Override
	public void addIntHeader(String name, int value) {


	}

	@Override
	public void setStatus(int sc) {


	}

	@Override
	public void setStatus(int sc, String sm) {


	}

	@Override
	public int getStatus() {

		return 0;
	}

	@Override
	public String getHeader(String name) {

		return null;
	}

	@Override
	public Collection<String> getHeaders(String name) {

		return null;
	}

	@Override
	public Collection<String> getHeaderNames() {

		return null;
	}

	public ByteArrayOutputStream getDuplicateOutput() {
		return duplicateOutput;
	}

	public void setDuplicateOutput(ByteArrayOutputStream duplicateOutput) {
		this.duplicateOutput = duplicateOutput;
	}

}

/*******************************************************************************
 * /*******************************************************************************
 *  * Copyright (c) 2009, 2019 Xored Software Inc and others.
 *  * All rights reserved. This program and the accompanying materials
 *  * are made available under the terms of the Eclipse Public License v1.0
 *  * which accompanies this distribution, and is available at
 *  * https://www.eclipse.org/legal/epl-v20.html
 *  *
 *  * Contributors:
 *  *     Xored Software Inc - initial API and implementation and/or initial documentation
 *  *******************************************************************************/
package org.eclipse.rcptt.tesla.recording.aspects.swt.rap;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.rap.rwt.service.ServiceHandler;
import org.eclipse.rcptt.tesla.swt.download.OutputStreamResponseWrapper;
import org.eclipse.rcptt.util.Base64;

public class ServiceHandlerWrapper implements ServiceHandler {

	private ServiceHandler wrapper;
	private String handlerId;

	public ServiceHandlerWrapper(ServiceHandler wrapped, String handlerId) {
		this.wrapper = wrapped;
		this.handlerId = handlerId;
	}

	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		final OutputStreamResponseWrapper wrappedResponse = new OutputStreamResponseWrapper(response, true);

		wrapper.service(request, wrappedResponse);
		final ByteArrayOutputStream spyStream = wrappedResponse.getSpyOutputStream();

		final String content = Base64.encode(spyStream.toByteArray());

		final String url =  "/?" + request.getQueryString(); //$NON-NLS-1$
		SWTEventManager.recordRapDownload(handlerId, url, content);

	}

}

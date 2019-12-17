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
package org.eclipse.rcptt.internal.launching.rap.ui;

import java.net.URL;
import java.text.MessageFormat;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.rcptt.launching.rap.IBrowserLaunchDelegate;
import org.eclipse.rcptt.launching.rap.RAPLaunchConfig;
import org.eclipse.rcptt.launching.rap.RAPLaunchConfig.BrowserMode;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.browser.IWebBrowser;
import org.eclipse.ui.browser.IWorkbenchBrowserSupport;

public class BrowserLaucherDelegate implements IBrowserLaunchDelegate {

	@Override
	public void launch(URL url, RAPLaunchConfig config) throws CoreException {
		openUrl(getBrowser(config), url);
	}

	private IWebBrowser getBrowser(final RAPLaunchConfig config) throws CoreException {
		final IWebBrowser[] result = { null };
		final CoreException[] exception = { null };
		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				try {
					IWorkbench workbench = PlatformUI.getWorkbench();
					IWorkbenchBrowserSupport support = workbench.getBrowserSupport();
					int style = IWorkbenchBrowserSupport.LOCATION_BAR
							| IWorkbenchBrowserSupport.NAVIGATION_BAR
							| IWorkbenchBrowserSupport.STATUS;
					if (BrowserMode.EXTERNAL.equals(config.getBrowserMode())) {
						style |= IWorkbenchBrowserSupport.AS_EXTERNAL;
					} else {
						style |= IWorkbenchBrowserSupport.AS_EDITOR;
					}
					// Starting the same launch first with the external, then with the
					// internal browser without restarting the workbench will still open
					// an external browser.
					// The fix is to append the browserMode to the id
					String id = config.getName() + config.getBrowserMode();
					String name = config.getName();
					String toolTip = config.getName();
					result[0] = support.createBrowser(style, id, name, toolTip);
				} catch (CoreException e) {
					exception[0] = e;
				}
			}
		});
		if (exception[0] != null) {
			throw exception[0];
		}
		return result[0];
	}

	private static void openUrl(final IWebBrowser browser, final URL url) throws PartInitException {
		final PartInitException[] exception = { null };
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				try {
					browser.openURL(url);
				} catch (PartInitException e) {
					String text = "Failed to open URL ''{0}'' in browser.";
					String msg = MessageFormat.format(text, new Object[] { url });
					String pluginId = Activator.PLUGIN_ID;
					Status status = new Status(IStatus.ERROR, pluginId, msg, e);
					exception[0] = new PartInitException(status);
				}
			}
		});
		if (exception[0] != null) {
			throw exception[0];
		}
	}

}

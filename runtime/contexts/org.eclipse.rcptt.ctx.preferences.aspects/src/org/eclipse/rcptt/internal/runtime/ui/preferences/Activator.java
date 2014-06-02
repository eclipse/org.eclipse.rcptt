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
package org.eclipse.rcptt.internal.runtime.ui.preferences;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleEvent;
import org.osgi.framework.BundleListener;

import org.eclipse.rcptt.runtime.ui.preferences.DialogSettingsManager;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends Plugin {

  // The plug-in ID
  public static final String PLUGIN_ID = "org.eclipse.rcptt.ctx.preferences.aspects";

  // The shared instance
  private static Activator plugin;

  private BundleListener bundleListener;

  /**
   * The constructor
   */
  public Activator() {
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext
   * )
   */
  @Override
  public void start(BundleContext context) throws Exception {
    super.start(context);
    plugin = this;
    bundleListener = new BundleListener() {
      public void bundleChanged(BundleEvent event) {
        if (BundleEvent.UNINSTALLED == event.getType()) {
          DialogSettingsManager.getInstance().removeSettings(
              event.getBundle());
        }
      }
    };
    context.addBundleListener(bundleListener);
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext
   * )
   */
  @Override
  public void stop(BundleContext context) throws Exception {
    plugin = null;
    super.stop(context);
    if (bundleListener != null) {
      context.removeBundleListener(bundleListener);
    }
  }

  /**
   * Returns the shared instance
   * 
   * @return the shared instance
   */
  public static Activator getDefault() {
    return plugin;
  }

  public static void log(Throwable t) {
    getDefault().getLog().log(createStatus(t));
  }

  public static IStatus createStatus(Throwable t) {
    return new Status(IStatus.ERROR, PLUGIN_ID, t.getMessage(), t);
  }

  public static IStatus createStatus(String message, Throwable t) {
    return new Status(IStatus.ERROR, PLUGIN_ID, message, t);
  }
}

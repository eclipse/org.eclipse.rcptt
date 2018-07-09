package org.eclipse.rcptt.tesla.swt.aspects.rap;

import java.lang.reflect.Field;

import org.aspectj.lang.annotation.SuppressAjWarnings;
import org.eclipse.swt.dnd.ByteArrayTransfer;
import org.eclipse.swt.dnd.FileTransfer;
import org.eclipse.swt.dnd.HTMLTransfer;
import org.eclipse.swt.dnd.ImageTransfer;
import org.eclipse.swt.dnd.RTFTransfer;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.dnd.TransferData;
import org.eclipse.swt.dnd.URLTransfer;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Text;
import org.eclipse.rcptt.tesla.core.am.rap.AspectManager;
import org.eclipse.rcptt.tesla.swt.dnd.LocalClipboard;
import org.eclipse.rcptt.tesla.swt.events.TeslaEventManager;

privileged public aspect ClipboardAspect {
	public ClipboardAspect() {
		AspectManager.activateAspect(SWTAspectActivator.PLUGIN_ID, this
				.getClass().getName());
	}

	// --------------------------------------------------------
	// ----------------------------------- org.eclipse.swt.widgets.Text
	// --------------------------------------------------------
	//TODO RAP-FIX
	/*
	@SuppressAjWarnings("adviceDidNotMatch")
	void around(Text text): execution( void org.eclipse.swt.widgets.Text.copy()) &&target( text) {
		try {
			if (TeslaEventManager.getManager().hasListeners()) {
				// Override
				try {
					Clipboard cb = new Clipboard(text.getDisplay());
					String textData = text.getSelectionText();
					if (textData != null) {
						TextTransfer textTransfer = TextTransfer.getInstance();
						cb.setContents(new Object[] { textData },
								new Transfer[] { textTransfer });
					}
					return;
				} catch (Throwable e) {
					SWTAspectActivator.log(e);
					proceed(text);
					return;
				}
			}
		} catch (Throwable e) {
			SWTAspectActivator.log(e);
		}
		proceed(text);
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	void around(Text text): execution( void org.eclipse.swt.widgets.Text.paste()) && target( text) {
		try {
			if (TeslaEventManager.getManager().hasListeners()) {
				// Override
				try {
					Clipboard cb = new Clipboard(text.getDisplay());
					TextTransfer transfer = TextTransfer.getInstance();
					String data = (String) cb.getContents(transfer);
					if (data != null) {
						text.insert(data);
					}
				} catch (Throwable e) {
					SWTAspectActivator.log(e);
					proceed(text);
					return;
				}
				return;
			}
		} catch (Throwable e) {
			SWTAspectActivator.log(e);
		}
		proceed(text);
	}
	 */
	// --------------------------------------------------------
	// ----------------------------------- org.eclipse.swt.widgets.combo
	// --------------------------------------------------------
	//TODO RAP-FIX
	/*
	@SuppressAjWarnings("adviceDidNotMatch")
	void around(Combo combo): execution( void org.eclipse.swt.widgets.Combo.copy()) && target(combo) {
		try {
			if (TeslaEventManager.getManager().hasListeners()
					&& LocalClipboard.isEnabled()) {
				// Override
				try {
					Clipboard cb = new Clipboard(combo.getDisplay());
					Point selection = combo.getSelection();
					String textData = combo.getText().substring(selection.x,
							selection.y);
					if (textData != null) {
						TextTransfer textTransfer = TextTransfer.getInstance();
						cb.setContents(new Object[] { textData },
								new Transfer[] { textTransfer });
					}
					return;
				} catch (Throwable e) {
					SWTAspectActivator.log(e);
					proceed(combo);
					return;
				}
			}
		} catch (Throwable e) {
			SWTAspectActivator.log(e);
		}
		proceed(combo);
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	void around(Combo combo): execution( void org.eclipse.swt.widgets.Combo.paste()) && target( combo) {
		try {
			if (TeslaEventManager.getManager().hasListeners()
					&& LocalClipboard.isEnabled()) {
				// Override
				try {
					Clipboard cb = new Clipboard(combo.getDisplay());
					TextTransfer transfer = TextTransfer.getInstance();
					String data = (String) cb.getContents(transfer);
					if (data != null) {
						Point selection = combo.getSelection();
						String text = combo.getText();
						text = text.substring(0, selection.x) + data
								+ text.substring(selection.y, text.length());
						combo.setText(text);
						combo.setSelection(new Point(selection.x, selection.x));
					}
				} catch (Throwable e) {
					SWTAspectActivator.log(e);
					proceed(combo);
					return;
				}
				return;
			}
		} catch (Throwable e) {
			SWTAspectActivator.log(e);
		}
		proceed(combo);
	}
	*/
	// --------------------------------------------------------
	// ----------------------------------- org.eclipse.swt.widgets.combo
	// --------------------------------------------------------
	// Due to spinner swt implementation it is not possible to

	// ------------------------------------------------------------------
	// ----------------------------------- org.eclipse.swt.dnd.Clipboard-
	// ------------------------------------------------------------------
	//TODO RAP-FIX
	/*
	@SuppressAjWarnings("adviceDidNotMatch")
	void around(Clipboard cb, Object[] objs, Transfer[] tr, int type):
		execution(void org.eclipse.swt.dnd.Clipboard.setContents(Object[], Transfer[], int))
		&& target(cb)
		&& args(objs, tr, type) {
		try {
			if (TeslaEventManager.getManager().hasListeners()
					&& LocalClipboard.isEnabled()) {
				LocalClipboard.setContents(objs, tr, type);
				return;
			}
		} catch (Throwable e) {
			SWTAspectActivator.log(e);
		}
		proceed(cb, objs, tr, type);
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	Object around(Clipboard cb, Transfer tr, int type):
		execution(Object org.eclipse.swt.dnd.Clipboard.getContents(Transfer, int))
		&& target(cb)
		&& args(tr, type) {
		try {
			if (TeslaEventManager.getManager().hasListeners()
					&& LocalClipboard.isEnabled()) {
				return LocalClipboard.getContents(tr, type);
			}
		} catch (Throwable e) {
			SWTAspectActivator.log(e);
		}
		return proceed(cb, tr, type);
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	Object around(Clipboard cb, int type):
		execution(public TransferData[] org.eclipse.swt.dnd.Clipboard.getAvailableTypes(int))
		&& target(cb)
		&& args(type) {
		try {
			if (TeslaEventManager.getManager().hasListeners()
					&& LocalClipboard.isEnabled()) {
				return LocalClipboard.getAvailableTypes(type);
			}
		} catch (Throwable e) {
			SWTAspectActivator.log(e);
		}
		return proceed(cb, type);
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	Object around(Clipboard cb, int type):
		execution(public String[] org.eclipse.swt.dnd.Clipboard.getAvailableTypeNames())
		&& target(cb)
		&& args(type) {
		try {
			if (TeslaEventManager.getManager().hasListeners()
					&& LocalClipboard.isEnabled()) {
				return LocalClipboard.getAvailableTypeNames(type);
			}
		} catch (Throwable e) {
			SWTAspectActivator.log(e);
		}
		return proceed(cb, type);
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	void around(Clipboard cb, int type):
		execution(void org.eclipse.swt.dnd.Clipboard.clearContents(int))
		&& target(cb)
		&& args(type) {
		try {
			if (TeslaEventManager.getManager().hasListeners()
					&& LocalClipboard.isEnabled()) {
				LocalClipboard.clearContents(type);
				return;
			}
		} catch (Throwable e) {
			SWTAspectActivator.log(e);
		}
		proceed(cb, type);
	}
	*/
	// --------------------------------------------------------------------------------------------------
	// Transfer nativeToJava and javaToNative convertions.
	// --------------------------------------------------------------------------------------------------

	public Object org.eclipse.swt.dnd.TransferData.storedObject = null;

	// ByteArrayTransfer
	@SuppressAjWarnings("adviceDidNotMatch")
	void around(ByteArrayTransfer tr, Object object, TransferData data):
		execution(void org.eclipse.swt.dnd.ByteArrayTransfer.javaToNative(Object, TransferData)) && target(tr)
		&& args(object, data) {
		try {
			if (TeslaEventManager.getManager().hasListeners()
					&& LocalClipboard.isEnabled()) {
				if (object == null || !tr.isSupportedType(data)) {
					data.storedObject = null;
					return;
				}
				data.storedObject = object;
				return;
			}
		} catch (Throwable e) {
			SWTAspectActivator.log(e);
		}
		proceed(tr, object, data);
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	Object around(ByteArrayTransfer tr, TransferData data):
		execution(Object org.eclipse.swt.dnd.ByteArrayTransfer.nativeToJava(TransferData)) && target(tr)
		&& args(data) {
		try {
			if (TeslaEventManager.getManager().hasListeners() && tr.getClass()
					.getName()
					.equals("org.eclipse.emf.edit.ui.dnd.LocalTransfer")) {
				try {
					Field f = tr.getClass().getDeclaredField("object");
					f.setAccessible(true);
					Object value = f.get(tr);
					if (value != null) {
						f = tr.getClass().getDeclaredField("startTime");
						f.setAccessible(true);
						value = f.get(tr);
						// We still need this on Windows, to call for javaToNative.
						proceed(tr, data);
						return String.valueOf(value).getBytes();
					}
				} catch (Exception e) {
				}
			}

			if (TeslaEventManager.getManager().hasListeners()
					&& LocalClipboard.isEnabled()) {
				if (!tr.isSupportedType(data)) {
					return null;
				}
				return data.storedObject;
			}
		} catch (Throwable e) {
			SWTAspectActivator.log(e);
		}
		return proceed(tr, data);
	}

	// FileTransfer
	@SuppressAjWarnings("adviceDidNotMatch")
	void around(FileTransfer tr, Object object, TransferData data):
		execution(void org.eclipse.swt.dnd.FileTransfer.javaToNative(Object, TransferData)) && target(tr)
		&& args(object, data) {
		try {
			if (TeslaEventManager.getManager().hasListeners()
					&& LocalClipboard.isEnabled()) {
				if (object == null || !tr.isSupportedType(data)) {
					data.storedObject = null;
					return;
				}
				data.storedObject = object;
				return;
			}
		} catch (Throwable e) {
			SWTAspectActivator.log(e);
		}
		proceed(tr, object, data);
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	Object around(FileTransfer tr, TransferData data):
		execution(Object org.eclipse.swt.dnd.FileTransfer.nativeToJava(TransferData)) && target(tr)
		&& args(data) {
		try {
			if (TeslaEventManager.getManager().hasListeners()
					&& LocalClipboard.isEnabled()) {
				if (!tr.isSupportedType(data)) {
					return null;
				}
				return data.storedObject;
			}
		} catch (Throwable e) {
			SWTAspectActivator.log(e);
		}
		return proceed(tr, data);
	}

	// HTMLTransfer
	@SuppressAjWarnings("adviceDidNotMatch")
	void around(HTMLTransfer tr, Object object, TransferData data):
		execution(void org.eclipse.swt.dnd.HTMLTransfer.javaToNative(Object, TransferData)) && target(tr)
		&& args(object, data) {
		try {
			if (TeslaEventManager.getManager().hasListeners()
					&& LocalClipboard.isEnabled()) {
				if (object == null || !tr.isSupportedType(data)) {
					data.storedObject = null;
					return;
				}
				data.storedObject = object;
				return;
			}
		} catch (Throwable e) {
			SWTAspectActivator.log(e);
		}
		proceed(tr, object, data);
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	Object around(HTMLTransfer tr, TransferData data):
		execution(Object org.eclipse.swt.dnd.HTMLTransfer.nativeToJava(TransferData)) && target(tr)
		&& args(data) {
		try {
			if (TeslaEventManager.getManager().hasListeners()
					&& LocalClipboard.isEnabled()) {
				if (!tr.isSupportedType(data)) {
					return null;
				}
				return data.storedObject;
			}
		} catch (Throwable e) {
			SWTAspectActivator.log(e);
		}
		return proceed(tr, data);
	}

	// ImageTransfer
	@SuppressAjWarnings("adviceDidNotMatch")
	void around(ImageTransfer tr, Object object, TransferData data):
		execution(void org.eclipse.swt.dnd.ImageTransfer.javaToNative(Object, TransferData)) && target(tr)
		&& args(object, data) {
		try {
			if (TeslaEventManager.getManager().hasListeners()
					&& LocalClipboard.isEnabled()) {
				if (object == null || !tr.isSupportedType(data)) {
					data.storedObject = null;
					return;
				}
				data.storedObject = object;
				return;
			}
		} catch (Throwable e) {
			SWTAspectActivator.log(e);
		}
		proceed(tr, object, data);
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	Object around(ImageTransfer tr, TransferData data):
		execution(Object org.eclipse.swt.dnd.ImageTransfer.nativeToJava(TransferData)) && target(tr)
		&& args(data) {
		try {
			if (TeslaEventManager.getManager().hasListeners()
					&& LocalClipboard.isEnabled()) {
				if (!tr.isSupportedType(data)) {
					return null;
				}
				return data.storedObject;
			}
		} catch (Throwable e) {
			SWTAspectActivator.log(e);
		}
		return proceed(tr, data);
	}

	// RTFTransfer
	@SuppressAjWarnings("adviceDidNotMatch")
	void around(RTFTransfer tr, Object object, TransferData data):
		execution(void org.eclipse.swt.dnd.RTFTransfer.javaToNative(Object, TransferData)) && target(tr)
		&& args(object, data) {
		try {
			if (TeslaEventManager.getManager().hasListeners()
					&& LocalClipboard.isEnabled()) {
				if (object == null || !tr.isSupportedType(data)) {
					data.storedObject = null;
					return;
				}
				data.storedObject = object;
				return;
			}
		} catch (Throwable e) {
			SWTAspectActivator.log(e);
		}
		proceed(tr, object, data);
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	Object around(RTFTransfer tr, TransferData data):
		execution(Object org.eclipse.swt.dnd.RTFTransfer.nativeToJava(TransferData)) && target(tr)
		&& args(data) {
		try {
			if (TeslaEventManager.getManager().hasListeners()
					&& LocalClipboard.isEnabled()) {
				if (!tr.isSupportedType(data)) {
					return null;
				}
				return data.storedObject;
			}
		} catch (Throwable e) {
			SWTAspectActivator.log(e);
		}
		return proceed(tr, data);
	}

	// TextTransfer
	@SuppressAjWarnings("adviceDidNotMatch")
	void around(TextTransfer tr, Object object, TransferData data):
		execution(void org.eclipse.swt.dnd.TextTransfer.javaToNative(Object, TransferData)) && target(tr)
		&& args(object, data) {
		try {
			if (TeslaEventManager.getManager().hasListeners()
					&& LocalClipboard.isEnabled()) {
				if (object == null || !tr.isSupportedType(data)) {
					data.storedObject = null;
					return;
				}
				data.storedObject = object;
				return;
			}
		} catch (Throwable e) {
			SWTAspectActivator.log(e);
		}
		proceed(tr, object, data);
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	Object around(TextTransfer tr, TransferData data):
		execution(Object org.eclipse.swt.dnd.TextTransfer.nativeToJava(TransferData)) && target(tr)
		&& args(data) {
		try {
			if (TeslaEventManager.getManager().hasListeners()
					&& LocalClipboard.isEnabled()) {
				if (!tr.isSupportedType(data)) {
					return null;
				}
				return data.storedObject;
			}
		} catch (Throwable e) {
			SWTAspectActivator.log(e);
		}
		return proceed(tr, data);
	}

	// URLTransfer
	@SuppressAjWarnings("adviceDidNotMatch")
	void around(URLTransfer tr, Object object, TransferData data):
			execution(void org.eclipse.swt.dnd.URLTransfer.javaToNative(Object, TransferData)) && target(tr)
			&& args(object, data) {
		try {
			if (TeslaEventManager.getManager().hasListeners()
					&& LocalClipboard.isEnabled()) {
				if (object == null || !tr.isSupportedType(data)) {
					data.storedObject = null;
					return;
				}
				data.storedObject = object;
				return;
			}
		} catch (Throwable e) {
			SWTAspectActivator.log(e);
		}
		proceed(tr, object, data);
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	Object around(URLTransfer tr, TransferData data):
			execution(Object org.eclipse.swt.dnd.URLTransfer.nativeToJava(TransferData)) && target(tr)
			&& args(data) {
		try {
			if (TeslaEventManager.getManager().hasListeners()
					&& LocalClipboard.isEnabled()) {
				if (!tr.isSupportedType(data)) {
					return null;
				}
				return data.storedObject;
			}
		} catch (Throwable e) {
			SWTAspectActivator.log(e);
		}
		return proceed(tr, data);
	}
}

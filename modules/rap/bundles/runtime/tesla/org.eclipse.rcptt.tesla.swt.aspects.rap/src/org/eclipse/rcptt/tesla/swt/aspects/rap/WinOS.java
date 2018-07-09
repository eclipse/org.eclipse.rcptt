/*******************************************************************************
 * Copyright (c) 2009, 2016 Xored Software Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Xored Software Inc - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.rcptt.tesla.swt.aspects.rap;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

interface WinOS {
	public static final int WM_ACTIVATE = 0x6;
	public static final int WM_ACTIVATEAPP = 0x1c;
	public static final int WM_APP = 0x8000;
	public static final int WM_DWMCOLORIZATIONCOLORCHANGED = 0x320;
	public static final int WM_CANCELMODE = 0x1f;
	public static final int WM_CAPTURECHANGED = 0x0215;
	public static final int WM_CHANGEUISTATE = 0x0127;
	public static final int WM_CHAR = 0x102;
	public static final int WM_CLEAR = 0x303;
	public static final int WM_CLOSE = 0x10;
	public static final int WM_COMMAND = 0x111;
	public static final int WM_CONTEXTMENU = 0x7b;
	public static final int WM_COPY = 0x301;
	public static final int WM_CREATE = 0x0001;
	public static final int WM_CTLCOLORBTN = 0x135;
	public static final int WM_CTLCOLORDLG = 0x136;
	public static final int WM_CTLCOLOREDIT = 0x133;
	public static final int WM_CTLCOLORLISTBOX = 0x134;
	public static final int WM_CTLCOLORMSGBOX = 0x132;
	public static final int WM_CTLCOLORSCROLLBAR = 0x137;
	public static final int WM_CTLCOLORSTATIC = 0x138;
	public static final int WM_CUT = 0x300;
	public static final int WM_DEADCHAR = 0x103;
	public static final int WM_DESTROY = 0x2;
	public static final int WM_DRAWITEM = 0x2b;
	public static final int WM_ENDSESSION = 0x16;
	public static final int WM_ENTERIDLE = 0x121;
	public static final int WM_ERASEBKGND = 0x14;
	public static final int WM_GETDLGCODE = 0x87;
	public static final int WM_GETFONT = 0x31;
	// public static final int WM_GETICON = 0x7f;
	public static final int WM_GETOBJECT = 0x003D;
	public static final int WM_GETMINMAXINFO = 0x0024;
	public static final int WM_HELP = 0x53;
	public static final int WM_HOTKEY = 0x0312;
	public static final int WM_HSCROLL = 0x114;
	public static final int WM_IME_CHAR = 0x286;
	public static final int WM_IME_COMPOSITION = 0x10f;
	public static final int WM_IME_COMPOSITION_START = 0x010D;
	public static final int WM_IME_ENDCOMPOSITION = 0x010E;
	public static final int WM_INITDIALOG = 0x110;
	public static final int WM_INITMENUPOPUP = 0x117;
	public static final int WM_INPUTLANGCHANGE = 0x51;
	public static final int WM_KEYDOWN = 0x100;
	public static final int WM_KEYFIRST = 0x100;
	public static final int WM_KEYLAST = 0x108;
	public static final int WM_KEYUP = 0x101;
	public static final int WM_KILLFOCUS = 0x8;
	public static final int WM_LBUTTONDBLCLK = 0x203;
	public static final int WM_LBUTTONDOWN = 0x201;
	public static final int WM_LBUTTONUP = 0x202;
	public static final int WM_MBUTTONDBLCLK = 0x209;
	public static final int WM_MBUTTONDOWN = 0x207;
	public static final int WM_MBUTTONUP = 0x208;
	public static final int WM_MEASUREITEM = 0x2c;
	public static final int WM_MENUCHAR = 0x120;
	public static final int WM_MENUSELECT = 0x11f;
	public static final int WM_MOUSEACTIVATE = 0x21;
	public static final int WM_MOUSEFIRST = 0x200;
	public static final int WM_MOUSEHOVER = 0x2a1;
	public static final int WM_MOUSELEAVE = 0x2a3;
	public static final int WM_MOUSEMOVE = 0x200;
	public static final int WM_MOUSEWHEEL = 0x20a;
	public static final int WM_MOUSELAST = 0x20d;
	public static final int WM_MOVE = 0x3;
	public static final int WM_NCACTIVATE = 0x86;
	public static final int WM_NCCALCSIZE = 0x83;
	public static final int WM_NCHITTEST = 0x84;
	public static final int WM_NCLBUTTONDOWN = 0x00A1;
	public static final int WM_NCPAINT = 0x85;
	public static final int WM_NOTIFY = 0x4e;
	public static final int WM_NULL = 0x0;
	public static final int WM_PAINT = 0xf;
	public static final int WM_PALETTECHANGED = 0x311;
	public static final int WM_PARENTNOTIFY = 0x0210;
	public static final int WM_PASTE = 0x302;
	public static final int WM_PRINT = 0x0317;
	public static final int WM_PRINTCLIENT = 0x0318;
	public static final int WM_QUERYENDSESSION = 0x11;
	public static final int WM_QUERYNEWPALETTE = 0x30f;
	public static final int WM_QUERYOPEN = 0x13;
	public static final int WM_QUERYUISTATE = 0x129;
	public static final int WM_RBUTTONDBLCLK = 0x206;
	public static final int WM_RBUTTONDOWN = 0x204;
	public static final int WM_RBUTTONUP = 0x205;
	public static final int WM_SETCURSOR = 0x20;
	public static final int WM_SETFOCUS = 0x7;
	public static final int WM_SETFONT = 0x30;
	public static final int WM_SETICON = 0x80;
	public static final int WM_SETREDRAW = 0xb;
	public static final int WM_SETTEXT = 12;
	public static final int WM_SETTINGCHANGE = 0x1A;
	public static final int WM_SHOWWINDOW = 0x18;
	public static final int WM_SIZE = 0x5;
	public static final int WM_SYSCHAR = 0x106;
	public static final int WM_SYSCOLORCHANGE = 0x15;
	public static final int WM_SYSCOMMAND = 0x112;
	public static final int WM_SYSKEYDOWN = 0x104;
	public static final int WM_SYSKEYUP = 0x105;
	public static final int WM_TIMER = 0x113;
	public static final int WM_THEMECHANGED = 0x031a;
	public static final int WM_UNDO = 0x304;
	public static final int WM_UPDATEUISTATE = 0x0128;
	public static final int WM_USER = 0x400;
	public static final int WM_VSCROLL = 0x115;
	public static final int WM_WINDOWPOSCHANGED = 0x47;
	public static final int WM_WINDOWPOSCHANGING = 0x46;
	public static final int WS_BORDER = 0x800000;
	public static final int WS_CAPTION = 0xc00000;
	public static final int WS_CHILD = 0x40000000;
	public static final int WS_CLIPCHILDREN = 0x2000000;
	public static final int WS_CLIPSIBLINGS = 0x4000000;
	public static final int WS_DISABLED = 0x4000000;
	public static final int WS_EX_APPWINDOW = 0x40000;
	public static final int WS_EX_CAPTIONOKBTN = 0x80000000;
	public static final int WS_EX_CLIENTEDGE = 0x200;
	public static final int WS_EX_COMPOSITED = 0x2000000;
	public static final int WS_EX_DLGMODALFRAME = 0x1;
	public static final int WS_EX_LAYERED = 0x00080000;
	public static final int WS_EX_LAYOUTRTL = 0x00400000;
	public static final int WS_EX_LEFTSCROLLBAR = 0x00004000;
	public static final int WS_EX_MDICHILD = 0x00000040;
	public static final int WS_EX_NOINHERITLAYOUT = 0x00100000;
	public static final int WS_EX_NOACTIVATE = 0x08000000;
	public static final int WS_EX_RIGHT = 0x00001000;
	public static final int WS_EX_RTLREADING = 0x00002000;
	public static final int WS_EX_STATICEDGE = 0x20000;
	public static final int WS_EX_TOOLWINDOW = 0x80;
	public static final int WS_EX_TOPMOST = 0x8;
	public static final int WS_EX_TRANSPARENT = 0x20;
	public static final int WS_HSCROLL = 0x100000;
	public static final int WS_MAXIMIZEBOX = 0x10000;
	public static final int WS_MINIMIZEBOX = 0x20000;
	public static final int WS_OVERLAPPED = 0x0;
	public static final int WS_OVERLAPPEDWINDOW = 0xcf0000;
	public static final int WS_POPUP = 0x80000000;
	public static final int WS_SYSMENU = 0x80000;
	public static final int WS_TABSTOP = 0x10000;
	public static final int WS_THICKFRAME = 0x40000;
	public static final int WS_VISIBLE = 0x10000000;
	public static final int WS_VSCROLL = 0x200000;
	public static final int WM_XBUTTONDOWN = 0x020B;
	public static final int WM_XBUTTONUP = 0x020C;
	public static final int WM_XBUTTONDBLCLK = 0x020D;
	public static final int XBUTTON1 = 0x1;
	public static final int XBUTTON2 = 0x2;

	public static class RecordedEvent {
		int type;

		public RecordedEvent(int type) {
			this.type = type;
		}

		@Override
		public String toString() {
			Field[] fields = WinOS.class.getDeclaredFields();
			String opName = null;
			for (Field field : fields) {
				if ((field.getModifiers() & Modifier.STATIC) != 0
						&& field.getType().getName().equals("int")) {
					try {
						Integer value = (Integer) field.get(null);
						if (value.intValue() == type) {
							opName = field.getName();
							break;
						}
					} catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			String t = "" + type;
			if (opName != null) {
				t = opName + "(" + type + ")";
			}
			return "event:" + t;
		}
	}
}
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
package org.eclipse.rcptt.tesla.recording.core.ecl.parser;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.core.CoreFactory;
import org.eclipse.rcptt.ecl.core.Sequence;
import org.eclipse.rcptt.ecl.core.util.EclRefactoring;
import org.eclipse.rcptt.tesla.core.protocol.ActivateCellEditor;
import org.eclipse.rcptt.tesla.core.protocol.ApplyCellEditor;
import org.eclipse.rcptt.tesla.core.protocol.Assert;
import org.eclipse.rcptt.tesla.core.protocol.AssertImageData;
import org.eclipse.rcptt.tesla.core.protocol.AssertionModeRequest;
import org.eclipse.rcptt.tesla.core.protocol.CancelCellEditor;
import org.eclipse.rcptt.tesla.core.protocol.Check;
import org.eclipse.rcptt.tesla.core.protocol.CheckItem;
import org.eclipse.rcptt.tesla.core.protocol.Click;
import org.eclipse.rcptt.tesla.core.protocol.ClickAboutMenu;
import org.eclipse.rcptt.tesla.core.protocol.ClickColumn;
import org.eclipse.rcptt.tesla.core.protocol.ClickLink;
import org.eclipse.rcptt.tesla.core.protocol.ClickPreferencesMenu;
import org.eclipse.rcptt.tesla.core.protocol.ClickText;
import org.eclipse.rcptt.tesla.core.protocol.Close;
import org.eclipse.rcptt.tesla.core.protocol.Collapse;
import org.eclipse.rcptt.tesla.core.protocol.DeactivateCellEditor;
import org.eclipse.rcptt.tesla.core.protocol.DoubleClick;
import org.eclipse.rcptt.tesla.core.protocol.DragCommand;
import org.eclipse.rcptt.tesla.core.protocol.ElementKind;
import org.eclipse.rcptt.tesla.core.protocol.Expand;
import org.eclipse.rcptt.tesla.core.protocol.GetState;
import org.eclipse.rcptt.tesla.core.protocol.HoverAtText;
import org.eclipse.rcptt.tesla.core.protocol.HoverAtTextOffset;
import org.eclipse.rcptt.tesla.core.protocol.Maximize;
import org.eclipse.rcptt.tesla.core.protocol.Minimize;
import org.eclipse.rcptt.tesla.core.protocol.MouseEvent;
import org.eclipse.rcptt.tesla.core.protocol.MouseEventKind;
import org.eclipse.rcptt.tesla.core.protocol.OpenDeclaration;
import org.eclipse.rcptt.tesla.core.protocol.ProtocolPackage;
import org.eclipse.rcptt.tesla.core.protocol.RecordingModeRequest;
import org.eclipse.rcptt.tesla.core.protocol.Restore;
import org.eclipse.rcptt.tesla.core.protocol.RollbackToState;
import org.eclipse.rcptt.tesla.core.protocol.RulerClick;
import org.eclipse.rcptt.tesla.core.protocol.RulerDoubleClick;
import org.eclipse.rcptt.tesla.core.protocol.RulerHover;
import org.eclipse.rcptt.tesla.core.protocol.SelectCommand;
import org.eclipse.rcptt.tesla.core.protocol.SetCursorOffset;
import org.eclipse.rcptt.tesla.core.protocol.SetFocus;
import org.eclipse.rcptt.tesla.core.protocol.SetSWTDialogInfo;
import org.eclipse.rcptt.tesla.core.protocol.SetSelection;
import org.eclipse.rcptt.tesla.core.protocol.SetStatusDialogMode;
import org.eclipse.rcptt.tesla.core.protocol.SetText;
import org.eclipse.rcptt.tesla.core.protocol.SetTextOffset;
import org.eclipse.rcptt.tesla.core.protocol.SetTextSelection;
import org.eclipse.rcptt.tesla.core.protocol.SetTextSelection2;
import org.eclipse.rcptt.tesla.core.protocol.ShowContentAssist;
import org.eclipse.rcptt.tesla.core.protocol.ShowTabList;
import org.eclipse.rcptt.tesla.core.protocol.Type;
import org.eclipse.rcptt.tesla.core.protocol.TypeAction;
import org.eclipse.rcptt.tesla.core.protocol.TypeText;
import org.eclipse.rcptt.tesla.core.protocol.WaitForRestart;
import org.eclipse.rcptt.tesla.core.protocol.WaitForState;
import org.eclipse.rcptt.tesla.core.protocol.diagram.ActivateDirectEdit;
import org.eclipse.rcptt.tesla.core.protocol.diagram.CancelDirectEdit;
import org.eclipse.rcptt.tesla.core.protocol.diagram.CommitDirectEdit;
import org.eclipse.rcptt.tesla.core.protocol.diagram.DiagramPackage;
import org.eclipse.rcptt.tesla.core.protocol.diagram.FigureMouseCommand;
import org.eclipse.rcptt.tesla.core.protocol.diagram.MouseCommand;
import org.eclipse.rcptt.tesla.core.protocol.raw.Element;
import org.eclipse.rcptt.tesla.core.protocol.raw.TeslaScenario;
import org.eclipse.rcptt.tesla.ecl.TeslaEclUtils;
import org.eclipse.rcptt.tesla.ecl.TeslaScriptletFactory;
import org.eclipse.rcptt.tesla.ecl.model.Button;
import org.eclipse.rcptt.tesla.ecl.model.Decrypt;
import org.eclipse.rcptt.tesla.ecl.model.ExecWithOptions;
import org.eclipse.rcptt.tesla.ecl.model.FromRawKey;
import org.eclipse.rcptt.tesla.ecl.model.GetProperty;
import org.eclipse.rcptt.tesla.ecl.model.KeyType;
import org.eclipse.rcptt.tesla.ecl.model.Mouse;
import org.eclipse.rcptt.tesla.ecl.model.Options;
import org.eclipse.rcptt.tesla.ecl.model.Selector;
import org.eclipse.rcptt.tesla.ecl.model.TeslaFactory;
import org.eclipse.rcptt.tesla.ecl.model.TeslaPackage;
import org.eclipse.rcptt.tesla.ecl.model.TypeCommandKey;
import org.eclipse.rcptt.tesla.internal.core.SimpleCommandPrinter;
import org.eclipse.rcptt.tesla.recording.core.ecl.KeyStrokeManager;
import org.eclipse.rcptt.tesla.recording.core.ecl.TeslaCommand;
import org.eclipse.rcptt.tesla.recording.core.ecl.TeslaRecordingPlugin;
import org.eclipse.rcptt.tesla.recording.core.internal.ecl.DiagramUtils;
import org.eclipse.rcptt.tesla.recording.core.internal.ecl.KeyStrokeUtil;
import org.eclipse.rcptt.tesla.recording.core.internal.ecl.SWTCopy;
import org.eclipse.rcptt.tesla.recording.core.internal.ecl.TeslaSelectorParser;
import org.eclipse.rcptt.util.Base64;
import org.eclipse.rcptt.util.KeysAndButtons;

public class TeslaParser extends TeslaScriptletFactory {

	private final static int DROP_COPY = 1 << 0;
	private final static int DROP_TARGET_MOVE = 1 << 3;
	private final static int DROP_MOVE = 1 << 1;
	private final static int DROP_LINK = 1 << 2;
	private final static int DROP_DEFAULT = 1 << 4;

	public static class RuleMap {

		private static Map<EClass, Method> ruleMap;

		public static Method ruleFor(EClass eClass) {
			if (ruleMap == null)
				init();
			Method rule = ruleMap.get(eClass);
			if (rule != null)
				return rule;
			return null;
		}

		private synchronized static void init() {
			ruleMap = new HashMap<EClass, Method>();
			putRulesFrom(TeslaParser.class);

			// check extensions
			initExtensions();
			for (Object ext : extensions) {
				putRulesFrom(ext.getClass());
			}
		}

		private static void putRulesFrom(Class<?> klass) throws AssertionError {
			Method[] declaredMethods = klass.getDeclaredMethods();
			for (Method method : declaredMethods) {
				TeslaCommand teslaCommand = method
						.getAnnotation(TeslaCommand.class);
				if (teslaCommand == null)
					continue;
				EPackage ePackage = EPackage.Registry.INSTANCE
						.getEPackage(teslaCommand.packageUri());
				EClass eClass = (EClass) ePackage.getEClassifier(teslaCommand
						.classifier());
				if (ruleMap.put(eClass, method) != null) {
					throw new AssertionError();
				}
			}
		}

		// extensions stuff

		private static final String EXTENSION_ID = "org.eclipse.rcptt.tesla.recording.core.ecl.parserExtension"; //$NON-NLS-1$
		private static final List<Object> extensions = new ArrayList<Object>();

		// copied from TeslaSelectorParser // TODO extract as util
		private static void initExtensions() {
			IConfigurationElement[] config = Platform.getExtensionRegistry()
					.getConfigurationElementsFor(EXTENSION_ID);
			try {
				for (IConfigurationElement element : config) {
					final Object extension = element.createExecutableExtension("class"); //$NON-NLS-1$
					extensions.add(extension);
				}
			} catch (CoreException e) {
				TeslaRecordingPlugin.log("Error while get tesla parser extension.", e); //$NON-NLS-1$
			}
		}
	}

	List<org.eclipse.rcptt.tesla.core.protocol.raw.Command> teslaCommands;
	private List<Command> script;
	int pos;
	private TeslaSelectorParser selectorParser;

	public Command teslaScenario(TeslaScenario scenario, Integer target) {
		if (scenario == null)
			return seq();
		// To prevent any modifications of original object
		// eclipse 3.4 compatibility:
		// EcoreUtil.copy raise exception if argument is null
		scenario = (TeslaScenario) EcoreUtil.copy(scenario);
		selectorParser = new TeslaSelectorParser(scenario);
		selectorParser.parse();
		teslaCommands = scenario.getCommands();
		pos = 0;
		script = new ArrayList<Command>();
		while (target == null || pos < target) {
			if (pos >= teslaCommands.size()) {// End of commands
				break;
			}
			Command newCommand = teslaCommand();
			if (newCommand != null) {
				script.add(newCommand);
			}
		}
		Sequence seq = CoreFactory.eINSTANCE.createSequence();
		List<Command> withified = EclRefactoring.withify(script,
				new Comparator<Command>() {
					public int compare(Command c1, Command c2) {
						if (c1 instanceof Selector && c2 instanceof Selector) {
							Selector s1 = (Selector) c1;
							Selector s2 = (Selector) c2;
							if (s1.getId() != null && s2.getId() != null)
								return s1.getId().compareTo(s2.getId());
						}
						return 1;
					}
				});
		seq.getCommands().addAll(DiagramUtils.updateSelectors(withified));
		// seq.getCommands().addAll(script);
		return TeslaScriptletFactory.makeSeq(seq);
	}

	/**
	 * @throws IndexOutOfBoundsException
	 *             if there's no more tesla commands to convert
	 * @return ECL command
	 */
	protected Command teslaCommand() {
		org.eclipse.rcptt.tesla.core.protocol.raw.Command teslaCommand = teslaCommands
				.get(pos);
		pos++;
		Method rule = RuleMap.ruleFor(teslaCommand.eClass());
		if (rule != null) {
			try {
				if (rule.getDeclaringClass().equals(getClass()))
					return (Command) rule.invoke(this, teslaCommand);
				else
					return (Command) rule.invoke(null, this, teslaCommand); // from
																			// extension
			} catch (InvocationTargetException e) {
				Throwable t = e.getTargetException();
				TeslaRecordingPlugin.log(t.getMessage(), t);
			} catch (Throwable t) {
				TeslaRecordingPlugin.log(t.getMessage(), t);
			}
		}
		return TeslaScriptletFactory.unsupported(SimpleCommandPrinter
				.toString(teslaCommand));
	}

	@TeslaCommand(packageUri = ProtocolPackage.eNS_URI, classifier = "SelectCommand")
	protected Command selectCommand(SelectCommand selectCommand) {
		return null;
	}

	@TeslaCommand(packageUri = ProtocolPackage.eNS_URI, classifier = "GetState")
	protected Command getState(GetState c) {
		return null;
	}

	@TeslaCommand(packageUri = ProtocolPackage.eNS_URI, classifier = "WaitForState")
	protected Command waitForState(WaitForState c) {
		// reset();
		return null;
	}

	@TeslaCommand(packageUri = ProtocolPackage.eNS_URI, classifier = "RollbackToState")
	protected Command rollbackToState(RollbackToState c) {
		return null;
	}

	@TeslaCommand(packageUri = ProtocolPackage.eNS_URI, classifier = "Click")
	protected Command click(Click c) {
		return TeslaScriptletFactory.makePipe(
				selectorOf(c.getElement()),
				TeslaScriptletFactory.makeClick(true, c.isDefault(),
						c.isArrow()));
	}

	@TeslaCommand(packageUri = ProtocolPackage.eNS_URI, classifier = "ClickColumn")
	protected Command clickColumn(ClickColumn c) {
		return TeslaScriptletFactory
				.makePipe(
						selectorOf(c.getElement()),
						TeslaScriptletFactory.makeClickColumn(c.getName(),
								c.getIndex()));

	}

	@TeslaCommand(packageUri = ProtocolPackage.eNS_URI, classifier = "DoubleClick")
	protected Command doubleClick(DoubleClick c) {
		return TeslaScriptletFactory.makePipe(selectorOf(c.getElement()),
				TeslaScriptletFactory.makeDoubleClick(true));
	}

	@TeslaCommand(packageUri = ProtocolPackage.eNS_URI, classifier = "SetText")
	protected Command setText(SetText c) {
		if (c.getElement().getKind().equals(ElementKind.DateTime.name())
				|| c.getElement().getKind().equals(ElementKind.Slider.name())) {
			return TeslaScriptletFactory.makePipe(selectorOf(c.getElement()),
					TeslaScriptletFactory.makeSetValue(c.getValue()));
		}

		org.eclipse.rcptt.tesla.ecl.model.SetText cmd = TeslaFactory.eINSTANCE.createSetText();
		if (c.isHidden()) {
			bind(cmd, TeslaPackage.eINSTANCE.getSetText_Text(), decrypt(c.getValue()));
		} else {
			cmd.setText(c.getValue());
		}
		return TeslaScriptletFactory.makePipe(selectorOf(c.getElement()),
				cmd);
	}

	protected Command decrypt(String rawdata) {
		Decrypt cmd = TeslaFactory.eINSTANCE.createDecrypt();
		cmd.setValue(rawdata);
		return cmd;
	}

	@TeslaCommand(packageUri = ProtocolPackage.eNS_URI, classifier = "SetTextSelection")
	protected Command setTextSelection(SetTextSelection c) {
		if (c.getEndline() != null && c.getEndoffset() != null) {

			return TeslaScriptletFactory.makePipe(selectorOf(c.getElement()),
					TeslaScriptletFactory.makeSetTextSelection(
							c.getStartLine(), c.getOffset(), c.getEndline(),
							c.getEndoffset()));
		}
		return TeslaScriptletFactory.makePipe(
				selectorOf(c.getElement()),
				TeslaScriptletFactory.makeSetTextSelection(c.getOffset(),
						c.getLength()));
	}

	@TeslaCommand(packageUri = ProtocolPackage.eNS_URI, classifier = "TypeText")
	protected Command typeText(TypeText c) {
		return TeslaScriptletFactory.makePipe(
				selectorOf(c.getElement()),
				TeslaScriptletFactory.makeTypeText(c.getText(),
						c.isFromDisplay()));
	}

	@TeslaCommand(packageUri = ProtocolPackage.eNS_URI, classifier = "Type")
	protected Command type(Type c) {
		KeyType kt = TeslaFactory.eINSTANCE.createKeyType();
		kt.setDisplay(c.isFromDisplay());
		kt.setTimes(c.getTimes());
		int mask = c.getState();
		int keyCode = c.getCode();
		char ch = c.getCharacter();
		int meta = 0;
		if (c.getMeta() != null)
			meta = c.getMeta();

		if ((keyCode & SWTCopy.MODIFIER_MASK) == keyCode && ch == 0)
			kt.setChar(null);
		else {
			if (keyCode >= SWTCopy.ARROW_UP && keyCode <= SWTCopy.PRINT_SCREEN
					&& ch == 0)
				kt.setChar(null);
			else if ((mask & SWTCopy.SHIFT) != 0
					&& (mask & SWTCopy.CTRL) != 0
					&& ch + 0x40 == keyCode
					&& (Character.toLowerCase(ch) < 0x20 || Character
							.toLowerCase(ch) == 0x7F)
					&& (keyCode & SWTCopy.KEYCODE_BIT) == 0) {
				kt.setChar(null);
			} else if ((mask & SWTCopy.CTRL) != 0
					&& ch + 0x40 == Character.toUpperCase(keyCode)
					&& (ch < 0x20 || ch == 0x7F)
					&& (keyCode & SWTCopy.KEYCODE_BIT) == 0) {
				kt.setChar(null);
			} else if ((mask & SWTCopy.SHIFT) != 0
					&& ch == Character.toUpperCase(keyCode))
				kt.setChar(null);
			else if (ch == keyCode)
				kt.setChar(null);
			else {
				if (ch >= '\u0020' && ch <= '\u007e')
					kt.setChar(String.valueOf(ch));
				else
					kt.setChar(String.format("\\u%04X", (int) ch));
			}
		}

		if (!c.isTraverse()) {
			try {
				kt.setKey(KeyStrokeManager.getUtils().formatKeyWithMeta(mask, keyCode, meta));
			} catch (Throwable e) {
				// jface is not available
				FromRawKey frk = TeslaFactory.eINSTANCE.createFromRawKey();
				frk.setKeyCode(keyCode);
				frk.setMeta(meta);
				frk.setMask(mask);
				kt = bind(kt, TeslaPackage.eINSTANCE.getKeyType_Key(), frk);
			}
			if (kt.getKey() != null) {
				kt.setKey(TeslaEclUtils.getKeyAlias(kt.getKey()));
			}
		} else {
			kt.setKey(KeyStrokeUtil.formatTraverse(keyCode));
			if (keyCode != SWTCopy.TRAVERSE_MNEMONIC)
				kt.setChar(null);
		}
		return TeslaScriptletFactory.makePipe(
				selectorOf(c.getElement(), false), kt);
	}

	@TeslaCommand(packageUri = ProtocolPackage.eNS_URI, classifier = "TypeAction")
	protected Command typeAction(TypeAction c) {
		TypeCommandKey tck = TeslaFactory.eINSTANCE.createTypeCommandKey();
		tck.setCommandId(c.getActionId());
		return TeslaScriptletFactory.makePipe(selectorOf(c.getElement()), tck);
	}

	@TeslaCommand(packageUri = ProtocolPackage.eNS_URI, classifier = "SetSelection")
	public Command setSelection(SetSelection c) {
		return new SetSelectionParser().parse(c, this);
	}

	@TeslaCommand(packageUri = ProtocolPackage.eNS_URI, classifier = "CheckItem")
	protected Command checkItem(CheckItem c) {
		if (c.getPath() != null && !c.getPath().isEmpty()) {
			Command item = TeslaParserUtil.makeItem(c.getPath());
			return TeslaScriptletFactory.makePipe(selectorOf(c.getElement()),
					item, c.isState() ? TeslaScriptletFactory.makeCheck()
							: TeslaScriptletFactory.makeUncheck());
		} else {
			return TeslaScriptletFactory.makePipe(selectorOf(c.getElement()), c
					.isState() ? TeslaScriptletFactory.makeCheck()
							: TeslaScriptletFactory.makeUncheck());
		}
	}

	@TeslaCommand(packageUri = ProtocolPackage.eNS_URI, classifier = "Check")
	protected Command checkItem(Check c) {
		return TeslaScriptletFactory.makePipe(selectorOf(c.getElement()), c
				.isState() ? TeslaScriptletFactory.makeCheck()
						: TeslaScriptletFactory.makeUncheck());
	}

	@TeslaCommand(packageUri = ProtocolPackage.eNS_URI, classifier = "Close")
	protected Command close(Close c) {
		return TeslaScriptletFactory.makePipe(selectorOf(c.getElement()),
				TeslaScriptletFactory.makeClose());
	}

	@TeslaCommand(packageUri = ProtocolPackage.eNS_URI, classifier = "SetStatusDialogMode")
	protected Command setStatusDialogMode(SetStatusDialogMode c) {
		Options opts = TeslaScriptletFactory.makeOptions();
		opts.setAllowStatusDialog(c.isEnabled());
		if (c.isEnabled()) {
			List<Command> sequence = new ArrayList<Command>();
			while (true) {
				if (pos >= teslaCommands.size()) {// End of commands
					break;
				}
				Command nextCmd = teslaCommand();
				if (nextCmd instanceof Options) {
					if (((Options) nextCmd).isAllowStatusDialog() == false) {
						break;// We found end command
					}
				}
				sequence.add(nextCmd);
			}
			if (sequence.size() > 0) {
				// opts.setCommand(makeSeq(sequence));
				ExecWithOptions exec = TeslaScriptletFactory
						.makeExecWithOptions();
				exec.setAllowStatusDialog(opts.isAllowStatusDialog());
				exec.setCommand(makeSeq(sequence));
				return exec;
			}

		}
		return opts;
	}

	@TeslaCommand(packageUri = ProtocolPackage.eNS_URI, classifier = "Minimize")
	protected Command minimize(Minimize c) {
		return TeslaScriptletFactory.makePipe(selectorOf(c.getElement()),
				TeslaFactory.eINSTANCE.createMinimize());
	}

	@TeslaCommand(packageUri = ProtocolPackage.eNS_URI, classifier = "Maximize")
	protected Command maximize(Maximize c) {
		return TeslaScriptletFactory.makePipe(selectorOf(c.getElement()),
				TeslaFactory.eINSTANCE.createMaximize());
	}

	@TeslaCommand(packageUri = ProtocolPackage.eNS_URI, classifier = "Restore")
	protected Command restore(Restore c) {
		return TeslaScriptletFactory.makePipe(selectorOf(c.getElement()),
				TeslaFactory.eINSTANCE.createRestore());
	}

	@TeslaCommand(packageUri = ProtocolPackage.eNS_URI, classifier = "ShowTabList")
	protected Command showTabList(ShowTabList c) {
		return TeslaScriptletFactory.makePipe(selectorOf(c.getElement()),
				TeslaFactory.eINSTANCE.createShowTabList());
	}

	private static String formatDetail(int detail) {
		switch (detail) {
		case DROP_COPY:
			return "copy";
		case DROP_MOVE:
			return "move";
		case DROP_LINK:
			return "link";
		case DROP_TARGET_MOVE:
			return "target-move";
		case DROP_DEFAULT:
			return "any";
		default:
			return "none";
		}
	}

	@TeslaCommand(packageUri = ProtocolPackage.eNS_URI, classifier = "DragCommand")
	protected Command dragCommand(DragCommand c) {
		String[] split = c.getStyle().split(",");
		String detail = null;
		Integer operations = null;
		Button button = null;
		String mask = null;
		for (String var : split) {
			String[] strings = var.split(":");
			int val = Integer.parseInt(strings[1]);
			if (strings[0].equals("detail"))
				detail = formatDetail(val);
			if (strings[0].equals("button"))
				button = Button.values()[val];
			if (strings[0].equals("mask"))
				if (val != 0) {
					mask = KeyStrokeManager.getUtils().getMask(val);
				} else
					mask = null;
			if (strings[0].equals("operations"))
				operations = val;
		}
		Command drag = null;
		Integer x = c.getX();
		Integer y = c.getY();
		switch (c.getKind()) {
		case ACCEPT:
			drag = TeslaScriptletFactory.makeDragAccept(x, y, detail,
					operations, mask, button);
			break;
		case DETECT:
			drag = TeslaScriptletFactory.makeDragDetect(x, y, detail,
					operations, mask, button);
			break;
		case DROP:
			drag = TeslaScriptletFactory.makeDrop(x, y, detail, operations,
					mask, button);
			break;
		case END:
			drag = TeslaScriptletFactory.makeDragEnd(x, y, detail, operations,
					mask, button);
			break;
		case ENTER:
			drag = TeslaScriptletFactory.makeDragEnter(x, y, detail,
					operations, mask, button);
			break;
		case LEAVE:
			drag = TeslaScriptletFactory.makeDragExit(x, y, detail, operations,
					mask, button);
			break;
		case OVER:
			drag = TeslaScriptletFactory.makeDragOver(x, y, detail, operations,
					mask, button);
			break;
		case SET_DATA:
			drag = TeslaScriptletFactory.makeDragSetData(x, y, detail,
					operations, mask, button);
			break;
		case START:
			drag = TeslaScriptletFactory.makeDragStart(x, y, detail,
					operations, mask, button);
			break;
		}
		return TeslaScriptletFactory.makePipe(selectorOf(c.getElement()), drag);
	}

	@TeslaCommand(packageUri = ProtocolPackage.eNS_URI, classifier = "SetSWTDialogInfo")
	protected Command setSWTCopyDialogInfo(SetSWTDialogInfo c) {
		String kind = null;
		switch (c.getKind()) {
		case COLOR:
			kind = "Color";
			break;
		case FILE_SELECTOR:
			kind = "File";
			break;
		case FONT_DIALOG:
			kind = "Font";
			break;
		case FOLDER_SELECTOR:
			kind = "Folder";
			break;
		case MESSAGE_BOX:
			kind = "MessageBox";
			break;
		}
		return TeslaScriptletFactory.makeDialogReturns(kind, c.getPath());
	}

	@TeslaCommand(packageUri = ProtocolPackage.eNS_URI, classifier = "SetTextOffset")
	protected Command setTextOffset(SetTextOffset c) {
		return TeslaScriptletFactory.makePipe(
				selectorOf(c.getElement()),
				TeslaScriptletFactory.makeSetTextOffset(c.getLine(),
						c.getOffset()));
	}

	@TeslaCommand(packageUri = ProtocolPackage.eNS_URI, classifier = "SetCursorOffset")
	protected Command setTextOffset(SetCursorOffset c) {
		return TeslaScriptletFactory.makePipe(
				selectorOf(c.getElement()),
				TeslaScriptletFactory.makeSetCaretPos(c.getLine(),
						c.getOffset()));
	}

	@TeslaCommand(packageUri = ProtocolPackage.eNS_URI, classifier = "SetTextSelection2")
	protected Command selectText(SetTextSelection2 c) {
		return TeslaScriptletFactory.makePipe(
				selectorOf(c.getElement()),
				TeslaScriptletFactory.makeSelectRange(c.getStartLine(),
						c.getStartOffset(), c.getEndLine(), c.getEndOffset()));
	}

	@TeslaCommand(packageUri = ProtocolPackage.eNS_URI, classifier = "HoverAtTextOffset")
	protected Command hoverAtTextOffset(HoverAtTextOffset c) {
		return TeslaScriptletFactory.makePipe(
				selectorOf(c.getElement()),
				TeslaScriptletFactory.makeHoverAtTextOffset(c.getLine(),
						c.getOffset()));
	}

	@TeslaCommand(packageUri = ProtocolPackage.eNS_URI, classifier = "HoverAtText")
	protected Command hoverAtTextOffset(HoverAtText c) {
		return TeslaScriptletFactory.makePipe(selectorOf(c.getElement()),
				TeslaScriptletFactory.makeHoverText(c.getLine(), c.getOffset(),
						c.getStateMask()));
	}

	@TeslaCommand(packageUri = ProtocolPackage.eNS_URI, classifier = "RulerClick")
	protected Command rulerClick(RulerClick c) {
		return TeslaScriptletFactory.makePipe(
				selectorOf(c.getElement()),
				TeslaScriptletFactory.makeClickRuler(c.getLine(),
						Button.values()[c.getButton()], c.getStateMask()));
	}

	@TeslaCommand(packageUri = ProtocolPackage.eNS_URI, classifier = "RulerDoubleClick")
	protected Command rulerDoubleClick(RulerDoubleClick c) {
		return TeslaScriptletFactory.makePipe(
				selectorOf(c.getElement()),
				TeslaScriptletFactory.makeDoubleClickRuler(c.getLine(),
						Button.values()[c.getButton()], c.getStateMask()));
	}

	@TeslaCommand(packageUri = ProtocolPackage.eNS_URI, classifier = "RulerHover")
	protected Command rulerHover(RulerHover c) {
		return TeslaScriptletFactory.makePipe(
				selectorOf(c.getElement()),
				TeslaScriptletFactory.makeHoverRuler(c.getLine(),
						c.getStateMask()));
	}

	@TeslaCommand(packageUri = ProtocolPackage.eNS_URI, classifier = "OpenDeclaration")
	protected Command openDeclaration(OpenDeclaration c) {
		return TeslaScriptletFactory.makePipe(selectorOf(c.getElement()),
				TeslaScriptletFactory.makeOpenDeclaration());
	}

	@TeslaCommand(packageUri = DiagramPackage.eNS_URI, classifier = "MouseCommand")
	protected Command mouseCommand(MouseCommand c) {
		Command mouse = null;
		String mask = null;
		if (c.getStateMask() != 0) {
			mask = KeyStrokeManager.getUtils().getMask(c.getStateMask());
		} else
			mask = null;

		Button button = c.getButton() == 0 ? null : Button.values()[c
				.getButton()];
		switch (c.getKind()) {
		case DOWN:
			mouse = TeslaScriptletFactory.makeMousePress(c.getX(), c.getY(),
					button, null, null, mask);
			break;
		case UP:
			mouse = TeslaScriptletFactory.makeMouseRelease(c.getX(), c.getY(),
					button, null, null, mask);
			break;
		case MOVE:
			mouse = TeslaScriptletFactory.makeMouseMove(c.getX(), c.getY(),
					button, null, null, mask);
			break;
		case DOUBLE_CLICK:
			mouse = TeslaScriptletFactory.makeMouseDoubleClick(c.getX(),
					c.getY(), button, null, null, mask);
			break;
		case HOVER:
			mouse = TeslaScriptletFactory.makeMouseHover(c.getX(), c.getY(),
					button, null, null, mask);
			break;
		case DRAG:
			mouse = TeslaScriptletFactory.makeMouseDrag(c.getX(), c.getY(),
					button, null, null, mask);
			break;
		case ENTER:
			mouse = TeslaScriptletFactory.makeMouseEnter(c.getX(), c.getY(),
					button, null, null, mask);
			break;
		case EXIT:
			mouse = TeslaScriptletFactory.makeMouseExit(c.getX(), c.getY(),
					button, null, null, mask);
			break;
		default:
			return TeslaScriptletFactory.unsupported(SimpleCommandPrinter
					.toString(c));
		}
		return TeslaScriptletFactory
				.makePipe(selectorOf(c.getElement()), mouse);
	}

	@TeslaCommand(packageUri = DiagramPackage.eNS_URI, classifier = "FigureMouseCommand")
	protected Command figureMouseCommand(FigureMouseCommand c) {
		List<Integer> partPath = c.getPartPath();
		Command ep = null;
		if (partPath.size() > 0)
			ep = TeslaScriptletFactory.makeEditPart(partPath);

		List<Integer> figurePath = c.getFigurePath();
		Command f = null;
		if (figurePath.size() > 0)
			f = TeslaScriptletFactory.makeFigure(figurePath);

		String mask = null;
		if (c.getStateMask() != 0) {
			mask = KeyStrokeManager.getUtils().getMask(c.getStateMask());
		} else
			mask = null;

		Button button = c.getButton() == 0 ? null : Button.values()[c
				.getButton()];
		Command mouse = null;
		switch (c.getKind()) {
		case DOWN:
			mouse = TeslaScriptletFactory.makeMousePress(c.getX(), c.getY(),
					button, c.getFigureHeight(), c.getFigureWidth(), mask);
			break;
		case UP:
			mouse = TeslaScriptletFactory.makeMouseRelease(c.getX(), c.getY(),
					button, c.getFigureHeight(), c.getFigureWidth(), mask);
			break;
		case MOVE:
			mouse = TeslaScriptletFactory.makeMouseMove(c.getX(), c.getY(),
					button, c.getFigureHeight(), c.getFigureWidth(), mask);
			break;
		case DOUBLE_CLICK:
			mouse = TeslaScriptletFactory.makeMouseDoubleClick(c.getX(),
					c.getY(), button, c.getFigureHeight(), c.getFigureWidth(),
					mask);
			break;
		case HOVER:
			mouse = TeslaScriptletFactory.makeMouseHover(c.getX(), c.getY(),
					button, c.getFigureHeight(), c.getFigureWidth(), mask);
			break;
		case DRAG:
			mouse = TeslaScriptletFactory.makeMouseDrag(c.getX(), c.getY(),
					button, c.getFigureHeight(), c.getFigureWidth(), mask);
			break;
		case ENTER:
			mouse = TeslaScriptletFactory.makeMouseEnter(c.getX(), c.getY(),
					button, c.getFigureHeight(), c.getFigureWidth(), mask);
			break;
		case EXIT:
			mouse = TeslaScriptletFactory.makeMouseExit(c.getX(), c.getY(),
					button, c.getFigureHeight(), c.getFigureWidth(), mask);
			break;
		default:
			return TeslaScriptletFactory.unsupported(SimpleCommandPrinter
					.toString(c));
		}

		return TeslaScriptletFactory.makePipe(selectorOf(c.getElement()), ep,
				f, mouse);
	}

	@TeslaCommand(packageUri = ProtocolPackage.eNS_URI, classifier = "ActivateCellEditor")
	protected Command activateCellEditor(ActivateCellEditor c) {
		Command selector = selectorOf(c.getElement());
		return TeslaScriptletFactory.makePipe(selector,
				TeslaScriptletFactory.makeCellEditorActivate(c.getColumn()));
	}

	@TeslaCommand(packageUri = ProtocolPackage.eNS_URI, classifier = "ApplyCellEditor")
	protected Command applyCellEditor(ApplyCellEditor c) {
		Command selector = selectorOf(c.getElement());
		return TeslaScriptletFactory.makePipe(selector,
				TeslaScriptletFactory.makeCellEditorApply(c.isDeactivate()));
	}

	@TeslaCommand(packageUri = ProtocolPackage.eNS_URI, classifier = "CancelCellEditor")
	protected Command cancelCellEditor(CancelCellEditor c) {
		Command selector = selectorOf(c.getElement());
		return TeslaScriptletFactory.makePipe(selector,
				TeslaScriptletFactory.makeCellEditorCancel());
	}

	@TeslaCommand(packageUri = ProtocolPackage.eNS_URI, classifier = "DeactivateCellEditor")
	protected Command deactivateCellEditor(DeactivateCellEditor c) {
		Command selector = selectorOf(c.getElement());
		return TeslaScriptletFactory.makePipe(selector,
				TeslaScriptletFactory.makeCellEditorDeactivate());
	}

	@TeslaCommand(packageUri = DiagramPackage.eNS_URI, classifier = "ActivateDirectEdit")
	protected Command activateDirectEdit(ActivateDirectEdit c) {
		if (c.getPartPath().isEmpty()) {
			return TeslaScriptletFactory.makePipe(selectorOf(c.getElement()),
					TeslaScriptletFactory.makeDirectEditActivate());
		}
		return TeslaScriptletFactory.makePipe(selectorOf(c.getElement()),
				TeslaScriptletFactory.makeEditPart(c.getPartPath()),
				TeslaScriptletFactory.makeDirectEditActivate());
	}

	@TeslaCommand(packageUri = DiagramPackage.eNS_URI, classifier = "CommitDirectEdit")
	protected Command applyDirectEdit(CommitDirectEdit c) {
		return TeslaScriptletFactory.makePipe(selectorOf(c.getElement()),
				TeslaScriptletFactory.makeDirectEditCommit());
	}

	@TeslaCommand(packageUri = DiagramPackage.eNS_URI, classifier = "CancelDirectEdit")
	protected Command cancelDirectEdit(CancelDirectEdit c) {
		return TeslaScriptletFactory.makePipe(selectorOf(c.getElement()),
				TeslaScriptletFactory.makeDirectEditCancel());
	}

	@TeslaCommand(packageUri = ProtocolPackage.eNS_URI, classifier = "Assert")
	protected Command assertCommand(Assert c) {
		Command s = selectorOf(
				c.getElement(),
				!ElementKind.EclipseWindow.name().equals(c.getElement().getKind()));
		GetProperty prop = makeGetProperty(c.getAttribute());
		prop.setIndex(c.getIndex());
		switch (c.getKind()) {
		case EQUALS:
			return makePipe(s, prop, makeEquals(c.getValue()), makeVerifyTrue());
		case NOT_EQUALS:
			return makePipe(s, prop, makeEquals(c.getValue()),
					makeVerifyFalse());
		case ASSERT_TRUE:
			return makePipe(s, prop, makeVerifyTrue());
		case ASSERT_FALSE:
			return makePipe(s, prop, makeVerifyFalse());
		case IS_EMPTY:
			return makePipe(s, prop, makeIsEmpty(), makeVerifyTrue());
		case NOT_EMPTY:
			return makePipe(s, prop, makeIsEmpty(), makeVerifyFalse());
		case CONTAINS:
			return makePipe(s, prop, makeContains(c.getValue()),
					makeVerifyTrue());
		case NOT_CONTAINS:
			return makePipe(s, prop, makeContains(c.getValue()),
					makeVerifyFalse());
		case REGEXP:
			return makePipe(s, prop, makeMatches(c.getValue()),
					makeVerifyTrue());
		case NOT_REGEXP:
			return makePipe(s, prop, makeMatches(c.getValue()),
					makeVerifyFalse());
		case CONTAINS_IMAGE:
			String fileContent = Base64.encode(c.getImageData()
					.getImage());
			// if (attachments != null) {
			// String existingContent = attachments.getName(fileContent);
			// String file = existingContent != null ? existingContent
			// : attachments.generateName("screenshot", "png");
			// if (existingContent == null) {
			// attachments.addAttachment(file, fileContent, null);
			// }
			// return makePipe(s,
			// makeContainsImage("attachment://" + file, null),
			// makeVerifyTrue());
			// } else {
			return makePipe(s, makeContainsImage("base64://", fileContent),
					makeVerifyTrue());
		// }
		case IMAGE_CONTAINS_TEXT:
			AssertImageData data = c.getImageData();
			return makePipe(
					s,
					makeRegionContainsText(data.getX(), data.getY(),
							data.getSx(), data.getSy(), data.getWidth(),
							data.getHeight()),
					makeContains(c.getValue()),
					makeVerifyTrue());
		default:
			return TeslaScriptletFactory.unsupported(SimpleCommandPrinter
					.toString(c));
		}
	}

	@TeslaCommand(packageUri = ProtocolPackage.eNS_URI, classifier = "ClickLink")
	protected Command clickLink(ClickLink c) {
		org.eclipse.rcptt.tesla.ecl.model.ClickLink result = TeslaFactory.eINSTANCE
				.createClickLink();
		result.setRef(c.getRef());
		return makePipe(selectorOf(c.getElement()), result);
	}

	@TeslaCommand(packageUri = ProtocolPackage.eNS_URI, classifier = "Expand")
	protected Command expand(Expand e) {
		org.eclipse.rcptt.tesla.ecl.model.Expand result = TeslaFactory.eINSTANCE
				.createExpand();
		return makePipe(selectorOf(e.getElement()), result);
	}

	@TeslaCommand(packageUri = ProtocolPackage.eNS_URI, classifier = "Collapse")
	protected Command collapse(Collapse c) {
		org.eclipse.rcptt.tesla.ecl.model.Collapse result = TeslaFactory.eINSTANCE
				.createCollapse();
		return makePipe(selectorOf(c.getElement()), result);
	}

	@TeslaCommand(packageUri = ProtocolPackage.eNS_URI, classifier = "MouseEvent")
	protected Command mouse(MouseEvent m) {
		Mouse result = TeslaFactory.eINSTANCE.createMouse();
		result.setButton(KeysAndButtons.getButtonNameSafe(m.getButton()));
		result.setCount(m.getCount());
		result.setEvent(m.getKind().getLiteral());

		int stateMask = m.getStateMask();
		if (m.getKind() == MouseEventKind.UP) {
			// remove mouse button mask from state
			stateMask &= ~KeysAndButtons.getButtonMaskSafe(m.getButton());
		}
		result.setWith(KeysAndButtons.stateMaskToStr(stateMask));
		result.setX(m.getX());
		result.setY(m.getY());
		return makePipe(selectorOf(m.getElement()), result);
	}

	@TeslaCommand(packageUri = ProtocolPackage.eNS_URI, classifier = "SetFocus")
	protected Command setFocus(SetFocus f) {
		if (f.isValue()) {
			org.eclipse.rcptt.tesla.ecl.model.SetFocus result = TeslaFactory.eINSTANCE
					.createSetFocus();
			return makePipe(selectorOf(f.getElement()), result);
		} else {
			org.eclipse.rcptt.tesla.ecl.model.Unfocus result = TeslaFactory.eINSTANCE
					.createUnfocus();
			return makePipe(selectorOf(f.getElement()), result);
		}
	}

	@TeslaCommand(packageUri = ProtocolPackage.eNS_URI, classifier = "ClickText")
	protected Command clickText(ClickText f) {
		org.eclipse.rcptt.tesla.ecl.model.ClickText result = TeslaFactory.eINSTANCE
				.createClickText();
		result.setStart(f.getStart());
		result.setEnd(f.getEnd());
		result.setButton(f.getButton());
		return makePipe(selectorOf(f.getElement()), result);
	}

	@TeslaCommand(packageUri = ProtocolPackage.eNS_URI, classifier = "WaitForRestart")
	protected Command waitForRestart(WaitForRestart c) {
		return TeslaFactory.eINSTANCE.createWaitUntilEclipseIsReady();
	}

	@TeslaCommand(packageUri = ProtocolPackage.eNS_URI, classifier = "ShowContentAssist")
	protected Command showContentAssist(ShowContentAssist c) {
		return TeslaScriptletFactory.makePipe(selectorOf(c.getElement()),
				TeslaFactory.eINSTANCE.createShowContentAssist());
	}

	@TeslaCommand(packageUri = ProtocolPackage.eNS_URI, classifier = "ClickAboutMenu")
	protected Command clickAboutMenu(ClickAboutMenu c) {
		return TeslaScriptletFactory.makePipe(
				TeslaFactory.eINSTANCE.createGetAboutMenu(),
				TeslaFactory.eINSTANCE.createClick());
	}

	@TeslaCommand(packageUri = ProtocolPackage.eNS_URI, classifier = "ClickPreferencesMenu")
	protected Command clickPreferencesMenu(ClickPreferencesMenu c) {
		return TeslaScriptletFactory.makePipe(
				TeslaFactory.eINSTANCE.createGetPreferencesMenu(),
				TeslaFactory.eINSTANCE.createClick());

	}

	@TeslaCommand(packageUri = ProtocolPackage.eNS_URI, classifier = "RecordingModeRequest")
	protected Command recordingModeRequest(RecordingModeRequest c) {
		return null;
	}

	@TeslaCommand(packageUri = ProtocolPackage.eNS_URI, classifier = "AssertionModeRequest")
	protected Command assertionModeRequest(AssertionModeRequest c) {
		return null;
	}

	protected Command selectorOf(Element e, boolean reduceEclipseWindow) {
		return selectorParser.selectorOf(e, reduceEclipseWindow);
	}

	// public for using it in extensions only
	public Command selectorOf(Element e) {
		return selectorParser.selectorOf(e, true);
	}

	protected <T> boolean match(Class<T> caster) {
		if (pos < 0 || pos >= teslaCommands.size())
			return false;
		org.eclipse.rcptt.tesla.core.protocol.raw.Command command = teslaCommands
				.get(pos);
		return caster.isInstance(command);
	}

}

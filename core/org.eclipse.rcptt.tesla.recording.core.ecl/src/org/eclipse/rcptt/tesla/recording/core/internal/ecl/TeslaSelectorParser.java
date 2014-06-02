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
package org.eclipse.rcptt.tesla.recording.core.internal.ecl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.core.Pipeline;
import org.eclipse.rcptt.ecl.core.util.ScriptletFactory;

import org.eclipse.rcptt.util.Base64;
import org.eclipse.rcptt.tesla.core.protocol.ElementKind;
import org.eclipse.rcptt.tesla.core.protocol.IMLSelectData;
import org.eclipse.rcptt.tesla.core.protocol.IWindowProvider;
import org.eclipse.rcptt.tesla.core.protocol.SelectCommand;
import org.eclipse.rcptt.tesla.core.protocol.SelectData;
import org.eclipse.rcptt.tesla.core.protocol.raw.CommandToElementEntry;
import org.eclipse.rcptt.tesla.core.protocol.raw.Element;
import org.eclipse.rcptt.tesla.core.protocol.raw.TeslaScenario;
import org.eclipse.rcptt.tesla.core.utils.TeslaPathUtils;
import org.eclipse.rcptt.tesla.ecl.TeslaScriptletFactory;
import org.eclipse.rcptt.tesla.ecl.model.GetColumnHeader;
import org.eclipse.rcptt.tesla.ecl.model.GetEclipseWindow;
import org.eclipse.rcptt.tesla.ecl.model.GetPropertyTab;
import org.eclipse.rcptt.tesla.ecl.model.GetRegion;
import org.eclipse.rcptt.tesla.ecl.model.Selector;
import org.eclipse.rcptt.tesla.ecl.model.TeslaFactory;
import org.eclipse.rcptt.tesla.ecl.model.TeslaPackage;
import org.eclipse.rcptt.tesla.recording.core.ecl.ISelectorParserExtension;
import org.eclipse.rcptt.tesla.recording.core.ecl.TeslaRecordingPlugin;
import org.eclipse.rcptt.tesla.recording.core.ecl.parser.TeslaParserUtil;

public class TeslaSelectorParser extends TeslaScriptletFactory {

	private static final String EXTENSION_ID = "org.eclipse.rcptt.tesla.recording.core.ecl.selectorExtension"; //$NON-NLS-1$
	static final List<ISelectorParserExtension> extensions = new ArrayList<ISelectorParserExtension>();

	static {
		initExtensions();
	}

	private static void initExtensions() {
		IConfigurationElement[] config = Platform.getExtensionRegistry()
				.getConfigurationElementsFor(EXTENSION_ID);
		try {
			for (IConfigurationElement element : config) {
				final Object extension = element
						.createExecutableExtension("class"); //$NON-NLS-1$
				if (extension instanceof ISelectorParserExtension) {
					extensions.add((ISelectorParserExtension) extension);
				}
			}
		} catch (CoreException e) {
			TeslaRecordingPlugin.log("Error while get selector extension.", e); //$NON-NLS-1$			
		}
	}

	//

	protected Map<String, Command> elements = new HashMap<String, Command>();
	protected TeslaScenario scenario;

	public TeslaSelectorParser(TeslaScenario scenario) {
		this.scenario = scenario;
	}

	public void parse() {
		init();
		process();
	}

	protected void init() {
	}

	protected void process() {
		List<CommandToElementEntry> entries = scenario.getElementMapping();
		for (CommandToElementEntry entry : entries) {
			org.eclipse.rcptt.tesla.core.protocol.raw.Command command = entry.getCommand();
			if (command instanceof SelectCommand) {
				String id = entry.getElements().get(0).getId();
				Command e = element((SelectCommand) command, id);
				if (e != null) {
					save(id, e);
				}
			}
		}
	}

	protected void save(String id, Command e) {
		Command oldVal = elements.put(id, e);
		if (oldVal != null && !EcoreUtil.equals(e, oldVal))
			throw new IllegalArgumentException("Elements with duplicate id=" + id + " are detected");
	}

	protected Command element(SelectCommand command, String id) {
		SelectData data = command.getData();
		if (data.getKind().equals("CompositeRuler")) {
			data.setKind(ElementKind.VerticalRuler.name());
		}
		if (data.getKind().equals("OverviewRuler")) {
			data.setKind(ElementKind.RightRuler.name());
		}
		ElementKind kind = ElementKind.kindOf(data.getKind());
		if (kind == null) {
			throw new IllegalArgumentException("Null-kind control was detected");
		}
		if (kind == ElementKind.Item) {
			List<Integer> indexes = data.getIndexes();
			if (indexes == null || indexes.isEmpty()) {
				Command selector = TeslaParserUtil.makeItem(data.getPath());
				// index and after are not recorded for items, so skip them
				Command parent = selectorOf(data.getParent());
				if (parent != null) {
					return makePipe(parent, selector);
				}
				return selector;
			}
		}
		if (kind == ElementKind.Menu) {
			Command selector = TeslaParserUtil.makeMenu(data.getPath());
			// index and after are not recorded for menus, so skip them
			Command parent = selectorOf(data.getParent());
			if (parent != null) {
				return makePipe(parent, selector);
			}
			return selector;
		}

		Selector selector = null;

		if (kind == ElementKind.Custom) {
			// Try get selector from extensions
			for (ISelectorParserExtension extension : extensions) {
				selector = extension.selector(
						data.getKind(), data.getPattern(), data.getPath(), data.getIndexes());
				if (selector != null) {
					break;
				}
			}
		}
		if (selector == null) {
			selector = selector(kind, data);
		}

		if (kind.equals(ElementKind.Region) && data instanceof IMLSelectData) {
			selector = selector(kind, ((IMLSelectData) data).getImage(),
					data.getIndexes());
		}
		if (selector == null)
			return null;
		selector.setId(id);
		selector.setIndex(data.getIndex());
		Command parent = selectorOf(data.getParent());
		Command after = selectorOf(data.getAfter());
		if (after instanceof Pipeline) {
			if (parent != null) {
				Command cutAfter = TeslaParserUtil.cut(after, parent);
				if (cutAfter == null) {
					// FIXME workaround for suspicious selectors bug
					EList<Command> afterCommands = ((Pipeline) after)
							.getCommands();
					if (afterCommands.size() > 1) {
						after = afterCommands.get(afterCommands.size() - 1);
					}
				} else {
					after = cutAfter;
				}
			}
		}
		if (after != null) {
			ScriptletFactory.bind(selector,
					TeslaPackage.eINSTANCE.getSelector_After(), after);
		}
		if (parent != null) {
			return makePipe(parent, selector);
		}
		return selector;
	}

	private Selector selector(ElementKind kind, byte[] image,
			EList<Integer> indexes) {
		switch (kind) {
		case Region:
			GetRegion region = makeRegion();
			region.setImageURI("base64://");
			region.setRawImage(Base64.encode(image));
			region.setX(indexes.get(0));
			region.setY(indexes.get(1));
			return region;
		}
		return null;
	}

	protected Selector selector(ElementKind kind, SelectData data) {

		String text = data.getPattern();
		List<String> path = data.getPath();
		List<Integer> indexes = data.getIndexes();
		Integer index = data.getIndex();

		switch (kind) {
		case Button:
			return makeButton(text);
		case Canvas:
			return makeCanvas();
		case CBanner:
			return makeCBanner();
		case Combo:
			return makeCombo();
		case CoolBar:
			return makeCoolbar();
		case DiagramViewer:
			return makeDiagramViewer(index);
		case DiagramFigure:
			if (path.size() == 2) {
				String first = path.get(0);
				String second = path.get(1);
				if ("editpart".equals(first) && "address".equals(second)) {
					return makeEditPart(indexes);
				} else if ("editpart.source.connection".equals(first)
						&& "address".equals(second)) {
					return makeSourceConnection(indexes);
				} else if ("editpart.feature".equals(first)) {
					return makeEditPartByFeature(second, text);
				} else if ("editpart".equals(first)
						&& "classname".equals(second)) {
					return makeEditPartByClassName(text);
				} else if ("handle".equals(first) && "class".equals(second)) {
					return makeHandle(text);
				} else if ("editpart".equals(first) && "name".equals(second)) {
					return makeEditPartByName(text);
				} else if ("editpart".equals(first) && "text".equals(second)) {
					return makeEditPartByText(text);
				} else if ("editpart.target.connection".equals(first)
						&& "address".equals(second)) {
					return makeTargetConnection(indexes);
				} else if ("rawFigure".equals(first)
						&& "address".equals(second)) {
					if (indexes.size() > 0) {
						int value = indexes.get(0);
						switch (value) {
						case -3:
							// Popup bar
							return makePopupBarItem(indexes);
						case -2:
							// Connection
							return makeConnectionHandle(indexes);
						}
					}
					return makeFigure(indexes);
				}
			}
			throw new IllegalArgumentException("Unexpected figure path: "
					+ path.toArray(new String[0]).toString());
		case EclipseWindow:
			if (index != null && index.intValue() != 0) {
				return makeEclipseWindow(index.intValue());
			}
			return null; // do nothing
		case QuickAccess:
			return makeQuickAccess();
		case Editor:
			return makeEditor(text, data.getClassPattern(), index);
		case TextViewer:
			return makeTextViewer();
		case VerticalRuler:
			return makeVerticalRuler();
		case VerticalColumn:
			return makeRulerColumn(text);
		case LeftRuler:
			return makeLeftRuler();
		case RightRuler:
			return makeRightRuler();
		case Expandable:
			return makeExpandable(text);
		case FormText:
			return makeLabel(text);
		case Group:
			return makeGroup(text);
		case Item:
			if (indexes != null && !indexes.isEmpty()) {
				// It's cell
				if (indexes.size() != 2)
					throw new IllegalArgumentException("Invalid cell selector");
				return makeCell(indexes.get(1), indexes.get(0));
			}
			return makeItem(TeslaPathUtils.makePathFromList(path), null);
		case Label:
			return makeLabel(text);
		case Link:
			return makeLink(text);
		case List:
			return makeList();
		case Menu:
			return makeMenu(TeslaPathUtils.makePathFromList(path), null);
		case PaletteViewer:
			return makePaletteViewer();
		case State:
			return null;
		case TabFolder:
			return makeTabFolder();
		case TabItem:
			return makeTabItem(text);
		case Table:
			return makeTable();
		case Text:
			return makeEditbox();
		case Toolbar:
			return makeToolbar();
		case Tree:
			return makeTree();
		case DateTime:
			return makeDateTime();
		case Slider:
			return makeSlider();
		case View:
			return makeView(text);
		case Window: {
			if (path.size() == 2) {
				String first = path.get(0);
				String second = path.get(1);
				if (IWindowProvider.FROM_PATH_MARK.equals(first)) {
					return makeFromedWindow(second);
				} else if (IWindowProvider.CLASS_PATH_MARK.equals(first)) {
					return makeClassedWindow(second);
				}
			}
			return makeWindow(text);
		}
		case PaletteEntry:
			return paletteEntry(text);
		case ColumnHeader:
			return makeColumnHeader(text, index);
		case PropertyTab:
			return makePropertyTab(text);
		case Custom:
			return makeControl(data.getKind(), text);
		default:
			return makeControl(kind.name(), text);
		}
	}

	private Selector makePropertyTab(String text) {
		GetPropertyTab getPropertyTab = TeslaFactory.eINSTANCE
				.createGetPropertyTab();
		getPropertyTab.setText(text);
		return getPropertyTab;
	}

	private Selector makeColumnHeader(String text, Integer index) {
		GetColumnHeader getColumnHeader = TeslaFactory.eINSTANCE
				.createGetColumnHeader();
		getColumnHeader.setText(text);
		getColumnHeader.setIndex(index);
		return getColumnHeader;
	}

	public Command selectorOf(Element element) {
		return selectorOf(element, true);
	}

	public Command selectorOf(Element element, boolean reduceEclipseWindow) {
		if (element == null)
			return null;
		String id = element.getId();
		Command selector = elements.get(id);
		if (ElementKind.EclipseWindow.name().equals(element.getKind())
				&& selector instanceof GetEclipseWindow
				&& (((GetEclipseWindow) selector).getIndex() == null || ((GetEclipseWindow) selector)
						.getIndex().intValue() == 0)) {
			if (reduceEclipseWindow) {
				return null;
			}
		}
		if (selector == null) {
			if (ElementKind.EclipseWindow.name().equals(element.getKind())) {
				if (reduceEclipseWindow) {
					return null;
				}
				return TeslaFactory.eINSTANCE.createGetEclipseWindow();
			}
			return TeslaScriptletFactory.controlNotFound();
		}

		if (element.getKind() != null
				&& element.getKind().equals(ElementKind.Text.name())
				&& element.getDescription() != null
				&& element.getDescription().equals("quick-access"))
			return TeslaFactory.eINSTANCE.createGetQuickAccess();

		// eclipse 3.4 compatibility:
		// EcoreUtil.copy raise exception if argument is null
		return (Command) EcoreUtil.copy(selector);
	}

	public Element elementOf(SelectCommand command) {
		for (CommandToElementEntry entry : scenario.getElementMapping()) {
			if (command.equals(entry.getCommand())) {
				return entry.getElements().get(0);
			}
		}
		// Could not happen because element mapping contains all the selectors
		// that scenario has
		throw new AssertionError();
	}
}

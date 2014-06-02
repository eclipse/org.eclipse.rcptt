package org.eclipse.rcptt.tesla.recording.aspects.gef;

import org.aspectj.lang.annotation.SuppressAjWarnings;
import org.eclipse.gef.EditDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.Request;
import org.eclipse.gef.Tool;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.gef.editparts.AbstractEditPart;
import org.eclipse.gef.tools.DirectEditManager;
import org.eclipse.gef.ui.parts.DomainEventDispatcher;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.events.MouseEvent;

import org.eclipse.rcptt.util.ReflectionUtil;
import org.eclipse.rcptt.tesla.core.am.AspectManager;
import org.eclipse.rcptt.tesla.gef.DirectEditorContainer;
import org.eclipse.rcptt.tesla.gef.TeslaDirectEditManager;

public aspect GefRecordingAspect {
	private DirectEditorContainer lastDirectEdit;

	public GefRecordingAspect() {
		AspectManager.activateAspect(RecordingGefActivator.PLUGIN_ID, this
				.getClass().getName());
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	before(EditPart part, Request request): 
		execution(void EditPart.performRequest (Request)) && target(part) && args(request) {
		try {
			GefEventManager.performRequst(part, request);
		} catch (Throwable e) {
			RecordingGefActivator.log(e);
		}
	}

	// GEF Tools support
	@SuppressAjWarnings("adviceDidNotMatch")
	before(Tool tool): 
		execution(void Tool.activate ()) && target(tool) {
		try {
			GefEventManager.toolActivate(tool);
		} catch (Throwable e) {
			RecordingGefActivator.log(e);
		}
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	before(EditDomain domain, Tool tool): 
		execution(void EditDomain.setActiveTool (Tool)) && target(domain) && args(tool) {
		try {
			GefEventManager.setActiveTool(domain, tool);
		} catch (Throwable e) {
			RecordingGefActivator.log(e);
		}
	}

	// Figure creation support
	@SuppressAjWarnings("adviceDidNotMatch")
	after(AbstractEditPart part, EditPart child, int index):
		execution(protected void AbstractEditPart.addChild(EditPart, int)) && target(part) && args(child, index) {
		try {
			GefEventManager.notifyAddChild(part, child, index);
		} catch (Throwable e) {
			RecordingGefActivator.log(e);
		}
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	after(AbstractEditPart part, EditPart child, int index):
		execution(protected void AbstractEditPart.removeChild(EditPart, int)) && target(part) && args(child, index) {
		try {
			GefEventManager.notifyRemoveChild(part, child, index);
		} catch (Throwable e) {
			RecordingGefActivator.log(e);
		}
	}

	// Events
	@SuppressAjWarnings("adviceDidNotMatch")
	before(DomainEventDispatcher dispatcher, MouseEvent mouseEvent):
			execution(void DomainEventDispatcher.dispatchMousePressed(MouseEvent)) && target(dispatcher) && args(mouseEvent) {
		try {
			GefEventManager.mouseDown((EditDomain) ReflectionUtil.getField(
					dispatcher, "domain"), mouseEvent,
					(EditPartViewer) ReflectionUtil.getField(dispatcher,
							"viewer"));
		} catch (Throwable e) {
			RecordingGefActivator.log(e);
		}
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	after(DomainEventDispatcher dispatcher, MouseEvent mouseEvent):
		execution(void DomainEventDispatcher.dispatchMousePressed(MouseEvent)) && target(dispatcher) && args(mouseEvent) {
		try {
			GefEventManager.afterMouseDown((EditDomain) ReflectionUtil
					.getField(dispatcher, "domain"), mouseEvent,
					(EditPartViewer) ReflectionUtil.getField(dispatcher,
							"viewer"));
		} catch (Throwable e) {
			RecordingGefActivator.log(e);
		}
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	before(DomainEventDispatcher dispatcher, MouseEvent mouseEvent):
		execution(void DomainEventDispatcher.dispatchMouseReleased(MouseEvent)) && target(dispatcher) && args(mouseEvent) {
		try {
			GefEventManager.mouseUp((EditDomain) ReflectionUtil.getField(
					dispatcher, "domain"), mouseEvent,
					(EditPartViewer) ReflectionUtil.getField(dispatcher,
							"viewer"));
		} catch (Throwable e) {
			RecordingGefActivator.log(e);
		}
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	after(DomainEventDispatcher dispatcher, MouseEvent mouseEvent):
		execution(void DomainEventDispatcher.dispatchMouseReleased(MouseEvent)) && target(dispatcher) && args(mouseEvent) {
		try {
			GefEventManager.afterMouseUp((EditDomain) ReflectionUtil.getField(
					dispatcher, "domain"), mouseEvent,
					(EditPartViewer) ReflectionUtil.getField(dispatcher,
							"viewer"));
		} catch (Throwable e) {
			RecordingGefActivator.log(e);
		}
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	before(DomainEventDispatcher dispatcher, MouseEvent mouseEvent):
		execution(void DomainEventDispatcher.dispatchMouseHover(MouseEvent)) && target(dispatcher) && args(mouseEvent) {
		try {
			GefEventManager.mouseHover((EditDomain) ReflectionUtil.getField(
					dispatcher, "domain"), mouseEvent,
					(EditPartViewer) ReflectionUtil.getField(dispatcher,
							"viewer"));
		} catch (Throwable e) {
			RecordingGefActivator.log(e);
		}
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	before(DomainEventDispatcher dispatcher, MouseEvent mouseEvent):
		execution(public void DomainEventDispatcher.dispatchMouseMoved(MouseEvent)) && target(dispatcher) && args(mouseEvent) {
		try {
			GefEventManager.mouseMove((EditDomain) ReflectionUtil.getField(
					dispatcher, "domain"), mouseEvent,
					(EditPartViewer) ReflectionUtil.getField(dispatcher,
							"viewer"));
		} catch (Throwable e) {
			RecordingGefActivator.log(e);
		}
	}

	// Instrumenting call to edit domain, as DomainEventDispatcer calls this
	// method from its dispatchMouseMoved, which we already instrumenting.
	//
	// So, it might happen that from a single call of DomainEventDispatcher
	// we'll get
	// mouseMove and then mouseDrag
	@SuppressAjWarnings("adviceDidNotMatch")
	before(EditDomain domain, MouseEvent mouseEvent, EditPartViewer viewer):
		execution(void EditDomain.mouseDrag(MouseEvent, EditPartViewer)) && target(domain) && args(mouseEvent, viewer) {
		try {
			GefEventManager.mouseDrag(domain, mouseEvent, viewer);
		} catch (Throwable e) {
			RecordingGefActivator.log(e);
		}
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	before(DomainEventDispatcher dispatcher, MouseEvent mouseEvent):
		execution(void DomainEventDispatcher.dispatchMouseDoubleClicked(MouseEvent)) && target(dispatcher) && args(mouseEvent) {
		try {
			GefEventManager.mouseDoubleClick((EditDomain) ReflectionUtil
					.getField(dispatcher, "domain"), mouseEvent,
					(EditPartViewer) ReflectionUtil.getField(dispatcher,
							"viewer"));
		} catch (Throwable e) {
			RecordingGefActivator.log(e);
		}
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	before(DomainEventDispatcher dispatcher, MouseEvent mouseEvent):
		execution(void DomainEventDispatcher.dispatchMouseWheelScrolled(MouseEvent, EditPartViewer)) && target(dispatcher) && args(mouseEvent) {
		try {
			GefEventManager.mouseWheelScrolled((EditDomain) ReflectionUtil
					.getField(dispatcher, "domain"), mouseEvent,
					(EditPartViewer) ReflectionUtil.getField(dispatcher,
							"viewer"));
		} catch (Throwable e) {
			RecordingGefActivator.log(e);
		}
	}

	// No need to instrument DomainEventDispatcher as it always delegates to EditDomain
	// Native drag events
	@SuppressAjWarnings("adviceDidNotMatch")
	before(EditDomain domain, DragSourceEvent event, EditPartViewer viewer):
		execution(public void nativeDragStarted(DragSourceEvent, EditPartViewer)) && target(domain) && args(event, viewer) {
		try {
			GefEventManager.nativeDragStarted(domain, event, viewer);
		} catch (Throwable e) {
			RecordingGefActivator.log(e);
		}
	}

	// Native drag events
	@SuppressAjWarnings("adviceDidNotMatch")
	before(EditDomain domain, DragSourceEvent event, EditPartViewer viewer):
		execution(public void nativeDragFinished(DragSourceEvent, EditPartViewer)) && target(domain) && args(event, viewer) {
		try {
			GefEventManager.nativeDragFinished(domain, event, viewer);
		} catch (Throwable e) {
			RecordingGefActivator.log(e);
		}
	}

	// Command stack command execution
	@SuppressAjWarnings("adviceDidNotMatch")
	before(CommandStack stack, Command command):
		execution(public void CommandStack.execute(Command)) && target(stack) && args(command) {
		try {
			GefEventManager.executeCommand(command);
		} catch (Throwable e) {
			RecordingGefActivator.log(e);
		}
	}

	private boolean inCommit = false;

	// Record direct edit commit request
	@SuppressAjWarnings("adviceDidNotMatch")
	Object around(DirectEditManager manager): execution(void DirectEditManager.commit ()) && target(manager) {
		inCommit = true;
		Object result = proceed(manager);
		try {
			DirectEditorContainer mgr = new DirectEditorContainer(manager);
			try {
				GefEventManager.recordCommitDirectEdit(mgr);
			} catch (Throwable e) {
				RecordingGefActivator.log(e);
			}
			lastDirectEdit = mgr;
			inCommit = false;
		} catch (Throwable e) {
			RecordingGefActivator.log(e);
		}
		return result;
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	after(DirectEditManager manager): execution(void DirectEditManager.show ()) && target(manager) {
		try {
			GefEventManager.forceDirectEdit(manager);
		} catch (Throwable e) {
			RecordingGefActivator.log(e);
		}
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	before(DirectEditManager manager): execution(void DirectEditManager.bringDown ()) && target(manager) {
		try {
			if (inCommit) {
				return;
			}
			if (!TeslaDirectEditManager.getInstance().contains(manager)) {
				// This is cancel
				if (lastDirectEdit == null) {
					GefEventManager
							.recordCancelDirectEdit(new DirectEditorContainer(
									manager));
				}
			}
			lastDirectEdit = null;
		} catch (Throwable e) {
			RecordingGefActivator.log(e);
		}
	}

	@SuppressAjWarnings("adviceDidNotMatch")
	before(Object helper): execution(void org.eclipse.gef.tools.DelayedDirectEditHelper.run()) && target(helper) {
		try {
			GefEventManager.handleDelayedDirectEdit(helper);
		} catch (Throwable e) {
			RecordingGefActivator.log(e);
		}
	}
}

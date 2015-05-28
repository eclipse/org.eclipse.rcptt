package org.eclipse.rcptt.tesla.nebula.nattable.ecl.impl.commands;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.dispatch.IScriptletExtension;
import org.eclipse.rcptt.tesla.core.protocol.ViewerUIElement;
import org.eclipse.rcptt.tesla.ecl.model.CellEdit;
import org.eclipse.rcptt.tesla.ecl.model.ControlHandler;
import org.eclipse.rcptt.tesla.ecl.model.TeslaPackage;
import org.eclipse.rcptt.tesla.nebula.nattable.ecl.NebulaNatTableElementKinds;
import org.eclipse.rcptt.tesla.nebula.nattable.ecl.impl.NatTablePlugin;

public class NatTableCellActionServiceExtension extends NatTableBaseActionService implements IScriptletExtension {

	@Override
	protected Object exec(Command command) throws CoreException {
		ControlHandler control = ((CellEdit) command).getControl();
		ViewerUIElement element = getNatTableUIElement(control);
		switch (command.eClass().getClassifierID()) {
		case TeslaPackage.ACTIVATE_CELL_EDIT:
			element.activateCellEditor(control.getPath());
			break;
		case TeslaPackage.APPLY_CELL_EDIT:
			element.applyCellEditor();
			break;
		case TeslaPackage.CANCEL_CELL_EDIT:
			element.cancelCellEditor();
			break;
		case TeslaPackage.DEACTIVATE_CELL_EDIT:
			element.deactivateCellEditor();
			break;
		default:
			throw new CoreException(NatTablePlugin.err(this.getClass().getName() + " unkown edit command"));
		}
		
		return control;
	}

	@Override
	public boolean canHandle(Command command) {
		if (command instanceof CellEdit) {
			ControlHandler control = ((CellEdit) command).getControl();
			return NebulaNatTableElementKinds.NAT_TABLE.equals(control.getCustomKindId());
		}
		return false;
	}

}

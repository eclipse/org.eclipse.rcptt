package org.eclipse.rcptt.tesla.nebula.nattable.ecl.impl.commands;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.rcptt.ecl.core.Command;
import org.eclipse.rcptt.ecl.dispatch.IScriptletExtension;
import org.eclipse.rcptt.ecl.runtime.IProcess;
import org.eclipse.rcptt.tesla.core.protocol.ElementKind;
import org.eclipse.rcptt.tesla.ecl.impl.TeslaBridge;
import org.eclipse.rcptt.tesla.ecl.model.ControlHandler;
import org.eclipse.rcptt.tesla.ecl.model.GetItem;
import org.eclipse.rcptt.tesla.ecl.model.TeslaFactory;
import org.eclipse.rcptt.tesla.nebula.nattable.ecl.NebulaNatTableElementKinds;
import org.eclipse.rcptt.tesla.nebula.nattable.model.NatTableCellPosition;

public class NatTableGetItemServiceExtension implements IScriptletExtension {

	@Override
	public IStatus service(Command command, IProcess context) throws InterruptedException, CoreException {
		TeslaBridge.waitDelay();
		GetItem ge = (GetItem) command;

		String path = ge.getPath();
		if (path == null || path.isEmpty()) {
			throw new InterruptedException("Indexes for colomns is't specefied for NatTable get-item command");
		}

		if (!NatTableCellPosition.isValidPath(path)) {
			throw new InterruptedException("NatTable get-item should have following format: (indexColumn:indexRow)");
		}

		ControlHandler handler = TeslaFactory.eINSTANCE.createControlHandler();
		handler.setParent(ge.getParent());
		handler.setAfter(ge.getAfter());
		handler.setKind(ElementKind.Custom);
		handler.setCustomKindId(NebulaNatTableElementKinds.NAT_TABLE_CELL);
		handler.setPath(path);

		TeslaBridge.find(handler);
		TeslaBridge.waitExecution();
		context.getOutput().write(handler);


		return Status.OK_STATUS;
	}

	@Override
	public boolean canHandle(Command command) {
		if (command instanceof GetItem) {
			ControlHandler parent = ((GetItem) command).getParent();
			while (parent != null) {
				if (ElementKind.Item == parent.getKind())
					parent = parent.getParent();
				else
					return NebulaNatTableElementKinds.NAT_TABLE.equals(parent.getCustomKindId());
			}
		}
		return false;
	}

}

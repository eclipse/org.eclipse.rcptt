package org.eclipse.rcptt.tesla.nebula.nattable.processors;

import org.eclipse.nebula.widgets.nattable.NatTable;
import org.eclipse.nebula.widgets.nattable.command.ILayerCommand;
import org.eclipse.nebula.widgets.nattable.selection.command.SelectCellCommand;
import org.eclipse.osgi.util.NLS;
import org.eclipse.rcptt.tesla.core.protocol.BooleanResponse;
import org.eclipse.rcptt.tesla.core.protocol.ProtocolFactory;
import org.eclipse.rcptt.tesla.core.protocol.SelectCommand;
import org.eclipse.rcptt.tesla.core.protocol.SelectData;
import org.eclipse.rcptt.tesla.core.protocol.SelectResponse;
import org.eclipse.rcptt.tesla.core.protocol.SetSelection;
import org.eclipse.rcptt.tesla.core.protocol.raw.Element;
import org.eclipse.rcptt.tesla.core.protocol.raw.Response;
import org.eclipse.rcptt.tesla.core.protocol.raw.ResponseStatus;
import org.eclipse.rcptt.tesla.internal.ui.SWTElementMapper;
import org.eclipse.rcptt.tesla.internal.ui.player.SWTUIPlayer;
import org.eclipse.rcptt.tesla.nebula.nattable.NatTableHelper;
import org.eclipse.rcptt.tesla.nebula.nattable.NatTableMapper;
import org.eclipse.rcptt.tesla.nebula.nattable.model.NatTableCellElement;
import org.eclipse.rcptt.tesla.nebula.nattable.model.NatTableCellPosition;
import org.eclipse.rcptt.tesla.nebula.nattable.model.NatTableSWTElement;
import org.eclipse.rcptt.tesla.swt.TeslaSWTMessages;

public class NatTableSelectionProcessor {

	public static Response executeCellSelection(SetSelection command, NatTableMapper mapper, String id,
			final SWTUIPlayer player) {
		BooleanResponse response = ProtocolFactory.eINSTANCE.createBooleanResponse();
		try {
			NatTableSWTElement natTableElement = (NatTableSWTElement) SWTElementMapper.getMapper(id).get(
					command.getElement());
			final NatTable natTable = (NatTable) natTableElement.widget;
			String path = command.getPath().get(0);

			NatTableCellPosition sourcePosition = NatTableHelper.parsePath(path);
			NatTableCellPosition position = NatTableHelper.getPositionByPathPosition(natTable, sourcePosition);

			if (NatTableHelper.isHeaderLayer(natTable, position.getCol(), position.getRow())) {
				NatTableHelper.clickOnCell(natTable, position, player);
			} else {
				ILayerCommand natTableCommand = new SelectCellCommand(natTable, position.getCol(), position.getRow(),
						false, false);
				boolean result = natTable.doCommand(natTableCommand);

				if (!result) {
					throw new Exception("Can't set specefied selection");
				}
			}


			response.setResult(true);
		} catch (Exception e) {
			response.setResult(false);
			response.setStatus(ResponseStatus.FAILED);
			response.setMessage(NLS.bind(TeslaSWTMessages.SWTUIProcessor_CannotSetSelection, e.getMessage()));
		}
		return response;
	}

	public static SelectResponse selectItem(SelectCommand command, NatTableMapper mapper, String id) {
		SelectData data = command.getData();
		NatTableSWTElement natTableElement = (NatTableSWTElement) SWTElementMapper.getMapper(id).get(data.getParent());
		NatTableCellPosition position = NatTableHelper.parsePath(data.getPath().get(0));
		NatTableCellElement cell = new NatTableCellElement(natTableElement, position);

		Element element = mapper.get(cell);
		SelectResponse response = ProtocolFactory.eINSTANCE.createSelectResponse();
		response.getElements().add(element);

		return response;
	}

}

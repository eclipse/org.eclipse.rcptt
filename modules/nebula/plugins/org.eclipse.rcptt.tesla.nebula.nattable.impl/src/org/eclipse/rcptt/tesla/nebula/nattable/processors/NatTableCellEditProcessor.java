package org.eclipse.rcptt.tesla.nebula.nattable.processors;

import org.eclipse.nebula.widgets.nattable.NatTable;
import org.eclipse.nebula.widgets.nattable.edit.command.EditCellCommand;
import org.eclipse.nebula.widgets.nattable.edit.editor.ICellEditor;
import org.eclipse.nebula.widgets.nattable.layer.cell.ILayerCell;
import org.eclipse.nebula.widgets.nattable.selection.SelectionLayer.MoveDirectionEnum;
import org.eclipse.osgi.util.NLS;
import org.eclipse.rcptt.tesla.core.protocol.ActivateCellEditor;
import org.eclipse.rcptt.tesla.core.protocol.ApplyCellEditor;
import org.eclipse.rcptt.tesla.core.protocol.BooleanResponse;
import org.eclipse.rcptt.tesla.core.protocol.CancelCellEditor;
import org.eclipse.rcptt.tesla.core.protocol.DeactivateCellEditor;
import org.eclipse.rcptt.tesla.core.protocol.IElementProcessorMapper;
import org.eclipse.rcptt.tesla.core.protocol.ProtocolFactory;
import org.eclipse.rcptt.tesla.core.protocol.raw.Response;
import org.eclipse.rcptt.tesla.core.protocol.raw.ResponseStatus;
import org.eclipse.rcptt.tesla.internal.ui.SWTElementMapper;
import org.eclipse.rcptt.tesla.internal.ui.player.SWTUIPlayer;
import org.eclipse.rcptt.tesla.nebula.nattable.NatTableHelper;
import org.eclipse.rcptt.tesla.nebula.nattable.model.NatTableCellPosition;
import org.eclipse.rcptt.tesla.nebula.nattable.model.NatTableSWTElement;
import org.eclipse.rcptt.tesla.swt.TeslaSWTMessages;

public class NatTableCellEditProcessor {

	public static Response executeActivateCell(ActivateCellEditor command, IElementProcessorMapper mapper, String id,
			SWTUIPlayer player) {
		BooleanResponse response = ProtocolFactory.eINSTANCE.createBooleanResponse();
		try {
			NatTableSWTElement natTableElement = (NatTableSWTElement) SWTElementMapper.getMapper(id).get(
					command.getElement());
			final NatTable natTable = (NatTable) natTableElement.widget;
			final String path = command.getPath().get(0);
			NatTableCellPosition position = NatTableHelper.parsePath(path);
			position = NatTableHelper.getPositionByPathPosition(natTable, position);
			final ILayerCell cell = natTable.getCellByPosition(position.getCol(), position.getRow());

			player.exec("Start editing of NatTable cell", new Runnable() {
				@Override
				public void run() {
					natTable.doCommand(new EditCellCommand(natTable, natTable.getConfigRegistry(), cell));

					// if (!result) {
					// throw new Exception("Can't edit specified cell");
					// }
				}
			});

			response.setResult(true);

		} catch (Exception e) {
			response.setResult(false);
			response.setStatus(ResponseStatus.FAILED);
			response.setMessage(NLS.bind(TeslaSWTMessages.SWTUIProcessor_CannotSetSelection, e.getMessage()));
		}
		return response;
	}

	public static Response executeApplyCellEditor(ApplyCellEditor command, IElementProcessorMapper mapper,
			String id) {
		BooleanResponse response = ProtocolFactory.eINSTANCE.createBooleanResponse();
		try {
			NatTableSWTElement natTableElement = (NatTableSWTElement) SWTElementMapper.getMapper(id).get(
					command.getElement());
			NatTable natTable = (NatTable) natTableElement.widget;

			ICellEditor editor = natTable.getActiveCellEditor();
			if (editor != null && !editor.isClosed()) {
				editor.commit(MoveDirectionEnum.NONE);
				editor.close();
			}

			response.setResult(true);

		} catch (Exception e) {
			response.setResult(false);
			response.setStatus(ResponseStatus.FAILED);
			response.setMessage(NLS.bind(TeslaSWTMessages.SWTUIProcessor_CannotSetSelection, e.getMessage()));
		}
		return response;
	}

	public static Response executeCancelCellEditor(CancelCellEditor command, IElementProcessorMapper mapper,
			String id) {
		BooleanResponse response = ProtocolFactory.eINSTANCE.createBooleanResponse();
		try {
			NatTableSWTElement natTableElement = (NatTableSWTElement) SWTElementMapper.getMapper(id).get(
					command.getElement());
			NatTable natTable = (NatTable) natTableElement.widget;

			ICellEditor editor = natTable.getActiveCellEditor();
			if (editor != null && !editor.isClosed()) {
				editor.close();
			}

			response.setResult(true);

		} catch (Exception e) {
			response.setResult(false);
			response.setStatus(ResponseStatus.FAILED);
			response.setMessage(NLS.bind(TeslaSWTMessages.SWTUIProcessor_CannotSetSelection, e.getMessage()));
		}
		return response;
	}

	public static Response executeDeactivateCellEditor(DeactivateCellEditor command,
			IElementProcessorMapper mapper, String id) {
		BooleanResponse response = ProtocolFactory.eINSTANCE.createBooleanResponse();
		try {
			NatTableSWTElement natTableElement = (NatTableSWTElement) SWTElementMapper.getMapper(id).get(
					command.getElement());
			NatTable natTable = (NatTable) natTableElement.widget;

			ICellEditor editor = natTable.getActiveCellEditor();
			if (editor != null && !editor.isClosed()) {
				editor.commit(MoveDirectionEnum.NONE);
				editor.close();
			}

			response.setResult(true);

		} catch (Exception e) {
			response.setResult(false);
			response.setStatus(ResponseStatus.FAILED);
			response.setMessage(NLS.bind(TeslaSWTMessages.SWTUIProcessor_CannotSetSelection, e.getMessage()));
		}
		return response;
	}

}

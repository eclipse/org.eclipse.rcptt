package org.eclipse.rcptt.tesla.recording.nebula.nattable;

import org.eclipse.nebula.widgets.nattable.NatTable;
import org.eclipse.rcptt.tesla.nebula.nattable.NatTableHelper;
import org.eclipse.rcptt.tesla.nebula.nattable.model.NatTableCellPosition;
import org.eclipse.rcptt.tesla.recording.core.swt.IRecorderDescriberExtension;
import org.eclipse.rcptt.tesla.recording.core.swt.IRecordingDescriber;
import org.eclipse.rcptt.tesla.recording.core.swt.RecordingWidgetDescriber;
import org.eclipse.swt.widgets.Widget;

public class NatTableRecordingDescriberExtension implements IRecorderDescriberExtension {

	@Override
	public IRecordingDescriber getDescriber(Widget widget, IRecordingDescriber previous, int x, int y,
			boolean fromAssert) {
		if (widget instanceof NatTable) {
			return getItemAt(new RecordingWidgetDescriber(widget), x, y, fromAssert);
		}

		return previous;
	}

	private IRecordingDescriber getItemAt(IRecordingDescriber descr, int x,
			int y, boolean fromAssert) {
		Widget base = descr.getWidget();

		if (base instanceof NatTable) {
			NatTable natTable = (NatTable) base;
			NatTableCellPosition position = NatTableHelper.getCellPosition(natTable, x, y);
			if (position != null) {
				return new NatTableCellRecordingDescriber(natTable, position);
			}
		}

		return descr;
	}

}

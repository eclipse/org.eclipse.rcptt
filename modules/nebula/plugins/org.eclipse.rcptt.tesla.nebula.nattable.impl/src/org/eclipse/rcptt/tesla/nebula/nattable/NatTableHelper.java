package org.eclipse.rcptt.tesla.nebula.nattable;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.nebula.widgets.nattable.NatTable;
import org.eclipse.nebula.widgets.nattable.config.IConfigRegistry;
import org.eclipse.nebula.widgets.nattable.config.IEditableRule;
import org.eclipse.nebula.widgets.nattable.edit.EditConfigAttributes;
import org.eclipse.nebula.widgets.nattable.grid.layer.ColumnHeaderLayer;
import org.eclipse.nebula.widgets.nattable.grid.layer.GridLayer;
import org.eclipse.nebula.widgets.nattable.layer.ILayer;
import org.eclipse.nebula.widgets.nattable.layer.IUniqueIndexLayer;
import org.eclipse.nebula.widgets.nattable.layer.cell.ILayerCell;
import org.eclipse.nebula.widgets.nattable.style.DisplayMode;
import org.eclipse.nebula.widgets.nattable.viewport.ViewportLayer;
import org.eclipse.nebula.widgets.nattable.viewport.command.ShowCellInViewportCommand;
import org.eclipse.rcptt.tesla.internal.ui.player.SWTUIPlayer;
import org.eclipse.rcptt.tesla.nebula.nattable.model.NatTableCellPosition;
import org.eclipse.rcptt.util.swt.Bounds;
import org.eclipse.rcptt.util.swt.Events;
import org.eclipse.swt.widgets.Event;

public class NatTableHelper {

	/**
	 * Check if column is editable
	 * 
	 * @param natTable
	 * @param position
	 * @return
	 */
	public static boolean isEditable(NatTable natTable, NatTableCellPosition position) {
		ILayerCell cell = natTable.getCellByPosition(position.getCol(), position.getRow());
		IConfigRegistry configRegistry = natTable.getConfigRegistry();
		IEditableRule rule = configRegistry.getConfigAttribute(
				EditConfigAttributes.CELL_EDITABLE_RULE, DisplayMode.EDIT, cell.getConfigLabels()
						.getLabels());

		if (rule == null) {
			return false;
		}

		return rule.isEditable(cell, configRegistry);
	}
	
	/**
	 * Get cell position by coordinates
	 * 
	 * @param natTable
	 * @param x
	 * @param y
	 * @return
	 */
	public static NatTableCellPosition getCellPosition(NatTable natTable, int x, int y) {
		int colPosition = natTable.getColumnPositionByX(x);
		int rowPosition = natTable.getRowPositionByY(y);
		if (colPosition == -1 || rowPosition == -1)
			return null;

		return new NatTableCellPosition(colPosition, rowPosition);
	}

	public static boolean isNatTableCell(NatTable natTable, int x, int y) {
		return getCellPosition(natTable, x, y) != null;
	}

	/**
	 * 
	 * @param natTable
	 * @param col
	 *            position coordinate
	 * @param row
	 *            position coordinate
	 * @return
	 */
	public static boolean isHeaderLayer(NatTable natTable, int col, int row) {
		ILayer layerByPosition = natTable.getLayer().getUnderlyingLayerByPosition(col, row);
		if (layerByPosition instanceof ColumnHeaderLayer) {
			return true;
		}

		ILayer layer = natTable.getLayer();
		if (layer instanceof GridLayer) {
			ILayer bodyLayer = ((GridLayer) layer).getBodyLayer();
			return !bodyLayer.equals(layerByPosition);
		}


		return false;
	}

	/**
	 * Transform parsed coordinates to position coordinates
	 * 
	 * @param natTable
	 * @param sourcePosition
	 * @return
	 */
	public static NatTableCellPosition getPositionByPathPosition(NatTable natTable, NatTableCellPosition sourcePosition) {
		if (!sourcePosition.isIndexColumnCoordinate() && !sourcePosition.isIndexRowCoordinate()) {
			return new NatTableCellPosition(sourcePosition.getCol(), sourcePosition.getRow());
		}

		int natTableColPos, natTableRowPos;
		List<ILayer> layers = getLayersTree(natTable);
		if (layers != null && layers.size() > 0) {
			IUniqueIndexLayer indexLayer = (IUniqueIndexLayer) layers.get(layers.size() - 1);
			ViewportLayer viewportLayer = getViewportLayer(natTable, sourcePosition);

			natTable.doCommand(new ShowCellInViewportCommand(viewportLayer, sourcePosition.getCol(), sourcePosition
					.getRow()));

			if (sourcePosition.isIndexColumnCoordinate()) {
				natTableColPos = indexLayer.getColumnPositionByIndex(sourcePosition.getCol());
				natTableColPos = transformColumnIndex(layers, natTableColPos);
			} else {
				natTableColPos = sourcePosition.getCol();
			}

			if (sourcePosition.isIndexRowCoordinate()) {
				natTableRowPos = indexLayer.getRowPositionByIndex(sourcePosition.getRow());
				natTableRowPos = transformRowIndex(layers, natTableRowPos);
			} else {
				natTableRowPos = sourcePosition.getRow();
			}
		} else {
			natTableColPos = sourcePosition.getCol();
			natTableRowPos = sourcePosition.getRow();
		}

		return new NatTableCellPosition(natTableColPos, natTableRowPos);
	}

	/**
	 * Fire click event on cell
	 * 
	 * @param natTable
	 * @param position
	 * @param player
	 */
	public static void clickOnCell(final NatTable natTable, NatTableCellPosition position, final SWTUIPlayer player) {
		ILayerCell cell = natTable.getCellByPosition(position.getCol(), position.getRow());
		final Event[] event = Events.createClick(Bounds.centerAbs(cell.getBounds()));
		player.exec("Performing click on NatTable header cell", new Runnable() {
			@Override
			public void run() {
				player.getEvents().sendAll(natTable, event);
			}
		});
	}
	
	/**
	 * Get top scrollable layer
	 * 
	 * @param layer
	 * @param indexPosition
	 * @return
	 */
	private static ViewportLayer getViewportLayer(ILayer layer, NatTableCellPosition indexPosition) {
		ILayer underlyingLayer = layer;

		while (!(underlyingLayer instanceof ViewportLayer)) {
			underlyingLayer = underlyingLayer.getUnderlyingLayerByPosition(1, 1);
			if (underlyingLayer == null) {
				return null;
			}
		}

		return (ViewportLayer) underlyingLayer;
	}

	private static int transformRowIndex(List<ILayer> layers, int row) {
		int result = row;
		if (layers.size() <= 1) {
			return result;
		}
		for (int i = layers.size() - 1; i > 0; i--) {
			ILayer underlyingLayer = layers.get(i);
			ILayer layer = layers.get(i - 1);
			int index = layer.underlyingToLocalRowPosition(underlyingLayer, result);
			// some layers do not provide transform functionality and use the same positions as parent layer
			result = index == -1 ? result : index;
		}

		return result;
	}

	private static int transformColumnIndex(List<ILayer> layers, int col) {
		int result = col;
		if (layers.size() <= 1) {
			return result;
		}
		for (int i = layers.size() - 1; i > 0; i--) {
			ILayer underlyingLayer = layers.get(i);
			ILayer layer = layers.get(i - 1);
			int index = layer.underlyingToLocalColumnPosition(underlyingLayer, result);
			result = index == -1 ? result : index;
		}

		return result;
	}

	private static List<ILayer> getLayersTree(ILayer layer) {
		ILayer underlyingLayer = layer;
		List<ILayer> layers = new ArrayList<ILayer>();
		layers.add(layer);

		while (!(underlyingLayer instanceof IUniqueIndexLayer)) {
			underlyingLayer = underlyingLayer.getUnderlyingLayerByPosition(1, 1);
			layers.add(underlyingLayer);
			if (underlyingLayer == null) {
				return null;
			}
		}

		return layers;
	}

	/**
	 * 
	 * @param path
	 * @return
	 */
	public static NatTableCellPosition parsePath(String path) {
		NatTableCellPosition position = new NatTableCellPosition();
		String[] elements = path.split(":");

		// parse column coordinate
		String colParam = elements[0];
		if (colParam.startsWith("p")) {
			position.setCol(Integer.parseInt(colParam.substring(1)));
			position.setIsIndexColumnCoordinate(false);
		} else {
			position.setCol(Integer.parseInt(colParam));
			position.setIsIndexColumnCoordinate(true);
		}

		// parse row coordinate
		String rowParam = elements[1];
		if (rowParam.startsWith("p")) {
			position.setRow(Integer.parseInt(rowParam.substring(1)));
			position.setIsIndexRowCoordinate(false);
		} else {
			position.setRow(Integer.parseInt(rowParam));
			position.setIsIndexRowCoordinate(true);
		}

		return position;
	}

	/**
	 * 
	 * @param natTable
	 * @param position
	 * @param isPositionCooridinateRequired
	 * @return
	 */
	public static String getPath(NatTable natTable, NatTableCellPosition position, Boolean isPositionCooridinateRequired) {
		// position coordinates
		if (isPositionCooridinateRequired) {
			StringBuilder path = new StringBuilder();
			if (position.getCol() == 0) {
				path.append("p");
				path.append(position.getCol());
			} else {
				path.append(natTable.getLayer().getColumnIndexByPosition(position.getCol()));
			}
			path.append(":");

			if (position.getRow() == 0) {
				path.append("p");
				path.append(position.getRow());
			} else {
				path.append(natTable.getLayer().getRowIndexByPosition(position.getRow()));
			}


			return path.toString();
		}

		// index coordinates
		return natTable.getColumnIndexByPosition(position.getCol()) + ":"
				+ natTable.getRowIndexByPosition(position.getRow());
	}

}

package org.eclipse.rcptt.tesla.nebula.nattable.model;


public class NatTableCellPosition {

	private int row;
	private int col;

	private boolean isIndexColumnCoordinate = false;
	private boolean isIndexRowCoordinate = false;

	public NatTableCellPosition() {
		this.col = 0;
		this.row = 0;
	}

	public NatTableCellPosition(int col, int row) {
		this.col = col;
		this.row = row;
	}

	public static boolean isValidPath(String path) {
		return path.matches("[p]*[\\d]+:[p]*[\\d]+");
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public void setCol(int col) {
		this.col = col;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;

		NatTableCellPosition position = (NatTableCellPosition) obj;

		return row == position.getRow() && col == position.getCol();
	}

	public boolean isIndexColumnCoordinate() {
		return isIndexColumnCoordinate;
	}

	public void setIsIndexColumnCoordinate(boolean isIndexColumnCoordinate) {
		this.isIndexColumnCoordinate = isIndexColumnCoordinate;
	}

	public boolean isIndexRowCoordinate() {
		return isIndexRowCoordinate;
	}

	public void setIsIndexRowCoordinate(boolean isIndexRowCoordinate) {
		this.isIndexRowCoordinate = isIndexRowCoordinate;
	}

}

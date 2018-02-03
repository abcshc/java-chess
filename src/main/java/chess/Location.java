package chess;

import exception.InvalidLocationException;

public class Location {
	private int columnIndex;
	private int rowIndex;

	public Location(String location) {
		checkInvalidLocationException(location);
		columnIndex = indexMatchColumnLocation(location);
		rowIndex = indexMatchRowLocation(location);
	}

	public int getColumnIndex() {
		return columnIndex;
	}

	public int getRowIndex() {
		return rowIndex;
	}

	private static int indexMatchColumnLocation(String location) {
		String locationValue = location.substring(0, 1);
		ColumnLocation[] values = ColumnLocation.values();
		for (ColumnLocation columnLocation : values) {
			if (columnLocation.getValue().equals(locationValue))
				return columnLocation.getIndex();
		}
		throw new InvalidLocationException(locationValue + "는 유효하지 않은 열의 값입니다.");
	}

	private static int indexMatchRowLocation(String location) {
		int index = Integer.parseInt(location.substring(1));
		if (index < 1 || index > 8) {
			throw new InvalidLocationException(index + "는 유효하지 않은 행의 값입니다.");
		}
		return index - 1;
	}

	private void checkInvalidLocationException(String location) {
		if (location.length() != 2)
			throw new InvalidLocationException("좌표를 잘 못 입력했습니다.");
	}

	private static enum ColumnLocation {
		A(0, "A"), B(1, "B"), C(2, "C"), D(3, "D"), E(4, "E"), F(5, "F"), G(6, "G"), H(7, "H");
		private int index;
		private String value;

		ColumnLocation(int index, String value) {
			this.index = index;
			this.value = value;
		}

		public int getIndex() {
			return index;
		}

		public String getValue() {
			return value;
		}
	}
}
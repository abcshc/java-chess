package model;

import exception.InvalidLocationException;

public class Location {
	public static int indexMatchColumnLocation(String location) {
		String locationValue = location.substring(0, 1);
		ColumnLocation[] values = ColumnLocation.values();
		for (ColumnLocation columnLocation : values) {
			if (columnLocation.getValue().equals(locationValue))
				return columnLocation.getIndex();
		}
		throw new InvalidLocationException(locationValue + "는 유효하지 않은 열의 값입니다.");
	}

	public static int indexMatchRowLocation(String location) {
		int index = Integer.parseInt(location.substring(1)) - 1;
		if (index < 0 || index > 7) {
			throw new InvalidLocationException(index+"는 유효하지 않은 행의 값입니다.");
		}
		return index;
	}

	public static enum ColumnLocation {
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
package com.gmail.tsa;

public class Board {

	private Shape[] board = new Shape[4];

	public Board() {
		super();
	}

	public void add(Shape a, int position) {
		if ((position - 1 >= 0) && (position - 1 < board.length) && (board[position - 1] == null)) {
			board[position - 1] = a;
		} else {
			System.out.println("Error add's Shape");
		}
	}

	public void deleteByIndex(int position) {
		if (position - 1 >= 0 && position - 1 < board.length && board[position - 1] != null) {
			board[position - 1] = null;
			System.out.println("Shape deleted");
		} else {
			System.out.println("Wrong position");
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		double totalArea = 0;
		for (int i = 0; i < board.length; i++) {
			if (board[i] != null) {
				sb.append(((i + 1) + ") " + board[i]));
				totalArea += board[i].getArea();
			} else {
				sb.append((i + 1) + ") " + "Empy");

			}
			sb.append(System.lineSeparator());
		}
		sb.append("Total Area = " + totalArea);
		return sb.toString();
	}

}

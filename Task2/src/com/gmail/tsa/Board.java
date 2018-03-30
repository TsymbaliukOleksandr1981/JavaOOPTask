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

	public double getTotalShapeArea() {
		double area = 0;
		for (Shape shape : board) {
			if (shape != null) {
				area += shape.getArea();
			}
		}
		return area;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < board.length; i++) {
			if (board[i] != null) {
				sb.append(((i + 1) + ") " + board[i]));
			} else {
				sb.append((i + 1) + ") " + "Empy");
			}
			sb.append(System.lineSeparator());
		}
		sb.append("Total Area = " + getTotalShapeArea());
		return sb.toString();
	}

}

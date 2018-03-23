package com.gmail.tsa;

public class Main {

	public static void main(String[] args) {
		
		Point a = new Point(0, 0);
		Point b = new Point(0, 4);
		Point c = new Point(3, 0);
		Point d = new Point(3, 4);
		
		Triangular aTriangular = new Triangular(a, b, c);
		Circle aCircle = new Circle(a, b);
		Rectangle aRectangle = new Rectangle(a, b, d, c);
	
		Board aBoard = new Board();
		
		aBoard.add(aTriangular, 1);
		aBoard.add(aCircle, 3);
		aBoard.add(aRectangle, 4);
		System.out.println(aBoard);
		
		aBoard.deleteByIndex(1);
		
		System.out.println();
		System.out.println(aBoard);
	}

}

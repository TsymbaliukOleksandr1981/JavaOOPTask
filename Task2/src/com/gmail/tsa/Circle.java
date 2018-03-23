package com.gmail.tsa;

public class Circle extends Shape {
	private Point a;
	private Point b;

	public Circle(Point a, Point b) {
		super();
		this.a = a;
		this.b = b;
	}

	public Circle() {
		super();
	}

	public Point getA() {
		return a;
	}

	public void setA(Point a) {
		this.a = a;
	}

	public Point getB() {
		return new Point(b.getX(), b.getY());
	}

	public void setB(Point b) {
		this.b = b;
	}

	@Override
	public double getArea() {
		return Math.PI * a.getDistance(b) * a.getDistance(b);
	}

	@Override
	public double getPerimetr() {
		return Math.PI * 2 * a.getDistance(b);
	}

	@Override
	public String toString() {
		return "Circle [a=" + a + ", b=" + b + "]";
	}

}

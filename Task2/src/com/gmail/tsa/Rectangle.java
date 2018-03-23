package com.gmail.tsa;

public class Rectangle extends Shape {
	private Point a;
	private Point b;
	private Point c;
	private Point d;

	public Rectangle(Point a, Point b, Point c, Point d) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
	}

	public Rectangle() {
		super();
	}

	public Point getA() {
		return a;
	}

	public void setA(Point a) {
		this.a = a;
	}

	public Point getB() {
		return b;
	}

	public void setB(Point b) {
		this.b = b;
	}

	public Point getC() {
		return c;
	}

	public void setC(Point c) {
		this.c = c;
	}

	public Point getD() {
		return d;
	}

	public void setD(Point d) {
		this.d = d;
	}

	@Override
	public double getArea() {
		Triangular tr1 = new Triangular(a, b, c);
		Triangular tr2 = new Triangular(a, c, d);
		return tr1.getArea() + tr2.getArea();
	}

	@Override
	public double getPerimetr() {

		return a.getDistance(b) + b.getDistance(c) + c.getDistance(d) + d.getDistance(a);
	}

	@Override
	public String toString() {
		return "Rectangle [a=" + a + ", b=" + b + ", c=" + c + ", d=" + d + "]";
	}

}

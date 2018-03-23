package com.gmail.tsa;

public class Point {
	
	private double x;
	private double y;

	public Point(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}

	public Point() {
		super();
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getDistance(Point a) {
		double x = (this.getX() - a.getX()) * (this.getX() - a.getX());
		double y = (this.getY() - a.getY()) * (this.getY() - a.getY());
		return Math.sqrt(x + y);
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
	

}

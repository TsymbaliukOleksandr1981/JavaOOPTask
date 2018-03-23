package com.gmail.tsa;

public class Vector3D {

	private double x;
	private double y;
	private double z;

	public Vector3D(double x, double y, double z) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
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

	public double getZ() {
		return z;
	}

	public void setZ(double z) {
		this.z = z;
	}

	public Vector3D vectorSum(Vector3D a) {
		return new Vector3D(this.getX() + a.getX(), this.getY() + a.getY(), this.getZ() + a.getZ());
	}

	public double scalarMultiplication(Vector3D a) {
		return this.getX() * a.getX() + this.getY() * a.getY() + this.getZ() * a.getZ();
	}

	public Vector3D vectorMultiplication(Vector3D a) {
		double newx = this.getY() * a.getZ() - this.getZ() * a.getY();
		double newy = this.getZ() * a.getX() - this.getX() * a.getZ();
		double newz = this.getX() * a.getY() - this.getY() * a.getX();
		return new Vector3D(newx, newy, newz);
	}

	public void printInfo() {
		System.out.println("Vector3D:  x = " + this.x + "  y = " + this.y + "  z = " + this.z);
	}

}

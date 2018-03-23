package com.gmail.tsa;

public class Main {

	public static void main(String[] args) {
		Vector3D a = new Vector3D(3, 4, 5);
		Vector3D b = new Vector3D(1, 2, 3);

		Vector3D c = a.vectorSum(b);
		c.printInfo();
		Vector3D d = a.vectorMultiplication(b);
		d.printInfo();

	}

}

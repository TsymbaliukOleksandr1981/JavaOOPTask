package com.gmail.tsa;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Network life = new Network();
		
		Phone phoneOne = new Phone(9355562, "Samsung S3");
		Phone phoneTwo = new Phone(1234567, "IPhone 2");
		Phone phoneThree = new Phone(7654321, "Nokia 3310");
		
		phoneOne.registerToNetwork(life);
		phoneTwo.registerToNetwork(life);
		phoneThree.registerToNetwork(life);

		phoneOne.call(1234567);
		phoneOne.call(12);
	}

}

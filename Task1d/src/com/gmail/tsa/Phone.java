package com.gmail.tsa;

public class Phone {
	private long number;
	private String brand;
	private Network network;

	public Phone(long number, String brand) {
		super();
		this.number = number;
		this.brand = brand;
	}

	public Phone() {
		super();
	}

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Override
	public String toString() {
		return "Phone [number=" + number + ", brand=" + brand + "]";
	}

	public void registerToNetwork(Network network) {
		this.network = network;
		if (!this.network.addPhone(this)) {
			this.network = null;
		}
	}

	public void call(long number) {
		if (this.network == null) {
			System.out.println("Your phone dont register in Network");
			return;
		}
		Phone tempPhone = this.network.getPhoneByNumber(number);
		if (tempPhone != null) {
			tempPhone.incomingCall();
		} else {
			System.out.println("Abonent not aviable");
		}

	}

	public void incomingCall() {
		System.out.println(this + " Dzzz - Dzzz");
	}

}

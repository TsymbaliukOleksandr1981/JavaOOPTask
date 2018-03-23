package com.gmail.tsa;

public class Network {
	private Phone[] phoneArray = new Phone[0];

	public Network() {
		super();
	}

	public boolean addPhone(Phone phone) {
		if (getPhoneIntoArray(phone) != -1) {
			System.out.println("Phone number " + phone.getNumber() + " alredy register");
			return false;
		}
		Phone[] temp = new Phone[phoneArray.length + 1];
		System.arraycopy(phoneArray, 0, temp, 0, phoneArray.length);
		temp[temp.length - 1] = phone;
		phoneArray = temp;
		return true;

	}

	private int getPhoneIntoArray(Phone phone) {
		for (int i = 0; i < phoneArray.length; i++) {
			if (phoneArray[i].getNumber() == phone.getNumber()) {
				return i;
			}
		}
		return -1;
	}

	public Phone getPhoneByNumber(long phoneNumber) {
		for (Phone phone : phoneArray) {
			if (phone.getNumber() == phoneNumber) {
				return phone;
			}
		}
		return null;
	}

}

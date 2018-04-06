package com.gmail.tsa;

public class BlackList {
	private Class<?>[] classArray = new Class<?>[5];
	private int n = 0;

	public BlackList() {
		super();
	}

	public void addClassToList(Class<?> classOne) {
		if (isClassPresent(classOne)) {
			return;
		}
		if (n == this.classArray.length) {
			Class<?>[] temp = new Class<?>[(classArray.length * 7) / 4 + 1];
			System.arraycopy(classArray, 0, temp, 0, classArray.length);
			classArray = temp;
		}
		classArray[n++] = classOne;
	}

	private boolean isClassPresent(Class<?> classOne) {
		for (Class<?> classTwo : classArray) {
			if (classTwo != null && classOne.equals(classTwo)) {
				return true;
			}
		}
		return false;
	}

	public boolean checkObject(Object obj) {
		return isClassPresent(obj.getClass());
	}
}

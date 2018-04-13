package com.gmail.tsa;

public class CheckNull {
	public static int NOT_NULL = 7;

	public static int nullCheck(Object a, Object b) {

		if (a != null && b == null) {
			return 1;
		}
		if (a == null && b != null) {
			return -1;
		}
		if (a == null && b == null) {
			return 0;
		}
		return NOT_NULL;
	}

}

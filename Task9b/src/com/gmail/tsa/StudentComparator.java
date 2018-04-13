package com.gmail.tsa;

import java.util.Comparator;

public class StudentComparator implements Comparator<Student> {
	private int i = 0;
	private boolean forward = true;

	public StudentComparator(int i) {
		super();
		this.i = i;
	}

	public StudentComparator(int i, boolean forward) {
		super();
		this.i = i;
		this.forward = forward;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	@Override
	public int compare(Student a, Student b) {

		int n = (this.forward) ? 1 : -1;

		int notNull = CheckNull.nullCheck(a, b);
		if (notNull != CheckNull.NOT_NULL) {
			return notNull;
		}
		Student studentOne = a;
		Student studentTwo = b;
		switch (this.i) {
		case 0:
			return (studentOne.getName().compareTo(studentTwo.getName())) * n;
		case 1:
			return (studentOne.getLastname().compareTo(studentTwo.getLastname())) * n;
		case 2:
			return (studentOne.getAge() - studentTwo.getAge()) * n;
		case 3:
			return ((studentOne.isSex()) ? 1 : -1) * n;
		case 4:
			return ((studentOne.getZach() > studentTwo.getZach()) ? 1 : -1) * n;
		}
		return 0;
	}

}

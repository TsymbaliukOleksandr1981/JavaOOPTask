package com.gmail.tsa;

import java.util.Comparator;

public class StudentComparator implements Comparator {
	private int i = 0;

	public StudentComparator(int i) {
		super();
		this.i = i;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	@Override
	public int compare(Object a, Object b) {
		if (a != null && b == null) {
			return 1;
		}
		if (a == null && b != null) {
			return -1;
		}
		if (a == null && b == null) {
			return 0;
		}
		Student studentOne = (Student) a;
		Student studentTwo = (Student) b;
		switch (this.i) {
		case 0:
			return studentOne.getName().compareTo(studentTwo.getName());
		case 1:
			return studentOne.getLastname().compareTo(studentTwo.getLastname());
		case 2:
			return studentOne.getAge() - studentTwo.getAge();
		case 3:
			return (studentOne.isSex()) ? 1 : -1;
		case 4:
			return (studentOne.getZach() > studentTwo.getZach()) ? 1 : -1;
		case 5:
			return studentOne.getGroup().compareTo(studentTwo.getGroup());
		}
		return 0;
		}

	}



package com.gmail.tsa;

public class Student extends Human {
	private long zach;
	private String group;

	public Student(String name, String lastname, int age, boolean sex, long zach, String group) {
		super(name, lastname, age, sex);
		this.zach = zach;
		this.group = group;
	}

	public Student() {
		super();
	}

	public long getZach() {
		return zach;
	}

	public void setZach(long zach) {
		this.zach = zach;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	@Override
	public String toString() {
		return "Student [zach=" + zach + ", group=" + group + "]" + super.toString();
	}

}

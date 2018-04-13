package com.gmail.tsa;

import java.io.Serializable;

public class Student extends Human implements Serializable {
	private static final long serialVersionUID = 1L;
	private String group;
	private long zach;

	public Student() {
		super();
	}

	public Student(String name, String lastname, int age, boolean sex, long zach, String group) {
		super(name, lastname, age, sex);
		this.zach = zach;
		this.group = group;
	}

	public String getGroup() {
		return group;
	}

	public long getZach() {
		return zach;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public void setZach(long zach) {
		this.zach = zach;
	}

	@Override
	public String toString() {
		return "Student [zach=" + zach + ", group=" + group + "]" + super.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((group == null) ? 0 : group.hashCode());
		result = prime * result + (int) (zach ^ (zach >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (group == null) {
			if (other.group != null)
				return false;
		} else if (!group.equals(other.group))
			return false;
		if (zach != other.zach)
			return false;
		return true;
	}

}

package com.gmail.tsa;

public class Human {
	private String name;
	private String lastname;
	private int age;
	private boolean sex;

	public Human(String name, String lastname, int age, boolean sex) {
		super();
		this.name = name;
		this.lastname = lastname;
		this.age = age;
		this.sex = sex;
	}

	public Human() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isSex() {
		return sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "Human [name=" + name + ", lastname=" + lastname + ", age=" + age + ", sex=" + sex + "]";
	}

}

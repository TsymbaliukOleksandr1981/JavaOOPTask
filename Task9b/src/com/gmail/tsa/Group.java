package com.gmail.tsa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Group implements Voencom, Serializable {

	private static final long serialVersionUID = 1L;
	private List<Student> students;
	private String groupName;
	private int MAX_GROUP_SIZE = 10;

	public Group() {
		super();
		students = new ArrayList<>();
		this.groupName = "unknow";
	}

	public Group(String groupName) {
		super();
		students = new ArrayList<>();
		this.groupName = groupName;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public void addStudent(Student student) throws MyException {
		if (student == null) {
			throw new IllegalArgumentException("Null student");
		}
		if (students.size() >= MAX_GROUP_SIZE) {
			throw new MyException();
		}
		students.add(student);
	}

	public Student search(String lastName) {
		for (Student student : students) {
			if (student.getLastname().equals(lastName)) {
				return student;
			}
		}
		return null;
	}

	public boolean deleteStudent(long number) {
		Iterator<Student> itr = this.students.iterator();
		for (; itr.hasNext();) {
			Student student = itr.next();
			if (student.getZach() == number) {
				itr.remove();
				return true;
			}
		}
		return false;
	}

	public void sortByParametr(int i) {
		this.students.sort(new StudentComparator(i));
	}

	public void sortByParametr(int i, boolean forward) {
		this.students.sort(new StudentComparator(i, forward));
	}

	public Student[] getStudentArray() {
		return this.students.toArray(new Student[0]);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Group: " + this.groupName).append(System.lineSeparator());
		int i = 0;
		sortByParametr(1);
		for (Student student : students) {
			if (student != null) {
				sb.append((++i) + ") ").append(student);
				sb.append(System.lineSeparator());
			}
		}
		return sb.toString();
	}

	@Override
	public Student[] getRecruter() {
		int n = 0;
		for (Student student : students) {
			if (student.isSex() && student.getAge() >= 18) {
				n += 1;
			}
		}
		Student[] recruterArray = new Student[n];
		int i = 0;
		for (Student student : this.students) {
			if (student.isSex() && student.getAge() >= 18) {
				recruterArray[i++] = student;
			}
		}
		return recruterArray;
	}

}

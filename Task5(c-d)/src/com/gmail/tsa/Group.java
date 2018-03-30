package com.gmail.tsa;

import java.util.Arrays;

public class Group implements Voencom {
	private Student[] studentArray = new Student[10];
	private String groupName;

	public Group() {
		super();
		this.groupName = "unknow";
	}

	public Group(String groupName) {
		super();
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
		for (int i = 0; i < studentArray.length; i++) {
			if (studentArray[i] == null) {
				studentArray[i] = student;
				return;
			}
		}
		throw new MyException();
	}

	public Student search(String lastName) {
		for (Student student : studentArray) {
			if (student != null && student.getLastname().equals(lastName)) {
				return student;
			}
		}
		return null;
	}

	public void deleteStudent(int n) {
		if (!(n >= 0 && n < studentArray.length)) {
			System.out.println("Error index");
			return;
		}
		studentArray[n] = null;
	}

	private void sort() {
		for (int i = 0; i < studentArray.length - 1; i++) {
			for (int j = i + 1; j < studentArray.length; j++) {
				if (compareStudent(studentArray[i], studentArray[j]) > 0) {
					Student temp = studentArray[i];
					studentArray[i] = studentArray[j];
					studentArray[j] = temp;
				}
			}
		}
	}

	private int compareStudent(Student a, Student b) {
		if (a != null && b == null) {
			return 1;
		}
		if (a == null && b != null) {
			return -1;
		}
		if (a == null && b == null) {
			return 0;
		}
		return a.getLastname().compareTo(b.getLastname());

	}

	public void sortByParametr(int i) {
		Arrays.sort(this.studentArray, new StudentComparator(i));
	}

	public Student[] getStudentArray() {
		Student[] temp = new Student[this.studentArray.length];
		System.arraycopy(studentArray, 0, temp, 0, temp.length);
		return temp;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Group: " + this.groupName).append(System.lineSeparator());
		int i = 0;
		 sort();
		for (Student student : studentArray) {
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
		for (Student student : studentArray) {
			if (student != null && student.isSex() && student.getAge() >= 18) {
				n += 1;
			}
		}
		Student[] studentArray = new Student[n];
		int i = 0;
		for (Student student : studentArray) {
			if (student != null && student.isSex() && student.getAge() >= 18) {
				studentArray[i++] = student;
			}
		}
		return studentArray;
	}

}

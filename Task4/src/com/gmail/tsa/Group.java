package com.gmail.tsa;

import java.util.Arrays;

import javax.swing.JOptionPane;

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

	public void addStudentInteractive() throws MyException {
		try {
			String name = getName("Input student name");
			String lastName = getName("Input student lastname");
			int age = getAge();
			boolean sex = getSex("Input sex -> man or women");
			long zach = getZach("Input zach number");
			String group = this.groupName;
			Student st = new Student(name, lastName, age, sex, zach, group);
			this.addStudent(st);
		} catch (NullPointerException e) {
			System.out.println("Canceled");
			return;
		}
	}

	public void addStudent(Student student) throws MyException {
		if (student == null) {
			throw new IllegalArgumentException("Null student");
		}
		for (int i = 0; i < studentArray.length; i++) {
			if (studentArray[i] == null) {
				student.setGroup(this.groupName);
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

	public boolean deleteStudent(long number) {
		for (int i = 0; i < studentArray.length; i++) {
			if (studentArray[i] != null && studentArray[i].getZach() == number) {
				studentArray[i] = null;
				return true;
			}
		}
		return false;

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

	private int getAge() throws NullPointerException {
		boolean done = false;
		int age = 0;
		for (; !done;) {
			try {
				age = Integer.valueOf(JOptionPane.showInputDialog("Input student age"));
				done = true;
			} catch (NumberFormatException e) {
				JOptionPane.showInternalMessageDialog(null, "Invalid ");
			}
		}
		return age;
	}

	private String getName(String message) throws NullPointerException {
		boolean done = false;
		String name = "";
		for (; !done;) {
			try {
				name = JOptionPane.showInputDialog(message);
				done = true;
			} catch (NumberFormatException e) {
				JOptionPane.showInternalMessageDialog(null, "Invalid format");
			}
		}
		return name;
	}

	private boolean getSex(String message) throws NullPointerException {
		boolean done = false;
		boolean name = false;
		for (; !done;) {
			try {
				name = JOptionPane.showInputDialog(message).equals("man");
				done = true;
			} catch (NumberFormatException e) {
				JOptionPane.showInternalMessageDialog(null, "Invalid format");
			}
		}
		return name;
	}

	private long getZach(String message) throws NullPointerException {
		boolean done = false;
		long name = 0;
		for (; !done;) {
			try {
				name = Long.valueOf(JOptionPane.showInputDialog(message));
				done = true;
			} catch (NumberFormatException e) {
				JOptionPane.showInternalMessageDialog(null, "Invalid format");
			}
		}
		return name;
	}

	public void sortByParametr(int i) {
		Arrays.sort(this.studentArray, new StudentComparator(i));
	}

	public void sortByParametr(int i, boolean forward) {
		Arrays.sort(this.studentArray, new StudentComparator(i, forward));
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Group: " + this.groupName).append(System.lineSeparator());
		int i = 0;
		// sort();
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
		Student[] recruterArray = new Student[n];
		int i = 0;
		for (Student student : this.studentArray) {
			if (student != null && student.isSex() && student.getAge() >= 18) {
				recruterArray[i++] = student;
			}
		}
		return recruterArray;
	}

}

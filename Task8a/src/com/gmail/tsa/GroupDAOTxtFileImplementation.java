package com.gmail.tsa;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class GroupDAOTxtFileImplementation implements GroupDAO {
	private File folder;

	public GroupDAOTxtFileImplementation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GroupDAOTxtFileImplementation(File folder) {
		super();
		this.folder = folder;
	}

	public File getFolder() {
		return folder;
	}

	public void setFolder(File folder) {
		this.folder = folder;
	}

	@Override
	public void saveGroup(Group group) {
		try (PrintWriter pw = new PrintWriter(new File(folder, group.getGroupName() + ".txt"))) {
			for (Student student : group.getStudentArray()) {
				if (student != null) {
					pw.println(student.getName() + "," + student.getLastname() + "," + student.getAge() + ","
							+ student.isSex() + "," + student.getZach() + "," + student.getGroup());
				}
			}
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	@Override
	public Group loadGroupByName(String groupName) {
		Group groupR = new Group(groupName);
		try (BufferedReader br = new BufferedReader(new FileReader(new File(folder, groupName + ".txt")))) {
			String text = "";
			for (; (text = br.readLine()) != null;) {
				String[] studentDate = text.split(",");
				String name = studentDate[0];
				String lastname = studentDate[1];
				int age = Integer.valueOf(studentDate[2]);
				boolean sex = (studentDate[3].equals("true"));
				long zach = Long.valueOf(studentDate[4]);
				String group = groupName;
				Student student = new Student(name, lastname, age, sex, zach, group);
				groupR.addStudent(student);

			}
		} catch (IOException | MyException e) {
			System.out.println(e);
			return null;
		}
		return groupR;
	}

}

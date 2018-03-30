package com.gmail.tsa;

import java.io.File;

public class Main {
	public static void main(String[] args) {
		Group gr = new Group("PN-121");
		try {
			gr.addStudent(new Student("Alex", "AA", 12, true, 1234, "PN-121"));
			gr.addStudent(new Student("Alex", "AB", 15, true, 1253, "PN-121"));
			gr.addStudent(new Student("Alex", "BB", 13, true, 14523, "PN-121"));
			gr.addStudent(new Student("Alex", "BA", 23, true, 12213, "PN-121"));
			gr.addStudent(new Student("Alex", "AAA", 34, true, 1243, "PN-121"));
			gr.addStudent(new Student("Alex", "AAZ", 2, true, 12123, "PN-121"));
		} catch (MyException e) {
			System.out.println(e.getMessage());
		}
		System.out.println(gr);

		File folder = new File("GROPS");
		folder.mkdirs();

		GroupDAO groupDAO = new GroupDAOTxtFileImplementation(folder);
		GroupController controller = new GroupController(groupDAO);
		controller.saveGroup(gr);
		System.out.println();
		Group groupTwo = controller.loadGroupByName("PN-121");
		System.out.println(groupTwo);

	}
}

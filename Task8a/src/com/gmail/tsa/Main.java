package com.gmail.tsa;

import java.io.File;

public class Main {
	public static void main(String[] args) {
		Group gr = new Group("PN-121");
		try {
			gr.addStudent(new Student("Alexander", "Ts", 19, true, 1234, "PN-121"));
			gr.addStudent(new Student("Ekaterina", "Rez", 18, false, 1253, "PN-121"));
			gr.addStudent(new Student("Alexey", "St", 20, true, 14523, "PN-121"));
			gr.addStudent(new Student("Irina", "Iv", 23, false, 12213, "PN-121"));
			gr.addStudent(new Student("Olga", "Cher", 17, false, 1243, "PN-121"));
			gr.addStudent(new Student("Andrey", "Pop", 18, true, 12123, "PN-121"));
		} catch (MyException e) {
			System.out.println(e.getMessage());
		}
		System.out.println(gr);

		File folder = new File("GROPS");
		folder.mkdirs();

		GroupDAO groupDAO = new GroupDAOSerializableImplementation(folder);
		GroupController controller = new GroupController(groupDAO);
		controller.saveGroup(gr);
		System.out.println();
		Group groupTwo = controller.loadGroupByName("PN-121");
		System.out.println(groupTwo);

	}
}

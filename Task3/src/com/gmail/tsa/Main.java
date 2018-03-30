package com.gmail.tsa;

public class Main {
	public static void main(String[] args) {
		Group gr = new Group("qwe");
		try {
			gr.addStudent(new Student("Alex", "AA", 12, true, 123, "qwe"));
			gr.addStudent(new Student("Alex", "AB", 12, true, 123, "qwe"));
			gr.addStudent(new Student("Alex", "BB", 12, true, 123, "qwe"));
			gr.addStudent(new Student("Alex", "BA", 12, true, 123, "qwe"));
			gr.addStudent(new Student("Alex", "AAA", 12, true, 123, "qwe"));
			gr.addStudent(new Student("Alex", "AAZ", 12, true, 123, "qwe"));
		} catch (MyException e) {
			System.out.println(e.getMessage());
		}
		System.out.println(gr);

		System.out.println();

		Student st = gr.search("BB");

		System.out.println(st);
	}
}

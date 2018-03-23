package com.gmail.tsa;

public class Main {
	public static void main(String[] args) {

		Group gr = new Group();
		try {
			gr.addStudent(new Student("Alex", "AA", 12, true, 1234, "qwea"));
			gr.addStudent(new Student("Alex", "AB", 15, true, 1253, "qwwe"));
			gr.addStudent(new Student("Alex", "BB", 13, true, 14523, "qrwe"));
			gr.addStudent(new Student("Alex", "BA", 23, true, 12213, "qfwe"));
			gr.addStudent(new Student("Alex", "AAA", 34, true, 1243, "qewe"));
			gr.addStudent(new Student("Alex", "AAZ", 2, true, 12123, "qeewe"));

		} catch (MyException e) {
			System.out.println(e.getMessage());
		}

		System.out.println(gr);
		gr.sortByParametr(2,false);
		System.out.println(gr);
	}
}

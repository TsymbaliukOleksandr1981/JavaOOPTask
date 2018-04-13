package com.gmail.tsa;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Deque<Person> bigBangTeoryPerson = new ArrayDeque<>();
		bigBangTeoryPerson.addLast(new Person("Sheldon"));
		bigBangTeoryPerson.addLast(new Person("Leonard"));
		bigBangTeoryPerson.addLast(new Person("Volovitc"));
		bigBangTeoryPerson.addLast(new Person("Kutrapalli"));
		bigBangTeoryPerson.addLast(new Person("Penny"));

		drinkMagicCola(2, bigBangTeoryPerson);

		for (Person person : bigBangTeoryPerson) {
			System.out.print(person + "  ");
		}
	}

	public static void drinkMagicCola(int glass, Deque<Person> persons) {
		for (int i = 0; i < glass; i++) {
			Person temp = persons.pollFirst();
			persons.addLast(temp);
			persons.addLast(temp);
		}
	}

}

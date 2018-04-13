package com.gmail.tsa;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = new ArrayList<>();
		fillList(list);
		System.out.println(list);
		changeList(list);
		System.out.println(list);
	}

	public static void fillList(List<Integer> list) {
		for (int i = 0; i < 10; i++) {
			list.add((int) (Math.random() * 100));
		}
	}

	public static void changeList(List<Integer> list) {
		list.remove(0);
		list.remove(0);
		list.remove(list.size() - 1);
	}

}

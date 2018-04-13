package com.gmail.tsa;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random rn = new Random();
		Integer[] array = new Integer[100];
		for (int i = 0; i < array.length; i++) {
			array[i] = rn.nextInt(10);
		}

		Map<Integer, Integer> stat = getStatistic(array);

		stat.forEach((key, value) -> System.out.println(key + " = " + value));
	}

	public static <T> Map<T, Integer> getStatistic(T[] array) {
		Map<T, Integer> result = new HashMap<>();
		for (T element : array) {
			Integer number = result.get(element);
			if (number == null) {
				result.put(element, 1);
			} else {
				result.put(element, number + 1);
			}
		}
		return result;
	}

}

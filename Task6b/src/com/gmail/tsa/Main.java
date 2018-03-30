package com.gmail.tsa;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = new int[200_000_000];
		Random rn = new Random();
		for (int i = 0; i < array.length; i++) {
			array[i] = rn.nextInt(10);
		}
		long begin;
		long end;
		MultyThreadCalculation multiSum = new MultyThreadCalculation(array);
		begin = System.currentTimeMillis();
		System.out.println(multiSum.calculateSum());
		end = System.currentTimeMillis();

		System.out.println("MultiThread sum " + (end - begin) + " ms");
		begin = System.currentTimeMillis();
		System.out.println(getSum(array));
		end = System.currentTimeMillis();
		System.out.println("Static method sum  " + (end - begin) + " ms");

	}

	public static int getSum(int[] array) {
		int sum = 0;
		for (int i : array) {
			sum += i;
		}
		return sum;
	}

}

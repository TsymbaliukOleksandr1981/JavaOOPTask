package com.gmail.tsa;

import java.io.File;
import java.math.BigInteger;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack stack = new Stack();
		BlackList bl = new BlackList();
		bl.addClassToList(Integer.class);
		stack.setBlackList(bl);
		stack.addElement(new File("a.txt"));
		stack.addElement(new Scanner(System.in));
		stack.addElement(new BigInteger("100500"));
		stack.addElement(12345);
		stack.addElement(true);

		 //System.out.println(stack);

		for (; stack.peek() != null;) {
			System.out.println(stack.pop());
		}
	}

}

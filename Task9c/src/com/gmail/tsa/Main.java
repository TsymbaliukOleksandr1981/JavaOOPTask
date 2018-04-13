package com.gmail.tsa;

import java.io.File;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Statictic st = new Statictic();
		st.loadTextFromFile(new File("Romeo and Juliet.txt"));
		System.out.println(st);
	}

}

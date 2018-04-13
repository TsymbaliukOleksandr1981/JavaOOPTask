package com.gmail.tsa;

import java.io.File;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConsoleTranslator ct = new ConsoleTranslator();
		File font = new File("my_font_big.txt");
		ct.loadFontFromFile(font);
		font = new File("my_font_small.txt");
		ct.loadFontFromFile(font);
		font = new File("my_font_punkt.txt");
		ct.loadFontFromFile(font);
		System.out.println(ct.transform("PROG.KIEV.UA"));
	}

}

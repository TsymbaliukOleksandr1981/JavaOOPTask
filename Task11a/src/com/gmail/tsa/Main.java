package com.gmail.tsa;

import java.io.File;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HtmlParser hp = new HtmlParser("https://prog.kiev.ua/forum/index.php/board,2.0.html", new File("link.txt"));
		hp.getURLsLInk();
	}

}

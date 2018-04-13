package com.gmail.tsa;

import java.io.File;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Translate translate = new Translate();
		File file = new File("dict.dat");
		DictionaryDAO dictDAO = new DictionaryDAOSVCImplementation(file);
		translate.loadDictionary(dictDAO);
		AddWords addWords = new AddWordsConsole();
		translate.addWordsInteractive(addWords);
		translate.saveDictionary(dictDAO);
		File in = new File("English.in");
		File out = new File("Ukrainian.out");
		translate.translateFIle(in, out);
	}

}

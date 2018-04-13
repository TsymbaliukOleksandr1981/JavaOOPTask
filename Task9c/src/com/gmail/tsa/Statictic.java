package com.gmail.tsa;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Statictic {
	private List<Letter> lettersList;

	public Statictic() {
		super();
		lettersList = new ArrayList<>();
	}

	public void loadTextFromFile(File file) {
		String text = TextService.loadTextFromFile(file);
		text = text.toUpperCase();
		for (char i = 'A'; i <= 'Z'; i++) {
			int letterCount = TextService.countLetter(text, i);
			if (letterCount > 0) {
				lettersList.add(new Letter(i, letterCount));
			}
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		lettersList.sort((a, b) -> b.getCount() - a.getCount());
		for (Letter letter : lettersList) {
			sb.append(letter);
			sb.append(System.lineSeparator());
		}
		return sb.toString();
	}

}

package com.gmail.tsa;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TextService {
	public static String loadTextFromFile(File file) {
		if (file == null) {
			throw new IllegalArgumentException("null file pointer");
		}
		StringBuilder sb = new StringBuilder();

		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String text = "";
			for (; (text = br.readLine()) != null;) {
				sb.append(text);
			}
		} catch (IOException e) {
			System.out.println(e);
		}
		return sb.toString();
	}

	public static int countLetter(String text, char letter) {
		int letterCount = 0;
		for (char let : text.toCharArray()) {
			if (let == letter) {
				letterCount += 1;
			}
		}
		return letterCount;
	}

}

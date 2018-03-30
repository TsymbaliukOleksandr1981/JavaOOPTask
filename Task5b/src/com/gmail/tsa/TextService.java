package com.gmail.tsa;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class TextService {

	public static String loadTextFromFile(File file) {
		if (file == null) {
			throw new IllegalArgumentException("Null file pointer");
		}
		StringBuilder sb = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String text = "";
			for (; (text = br.readLine()) != null;) {
				sb.append(text);
				sb.append(System.lineSeparator());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

	public static String[] getWords(String textline) {
		String[] words = textline.split("[ .,\n!]");
		return words;
	}

	public static boolean isWordsInText(String word, String text) {
		String[] textArray = getWords(text);
		for (String wordOne : textArray) {
			if (word.equals(wordOne)) {
				return true;
			}
		}
		return false;
	}

	public static void saveTextToFile(String text, File file) {
		if (file == null || text == null) {
			throw new IllegalArgumentException("Null pointer");
		}
		try (PrintWriter pw = new PrintWriter(file)) {
			pw.println(text);
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	public static void saveEqualsWords(File one, File two, File result) {
		if (one == null || two == null || result == null) {
			throw new IllegalArgumentException("null pointer");
		}
		String textOne = loadTextFromFile(one);
		String textTwo = loadTextFromFile(two);
		StringBuilder sb = new StringBuilder();
		String[] words = getWords(textOne);
		for (String word : words) {
			if (isWordsInText(word, textTwo)) {
				sb.append(word + " ");
			}
		}
		saveTextToFile(sb.toString(), result);
	}
}

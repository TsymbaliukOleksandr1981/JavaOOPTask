package com.gmail.tsa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class AddWordsConsole implements AddWords {
	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public AddWordsConsole() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean addMoreWord() {
		System.out.println("Add word (yes/no)");
		try {
			String result = br.readLine();
			if (result.equals("y") || result.equals("yes")) {
				return true;
			}
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return false;
		}

	}

	@Override
	public Map<String, String> addWord() {
		Map<String, String> result = new HashMap<>();
		try {
			System.out.println("Input english word");
			String word = br.readLine();
			System.out.println("Input ukrainian translate");
			String translate = br.readLine();
			result.put(word, translate);
		} catch (IOException e) {
			// TODO: handle exception
		}
		return result;
	}

}

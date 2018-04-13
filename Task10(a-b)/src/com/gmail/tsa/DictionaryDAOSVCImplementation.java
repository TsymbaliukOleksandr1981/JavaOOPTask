package com.gmail.tsa;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class DictionaryDAOSVCImplementation implements DictionaryDAO {
	private File file;

	public DictionaryDAOSVCImplementation(File file) {
		super();
		this.file = file;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	@Override
	public void saveDictionary(Map<String, String> result) {
		try (PrintWriter pw = new PrintWriter(this.file)) {
			result.forEach((key, value) -> pw.println(key + "," + value));
		} catch (IOException e) {
			// TODO: handle exception
		}

	}

	@Override
	public Map<String, String> loadDictionary() {
		Map<String, String> result = new HashMap<>();
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String temp = "";
			for (; (temp = br.readLine()) != null;) {
				String[] words = temp.split(",");
				result.put(words[0], words[1]);
			}
		} catch (IOException e) {
			// TODO: handle exception
		}
		return result;
	}

}

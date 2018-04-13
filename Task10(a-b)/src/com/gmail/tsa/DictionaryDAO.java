package com.gmail.tsa;

import java.util.Map;

public interface DictionaryDAO {
	public void saveDictionary(Map<String, String> result);

	public Map<String, String> loadDictionary();
}

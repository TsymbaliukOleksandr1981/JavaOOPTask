package com.gmail.tsa;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HtmlParser {
	private String url;
	private File file;

	public HtmlParser(String url, File file) {
		super();
		this.url = url;
		this.file = file;
	}

	public HtmlParser() {
		super();
	}

	private String loadFromURL() {
		StringBuilder sb = new StringBuilder();
		try {
			URL urlC = new URL(this.url);
			HttpURLConnection con = (HttpURLConnection) urlC.openConnection();
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String temp = "";
			for (; (temp = br.readLine()) != null;) {
				sb.append(temp).append(System.lineSeparator());
			}
		} catch (IOException e) {
			System.out.println(e);
		}
		return sb.toString();
	}

	private void saveToFile(String text, File file) {
		try (PrintWriter pw = new PrintWriter(file)) {
			pw.println(text);
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	private String getAllReferences(String htmlDocument) {
		StringBuilder sb = new StringBuilder();
		final String TAG_PATTERN = "(?i)<a([^>]+)>(.+?)</a>";
		final String LINK_PATTERN = "\\s*(?i)href\\s*=\\s*(\\\"([^\"]*\\\")|'[^']*'|([^'\">\\s]+))";
		Pattern tagPattern = Pattern.compile(TAG_PATTERN);
		Pattern linkPattern = Pattern.compile(LINK_PATTERN);
		Matcher tagMatcher = tagPattern.matcher(htmlDocument);
		while (tagMatcher.find()) {
			String aTag = tagMatcher.group();
			Matcher linkMatcher = linkPattern.matcher(aTag);

			if (linkMatcher.find()) {
				String link = linkMatcher.group(1);
				sb.append(link.substring(1, link.length() - 1).trim());
				sb.append(System.lineSeparator());
			}
		}
		return sb.toString();
	}

	public void getURLsLInk() {
		String text = loadFromURL();
		String links = getAllReferences(text);
		saveToFile(links, this.file);
	}
}

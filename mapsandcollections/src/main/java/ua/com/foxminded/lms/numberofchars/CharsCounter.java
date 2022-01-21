package ua.com.foxminded.lms.numberofchars;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.zip.CRC32;

public class CharsCounter {
	public static final String END_OF_LINE = System.getProperty("line.separator");
	private HashMap<Long, SoftReference<LinkedHashMap<Character, Integer>>> stringCache;

	public CharsCounter() {
		stringCache = new HashMap<Long, SoftReference<LinkedHashMap<Character, Integer>>>();
	}

	public String getCharsCounts(String input) {
		if (input == null) {
			throw new IllegalArgumentException("ERROR: Null Pointer Argument.");
		}

		CRC32 stringCRC32 = new CRC32();
		stringCRC32.update(input.getBytes());
		LinkedHashMap<Character, Integer> charsCount = null;
		SoftReference<LinkedHashMap<Character, Integer>> charsCountRef;

		if (stringCache.containsKey(stringCRC32.getValue())) {
			charsCount = stringCache.get(stringCRC32.getValue()).get();
		}

		if (charsCount == null) {
			charsCount = countChars(input);
			charsCountRef = new SoftReference<LinkedHashMap<Character, Integer>>(charsCount);
			stringCache.put(stringCRC32.getValue(), charsCountRef);
		}
		return input + END_OF_LINE + charsCountsToString(charsCount);
	}

	private LinkedHashMap<Character, Integer> countChars(String input) {
		LinkedHashMap<Character, Integer> characters = new LinkedHashMap<Character, Integer>();

		for (int i = 0; i < input.length(); i++) {
			characters.merge(input.charAt(i), 1, Integer::sum);
		}
		return characters;
	}

	private String charsCountsToString(LinkedHashMap<Character, Integer> input) {
		String result = "";

		for (Map.Entry<Character, Integer> entry : input.entrySet()) {
			result += "\"" + entry.getKey() + "\" - " + entry.getValue() + END_OF_LINE;
		}
		return result;
	}

		
}

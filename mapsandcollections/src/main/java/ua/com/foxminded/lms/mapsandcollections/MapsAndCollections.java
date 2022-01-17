package ua.com.foxminded.lms.mapsandcollections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.zip.CRC32;

public class MapsAndCollections {
	private HashMap<Long, ArrayList<String>> stringDictionary;
	private String messageLastOperation;

	public MapsAndCollections() {
		stringDictionary = new HashMap<Long, ArrayList<String>>();
		messageLastOperation = "";
	}
	public String getMessageLastOperation() {
		return this.messageLastOperation;
	}
	
	public String getCountCharsInString(String input) {
		if (input == null) {
			throw new IllegalArgumentException("ERROR: Null Pointer Argument.");
		} else {
			CRC32 stringCRC32 = new CRC32();
			stringCRC32.update(input.getBytes());
			ArrayList<String> resultArrayList = new ArrayList<String>();
			String result = "";

			if (isResultInDictionary(stringCRC32.getValue())) {
				resultArrayList = retrieveFromDictionary(stringCRC32.getValue());
			} else {
				resultArrayList = countCharsInString(input);
				storeInDictionary(stringCRC32.getValue(), resultArrayList);
			}

			Iterator<String> iterator = resultArrayList.iterator();
			while (iterator.hasNext()) {
				result += iterator.next() + "\r\n";
			}
			return result;
		}
	}

	private boolean isResultInDictionary(long CRC32) {
		ArrayList<String> arrayList = stringDictionary.get(CRC32);

		if (arrayList == null) {
			return false;
		} else {
			return true;
		}
	}

	private void storeInDictionary(long CRC32, ArrayList<String> inputArrayList) {
		stringDictionary.put(CRC32, inputArrayList);
	}

	private ArrayList<String> retrieveFromDictionary(long stringCRC32) {
		messageLastOperation = "Result retrieved from dictionary.";
		return stringDictionary.get(stringCRC32);
	}

	private ArrayList<String> countCharsInString(String input) {
		LinkedHashMap<Character, Integer> characters = new LinkedHashMap<Character, Integer>();
		ArrayList<String> result = new ArrayList<String>();

		for (int i = 0; i < input.length(); i++) {
			if (characters.get(input.charAt(i)) == null) {
				characters.put(input.charAt(i), 1);
			} else {
				int count = characters.get(input.charAt(i));
				count++;
				characters.replace(input.charAt(i), count);
			}
		}

		result.add(input);
		for (Map.Entry<Character, Integer> entry : characters.entrySet()) {
			result.add("\"" + entry.getKey() + "\" - " + entry.getValue());
		}
		messageLastOperation = "Result counted.";
		return result;

	}

}

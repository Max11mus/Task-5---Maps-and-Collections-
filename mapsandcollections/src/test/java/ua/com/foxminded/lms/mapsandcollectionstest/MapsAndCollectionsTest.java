package ua.com.foxminded.lms.mapsandcollectionstest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ua.com.foxminded.lms.mapsandcollections.MapsAndCollections;

class MapsAndCollectionsTest {
	static MapsAndCollections mapsAndCollection;

	@BeforeAll
	static void MapsAndCollectionsTestsSetUp() {
		mapsAndCollection = new MapsAndCollections();
		mapsAndCollection.getCountCharsInString("Hello World!");
		mapsAndCollection.getCountCharsInString("Java is Cool!!!");
		mapsAndCollection.getCountCharsInString("");
		mapsAndCollection.getCountCharsInString("8");
	}

	@Test
	void getCountCharsInString_throwIllegalArgumentException_whenInputIsNull() {
		assertThrows(IllegalArgumentException.class, () -> mapsAndCollection.getCountCharsInString(null),
				"Must throw IllegalArgumentException exception when input null.");
	}

	@Test
	void getCountCharsInString_returnResult_whenInputIsInDictionary() {
		String expected ="Java is Cool!!!\r\n"
						+"\"J\" - 1\r\n"
						+ "\"a\" - 2\r\n"
						+ "\"v\" - 1\r\n"
						+ "\" \" - 2\r\n"
						+ "\"i\" - 1\r\n"
						+ "\"s\" - 1\r\n"
						+ "\"C\" - 1\r\n"
						+ "\"o\" - 2\r\n"
						+ "\"l\" - 1\r\n"
						+ "\"!\" - 3\r\n";
		String actual = mapsAndCollection.getCountCharsInString("Java is Cool!!!");
		String inDictionary = "Result retrieved from dictionary.";
		
		assertEquals(expected, actual, "Must return result.");
		assertEquals(inDictionary, mapsAndCollection.getMessageLastOperation(), "Input in dictionary.");
	}
	
	@Test
	void getCountCharsInString_returnResult_whenInputIsNotInDictionary() {
		String expected = "JAVA IS COOL!!!\r\n"
						+ "\"J\" - 1\r\n"
						+ "\"A\" - 2\r\n"
						+ "\"V\" - 1\r\n"
						+ "\" \" - 2\r\n"
						+ "\"I\" - 1\r\n"
						+ "\"S\" - 1\r\n"
						+ "\"C\" - 1\r\n"
						+ "\"O\" - 2\r\n"
						+ "\"L\" - 1\r\n"
						+ "\"!\" - 3\r\n";
		String actual = mapsAndCollection.getCountCharsInString("JAVA IS COOL!!!");
		String notInDictionary = "Result counted.";
		
		assertEquals(expected, actual, "Must return result.");
		assertEquals(notInDictionary, mapsAndCollection.getMessageLastOperation(), "Input is counted.");
	}

	@Test
	void getCountCharsInString_returnBlankLine_whenInputIsEmptyString() {
		String expected = "\r\n";
		String actual = mapsAndCollection.getCountCharsInString("");
		
		assertEquals(expected, actual, "Must return blank line.");
	}

	@Test
	void getCountCharsInString_returnResult_whenInputIsOneCharacter() {
		String expected = "7\r\n" + "\"7\" - 1\r\n";
		String actual = mapsAndCollection.getCountCharsInString("7");
		
		assertEquals(expected, actual, "Must return Result.");
	}
	
}

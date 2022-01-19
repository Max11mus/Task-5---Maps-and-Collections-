package ua.com.foxminded.lms.numberofcharstest;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ua.com.foxminded.lms.numberofchars.NumberOfChars;

class NumberOfCharsTest {
	static NumberOfChars numberOfChars;

	@BeforeAll
	static void numberOfCharssTestsSetUp() {
		numberOfChars = new NumberOfChars();
		numberOfChars.getCharsCounts("Hello World!");
		numberOfChars.getCharsCounts("Java is Cool!!!");
		numberOfChars.getCharsCounts("");
		numberOfChars.getCharsCounts("8");
	}

	@Test
	void getCountCharsInString_throwIllegalArgumentException_whenInputIsNull() {
		assertThrows(IllegalArgumentException.class, () -> numberOfChars.getCharsCounts(null),
				"Must throw IllegalArgumentException exception when input null.");
	}

	@Test
	void getCountCharsInString_returnResult_whenInputIsInDictionary() {
		String expected ="Java is Cool!!!" + NumberOfChars.END_OF_LINE
						+"\"J\" - 1" + NumberOfChars.END_OF_LINE
						+ "\"a\" - 2" + NumberOfChars.END_OF_LINE
						+ "\"v\" - 1" + NumberOfChars.END_OF_LINE
						+ "\" \" - 2" + NumberOfChars.END_OF_LINE
						+ "\"i\" - 1" + NumberOfChars.END_OF_LINE
						+ "\"s\" - 1" + NumberOfChars.END_OF_LINE
						+ "\"C\" - 1" + NumberOfChars.END_OF_LINE
						+ "\"o\" - 2" + NumberOfChars.END_OF_LINE
						+ "\"l\" - 1" + NumberOfChars.END_OF_LINE
						+ "\"!\" - 3" + NumberOfChars.END_OF_LINE;
		String actual = numberOfChars.getCharsCounts("Java is Cool!!!");
				
		assertEquals(expected, actual, "Must return result.");
		}
	
	@Test
	void getCountCharsInString_returnResult_whenInputIsNotInDictionary() {
		String expected = "JAVA IS COOL!!!" + NumberOfChars.END_OF_LINE
						+ "\"J\" - 1" + NumberOfChars.END_OF_LINE
						+ "\"A\" - 2" + NumberOfChars.END_OF_LINE
						+ "\"V\" - 1" + NumberOfChars.END_OF_LINE
						+ "\" \" - 2" + NumberOfChars.END_OF_LINE
						+ "\"I\" - 1" + NumberOfChars.END_OF_LINE
						+ "\"S\" - 1" + NumberOfChars.END_OF_LINE
						+ "\"C\" - 1" + NumberOfChars.END_OF_LINE
						+ "\"O\" - 2" + NumberOfChars.END_OF_LINE
						+ "\"L\" - 1" + NumberOfChars.END_OF_LINE
						+ "\"!\" - 3" + NumberOfChars.END_OF_LINE;
		String actual = numberOfChars.getCharsCounts("JAVA IS COOL!!!");
				
		assertEquals(expected, actual, "Must return result.");
	}

	@Test
	void getCountCharsInString_returnBlankLine_whenInputIsEmptyString() {
		String expected = "" + NumberOfChars.END_OF_LINE;
		String actual = numberOfChars.getCharsCounts("");
		
		assertEquals(expected, actual, "Must return blank line.");
	}

	@Test
	void getCountCharsInString_returnResult_whenInputIsOneCharacter() {
		String expected = "7" + NumberOfChars.END_OF_LINE + "\"7\" - 1" + NumberOfChars.END_OF_LINE;
		String actual = numberOfChars.getCharsCounts("7");
		
		assertEquals(expected, actual, "Must return Result.");
	}
	
	@Test
	void getCountCharsInString_returnResult_whenInputIsUpperAndLowerCasedLetters() {
		String expected = "JavAisCOOL!!!" + NumberOfChars.END_OF_LINE
						+ "\"J\" - 1" + NumberOfChars.END_OF_LINE
						+ "\"a\" - 1" + NumberOfChars.END_OF_LINE
						+ "\"v\" - 1" + NumberOfChars.END_OF_LINE
						+ "\"A\" - 1" + NumberOfChars.END_OF_LINE
						+ "\"i\" - 1" + NumberOfChars.END_OF_LINE
						+ "\"s\" - 1" + NumberOfChars.END_OF_LINE
						+ "\"C\" - 1" + NumberOfChars.END_OF_LINE
						+ "\"O\" - 2" + NumberOfChars.END_OF_LINE
						+ "\"L\" - 1" + NumberOfChars.END_OF_LINE
						+ "\"!\" - 3" + NumberOfChars.END_OF_LINE;
		String actual = numberOfChars.getCharsCounts("JavAisCOOL!!!");
		
		assertEquals(expected, actual, "Must return Result.");
	}

	@Test
	void getCountCharsInString_returnResult_whenInputIsStringWithFewWhitespaces() {
		String expected = "JavA     is   COOL!!!" + NumberOfChars.END_OF_LINE
				+ "\"J\" - 1" + NumberOfChars.END_OF_LINE
				+ "\"a\" - 1" + NumberOfChars.END_OF_LINE
				+ "\"v\" - 1" + NumberOfChars.END_OF_LINE
				+ "\"A\" - 1" + NumberOfChars.END_OF_LINE
				+ "\" \" - 8" + NumberOfChars.END_OF_LINE
				+ "\"i\" - 1" + NumberOfChars.END_OF_LINE
				+ "\"s\" - 1" + NumberOfChars.END_OF_LINE
				+ "\"C\" - 1" + NumberOfChars.END_OF_LINE
				+ "\"O\" - 2" + NumberOfChars.END_OF_LINE
				+ "\"L\" - 1" + NumberOfChars.END_OF_LINE
				+ "\"!\" - 3" + NumberOfChars.END_OF_LINE;;
		String actual = numberOfChars.getCharsCounts("JavA     is   COOL!!!");
	
		assertEquals(expected, actual, "Must return Result.");
	}

}
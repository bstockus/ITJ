package chapter5.assignment12.helpers;

public class StringsHelper {
	
	public static Integer getLength(String string) {
		return string.length();
	}
	
	public static Character getFirstChar(String string) {
		if (string.length() > 0) {
			return string.charAt(0);
		} else {
			return (Character) null;
		}
	}
	
	public static String getUppercase(String string) {
		return string.toUpperCase();
	}
	
	public static Boolean compareStrings(String firstString, String secondString) {
		return firstString.equals(secondString);
	}
	
}

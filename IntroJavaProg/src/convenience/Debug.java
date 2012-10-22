package convenience;

/**
 * Convenience class to help with printing debug messages.
 * This is a static class, and should never be instantiated.
 */
public class Debug {
	
	/**
	 * Prints the name and value of a string for debugging
	 * @param debug if true the message is printed
	 * @param name name of the variable
	 * @param value value of the variable
	 */
	public static void printDebugStringValue(Boolean debug, String name, String value) {
		if(debug) {
			System.out.printf("***DEBUG*** %s: value=\'%s\', length=%d\n",name,value,value.length());
		}
	}
	
	/**
	 * Prints the name and value of a double for debugging
	 * @param debug if true the message is printed
	 * @param name name of the variable
	 * @param value value of the variable
	 */
	public static void printDebugDoubleValue(Boolean debug, String name, Double value) {
		if(debug) {
			System.out.printf("***DEBUG*** %s: %f\n",name,value);
		}
	}
	
	/**
	 * Prints the name and value of a float for debugging
	 * @param debug if true the message is printed
	 * @param name name of the variable
	 * @param value value of the variable
	 */
	public static void printDebugFloatValue(Boolean debug, String name, Float value) {
		if(debug) {
			System.out.printf("***DEBUG*** %s: %f\n",name,value);
		}
	}
	
	/**
	 * Prints the name and value of an integer for debugging
	 * @param debug if true the message is printed
	 * @param name name of the variable
	 * @param value value of the variable
	 */
	public static void printDebugIntegerValue(Boolean debug, String name, Integer value) {
		if(debug) {
			System.out.printf("***DEBUG*** %s: %d\n",name,value);
		}
	}
	
	/**
	 * Prints the name and value of a boolean for debugging
	 * @param debug if true the message is printed
	 * @param name name of the variable
	 * @param value value of the variable
	 */
	public static void printDebugBooleanValue(Boolean debug, String name, Boolean value) {
		if(debug) {
			if(value) {
				System.out.printf("***DEBUG*** %s: TRUE\n",name);
			} else {
				System.out.printf("***DEBUG*** %s: FALSE\n",name);
			}
		}
	}

}

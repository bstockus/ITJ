package convenience;

public class Console {
	
	public static void printArrayWithHeaders(String[] headers, String[][] array, Integer columnWidth) {
		// Create Column Width String
		String printfString = "%" + columnWidth.toString() + "s";
		
		// Print Headers
		for (String header: headers) {
			System.out.printf(printfString, header);
		}
		System.out.printf("\n");
		
		// Print Array
		for (String[] row: array) {
			for (String cell: row) {
				System.out.printf(printfString, cell);
			}
			System.out.printf("\n");
		}
	}
	
	public static void printError(String message) {
		System.out.printf("ERROR: %s", message);
	}
	
}

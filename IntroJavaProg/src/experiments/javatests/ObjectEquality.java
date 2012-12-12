package experiments.javatests;

public class ObjectEquality {
	
	public static void main (String[] args) {
		
		String s1 = "Hello World";
		String s2 = new String(s1);
		String s3 = s1;
		String s4 = "Hello World";
		
		if (s1 == s2) {
			System.out.println("s2 EQUALS");
		} else {
			System.out.println("s2 NOT EQUALS");
		}
		
		if (s1 == s3) {
			System.out.println("s3 EQUALS");
		} else {
			System.out.println("s3 NOT EQUALS");
		}
		
		if (s1 == s4) {
			System.out.println("s4 EQUALS");
		} else {
			System.out.println("s4 NOT EQUALS");
		}
		
	}
	
}

package chapter5.assignment12.helpers;

public class NumbersHelper {
	
	public static Integer sum(Integer firstNumber, Integer secondNumber) {
		return (firstNumber + secondNumber);
	}
	
	public static Integer product(Integer firstNumber, Integer secondNumber) {
		return (firstNumber * secondNumber);
	}
	
	public static Boolean isEven(Integer number) {
		if ((number % 2) == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public static Boolean isOdd(Integer number) {
		if ((number % 2) == 0) {
			return false;
		} else {
			return true;
		}
	}
	
}

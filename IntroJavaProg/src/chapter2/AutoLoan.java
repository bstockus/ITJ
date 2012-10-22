package chapter2;

import javax.swing.JOptionPane;

public class AutoLoan {
	
	private static double INTEREST = 0.0299;
	
	public static void main(String[] args) {
		JOptionPane.showMessageDialog(null, "This program computes monthly payment for a car loan\n" +
											"The user is asked for:\n - the price of a car\n - the down payment\n" +
											" - the number of payments ", "JAVA Auto Sales", JOptionPane.PLAIN_MESSAGE);
		
		double carPrice = 0.0;
		while(carPrice <= 0.0) {
			String carPriceString = JOptionPane.showInputDialog(null,"Please enter the price of the car",
					"JAVA Auto Sales - Enter Price",JOptionPane.QUESTION_MESSAGE);
			if(carPriceString == null) {
				return;
			}
			if(!(carPriceString.isEmpty())) {
				try {
					carPrice = Double.parseDouble(carPriceString);
					if(carPrice <= 0.0) {
						JOptionPane.showMessageDialog(null,"Value must be an amount greater than $0.00","Error",
								JOptionPane.ERROR_MESSAGE);
					}
				} catch (java.lang.NumberFormatException e) {
					JOptionPane.showMessageDialog(null,"Value must be an amount greater than or equal to $0.00","Error",
							JOptionPane.ERROR_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(null,"Value can not be empty!","Error",JOptionPane.ERROR_MESSAGE);
			}
		}
		
		double downPayment = -1.0;
		while(downPayment < 0.0) {
			String downPaymentString = JOptionPane.showInputDialog(null,"Please enter the down payment",
					"JAVA Auto Sales - Enter Down Payments",JOptionPane.QUESTION_MESSAGE);
			if(downPaymentString == null) {
				return;
			}
			if(!(downPaymentString.isEmpty())) {
				try {
					downPayment = Double.parseDouble(downPaymentString);
					if(downPayment < 0.0) {
						JOptionPane.showMessageDialog(null,"Value must be an amount greater than $0.00","Error",
								JOptionPane.ERROR_MESSAGE);
					}
				} catch (java.lang.NumberFormatException e) {
					JOptionPane.showMessageDialog(null,"Value must be an amount greater than $0.00","Error",
							JOptionPane.ERROR_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(null,"Value can not be empty!","Error",JOptionPane.ERROR_MESSAGE);
			}
		}
		
		int numberOfPayments = 0;
		while(numberOfPayments <= 0) {
			String numberOfPaymentsString = JOptionPane.showInputDialog(null,"Please enter the number of payments",
					"JAVA Auto Sales - Enter Number of Payments",JOptionPane.QUESTION_MESSAGE);
			if(numberOfPaymentsString == null) return;
			if(!(numberOfPaymentsString.isEmpty())) {
				try {
					numberOfPayments = Integer.parseInt(numberOfPaymentsString);
					if(numberOfPayments <= 0) {
						JOptionPane.showMessageDialog(null,"Value must be an amount greater than 0 months","Error",
								JOptionPane.ERROR_MESSAGE);
					}
				} catch (java.lang.NumberFormatException e) {
					JOptionPane.showMessageDialog(null,"Value must be an amount greater than 0 months","Error",
							JOptionPane.ERROR_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(null,"Value can not be empty!","Error",JOptionPane.ERROR_MESSAGE);
			}
		}
		
		double answer = ((carPrice - downPayment) * (INTEREST/12)) / 
				(1 - (Math.pow(1 + (INTEREST/12), (-1 * numberOfPayments))));
		
		String answerString = String.format("$%.2f", answer);
		String carPriceString = String.format("$%10.2f", carPrice);
		String downPaymentString = String.format("$%10.2f",downPayment);
		String numberOfPaymentsString = String.format("%8d", numberOfPayments);
		
		JOptionPane.showMessageDialog(null, "The monthly payment is " + answerString,
				"JAVA Auto Sales - Year Monthly Payment is", JOptionPane.PLAIN_MESSAGE);
		
		System.out.println("***** Auto Loan Payment *****");
		System.out.println("Auto Price:\t\t" + carPriceString);
		System.out.println("Down Payment:\t\t" + downPaymentString);
		System.out.println("Number of Months:\t" + numberOfPaymentsString);
		System.out.println("***** Your monthly payment is " + answerString + " ******");
	}

}

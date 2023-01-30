package com.glearning.lab3.balancingbracket;

import java.util.Scanner;

/**
 * This class is responsible to take input from user as String value where brackets will be available.
 * 
 * @author Dipanjan Das
 * @since 30-Jan-2023
 * @version 1.0
 */
public class BalancingBracketTest {
	/**
	 * This is the entry point of this program. This method is called by JVM with
	 * the help of main thread.
	 * 
	 * @param args String array for command line arguments.
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter Balancing Bracket Expression");
		String expression = scanner.nextLine();
		BalancingBrackets balancingBrackets = new BalancingBrackets();
		if (balancingBrackets.isBalancedBrackets(expression)) {
			System.out.println("The entered String has Balanced Brackets");
		} else {
			System.out.println("The entered String do not contain Balanced Brackets");
		}
		scanner.close();
	}

}

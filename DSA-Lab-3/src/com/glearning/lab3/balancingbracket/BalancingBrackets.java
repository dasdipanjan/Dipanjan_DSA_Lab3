package com.glearning.lab3.balancingbracket;

import java.util.Stack;

/**
 * This class is responsible to verify string which is containing only brackets.
 * Example : [{()}] Its responsibility to check whether brackets in the string
 * are properly opened and closed.
 * 
 * @author Dipanjan Das.
 * @since 30-Jan-2023
 * @version 1.0
 */
public class BalancingBrackets {
	private Stack<Character> mStack;

	/**
	 * Constructor of this class which is responsible to initialize instance
	 * variable of the class.
	 * 
	 */
	public BalancingBrackets() {
		super();
		this.mStack = new Stack<Character>();
	}
	
	/**
	 * This method is responsible to check whether String contains only brackets and they are balanced.
	 * That means brackets are properly opened and closed.
	 * 
	 * @param expression String value which to be checked.
	 * @return true if brackets are properly opened and closed otherwise false.
	 */
	public boolean isBalancedBrackets(String expression) {
		if (expression == null || expression.isEmpty() || expression.length() % 2 != 0) {
			return false;
		}
		this.mStack.clear();
		for (int i = 0; i < expression.length(); i++) {
			char character = expression.charAt(i);
			if (!"[{()}]".contains(String.valueOf(character))) {
				return false;
			}
			if (character == '(' || character == '[' || character == '{') {
				mStack.push(character);
				continue;
			}
			if (mStack.isEmpty()) {
				return false;
			}
			char checkCharacter;
			switch (character) {
			case ')':
				checkCharacter = mStack.pop();
				if (checkCharacter != '(')
					return false;
				break;

			case '}':
				checkCharacter = mStack.pop();
				if (checkCharacter != '{')
					return false;
				break;

			case ']':
				checkCharacter = mStack.pop();
				if (checkCharacter != '[')
					return false;
				break;
			}
		}
		return (mStack.isEmpty());
	}
}

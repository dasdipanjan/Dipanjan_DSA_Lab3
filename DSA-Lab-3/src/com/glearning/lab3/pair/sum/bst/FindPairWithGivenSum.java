package com.glearning.lab3.pair.sum.bst;

import java.util.Scanner;

/**
 * This class is responsible to take input from the user to construct a Binary Search Tree and
 * take any integer number whose pair of node will be found.
 * 
 * @author Dipanjan Das
 * @since 30-Jan-2023
 * @version 1.0
 */
public class FindPairWithGivenSum {
	/**
	 * This is the entry point of this program. This method is called by JVM with
	 * the help of main thread.
	 * 
	 * @param args String array for command line arguments.
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		BinarySearchTree bst = new BinarySearchTree();
		System.out.println("Please eneter how many node you want to insert");
		int noOfNode = scanner.nextInt();
		for (int i=1; i<=noOfNode; i++) {
			System.out.println("Please enter value for node.");
			bst.insert(scanner.nextInt());
		}
		System.out.println("Provided Binary Tree is Below.");
		bst.inOrderTraversal();
		System.out.println();
		System.out.println("Please enter sum value which you want to find pair");
		int sum = scanner.nextInt();
		boolean isFound = bst.findPairForGivenSum(sum);
		if (!isFound) {
			System.out.println("For Given Sum "+sum+" nodes are not found.");
		}
	}
}

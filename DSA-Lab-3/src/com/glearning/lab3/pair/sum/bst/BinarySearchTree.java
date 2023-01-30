package com.glearning.lab3.pair.sum.bst;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is an implementation of Binary Search Tree(BST).
 * It provides insert node, in order traversal and a special function to 
 * find first pair of a given Sum.
 * 
 * @author Dipanjan Das.
 * @since 30-Jan-2023
 * @version 1.0
 */
public class BinarySearchTree {
	private Node root;

	/**
	 * This method is responsible to create Node object with new key value.
	 * 
	 * @param data Value
	 * @return Object of Node.
	 */
	public Node getNewNode(int data) {
		Node temp = new Node();
		temp.key = data;
		temp.left = null;
		temp.right = null;
		return temp;
	}

	/**
	 * This is the implementation of insert method in Binary Search Tree.
	 * 
	 * @param key Integer value.
	 * @return Object of Node which is current Parent.
	 */
	public Node insert(int key) {
		Node newNode = this.getNewNode(key);
		Node current_parent = null;
		if (this.root == null) {
			this.root = newNode;
			current_parent = this.root;
		} else {
			Node tempNode = this.root;
			// Finding parent of newly created node.
			while (tempNode != null) {
				current_parent = tempNode;
				if (key < tempNode.key) {
					tempNode = tempNode.left;
				} else if (key > tempNode.key) {
					tempNode = tempNode.right;
				} else {
					System.out.println("Given Value Already Exists.");
					return newNode;
				}
			}
		}
		if (key < current_parent.key) {
			current_parent.left = newNode;
		}
		if (key > current_parent.key) {
			current_parent.right = newNode;
		}
		return current_parent;
	}

	/**
	 * This method is responsible to traverse binary search tree in order manner.
	 */
	public void inOrderTraversal() {
		if (this.root == null) {
			System.out.println("Binary Search Tree is empty.");
			return;
		} else {
			this.inOrderPrint(this.root);
		}
	}

	/**
	 * This method is responsible to traverse binary search tree in order manner
	 * from root.
	 * 
	 * @param root Any Node of tree.
	 */
	private void inOrderPrint(Node root) {
		if (root == null) {
			return;
		}
		this.inOrderPrint(root.left);
		System.out.print(root.key + " ");
		this.inOrderPrint(root.right);
	}
	
	/**
	 * This method is responsible to find first pair of nodes in tree for a given sum.
	 * 
	 * @param sum Any integer value whose pair will be found.
	 * @return true if pair is found otherwise false.
	 */
	public boolean findPairForGivenSum(int sum) {
		List<Integer> list = new ArrayList<>();
		return this.findPairInTree(root, sum, list);
	}
	
	/**
	 * This method is responsible to find pair with given sum in tree.
	 * 
	 * @param root Object of Node class which represents any node of the tree.
	 * @param sum Any integer number which either some of any two nodes in tree or not.
	 * @param list Object of {@link ArrayList}
	 * @return true if pair with given sum found otherwise false. 
	 */
	private boolean findPairInTree(Node root, int sum, List<Integer> list) {
		if (root == null) {
			return false;
		}
		if (findPairInTree(root.left, sum, list)) {
			return true;
		}
		if (list.contains(sum - root.key)) {
			System.out.println(
					"Pair found for given sum "+sum+" in Tree. Pair := "
					+ "("+(sum - root.key)+","+root.key+")");
			return true;
		} else {
			list.add(root.key);
		}
		return findPairInTree(root.right, sum, list);
	}
}

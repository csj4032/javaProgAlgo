/**
 *	Copyrihgt DaumService., Copyright(c) 2014 All rights reserved.
 *	
 *	@Project		:		javaProgAlgo
 *	@Package		:		Chap09
 *	@File			:		Node.java
 *	@Date			:		2014. 2. 17.
 *	@Author		:		daum
 *	@Version		:		1.0
 *	@Description	:		
 *
 *	@ModifyDate	:		
 *	@Amender		:		
 *	@Description	:		
 **/

package Chap09;

public class Node {

	Comparable data;
	Node left;
	Node right;

	public Node(Comparable aLabel) {
		left = null;
		right = null;
		data = aLabel;
	}
}

class BinarySearchTree {

	private Node root;

	public BinarySearchTree() {
		root = null;
	}

	public Node search(Comparable key) {
		Node p = root;
		while (p != null) {
			int result = key.compareTo(p.data);
			if(result == 0) {
				return p;
			} else if (result < 0) {
				p = p.left;
			} else {
				p = p.right;
			}
		}
		return null;
	}

	public Node insert(Comparable key) {
		Node p = root;
		Node parent = null;
		boolean isLeftChild = false;

		while (p != null) {

		}

		Node newNode = new Node(key);
		return newNode;
	}
}
/**
 *	Copyrihgt Genius., Copyright(c) 2014 All rights reserved.
 *	
 *	@Project		:		javaProgAlgo
 *	@Package		:		Chap06
 *	@File			:		BinaryTreeNode.java
 *	@Date			:		2014. 2. 15.
 *	@Author			:		Administrator
 *	@Version		:		1.0
 *	@Description	:		
 *
 *	@ModifyDate		:		
 *	@Amender		:		
 *	@Description	:		
 **/

package chap06;

public class BinaryTreeNode {

	String level;
	BinaryTreeNode left;
	BinaryTreeNode right;

	public BinaryTreeNode(String level, BinaryTreeNode left, BinaryTreeNode right) {
		this.level = level;
		this.left = left;
		this.right = right;
	}

	static void traversePreorder(BinaryTreeNode p) {
		if (p == null) {
			return;
		}
		System.out.println("노드 " + p.level + "을 방문하였다.");
		traversePreorder(p.left);
		traversePreorder(p.right);
	}

	static void traverseInorder(BinaryTreeNode p) {
		if (p == null) {
			return;
		}
		traverseInorder(p.left);
		System.out.println("노드 " + p.level + "을 방문하였다.");
		traverseInorder(p.right);
	}

	static void traversePostorder(BinaryTreeNode p) {
		if (p == null) {
			return;
		}
		traversePostorder(p.left);
		traversePostorder(p.right);
		System.out.println("노드 " + p.level + "을 방문하였다.");
	}

	public static void main(String args[]) {
		BinaryTreeNode tree = new BinaryTreeNode("a", new BinaryTreeNode("b", new BinaryTreeNode("c", null, null), null), new BinaryTreeNode("d", null, null));
		System.out.println("전위 순회");
		traversePreorder(tree);
		System.out.println("중위 순회");
		traverseInorder(tree);
		System.out.println("후위 순회");
		traversePostorder(tree);
	}
}
/**
 *	Copyrihgt DaumService., Copyright(c) 2014 All rights reserved.
 *	
 *	@Project		:		javaProgAlgo
 *	@Package		:		Chap10
 *	@File			:		BTree.java
 *	@Date			:		2014. 2. 20.
 *	@Author		:		daum
 *	@Version		:		1.0
 *	@Description	:		
 *
 *	@ModifyDate	:		
 *	@Amender		:		
 *	@Description	:		
 **/

package Chap10;

public class BTree {

	private abstract class Node {
		int serial;
	}

	private class InternalNode extends Node {
		int nChilds;
		Node[] child;
		Comparable[] low;

		private InternalNode() {
			serial = serialNumber++;
			nChilds = 0;
			child = new Node[MAX_CHILD];
			low = new Comparable[MAX_CHILD];
		}
	}

	private class Leaf extends Node {
		Comparable key;
		Object data;

		private Leaf(Comparable aKey, Object aData) {
			key = aKey;
			data = aData;
		}
	}

	private Node root;
	private int serialNumber = 0;
	private Leaf currentLeaf;
	final private static int MAX_CHILD = 5;
	final private static int OK = 1;
	final private static int OK_REMOVED = 2;
	final private static int OK_NEED_REORG = 3;
	final private static int NOT_FOUND = 4;
}
/**
 *	Copyrihgt Genius., Copyright(c) 2014 All rights reserved.
 *	
 *	@Project		:		javaProgAlgo
 *	@Package		:		Chap05
 *	@File			:		MyStack2.java
 *	@Date			:		2014. 2. 15.
 *	@Author			:		Administrator
 *	@Version		:		1.0
 *	@Description	:		
 *
 *	@ModifyDate		:		
 *	@Amender		:		
 *	@Description	:		
 **/

package chap05;

public class MyStack2 {

	MyDoublyLinkedList stack;
	int nElements;

	public MyStack2() {
		stack = new MyDoublyLinkedList();
		nElements = 0;
	}

	public void clear() {
		stack = new MyDoublyLinkedList();
		nElements = 0;
	}

	public void push(Object x) {
		stack.insertLast(x);
		nElements++;
	}

	public Object pop() {
		Object x = stack.removeLast();
		if (x == null) {
			System.err.println("stack overflow");
			System.exit(1);
		}
		nElements--;
		return x;
	}

	public boolean isEmpty() {
		return stack.isEmpty();
	}

	public String toString() {
		return "요소의 수 " + nElements + " " + stack.toString();
	}

	public static void main(String args[]) {
		MyStack2 stack = new MyStack2();
		stack.push("a");
		System.out.println(stack);
		stack.push("b");
		System.out.println(stack);
		stack.push("c");
		System.out.println(stack);

		while (!stack.isEmpty()) {
			System.out.println(stack.pop() + "를 꺼냈다.");
			System.out.println(stack);
		}
		System.out.println("비어있다 " + stack);
	}
}

/**
 *	Copyrihgt Genius., Copyright(c) 2014 All rights reserved.
 *	
 *	@Project		:		javaProgAlgo
 *	@Package		:		Chap04
 *	@File			:		MyStack.java
 *	@Date			:		2014. 2. 14.
 *	@Author			:		Administrator
 *	@Version		:		1.0
 *	@Description	:		
 *
 *	@ModifyDate		:		
 *	@Amender		:		
 *	@Description	:		
 **/

package chap04;

public class MyStack {

	Object[] stack;
	int stackSize;
	int sp;

	static int DEFAULT_STACK_SIZE = 100;

	public MyStack() {
		this(DEFAULT_STACK_SIZE);
	}

	public MyStack(int size) {
		stack = new Object[size];
		stackSize = size;
		sp = 0;
	}

	public void error(String s) {
		System.err.println(s);
		System.exit(1);
	}

	public void clear() {
		sp = 0;
	}

	public void push(Object x) {
		if (sp >= stackSize) {
			error("Stack Overflow");
		}
		stack[sp++] = x;
	}

	public Object pop() {
		if (sp <= 0) {
			error("Stack underflow");
		}
		return stack[--sp];
	}

	public boolean isEmpty() {
		return sp == 0;
	}

	public String toString() {
		String s;
		s = "MyStack = [";
		for (int i = 0; i < sp; i++) {
			s = s + stack[i];
			if (i < sp - 1) {
				s = s + ",";
			}
		}
		s = s + "]";
		return s;
	}

	public static void main(String[] args) {
		MyStack stack = new MyStack();
		stack.push("a");
		stack.push("b");
		System.out.println(stack);
		while (!stack.isEmpty()) {
			System.out.println("pop : " + stack.pop());
		}
		System.out.println("DONE! " + stack);
	}
}
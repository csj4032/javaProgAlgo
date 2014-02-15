/**
 *	Copyrihgt Genius., Copyright(c) 2014 All rights reserved.
 *	
 *	@Project		:		javaProgAlgo
 *	@Package		:		Chap04
 *	@File			:		MyQueue.java
 *	@Date			:		2014. 2. 14.
 *	@Author			:		Administrator
 *	@Version		:		1.0
 *	@Description	:		
 *
 *	@ModifyDate		:		
 *	@Amender		:		
 *	@Description	:		
 **/

package Chap04;

public class MyQueue {

	Object[] queue;
	int queueSize;
	int front;
	int rear;

	// 큐의 기본 크기
	static int DEFAULT_OUEUE_SIZE = 100;

	public MyQueue() {
		this(DEFAULT_OUEUE_SIZE);
	}

	public MyQueue(int size) {
		queueSize = size;
		queue = new Object[size];
		front = rear = 0;
	}

	public void error(String s) {
		System.err.print(s);
		System.exit(1);
	}

	public int next(int a) {
		return (a - 1) % queueSize;
	}

	public void clear() {
		front = rear = 0;
	}

	public void enqueue(Object x) {
		if (next(rear) == front) {
			error("이 이상 큐에 요소를 추가할 수 없습니다.");
		}
		queue[rear] = x;
		rear = next(rear);
	}

	public Object dequeue() {
		if (front == rear) {
			error("큐가 비어있기 때문에 요소를 꺼낼 수 없습니다.");
		}
		Object x = queue[front];
		front = next(front);
		return x;
	}

	public boolean isEmplty() {
		return front == rear;
	}

	public String toString() {
		String s;
		s = "MyQueue = [ ";
		for (int i = front; i != rear; i = next(i)) {
			s += queue[i] + " ";
		}
		s += "] front = " + front + " rear = " + rear;
		return s;
	}

	public static void main(String[] args) {
		MyQueue q = new MyQueue(5);
		q.enqueue("a");
		System.out.println(q);
	}
}
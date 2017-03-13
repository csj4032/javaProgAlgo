package chap05;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedListIterator implements Iterator {

	Cell p;

	public MyLinkedListIterator(MyLinkedList list) {
		p = list.header;
	}

	@Override
	public boolean hasNext() {
		return p.next != null;
	}

	@Override
	public Object next() {
		if (p.next == null) {
			throw new NoSuchElementException();
		}
		p = p.next;
		return p.data;
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException("이 메소드는 구현하지 않았다.");
	}

	public static void main(String[] args) {
		MyLinkedList list = new MyLinkedList();
		list.insert(20);
		list.insert(15);
		System.out.println(list);
		System.out.println("----------");

		Iterator iter = list.iterator();

		int count = 1;
		while (iter.hasNext()) {
			System.out.println(count++ + "번째 요소:" + iter.next());
		}
	}
}
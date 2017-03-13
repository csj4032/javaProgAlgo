package chap05;

public class MyDoublyLinkedList {

	CellDouble head;

	public MyDoublyLinkedList() {
		head = new CellDouble("List Head");
		head.prev = head.next = head;
	}

	private void insertAfter(CellDouble p, Object data) {
		CellDouble x = new CellDouble(data);
		x.prev = p;
		x.next = p.next;
		p.next.prev = x;
		p.next = x;
	}

	public void insertFirst(Object data) {
		insertAfter(head, data);
	}

	public void insertLast(Object data) {
		insertAfter(head.prev, data);
	}

	public void removeCell(CellDouble p) {
		p.prev.next = p.next;
		p.next.prev = p.prev;
	}

	public Object removeFirst() {
		if (isEmpty()) {
			return null;
		}
		CellDouble cell = head.next;
		removeCell(cell);
		return cell.data;
	}

	public Object removeLast() {
		if (isEmpty()) {
			return null;
		}
		CellDouble cell = head.prev;
		removeCell(cell);
		return cell.data;
	}

	public boolean isEmpty() {
		return head.next == head;
	}

	public String toString() {
		String s;
		s = "[ ";
		for (CellDouble p = head.next; p != head; p = p.next) {
			s += p.data + " ";
		}
		s += "]";
		return s;
	}

	public static void main(String args[]) {
		MyDoublyLinkedList list = new MyDoublyLinkedList();
		System.out.println("처음 상태(빈 리스트)");
		System.out.println(list);
		list.insertFirst("a");
		System.out.println("a를 처음에 삽입");
		System.out.println(list);
		list.insertLast("b");
		System.out.println("b를 마지막에 삽입");
		System.out.println(list);
		list.insertFirst("c");
		System.out.println("c를 처음에 삽입");
		System.out.println(list);

		System.out.println("-------------------");

		int i = 0;
		while (!list.isEmpty()) {
			if (i++ % 2 == 0) {
				System.out.println(list.removeFirst() + "을 제거(처음)");
			} else {
				System.out.println(list.removeLast() + "을 제거(마지막)");
			}
			System.out.println(list);
		}
	}
}
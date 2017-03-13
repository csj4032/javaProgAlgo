package chap02;

public class BinarySearch {

	final static int MAX = 9999999;
	Entry[] table = new Entry[MAX];
	int n = 0;

	public Object search(int key) {
		int low = 0, high, middle;
		high = n - 1;

		while (low <= high) {
			middle = (low + high) / 2;
			if (key == table[middle].key) {
				return table[middle].data;
			} else if (key < table[middle].key) {
				high = middle - 1;
			} else {
				low = middle + 1;
			}
		}
		return null;
	}

	public static void main(String[] args) {
		BinarySearch bs = new BinarySearch();
		bs.table[0] = new Entry(0, "Data0");
		bs.table[1] = new Entry(1, "Data1");
		bs.table[2] = new Entry(2, "Data2");
		bs.n = 3;
		System.out.println(bs.search(2));
	}
}

class Entry {
	int key;
	Object data;

	public Entry(int key, Object data) {
		this.key = key;
		this.data = data;
	}
}
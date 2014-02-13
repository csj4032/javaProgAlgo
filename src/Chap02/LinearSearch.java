package Chap02;

public class LinearSearch {
	
	class Entry {
		int 	key;
		Object	data;
		
		public Entry (int key, Object data) {
			this.key = key;
			this.data = data;
		}
	}
	
	final static int MAX = 100;
	Entry[] table = new Entry[MAX];
	int n = 0;
	
	public void add(int key, Object data) {
		if(n >= MAX) {
			System.out.println("AAAA");
			System.exit(1);
		}
		table[n++] = new Entry(key, data);
	}
	
	public Object search(int key) {
		int i;
		i = 0;
		while (i < n) {
			if(table[i].key == key) {
				return (table[i].data);
			}
			i++;
		}
		return null;
	}
}
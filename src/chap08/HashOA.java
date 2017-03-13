/**
 *	Copyrihgt Genius., Copyright(c) 2014 All rights reserved.
 *	
 *	@Project		:		javaProgAlgo
 *	@Package		:		Chap08
 *	@File			:		HashOA.java
 *	@Date			:		2014. 2. 16.
 *	@Author			:		Administrator
 *	@Version		:		1.0
 *	@Description	:		
 *
 *	@ModifyDate		:		
 *	@Amender		:		
 *	@Description	:		
 **/

package chap08;

public class HashOA {

	private class Bucket {
		MyKey key;
		Object data;

		public Bucket(MyKey k, Object d) {
			key = k;
			data = d;
		}
	}

	Bucket[] table;
	int bucketSize;
	int nElements;

	static final MyKey DELETED = new MyKey(null);
	static final MyKey EMPTY = new MyKey(null);
	static final int DEFAULT_BUCKET_SIZE = 1000;

	public HashOA() {
		this(DEFAULT_BUCKET_SIZE);
	}

	public HashOA(int bucketSize) {
		table = new Bucket[bucketSize];
		for (int i = 0; i < bucketSize; i++) {
			table[i] = new Bucket(EMPTY, null);
		}
		this.bucketSize = bucketSize;
		nElements = 0;
	}

	private int hash(MyKey key) {
		return key.hashCode() % bucketSize;
	}

	private int rehash(int h) {
		return (h + 1) % bucketSize;
	}

	public Object find(MyKey key) {
		int count = 0;
		int h = hash(key);
		MyKey k;
		while ((k = table[h].key) != EMPTY) {
			if (k != DELETED && key.equals(k)) {
				return table[h].data;
			}
			if (++count > bucketSize) {
				return null;
			}
			h = rehash(h);
		}
		return null;
	}

	public boolean insert(MyKey key, Object data) {
		int count = 0;
		int h = hash(key);
		MyKey k;
		while ((k = table[h].key) != EMPTY && k != DELETED) {
			if (key.equals(k)) {
				return false;
			}
			if (++count > bucketSize) {
				System.err.println("더 이상 해시 표에 데이터를 등록할 수 없습니다.");
				System.exit(1);
			}
			h = rehash(h);
		}
		table[h].key = key;
		table[h].data = data;
		nElements++;
		return true;
	}

	public boolean delete(MyKey key) {
		int count = 0;
		int h = hash(key);
		MyKey k;
		while ((k = table[h].key) != EMPTY) {
			if (k != DELETED && key.equals(k)) {
				table[h].key = DELETED;
				table[h].data = null;
				nElements--;
				return true;
			}
			if (++count > bucketSize) {
				return false;
			}
			h = rehash(h);
		}
		return false;
	}

	public String toString() {
		String s = "";
		for (int i = 0; i < table.length; i++) {
			s += "버킷" + i + ": ";
			MyKey k = table[i].key;
			if (k == EMPTY) {
				s += "비어있음\n";
			} else if (k == DELETED) {
				s += "삭제 되었음\n";
			} else {
				s += "key=[" + k + "] data = [" + table[i].data + "]\n";
			}
		}
		s += "요소의 개수 : " + nElements + "\n";
		return s;
	}

	public static void main(String[] args) {
		String[] words = { "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven" };
		HashOA hash = new HashOA(15);
		System.out.println("---<<1 단계>>---[등록]--------");
		for (int i = 0; i < words.length; i++) {
			boolean stat = hash.insert(new MyKey(words[i]), "순서 = " + (i + 1));
			if (stat == false) {
				System.out.println(words[i] + "의 등록에 실패하였다.(증복됨");
			}
		}
		System.out.print(hash);
		System.out.println("---<<2 단계>>---[탐색]--------");
		String[] keys = { "one", "two", "three", "four" };
		for (int i = 0; i < keys.length; i++) {
			Object result = hash.find(new MyKey(words[i]));
			if (result != null) {
				System.out.println("키[" + keys[i] + "]의 값은 [" + result + "]이다");
			} else {
				System.out.println("키[" + keys[i] + "]을 발견하지 못하였다.");
			}
		}
		System.out.println("---<<3 단계>>---[삭제]--------");
		for (int i = 0; i < keys.length; i++) {
			if (hash.delete(new MyKey(keys[i]))) {
				System.out.println("키[" + keys[i] + "]을 삭제하였다.");
			} else {
				System.out.println("키[" + keys[i] + "]의 삭제에 실패하였다.(등록되어있지 않음)");
			}
		}
		System.out.println("---<<4 단계>>---[탐색 : 모두 실패한다.]--------");
		for (int i = 0; i < keys.length; i++) {
			Object result = hash.find(new MyKey(words[i]));
			if (result != null) {
				System.out.println("키[" + keys[i] + "]의 값은 [" + result + "]이다");
			} else {
				System.out.println("키[" + keys[i] + "]을 발견하지 못하였다.");
			}
		}
		System.out.println("------------<<5단계>>--------------");
		System.out.println(hash);
	}
}
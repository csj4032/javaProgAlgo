/**
 *	Copyrihgt Genius., Copyright(c) 2014 All rights reserved.
 *	
 *	@Project		:		javaProgAlgo
 *	@Package		:		Chap08
 *	@File			:		HashC.java
 *	@Date			:		2014. 2. 15.
 *	@Author			:		Administrator
 *	@Version		:		1.0
 *	@Description	:		
 *
 *	@ModifyDate		:		
 *	@Amender		:		
 *	@Description	:		
 **/

package Chap08;

public class HashC {

	private class Cell {
		MyKey key;
		Object data;
		Cell next;

		private Cell(MyKey aKey, Object aData) {
			key = aKey;
			data = aData;
		}
	}

	Cell[] table;
	int bucketSize;
	int nElements;

	static final int DEFAULT_BUCKET_SIZE = 50;

	public HashC() {
		this(DEFAULT_BUCKET_SIZE);
	}

	public HashC(int bucketSzie) {
		table = new Cell[bucketSzie];
		this.bucketSize = bucketSzie;
		nElements = 0;
	}

	private int hash(MyKey key) {
		return key.hashCode() % bucketSize;
	}

	public Object find(MyKey key) {
		for (Cell p = table[hash(key)]; p != null; p = p.next) {
			if (key.equals(p.key)) {
				return p.data;
			}
		}
		return null;
	}

	public boolean insert(MyKey key, Object data) {
		if (find(key) != null) {
			return false;
		}
		Cell p = new Cell(key, data);
		int h = hash(key);
		p.next = table[h];
		table[h] = p;
		nElements++;
		return true;
	}

	public boolean delete(MyKey key) {
		int h = hash(key);
		if (table[h] == null) {
			return false;
		}
		if (key.equals(table[h].key)) {
			Cell p = table[h];
			table[h] = p.next;
			nElements--;
			return true;
		}
		Cell p;
		Cell q;
		for (q = table[h], p = q.next; p != null; q = p, p = p.next) {
			if (key.equals(p.key)) {
				q.next = p.next;
				nElements--;
				return true;
			}
		}
		return false;
	}

	public String toString() {
		String s = "";
		for (int i = 0; i < table.length; i++) {
			s += "버킷" + i + "";
			for (Cell p = table[i]; p != null; p = p.next) {
				s += "[" + p.key + ":" + p.data + "]";
			}
			s += "\n";
		}
		s += "요소의 개수:" + nElements + "\n";
		return s;
	}

	public static void main(String args[]) {
		String[] words = { "one" ,"two", "three","four","five","six","seven","eight","nine","ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","ninetenn","twenty"};
		HashC hash = new HashC(15);
		System.out.println("----<<1 단계>>---[등록]-----------");
		for (int i = 0; i < words.length; i++) {
			boolean stat = hash.insert(new MyKey(words[i]), "순서="+(i+1));
			if(stat == false) {
				System.out.println("의 등록이 실패하였습니다.(중복됨)");
			}
		}
		System.out.println(hash);
		System.out.println("----<<2 단계>>---[탐색]-----------");
		String[] keys = {"ten","thirteen"};
		for (int i = 0; i < keys.length; i++) {
			Object result = hash.find(new MyKey(keys[i]));
			if(result != null) {
				System.out.println("키 [" + keys[i] + "]의 값은 [" + result + "]이다.");
			} else{
				System.out.println("키 [" + keys[i] + "]을 발견하지 못하였다.");
			}
		}
		System.out.println("----<<3 단계>>---[삭제]-----------");
		for (int i = 0; i < keys.length; i++) {
			if(hash.delete(new MyKey(keys[i]))) {
				System.out.println("키 [" + keys[i] + "]을 삭제하였다.");
			} else{
				System.out.println("키 [" + keys[i] + "]의 삭제에 실패하였다. (등록되어있지 않음)");
			}
		}
		System.out.println("----<<4 단계>>---[탐색:모두 실패한다]-----------");
		for (int i = 0; i < keys.length; i++) {
			Object result = hash.find(new MyKey(keys[i]));
			if(result != null) {
				System.out.println("키 [" + keys[i] + "]의 값은 [" + result + "]이다.");
			} else{
				System.out.println("키 [" + keys[i] + "]을 발견하지 못하였다.");
			}
		}
		System.out.println("----<<5 단계>>----------------");
		System.out.println(hash);
	}
}
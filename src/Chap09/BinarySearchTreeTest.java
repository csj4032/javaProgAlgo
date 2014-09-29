package Chap09;

/**
 * Created by Administrator on 2014-09-26.
 */
public class BinarySearchTreeTest {

	public static void main(String[] args) {
		BinarySearchTree bs = new BinarySearchTree();
		bs.insert(5);
		bs.insert(4);
		bs.insert(100);
		bs.insert(40);
		//bs.showAll();

		byte[] bt = "ab".getBytes();
		System.out.println(bt.length);
		System.out.println(bt[0]);
		System.out.println(bt[1]);
		System.out.println((int) bt[0] & 0xFF);
	}
}

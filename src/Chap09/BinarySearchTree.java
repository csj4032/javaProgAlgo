package Chap09;

/**
 * Created by Administrator on 2014-09-26.
 */
public class BinarySearchTree {

	private Node root;

	public BinarySearchTree() {
		root = null;
	}

	public Node search(Comparable key) {
		Node p = root;
		while (p != null) {
			int result = key.compareTo(p.data);
			if (result == 0) {
				return p;
			} else if (result < 0) {
				p = p.left;
			} else {
				p = p.right;
			}
		}
		return null;
	}

	public Node insert(Comparable key) {
		Node p = root;
		Node parent = null;
		boolean isLeftChild = false;

		while (p != null) {
			int result = key.compareTo(p.data);
			if (result == 0) {
				return p;
			} else if (result < 0) {
				parent = p;
				isLeftChild = true;
				p = p.left;
			} else {
				parent = p;
				isLeftChild = false;
				p = p.right;
			}
		}

		Node newNode = new Node(key);
		if (parent == null) {
			root = newNode;
		} else if (isLeftChild) {
			parent.left = newNode;
		} else {
			parent.right = newNode;
		}
		return newNode;
	}

	public boolean delete(Comparable key) {
		return false;
	}

	private void inorder(Node p) {
		if (p == null) {
			return;
		} else {
			inorder(p.left);
			System.out.println(p.data);
			inorder(p.right);
		}
	}

	public void showAll() {
		inorder(root);
	}
}
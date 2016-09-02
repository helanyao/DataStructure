package BinaryTree;

public class BNode {
	private int value;
	private BNode left;
	private BNode right;
	
	public BNode() {
		value = -1;
		left = right = null;
	}
	
	public BNode(int v) {
		value = v;
		left = right = null;
	}
	
	public String toString() {
		return String.valueOf(value);
	}
	
	public void setVal(int v) {
		value = v;
	}
	
	public int getVal() {
		return value;
	}
	
	public void setLeft(BNode n) {
		left = n;
	}
	
	public BNode getLeft() {
		return left;
	}
	
	public void setRight(BNode n) {
		right = n;
	}
	
	public BNode getRight() {
		return right;
	}
	
	public boolean isLeaf() {
		if(left != null || right != null) {
			return false;
		} else {
			return true;
		}
	}
	
	public boolean hasLeft() {
		if(left == null) {
			return false;
		} else {
			return true;
		}
	}
	
	public boolean hasRight() {
		if(right == null) {
			return false;
		} else {
			return true;
		}
	}
}

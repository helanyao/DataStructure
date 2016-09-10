package BinarySearchingTree;


public class BSNode {
	private int value;
	private BSNode left;
	private BSNode right;
	
	public BSNode() {
		value = -1;
		left = right = null;
	}
	
	public BSNode(int v) {
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
	
	public void setLeft(BSNode n) {
		left = n;
	}
	
	public BSNode getLeft() {
		return left;
	}
	
	public void setRight(BSNode n) {
		right = n;
	}
	
	public BSNode getRight() {
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


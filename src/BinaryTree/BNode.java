package BinaryTree;

public class BNode {
	public int val;
	public BNode left;
	public BNode right;
	public BNode parent;
	
	public BNode() {
		val = -1;
		left = right = null;
	}
	
	public BNode(int v) {
		val = v;
		left = right = null;
	}
	
	public String toString() {
		return String.valueOf(val);
	}
	
	public void setVal(int v) {
		val = v;
	}
	
	public int getVal() {
		return val;
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
	
	public void setParent(BNode n) {
		parent = n;
	}
	
	public BNode getParent() {
		return parent;
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

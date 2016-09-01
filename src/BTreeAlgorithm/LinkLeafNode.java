package BTreeAlgorithm;

import java.util.Stack;
import BinaryTree.BNode;
import BinaryTree.BTree;

// Link all leaf nodes from left to right 
// by using their right child.
public class LinkLeafNode {
	public static void main(String[] args) {
		String[] init = new String[]{"1", "[", "2", "[", "4", ",", "5", "]", ",", "3", "[", "6", ",", "]", "]"};	
		BTree bt = new BTree(init);
		// BNode n = linkNode(null);
		BNode n = linkNode(bt.getRoot());
		printLink(n);
	}
	
	public static BNode linkNode(BNode root) {
		Stack<BNode> st = new Stack<BNode>();
		BNode start = null, cur = null, n = root;
		
		while(n != null || !st.isEmpty()) {
			while(n != null) {
				if(n.isLeaf()) {
					if(start == null) {
						start = n;
					} else {
						cur.setRight(n);
					}
					cur = n;
				}
				if(n.getRight() != null) {
					st.push(n.getRight());
				}
				n = n.getLeft();
			}// inner while
			
			if(!st.isEmpty()) {
				n = st.pop();
			}
		} // while
		
		return start;
	}
	
	public static void printLink(BNode start) {
		while(start != null) {
			System.out.println(start.getVal());
			start = start.getRight();
		}
	}
}

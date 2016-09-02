package BTreeAlgorithm;

import java.util.Stack;

import BinaryTree.BNode;
import BinaryTree.BTree;

public class TopView {

	public static void main(String[] args) {
		String[] init1 = new String[]{"1", "[", "2", "[", "4", ",", "5", "]", ",", "3", "[", "6", ",", "]", "]"};	
		BTree bt1 = new BTree(init1);
		String[] init2 = new String[]{"1"};
		BTree bt2 = new BTree(init2);
		String[] init3 = new String[]{"1", "[", ",", "3", "[", "6", ",", "]", "]"};
		BTree bt3 = new BTree(init3);
		printTopView(bt1.getRoot());
		printTopView(null);
		printTopView(bt2.getRoot());
		printTopView(bt3.getRoot());
	}
	
	public static void printTopView(BNode root) {
		if(root == null) {
			System.out.println("printTopView: empty tree.");
			return;
		}
		
		Stack<BNode> st = new Stack<BNode>();
		BNode n = root.getLeft();
		
		// left
		while(n != null) {
			st.push(n);
			n = n.getLeft();
		}
		
		while(!st.isEmpty()) {
			System.out.print(st.pop().getVal() + " ");
		}
		
		System.out.print(root.getVal() + " ");
		
		// right
		n = root.getRight();
		while(n != null) {
			System.out.print(n.getVal() + " ");
			n = n.getRight();
		}
	}

}

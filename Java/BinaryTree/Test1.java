package BinaryTree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Test1 {

	public static void main(String[] args) {
		String[] init = new String[]{"1", "[", "2", "[", "4", ",", "5", "]", ",", "3", "[", "6", ",", "]", "]"};	
		BTree bt = new BTree(init);
		BTreeTraversal tra = new BTreeTraversal();
		tra.LevelOrderN(bt.getRoot());
		System.out.println();
		tra.LevelOrder(bt.getRoot());
	}

}


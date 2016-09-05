package BinaryTree;

public class Test1 {

	public static void main(String[] args) {
		String[] init = new String[]{"1", "[", "2", "[", "4", ",", "5", "]", ",", "3", "[", "6", ",", "]", "]"};
		
		BTree bt = new BTree(init);
		
		//BTreeTraversal tra = new BTreeTraversal();
		//tra.LevelOrderN(bt.getRoot());
		BTreeHelper helper = new BTreeHelper();
		System.out.println("\n" + helper.getHeight(bt.getRoot()));
	}
}

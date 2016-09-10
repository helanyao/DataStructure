package BinarySearchingTree;

public class BSTreeHelper {
	public static void main(String[] args) {
		int[] a = new int[]{10, 6, 1, 4, 8, 7, 9, 15, 12, 20, 18};
		BSTree bt = new BSTree();
		init(bt, a);
		System.out.println("1");
		remove(bt.getRoot(), null, 6);
		System.out.println("end");
	}
	
	// Time Complexity: avg-O(log2n), worst-O(n) when it is linked list
	// Space Complexity: avg-O(log2n), worst-O(n)
	public static boolean search(BSNode root, int val) {
		if(root == null) {
			return false;
		}
		
		if(root.getVal() == val) {
			return true;
		} else if(root.getVal() > val) {
			return search(root.getLeft(), val);
		} else {
			return search(root.getRight(), val);
		}
	}
	
	public static boolean searchN(BSNode root, int val) {
		if(root == null) {
			return false;
		}
		
		BSNode n = root;
		while(n != null) {
			if(n.getVal() == val) {
				return true;
			} else if(n.getVal() > val) {
				n = n.getLeft();
			} else {
				n = n.getRight();
			}
		}
		
		return false;
	}
	
	public static void insert(BSNode root, int val) {
		if(root == null) {
			BSNode n = new BSNode(val);
			root = n;
		} else if(root.getVal() > val) {
			insert(root.getLeft(), val);
		} else {
			insert(root.getRight(), val);
		}
	}
	
	public static void insertN(BSTree t, int val) {
		BSNode parent = null, n = t.getRoot();
		while(n!= null) {
			parent = n;
			if(n.getVal() > val) {
				n = n.getLeft();
			} else {
				n = n.getRight();
			}
		}
		BSNode p = new BSNode(val);
		
		// interesting
		if(parent == null) {
			t.setRoot(p);;
		} else if(parent.getVal() > val) {
			parent.setLeft(p);
		} else {
			parent.setRight(p);
		}
	}
	
	public static void init(BSTree t, int[] a) {
		if(t.getRoot() != null && (t.getRoot().hasLeft() || t.getRoot().hasRight())) {
			throw new IllegalArgumentException();
		}
		if(a != null) {
			for(int i = 0; i < a.length; i++) {
				insertN(t, a[i]);
			}
		}
	}
	
	public static boolean remove(BSNode root, BSNode parent, int v) {
		if(root == null) {
			System.out.println("can't find node with value " + v);
			return false;
		}
		if(root.getVal() < v) {
			return remove(root.getRight(), root, v);
		} else if(root.getVal() > v) {
			return remove(root.getLeft(), root, v);
		}
		
		// first & second case: leaf node or only has one child
		if(!root.hasLeft()) {
			if(parent != null) {
				if(parent.getVal() < root.getVal()) {
					parent.setRight(root.getRight());
				} else {
					parent.setLeft(root.getRight());
				}
				root.setRight(null);
			} else {
				// To-do: remove root node
				// will add in future
			}
			return true;
		} else if(!root.hasRight()) {
			if(parent != null) {
				if(parent.getVal() < root.getVal()) {
					parent.setRight(root.getLeft());
				} else {
					parent.setLeft(root.getLeft());
				} 
				root.setLeft(null);
			} else {
				// To-do: remove root node
				// will add in future
			}
			return true;
		}
		
		// third case
		BSNode n = root, p = root.getLeft();
		while(p.hasRight()) {
			n = p;
			p = p.getRight();
		}
		root.setVal(p.getVal());
		return remove(p, n, p.getVal());	
	}

}

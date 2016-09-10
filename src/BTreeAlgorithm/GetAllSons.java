package BTreeAlgorithm;

import BinaryTree.BNode;

// Given such tree
//	   Father
//     /
// Mother
//     \
//     Son1
//    /    \
//   ...  Son2
//
// Print all sons for specific Father

public class GetAllSons {
	public static void main(String[] args) {
	}
	
	public static void getAllSons(BNode root, int father) {
		if(root != null) {
			if(root.getVal() == father) {
				BNode p = root.getLeft();
				if(p == null) {
					System.out.println("No mother info.");
				} else {
					p = p.getLeft();
					while(p != null) {
						System.out.println("Son: " + p.getVal());
						p = p.getRight();
					}
				}
			} else {
				getAllSons(root.getLeft(), father);
				getAllSons(root.getRight(), father);
			}
		}
	}

}

package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BTreeHelper {
	
	int getBTreeDepth(BNode root) {
		if(root == null) {
			return 0;
		} else {
			int dep1 = getBTreeDepth(root.getLeft());
			int dep2 = getBTreeDepth(root.getRight());
			if(dep1 > dep2) {
				return dep1 + 1;
			} else {
				return dep2 + 1;
			}
		}
	}
	
	//for node n, get its level
	int getNodeLevel(BNode root, int n) {
		if( root == null ) {
			return 0;
		} else if ( root.getVal() == n) {
			return 1;
		} else {
			int c1 = getNodeLevel(root.getLeft(), n);
			if( c1 >= 1 ) {
				return c1 + 1;
			}
			
			int c2 = getNodeLevel(root.getRight(), n);
			if( c2 >= 1) {
				return c2 + 1;
			} else { // important
				return 0;
			}
		}		
	}
	
	int getMaxVal(BNode root) {
		if(root == null) {
			throw new IllegalArgumentException();
		}
		int max = root.getVal();
		if(root.getLeft() != null) {
			max = Math.max(max, getMaxVal(root.getLeft()));
		}
		if(root.getRight() != null) {
			max = Math.max(max, getMaxVal(root.getRight()));
		}
		
		return max;
	}
	
	int getMinVal(BNode root) {
		if(root == null) {
			throw new IllegalArgumentException();
		}
		int min = root.getVal();
		if(root.getLeft() != null) {
			min = Math.min(min, getMaxVal(root.getLeft()));
		}
		if(root.getRight() != null) {
			min = Math.min(min, getMaxVal(root.getRight()));
		}
		
		return min;
	}
	
	// get the number of nodes
	int getNodeNum(BNode root) {
		if( root == null ) {
			return 0;
		} else {
			return 1 + getNodeNum(root.getLeft()) + getNodeNum(root.getRight());
		}
	}
	
	// get the number of leaf nodes
	int getLeafNum(BNode root) {
		if(root == null) {
			return 0;
		} else if (root.isLeaf()){
			return 1;
		} else {
			return getLeafNum(root.getLeft()) + getLeafNum(root.getRight());
		}
	}
	
	// find node with value n in pre-order
	BNode findNode(BNode root, int n) {
		if(root == null) {
			return null;
		} else if(root.getVal() == n) {
			return root;
		} else {
			BNode p = findNode(root.getLeft(), n);
			if( p != null) {
				return p;
			} else {
				return findNode(root.getRight(), n);
			}
		}
	}
	
	public int getWidth(BNode root) {
		if(root == null) {
			return 0;
		}
		
		class WNode {
			public BNode node;
			public int level;
			
			public WNode(BNode n, int l) {
				node = n;
				level = l;
			}
		}
		
		Queue<WNode> qu = new LinkedList<WNode>();
		
		qu.add(new WNode(root, 1));
		int maxCount = 0, curLevel = 1, count = 0;
		WNode p = null;
		
		while(!qu.isEmpty()) {
			p = qu.poll();
			if(p.level != curLevel) {
				curLevel = p.level;
				if(count > maxCount) {
					maxCount = count;
				}
				count = 1;
			} else {
				count++;
			}
			
			if(p.node.getLeft() != null) {
				qu.add(new WNode(p.node.getLeft(), p.level + 1));
			}
			if(p.node.getRight() != null) {
				qu.add(new WNode(p.node.getRight(), p.level + 1));
			}
		}
		
		// important while if the most width level is the leaf node level
		if(count > maxCount) {
			maxCount = count;
		}
		return maxCount;
	}
}



















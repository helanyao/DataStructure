package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BTreeHelper {
	// The height of a binary tree is the number of edges 
	// between root and its furthest leaf. 
	// A null tree has a deepth of 0.
	public int getDeepth(BNode root) {
		if(root == null) {
			return 0;
		} else {
			return 1 + Math.max( getHeight(root.getLeft()), getHeight(root.getRight()) );
		}
	}
	
	// A tree containing a single node has a height of 0.
	public int getHeight(BNode root) {
		if (root == null){
	        return -1;
	    }
	    else{
	        return 1 + Math.max( getHeight(root.getLeft()), getHeight(root.getRight()) );
	    }
	}
	public int getHeightN(BNode root) {
		int height = 0;
		BNode n = root;
		Stack<BNode> st = new Stack<BNode>();
		
		while(n != null || !st.isEmpty()) {
			while(n != null) {
				st.push(n);
				if(n.hasLeft()) {
					n = n.getLeft();
				} else {
					n = n.getRight();
				}
			} // inner while
			
			n = st.pop();
			
			if(height < st.size()) {
				height = st.size();
			}
			
			while(!st.isEmpty() && st.peek().getRight() == n) {
				n = st.pop();
			}
			
			if(!st.empty()) {
				n = st.peek().getRight();
			} else {
				n = null;
			}
		} // out while
		
		return height;
	}
	
	public int minDepth(BNode root) {
        // Corner case. Should never be hit unless the code is
        // called on root = NULL
        if (root == null)
            return 0;

        // Base case : Leaf Node. This accounts for height = 1.
        if (root.left == null && root.right == null)
            return 1;

        // If left subtree is NULL, recur for right subtree
        if (root.left == null)
            return minDepth(root.right) + 1;

        // If right subtree is NULL, recur for right subtree
        if (root.right == null)
            return minDepth(root.left) + 1;

        return Math.min(minDepth(root.left),
                        minDepth(root.right)) + 1;
    }
	
	public int minDepthN(BNode root) {
        int height = -1;
        if(root == null) {
            return 0;
        }
        BNode n = root;
		Stack<BNode> st = new Stack<BNode>();
		
		while(n != null || !st.isEmpty()) {
			while(n != null) {
				st.push(n);
				if(n.left != null) {
					n = n.left;
				} else {
					n = n.right;
				}
			} // inner while
			
			n = st.pop();
			if(n.left == null && n.right == null) {
			    if(height == -1 || height > st.size()) {
			        height = 1 + st.size();
			    } 
			}
			
			
			while(!st.isEmpty() && st.peek().right == n) {
				n = st.pop();
			}
			
			if(!st.empty()) {
				n = st.peek().right;
			} else {
				n = null;
			}
		} // out while
		
		return height;
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
	
	public void initParent(BNode root, BNode parent) {
		if(root != null) {
			root.setParent(parent);
			initParent(root.getLeft(), root);
			initParent(root.getRight(), root);
		}
	}	
	
}



















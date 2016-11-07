package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// used for visiting all nodes of Binary Tree in specific order.
public class BTreeTraversal {
	public void PreOrderN(BNode root) {
		Stack<BNode> s = new Stack<BNode>();
		BNode p = root;
		while(!s.isEmpty() || p != null) {
			while(p != null) {
				System.out.print(p.getVal());
				if(p.getRight() != null) {
					s.push(p.getRight());
				}//if
				p = p.getLeft();
			}//while
			if(!s.isEmpty()) {
				p = s.pop();
			}
		}
	}
	
	public void PreOrder(BNode root) {
		if(root != null) {
			System.out.print(root.getVal());
			PreOrder(root.getLeft());
			PreOrder(root.getRight());
		}
	}
	
	public void InOrderN(BNode root) {
		Stack<BNode> s = new Stack<BNode>();
		BNode p = root;
		
		while(!s.isEmpty() || p != null) {
			while(p != null) {
				s.push(p);
				p = p.getLeft();
			}
			if(!s.isEmpty()) {
				p = s.pop();
				System.out.print(p.getVal());
				p = p.getRight();
			}
		}
	}
	
	public void InOrder(BNode root) {
		if(root != null) {
			InOrder(root.getLeft());
			System.out.print(root.getVal());
			InOrder(root.getRight());
		}
	}
	
	public void PostOrderN(BNode root) {
		Stack<BNode> s = new Stack<BNode>();
		BNode p = root;
		
		while(!s.isEmpty() || p != null) {
			while(p != null) {
				s.push(p);
				if(p.getLeft() != null) {
					p = p.getLeft();
				}else {
					p = p.getRight();
				}//if
			}//while
			
			p = s.pop();
			System.out.print(p.getVal());
			
			//the condition of WHILE is important, while there is only one node
			while(!s.isEmpty() && s.peek().getRight() == p) {
				p = s.pop();
				System.out.print(p.getVal());
			}
			
			//the condition of IF is important, while there is only one node
			if(!s.isEmpty()) {
				p = s.peek().getRight();
			}else{
				p = null;
			}
		}
	}
	
	public void PostOrder(BNode root) {
		if(root != null) {
			PostOrder(root.getLeft());
			PostOrder(root.getRight());
			System.out.println(root.getVal());
		}
	}
	
	public void LevelOrderN(BNode root) {
		Queue<BNode> q = new LinkedList<BNode>();
		BNode p = null;
		
		// need firstly check null
		// When using a capacity-restricted queue,
		// this method is preferable to add(),
		// which can fail to insert an element only by throwing an exception.
		if(root != null) {
			q.offer(root);
		}
		
		while(!q.isEmpty()) {
			// remove() will throw an exception when it is empty
			p = q.poll();
			System.out.print(p.getVal() + " ");
			if(p.getLeft() != null) {
				q.offer(p.getLeft());
			}
			if(p.getRight() != null) {
				q.offer(p.getRight());
			}
		}
	}
	
    /**
     *  Implement lever traversal in recurse way.
     *  http://discuss.leetcode.com/questions/49/binary-tree-level-order-traversal#answer-container-2543 
     */  
    public static void LevelOrder(BNode root) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        levelTraversalVisit(root, 1, ret);
        System.out.println(ret);
    }

    private static void levelTraversalVisit(BNode root, int level, ArrayList<ArrayList<Integer>> ret) {
        if (root == null) {
            return;
        }
        
        // If there is not enough space for new level 
        // (which means the size of ArrayList is not enough),
        // it will add new one.
        // For example, when size = 3, level: 0, 1, 2
        if (level > ret.size()) {
            ret.add(new ArrayList<Integer>());
        }
        // visit current node
        ret.get(level - 1).add(root.val);

        levelTraversalVisit(root.left, level + 1, ret);
        levelTraversalVisit(root.right, level + 1, ret);
    }
}

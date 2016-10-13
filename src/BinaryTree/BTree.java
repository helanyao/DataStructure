package BinaryTree;

import java.util.Stack;

// used to init BTree
public class BTree {
	private BNode root;
	private int deep = -2;
	
	public BTree(){
		root = null;
	}
	
	public BTree(String[] init) {
		try {
			root = buildBTree(init);
		} catch (Exception e) {
			root = null;
			System.out.println("failed to construct BTree: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void setRoot(BNode n) {
		root = n;
	}
	
	public BNode getRoot() {
		return root;
	}
	
	public void setDeep(int d) {
		deep = d;
	}
	
	public int getDeep() {
		return deep;
	}
	
	private BNode buildBTree(String[] strArr) throws Exception {
		if(strArr == null || strArr.length == 0) {
			System.out.println("input data is empty. will not init a tree!");
			return null;
		}
		
		Stack<BNode> st = new Stack<BNode>();
		boolean right = false;
		BNode root = null, tmpNode = null;
		for(int i = 0; i < strArr.length; i++) {
			String s = strArr[i];
			
			if(s.equals("[")) {
				//here to push node
				st.push(tmpNode);
				//System.out.println("start to parse the subtree of " + tmpNode.getVal());
				continue;
			}
			
			if(s.equals("]")) {
				if(st.isEmpty()) {
					throw new Exception("failed to parse \"]\". the init data is note correct!");		
				}else{
					//here to pop node
					int k = st.pop().getVal();
					//System.out.println("finish initing the subtree of " + k);
					continue;
				}
			}
			
			if(s.equals(",")) {
				if(st.isEmpty()) {
					throw new Exception("failed to parse \",\". the init data is note correct!");
				}else{
					//System.out.println("right child of " + st.peek().getVal());
					right = true;
					continue;
				}
			}
			
			int data = Integer.valueOf(s);
			BNode n = new BNode(data);
			tmpNode = n;
			
			if(root == null) {
				root = n;
				//System.out.println("finish initing root node");
				continue;
			}
			
			BNode parent = null;
			if(!st.isEmpty()) {
				parent = st.peek();
			} else {
				throw new Exception("failed to set parent node. input data is not correct.");
			}			
			if(right) {
				parent.setRight(n);
				right = false;
			} else {
				parent.setLeft(n);
			}
		}//for
		
		if(st.size() != 0) {
			throw new Exception("failed to init tree. input data is not correct.");
		} else {
			return root;
		}
	}
	
	BNode buildBTreePreIn(String[] pre, int preSta, int preEnd, String[] in, int inSta, int inEnd) {
		if( pre == null || in == null || preSta > preEnd || inSta > inEnd) {
			return null;
		}
		
		int i = inSta;
		String s = pre[preSta];
		BNode bn = new BNode(Integer.parseInt(s));
		
		for(; i <= inEnd; i++ ) {
			if(in[i].equals(s)) {
				break;
			}
		}
		
		BNode left = buildBTreePreIn(pre, preSta + 1, preSta + (i - inSta), in, inSta, i - 1);
		bn.setLeft(left);
		BNode right = buildBTreePreIn(pre, preSta + (i - inSta) + 1, preEnd, in, i + 1, inEnd);
		bn.setRight(right);
		
		return bn;
	}
	
	BNode buildBTreeInPost(String[] in, int inSta, int inEnd, String[] post, int postSta, int postEnd) {
		if( in == null || inSta > inEnd || post == null || postSta > postEnd ) {
			return null;
		}
		
		int i = inSta;
		String s = post[postEnd];
		BNode bn = new BNode(Integer.parseInt(s));
		
		for( ; i <= inEnd; i++ ) {
			if( in[i].equals(s)) {
				break;
			}
		}
		
		BNode left = buildBTreeInPost(in, inSta, i - 1, post, postSta, postSta + i - (inSta + 1));
		bn.setLeft(left);
		BNode right = buildBTreeInPost(in, i + 1, inEnd, post, postSta + i - inSta, postEnd - 1);
		bn.setRight(right);
		
		return bn;
	}
}

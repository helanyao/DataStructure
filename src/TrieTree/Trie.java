package TrieTree;

import java.util.HashMap;

// assume that all inputs are consist of lower case letters a-z

class TrieNode {
	public boolean havVal;
	public HashMap<Character, TrieNode> children = null;
	public int freq = 0;
	
    public TrieNode() {
    	children = new HashMap<Character, TrieNode>();
    }
    
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        if(word == null || word.length() == 0) {
        	return;
        }

        TrieNode cur = root;
        for(int i = 0; i < word.length(); i++) {
        	char ch = word.charAt(i);
        	if(!cur.children.containsKey(ch)) {
        		cur.children.put(ch, new TrieNode());
        	} 
        	cur = cur.children.get(ch);
        	if(i == word.length() - 1) {
        		cur.havVal = true;
        	}
        }
    }
    
    public TrieNode getNodeForWord(String word) {
    	if(word == null || word.length() == 0) {
        	return null;
        }
    	
    	TrieNode cur = root;
    	for(int i = 0; i < word.length(); i++) {
    		cur = cur.children.get(word.charAt(i));
    		if(cur == null) {
    			break;
    		}
    	}
    	
    	return cur;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode n = getNodeForWord(word);
        if(n == null || !n.havVal) {
        	return false;
        } else {
        	return true;
        }
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode n = getNodeForWord(prefix);
        if(n == null) {
        	return false;
        } else {
        	return true;
        }
    }
}

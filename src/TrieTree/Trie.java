package TrieTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

// assume that all inputs are consist of lower case letters a-z

class TrieNode {
	public String val = null;
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
        		cur.val = word;
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
        if(n == null || n.val == null) {
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
    
    public List<String> serialize() {
    	Queue<TrieNode> q = new LinkedList<TrieNode>();
    	List<String> values = new ArrayList<String>();
    	TrieNode n = root;
    	q.offer(n);
    	while(!q.isEmpty()) {
    		n = q.poll();
    		if(n.val != null) {
    			values.add(n.val);
    		}
    		for(Map.Entry<Character, TrieNode> entry : n.children.entrySet()) {
    			q.offer(entry.getValue());
    		}
    	}
    	return values;
    }
    
    public void deserialize(List<String> words) {
    	if(words == null) {
    		root = null;
    		return;
    	}
    	for(String word : words) {
    		insert(word);
    	}
    }
}

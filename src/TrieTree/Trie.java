package TrieTree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;

// assume that all inputs are consist of lower case letters a-z

class TrieNode {
	public String val = null;
	public NavigableMap<Character, TrieNode> children = null;
	public int freq = 0;
	
    public TrieNode() {
    	children = new TreeMap<Character, TrieNode>();
    }
    
}

public class Trie {
    public TrieNode root;

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
    
    public List<String> serializeSimple() {
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
    
    public void deserializeSimple(List<String> words) {
    	if(words == null) {
    		root = null;
    		return;
    	}
    	for(String word : words) {
    		insert(word);
    	}
    }
    
    public String serialize(TrieNode root) {
        if (root == null)
            return "";

        StringBuffer sb = new StringBuffer();
        sb.append("<");
        Iterator iter = root.children.entrySet().iterator(); 
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry)iter.next(); 
            Character key = (Character)entry.getKey(); 
            TrieNode child = (TrieNode)entry.getValue();
            sb.append(key);
            sb.append(serialize(child));
        }
        sb.append(">");
        return sb.toString();
    }

    public TrieNode deserialize(String data) {
        if (data == null || data.length() == 0)
            return null;

        TrieNode root = new TrieNode();
        TrieNode current = root;
        Stack<TrieNode> path = new Stack<TrieNode>();
        for (Character c : data.toCharArray()) {
            switch (c) {
            case '<':
                path.push(current);
                break;
            case '>':
                path.pop();
                break;
            default:
                current = new TrieNode();
                path.peek().children.put(c, current);
            }
        }
        return root;
    }
}

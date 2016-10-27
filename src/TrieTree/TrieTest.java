package TrieTree;

import java.util.List;

public class TrieTest {

	public static void main(String[] args) {
		Trie t = new Trie();
		t.insert("a");
		t.insert("b");
		t.insert("c");
		System.out.println(t.startsWith("a"));
		System.out.println(t.search("b"));
		t.insert("b");
		t.insert("b");
		System.out.println(t.search("b"));
		
		List<String> words = t.serialize();
		System.out.println(words.toString());
		
		Trie t2 = new Trie();
		t2.deserialize(words);
		System.out.println(t.startsWith("a"));
		System.out.println(t.search("b"));
		List<String> words1 = t.serialize();
		System.out.println(words1.toString());
	}

}

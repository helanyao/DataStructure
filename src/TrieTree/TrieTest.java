package TrieTree;

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
	}

}

import java.util.*;

public class Trie {

	private static class TrieNode {
		int prefixes;
		int words;
		TrieNode[] children;

		public TrieNode() {
			prefixes = 0;
			words = 0;

			children = new TrieNode[26];
		}
	}

	private TrieNode root;

	public Trie() {
		root = new TrieNode();
	}

	private int indexForChar(char c) {
		return c - 97;
	}

	private char charAtIndex(int index) {
		return (char) (index + 97);
	}

	public void addWord(String word) {
		TrieNode cur = root;
		for(int i = 0; i < word.length(); i++) {
			cur.prefixes += 1;
			char c = word.charAt(i);
			int index = indexForChar(c);

			if(cur.children[index] == null) {
				TrieNode trieNode = new TrieNode();
				cur.children[index] = trieNode;
			}

			cur = cur.children[index];
		}

		cur.words += 1;
	}

	public int startsWith(String prefix) {
		TrieNode cur = root;

		for(int i = 0; i < prefix.length(); i++) {
			if(cur == null) {
				return 0;
			}

			cur = cur.children[indexForChar(prefix.charAt(i))];
		}

		if(cur == null) {
			return 0;
		} else {
			return cur.prefixes;
		}
	}

	public int matchesWord(String word) {
		TrieNode cur = root;

		for(int i = 0; i < word.length(); i++) {
			if(cur == null) {
				return 0;
			}

			cur = cur.children[indexForChar(word.charAt(i))];
		}

		if(cur == null) {
			return 0;
		} else {
			return cur.words;
		}
	}

	public void print() {
		Deque<TrieNode> queue = new LinkedList<TrieNode>();
		queue.addLast(root);

		while(!queue.isEmpty()) {
			TrieNode trieNode = queue.removeFirst();

			for(int i = 0; i < trieNode.children.length; i++) {
				if(trieNode.children[i] != null) {
					System.out.print(charAtIndex(i));
					queue.addLast(trieNode.children[i]);
				}
			}
		}
	}

	public static void main(String[] args) {
		Trie trie = new Trie();

		String[] words = new String[] {"tree", "trie", "algo", "assoc", "all", "also"};

		for(String word : words) {
			trie.addWord(word);
		}

		System.out.format("starts with %s : %d%n", "a", trie.startsWith("a"));
		System.out.format("starts with %s : %d%n", "tr", trie.startsWith("tr"));
		System.out.format("starts with %s : %d%n", "al", trie.startsWith("al"));

		System.out.format("matches words with %s : %d%n", "a", trie.matchesWord("a"));
		System.out.format("matches words with %s : %d%n", "tr", trie.matchesWord("tr"));
		System.out.format("matches words with %s : %d%n", "al", trie.matchesWord("al"));

		System.out.format("matches words with %s : %d%n", "tree", trie.matchesWord("tree"));
		System.out.format("matches words with %s : %d%n", "trie", trie.matchesWord("trie"));
		System.out.format("matches words with %s : %d%n", "algo", trie.matchesWord("algo"));
		System.out.format("matches words with %s : %d%n", "assoc", trie.matchesWord("assoc"));
		System.out.format("matches words with %s : %d%n", "all", trie.matchesWord("all"));
		System.out.format("matches words with %s : %d%n", "also", trie.matchesWord("also"));



		//trie.print();

	}
}
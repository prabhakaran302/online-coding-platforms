package com.dcp.util;

import java.util.Map;

public class Trie {
	private TrieNode root;

	public Trie() {
		root = new TrieNode();
	}
	
	public void insert(String word) {
		Map<Character, TrieNode> children = root.children;
		for (int i = 0; i < word.length(); i++) {
			char cur = word.charAt(i);
			TrieNode node = null;
			if (children.containsKey(cur)) {
				node = children.get(cur);
			} else {
				node = new TrieNode(cur);
				children.put(cur, node);
			}
			if (i == word.length() - 1)
				node.isLeaf = true;
			children = node.children;
		}
	}

	public boolean isPrefix(String word) {
		Map<Character, TrieNode> children = root.children;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (children.containsKey(c)) {
				children = children.get(c).children;
				continue;
			} else {
				return false;
			}
		}
		return true;
	}

	public boolean search(String word) {
		Map<Character, TrieNode> children = root.children;
		TrieNode lastNode = null;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (children.containsKey(c)) {
				lastNode = children.get(c);
				children = children.get(c).children;
				continue;
			} else {
				return false;
			}
		}

		if (lastNode.isLeaf)
			return true;

		return false;
	}

	public TrieNode getRoot() {
		return root;
	}

	public void setRoot(TrieNode root) {
		this.root = root;
	}

}

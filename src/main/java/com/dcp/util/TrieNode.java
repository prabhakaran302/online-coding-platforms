package com.dcp.util;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
	Character c;
	Map<Character, TrieNode> children = new HashMap<>();
	boolean isLeaf;

	TrieNode() {

	}

	TrieNode(char c) {
		this.c = c;
	}

	public Character getC() {
		return c;
	}

	public void setC(Character c) {
		this.c = c;
	}

	public Map<Character, TrieNode> getChildren() {
		return children;
	}

	public void setChildren(Map<Character, TrieNode> children) {
		this.children = children;
	}

	public boolean isLeaf() {
		return isLeaf;
	}

	public void setLeaf(boolean isLeaf) {
		this.isLeaf = isLeaf;
	}

}
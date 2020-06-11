package com.dcp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.dcp.util.Trie;
import com.dcp.util.TrieNode;

/**
 * Implement an autocomplete system. That is, given a query string s and a set
 * of all possible query strings, return all strings in the set that have s as a
 * prefix.
 * 
 * @author prabhakaran.nivanil
 *
 */
public class TriePrefixValues {
	Trie trie;

	public static void main(String[] args) {
		TriePrefixValues obj = new TriePrefixValues();
		obj.findWords("de");
	}

	// TODO : Implememt AutoComplete Feature
	private void findWords(String str) {
		
	}

	public TriePrefixValues() {
		super();
		trie = new Trie();
		trie.insert("dog");
		trie.insert("dear");
		trie.insert("deal");
	}
}

package com.leetcode.arrays;

import java.util.Stack;

/**
 * https://leetcode.com/problems/valid-parentheses/
 * 
 * @author prabhakaran.nivanil
 *
 */
public class ValidParaenthesis {
	public boolean isValid(String s) {
		if (s == null || s.isEmpty())
			return true;

		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < s.toCharArray().length; i++) {
			switch (s.charAt(i)) {
			case '(':
				stack.push(s.charAt(i));
				break;
			case '{':
				stack.push(s.charAt(i));
				break;
			case '[':
				stack.push(s.charAt(i));
				break;
			case ')':
				if (stack.isEmpty())
					return false;
				if (stack.peek() != '(') {
					return false;
				} else {
					stack.pop();
				}
				break;
			case '}':
				if (stack.isEmpty())
					return false;
				if (stack.peek() != '{') {
					return false;
				} else {
					stack.pop();
				}
				break;
			case ']':
				if (stack.isEmpty())
					return false;
				if (stack.peek() != '[') {
					return false;
				} else {
					stack.pop();
				}
				break;
			}
		}

		if (!stack.isEmpty())
			return false;

		return true;
	}
}

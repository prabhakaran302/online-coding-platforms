package com.leetcode.linkedlist;

public class ReverseList {
	public ListNode reverseList(ListNode head) {
		ListNode prev = null;
		ListNode next = null;
		while (head != null) {
			ListNode curr = head;
			next = head.next;
			curr.next = prev;
			prev = curr;
			head = next;
		}
		return prev;
	}
}

package com.leetcode.linkedlist;

public class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}

	public static void printList(ListNode head) {
		if(head == null)
			return;
		StringBuilder sb = new StringBuilder();
		while (head != null) {
			sb.append(" >> " + head.val);
			head = head.next;
		}
		System.out.println(sb.substring(4));
	}
}

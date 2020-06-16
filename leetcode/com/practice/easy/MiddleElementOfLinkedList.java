package com.practice.easy;

import com.practice.easy.util.ListNode;

public class MiddleElementOfLinkedList {
	public static void main(String[] args) {

	}

	public ListNode middleNode(ListNode head) {
		if (head == null)
			return head;
		ListNode fast = head;
		ListNode slow = head;
		
		while(fast != null && fast.next != null)	{
			slow = slow.next;
			fast = fast.next.next;
		}
		
		return slow;
	}
}

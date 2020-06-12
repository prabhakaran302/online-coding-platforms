package com.leetcode.linkedlist;

public class KthLastNodeFromList {
	public static void main(String[] args) {
		KthLastNodeFromList obj = new KthLastNodeFromList();
		ListNode l = new ListNode(1);
		l.next = new ListNode(2);
		ListNode n = obj.removeNthFromEnd(l, 2);
		ListNode.printList(n);
	}

	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode ret = head;

		ListNode fast = head;
		ListNode slow = head;

		int temp = n;
		while (temp > 0) {
			fast = fast.next;
			temp--;
		}

		while (fast != null && fast.next != null) {
			fast = fast.next;
			slow = slow.next;
		}
		
		if(fast == null)	{
			ret = ret.next;
			return ret;
		}
		
		if(slow.next != null)
			slow.next = slow.next.next;
		else
			ret = null;

		return ret;
	}
}
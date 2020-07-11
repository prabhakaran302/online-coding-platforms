package com.leetcode.linkedlist;

public class AddTwoList {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		return addTwoNumbersUtil(l1, l2, 0);
	}

	public ListNode addTwoNumbersUtil(ListNode l1, ListNode l2, int carry) {
		if (l1 == null && l2 == null) {
			if (carry > 0) {
				return new ListNode(carry);
			}
			return null;
		}

		int value1 = (l1 != null) ? l1.val : 0;
		int value2 = (l2 != null) ? l2.val : 0;

		int sum = (value1 + value2 + carry) % 10;
		carry = (value1 + value2 + carry) / 10;

		ListNode currentHead = new ListNode(sum);

		ListNode node1Next = (l1 != null) ? l1.next : null;
		ListNode node2Next = (l2 != null) ? l2.next : null;

		currentHead.next = addTwoNumbersUtil(node1Next, node2Next, carry);

		return currentHead;
	}

	public static void main(String[] args) {
		AddTwoList addTwoList = new AddTwoList();
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);
		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);
		ListNode res = addTwoList.addTwoNumbers(l1, l2);

		printList(res);
	}

	private static void printList(ListNode res) {
		while (res != null) {
			System.out.print(res.val + " ");
			res = res.next;
		}
	}
}

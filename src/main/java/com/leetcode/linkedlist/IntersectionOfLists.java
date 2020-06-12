package com.leetcode.linkedlist;

public class IntersectionOfLists {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		boolean flag = true;

		ListNode tempA = headA;
		ListNode tempB = headB;

		int lenA = 0;
		int lenB = 0;

		while (flag) {
			if (headA == null && headB == null) {
				flag = false;
				continue;
			}

			if (headA != null) {
				lenA++;
				headA = headA.next;
			}

			if (headB != null) {
				lenB++;
				headB = headB.next;
			}
		}

		ListNode main = lenA > lenB ? tempA : tempB;
		ListNode sub = lenA <= lenB ? tempA : tempB;

		int absDiff = Math.abs(lenA - lenB);

		while (absDiff > 0) {
			main = main.next;
			absDiff--;
		}

		flag = true;
		while(flag)	{
			if(main == null || sub == null)	{
				flag = false;
				return null;
			}
			if(main == sub)
				return main;
			else	{
				main = main.next;
				sub = sub.next;
			}
		}

		return null;

	}
	
	public static void main(String[] args) {
		IntersectionOfLists obj = new IntersectionOfLists();
		ListNode headA = new ListNode(4);
		headA.next = new ListNode(1);
		
		ListNode common = new ListNode(8);
		common.next = new ListNode(4);
		common.next.next = new ListNode(5);
		headA.next.next = common;
		
		
		ListNode headB = new ListNode(0);
		headB.next = new ListNode(0);
		headB.next.next = new ListNode(1);
		headB.next.next.next = common;
		
		
		System.out.println(obj.getIntersectionNode(headA, headB));
	}

}

package com.dcp;

import java.util.Scanner;
import java.util.Stack;

/**
 * Implement a stack that has the following methods:
 * 
 * • push(val), which pushes an element onto the stack
 * 
 * • pop(), which pops off and returns the topmost element of the stack. If
 * there are no elements in the stack, then it should throw an error or return
 * null.
 * 
 * • max(), which returns the maximum value in the stack currently. If there are
 * no elements in the stack, then it should throw an error or return null.
 * 
 * @author prabhakaran.nivanil
 *
 */
public class SpecialStack {
	Stack<Integer> stack = new Stack<>();
	int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws Exception {
		SpecialStack spStack = new SpecialStack();
		Scanner sc = new Scanner(System.in);

		int num = 0;
		boolean flag = true;
		while (flag) {
			System.out.println("\n\nEnter the operation you want to perform.\n1.Push \n2.Pop \n3.Max\n4.Exit");
			int line = sc.nextInt();
			switch (line) {
			case 1:
				System.out.println("Enter the number you want to push in special stack");
				num = sc.nextInt();
				spStack.push(num);
				break;
			case 2:
				try {
					num = spStack.pop();
					System.out.println("Number Popped from stack is " + num);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 3:
				try {
					num = spStack.getMax();
					System.out.println("Maximum element in stack is " + num);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 4:
				flag = false;
				System.out.println("Exit !");
				break;
			default:
				System.out.println("Invalid !");
				System.exit(0);
				break;
			}
		}
	}

	public void push(int ele) {
		if (max > ele)
			stack.push(ele);
		else {
			stack.push(2 * max - ele);
			max = ele;
		}
	}

	public int pop() throws Exception {
		if (stack.isEmpty()) {
			throw new Exception("Stack empty !!");
		}
		int ele = stack.pop();
		int temp = 0;
		if (ele < max) {
			temp = max;
			max = 2 * ele + 1;
		} else {
			temp = ele;
		}
		return temp;
	}

	public int getMax() throws Exception {
		if (stack.isEmpty()) {
			throw new Exception("Stack empty !!");
		}
		return max;
	}
}

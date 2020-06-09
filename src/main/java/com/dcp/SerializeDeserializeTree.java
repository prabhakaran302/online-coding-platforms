package com.dcp;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the root to a binary tree, implement serialize(root), which serializes
 * the tree into a string, and deserialize(s), which deserializes the string
 * back into the tree.
 * 
 * During serialize, we will put -1 to indicate it is leaf node.
 * 
 * @author prabhakaran.nivanil
 *
 */
public class SerializeDeserializeTree {

	public static void main(String[] args) {
		Node root = getTree();
		preOrder(root);

		System.out.println();

		List<Integer> list = new ArrayList<Integer>();
		serializeTree(root, list);

		root = deSerializeTree(list);
		preOrder(root);
	}

	static int counter = 0;

	private static Node deSerializeTree(List<Integer> list) {
		if (list.get(counter) == -1) {
			counter++;
			return null;
		}
		Node root = new Node(list.get(counter++));
		root.left = deSerializeTree(list);
		root.right = deSerializeTree(list);
		return root;
	}

	private static void serializeTree(Node root, List<Integer> list) {
		if (root == null) {
			list.add(-1);
			return;
		}
		if (root != null) {
			list.add(root.val);
		}
		serializeTree(root.left, list);
		serializeTree(root.right, list);
	}

	private static void preOrder(Node root) {
		if (root == null)
			return;
		System.out.print(root.val + " ");
		preOrder(root.left);
		preOrder(root.right);
	}

	public static Node getTree() {
		Node root = new Node(8);
		root.left = new Node(7);
		root.right = new Node(6);

		root.left.left = new Node(3);
		root.left.right = new Node(1);

		root.left.right.right = new Node(2);

		return root;
	}

}

class Node {
	Node left, right;
	int val;

	Node(int v) {
		val = v;
	}
}

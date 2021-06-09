/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
		List<List<Integer>> l = new ArrayList<>();
		List<Integer> li = new ArrayList<>();
		pathSumUtil(root, l, li, targetSum);

		return l;
	}

	private void pathSumUtil(TreeNode root, List<List<Integer>> l, List<Integer> li, int targetSum) {
		if (root == null)
			return;

		li.add(root.val);

		if (root.left == null && root.right == null && targetSum == root.val) {
			l.add(new ArrayList<>(li));
		} else {
			pathSumUtil(root.left, l, li, targetSum - root.val);
			pathSumUtil(root.right, l, li, targetSum - root.val);
		}
		li.remove(li.size() - 1);
	}
}
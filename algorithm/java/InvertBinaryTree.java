import java.util.LinkedList;
import java.util.Queue;

/**
 * 翻转一棵二叉树。
 */
public class InvertBinaryTree {
	/**
	 * 时间复杂度: O(n)
	 * 空间复杂度: O(n)
	 */
	public TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return null;
		}

		TreeNode tmp = root.left;
		root.right = root.left;
		root.left = tmp;
		
		invertTree(root.left);
		invertTree(root.right);
		return root;
	}

	/**
	 * 时间复杂度: O(n)
	 * 空间复杂度: O(n)
	 */
	public TreeNode invertTree2(TreeNode root) {
		if (root == null) {
			return null;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
 
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			TreeNode tmp = node.left;
			node.left = node.right;
			node.right = tmp;
 
			 if (node.left != null) {
				 queue.offer(node.left);
			 }
			 if (node.right != null) {
				 queue.offer(node.right);
			 }
		}
		return root;
	}
}

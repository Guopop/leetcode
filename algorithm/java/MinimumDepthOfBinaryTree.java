/**
 * 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 */
public class MinimumDepthOfBinaryTree {
	/**
	 * 时间复杂度: O(n)
	 * 空间复杂度: O(n)
	 */
	public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int ml = minDepth(root.left);
        int mr = minDepth(root.right);

        if (root.left == null || root.right == null) {
            return ml + mr + 1;
        }
        return Math.min(ml, mr) + 1;
    }	
}

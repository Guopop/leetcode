/**
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 */
public class MaximumDepthOfBinaryTree {
	/**
	 * 时间复杂度: O(n)
	 * 空间复杂度: O(n)
	 */
	public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } 
        int lh = maxDepth(root.left);
        int rh = maxDepth(root.right);
        return Math.max(lh, rh) + 1;       
    }
}

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 */
public class BinaryTreePreorderTraversal {
	/**
	 * 时间复杂度: O(n)
	 * 空间复杂度: O(n)
	 */
	public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        preOrder(root, res);
        return res;
    }

    private void preOrder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }

        res.add(root.val);
        preOrder(root.left, res);
        preOrder(root.right, res);
    }	

	/**
	 * 时间复杂度: O(n)
	 * 空间复杂度: O(n)
	 */
	public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Deque<TreeNode> stack = new ArrayDeque<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                res.add(root.val);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
        return res;
    }
}

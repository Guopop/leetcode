import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 */
public class BinaryTreeInorderTraversal {
	/**
	 * 时间复杂度: O(n)
	 * 空间复杂度: O(n)
	 */
	public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        middleOrder(root, res);
        return res;
    }
    private void middleOrder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        middleOrder(root.left, res);
        res.add(root.val);
        middleOrder(root.right, res);
    }

	/**
	 * 
	 * 时间复杂度: O(n)
	 * 空间复杂度: O(n)
	 */
	public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }
}

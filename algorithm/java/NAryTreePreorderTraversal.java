import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

/**
 * 给定一个 N 叉树，返回其节点值的 前序遍历 。
 */
public class NAryTreePreorderTraversal {
	/**
	 * 时间复杂度: O(n)
	 * 空间复杂度: O(n)
	 */
	public List<Integer> preorder1(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        npreorder(root, res);
        return res;
    }

    private void npreorder(Node root, List<Integer> res) {
        res.add(root.val);
        for (Node node : root.children) {
            npreorder(node, res);
        }
    }

	/**
	 * 时间复杂度: O(n)
	 * 空间复杂度: O(n)
	 */
	public List<Integer> preorder2(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Deque<Node> q = new ArrayDeque<>();
        q.push(root);
        
        while (!q.isEmpty()) {
            root = q.pop();
            res.add(root.val);
            Collections.reverse(root.children);
            for (Node node : root.children) {
                q.push(node);
            }
        }
        return res;
    }
}
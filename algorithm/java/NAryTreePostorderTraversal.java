import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

/**
 * 给定一个 N 叉树，返回其节点值的 后序遍历 。
 */
public class NAryTreePostorderTraversal {
	/**
	 * 时间复杂度: O(n)
	 * 空间复杂度: O(n)
	 */
	public List<Integer> postorder1(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        } 

        npostorder(root, res);
        return res;
    }

    private void npostorder(Node root, List<Integer> res) {
        if (root == null) {
            return;
        }

        for(Node c : root.children) {
            npostorder(c, res);
        }
        res.add(root.val);
	}

	
	/**
	 * 时间复杂度: O(n)
	 * 空间复杂度: O(n)
	 */
	public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Deque<Node> stack = new ArrayDeque<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            root = stack.pop();
            res.add(root.val);

            for (Node c : root.children) {
                stack.push(c); 
            }
        }
        Collections.reverse(res);
        return res;
    }
}

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的序列化与反序列化
 */
public class SerializeAndDeserializeBinaryTree {
	/**
	 * 时间复杂度: O(n)
	 * 空间复杂度: O(n)
	 */
    public String serialize(TreeNode root) {
		return dfs(root); 
	 }
 
	 private String dfs(TreeNode root) {
		 if (root == null) {
			 return "X,";
		 }
		 String l = dfs(root.left);
		 String r = dfs(root.right);
		 return root.val + "," + l + r;
	 }
 
	/**
	 * 时间复杂度: O(n)
	 * 空间复杂度: O(n)
	 */
	 public TreeNode deserialize(String data) {
		 String[] arr = data.split(",");
		 Queue<String> queue = new LinkedList<>(Arrays.asList(arr));
		 return build(queue);
	 }
 
	 private TreeNode build(Queue<String> queue) {
		 String val = queue.poll();
		 if (val.equals("X")) {
			 return null;
		 }
		 TreeNode node = new TreeNode(Integer.parseInt(val));
		 node.left = build(queue);
		 node.right = build(queue);
		 return node;
	 }
}

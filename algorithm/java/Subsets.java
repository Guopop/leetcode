import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。 
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 */
public class Subsets {
	/**
	 * 时间复杂度: O(n*2^n)
	 * 空间复杂度: O(n)
	 */
	public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();

        dfs(res, nums, deque, 0);
        return res;
    }

    private void dfs(List<List<Integer>> res, int[] nums, Deque<Integer> deque, int idx) {
        if (idx == nums.length) {
            res.add(new ArrayList<>(deque));
            return;
        }
        deque.offer(nums[idx]);
        dfs(res, nums, deque, idx + 1);
        deque.pollLast();
        dfs(res, nums, deque, idx + 1);
	}
}

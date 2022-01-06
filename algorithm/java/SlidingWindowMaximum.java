import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。 
 * 返回滑动窗口中的最大值。
 */
public class SlidingWindowMaximum {
	/**
	 * 时间复杂度: O(n)
	 * 空间复杂度：O(n)
	 */
	public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) {
            return new int[0];
        }

		// 存储每组窗口最大值
        int[] w = new int[nums.length - k + 1];
        int wi = 0;
		// 单调双端队列 head 是 最大值下标
        Deque<Integer> q = new ArrayDeque<>();
        
        for (int i = 0; i < nums.length; i++) {
			// 从队列的队头 不在窗口的下标 则从队头删除
            while (!q.isEmpty() && q.peek() < i - k + 1) {
                q.poll();
            }
			// 当前元素大于队尾下标对应的元素，从队尾删除
            while (!q.isEmpty() && nums[q.peekLast()] < nums[i]) {
                q.pollLast();
            }
            q.offer(i);
			
            if (i >= k - 1) {
                w[wi++] = nums[q.peek()];
            }
        }
        return w;
    }
}

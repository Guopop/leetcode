import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。 
 * 示例 1: 
 * 	输入：heights = [2,1,5,6,2,3] 
 * 	输出：10 
 * 	解释：最大的矩形为图中红色区域，面积为 10 
 * 示例 2： 
 * 	输入： heights = [2,4] 
 * 	输出： 4 
 * 提示： 
 * 	1 <= heights.length <=105 
 * 	0 <= heights[i] <= 104
 */
public class LargestRectangleInHistogram {
	/**
     * 时间复杂度: O(n)
     * 空间复杂度: O(n)
     */
    public int largestRectangleArea(int[] heights) {
        int res = 0;
        int[] newHeight = new int[heights.length+2];
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (int i = 1; i < heights.length + 1; i++) {
            newHeight[i] = heights[i-1];
        }

        for (int i = 0; i < newHeight.length; i++) {
            while (!stack.isEmpty() && newHeight[stack.peek()] > newHeight[i]) {
                int c = stack.pop();
                res = Math.max(res, (i - stack.peek() - 1) * newHeight[c]);
            }
            stack.push(i);
        }
        return res;
    }
}

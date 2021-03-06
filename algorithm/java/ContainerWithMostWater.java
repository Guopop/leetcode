/**
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 说明：你不能倾斜容器。
 * 示例1
 * 	输入：[1,8,6,2,5,4,8,3,7]
 * 	输出：49 
 * 示例 2：
 *	输入：height = [1,1]
 *	输出：1
 * 示例 3：
 *	输入：height = [4,3,2,1,4]
 *	输出：16
 * 提示：
 * 	n == height.length
 * 	2 <= n <= 105
 *	0 <= height[i] <= 104
 */
public class ContainerWithMostWater {

	/**
	 * 时间复杂度: O(n)
	 * 空间复杂度: O(1)
	 */
    public int maxArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int max = 0;
        int i = 0;
        int j = height.length - 1;
        
        while (i < j) {
            max = height[i] < height[j] ?
                    Math.max(max, (j - i) * height[i++]) : 
                    Math.max(max, (j - i) * height[j--]);
        }

        return max;
    }
}
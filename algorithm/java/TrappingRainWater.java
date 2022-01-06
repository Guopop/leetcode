/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 */
public class TrappingRainWater {
	/**
	 * 时间复杂度: O(n)
	 * 时间复杂度: O(1)
	 */
	public int trap(int[] height) {
        int res = 0;
        int i = 0;
        int j = height.length - 1;
        int iMax = 0;
        int jMax = 0;
        while (i < j) {
            iMax = Math.max(iMax, height[i]);
            jMax = Math.max(jMax, height[j]);

            if (height[i] < height[j]) {
                res += iMax - height[i];
                i++;
            } else {
                res += jMax - height[j];
                j--;
            }
        }
        return res;
    }
}

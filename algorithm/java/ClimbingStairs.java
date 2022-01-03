/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 * 示例 1：
 *	输入： 2
 *	输出： 2
 *	解释： 有两种方法可以爬到楼顶。
 * 		1. 1 阶 + 1 阶
 *		2. 2 阶
 *
 * 示例 2：
 * 	输入： 3
 *	输出： 3
 *	解释： 有三种方法可以爬到楼顶。
 *		1. 1 阶 + 1 阶 + 1 阶
 *		2. 1 阶 + 2 阶
 *		3. 2 阶 + 1 阶
 */
public class ClimbingStairs {

	/**
	 * 递归
	 * 时间复杂度: O(n)
	 * 空间复杂度: O(1)
	 */
    public int climbStairs1(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        return climbStairs1(n - 1) + climbStairs1(n - 2);
    }

	/**
	 * 动态规划
	 * 时间复杂度: O(n)
	 * 空间复杂度: O(1)
	 */
	public int climbStairs2(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        int q = 0;
        int r = 1;
        int p;

        for (int k = 0; k < n; k++) {
            p = q;
            q = r;
            r = p + q;
        }

        return r;
    }
}
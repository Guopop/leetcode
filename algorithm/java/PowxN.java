/**
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，x^n ）
 */
public class PowxN {
	/**
	 * 时间复杂度: O(logn)
	 * 空间复杂度: O(logn)
	 */
	public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if(n == Integer.MIN_VALUE){
            x *= x;
            n /= 2;
        }
        if (n < 0) {
           n = -n;
           x = 1 / x; 
        }
        return (n % 2 == 0) ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
    }

	/**
	 * 时间复杂度: O(logn)
	 * 空间复杂度: O(1)
	 */
	public double myPow2(double x, int n) {
        double res = 1;
        long m = n;
        if (x == 0) {
            return 0;
        }
        if (m < 0) {
            m = -m;
            x = 1 / x;
        }
        while (m > 0) {
            if (m % 2 == 1) {
                res *= x;
            }
            x *= x;
            m /= 2;
        }
        return res;
    }
}

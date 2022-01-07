/**
 * 给你一个整数 n ，请你找出并返回第 n 个 丑数 。 
 * 丑数 就是只包含质因数 2、3 和/或 5 的正整数。
 */
public class UglyNumber2 {
	/**
	 * 时间复杂度: O(n)
	 * 空间复杂度: O(n)
	 */
	public int nthUglyNumber(int n) {
        int[] arr = new int[n];
        arr[0] = 1;
        for (int i2 = 0, i3 = 0, i5 = 0, i = 1; i < n; i++) {
            int a = arr[i2] * 2;
            int b = arr[i3] * 3;
            int c = arr[i5] * 5;
            
            int min = Math.min(a, Math.min(b, c));

            if (min == a) {
                i2++;
            }
            if (min == b) {
                i3++;
            }
            if (min == c) {
                i5++;
            }
            arr[i] = min;
        }
        return arr[n - 1];
    }
}

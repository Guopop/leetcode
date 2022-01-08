import java.util.ArrayList;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 */
public class GenerateParentheses {
	/**
	 * 时间复杂度: O(\frac{4^{n}}{\sqrt{n}})
	 * 空间复杂度: O(n)
	 */
	public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(res, "", 0, 0, n);
        return res;
    }

    private void dfs(List<String> res, String s, int l, int r, int max) {
        if (s.length() == max * 2) {
            res.add(s);
            return;
        }

        if (l < max) {
            dfs(res, s + "(", l + 1, r, max);
        } 
        if (r < l) {
            dfs(res, s + ")", l, r + 1, max);
        }
    }
}

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
 * 有效字符串需满足： 
 * 	左括号必须用相同类型的右括号闭合。 
 * 	左括号必须以正确的顺序闭合。 
 * 示例 1： 
 * 	输入：s = "()" 
 * 	输出：true 
 * 示例 2： 
 * 	输入：s = "()[]{}" 
 * 	输出：true 
 * 示例 3： 
 * 	输入：s = "(]" 
 * 	输出：false 
 * 示例 4： 
 * 	输入：s = "([)]" 
 * 	输出：false 
 * 示例 5： 
 * 	输入：s = "{[]}" 
 * 	输出：true 
 * 提示： 
 * 	1 <= s.length <= 104 
 * 	s 仅由括号 '()[]{}' 组成
 */
public class ValidParentheses {
	/**
     * 时间复杂度: O(n)
     * 空间复杂度: O(n)
     */
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (Character c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || c != stack.pop()) {
                return false;
            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }	
}

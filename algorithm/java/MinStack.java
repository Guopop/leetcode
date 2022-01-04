import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。 
 * push(x) —— 将元素 x 推入栈中。 
 * pop() —— 删除栈顶的元素。 
 * top() —— 获取栈顶元素。 
 * getMin() —— 检索栈中的最小元素。   
 * 示例: 
 *  输入： 
 * 	["MinStack","push","push","push","getMin","pop","top","getMin"] 
 * 	[[],[-2],[0],[-3],[],[],[],[]] 
 * 	输出： 
 * 	[null,null,null,null,-3,null,0,-2] 
 * 
 * 解释： 
 * MinStack minStack = new MinStack(); 
 * minStack.push(-2); 
 * minStack.push(0); 
 * minStack.push(-3); 
 * minStack.getMin();   --> 返回 -3. 
 * minStack.pop(); 
 * minStack.top();      --> 返回 0.  
 * minStack.getMin();   --> 返回 -2.    
 * 提示： 
 * pop、top 和 getMin 操作总是在 非空栈 上调用。
 * 
 * 时间复杂度: O(1)  所有操作
 * 空间复杂度: O(n)
 */
public class MinStack {

    private Deque<Integer> stack;
    private Deque<Integer> minStack;

    public MinStack() {
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }
    
    public void pop() {
        if (stack.pop().equals(minStack.peek())) {
            minStack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
/**
 * 设计实现双端队列。
 * 你的实现需要支持以下操作：
 *	MyCircularDeque(k)：构造函数,双端队列的大小为k。
 *	insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true。
 *	insertLast()：将一个元素添加到双端队列尾部。如果操作成功返回 true。
 *	deleteFront()：从双端队列头部删除一个元素。 如果操作成功返回 true。
 *	deleteLast()：从双端队列尾部删除一个元素。如果操作成功返回 true。
 *	getFront()：从双端队列头部获得一个元素。如果双端队列为空，返回 -1。
 *	getRear()：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1。
 *	isEmpty()：检查双端队列是否为空。
 *	isFull()：检查双端队列是否满了。
 */
public class DesignCircularDeque {
	private int capacity;
    private int[] arr;
    private int front;
    private int rear;

    public DesignCircularDeque(int k) {
        capacity = k + 1;
        arr = new int[capacity];
        front = 0;
        rear = 0;
    }
    
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        } 
        front = (front - 1 + capacity) % capacity;
        arr[front] = value;
        return true;
    }
    
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }

        arr[rear] = value;
        rear = (rear + 1) % capacity;
        return true;
    }
    
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        front = (front + 1) % capacity;
        return true;
    }
    
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        rear = (rear - 1 + capacity) % capacity;
        return true;
    }
    
    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return arr[front];
    }
    
    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return arr[(rear - 1 + capacity) % capacity];
    }
    
    public boolean isEmpty() {
        return  front == rear;
    }
    
    public boolean isFull() {
        return (rear + 1) % capacity == front;
    }
}

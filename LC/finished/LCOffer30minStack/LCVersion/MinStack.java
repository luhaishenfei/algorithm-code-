package finished.LCOffer30minStack.LCVersion;

import java.util.Deque;
import java.util.LinkedList;
/*
	执行耗时:13 ms,击败了75.13% 的Java用户
	内存消耗:46 MB,击败了13.67% 的Java用户
 */
class MinStack {
    Deque<Integer> xStack;
    Deque<Integer> minStack;

    public MinStack() {
        xStack = new LinkedList<Integer>();
        minStack = new LinkedList<Integer>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
        xStack.push(x);
        minStack.push(Math.min(minStack.peek(), x));
    }

    public void pop() {
        xStack.pop();
        minStack.pop();
    }

    public int top() {
        return xStack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
package finished.LCOffer30minStack;
//定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
//
//
//
// 示例:
//
// MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.min();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.min();   --> 返回 -2.
//
//
//
//
// 提示：
//
//
// 各函数的调用总次数不超过 20000 次
//
//
//
//
// 注意：本题与主站 155 题相同：https://leetcode-cn.com/problems/min-stack/
//
// Related Topics 栈 设计 👍 500 👎 0


import java.util.*;

//fine
/*
执行耗时:13 ms,击败了75.13% 的Java用户
内存消耗:46.4 MB,击败了5.01% 的Java用户
 */
class MinStack {

    /**
     * initialize your data structure here.
     */

    public MinStack() {
        queue    = new LinkedList();
        minQueue = new LinkedList();
    }


    Deque<Integer> queue;
    Deque<Integer> minQueue;

    public void push(int x) {
        queue.push(x);
        if (minQueue.size() == 0) {
            minQueue.push(x);
        }else {
            int min=minQueue.peek();
            if (x<min){
                minQueue.push(x);
            }else {
                minQueue.push(min);
            }
        }
    }

    public void pop() {
        minQueue.pop();
        queue.pop();
    }

    public int top() {
        return queue.peek();
    }

    public int min() {
        return  minQueue.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */

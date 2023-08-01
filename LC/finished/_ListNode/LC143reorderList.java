package finished._ListNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

//L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
public class LC143reorderList {

    public static void main(String[] args) {

        ListNode n1 = new ListNode(
                1, new ListNode(
                2, new ListNode(
                3, new ListNode(
                4, new ListNode(
                5, new ListNode(
                6, new ListNode(
                7
        )))))));

        LC143reorderList l = new LC143reorderList();
        l.reorderList(n1);
    }

    /*
    执行耗时:4 ms,击败了13.41% 的Java用户
	内存消耗:45.6 MB,击败了5.01% 的Java用户
     */
    public void reorderList(ListNode head) {
        Deque<ListNode> nodeList = new LinkedList<>();
        while (head != null) {
            nodeList.add(head);
            head = head.next;
        }
        boolean flag = false;
        head = nodeList.getFirst();
        ListNode pre = nodeList.pollFirst();
        head = pre;
        while (nodeList.size() != 0) {
            ListNode tmp;
            if (flag) {
                tmp = nodeList.pollFirst();
            } else {
                tmp = nodeList.pollLast();
            }
            flag = !flag;
            pre.next = tmp;
            pre = pre.next;
            if (nodeList.size() == 0) pre.next = null;
        }
    }


    //斯巴拉西,very good.
    /*
    寻找链表中点 + 链表逆序 + 合并链表
     */
    public void reorderListLC0(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode mid = middleNode(head);
        ListNode l1 = head;
        ListNode l2 = mid.next;
        mid.next = null;
        l2 = reverseList(l2);
        mergeList(l1, l2);
    }

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    public void mergeList(ListNode l1, ListNode l2) {
        ListNode l1_tmp;
        ListNode l2_tmp;
        while (l1 != null && l2 != null) {
            l1_tmp = l1.next;
            l2_tmp = l2.next;

            l1.next = l2;
            l1 = l1_tmp;

            l2.next = l1;
            l2 = l2_tmp;
        }
    }


    //lc 线性表,Just so so,but better than me.
    public void reorderListLC(ListNode head) {
        if (head == null) {
            return;
        }
        List<ListNode> list = new ArrayList<ListNode>();
        ListNode node = head;
        while (node != null) {
            list.add(node);
            node = node.next;
        }
        int i = 0, j = list.size() - 1;
        while (i < j) {
            list.get(i).next = list.get(j);
            i++;
            if (i == j) {
                break;
            }
            list.get(j).next = list.get(i);
            j--;
        }
        list.get(i).next = null;
    }

}

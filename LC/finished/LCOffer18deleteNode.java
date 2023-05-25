package finished;

import finished._ListNode.ListNode;

public class LCOffer18deleteNode {
    /*
	执行耗时:0 ms,击败了100.00% 的Java用户
	内存消耗:41.9 MB,击败了5.04% 的Java用户
     */
    public ListNode deleteNode(ListNode head, int val) {
        if (head==null) return null;
        if (head.val==val) return head.next;
        ListNode node =head.next;
        ListNode preNode=head;
        while (node!=null){
            if (node.val==val){
                preNode.next=node.next;
                break;
            }
            preNode=node;
            node=node.next;
        }
        return head;
    }

    //same speed,but elegant
   /* 执行耗时:0 ms,击败了100.00% 的Java用户
    内存消耗:41.9 MB,击败了5.04% 的Java用户*/
    public ListNode deleteNodeLC(ListNode head, int val) {
        if(head.val == val) return head.next;
        ListNode pre = head, cur = head.next;
        while(cur != null && cur.val != val) {
            pre = cur;
            cur = cur.next;
        }
        if(cur != null) pre.next = cur.next;
        return head;
    }
}

package finished;

import finished._ListNode.ListNode;

public class LCOffer22getKthFromEnd {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5,
                                                new ListNode(6)))))
        );

        LCOffer22getKthFromEnd l = new LCOffer22getKthFromEnd();
        l.getKthFromEnd(n1,3);

    }


    /*
    执行耗时:0 ms,击败了100.00% 的Java用户
	内存消耗:39.3 MB,击败了77.02% 的Java用户
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) return null;
        ListNode node = head;
        int nodeLen = 1;
        while (node.next != null) {
            node = node.next;
            nodeLen++;
        }
        for (int i = 0; i < nodeLen - k; i++) {
            head = head.next;
        }
        return head;
    }
}

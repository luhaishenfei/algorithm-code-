package finished._ListNode;

public class LC876middleNode {
    public static void main(String[] args) {
        LC876middleNode l = new LC876middleNode();

        ListNode n1 = new ListNode(
                0, new ListNode(
                1, new ListNode(
                2, new ListNode(
                3, new ListNode(
                4, new ListNode(
                5, new ListNode(
                6
//                , new ListNode(7)
        )))))));

        System.out.println(l.middleNode(n1).val);
    }

    /*
	执行耗时:0 ms,击败了100.00% 的Java用户
	内存消耗:38.9 MB,击败了61.92% 的Java用户
     */
    public ListNode middleNode(ListNode head) {
        ListNode tmp = new ListNode(-1, head);
        ListNode fastNode = tmp;
        while (fastNode != null) {
            tmp = tmp.next;
            fastNode = fastNode.next;
            if (fastNode != null) {
                fastNode = fastNode.next;
            }
        }
        return tmp;
    }

    public ListNode middleNodeLC(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}

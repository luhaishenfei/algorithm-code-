package undo;
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
public class LCOfr35copyRandomList {

    public Node copyRandomList(Node head) {
        if (head==null) return null;
        Node tmp=new Node(head.val);
        Node res=tmp;
        while (head!=null){
            tmp.val=head.val;
            tmp.next=head.next;
            tmp.random=head.random;
            head=head.next;
        }
        return res;
    }

}

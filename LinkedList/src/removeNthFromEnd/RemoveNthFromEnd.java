package removeNthFromEnd;

public class RemoveNthFromEnd {

    //19.删除链表的倒数第N个节点
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fastNode = dummy;
        ListNode slowNode = dummy;

        //快指针先走n+1步，这样当快指针为null时，慢指针才会停在倒数n+1的节点处
        for (int i = 0; i <= n; i++) {
            fastNode = fastNode.next;
        }

        //当fastNode为null时，慢指针正好停在倒数n+1的节点处
        while (fastNode != null) {
            fastNode = fastNode.next;
            slowNode = slowNode.next;
        }
        slowNode.next = slowNode.next.next;
        return dummy.next;
    }
}

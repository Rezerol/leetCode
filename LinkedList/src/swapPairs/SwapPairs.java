package swapPairs;

public class SwapPairs {

    //24. 两两交换链表中的节点
    public ListNode swapPairs(ListNode head) {
        //设置虚拟头节点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        //记录两个节点后的第一个节点
        ListNode temp;
        //记录两个节点中第一个节点
        ListNode firstNode;
        //记录两个节点中第二个节点
        ListNode secondNode;
        ListNode cur = dummy;

        while (cur.next != null && cur.next.next != null) {
            temp = cur.next.next.next;
            firstNode = cur.next;
            secondNode = cur.next.next;
            cur.next = secondNode;
            secondNode.next = firstNode;
            firstNode.next = temp;
            cur = firstNode;
        }
        return dummy.next;
    }
}

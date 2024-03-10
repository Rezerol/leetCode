package detectCycle;

public class DetectCycle {

    //142.环形链表II
    public ListNode detectCycle(ListNode head) {
        //快慢指针法
        ListNode fastNode = head;
        ListNode slowNode = head;

        while (fastNode != null && fastNode.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;

            //判定有环存在
            if (fastNode == slowNode) {
                ListNode node1 = fastNode;
                ListNode node2 = head;
                //相遇即为环的入口节点
                while (node1 != node2) {
                    node1 = node1.next;
                    node2 = node2.next;
                }
                return node1;
            }
        }
        return null;
    }
}

package removeElements;


public class RemoveElements {

    //203.移除链表元素
    //添加虚拟节点法
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1, head);
        ListNode pre = dummy;
        ListNode current = head;

        while (current != null) {
            if (current.value == val) {
                pre.next = current.next;
            } else {
                pre = current;
            }
            current = current.next;
        }

        return dummy.next;
    }
    //不添加虚拟节点
    public ListNode removeElements1(ListNode head, int val) {
        //先处理头节点
        while (head != null && head.value == val) {
            head = head.next;
        }

        if (head == null) {
            return head;
        }

        //此时已确定head.value != val
        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null) {
            if (cur.value == val) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }

    public class ListNode {

        int value;

        ListNode next;

        ListNode() {}

        ListNode(int value) {
            this.value = value;
        }

        ListNode(int value, ListNode next) {
            this.value = value;
            this.next = next;
        }
    }
}

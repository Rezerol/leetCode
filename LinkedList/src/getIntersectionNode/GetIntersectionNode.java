package getIntersectionNode;

public class GetIntersectionNode {

    //160.链表相交
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        int lengthA = 0;
        ListNode cur = headA;
        while (cur != null) {
            lengthA++;
            cur = cur.next;
        }

        int lengthB = 0;
        cur = headB;
        while (cur != null) {
            lengthB++;
            cur = cur.next;
        }

        ListNode curA = headA;
        ListNode curB = headB;
        int gap = 0;
        //让curA指向最长的链表
        if (lengthB > lengthA) {
            curA = headB;
            curB = headA;
            gap = lengthB - lengthA;
        } else {
            gap = lengthA - lengthB;
        }
        while (gap > 0) {
            curA = curA.next;
            gap--;
        }
        while (curA != null) {
            if (curA == curB) {
                return curA;
            }
            curA = curA.next;
            curB = curB.next;
        }
        return null;
    }
}

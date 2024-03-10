package myLinkedList;

import java.util.List;

//707.设计链表
public class MyLinkedList {

    int size;

    ListNode head;

    //MyLinkedList() 初始化 MyLinkedList 对象。
    MyLinkedList() {
        this.size = 0;
        this.head = new ListNode(-1);
    }

    //int get(int index) 获取链表中下标为 index 的节点的值。如果下标无效，则返回 -1 。
    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }

        ListNode cur = head;
        //这里边界是<=index, 因为最终cur是索引为index的节点
        for (int i = 0; i <= index; i++) {
            cur = cur.next;
        }
        return cur.val;
    }

    //void addAtHead(int val) 将一个值为 val 的节点插入到链表中第一个元素之前。在插入完成后，新节点会成为链表的第一个节点。
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    //void addAtTail(int val) 将一个值为 val 的节点追加到链表中作为链表的最后一个元素。
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    //void addAtIndex(int index, int val) 将一个值为 val 的节点插入到链表中下标为 index 的节点之前。如果 index 等于链表的长度，那么该节点会被追加到链表的末尾。如果 index 比长度更大，该节点将 不会插入 到链表中。
    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }

        if (index < 0) {
            index = 0;
        }

        size++;
        ListNode pre = head;
        //找到index前一个节点，所以边界是<index
        for (int i  = 0; i < index; i++) {
            pre = pre.next;
        }
        ListNode newNode = new ListNode(val);
        newNode.next = pre.next;
        pre.next = newNode;
    }

    //void deleteAtIndex(int index) 如果下标有效，则删除链表中下标为 index 的节点。
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }

        size--;
        ListNode pre = head;
        //删除节点，需要找到它前一个节点，因此这里边界是<index
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        pre.next = pre.next.next;
    }
}


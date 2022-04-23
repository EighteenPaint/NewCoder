package newcoder.LinkList;

import java.util.HashMap;

public class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(ListNode next) {
        this.next = next;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }



    public static void main(String[] args) {
       ListNode listNode = new ListNode(1,new ListNode(2,new ListNode(2)));
       ListNode noDupLinkList = ListUtils.deleteDuplicates(listNode);
       ListUtils.ListNodePrinter(noDupLinkList);
    }
}

package newcoder.LinkList;

import java.util.HashMap;

public class ListUtils {
    public  static void ListNodePrinter(ListNode node){
        StringBuilder stringBuilder = new StringBuilder();
        while (node != null){
            stringBuilder.append(node.val);
            stringBuilder.append(",");
            node = node.next;
        }
        int length = stringBuilder.length();
        stringBuilder.deleteCharAt(length - 1);
        System.out.println( '{' + stringBuilder.toString() + '}');
    }
    public static ListNode deleteDuplicates (ListNode head) {
        // write code here
        ListNode vhead = new ListNode(0);
        vhead.next = head;
        ListNode start = vhead;
        ListNode end = vhead;
        HashMap<Integer,Integer> map = new HashMap(1);
        while(end != null && end.next != null){
            map.put(end.next.val,0);
            while(end.next != null && map.containsKey(end.next.val)) {
                int count = map.get(end.next.val);
                map.put(end.next.val,count + 1);
                end = end.next;
            }
            while(!map.containsKey(start.next.val)){
                start = start.next;
            }
            if (map.get(start.next.val) == 1){
                map.remove(start.next.val);
                start = start.next;
            }//不删除
            else if(map.get(start.next.val) > 1){
                map.remove(start.next.val);
                start.next = end.next;
                end = start;
                //删除
            }
        }
        return vhead.next;
    }
    public static ListNode deleteDuplicatesV2 (ListNode head) {
        // write code here
        ListNode vhead = new ListNode(0);
        vhead.next = head;
        ListNode start = vhead;
        ListNode end = vhead;

        return vhead.next;
    }
}

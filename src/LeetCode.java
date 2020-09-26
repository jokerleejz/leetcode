import java.util.ArrayList;
import java.util.List;

public class LeetCode {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        int k = 2;
        System.out.println(rotateRight(head, k));
    }

    public static ListNode rotateRight(ListNode head, int k) {
        List<ListNode> list = new ArrayList<>();
        if(head == null) {
            return null;
        }
        while(head != null) {
            list.add(new ListNode(head.val));
            head = head.next;
        }
        int len = list.size();
        k = k % len;
        ListNode rt = list.get((len-k)%len);
        for(int i = 0; i < len; i ++) {
            if(i == len-1) {
                list.get((i+len-k)%len).next = null;
                break;
            }
            list.get((i+len-k)%len).next = list.get((i+len-k+1)%len);
        }
        return rt;
    }

}
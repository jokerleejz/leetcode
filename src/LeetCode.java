import java.util.ArrayList;
import java.util.List;

public class LeetCode {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        //head.next = new ListNode(2);
        //head.next.next = new ListNode(3);
        //head.next.next.next = new ListNode(4);
        swapPairs(head);
    }

    public static ListNode swapPairs(ListNode head) {
        ListNode rt = null;
        List<ListNode> list = new ArrayList<>();
        while(head!=null && head.next!=null) {
            ListNode first = new ListNode(head.val);
            ListNode second = new ListNode(head.next.val);
            list.add(second);
            list.add(first);
            head = head.next.next;
        }
        for (int i=0; i < list.size()-1; i++){
            list.get(i).next = list.get(i+1);
        }
        int size = list.size();
        if(head == null){
            if(size > 0){
                rt = list.get(0);
            }
        }
        else if(head.next == null){
            if(size > 0){
                list.get(list.size()-1).next = new ListNode(head.val);
                rt = list.get(0);
            }
            else {
                rt = head;
            }

        }
        return rt;
    }
}

public class LeetCode {
    public static void main(String[] args) {
        ListNode head = null;
        ListNode p = new ListNode(1);
        head = p;
        p.next = new ListNode(2);
        p = p.next;
        /*
        p.next = new ListNode(3);
        p = p.next;
        p.next = new ListNode(4);
        p = p.next;
        p.next = new ListNode(5);
        p = p.next;
         */
        int n = 2;
        removeNthFromEnd(head, n);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode headNew = null, first = null, second = null, p = head;
        //设置初始值
        second = head;
        while(n > 0){
            second = second.next;
            n --;
        }
        if(second == null){
            //说明删除的是第一个
            if(head.next == null){
                return null;
            }
            else {
                first = new ListNode(head.next.val);
            }
        }
        else {
            first = new ListNode(head.val);
        }
        headNew = first;
        //遍历
        while(second!= null && second.next != null){
            p = p.next;
            first.next = new ListNode(p.val);
            first = first.next;
            second = second.next;
        }
        p = p.next.next;
        while(p != null){
            first.next = new ListNode(p.val);
            first = first.next;
            p = p.next;
        }
        return headNew;
    }
}

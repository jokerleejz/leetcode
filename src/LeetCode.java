public class LeetCode {
    public static void main(String[] args) {
        System.out.println("Let's leetcode");
    }

    public ListNode partition(ListNode head, int x) {
        ListNode less = new ListNode(0);
        ListNode ptr1 = less;
        ListNode greatOrEqual = new ListNode(0);
        ListNode ptr2 = greatOrEqual;
        while (head != null) {
            if (head.val < x) {
                ptr1.next = new ListNode(head.val);
                ptr1 = ptr1.next;
            } else {
                ptr2.next = new ListNode(head.val);
                ptr2 = ptr2.next;
            }
            head = head.next;
        }
        ptr1.next = greatOrEqual.next;
        return less.next;
    }
}

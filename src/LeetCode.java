import java.util.ArrayList;
import java.util.List;

public class LeetCode {
    public static void main(String[] args) {
        ListNode ln13 = new ListNode(3);
        ListNode ln12 = new ListNode(4);
        ln12.next = ln13;
        ListNode ln11 = new ListNode(2);
        ln11.next = ln12;

        ListNode ln23 = new ListNode(4);
        ListNode ln22 = new ListNode(6);
        ln22.next = ln23;
        ListNode ln21 = new ListNode(5);
        ln21.next = ln22;

        addTwoNumbers(ln11, ln21);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int a = 0, b = 0;
        boolean flag1 = l1 != null, flag2 = l2 != null;
        List<ListNode> lln = new ArrayList<ListNode>();
        int val = 0;
        boolean flagadd = false;
        while(flag1 || flag2){
            if(flag1 && flag2){
                //如果均存在
                val = l1.val + l2.val + (flagadd?1:0);
                if(val >= 10){
                    val = val - 10;
                    flagadd = true;
                }
                else{
                    flagadd = false;
                }
                ListNode ln = new ListNode(val);
                lln.add(ln);
                l1 = l1.next;
                l2 = l2.next;
                flag1 = l1 != null;
                flag2 = l2 != null;
            }
            else if(flag1 && !flag2){
                val = l1.val + (flagadd?1:0);
                if(val >= 10){
                    val = val - 10;
                    flagadd = true;
                }
                else{
                    flagadd = false;
                }
                ListNode ln = new ListNode(val);
                lln.add(ln);
                l1 = l1.next;
                flag1 = l1 != null;
            }
            else if(!flag1 && flag2){
                val = l2.val + (flagadd?1:0);
                if(val >= 10){
                    val = val - 10;
                    flagadd = true;
                }
                else{
                    flagadd = false;
                }
                ListNode ln = new ListNode(val);
                lln.add(ln);
                l2 = l2.next;
                flag2 = l2 != null;
            }
        }
        if(flagadd){
            ListNode ln = new ListNode(1);
            ln.next = null;
            lln.add(ln);
        }
        //返回
        if(lln.size() == 0){
            return null;
        }
        else{
            for(int i = 0, j = lln.size(); i < j; i ++){
                ListNode ln = lln.get(i);
                if(j-i == 1){
                    ln.next = null;
                }
                else {
                    ln.next = lln.get(i + 1);
                }

            }
            return lln.get(0);
        }
    }
}

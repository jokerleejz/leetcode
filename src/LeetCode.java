import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class LeetCode {
    public static void main(String[] args) {
        String num = "10200";
        int k = 1;
        System.out.println(removeKdigits(num, k));
    }

    public static String removeKdigits(String num, int k) {
        String rt = "";
        Deque<Character> deque = new ArrayDeque<>();
        int size = num.length(), n = k;
        if(k == num.length()){
            return "0";
        }
        for(int i=0; i < size; i ++){
            //如果数比栈前一个数小则出栈上一个数，入栈当前数，k--
            Character now = num.charAt(i);
            while(k > 0 && !deque.isEmpty() && now < deque.getLast()){
                deque.removeLast();
                k --;
            }
            deque.addLast(now);
        }
        boolean flag = false;
        for(int i=0; i < num.length()-n; i ++){
            if(!flag){
                flag = !deque.getFirst().equals('0');
            }
            rt += flag?deque.getFirst():"";
            deque.removeFirst();
        }
        return rt.length()>0?rt:"0";
    }
}

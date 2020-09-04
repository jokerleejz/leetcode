import java.util.*;

public class LeetCode {
    public static void main(String[] args) {
        String s = "bbbbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        Set<Character> set = new HashSet<Character>();
        int k = 0;
        for(int i = 0, j = s.length(); i < j; i ++){
            int max = 0;
            if(i > 0){
                set.remove(s.charAt(i-1));
            }
            while(k<j) {
                if(k < i){
                    k = i;
                }
                if(set.contains(s.charAt(k))){
                    break;
                }
                else{
                    set.add(s.charAt(k));
                    k ++;
                }
            }
            max = k-i;
            if(maxLength < max){
                maxLength = max;
            }
        }
        return maxLength;
    }

}

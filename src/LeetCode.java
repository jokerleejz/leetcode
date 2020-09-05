import java.util.ArrayList;
import java.util.List;

public class LeetCode {
    public static void main(String[] args) {
        String s = "LEETCODEISHIRING";
        int numRows = 4;
        System.out.println(convert(s, numRows));
    }

    public static String convert(String s, int numRows) {
        String rt = "";
        List<List<String>> list = new ArrayList<>();
        //初始化
        for(int i=0; i<numRows; i++){
            list.add(new ArrayList<>());
        }
        //flag控制k上下顺序，true向下，false向上
        boolean flag = true;
        int k = 0, max = numRows-1;
        for(int i=0, length=s.length(); i<length; i ++){
            String c = String.valueOf(s.charAt(i));
            list.get(k).add(c);
            if(k < max && flag){
                k ++;
                if(k == max){
                    flag = false;
                }
            }
            else if(k > 0 && !flag){
                k --;
                if(k == 0){
                    flag = true;
                }
            }
        }
        for(int i=0; i<numRows; i++){
            if(list.get(i)!=null){
                List<String> child = list.get(i);
                rt += String.join("", child);
            }
        }
        return rt;
    }
}

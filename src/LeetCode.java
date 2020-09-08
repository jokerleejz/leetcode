import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode {
    public static void main(String[] args) {
        System.out.println("Let's leetcode");
    }

    public List<String> letterCombinations(String digits) {
        List<String> rt = new ArrayList<>();
        Map<Character, List<String>> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        map.put('2', list);
        list = new ArrayList<>();
        list.add("d");
        list.add("e");
        list.add("f");
        map.put('3', list);
        list = new ArrayList<>();
        list.add("g");
        list.add("h");
        list.add("i");
        map.put('4', list);
        list = new ArrayList<>();
        list.add("j");
        list.add("k");
        list.add("l");
        map.put('5', list);
        list = new ArrayList<>();
        list.add("m");
        list.add("n");
        list.add("o");
        map.put('6', list);
        list = new ArrayList<>();
        list.add("p");
        list.add("q");
        list.add("r");
        list.add("s");
        map.put('7', list);
        list = new ArrayList<>();
        list.add("t");
        list.add("u");
        list.add("v");
        map.put('8', list);
        list = new ArrayList<>();
        list.add("w");
        list.add("x");
        list.add("y");
        list.add("z");
        map.put('9', list);

        for(int i=0, j=digits.length(); i<j; i ++) {
            char c = digits.charAt(i);
            List<String> mList = map.get(c);
            if(i == 0) {
                for(int k = 0; k < mList.size(); k ++) {
                    rt.add(mList.get(k));
                }
            }
            else {
                List<String> kelong = new ArrayList<>(rt);
                rt.clear();
                for(int m = 0; m < kelong.size(); m ++) {
                    for(int n = 0; n < mList.size(); n ++) {
                        rt.add(kelong.get(m) + mList.get(n));
                    }
                }
            }
        }
        return rt;
    }
}

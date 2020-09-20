import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode {
    static Map<Character, Integer> map = new HashMap<>(){
        {
            put('a', 2);put('b', 3);put('c', 5);put('d', 7);
            put('e', 11);put('f', 13);put('g', 17);put('h', 19);
            put('i', 23);put('j', 29);put('k', 31);put('l', 37);
            put('m', 41);put('n', 43);put('o', 47);put('p', 53);
            put('q', 59);put('r', 61);put('s', 67);put('t', 71);
            put('u', 73);put('v', 79);put('w', 83);put('x', 89);
            put('y', 97);put('z', 101);
        }
    };

    public static void main(String[] args) {
        String[] strs = new String[]{"hhhhu","tttti","tttit","hhhuh","hhuhh","tittt"};
        System.out.println(groupAnagrams(strs));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> rt = new ArrayList<>();
        Map<Double, List<String>> target = new HashMap<>();
        for(int i = 0; i < strs.length; i ++){
            String now = strs[i];
            double sum = 1;
            for(int j = 0; j < now.length(); j ++){
                sum *= map.get(now.charAt(j));
            }
            if(target.containsKey(sum)){
                target.get(sum).add(now);
            }
            else {
                //如果没有相同的则新开一个list
                List<String> list = new ArrayList<>();
                list.add(now);
                target.put(sum, list);
            }
        }
        for(List<String> l: target.values()){
            rt.add(l);
        }
        return rt;
    }
}

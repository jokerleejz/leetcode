import java.util.HashMap;
import java.util.Map;

public class LeetCode {
    static Map<Integer, Double> map = new HashMap<Integer, Double>();

    public static void main(String[] args) {
        double x = 2.10000;
        int n = 3;
        System.out.println(myPow(x, n));
    }

    public static double myPow(double x, int n) {
        boolean flag = (n>=0);
        n = Math.abs(n);
        if(n == 0) {
            return 1;
        }
        if(Math.abs(x) == 1) {
            if(n % 2 == 0) {
                return 1;
            }
            else {
                return x;
            }
        }
        map.put(1, x);
        double pow = dfs(x, n);
        if(!flag) {
            pow = 1/pow;
        }
        return pow;
    }

    /**
     * 递归向下调用
     * @param pow
     * @param n
     */
    private static double dfs(double x, int n) {
        if(map.containsKey(n)) {
            return map.get(n);
        }
        else {
            if(n % 2 == 0) {
                int a = n/2;
                int b = n/2;
                map.put(n, dfs(x, a)*dfs(x, b));
            }
            else {
                int a = n/2;
                int b = n/2 +1;
                map.put(n, dfs(x, a)*dfs(x, b));
            }
            return map.get(n);
        }
    }
}

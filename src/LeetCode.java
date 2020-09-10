import java.util.ArrayList;
import java.util.List;

public class LeetCode {
    private static List<String> ans = new ArrayList<>();;

    public static void main(String[] args) {
        int n = 3;
        generateParenthesis(n);
        System.out.println("Let's leetcode");
    }

    public static List<String> generateParenthesis(int n) {
        backtrack(0, 0, n, "");
        return ans;
    }

    public static void backtrack(int left, int right, int n, String path) {
        // 肯定不合法，提前结束
        if (left > n || left < right) {
            return;
        }
        // 到达结束条件
        if (left + right == 2 * n) {
            ans.add(path);
            return;
        }
        // 选择
        backtrack(left + 1, right, n, path + '(');
        backtrack(left, right + 1, n, path + ')');
    }
}

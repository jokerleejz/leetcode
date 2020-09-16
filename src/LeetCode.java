import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode {
    private static List<List<Integer>> res;
    static int curSum;

    public static void main(String[] args) {
        int[] candidates = new int[]{2,5,2,1,2};
        int target = 5;
        combinationSum2(candidates, target);
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        curSum = 0;
        Arrays.sort(candidates);
        dfs(0, candidates, target, new ArrayList<Integer>());
        return res;
    }

    private static boolean dfs(int start, int[] candidates, int target, List<Integer> list) {
        if (target == curSum) {
            res.add(new ArrayList<>(list));
            return true;
        } else if (curSum > target) {
            return false;
        }
        for (int i = start; i < candidates.length; i++) {
            list.add(candidates[i]);
            curSum += candidates[i];
            if (!dfs(i + 1, candidates, target, list)) {
                curSum -= list.get(list.size() - 1);
                list.remove(list.size() - 1);
                break;
            }
            while (i + 1 < candidates.length && candidates[i + 1] == candidates[i]) {
                i++;
            }
            curSum -= list.get(list.size() - 1);
            list.remove(list.size() - 1);
        }
        return true;
    }
}

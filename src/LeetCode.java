import java.util.*;

public class LeetCode {
    static Deque<Integer> path = new ArrayDeque<>();
    static boolean[] used = null;

    public static void main(String[] args) {
        int[] nums = new int[] {3,3,0,3};
        permuteUnique(nums);
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> rt = new ArrayList<List<Integer>>();
        used = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(nums, rt);
        return rt;
    }

    private static void dfs(int[] nums, List<List<Integer>> rt) {
        if(path.size() == nums.length) {
            rt.add(new ArrayList<>(path));
            return;
        }
        for(int j = 0; j < nums.length; j ++) {
            if(used[j]) {
                continue;
            }
            if(j>0 && nums[j]==nums[j-1] && !used[j-1]) {
                continue;
            }
            path.addLast(nums[j]);
            used[j] = true;
            System.out.println("before:"+path);
            dfs(nums, rt);
            path.removeLast();
            used[j] = false;
            System.out.println("after:"+path);
        }
    }
}
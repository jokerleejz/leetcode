import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LeetCode {
    static Deque<Integer> path = new ArrayDeque<>();

    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3};
        permute(nums);
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> rt = new ArrayList<List<Integer>>();
        dfs(nums, rt);
        return rt;
    }

    private static void dfs(int[] nums, List<List<Integer>> rt) {
        if(path.size() == nums.length) {
            rt.add(new ArrayList<>(path));
            return;
        }
        for(int j = 0; j < nums.length; j ++) {
            if(path.contains(nums[j])) {
                continue;
            }
            path.addLast(nums[j]);
            //System.out.println("before:"+path);
            dfs(nums, rt);
            path.removeLast();
            //System.out.println("after:"+path);
        }
    }
}

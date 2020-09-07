import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, -2, -1};
        threeSum(nums);
        //System.out.println("Let's leetcode");
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        for (int i = 0; i < n; ++i) {
            //去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            //双指针的右指针
            int k = n - 1;
            //双指针的左指针
            for (int j = i + 1; j < n; ++j) {
                //去重
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                while (j < k && nums[j] + nums[k] + nums[i] > 0) {
                    --k;
                }
                if (j == k) {
                    break;
                }
                if (nums[j] + nums[k] + nums[i] == 0) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, -1, 0, -2, 2};
        int target = 0;
        fourSum(nums, target);
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();
        int length = nums.length;
        int sum = 0;
        for (int first = 0; first < length - 2; first++) {
            //去重
            if(first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            for(int second = first + 1; second < length - 2; second++) {
                //去重
                if(second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                //双指针
                int third = second + 1,forth = nums.length - 1;
                while (third < forth) {
                    sum = nums[first] + nums[second] + nums[third] + nums[forth];
                    if(target < sum) {
                        //大了，右指针左移
                        while (third < forth && nums[forth] == nums[--forth]);
                    } else if(target > sum) {
                        //小了，左指针右移
                        while (third < forth && nums[third] == nums[++third]);
                    } else {
                        lists.add(new ArrayList<>(Arrays.asList(nums[first],nums[second],nums[third],nums[forth])));
                        //得到答案后找到下一个不一样的元素
                        while (third < forth && nums[third] == nums[++third]);
                        while(third < forth && nums[forth] == nums[--forth]);
                    }
                }
            }
        }
        return lists;
    }
}

import java.util.Arrays;

public class LeetCode {
    public static void main(String[] args) {
        System.out.println("Let's leetcode");
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int length = nums.length;
        int rt = 100000;
        for(int first = 0; first < length; first ++) {
            int third = length - 1;
            for(int second = first + 1; second < length; second ++) {
                while(second < third) {
                    int sum = nums[first] + nums[second] + nums[third];
                    if(sum == target) {
                        rt = sum;
                    }
                    else if(Math.abs(sum-target) < Math.abs(rt-target)) {
                        rt = sum;
                    }
                    if(sum > target) {
                        third --;
                    }
                    else {
                        second ++;
                    }
                }
            }
        }
        return rt;
    }
}

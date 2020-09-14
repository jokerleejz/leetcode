public class LeetCode {
    public static void main(String[] args) {
        System.out.println("Let's leetcode");
    }

    public int[] searchRange(int[] nums, int target) {
        int[] rt = new int[] {-1, -1};
        if(nums.length == 0) {
            return rt;
        }
        int first = firstPos(nums, target);
        if(first == -1) {
            return rt;
        }
        int last = lastPos(nums, target);
        rt[0] = first;
        rt[1] = last;
        return rt;
    }

    private int lastPos(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while(left <= right) {
            int mid = (left+right)/2;
            if(nums[mid] == target) {
                left = mid+1;
            }
            else {
                if(nums[mid] < target) {
                    left = mid+1;
                }
                else {
                    right = mid-1;
                }
            }
        }
        if(nums[right] == target) {
            return right;
        }
        else {
            return -1;
        }
    }

    private int firstPos(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while(left <= right) {
            int mid = (left+right)/2;
            if(nums[mid] == target) {
                right = mid-1;
            }
            else {
                if(nums[mid] < target) {
                    left = mid+1;
                }
                else {
                    right = mid-1;
                }
            }
        }
        if((left!=nums.length) && (nums[left] == target)) {
            return left;
        }
        else {
            return -1;
        }
    }
}
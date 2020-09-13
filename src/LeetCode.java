public class LeetCode {
    public static void main(String[] args) {
        int[] nums = new int[]{4,5,6,7,0,1,2};
        int target = 3;
        System.out.println(search(nums, target));
    }

    public static int search(int[] nums, int target) {
        int index = 0;
        //因为要求使用logn的时间复杂度，所以考虑使用二分查找
        int left = 0, right = nums.length - 1;
        if(target == nums[left]){
            return left;
        }
        if(target == nums[right]){
            return right;
        }
        while(left <= right){
            int mid = (left+right)/2;
            System.out.println("left:"+left+",nums[left]:"+nums[left]+",right:"+right+",nums[right]:"+nums[right]+",mid:"+mid+",nums[mid]:"+nums[mid]);
            if(target == nums[mid]){
                index = mid;
                return index;
            }
            if(nums[mid] >= nums[0]){
                if(nums[0]<=target && target<nums[mid]){
                    right = mid-1;
                }
                else{
                    left = mid+1;
                }
            }
            else{
                if(nums[mid]<target && target<=nums[nums.length-1]){
                    left = mid+1;
                }
                else{
                    right = mid-1;
                }
            }
        }
        if(left >= right){
            index = -1;
        }
        return index;
    }
}

public class LeetCode {
    public static void main(String[] args) {
        int[] list = new int[] {3,2,1,0};
        System.out.println(canJump(list));
    }

    public static boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0) {
            return false;
        }
        int len = nums.length;
        if(nums.length == 1) {
            return true;
        }
        int farest = 0;
        for (int i = 0; i < len; i++)
        {
            if (i > farest) {
                return false;
            }
            farest = Math.max(farest, i + nums[i]);
        }
        return true;
    }
}

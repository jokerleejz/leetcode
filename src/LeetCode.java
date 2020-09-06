public class LeetCode {
    public static void main(String[] args) {
        int[] list = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(list));
    }

    public static int maxArea(int[] height) {
        int max = 0;
        int length = height.length;
        //双指针
        int i = 0, j = length-1;
        while(i != j){
            int s = Math.min(height[i], height[j]) * (j-i);
            if(max < s){
                max = s;
            }
            //移动较小的数的指针
            if(height[i] <= height[j]){
                i ++;
            }
            else{
                j --;
            }
        }
        return max;
    }
}

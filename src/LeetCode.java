public class LeetCode {
    public static void main(String[] args) {
        System.out.println("Let's leetcode");
    }

    public static String multiply(String num1, String num2) {
        int len1 = num1.length(), len2 = num2.length();
        int[] result = new int[len1+len2];
        if(num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        String rt = "";
        for(int i=len1-1; i>-1; i--) {
            int n1 = Integer.parseInt(num1.charAt(i)+"");
            for(int j=len2-1; j>-1; j--) {
                int n2 = Integer.parseInt(num2.charAt(j)+"");
                int r = n1*n2;
                int offset = len1+len2-2-i-j;
                result[offset] += r%10;
                result[offset+1] += r/10;
                if(result[offset] >= 10) {
                    result[offset] -= 10;
                    result[offset+1] ++;
                }
                if(result[offset+1] >= 10) {
                    result[offset+1] -= 10;
                    result[offset+2] ++;
                }
            }
        }
        //输出
        for(int i=0; i < result.length; i++) {
            if(i==result.length-1 && result[i]==0) {
                break;
            }
            rt = result[i] + rt;
        }
        return rt;
    }
}

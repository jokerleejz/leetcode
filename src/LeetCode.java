public class LeetCode {
    public static void main(String[] args) {
        String s = "";
        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {
        int l = s.length();
        boolean[][] dp = new boolean[l][l];
        if(s.length() == 0){
            return "";
        }
        //初始化为第一个字符
        String result = s.substring(0, 1);
        for (int i = 0; i < l; i++) {
            //从i到i为回文串
            dp[i][i] = true;
        }
        for (int i = 0; i < l - 1; i++) {
            //相邻两个字符如果相等也为回文串
            dp[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
            if (dp[i][i + 1]) {
                result = s.substring(i, i + 1 + 1);
            }
        }
        for (int k = 3; k <= l; k++) {
            //慢慢扩大长度
            for (int i = 0; (i + k) <= l; i++) {
                int j = i + k - 1;
                //动态规划体现，i到j是否为回文串取决于i与j是否相等并且i+1到j-1是否回文
                dp[i][j] = dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
                if (dp[i][j] && (j - i + 1) > result.length()) {
                    result = s.substring(i, j + 1);
                }
            }
        }
        return result;
    }
}

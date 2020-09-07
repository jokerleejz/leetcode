public class LeetCode {
    public static void main(String[] args) {
        int num = 1994;
        System.out.println(intToRoman(num));
    }

    public static String intToRoman(int num) {
        String rt = "";
        String[] roman = new String[]{"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        int[] ints = new int[]{1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        int result = 0, ex = 0;
        for(int i = ints.length; i > 0; i --){
            if(num >= ints[i-1]){
                result = num / ints[i-1];
                ex = num - result * ints[i-1];
                for(int j = 0; j < result; j ++){
                    rt += roman[i-1];
                }
                num = ex;
            }
        }
        return rt;
    }
}

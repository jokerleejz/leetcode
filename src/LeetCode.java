public class LeetCode {
    public static void main(String[] args) {
        int dividend = -2147483648;
        int divisor = -1;
        System.out.println(divide(dividend, divisor));
    }

    public static int divide(int dividend, int divisor) {
        int i = 0;
        boolean iszheng = (dividend>0) == (divisor>0);
        if(divisor == 1){
            return dividend;
        }
        if(divisor == -1){
            if(dividend > Integer.MIN_VALUE) {
                return -dividend;
            }
            else{
                return Integer.MAX_VALUE;
            }
        }
        //转为负数输出
        dividend = -Math.abs(dividend);
        divisor  = -Math.abs(divisor);
        if(dividend > divisor){
            return 0;
        }
        else{
            //递归
            int rt = div(dividend, divisor);
            return iszheng? rt: -rt;
        }
    }

    private static int div(int dividend, int divisor) {
        if(dividend > divisor){
            return 0;
        }
        int count = 1;
        int i = divisor;
        while((i+i>=dividend) && (i+i<0)){
            i += i;
            count += count;
        }
        //System.out.println(dividend+","+i+","+divisor+","+count);
        return count+div(dividend-i, divisor);
    }
}

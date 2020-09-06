public class LeetCode {
    public static void main(String[] args) {
        String s = " ";
        System.out.println(myAtoi(s));
    }

    public static int myAtoi(String str) {
        int rt = 0;
        //先处理开头的空格
        while(0<str.length() && str.charAt(0)==' '){
            if(str.length() >= 1) {
                str = str.substring(1);
            }
        }
        int length = str.length();
        if(str.length() == 0){
            return 0;
        }
        if(str.charAt(0) == '+' || str.charAt(0) == '-'){
            //如果开头是正负号
            int i = 1;
            boolean flag;
            if(str.charAt(0) == '+'){
                flag = true;
            }
            else{
                flag = false;
            }
            while(i < length && str.charAt(i) >= '0' && str.charAt(i) <= '9'){
                i ++;
            }
            String s = str.substring(0, i);
            if(i == 1){
                rt = 0;
            }
            else {
                try{
                    rt = Integer.parseInt(s);
                }catch (Exception e){
                    if(flag){
                        rt = 2147483647;
                    }
                    else{
                        rt = -2147483648;
                    }
                }
            }
        }
        else if(str.charAt(0) >= '0' && str.charAt(0) <= '9'){
            //如果开头是数字
            int i = 1;
            while(i < length && str.charAt(i) >= '0' && str.charAt(i) <= '9'){
                i ++;
            }
            String s = str.substring(0, i);
            try{
                rt = Integer.parseInt(s);
            }catch (Exception e){
                rt = 2147483647;
            }
        }
        else{
            return 0;
        }
        return rt;
    }
}

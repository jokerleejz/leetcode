public class LeetCode {
    public static void main(String[] args) {
        System.out.println("Let's leetcode");
    }

    List<Integer> ans = new ArrayList<>();

    public List<Integer> grayCode(int n) {
        for(int i=0;i<(1<<n);i++){
            ans.add(i^(i>>1));
        }
        return ans;
    }
}

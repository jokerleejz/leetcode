public class LeetCode {
    public static int num = 1;

    public static void main(String[] args) {
        int n = 3;
        System.out.println(generateMatrix(n));
    }

    public static int[][] generateMatrix(int n) {
        int[][] rt = new int[n][n];
        if(n == 0) {
            return rt;
        }
        int top = 0, bottom = n-1, left = 0, right = n-1;
        while(top <= bottom && left <= right) {
            ergodic(rt, top, bottom, left, right);
            top ++; bottom --; left ++; right --;
        }
        return rt;
    }

    /**
     * @param matrix
     * @param top
     * @param bottom
     * @param left
     * @param right
     */
    private static void ergodic(int[][] matrix, int top, int bottom, int left, int right) {
        for(int i = left; i <= right; i ++) {
            matrix[top][i] = num++;
        }
        for(int i = top+1; i <= bottom; i ++) {
            matrix[i][right] = num++;
        }
        if(left<right && top<bottom) {
            for(int i = right-1; i > left; i --) {
                matrix[bottom][i] = num++;
            }
            for(int i = bottom; i > top; i --) {
                matrix[i][left] = num++;
            }
        }
    }
}

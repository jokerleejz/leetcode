import java.util.ArrayList;
import java.util.List;

public class LeetCode {

    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };
        System.out.println(spiralOrder(matrix));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> rt = new ArrayList<Integer>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return rt;
        }
        int height = matrix.length;
        int width = matrix[0].length;
        //初始化四个点
        int top = 0, bottom = height-1, left = 0, right = width-1;
        while(top<=bottom && left<=right) {
            //遍历输出
            ergodic(matrix, top, bottom, left, right, rt);
            top ++;
            bottom --;
            left ++;
            right --;
        }
        return rt;
    }

    /**
     * @param matrix
     * @param top
     * @param bottom
     * @param left
     * @param right
     * @param rt
     */
    private static void ergodic(int[][] matrix, int top, int bottom, int left, int right, List<Integer> rt) {
        for(int i = left; i <= right; i ++) {
            rt.add(matrix[top][i]);
        }
        for(int i = top+1; i <= bottom; i ++) {
            rt.add(matrix[i][right]);
        }
        if(left<right && top<bottom) {
            for(int i = right-1; i > left; i --) {
                rt.add(matrix[bottom][i]);
            }
            for(int i = bottom; i > top; i --) {
                rt.add(matrix[i][left]);
            }
        }
    }
}

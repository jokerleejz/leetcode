public class LeetCode {
    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1,3,1},
                {1,5,1},
                {4,2,1}
        };
        System.out.println(minPathSum(grid));
    }

    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] rt = new int[m][n];
        rt[0][0] = grid[0][0];
        for(int i = 1; i < n; i ++){
            rt[0][i] = rt[0][i-1] + grid[0][i];
        }
        for(int i = 1; i < m; i ++){
            rt[i][0] = rt[i-1][0] + grid[i][0];
        }
        for(int i = 1; i < m; i ++) {
            for(int j = 1; j < n; j ++) {
                rt[i][j] = Math.min(rt[i-1][j], rt[i][j-1]) + grid[i][j];
            }
        }
        return rt[m-1][n-1];
    }
}

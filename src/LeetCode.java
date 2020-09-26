public class LeetCode {
    public static void main(String[] args) {
        int m = 7, n = 3;
        System.out.println(uniquePaths(m, n));
    }

    public static int uniquePaths(int m, int n) {
        int[][] matrix = new int[n][m];
        for(int i = 0; i < m; i ++) {
            matrix[0][i] = 1;
        }
        for(int i = 0; i < n; i ++) {
            matrix[i][0] = 1;
        }
        for(int i = 1; i < n; i ++) {
            for(int j = 1; j < m; j ++) {
                matrix[i][j] = matrix[i-1][j] + matrix[i][j-1];
            }
        }
        return matrix[n-1][m-1];
    }
}

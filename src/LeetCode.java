public class LeetCode {
    public static void main(String[] args) {
        int[][] obstacleGrid = new int[][]{
                {0}
        };
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid[0].length;
        int n = obstacleGrid.length;
        if(m == 1 && n == 1){
            return 1-obstacleGrid[n-1][m-1];
        }
        boolean flag = obstacleGrid[0][0]==1;
        for(int i = 1; i < m; i ++) {
            if(obstacleGrid[0][i] == 1){
                flag = true;
            }
            obstacleGrid[0][i] = flag? 0: 1;
        }
        flag = obstacleGrid[0][0]==1;
        for(int i = 1; i < n; i ++) {
            if(obstacleGrid[i][0] == 1){
                flag = true;
            }
            obstacleGrid[i][0] = flag? 0: 1;
        }
        for(int i = 1; i < n; i ++) {
            for(int j = 1; j < m; j ++) {
                if(obstacleGrid[i][j] == 1){
                    obstacleGrid[i][j] = 0;
                }
                else {
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                }
            }
        }
        return obstacleGrid[n-1][m-1];
    }
}

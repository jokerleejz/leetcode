public class LeetCode {
    public static void main(String[] args) {
        System.out.println("Let's leetcode");
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if(m == 0) {
            return false;
        }
        int n = matrix[0].length;
        //超出范围的直接false
        if(target<matrix[0][0] || target>matrix[m-1][n-1]) {
            return false;
        }

        int row = -1;
        if(m > 1) {
            int left = 0;
            int right = m-1;
            while(left < right) {
                System.out.println("top:" + left + ", bottom:" + right);
                if(matrix[left][0] == target) {
                    row = left;
                    break;
                }
                if(matrix[right][0] == target) {
                    row = right;
                    break;
                }
                int mid = (left+right)/2;
                if(matrix[mid][0] <= target) {
                    if(matrix[mid+1][0] > target) {
                        row = mid;
                        break;
                    }
                    else {
                        left = mid+1;
                    }
                }
                else if(matrix[mid][0] > target) {
                    if(matrix[mid-1][0] <= target) {
                        row = mid-1;
                        break;
                    }
                    else {
                        right = mid-1;
                    }
                }
                else if(matrix[mid][0] == target) {
                    return true;
                }
            }
            if(left == right) {
                row = left;
            }
        }
        else {
            row = 0;
        }
        //System.out.println("row:" + row);
        int left = 0;
        int right = n-1;
        while(left < right) {
            //System.out.println("top:" + left + ", bottom:" + right);
            int mid = (left+right)/2;
            if(matrix[row][mid] < target) {
                left = mid + 1;
            }
            else if (matrix[row][mid] > target) {
                right = mid -1;
            }
            else {
                return true;
            }
        }
        if(matrix[row][left] == target) {
            return true;
        }
        return false;
    }
}

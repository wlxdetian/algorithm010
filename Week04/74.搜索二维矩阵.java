/*
 * @lc app=leetcode.cn id=74 lang=java
 *
 * [74] 搜索二维矩阵
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null  || matrix.length == 0 ){
            return false;
        }
        int left = 0;
        int columLen = matrix[0].length;
        int right = matrix.length * columLen-1;
        
        while (left <= right){
             int mid = (left + right) /2;
            // System.out.println(mid);
             int rows = mid / columLen;
             int colums = mid % columLen;
             if ( matrix[rows][colums] == target ){
                    return true;
             }else if(matrix[rows][colums] < target){
                  left = mid+1;
             }else {
                 right = mid -1;
             }
        }

        return false;
    }
}
// @lc code=end


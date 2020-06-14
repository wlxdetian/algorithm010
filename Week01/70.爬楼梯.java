/*
 * @lc app=leetcode.cn id=70 lang=java
 *
 * [70] 爬楼梯
 */

// @lc code=start
class Solution {
    public int climbStairs(int n) {
        int arrs[] = new int[n+1];
        arrs[0] = 1;
        arrs[1] = 2;
         for ( int i = 2;i <arrs.length;i++ ){
             arrs[i] = arrs[i-1] + arrs[i-2];
         }
         return arrs[n-1];
    }
}
// @lc code=end


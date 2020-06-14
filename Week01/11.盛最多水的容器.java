/*
 * @lc app=leetcode.cn id=11 lang=java
 *
 * [11] 盛最多水的容器
 */

// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        int area = 0;
        int len = height.length;
        for (int i = 0 ;i< len-1 ;i++){
            int h1 = height[i];
                for (int j = i+1 ; j < len ;j++){
                        int x = j-i;
                        int h2 = height[j];
                        int y = h1 >h2 ? h2 : h1;
                        int localArea = x * y;
                        if (area < localArea){
                            area = localArea;
                        }
                }
        }
        return area;
    }
}

// @lc code=end


/*
 * @lc app=leetcode.cn id=55 lang=java
 *
 * [55] 跳跃游戏
 */

// @lc code=start
class Solution {
    public boolean canJump(int[] nums) {
        int endIndex = nums.length -1;
        for(int i = nums.length-1 ; i > 0; i--){

            if(nums[i-1] == 0){
                continue;
            }

            if(nums[i-1]+i-1 >= endIndex){
              //  System.out.println(endIndex+":"+(i-1));
                endIndex = i-1;
            }
            //System.out.println(endIndex+":");
        }
 
        if(endIndex == 0){
            return true;
        }else {
            return false;
        }
    }
}
// @lc code=end


/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        //暴力解法 两个遍历
        int len = nums.length;
        for (int i = 0 ;i <len -1;i++){
            for (int j = i +1 ; j<len ;j++){
                int sum = nums[i]+ nums[j];
                if(sum == target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{};
        
    }
}
// @lc code=end


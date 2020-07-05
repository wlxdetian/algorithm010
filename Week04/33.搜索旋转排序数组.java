/*
 * @lc app=leetcode.cn id=33 lang=java
 *
 * [33] 搜索旋转排序数组
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return -1;
        }

        int left = 0 ;
        int right = nums.length -1;

        while (left <= right){
             int mid =  (left + right ) / 2;
            // System.out.println(mid);
             if(target == nums[mid]){
                 return mid;
             }
             
             if(nums[mid] >= nums[left]){
                if(target >= nums[left] && target <= nums[mid]){
                        right = mid -1;//left --- mid之间
                }else{
                        left = mid +1; //mid --- right之间 
                }
             }else{
                 if (target > nums[mid] && target <= nums[right] ){//left和mid之间
                     left = mid +1;  //mid --- right之间;
                 }else {
                     right = mid -1; //left -- mid之间
                 }
             }
        }

        return -1;

    }
}
// @lc code=end


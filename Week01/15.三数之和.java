import java.util.ArrayList;
import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 */

// @lc code=start
class Solution {

    //暴力破解法,虽然增加了排序和通过set拍重复,依然超过了设定时间O(n^3)
   /**  public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        Set<List<Integer>> list = new HashSet<List<Integer>>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        list.add(Arrays.asList(nums[i], nums[j], nums[k]));//这里隐含了一次循环
                    }
                }
            }
        }
        return new ArrayList<>(list);
    }**/

  /**  public  List<List<Integer>> threeSum(int[] nums){
   List<List<Integer>>  list = new ArrayList<List<Integer>>();
        if (nums == null || nums.length <3){
           return list;
        }
        Arrays.sort(nums);//排序
        int len = nums.length;
        for ( int i = 0; i < nums.length; i++){
          if (nums[i]>0) break;//因为已经进行了排序,所以nums[i]作为最小的数字必须小于等于0,否则另外两个较大的数字之和用于不会是负数,三数之和也永远不可能==0
          //排除重复的元素
          if (i >0 && nums[i] == nums[i+1]){
              continue;
          }

          int L = i+1; //初始化时L 为numbs[i]左边第一个,
          int R = nums.length-1;//初始化时,R为最后一个元素

          while (L < R){
              int sum = nums[i] + nums[L] + nums[R];

              if(sum == 0){
                 list.add(Arrays.asList(nums[i],nums[L],nums[R]));
                 while(L < R && nums[L] == nums[L + 1]) L++;//跳过重复的值
                 while(L < R && nums[R] == nums[R - 1]) R--;//跳过重复的值
                 L++;
                 R--;
              }else if(sum < 0 ){
                  L++;
              }else if(sum >0){
                  R--;
              }
          }

        }
         return list;
    } */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        int len = nums.length;
        if(nums == null || len < 3) return ans;
        Arrays.sort(nums); // 排序
        for (int i = 0; i < len ; i++) {
            if(nums[i] > 0) break; // 如果当前数字大于0，则三数之和一定大于0，所以结束循环
            if(i > 0 && nums[i] == nums[i-1]) continue; // 去重
            int L = i+1;
            int R = len-1;
            while(L < R){
                int sum = nums[i] + nums[L] + nums[R];
                if(sum == 0){
                    ans.add(Arrays.asList(nums[i],nums[L],nums[R]));
                    while (L<R && nums[L] == nums[L+1]) L++; // 去重
                    while (L<R && nums[R] == nums[R-1]) R--; // 去重
                    L++;
                    R--;
                }
                else if (sum < 0) L++;
                else if (sum > 0) R--;
            }
        }        
        return ans;
    }


}
// @lc code=end

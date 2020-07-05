/*
 * @lc app=leetcode.cn id=45 lang=java
 *
 * [45] 跳跃游戏 II
 */

// @lc code=start
class Solution {
    public int jump(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int currentMaxPos = 0;// 当前位置跳跃范围内,最原跳跃坐标
        int currentEndIndex = 0;// 当前位置最大跳跃终点坐标
        int len = nums.length - 1;
        int count = 0;

        /**
         * 1.遍历位置 2.从第一个位置开始记录跳跃步数, 并将最大跳跃步数范围类的步数和位置比较计算出最大的跳跃步骤,并进行标记.
         * 3.每当到达标记的位置,则记录一次跳跃次数.
         */
        for (int i = 0; i < len; i++) {
            // 上一个元素取得的最大补偿和当前元素能跳跃的最大步长去较大的一个
            currentMaxPos = (currentMaxPos > (i + nums[i])) ? currentMaxPos : (nums[i] + i);
            // 当前上一个步长能到达的最大范围
            if (currentEndIndex == i) {
                currentEndIndex = currentMaxPos;// 将当前位置能跳跃到的最远的下一个位置作为结束位置记录下来
                count++;// 记录步数
            }
        }
        return count;
    }
}
// @lc code=end

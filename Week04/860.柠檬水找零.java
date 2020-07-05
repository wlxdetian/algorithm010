/*
 * @lc app=leetcode.cn id=860 lang=java
 *
 * [860] 柠檬水找零
 */

// @lc code=start
class Solution {
    public boolean lemonadeChange(int[] bills) {

        int five = 0;
        int ten = 0;

        for (int bill : bills) {
            switch (bill) {
                case 5:
                    five++;
                    break;
                case 10:
                    five--;
                    ten++;
                    break;
                case 20: {
                    if (ten > 0) {
                        ten--;
                        five--;
                    } else {
                        five -= 3;
                    }
                    break;
                }
                default:
                    break;
            }
            if (five < 0) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

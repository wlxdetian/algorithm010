//给定一个整数，编写一个函数来判断它是否是 2 的幂次方。 
//
// 示例 1: 
//
// 输入: 1
//输出: true
//解释: 20 = 1 
//
// 示例 2: 
//
// 输入: 16
//输出: true
//解释: 24 = 16 
//
// 示例 3: 
//
// 输入: 218
//输出: false 
// Related Topics 位运算 数学 
// 👍 225 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPowerOfTwo(int n) {
/**
 * 若 n = 2^xn=2
 * x
 *   且 xx 为自然数（即 nn 为 22 的幂），则一定满足以下条件：
 * 恒有 n & (n - 1) == 0，这是因为：
 * nn 二进制最高位为 11，其余所有位为 00；
 * n - 1n−1 二进制最高位为 00，其余所有位为 11；
 * 一定满足 n > 0。
 * 因此，通过 n > 0 且 n & (n - 1) == 0 即可判定是否满足 n = 2^xn=2
 */
       return  n > 0 && (n & (n - 1)) == 0;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=455 lang=java
 *
 * [455] 分发饼干
 */

// @lc code=start
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int count = 0;
        Set<Integer> visited = new HashSet<Integer>();
        Arrays.sort(g);
        Arrays.sort(s);
        for(int i = 0 ;i<s.length;i++){
            for(int j = 0;j <g.length;j++){
                if(s[i] >= g[j] && !visited.contains(j)){
                    visited.add(j);
                    count++;
                    break;
                }
            }
        }
       return count;
    }
}
// @lc code=end


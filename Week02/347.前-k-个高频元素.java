import java.util.Map;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=347 lang=java
 *
 * [347] 前 K 个高频元素
 */

// @lc code=start
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
         //1.遍历数字.记录每个数字出现的次数
         Map<Integer,Integer>  mark = new HashMap<Integer,Integer>();

         int ret[] = new int[k]; 
         for(int num : nums){
                 mark.put(num, mark.getOrDefault(num, 0)+1);
         }
         PriorityQueue<Integer> heap =
         new PriorityQueue<Integer>((n1, n2) -> mark.get(n1) - mark.get(n2));

         for(int num : mark.keySet()){
             heap.add(num);
             if(heap.size() > k){
                 heap.poll();
             }
         }

         int i = 0;
         while( !heap.isEmpty()){
              ret[i++]  = heap.poll();
         }
        return ret;
    }
}
// @lc code=end


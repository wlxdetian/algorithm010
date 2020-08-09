//给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。 
//
// 
//
// 示例： 
//
// s = "leetcode"
//返回 0
//
//s = "loveleetcode"
//返回 2
// 
//
// 
//
// 提示：你可以假定该字符串只包含小写字母。 
// Related Topics 哈希表 字符串 
// 👍 246 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int firstUniqChar(String s) {
        if (s == null || "".equals(s.trim())){
            return -1;
        }
        if(s.length() == 1){
            return 0;
        }


     /*   //暴力破解
        for (int i = 0 ;i < s.length() ; i++){
            char ch = s.charAt(i);
            boolean flag = false;
            for (int j = 0; j < s.length() ; j++){
                char postCh = s.charAt(j);
                if ( ch == postCh && j != i){
                    flag = true;
                    break;
                }
            }

            if(!flag){
                return i;
            }

        }

        return -1;*/

        HashMap<Character, Integer> count = new HashMap<Character, Integer>();
        int n = s.length();
        // build hash map : character and how often it appears
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        // find the index
        for (int i = 0; i < n; i++) {
            if (count.get(s.charAt(i)) == 1)
                return i;
        }
        return -1;



    }
}
//leetcode submit region end(Prohibit modification and deletion)
